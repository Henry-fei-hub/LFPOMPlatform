package pomplatform.borrowMoneyManage.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBorrowMoneyManage extends GenericBase implements BaseFactory<BaseBorrowMoneyManage>, Comparable<BaseBorrowMoneyManage> 
{


	public static BaseBorrowMoneyManage newInstance(){
		return new BaseBorrowMoneyManage();
	}

	@Override
	public BaseBorrowMoneyManage make(){
		BaseBorrowMoneyManage b = new BaseBorrowMoneyManage();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_BORROW_LIMIT_MANAGE_ID = "borrow_limit_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_BORROW_LIMIT_MONEY = "borrow_limit_money" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_UPDATE_EMPLOYEE_ID = "update_employee_id" ;
	public final static java.lang.String CS_UPDATE_DATE = "update_date" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编号,员工姓名,部门,在职状态,主键编码,职员编码,借款额度,创建人,创建日期,更新人,更新日期";

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getBorrowLimitManageId() {
		return this.__borrow_limit_manage_id;
	}

	public void setBorrowLimitManageId( java.lang.Integer value ) {
		this.__borrow_limit_manage_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getBorrowLimitMoney() {
		return this.__borrow_limit_money;
	}

	public void setBorrowLimitMoney( java.math.BigDecimal value ) {
		this.__borrow_limit_money = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.Integer getUpdateEmployeeId() {
		return this.__update_employee_id;
	}

	public void setUpdateEmployeeId( java.lang.Integer value ) {
		this.__update_employee_id = value;
	}

	public java.util.Date getUpdateDate() {
		return this.__update_date;
	}

	public void setUpdateDate( java.util.Date value ) {
		this.__update_date = value;
	}

	public void cloneCopy(BaseBorrowMoneyManage __bean){
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setStatus(getStatus());
		__bean.setBorrowLimitManageId(getBorrowLimitManageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setBorrowLimitMoney(getBorrowLimitMoney());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setUpdateEmployeeId(getUpdateEmployeeId());
		__bean.setUpdateDate(getUpdateDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getBorrowLimitManageId() == null ? "" : getBorrowLimitManageId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getBorrowLimitMoney() == null ? "" : getBorrowLimitMoney());
		sb.append(",");
		String strCreateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getCreateEmployeeId()));
		sb.append(strCreateEmployeeId == null ? "" : strCreateEmployeeId);
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		String strUpdateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getUpdateEmployeeId()));
		sb.append(strUpdateEmployeeId == null ? "" : strUpdateEmployeeId);
		sb.append(",");
		sb.append(getUpdateDate() == null ? "" : sdf.format(getUpdateDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBorrowMoneyManage o) {
		return __borrow_limit_manage_id == null ? -1 : __borrow_limit_manage_id.compareTo(o.getBorrowLimitManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__borrow_limit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__borrow_limit_money);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__update_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__update_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBorrowMoneyManage o = (BaseBorrowMoneyManage)obj;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__borrow_limit_manage_id, o.getBorrowLimitManageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__borrow_limit_money, o.getBorrowLimitMoney())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__update_employee_id, o.getUpdateEmployeeId())) return false;
		if(!Objects.equals(this.__update_date, o.getUpdateDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getBorrowLimitManageId() != null) sb.append(__wrapNumber(count++, "borrowLimitManageId", getBorrowLimitManageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getBorrowLimitMoney() != null) sb.append(__wrapDecimal(count++, "borrowLimitMoney", getBorrowLimitMoney()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getUpdateEmployeeId() != null) sb.append(__wrapNumber(count++, "updateEmployeeId", getUpdateEmployeeId()));
		if(getUpdateDate() != null) sb.append(__wrapDate(count++, "updateDate", getUpdateDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("borrowLimitManageId")) != null) setBorrowLimitManageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("borrowLimitMoney")) != null) setBorrowLimitMoney(__getDecimal(val));  
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("updateEmployeeId")) != null) setUpdateEmployeeId(__getInt(val)); 
		if((val = values.get("updateDate")) != null) setUpdateDate(__getDate(val)); 
	}

	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __borrow_limit_manage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __borrow_limit_money ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.Integer  __update_employee_id ;
	protected java.util.Date  __update_date ;
}
