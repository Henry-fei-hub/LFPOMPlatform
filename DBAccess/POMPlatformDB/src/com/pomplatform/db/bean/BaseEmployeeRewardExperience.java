package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeRewardExperience extends GenericBase implements BaseFactory<BaseEmployeeRewardExperience>, Comparable<BaseEmployeeRewardExperience> 
{


	public static BaseEmployeeRewardExperience newInstance(){
		return new BaseEmployeeRewardExperience();
	}

	@Override
	public BaseEmployeeRewardExperience make(){
		BaseEmployeeRewardExperience b = new BaseEmployeeRewardExperience();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_REWARD_EXPERIENCE_ID = "employee_reward_experience_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_REWARD_NAME = "reward_name" ;
	public final static java.lang.String CS_REWARD_DESCRIPTION = "reward_description" ;
	public final static java.lang.String CS_REWARD_DATE = "reward_date" ;
	public final static java.lang.String CS_REWARD_UNIT = "reward_unit" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,名称,奖惩说明,奖惩日期,授予单位,附件";

	public java.lang.Integer getEmployeeRewardExperienceId() {
		return this.__employee_reward_experience_id;
	}

	public void setEmployeeRewardExperienceId( java.lang.Integer value ) {
		this.__employee_reward_experience_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getRewardName() {
		return this.__reward_name;
	}

	public void setRewardName( java.lang.String value ) {
		this.__reward_name = value;
	}

	public java.lang.String getRewardDescription() {
		return this.__reward_description;
	}

	public void setRewardDescription( java.lang.String value ) {
		this.__reward_description = value;
	}

	public java.util.Date getRewardDate() {
		return this.__reward_date;
	}

	public void setRewardDate( java.util.Date value ) {
		this.__reward_date = value;
	}

	public java.lang.String getRewardUnit() {
		return this.__reward_unit;
	}

	public void setRewardUnit( java.lang.String value ) {
		this.__reward_unit = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public void cloneCopy(BaseEmployeeRewardExperience __bean){
		__bean.setEmployeeRewardExperienceId(getEmployeeRewardExperienceId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRewardName(getRewardName());
		__bean.setRewardDescription(getRewardDescription());
		__bean.setRewardDate(getRewardDate());
		__bean.setRewardUnit(getRewardUnit());
		__bean.setAttachment(getAttachment());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeRewardExperienceId() == null ? "" : getEmployeeRewardExperienceId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getRewardName() == null ? "" : getRewardName());
		sb.append(",");
		sb.append(getRewardDescription() == null ? "" : getRewardDescription());
		sb.append(",");
		sb.append(getRewardDate() == null ? "" : sdf.format(getRewardDate()));
		sb.append(",");
		sb.append(getRewardUnit() == null ? "" : getRewardUnit());
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeRewardExperience o) {
		return __employee_reward_experience_id == null ? -1 : __employee_reward_experience_id.compareTo(o.getEmployeeRewardExperienceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_reward_experience_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__reward_name);
		hash = 97 * hash + Objects.hashCode(this.__reward_description);
		hash = 97 * hash + Objects.hashCode(this.__reward_date);
		hash = 97 * hash + Objects.hashCode(this.__reward_unit);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeRewardExperience o = (BaseEmployeeRewardExperience)obj;
		if(!Objects.equals(this.__employee_reward_experience_id, o.getEmployeeRewardExperienceId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__reward_name, o.getRewardName())) return false;
		if(!Objects.equals(this.__reward_description, o.getRewardDescription())) return false;
		if(!Objects.equals(this.__reward_date, o.getRewardDate())) return false;
		if(!Objects.equals(this.__reward_unit, o.getRewardUnit())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeRewardExperienceId() != null) sb.append(__wrapNumber(count++, "employeeRewardExperienceId", getEmployeeRewardExperienceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRewardName() != null) sb.append(__wrapString(count++, "rewardName", getRewardName()));
		if(getRewardDescription() != null) sb.append(__wrapString(count++, "rewardDescription", getRewardDescription()));
		if(getRewardDate() != null) sb.append(__wrapDate(count++, "rewardDate", getRewardDate()));
		if(getRewardUnit() != null) sb.append(__wrapString(count++, "rewardUnit", getRewardUnit()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeRewardExperienceId")) != null) setEmployeeRewardExperienceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("rewardName")) != null) setRewardName(__getString(val));
		if((val = values.get("rewardDescription")) != null) setRewardDescription(__getString(val));
		if((val = values.get("rewardDate")) != null) setRewardDate(__getDate(val)); 
		if((val = values.get("rewardUnit")) != null) setRewardUnit(__getString(val));
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
	}

	protected java.lang.Integer  __employee_reward_experience_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __reward_name ;
	protected java.lang.String  __reward_description ;
	protected java.util.Date  __reward_date ;
	protected java.lang.String  __reward_unit ;
	protected java.lang.String  __attachment ;
}
