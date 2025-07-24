package pomplatform.annoucement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSannoucementaaaor extends GenericCondition{

	public ConditionSannoucementaaaor(){
		setParameterCount(5);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getAnnoucementTime() {
		return this.__annoucement_time;
	}

	public void setAnnoucementTime( java.util.Date value ) {
		this.__annoucement_time = value;
	}

	public java.lang.String getAnnoucementTitle() {
		return this.__annoucement_title == null ? null : (this.__annoucement_title.indexOf("%") >= 0 ? this.__annoucement_title : "%"+this.__annoucement_title+"%");
	}

	public void setAnnoucementTitle( java.lang.String value ) {
		this.__annoucement_title = value;
	}

	public java.lang.String getAnnoucementContent() {
		return this.__annoucement_content == null ? null : (this.__annoucement_content.indexOf("%") >= 0 ? this.__annoucement_content : "%"+this.__annoucement_content+"%");
	}

	public void setAnnoucementContent( java.lang.String value ) {
		this.__annoucement_content = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getAnnoucementTime() != null) sb.append(__wrapDate(1, "annoucementTime", getAnnoucementTime()));
		if(getAnnoucementTitle() != null) sb.append(__wrapString(1, "annoucementTitle", getAnnoucementTitle()));
		if(getAnnoucementContent() != null) sb.append(__wrapString(1, "annoucementContent", getAnnoucementContent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("annoucementTime")) != null) setAnnoucementTime(__getDate(val)); 
		if((val = values.get("annoucementTitle")) != null) setAnnoucementTitle(__getString(val));
		if((val = values.get("annoucementContent")) != null) setAnnoucementContent(__getString(val));
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.util.Date __annoucement_time = null;
	private java.lang.String __annoucement_title = null;
	private java.lang.String __annoucement_content = null;
}

