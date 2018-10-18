package com.teams.models;

import java.math.BigDecimal;

public class teamChat {
	
	public BigDecimal _id;
	public String _name;
	public String _description;
	public String _idEmployeeCreator;
	public BigDecimal _typeChat;
	public String _image;
	
	//constructor
	public teamChat (BigDecimal id, String name, Object descrip, Object idEmployeeCreator, BigDecimal typeChat, Object image) {
			this.set_id(id);
			this.set_name(name);
			if (descrip != null) {
				this.set_description(descrip.toString());
			}
			if (idEmployeeCreator != null) {
				this.set_idEmployeeCreator(idEmployeeCreator.toString());
			}
			this.set_typeChat(typeChat);
			if (image != null) {
				this.set_image(image.toString());
			}
	}
	
	
	
	public BigDecimal get_id() {
		return _id;
	}
	public void set_id(BigDecimal _id) {
		this._id = _id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public String get_idEmployeeCreator() {
		return _idEmployeeCreator;
	}
	public void set_idEmployeeCreator(String _idEmployeeCreator) {
		this._idEmployeeCreator = _idEmployeeCreator;
	}
	public BigDecimal get_typeChat() {
		return _typeChat;
	}
	public void set_typeChat(BigDecimal _typeChat) {
		this._typeChat = _typeChat;
	}
	public String get_image() {
		return _image;
	}
	public void set_image(String _image) {
		this._image = _image;
	}

	
	
}
