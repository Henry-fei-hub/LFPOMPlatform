package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePreProjectAnalysisData extends GenericBase implements BaseFactory<BasePreProjectAnalysisData>, Comparable<BasePreProjectAnalysisData> 
{


	public static BasePreProjectAnalysisData newInstance(){
		return new BasePreProjectAnalysisData();
	}

	@Override
	public BasePreProjectAnalysisData make(){
		BasePreProjectAnalysisData b = new BasePreProjectAnalysisData();
		return b;
	}

	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_SPECIALTY = "specialty" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_REGION = "region" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_REGISTER_DATE = "register_date" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_COMPARISON_FORM = "comparison_form" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_CLOSE_REASON = "close_reason" ;
	public final static java.lang.String CS_CLOSE_REMARK = "close_remark" ;
	public final static java.lang.String CS_COMPETITIVE_UNIT = "competitive_unit" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;

	public final static java.lang.String ALL_CAPTIONS = "信息编号,业务类别,参与专业,立项/关闭的流程状态,项目名称,区域,项目地址（省）,项目地址（市）,登记时间,立项时间,比选形式,预估合同金额,项目关闭原因,项目关闭备注,竞争单位,报备人,项目营销团队,主办设计团队";
	public final static java.lang.String EXITPORT_CAPTIONS = "业务类别,参与专业,立项/关闭的流程状态,立项依据,项目名称,区域,项目地址（省）,项目地址（市）,登记时间,立项时间,比选形式,预估合同金额,项目关闭原因,项目关闭备注,竞争单位,报备人,项目营销团队,主办设计团队";

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( java.lang.String value ) {
		this.__specialty = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}
    
	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}
	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getRegion() {
		return this.__region;
	}

	public void setRegion( java.lang.Integer value ) {
		this.__region = value;
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

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.Integer getComparisonForm() {
		return this.__comparison_form;
	}

	public void setComparisonForm( java.lang.Integer value ) {
		this.__comparison_form = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.String getCloseReason() {
		return this.__close_reason;
	}

	public void setCloseReason( java.lang.String value ) {
		this.__close_reason = value;
	}

	public java.lang.String getCloseRemark() {
		return this.__close_remark;
	}

	public void setCloseRemark( java.lang.String value ) {
		this.__close_remark = value;
	}

	public java.lang.String getCompetitiveUnit() {
		return this.__competitive_unit;
	}

	public void setCompetitiveUnit( java.lang.String value ) {
		this.__competitive_unit = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( java.lang.String value ) {
		this.__project_sales_team = value;
	}
	
	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}
	

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public void cloneCopy(BasePreProjectAnalysisData __bean){
		__bean.setInfoCode(getInfoCode());
		__bean.setBusinessType(getBusinessType());
		__bean.setSpecialty(getSpecialty());
		__bean.setStatus(getStatus());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setProjectName(getProjectName());
		__bean.setRegion(getRegion());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setRegisterDate(getRegisterDate());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setComparisonForm(getComparisonForm());
		__bean.setContractAmount(getContractAmount());
		__bean.setCloseReason(getCloseReason());
		__bean.setCloseRemark(getCloseRemark());
		__bean.setCompetitiveUnit(getCompetitiveUnit());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDesignTeam(getDesignTeam());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		/*sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");*/
		sb.append(getBusinessType() == null ? "" : getBusinessType().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getSpecialty() == null ? "" : getSpecialty().replaceAll(",", "，"));
		sb.append(",");
		String status=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_161", String.valueOf(getStatus()));
		sb.append(getStatus() == null ? "" : status);
		sb.append(",");
		String projectBaseOn= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(getProjectBaseOn()));
		sb.append(getProjectBaseOn() == null ? "" : projectBaseOn);
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String region=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_170", String.valueOf(getRegion()));
		sb.append(getRegion() == null ? "" : region);
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getRegisterDate() == null ? "" : sdf.format(getRegisterDate()));
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		String ComparisonForm=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_168", String.valueOf(getComparisonForm()));
		sb.append(getComparisonForm() == null ? "" : ComparisonForm);
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(","); 
		String closeReason=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_169", String.valueOf(getCloseReason()));
		sb.append(getCloseReason() == null ? "" : closeReason);
		sb.append(",");
		sb.append(getCloseRemark() == null ? "" : getCloseRemark());
		sb.append(",");
		sb.append(getCompetitiveUnit() == null ? "" : getCompetitiveUnit().replaceAll(",", "，"));
		sb.append(",");
		String applyEmployeeId=delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplyEmployeeId()));
		sb.append(getApplyEmployeeId() == null ? "" : applyEmployeeId);
		sb.append(",");
		String departments=delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(getDepartmentId() == null ? "" : departments);
		sb.append(",");
		String designTeam=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getDesignTeam()));
		sb.append(getDesignTeam() == null ? "" : designTeam);
		return sb.toString();
	}

	@Override
	public int compareTo(BasePreProjectAnalysisData o) {
		return __info_code == null ? -1 : __info_code.compareTo(o.getInfoCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__region);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__register_date);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__comparison_form);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__close_reason);
		hash = 97 * hash + Objects.hashCode(this.__close_remark);
		hash = 97 * hash + Objects.hashCode(this.__competitive_unit);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePreProjectAnalysisData o = (BasePreProjectAnalysisData)obj;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__region, o.getRegion())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__register_date, o.getRegisterDate())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__comparison_form, o.getComparisonForm())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__close_reason, o.getCloseReason())) return false;
		if(!Objects.equals(this.__close_remark, o.getCloseRemark())) return false;
		if(!Objects.equals(this.__competitive_unit, o.getCompetitiveUnit())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getRegion() != null) sb.append(__wrapNumber(count++, "region", getRegion()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getRegisterDate() != null) sb.append(__wrapDate(count++, "registerDate", getRegisterDate()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getComparisonForm() != null) sb.append(__wrapNumber(count++, "comparisonForm", getComparisonForm()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getCloseReason() != null) sb.append(__wrapString(count++, "closeReason", getCloseReason()));
		if(getCloseRemark() != null) sb.append(__wrapString(count++, "closeRemark", getCloseRemark()));
		if(getCompetitiveUnit() != null) sb.append(__wrapString(count++, "competitiveUnit", getCompetitiveUnit()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("region")) != null) setRegion(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val)); 
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("comparisonForm")) != null) setComparisonForm(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("closeReason")) != null) setCloseReason(__getString(val));
		if((val = values.get("closeRemark")) != null) setCloseRemark(__getString(val));
		if((val = values.get("competitiveUnit")) != null) setCompetitiveUnit(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
	}

	protected java.lang.String  __info_code ;
	protected java.lang.String  __business_type ;
	protected java.lang.String  __specialty ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __project_base_on ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __region ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.util.Date  __register_date ;
	protected java.util.Date  __project_approval_time ;
	protected java.lang.Integer  __comparison_form ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.String  __close_reason ;
	protected java.lang.String  __close_remark ;
	protected java.lang.String  __competitive_unit ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.String  __project_sales_team ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __design_team ;
}
