package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSubContractRemark extends GenericBase implements BaseFactory<BaseSubContractRemark>, Comparable<BaseSubContractRemark> 
{


	public static BaseSubContractRemark newInstance(){
		return new BaseSubContractRemark();
	}

	@Override
	public BaseSubContractRemark make(){
		BaseSubContractRemark b = new BaseSubContractRemark();
		return b;
	}

	public final static java.lang.String CS_SUB_CONTRACT_REMARK_ID = "sub_contract_remark_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_CONTENT_INFO = "content_info" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同id,员工编码,登记日期,子订单的备注";

	public java.lang.Integer getSubContractRemarkId() {
		return this.__sub_contract_remark_id;
	}

	public void setSubContractRemarkId( java.lang.Integer value ) {
		this.__sub_contract_remark_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.String getContentInfo() {
		return this.__content_info;
	}

	public void setContentInfo( java.lang.String value ) {
		this.__content_info = value;
	}

	public void cloneCopy(BaseSubContractRemark __bean){
		__bean.setSubContractRemarkId(getSubContractRemarkId());
		__bean.setContractId(getContractId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setContentInfo(getContentInfo());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubContractRemarkId() == null ? "" : getSubContractRemarkId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getContentInfo() == null ? "" : getContentInfo());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSubContractRemark o) {
		return __sub_contract_remark_id == null ? -1 : __sub_contract_remark_id.compareTo(o.getSubContractRemarkId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_remark_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__content_info);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSubContractRemark o = (BaseSubContractRemark)obj;
		if(!Objects.equals(this.__sub_contract_remark_id, o.getSubContractRemarkId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__content_info, o.getContentInfo())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubContractRemarkId() != null) sb.append(__wrapNumber(count++, "subContractRemarkId", getSubContractRemarkId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getContentInfo() != null) sb.append(__wrapString(count++, "contentInfo", getContentInfo()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subContractRemarkId")) != null) setSubContractRemarkId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("contentInfo")) != null) setContentInfo(__getString(val));
	}

	protected java.lang.Integer  __sub_contract_remark_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.String  __content_info ;
}
