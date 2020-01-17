package com.fixit.server;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fixit.fixer.CredentialInfo;
import com.fixit.fixer.Fixer;
import com.fixit.fixer.PersonalInfo;
import com.fixit.fixer.WorkInfo;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet 
{
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String command = request.getParameter("command");
		try 
		{
			if(command.equals("FIXER-CREDENTIALS"))
				getFixerCredentials(request, response);
			else if(command.equals("FIXER-PERSONAL"))
				getFixerPersonal(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void getFixerPersonal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException 
	{	
		PersonalInfo data = makePersonal(request, response);
		CredentialInfo cdata = makeCredentials(request, response);
		
		request.setAttribute("fixer-personal", data);
		request.setAttribute("fixer-credentials", cdata);
		
		//Redirect to new page
		RequestDispatcher dispatch = request.getRequestDispatcher("fixer-signup-work.jsp");
		dispatch.forward(request, response); 
	}

	private static PersonalInfo makePersonal(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		//Get Data from FORM
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");		
		String phoneNumber = request.getParameter("phoneNumber");

		//Make an object 
		return new PersonalInfo(firstName, lastName, gender, phoneNumber);		
	}

	private void getFixerCredentials(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{				
		CredentialInfo data = makeCredentials(request, response);
		
		//Attach the object with the request
		request.setAttribute("fixer-credentials", data);
		
		//Redirect to new page
		RequestDispatcher dispatch = request.getRequestDispatcher("fixer-signup-personal.jsp");
		dispatch.forward(request, response);
	}

	private static CredentialInfo makeCredentials(HttpServletRequest request, HttpServletResponse response) 
	{
		//Get form data
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		
		return new CredentialInfo(username, email, password);		
	}
	
	private static WorkInfo makeWork(HttpServletRequest request, HttpServletResponse response) 
	{
		String serviceCategory = request.getParameter("serviceCategory");
		String serviceName = request.getParameter("serviceName");
        String city = request.getParameter("city");
        String workArea = request.getParameter("workArea");
		String workAddress = request.getParameter("workAddress");
		
		return new WorkInfo(serviceCategory, serviceName, city, workArea, workAddress);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		doGet(request, response);	
	}

	public static Fixer makeFixer(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{		
		CredentialInfo credential = makeCredentials(request, response);
		PersonalInfo personal = makePersonal(request, response);
		WorkInfo work = makeWork(request, response);
		
		return new Fixer(credential, personal, work);
	}


}
