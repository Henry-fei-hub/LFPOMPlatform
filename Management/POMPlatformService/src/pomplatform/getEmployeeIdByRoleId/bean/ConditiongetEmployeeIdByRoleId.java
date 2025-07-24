package pomplatform.getEmployeeIdByRoleId.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditiongetEmployeeIdByRoleId extends GenericCondition{

	public ConditiongetEmployeeIdByRoleId(){
		setParameterCount(3);
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}
	

	public java.util.Date getChangePlateDate() {
		return __change_plate_date;
	}

	public void setChangePlateDate(java.util.Date value) {
		this.__change_plate_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getRoleId() != null) sb.append(__wrapNumber(1, "roleId", getRoleId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getChangePlateDate() != null) sb.append(__wrapDate(1, "changePlateDate", getChangePlateDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("changePlateDate")) != null) setChangePlateDate(__getDate(val)); 
	}

	private java.lang.Integer __role_id = null;
	private java.lang.Integer __plate_id = null;
	private java.util.Date __change_plate_date = null;
}

