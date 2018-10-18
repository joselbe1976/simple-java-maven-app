package com.common.pushnotifications.pushy;

import com.common.config.ParamsApp;
import com.fasterxml.jackson.databind.ObjectMapper;



import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;

import java.util.Map;

public class PushyAPI {
	public static ObjectMapper mapper = new ObjectMapper();
    
	public static void sendPush(PushyPushRequest req) throws Exception {
        // Get custom HTTP client
       // HttpClient client = new DefaultHttpClient();
        
        HttpClient client = HttpClientBuilder.create().build();
        HttpClientContext context = HttpClientContext.create();

        
        new ParamsApp();
        
        //Proxy Configuration. is Optional
        
        if (ParamsApp.PROXY_IS_ACTIVATE.equals("Y")) {
	    	
        	addLog("<Proxy Activate>",ParamsApp.LOG_TYPE_INFO);
        	
        	
        	//Define the Proxy Host
        	HttpHost proxy = new HttpHost(ParamsApp.PROXY_HOST, ParamsApp.PROXY_PORT, ParamsApp.PROXY_PROTOCOL);
        	
        	addLog("     - Host    : " + ParamsApp.PROXY_HOST,ParamsApp.LOG_TYPE_INFO);
        	addLog("     - Port    : " + ParamsApp.PROXY_PORT,ParamsApp.LOG_TYPE_INFO);
        	addLog("     - Protocol: " + ParamsApp.PROXY_PROTOCOL,ParamsApp.LOG_TYPE_INFO);
        	
        	//set the proxy
        	 HttpClientBuilder httpClientBuilder = HttpClients.custom();
             httpClientBuilder.setProxy(proxy);
             client = httpClientBuilder.build();
        	
        	
        	if (ParamsApp.PROXY_AUTH.equals("Y")) {
        		
        		addLog("       <Proxy Auth Activate>",ParamsApp.LOG_TYPE_INFO);
        		addLog("            - User    : " +  ParamsApp.PROXY_USER,ParamsApp.LOG_TYPE_INFO);
        		addLog("            - Password: " +  ParamsApp.PROXY_PASSWORD,ParamsApp.LOG_TYPE_INFO);
        		//define the Context with Secirity access
        		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(ParamsApp.PROXY_USER, ParamsApp.PROXY_PASSWORD);
                AuthScope scope = new AuthScope(ParamsApp.PROXY_HOST, ParamsApp.PROXY_PORT);
                CredentialsProvider provider = new BasicCredentialsProvider();
                provider.setCredentials(scope, credentials);
                context.setCredentialsProvider(provider);
        		
        	}
        }
        
        
        
        // Create POST request
        HttpPost request = new HttpPost(ParamsApp.SYSTEM_PUSHY_URL); 

        // Set content type to JSON
        request.addHeader("Content-Type", "application/json");

        // Convert post data to JSON
        String json = mapper.writeValueAsString(req);

        // Send post data as string
        request.setEntity(new StringEntity(json));

        // Execute the request
        HttpResponse response = client.execute(request, context); // here apply security if is configured by properties

        // Get response JSON as string
        String responseJSON = EntityUtils.toString(response.getEntity());

        addLog("       Pushy response : " + responseJSON,ParamsApp.LOG_TYPE_INFO);

        
        // Convert JSON response into HashMap
        Map<String, Object> map = mapper.readValue(responseJSON, Map.class);

        // Got an error?
        if (map.containsKey("error")) {
            // Throw it
            throw new Exception(map.get("error").toString());
        }
    }
	
	protected static void addLog(String info, int logType)
	{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_BUSSINESS, "(PushyAPI) "+info, logType);
	}

}
