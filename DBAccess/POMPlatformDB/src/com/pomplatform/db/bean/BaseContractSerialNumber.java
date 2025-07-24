package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractSerialNumber extends GenericBase implements BaseFactory<BaseContractSerialNumber>, Comparable<BaseContractSerialNumber> 
{


	public static BaseContractSerialNumber newInstance(){
		return new BaseContractSerialNumber();
	}

	@Override
	public BaseContractSerialNumber make(){
		BaseContractSerialNumber b = new BaseContractSerialNumber();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_SERIAL_NUMBER_ID = "contract_serial_number_id" ;
	public final static java.lang.String CS_PRODUCE_DATE = "produce_date" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_SIGNING_COMPANY_NAME = "signing_company_name" ;

	public final static java.lang.String ALL_CAPTIONS = "流水号编码,流水号产生的日期,流水号,签约公司的代号码";

	public java.lang.Integer getContractSerialNumberId() {
		return this.__contract_serial_number_id;
	}

	public void setContractSerialNumberId( java.lang.Integer value ) {
		this.__contract_serial_number_id = value;
	}

	public java.util.Date getProduceDate() {
		return this.__produce_date;
	}

	public void setProduceDate( java.util.Date value ) {
		this.__produce_date = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	public java.lang.Integer getSigningCompanyName() {
		return this.__signing_company_name;
	}

	public void setSigningCompanyName( java.lang.Integer value ) {
		this.__signing_company_name = value;
	}

	public void cloneCopy(BaseContractSerialNumber __bean){
		__bean.setContractSerialNumberId(getContractSerialNumberId());
		__bean.setProduceDate(getProduceDate());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setSigningCompanyName(getSigningCompanyName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractSerialNumberId() == null ? "" : getContractSerialNumberId());
		sb.append(",");
		sb.append(getProduceDate() == null ? "" : sdf.format(getProduceDate()));
		sb.append(",");
		sb.append(getSerialNumber() == null ? "" : getSerialNumber());
		sb.append(",");
		String strSigningCompanyName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompanyName()));
		sb.append(strSigningCompanyName == null ? "" : strSigningCompanyName);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractSerialNumber o) {
		return __contract_serial_number_id == null ? -1 : __contract_serial_number_id.compareTo(o.getContractSerialNumberId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_serial_number_id);
		hash = 97 * hash + Objects.hashCode(this.__produce_date);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__signing_company_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractSerialNumber o = (BaseContractSerialNumber)obj;
		if(!Objects.equals(this.__contract_serial_number_id, o.getContractSerialNumberId())) return false;
		if(!Objects.equals(this.__produce_date, o.getProduceDate())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__signing_company_name, o.getSigningCompanyName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractSerialNumberId() != null) sb.append(__wrapNumber(count++, "contractSerialNumberId", getContractSerialNumberId()));
		if(getProduceDate() != null) sb.append(__wrapDate(count++, "produceDate", getProduceDate()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(count++, "serialNumber", getSerialNumber()));
		if(getSigningCompanyName() != null) sb.append(__wrapNumber(count++, "signingCompanyName", getSigningCompanyName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractSerialNumberId")) != null) setContractSerialNumberId(__getInt(val)); 
		if((val = values.get("produceDate")) != null) setProduceDate(__getDate(val)); 
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val)); 
		if((val = values.get("signingCompanyName")) != null) setSigningCompanyName(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_serial_number_id ;
	protected java.util.Date  __produce_date ;
	protected java.lang.Integer  __serial_number ;
	protected java.lang.Integer  __signing_company_name ;
}
