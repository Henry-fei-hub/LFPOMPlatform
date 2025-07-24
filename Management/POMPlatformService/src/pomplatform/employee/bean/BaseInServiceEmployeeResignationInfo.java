package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseInServiceEmployeeResignationInfo extends GenericBase implements BaseFactory<BaseInServiceEmployeeResignationInfo>, Comparable<BaseInServiceEmployeeResignationInfo> 
{


	public static BaseInServiceEmployeeResignationInfo newInstance(){
		return new BaseInServiceEmployeeResignationInfo();
	}

	@Override
	public BaseInServiceEmployeeResignationInfo make(){
		BaseInServiceEmployeeResignationInfo b = new BaseInServiceEmployeeResignationInfo();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;

	public final static java.lang.String ALL_CAPTIONS = "申请人,截止日期";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public void cloneCopy(BaseInServiceEmployeeResignationInfo __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEndDate(getEndDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInServiceEmployeeResignationInfo o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInServiceEmployeeResignationInfo o = (BaseInServiceEmployeeResignationInfo)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __end_date ;
}
