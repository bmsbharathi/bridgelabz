package com.bridgeit.logger;

import org.apache.log4j.Logger;

public class Loggerr{

	final static Logger logger = Logger.getLogger(Loggerr.class);

	public static void main(String[] args) {

		Loggerr obj = new Loggerr();
		obj.runMe("Bharathi");

	}

	private void runMe(String parameter){

		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}

		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}

}