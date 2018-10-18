package com.teams.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class teamMessage {
  private BigDecimal _id;
  private BigDecimal _idChat;
  private String _text;
  private String _idFile;
  private String _extFile;
  private BigDecimal _sizeFile;  // in bytes
  private int _isReaded; // message readed by user
  
  
  
   public teamMessage(BigDecimal id, BigDecimal idChat, Object text, Object idFile, Object extFile, BigDecimal sizeFile, Date readedUser) {
	   _id = id;
	   _idChat = idChat;
	   if (text != null) {
		   _text = text.toString();
	   }
	   if (idFile != null) {
		   _idFile = idFile.toString();
	   }
	   if (extFile != null) {
		   _extFile = extFile.toString();
	   }
	   if (sizeFile != null) {
		   _sizeFile = sizeFile;
	   }
	   
	   //readed control message
	   _isReaded = 0; //no
	
	   Calendar cal = Calendar.getInstance();
	   cal.setTime(readedUser);
	   int year = cal.get(Calendar.YEAR);
	   
	   if (year != 4000) {
		   _isReaded = 1; //yes
	   }
	   
   }
  
  
	public BigDecimal get_id() {
		return _id;
	}
	public void set_id(BigDecimal _id) {
		this._id = _id;
	}
	public BigDecimal get_idChat() {
		return _idChat;
	}
	public void set_idChat(BigDecimal _idChat) {
		this._idChat = _idChat;
	}
	public String get_text() {
		return _text;
	}
	public void set_text(String _text) {
		this._text = _text;
	}
	public String get_idFile() {
		return _idFile;
	}
	public void set_idFile(String _idFile) {
		this._idFile = _idFile;
	}
	public String get_extFile() {
		return _extFile;
	}
	public void set_extFile(String _extFile) {
		this._extFile = _extFile;
	}
	public BigDecimal get_sizeFile() {
		return _sizeFile;
	}
	public void set_sizeFile(BigDecimal _sizeFile) {
		this._sizeFile = _sizeFile;
	}

	public int get_isReaded() {
		return _isReaded;
	}


	public void set_isReaded(int _isReaded) {
		this._isReaded = _isReaded;
	}
  
  
}
