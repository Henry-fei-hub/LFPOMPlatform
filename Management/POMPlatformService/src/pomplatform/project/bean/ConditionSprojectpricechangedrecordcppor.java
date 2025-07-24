package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectpricechangedrecordcppor extends GenericCondition{

	public ConditionSprojectpricechangedrecordcppor(){
		setParameterCount(11);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getProjectPriceChangedRecordId() {
		return this.__project_price_changed_record_id;
	}

	public void setProjectPriceChangedRecordId( java.lang.Integer value ) {
		this.__project_price_changed_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.String getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.String value ) {
		this.__month = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.util.Date getRecordTime() {
		return this.__record_time;
	}

	public void setRecordTime( java.util.Date value ) {
		this.__record_time = value;
	}

	public java.lang.Integer getSubsidiesType() {
		return this.__subsidies_type;
	}

	public void setSubsidiesType( java.lang.Integer value ) {
		this.__subsidies_type = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectPriceChangedRecordId() != null) sb.append(__wrapNumber(1, "projectPriceChangedRecordId", getProjectPriceChangedRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapString(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapString(1, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(1, "recordDate", getRecordDate()));
		if(getRecordTime() != null) sb.append(__wrapDate(1, "recordTime", getRecordTime()));
		if(getSubsidiesType() != null) sb.append(__wrapNumber(1, "subsidiesType", getSubsidiesType()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectPriceChangedRecordId")) != null) setProjectPriceChangedRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("month")) != null) setMonth(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("recordTime")) != null) setRecordTime(__getDate(val)); 
		if((val = values.get("subsidiesType")) != null) setSubsidiesType(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.Integer __project_price_changed_record_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __year = null;
	private java.lang.String __month = null;
	private java.util.Date __record_date = null;
	private java.util.Date __record_time = null;
	private java.lang.Integer __subsidies_type = null;
	private java.lang.Integer __operate_employee_id = null;
}

