package com.cavlib.dao;

import java.util.List;

import com.cavlib.beans.Image;

public interface ImageMapper {
    public List<String> getImageByPostId(int post_id);
    public Boolean addImage(int post_id, String url);
    public void addImage(Image image);
}
