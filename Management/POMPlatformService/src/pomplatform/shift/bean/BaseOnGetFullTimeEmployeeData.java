package pomplatform.shift.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnGetFullTimeEmployeeData extends GenericBase implements BaseFactory<BaseOnGetFullTimeEmployeeData>, Comparable<BaseOnGetFullTimeEmployeeData> 
{


	public static BaseOnGetFullTimeEmployeeData newInstance(){
		return new BaseOnGetFullTimeEmployeeData();
	}

	@Override
	public BaseOnGetFullTimeEmployeeData make(){
		BaseOnGetFullTimeEmployeeData b = new BaseOnGetFullTimeEmployeeData();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_FULL_TIME_NUM = "full_time_num" ;
	public final static java.lang.String CS_FULL_TIME_MONTHS = "full_time_months" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,年份,员工编号,员工姓名,部门名称,全勤月数量,全勤月份";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
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

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.lang.Integer getFullTimeNum() {
		return this.__full_time_num;
	}

	public void setFullTimeNum( java.lang.Integer value ) {
		this.__full_time_num = value;
	}

	public java.lang.String getFullTimeMonths() {
		return this.__full_time_months;
	}

	public void setFullTimeMonths( java.lang.String value ) {
		this.__full_time_months = value;
	}

	public void cloneCopy(BaseOnGetFullTimeEmployeeData __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setFullTimeNum(getFullTimeNum());
		__bean.setFullTimeMonths(getFullTimeMonths());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getFullTimeNum() == null ? "" : getFullTimeNum());
		sb.append(",");
		sb.append(getFullTimeMonths() == null ? "" : getFullTimeMonths());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnGetFullTimeEmployeeData o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__full_time_num);
		hash = 97 * hash + Objects.hashCode(this.__full_time_months);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnGetFullTimeEmployeeData o = (BaseOnGetFullTimeEmployeeData)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__full_time_num, o.getFullTimeNum())) return false;
		if(!Objects.equals(this.__full_time_months, o.getFullTimeMonths())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getFullTimeNum() != null) sb.append(__wrapNumber(count++, "fullTimeNum", getFullTimeNum()));
		if(getFullTimeMonths() != null) sb.append(__wrapString(count++, "fullTimeMonths", getFullTimeMonths()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getYear() != null) res.put("year", getYear());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentName() != null) res.put("departmentName", getDepartmentName());
		if(getFullTimeNum() != null) res.put("fullTimeNum", getFullTimeNum());
		if(getFullTimeMonths() != null) res.put("fullTimeMonths", getFullTimeMonths());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("fullTimeNum")) != null) setFullTimeNum(__getInt(val)); 
		if((val = values.get("fullTimeMonths")) != null) setFullTimeMonths(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __department_name ;
	protected java.lang.Integer  __full_time_num ;
	protected java.lang.String  __full_time_months ;
}
