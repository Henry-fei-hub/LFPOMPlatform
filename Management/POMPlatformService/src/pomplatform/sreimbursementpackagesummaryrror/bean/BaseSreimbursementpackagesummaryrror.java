package pomplatform.sreimbursementpackagesummaryrror.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSreimbursementpackagesummaryrror extends GenericBase implements BaseFactory<BaseSreimbursementpackagesummaryrror>, Comparable<BaseSreimbursementpackagesummaryrror> 
{


	public static BaseSreimbursementpackagesummaryrror newInstance(){
		return new BaseSreimbursementpackagesummaryrror();
	}

	@Override
	public BaseSreimbursementpackagesummaryrror make(){
		BaseSreimbursementpackagesummaryrror b = new BaseSreimbursementpackagesummaryrror();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID = "reimbursement_package_summary_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_EMPLOYEE_OR_COMPANY_ID = "employee_or_company_id" ;
	public final static java.lang.String CS_PAYEE_NAME = "payee_name" ;
	public final static java.lang.String CS_SELF_BANK_NAME = "self_bank_name" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_OTHER_BANK_NAME = "other_bank_name" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PAYMENT_AMOUNT = "payment_amount" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE_AMOUNT = "strike_a_balance_amount" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;

	public final static java.lang.String ALL_CAPTIONS = "报销打包汇总表编码,报销打包表编码,款项属性,收款类型,员工或者收款单位Id,收款方,银行名称(收款方),银行账号(收款方),付款方  system_dictionary_69,银行名称(付款方),银行账号(付款方),总金额,付款金额,冲账金额,开始时间,修改时间,是否完成";

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getPayFor() {
		return this.__pay_for;
	}

	public void setPayFor( java.lang.Integer value ) {
		this.__pay_for = value;
	}

	public java.lang.Integer getEmployeeOrCompanyId() {
		return this.__employee_or_company_id;
	}

	public void setEmployeeOrCompanyId( java.lang.Integer value ) {
		this.__employee_or_company_id = value;
	}

	public java.lang.String getPayeeName() {
		return this.__payee_name;
	}

	public void setPayeeName( java.lang.String value ) {
		this.__payee_name = value;
	}

	public java.lang.String getSelfBankName() {
		return this.__self_bank_name;
	}

	public void setSelfBankName( java.lang.String value ) {
		this.__self_bank_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account;
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.Integer getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.Integer value ) {
		this.__other_name = value;
	}

	public java.lang.String getOtherBankName() {
		return this.__other_bank_name;
	}

	public void setOtherBankName( java.lang.String value ) {
		this.__other_bank_name = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account;
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return this.__payment_amount;
	}

	public void setPaymentAmount( java.math.BigDecimal value ) {
		this.__payment_amount = value;
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return this.__strike_a_balance_amount;
	}

	public void setStrikeABalanceAmount( java.math.BigDecimal value ) {
		this.__strike_a_balance_amount = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public void cloneCopy(BaseSreimbursementpackagesummaryrror __bean){
		__bean.setReimbursementPackageSummaryId(getReimbursementPackageSummaryId());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setPayFor(getPayFor());
		__bean.setEmployeeOrCompanyId(getEmployeeOrCompanyId());
		__bean.setPayeeName(getPayeeName());
		__bean.setSelfBankName(getSelfBankName());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherName(getOtherName());
		__bean.setOtherBankName(getOtherBankName());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setAmount(getAmount());
		__bean.setPaymentAmount(getPaymentAmount());
		__bean.setStrikeABalanceAmount(getStrikeABalanceAmount());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setIsCompleted(getIsCompleted());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementPackageSummaryId() == null ? "" : getReimbursementPackageSummaryId());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getMoneyAttribute() == null ? "" : getMoneyAttribute());
		sb.append(",");
		sb.append(getPayFor() == null ? "" : getPayFor());
		sb.append(",");
		sb.append(getEmployeeOrCompanyId() == null ? "" : getEmployeeOrCompanyId());
		sb.append(",");
		sb.append(getPayeeName() == null ? "" : getPayeeName());
		sb.append(",");
		sb.append(getSelfBankName() == null ? "" : getSelfBankName());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getOtherName() == null ? "" : getOtherName());
		sb.append(",");
		sb.append(getOtherBankName() == null ? "" : getOtherBankName());
		sb.append(",");
		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getStrikeABalanceAmount() == null ? "" : getStrikeABalanceAmount());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSreimbursementpackagesummaryrror o) {
		return __reimbursement_package_summary_id == null ? -1 : __reimbursement_package_summary_id.compareTo(o.getReimbursementPackageSummaryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_summary_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__employee_or_company_id);
		hash = 97 * hash + Objects.hashCode(this.__payee_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSreimbursementpackagesummaryrror o = (BaseSreimbursementpackagesummaryrror)obj;
		if(!Objects.equals(this.__reimbursement_package_summary_id, o.getReimbursementPackageSummaryId())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__employee_or_company_id, o.getEmployeeOrCompanyId())) return false;
		if(!Objects.equals(this.__payee_name, o.getPayeeName())) return false;
		if(!Objects.equals(this.__self_bank_name, o.getSelfBankName())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__other_bank_name, o.getOtherBankName())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__payment_amount, o.getPaymentAmount())) return false;
		if(!Objects.equals(this.__strike_a_balance_amount, o.getStrikeABalanceAmount())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(count++, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		if(getPayeeName() != null) sb.append(__wrapString(count++, "payeeName", getPayeeName()));
		if(getSelfBankName() != null) sb.append(__wrapString(count++, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherName() != null) sb.append(__wrapNumber(count++, "otherName", getOtherName()));
		if(getOtherBankName() != null) sb.append(__wrapString(count++, "otherBankName", getOtherBankName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPaymentAmount() != null) sb.append(__wrapDecimal(count++, "paymentAmount", getPaymentAmount()));
		if(getStrikeABalanceAmount() != null) sb.append(__wrapDecimal(count++, "strikeABalanceAmount", getStrikeABalanceAmount()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val)); 
		if((val = values.get("payeeName")) != null) setPayeeName(__getString(val));
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getInt(val)); 
		if((val = values.get("otherBankName")) != null) setOtherBankName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("strikeABalanceAmount")) != null) setStrikeABalanceAmount(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
	}

	protected java.lang.Integer  __reimbursement_package_summary_id ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.lang.Integer  __money_attribute ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.Integer  __employee_or_company_id ;
	protected java.lang.String  __payee_name ;
	protected java.lang.String  __self_bank_name ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.Integer  __other_name ;
	protected java.lang.String  __other_bank_name ;
	protected java.lang.String  __other_bank_account ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __payment_amount ;
	protected java.math.BigDecimal  __strike_a_balance_amount ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Boolean  __is_completed ;
}
