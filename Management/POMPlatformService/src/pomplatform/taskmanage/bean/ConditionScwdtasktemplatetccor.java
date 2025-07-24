package pomplatform.taskmanage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScwdtasktemplatetccor extends GenericCondition{

	public ConditionScwdtasktemplatetccor(){
		setParameterCount(10);
	}

	public java.lang.String getTemplateName() {
		return this.__template_name == null ? null : (this.__template_name.indexOf("%") >= 0 ? this.__template_name : "%"+this.__template_name+"%");
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no == null ? null : (this.__company_no.indexOf("%") >= 0 ? this.__company_no : "%"+this.__company_no+"%");
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.lang.Integer getCwdTaskTemplateId() {
		return this.__cwd_task_template_id;
	}

	public void setCwdTaskTemplateId( java.lang.Integer value ) {
		this.__cwd_task_template_id = value;
	}

	public java.lang.Integer getProjectArea() {
		return this.__project_area;
	}

	public void setProjectArea( java.lang.Integer value ) {
		this.__project_area = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getNumberOfDay() {
		return this.__number_of_day;
	}

	public void setNumberOfDay( java.lang.Integer value ) {
		this.__number_of_day = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getNumberOfParticipant() {
		return this.__number_of_participant;
	}

	public void setNumberOfParticipant( java.lang.Integer value ) {
		this.__number_of_participant = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTemplateName() != null) sb.append(__wrapString(1, "templateName", getTemplateName()));
		if(getCompanyNo() != null) sb.append(__wrapString(1, "companyNo", getCompanyNo()));
		if(getCwdTaskTemplateId() != null) sb.append(__wrapNumber(1, "cwdTaskTemplateId", getCwdTaskTemplateId()));
		if(getProjectArea() != null) sb.append(__wrapNumber(1, "projectArea", getProjectArea()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getNumberOfDay() != null) sb.append(__wrapNumber(1, "numberOfDay", getNumberOfDay()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		if(getNumberOfParticipant() != null) sb.append(__wrapNumber(1, "numberOfParticipant", getNumberOfParticipant()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("cwdTaskTemplateId")) != null) setCwdTaskTemplateId(__getInt(val)); 
		if((val = values.get("projectArea")) != null) setProjectArea(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("numberOfDay")) != null) setNumberOfDay(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("numberOfParticipant")) != null) setNumberOfParticipant(__getInt(val)); 
	}

	private java.lang.String __template_name = null;
	private java.lang.String __company_no = null;
	private java.lang.Integer __cwd_task_template_id = null;
	private java.lang.Integer __project_area = null;
	private java.lang.Integer __operator = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __number_of_day = null;
	private java.lang.Integer __project_level = null;
	private java.lang.Integer __number_of_participant = null;
}

