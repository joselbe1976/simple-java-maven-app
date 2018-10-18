/* 
 * Equilibrha 2017
 * Jose Luis Bustos Esteban 2017. AES 256 Encript
 */
package com.common.tools.encript;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encriptAES {

	// Definición del tipo de algoritmo a utilizar (AES, DES, RSA) EN EQUILIBRHA USAMOS AES 256
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
    
    //Claves fijas algoritmo
    private String key = "92AE31A79FEEB2A3"; //llave privaa para todos
    private String iv = "0123456789ABCDEF"; // vector de inicialización el Mismo para todos
    
    
    //metodos para cambiar las claves
    public void changeAESKeys(String ClavePrivada, String VectorInicializacion)
    {
	    	this.key = ClavePrivada;
	    	this.iv = VectorInicializacion;
    }
	   

   public  String cryptWithAES(String pass){
		try {
			return this.encrypt(key, iv,pass); //en sha1 y base64
	    }
	    catch(Exception e)
	    {
	    		return "";
	    }
	   finally
	   {}
   }	

   public  String decryptWithAES(String pass){
		try {
			return this.decrypt(key, iv,pass); //desencriptacion
	    }
	    catch(Exception e)
	    {
	    		return "";
	    }
	    finally
	    {  }
   }	
   
	   
   // --------------------------------------------------------------
   // Real Functions SHa1
   // --------------------------------------------------------------
    
    private String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(new Base64Tools().encode(encrypted));
    }
 
    /**
     * Función de tipo String que recibe una llave (key), un vector de inicialización (iv)
     * y el texto que se desea descifrar
     * @param key la llave en tipo String a utilizar
     * @param iv el vector de inicialización a utilizar
     * @param encrypted el texto cifrado en modo String
     * @return el texto desencriptado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos: NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException
     */
    private  String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = new Base64Tools().decode_string_bytes(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
}
