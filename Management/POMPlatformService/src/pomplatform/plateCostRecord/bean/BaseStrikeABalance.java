package pomplatform.plateCostRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseStrikeABalance extends GenericBase implements BaseFactory<BaseStrikeABalance>, Comparable<BaseStrikeABalance> 
{


	public static BaseStrikeABalance newInstance(){
		return new BaseStrikeABalance();
	}

	@Override
	public BaseStrikeABalance make(){
		BaseStrikeABalance b = new BaseStrikeABalance();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RETURN_DATE = "return_date" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RETURN_MONEY = "return_money" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,业务编码,创建人,冲账日期,摘要,部门,冲账金额";

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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getReturnDate() {
		return this.__return_date;
	}

	public void setReturnDate( java.util.Date value ) {
		this.__return_date = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getReturnMoney() {
		return this.__return_money;
	}

	public void setReturnMoney( java.math.BigDecimal value ) {
		this.__return_money = value;
	}

	public void cloneCopy(BaseStrikeABalance __bean){
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setReturnDate(getReturnDate());
		__bean.setTitleName(getTitleName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setReturnMoney(getReturnMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getReturnDate() == null ? "" : sdf.format(getReturnDate()));
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getReturnMoney() == null ? "" : getReturnMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStrikeABalance o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__return_date);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__return_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStrikeABalance o = (BaseStrikeABalance)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__return_date, o.getReturnDate())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__return_money, o.getReturnMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getReturnDate() != null) sb.append(__wrapDate(count++, "returnDate", getReturnDate()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getReturnMoney() != null) sb.append(__wrapDecimal(count++, "returnMoney", getReturnMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("returnDate")) != null) setReturnDate(__getDate(val)); 
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("returnMoney")) != null) setReturnMoney(__getDecimal(val));  
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __return_date ;
	protected java.lang.String  __title_name ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __return_money ;
}
