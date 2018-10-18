/*
 * Jose Luis Bustos Esteban 2014. Image cache for Web and Soap
 */
package com.common.tools.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



import org.apache.commons.io.FilenameUtils;

import com.common.config.ParamsApp;
import com.common.tools.Redis.RedisCacheData;
import com.common.tools.Redis.RedisInterface;

public class documentsCache 
{
	//constantes
	public static final int CACHE_GROUP_IMAGE = 1;
	public static final int CACHE_GROUP_GENERIC_FILE = 2;
	
	private String CacheDir;
	private int debug;
	
	//elementos publicos
	public int CleanCachesNumTotFiles;
	public int CleanCachesNumFilesDeleted;
	public String CleanCachesLog;
	
	
	//constructores
	public documentsCache()
	{

		new ParamsApp();
		debug = ParamsApp.SYSTEM_DEBUG;
		CacheDir = ParamsApp.SYSTEM_CACHE_DIRECTORY;
	}
	

	
	//get the extension
	private String getExtension(String file)
	{
		return FilenameUtils.getExtension(file);
	}
	
	
	private void addLog(String log, int type)
	{
		if (debug==1){	new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_BUSSINESS, "(" + documentsCache.class.getName() + ") "+ log, type);}
	}
	
	
	//Devuelve la ruta de un archivo cacheado si existe. Sino blanco
	public String getCachePath(String fileOrigen)
	{

		String origen = CacheDir  + "files" + getPathByOperSystem() + fileOrigen;
		
		File oFile = new File(origen);
		
		if (oFile.exists())
		{
			return origen;
		}
		else
		{
			return "";
		}

	}
	
	
	//TODO:
	//eliminacion de todos los archivos de Cache
	public void cleanAllCaches(){
		
		if(ParamsApp.SYSTEM_REDIS == 1) {
			
			CleanCachesLog = "<br><b>Eliminando caches servidor Redis...";
			
			// Cache on Redis Server
			RedisInterface redis = new RedisInterface();
			
			try {
				
				//Clean all Caches
				redis.cleanAllCaches();
				CleanCachesLog = "<br><b>Eliminando caches servidor Cache Redis...<br></b>";
				CleanCachesLog += "<br><b>OK<br></b>";
				
			}
			catch(Exception e) {
				CleanCachesLog += "<br><b>ERROR: "+e.getMessage()+"<br></b>";
			}
			finally {
				redis = null;
				CleanCachesLog +="<br><br><b>Fin limpieza cachés en Servidor Cache</b>";
			}
			

		}
		else {
			//Mode Cache on Disk
		
		
		
			String sourcePath = CacheDir  + "files"; 
			CleanCachesLog = "<br><b>Eliminando directorio caché: "+ sourcePath;
			CleanCachesLog+="<br></b>";
			File prueba= new File(sourcePath); 
			File[] ficheros =prueba.listFiles(); 
			File f=null; 
			this.CleanCachesNumTotFiles = ficheros.length;
			this.CleanCachesNumFilesDeleted = 0;
			if(prueba.exists()) 
			{ 
				for (int x=0;x<ficheros.length;x++) 
				{ 
					f= new File(ficheros[x].toString()); 
					f.delete(); 
					this.CleanCachesNumFilesDeleted++;
					CleanCachesLog+="<br>Eliminado archivo caché " + ficheros[x].toString() + "  -> OK";
				} 
				
				CleanCachesLog+="<br><br><b>Fin limpieza cachés</b>";
				
				addLog("(cleanAllCaches: Fin limpieza ...",ParamsApp.LOG_TYPE_INFO); 
			} 
			else 
			{ 
				addLog("(cleanAllCaches: No existe el directorio",ParamsApp.LOG_TYPE_INFO); 
			}
		}
	}
	
	
	//enruta segun el sistema operativo
	private String getPathByOperSystem()
	{
		
		if (new ParamsApp().SYSTEM_SSOO.equals("WINDOWS"))
		{
			addLog("  \ncache: es Windows",ParamsApp.LOG_TYPE_INFO);
			return "\\";
		}
		else
		{
			addLog("  \ncache: es MacOsx / Linux / Unix",ParamsApp.LOG_TYPE_INFO);
			return "//"; //mac, linux, unix
		}
		
	}
	
	
	//Devuelve la ruta de un archivo buscando por nombre parcial
	public String getCacheFileListImage(String fileName)
	{
		if(ParamsApp.SYSTEM_REDIS == 1) {
			
			String returnData = "";
			
			// Cache on Redis Server
			RedisInterface redis = new RedisInterface();
			RedisCacheData dataRedis = new RedisCacheData();
			
			try {
				
				//find key in Redis Server
				if (redis.existKeyCache(fileName)) {
					//return any value. Emply = no exist, if is diferent of emply exit
					returnData= "findedKey";
				}
				
			}
			catch(Exception e) {
				System.out.println("ERROR: getImageEmpleadoBase64 (mode Redis server) :" + e.getMessage());
			}
			finally {
				redis = null;
				dataRedis = null;
			}
			
			return returnData;
		}
		else {
			//Mode Cache on Disk
		
			//le pasamos el identificador "sin extension".
			 File[] fileList = getFileListImage(fileName);
	
			 if (fileList == null){
				 return "";
			 }
		     if (fileList.length > 0)
		     {
		        	File file = fileList[0]; 
		        	return CacheDir  + "files" + getPathByOperSystem() + file.getName();
		     }
		     else
		     {
		    	 return "";
		    	 
		     }
		} 
	}
	
	//funcion que busca una imagen en el directoruio cache
	 private File[] getFileListImage( String fileName) {
	        File dir = new File(CacheDir+"files"+ getPathByOperSystem() );   
	        final String  xname = fileName;
	        File[] fileList = dir.listFiles(new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	              
	             // if ( name.startsWith(xname) && (name.toLowerCase().endsWith("png")|| name.toLowerCase().endsWith("jpg") || name.toLowerCase().endsWith("bmp")))
	              if ( name.startsWith(xname))
	   	          {
	            	  return true;
	              }
	              return false;
	            }
	        });
	        return fileList;
	   }	

	
	 //Cachea Datos. Solo en modo Redis
	 public void cacheData(String Key, String Data) {
		 if(ParamsApp.SYSTEM_REDIS == 1) {
			 	RedisInterface redis = new RedisInterface();
				RedisCacheData dataRedis = new RedisCacheData();
				
				dataRedis.addData("value", Data);
				String dataSendServer = dataRedis.getDataCacheString(); // data (JSON)
				redis.setValueCache(Key, dataSendServer);
		 }
	 }
	 
	 public void cacheDataFile(String Key, String Extension, String Data) {
		 if(ParamsApp.SYSTEM_REDIS == 1) {
			 	RedisInterface redis = new RedisInterface();
				RedisCacheData dataRedis = new RedisCacheData();
				dataRedis.addData("ext", Extension);
				dataRedis.addData("file", Data);
				String dataSendServer = dataRedis.getDataCacheString(); // data (JSON)
				redis.setValueCache(Key, dataSendServer);
		 }
	 }
	 
	 
	//return RedisCacheData
	 public RedisCacheData getCacheDataFile(String key) {
			 if(ParamsApp.SYSTEM_REDIS == 1) {
				 	RedisInterface redis = new RedisInterface();
					RedisCacheData dataRedis = new RedisCacheData();
					
					String dataJson = redis.getValueCache(key);
					dataRedis.setFromCache(dataJson); //setvalue
					return 	dataRedis;
					
			 }
			 else {
				 return null;
			 }
	}
	 
	 //devuelve un dato de la cache de datos
	 public String getCacheData(String key) {
		 if(ParamsApp.SYSTEM_REDIS == 1) {
			 	RedisInterface redis = new RedisInterface();
				RedisCacheData dataRedis = new RedisCacheData();
				
				String dataJson = redis.getValueCache(key);
				dataRedis.setFromCache(dataJson); //setvalue
				return 	dataRedis.getValue("value");
				
		 }
		 else {
			 return "";
		 }
	 }
	 
	 
	//Cachea un archivo
	public void cacheFile(String fileOrigen, String fileNameDestino, int grupo)
	{
		
		if(ParamsApp.SYSTEM_REDIS == 1) {
			
			System.out.println("INFO: cache file: " + fileNameDestino);
			// Cache on Redis Server
			RedisInterface redis = new RedisInterface();
			RedisCacheData dataRedis = new RedisCacheData();
			
			try {
				
				// Cache File on Redis Server (extension file and File)
				
				
				// step 1. Get the extesion
				String extension = getExtension(fileOrigen);
				
				//get the file
				String fileBase64 = new ParamsApp().readFileAndConvertBase64String(fileOrigen);
				
				//create the Redis Data
				dataRedis.addData("ext", extension);
				dataRedis.addData("file", fileBase64);
				String dataSendServer = dataRedis.getDataCacheString(); // data (JSON)
				
				//send to Redis server
				redis.setValueCache(fileNameDestino, dataSendServer);
				
				
			}
			catch(Exception e) {
				System.out.println("ERROR: cacheFile (mode Redis server) :" + e.getMessage());
			}
			finally {
				redis = null;
				dataRedis = null;
			}
		}
		else {
		
			//Cache on Disk
			File oFile = new File(fileOrigen);
			
			if (oFile.exists())
			{
				
				File aux;
				//montamos path destino segun si es imagen o file
			
				aux = new File(CacheDir + "files");
				
				if (!aux.exists())
				{
					addLog("(cacheFile) The directory "+CacheDir+"images  No exist!!!!",ParamsApp.LOG_TYPE_ERROR);
					return;
				}
				
				//ruta en el images/cache de la aplicacion web
				
				String destino = CacheDir  + "files" + getPathByOperSystem()  + fileNameDestino + "."+getExtension(fileOrigen);
				
			
				//miramos si existe
				File dFile=new File(destino);
				
				boolean copiar = true;
				
				
				if (dFile.exists()) //existe en destino, tenemos que ver que podemos machacar
				{
					addLog("  Existe en destino. Control de cache!",ParamsApp.LOG_TYPE_INFO);
					//mismo tamaño, no hacemos nada porque es el mismo
					if (dFile.length() == oFile.length())
					{
						addLog("  tamaño archivos igual, no reemplazamos la cache!!",ParamsApp.LOG_TYPE_INFO);
						copiar = false;
					}
					
					if (copiar)
					{
						//eliminamos si podemos
						if (dFile.canWrite()==true)
						{
							addLog("    Podemos sustituir el archivo",ParamsApp.LOG_TYPE_INFO);
							if (!dFile.delete()) // si error al borrar
							{
								addLog("    Error al borrar el archivo cache:"+dFile.getAbsolutePath(),ParamsApp.LOG_TYPE_ERROR);
								copiar = false;
							}
							else{addLog("  archivo cache borrado",ParamsApp.LOG_TYPE_INFO);}
						}
						else
						{
							addLog("  Archivo de cache no permite escritura. no hacemos nada.!!",ParamsApp.LOG_TYPE_ERROR);
						}
					}
				}
				
	
				
				if (copiar)//copiamos origen en destino
				{
						//addLog("  Iniciamos la copia de la cache",ParamsApp.LOG_TYPE_INFO);
						InputStream inStream = null;
						OutputStream outStream = null;
						try {
							inStream = new FileInputStream(oFile);
							outStream = new FileOutputStream(dFile);
							
							byte[] buffer = new byte[1024];
			 
							int length;
		
							//copy the file content in bytes 
			    	    
							while ((length = inStream.read(buffer)) > 0){
								outStream.write(buffer, 0, length);
							}
						
							inStream.close();
							outStream.close();
						} 
						catch (IOException e) {
							addLog("  Error al crear la cache",ParamsApp.LOG_TYPE_INFO);
							e.printStackTrace();
						}
						finally
						{
							inStream = null;
							outStream = null;
						}
				}
				else
				{addLog("  NO CREAMOS LA CACHE",ParamsApp.LOG_TYPE_INFO);}
				
				
			}
			else
			{
				addLog("  Archivo origen no existe",ParamsApp.LOG_TYPE_ERROR);
			}
		}
	}
	
	

}
