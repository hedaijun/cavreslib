package com.cavlib.dao;

import java.util.List;

import com.cavlib.beans.Image;

public interface ImageMapper {
    public List<String> getImageByPostId(int post_id);
    public void addImage(Image image);
    public Boolean deleteImage(int post_id);
}
