package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFileNumber extends GenericBase implements BaseFactory<BaseFileNumber>, Comparable<BaseFileNumber> 
{


	public static BaseFileNumber newInstance(){
		return new BaseFileNumber();
	}

	@Override
	public BaseFileNumber make(){
		BaseFileNumber b = new BaseFileNumber();
		return b;
	}

	public final static java.lang.String CS_FILE_NUMBER_ID = "file_number_id" ;
	public final static java.lang.String CS_FILE_NUMBER_MAX = "file_number_max" ;

	public final static java.lang.String ALL_CAPTIONS = ",文件号";

	public java.lang.Integer getFileNumberId() {
		return this.__file_number_id;
	}

	public void setFileNumberId( java.lang.Integer value ) {
		this.__file_number_id = value;
	}

	public java.lang.Integer getFileNumberMax() {
		return this.__file_number_max;
	}

	public void setFileNumberMax( java.lang.Integer value ) {
		this.__file_number_max = value;
	}

	public void cloneCopy(BaseFileNumber __bean){
		__bean.setFileNumberId(getFileNumberId());
		__bean.setFileNumberMax(getFileNumberMax());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileNumberId() == null ? "" : getFileNumberId());
		sb.append(",");
		sb.append(getFileNumberMax() == null ? "" : getFileNumberMax());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFileNumber o) {
		return __file_number_id == null ? -1 : __file_number_id.compareTo(o.getFileNumberId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_number_id);
		hash = 97 * hash + Objects.hashCode(this.__file_number_max);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFileNumber o = (BaseFileNumber)obj;
		if(!Objects.equals(this.__file_number_id, o.getFileNumberId())) return false;
		if(!Objects.equals(this.__file_number_max, o.getFileNumberMax())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileNumberId() != null) sb.append(__wrapNumber(count++, "fileNumberId", getFileNumberId()));
		if(getFileNumberMax() != null) sb.append(__wrapNumber(count++, "fileNumberMax", getFileNumberMax()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileNumberId")) != null) setFileNumberId(__getInt(val)); 
		if((val = values.get("fileNumberMax")) != null) setFileNumberMax(__getInt(val)); 
	}

	protected java.lang.Integer  __file_number_id ;
	protected java.lang.Integer  __file_number_max ;
}
