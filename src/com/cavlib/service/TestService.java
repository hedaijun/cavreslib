package com.cavlib.service;

import java.util.List;

import com.cavlib.beans.Post;

import junit.framework.Test;

public interface TestService {
      public List<Post> testPost();
      public void testGetPost();
      public void testUser();
      public void testComment();
      public void testImage(String image);
}
