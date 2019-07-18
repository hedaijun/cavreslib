package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;
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
	public String getPost(Map<String,Object> map,HttpServletRequest request) {
		//获取PostBean,进入PostContent页面
		try {
		postId = request.getParameter("post_id");
		List<Comment> comment = commentService.getComment(postId);
		Post post =postContentService.getPostContent(postId);
		map.put("post", post);
		map.put("comment", comment);
		System.out.println(comment.get(0).toString());
//		Comment test = new Comment();
//		test.setPost_id(123);
//		test.setUser_id(1231);
//		test.setContent("fuck you2");
//		commentService.setComment(test);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return "post";
	}
}
