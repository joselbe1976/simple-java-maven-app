/*
 * --------------------------------------------------------------------------------------------
 * Jose Luis Bustos Esteban. Jose Luis Bustos Esteban
 * --------------------------------------------------------------------------------------------
 * Esta clase  cintiene los algoritmos para codificar/decodificar para su uso en SOAP
 * --------------------------------------------------------------------------------------------
*/
package com.common.tools.encript;
import com.Ostermiller.util.*;

public class Base64Tools {
	

    

	public byte[] encode(byte[] b) throws Exception {
        return Base64.encode(b);
        
     }
     
     public byte[] decode(byte[] b) throws Exception {
    	 return Base64.decode(b);
     }  
     
     
     
     public String encode_string(String b) throws Exception
     {
    	 return new String(this.encode(b.getBytes()));
     }
     
     public String decode_string(String b) throws Exception
     {
    	 return new String(this.decode(b.getBytes()));
     }  

     public byte[] decode_string_bytes(String b) throws Exception
     {
    	 return this.decode(b.getBytes());
     }  
     
     
}
