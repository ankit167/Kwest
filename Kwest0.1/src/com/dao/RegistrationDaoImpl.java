package com.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.User;

public class RegistrationDaoImpl implements RegistrationDaoI{
	
private HibernateTemplate hibernateTemplate;
	


	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}



public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}



	public int addUser(int user_id, String username, String first_name, String last_name,String profile_pic,String email, String password) {
		/*
		String sql="insert into User values (?,?,?,?,?,?,?)";
		Object[] params ={user_id,username,first_name,last_name,null,email,password};
		hibernateTemplate.update(sql, params);
		*/
		User user = new User();
		user.setUser_id(user_id);
		user.setEmail(email);
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setPassword(password);
		user.setProfile_pic(profile_pic);
		user.setUsername(username);
		hibernateTemplate.save(user);
		return 1;
	}
	
	public int maxKey(String table_name, String id) {
		// TODO Auto-generated method stub
		String hql = "select max ("+id+") from "+table_name+"";
		System.out.println(hql);
		List<Integer> lst = hibernateTemplate.find(hql);
		System.out.println(lst);
		System.out.println(lst.get(0));
		if(lst == null||lst.get(0)==null) return 0;
		return lst.get(0);
	}



}
