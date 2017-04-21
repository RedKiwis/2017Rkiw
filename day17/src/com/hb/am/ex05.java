package com.hb.am;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex05
 */
@WebServlet("/data4.json")
public class ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String xml = "http://samples.openweathermap.org/data/2.5/weather?q=London&mode=xml&appid=b1b15e88fa797225412429c1c50c122a1";
	private final String json = "http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b1b15e88fa797225412429c1c50c122a1";
	private final String html = "http://samples.openweathermap.org/data/2.5/weather?q=London&mode=html&appid=b1b15e88fa797225412429c1c50c122a1";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer msg = new StringBuffer();
		
		URL me = new URL(json);
		InputStream is = me.openStream();
		int by;
		
		while((by =is.read())!=-1){
			System.out.print((char)by);
			msg.append((char)by);
		}
		
		is.close();
		
		//******************************************
		
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.close();
	}

}
