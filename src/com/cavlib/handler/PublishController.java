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

import org.apache.commons.io.FilenameUtils;
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
		
		int count=1;
		Image img = new Image();
		img.setPostId(post.getPostId());
	    for (MultipartFile mf : file) {
		if(!mf.isEmpty()){
			// 使用UUID给图片重命名，并去掉四个“-”
			String name = UUID.randomUUID().toString().replaceAll("-", "");
			// 获取文件的扩展名
			String ext = FilenameUtils.getExtension(mf.getOriginalFilename());  
			// 设置图片上传路径
			String url = request.getSession().getServletContext().getRealPath("/resources");
			img.setUrl(name+"."+ext);
			
			 request.setCharacterEncoding("UTF-8");
		        Part part = request.getPart("file");
		        String inputName=part.getName();
		        InputStream input=part.getInputStream();
		        //想要保存的目标文件的目录下
		        String tagDir= url;
		        //避免文件名重复使用uuid来避免,产生一个随机的uuid字符
//		        String realFileName=UUID.randomUUID().toString();
		        OutputStream output=new FileOutputStream(new File(tagDir,name));
		        int len=0;
		        byte[] buff=new byte[1024*8];
		         
		        while ((len = input.read(buff)) > -1) {
		            output.write(buff, 0, len);
		        }
		 
		        input.close();
		        output.close();
		        reponse.setCharacterEncoding("utf-8");
			
			// 以绝对路径保存重名命后的图片
			mf.transferTo(new File(url + "/" + name + "." + ext));			
			// 把图片信息保存到数据库
			imageService.addImage(img);

		}  
		count++;
	}  

		return "forward:/getPosts";
	}
}
