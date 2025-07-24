package pomplatform.websitenews.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSwebsitenewntfor extends GenericCondition{

	public ConditionSwebsitenewntfor(){
		setParameterCount(6);
	}

	public java.lang.Integer getNewType() {
		return this.__new_type;
	}

	public void setNewType( java.lang.Integer value ) {
		this.__new_type = value;
	}

	public java.lang.String getTitle() {
		return this.__title == null ? null : (this.__title.indexOf("%") >= 0 ? this.__title : "%"+this.__title+"%");
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url == null ? null : (this.__file_url.indexOf("%") >= 0 ? this.__file_url : "%"+this.__file_url+"%");
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getContent() {
		return this.__content == null ? null : (this.__content.indexOf("%") >= 0 ? this.__content : "%"+this.__content+"%");
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.lang.Integer getWebsiteNewId() {
		return this.__website_new_id;
	}

	public void setWebsiteNewId( java.lang.Integer value ) {
		this.__website_new_id = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getNewType() != null) sb.append(__wrapNumber(1, "newType", getNewType()));
		if(getTitle() != null) sb.append(__wrapString(1, "title", getTitle()));
		if(getFileUrl() != null) sb.append(__wrapString(1, "fileUrl", getFileUrl()));
		if(getContent() != null) sb.append(__wrapString(1, "content", getContent()));
		if(getWebsiteNewId() != null) sb.append(__wrapNumber(1, "websiteNewId", getWebsiteNewId()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("newType")) != null) setNewType(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("websiteNewId")) != null) setWebsiteNewId(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	private java.lang.Integer __new_type = null;
	private java.lang.String __title = null;
	private java.lang.String __file_url = null;
	private java.lang.String __content = null;
	private java.lang.Integer __website_new_id = null;
	private java.lang.Integer __delete_flag = null;
}

