package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBusinessStateRecord extends GenericBase implements BaseFactory<BaseBusinessStateRecord>, Comparable<BaseBusinessStateRecord> 
{


	public static BaseBusinessStateRecord newInstance(){
		return new BaseBusinessStateRecord();
	}

	@Override
	public BaseBusinessStateRecord make(){
		BaseBusinessStateRecord b = new BaseBusinessStateRecord();
		return b;
	}

	public final static java.lang.String CS_BUSINESS_STATE_RECORD_ID = "business_state_record_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_BUSINESS_CODE = "business_code" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_BEFORE_CONTRACT_TOTAL = "before_contract_total" ;
	public final static java.lang.String CS_BUSINESS_INTEGRAL = "business_integral" ;
	public final static java.lang.String CS_ACCOUNT_WEIGHT_RECORD_ID = "account_weight_record_id" ;
	public final static java.lang.String CS_SIGNING_COMPANY = "signing_company" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编码,业态编号,业态名称,修改前合同总价,总金额,业态类型,签约公司,操作人,操作时间";

	public java.lang.Integer getBusinessStateRecordId() {
		return this.__business_state_record_id;
	}

	public void setBusinessStateRecordId( java.lang.Integer value ) {
		this.__business_state_record_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getBusinessCode() {
		return this.__business_code;
	}

	public void setBusinessCode( java.lang.String value ) {
		this.__business_code = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.math.BigDecimal getBeforeContractTotal() {
		return this.__before_contract_total;
	}

	public void setBeforeContractTotal( java.math.BigDecimal value ) {
		this.__before_contract_total = value;
	}

	public java.math.BigDecimal getBusinessIntegral() {
		return this.__business_integral;
	}

	public void setBusinessIntegral( java.math.BigDecimal value ) {
		this.__business_integral = value;
	}

	public java.lang.Integer getAccountWeightRecordId() {
		return this.__account_weight_record_id;
	}

	public void setAccountWeightRecordId( java.lang.Integer value ) {
		this.__account_weight_record_id = value;
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
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

	public void cloneCopy(BaseBusinessStateRecord __bean){
		__bean.setBusinessStateRecordId(getBusinessStateRecordId());
		__bean.setContractId(getContractId());
		__bean.setBusinessCode(getBusinessCode());
		__bean.setBusinessName(getBusinessName());
		__bean.setBeforeContractTotal(getBeforeContractTotal());
		__bean.setBusinessIntegral(getBusinessIntegral());
		__bean.setAccountWeightRecordId(getAccountWeightRecordId());
		__bean.setSigningCompany(getSigningCompany());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBusinessStateRecordId() == null ? "" : getBusinessStateRecordId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getBusinessCode() == null ? "" : getBusinessCode());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getBeforeContractTotal() == null ? "" : getBeforeContractTotal());
		sb.append(",");
		sb.append(getBusinessIntegral() == null ? "" : getBusinessIntegral());
		sb.append(",");
		sb.append(getAccountWeightRecordId() == null ? "" : getAccountWeightRecordId());
		sb.append(",");
		String strSigningCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompany()));
		sb.append(strSigningCompany == null ? "" : strSigningCompany);
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBusinessStateRecord o) {
		return __business_state_record_id == null ? -1 : __business_state_record_id.compareTo(o.getBusinessStateRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__business_state_record_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__business_code);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__before_contract_total);
		hash = 97 * hash + Objects.hashCode(this.__business_integral);
		hash = 97 * hash + Objects.hashCode(this.__account_weight_record_id);
		hash = 97 * hash + Objects.hashCode(this.__signing_company);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBusinessStateRecord o = (BaseBusinessStateRecord)obj;
		if(!Objects.equals(this.__business_state_record_id, o.getBusinessStateRecordId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__business_code, o.getBusinessCode())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__before_contract_total, o.getBeforeContractTotal())) return false;
		if(!Objects.equals(this.__business_integral, o.getBusinessIntegral())) return false;
		if(!Objects.equals(this.__account_weight_record_id, o.getAccountWeightRecordId())) return false;
		if(!Objects.equals(this.__signing_company, o.getSigningCompany())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBusinessStateRecordId() != null) sb.append(__wrapNumber(count++, "businessStateRecordId", getBusinessStateRecordId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getBusinessCode() != null) sb.append(__wrapString(count++, "businessCode", getBusinessCode()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getBeforeContractTotal() != null) sb.append(__wrapDecimal(count++, "beforeContractTotal", getBeforeContractTotal()));
		if(getBusinessIntegral() != null) sb.append(__wrapDecimal(count++, "businessIntegral", getBusinessIntegral()));
		if(getAccountWeightRecordId() != null) sb.append(__wrapNumber(count++, "accountWeightRecordId", getAccountWeightRecordId()));
		if(getSigningCompany() != null) sb.append(__wrapNumber(count++, "signingCompany", getSigningCompany()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("businessStateRecordId")) != null) setBusinessStateRecordId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("businessCode")) != null) setBusinessCode(__getString(val));
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("beforeContractTotal")) != null) setBeforeContractTotal(__getDecimal(val));  
		if((val = values.get("businessIntegral")) != null) setBusinessIntegral(__getDecimal(val));  
		if((val = values.get("accountWeightRecordId")) != null) setAccountWeightRecordId(__getInt(val)); 
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __business_state_record_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __business_code ;
	protected java.lang.String  __business_name ;
	protected java.math.BigDecimal  __before_contract_total ;
	protected java.math.BigDecimal  __business_integral ;
	protected java.lang.Integer  __account_weight_record_id ;
	protected java.lang.Integer  __signing_company ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
}
