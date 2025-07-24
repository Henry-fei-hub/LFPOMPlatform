package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCapitalsToContractReceivable extends GenericBase implements BaseFactory<BaseCapitalsToContractReceivable>, Comparable<BaseCapitalsToContractReceivable> 
{


	public static BaseCapitalsToContractReceivable newInstance(){
		return new BaseCapitalsToContractReceivable();
	}

	@Override
	public BaseCapitalsToContractReceivable make(){
		BaseCapitalsToContractReceivable b = new BaseCapitalsToContractReceivable();
		return b;
	}

	public final static java.lang.String CS_CAPITALS_TO_CONTRACT_RECEIVABLE_ID = "capitals_to_contract_receivable_id" ;
	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_STAGE_PERCENTAGE = "stage_percentage" ;
	public final static java.lang.String CS_STAGE_SUM_MONEY = "stage_sum_money" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,合同阶段id,资金id,操作人id,登记日期,回款阶段百分比,回款阶段金额";

	public java.lang.Integer getCapitalsToContractReceivableId() {
		return this.__capitals_to_contract_receivable_id;
	}

	public void setCapitalsToContractReceivableId( java.lang.Integer value ) {
		this.__capitals_to_contract_receivable_id = value;
	}

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.math.BigDecimal getStagePercentage() {
		return this.__stage_percentage;
	}

	public void setStagePercentage( java.math.BigDecimal value ) {
		this.__stage_percentage = value;
	}

	public java.math.BigDecimal getStageSumMoney() {
		return this.__stage_sum_money;
	}

	public void setStageSumMoney( java.math.BigDecimal value ) {
		this.__stage_sum_money = value;
	}

	public void cloneCopy(BaseCapitalsToContractReceivable __bean){
		__bean.setCapitalsToContractReceivableId(getCapitalsToContractReceivableId());
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setCapitalId(getCapitalId());
		__bean.setOperator(getOperator());
		__bean.setCreateDate(getCreateDate());
		__bean.setStagePercentage(getStagePercentage());
		__bean.setStageSumMoney(getStageSumMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalsToContractReceivableId() == null ? "" : getCapitalsToContractReceivableId());
		sb.append(",");
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getStagePercentage() == null ? "" : getStagePercentage());
		sb.append(",");
		sb.append(getStageSumMoney() == null ? "" : getStageSumMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCapitalsToContractReceivable o) {
		return __capitals_to_contract_receivable_id == null ? -1 : __capitals_to_contract_receivable_id.compareTo(o.getCapitalsToContractReceivableId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capitals_to_contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__stage_percentage);
		hash = 97 * hash + Objects.hashCode(this.__stage_sum_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCapitalsToContractReceivable o = (BaseCapitalsToContractReceivable)obj;
		if(!Objects.equals(this.__capitals_to_contract_receivable_id, o.getCapitalsToContractReceivableId())) return false;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__stage_percentage, o.getStagePercentage())) return false;
		if(!Objects.equals(this.__stage_sum_money, o.getStageSumMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalsToContractReceivableId() != null) sb.append(__wrapNumber(count++, "capitalsToContractReceivableId", getCapitalsToContractReceivableId()));
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getStagePercentage() != null) sb.append(__wrapDecimal(count++, "stagePercentage", getStagePercentage()));
		if(getStageSumMoney() != null) sb.append(__wrapDecimal(count++, "stageSumMoney", getStageSumMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalsToContractReceivableId")) != null) setCapitalsToContractReceivableId(__getInt(val)); 
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("stagePercentage")) != null) setStagePercentage(__getDecimal(val));  
		if((val = values.get("stageSumMoney")) != null) setStageSumMoney(__getDecimal(val));  
	}

	protected java.lang.Integer  __capitals_to_contract_receivable_id ;
	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_date ;
	protected java.math.BigDecimal  __stage_percentage ;
	protected java.math.BigDecimal  __stage_sum_money ;
}
