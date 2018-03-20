package com.kraft.pim.preprocess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class InitServlet extends HttpServlet implements ServletContextListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InitServlet.class);
	Timer timer;
	TimerTask task;
	ServletContext context;
	
	
	public static String CONTEXT_PATH="";

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		// logger.debug("Initializing Context");
		// (new PreprocessorThread()).start();
	}

	@Override
	public void init() throws ServletException {
		CONTEXT_PATH=getServletContext().getRealPath("/");
		
		logger.debug("Begin Scheduler");
		context=getServletContext();
		context.setAttribute("attributelist", new AttributeList().setAttribute()); 
		//new AttributeList().setAttribute();
		timer = new Timer();
		task = new PreprocessorThread(context);
		// scheduling the task at fixed rate delay
		timer.schedule(task, 500, Long.parseLong(InboundProperties.appWaitTime));
		logger.debug("Exiting Scheduler");
		super.init();
	}
	
			
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CINTEXT_PATH:"+req.getContextPath());
		 
		if (null != req.getParameter("stop_val")) {
			if (timer != null) {
				timer.cancel();
				timer=null;
				task = null;
			}
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			String title = "Inbound Preprocessor";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
					+ "transitional//en\">\n";
			out.println(docType + "<html>\n" + "<head><title>" + title
					+ "</title></head>\n" + "<body>\n" + "Stopping Application"
					+ "</body></html>");
		} else if (null != req.getParameter("get_list")) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			String title = "Inbound Preprocessor";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
					+ "transitional//en\">\n";
			String listString = "";
			for (String entry : PreprocessorThread.inboundSAPFileList) {
				listString += entry + "<br>";
			}
			out.println(docType + "<html>\n" + "<head><title>" + title
					+ "</title></head>\n" + "<body>\n"
					+ "<h2>Listing inbound SAP files:</h2>\n<pre>" + listString
					+ "</pre></body></html>");
		} else if (null != req.getParameter("start_val")) {
			logger.debug("Begin Scheduler");
			if (null == timer) {
				//new AttributeList().setAttribute();
				timer = new Timer();
				task = new PreprocessorThread(context);

				// scheduling the task at fixed rate delay
				timer.schedule(task, 500,
						Long.parseLong(InboundProperties.appWaitTime));
				logger.debug("Exiting Scheduler");
				resp.setContentType("text/html");

				PrintWriter out = resp.getWriter();
				String title = "Inbound Preprocessor";
				String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
						+ "transitional//en\">\n";
				out.println(docType + "<html>\n" + "<head><title>" + title
						+ "</title></head>\n" + "<body>\n"
						+ "Restarting Application" + "</body></html>");
			}
		}
	}
}
