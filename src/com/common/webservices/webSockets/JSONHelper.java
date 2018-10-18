package com.common.webservices.webSockets;

import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONObject;

import com.common.tools.interfaces.iDisposable;

public class JSONHelper  implements iDisposable{
	
	JSONObject data; // arguments
	
	public JSONHelper() {
		this.data = new JSONObject();
	}
	public JSONHelper(String jsonString) {
		this.data = new JSONObject();
		this.setFromString(jsonString);
	}

	@Override
	public void Dispose() {
		this.data = null;
	}
	
	
	public JSONObject getJsonObject() {
		return data;
	}
	
	
	//Add Data 
	public void addData(String key, String value) {
		try {
			//Add to the data list
			this.data.put(key, value);
			
				}
		catch(Exception e) {	}
	}
	
	public void addData(String key, BigDecimal value) {
		try {
			//Add to the data list
			this.data.put(key, value);
			
				}
		catch(Exception e) {	}
	}
	
	public void addData(String key, int value) {
		try {
			//Add to the data list
			this.data.put(key, value);

		}
		catch(Exception e) {	}
	}
	
	public void addData(String key, JSONObject value) {
		try {
			//Add to the data list
			this.data.put(key, value);

		}
		catch(Exception e) {	}
	}
	
	public void addData(String key, JSONArray value) {
		try {
			//Add to the data list
			this.data.put(key, value);
			
				}
		catch(Exception e) {	}
	}
	

	//return JSON of Data
	public String getDataString() {
		return this.data.toString();
	}
	
	//Create the objet from String
	public void setFromString(String jsonString) {
		this.data = new JSONObject(jsonString);
	}
	
	
	public String getValue(String key) {
		try {
			return this.data.getString(key);
			
		}
		catch(Exception e) {
			return "";
		}
	}

	public int getValueInt(String key) {
		try {
			return this.data.getInt(key);
			
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	
}
