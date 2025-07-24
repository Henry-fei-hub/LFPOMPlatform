package pomplatform.newMainprojectInfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseNewMainprojectInfo extends GenericBase implements BaseFactory<BaseNewMainprojectInfo>, Comparable<BaseNewMainprojectInfo> 
{


	public static BaseNewMainprojectInfo newInstance(){
		return new BaseNewMainprojectInfo();
	}

	@Override
	public BaseNewMainprojectInfo make(){
		BaseNewMainprojectInfo b = new BaseNewMainprojectInfo();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_ENGLISH_NAME = "project_english_name" ;
	public final static java.lang.String CS_PROJECT_STATUS = "project_status" ;
	public final static java.lang.String CS_DESIGN_STATUS = "design_status" ;
	public final static java.lang.String CS_SIGN_COMPANY = "sign_company" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION_REMARK = "project_origination_remark" ;
	public final static java.lang.String CS_DESIGN_COOPERATION_NAME = "design_cooperation_name" ;
	public final static java.lang.String CS_DESIGN_COOPERATION_ENGLISH_NAME = "design_cooperation_english_name" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_IS_HIGH_RISE_BUILDING = "is_high_rise_building" ;
	public final static java.lang.String CS_INFO_REGISTER_TIME = "info_register_time" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_HAS_CONTRACT = "has_contract" ;
	public final static java.lang.String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_MODEL = "project_model" ;
	public final static java.lang.String CS_DESIGN_QUALIFICATION = "design_qualification" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_FIRE_RESISTANCE_RATING = "fire_resistance_rating" ;
	public final static java.lang.String CS_ESTIMATE_THE_DESIGN_AREAS = "estimate_the_design_areas" ;
	public final static java.lang.String CS_PROJECT_TOTAL_INVESTMENT = "project_total_investment" ;
	public final static java.lang.String CS_ACTUAL_DESIGN_AREAS = "actual_design_areas" ;
	public final static java.lang.String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;
	public final static java.lang.String CS_BUILDING_HEIGHT = "building_height" ;
	public final static java.lang.String CS_BUILDING_FLOORS = "building_floors" ;
	public final static java.lang.String CS_DECORATE_MONEY_CONTROL = "decorate_money_control" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_PROJECT_END_TIME = "project_end_time" ;
	public final static java.lang.String CS_PROJECT_SALE_MAN = "project_sale_man" ;
	public final static java.lang.String CS_PROJECT_SALE_TEAM_MANAGER = "project_sale_team_manager" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_PROJECT_LEADER = "project_leader" ;

	public final static java.lang.String ALL_CAPTIONS = "主项目编码,项目编号,项目名称,项目英文名称,项目状态,设计状态,拟签约公司,项目来源渠道,项目来源说明,设计合作单位,设计合作单位英文名称,项目营销团队,主办设计团队,是否高层建筑,信息登记时间,正式立项时间,是否有合同,立项依据,信息编号,立项模式,设计资质章,业务类别,耐火等级,设计预估面积,项目总投资额,实际设计面积,建筑总面积,建筑高度,建筑楼层,装修造价控制,项目等级,详细地址,项目完成时间,项目营销专员,运营董事,项目经理,项目主管领导";

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectEnglishName() {
		return this.__project_english_name;
	}

	public void setProjectEnglishName( java.lang.String value ) {
		this.__project_english_name = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
	}

	public java.lang.String getDesignStatus() {
		return this.__design_status;
	}

	public void setDesignStatus( java.lang.String value ) {
		this.__design_status = value;
	}

	public java.lang.Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( java.lang.Integer value ) {
		this.__sign_company = value;
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

	public java.lang.String getDesignCooperationName() {
		return this.__design_cooperation_name;
	}

	public void setDesignCooperationName( java.lang.String value ) {
		this.__design_cooperation_name = value;
	}

	public java.lang.String getDesignCooperationEnglishName() {
		return this.__design_cooperation_english_name;
	}

	public void setDesignCooperationEnglishName( java.lang.String value ) {
		this.__design_cooperation_english_name = value;
	}

	public java.lang.String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( java.lang.String value ) {
		this.__project_sales_team = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.Boolean getIsHighRiseBuilding() {
		return this.__is_high_rise_building;
	}

	public void setIsHighRiseBuilding( java.lang.Boolean value ) {
		this.__is_high_rise_building = value;
	}

	public java.util.Date getInfoRegisterTime() {
		return this.__info_register_time;
	}

	public void setInfoRegisterTime( java.util.Date value ) {
		this.__info_register_time = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.Boolean getHasContract() {
		return this.__has_contract;
	}

	public void setHasContract( java.lang.Boolean value ) {
		this.__has_contract = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectModel() {
		return this.__project_model;
	}

	public void setProjectModel( java.lang.String value ) {
		this.__project_model = value;
	}

	public java.lang.String getDesignQualification() {
		return this.__design_qualification;
	}

	public void setDesignQualification( java.lang.String value ) {
		this.__design_qualification = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getFireResistanceRating() {
		return this.__fire_resistance_rating;
	}

	public void setFireResistanceRating( java.lang.String value ) {
		this.__fire_resistance_rating = value;
	}

	public java.lang.String getEstimateTheDesignAreas() {
		return this.__estimate_the_design_areas;
	}

	public void setEstimateTheDesignAreas( java.lang.String value ) {
		this.__estimate_the_design_areas = value;
	}

	public java.lang.String getProjectTotalInvestment() {
		return this.__project_total_investment;
	}

	public void setProjectTotalInvestment( java.lang.String value ) {
		this.__project_total_investment = value;
	}

	public java.lang.String getActualDesignAreas() {
		return this.__actual_design_areas;
	}

	public void setActualDesignAreas( java.lang.String value ) {
		this.__actual_design_areas = value;
	}

	public java.lang.String getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( java.lang.String value ) {
		this.__total_building_areas = value;
	}

	public java.lang.String getBuildingHeight() {
		return this.__building_height;
	}

	public void setBuildingHeight( java.lang.String value ) {
		this.__building_height = value;
	}

	public java.lang.String getBuildingFloors() {
		return this.__building_floors;
	}

	public void setBuildingFloors( java.lang.String value ) {
		this.__building_floors = value;
	}

	public java.lang.String getDecorateMoneyControl() {
		return this.__decorate_money_control;
	}

	public void setDecorateMoneyControl( java.lang.String value ) {
		this.__decorate_money_control = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.util.Date getProjectEndTime() {
		return this.__project_end_time;
	}

	public void setProjectEndTime( java.util.Date value ) {
		this.__project_end_time = value;
	}

	public java.lang.String getProjectSaleMan() {
		return this.__project_sale_man;
	}

	public void setProjectSaleMan( java.lang.String value ) {
		this.__project_sale_man = value;
	}

	public java.lang.String getProjectSaleTeamManager() {
		return this.__project_sale_team_manager;
	}

	public void setProjectSaleTeamManager( java.lang.String value ) {
		this.__project_sale_team_manager = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public java.lang.String getProjectLeader() {
		return this.__project_leader;
	}

	public void setProjectLeader( java.lang.String value ) {
		this.__project_leader = value;
	}

	public void cloneCopy(BaseNewMainprojectInfo __bean){
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setProjectEnglishName(getProjectEnglishName());
		__bean.setProjectStatus(getProjectStatus());
		__bean.setDesignStatus(getDesignStatus());
		__bean.setSignCompany(getSignCompany());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setProjectOriginationRemark(getProjectOriginationRemark());
		__bean.setDesignCooperationName(getDesignCooperationName());
		__bean.setDesignCooperationEnglishName(getDesignCooperationEnglishName());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setIsHighRiseBuilding(getIsHighRiseBuilding());
		__bean.setInfoRegisterTime(getInfoRegisterTime());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setHasContract(getHasContract());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectModel(getProjectModel());
		__bean.setDesignQualification(getDesignQualification());
		__bean.setBusinessType(getBusinessType());
		__bean.setFireResistanceRating(getFireResistanceRating());
		__bean.setEstimateTheDesignAreas(getEstimateTheDesignAreas());
		__bean.setProjectTotalInvestment(getProjectTotalInvestment());
		__bean.setActualDesignAreas(getActualDesignAreas());
		__bean.setTotalBuildingAreas(getTotalBuildingAreas());
		__bean.setBuildingHeight(getBuildingHeight());
		__bean.setBuildingFloors(getBuildingFloors());
		__bean.setDecorateMoneyControl(getDecorateMoneyControl());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setAddress(getAddress());
		__bean.setProjectEndTime(getProjectEndTime());
		__bean.setProjectSaleMan(getProjectSaleMan());
		__bean.setProjectSaleTeamManager(getProjectSaleTeamManager());
		__bean.setProjectManager(getProjectManager());
		__bean.setProjectLeader(getProjectLeader());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		String strProjectCode = delicacy.system.executor.SelectValueCache.getSelectValue("main_projects", String.valueOf(getProjectCode()));
		sb.append(strProjectCode == null ? "" : strProjectCode);
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectEnglishName() == null ? "" : getProjectEnglishName());
		sb.append(",");
		sb.append(getProjectStatus() == null ? "" : getProjectStatus());
		sb.append(",");
		String strDesignStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_29", String.valueOf(getDesignStatus()));
		sb.append(strDesignStatus == null ? "" : strDesignStatus);
		sb.append(",");
		String strSignCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSignCompany()));
		sb.append(strSignCompany == null ? "" : strSignCompany);
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		sb.append(getProjectOriginationRemark() == null ? "" : getProjectOriginationRemark());
		sb.append(",");
		sb.append(getDesignCooperationName() == null ? "" : getDesignCooperationName());
		sb.append(",");
		sb.append(getDesignCooperationEnglishName() == null ? "" : getDesignCooperationEnglishName());
		sb.append(",");
		String strProjectSalesTeam = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getProjectSalesTeam()));
		sb.append(strProjectSalesTeam == null ? "" : strProjectSalesTeam);
		sb.append(",");
		String strDesignTeam = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDesignTeam()));
		sb.append(strDesignTeam == null ? "" : strDesignTeam);
		sb.append(",");
		sb.append(getIsHighRiseBuilding() == null ? "" : getIsHighRiseBuilding());
		sb.append(",");
		sb.append(getInfoRegisterTime() == null ? "" : sdf.format(getInfoRegisterTime()));
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getHasContract() == null ? "" : getHasContract());
		sb.append(",");
		String strProjectBaseOn = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(getProjectBaseOn()));
		sb.append(strProjectBaseOn == null ? "" : strProjectBaseOn);
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectModel() == null ? "" : getProjectModel());
		sb.append(",");
		sb.append(getDesignQualification() == null ? "" : getDesignQualification());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		sb.append(getFireResistanceRating() == null ? "" : getFireResistanceRating());
		sb.append(",");
		sb.append(getEstimateTheDesignAreas() == null ? "" : getEstimateTheDesignAreas());
		sb.append(",");
		sb.append(getProjectTotalInvestment() == null ? "" : getProjectTotalInvestment());
		sb.append(",");
		sb.append(getActualDesignAreas() == null ? "" : getActualDesignAreas());
		sb.append(",");
		sb.append(getTotalBuildingAreas() == null ? "" : getTotalBuildingAreas());
		sb.append(",");
		sb.append(getBuildingHeight() == null ? "" : getBuildingHeight());
		sb.append(",");
		sb.append(getBuildingFloors() == null ? "" : getBuildingFloors());
		sb.append(",");
		sb.append(getDecorateMoneyControl() == null ? "" : getDecorateMoneyControl());
		sb.append(",");
		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(strProjectLevel == null ? "" : strProjectLevel);
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getProjectEndTime() == null ? "" : sdf.format(getProjectEndTime()));
		sb.append(",");
		sb.append(getProjectSaleMan() == null ? "" : getProjectSaleMan());
		sb.append(",");
		sb.append(getProjectSaleTeamManager() == null ? "" : getProjectSaleTeamManager());
		sb.append(",");
		String strProjectManager = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManager()));
		sb.append(strProjectManager == null ? "" : strProjectManager);
		sb.append(",");
		String strProjectLeader = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectLeader()));
		sb.append(strProjectLeader == null ? "" : strProjectLeader);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNewMainprojectInfo o) {
		return __main_project_id == null ? -1 : __main_project_id.compareTo(o.getMainProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_english_name);
		hash = 97 * hash + Objects.hashCode(this.__project_status);
		hash = 97 * hash + Objects.hashCode(this.__design_status);
		hash = 97 * hash + Objects.hashCode(this.__sign_company);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__project_origination_remark);
		hash = 97 * hash + Objects.hashCode(this.__design_cooperation_name);
		hash = 97 * hash + Objects.hashCode(this.__design_cooperation_english_name);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__is_high_rise_building);
		hash = 97 * hash + Objects.hashCode(this.__info_register_time);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__has_contract);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_model);
		hash = 97 * hash + Objects.hashCode(this.__design_qualification);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__fire_resistance_rating);
		hash = 97 * hash + Objects.hashCode(this.__estimate_the_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__project_total_investment);
		hash = 97 * hash + Objects.hashCode(this.__actual_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__total_building_areas);
		hash = 97 * hash + Objects.hashCode(this.__building_height);
		hash = 97 * hash + Objects.hashCode(this.__building_floors);
		hash = 97 * hash + Objects.hashCode(this.__decorate_money_control);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__project_end_time);
		hash = 97 * hash + Objects.hashCode(this.__project_sale_man);
		hash = 97 * hash + Objects.hashCode(this.__project_sale_team_manager);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__project_leader);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNewMainprojectInfo o = (BaseNewMainprojectInfo)obj;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_english_name, o.getProjectEnglishName())) return false;
		if(!Objects.equals(this.__project_status, o.getProjectStatus())) return false;
		if(!Objects.equals(this.__design_status, o.getDesignStatus())) return false;
		if(!Objects.equals(this.__sign_company, o.getSignCompany())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__project_origination_remark, o.getProjectOriginationRemark())) return false;
		if(!Objects.equals(this.__design_cooperation_name, o.getDesignCooperationName())) return false;
		if(!Objects.equals(this.__design_cooperation_english_name, o.getDesignCooperationEnglishName())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__is_high_rise_building, o.getIsHighRiseBuilding())) return false;
		if(!Objects.equals(this.__info_register_time, o.getInfoRegisterTime())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__has_contract, o.getHasContract())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_model, o.getProjectModel())) return false;
		if(!Objects.equals(this.__design_qualification, o.getDesignQualification())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__fire_resistance_rating, o.getFireResistanceRating())) return false;
		if(!Objects.equals(this.__estimate_the_design_areas, o.getEstimateTheDesignAreas())) return false;
		if(!Objects.equals(this.__project_total_investment, o.getProjectTotalInvestment())) return false;
		if(!Objects.equals(this.__actual_design_areas, o.getActualDesignAreas())) return false;
		if(!Objects.equals(this.__total_building_areas, o.getTotalBuildingAreas())) return false;
		if(!Objects.equals(this.__building_height, o.getBuildingHeight())) return false;
		if(!Objects.equals(this.__building_floors, o.getBuildingFloors())) return false;
		if(!Objects.equals(this.__decorate_money_control, o.getDecorateMoneyControl())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__project_end_time, o.getProjectEndTime())) return false;
		if(!Objects.equals(this.__project_sale_man, o.getProjectSaleMan())) return false;
		if(!Objects.equals(this.__project_sale_team_manager, o.getProjectSaleTeamManager())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__project_leader, o.getProjectLeader())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectEnglishName() != null) sb.append(__wrapString(count++, "projectEnglishName", getProjectEnglishName()));
		if(getProjectStatus() != null) sb.append(__wrapString(count++, "projectStatus", getProjectStatus()));
		if(getDesignStatus() != null) sb.append(__wrapString(count++, "designStatus", getDesignStatus()));
		if(getSignCompany() != null) sb.append(__wrapNumber(count++, "signCompany", getSignCompany()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getProjectOriginationRemark() != null) sb.append(__wrapString(count++, "projectOriginationRemark", getProjectOriginationRemark()));
		if(getDesignCooperationName() != null) sb.append(__wrapString(count++, "designCooperationName", getDesignCooperationName()));
		if(getDesignCooperationEnglishName() != null) sb.append(__wrapString(count++, "designCooperationEnglishName", getDesignCooperationEnglishName()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getIsHighRiseBuilding() != null) sb.append(__wrapBoolean(count++, "isHighRiseBuilding", getIsHighRiseBuilding()));
		if(getInfoRegisterTime() != null) sb.append(__wrapDate(count++, "infoRegisterTime", getInfoRegisterTime()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getHasContract() != null) sb.append(__wrapBoolean(count++, "hasContract", getHasContract()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectModel() != null) sb.append(__wrapString(count++, "projectModel", getProjectModel()));
		if(getDesignQualification() != null) sb.append(__wrapString(count++, "designQualification", getDesignQualification()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getFireResistanceRating() != null) sb.append(__wrapString(count++, "fireResistanceRating", getFireResistanceRating()));
		if(getEstimateTheDesignAreas() != null) sb.append(__wrapString(count++, "estimateTheDesignAreas", getEstimateTheDesignAreas()));
		if(getProjectTotalInvestment() != null) sb.append(__wrapString(count++, "projectTotalInvestment", getProjectTotalInvestment()));
		if(getActualDesignAreas() != null) sb.append(__wrapString(count++, "actualDesignAreas", getActualDesignAreas()));
		if(getTotalBuildingAreas() != null) sb.append(__wrapString(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getBuildingHeight() != null) sb.append(__wrapString(count++, "buildingHeight", getBuildingHeight()));
		if(getBuildingFloors() != null) sb.append(__wrapString(count++, "buildingFloors", getBuildingFloors()));
		if(getDecorateMoneyControl() != null) sb.append(__wrapString(count++, "decorateMoneyControl", getDecorateMoneyControl()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getProjectEndTime() != null) sb.append(__wrapDate(count++, "projectEndTime", getProjectEndTime()));
		if(getProjectSaleMan() != null) sb.append(__wrapString(count++, "projectSaleMan", getProjectSaleMan()));
		if(getProjectSaleTeamManager() != null) sb.append(__wrapString(count++, "projectSaleTeamManager", getProjectSaleTeamManager()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		if(getProjectLeader() != null) sb.append(__wrapString(count++, "projectLeader", getProjectLeader()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectEnglishName")) != null) setProjectEnglishName(__getString(val));
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("designStatus")) != null) setDesignStatus(__getString(val));
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val)); 
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("projectOriginationRemark")) != null) setProjectOriginationRemark(__getString(val));
		if((val = values.get("designCooperationName")) != null) setDesignCooperationName(__getString(val));
		if((val = values.get("designCooperationEnglishName")) != null) setDesignCooperationEnglishName(__getString(val));
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val)); 
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("isHighRiseBuilding")) != null) setIsHighRiseBuilding(__getBoolean(val));
		if((val = values.get("infoRegisterTime")) != null) setInfoRegisterTime(__getDate(val)); 
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("hasContract")) != null) setHasContract(__getBoolean(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectModel")) != null) setProjectModel(__getString(val));
		if((val = values.get("designQualification")) != null) setDesignQualification(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("fireResistanceRating")) != null) setFireResistanceRating(__getString(val));
		if((val = values.get("estimateTheDesignAreas")) != null) setEstimateTheDesignAreas(__getString(val));
		if((val = values.get("projectTotalInvestment")) != null) setProjectTotalInvestment(__getString(val));
		if((val = values.get("actualDesignAreas")) != null) setActualDesignAreas(__getString(val));
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getString(val));
		if((val = values.get("buildingHeight")) != null) setBuildingHeight(__getString(val));
		if((val = values.get("buildingFloors")) != null) setBuildingFloors(__getString(val));
		if((val = values.get("decorateMoneyControl")) != null) setDecorateMoneyControl(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("projectEndTime")) != null) setProjectEndTime(__getDate(val)); 
		if((val = values.get("projectSaleMan")) != null) setProjectSaleMan(__getString(val));
		if((val = values.get("projectSaleTeamManager")) != null) setProjectSaleTeamManager(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
	}

	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_english_name ;
	protected java.lang.String  __project_status ;
	protected java.lang.String  __design_status ;
	protected java.lang.Integer  __sign_company ;
	protected java.lang.String  __project_origination ;
	protected java.lang.String  __project_origination_remark ;
	protected java.lang.String  __design_cooperation_name ;
	protected java.lang.String  __design_cooperation_english_name ;
	protected java.lang.String  __project_sales_team ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.Boolean  __is_high_rise_building ;
	protected java.util.Date  __info_register_time ;
	protected java.util.Date  __project_approval_time ;
	protected java.lang.Boolean  __has_contract ;
	protected java.lang.Integer  __project_base_on ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_model ;
	protected java.lang.String  __design_qualification ;
	protected java.lang.String  __business_type ;
	protected java.lang.String  __fire_resistance_rating ;
	protected java.lang.String  __estimate_the_design_areas ;
	protected java.lang.String  __project_total_investment ;
	protected java.lang.String  __actual_design_areas ;
	protected java.lang.String  __total_building_areas ;
	protected java.lang.String  __building_height ;
	protected java.lang.String  __building_floors ;
	protected java.lang.String  __decorate_money_control ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.String  __address ;
	protected java.util.Date  __project_end_time ;
	protected java.lang.String  __project_sale_man ;
	protected java.lang.String  __project_sale_team_manager ;
	protected java.lang.String  __project_manager ;
	protected java.lang.String  __project_leader ;
}
