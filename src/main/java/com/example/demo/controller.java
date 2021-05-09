package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	@Autowired
	userService udao;
	@Autowired
	suggestionssurvices sdao;

	@PostMapping(value="/createsuggestion")
	public void createsuggestion(@RequestBody sugestions usr) {
		
		sdao.saveUser(usr);
	}
	
	@PostMapping(value="/createaccount")
	public ArrayList<String> createaccount(@RequestBody user usr) {
		ArrayList<String> list = new ArrayList<String> ();
		if(!usr.getPassword().equals(usr.getPassword2())) {
			list.add("the passwords douesnt match");
			return list;
		}
		if(usr.getPassword().length()<8) {
			list.add( "the password have to be more than 8 chars");
			return list;
		}
		if(!isValidEmailAddress(usr.getEmail())) {
			list.add( "the email is invalid");
			return list;
		}

		Object[] userarray = udao.getAllUsers().toArray();
		for (int i = 0; i < userarray.length; i++) {
			if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
				list.add("there is an account with this email");
			return list;
			
			}
		}	
		list.add("true");
		list.add(usr.getEmail());
		udao.saveUser(usr);
		return list;
	}
	
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
    

	@PostMapping(
			  value = "/login")
	public ArrayList<String>  login(@RequestBody user usr){	
		ArrayList<String> loginerrors = new ArrayList<String>();
		int indexofemail = -1;
		Object[] userarray = udao.getAllUsers().toArray();
		for (int i = 0; i < userarray.length; i++) {
			if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
				indexofemail=i;		
				break;
			}
		}	
		if(indexofemail==-1) {
			loginerrors.add("this email doesnt exist");
		}
		else if(!(usr.getPassword()).equals(((user) userarray[indexofemail]).getPassword()))
		
		{
			loginerrors.add("the password is wrong");
		}
		if(loginerrors.size()==0) {
			loginerrors.add("true");
			loginerrors.add(usr.getEmail());
		
		}
		
		
	
		return loginerrors;		
	}
	

	@PostMapping(
			  value = "/updatepassword")
	public ArrayList<String>  updatepassword(@RequestBody user usr){	
		ArrayList<String> loginerrors = new ArrayList<String>();
		int indexofemail = -1;
		Object[] userarray = udao.getAllUsers().toArray();
		for (int i = 0; i < userarray.length; i++) {
			if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
				indexofemail=i;		
				break;
			}
		}	
		if(indexofemail==-1) {
			loginerrors.add("this email doesnt exist");
		}
		else if(!(usr.getPassword()).equals(((user) userarray[indexofemail]).getPassword()))
		
		{
			loginerrors.add("the password is wrong");
		}
		if(usr.getPassword2().length()<8) {
			loginerrors.add("the password have to be more than 8 chars");
		}
		if(loginerrors.size()==0) {
			user nsr = (user) userarray[indexofemail];
			nsr.setPassword(usr.getPassword2());
			nsr.setPassword2(usr.getPassword2());
			udao.saveUser(nsr);
			loginerrors.add("true");
	
			
		}
		
		
	
		return loginerrors;		
	}
	
	
	
	
	@PostMapping("/getallsugestions")
    public ArrayList<sugestions> getmysugestions(){
    	ArrayList<sugestions> myproducts = new ArrayList<sugestions>(); 
//		Double.parseDouble(shp.getLog())
//		Double.parseDouble(shp.getTan())

       	Object[] userarray = sdao.getAllUsers().toArray();
       	
		for (int i = 0; i < userarray.length; i++) {
			


	myproducts.add((sugestions)userarray[i]);
		

			
		}
    	
		return myproducts;
    	
    }
	

	@PostMapping("/deletesugestion")
    public void deletesuggestion(@RequestBody sugestions usr){
	int idd = usr.getId();
	sdao.removesug(idd);
    	
    }
	
	
	
}
