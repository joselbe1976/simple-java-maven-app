/*
 * Jose Luis Bustos Esteban 2014. Clase para la formacion del XML
 */
package com.common.tools.xml;


import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.common.tools.interfaces.iDisposable;

public class XmlHelper  implements iDisposable
{
	
	//constantes
	// --------------------------------------------------------------------------
	public final int XML_NORMAL = 0;
	public final int  XML_NO_USAR_CDATA = 1;
	public final int XML_NO_CERRAR_XML = 2;
	public final int XML_SOLO_CERRAR_XML = 3;
	public final int XML_SOLO_VALOR = 4;
	
	public static final int FORMAT_XML = 1;
	public static final int FORMAT_JSON = 2;
	
	public int FORMAT; //Formato Salida
	
	// Hasmap que contienen los items de XML. Usamos liked pars que guarde el orden de entrada
	// --------------------------------------------------------------------------
	private LinkedHashMap<String, String> cache = new LinkedHashMap<String, String>();
	private LinkedHashMap<String, Integer> options = new LinkedHashMap<String, Integer>();
	
	// --------------------------------------------------------------------------
	//Constructores
	// --------------------------------------------------------------------------
	public XmlHelper()
	{
			FORMAT = FORMAT_XML;  //por defecto XML
	}

	public XmlHelper(int format)
	{
			FORMAT = format;
	}
	
	
	@Override
	public void Dispose() {
		cache = null;
		options = null;
	}
	
	// --------------------------------------------------------------------------
	//asignar formato
	// --------------------------------------------------------------------------
	public void setFormat(int format)
	{
		FORMAT = format;
	}
	
	// --------------------------------------------------------------------------
	//metodos para poner
	// --------------------------------------------------------------------------
	public void addXmlItem(String key, String Value, Integer opcion)
	{
		if(Value==null){Value="";}
		
		cache.put(key, Value); //items
		if (opcion == null)
		{
			options.put(key,XML_NORMAL);
		} //opciones del item
		else
		{
			options.put(key, opcion);
		}
		
	}
	
	// --------------------------------------------------------------------------
	//sobrecarga
	// --------------------------------------------------------------------------
	public void addXmlItem(String key, int record, String Value, Integer opcion)
	{
		this.addXmlItem(key+"_"+record,Value,opcion);
	}
	
	
	// --------------------------------------------------------------------------
	//Devuelve el XML del Hasmap introducido
	// --------------------------------------------------------------------------
	public String getValues() throws JSONException
	{
		if(FORMAT == FORMAT_XML)
		{
		   return getXml(); //xml
		}
		else
		{
			return getJson(); //Json
		}
	}
	
	// --------------------------------------------------------------------------
	// cadena de error por defecto para enviar a los clientes siempre.
	// --------------------------------------------------------------------------
	public String getErrorValues(String Serial) 
	{
		try {
			addXmlItem("object1","object", XML_NO_CERRAR_XML);
			addXmlItem("codeMeta4",Serial, XML_NORMAL);
			addXmlItem("Records","0", XML_NORMAL);
			addXmlItem("Errors","1", XML_NORMAL);
			addXmlItem("object2","object", XML_SOLO_CERRAR_XML);
			return  this.getValues();
			
			} 
		catch (JSONException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
		}
		finally
		{
			
		}
	}
	
	// --------------------------------------------------------------------------
	// monta la salida con XML
	// --------------------------------------------------------------------------
	private String getXml()
	{
		StringBuilder Xml = new StringBuilder();
		
		Iterator<String> keySetIterator = cache.keySet().iterator();

		//recorremos el hasmap y montamos el serial con el stringbuilder
		while(keySetIterator.hasNext()){
			 String key = keySetIterator.next();
			
			 Integer opcion = this.getItemXmlOption(key);
			 
			 if (opcion == XML_NORMAL)
			 {
				 Xml.append("<").append(key).append(">").append("<![CDATA[").append(cache.get(key)).append("]]>").append("</").append(key).append(">");
			
			 }
			 else if(opcion == XML_NO_USAR_CDATA)
			 {
				 Xml.append("<").append(key).append(">").append(cache.get(key)).append("</").append(key).append(">");
			 }
			 else if(opcion == XML_NO_CERRAR_XML)
			 {
				 Xml.append("<").append(cache.get(key)).append(">");
			 }
			 else if(opcion == XML_SOLO_CERRAR_XML)
			 {
				 Xml.append("</").append(cache.get(key)).append(">");
			 }
			 else if(opcion == XML_SOLO_VALOR)
			 {
				 Xml.append(cache.get(key));
			 }
			 
		}
		
		//devolvemos la cadena
		return Xml.toString();
	}
	
	
	// --------------------------------------------------------------------------
	// Devuelve el rtipo de opcion de XML
	// --------------------------------------------------------------------------
	private Integer getItemXmlOption(String key)
	{
		Iterator<String> keySetIterator = options.keySet().iterator();

		//recorremos el hasmap y montamos el serial con el stringbuilder
		while(keySetIterator.hasNext()){
			String key2 = keySetIterator.next();
			if (key2.equals(key))
			{
				return options.get(key2);
			}
		
		}
		return 0;
		
	}
	
	
	// --------------------------------------------------------------------------
	// Devolucion en formato JSON
	// --------------------------------------------------------------------------
	public String getJson() 
	{
		Iterator<String> keySetIterator = cache.keySet().iterator();

		
		//creamos un array de Json
		 JSONObject obj = new JSONObject();
		 JSONArray lista = new JSONArray();
		
		try{
		

				while(keySetIterator.hasNext()){
					String key = keySetIterator.next();
					Integer opcion = this.getItemXmlOption(key);
					
					if (!key.contains("_")) //no queremos registros
					{
					
						 if (opcion == XML_NORMAL || opcion == XML_NO_USAR_CDATA || opcion == XML_SOLO_VALOR)
						 {
			
							 obj.put(key,cache.get(key));
							 
						 }
					}
				}//while

				//si hay registros
				int records = getNumRecords();
				
				
				
				if (records > 0)
				{
					int pos = 0;
					String find="";
					for (int i = 0; i<records;i++)
					{
						find="_"+String.valueOf(pos); //cadena a buscar	
						
						keySetIterator = cache.keySet().iterator();

						 //creamos objeto Json
						 JSONObject obj2 = new JSONObject();

						while(keySetIterator.hasNext()){
							String key = keySetIterator.next();
							Integer opcion = this.getItemXmlOption(key);
							
							
							if (key.contains(find)) //Si es ese registro
							{
							
								 if (opcion == XML_NORMAL || opcion == XML_NO_USAR_CDATA || opcion == XML_SOLO_VALOR)
								 {
					
									 obj2.put(key.replace(find, ""),cache.get(key));
								 }
							}
						}//while
						
						//añadimos al array de registros de Json
						lista.put(obj2);
						
						pos++;
					}
					
					//array to obj
					obj.put("data", lista);
					
					
				}
				
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		finally{}
		
		//devolvemos la cadena
		return obj.toString();
	}
	
	
	
	//devuelve el numero de registros
	private int getNumRecords()
	{

		// paso 2. Buscamos el numero de registros
		Iterator<String> keySetIterator = cache.keySet().iterator();
	
		
		while(keySetIterator.hasNext()){
			String key = keySetIterator.next();
			
			
			if (key.trim().toUpperCase().equals("RECORDS"))
			{
				return Integer.parseInt(cache.get(key)); //devolvemos el numero
			}
		}//while
		
		return 0;
	}
	
	
	
	// --------------------------------------------------------------------------
	//vaciar el hasmap
	// --------------------------------------------------------------------------
	public void vaciar()
	{
		//eliminamos d ememoria cada elemento
		
		Iterator<String> keySetIterator = cache.keySet().iterator();

		//recorremos el hasmap y montamos el serial con el stringbuilder
		while(keySetIterator.hasNext()){
		 String key = keySetIterator.next();
		 cache.remove(key);
		}

		Iterator<String> keySetIterator2 = options.keySet().iterator();

		//recorremos el hasmap y montamos el serial con el stringbuilder
		while(keySetIterator2.hasNext()){
		 String key = keySetIterator.next();
		 options.remove(key);
		}
		
		cache = null;
		options = null;
		//volvemos a asignar memoria
		cache = new LinkedHashMap<String, String>();
		options = new LinkedHashMap<String, Integer>();
		
	}

	
	
}
