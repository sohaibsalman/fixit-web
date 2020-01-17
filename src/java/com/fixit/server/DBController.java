package com.fixit.server;

import com.fixit.fixer.Fixer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class DBController
 */
@WebServlet("/DBController")
public class DBController extends HttpServlet {	
	
	private FixerDbUtil fixerDbUtil;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try 
		{
			fixerDbUtil = new FixerDbUtil();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET WHICH FORM WAS SUBMITTED
        String command = request.getParameter("command");
		try 
		{
            //ADD FIXER FORM SUBMITTED
			if(command.equals("ADD-FIXER"))
            {
                signup(request, response);
            }
            else if(command.equals("LOGIN-FIXER"))
            {
                login(request, response);
            }
		}
		catch (Exception e)
		{
            PrintWriter out = response.getWriter();
			e.printStackTrace(out);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        
        try
        {
            Fixer f = Signup.makeFixer(request, response);
            
            //ADD FIXER DATA TO VECTOR
            Vector<String> fixer = new Vector<>();
            
            fixer.add(f.getCredential().getUsername());     //id                    0
            fixer.add(f.getPersonal().getFirstName());      //first name            1
            fixer.add(f.getPersonal().getLastName());       //last name             2
            fixer.add(f.getCredential().getEmail());        //email                 3
            fixer.add(f.getCredential().getPassword());     //password              4
            fixer.add(f.getPersonal().getPhoneNumber());    //phone                 5
            fixer.add(f.getPersonal().getGender());         //gender                6
            fixer.add(f.getWork().getCity());               //city                  7
            fixer.add(f.getWork().getWorkArea());           //area                  8
            fixer.add(f.getWork().getWorkAddress());        //address               9
            fixer.add(f.getWork().getServiceCategory());    //service category      10
            fixer.add(f.getWork().getServiceName());        //service name          11
            
            boolean add = fixerDbUtil.addFixer(fixer);
            if(add)
            {
                //Create Session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(3600*24);
                session.setAttribute("username", f.getCredential().getUsername());
                session.setAttribute("fixer", f);
                
                //forward to new page
                response.sendRedirect("fixer-profile.jsp");
            }
            else
            {
                response.sendRedirect("");
            }
        } 
        catch (Exception ex)
        {
            PrintWriter pw = response.getWriter();
            ex.printStackTrace(pw);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            Fixer f = fixerDbUtil.loginFixer(username, password);
            if(f == null)
            {
                response.sendRedirect("fixer-signin.jsp");
            }
            else 
            {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(3600*24);
                session.setAttribute("username", f.getCredential().getUsername());
                session.setAttribute("fixer", f);
                response.sendRedirect("fixer-profile.jsp");
            }
        } 
        catch (Exception ex)
        {
            PrintWriter pw = response.getWriter();
            ex.printStackTrace(pw);
        }
    }

}
