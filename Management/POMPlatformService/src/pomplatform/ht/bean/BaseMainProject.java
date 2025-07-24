package pomplatform.ht.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMainProject extends GenericBase implements BaseFactory<BaseMainProject>, Comparable<BaseMainProject>
{


	public static BaseMainProject newInstance(){
		return new BaseMainProject();
	}

	@Override
	public BaseMainProject make(){
		BaseMainProject b = new BaseMainProject();
		return b;
	}

	public final static String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_PROJECT_ENGLISH_NAME = "project_english_name" ;
	public final static String CS_PROJECT_STATUS = "project_status" ;
	public final static String CS_DESIGN_STATUS = "design_status" ;
	public final static String CS_SIGN_COMPANY = "sign_company" ;
	public final static String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static String CS_PROJECT_ORIGINATION_REMARK = "project_origination_remark" ;
	public final static String CS_DESIGN_COOPERATION_NAME = "design_cooperation_name" ;
	public final static String CS_DESIGN_COOPERATION_ENGLISH_NAME = "design_cooperation_english_name" ;
	public final static String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static String CS_DESIGN_TEAM = "design_team" ;
	public final static String CS_IS_HIGH_RISE_BUILDING = "is_high_rise_building" ;
	public final static String CS_INFO_REGISTER_TIME = "info_register_time" ;
	public final static String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static String CS_HAS_CONTRACT = "has_contract" ;
	public final static String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static String CS_INFO_CODE = "info_code" ;
	public final static String CS_PROJECT_MODEL = "project_model" ;
	public final static String CS_DESIGN_QUALIFICATION = "design_qualification" ;
	public final static String CS_BUSINESS_TYPE = "business_type" ;
	public final static String CS_FIRE_RESISTANCE_RATING = "fire_resistance_rating" ;
	public final static String CS_ESTIMATE_THE_DESIGN_AREAS = "estimate_the_design_areas" ;
	public final static String CS_PROJECT_TOTAL_INVESTMENT = "project_total_investment" ;
	public final static String CS_ACTUAL_DESIGN_AREAS = "actual_design_areas" ;
	public final static String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;
	public final static String CS_BUILDING_HEIGHT = "building_height" ;
	public final static String CS_BUILDING_FLOORS = "building_floors" ;
	public final static String CS_DECORATE_MONEY_CONTROL = "decorate_money_control" ;
	public final static String CS_PROJECT_LEVEL = "project_level" ;
	public final static String CS_PROVINCE = "province" ;
	public final static String CS_CITY = "city" ;
	public final static String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static String CS_PROJECT_END_TIME = "project_end_time" ;
	public final static String CS_PROJECT_TYPE = "project_type" ;
	public final static String CS_CUSTOMER_NAME = "customer_name" ;
	public final static String CS_CUSTOMER_ADDRESS = "customer_address" ;
	public final static String CS_BID_PROJECT = "bid_project" ;
	public final static String CS_CONSTRUCTION_UNIT = "construction_unit" ;
	public final static String CS_ARCHITECTURAL_DESIGN_UNITS = "architectural_design_units" ;
	public final static String CS_RATE_OF_BID_WINNING = "rate_of_bid_winning" ;
	public final static String CS_FOLLOW_UP_DATE = "follow_up_date" ;
	public final static String CS_EQUITYEDGE_REMARK = "equityedge_remark" ;
	public final static String CS_ORDER_SIGN_UP_TIME = "order_sign_up_time" ;
	public final static String CS_DESIGN_SERVICE_BOOK = "design_service_book" ;
	public final static String CS_SERVICE_SUGGEST_BOOK = "service_suggest_book" ;
	public final static String CS_TOTAL_MONEY = "total_money" ;
	public final static String CS_COVERED_AREA = "covered_area" ;
	public final static String CS_DESIGN_AREA = "design_area" ;
	public final static String CS_HAS_FORMAL_CONTRACTS = "has_formal_contracts" ;
	public final static String CS_HAS_OUT_QUOTATIONS = "has_out_quotations" ;
	public final static String CS_HAS_SPLIT_PRICE = "has_split_price" ;
	public final static String CS_HAS_ORDER_RELEASE = "has_order_release" ;
	public final static String CS_HAS_DEPOSIT = "has_deposit" ;
	public final static String CS_HAS_RATE_OF_PAYMENT = "has_rate_of_payment" ;
	public final static String CS_BID_TYPE = "bid_type" ;
	public final static java.lang.String CS_OUTSOURCE = "outsource" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static String CS_SECRETARY = "secretary" ;
	public final static String CS_MANAGER = "manager" ;
	public final static String CS_LEADER = "leader" ;
	public final static String CS_CHARGE_PERSON = "charge_person" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编号,项目名称,业务类别,立项依据,投标结果,主办设计团队,项目秘书,项目主管领导,项目负责人,项目经理";

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( Integer value ) {
		this.__main_project_id = value;
	}

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public String getProjectEnglishName() {
		return this.__project_english_name;
	}

	public void setProjectEnglishName( String value ) {
		this.__project_english_name = value;
	}

	public String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( String value ) {
		this.__project_status = value;
	}

	public String getDesignStatus() {
		return this.__design_status;
	}

	public void setDesignStatus( String value ) {
		this.__design_status = value;
	}

	public Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( Integer value ) {
		this.__sign_company = value;
	}

	public String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( String value ) {
		this.__project_origination = value;
	}

	public String getProjectOriginationRemark() {
		return this.__project_origination_remark;
	}

	public void setProjectOriginationRemark( String value ) {
		this.__project_origination_remark = value;
	}

	public String getDesignCooperationName() {
		return this.__design_cooperation_name;
	}

	public void setDesignCooperationName( String value ) {
		this.__design_cooperation_name = value;
	}

	public String getDesignCooperationEnglishName() {
		return this.__design_cooperation_english_name;
	}

	public void setDesignCooperationEnglishName( String value ) {
		this.__design_cooperation_english_name = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( Integer value ) {
		this.__design_team = value;
	}

	public Boolean getIsHighRiseBuilding() {
		return this.__is_high_rise_building;
	}

	public void setIsHighRiseBuilding( Boolean value ) {
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

	public Boolean getHasContract() {
		return this.__has_contract;
	}

	public void setHasContract( Boolean value ) {
		this.__has_contract = value;
	}

	public Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( Integer value ) {
		this.__project_base_on = value;
	}

	public String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public String getProjectModel() {
		return this.__project_model;
	}

	public void setProjectModel( String value ) {
		this.__project_model = value;
	}

	public String getDesignQualification() {
		return this.__design_qualification;
	}

	public void setDesignQualification( String value ) {
		this.__design_qualification = value;
	}

	public String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( String value ) {
		this.__business_type = value;
	}

	public String getFireResistanceRating() {
		return this.__fire_resistance_rating;
	}

	public void setFireResistanceRating( String value ) {
		this.__fire_resistance_rating = value;
	}

	public String getEstimateTheDesignAreas() {
		return this.__estimate_the_design_areas;
	}

	public void setEstimateTheDesignAreas( String value ) {
		this.__estimate_the_design_areas = value;
	}

	public String getProjectTotalInvestment() {
		return this.__project_total_investment;
	}

	public void setProjectTotalInvestment( String value ) {
		this.__project_total_investment = value;
	}

	public String getActualDesignAreas() {
		return this.__actual_design_areas;
	}

	public void setActualDesignAreas( String value ) {
		this.__actual_design_areas = value;
	}

	public String getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( String value ) {
		this.__total_building_areas = value;
	}

	public String getBuildingHeight() {
		return this.__building_height;
	}

	public void setBuildingHeight( String value ) {
		this.__building_height = value;
	}

	public String getBuildingFloors() {
		return this.__building_floors;
	}

	public void setBuildingFloors( String value ) {
		this.__building_floors = value;
	}

	public String getDecorateMoneyControl() {
		return this.__decorate_money_control;
	}

	public void setDecorateMoneyControl( String value ) {
		this.__decorate_money_control = value;
	}

	public Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( Integer value ) {
		this.__project_level = value;
	}

	public String getProvince() {
		return this.__province;
	}

	public void setProvince( String value ) {
		this.__province = value;
	}

	public String getCity() {
		return this.__city;
	}

	public void setCity( String value ) {
		this.__city = value;
	}

	public String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( String value ) {
		this.__detail_address = value;
	}

	public java.util.Date getProjectEndTime() {
		return this.__project_end_time;
	}

	public void setProjectEndTime( java.util.Date value ) {
		this.__project_end_time = value;
	}

	public String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( String value ) {
		this.__project_type = value;
	}

	public String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( String value ) {
		this.__customer_name = value;
	}

	public String getCustomerAddress() {
		return this.__customer_address;
	}

	public void setCustomerAddress( String value ) {
		this.__customer_address = value;
	}

	public String getBidProject() {
		return this.__bid_project;
	}

	public void setBidProject( String value ) {
		this.__bid_project = value;
	}

	public String getConstructionUnit() {
		return this.__construction_unit;
	}

	public void setConstructionUnit( String value ) {
		this.__construction_unit = value;
	}

	public String getArchitecturalDesignUnits() {
		return this.__architectural_design_units;
	}

	public void setArchitecturalDesignUnits( String value ) {
		this.__architectural_design_units = value;
	}

	public String getRateOfBidWinning() {
		return this.__rate_of_bid_winning;
	}

	public void setRateOfBidWinning( String value ) {
		this.__rate_of_bid_winning = value;
	}

	public java.util.Date getFollowUpDate() {
		return this.__follow_up_date;
	}

	public void setFollowUpDate( java.util.Date value ) {
		this.__follow_up_date = value;
	}

	public String getEquityedgeRemark() {
		return this.__equityedge_remark;
	}

	public void setEquityedgeRemark( String value ) {
		this.__equityedge_remark = value;
	}

	public java.util.Date getOrderSignUpTime() {
		return this.__order_sign_up_time;
	}

	public void setOrderSignUpTime( java.util.Date value ) {
		this.__order_sign_up_time = value;
	}

	public String getDesignServiceBook() {
		return this.__design_service_book;
	}

	public void setDesignServiceBook( String value ) {
		this.__design_service_book = value;
	}

	public String getServiceSuggestBook() {
		return this.__service_suggest_book;
	}

	public void setServiceSuggestBook( String value ) {
		this.__service_suggest_book = value;
	}

	public java.math.BigDecimal getTotalMoney() {
		return this.__total_money;
	}

	public void setTotalMoney( java.math.BigDecimal value ) {
		this.__total_money = value;
	}

	public java.math.BigDecimal getCoveredArea() {
		return this.__covered_area;
	}

	public void setCoveredArea( java.math.BigDecimal value ) {
		this.__covered_area = value;
	}

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public Boolean getHasFormalContracts() {
		return this.__has_formal_contracts;
	}

	public void setHasFormalContracts( Boolean value ) {
		this.__has_formal_contracts = value;
	}

	public Boolean getHasOutQuotations() {
		return this.__has_out_quotations;
	}

	public void setHasOutQuotations( Boolean value ) {
		this.__has_out_quotations = value;
	}

	public java.lang.String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( java.lang.String value ) {
		this.__specialty = value;
	}

	public java.lang.String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( java.lang.String value ) {
		this.__project_sales_team = value;
	}

	public java.lang.Boolean getHasSplitPrice() {
		return this.__has_split_price;
	}

	public void setHasSplitPrice( Boolean value ) {
		this.__has_split_price = value;
	}

	public Boolean getHasOrderRelease() {
		return this.__has_order_release;
	}

	public void setHasOrderRelease( Boolean value ) {
		this.__has_order_release = value;
	}

	public Boolean getHasDeposit() {
		return this.__has_deposit;
	}

	public void setHasDeposit( Boolean value ) {
		this.__has_deposit = value;
	}

	public java.math.BigDecimal getHasRateOfPayment() {
		return this.__has_rate_of_payment;
	}

	public void setHasRateOfPayment( java.math.BigDecimal value ) {
		this.__has_rate_of_payment = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	public java.util.Date getHasFormalContractTime() {
		return this.__has_formal_contract_time;
	}

	public void setHasFormalContractTime( java.util.Date value ) {
		this.__has_formal_contract_time = value;
	}

	public java.util.Date getHasOutQuotationTime() {
		return this.__has_out_quotation_time;
	}

	public void setHasOutQuotationTime( java.util.Date value ) {
		this.__has_out_quotation_time = value;
	}

	public java.util.Date getHasOrderReleaseTime() {
		return this.__has_order_release_time;
	}

	public void setHasOrderReleaseTime( java.util.Date value ) {
		this.__has_order_release_time = value;
	}

	public java.util.Date getHasSplitPriceTime() {
		return this.__has_split_price_time;
	}

	public void setHasSplitPriceTime( java.util.Date value ) {
		this.__has_split_price_time = value;
	}

	public java.lang.Integer getBidType() {
		return this.__bid_type;
	}

	public void setBidType( java.lang.Integer value ) {
		this.__bid_type = value;
	}
	public java.lang.String getOutsource() {
		return this.__outsource;
	}

	public void setOutsource( java.lang.String value ) {
		this.__outsource = value;
	}

	public String getSecretary() {
		return this.__secretary;
	}

	public void setSecretary( String value ) {
		this.__secretary = value;
	}

	public java.lang.String getManager() {
		return this.__manager;
	}

	public void setManager( java.lang.String value ) {
		this.__manager = value;
	}

	public String getLeader() {
		return this.__leader;
	}

	public void setLeader( String value ) {
		this.__leader = value;
	}

	public String getChargePerson() {
		return this.__charge_person;
	}

	public void setChargePerson( String value ) {
		this.__charge_person = value;
	}

	public void cloneCopy(BaseMainProject __bean){
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
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setProjectEndTime(getProjectEndTime());
		__bean.setProjectType(getProjectType());
		__bean.setClientId(getClientId());
		__bean.setCustomerName(getCustomerName());
		__bean.setCustomerAddress(getCustomerAddress());
		__bean.setBidProject(getBidProject());
		__bean.setConstructionUnit(getConstructionUnit());
		__bean.setArchitecturalDesignUnits(getArchitecturalDesignUnits());
		__bean.setRateOfBidWinning(getRateOfBidWinning());
		__bean.setFollowUpDate(getFollowUpDate());
		__bean.setEquityedgeRemark(getEquityedgeRemark());
		__bean.setOrderSignUpTime(getOrderSignUpTime());
		__bean.setDesignServiceBook(getDesignServiceBook());
		__bean.setServiceSuggestBook(getServiceSuggestBook());
		__bean.setTotalMoney(getTotalMoney());
		__bean.setCoveredArea(getCoveredArea());
		__bean.setDesignArea(getDesignArea());
		__bean.setHasFormalContracts(getHasFormalContracts());
		__bean.setHasOutQuotations(getHasOutQuotations());
		__bean.setSpecialty(getSpecialty());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setHasSplitPrice(getHasSplitPrice());
		__bean.setHasOrderRelease(getHasOrderRelease());
		__bean.setHasDeposit(getHasDeposit());
		__bean.setHasRateOfPayment(getHasRateOfPayment());
		__bean.setParentId(getParentId());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setHasFormalContractTime(getHasFormalContractTime());
		__bean.setHasOutQuotationTime(getHasOutQuotationTime());
		__bean.setHasOrderReleaseTime(getHasOrderReleaseTime());
		__bean.setHasSplitPriceTime(getHasSplitPriceTime());
		__bean.setBidType(getBidType());
		__bean.setOutsource(getOutsource());
		__bean.setSecretary(getSecretary());
		__bean.setManager(getManager());
		__bean.setLeader(getLeader());
		__bean.setChargePerson(getChargePerson());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
//		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
//		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		String s1 = replaceSpecialStrTwo(BaseHelpUtils.getString(getProjectName()));
		sb.append(getProjectName() == null ? "" : s1);
		sb.append(",");
//		sb.append(getProjectEnglishName() == null ? "" : getProjectEnglishName());
//		sb.append(",");
//		String strProjectStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_30", String.valueOf(getProjectStatus()));
//		sb.append(strProjectStatus == null ? "" : strProjectStatus);
//		sb.append(",");
//		sb.append(getDesignStatus() == null ? "" : getDesignStatus());
//		sb.append(",");
//		sb.append(getSignCompany() == null ? "" : getSignCompany());
//		sb.append(",");
//		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
//		sb.append(",");
//		sb.append(getProjectOriginationRemark() == null ? "" : getProjectOriginationRemark());
//		sb.append(",");
//		sb.append(getDesignCooperationName() == null ? "" : getDesignCooperationName());
//		sb.append(",");
//		sb.append(getDesignCooperationEnglishName() == null ? "" : getDesignCooperationEnglishName());
//		sb.append(",");
//		sb.append(getDesignTeam() == null ? "" : getDesignTeam());
//		sb.append(",");
//		sb.append(getIsHighRiseBuilding() == null ? "" : getIsHighRiseBuilding());
//		sb.append(",");
//		sb.append(getInfoRegisterTime() == null ? "" : sdf.format(getInfoRegisterTime()));
//		sb.append(",");
//		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
//		sb.append(",");
//		sb.append(getHasContract() == null ? "" : getHasContract());
//		sb.append(",");
//		sb.append(getProjectBaseOn() == null ? "" : getProjectBaseOn());
//		sb.append(",");
//		sb.append(getInfoCode() == null ? "" : getInfoCode());
//		sb.append(",");
//		sb.append(getProjectModel() == null ? "" : getProjectModel());
//		sb.append(",");
//		sb.append(getDesignQualification() == null ? "" : getDesignQualification());
//		sb.append(",");
//		String strBusinessType =  delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(getBusinessType() == null ? "" : getBusinessType().replaceAll(",", "，"));
		sb.append(",");
		String strProjectBaseOn = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(getProjectBaseOn()));
		sb.append(strProjectBaseOn == null ? "" : strProjectBaseOn);
		sb.append(",");
		String strBidType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_128", String.valueOf(getBidType()));
		if(getProjectBaseOn()!=null&& getProjectBaseOn()==2|| getProjectBaseOn()==3)
			sb.append("");
		else
		sb.append(strBidType == null ? "" : strBidType);
		sb.append(",");
		String strDesignTeam = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDesignTeam()));
		sb.append(strDesignTeam == null ? "" : strDesignTeam);
		sb.append(",");
//		sb.append(getFireResistanceRating() == null ? "" : getFireResistanceRating());
//		sb.append(",");
//		sb.append(getEstimateTheDesignAreas() == null ? "" : getEstimateTheDesignAreas());
//		sb.append(",");
//		sb.append(getProjectTotalInvestment() == null ? "" : getProjectTotalInvestment());
//		sb.append(",");
//		sb.append(getActualDesignAreas() == null ? "" : getActualDesignAreas());
//		sb.append(",");
//		sb.append(getTotalBuildingAreas() == null ? "" : getTotalBuildingAreas());
//		sb.append(",");
//		sb.append(getBuildingHeight() == null ? "" : getBuildingHeight());
//		sb.append(",");
//		sb.append(getBuildingFloors() == null ? "" : getBuildingFloors());
//		sb.append(",");
//		sb.append(getDecorateMoneyControl() == null ? "" : getDecorateMoneyControl());
//		sb.append(",");
//		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
//		sb.append(strProjectLevel == null ? "" : strProjectLevel);
//		sb.append(",");
//		sb.append(getProvince() == null ? "" : getProvince());
//		sb.append(",");
//		sb.append(getCity() == null ? "" : getCity());
//		sb.append(",");
//		sb.append(getDetailAddress() == null ? "" : getDetailAddress());
//		sb.append(",");
//		sb.append(getProjectEndTime() == null ? "" : sdf.format(getProjectEndTime()));
//		sb.append(",");
//		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getProjectType()));
//		sb.append(strProjectType == null ? "" : strProjectType);
//		sb.append(",");
//		sb.append(getCustomerName() == null ? "" : getCustomerName());
//		sb.append(",");
//		sb.append(getCustomerAddress() == null ? "" : getCustomerAddress());
//		sb.append(",");
//		sb.append(getBidProject() == null ? "" : getBidProject());
//		sb.append(",");
//		sb.append(getConstructionUnit() == null ? "" : getConstructionUnit());
//		sb.append(",");
//		sb.append(getArchitecturalDesignUnits() == null ? "" : getArchitecturalDesignUnits());
//		sb.append(",");
//		sb.append(getRateOfBidWinning() == null ? "" : getRateOfBidWinning());
//		sb.append(",");
//		sb.append(getFollowUpDate() == null ? "" : sdf.format(getFollowUpDate()));
//		sb.append(",");
//		sb.append(getEquityedgeRemark() == null ? "" : getEquityedgeRemark());
//		sb.append(",");
//		sb.append(getOrderSignUpTime() == null ? "" : sdf.format(getOrderSignUpTime()));
//		sb.append(",");
//		sb.append(getDesignServiceBook() == null ? "" : getDesignServiceBook());
//		sb.append(",");
//		sb.append(getServiceSuggestBook() == null ? "" : getServiceSuggestBook());
//		sb.append(",");
//		sb.append(getTotalMoney() == null ? "" : getTotalMoney());
//		sb.append(",");
//		sb.append(getCoveredArea() == null ? "" : getCoveredArea());
//		sb.append(",");
//		sb.append(getDesignArea() == null ? "" : getDesignArea());
//		sb.append(",");
//		sb.append(getHasFormalContracts() == null ? "" : getHasFormalContracts());
//		sb.append(",");
//		sb.append(getHasOutQuotations() == null ? "" : getHasOutQuotations());
//		sb.append(",");
//		sb.append(getSpecialty() == null ? "" : getSpecialty());
//		sb.append(",");
//		sb.append(getProjectSalesTeam() == null ? "" : getProjectSalesTeam());
//		sb.append(",");
//		sb.append(getHasSplitPrice() == null ? "" : getHasSplitPrice());
//		sb.append(",");
//		sb.append(getHasOrderRelease() == null ? "" : getHasOrderRelease());
//		sb.append(",");
//		sb.append(getHasDeposit() == null ? "" : getHasDeposit());
//		sb.append(",");
//		sb.append(getHasRateOfPayment() == null ? "" : getHasRateOfPayment());
//		sb.append(",");
//		sb.append(getParentId() == null ? "" : getParentId());
//		sb.append(",");
		sb.append(getSecretary() == null ? "" : getSecretary());
		sb.append(",");
		sb.append(getLeader() == null ? "" : getLeader());
		sb.append(",");
		sb.append(getChargePerson() == null ? "" : getChargePerson());
		sb.append(",");
		sb.append(getManager() == null ? "" : getManager());
		return sb.toString();
	}

	public static String replaceSpecialStr(String str) {
		String repl = "";
		if (str != null) {
			Pattern p = Pattern.compile("[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， ·、？]");
			Matcher m = p.matcher(str);
			repl = m.replaceAll("");
		}
		return repl.replace("[", "").replace("]", "").replace("=", "").replace("-","").trim();
	}

	public static String replaceSpecialStrTwo(String str) {
		String repl = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			repl = m.replaceAll("");
		}
		return repl.replace("[", "").replace("]", "").replace("=", "").replace("-","").replace(",","，").trim();
	}

	@Override
	public int compareTo(BaseMainProject o) {
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
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__project_end_time);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_address);
		hash = 97 * hash + Objects.hashCode(this.__bid_project);
		hash = 97 * hash + Objects.hashCode(this.__construction_unit);
		hash = 97 * hash + Objects.hashCode(this.__architectural_design_units);
		hash = 97 * hash + Objects.hashCode(this.__rate_of_bid_winning);
		hash = 97 * hash + Objects.hashCode(this.__follow_up_date);
		hash = 97 * hash + Objects.hashCode(this.__equityedge_remark);
		hash = 97 * hash + Objects.hashCode(this.__order_sign_up_time);
		hash = 97 * hash + Objects.hashCode(this.__design_service_book);
		hash = 97 * hash + Objects.hashCode(this.__service_suggest_book);
		hash = 97 * hash + Objects.hashCode(this.__total_money);
		hash = 97 * hash + Objects.hashCode(this.__covered_area);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__has_formal_contracts);
		hash = 97 * hash + Objects.hashCode(this.__has_out_quotations);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__has_split_price);
		hash = 97 * hash + Objects.hashCode(this.__has_order_release);
		hash = 97 * hash + Objects.hashCode(this.__has_deposit);
		hash = 97 * hash + Objects.hashCode(this.__has_rate_of_payment);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__has_formal_contract_time);
		hash = 97 * hash + Objects.hashCode(this.__has_out_quotation_time);
		hash = 97 * hash + Objects.hashCode(this.__has_order_release_time);
		hash = 97 * hash + Objects.hashCode(this.__has_split_price_time);
		hash = 97 * hash + Objects.hashCode(this.__bid_type);
		hash = 97 * hash + Objects.hashCode(this.__outsource);
		hash = 97 * hash + Objects.hashCode(this.__secretary);
		hash = 97 * hash + Objects.hashCode(this.__manager);
		hash = 97 * hash + Objects.hashCode(this.__leader);
		hash = 97 * hash + Objects.hashCode(this.__charge_person);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProject o = (BaseMainProject)obj;
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
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__project_end_time, o.getProjectEndTime())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__customer_address, o.getCustomerAddress())) return false;
		if(!Objects.equals(this.__bid_project, o.getBidProject())) return false;
		if(!Objects.equals(this.__construction_unit, o.getConstructionUnit())) return false;
		if(!Objects.equals(this.__architectural_design_units, o.getArchitecturalDesignUnits())) return false;
		if(!Objects.equals(this.__rate_of_bid_winning, o.getRateOfBidWinning())) return false;
		if(!Objects.equals(this.__follow_up_date, o.getFollowUpDate())) return false;
		if(!Objects.equals(this.__equityedge_remark, o.getEquityedgeRemark())) return false;
		if(!Objects.equals(this.__order_sign_up_time, o.getOrderSignUpTime())) return false;
		if(!Objects.equals(this.__design_service_book, o.getDesignServiceBook())) return false;
		if(!Objects.equals(this.__service_suggest_book, o.getServiceSuggestBook())) return false;
		if(!Objects.equals(this.__total_money, o.getTotalMoney())) return false;
		if(!Objects.equals(this.__covered_area, o.getCoveredArea())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__has_formal_contracts, o.getHasFormalContracts())) return false;
		if(!Objects.equals(this.__has_out_quotations, o.getHasOutQuotations())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__has_split_price, o.getHasSplitPrice())) return false;
		if(!Objects.equals(this.__has_order_release, o.getHasOrderRelease())) return false;
		if(!Objects.equals(this.__has_deposit, o.getHasDeposit())) return false;
		if(!Objects.equals(this.__has_rate_of_payment, o.getHasRateOfPayment())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__has_formal_contract_time, o.getHasFormalContractTime())) return false;
		if(!Objects.equals(this.__has_out_quotation_time, o.getHasOutQuotationTime())) return false;
		if(!Objects.equals(this.__has_order_release_time, o.getHasOrderReleaseTime())) return false;
		if(!Objects.equals(this.__has_split_price_time, o.getHasSplitPriceTime())) return false;
		if(!Objects.equals(this.__bid_type, o.getBidType())) return false;
		if(!Objects.equals(this.__outsource, o.getOutsource())) return false;
		if(!Objects.equals(this.__secretary, o.getSecretary())) return false;
		if(!Objects.equals(this.__manager, o.getManager())) return false;
		if(!Objects.equals(this.__leader, o.getLeader())) return false;
		if(!Objects.equals(this.__charge_person, o.getChargePerson())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

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
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getProjectEndTime() != null) sb.append(__wrapDate(count++, "projectEndTime", getProjectEndTime()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCustomerAddress() != null) sb.append(__wrapString(count++, "customerAddress", getCustomerAddress()));
		if(getBidProject() != null) sb.append(__wrapString(count++, "bidProject", getBidProject()));
		if(getConstructionUnit() != null) sb.append(__wrapString(count++, "constructionUnit", getConstructionUnit()));
		if(getArchitecturalDesignUnits() != null) sb.append(__wrapString(count++, "architecturalDesignUnits", getArchitecturalDesignUnits()));
		if(getRateOfBidWinning() != null) sb.append(__wrapString(count++, "rateOfBidWinning", getRateOfBidWinning()));
		if(getFollowUpDate() != null) sb.append(__wrapDate(count++, "followUpDate", getFollowUpDate()));
		if(getEquityedgeRemark() != null) sb.append(__wrapString(count++, "equityedgeRemark", getEquityedgeRemark()));
		if(getOrderSignUpTime() != null) sb.append(__wrapDate(count++, "orderSignUpTime", getOrderSignUpTime()));
		if(getDesignServiceBook() != null) sb.append(__wrapString(count++, "designServiceBook", getDesignServiceBook()));
		if(getServiceSuggestBook() != null) sb.append(__wrapString(count++, "serviceSuggestBook", getServiceSuggestBook()));
		if(getTotalMoney() != null) sb.append(__wrapDecimal(count++, "totalMoney", getTotalMoney()));
		if(getCoveredArea() != null) sb.append(__wrapDecimal(count++, "coveredArea", getCoveredArea()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getHasFormalContracts() != null) sb.append(__wrapBoolean(count++, "hasFormalContracts", getHasFormalContracts()));
		if(getHasOutQuotations() != null) sb.append(__wrapBoolean(count++, "hasOutQuotations", getHasOutQuotations()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getHasSplitPrice() != null) sb.append(__wrapBoolean(count++, "hasSplitPrice", getHasSplitPrice()));
		if(getHasOrderRelease() != null) sb.append(__wrapBoolean(count++, "hasOrderRelease", getHasOrderRelease()));
		if(getHasDeposit() != null) sb.append(__wrapBoolean(count++, "hasDeposit", getHasDeposit()));
		if(getHasRateOfPayment() != null) sb.append(__wrapDecimal(count++, "hasRateOfPayment", getHasRateOfPayment()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(count++, "serialNumber", getSerialNumber()));
		if(getHasFormalContractTime() != null) sb.append(__wrapDate(count++, "hasFormalContractTime", getHasFormalContractTime()));
		if(getHasOutQuotationTime() != null) sb.append(__wrapDate(count++, "hasOutQuotationTime", getHasOutQuotationTime()));
		if(getHasOrderReleaseTime() != null) sb.append(__wrapDate(count++, "hasOrderReleaseTime", getHasOrderReleaseTime()));
		if(getHasSplitPriceTime() != null) sb.append(__wrapDate(count++, "hasSplitPriceTime", getHasSplitPriceTime()));
		if(getBidType() != null) sb.append(__wrapNumber(count++, "bidType", getBidType()));
		if(getOutsource() != null) sb.append(__wrapString(count++, "outsource", getOutsource()));
		if(getSecretary() != null) sb.append(__wrapString(count++, "secretary", getSecretary()));
		if(getManager() != null) sb.append(__wrapString(count++, "manager", getManager()));
		if(getLeader() != null) sb.append(__wrapString(count++, "leader", getLeader()));
		if(getChargePerson() != null) sb.append(__wrapString(count++, "chargePerson", getChargePerson()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getProjectEnglishName() != null) res.put("projectEnglishName", getProjectEnglishName());
		if(getProjectStatus() != null) res.put("projectStatus", getProjectStatus());
		if(getDesignStatus() != null) res.put("designStatus", getDesignStatus());
		if(getSignCompany() != null) res.put("signCompany", getSignCompany());
		if(getProjectOrigination() != null) res.put("projectOrigination", getProjectOrigination());
		if(getProjectOriginationRemark() != null) res.put("projectOriginationRemark", getProjectOriginationRemark());
		if(getDesignCooperationName() != null) res.put("designCooperationName", getDesignCooperationName());
		if(getDesignCooperationEnglishName() != null) res.put("designCooperationEnglishName", getDesignCooperationEnglishName());
		if(getProjectSalesTeam() != null) res.put("projectSalesTeam", getProjectSalesTeam());
		if(getDesignTeam() != null) res.put("designTeam", getDesignTeam());
		if(getIsHighRiseBuilding() != null) res.put("isHighRiseBuilding", getIsHighRiseBuilding());
		if(getInfoRegisterTime() != null) res.put("infoRegisterTime", getInfoRegisterTime());
		if(getProjectApprovalTime() != null) res.put("projectApprovalTime", getProjectApprovalTime());
		if(getHasContract() != null) res.put("hasContract", getHasContract());
		if(getProjectBaseOn() != null) res.put("projectBaseOn", getProjectBaseOn());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectModel() != null) res.put("projectModel", getProjectModel());
		if(getDesignQualification() != null) res.put("designQualification", getDesignQualification());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getFireResistanceRating() != null) res.put("fireResistanceRating", getFireResistanceRating());
		if(getEstimateTheDesignAreas() != null) res.put("estimateTheDesignAreas", getEstimateTheDesignAreas());
		if(getProjectTotalInvestment() != null) res.put("projectTotalInvestment", getProjectTotalInvestment());
		if(getActualDesignAreas() != null) res.put("actualDesignAreas", getActualDesignAreas());
		if(getTotalBuildingAreas() != null) res.put("totalBuildingAreas", getTotalBuildingAreas());
		if(getBuildingHeight() != null) res.put("buildingHeight", getBuildingHeight());
		if(getBuildingFloors() != null) res.put("buildingFloors", getBuildingFloors());
		if(getDecorateMoneyControl() != null) res.put("decorateMoneyControl", getDecorateMoneyControl());
		if(getProjectLevel() != null) res.put("projectLevel", getProjectLevel());
		if(getProvince() != null) res.put("province", getProvince());
		if(getCity() != null) res.put("city", getCity());
		if(getDetailAddress() != null) res.put("detailAddress", getDetailAddress());
		if(getProjectEndTime() != null) res.put("projectEndTime", getProjectEndTime());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getCustomerAddress() != null) res.put("customerAddress", getCustomerAddress());
		if(getBidProject() != null) res.put("bidProject", getBidProject());
		if(getConstructionUnit() != null) res.put("constructionUnit", getConstructionUnit());
		if(getArchitecturalDesignUnits() != null) res.put("architecturalDesignUnits", getArchitecturalDesignUnits());
		if(getRateOfBidWinning() != null) res.put("rateOfBidWinning", getRateOfBidWinning());
		if(getFollowUpDate() != null) res.put("followUpDate", getFollowUpDate());
		if(getEquityedgeRemark() != null) res.put("equityedgeRemark", getEquityedgeRemark());
		if(getOrderSignUpTime() != null) res.put("orderSignUpTime", getOrderSignUpTime());
		if(getDesignServiceBook() != null) res.put("designServiceBook", getDesignServiceBook());
		if(getServiceSuggestBook() != null) res.put("serviceSuggestBook", getServiceSuggestBook());
		if(getTotalMoney() != null) res.put("totalMoney", getTotalMoney());
		if(getCoveredArea() != null) res.put("coveredArea", getCoveredArea());
		if(getDesignArea() != null) res.put("designArea", getDesignArea());
		if(getHasFormalContracts() != null) res.put("hasFormalContracts", getHasFormalContracts());
		if(getHasOutQuotations() != null) res.put("hasOutQuotations", getHasOutQuotations());
		if(getHasSplitPrice() != null) res.put("hasSplitPrice", getHasSplitPrice());
		if(getHasOrderRelease() != null) res.put("hasOrderRelease", getHasOrderRelease());
		if(getHasDeposit() != null) res.put("hasDeposit", getHasDeposit());
		if(getHasRateOfPayment() != null) res.put("hasRateOfPayment", getHasRateOfPayment());
		if(getBidType() != null) res.put("bidType", getBidType());
		if(getSecretary() != null) res.put("secretary", getSecretary());
		if(getManager() != null) res.put("manager", getManager());
		if(getLeader() != null) res.put("leader", getLeader());
		if(getChargePerson() != null) res.put("chargePerson", getChargePerson());
		return res;
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
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("projectEndTime")) != null) setProjectEndTime(__getDate(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("clientId")) != null) setClientId(__getInt(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("customerAddress")) != null) setCustomerAddress(__getString(val));
		if((val = values.get("bidProject")) != null) setBidProject(__getString(val));
		if((val = values.get("constructionUnit")) != null) setConstructionUnit(__getString(val));
		if((val = values.get("architecturalDesignUnits")) != null) setArchitecturalDesignUnits(__getString(val));
		if((val = values.get("rateOfBidWinning")) != null) setRateOfBidWinning(__getString(val));
		if((val = values.get("followUpDate")) != null) setFollowUpDate(__getDate(val));
		if((val = values.get("equityedgeRemark")) != null) setEquityedgeRemark(__getString(val));
		if((val = values.get("orderSignUpTime")) != null) setOrderSignUpTime(__getDate(val));
		if((val = values.get("designServiceBook")) != null) setDesignServiceBook(__getString(val));
		if((val = values.get("serviceSuggestBook")) != null) setServiceSuggestBook(__getString(val));
		if((val = values.get("totalMoney")) != null) setTotalMoney(__getDecimal(val));
		if((val = values.get("coveredArea")) != null) setCoveredArea(__getDecimal(val));
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));
		if((val = values.get("hasFormalContracts")) != null) setHasFormalContracts(__getBoolean(val));
		if((val = values.get("hasOutQuotations")) != null) setHasOutQuotations(__getBoolean(val));
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("hasSplitPrice")) != null) setHasSplitPrice(__getBoolean(val));
		if((val = values.get("hasOrderRelease")) != null) setHasOrderRelease(__getBoolean(val));
		if((val = values.get("hasDeposit")) != null) setHasDeposit(__getBoolean(val));
		if((val = values.get("hasRateOfPayment")) != null) setHasRateOfPayment(__getDecimal(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val));
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val));
		if((val = values.get("hasFormalContractTime")) != null) setHasFormalContractTime(__getDate(val));
		if((val = values.get("hasOutQuotationTime")) != null) setHasOutQuotationTime(__getDate(val));
		if((val = values.get("hasOrderReleaseTime")) != null) setHasOrderReleaseTime(__getDate(val));
		if((val = values.get("hasSplitPriceTime")) != null) setHasSplitPriceTime(__getDate(val));
		if((val = values.get("bidType")) != null) setBidType(__getInt(val));
		if((val = values.get("outsource")) != null) setOutsource(__getString(val));
		if((val = values.get("secretary")) != null) setSecretary(__getString(val));
		if((val = values.get("manager")) != null) setManager(__getString(val));
		if((val = values.get("leader")) != null) setLeader(__getString(val));
		if((val = values.get("chargePerson")) != null) setChargePerson(__getString(val));
	}

	protected Integer  __main_project_id ;
	protected String  __project_code ;
	protected String  __project_name ;
	protected String  __project_english_name ;
	protected String  __project_status ;
	protected String  __design_status ;
	protected Integer  __sign_company ;
	protected String  __project_origination ;
	protected String  __project_origination_remark ;
	protected String  __design_cooperation_name ;
	protected String  __design_cooperation_english_name ;
	protected Integer  __design_team ;
	protected Boolean  __is_high_rise_building ;
	protected java.util.Date  __info_register_time ;
	protected java.util.Date  __project_approval_time ;
	protected Boolean  __has_contract ;
	protected Integer  __project_base_on ;
	protected String  __info_code ;
	protected String  __project_model ;
	protected String  __design_qualification ;
	protected String  __business_type ;
	protected String  __fire_resistance_rating ;
	protected String  __estimate_the_design_areas ;
	protected String  __project_total_investment ;
	protected String  __actual_design_areas ;
	protected String  __total_building_areas ;
	protected String  __building_height ;
	protected String  __building_floors ;
	protected String  __decorate_money_control ;
	protected Integer  __project_level ;
	protected String  __province ;
	protected String  __city ;
	protected String  __detail_address ;
	protected java.util.Date  __project_end_time ;
	protected String  __project_type ;
	protected String  __customer_name ;
	protected String  __customer_address ;
	protected String  __bid_project ;
	protected String  __construction_unit ;
	protected String  __architectural_design_units ;
	protected String  __rate_of_bid_winning ;
	protected java.util.Date  __follow_up_date ;
	protected String  __equityedge_remark ;
	protected java.util.Date  __order_sign_up_time ;
	protected String  __design_service_book ;
	protected String  __service_suggest_book ;
	protected java.math.BigDecimal  __total_money ;
	protected java.math.BigDecimal  __covered_area ;
	protected java.math.BigDecimal  __design_area ;
	protected Boolean  __has_formal_contracts ;
	protected Boolean  __has_out_quotations ;
	protected java.lang.String  __specialty ;
	protected java.lang.String  __project_sales_team ;
	protected Boolean  __has_split_price ;
	protected Boolean  __has_order_release ;
	protected Boolean  __has_deposit ;
	protected java.math.BigDecimal  __has_rate_of_payment ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __serial_number ;
	protected java.util.Date  __has_formal_contract_time ;
	protected java.util.Date  __has_out_quotation_time ;
	protected java.util.Date  __has_order_release_time ;
	protected java.util.Date  __has_split_price_time ;
	protected java.lang.Integer  __bid_type ;
	protected java.lang.String  __outsource ;
	protected java.lang.Integer  __client_id ;
	protected String  __secretary ;
	protected java.lang.String  __manager ;
	protected String  __leader ;
	protected String  __charge_person ;
}
