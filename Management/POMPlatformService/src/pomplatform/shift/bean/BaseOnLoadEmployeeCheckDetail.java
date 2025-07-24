package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadEmployeeCheckDetail extends GenericBase implements BaseFactory<BaseOnLoadEmployeeCheckDetail>, Comparable<BaseOnLoadEmployeeCheckDetail> 
{


	public static BaseOnLoadEmployeeCheckDetail newInstance(){
		return new BaseOnLoadEmployeeCheckDetail();
	}

	@Override
	public BaseOnLoadEmployeeCheckDetail make(){
		BaseOnLoadEmployeeCheckDetail b = new BaseOnLoadEmployeeCheckDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_CHECK_DATE = "check_date" ;
	public final static java.lang.String CS_CHECK_TIME_DETAILS = "check_time_details" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,员工编号,员工姓名,部门,打卡日期,打卡明细";

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

	public java.util.Date getCheckDate() {
		return this.__check_date;
	}

	public void setCheckDate( java.util.Date value ) {
		this.__check_date = value;
	}

	public java.lang.String getCheckTimeDetails() {
		return this.__check_time_details;
	}

	public void setCheckTimeDetails( java.lang.String value ) {
		this.__check_time_details = value;
	}

	public void cloneCopy(BaseOnLoadEmployeeCheckDetail __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCheckDate(getCheckDate());
		__bean.setCheckTimeDetails(getCheckTimeDetails());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getCheckDate() == null ? "" : sdf.format(getCheckDate()));
		sb.append(",");
		sb.append(getCheckTimeDetails() == null ? "" : getCheckTimeDetails());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadEmployeeCheckDetail o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__check_date);
		hash = 97 * hash + Objects.hashCode(this.__check_time_details);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadEmployeeCheckDetail o = (BaseOnLoadEmployeeCheckDetail)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__check_date, o.getCheckDate())) return false;
		if(!Objects.equals(this.__check_time_details, o.getCheckTimeDetails())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCheckDate() != null) sb.append(__wrapDate(count++, "checkDate", getCheckDate()));
		if(getCheckTimeDetails() != null) sb.append(__wrapString(count++, "checkTimeDetails", getCheckTimeDetails()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("checkDate")) != null) setCheckDate(__getDate(val)); 
		if((val = values.get("checkTimeDetails")) != null) setCheckTimeDetails(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __check_date ;
	protected java.lang.String  __check_time_details ;
}
