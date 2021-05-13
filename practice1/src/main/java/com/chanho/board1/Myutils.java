package com.chanho.board1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chanho.board1.user.UserVO1;

public class Myutils {
	 public static void openJsp(String add, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String jsp = "/WEB-INF/jsp"+ add + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	 }
	 
	 public static int parseStringToInt(String val) {
		 
		 try {
			int result = Integer.parseInt(val);
			return result;
			
		} catch (Exception e) {
			
			return 0;
		}
	 }
	 
	 public static int getParamInt(String key, HttpServletRequest req) {
		 String strVal = req.getParameter(key);
		 int intVal = Integer.parseInt(strVal);
		 return intVal;
	 }
	 
	 
	 public static UserVO1 getLoginUser(HttpServletRequest req) {
		 
		 if(req == null) {return null;}
		 
		 HttpSession hs = req.getSession();
		 return (UserVO1) hs.getAttribute("loginUser");
	 }
	public static int getLoginUserPk(HttpServletRequest request) {
		
		if(request == null) {return 0;}
		return getLoginUser(request).getIuser();
	}
	 
	
}
