package com.cavlib.dao;

import java.util.List;

public interface ImageMapper {
    public List<String> getImageByPostId(int id);
    public Boolean addImage(int id, String url);
}
