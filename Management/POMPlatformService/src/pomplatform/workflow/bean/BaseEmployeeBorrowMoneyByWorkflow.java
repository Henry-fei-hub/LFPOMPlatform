package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeBorrowMoneyByWorkflow extends GenericBase implements BaseFactory<BaseEmployeeBorrowMoneyByWorkflow>, Comparable<BaseEmployeeBorrowMoneyByWorkflow> 
{


	public static BaseEmployeeBorrowMoneyByWorkflow newInstance(){
		return new BaseEmployeeBorrowMoneyByWorkflow();
	}

	@Override
	public BaseEmployeeBorrowMoneyByWorkflow make(){
		BaseEmployeeBorrowMoneyByWorkflow b = new BaseEmployeeBorrowMoneyByWorkflow();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_MONEY_MANAGE_ID = "employee_money_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_BORROW_DATE = "borrow_date" ;
	public final static java.lang.String CS_ANTICIPATED_DATE = "anticipated_date" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工编号,员工姓名,在职状态,职员,部门,借款金额,借款日期,预计还款日期,主题名称,借款事由,操作人,操作时间,编号,归属公司";

	public java.lang.Integer getEmployeeMoneyManageId() {
		return this.__employee_money_manage_id;
	}

	public void setEmployeeMoneyManageId( java.lang.Integer value ) {
		this.__employee_money_manage_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.util.Date getBorrowDate() {
		return this.__borrow_date;
	}

	public void setBorrowDate( java.util.Date value ) {
		this.__borrow_date = value;
	}

	public java.util.Date getAnticipatedDate() {
		return this.__anticipated_date;
	}

	public void setAnticipatedDate( java.util.Date value ) {
		this.__anticipated_date = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
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

	public void cloneCopy(BaseEmployeeBorrowMoneyByWorkflow __bean){
		__bean.setEmployeeMoneyManageId(getEmployeeMoneyManageId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setStatus(getStatus());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setBorrowDate(getBorrowDate());
		__bean.setAnticipatedDate(getAnticipatedDate());
		__bean.setTitleName(getTitleName());
		__bean.setReason(getReason());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setCode(getCode());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeMoneyManageId() == null ? "" : getEmployeeMoneyManageId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getBorrowDate() == null ? "" : sdf.format(getBorrowDate()));
		sb.append(",");
		sb.append(getAnticipatedDate() == null ? "" : sdf.format(getAnticipatedDate()));
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
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
	public int compareTo(BaseEmployeeBorrowMoneyByWorkflow o) {
		return __employee_money_manage_id == null ? -1 : __employee_money_manage_id.compareTo(o.getEmployeeMoneyManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_money_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__borrow_date);
		hash = 97 * hash + Objects.hashCode(this.__anticipated_date);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
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
		final BaseEmployeeBorrowMoneyByWorkflow o = (BaseEmployeeBorrowMoneyByWorkflow)obj;
		if(!Objects.equals(this.__employee_money_manage_id, o.getEmployeeMoneyManageId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__borrow_date, o.getBorrowDate())) return false;
		if(!Objects.equals(this.__anticipated_date, o.getAnticipatedDate())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
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
		if(getEmployeeMoneyManageId() != null) sb.append(__wrapNumber(count++, "employeeMoneyManageId", getEmployeeMoneyManageId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getBorrowDate() != null) sb.append(__wrapDate(count++, "borrowDate", getBorrowDate()));
		if(getAnticipatedDate() != null) sb.append(__wrapDate(count++, "anticipatedDate", getAnticipatedDate()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
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
		if((val = values.get("employeeMoneyManageId")) != null) setEmployeeMoneyManageId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("borrowDate")) != null) setBorrowDate(__getDate(val)); 
		if((val = values.get("anticipatedDate")) != null) setAnticipatedDate(__getDate(val)); 
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_money_manage_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.util.Date  __borrow_date ;
	protected java.util.Date  __anticipated_date ;
	protected java.lang.String  __title_name ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __company_id ;
}
