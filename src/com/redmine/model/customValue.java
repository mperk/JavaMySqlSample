package com.redmine.model;

public class customValue {
	
	private int id;
	private String customized_type;
	private int customized_id;
	private int custom_field_id;
	private String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomized_type() {
		return customized_type;
	}
	public void setCustomized_type(String customized_type) {
		this.customized_type = customized_type;
	}
	public int getCustomized_id() {
		return customized_id;
	}
	public void setCustomized_id(int customized_id) {
		this.customized_id = customized_id;
	}
	public int getCustom_field_id() {
		return custom_field_id;
	}
	public void setCustom_field_id(int custom_field_id) {
		this.custom_field_id = custom_field_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "cv [id=" + id + ", customized_type=" + customized_type + ", customized_id=" + customized_id
				+ ", custom_field_id=" + custom_field_id + ", value=" + value + "]";
	}
	
	

}
