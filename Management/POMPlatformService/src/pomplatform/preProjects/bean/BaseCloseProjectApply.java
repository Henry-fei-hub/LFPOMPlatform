package pomplatform.preProjects.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseMainProjectSpecialty;
import com.pomplatform.db.bean.BaseMainProjectCompetitionUnit;

public class BaseCloseProjectApply extends GenericBase implements BaseFactory<BaseCloseProjectApply>, Comparable<BaseCloseProjectApply> 
{


	public static BaseCloseProjectApply newInstance(){
		return new BaseCloseProjectApply();
	}

	@Override
	public BaseCloseProjectApply make(){
		BaseCloseProjectApply b = new BaseCloseProjectApply();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_CUSTOMER_ADDRESS = "customer_address" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION_REMARK = "project_origination_remark" ;
	public final static java.lang.String CS_CUSTOMER_CONTACT_ID = "customer_contact_id" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_DESIGN_STATUS = "design_status" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_SIGN_COMPANY = "sign_company" ;
	public final static java.lang.String CS_DESIGN_QUALIFICATION = "design_qualification" ;
	public final static java.lang.String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_IS_HIGH_RISE_BUILDING = "is_high_rise_building" ;
	public final static java.lang.String CS_DESIGN_COOPERATION_NAME = "design_cooperation_name" ;
	public final static java.lang.String CS_ARCHITECTURAL_DESIGN_UNITS = "architectural_design_units" ;
	public final static java.lang.String CS_PROJECT_TOTAL_INVESTMENT = "project_total_investment" ;
	public final static java.lang.String CS_FIRE_RESISTANCE_RATING = "fire_resistance_rating" ;
	public final static java.lang.String CS_ESTIMATE_THE_DESIGN_AREAS = "estimate_the_design_areas" ;
	public final static java.lang.String CS_ACTUAL_DESIGN_AREAS = "actual_design_areas" ;
	public final static java.lang.String CS_BUILDING_HEIGHT = "building_height" ;
	public final static java.lang.String CS_BUILDING_FLOORS = "building_floors" ;
	public final static java.lang.String CS_DECORATE_MONEY_CONTROL = "decorate_money_control" ;
	public final static java.lang.String CS_SPECIALTY = "specialty" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_HAS_CONTRACT = "has_contract" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_INFO_REGISTER_TIME = "info_register_time" ;
	public final static java.lang.String CS_PROJECT_STATUS = "project_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编号,信息编号,开发商id,开发商名称,开发商地址,项目名称,项目地址（省）,项目地址（市）,详细地址,项目类别,项目面积,项目来源渠道,项目来源说明,联系人id,联系人,联系电话,设计状态system_dictionary_155,项目营销团队plate_str,主办设计团队plate_records,项目等级system_dictionary_2,拟签约公司company_records,设计资质章system_dictionary_157,立项依据system_dictionary_28,立项时间,是否高层建筑,设计合作单位,建筑设计单位,项目总投资额,耐火等级,设计预估面积,实际设计面积,建筑高度,建筑楼层,装修造价控制,合同参与专业,业务类别,是否有合同,报备人,报备时间,修改时间,项目状态system_dictionary_154(1前期跟踪，2已立项，3关闭)";

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getCustomerAddress() {
		return this.__customer_address;
	}

	public void setCustomerAddress( java.lang.String value ) {
		this.__customer_address = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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

	public java.lang.String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	public java.math.BigDecimal getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( java.math.BigDecimal value ) {
		this.__total_building_areas = value;
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

	public java.lang.Integer getCustomerContactId() {
		return this.__customer_contact_id;
	}

	public void setCustomerContactId( java.lang.Integer value ) {
		this.__customer_contact_id = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.String getDesignStatus() {
		return this.__design_status;
	}

	public void setDesignStatus( java.lang.String value ) {
		this.__design_status = value;
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

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( java.lang.Integer value ) {
		this.__sign_company = value;
	}

	public java.lang.String getDesignQualification() {
		return this.__design_qualification;
	}

	public void setDesignQualification( java.lang.String value ) {
		this.__design_qualification = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.Boolean getIsHighRiseBuilding() {
		return this.__is_high_rise_building;
	}

	public void setIsHighRiseBuilding( java.lang.Boolean value ) {
		this.__is_high_rise_building = value;
	}

	public java.lang.String getDesignCooperationName() {
		return this.__design_cooperation_name;
	}

	public void setDesignCooperationName( java.lang.String value ) {
		this.__design_cooperation_name = value;
	}

	public java.lang.String getArchitecturalDesignUnits() {
		return this.__architectural_design_units;
	}

	public void setArchitecturalDesignUnits( java.lang.String value ) {
		this.__architectural_design_units = value;
	}

	public java.math.BigDecimal getProjectTotalInvestment() {
		return this.__project_total_investment;
	}

	public void setProjectTotalInvestment( java.math.BigDecimal value ) {
		this.__project_total_investment = value;
	}

	public java.lang.String getFireResistanceRating() {
		return this.__fire_resistance_rating;
	}

	public void setFireResistanceRating( java.lang.String value ) {
		this.__fire_resistance_rating = value;
	}

	public java.math.BigDecimal getEstimateTheDesignAreas() {
		return this.__estimate_the_design_areas;
	}

	public void setEstimateTheDesignAreas( java.math.BigDecimal value ) {
		this.__estimate_the_design_areas = value;
	}

	public java.math.BigDecimal getActualDesignAreas() {
		return this.__actual_design_areas;
	}

	public void setActualDesignAreas( java.math.BigDecimal value ) {
		this.__actual_design_areas = value;
	}

	public java.math.BigDecimal getBuildingHeight() {
		return this.__building_height;
	}

	public void setBuildingHeight( java.math.BigDecimal value ) {
		this.__building_height = value;
	}

	public java.math.BigDecimal getBuildingFloors() {
		return this.__building_floors;
	}

	public void setBuildingFloors( java.math.BigDecimal value ) {
		this.__building_floors = value;
	}

	public java.math.BigDecimal getDecorateMoneyControl() {
		return this.__decorate_money_control;
	}

	public void setDecorateMoneyControl( java.math.BigDecimal value ) {
		this.__decorate_money_control = value;
	}

	public java.lang.String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( java.lang.String value ) {
		this.__specialty = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.Boolean getHasContract() {
		return this.__has_contract;
	}

	public void setHasContract( java.lang.Boolean value ) {
		this.__has_contract = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getInfoRegisterTime() {
		return this.__info_register_time;
	}

	public void setInfoRegisterTime( java.util.Date value ) {
		this.__info_register_time = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
	}

	public java.util.List<BaseMainProjectBusinessType> getDetailMainProjectBusinessType() {
		return this.__detailMainProjectBusinessType;
	}

	public void setDetailMainProjectBusinessType( java.util.List<BaseMainProjectBusinessType> value ) {
		this.__detailMainProjectBusinessType = value;
	}

	public java.util.List<BaseMainProjectSpecialty> getDetailMainProjectSpecialty() {
		return this.__detailMainProjectSpecialty;
	}

	public void setDetailMainProjectSpecialty( java.util.List<BaseMainProjectSpecialty> value ) {
		this.__detailMainProjectSpecialty = value;
	}

	public java.util.List<BaseMainProjectCompetitionUnit> getDetailMainProjectCompetitionUnit() {
		return this.__detailMainProjectCompetitionUnit;
	}

	public void setDetailMainProjectCompetitionUnit( java.util.List<BaseMainProjectCompetitionUnit> value ) {
		this.__detailMainProjectCompetitionUnit = value;
	}

	public void cloneCopy(BaseCloseProjectApply __bean){
		__bean.setPreProjectId(getPreProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setInfoCode(getInfoCode());
		__bean.setClientId(getClientId());
		__bean.setCustomerName(getCustomerName());
		__bean.setCustomerAddress(getCustomerAddress());
		__bean.setProjectName(getProjectName());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setProjectType(getProjectType());
		__bean.setTotalBuildingAreas(getTotalBuildingAreas());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setProjectOriginationRemark(getProjectOriginationRemark());
		__bean.setCustomerContactId(getCustomerContactId());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setDesignStatus(getDesignStatus());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setSignCompany(getSignCompany());
		__bean.setDesignQualification(getDesignQualification());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setIsHighRiseBuilding(getIsHighRiseBuilding());
		__bean.setDesignCooperationName(getDesignCooperationName());
		__bean.setArchitecturalDesignUnits(getArchitecturalDesignUnits());
		__bean.setProjectTotalInvestment(getProjectTotalInvestment());
		__bean.setFireResistanceRating(getFireResistanceRating());
		__bean.setEstimateTheDesignAreas(getEstimateTheDesignAreas());
		__bean.setActualDesignAreas(getActualDesignAreas());
		__bean.setBuildingHeight(getBuildingHeight());
		__bean.setBuildingFloors(getBuildingFloors());
		__bean.setDecorateMoneyControl(getDecorateMoneyControl());
		__bean.setSpecialty(getSpecialty());
		__bean.setBusinessType(getBusinessType());
		__bean.setHasContract(getHasContract());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setInfoRegisterTime(getInfoRegisterTime());
		__bean.setProjectStatus(getProjectStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getClientId() == null ? "" : getClientId());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getCustomerAddress() == null ? "" : getCustomerAddress());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getDetailAddress() == null ? "" : getDetailAddress());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getTotalBuildingAreas() == null ? "" : getTotalBuildingAreas());
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		sb.append(getProjectOriginationRemark() == null ? "" : getProjectOriginationRemark());
		sb.append(",");
		sb.append(getCustomerContactId() == null ? "" : getCustomerContactId());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getDesignStatus() == null ? "" : getDesignStatus());
		sb.append(",");
		sb.append(getProjectSalesTeam() == null ? "" : getProjectSalesTeam());
		sb.append(",");
		sb.append(getDesignTeam() == null ? "" : getDesignTeam());
		sb.append(",");
		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(strProjectLevel == null ? "" : strProjectLevel);
		sb.append(",");
		String strSignCompany = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getSignCompany()));
		sb.append(strSignCompany == null ? "" : strSignCompany);
		sb.append(",");
		sb.append(getDesignQualification() == null ? "" : getDesignQualification());
		sb.append(",");
		String strProjectBaseOn = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(getProjectBaseOn()));
		sb.append(strProjectBaseOn == null ? "" : strProjectBaseOn);
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getIsHighRiseBuilding() == null ? "" : getIsHighRiseBuilding());
		sb.append(",");
		sb.append(getDesignCooperationName() == null ? "" : getDesignCooperationName());
		sb.append(",");
		sb.append(getArchitecturalDesignUnits() == null ? "" : getArchitecturalDesignUnits());
		sb.append(",");
		sb.append(getProjectTotalInvestment() == null ? "" : getProjectTotalInvestment());
		sb.append(",");
		sb.append(getFireResistanceRating() == null ? "" : getFireResistanceRating());
		sb.append(",");
		sb.append(getEstimateTheDesignAreas() == null ? "" : getEstimateTheDesignAreas());
		sb.append(",");
		sb.append(getActualDesignAreas() == null ? "" : getActualDesignAreas());
		sb.append(",");
		sb.append(getBuildingHeight() == null ? "" : getBuildingHeight());
		sb.append(",");
		sb.append(getBuildingFloors() == null ? "" : getBuildingFloors());
		sb.append(",");
		sb.append(getDecorateMoneyControl() == null ? "" : getDecorateMoneyControl());
		sb.append(",");
		sb.append(getSpecialty() == null ? "" : getSpecialty());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		sb.append(getHasContract() == null ? "" : getHasContract());
		sb.append(",");
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getInfoRegisterTime() == null ? "" : sdf.format(getInfoRegisterTime()));
		sb.append(",");
		sb.append(getProjectStatus() == null ? "" : getProjectStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCloseProjectApply o) {
		return __pre_project_id == null ? -1 : __pre_project_id.compareTo(o.getPreProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_address);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__total_building_areas);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__project_origination_remark);
		hash = 97 * hash + Objects.hashCode(this.__customer_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__design_status);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__sign_company);
		hash = 97 * hash + Objects.hashCode(this.__design_qualification);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__is_high_rise_building);
		hash = 97 * hash + Objects.hashCode(this.__design_cooperation_name);
		hash = 97 * hash + Objects.hashCode(this.__architectural_design_units);
		hash = 97 * hash + Objects.hashCode(this.__project_total_investment);
		hash = 97 * hash + Objects.hashCode(this.__fire_resistance_rating);
		hash = 97 * hash + Objects.hashCode(this.__estimate_the_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__actual_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__building_height);
		hash = 97 * hash + Objects.hashCode(this.__building_floors);
		hash = 97 * hash + Objects.hashCode(this.__decorate_money_control);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__has_contract);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__info_register_time);
		hash = 97 * hash + Objects.hashCode(this.__project_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCloseProjectApply o = (BaseCloseProjectApply)obj;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__customer_address, o.getCustomerAddress())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__total_building_areas, o.getTotalBuildingAreas())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__project_origination_remark, o.getProjectOriginationRemark())) return false;
		if(!Objects.equals(this.__customer_contact_id, o.getCustomerContactId())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__design_status, o.getDesignStatus())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__sign_company, o.getSignCompany())) return false;
		if(!Objects.equals(this.__design_qualification, o.getDesignQualification())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__is_high_rise_building, o.getIsHighRiseBuilding())) return false;
		if(!Objects.equals(this.__design_cooperation_name, o.getDesignCooperationName())) return false;
		if(!Objects.equals(this.__architectural_design_units, o.getArchitecturalDesignUnits())) return false;
		if(!Objects.equals(this.__project_total_investment, o.getProjectTotalInvestment())) return false;
		if(!Objects.equals(this.__fire_resistance_rating, o.getFireResistanceRating())) return false;
		if(!Objects.equals(this.__estimate_the_design_areas, o.getEstimateTheDesignAreas())) return false;
		if(!Objects.equals(this.__actual_design_areas, o.getActualDesignAreas())) return false;
		if(!Objects.equals(this.__building_height, o.getBuildingHeight())) return false;
		if(!Objects.equals(this.__building_floors, o.getBuildingFloors())) return false;
		if(!Objects.equals(this.__decorate_money_control, o.getDecorateMoneyControl())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__has_contract, o.getHasContract())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__info_register_time, o.getInfoRegisterTime())) return false;
		if(!Objects.equals(this.__project_status, o.getProjectStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCustomerAddress() != null) sb.append(__wrapString(count++, "customerAddress", getCustomerAddress()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getTotalBuildingAreas() != null) sb.append(__wrapDecimal(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getProjectOriginationRemark() != null) sb.append(__wrapString(count++, "projectOriginationRemark", getProjectOriginationRemark()));
		if(getCustomerContactId() != null) sb.append(__wrapNumber(count++, "customerContactId", getCustomerContactId()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getDesignStatus() != null) sb.append(__wrapString(count++, "designStatus", getDesignStatus()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getSignCompany() != null) sb.append(__wrapNumber(count++, "signCompany", getSignCompany()));
		if(getDesignQualification() != null) sb.append(__wrapString(count++, "designQualification", getDesignQualification()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getIsHighRiseBuilding() != null) sb.append(__wrapBoolean(count++, "isHighRiseBuilding", getIsHighRiseBuilding()));
		if(getDesignCooperationName() != null) sb.append(__wrapString(count++, "designCooperationName", getDesignCooperationName()));
		if(getArchitecturalDesignUnits() != null) sb.append(__wrapString(count++, "architecturalDesignUnits", getArchitecturalDesignUnits()));
		if(getProjectTotalInvestment() != null) sb.append(__wrapDecimal(count++, "projectTotalInvestment", getProjectTotalInvestment()));
		if(getFireResistanceRating() != null) sb.append(__wrapString(count++, "fireResistanceRating", getFireResistanceRating()));
		if(getEstimateTheDesignAreas() != null) sb.append(__wrapDecimal(count++, "estimateTheDesignAreas", getEstimateTheDesignAreas()));
		if(getActualDesignAreas() != null) sb.append(__wrapDecimal(count++, "actualDesignAreas", getActualDesignAreas()));
		if(getBuildingHeight() != null) sb.append(__wrapDecimal(count++, "buildingHeight", getBuildingHeight()));
		if(getBuildingFloors() != null) sb.append(__wrapDecimal(count++, "buildingFloors", getBuildingFloors()));
		if(getDecorateMoneyControl() != null) sb.append(__wrapDecimal(count++, "decorateMoneyControl", getDecorateMoneyControl()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getHasContract() != null) sb.append(__wrapBoolean(count++, "hasContract", getHasContract()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getInfoRegisterTime() != null) sb.append(__wrapDate(count++, "infoRegisterTime", getInfoRegisterTime()));
		if(getProjectStatus() != null) sb.append(__wrapString(count++, "projectStatus", getProjectStatus()));
		if(getDetailMainProjectBusinessType() != null)  sb.append(__wrapList(count++, "detailMainProjectBusinessType", getDetailMainProjectBusinessType()));
		if(getDetailMainProjectSpecialty() != null)  sb.append(__wrapList(count++, "detailMainProjectSpecialty", getDetailMainProjectSpecialty()));
		if(getDetailMainProjectCompetitionUnit() != null)  sb.append(__wrapList(count++, "detailMainProjectCompetitionUnit", getDetailMainProjectCompetitionUnit()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("customerAddress")) != null) setCustomerAddress(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getDecimal(val));  
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("projectOriginationRemark")) != null) setProjectOriginationRemark(__getString(val));
		if((val = values.get("customerContactId")) != null) setCustomerContactId(__getInt(val)); 
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("designStatus")) != null) setDesignStatus(__getString(val));
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val)); 
		if((val = values.get("designQualification")) != null) setDesignQualification(__getString(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("isHighRiseBuilding")) != null) setIsHighRiseBuilding(__getBoolean(val));
		if((val = values.get("designCooperationName")) != null) setDesignCooperationName(__getString(val));
		if((val = values.get("architecturalDesignUnits")) != null) setArchitecturalDesignUnits(__getString(val));
		if((val = values.get("projectTotalInvestment")) != null) setProjectTotalInvestment(__getDecimal(val));  
		if((val = values.get("fireResistanceRating")) != null) setFireResistanceRating(__getString(val));
		if((val = values.get("estimateTheDesignAreas")) != null) setEstimateTheDesignAreas(__getDecimal(val));  
		if((val = values.get("actualDesignAreas")) != null) setActualDesignAreas(__getDecimal(val));  
		if((val = values.get("buildingHeight")) != null) setBuildingHeight(__getDecimal(val));  
		if((val = values.get("buildingFloors")) != null) setBuildingFloors(__getDecimal(val));  
		if((val = values.get("decorateMoneyControl")) != null) setDecorateMoneyControl(__getDecimal(val));  
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("hasContract")) != null) setHasContract(__getBoolean(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("infoRegisterTime")) != null) setInfoRegisterTime(__getDate(val)); 
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("detailMainProjectBusinessType")) != null) setDetailMainProjectBusinessType(__getList(val, BaseMainProjectBusinessType.newInstance()));
		if((val = values.get("detailMainProjectSpecialty")) != null) setDetailMainProjectSpecialty(__getList(val, BaseMainProjectSpecialty.newInstance()));
		if((val = values.get("detailMainProjectCompetitionUnit")) != null) setDetailMainProjectCompetitionUnit(__getList(val, BaseMainProjectCompetitionUnit.newInstance()));
	}

	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __client_id ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __customer_address ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __detail_address ;
	protected java.lang.String  __project_type ;
	protected java.math.BigDecimal  __total_building_areas ;
	protected java.lang.String  __project_origination ;
	protected java.lang.String  __project_origination_remark ;
	protected java.lang.Integer  __customer_contact_id ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __design_status ;
	protected java.lang.String  __project_sales_team ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __sign_company ;
	protected java.lang.String  __design_qualification ;
	protected java.lang.Integer  __project_base_on ;
	protected java.util.Date  __project_approval_time ;
	protected java.lang.Boolean  __is_high_rise_building ;
	protected java.lang.String  __design_cooperation_name ;
	protected java.lang.String  __architectural_design_units ;
	protected java.math.BigDecimal  __project_total_investment ;
	protected java.lang.String  __fire_resistance_rating ;
	protected java.math.BigDecimal  __estimate_the_design_areas ;
	protected java.math.BigDecimal  __actual_design_areas ;
	protected java.math.BigDecimal  __building_height ;
	protected java.math.BigDecimal  __building_floors ;
	protected java.math.BigDecimal  __decorate_money_control ;
	protected java.lang.String  __specialty ;
	protected java.lang.String  __business_type ;
	protected java.lang.Boolean  __has_contract ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __info_register_time ;
	protected java.lang.String  __project_status ;
	protected java.util.List<BaseMainProjectBusinessType> __detailMainProjectBusinessType = null;
	protected java.util.List<BaseMainProjectSpecialty> __detailMainProjectSpecialty = null;
	protected java.util.List<BaseMainProjectCompetitionUnit> __detailMainProjectCompetitionUnit = null;
}
