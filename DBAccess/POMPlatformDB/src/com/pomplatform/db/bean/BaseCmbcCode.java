package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCmbcCode extends GenericBase implements BaseFactory<BaseCmbcCode>, Comparable<BaseCmbcCode> 
{


	public static BaseCmbcCode newInstance(){
		return new BaseCmbcCode();
	}

	@Override
	public BaseCmbcCode make(){
		BaseCmbcCode b = new BaseCmbcCode();
		return b;
	}

	public final static java.lang.String CS_CMBC_CODE_ID = "cmbc_code_id" ;
	public final static java.lang.String CS_CODE_NAME = "code_name" ;
	public final static java.lang.String CS_CODE_ID = "code_id" ;
	public final static java.lang.String CS_CODE_VALUE = "code_value" ;
	public final static java.lang.String CS_CODE_REMARK = "code_remark" ;

	public final static java.lang.String ALL_CAPTIONS = ",,,,";

	public java.lang.Integer getCmbcCodeId() {
		return this.__cmbc_code_id;
	}

	public void setCmbcCodeId( java.lang.Integer value ) {
		this.__cmbc_code_id = value;
	}

	public java.lang.String getCodeName() {
		return this.__code_name;
	}

	public void setCodeName( java.lang.String value ) {
		this.__code_name = value;
	}

	public java.lang.String getCodeId() {
		return this.__code_id;
	}

	public void setCodeId( java.lang.String value ) {
		this.__code_id = value;
	}

	public java.lang.String getCodeValue() {
		return this.__code_value;
	}

	public void setCodeValue( java.lang.String value ) {
		this.__code_value = value;
	}

	public java.lang.String getCodeRemark() {
		return this.__code_remark;
	}

	public void setCodeRemark( java.lang.String value ) {
		this.__code_remark = value;
	}

	public void cloneCopy(BaseCmbcCode __bean){
		__bean.setCmbcCodeId(getCmbcCodeId());
		__bean.setCodeName(getCodeName());
		__bean.setCodeId(getCodeId());
		__bean.setCodeValue(getCodeValue());
		__bean.setCodeRemark(getCodeRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCmbcCodeId() == null ? "" : getCmbcCodeId());
		sb.append(",");
		sb.append(getCodeName() == null ? "" : getCodeName());
		sb.append(",");
		sb.append(getCodeId() == null ? "" : getCodeId());
		sb.append(",");
		sb.append(getCodeValue() == null ? "" : getCodeValue());
		sb.append(",");
		sb.append(getCodeRemark() == null ? "" : getCodeRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCmbcCode o) {
		return __cmbc_code_id == null ? -1 : __cmbc_code_id.compareTo(o.getCmbcCodeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cmbc_code_id);
		hash = 97 * hash + Objects.hashCode(this.__code_name);
		hash = 97 * hash + Objects.hashCode(this.__code_id);
		hash = 97 * hash + Objects.hashCode(this.__code_value);
		hash = 97 * hash + Objects.hashCode(this.__code_remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCmbcCode o = (BaseCmbcCode)obj;
		if(!Objects.equals(this.__cmbc_code_id, o.getCmbcCodeId())) return false;
		if(!Objects.equals(this.__code_name, o.getCodeName())) return false;
		if(!Objects.equals(this.__code_id, o.getCodeId())) return false;
		if(!Objects.equals(this.__code_value, o.getCodeValue())) return false;
		if(!Objects.equals(this.__code_remark, o.getCodeRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCmbcCodeId() != null) sb.append(__wrapNumber(count++, "cmbcCodeId", getCmbcCodeId()));
		if(getCodeName() != null) sb.append(__wrapString(count++, "codeName", getCodeName()));
		if(getCodeId() != null) sb.append(__wrapString(count++, "codeId", getCodeId()));
		if(getCodeValue() != null) sb.append(__wrapString(count++, "codeValue", getCodeValue()));
		if(getCodeRemark() != null) sb.append(__wrapString(count++, "codeRemark", getCodeRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cmbcCodeId")) != null) setCmbcCodeId(__getInt(val)); 
		if((val = values.get("codeName")) != null) setCodeName(__getString(val));
		if((val = values.get("codeId")) != null) setCodeId(__getString(val));
		if((val = values.get("codeValue")) != null) setCodeValue(__getString(val));
		if((val = values.get("codeRemark")) != null) setCodeRemark(__getString(val));
	}

	protected java.lang.Integer  __cmbc_code_id ;
	protected java.lang.String  __code_name ;
	protected java.lang.String  __code_id ;
	protected java.lang.String  __code_value ;
	protected java.lang.String  __code_remark ;
}
