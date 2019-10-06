package com.baseware.helper.resource;
/*
 * * This class return path to the framework
 */

public class ResourceHelper {

	public static String getResourcePath(String path) {
		String basePath=System.getProperty("user.dir");
		return basePath+path;
		
	}
}
