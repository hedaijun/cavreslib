package com.cavlib.beans;

import java.io.Serializable;

public class Image implements Serializable{
	private static final long serialVersionUID = 8363556599610850348L;

	private int post_id;
	private String url;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getImage_url() {
		return url;
	}
	public void setImage_url(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Picture [post_id=" + post_id + ", image_url=" + url+ "]";
	}
	
}
