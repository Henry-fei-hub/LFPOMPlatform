package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCustomerResource extends GenericBase implements BaseFactory<BaseCustomerResource>, Comparable<BaseCustomerResource> 
{


	public static BaseCustomerResource newInstance(){
		return new BaseCustomerResource();
	}

	@Override
	public BaseCustomerResource make(){
		BaseCustomerResource b = new BaseCustomerResource();
		return b;
	}

	public final static java.lang.String CS_CUSTOMER_RESOURCE_ID = "customer_resource_id" ;
	public final static java.lang.String CS_COMPANY_NAME = "company_name" ;
	public final static java.lang.String CS_COMPANY_ADDRESS = "company_address" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_TELEPHONE = "telephone" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_BIRTH_DATE = "birth_date" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,公司名称,公司地址,客户姓名,职位,电话,邮箱,生日日期,性别(对应字典表12),操作人,操作时间,备注";

	public java.lang.Integer getCustomerResourceId() {
		return this.__customer_resource_id;
	}

	public void setCustomerResourceId( java.lang.Integer value ) {
		this.__customer_resource_id = value;
	}

	public java.lang.String getCompanyName() {
		return this.__company_name;
	}

	public void setCompanyName( java.lang.String value ) {
		this.__company_name = value;
	}

	public java.lang.String getCompanyAddress() {
		return this.__company_address;
	}

	public void setCompanyAddress( java.lang.String value ) {
		this.__company_address = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getGrade() {
		return this.__grade;
	}

	public void setGrade( java.lang.String value ) {
		this.__grade = value;
	}

	public java.lang.String getTelephone() {
		return this.__telephone;
	}

	public void setTelephone( java.lang.String value ) {
		this.__telephone = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.util.Date getBirthDate() {
		return this.__birth_date;
	}

	public void setBirthDate( java.util.Date value ) {
		this.__birth_date = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseCustomerResource __bean){
		__bean.setCustomerResourceId(getCustomerResourceId());
		__bean.setCompanyName(getCompanyName());
		__bean.setCompanyAddress(getCompanyAddress());
		__bean.setName(getName());
		__bean.setGrade(getGrade());
		__bean.setTelephone(getTelephone());
		__bean.setEmail(getEmail());
		__bean.setBirthDate(getBirthDate());
		__bean.setGender(getGender());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCustomerResourceId() == null ? "" : getCustomerResourceId());
		sb.append(",");
		sb.append(getCompanyName() == null ? "" : getCompanyName());
		sb.append(",");
		sb.append(getCompanyAddress() == null ? "" : getCompanyAddress());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getGrade() == null ? "" : getGrade());
		sb.append(",");
		sb.append(getTelephone() == null ? "" : getTelephone());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getBirthDate() == null ? "" : sdf.format(getBirthDate()));
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCustomerResource o) {
		return __customer_resource_id == null ? -1 : __customer_resource_id.compareTo(o.getCustomerResourceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__customer_resource_id);
		hash = 97 * hash + Objects.hashCode(this.__company_name);
		hash = 97 * hash + Objects.hashCode(this.__company_address);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__telephone);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__birth_date);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCustomerResource o = (BaseCustomerResource)obj;
		if(!Objects.equals(this.__customer_resource_id, o.getCustomerResourceId())) return false;
		if(!Objects.equals(this.__company_name, o.getCompanyName())) return false;
		if(!Objects.equals(this.__company_address, o.getCompanyAddress())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__telephone, o.getTelephone())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__birth_date, o.getBirthDate())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCustomerResourceId() != null) sb.append(__wrapNumber(count++, "customerResourceId", getCustomerResourceId()));
		if(getCompanyName() != null) sb.append(__wrapString(count++, "companyName", getCompanyName()));
		if(getCompanyAddress() != null) sb.append(__wrapString(count++, "companyAddress", getCompanyAddress()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getTelephone() != null) sb.append(__wrapString(count++, "telephone", getTelephone()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getBirthDate() != null) sb.append(__wrapDate(count++, "birthDate", getBirthDate()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("customerResourceId")) != null) setCustomerResourceId(__getInt(val)); 
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
		if((val = values.get("companyAddress")) != null) setCompanyAddress(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("telephone")) != null) setTelephone(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("birthDate")) != null) setBirthDate(__getDate(val)); 
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __customer_resource_id ;
	protected java.lang.String  __company_name ;
	protected java.lang.String  __company_address ;
	protected java.lang.String  __name ;
	protected java.lang.String  __grade ;
	protected java.lang.String  __telephone ;
	protected java.lang.String  __email ;
	protected java.util.Date  __birth_date ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
