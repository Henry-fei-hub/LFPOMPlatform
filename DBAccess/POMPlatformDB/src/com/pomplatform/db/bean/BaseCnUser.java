package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnUser extends GenericBase implements BaseFactory<BaseCnUser>, Comparable<BaseCnUser> 
{


	public static BaseCnUser newInstance(){
		return new BaseCnUser();
	}

	@Override
	public BaseCnUser make(){
		BaseCnUser b = new BaseCnUser();
		return b;
	}

	public final static java.lang.String CS_USER_ID = "user_id" ;
	public final static java.lang.String CS_USER_NAME = "user_name" ;
	public final static java.lang.String CS_USER_PASSWORD = "user_password" ;
	public final static java.lang.String CS_PHONE = "phone" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;
	public final static java.lang.String CS_USER_FILE_IMAGE = "user_file_image" ;
	public final static java.lang.String CS_PROFESSIONAL_TYPE_ID = "professional_type_id" ;
	public final static java.lang.String CS_USER_AUTOGRAPH = "user_autograph" ;

	public final static java.lang.String ALL_CAPTIONS = ",用户昵称,密码,手机号,组织机构代码,头像图片,专业类型,个人签名";

	public java.lang.Integer getUserId() {
		return this.__user_id;
	}

	public void setUserId( java.lang.Integer value ) {
		this.__user_id = value;
	}

	public java.lang.String getUserName() {
		return this.__user_name;
	}

	public void setUserName( java.lang.String value ) {
		this.__user_name = value;
	}

	public java.lang.String getUserPassword() {
		return this.__user_password;
	}

	public void setUserPassword( java.lang.String value ) {
		this.__user_password = value;
	}

	public java.lang.String getPhone() {
		return this.__phone;
	}

	public void setPhone( java.lang.String value ) {
		this.__phone = value;
	}

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public java.lang.Integer getUserFileImage() {
		return this.__user_file_image;
	}

	public void setUserFileImage( java.lang.Integer value ) {
		this.__user_file_image = value;
	}

	public java.lang.Integer getProfessionalTypeId() {
		return this.__professional_type_id;
	}

	public void setProfessionalTypeId( java.lang.Integer value ) {
		this.__professional_type_id = value;
	}

	public java.lang.String getUserAutograph() {
		return this.__user_autograph;
	}

	public void setUserAutograph( java.lang.String value ) {
		this.__user_autograph = value;
	}

	public void cloneCopy(BaseCnUser __bean){
		__bean.setUserId(getUserId());
		__bean.setUserName(getUserName());
		__bean.setUserPassword(getUserPassword());
		__bean.setPhone(getPhone());
		__bean.setOrganizationId(getOrganizationId());
		__bean.setUserFileImage(getUserFileImage());
		__bean.setProfessionalTypeId(getProfessionalTypeId());
		__bean.setUserAutograph(getUserAutograph());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getUserId() == null ? "" : getUserId());
		sb.append(",");
		sb.append(getUserName() == null ? "" : getUserName());
		sb.append(",");
		sb.append(getUserPassword() == null ? "" : getUserPassword());
		sb.append(",");
		sb.append(getPhone() == null ? "" : getPhone());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		sb.append(",");
		sb.append(getUserFileImage() == null ? "" : getUserFileImage());
		sb.append(",");
		sb.append(getProfessionalTypeId() == null ? "" : getProfessionalTypeId());
		sb.append(",");
		sb.append(getUserAutograph() == null ? "" : getUserAutograph());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnUser o) {
		return __user_id == null ? -1 : __user_id.compareTo(o.getUserId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__user_id);
		hash = 97 * hash + Objects.hashCode(this.__user_name);
		hash = 97 * hash + Objects.hashCode(this.__user_password);
		hash = 97 * hash + Objects.hashCode(this.__phone);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		hash = 97 * hash + Objects.hashCode(this.__user_file_image);
		hash = 97 * hash + Objects.hashCode(this.__professional_type_id);
		hash = 97 * hash + Objects.hashCode(this.__user_autograph);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnUser o = (BaseCnUser)obj;
		if(!Objects.equals(this.__user_id, o.getUserId())) return false;
		if(!Objects.equals(this.__user_name, o.getUserName())) return false;
		if(!Objects.equals(this.__user_password, o.getUserPassword())) return false;
		if(!Objects.equals(this.__phone, o.getPhone())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		if(!Objects.equals(this.__user_file_image, o.getUserFileImage())) return false;
		if(!Objects.equals(this.__professional_type_id, o.getProfessionalTypeId())) return false;
		if(!Objects.equals(this.__user_autograph, o.getUserAutograph())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getUserId() != null) sb.append(__wrapNumber(count++, "userId", getUserId()));
		if(getUserName() != null) sb.append(__wrapString(count++, "userName", getUserName()));
		if(getUserPassword() != null) sb.append(__wrapString(count++, "userPassword", getUserPassword()));
		if(getPhone() != null) sb.append(__wrapString(count++, "phone", getPhone()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		if(getUserFileImage() != null) sb.append(__wrapNumber(count++, "userFileImage", getUserFileImage()));
		if(getProfessionalTypeId() != null) sb.append(__wrapNumber(count++, "professionalTypeId", getProfessionalTypeId()));
		if(getUserAutograph() != null) sb.append(__wrapString(count++, "userAutograph", getUserAutograph()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getUserId() != null) res.put("userId", getUserId());
		if(getUserName() != null) res.put("userName", getUserName());
		if(getUserPassword() != null) res.put("userPassword", getUserPassword());
		if(getPhone() != null) res.put("phone", getPhone());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		if(getUserFileImage() != null) res.put("userFileImage", getUserFileImage());
		if(getProfessionalTypeId() != null) res.put("professionalTypeId", getProfessionalTypeId());
		if(getUserAutograph() != null) res.put("userAutograph", getUserAutograph());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("userId")) != null) setUserId(__getInt(val)); 
		if((val = values.get("userName")) != null) setUserName(__getString(val));
		if((val = values.get("userPassword")) != null) setUserPassword(__getString(val));
		if((val = values.get("phone")) != null) setPhone(__getString(val));
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
		if((val = values.get("userFileImage")) != null) setUserFileImage(__getInt(val)); 
		if((val = values.get("professionalTypeId")) != null) setProfessionalTypeId(__getInt(val)); 
		if((val = values.get("userAutograph")) != null) setUserAutograph(__getString(val));
	}

	protected java.lang.Integer  __user_id ;
	protected java.lang.String  __user_name ;
	protected java.lang.String  __user_password ;
	protected java.lang.String  __phone ;
	protected java.lang.Integer  __organization_id ;
	protected java.lang.Integer  __user_file_image ;
	protected java.lang.Integer  __professional_type_id ;
	protected java.lang.String  __user_autograph ;
}
