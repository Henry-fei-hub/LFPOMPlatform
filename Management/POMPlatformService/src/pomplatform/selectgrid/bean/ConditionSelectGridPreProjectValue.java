package pomplatform.selectgrid.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSelectGridPreProjectValue extends GenericCondition{

	public ConditionSelectGridPreProjectValue(){
		setParameterCount(5);
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getCustomNumber() {
		return this.__custom_number == null ? null : (this.__custom_number.indexOf("%") >= 0 ? this.__custom_number : "%"+this.__custom_number+"%");
	}

	public void setCustomNumber( java.lang.String value ) {
		this.__custom_number = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPreProjectReimbursementNumberId() {
		return this.__pre_project_reimbursement_number_id;
	}

	public void setPreProjectReimbursementNumberId( java.lang.Integer value ) {
		this.__pre_project_reimbursement_number_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getCustomNumber() != null) sb.append(__wrapString(1, "customNumber", getCustomNumber()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getPreProjectReimbursementNumberId() != null) sb.append(__wrapNumber(1, "preProjectReimbursementNumberId", getPreProjectReimbursementNumberId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("customNumber")) != null) setCustomNumber(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("preProjectReimbursementNumberId")) != null) setPreProjectReimbursementNumberId(__getInt(val)); 
	}

	private java.lang.String __project_name = null;
	private java.lang.String __custom_number = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __pre_project_reimbursement_number_id = null;
}

