package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCodeManage extends GenericBase implements BaseFactory<BaseCodeManage>, Comparable<BaseCodeManage> 
{


	public static BaseCodeManage newInstance(){
		return new BaseCodeManage();
	}

	@Override
	public BaseCodeManage make(){
		BaseCodeManage b = new BaseCodeManage();
		return b;
	}

	public final static java.lang.String CS_CODE_MANAGE_ID = "code_manage_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_ORDER_NUM = "order_num" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,记录日期,年份,月份,编号,序列";

	public java.lang.Integer getCodeManageId() {
		return this.__code_manage_id;
	}

	public void setCodeManageId( java.lang.Integer value ) {
		this.__code_manage_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getOrderNum() {
		return this.__order_num;
	}

	public void setOrderNum( java.lang.Integer value ) {
		this.__order_num = value;
	}

	public void cloneCopy(BaseCodeManage __bean){
		__bean.setCodeManageId(getCodeManageId());
		__bean.setRecordDate(getRecordDate());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setCode(getCode());
		__bean.setOrderNum(getOrderNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCodeManageId() == null ? "" : getCodeManageId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getOrderNum() == null ? "" : getOrderNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCodeManage o) {
		return __code_manage_id == null ? -1 : __code_manage_id.compareTo(o.getCodeManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__code_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__order_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCodeManage o = (BaseCodeManage)obj;
		if(!Objects.equals(this.__code_manage_id, o.getCodeManageId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__order_num, o.getOrderNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCodeManageId() != null) sb.append(__wrapNumber(count++, "codeManageId", getCodeManageId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getOrderNum() != null) sb.append(__wrapNumber(count++, "orderNum", getOrderNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("codeManageId")) != null) setCodeManageId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("orderNum")) != null) setOrderNum(__getInt(val)); 
	}

	protected java.lang.Integer  __code_manage_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __order_num ;
}
