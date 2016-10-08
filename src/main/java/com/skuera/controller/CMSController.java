package com.skuera.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skuera.form.ArticleForm;
import com.skuera.model.Article;
import com.skuera.model.User;
import com.skuera.service.SerI;

@RestController
public class CMSController {
	
	@Autowired
	private SerI ser;
	
	@RequestMapping(value = "/isvalid", method = RequestMethod.POST)
	public User isValid(@RequestBody User user){
		
		User us= ser.isValidUser(user.getUsername(), user.getPassword());
		System.out.println(us.getUsername());
	
			return us;
		}
	
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public Article isValid(@RequestBody ArticleForm article){
		Article art=new Article();
		art.setArticleText(article.getArticleText());
		art.setArticleTitle(article.getArticleTitle());
		art.setUsers(ser.getUserByUserName(article.getUsername()));
		
		int res= ser.saveArticle(art);
		if(res==1){
			return art;
		}
		return null;
	
		}
	
	@RequestMapping(value = "/getAllArticle", method = RequestMethod.POST)
	public List<Article> getArticle(@RequestBody User user){
		List<Article> artList=new ArrayList<>();

	artList=ser.getAllArticle(user.getUsername());
		return artList;
	}
	
	@RequestMapping(value = "/getArticle", method = RequestMethod.POST)
	public Article getArticleDetail(@RequestBody Article art){
	Article artcl=new Article();

	artcl=ser.getArticle(art.getArticleId());
		return artcl;
	}
}
	

	


