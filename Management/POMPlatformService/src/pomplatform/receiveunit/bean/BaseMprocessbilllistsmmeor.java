package pomplatform.receiveunit.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprocessbilllistsmmeor extends GenericBase implements BaseFactory<BaseMprocessbilllistsmmeor>, Comparable<BaseMprocessbilllistsmmeor> 
{


	public static BaseMprocessbilllistsmmeor newInstance(){
		return new BaseMprocessbilllistsmmeor();
	}

	@Override
	public BaseMprocessbilllistsmmeor make(){
		BaseMprocessbilllistsmmeor b = new BaseMprocessbilllistsmmeor();
		return b;
	}

	public final static java.lang.String CS_PROCESS_BILL_LIST_ID = "process_bill_list_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_EMPLOYEE_OR_COMPANY_ID = "employee_or_company_id" ;
	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_PAYEE_NAME = "payee_name" ;
	public final static java.lang.String CS_SELF_BANK_NAME = "self_bank_name" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_OTHER_BANK_NAME = "other_bank_name" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_BALANCE_AMOUNT = "balance_amount" ;
	public final static java.lang.String CS_IS_COMPLETE = "is_complete" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_EQUIVALENT_NUMBER = "equivalent_number" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;

	public final static java.lang.String ALL_CAPTIONS = "收款单位,付款金额,冲账金额,余额,申请人,付款日期,付款公司,备注";

	public java.lang.Integer getProcessBillListId() {
		return this.__process_bill_list_id;
	}

	public void setProcessBillListId( java.lang.Integer value ) {
		this.__process_bill_list_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
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

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
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

	public java.math.BigDecimal getPayMoney() {
		return this.__pay_money;
	}

	public void setPayMoney( java.math.BigDecimal value ) {
		this.__pay_money = value;
	}

	public java.math.BigDecimal getBalanceAmount() {
		return this.__balance_amount;
	}

	public void setBalanceAmount( java.math.BigDecimal value ) {
		this.__balance_amount = value;
	}

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.String getEquivalentNumber() {
		return this.__equivalent_number;
	}

	public void setEquivalentNumber( java.lang.String value ) {
		this.__equivalent_number = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getInitAmount() {
		return __init_amount;
	}

	public void setInitAmount(java.math.BigDecimal value) {
		this.__init_amount = value;
	}

	public void cloneCopy(BaseMprocessbilllistsmmeor __bean){
		__bean.setProcessBillListId(getProcessBillListId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setPayFor(getPayFor());
		__bean.setEmployeeOrCompanyId(getEmployeeOrCompanyId());
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setPayeeName(getPayeeName());
		__bean.setSelfBankName(getSelfBankName());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherName(getOtherName());
		__bean.setOtherBankName(getOtherBankName());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setPayMoney(getPayMoney());
		__bean.setBalanceAmount(getBalanceAmount());
		__bean.setIsComplete(getIsComplete());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperator(getOperator());
		__bean.setEquivalentNumber(getEquivalentNumber());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setInitAmount(getInitAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPayeeName() == null ? "" : getPayeeName());
		sb.append(",");
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getBalanceAmount() == null ? "" : getBalanceAmount());
		sb.append(",");
		sb.append(getInitAmount() == null ? "" : getInitAmount());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		String strOtherName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_69", String.valueOf(getOtherName()));
		sb.append(strOtherName == null ? "" : strOtherName);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprocessbilllistsmmeor o) {
		return __process_bill_list_id == null ? -1 : __process_bill_list_id.compareTo(o.getProcessBillListId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_bill_list_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__employee_or_company_id);
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__payee_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_complete);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__equivalent_number);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__init_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprocessbilllistsmmeor o = (BaseMprocessbilllistsmmeor)obj;
		if(!Objects.equals(this.__process_bill_list_id, o.getProcessBillListId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__employee_or_company_id, o.getEmployeeOrCompanyId())) return false;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__payee_name, o.getPayeeName())) return false;
		if(!Objects.equals(this.__self_bank_name, o.getSelfBankName())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__other_bank_name, o.getOtherBankName())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__balance_amount, o.getBalanceAmount())) return false;
		if(!Objects.equals(this.__is_complete, o.getIsComplete())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__equivalent_number, o.getEquivalentNumber())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__init_amount, o.getInitAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessBillListId() != null) sb.append(__wrapNumber(count++, "processBillListId", getProcessBillListId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(count++, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getPayeeName() != null) sb.append(__wrapString(count++, "payeeName", getPayeeName()));
		if(getSelfBankName() != null) sb.append(__wrapString(count++, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherName() != null) sb.append(__wrapNumber(count++, "otherName", getOtherName()));
		if(getOtherBankName() != null) sb.append(__wrapString(count++, "otherBankName", getOtherBankName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getBalanceAmount() != null) sb.append(__wrapDecimal(count++, "balanceAmount", getBalanceAmount()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(count++, "isComplete", getIsComplete()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getEquivalentNumber() != null) sb.append(__wrapString(count++, "equivalentNumber", getEquivalentNumber()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getInitAmount() != null) sb.append(__wrapDecimal(count++, "initAmount", getInitAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processBillListId")) != null) setProcessBillListId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("payeeName")) != null) setPayeeName(__getString(val));
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getInt(val)); 
		if((val = values.get("otherBankName")) != null) setOtherBankName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("balanceAmount")) != null) setBalanceAmount(__getDecimal(val));  
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("equivalentNumber")) != null) setEquivalentNumber(__getString(val));
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("initAmount")) != null) setInitAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __process_bill_list_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.Integer  __employee_or_company_id ;
	protected java.lang.Integer  __money_attribute ;
	protected java.lang.String  __payee_name ;
	protected java.lang.String  __self_bank_name ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.Integer  __other_name ;
	protected java.lang.String  __other_bank_name ;
	protected java.lang.String  __other_bank_account ;
	protected java.math.BigDecimal  __pay_money ;
	protected java.math.BigDecimal  __balance_amount ;
	protected java.lang.Boolean  __is_complete ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator ;
	protected java.lang.String  __equivalent_number ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal __init_amount ;
}
