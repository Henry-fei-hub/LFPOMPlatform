package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGoodsReceive extends GenericBase implements BaseFactory<BaseGoodsReceive>, Comparable<BaseGoodsReceive> 
{


	public static BaseGoodsReceive newInstance(){
		return new BaseGoodsReceive();
	}

	@Override
	public BaseGoodsReceive make(){
		BaseGoodsReceive b = new BaseGoodsReceive();
		return b;
	}

	public final static java.lang.String CS_GOODS_RECEIVE_ID = "goods_receive_id" ;
	public final static java.lang.String CS_SUBJECT = "subject" ;
	public final static java.lang.String CS_RECEIVE_DATE = "receive_date" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COUNT = "count" ;
	public final static java.lang.String CS_CREATE_PERSON_ID = "create_person_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_FILE_MANAGE_ID = "file_manage_id" ;
	public final static java.lang.String CS_GOODS_DETAIL = "goods_detail" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主题,日期,部门编码,物品数量,创建人编码,创建时间,文件管理编码,物品详情";

	public java.lang.Integer getGoodsReceiveId() {
		return this.__goods_receive_id;
	}

	public void setGoodsReceiveId( java.lang.Integer value ) {
		this.__goods_receive_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject;
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
	}

	public java.util.Date getReceiveDate() {
		return this.__receive_date;
	}

	public void setReceiveDate( java.util.Date value ) {
		this.__receive_date = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public java.lang.Integer getCreatePersonId() {
		return this.__create_person_id;
	}

	public void setCreatePersonId( java.lang.Integer value ) {
		this.__create_person_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getFileManageId() {
		return this.__file_manage_id;
	}

	public void setFileManageId( java.lang.Integer value ) {
		this.__file_manage_id = value;
	}

	public java.lang.String getGoodsDetail() {
		return this.__goods_detail;
	}

	public void setGoodsDetail( java.lang.String value ) {
		this.__goods_detail = value;
	}

	public void cloneCopy(BaseGoodsReceive __bean){
		__bean.setGoodsReceiveId(getGoodsReceiveId());
		__bean.setSubject(getSubject());
		__bean.setReceiveDate(getReceiveDate());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCount(getCount());
		__bean.setCreatePersonId(getCreatePersonId());
		__bean.setCreateTime(getCreateTime());
		__bean.setFileManageId(getFileManageId());
		__bean.setGoodsDetail(getGoodsDetail());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getGoodsReceiveId() == null ? "" : getGoodsReceiveId());
		sb.append(",");
		sb.append(getSubject() == null ? "" : getSubject());
		sb.append(",");
		sb.append(getReceiveDate() == null ? "" : sdf.format(getReceiveDate()));
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getCreatePersonId() == null ? "" : getCreatePersonId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getFileManageId() == null ? "" : getFileManageId());
		sb.append(",");
		sb.append(getGoodsDetail() == null ? "" : getGoodsDetail());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGoodsReceive o) {
		return __goods_receive_id == null ? -1 : __goods_receive_id.compareTo(o.getGoodsReceiveId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__goods_receive_id);
		hash = 97 * hash + Objects.hashCode(this.__subject);
		hash = 97 * hash + Objects.hashCode(this.__receive_date);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__create_person_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__file_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__goods_detail);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGoodsReceive o = (BaseGoodsReceive)obj;
		if(!Objects.equals(this.__goods_receive_id, o.getGoodsReceiveId())) return false;
		if(!Objects.equals(this.__subject, o.getSubject())) return false;
		if(!Objects.equals(this.__receive_date, o.getReceiveDate())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__create_person_id, o.getCreatePersonId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__file_manage_id, o.getFileManageId())) return false;
		if(!Objects.equals(this.__goods_detail, o.getGoodsDetail())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getGoodsReceiveId() != null) sb.append(__wrapNumber(count++, "goodsReceiveId", getGoodsReceiveId()));
		if(getSubject() != null) sb.append(__wrapString(count++, "subject", getSubject()));
		if(getReceiveDate() != null) sb.append(__wrapDate(count++, "receiveDate", getReceiveDate()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getCreatePersonId() != null) sb.append(__wrapNumber(count++, "createPersonId", getCreatePersonId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getFileManageId() != null) sb.append(__wrapNumber(count++, "fileManageId", getFileManageId()));
		if(getGoodsDetail() != null) sb.append(__wrapString(count++, "goodsDetail", getGoodsDetail()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("goodsReceiveId")) != null) setGoodsReceiveId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("receiveDate")) != null) setReceiveDate(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("createPersonId")) != null) setCreatePersonId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("fileManageId")) != null) setFileManageId(__getInt(val)); 
		if((val = values.get("goodsDetail")) != null) setGoodsDetail(__getString(val));
	}

	protected java.lang.Integer  __goods_receive_id ;
	protected java.lang.String  __subject ;
	protected java.util.Date  __receive_date ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __count ;
	protected java.lang.Integer  __create_person_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __file_manage_id ;
	protected java.lang.String  __goods_detail ;
}
