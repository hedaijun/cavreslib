package com.cavlib.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable{
	private static final long serialVersionUID = 8363556599610850348L;
	
	private Integer post_id;
	private String title;
	private String link;
	private Timestamp time;
	private String content;
	private int user_id;
	public Integer getId() {
		return post_id;
	}
	public void setId(Integer post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", title=" + title + ", time=" + time + ", content="  +content+", link="+link+ ", user_id="+user_id+"]";
	}
}