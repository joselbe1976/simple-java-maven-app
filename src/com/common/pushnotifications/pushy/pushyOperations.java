package com.common.pushnotifications.pushy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.config.ParamsApp;

/*
 * Pushy operations
 * 
 */

public class pushyOperations {

	//envia una notificaicon Push a un dispositivo con un texto
	public  int sendPushyPushNotification(String idDispositivo, String messageText, String argsApps) {
		addLog("Inicia Metodo sendPushyPushNotification",ParamsApp.LOG_TYPE_INFO);
		addLog("    - Disopsitivo: " + idDispositivo,ParamsApp.LOG_TYPE_INFO);
		addLog("    - messageText : "+messageText,ParamsApp.LOG_TYPE_INFO);
		// Prepare list of target registration IDs
		List<String> registrationIDs = new ArrayList<String>();

		// Add your registration IDs here
		registrationIDs.add(idDispositivo);

		// Set payload (any object, it will be serialized to JSON)
		Map<String, String> payload = new HashMap<String, String>();

		// Add "message" parameter to payload
		payload.put("message", messageText);
		payload.put("argument", argsApps); //the argument

		//Añadimos la parte de IOS siempre porque android ya funciona
		Map<String, Object> notificationIos = new HashMap<String, Object>();
		
		notificationIos.put("body", messageText);
		notificationIos.put("badge", 1);
		notificationIos.put("sound", "ping.aiff");
		
		// Prepare the push request
		PushyPushRequest push = new PushyPushRequest(payload, registrationIDs.toArray(new String[registrationIDs.size()]),notificationIos);

		try {
			// Try sending the push notification
			PushyAPI.sendPush(push);
			addLog("    Ejecutado envio!",ParamsApp.LOG_TYPE_INFO);
		}
		catch (Exception exc) {
		
			addLog(exc.toString(),ParamsApp.LOG_TYPE_ERROR);
			exc.printStackTrace();
			return -1;
			
		}
		
		addLog("Finaliza Metodo sendPushyPushNotification",ParamsApp.LOG_TYPE_INFO);		
		return 0; // ok
		
	}
	
	protected void addLog(String info, int logType)
	{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "(pushyOperations) "+info, logType);
	}
}
