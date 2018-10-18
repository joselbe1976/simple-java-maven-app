package com.common.config;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class eqLoggers {

	private static List<eqLoggerData> LoggersData = new ArrayList<>();
	
	//add loger
	public void addLogger(Logger logger, int id) {
		LoggersData.add(new eqLoggerData(logger, id));
		
	}
	
	//gert Logger
	public Logger getLogger( int id) {

		for (eqLoggerData data : LoggersData) {
			if (data.id == id) {
				return data.logger;
			}
		 }
		
		return null;
		
		
	}
	
}
