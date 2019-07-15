package com.cavlib.beans;

import java.io.Serializable;

public class Picture implements Serializable{
	private static final long serialVersionUID = 8363556599610850348L;

	private int post_id;
	private String image_url;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public String toString() {
		return "Picture [post_id=" + post_id + ", image_url=" + image_url+ "]";
	}
	
}
