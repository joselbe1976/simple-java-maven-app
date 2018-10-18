/*
 * --------------------------------------------------------------------------------------------
 * Jose Luis Bustos Esteban. Jose Luis Bustos Esteban
 * --------------------------------------------------------------------------------------------
 * Esta clase se encarga de la codificacion/decodificacion en base64 de imagenes.
 * --------------------------------------------------------------------------------------------
*/
package com.common.tools;

import java.io.IOException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.common.tools.encript.Base64Tools;



public class Imagesbase64 {
	 public  BufferedImage decodeToImage(String imageString) {

	        BufferedImage image = null;
	        byte[] imageByte;
	        try {
	            
	            imageByte = new Base64Tools().decode(imageString.getBytes());
	            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
	            image = ImageIO.read(bis);
	            bis.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return image;
	    }



	    public String encodeToString(BufferedImage image, String type) throws Exception {
	        String imageString = null;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();

	        try {
	        	
	        	if (type.equals("bmp")){type = "jpg";} //joselbe. Los BMP los tratamos como JPG o no funciona.
	        	
	            ImageIO.write(image, type, bos);
	            byte[] imageBytes = bos.toByteArray();

	            imageString = new String(new Base64Tools().encode(imageBytes));

	            bos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return imageString;
	    }
	  
	    
}
