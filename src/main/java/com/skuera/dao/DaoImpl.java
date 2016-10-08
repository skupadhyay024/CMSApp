package com.skuera.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skuera.model.Article;
import com.skuera.model.User;

@Repository
@Transactional
public class DaoImpl implements DaoI {
	
	 @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public User validate(String user, String pass) {
		Session sess=sessionFactory.getCurrentSession();
		String hql="FROM User u where u.username=:uid and u.password=:pass";
		Query query = sess.createQuery(hql);
		query.setParameter("uid",user);
		query.setParameter("pass",pass);
		List results = query.list();
		User us=null;
		
		if(results.size()>0){
			us=(User) results.get(0);
			return us;
		}else{
			return us;
		}
		
	}

	@Override
	public void saveArticle(Article article) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.save(article);
		
	}

	@Override
	public User getUserByUserName(String uname) {
	String hql="from User u where u.username=:uname";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+uname);
	qry.setString("uname", uname);
	User u=(User) qry.uniqueResult();

	return u;
	
	}

	@Override
	public List<Article> getAllArticle(String username) {
	String hql="from Article a where a.users.username=:uname";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+username);
	qry.setString("uname", username);
	List<Article> alist=qry.list();
	System.out.println(alist.size());
	return alist;
	}

	@Override
	public Article getArticle(int articleId) {
		Session sess=sessionFactory.getCurrentSession();
		Article art=(Article) sess.load(Article.class, articleId);
		return art;
	}
	
	

}
