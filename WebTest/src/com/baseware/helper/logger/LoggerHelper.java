package com.baseware.helper.logger;
import org.apache.log4j.Logger;
/*
 * This class setting up Logger and returning the same for logging requirement
 */
import org.apache.log4j.PropertyConfigurator;


import com.baseware.helper.resource.ResourceHelper;

public class LoggerHelper {
private static boolean root=false;
public static Logger getLogger(Class cls) {
	if(root) {
		return Logger.getLogger(cls);
	}
	PropertyConfigurator.configure(ResourceHelper.getResourcePath("/WebTest/src/resources/configfile/log4j.properties")) ;
	root=true;
	return Logger.getLogger(cls);
	
}
}
