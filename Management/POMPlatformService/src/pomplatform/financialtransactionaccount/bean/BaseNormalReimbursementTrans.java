package pomplatform.financialtransactionaccount.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

public class BaseNormalReimbursementTrans extends GenericBase implements BaseFactory<BaseNormalReimbursementTrans>, Comparable<BaseNormalReimbursementTrans> 
{


	public static BaseNormalReimbursementTrans newInstance(){
		return new BaseNormalReimbursementTrans();
	}

	@Override
	public BaseNormalReimbursementTrans make(){
		BaseNormalReimbursementTrans b = new BaseNormalReimbursementTrans();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;
	public final static java.lang.String CS_SUMMARY = "summary" ;
	public final static java.lang.String CS_PROCESS_BILL_LIST_ID = "process_bill_list_id" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_EMPLOYEE_OR_COMPANY_ID = "employee_or_company_id" ;
	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_BALANCE_AMOUNT = "balance_amount" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "流程实例ID,流程类型,业务编码,创建时间,流程状态,完成时间,流程发起者,货币种类,摘要,付款信息ID,收款对象类型,员工或者收款单位Id,付款金额,冲账金额,归属公司";

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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public java.lang.String getSummary() {
		return this.__summary;
	}

	public void setSummary( java.lang.String value ) {
		this.__summary = value;
	}

	public java.lang.Integer getProcessBillListId() {
		return this.__process_bill_list_id;
	}

	public void setProcessBillListId( java.lang.Integer value ) {
		this.__process_bill_list_id = value;
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

	public java.lang.Integer getCompanyId() {
		return __company_id;
	}

	public void setCompanyId(java.lang.Integer value) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseNormalReimbursementTrans __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setRecordDate(getRecordDate());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setDrafter(getDrafter());
		__bean.setCurrencyType(getCurrencyType());
		__bean.setSummary(getSummary());
		__bean.setProcessBillListId(getProcessBillListId());
		__bean.setPayFor(getPayFor());
		__bean.setEmployeeOrCompanyId(getEmployeeOrCompanyId());
		__bean.setPayMoney(getPayMoney());
		__bean.setBalanceAmount(getBalanceAmount());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		sb.append(",");
		sb.append(getSummary() == null ? "" : getSummary());
		sb.append(",");
		sb.append(getProcessBillListId() == null ? "" : getProcessBillListId());
		sb.append(",");
		sb.append(getPayFor() == null ? "" : getPayFor());
		sb.append(",");
		sb.append(getEmployeeOrCompanyId() == null ? "" : getEmployeeOrCompanyId());
		sb.append(",");
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getBalanceAmount() == null ? "" : getBalanceAmount());
		sb.append(",");
		String companyStr = SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(companyStr == null ? "" : companyStr);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNormalReimbursementTrans o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		hash = 97 * hash + Objects.hashCode(this.__summary);
		hash = 97 * hash + Objects.hashCode(this.__process_bill_list_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__employee_or_company_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNormalReimbursementTrans o = (BaseNormalReimbursementTrans)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		if(!Objects.equals(this.__summary, o.getSummary())) return false;
		if(!Objects.equals(this.__process_bill_list_id, o.getProcessBillListId())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__employee_or_company_id, o.getEmployeeOrCompanyId())) return false;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__balance_amount, o.getBalanceAmount())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		if(getSummary() != null) sb.append(__wrapString(count++, "summary", getSummary()));
		if(getProcessBillListId() != null) sb.append(__wrapNumber(count++, "processBillListId", getProcessBillListId()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(count++, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getBalanceAmount() != null) sb.append(__wrapDecimal(count++, "balanceAmount", getBalanceAmount()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getDrafter() != null) res.put("drafter", getDrafter());
		if(getCurrencyType() != null) res.put("currencyType", getCurrencyType());
		if(getSummary() != null) res.put("summary", getSummary());
		if(getProcessBillListId() != null) res.put("processBillListId", getProcessBillListId());
		if(getPayFor() != null) res.put("payFor", getPayFor());
		if(getEmployeeOrCompanyId() != null) res.put("employeeOrCompanyId", getEmployeeOrCompanyId());
		if(getPayMoney() != null) res.put("payMoney", getPayMoney());
		if(getBalanceAmount() != null) res.put("balanceAmount", getBalanceAmount());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("summary")) != null) setSummary(__getString(val));
		if((val = values.get("processBillListId")) != null) setProcessBillListId(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val)); 
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("balanceAmount")) != null) setBalanceAmount(__getDecimal(val));  
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));  
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.Integer  __currency_type ;
	protected java.lang.String  __summary ;
	protected java.lang.Integer  __process_bill_list_id ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.Integer  __employee_or_company_id ;
	protected java.math.BigDecimal  __pay_money ;
	protected java.math.BigDecimal  __balance_amount ;
	protected java.lang.Integer  __company_id ;
}
