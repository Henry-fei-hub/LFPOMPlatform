package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSspecialdeductionrecordsssor extends GenericCondition{

	public ConditionSspecialdeductionrecordsssor(){
		setParameterCount(5);
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
	}

	public java.lang.Integer getDeparmentId() {
		return this.__deparment_id;
	}

	public void setDeparmentId( java.lang.Integer value ) {
		this.__deparment_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeId() != null) sb.append(__wrapNumber(1, "employeId", getEmployeId()));
		if(getDeparmentId() != null) sb.append(__wrapNumber(1, "deparmentId", getDeparmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(1, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("deparmentId")) != null) setDeparmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
	}

	private java.lang.Integer __employe_id = null;
	private java.lang.Integer __deparment_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Boolean __is_enable = null;
}

