package com.common.meta4;

import java.io.IOException;

import com.Ostermiller.util.Base64;
import com.common.config.ParamsApp;
import com.common.tools.Redis.RedisCacheData;
import com.common.tools.Redis.RedisInterface;
import com.common.tools.cache.documentsCache;

public class meta4ImagesCache {
	
	public String extesion = "";
	
	//Devuelve la imagen en BAse64 para enviar al dispositivo
	//Comun a Peoplenet y Tinnova
	public String getImageEmpleadoBase64(String id)
	{
		String result="";

		
		if(ParamsApp.SYSTEM_REDIS == 1) {
			// Cache on Redis Server
			RedisInterface redis = new RedisInterface();
			RedisCacheData dataRedis = new RedisCacheData();
			
			try {
				
				String dataS = redis.getValueCache(id);
				
				if (dataS != null) {
					//set data from redis server
					dataRedis.setFromCache(dataS);
					
					//get Value
					result = dataRedis.getValue("file");
					this.extesion = dataRedis.getValue("ext");
					
				}
				
			}
			catch(Exception e) {
				System.out.println("ERROR: getImageEmpleadoBase64 (mode Redis server) :" + e.getMessage());
			}
			finally {
				redis = null;
				dataRedis = null;
			}
		}
		else {
		
			//Cache on Disk
			String FileCacheImagen = new documentsCache().getCacheFileListImage(id);
			
			if (!FileCacheImagen.equals(""))
			{
				String MimeType  = new ParamsApp().getExtensionFile(FileCacheImagen);
				this.extesion = MimeType;
				//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
				 result = new ParamsApp().getValueFileBase64Encode(FileCacheImagen, MimeType);
			}
		}
			
		return result;
	}
	
	//imagen general
	public String getImageBase64(String id)
	{
		String result="";

		
		if(ParamsApp.SYSTEM_REDIS == 1) {
			// Cache on Redis Server
			RedisInterface redis = new RedisInterface();
			RedisCacheData dataRedis = new RedisCacheData();
			
			try {
				
				String dataS = redis.getValueCache(id);
				
				if (dataS != null) {
					//set data from redis server
					dataRedis.setFromCache(dataS);
					
					//get Value
					result = dataRedis.getValue("file");
					this.extesion = dataRedis.getValue("ext");
					
				}
				
			}
			catch(Exception e) {
				System.out.println("ERROR: getImageEmpleadoBase64 (mode Redis server) :" + e.getMessage());
			}
			finally {
				redis = null;
				dataRedis = null;
			}
		}
		else {
		
			String FileCacheImagen = new documentsCache().getCacheFileListImage(id);
			
			if (!FileCacheImagen.equals(""))
			{
				String MimeType  = new ParamsApp().getExtensionFile(FileCacheImagen);
				
				this.extesion = MimeType;
				//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
				// result = new ParamsApp().getValueFileBase64Encode(FileCacheImagen, MimeType);
				
				try {
					result = new ParamsApp().readFileAndConvertBase64String(FileCacheImagen);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
			
		return result;
	}
	
	
	
	public String getImageNOBase64(String id)
	{
		String result="";

		String FileCacheImagen = new documentsCache().getCacheFileListImage(id);
		
		if (!FileCacheImagen.equals(""))
		{
			String MimeType  = new ParamsApp().getExtensionFile(FileCacheImagen);
			
			this.extesion = MimeType;
			//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
			 result = new ParamsApp().getValueFileBase64Encode(FileCacheImagen, MimeType);
			 result = Base64.decode(result); //decodificado
		}
			
		return result;
	}
	
	
}
