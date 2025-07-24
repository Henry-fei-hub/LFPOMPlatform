package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasepreProjectRecordRemark extends GenericBase implements BaseFactory<BasepreProjectRecordRemark>, Comparable<BasepreProjectRecordRemark> 
{


	public static BasepreProjectRecordRemark newInstance(){
		return new BasepreProjectRecordRemark();
	}

	@Override
	public BasepreProjectRecordRemark make(){
		BasepreProjectRecordRemark b = new BasepreProjectRecordRemark();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_REGISTER_DATE = "register_date" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_IS_ORIGINAL = "is_original" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_ESTIMATE_THE_DESIGN_AREAS = "estimate_the_design_areas" ;
	public final static java.lang.String CS_DESIGN_PRICE = "design_price" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_TRACK_DATE = "track_date" ;
	public final static java.lang.String CS_PROJECT_RECORD_REMARK = "project_record_remark" ;
	public final static java.lang.String CS_COMPETITIVE_UNIT = "competitive_unit" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION_REMARK = "project_origination_remark" ;
	public final static java.lang.String CS_PROJECT_LEADER = "project_leader" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_WIN_RATE = "win_rate" ;

	public final static java.lang.String ALL_CAPTIONS = "归属部门,项目营销团队,报备人,登记时间,信息编号,项目名称,业务类别,是否原创,客户名称,项目地址（省）,项目地址（市）,联系人,职务,电话,设计预估面积,设计详细报价,预估合同金额,跟踪时间,项目跟踪记录,竞争单位,项目来源渠道,项目来源说明,项目主管领导,项目经理,赢率";
	public final static java.lang.String EXITPORT_CAPTIONS = "报备人,登记时间,信息编号,项目名称,业务类别,是否原创,客户名称,项目地址（省）,项目地址（市）,联系人,职务,电话,设计预估面积,设计详细报价,预估合同金额,跟踪时间,项目跟踪记录,竞争单位,项目来源渠道,项目来源说明,项目主管领导,项目经理,赢率";

	
	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}
	
	public java.lang.String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( java.lang.String value ) {
		this.__project_sales_team = value;
	}
	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getIsOriginal() {
		return this.__is_original;
	}

	public void setIsOriginal( java.lang.String value ) {
		this.__is_original = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
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

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getGrade() {
		return this.__grade;
	}

	public void setGrade( java.lang.String value ) {
		this.__grade = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.math.BigDecimal getEstimateTheDesignAreas() {
		return this.__estimate_the_design_areas;
	}

	public void setEstimateTheDesignAreas( java.math.BigDecimal value ) {
		this.__estimate_the_design_areas = value;
	}

	public java.lang.String getDesignPrice() {
		return this.__design_price;
	}

	public void setDesignPrice( java.lang.String value ) {
		this.__design_price = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.util.Date getTrackDate() {
		return this.__track_date;
	}

	public void setTrackDate( java.util.Date value ) {
		this.__track_date = value;
	}

	public java.lang.String getProjectRecordRemark() {
		return this.__project_record_remark;
	}

	public void setProjectRecordRemark( java.lang.String value ) {
		this.__project_record_remark = value;
	}

	public java.lang.String getCompetitiveUnit() {
		return this.__competitive_unit;
	}

	public void setCompetitiveUnit( java.lang.String value ) {
		this.__competitive_unit = value;
	}

	public java.lang.String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( java.lang.String value ) {
		this.__project_origination = value;
	}

	public java.lang.String getProjectOriginationRemark() {
		return this.__project_origination_remark;
	}

	public void setProjectOriginationRemark( java.lang.String value ) {
		this.__project_origination_remark = value;
	}

	public java.lang.String getProjectLeader() {
		return this.__project_leader;
	}

	public void setProjectLeader( java.lang.String value ) {
		this.__project_leader = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public java.lang.String getWinRate() {
		return this.__win_rate;
	}

	public void setWinRate( java.lang.String value ) {
		this.__win_rate = value;
	}

	public void cloneCopy(BasepreProjectRecordRemark __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setRegisterDate(getRegisterDate());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectName(getProjectName());
		__bean.setBusinessType(getBusinessType());
		__bean.setIsOriginal(getIsOriginal());
		__bean.setCustomerName(getCustomerName());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setContactName(getContactName());
		__bean.setGrade(getGrade());
		__bean.setContactPhone(getContactPhone());
		__bean.setEstimateTheDesignAreas(getEstimateTheDesignAreas());
		__bean.setDesignPrice(getDesignPrice());
		__bean.setContractAmount(getContractAmount());
		__bean.setTrackDate(getTrackDate());
		__bean.setProjectRecordRemark(getProjectRecordRemark());
		__bean.setCompetitiveUnit(getCompetitiveUnit());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setProjectOriginationRemark(getProjectOriginationRemark());
		__bean.setProjectLeader(getProjectLeader());
		__bean.setProjectManager(getProjectManager());
		__bean.setWinRate(getWinRate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String applyEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplyEmployeeId()));
		sb.append(getApplyEmployeeId() == null ? "" : applyEmployeeId);
		sb.append(",");
		sb.append(getRegisterDate() == null ? "" : sdf.format(getRegisterDate()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getIsOriginal() == null ? "" : getIsOriginal());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getGrade() == null ? "" : getGrade());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getEstimateTheDesignAreas() == null ? "" : getEstimateTheDesignAreas());
		sb.append(",");
		sb.append(getDesignPrice() == null ? "" : getDesignPrice().replaceAll(",", "，").replaceAll("\r", " ").replaceAll("\n", " "));
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getTrackDate() == null ? "" : sdf.format(getTrackDate()));
		sb.append(",");
		sb.append(getProjectRecordRemark() == null ? "" : getProjectRecordRemark().replaceAll(",", "，").replaceAll("\r", " ").replaceAll("\n", " "));
		sb.append(",");
		sb.append(getCompetitiveUnit() == null ? "" : getCompetitiveUnit());
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		sb.append(getProjectOriginationRemark() == null ? "" : getProjectOriginationRemark());
		sb.append(",");
		sb.append(getProjectLeader() == null ? "" : getProjectLeader());
		sb.append(",");
		sb.append(getProjectManager() == null ? "" : getProjectManager());
		sb.append(",");
		sb.append(getWinRate() == null ? "" : getWinRate());
		return sb.toString();
	}

	@Override
	public int compareTo(BasepreProjectRecordRemark o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__register_date);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__is_original);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__estimate_the_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__design_price);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__track_date);
		hash = 97 * hash + Objects.hashCode(this.__project_record_remark);
		hash = 97 * hash + Objects.hashCode(this.__competitive_unit);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__project_origination_remark);
		hash = 97 * hash + Objects.hashCode(this.__project_leader);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__win_rate);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasepreProjectRecordRemark o = (BasepreProjectRecordRemark)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__register_date, o.getRegisterDate())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__is_original, o.getIsOriginal())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__estimate_the_design_areas, o.getEstimateTheDesignAreas())) return false;
		if(!Objects.equals(this.__design_price, o.getDesignPrice())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__track_date, o.getTrackDate())) return false;
		if(!Objects.equals(this.__project_record_remark, o.getProjectRecordRemark())) return false;
		if(!Objects.equals(this.__competitive_unit, o.getCompetitiveUnit())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__project_origination_remark, o.getProjectOriginationRemark())) return false;
		if(!Objects.equals(this.__project_leader, o.getProjectLeader())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__win_rate, o.getWinRate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getRegisterDate() != null) sb.append(__wrapDate(count++, "registerDate", getRegisterDate()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getIsOriginal() != null) sb.append(__wrapString(count++, "isOriginal", getIsOriginal()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getEstimateTheDesignAreas() != null) sb.append(__wrapDecimal(count++, "estimateTheDesignAreas", getEstimateTheDesignAreas()));
		if(getDesignPrice() != null) sb.append(__wrapString(count++, "designPrice", getDesignPrice()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getTrackDate() != null) sb.append(__wrapDate(count++, "trackDate", getTrackDate()));
		if(getProjectRecordRemark() != null) sb.append(__wrapString(count++, "projectRecordRemark", getProjectRecordRemark()));
		if(getCompetitiveUnit() != null) sb.append(__wrapString(count++, "competitiveUnit", getCompetitiveUnit()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getProjectOriginationRemark() != null) sb.append(__wrapString(count++, "projectOriginationRemark", getProjectOriginationRemark()));
		if(getProjectLeader() != null) sb.append(__wrapString(count++, "projectLeader", getProjectLeader()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		if(getWinRate() != null) sb.append(__wrapString(count++, "winRate", getWinRate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("isOriginal")) != null) setIsOriginal(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("estimateTheDesignAreas")) != null) setEstimateTheDesignAreas(__getDecimal(val));  
		if((val = values.get("designPrice")) != null) setDesignPrice(__getString(val));
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("trackDate")) != null) setTrackDate(__getDate(val)); 
		if((val = values.get("projectRecordRemark")) != null) setProjectRecordRemark(__getString(val));
		if((val = values.get("competitiveUnit")) != null) setCompetitiveUnit(__getString(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("projectOriginationRemark")) != null) setProjectOriginationRemark(__getString(val));
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("winRate")) != null) setWinRate(__getString(val));
	}
    
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __project_sales_team; 
	protected java.lang.Integer  __apply_employee_id ;
	protected java.util.Date  __register_date ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __business_type ;
	protected java.lang.String  __is_original ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __grade ;
	protected java.lang.String  __contact_phone ;
	protected java.math.BigDecimal  __estimate_the_design_areas ;
	protected java.lang.String  __design_price ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.util.Date  __track_date ;
	protected java.lang.String  __project_record_remark ;
	protected java.lang.String  __competitive_unit ;
	protected java.lang.String  __project_origination ;
	protected java.lang.String  __project_origination_remark ;
	protected java.lang.String  __project_leader ;
	protected java.lang.String  __project_manager ;
	protected java.lang.String  __win_rate ;
}
