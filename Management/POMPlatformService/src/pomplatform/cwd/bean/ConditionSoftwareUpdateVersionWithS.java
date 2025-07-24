package pomplatform.cwd .bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSoftwareUpdateVersionWithS extends GenericCondition{

	public ConditionSoftwareUpdateVersionWithS(){
		setParameterCount(8);
	}

	public java.lang.String getTitle() {
		return this.__title == null ? null : (this.__title.indexOf("%") >= 0 ? this.__title : "%"+this.__title+"%");
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getSqlScript() {
		return this.__sql_script == null ? null : (this.__sql_script.indexOf("%") >= 0 ? this.__sql_script : "%"+this.__sql_script+"%");
	}

	public void setSqlScript( java.lang.String value ) {
		this.__sql_script = value;
	}

	public java.lang.Integer getSoftwareUpdateVersionId() {
		return this.__software_update_version_id;
	}

	public void setSoftwareUpdateVersionId( java.lang.Integer value ) {
		this.__software_update_version_id = value;
	}

	public java.math.BigDecimal getVersionNo() {
		return this.__version_no;
	}

	public void setVersionNo( java.math.BigDecimal value ) {
		this.__version_no = value;
	}

	public java.lang.Integer getSoftwareType() {
		return this.__software_type;
	}

	public void setSoftwareType( java.lang.Integer value ) {
		this.__software_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Boolean getIsReboot() {
		return this.__is_reboot;
	}

	public void setIsReboot( java.lang.Boolean value ) {
		this.__is_reboot = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTitle() != null) sb.append(__wrapString(1, "title", getTitle()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getSqlScript() != null) sb.append(__wrapString(1, "sqlScript", getSqlScript()));
		if(getSoftwareUpdateVersionId() != null) sb.append(__wrapNumber(1, "softwareUpdateVersionId", getSoftwareUpdateVersionId()));
		if(getVersionNo() != null) sb.append(__wrapNumber(1, "versionNo", getVersionNo()));
		if(getSoftwareType() != null) sb.append(__wrapNumber(1, "softwareType", getSoftwareType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getIsReboot() != null) sb.append(__wrapBoolean(1, "isReboot", getIsReboot()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("sqlScript")) != null) setSqlScript(__getString(val));
		if((val = values.get("softwareUpdateVersionId")) != null) setSoftwareUpdateVersionId(__getInt(val)); 
		if((val = values.get("versionNo")) != null) setVersionNo(__getDecimal(val));  
		if((val = values.get("softwareType")) != null) setSoftwareType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("isReboot")) != null) setIsReboot(__getBoolean(val));
	}

	private java.lang.String __title = null;
	private java.lang.String __remark = null;
	private java.lang.String __sql_script = null;
	private java.lang.Integer __software_update_version_id = null;
	private java.math.BigDecimal __version_no = null;
	private java.lang.Integer __software_type = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Boolean __is_reboot = null;
}

