package com.kraft.pim.preprocess;

import java.util.LinkedList;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

public class PreprocessorThread extends TimerTask {

	public static LinkedList<String> inboundSAPFileList = new LinkedList<String>();
	private static ServletContext context;

	private static final Logger logger = Logger
			.getLogger(PreprocessorThread.class);

	

	public PreprocessorThread(ServletContext context) {
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	@Override
	public void run() {
		// while (true) {
		logger.debug("Starting Preprocessor");
		try {
			new Preprocessor().startPreprocessor(context);
			logger.debug("Sleeping main thread");

		} catch (Exception e) {
			logger.error("Error executing Preprocessor", e);
		}
		// }
	}

	public static void addToList(String entry) {
		if(inboundSAPFileList.size()>100){
			inboundSAPFileList.clear();
		}
		inboundSAPFileList.add(entry);
	}

	/*
	 * @Override public synchronized void run() { while (true) {
	 * logger.debug("Starting Preprocessor"); try { new
	 * Preprocessor().startPreprocessor(); logger.debug("Sleeping main thread");
	 * Thread.sleep(Long.parseLong(InboundProperties.appWaitTime)); } catch
	 * (Exception e) { logger.error("Error executing Preprocessor", e); } } }
	 */

}
