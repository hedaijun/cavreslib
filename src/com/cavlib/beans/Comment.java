package com.cavlib.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable{
	private static final long serialVersionUID = 8363556599610850348L;

	private int user_id;
	private int post_id;
	private Timestamp time;
	private String content;
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	public int getPostId() {
		return post_id;
	}
	public void setPostId(int post_id) {
		this.post_id = post_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Comment [user_id=" + user_id + ", post_id=" + post_id + ", time="  +time+", content="+content+ "]";
	}
}
