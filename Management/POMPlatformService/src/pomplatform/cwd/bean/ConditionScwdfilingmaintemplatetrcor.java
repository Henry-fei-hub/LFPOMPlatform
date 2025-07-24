package pomplatform.cwd.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScwdfilingmaintemplatetrcor extends GenericCondition{

	public ConditionScwdfilingmaintemplatetrcor(){
		setParameterCount(6);
	}

	public java.lang.String getTemplateName() {
		return this.__template_name == null ? null : (this.__template_name.indexOf("%") >= 0 ? this.__template_name : "%"+this.__template_name+"%");
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getCwdFilingMainTemplateId() {
		return this.__cwd_filing_main_template_id;
	}

	public void setCwdFilingMainTemplateId( java.lang.Integer value ) {
		this.__cwd_filing_main_template_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTemplateName() != null) sb.append(__wrapString(1, "templateName", getTemplateName()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getCwdFilingMainTemplateId() != null) sb.append(__wrapNumber(1, "cwdFilingMainTemplateId", getCwdFilingMainTemplateId()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("cwdFilingMainTemplateId")) != null) setCwdFilingMainTemplateId(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.String __template_name = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __cwd_filing_main_template_id = null;
	private java.lang.Integer __project_type = null;
	private java.lang.Integer __operator_id = null;
	private java.lang.Integer __department_id = null;
}

