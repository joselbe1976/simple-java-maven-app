package com.common.webservices.apiRest.models;

public class deviceType {

	public static final int DEVICE_NATIVE_APP = 1;
	public static final int DEVICE_WEB = 2;
	public static final int DEVICE_ELECTRONJS = 3;
	
	public static final int SSOO_MACOS = 11;
	public static final int SSOO_WINDOWS = 12;
	public static final int SSOO_ANDROID = 13;
	public static final int SSOO_IOS = 14;
	
	
	
	public static String getName(int type) {
		switch(type) {
			case 1: return "1. Native App";
			case 2: return "2. Web";
			case 3: return "3. ElectrónJS";
			case 11: return "11. Apple MacOs";
			case 12: return "12. Microsoft Windows";
			case 13: return "13. Android";
			case 14: return "14. IOS";
			default:  return "Code " + type +  " NO recognize";
		}
	}
	
}
