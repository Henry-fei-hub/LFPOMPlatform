package pomplatform.equipment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionEquipmentDetail extends GenericCondition{

	public ConditionEquipmentDetail(){
		setParameterCount(7);
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getNextAuditor() {
		return this.__next_auditor;
	}

	public void setNextAuditor( Integer value ) {
		this.__next_auditor = value;
	}

	public String getEquipmentName() {
		return this.__equipment_name == null ? null : (this.__equipment_name.indexOf("%") >= 0 ? this.__equipment_name : "%"+this.__equipment_name+"%");
	}

	public void setEquipmentName( String value ) {
		this.__equipment_name = value;
	}

	public Short getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( Short value ) {
		this.__operation_type = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getNextAuditor() != null) sb.append(__wrapNumber(1, "nextAuditor", getNextAuditor()));
		if(getEquipmentName() != null) sb.append(__wrapString(1, "equipmentName", getEquipmentName()));
		if(getOperationType() != null) sb.append(__wrapNumber(1, "operationType", getOperationType()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("nextAuditor")) != null) setNextAuditor(__getInt(val)); 
		if((val = values.get("equipmentName")) != null) setEquipmentName(__getString(val));
		if((val = values.get("operationType")) != null) setOperationType(__getShort(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getDepartmentId() != null) res.add("departmentId");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getNextAuditor() != null) res.add("nextAuditor");
		if(getEquipmentName() != null) res.add("equipmentName");
		if(getOperationType() != null) res.add("operationType");
		if(getStartDate() != null) res.add("startDate");
		if(getEndDate() != null) res.add("endDate");
		return res;
	}

	private Integer __department_id = null;
	private Integer __employee_id = null;
	private Integer __next_auditor = null;
	private String __equipment_name = null;
	private Short __operation_type = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
}

