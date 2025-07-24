package pomplatform.operating.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOperatingOnPayCommonPlateIntegral extends GenericBase implements BaseFactory<BaseOperatingOnPayCommonPlateIntegral>, Comparable<BaseOperatingOnPayCommonPlateIntegral> 
{


	public static BaseOperatingOnPayCommonPlateIntegral newInstance(){
		return new BaseOperatingOnPayCommonPlateIntegral();
	}

	@Override
	public BaseOperatingOnPayCommonPlateIntegral make(){
		BaseOperatingOnPayCommonPlateIntegral b = new BaseOperatingOnPayCommonPlateIntegral();
		return b;
	}

	public final static java.lang.String CS_OWN_PLATE_ID = "own_plate_id" ;
	public final static java.lang.String CS_MANAGE_PROJECT_ID = "manage_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ASSIGNED_INTEGRAL = "assigned_integral" ;
	public final static java.lang.String CS_ASSIGN_DATE = "assign_date" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",管理项目,发放成员,已发放积分,发放日期,年份,月份,所在业务部门";

	public java.lang.Integer getOwnPlateId() {
		return this.__own_plate_id;
	}

	public void setOwnPlateId( java.lang.Integer value ) {
		this.__own_plate_id = value;
	}

	public java.lang.Integer getManageProjectId() {
		return this.__manage_project_id;
	}

	public void setManageProjectId( java.lang.Integer value ) {
		this.__manage_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return this.__assigned_integral;
	}

	public void setAssignedIntegral( java.math.BigDecimal value ) {
		this.__assigned_integral = value;
	}

	public java.util.Date getAssignDate() {
		return this.__assign_date;
	}

	public void setAssignDate( java.util.Date value ) {
		this.__assign_date = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public void cloneCopy(BaseOperatingOnPayCommonPlateIntegral __bean){
		__bean.setOwnPlateId(getOwnPlateId());
		__bean.setManageProjectId(getManageProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAssignedIntegral(getAssignedIntegral());
		__bean.setAssignDate(getAssignDate());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPlateId(getPlateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOwnPlateId() == null ? "" : getOwnPlateId());
		sb.append(",");
		String strManageProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("manage_projects", String.valueOf(getManageProjectId()));
		sb.append(strManageProjectId == null ? "" : strManageProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAssignedIntegral() == null ? "" : getAssignedIntegral());
		sb.append(",");
		sb.append(getAssignDate() == null ? "" : sdf.format(getAssignDate()));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOperatingOnPayCommonPlateIntegral o) {
		return __own_plate_id == null ? -1 : __own_plate_id.compareTo(o.getOwnPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__own_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__manage_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__assigned_integral);
		hash = 97 * hash + Objects.hashCode(this.__assign_date);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOperatingOnPayCommonPlateIntegral o = (BaseOperatingOnPayCommonPlateIntegral)obj;
		if(!Objects.equals(this.__own_plate_id, o.getOwnPlateId())) return false;
		if(!Objects.equals(this.__manage_project_id, o.getManageProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__assigned_integral, o.getAssignedIntegral())) return false;
		if(!Objects.equals(this.__assign_date, o.getAssignDate())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOwnPlateId() != null) sb.append(__wrapNumber(count++, "ownPlateId", getOwnPlateId()));
		if(getManageProjectId() != null) sb.append(__wrapNumber(count++, "manageProjectId", getManageProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAssignedIntegral() != null) sb.append(__wrapDecimal(count++, "assignedIntegral", getAssignedIntegral()));
		if(getAssignDate() != null) sb.append(__wrapDate(count++, "assignDate", getAssignDate()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("ownPlateId")) != null) setOwnPlateId(__getInt(val)); 
		if((val = values.get("manageProjectId")) != null) setManageProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("assignedIntegral")) != null) setAssignedIntegral(__getDecimal(val));  
		if((val = values.get("assignDate")) != null) setAssignDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __own_plate_id ;
	protected java.lang.Integer  __manage_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __assigned_integral ;
	protected java.util.Date  __assign_date ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __plate_id ;
}
