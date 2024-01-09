package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.Mobile;
import com.java.repo.MobileRepository;

@Service
public class MobileService {

	private MobileRepository repository;
	
	@Autowired
	public void setRepository(MobileRepository repository) {
		this.repository = repository;
	}
	
	public List<Mobile> getAllData() {
		return repository.findAll();
	}
	
	public Boolean saveData(Mobile mobile){
		Mobile mobile2 = repository.save(mobile);
		if(mobile2!=null) {
			return true;
		}
		
		return false;
	}
	public void deleteData(Integer id) {
		repository.deleteById(id);
		
	}
	public void deleteData1(Mobile mobile) {
		repository.delete(mobile);
		
	}
	
	public Boolean updateData(Mobile mobile) {
		Mobile mobile1 = repository.save(mobile);
		if(mobile1!=null) {
			return true;
		}
		
		return false;
		
		
	}
}






