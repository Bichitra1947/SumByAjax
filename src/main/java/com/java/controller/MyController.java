package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.entity.Mobile;
import com.java.service.MobileService;
@Controller
public class MyController {

	@Autowired
	private MobileService service;
	
	//show the existing data and getting data from form field using form binding------------------
	@GetMapping("/")
	public ModelAndView showData(@ModelAttribute Mobile data) {		
		ModelAndView  mav=new ModelAndView();
		mav.addObject("Mobiles", service.getAllData());
		mav.addObject("mobileObj", new Mobile());
		mav.setViewName("mobileUI");
		return mav;
	}
	
	//this is for save data to the databases table---------------------------------
	@PostMapping("/showData")
	public ModelAndView saveData1(Mobile data){
		ModelAndView mav=new ModelAndView();

		Boolean status = service.saveData(data);
		if(status) {
			mav.addObject("success", "Data Added successfully");
		}else {
			mav.addObject("error", "Opps! sorry try again");
		}
		
		mav.setViewName("index");
		return mav;
	}
	
	// this is for delete data from controller-------------------------------------------
	
	//get data from delete html file -----------------------
	@GetMapping("/delete")
	public ModelAndView getDeleteData() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("mobileKey", new Mobile());
		mav.setViewName("delete");
		
		return mav;
	}
	
	// delete data from database--------------------------------
	@PostMapping("/deleteData")
	public ModelAndView deletedata(Mobile mobile) {
		Integer id = mobile.getId();
		service.deleteData(id);
		ModelAndView mav=new ModelAndView();
		if(id!=null) {
			mav.addObject("msg1", "Delete successfully");
		}else {
			mav.addObject("msg2", "Delete Fail ,try again");
		}
		mav.setViewName("deleteSuccess");
		return mav;
	}
	
	
	//update data ------------------------------------------
	
	@GetMapping("/update")
	public ModelAndView getUpdateData() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("updateKey",new Mobile() );
		mav.setViewName("update");
		return mav;
	}
	
	@PostMapping("/updateData")
	public ModelAndView  upadteData(Mobile mobile) {
		Boolean status = service.updateData(mobile);
		
		ModelAndView mav=new ModelAndView( );
		if(status) {
			mav.addObject("msg1", "update Success");
		}else {
			mav.addObject("msg2", "update Success");
		}
		
		mav.setViewName("updateSuccess");
		return mav;
	}
	
}




















