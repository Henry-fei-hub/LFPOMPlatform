package pomplatform.manageProjectEmployeeRecordEachMonth.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseManageProjectEmployeeRecordEachMonth extends GenericBase implements BaseFactory<BaseManageProjectEmployeeRecordEachMonth>, Comparable<BaseManageProjectEmployeeRecordEachMonth> 
{


	public static BaseManageProjectEmployeeRecordEachMonth newInstance(){
		return new BaseManageProjectEmployeeRecordEachMonth();
	}

	@Override
	public BaseManageProjectEmployeeRecordEachMonth make(){
		BaseManageProjectEmployeeRecordEachMonth b = new BaseManageProjectEmployeeRecordEachMonth();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_ASSIGNED_INTEGRAL = "assigned_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "员工姓名,工号,年份,月份,补贴奖金";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return this.__assigned_integral;
	}

	public void setAssignedIntegral( java.math.BigDecimal value ) {
		this.__assigned_integral = value;
	}

	public void cloneCopy(BaseManageProjectEmployeeRecordEachMonth __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setAssignedIntegral(getAssignedIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strYear = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_18", String.valueOf(getYear()));
		sb.append(strYear == null ? "" : strYear);
		sb.append(",");
		String strMonth = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_19", String.valueOf(getMonth()));
		sb.append(strMonth == null ? "" : strMonth);
		sb.append(",");
		sb.append(getAssignedIntegral() == null ? "" : getAssignedIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseManageProjectEmployeeRecordEachMonth o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__assigned_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseManageProjectEmployeeRecordEachMonth o = (BaseManageProjectEmployeeRecordEachMonth)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__assigned_integral, o.getAssignedIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getAssignedIntegral() != null) sb.append(__wrapDecimal(count++, "assignedIntegral", getAssignedIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("assignedIntegral")) != null) setAssignedIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __assigned_integral ;
}
