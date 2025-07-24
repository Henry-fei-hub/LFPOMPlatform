package pomplatform.projectteambuild.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionSemployeeedror extends GenericCondition{

	public ConditionSemployeeedror(){
		setParameterCount(5);
	}

	public String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( Integer value ) {
		this.__role_id = value;
	}

	public Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( Integer value ) {
		this.__grade_id = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getRoleId() != null) sb.append(__wrapNumber(1, "roleId", getRoleId()));
		if(getGradeId() != null) sb.append(__wrapNumber(1, "gradeId", getGradeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getEmployeeName() != null) res.add("employeeName");
		if(getDepartmentId() != null) res.add("departmentId");
		if(getRoleId() != null) res.add("roleId");
		if(getGradeId() != null) res.add("gradeId");
		if(getPlateId() != null) res.add("plateId");
		return res;
	}

	private String __employee_name = null;
	private Integer __department_id = null;
	private Integer __role_id = null;
	private Integer __grade_id = null;
	private Integer __plate_id = null;
}

