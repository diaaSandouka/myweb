package com.example.demo;

import java.awt.print.Pageable;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.user;
import com.sun.istack.Nullable;
@Service
@Transactional
public class suggestionssurvices {
	@Autowired
	private sugestionsdao dao;
	
	

	
	public sugestions saveUser(sugestions u)
	{
		
		return dao.save(u);
	}
	public Collection<sugestions> getAllUsers()
	{
		return dao.findAll();
	}
	public void removesug(int id )
	{
		dao.deleteById(id);
	}
	public sugestions updateUser(sugestions u )
	{
		return dao.save(u);
	}
	
	public long userlength()
	{
		return dao.count();
	}
	
	
	
	
	
}











