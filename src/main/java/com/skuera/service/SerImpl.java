package com.skuera.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skuera.dao.DaoI;
import com.skuera.model.Article;
import com.skuera.model.User;
 

 
@Service("userService")
public class SerImpl implements SerI {
	
	@Autowired
	private DaoI dao;

	
	
	
	public void setDao(DaoI dao) {
		this.dao = dao;
	}




	@Override
	public User isValidUser(String user, String pass) {
		// TODO Auto-generated method stub
		return dao.validate(user, pass);
	}




	@Override
	public int saveArticle(Article article) {
int res=0;
		try{
			System.out.println("In Dao");
		 dao.saveArticle(article);
		 res=1;
		}catch(Exception e){
			
			
			
		}
		return res;
		
	}




	@Override
	public User getUserByUserName(String uname) {
		// TODO Auto-generated method stub
		return dao.getUserByUserName(uname);
	}




	@Override
	public List<Article> getAllArticle(String username) {
		// TODO Auto-generated method stub
		return dao.getAllArticle(username);
	}




	@Override
	public Article getArticle(int articleId) {
		// TODO Auto-generated method stub
		return dao.getArticle(articleId);
	}
  
 
}