package pomplatform.operation.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionProjectManager extends GenericCondition{

	public final static String NAME_START_DATE = "startDate" ;
	public final static String NAME_END_DATE = "endDate" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_PLATE_ID = "plateId" ;
	public final static String NAME_DEPARTMENT_MANAGER_ID = "departmentManagerId" ;
	public final static String NAME_CONTRACT_CODE = "contractCode" ;
	public final static String NAME_DESIGN_TYPE = "designType" ;
	public final static String NAME_PROJECT_LEVEL = "projectLevel" ;
	public final static String NAME_STATUS = "status" ;
	public final static String NAME_PROJECT_NAME = "projectName" ;
	public final static String NAME_PROJECT_FLAG = "projectFlag" ;

	public ConditionProjectManager(){
		setParameterCount(11);
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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getDesignType() {
		return this.__design_type;
	}

	public void setDesignType( java.lang.Integer value ) {
		this.__design_type = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStartDate() != null) res.put(NAME_START_DATE, getStartDate());
		if(getEndDate() != null) res.put(NAME_END_DATE, getEndDate());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getPlateId() != null) res.put(NAME_PLATE_ID, getPlateId());
		if(getDepartmentManagerId() != null) res.put(NAME_DEPARTMENT_MANAGER_ID, getDepartmentManagerId());
		if(getContractCode() != null) res.put(NAME_CONTRACT_CODE, getContractCode());
		if(getDesignType() != null) res.put(NAME_DESIGN_TYPE, getDesignType());
		if(getProjectLevel() != null) res.put(NAME_PROJECT_LEVEL, getProjectLevel());
		if(getStatus() != null) res.put(NAME_STATUS, getStatus());
		if(getProjectName() != null) res.put(NAME_PROJECT_NAME, getProjectName());
		if(getProjectFlag() != null) res.put(NAME_PROJECT_FLAG, getProjectFlag());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, NAME_START_DATE, getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, NAME_END_DATE, getEndDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, NAME_PLATE_ID, getPlateId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(1, NAME_DEPARTMENT_MANAGER_ID, getDepartmentManagerId()));
		if(getContractCode() != null) sb.append(__wrapString(1, NAME_CONTRACT_CODE, getContractCode()));
		if(getDesignType() != null) sb.append(__wrapNumber(1, NAME_DESIGN_TYPE, getDesignType()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, NAME_PROJECT_LEVEL, getProjectLevel()));
		if(getStatus() != null) sb.append(__wrapNumber(1, NAME_STATUS, getStatus()));
		if(getProjectName() != null) sb.append(__wrapString(1, NAME_PROJECT_NAME, getProjectName()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(1, NAME_PROJECT_FLAG, getProjectFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if(values.containsKey(NAME_START_DATE) && (val = values.get(NAME_START_DATE)) != null) setStartDate(__getDate(val)); 
		if(values.containsKey(NAME_END_DATE) && (val = values.get(NAME_END_DATE)) != null) setEndDate(__getDate(val)); 
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_PLATE_ID) && (val = values.get(NAME_PLATE_ID)) != null) setPlateId(__getInt(val)); 
		if(values.containsKey(NAME_DEPARTMENT_MANAGER_ID) && (val = values.get(NAME_DEPARTMENT_MANAGER_ID)) != null) setDepartmentManagerId(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_CODE) && (val = values.get(NAME_CONTRACT_CODE)) != null) setContractCode(__getString(val));
		if(values.containsKey(NAME_DESIGN_TYPE) && (val = values.get(NAME_DESIGN_TYPE)) != null) setDesignType(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_LEVEL) && (val = values.get(NAME_PROJECT_LEVEL)) != null) setProjectLevel(__getInt(val)); 
		if(values.containsKey(NAME_STATUS) && (val = values.get(NAME_STATUS)) != null) setStatus(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_NAME) && (val = values.get(NAME_PROJECT_NAME)) != null) setProjectName(__getString(val));
		if(values.containsKey(NAME_PROJECT_FLAG) && (val = values.get(NAME_PROJECT_FLAG)) != null) setProjectFlag(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStartDate() != null) res.add(NAME_START_DATE);
		if(getEndDate() != null) res.add(NAME_END_DATE);
		if(getEmployeeId() != null) res.add(NAME_EMPLOYEE_ID);
		if(getPlateId() != null) res.add(NAME_PLATE_ID);
		if(getDepartmentManagerId() != null) res.add(NAME_DEPARTMENT_MANAGER_ID);
		if(getContractCode() != null) res.add(NAME_CONTRACT_CODE);
		if(getDesignType() != null) res.add(NAME_DESIGN_TYPE);
		if(getProjectLevel() != null) res.add(NAME_PROJECT_LEVEL);
		if(getStatus() != null) res.add(NAME_STATUS);
		if(getProjectName() != null) res.add(NAME_PROJECT_NAME);
		if(getProjectFlag() != null) res.add(NAME_PROJECT_FLAG);
		return res;
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_manager_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __design_type = null;
	private java.lang.Integer __project_level = null;
	private java.lang.Integer __status = null;
	private java.lang.String __project_name = null;
	private java.lang.Integer __project_flag = null;
}

