package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOldProjectRevenue extends GenericBase implements BaseFactory<BaseOldProjectRevenue>, Comparable<BaseOldProjectRevenue> 
{


	public static BaseOldProjectRevenue newInstance(){
		return new BaseOldProjectRevenue();
	}

	@Override
	public BaseOldProjectRevenue make(){
		BaseOldProjectRevenue b = new BaseOldProjectRevenue();
		return b;
	}

	public final static java.lang.String CS_OLD_PROJECT_REVENUE_ID = "old_project_revenue_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PALTE_ID = "palte_id" ;
	public final static java.lang.String CS_IS_FINISH = "is_finish" ;
	public final static java.lang.String CS_BUNIESS_TYPE = "buniess_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编号,订单编号,订单名,订单的营收,归属的部门Id,是否完结（1完结，2.没有完结）,业态";

	public java.lang.Integer getOldProjectRevenueId() {
		return this.__old_project_revenue_id;
	}

	public void setOldProjectRevenueId( java.lang.Integer value ) {
		this.__old_project_revenue_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getPalteId() {
		return this.__palte_id;
	}

	public void setPalteId( java.lang.Integer value ) {
		this.__palte_id = value;
	}

	public java.lang.Integer getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Integer value ) {
		this.__is_finish = value;
	}

	public java.lang.Integer getBuniessType() {
		return this.__buniess_type;
	}

	public void setBuniessType( java.lang.Integer value ) {
		this.__buniess_type = value;
	}

	public void cloneCopy(BaseOldProjectRevenue __bean){
		__bean.setOldProjectRevenueId(getOldProjectRevenueId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setAmount(getAmount());
		__bean.setPalteId(getPalteId());
		__bean.setIsFinish(getIsFinish());
		__bean.setBuniessType(getBuniessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOldProjectRevenueId() == null ? "" : getOldProjectRevenueId());
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPalteId() == null ? "" : getPalteId());
		sb.append(",");
		sb.append(getIsFinish() == null ? "" : getIsFinish());
		sb.append(",");
		sb.append(getBuniessType() == null ? "" : getBuniessType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOldProjectRevenue o) {
		return __old_project_revenue_id == null ? -1 : __old_project_revenue_id.compareTo(o.getOldProjectRevenueId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__old_project_revenue_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__palte_id);
		hash = 97 * hash + Objects.hashCode(this.__is_finish);
		hash = 97 * hash + Objects.hashCode(this.__buniess_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOldProjectRevenue o = (BaseOldProjectRevenue)obj;
		if(!Objects.equals(this.__old_project_revenue_id, o.getOldProjectRevenueId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__palte_id, o.getPalteId())) return false;
		if(!Objects.equals(this.__is_finish, o.getIsFinish())) return false;
		if(!Objects.equals(this.__buniess_type, o.getBuniessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOldProjectRevenueId() != null) sb.append(__wrapNumber(count++, "oldProjectRevenueId", getOldProjectRevenueId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPalteId() != null) sb.append(__wrapNumber(count++, "palteId", getPalteId()));
		if(getIsFinish() != null) sb.append(__wrapNumber(count++, "isFinish", getIsFinish()));
		if(getBuniessType() != null) sb.append(__wrapNumber(count++, "buniessType", getBuniessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("oldProjectRevenueId")) != null) setOldProjectRevenueId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("palteId")) != null) setPalteId(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getInt(val)); 
		if((val = values.get("buniessType")) != null) setBuniessType(__getInt(val)); 
	}

	protected java.lang.Integer  __old_project_revenue_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __palte_id ;
	protected java.lang.Integer  __is_finish ;
	protected java.lang.Integer  __buniess_type ;
}
