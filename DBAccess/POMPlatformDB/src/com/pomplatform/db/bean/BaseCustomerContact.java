package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCustomerContact extends GenericBase implements BaseFactory<BaseCustomerContact>, Comparable<BaseCustomerContact> 
{


	public static BaseCustomerContact newInstance(){
		return new BaseCustomerContact();
	}

	@Override
	public BaseCustomerContact make(){
		BaseCustomerContact b = new BaseCustomerContact();
		return b;
	}

	public final static java.lang.String CS_CUSTOMER_CONTACT_ID = "customer_contact_id" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_TELEPHONE = "telephone" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_BIRTH_DATE = "birth_date" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_EMPLOYEE_TYPE = "employee_type" ;
	public final static java.lang.String CS_PERSONAL_INFLUENCE = "personal_influence" ;
	public final static java.lang.String CS_COOPERATION_RELATION = "cooperation_relation" ;
	public final static java.lang.String CS_COOPERATION_ATTITUDE = "cooperation_attitude" ;
	public final static java.lang.String CS_WORK_ADDRESS = "work_address" ;
	public final static java.lang.String CS_GIFT_RECORD = "gift_record" ;
	public final static java.lang.String CS_COMPLAINT_ADVICE = "complaint_advice" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,客户Id,客户姓名,职位,移动电话,商务座机,邮箱,生日日期,性别(对应字典表12),2其他联系人)(对应于字典表146),3弱)(对应于字典表147),2未接洽过)(对应于字典表148),3反对)(对应于字典表149),办公地址,礼物记录,投诉&建议,操作人,操作时间,备注";

	public java.lang.Integer getCustomerContactId() {
		return this.__customer_contact_id;
	}

	public void setCustomerContactId( java.lang.Integer value ) {
		this.__customer_contact_id = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
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

	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
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

	public java.lang.Integer getEmployeeType() {
		return this.__employee_type;
	}

	public void setEmployeeType( java.lang.Integer value ) {
		this.__employee_type = value;
	}

	public java.lang.Integer getPersonalInfluence() {
		return this.__personal_influence;
	}

	public void setPersonalInfluence( java.lang.Integer value ) {
		this.__personal_influence = value;
	}

	public java.lang.Integer getCooperationRelation() {
		return this.__cooperation_relation;
	}

	public void setCooperationRelation( java.lang.Integer value ) {
		this.__cooperation_relation = value;
	}

	public java.lang.Integer getCooperationAttitude() {
		return this.__cooperation_attitude;
	}

	public void setCooperationAttitude( java.lang.Integer value ) {
		this.__cooperation_attitude = value;
	}

	public java.lang.String getWorkAddress() {
		return this.__work_address;
	}

	public void setWorkAddress( java.lang.String value ) {
		this.__work_address = value;
	}

	public java.lang.String getGiftRecord() {
		return this.__gift_record;
	}

	public void setGiftRecord( java.lang.String value ) {
		this.__gift_record = value;
	}

	public java.lang.String getComplaintAdvice() {
		return this.__complaint_advice;
	}

	public void setComplaintAdvice( java.lang.String value ) {
		this.__complaint_advice = value;
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

	public void cloneCopy(BaseCustomerContact __bean){
		__bean.setCustomerContactId(getCustomerContactId());
		__bean.setCustomerId(getCustomerId());
		__bean.setName(getName());
		__bean.setGrade(getGrade());
		__bean.setTelephone(getTelephone());
		__bean.setMobile(getMobile());
		__bean.setEmail(getEmail());
		__bean.setBirthDate(getBirthDate());
		__bean.setGender(getGender());
		__bean.setEmployeeType(getEmployeeType());
		__bean.setPersonalInfluence(getPersonalInfluence());
		__bean.setCooperationRelation(getCooperationRelation());
		__bean.setCooperationAttitude(getCooperationAttitude());
		__bean.setWorkAddress(getWorkAddress());
		__bean.setGiftRecord(getGiftRecord());
		__bean.setComplaintAdvice(getComplaintAdvice());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCustomerContactId() == null ? "" : getCustomerContactId());
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getGrade() == null ? "" : getGrade());
		sb.append(",");
		sb.append(getTelephone() == null ? "" : getTelephone());
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getBirthDate() == null ? "" : sdf.format(getBirthDate()));
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		sb.append(getEmployeeType() == null ? "" : getEmployeeType());
		sb.append(",");
		sb.append(getPersonalInfluence() == null ? "" : getPersonalInfluence());
		sb.append(",");
		sb.append(getCooperationRelation() == null ? "" : getCooperationRelation());
		sb.append(",");
		sb.append(getCooperationAttitude() == null ? "" : getCooperationAttitude());
		sb.append(",");
		sb.append(getWorkAddress() == null ? "" : getWorkAddress());
		sb.append(",");
		sb.append(getGiftRecord() == null ? "" : getGiftRecord());
		sb.append(",");
		sb.append(getComplaintAdvice() == null ? "" : getComplaintAdvice());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCustomerContact o) {
		return __customer_contact_id == null ? -1 : __customer_contact_id.compareTo(o.getCustomerContactId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__customer_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__telephone);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__birth_date);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__employee_type);
		hash = 97 * hash + Objects.hashCode(this.__personal_influence);
		hash = 97 * hash + Objects.hashCode(this.__cooperation_relation);
		hash = 97 * hash + Objects.hashCode(this.__cooperation_attitude);
		hash = 97 * hash + Objects.hashCode(this.__work_address);
		hash = 97 * hash + Objects.hashCode(this.__gift_record);
		hash = 97 * hash + Objects.hashCode(this.__complaint_advice);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCustomerContact o = (BaseCustomerContact)obj;
		if(!Objects.equals(this.__customer_contact_id, o.getCustomerContactId())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__telephone, o.getTelephone())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__birth_date, o.getBirthDate())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__employee_type, o.getEmployeeType())) return false;
		if(!Objects.equals(this.__personal_influence, o.getPersonalInfluence())) return false;
		if(!Objects.equals(this.__cooperation_relation, o.getCooperationRelation())) return false;
		if(!Objects.equals(this.__cooperation_attitude, o.getCooperationAttitude())) return false;
		if(!Objects.equals(this.__work_address, o.getWorkAddress())) return false;
		if(!Objects.equals(this.__gift_record, o.getGiftRecord())) return false;
		if(!Objects.equals(this.__complaint_advice, o.getComplaintAdvice())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCustomerContactId() != null) sb.append(__wrapNumber(count++, "customerContactId", getCustomerContactId()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getTelephone() != null) sb.append(__wrapString(count++, "telephone", getTelephone()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getBirthDate() != null) sb.append(__wrapDate(count++, "birthDate", getBirthDate()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getEmployeeType() != null) sb.append(__wrapNumber(count++, "employeeType", getEmployeeType()));
		if(getPersonalInfluence() != null) sb.append(__wrapNumber(count++, "personalInfluence", getPersonalInfluence()));
		if(getCooperationRelation() != null) sb.append(__wrapNumber(count++, "cooperationRelation", getCooperationRelation()));
		if(getCooperationAttitude() != null) sb.append(__wrapNumber(count++, "cooperationAttitude", getCooperationAttitude()));
		if(getWorkAddress() != null) sb.append(__wrapString(count++, "workAddress", getWorkAddress()));
		if(getGiftRecord() != null) sb.append(__wrapString(count++, "giftRecord", getGiftRecord()));
		if(getComplaintAdvice() != null) sb.append(__wrapString(count++, "complaintAdvice", getComplaintAdvice()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("customerContactId")) != null) setCustomerContactId(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("telephone")) != null) setTelephone(__getString(val));
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("birthDate")) != null) setBirthDate(__getDate(val)); 
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("employeeType")) != null) setEmployeeType(__getInt(val)); 
		if((val = values.get("personalInfluence")) != null) setPersonalInfluence(__getInt(val)); 
		if((val = values.get("cooperationRelation")) != null) setCooperationRelation(__getInt(val)); 
		if((val = values.get("cooperationAttitude")) != null) setCooperationAttitude(__getInt(val)); 
		if((val = values.get("workAddress")) != null) setWorkAddress(__getString(val));
		if((val = values.get("giftRecord")) != null) setGiftRecord(__getString(val));
		if((val = values.get("complaintAdvice")) != null) setComplaintAdvice(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __customer_contact_id ;
	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __name ;
	protected java.lang.String  __grade ;
	protected java.lang.String  __telephone ;
	protected java.lang.String  __mobile ;
	protected java.lang.String  __email ;
	protected java.util.Date  __birth_date ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __employee_type ;
	protected java.lang.Integer  __personal_influence ;
	protected java.lang.Integer  __cooperation_relation ;
	protected java.lang.Integer  __cooperation_attitude ;
	protected java.lang.String  __work_address ;
	protected java.lang.String  __gift_record ;
	protected java.lang.String  __complaint_advice ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
