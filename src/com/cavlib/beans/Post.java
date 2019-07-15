package com.cavlib.beans;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable{
	private static final long serialVersionUID = 8363556599610850348L;
	
	private Integer id;
	private String title;
	private String link;
	private Date time;
	private String content;
	private int user_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
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
		return "Post [id=" + id + ", title=" + title + ", time=" + time + ", content="  +content+", link="+link+ ", user_id="+user_id+"]";
	}
}