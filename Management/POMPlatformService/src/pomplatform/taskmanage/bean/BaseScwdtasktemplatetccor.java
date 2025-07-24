package pomplatform.taskmanage.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseScwdtasktemplatetccor extends GenericBase implements BaseFactory<BaseScwdtasktemplatetccor>, Comparable<BaseScwdtasktemplatetccor> 
{


	public static BaseScwdtasktemplatetccor newInstance(){
		return new BaseScwdtasktemplatetccor();
	}

	@Override
	public BaseScwdtasktemplatetccor make(){
		BaseScwdtasktemplatetccor b = new BaseScwdtasktemplatetccor();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_TEMPLATE_ID = "cwd_task_template_id" ;
	public final static java.lang.String CS_TEMPLATE_NAME = "template_name" ;
	public final static java.lang.String CS_PROJECT_AREA = "project_area" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_NUMBER_OF_DAY = "number_of_day" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_NUMBER_OF_PARTICIPANT = "number_of_participant" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,模板名称,项目面积,操作人,创建时间,部门,归属公司编码,公司编号,天数(周期),项目类型,参与人数";

	public java.lang.Integer getCwdTaskTemplateId() {
		return this.__cwd_task_template_id;
	}

	public void setCwdTaskTemplateId( java.lang.Integer value ) {
		this.__cwd_task_template_id = value;
	}

	public java.lang.String getTemplateName() {
		return this.__template_name;
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
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

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
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

	public void cloneCopy(BaseScwdtasktemplatetccor __bean){
		__bean.setCwdTaskTemplateId(getCwdTaskTemplateId());
		__bean.setTemplateName(getTemplateName());
		__bean.setProjectArea(getProjectArea());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setNumberOfDay(getNumberOfDay());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setNumberOfParticipant(getNumberOfParticipant());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskTemplateId() == null ? "" : getCwdTaskTemplateId());
		sb.append(",");
		sb.append(getTemplateName() == null ? "" : getTemplateName());
		sb.append(",");
		sb.append(getProjectArea() == null ? "" : getProjectArea());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getNumberOfDay() == null ? "" : getNumberOfDay());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getNumberOfParticipant() == null ? "" : getNumberOfParticipant());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseScwdtasktemplatetccor o) {
		return __cwd_task_template_id == null ? -1 : __cwd_task_template_id.compareTo(o.getCwdTaskTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_template_id);
		hash = 97 * hash + Objects.hashCode(this.__template_name);
		hash = 97 * hash + Objects.hashCode(this.__project_area);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__number_of_day);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__number_of_participant);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseScwdtasktemplatetccor o = (BaseScwdtasktemplatetccor)obj;
		if(!Objects.equals(this.__cwd_task_template_id, o.getCwdTaskTemplateId())) return false;
		if(!Objects.equals(this.__template_name, o.getTemplateName())) return false;
		if(!Objects.equals(this.__project_area, o.getProjectArea())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__number_of_day, o.getNumberOfDay())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__number_of_participant, o.getNumberOfParticipant())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskTemplateId() != null) sb.append(__wrapNumber(count++, "cwdTaskTemplateId", getCwdTaskTemplateId()));
		if(getTemplateName() != null) sb.append(__wrapString(count++, "templateName", getTemplateName()));
		if(getProjectArea() != null) sb.append(__wrapNumber(count++, "projectArea", getProjectArea()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getNumberOfDay() != null) sb.append(__wrapNumber(count++, "numberOfDay", getNumberOfDay()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getNumberOfParticipant() != null) sb.append(__wrapNumber(count++, "numberOfParticipant", getNumberOfParticipant()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskTemplateId")) != null) setCwdTaskTemplateId(__getInt(val)); 
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("projectArea")) != null) setProjectArea(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("numberOfDay")) != null) setNumberOfDay(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("numberOfParticipant")) != null) setNumberOfParticipant(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_template_id ;
	protected java.lang.String  __template_name ;
	protected java.lang.Integer  __project_area ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.lang.Integer  __number_of_day ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __number_of_participant ;
}
