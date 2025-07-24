package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAttendanceRule extends GenericBase implements BaseFactory<BaseAttendanceRule>, Comparable<BaseAttendanceRule> 
{


	public static BaseAttendanceRule newInstance(){
		return new BaseAttendanceRule();
	}

	@Override
	public BaseAttendanceRule make(){
		BaseAttendanceRule b = new BaseAttendanceRule();
		return b;
	}

	public final static java.lang.String CS_ATTENDANCE_RULE_ID = "attendance_rule_id" ;
	public final static java.lang.String CS_RULE_NAME = "rule_name" ;
	public final static java.lang.String CS_RULE_TYPE = "rule_type" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,考勤规则名称,考勤规则类型1按时间段算可自动调休工时,是否有效,备注";

	public java.lang.Integer getAttendanceRuleId() {
		return this.__attendance_rule_id;
	}

	public void setAttendanceRuleId( java.lang.Integer value ) {
		this.__attendance_rule_id = value;
	}

	public java.lang.String getRuleName() {
		return this.__rule_name;
	}

	public void setRuleName( java.lang.String value ) {
		this.__rule_name = value;
	}

	public java.lang.Integer getRuleType() {
		return this.__rule_type;
	}

	public void setRuleType( java.lang.Integer value ) {
		this.__rule_type = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseAttendanceRule __bean){
		__bean.setAttendanceRuleId(getAttendanceRuleId());
		__bean.setRuleName(getRuleName());
		__bean.setRuleType(getRuleType());
		__bean.setIsEnable(getIsEnable());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttendanceRuleId() == null ? "" : getAttendanceRuleId());
		sb.append(",");
		sb.append(getRuleName() == null ? "" : getRuleName());
		sb.append(",");
		sb.append(getRuleType() == null ? "" : getRuleType());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceRule o) {
		return __attendance_rule_id == null ? -1 : __attendance_rule_id.compareTo(o.getAttendanceRuleId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attendance_rule_id);
		hash = 97 * hash + Objects.hashCode(this.__rule_name);
		hash = 97 * hash + Objects.hashCode(this.__rule_type);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceRule o = (BaseAttendanceRule)obj;
		if(!Objects.equals(this.__attendance_rule_id, o.getAttendanceRuleId())) return false;
		if(!Objects.equals(this.__rule_name, o.getRuleName())) return false;
		if(!Objects.equals(this.__rule_type, o.getRuleType())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttendanceRuleId() != null) sb.append(__wrapNumber(count++, "attendanceRuleId", getAttendanceRuleId()));
		if(getRuleName() != null) sb.append(__wrapString(count++, "ruleName", getRuleName()));
		if(getRuleType() != null) sb.append(__wrapNumber(count++, "ruleType", getRuleType()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getAttendanceRuleId() != null) res.put("attendanceRuleId", getAttendanceRuleId());
		if(getRuleName() != null) res.put("ruleName", getRuleName());
		if(getRuleType() != null) res.put("ruleType", getRuleType());
		if(getIsEnable() != null) res.put("isEnable", getIsEnable());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attendanceRuleId")) != null) setAttendanceRuleId(__getInt(val)); 
		if((val = values.get("ruleName")) != null) setRuleName(__getString(val));
		if((val = values.get("ruleType")) != null) setRuleType(__getInt(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __attendance_rule_id ;
	protected java.lang.String  __rule_name ;
	protected java.lang.Integer  __rule_type ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.String  __remark ;
}
