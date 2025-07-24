package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractCommissionDetail extends GenericBase implements BaseFactory<BaseContractCommissionDetail>, Comparable<BaseContractCommissionDetail> 
{


	public static BaseContractCommissionDetail newInstance(){
		return new BaseContractCommissionDetail();
	}

	@Override
	public BaseContractCommissionDetail make(){
		BaseContractCommissionDetail b = new BaseContractCommissionDetail();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_COMMISSION_DETAIL_ID = "contract_commission_detail_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RATE = "rate" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_BILLING_RATIO = "billing_ratio" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_IS_ORIGINAL = "is_original" ;
	public final static java.lang.String CS_IS_SUB_PROJECT = "is_sub_project" ;
	public final static java.lang.String CS_TOTAL_RATE = "total_rate" ;

	public final static java.lang.String ALL_CAPTIONS = "合同提成表主键,合同编号,合同编码,业务部门,年份,月份,项目进度(%)-18年之后的进度,合同名称,各个订单的结算比例,积分,是否原创,是否建筑院分包,项目的总进度(%)";

	public java.lang.Integer getContractCommissionDetailId() {
		return this.__contract_commission_detail_id;
	}

	public void setContractCommissionDetailId( java.lang.Integer value ) {
		this.__contract_commission_detail_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.math.BigDecimal getRate() {
		return this.__rate;
	}

	public void setRate( java.math.BigDecimal value ) {
		this.__rate = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getBillingRatio() {
		return this.__billing_ratio;
	}

	public void setBillingRatio( java.lang.String value ) {
		this.__billing_ratio = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Boolean getIsOriginal() {
		return this.__is_original;
	}

	public void setIsOriginal( java.lang.Boolean value ) {
		this.__is_original = value;
	}

	public java.lang.Boolean getIsSubProject() {
		return this.__is_sub_project;
	}

	public void setIsSubProject( java.lang.Boolean value ) {
		this.__is_sub_project = value;
	}

	public java.math.BigDecimal getTotalRate() {
		return this.__total_rate;
	}

	public void setTotalRate( java.math.BigDecimal value ) {
		this.__total_rate = value;
	}

	public void cloneCopy(BaseContractCommissionDetail __bean){
		__bean.setContractCommissionDetailId(getContractCommissionDetailId());
		__bean.setContractCode(getContractCode());
		__bean.setContractId(getContractId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRate(getRate());
		__bean.setContractName(getContractName());
		__bean.setBillingRatio(getBillingRatio());
		__bean.setAmount(getAmount());
		__bean.setIsOriginal(getIsOriginal());
		__bean.setIsSubProject(getIsSubProject());
		__bean.setTotalRate(getTotalRate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractCommissionDetailId() == null ? "" : getContractCommissionDetailId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getRate() == null ? "" : getRate());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getBillingRatio() == null ? "" : getBillingRatio());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getIsOriginal() == null ? "" : getIsOriginal());
		sb.append(",");
		sb.append(getIsSubProject() == null ? "" : getIsSubProject());
		sb.append(",");
		sb.append(getTotalRate() == null ? "" : getTotalRate());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractCommissionDetail o) {
		return __contract_commission_detail_id == null ? -1 : __contract_commission_detail_id.compareTo(o.getContractCommissionDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_commission_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__rate);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__billing_ratio);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__is_original);
		hash = 97 * hash + Objects.hashCode(this.__is_sub_project);
		hash = 97 * hash + Objects.hashCode(this.__total_rate);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractCommissionDetail o = (BaseContractCommissionDetail)obj;
		if(!Objects.equals(this.__contract_commission_detail_id, o.getContractCommissionDetailId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__rate, o.getRate())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__billing_ratio, o.getBillingRatio())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__is_original, o.getIsOriginal())) return false;
		if(!Objects.equals(this.__is_sub_project, o.getIsSubProject())) return false;
		if(!Objects.equals(this.__total_rate, o.getTotalRate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractCommissionDetailId() != null) sb.append(__wrapNumber(count++, "contractCommissionDetailId", getContractCommissionDetailId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRate() != null) sb.append(__wrapDecimal(count++, "rate", getRate()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getBillingRatio() != null) sb.append(__wrapString(count++, "billingRatio", getBillingRatio()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getIsOriginal() != null) sb.append(__wrapBoolean(count++, "isOriginal", getIsOriginal()));
		if(getIsSubProject() != null) sb.append(__wrapBoolean(count++, "isSubProject", getIsSubProject()));
		if(getTotalRate() != null) sb.append(__wrapDecimal(count++, "totalRate", getTotalRate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractCommissionDetailId() != null) res.put("contractCommissionDetailId", getContractCommissionDetailId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getRate() != null) res.put("rate", getRate());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getBillingRatio() != null) res.put("billingRatio", getBillingRatio());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getIsOriginal() != null) res.put("isOriginal", getIsOriginal());
		if(getIsSubProject() != null) res.put("isSubProject", getIsSubProject());
		if(getTotalRate() != null) res.put("totalRate", getTotalRate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractCommissionDetailId")) != null) setContractCommissionDetailId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("rate")) != null) setRate(__getDecimal(val));  
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("billingRatio")) != null) setBillingRatio(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("isOriginal")) != null) setIsOriginal(__getBoolean(val));
		if((val = values.get("isSubProject")) != null) setIsSubProject(__getBoolean(val));
		if((val = values.get("totalRate")) != null) setTotalRate(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_commission_detail_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __rate ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __billing_ratio ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Boolean  __is_original ;
	protected java.lang.Boolean  __is_sub_project ;
	protected java.math.BigDecimal  __total_rate ;
}
