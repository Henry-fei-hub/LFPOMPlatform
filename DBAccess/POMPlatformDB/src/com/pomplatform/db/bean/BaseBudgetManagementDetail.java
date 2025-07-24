package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBudgetManagementDetail extends GenericBase implements BaseFactory<BaseBudgetManagementDetail>, Comparable<BaseBudgetManagementDetail> 
{


	public static BaseBudgetManagementDetail newInstance(){
		return new BaseBudgetManagementDetail();
	}

	@Override
	public BaseBudgetManagementDetail make(){
		BaseBudgetManagementDetail b = new BaseBudgetManagementDetail();
		return b;
	}

	public final static java.lang.String CS_BUDGET_MANAGEMENT_DETAIL_ID = "budget_management_detail_id" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BD_CODE = "bd_code" ;
	public final static java.lang.String CS_BDD_TYPE = "bdd_type" ;
	public final static java.lang.String CS_BDD_AMOUNT = "bdd_amount" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,预算管理id,预算编号,预算详细类别   budget_detail_type,预算详细金额,项目id";

	public java.lang.Integer getBudgetManagementDetailId() {
		return this.__budget_management_detail_id;
	}

	public void setBudgetManagementDetailId( java.lang.Integer value ) {
		this.__budget_management_detail_id = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.String getBdCode() {
		return this.__bd_code;
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public java.lang.String getBddType() {
		return this.__bdd_type;
	}

	public void setBddType( java.lang.String value ) {
		this.__bdd_type = value;
	}

	public java.math.BigDecimal getBddAmount() {
		return this.__bdd_amount;
	}

	public void setBddAmount( java.math.BigDecimal value ) {
		this.__bdd_amount = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public void cloneCopy(BaseBudgetManagementDetail __bean){
		__bean.setBudgetManagementDetailId(getBudgetManagementDetailId());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBdCode(getBdCode());
		__bean.setBddType(getBddType());
		__bean.setBddAmount(getBddAmount());
		__bean.setProjectId(getProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBudgetManagementDetailId() == null ? "" : getBudgetManagementDetailId());
		sb.append(",");
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getBdCode() == null ? "" : getBdCode());
		sb.append(",");
		sb.append(getBddType() == null ? "" : getBddType());
		sb.append(",");
		sb.append(getBddAmount() == null ? "" : getBddAmount());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBudgetManagementDetail o) {
		return __budget_management_detail_id == null ? -1 : __budget_management_detail_id.compareTo(o.getBudgetManagementDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__budget_management_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_code);
		hash = 97 * hash + Objects.hashCode(this.__bdd_type);
		hash = 97 * hash + Objects.hashCode(this.__bdd_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBudgetManagementDetail o = (BaseBudgetManagementDetail)obj;
		if(!Objects.equals(this.__budget_management_detail_id, o.getBudgetManagementDetailId())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__bd_code, o.getBdCode())) return false;
		if(!Objects.equals(this.__bdd_type, o.getBddType())) return false;
		if(!Objects.equals(this.__bdd_amount, o.getBddAmount())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBudgetManagementDetailId() != null) sb.append(__wrapNumber(count++, "budgetManagementDetailId", getBudgetManagementDetailId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBdCode() != null) sb.append(__wrapString(count++, "bdCode", getBdCode()));
		if(getBddType() != null) sb.append(__wrapString(count++, "bddType", getBddType()));
		if(getBddAmount() != null) sb.append(__wrapDecimal(count++, "bddAmount", getBddAmount()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("budgetManagementDetailId")) != null) setBudgetManagementDetailId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("bdCode")) != null) setBdCode(__getString(val));
		if((val = values.get("bddType")) != null) setBddType(__getString(val));
		if((val = values.get("bddAmount")) != null) setBddAmount(__getDecimal(val));  
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __budget_management_detail_id ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.String  __bd_code ;
	protected java.lang.String  __bdd_type ;
	protected java.math.BigDecimal  __bdd_amount ;
	protected java.lang.Integer  __project_id ;
}
