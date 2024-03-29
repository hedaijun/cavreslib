package com.cavlib.handler;

import static org.hamcrest.CoreMatchers.anything;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;
import com.cavlib.beans.User;
import com.cavlib.service.CommentService;
import com.cavlib.service.PostContentService;

@Controller
public class BrowsePostController {
	@Autowired
	private PostContentService postContentService;
	@Autowired
	private CommentService commentService;
	private String postId;
	
	@RequestMapping("/post")
	public String getPost(Map<String,Object> map,HttpServletRequest request,HttpServletResponse reponse) {
		//获取PostBean,进入PostContent页面
		try {
		postId = request.getParameter("post_id");
		List<Comment> comments = commentService.getComment(postId);
		Map userNames = new HashMap();
		Post post =postContentService.getPostContent(postId);
		List<String> imgs = postContentService.getPostImg(postId);
		for(Comment comment: comments) {
			userNames.put(comment.getUserId(),commentService.getUserName(comment.getUserId()));
			//System.out.println(comment.getContent()+"::"+userNames.get(comment.getUserId()));
		}
		
		post.setContent(post.getContent().replace("\r\n", "<br>"));
		post.setContent(post.getContent().replace("\r", "<br>"));
		post.setContent(post.getContent().replace("\n", "<br>"));
		request.setAttribute("imgs", imgs);
		request.setAttribute("post", post);
		request.setAttribute("comment", comments);
		request.setAttribute("userName", userNames);
	
//		comment.get(0).setTime(new Timestamp(comment.get(0).getTime().getTime()-3600*8));
	//	System.out.println(new Timestamp(comment.get(0).getTime().getTime()-3600000*8));
		//System.out.println(post.getLink());
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return "post";
	}
	
	@RequestMapping("/post/submitComment")
	public String submit(Map<String,Object> map,HttpServletRequest request,HttpServletResponse reponse,HttpSession session) {
		//获取PostBean,进入PostContent页面
		postId = request.getParameter("post_id");
		User user =(User)session.getAttribute("user");
		String commentText =request.getParameter("commentText");
		Comment comment = new Comment();
		try {
		comment.setContent(commentText);
		comment.setPostId(Integer.valueOf(postId));
		comment.setUserId(user.getUserId());
		commentService.setComment(comment);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "forward:/post";
		}
	

}
