package com.cavlib.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cavlib.beans.Image;
import com.cavlib.beans.Post;
import com.cavlib.beans.User;
import com.cavlib.service.ImageService;
import com.cavlib.service.PublishService;

@Controller
public class PublishController {

	@Autowired
	private PublishService publishService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/publishPage")
	public String getPublishPage() {
		return "publish";
	}
	
	@RequestMapping("/publish")
	public String publishPost(HttpServletRequest request,HttpServletResponse reponse,HttpSession session,
			@RequestParam(value="file",required=false) MultipartFile[] file) throws IllegalStateException, IOException, ServletException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String link = request.getParameter("link");
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_id = user.getUserId();
		String type = request.getParameter("type");
		Post post = new Post(title, link, content, type, user_id);		
		publishService.publishPost(post);	
		
		
		Image img = new Image();
		img.setPostId(post.getPostId());
	    for (MultipartFile mf : file) {
		if(!mf.isEmpty()){
			// 使用UUID给图片重命名，并去掉四个“-”
//			String name = UUID.randomUUID().toString().replaceAll("-", "");
			String name = mf.getOriginalFilename();
			img.setUrl(name);	
			// 获取文件的扩展名
//			String ext = FilenameUtils.getExtension(mf.getOriginalFilename());  
			//获取后缀名
//            String ext =mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf(".") + 1);
			// 设置图片上传路径
			String path = request.getSession().getServletContext().getRealPath("static/resources");
			
			// 以绝对路径保存重名命后的图片
//			mf.transferTo(new File(path + "/" + name + "." + ext));		
			mf.transferTo(new File(path + "/" + name));	
			
			
			// 把图片信息保存到数据库
			imageService.addImage(img);
		}  
	}  

		return "forward:/getPosts";
	}
}
