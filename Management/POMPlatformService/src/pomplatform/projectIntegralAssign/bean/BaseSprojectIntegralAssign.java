package pomplatform.projectIntegralAssign.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectIntegralAssign extends GenericBase implements BaseFactory<BaseSprojectIntegralAssign>, Comparable<BaseSprojectIntegralAssign> 
{


	public static BaseSprojectIntegralAssign newInstance(){
		return new BaseSprojectIntegralAssign();
	}

	@Override
	public BaseSprojectIntegralAssign make(){
		BaseSprojectIntegralAssign b = new BaseSprojectIntegralAssign();
		return b;
	}

	public final static java.lang.String CS_PROJECT_INTEGRAL_ASSIGN_RECORD_ID = "project_integral_assign_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_BEFORE_RESERVE_INTEGRAL = "before_reserve_integral" ;
	public final static java.lang.String CS_AFTER_RESERVE_INTEGRAL = "after_reserve_integral" ;
	public final static java.lang.String CS_ASSIGN_INTEGRAL = "assign_integral" ;
	public final static java.lang.String CS_ASSIGN_DATE = "assign_date" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_EMPLOYEE_ID = "plate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "ID,项目,人员,发放前预留积分,发放后预留积分,发放积分,发放日期,板块,事业部负责人,备注";

	public java.lang.Integer getProjectIntegralAssignRecordId() {
		return this.__project_integral_assign_record_id;
	}

	public void setProjectIntegralAssignRecordId( java.lang.Integer value ) {
		this.__project_integral_assign_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getBeforeReserveIntegral() {
		return this.__before_reserve_integral;
	}

	public void setBeforeReserveIntegral( java.math.BigDecimal value ) {
		this.__before_reserve_integral = value;
	}

	public java.math.BigDecimal getAfterReserveIntegral() {
		return this.__after_reserve_integral;
	}

	public void setAfterReserveIntegral( java.math.BigDecimal value ) {
		this.__after_reserve_integral = value;
	}

	public java.math.BigDecimal getAssignIntegral() {
		return this.__assign_integral;
	}

	public void setAssignIntegral( java.math.BigDecimal value ) {
		this.__assign_integral = value;
	}

	public java.util.Date getAssignDate() {
		return this.__assign_date;
	}

	public void setAssignDate( java.util.Date value ) {
		this.__assign_date = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPlateEmployeeId() {
		return this.__plate_employee_id;
	}

	public void setPlateEmployeeId( java.lang.Integer value ) {
		this.__plate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSprojectIntegralAssign __bean){
		__bean.setProjectIntegralAssignRecordId(getProjectIntegralAssignRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setBeforeReserveIntegral(getBeforeReserveIntegral());
		__bean.setAfterReserveIntegral(getAfterReserveIntegral());
		__bean.setAssignIntegral(getAssignIntegral());
		__bean.setAssignDate(getAssignDate());
		__bean.setPlateId(getPlateId());
		__bean.setPlateEmployeeId(getPlateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectIntegralAssignRecordId() == null ? "" : getProjectIntegralAssignRecordId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getBeforeReserveIntegral() == null ? "" : getBeforeReserveIntegral());
		sb.append(",");
		sb.append(getAfterReserveIntegral() == null ? "" : getAfterReserveIntegral());
		sb.append(",");
		sb.append(getAssignIntegral() == null ? "" : getAssignIntegral());
		sb.append(",");
		sb.append(getAssignDate() == null ? "" : sdf.format(getAssignDate()));
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getPlateEmployeeId() == null ? "" : getPlateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectIntegralAssign o) {
		return __project_integral_assign_record_id == null ? -1 : __project_integral_assign_record_id.compareTo(o.getProjectIntegralAssignRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_integral_assign_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__before_reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__after_reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__assign_integral);
		hash = 97 * hash + Objects.hashCode(this.__assign_date);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectIntegralAssign o = (BaseSprojectIntegralAssign)obj;
		if(!Objects.equals(this.__project_integral_assign_record_id, o.getProjectIntegralAssignRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__before_reserve_integral, o.getBeforeReserveIntegral())) return false;
		if(!Objects.equals(this.__after_reserve_integral, o.getAfterReserveIntegral())) return false;
		if(!Objects.equals(this.__assign_integral, o.getAssignIntegral())) return false;
		if(!Objects.equals(this.__assign_date, o.getAssignDate())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_employee_id, o.getPlateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectIntegralAssignRecordId() != null) sb.append(__wrapNumber(count++, "projectIntegralAssignRecordId", getProjectIntegralAssignRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getBeforeReserveIntegral() != null) sb.append(__wrapDecimal(count++, "beforeReserveIntegral", getBeforeReserveIntegral()));
		if(getAfterReserveIntegral() != null) sb.append(__wrapDecimal(count++, "afterReserveIntegral", getAfterReserveIntegral()));
		if(getAssignIntegral() != null) sb.append(__wrapDecimal(count++, "assignIntegral", getAssignIntegral()));
		if(getAssignDate() != null) sb.append(__wrapDate(count++, "assignDate", getAssignDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(count++, "plateEmployeeId", getPlateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectIntegralAssignRecordId")) != null) setProjectIntegralAssignRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("beforeReserveIntegral")) != null) setBeforeReserveIntegral(__getDecimal(val)); 
		if((val = values.get("afterReserveIntegral")) != null) setAfterReserveIntegral(__getDecimal(val)); 
		if((val = values.get("assignIntegral")) != null) setAssignIntegral(__getDecimal(val)); 
		if((val = values.get("assignDate")) != null) setAssignDate(__getDate(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_integral_assign_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __before_reserve_integral ;
	protected java.math.BigDecimal  __after_reserve_integral ;
	protected java.math.BigDecimal  __assign_integral ;
	protected java.util.Date  __assign_date ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __plate_employee_id ;
	protected java.lang.String  __remark ;
}
