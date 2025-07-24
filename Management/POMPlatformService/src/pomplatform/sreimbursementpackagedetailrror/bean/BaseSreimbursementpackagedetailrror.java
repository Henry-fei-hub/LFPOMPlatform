package pomplatform.sreimbursementpackagedetailrror.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSreimbursementpackagedetailrror extends GenericBase implements BaseFactory<BaseSreimbursementpackagedetailrror>, Comparable<BaseSreimbursementpackagedetailrror> 
{


	public static BaseSreimbursementpackagedetailrror newInstance(){
		return new BaseSreimbursementpackagedetailrror();
	}

	@Override
	public BaseSreimbursementpackagedetailrror make(){
		BaseSreimbursementpackagedetailrror b = new BaseSreimbursementpackagedetailrror();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_DETAIL_ID = "reimbursement_package_detail_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_PROCESS_TYPE_ID = "process_type_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_EMPLOYEE_OR_COMPANY_ID = "employee_or_company_id" ;
	public final static java.lang.String CS_PAYEE_NAME = "payee_name" ;
	public final static java.lang.String CS_SELF_BANK_NAME = "self_bank_name" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PAYMENT_AMOUNT = "payment_amount" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE_AMOUNT = "strike_a_balance_amount" ;
	public final static java.lang.String CS_PROCESS_BILL_LIST_ID = "process_bill_list_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "报销打包汇总详情表编码,报销打包表编码,流程类型,流程,业务编码,流程实例编码,编号,起草人,收款类型,员工或者收款单位Id,收款方,银行名称(收款方),银行账号(收款方),总金额,付款金额,冲账金额,账单流水Id,开始时间,修改时间";

	public java.lang.Integer getReimbursementPackageDetailId() {
		return this.__reimbursement_package_detail_id;
	}

	public void setReimbursementPackageDetailId( java.lang.Integer value ) {
		this.__reimbursement_package_detail_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getProcessTypeId() {
		return this.__process_type_id;
	}

	public void setProcessTypeId( java.lang.Integer value ) {
		this.__process_type_id = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
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

	public java.lang.Integer getProcessBillListId() {
		return this.__process_bill_list_id;
	}

	public void setProcessBillListId( java.lang.Integer value ) {
		this.__process_bill_list_id = value;
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

	public void cloneCopy(BaseSreimbursementpackagedetailrror __bean){
		__bean.setReimbursementPackageDetailId(getReimbursementPackageDetailId());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setProcessTypeId(getProcessTypeId());
		__bean.setProcessId(getProcessId());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setCode(getCode());
		__bean.setDrafter(getDrafter());
		__bean.setPayFor(getPayFor());
		__bean.setEmployeeOrCompanyId(getEmployeeOrCompanyId());
		__bean.setPayeeName(getPayeeName());
		__bean.setSelfBankName(getSelfBankName());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setAmount(getAmount());
		__bean.setPaymentAmount(getPaymentAmount());
		__bean.setStrikeABalanceAmount(getStrikeABalanceAmount());
		__bean.setProcessBillListId(getProcessBillListId());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementPackageDetailId() == null ? "" : getReimbursementPackageDetailId());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getProcessTypeId() == null ? "" : getProcessTypeId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getDrafter() == null ? "" : getDrafter());
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
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getStrikeABalanceAmount() == null ? "" : getStrikeABalanceAmount());
		sb.append(",");
		sb.append(getProcessBillListId() == null ? "" : getProcessBillListId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSreimbursementpackagedetailrror o) {
		return __reimbursement_package_detail_id == null ? -1 : __reimbursement_package_detail_id.compareTo(o.getReimbursementPackageDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__employee_or_company_id);
		hash = 97 * hash + Objects.hashCode(this.__payee_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__process_bill_list_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSreimbursementpackagedetailrror o = (BaseSreimbursementpackagedetailrror)obj;
		if(!Objects.equals(this.__reimbursement_package_detail_id, o.getReimbursementPackageDetailId())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__process_type_id, o.getProcessTypeId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__employee_or_company_id, o.getEmployeeOrCompanyId())) return false;
		if(!Objects.equals(this.__payee_name, o.getPayeeName())) return false;
		if(!Objects.equals(this.__self_bank_name, o.getSelfBankName())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__payment_amount, o.getPaymentAmount())) return false;
		if(!Objects.equals(this.__strike_a_balance_amount, o.getStrikeABalanceAmount())) return false;
		if(!Objects.equals(this.__process_bill_list_id, o.getProcessBillListId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementPackageDetailId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageDetailId", getReimbursementPackageDetailId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getProcessTypeId() != null) sb.append(__wrapNumber(count++, "processTypeId", getProcessTypeId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(count++, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		if(getPayeeName() != null) sb.append(__wrapString(count++, "payeeName", getPayeeName()));
		if(getSelfBankName() != null) sb.append(__wrapString(count++, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPaymentAmount() != null) sb.append(__wrapDecimal(count++, "paymentAmount", getPaymentAmount()));
		if(getStrikeABalanceAmount() != null) sb.append(__wrapDecimal(count++, "strikeABalanceAmount", getStrikeABalanceAmount()));
		if(getProcessBillListId() != null) sb.append(__wrapNumber(count++, "processBillListId", getProcessBillListId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementPackageDetailId")) != null) setReimbursementPackageDetailId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("processTypeId")) != null) setProcessTypeId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val)); 
		if((val = values.get("payeeName")) != null) setPayeeName(__getString(val));
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("strikeABalanceAmount")) != null) setStrikeABalanceAmount(__getDecimal(val));  
		if((val = values.get("processBillListId")) != null) setProcessBillListId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __reimbursement_package_detail_id ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.lang.Integer  __process_type_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.Integer  __employee_or_company_id ;
	protected java.lang.String  __payee_name ;
	protected java.lang.String  __self_bank_name ;
	protected java.lang.String  __self_bank_account ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __payment_amount ;
	protected java.math.BigDecimal  __strike_a_balance_amount ;
	protected java.lang.Integer  __process_bill_list_id ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
}
