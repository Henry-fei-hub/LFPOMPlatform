package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCapitalsToInvoice extends GenericBase implements BaseFactory<BaseCapitalsToInvoice>, Comparable<BaseCapitalsToInvoice> 
{


	public static BaseCapitalsToInvoice newInstance(){
		return new BaseCapitalsToInvoice();
	}

	@Override
	public BaseCapitalsToInvoice make(){
		BaseCapitalsToInvoice b = new BaseCapitalsToInvoice();
		return b;
	}

	public final static java.lang.String CS_CAPITALS_TO_INVOICE_ID = "capitals_to_invoice_id" ;
	public final static java.lang.String CS_INVOICE_ID = "invoice_id" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_STAGE_PERCENTAGE = "stage_percentage" ;
	public final static java.lang.String CS_STAGE_SUM_MONEY = "stage_sum_money" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,发票id,资金id,操作人id,登记日期,回款阶段百分比,回款阶段金额";

	public java.lang.Integer getCapitalsToInvoiceId() {
		return this.__capitals_to_invoice_id;
	}

	public void setCapitalsToInvoiceId( java.lang.Integer value ) {
		this.__capitals_to_invoice_id = value;
	}

	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
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

	public void cloneCopy(BaseCapitalsToInvoice __bean){
		__bean.setCapitalsToInvoiceId(getCapitalsToInvoiceId());
		__bean.setInvoiceId(getInvoiceId());
		__bean.setCapitalId(getCapitalId());
		__bean.setOperator(getOperator());
		__bean.setCreateDate(getCreateDate());
		__bean.setStagePercentage(getStagePercentage());
		__bean.setStageSumMoney(getStageSumMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalsToInvoiceId() == null ? "" : getCapitalsToInvoiceId());
		sb.append(",");
		sb.append(getInvoiceId() == null ? "" : getInvoiceId());
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
	public int compareTo(BaseCapitalsToInvoice o) {
		return __capitals_to_invoice_id == null ? -1 : __capitals_to_invoice_id.compareTo(o.getCapitalsToInvoiceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capitals_to_invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_id);
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
		final BaseCapitalsToInvoice o = (BaseCapitalsToInvoice)obj;
		if(!Objects.equals(this.__capitals_to_invoice_id, o.getCapitalsToInvoiceId())) return false;
		if(!Objects.equals(this.__invoice_id, o.getInvoiceId())) return false;
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
		if(getCapitalsToInvoiceId() != null) sb.append(__wrapNumber(count++, "capitalsToInvoiceId", getCapitalsToInvoiceId()));
		if(getInvoiceId() != null) sb.append(__wrapNumber(count++, "invoiceId", getInvoiceId()));
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
		if((val = values.get("capitalsToInvoiceId")) != null) setCapitalsToInvoiceId(__getInt(val)); 
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("stagePercentage")) != null) setStagePercentage(__getDecimal(val));  
		if((val = values.get("stageSumMoney")) != null) setStageSumMoney(__getDecimal(val));  
	}

	protected java.lang.Integer  __capitals_to_invoice_id ;
	protected java.lang.Integer  __invoice_id ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_date ;
	protected java.math.BigDecimal  __stage_percentage ;
	protected java.math.BigDecimal  __stage_sum_money ;
}
