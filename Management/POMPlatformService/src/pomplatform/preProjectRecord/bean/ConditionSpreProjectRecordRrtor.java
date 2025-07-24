package pomplatform.preProjectRecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSpreProjectRecordRrtor extends GenericCondition{

	public ConditionSpreProjectRecordRrtor(){
		setParameterCount(10);
	}

	public java.lang.String getRelevantEmployees() {
		return this.__relevant_employees == null ? null : (this.__relevant_employees.indexOf("%") >= 0 ? this.__relevant_employees : "%"+this.__relevant_employees+"%");
	}

	public void setRelevantEmployees( java.lang.String value ) {
		this.__relevant_employees = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getTrackCode() {
		return this.__track_code == null ? null : (this.__track_code.indexOf("%") >= 0 ? this.__track_code : "%"+this.__track_code+"%");
	}

	public void setTrackCode( java.lang.String value ) {
		this.__track_code = value;
	}

	public java.lang.Integer getPreProjectRecordId() {
		return this.__pre_project_record_id;
	}

	public void setPreProjectRecordId( java.lang.Integer value ) {
		this.__pre_project_record_id = value;
	}

	public java.util.Date getTrackDate() {
		return this.__track_date;
	}

	public void setTrackDate( java.util.Date value ) {
		this.__track_date = value;
	}

	public java.lang.Integer getInformationType() {
		return this.__information_type;
	}

	public void setInformationType( java.lang.Integer value ) {
		this.__information_type = value;
	}

	public java.lang.Integer getRegisterEmployee() {
		return this.__register_employee;
	}

	public void setRegisterEmployee( java.lang.Integer value ) {
		this.__register_employee = value;
	}

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}
	 
	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}
	
	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getRelevantEmployees() != null) sb.append(__wrapString(1, "relevantEmployees", getRelevantEmployees()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getTrackCode() != null) sb.append(__wrapString(1, "trackCode", getTrackCode()));
		if(getPreProjectRecordId() != null) sb.append(__wrapNumber(1, "preProjectRecordId", getPreProjectRecordId()));
		if(getTrackDate() != null) sb.append(__wrapDate(1, "trackDate", getTrackDate()));
		if(getInformationType() != null) sb.append(__wrapNumber(1, "informationType", getInformationType()));
		if(getRegisterEmployee() != null) sb.append(__wrapNumber(1, "registerEmployee", getRegisterEmployee()));
		if(getRegisterDate() != null) sb.append(__wrapDate(1, "registerDate", getRegisterDate()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(1, "preProjectId", getPreProjectId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("relevantEmployees")) != null) setRelevantEmployees(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("trackCode")) != null) setTrackCode(__getString(val));
		if((val = values.get("preProjectRecordId")) != null) setPreProjectRecordId(__getInt(val)); 
		if((val = values.get("trackDate")) != null) setTrackDate(__getDate(val)); 
		if((val = values.get("informationType")) != null) setInformationType(__getInt(val)); 
		if((val = values.get("registerEmployee")) != null) setRegisterEmployee(__getInt(val)); 
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val));
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	private java.lang.String __relevant_employees = null;
	private java.lang.String __remark = null;
	private java.lang.String __track_code = null;
	private java.lang.Integer __pre_project_record_id = null;
	private java.util.Date __track_date = null;
	private java.lang.Integer __information_type = null;
	private java.lang.Integer __register_employee = null;
	private java.util.Date __register_date = null;
	private java.lang.Integer __pre_project_id = null;
	private java.lang.Integer __main_project_id = null;
}
