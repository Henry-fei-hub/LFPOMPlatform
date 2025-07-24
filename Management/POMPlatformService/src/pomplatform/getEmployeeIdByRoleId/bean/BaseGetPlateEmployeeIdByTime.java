package pomplatform.getEmployeeIdByRoleId.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetPlateEmployeeIdByTime extends GenericBase implements BaseFactory<BaseGetPlateEmployeeIdByTime>, Comparable<BaseGetPlateEmployeeIdByTime> 
{


	public static BaseGetPlateEmployeeIdByTime newInstance(){
		return new BaseGetPlateEmployeeIdByTime();
	}

	@Override
	public BaseGetPlateEmployeeIdByTime make(){
		BaseGetPlateEmployeeIdByTime b = new BaseGetPlateEmployeeIdByTime();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CHANGE_PLATE_DATE = "change_plate_date" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,转岗时间（主要用于排序和修改）,员工编号,员工姓名";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getChangePlateDate() {
		return this.__change_plate_date;
	}

	public void setChangePlateDate( java.util.Date value ) {
		this.__change_plate_date = value;
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

	public void cloneCopy(BaseGetPlateEmployeeIdByTime __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setChangePlateDate(getChangePlateDate());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getChangePlateDate() == null ? "" : sdf.format(getChangePlateDate()));
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetPlateEmployeeIdByTime o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__change_plate_date);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetPlateEmployeeIdByTime o = (BaseGetPlateEmployeeIdByTime)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__change_plate_date, o.getChangePlateDate())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getChangePlateDate() != null) sb.append(__wrapDate(count++, "changePlateDate", getChangePlateDate()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("changePlateDate")) != null) setChangePlateDate(__getDate(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __change_plate_date ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
}
