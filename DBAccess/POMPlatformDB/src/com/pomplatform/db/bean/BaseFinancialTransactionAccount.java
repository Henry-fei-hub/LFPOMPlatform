package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFinancialTransactionAccount extends GenericBase implements BaseFactory<BaseFinancialTransactionAccount>, Comparable<BaseFinancialTransactionAccount> 
{


	public static BaseFinancialTransactionAccount newInstance(){
		return new BaseFinancialTransactionAccount();
	}

	@Override
	public BaseFinancialTransactionAccount make(){
		BaseFinancialTransactionAccount b = new BaseFinancialTransactionAccount();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
	public final static java.lang.String CS_FINANCE_NO = "finance_no" ;
	public final static java.lang.String CS_ACCOUNT_NAME = "account_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_REIMBURSABLE = "reimbursable" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ACCOUNT_STATUS = "account_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码, 2收款单位,财务编号,名称,备注,能否报销,创建时间, 3销户";

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.String getFinanceNo() {
		return this.__finance_no;
	}

	public void setFinanceNo( java.lang.String value ) {
		this.__finance_no = value;
	}

	public java.lang.String getAccountName() {
		return this.__account_name;
	}

	public void setAccountName( java.lang.String value ) {
		this.__account_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getReimbursable() {
		return this.__reimbursable;
	}

	public void setReimbursable( java.lang.Boolean value ) {
		this.__reimbursable = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getAccountStatus() {
		return this.__account_status;
	}

	public void setAccountStatus( java.lang.Integer value ) {
		this.__account_status = value;
	}

	public void cloneCopy(BaseFinancialTransactionAccount __bean){
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setAccountType(getAccountType());
		__bean.setFinanceNo(getFinanceNo());
		__bean.setAccountName(getAccountName());
		__bean.setRemark(getRemark());
		__bean.setReimbursable(getReimbursable());
		__bean.setCreateTime(getCreateTime());
		__bean.setAccountStatus(getAccountStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		sb.append(getAccountType() == null ? "" : getAccountType());
		sb.append(",");
		sb.append(getFinanceNo() == null ? "" : getFinanceNo());
		sb.append(",");
		sb.append(getAccountName() == null ? "" : getAccountName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getReimbursable() == null ? "" : getReimbursable());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getAccountStatus() == null ? "" : getAccountStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialTransactionAccount o) {
		return __financial_transaction_account_id == null ? -1 : __financial_transaction_account_id.compareTo(o.getFinancialTransactionAccountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__account_type);
		hash = 97 * hash + Objects.hashCode(this.__finance_no);
		hash = 97 * hash + Objects.hashCode(this.__account_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__reimbursable);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__account_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialTransactionAccount o = (BaseFinancialTransactionAccount)obj;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
		if(!Objects.equals(this.__finance_no, o.getFinanceNo())) return false;
		if(!Objects.equals(this.__account_name, o.getAccountName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__reimbursable, o.getReimbursable())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__account_status, o.getAccountStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
		if(getFinanceNo() != null) sb.append(__wrapString(count++, "financeNo", getFinanceNo()));
		if(getAccountName() != null) sb.append(__wrapString(count++, "accountName", getAccountName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getReimbursable() != null) sb.append(__wrapBoolean(count++, "reimbursable", getReimbursable()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getAccountStatus() != null) sb.append(__wrapNumber(count++, "accountStatus", getAccountStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getAccountType() != null) res.put("accountType", getAccountType());
		if(getFinanceNo() != null) res.put("financeNo", getFinanceNo());
		if(getAccountName() != null) res.put("accountName", getAccountName());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getReimbursable() != null) res.put("reimbursable", getReimbursable());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getAccountStatus() != null) res.put("accountStatus", getAccountStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("financeNo")) != null) setFinanceNo(__getString(val));
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("reimbursable")) != null) setReimbursable(__getBoolean(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("accountStatus")) != null) setAccountStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.lang.Integer  __account_type ;
	protected java.lang.String  __finance_no ;
	protected java.lang.String  __account_name ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __reimbursable ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __account_status ;
}
