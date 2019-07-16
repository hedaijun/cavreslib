package com.cavlib.dao;

import java.util.List;

public interface ImageMapper {
    public List<String> getImageByPostId(int post_id);
    public Boolean addImage(int post_id, String url);
}
