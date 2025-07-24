package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionStravelreimbursementmmmor extends GenericCondition{

	public ConditionStravelreimbursementmmmor(){
		setParameterCount(10);
	}

	public java.util.Date getMinStartDate() {
		return this.__min_start_date;
	}

	public void setMinStartDate( java.util.Date value ) {
		this.__min_start_date = value;
	}

	public java.util.Date getMaxStartDate() {
		return this.__max_start_date;
	}

	public void setMaxStartDate( java.util.Date value ) {
		this.__max_start_date = value;
	}

	public java.util.Date getMinEndDate() {
		return this.__min_end_date;
	}

	public void setMinEndDate( java.util.Date value ) {
		this.__min_end_date = value;
	}

	public java.util.Date getMaxEndDate() {
		return this.__max_end_date;
	}

	public void setMaxEndDate( java.util.Date value ) {
		this.__max_end_date = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
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

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Boolean getIsProject() {
		return this.__is_project;
	}

	public void setIsProject( java.lang.Boolean value ) {
		this.__is_project = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinStartDate() != null) sb.append(__wrapDate(1, "minStartDate", getMinStartDate()));
		if(getMaxStartDate() != null) sb.append(__wrapDate(1, "maxStartDate", getMaxStartDate()));
		if(getMinEndDate() != null) sb.append(__wrapDate(1, "minEndDate", getMinEndDate()));
		if(getMaxEndDate() != null) sb.append(__wrapDate(1, "maxEndDate", getMaxEndDate()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getTitle() != null) sb.append(__wrapString(1, "title", getTitle()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(1, "processInstanceId", getProcessInstanceId()));
		if(getIsProject() != null) sb.append(__wrapBoolean(1, "isProject", getIsProject()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minStartDate")) != null) setMinStartDate(__getDate(val)); 
		if((val = values.get("maxStartDate")) != null) setMaxStartDate(__getDate(val)); 
		if((val = values.get("minEndDate")) != null) setMinEndDate(__getDate(val)); 
		if((val = values.get("maxEndDate")) != null) setMaxEndDate(__getDate(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("isProject")) != null) setIsProject(__getBoolean(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	private java.util.Date __min_start_date = null;
	private java.util.Date __max_start_date = null;
	private java.util.Date __min_end_date = null;
	private java.util.Date __max_end_date = null;
	private java.lang.String __code = null;
	private java.lang.String __title = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __process_instance_id = null;
	private java.lang.Boolean __is_project = null;
	private java.lang.Integer __delete_flag = null;
}

