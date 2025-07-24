package pomplatform.activityMpcor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSactivityMpcor extends GenericCondition{

	public ConditionSactivityMpcor(){
		setParameterCount(9);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
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

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name == null ? null : (this.__contact_name.indexOf("%") >= 0 ? this.__contact_name : "%"+this.__contact_name+"%");
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.Integer getMeetType() {
		return this.__meet_type;
	}

	public void setMeetType( java.lang.Integer value ) {
		this.__meet_type = value;
	}

	public java.lang.String getMeetTitle() {
		return this.__meet_title == null ? null : (this.__meet_title.indexOf("%") >= 0 ? this.__meet_title : "%"+this.__meet_title+"%");
	}

	public void setMeetTitle( java.lang.String value ) {
		this.__meet_title = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}
	
	public java.lang.String getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.String value ) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getContactName() != null) sb.append(__wrapString(1, "contactName", getContactName()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getMeetType() != null) sb.append(__wrapNumber(1, "meetType", getMeetType()));
		if(getMeetTitle() != null) sb.append(__wrapString(1, "meetTitle", getMeetTitle()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getProvince() != null) sb.append(__wrapString(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(1, "city", getCity()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("meetType")) != null) setMeetType(__getInt(val)); 
		if((val = values.get("meetTitle")) != null) setMeetTitle(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
	}

	private java.lang.Integer __operate_employee_id = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.String __project_name = null;
	private java.lang.String __contact_name = null;
	private java.lang.String __customer_name = null;
	private java.lang.Integer __meet_type = null;
	private java.lang.String __meet_title = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __province = null;
	private java.lang.String __city = null;
}

