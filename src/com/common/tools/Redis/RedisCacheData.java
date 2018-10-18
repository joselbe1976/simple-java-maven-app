package com.common.tools.Redis;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RedisCacheData {

	JSONObject lista; // Values List
	
	public RedisCacheData() {
		this.lista = new JSONObject();
	}
	
	//Add Data to cache format
	public void addData(String key, String value) {
		try {
			//Add to the data list
			this.lista.put(key, value);

		}
		catch(Exception e) {	}
	}

	//return JSON of Data
	public String getDataCacheString() {
		return this.lista.toString();
	}
	
	//regeneramos la lista con lo que viene de la cache
	public void setFromCache(String jsonCache) {
		this.lista = new JSONObject(jsonCache);
	}
	
	//acessos a los items
	
	public String getValue(String key) {
		try {
			return this.lista.getString(key);
			
		}
		catch(Exception e) {
			return "";
		}
	}
	
	
	
}
