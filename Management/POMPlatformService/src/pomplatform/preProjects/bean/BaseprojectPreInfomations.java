package pomplatform.preProjects.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;
import delicacy.common.BaseFactory;
import delicacy.common.BaseHelpUtils;

public class BaseprojectPreInfomations extends GenericBase implements BaseFactory<BaseprojectPreInfomations>, Comparable<BaseprojectPreInfomations>
{


	public static BaseprojectPreInfomations newInstance(){
		return new BaseprojectPreInfomations();
	}

	@Override
	public BaseprojectPreInfomations make(){
		BaseprojectPreInfomations b = new BaseprojectPreInfomations();
		return b;
	}

	public final static java.lang.String CS_WARN_IMG = "warn_img" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_WIN_RATE = "win_rate" ;
	public final static java.lang.String CS_PROJECT_STATUS = "project_status" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REGISTER_DATE = "register_date" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_COMPARISON_FORM = "comparison_form" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_PROJECT_MISSIONER = "project_missioner" ;
	public final static java.lang.String CS_ESTIMATE_THE_DESIGN_AREAS = "estimate_the_design_areas" ;
	public final static java.lang.String CS_ACTUAL_DESIGN_AREAS = "actual_design_areas" ;
	public final static java.lang.String CS_PROJECT_TOTAL_INVESTMENT = "project_total_investment" ;
	public final static java.lang.String CS_DECORATE_MONEY_CONTROL = "decorate_money_control" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_PROJECT_LEADER = "project_leader" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;
	public final static java.lang.String CS_DESIGN_STATUS = "design_status" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION_REMARK = "project_origination_remark" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_INFO_REGISTER_TIME = "info_register_time" ;
	public final static java.lang.String CS_CUSTOMER_ADDRESS = "customer_address" ;
	public final static java.lang.String CS_SIGN_COMPANY = "sign_company" ;
	public final static java.lang.String CS_DESIGN_QUALIFICATION = "design_qualification" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_DESIGN_COOPERATION_NAME = "design_cooperation_name" ;
	public final static java.lang.String CS_IS_HIGH_RISE_BUILDING = "is_high_rise_building" ;
	public final static java.lang.String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;
	public final static java.lang.String CS_FIRE_RESISTANCE_RATING = "fire_resistance_rating" ;
	public final static java.lang.String CS_BUILDING_HEIGHT = "building_height" ;
	public final static java.lang.String CS_BUILDING_FLOORS = "building_floors" ;
	public final static java.lang.String CS_ARCHITECTURAL_DESIGN_UNITS = "architectural_design_units" ;
	public final static java.lang.String CS_CONTACT_EMAIL = "contact_email" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static java.lang.String CS_REGION = "region" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CLOSE_REASON = "close_reason" ;
	public final static java.lang.String CS_CLOSE_REMARK = "close_remark" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_IS_ORIGINAL = "is_original" ;
	public final static java.lang.String CS_IS_SUB_PROJECT = "is_sub_project" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_IS_PUBLICLY_BIDDING = "is_publicly_bidding" ;
	public final static java.lang.String CS_HAVE_AGENTS = "have_agents" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_OWNER_TYPE_ID = "owner_type_id" ;
	public final static java.lang.String CS_ESTIMATE_PRICE = "estimate_price" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_SPECIALTY = "specialty" ;
	public final static java.lang.String CS_COMPETITION_NAME = "competition_name" ;
	public final static java.lang.String CS_IS_OPERATION_DEPARTMENT = "is_operation_department" ;

	public final static java.lang.String ALL_CAPTIONS = ",项目编号,信息编号,项目名称,开发商名称,业务类别,详细地址,项目等级system_dictionary_2,预估合同金额,赢率,项目状态system_dictionary_154,报备人,项目营销团队plate_str,流程状态,立项/关闭的流程状态(1立项进行中，2已立项，5立项失败，4关闭进行中，5已关闭，6关闭失败),立项依据system_dictionary_28,报备时间,登记时间,项目来源渠道,比选形式,联系人,联系电话,,设计预估面积,实际设计面积,项目总投资额,装修造价控制,主办设计团队plate_records,,,合同状态,设计状态system_dictionary_155,项目来源说明,项目地址（省）,项目地址（市）,修改时间,开发商地址,拟签约公司company_records,设计资质章system_dictionary_157,立项时间,设计合作单位,是否高层建筑,项目面积,耐火等级,建筑高度,建筑楼层,建筑设计单位,联系人邮箱,板块,员工姓名,项目类别,开发商id,区域,备注,关闭项目理由,项目关闭备注,联系人职位,是否原创,是否建筑院分包项目,,,是否公开挂网招标,是否有代理商,部门,业主所属行业类型,预估价格,主键编码,合同参与专业,,是否运营组分配项目";
	public final static java.lang.String EXITPORTT_CAPTIONS = "项目编号,信息编号,项目名称,开发商名称,业务类别,项目类别,区域,省份,城市,详细地址,项目等级,预估合同金额,赢率,项目状态,报备人,项目营销团队,报备流程状态,立项/关闭的流程状态,立项依据,报备时间,登记时间,项目来源渠道,比选形式,联系人,联系电话,项目营销专员,主办设计团队,项目主管领导,项目经理,是否运营组分配项目 ,竞争单位,项目关闭原因,项目关闭备注,项目产值";
	public java.lang.String getWarnImg() {
		return this.__warn_img;
	}

	public void setWarnImg( java.lang.String value ) {
		this.__warn_img = value;
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

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.String getWinRate() {
		return this.__win_rate;
	}

	public void setWinRate( java.lang.String value ) {
		this.__win_rate = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
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

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}

	public java.lang.String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( java.lang.String value ) {
		this.__project_origination = value;
	}

	public java.lang.Integer getComparisonForm() {
		return this.__comparison_form;
	}

	public void setComparisonForm( java.lang.Integer value ) {
		this.__comparison_form = value;
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

	public java.lang.String getProjectMissioner() {
		return this.__project_missioner;
	}

	public void setProjectMissioner( java.lang.String value ) {
		this.__project_missioner = value;
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

	public java.math.BigDecimal getProjectTotalInvestment() {
		return this.__project_total_investment;
	}

	public void setProjectTotalInvestment( java.math.BigDecimal value ) {
		this.__project_total_investment = value;
	}

	public java.math.BigDecimal getDecorateMoneyControl() {
		return this.__decorate_money_control;
	}

	public void setDecorateMoneyControl( java.math.BigDecimal value ) {
		this.__decorate_money_control = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
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

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.String getDesignStatus() {
		return this.__design_status;
	}

	public void setDesignStatus( java.lang.String value ) {
		this.__design_status = value;
	}

	public java.lang.String getProjectOriginationRemark() {
		return this.__project_origination_remark;
	}

	public void setProjectOriginationRemark( java.lang.String value ) {
		this.__project_origination_remark = value;
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

	public java.util.Date getInfoRegisterTime() {
		return this.__info_register_time;
	}

	public void setInfoRegisterTime( java.util.Date value ) {
		this.__info_register_time = value;
	}

	public java.lang.String getCustomerAddress() {
		return this.__customer_address;
	}

	public void setCustomerAddress( java.lang.String value ) {
		this.__customer_address = value;
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

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.String getDesignCooperationName() {
		return this.__design_cooperation_name;
	}

	public void setDesignCooperationName( java.lang.String value ) {
		this.__design_cooperation_name = value;
	}

	public java.lang.Boolean getIsHighRiseBuilding() {
		return this.__is_high_rise_building;
	}

	public void setIsHighRiseBuilding( java.lang.Boolean value ) {
		this.__is_high_rise_building = value;
	}

	public java.math.BigDecimal getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( java.math.BigDecimal value ) {
		this.__total_building_areas = value;
	}

	public java.lang.String getFireResistanceRating() {
		return this.__fire_resistance_rating;
	}

	public void setFireResistanceRating( java.lang.String value ) {
		this.__fire_resistance_rating = value;
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

	public java.lang.String getArchitecturalDesignUnits() {
		return this.__architectural_design_units;
	}

	public void setArchitecturalDesignUnits( java.lang.String value ) {
		this.__architectural_design_units = value;
	}

	public java.lang.String getContactEmail() {
		return this.__contact_email;
	}

	public void setContactEmail( java.lang.String value ) {
		this.__contact_email = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.Integer getRegion() {
		return this.__region;
	}

	public void setRegion( java.lang.Integer value ) {
		this.__region = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.lang.String getGrade() {
		return this.__grade;
	}

	public void setGrade( java.lang.String value ) {
		this.__grade = value;
	}

	public java.lang.Boolean getIsOriginal() {
		return this.__is_original;
	}

	public void setIsOriginal( java.lang.Boolean value ) {
		this.__is_original = value;
	}

	public java.lang.Boolean getIsSubProject() {
		return this.__is_sub_project;
	}

	public void setIsSubProject( java.lang.Boolean value ) {
		this.__is_sub_project = value;
	}

	public java.lang.Double getDays() {
		return this.__days;
	}

	public void setDays( java.lang.Double value ) {
		this.__days = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Boolean getIsPubliclyBidding() {
		return this.__is_publicly_bidding;
	}

	public void setIsPubliclyBidding( java.lang.Boolean value ) {
		this.__is_publicly_bidding = value;
	}

	public java.lang.Boolean getHaveAgents() {
		return this.__have_agents;
	}

	public void setHaveAgents( java.lang.Boolean value ) {
		this.__have_agents = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getOwnerTypeId() {
		return this.__owner_type_id;
	}

	public void setOwnerTypeId( java.lang.Integer value ) {
		this.__owner_type_id = value;
	}

	public java.math.BigDecimal getEstimatePrice() {
		return this.__estimate_price;
	}

	public void setEstimatePrice( java.math.BigDecimal value ) {
		this.__estimate_price = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( java.lang.String value ) {
		this.__specialty = value;
	}

	public java.lang.String getCompetitionName() {
		return this.__competition_name;
	}

	public void setCompetitionName( java.lang.String value ) {
		this.__competition_name = value;
	}

	public java.lang.Boolean getIsOperationDepartment() {
		return this.__is_operation_department;
	}

	public void setIsOperationDepartment( java.lang.Boolean value ) {
		this.__is_operation_department = value;
	}

	public java.math.BigDecimal getProjectOutputValue() {
		return __project_output_value;
	}

	public void setProjectOutputValue(java.math.BigDecimal value) {
		this.__project_output_value = value;
	}

	public void cloneCopy(BaseprojectPreInfomations __bean){
		__bean.setWarnImg(getWarnImg());
		__bean.setProjectCode(getProjectCode());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectName(getProjectName());
		__bean.setCustomerName(getCustomerName());
		__bean.setBusinessType(getBusinessType());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setContractAmount(getContractAmount());
		__bean.setWinRate(getWinRate());
		__bean.setProjectStatus(getProjectStatus());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setStatus(getStatus());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setCreateTime(getCreateTime());
		__bean.setRegisterDate(getRegisterDate());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setComparisonForm(getComparisonForm());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setProjectMissioner(getProjectMissioner());
		__bean.setEstimateTheDesignAreas(getEstimateTheDesignAreas());
		__bean.setActualDesignAreas(getActualDesignAreas());
		__bean.setProjectTotalInvestment(getProjectTotalInvestment());
		__bean.setDecorateMoneyControl(getDecorateMoneyControl());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setProjectLeader(getProjectLeader());
		__bean.setProjectManager(getProjectManager());
		__bean.setContractStatus(getContractStatus());
		__bean.setDesignStatus(getDesignStatus());
		__bean.setProjectOriginationRemark(getProjectOriginationRemark());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setInfoRegisterTime(getInfoRegisterTime());
		__bean.setCustomerAddress(getCustomerAddress());
		__bean.setSignCompany(getSignCompany());
		__bean.setDesignQualification(getDesignQualification());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setDesignCooperationName(getDesignCooperationName());
		__bean.setIsHighRiseBuilding(getIsHighRiseBuilding());
		__bean.setTotalBuildingAreas(getTotalBuildingAreas());
		__bean.setFireResistanceRating(getFireResistanceRating());
		__bean.setBuildingHeight(getBuildingHeight());
		__bean.setBuildingFloors(getBuildingFloors());
		__bean.setArchitecturalDesignUnits(getArchitecturalDesignUnits());
		__bean.setContactEmail(getContactEmail());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setProjectType(getProjectType());
		__bean.setClientId(getClientId());
		__bean.setRegion(getRegion());
		__bean.setRemark(getRemark());
		__bean.setCloseReason(getCloseReason());
		__bean.setCloseRemark(getCloseRemark());
		__bean.setGrade(getGrade());
		__bean.setIsOriginal(getIsOriginal());
		__bean.setIsSubProject(getIsSubProject());
		__bean.setDays(getDays());
		__bean.setFlag(getFlag());
		__bean.setIsPubliclyBidding(getIsPubliclyBidding());
		__bean.setHaveAgents(getHaveAgents());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOwnerTypeId(getOwnerTypeId());
		__bean.setEstimatePrice(getEstimatePrice());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setSpecialty(getSpecialty());
		__bean.setCompetitionName(getCompetitionName());
		__bean.setIsOperationDepartment(getIsOperationDepartment());
		__bean.setProjectOutputValue(getProjectOutputValue());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType().replaceAll(",", "，"));
		sb.append(",");
		String projectType=delicacy.system.executor.SelectValueCache.getSelectValue("pre_business_type", String.valueOf(getProjectType()));
		sb.append(projectType == null ? "" : projectType);
		sb.append(",");
		String region =delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_170", String.valueOf(getRegion()));
		sb.append(region == null ? "" : region);
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getDetailAddress() == null ? "" : getDetailAddress().replaceAll(",", "，"));
		sb.append(",");
		String projectLevel=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(getProjectLevel() == null ? "" : projectLevel);
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getWinRate() == null ? "" : getWinRate());
		sb.append(",");
		sb.append(getProjectStatus() == null ? "前期跟踪" : getProjectStatus());
		sb.append(",");
		String ApplyEmployeeId=delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplyEmployeeId()));
		sb.append(getApplyEmployeeId() == null ? "" : ApplyEmployeeId);
		sb.append(",");
		String departmentId=delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(getDepartmentId() == null ? "" : departmentId);
		sb.append(",");
		String ProcessStatus=delicacy.system.executor.SelectValueCache.getSelectValue("process_status", String.valueOf(getProcessStatus()));
		sb.append(getProcessStatus() == null ? "" : ProcessStatus);
		sb.append(",");
		String status=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_161", String.valueOf(getStatus()));
		sb.append(getStatus() == null ? "" : status);
		sb.append(",");
		String projectBaseOn=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(getProjectBaseOn()));
		sb.append(getProjectBaseOn() == null ? "" : projectBaseOn);
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRegisterDate() == null ? "" : sdf.format(getRegisterDate()));
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		String getComparisonForm=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_168", String.valueOf(getComparisonForm()));
		sb.append(getComparisonForm() == null ? "" : getComparisonForm);
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getProjectMissioner() == null ? "" : getProjectMissioner().replaceAll(",", "，"));
		sb.append(",");
		String DesignTeam=delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getDesignTeam()));
		sb.append(getDesignTeam() == null ? "" : DesignTeam);
		sb.append(",");
		sb.append(getProjectLeader() == null ? "" : getProjectLeader().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getProjectManager() == null ? "" : getProjectManager().replaceAll(",", "，"));
		sb.append(",");
		String isOperationDepartment = "";
		if(getIsOperationDepartment()!=null) {
			if (getIsOperationDepartment().equals(false)) {
				isOperationDepartment = "否";
			} else if (getIsOperationDepartment().equals(true)) {
				isOperationDepartment = "是";
			}
		}
		sb.append(getIsOperationDepartment() == null ? "" : isOperationDepartment);
		sb.append(",");
		sb.append(getCompetitionName() == null ? "" : getCompetitionName().replaceAll(",", "，"));
		sb.append(",");
		String strCloseReason = SelectValueCache.getSelectValue("system_dictionary_169", BaseHelpUtils.getString(getCloseReason()));
		sb.append(strCloseReason == null ? "" : strCloseReason);
		sb.append(",");
		sb.append(getCloseRemark() == null ? "" : getCloseRemark().replaceAll(",", "，").replaceAll("\r", "").replaceAll("\n", ""));
		sb.append(",");
		sb.append(getProjectOutputValue() == null ? "" : getProjectOutputValue());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseprojectPreInfomations o) {
		return __pre_project_id == null ? -1 : __pre_project_id.compareTo(o.getPreProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__warn_img);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__win_rate);
		hash = 97 * hash + Objects.hashCode(this.__project_status);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__register_date);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__comparison_form);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__project_missioner);
		hash = 97 * hash + Objects.hashCode(this.__estimate_the_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__actual_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__project_total_investment);
		hash = 97 * hash + Objects.hashCode(this.__decorate_money_control);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__project_leader);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__design_status);
		hash = 97 * hash + Objects.hashCode(this.__project_origination_remark);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__info_register_time);
		hash = 97 * hash + Objects.hashCode(this.__customer_address);
		hash = 97 * hash + Objects.hashCode(this.__sign_company);
		hash = 97 * hash + Objects.hashCode(this.__design_qualification);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__design_cooperation_name);
		hash = 97 * hash + Objects.hashCode(this.__is_high_rise_building);
		hash = 97 * hash + Objects.hashCode(this.__total_building_areas);
		hash = 97 * hash + Objects.hashCode(this.__fire_resistance_rating);
		hash = 97 * hash + Objects.hashCode(this.__building_height);
		hash = 97 * hash + Objects.hashCode(this.__building_floors);
		hash = 97 * hash + Objects.hashCode(this.__architectural_design_units);
		hash = 97 * hash + Objects.hashCode(this.__contact_email);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__region);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__close_reason);
		hash = 97 * hash + Objects.hashCode(this.__close_remark);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__is_original);
		hash = 97 * hash + Objects.hashCode(this.__is_sub_project);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__is_publicly_bidding);
		hash = 97 * hash + Objects.hashCode(this.__have_agents);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__owner_type_id);
		hash = 97 * hash + Objects.hashCode(this.__estimate_price);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__competition_name);
		hash = 97 * hash + Objects.hashCode(this.__is_operation_department);
		hash = 97 * hash + Objects.hashCode(this.__project_output_value);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseprojectPreInfomations o = (BaseprojectPreInfomations)obj;
		if(!Objects.equals(this.__warn_img, o.getWarnImg())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__win_rate, o.getWinRate())) return false;
		if(!Objects.equals(this.__project_status, o.getProjectStatus())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__register_date, o.getRegisterDate())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__comparison_form, o.getComparisonForm())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__project_missioner, o.getProjectMissioner())) return false;
		if(!Objects.equals(this.__estimate_the_design_areas, o.getEstimateTheDesignAreas())) return false;
		if(!Objects.equals(this.__actual_design_areas, o.getActualDesignAreas())) return false;
		if(!Objects.equals(this.__project_total_investment, o.getProjectTotalInvestment())) return false;
		if(!Objects.equals(this.__decorate_money_control, o.getDecorateMoneyControl())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__project_leader, o.getProjectLeader())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__design_status, o.getDesignStatus())) return false;
		if(!Objects.equals(this.__project_origination_remark, o.getProjectOriginationRemark())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__info_register_time, o.getInfoRegisterTime())) return false;
		if(!Objects.equals(this.__customer_address, o.getCustomerAddress())) return false;
		if(!Objects.equals(this.__sign_company, o.getSignCompany())) return false;
		if(!Objects.equals(this.__design_qualification, o.getDesignQualification())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__design_cooperation_name, o.getDesignCooperationName())) return false;
		if(!Objects.equals(this.__is_high_rise_building, o.getIsHighRiseBuilding())) return false;
		if(!Objects.equals(this.__total_building_areas, o.getTotalBuildingAreas())) return false;
		if(!Objects.equals(this.__fire_resistance_rating, o.getFireResistanceRating())) return false;
		if(!Objects.equals(this.__building_height, o.getBuildingHeight())) return false;
		if(!Objects.equals(this.__building_floors, o.getBuildingFloors())) return false;
		if(!Objects.equals(this.__architectural_design_units, o.getArchitecturalDesignUnits())) return false;
		if(!Objects.equals(this.__contact_email, o.getContactEmail())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__region, o.getRegion())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__close_reason, o.getCloseReason())) return false;
		if(!Objects.equals(this.__close_remark, o.getCloseRemark())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__is_original, o.getIsOriginal())) return false;
		if(!Objects.equals(this.__is_sub_project, o.getIsSubProject())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__is_publicly_bidding, o.getIsPubliclyBidding())) return false;
		if(!Objects.equals(this.__have_agents, o.getHaveAgents())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__owner_type_id, o.getOwnerTypeId())) return false;
		if(!Objects.equals(this.__estimate_price, o.getEstimatePrice())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__competition_name, o.getCompetitionName())) return false;
		if(!Objects.equals(this.__is_operation_department, o.getIsOperationDepartment())) return false;
		if(!Objects.equals(this.__project_output_value, o.getProjectOutputValue())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWarnImg() != null) sb.append(__wrapString(count++, "warnImg", getWarnImg()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getWinRate() != null) sb.append(__wrapString(count++, "winRate", getWinRate()));
		if(getProjectStatus() != null) {
			sb.append(__wrapString(count++, "projectStatus", getProjectStatus()));
		}else {
			sb.append(__wrapString(count++, "projectStatus", "前期跟踪"));
		}
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRegisterDate() != null) sb.append(__wrapDate(count++, "registerDate", getRegisterDate()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getComparisonForm() != null) sb.append(__wrapNumber(count++, "comparisonForm", getComparisonForm()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getProjectMissioner() != null) sb.append(__wrapString(count++, "projectMissioner", getProjectMissioner()));
		if(getEstimateTheDesignAreas() != null) sb.append(__wrapDecimal(count++, "estimateTheDesignAreas", getEstimateTheDesignAreas()));
		if(getActualDesignAreas() != null) sb.append(__wrapDecimal(count++, "actualDesignAreas", getActualDesignAreas()));
		if(getProjectTotalInvestment() != null) sb.append(__wrapDecimal(count++, "projectTotalInvestment", getProjectTotalInvestment()));
		if(getDecorateMoneyControl() != null) sb.append(__wrapDecimal(count++, "decorateMoneyControl", getDecorateMoneyControl()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getProjectLeader() != null) sb.append(__wrapString(count++, "projectLeader", getProjectLeader()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getDesignStatus() != null) sb.append(__wrapString(count++, "designStatus", getDesignStatus()));
		if(getProjectOriginationRemark() != null) sb.append(__wrapString(count++, "projectOriginationRemark", getProjectOriginationRemark()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getInfoRegisterTime() != null) sb.append(__wrapDate(count++, "infoRegisterTime", getInfoRegisterTime()));
		if(getCustomerAddress() != null) sb.append(__wrapString(count++, "customerAddress", getCustomerAddress()));
		if(getSignCompany() != null) sb.append(__wrapNumber(count++, "signCompany", getSignCompany()));
		if(getDesignQualification() != null) sb.append(__wrapString(count++, "designQualification", getDesignQualification()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getDesignCooperationName() != null) sb.append(__wrapString(count++, "designCooperationName", getDesignCooperationName()));
		if(getIsHighRiseBuilding() != null) sb.append(__wrapBoolean(count++, "isHighRiseBuilding", getIsHighRiseBuilding()));
		if(getTotalBuildingAreas() != null) sb.append(__wrapDecimal(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getFireResistanceRating() != null) sb.append(__wrapString(count++, "fireResistanceRating", getFireResistanceRating()));
		if(getBuildingHeight() != null) sb.append(__wrapDecimal(count++, "buildingHeight", getBuildingHeight()));
		if(getBuildingFloors() != null) sb.append(__wrapDecimal(count++, "buildingFloors", getBuildingFloors()));
		if(getArchitecturalDesignUnits() != null) sb.append(__wrapString(count++, "architecturalDesignUnits", getArchitecturalDesignUnits()));
		if(getContactEmail() != null) sb.append(__wrapString(count++, "contactEmail", getContactEmail()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getRegion() != null) sb.append(__wrapNumber(count++, "region", getRegion()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCloseReason() != null) sb.append(__wrapString(count++, "closeReason", getCloseReason()));
		if(getCloseRemark() != null) sb.append(__wrapString(count++, "closeRemark", getCloseRemark()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getIsOriginal() != null) sb.append(__wrapBoolean(count++, "isOriginal", getIsOriginal()));
		if(getIsSubProject() != null) sb.append(__wrapBoolean(count++, "isSubProject", getIsSubProject()));
		if(getDays() != null) sb.append(__wrapNumber(count++, "days", getDays()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getIsPubliclyBidding() != null) sb.append(__wrapBoolean(count++, "isPubliclyBidding", getIsPubliclyBidding()));
		if(getHaveAgents() != null) sb.append(__wrapBoolean(count++, "haveAgents", getHaveAgents()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOwnerTypeId() != null) sb.append(__wrapNumber(count++, "ownerTypeId", getOwnerTypeId()));
		if(getEstimatePrice() != null) sb.append(__wrapDecimal(count++, "estimatePrice", getEstimatePrice()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getCompetitionName() != null) sb.append(__wrapString(count++, "competitionName", getCompetitionName()));
		if(getIsOperationDepartment() != null) sb.append(__wrapBoolean(count++, "isOperationDepartment", getIsOperationDepartment()));
		if(getProjectOutputValue() != null) sb.append(__wrapDecimal(count++, "projectOutputValue", getProjectOutputValue()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("warnImg")) != null) setWarnImg(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val));
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));
		if((val = values.get("winRate")) != null) setWinRate(__getString(val));
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val));
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val));
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("comparisonForm")) != null) setComparisonForm(__getInt(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("projectMissioner")) != null) setProjectMissioner(__getString(val));
		if((val = values.get("estimateTheDesignAreas")) != null) setEstimateTheDesignAreas(__getDecimal(val));
		if((val = values.get("actualDesignAreas")) != null) setActualDesignAreas(__getDecimal(val));
		if((val = values.get("projectTotalInvestment")) != null) setProjectTotalInvestment(__getDecimal(val));
		if((val = values.get("decorateMoneyControl")) != null) setDecorateMoneyControl(__getDecimal(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val));
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val));
		if((val = values.get("designStatus")) != null) setDesignStatus(__getString(val));
		if((val = values.get("projectOriginationRemark")) != null) setProjectOriginationRemark(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("infoRegisterTime")) != null) setInfoRegisterTime(__getDate(val));
		if((val = values.get("customerAddress")) != null) setCustomerAddress(__getString(val));
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val));
		if((val = values.get("designQualification")) != null) setDesignQualification(__getString(val));
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val));
		if((val = values.get("designCooperationName")) != null) setDesignCooperationName(__getString(val));
		if((val = values.get("isHighRiseBuilding")) != null) setIsHighRiseBuilding(__getBoolean(val));
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getDecimal(val));
		if((val = values.get("fireResistanceRating")) != null) setFireResistanceRating(__getString(val));
		if((val = values.get("buildingHeight")) != null) setBuildingHeight(__getDecimal(val));
		if((val = values.get("buildingFloors")) != null) setBuildingFloors(__getDecimal(val));
		if((val = values.get("architecturalDesignUnits")) != null) setArchitecturalDesignUnits(__getString(val));
		if((val = values.get("contactEmail")) != null) setContactEmail(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("clientId")) != null) setClientId(__getInt(val));
		if((val = values.get("region")) != null) setRegion(__getInt(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("closeReason")) != null) setCloseReason(__getString(val));
		if((val = values.get("closeRemark")) != null) setCloseRemark(__getString(val));
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("isOriginal")) != null) setIsOriginal(__getBoolean(val));
		if((val = values.get("isSubProject")) != null) setIsSubProject(__getBoolean(val));
		if((val = values.get("days")) != null) setDays(__getDouble(val));
		if((val = values.get("flag")) != null) setFlag(__getInt(val));
		if((val = values.get("isPubliclyBidding")) != null) setIsPubliclyBidding(__getBoolean(val));
		if((val = values.get("haveAgents")) != null) setHaveAgents(__getBoolean(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
		if((val = values.get("ownerTypeId")) != null) setOwnerTypeId(__getInt(val));
		if((val = values.get("estimatePrice")) != null) setEstimatePrice(__getDecimal(val));
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val));
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("competitionName")) != null) setCompetitionName(__getString(val));
		if((val = values.get("isOperationDepartment")) != null) setIsOperationDepartment(__getBoolean(val));
		if((val = values.get("projectOutputValue")) != null) setProjectOutputValue(__getDecimal(val));
	}

	protected java.lang.String  __warn_img ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __business_type ;
	protected java.lang.String  __detail_address ;
	protected java.lang.Integer  __project_level ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.String  __win_rate ;
	protected java.lang.String  __project_status ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.String  __project_sales_team ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __project_base_on ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __register_date ;
	protected java.lang.String  __project_origination ;
	protected java.lang.Integer  __comparison_form ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __project_missioner ;
	protected java.math.BigDecimal  __estimate_the_design_areas ;
	protected java.math.BigDecimal  __actual_design_areas ;
	protected java.math.BigDecimal  __project_total_investment ;
	protected java.math.BigDecimal  __decorate_money_control ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.String  __project_leader ;
	protected java.lang.String  __project_manager ;
	protected java.lang.Integer  __contract_status ;
	protected java.lang.String  __design_status ;
	protected java.lang.String  __project_origination_remark ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.util.Date  __info_register_time ;
	protected java.lang.String  __customer_address ;
	protected java.lang.Integer  __sign_company ;
	protected java.lang.String  __design_qualification ;
	protected java.util.Date  __project_approval_time ;
	protected java.lang.String  __design_cooperation_name ;
	protected java.lang.Boolean  __is_high_rise_building ;
	protected java.math.BigDecimal  __total_building_areas ;
	protected java.lang.String  __fire_resistance_rating ;
	protected java.math.BigDecimal  __building_height ;
	protected java.math.BigDecimal  __building_floors ;
	protected java.lang.String  __architectural_design_units ;
	protected java.lang.String  __contact_email ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __project_type ;
	protected java.lang.Integer  __client_id ;
	protected java.lang.Integer  __region ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __close_reason ;
	protected java.lang.String  __close_remark ;
	protected java.lang.String  __grade ;
	protected java.lang.Boolean  __is_original ;
	protected java.lang.Boolean  __is_sub_project ;
	protected java.lang.Double  __days ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Boolean  __is_publicly_bidding ;
	protected java.lang.Boolean  __have_agents ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __owner_type_id ;
	protected java.math.BigDecimal  __estimate_price ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __specialty ;
	protected java.lang.String  __competition_name ;
	protected java.lang.Boolean  __is_operation_department ;
	protected java.math.BigDecimal  __project_output_value ;
}
