package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePayMoneyManageOfWorkflow extends GenericBase implements BaseFactory<BasePayMoneyManageOfWorkflow>, Comparable<BasePayMoneyManageOfWorkflow> 
{


	public static BasePayMoneyManageOfWorkflow newInstance(){
		return new BasePayMoneyManageOfWorkflow();
	}

	@Override
	public BasePayMoneyManageOfWorkflow make(){
		BasePayMoneyManageOfWorkflow b = new BasePayMoneyManageOfWorkflow();
		return b;
	}

	public final static java.lang.String CS_PAY_MONEY_MANAGE_ID = "pay_money_manage_id" ;
	public final static java.lang.String CS_RECEIVE_UNIT = "receive_unit" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_PAY_AMOUNT = "pay_amount" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ATTACHMENT_FILE = "attachment_file" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,收款单位,银行账号,开户行,主题名称,付款金额,申请人,部门编码,附件,付款原因,操作人,操作时间,编号,归属公司";

	public java.lang.Integer getPayMoneyManageId() {
		return this.__pay_money_manage_id;
	}

	public void setPayMoneyManageId( java.lang.Integer value ) {
		this.__pay_money_manage_id = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit;
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getAttachmentFile() {
		return this.__attachment_file;
	}

	public void setAttachmentFile( java.lang.String value ) {
		this.__attachment_file = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BasePayMoneyManageOfWorkflow __bean){
		__bean.setPayMoneyManageId(getPayMoneyManageId());
		__bean.setReceiveUnit(getReceiveUnit());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankName(getBankName());
		__bean.setTitleName(getTitleName());
		__bean.setPayAmount(getPayAmount());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setAttachmentFile(getAttachmentFile());
		__bean.setReason(getReason());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setCode(getCode());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPayMoneyManageId() == null ? "" : getPayMoneyManageId());
		sb.append(",");
		sb.append(getReceiveUnit() == null ? "" : getReceiveUnit());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
		sb.append(",");
		sb.append(getPayAmount() == null ? "" : getPayAmount());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getAttachmentFile() == null ? "" : getAttachmentFile());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePayMoneyManageOfWorkflow o) {
		return __pay_money_manage_id == null ? -1 : __pay_money_manage_id.compareTo(o.getPayMoneyManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pay_money_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
		hash = 97 * hash + Objects.hashCode(this.__pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_file);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePayMoneyManageOfWorkflow o = (BasePayMoneyManageOfWorkflow)obj;
		if(!Objects.equals(this.__pay_money_manage_id, o.getPayMoneyManageId())) return false;
		if(!Objects.equals(this.__receive_unit, o.getReceiveUnit())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
		if(!Objects.equals(this.__pay_amount, o.getPayAmount())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__attachment_file, o.getAttachmentFile())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPayMoneyManageId() != null) sb.append(__wrapNumber(count++, "payMoneyManageId", getPayMoneyManageId()));
		if(getReceiveUnit() != null) sb.append(__wrapString(count++, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
		if(getPayAmount() != null) sb.append(__wrapDecimal(count++, "payAmount", getPayAmount()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getAttachmentFile() != null) sb.append(__wrapString(count++, "attachmentFile", getAttachmentFile()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("payMoneyManageId")) != null) setPayMoneyManageId(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("attachmentFile")) != null) setAttachmentFile(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __pay_money_manage_id ;
	protected java.lang.String  __receive_unit ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __title_name ;
	protected java.math.BigDecimal  __pay_amount ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __attachment_file ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __company_id ;
}
