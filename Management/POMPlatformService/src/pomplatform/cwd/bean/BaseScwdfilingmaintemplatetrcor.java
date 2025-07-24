package pomplatform.cwd.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseScwdfilingmaintemplatetrcor extends GenericBase implements BaseFactory<BaseScwdfilingmaintemplatetrcor>, Comparable<BaseScwdfilingmaintemplatetrcor> 
{


	public static BaseScwdfilingmaintemplatetrcor newInstance(){
		return new BaseScwdfilingmaintemplatetrcor();
	}

	@Override
	public BaseScwdfilingmaintemplatetrcor make(){
		BaseScwdfilingmaintemplatetrcor b = new BaseScwdfilingmaintemplatetrcor();
		return b;
	}

	public final static java.lang.String CS_CWD_FILING_MAIN_TEMPLATE_ID = "cwd_filing_main_template_id" ;
	public final static java.lang.String CS_TEMPLATE_NAME = "template_name" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,模板名称,项目类型,操作人,部门编码,备注,创建时间";

	public java.lang.Integer getCwdFilingMainTemplateId() {
		return this.__cwd_filing_main_template_id;
	}

	public void setCwdFilingMainTemplateId( java.lang.Integer value ) {
		this.__cwd_filing_main_template_id = value;
	}

	public java.lang.String getTemplateName() {
		return this.__template_name;
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseScwdfilingmaintemplatetrcor __bean){
		__bean.setCwdFilingMainTemplateId(getCwdFilingMainTemplateId());
		__bean.setTemplateName(getTemplateName());
		__bean.setProjectType(getProjectType());
		__bean.setOperatorId(getOperatorId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFilingMainTemplateId() == null ? "" : getCwdFilingMainTemplateId());
		sb.append(",");
		sb.append(getTemplateName() == null ? "" : getTemplateName());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseScwdfilingmaintemplatetrcor o) {
		return __cwd_filing_main_template_id == null ? -1 : __cwd_filing_main_template_id.compareTo(o.getCwdFilingMainTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_main_template_id);
		hash = 97 * hash + Objects.hashCode(this.__template_name);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseScwdfilingmaintemplatetrcor o = (BaseScwdfilingmaintemplatetrcor)obj;
		if(!Objects.equals(this.__cwd_filing_main_template_id, o.getCwdFilingMainTemplateId())) return false;
		if(!Objects.equals(this.__template_name, o.getTemplateName())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFilingMainTemplateId() != null) sb.append(__wrapNumber(count++, "cwdFilingMainTemplateId", getCwdFilingMainTemplateId()));
		if(getTemplateName() != null) sb.append(__wrapString(count++, "templateName", getTemplateName()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFilingMainTemplateId")) != null) setCwdFilingMainTemplateId(__getInt(val)); 
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cwd_filing_main_template_id ;
	protected java.lang.String  __template_name ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
}
