package com.shree.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.shree.spring.model.LoginModel;

public class LoginController implements Controller{
	
	LoginModel loginModel;
	
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		String type = loginModel.validate(uname,pwd);
		if(type==null)
			return new ModelAndView("/login.html");
		else if(type.equals("admin"))
			return new ModelAndView("/AdminHome.jsp");
		else
			return new ModelAndView("/UserHome.jsp");
	}

}
