package SystemAdmin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SystemAdmin.entity.*;
import general.Entity.User;

@WebServlet("/searchUserAccount")
public class SearchUserAccount extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		searchUserAccount(request, response);
	}
	
	protected void searchUserAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String name = request.getParameter("searchbox");
//			
			ArrayList<User> userAcc = new SystemAdmin().searchUserByUserName(name);
			request.setAttribute("userAccountList", userAcc);
			RequestDispatcher dis = request.getRequestDispatcher("/UserAccountPage.jsp");
			dis.forward(request, response);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
