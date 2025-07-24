package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBusinessLineRecord extends GenericBase implements BaseFactory<BaseBusinessLineRecord>, Comparable<BaseBusinessLineRecord> 
{


	public static BaseBusinessLineRecord newInstance(){
		return new BaseBusinessLineRecord();
	}

	@Override
	public BaseBusinessLineRecord make(){
		BaseBusinessLineRecord b = new BaseBusinessLineRecord();
		return b;
	}

	public final static java.lang.String CS_BUSINESS_LINE_ID = "business_line_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_BUSINESS_AMOUNT = "business_amount" ;
	public final static java.lang.String CS_BUSINESS_LINE_RECORD_ID = "business_line_record_id" ;

	public final static java.lang.String ALL_CAPTIONS = "条线编码,合同编码,条线金额,";

	public java.lang.Integer getBusinessLineId() {
		return this.__business_line_id;
	}

	public void setBusinessLineId( java.lang.Integer value ) {
		this.__business_line_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getBusinessAmount() {
		return this.__business_amount;
	}

	public void setBusinessAmount( java.math.BigDecimal value ) {
		this.__business_amount = value;
	}

	public java.lang.Integer getBusinessLineRecordId() {
		return this.__business_line_record_id;
	}

	public void setBusinessLineRecordId( java.lang.Integer value ) {
		this.__business_line_record_id = value;
	}

	public void cloneCopy(BaseBusinessLineRecord __bean){
		__bean.setBusinessLineId(getBusinessLineId());
		__bean.setContractId(getContractId());
		__bean.setBusinessAmount(getBusinessAmount());
		__bean.setBusinessLineRecordId(getBusinessLineRecordId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBusinessLineId() == null ? "" : getBusinessLineId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getBusinessAmount() == null ? "" : getBusinessAmount());
		sb.append(",");
		sb.append(getBusinessLineRecordId() == null ? "" : getBusinessLineRecordId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBusinessLineRecord o) {
		return __business_line_record_id == null ? -1 : __business_line_record_id.compareTo(o.getBusinessLineRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__business_line_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__business_amount);
		hash = 97 * hash + Objects.hashCode(this.__business_line_record_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBusinessLineRecord o = (BaseBusinessLineRecord)obj;
		if(!Objects.equals(this.__business_line_id, o.getBusinessLineId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__business_amount, o.getBusinessAmount())) return false;
		if(!Objects.equals(this.__business_line_record_id, o.getBusinessLineRecordId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBusinessLineId() != null) sb.append(__wrapNumber(count++, "businessLineId", getBusinessLineId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getBusinessAmount() != null) sb.append(__wrapDecimal(count++, "businessAmount", getBusinessAmount()));
		if(getBusinessLineRecordId() != null) sb.append(__wrapNumber(count++, "businessLineRecordId", getBusinessLineRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("businessLineId")) != null) setBusinessLineId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("businessAmount")) != null) setBusinessAmount(__getDecimal(val));  
		if((val = values.get("businessLineRecordId")) != null) setBusinessLineRecordId(__getInt(val)); 
	}

	protected java.lang.Integer  __business_line_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __business_amount ;
	protected java.lang.Integer  __business_line_record_id ;
}
