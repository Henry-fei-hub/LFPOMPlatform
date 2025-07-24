package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInvoiceApplyReceivable extends GenericBase implements BaseFactory<BaseInvoiceApplyReceivable>, Comparable<BaseInvoiceApplyReceivable> 
{


	public static BaseInvoiceApplyReceivable newInstance(){
		return new BaseInvoiceApplyReceivable();
	}

	@Override
	public BaseInvoiceApplyReceivable make(){
		BaseInvoiceApplyReceivable b = new BaseInvoiceApplyReceivable();
		return b;
	}

	public final static java.lang.String CS_INVOICE_APPLY_RECEIVABLE_ID = "invoice_apply_receivable_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_INVOICE_APPLY_ID = "invoice_apply_id" ;
	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_RECEIVABLE_APPLY_MONEY = "receivable_apply_money" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,合同主键,,合同阶段编码,阶段申请的金额,创建时间";

	public java.lang.Integer getInvoiceApplyReceivableId() {
		return this.__invoice_apply_receivable_id;
	}

	public void setInvoiceApplyReceivableId( java.lang.Integer value ) {
		this.__invoice_apply_receivable_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getInvoiceApplyId() {
		return this.__invoice_apply_id;
	}

	public void setInvoiceApplyId( java.lang.Integer value ) {
		this.__invoice_apply_id = value;
	}

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.math.BigDecimal getReceivableApplyMoney() {
		return this.__receivable_apply_money;
	}

	public void setReceivableApplyMoney( java.math.BigDecimal value ) {
		this.__receivable_apply_money = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseInvoiceApplyReceivable __bean){
		__bean.setInvoiceApplyReceivableId(getInvoiceApplyReceivableId());
		__bean.setContractId(getContractId());
		__bean.setInvoiceApplyId(getInvoiceApplyId());
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setReceivableApplyMoney(getReceivableApplyMoney());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceApplyReceivableId() == null ? "" : getInvoiceApplyReceivableId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getInvoiceApplyId() == null ? "" : getInvoiceApplyId());
		sb.append(",");
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		sb.append(getReceivableApplyMoney() == null ? "" : getReceivableApplyMoney());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoiceApplyReceivable o) {
		return __invoice_apply_receivable_id == null ? -1 : __invoice_apply_receivable_id.compareTo(o.getInvoiceApplyReceivableId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_apply_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_apply_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__receivable_apply_money);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoiceApplyReceivable o = (BaseInvoiceApplyReceivable)obj;
		if(!Objects.equals(this.__invoice_apply_receivable_id, o.getInvoiceApplyReceivableId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__invoice_apply_id, o.getInvoiceApplyId())) return false;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__receivable_apply_money, o.getReceivableApplyMoney())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceApplyReceivableId() != null) sb.append(__wrapNumber(count++, "invoiceApplyReceivableId", getInvoiceApplyReceivableId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getInvoiceApplyId() != null) sb.append(__wrapNumber(count++, "invoiceApplyId", getInvoiceApplyId()));
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getReceivableApplyMoney() != null) sb.append(__wrapDecimal(count++, "receivableApplyMoney", getReceivableApplyMoney()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceApplyReceivableId")) != null) setInvoiceApplyReceivableId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("invoiceApplyId")) != null) setInvoiceApplyId(__getInt(val)); 
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("receivableApplyMoney")) != null) setReceivableApplyMoney(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __invoice_apply_receivable_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __invoice_apply_id ;
	protected java.lang.Integer  __contract_receivable_id ;
	protected java.math.BigDecimal  __receivable_apply_money ;
	protected java.util.Date  __create_time ;
}
