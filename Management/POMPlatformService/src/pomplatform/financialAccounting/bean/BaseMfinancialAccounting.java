package pomplatform.financialAccounting.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

public class BaseMfinancialAccounting extends GenericBase implements BaseFactory<BaseMfinancialAccounting>, Comparable<BaseMfinancialAccounting> 
{


	public static BaseMfinancialAccounting newInstance(){
		return new BaseMfinancialAccounting();
	}

	@Override
	public BaseMfinancialAccounting make(){
		BaseMfinancialAccounting b = new BaseMfinancialAccounting();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_BALANCE_AMOUNT = "balance_amount" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_VOUCHER_NO = "voucher_no" ;
	public final static java.lang.String CS_POSTING_DATE = "posting_date" ;
	public final static java.lang.String CS_BE_PACKED = "be_packed" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	
	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,流程类型,创建时间,完成时间,创建人,报销编号,报销总金额,付款金额,差额金额,报销部门,归属公司,备注,主题,凭证号,入账日期,是否被打包";

	public final static java.lang.String ALL_CAPTIONS_1 = "流程类型,报销编号,报销总金额,付款金额,差额金额,起草人,报销部门,归属公司,凭证号,入账日期,完成时间,是否被打包";
	
	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
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

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getVoucherNo() {
		return this.__voucher_no;
	}

	public void setVoucherNo( java.lang.String value ) {
		this.__voucher_no = value;
	}

	public java.util.Date getPostingDate() {
		return this.__posting_date;
	}

	public void setPostingDate( java.util.Date value ) {
		this.__posting_date = value;
	}

	public java.lang.Boolean getBePacked() {
		return this.__be_packed;
	}

	public void setBePacked( java.lang.Boolean value ) {
		this.__be_packed = value;
	}

	public java.lang.Integer getProcessId() {
		return __process_id;
	}

	public void setProcessId(java.lang.Integer value) {
		this.__process_id = value;
	}

	public void cloneCopy(BaseMfinancialAccounting __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCode(getCode());
		__bean.setAmount(getAmount());
		__bean.setPayMoney(getPayMoney());
		__bean.setBalanceAmount(getBalanceAmount());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setRemark(getRemark());
		__bean.setTitle(getTitle());
		__bean.setVoucherNo(getVoucherNo());
		__bean.setPostingDate(getPostingDate());
		__bean.setBePacked(getBePacked());
		__bean.setProcessId(getProcessId());
	}

	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String processType = SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(processType == null ? "" : processType);
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		/*sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");*/
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getBalanceAmount() == null ? "" : getBalanceAmount());
		sb.append(",");
		
		String employeeId = SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(employeeId == null ? "" : employeeId);
		sb.append(",");
		
		String departmentId = SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(departmentId == null ? "" : departmentId);
		sb.append(",");
		
		String companyId = SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(companyId == null ? "" : companyId);
		sb.append(",");
		
		sb.append(getVoucherNo() == null ? "" : getVoucherNo());
		sb.append(",");
		sb.append(getPostingDate() == null ? "" : sdf.format(getPostingDate()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getBePacked() == null ? "" : getBePacked());
//		sb.append(",");
//		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMfinancialAccounting o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__voucher_no);
		hash = 97 * hash + Objects.hashCode(this.__posting_date);
		hash = 97 * hash + Objects.hashCode(this.__be_packed);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMfinancialAccounting o = (BaseMfinancialAccounting)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__balance_amount, o.getBalanceAmount())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__voucher_no, o.getVoucherNo())) return false;
		if(!Objects.equals(this.__posting_date, o.getPostingDate())) return false;
		if(!Objects.equals(this.__be_packed, o.getBePacked())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getBalanceAmount() != null) sb.append(__wrapDecimal(count++, "balanceAmount", getBalanceAmount()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getVoucherNo() != null) sb.append(__wrapString(count++, "voucherNo", getVoucherNo()));
		if(getPostingDate() != null) sb.append(__wrapDate(count++, "postingDate", getPostingDate()));
		if(getBePacked() != null) sb.append(__wrapBoolean(count++, "bePacked", getBePacked()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("balanceAmount")) != null) setBalanceAmount(__getDecimal(val));  
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("postingDate")) != null) setPostingDate(__getDate(val)); 
		if((val = values.get("bePacked")) != null) setBePacked(__getBoolean(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val));
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __code ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __pay_money ;
	protected java.math.BigDecimal  __balance_amount ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __title ;
	protected java.lang.String  __voucher_no ;
	protected java.util.Date  __posting_date ;
	protected java.lang.Boolean  __be_packed ;
	protected java.lang.Integer  __process_id;
}
