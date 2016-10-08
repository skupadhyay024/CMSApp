	package com.skuera.service;

import java.util.List;

import com.skuera.model.Article;
import com.skuera.model.User;

public interface SerI {
	public User isValidUser(String user,String pass);
	public int saveArticle(Article article);
	public User getUserByUserName(String uname);
	public List<Article> getAllArticle(String username);
	public Article getArticle(int articleId);
     
    /*User findById(long id);
     
    User findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);*/
     
}