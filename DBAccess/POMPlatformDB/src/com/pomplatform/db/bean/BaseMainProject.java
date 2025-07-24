package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
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
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_PROJECT_END_TIME = "project_end_time" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_CUSTOMER_ADDRESS = "customer_address" ;
	public final static java.lang.String CS_BID_PROJECT = "bid_project" ;
	public final static java.lang.String CS_CONSTRUCTION_UNIT = "construction_unit" ;
	public final static java.lang.String CS_ARCHITECTURAL_DESIGN_UNITS = "architectural_design_units" ;
	public final static java.lang.String CS_RATE_OF_BID_WINNING = "rate_of_bid_winning" ;
	public final static java.lang.String CS_FOLLOW_UP_DATE = "follow_up_date" ;
	public final static java.lang.String CS_EQUITYEDGE_REMARK = "equityedge_remark" ;
	public final static java.lang.String CS_ORDER_SIGN_UP_TIME = "order_sign_up_time" ;
	public final static java.lang.String CS_DESIGN_SERVICE_BOOK = "design_service_book" ;
	public final static java.lang.String CS_SERVICE_SUGGEST_BOOK = "service_suggest_book" ;
	public final static java.lang.String CS_TOTAL_MONEY = "total_money" ;
	public final static java.lang.String CS_COVERED_AREA = "covered_area" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_HAS_FORMAL_CONTRACTS = "has_formal_contracts" ;
	public final static java.lang.String CS_HAS_OUT_QUOTATIONS = "has_out_quotations" ;
	public final static java.lang.String CS_SPECIALTY = "specialty" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_HAS_SPLIT_PRICE = "has_split_price" ;
	public final static java.lang.String CS_HAS_ORDER_RELEASE = "has_order_release" ;
	public final static java.lang.String CS_HAS_DEPOSIT = "has_deposit" ;
	public final static java.lang.String CS_HAS_RATE_OF_PAYMENT = "has_rate_of_payment" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_HAS_FORMAL_CONTRACT_TIME = "has_formal_contract_time" ;
	public final static java.lang.String CS_HAS_OUT_QUOTATION_TIME = "has_out_quotation_time" ;
	public final static java.lang.String CS_HAS_ORDER_RELEASE_TIME = "has_order_release_time" ;
	public final static java.lang.String CS_HAS_SPLIT_PRICE_TIME = "has_split_price_time" ;
	public final static java.lang.String CS_BID_TYPE = "bid_type" ;
	public final static java.lang.String CS_BID_DATE = "bid_date" ;
	public final static java.lang.String CS_BID_CLASS_TYPE = "bid_class_type" ;
	public final static java.lang.String CS_BID_UNIT_NUM = "bid_unit_num" ;
	public final static java.lang.String CS_OUR_ORDER = "our_order" ;
	public final static java.lang.String CS_BIG_PAY_AMOUNT = "big_pay_amount" ;
	public final static java.lang.String CS_BIG_IS_ACHIEVE_AMOUNT = "big_is_achieve_amount" ;
	public final static java.lang.String CS_BIG_ADVANCE_AMOUNT = "big_advance_amount" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_CUSTOMER_CONTACT_ID = "customer_contact_id" ;
	public final static java.lang.String CS_ARCHITECTURAL_DESIGN_UNIT_ID = "architectural_design_unit_id" ;
	public final static java.lang.String CS_ARCHITECTURAL_DESIGN_UNIT_CONTACT_ID = "architectural_design_unit_contact_id" ;
	public final static java.lang.String CS_REGION = "region" ;
	public final static java.lang.String CS_COMPARISON_FORM = "comparison_form" ;
	public final static java.lang.String CS_IS_ORIGINAL = "is_original" ;
	public final static java.lang.String CS_IS_SUB_PROJECT = "is_sub_project" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;
	public final static java.lang.String CS_IS_PUBLICLY_BIDDING = "is_publicly_bidding" ;
	public final static java.lang.String CS_HAVE_AGENTS = "have_agents" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_OWNER_TYPE_ID = "owner_type_id" ;
	public final static java.lang.String CS_ESTIMATE_PRICE = "estimate_price" ;
	public final static java.lang.String CS_PROJECT_PHASE = "project_phase" ;
	public final static java.lang.String CS_PROJECT_ATTRIBUTE = "project_attribute" ;
	public final static java.lang.String CS_PROJECT_NAME_ONE = "project_name_one" ;
	public final static java.lang.String CS_WINNING_TIME = "winning_time" ;
	public final static java.lang.String CS_PROJECT_OUTPUT_VALUE = "project_output_value" ;
	public final static java.lang.String CS_MAIN_PROJECT_STAGE_ID = "main_project_stage_id" ;
	public final static java.lang.String CS_IS_MODIFY_PROJECT = "is_modify_project" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编号,项目名称,项目英文名称,项目状态,设计状态,拟签约公司,项目来源渠道,项目来源说明,设计合作单位,设计合作单位英文名称,主办设计团队,是否高层建筑,信息登记时间,正式立项时间,是否有合同,立项依据0未知、  1投标立项、 2合同立项、  3委托函立项,信息编号,立项模式,设计资质章,业务类别,耐火等级,设计预估面积,项目总投资额,实际设计面积,建筑总面积,建筑高度,建筑楼层,装修造价控制,项目等级,省份,城市,详细地址,项目完成时间,项目类别,客户名称,客户地址,投标项目,建设单位,建筑设计单位,百分比,跟进日期,说明,预计签约时间,设计服务书,服务建议书,报价总金额,建筑面积,设计面积,是否有正式合同,是否有报价单,合同参与专业,项目营销团队,是否有拆分价 true 有，反之,订单下达状态,是否收取 定金,回款率,父级编码,序列号(记录第几个补充协议),拥有正式合同的时间,有报价单的时间,订单下达的时间,有拆分价的时间,对应于字典表128),投标日期,对应于字典表129),投标单位总数,我方排名,落标补偿金,是否收到落标补偿,甲方补偿金额,客户id,客户联系人,客户联系人电话,报备人,联系人id,建筑设计单位编码,建筑设计单位联系人,区域,比选形式,是否原创,是否建筑院分包项目,合同状态,是否公开挂网招标,是否有代理商,公司编码（默认为JA公司编码）,公司编码（默认为JA公司编码）,项目完成百分比,业主所属行业类型,预估价格,项目进行阶段(1新建 2策划 3运行 4完成 5暂停),项目属性 1普通设计项目 2品管项目,报备申请时项目名称,中标时间,项目产值,项目立项阶段id,是否修改项目,职位,备注,流程状态  0无意义   1进行中   2 已完成   3已驳回";

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

	public java.util.Date getProjectEndTime() {
		return this.__project_end_time;
	}

	public void setProjectEndTime( java.util.Date value ) {
		this.__project_end_time = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
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

	public java.lang.String getBidProject() {
		return this.__bid_project;
	}

	public void setBidProject( java.lang.String value ) {
		this.__bid_project = value;
	}

	public java.lang.String getConstructionUnit() {
		return this.__construction_unit;
	}

	public void setConstructionUnit( java.lang.String value ) {
		this.__construction_unit = value;
	}

	public java.lang.String getArchitecturalDesignUnits() {
		return this.__architectural_design_units;
	}

	public void setArchitecturalDesignUnits( java.lang.String value ) {
		this.__architectural_design_units = value;
	}

	public java.lang.String getRateOfBidWinning() {
		return this.__rate_of_bid_winning;
	}

	public void setRateOfBidWinning( java.lang.String value ) {
		this.__rate_of_bid_winning = value;
	}

	public java.util.Date getFollowUpDate() {
		return this.__follow_up_date;
	}

	public void setFollowUpDate( java.util.Date value ) {
		this.__follow_up_date = value;
	}

	public java.lang.String getEquityedgeRemark() {
		return this.__equityedge_remark;
	}

	public void setEquityedgeRemark( java.lang.String value ) {
		this.__equityedge_remark = value;
	}

	public java.util.Date getOrderSignUpTime() {
		return this.__order_sign_up_time;
	}

	public void setOrderSignUpTime( java.util.Date value ) {
		this.__order_sign_up_time = value;
	}

	public java.lang.String getDesignServiceBook() {
		return this.__design_service_book;
	}

	public void setDesignServiceBook( java.lang.String value ) {
		this.__design_service_book = value;
	}

	public java.lang.String getServiceSuggestBook() {
		return this.__service_suggest_book;
	}

	public void setServiceSuggestBook( java.lang.String value ) {
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

	public java.lang.Boolean getHasFormalContracts() {
		return this.__has_formal_contracts;
	}

	public void setHasFormalContracts( java.lang.Boolean value ) {
		this.__has_formal_contracts = value;
	}

	public java.lang.Boolean getHasOutQuotations() {
		return this.__has_out_quotations;
	}

	public void setHasOutQuotations( java.lang.Boolean value ) {
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

	public void setHasSplitPrice( java.lang.Boolean value ) {
		this.__has_split_price = value;
	}

	public java.lang.Boolean getHasOrderRelease() {
		return this.__has_order_release;
	}

	public void setHasOrderRelease( java.lang.Boolean value ) {
		this.__has_order_release = value;
	}

	public java.lang.Boolean getHasDeposit() {
		return this.__has_deposit;
	}

	public void setHasDeposit( java.lang.Boolean value ) {
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

	public java.util.Date getBidDate() {
		return this.__bid_date;
	}

	public void setBidDate( java.util.Date value ) {
		this.__bid_date = value;
	}

	public java.lang.Integer getBidClassType() {
		return this.__bid_class_type;
	}

	public void setBidClassType( java.lang.Integer value ) {
		this.__bid_class_type = value;
	}

	public java.lang.Integer getBidUnitNum() {
		return this.__bid_unit_num;
	}

	public void setBidUnitNum( java.lang.Integer value ) {
		this.__bid_unit_num = value;
	}

	public java.lang.String getOurOrder() {
		return this.__our_order;
	}

	public void setOurOrder( java.lang.String value ) {
		this.__our_order = value;
	}

	public java.math.BigDecimal getBigPayAmount() {
		return this.__big_pay_amount;
	}

	public void setBigPayAmount( java.math.BigDecimal value ) {
		this.__big_pay_amount = value;
	}

	public java.lang.Boolean getBigIsAchieveAmount() {
		return this.__big_is_achieve_amount;
	}

	public void setBigIsAchieveAmount( java.lang.Boolean value ) {
		this.__big_is_achieve_amount = value;
	}

	public java.math.BigDecimal getBigAdvanceAmount() {
		return this.__big_advance_amount;
	}

	public void setBigAdvanceAmount( java.math.BigDecimal value ) {
		this.__big_advance_amount = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
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

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.Integer getCustomerContactId() {
		return this.__customer_contact_id;
	}

	public void setCustomerContactId( java.lang.Integer value ) {
		this.__customer_contact_id = value;
	}

	public java.lang.Integer getArchitecturalDesignUnitId() {
		return this.__architectural_design_unit_id;
	}

	public void setArchitecturalDesignUnitId( java.lang.Integer value ) {
		this.__architectural_design_unit_id = value;
	}

	public java.lang.Integer getArchitecturalDesignUnitContactId() {
		return this.__architectural_design_unit_contact_id;
	}

	public void setArchitecturalDesignUnitContactId( java.lang.Integer value ) {
		this.__architectural_design_unit_contact_id = value;
	}

	public java.lang.Integer getRegion() {
		return this.__region;
	}

	public void setRegion( java.lang.Integer value ) {
		this.__region = value;
	}

	public java.lang.Integer getComparisonForm() {
		return this.__comparison_form;
	}

	public void setComparisonForm( java.lang.Integer value ) {
		this.__comparison_form = value;
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

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
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

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
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

	public java.lang.Integer getProjectPhase() {
		return this.__project_phase;
	}

	public void setProjectPhase( java.lang.Integer value ) {
		this.__project_phase = value;
	}

	public java.lang.Integer getProjectAttribute() {
		return this.__project_attribute;
	}

	public void setProjectAttribute( java.lang.Integer value ) {
		this.__project_attribute = value;
	}

	public java.lang.String getProjectNameOne() {
		return this.__project_name_one;
	}

	public void setProjectNameOne( java.lang.String value ) {
		this.__project_name_one = value;
	}

	public java.util.Date getWinningTime() {
		return this.__winning_time;
	}

	public void setWinningTime( java.util.Date value ) {
		this.__winning_time = value;
	}

	public java.math.BigDecimal getProjectOutputValue() {
		return this.__project_output_value;
	}

	public void setProjectOutputValue( java.math.BigDecimal value ) {
		this.__project_output_value = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.lang.Boolean getIsModifyProject() {
		return this.__is_modify_project;
	}

	public void setIsModifyProject( java.lang.Boolean value ) {
		this.__is_modify_project = value;
	}

	public java.lang.String getGrade() {
		return this.__grade;
	}

	public void setGrade( java.lang.String value ) {
		this.__grade = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
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
		__bean.setBidDate(getBidDate());
		__bean.setBidClassType(getBidClassType());
		__bean.setBidUnitNum(getBidUnitNum());
		__bean.setOurOrder(getOurOrder());
		__bean.setBigPayAmount(getBigPayAmount());
		__bean.setBigIsAchieveAmount(getBigIsAchieveAmount());
		__bean.setBigAdvanceAmount(getBigAdvanceAmount());
		__bean.setClientId(getClientId());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setCustomerContactId(getCustomerContactId());
		__bean.setArchitecturalDesignUnitId(getArchitecturalDesignUnitId());
		__bean.setArchitecturalDesignUnitContactId(getArchitecturalDesignUnitContactId());
		__bean.setRegion(getRegion());
		__bean.setComparisonForm(getComparisonForm());
		__bean.setIsOriginal(getIsOriginal());
		__bean.setIsSubProject(getIsSubProject());
		__bean.setContractStatus(getContractStatus());
		__bean.setIsPubliclyBidding(getIsPubliclyBidding());
		__bean.setHaveAgents(getHaveAgents());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setPercent(getPercent());
		__bean.setOwnerTypeId(getOwnerTypeId());
		__bean.setEstimatePrice(getEstimatePrice());
		__bean.setProjectPhase(getProjectPhase());
		__bean.setProjectAttribute(getProjectAttribute());
		__bean.setProjectNameOne(getProjectNameOne());
		__bean.setWinningTime(getWinningTime());
		__bean.setProjectOutputValue(getProjectOutputValue());
		__bean.setMainProjectStageId(getMainProjectStageId());
		__bean.setIsModifyProject(getIsModifyProject());
		__bean.setGrade(getGrade());
		__bean.setRemark(getRemark());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectEnglishName() == null ? "" : getProjectEnglishName());
		sb.append(",");
		sb.append(getProjectStatus() == null ? "" : getProjectStatus());
		sb.append(",");
		sb.append(getDesignStatus() == null ? "" : getDesignStatus());
		sb.append(",");
		sb.append(getSignCompany() == null ? "" : getSignCompany());
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		sb.append(getProjectOriginationRemark() == null ? "" : getProjectOriginationRemark());
		sb.append(",");
		sb.append(getDesignCooperationName() == null ? "" : getDesignCooperationName());
		sb.append(",");
		sb.append(getDesignCooperationEnglishName() == null ? "" : getDesignCooperationEnglishName());
		sb.append(",");
		sb.append(getDesignTeam() == null ? "" : getDesignTeam());
		sb.append(",");
		sb.append(getIsHighRiseBuilding() == null ? "" : getIsHighRiseBuilding());
		sb.append(",");
		sb.append(getInfoRegisterTime() == null ? "" : sdf.format(getInfoRegisterTime()));
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getHasContract() == null ? "" : getHasContract());
		sb.append(",");
		sb.append(getProjectBaseOn() == null ? "" : getProjectBaseOn());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectModel() == null ? "" : getProjectModel());
		sb.append(",");
		sb.append(getDesignQualification() == null ? "" : getDesignQualification());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
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
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getDetailAddress() == null ? "" : getDetailAddress());
		sb.append(",");
		sb.append(getProjectEndTime() == null ? "" : sdf.format(getProjectEndTime()));
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getCustomerAddress() == null ? "" : getCustomerAddress());
		sb.append(",");
		sb.append(getBidProject() == null ? "" : getBidProject());
		sb.append(",");
		sb.append(getConstructionUnit() == null ? "" : getConstructionUnit());
		sb.append(",");
		sb.append(getArchitecturalDesignUnits() == null ? "" : getArchitecturalDesignUnits());
		sb.append(",");
		sb.append(getRateOfBidWinning() == null ? "" : getRateOfBidWinning());
		sb.append(",");
		sb.append(getFollowUpDate() == null ? "" : sdf.format(getFollowUpDate()));
		sb.append(",");
		sb.append(getEquityedgeRemark() == null ? "" : getEquityedgeRemark());
		sb.append(",");
		sb.append(getOrderSignUpTime() == null ? "" : sdf.format(getOrderSignUpTime()));
		sb.append(",");
		sb.append(getDesignServiceBook() == null ? "" : getDesignServiceBook());
		sb.append(",");
		sb.append(getServiceSuggestBook() == null ? "" : getServiceSuggestBook());
		sb.append(",");
		sb.append(getTotalMoney() == null ? "" : getTotalMoney());
		sb.append(",");
		sb.append(getCoveredArea() == null ? "" : getCoveredArea());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getHasFormalContracts() == null ? "" : getHasFormalContracts());
		sb.append(",");
		sb.append(getHasOutQuotations() == null ? "" : getHasOutQuotations());
		sb.append(",");
		sb.append(getSpecialty() == null ? "" : getSpecialty());
		sb.append(",");
		sb.append(getProjectSalesTeam() == null ? "" : getProjectSalesTeam());
		sb.append(",");
		sb.append(getHasSplitPrice() == null ? "" : getHasSplitPrice());
		sb.append(",");
		sb.append(getHasOrderRelease() == null ? "" : getHasOrderRelease());
		sb.append(",");
		sb.append(getHasDeposit() == null ? "" : getHasDeposit());
		sb.append(",");
		sb.append(getHasRateOfPayment() == null ? "" : getHasRateOfPayment());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getSerialNumber() == null ? "" : getSerialNumber());
		sb.append(",");
		sb.append(getHasFormalContractTime() == null ? "" : sdf.format(getHasFormalContractTime()));
		sb.append(",");
		sb.append(getHasOutQuotationTime() == null ? "" : sdf.format(getHasOutQuotationTime()));
		sb.append(",");
		sb.append(getHasOrderReleaseTime() == null ? "" : sdf.format(getHasOrderReleaseTime()));
		sb.append(",");
		sb.append(getHasSplitPriceTime() == null ? "" : sdf.format(getHasSplitPriceTime()));
		sb.append(",");
		sb.append(getBidType() == null ? "" : getBidType());
		sb.append(",");
		sb.append(getBidDate() == null ? "" : sdf.format(getBidDate()));
		sb.append(",");
		sb.append(getBidClassType() == null ? "" : getBidClassType());
		sb.append(",");
		sb.append(getBidUnitNum() == null ? "" : getBidUnitNum());
		sb.append(",");
		sb.append(getOurOrder() == null ? "" : getOurOrder());
		sb.append(",");
		sb.append(getBigPayAmount() == null ? "" : getBigPayAmount());
		sb.append(",");
		sb.append(getBigIsAchieveAmount() == null ? "" : getBigIsAchieveAmount());
		sb.append(",");
		sb.append(getBigAdvanceAmount() == null ? "" : getBigAdvanceAmount());
		sb.append(",");
		sb.append(getClientId() == null ? "" : getClientId());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		sb.append(getCustomerContactId() == null ? "" : getCustomerContactId());
		sb.append(",");
		sb.append(getArchitecturalDesignUnitId() == null ? "" : getArchitecturalDesignUnitId());
		sb.append(",");
		sb.append(getArchitecturalDesignUnitContactId() == null ? "" : getArchitecturalDesignUnitContactId());
		sb.append(",");
		sb.append(getRegion() == null ? "" : getRegion());
		sb.append(",");
		sb.append(getComparisonForm() == null ? "" : getComparisonForm());
		sb.append(",");
		sb.append(getIsOriginal() == null ? "" : getIsOriginal());
		sb.append(",");
		sb.append(getIsSubProject() == null ? "" : getIsSubProject());
		sb.append(",");
		sb.append(getContractStatus() == null ? "" : getContractStatus());
		sb.append(",");
		sb.append(getIsPubliclyBidding() == null ? "" : getIsPubliclyBidding());
		sb.append(",");
		sb.append(getHaveAgents() == null ? "" : getHaveAgents());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getOwnerTypeId() == null ? "" : getOwnerTypeId());
		sb.append(",");
		sb.append(getEstimatePrice() == null ? "" : getEstimatePrice());
		sb.append(",");
		sb.append(getProjectPhase() == null ? "" : getProjectPhase());
		sb.append(",");
		sb.append(getProjectAttribute() == null ? "" : getProjectAttribute());
		sb.append(",");
		sb.append(getProjectNameOne() == null ? "" : getProjectNameOne());
		sb.append(",");
		sb.append(getWinningTime() == null ? "" : sdf.format(getWinningTime()));
		sb.append(",");
		sb.append(getProjectOutputValue() == null ? "" : getProjectOutputValue());
		sb.append(",");
		sb.append(getMainProjectStageId() == null ? "" : getMainProjectStageId());
		sb.append(",");
		sb.append(getIsModifyProject() == null ? "" : getIsModifyProject());
		sb.append(",");
		sb.append(getGrade() == null ? "" : getGrade());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
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
		hash = 97 * hash + Objects.hashCode(this.__bid_date);
		hash = 97 * hash + Objects.hashCode(this.__bid_class_type);
		hash = 97 * hash + Objects.hashCode(this.__bid_unit_num);
		hash = 97 * hash + Objects.hashCode(this.__our_order);
		hash = 97 * hash + Objects.hashCode(this.__big_pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__big_is_achieve_amount);
		hash = 97 * hash + Objects.hashCode(this.__big_advance_amount);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__architectural_design_unit_id);
		hash = 97 * hash + Objects.hashCode(this.__architectural_design_unit_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__region);
		hash = 97 * hash + Objects.hashCode(this.__comparison_form);
		hash = 97 * hash + Objects.hashCode(this.__is_original);
		hash = 97 * hash + Objects.hashCode(this.__is_sub_project);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__is_publicly_bidding);
		hash = 97 * hash + Objects.hashCode(this.__have_agents);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__owner_type_id);
		hash = 97 * hash + Objects.hashCode(this.__estimate_price);
		hash = 97 * hash + Objects.hashCode(this.__project_phase);
		hash = 97 * hash + Objects.hashCode(this.__project_attribute);
		hash = 97 * hash + Objects.hashCode(this.__project_name_one);
		hash = 97 * hash + Objects.hashCode(this.__winning_time);
		hash = 97 * hash + Objects.hashCode(this.__project_output_value);
		hash = 97 * hash + Objects.hashCode(this.__main_project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__is_modify_project);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
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
		if(!Objects.equals(this.__bid_date, o.getBidDate())) return false;
		if(!Objects.equals(this.__bid_class_type, o.getBidClassType())) return false;
		if(!Objects.equals(this.__bid_unit_num, o.getBidUnitNum())) return false;
		if(!Objects.equals(this.__our_order, o.getOurOrder())) return false;
		if(!Objects.equals(this.__big_pay_amount, o.getBigPayAmount())) return false;
		if(!Objects.equals(this.__big_is_achieve_amount, o.getBigIsAchieveAmount())) return false;
		if(!Objects.equals(this.__big_advance_amount, o.getBigAdvanceAmount())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__customer_contact_id, o.getCustomerContactId())) return false;
		if(!Objects.equals(this.__architectural_design_unit_id, o.getArchitecturalDesignUnitId())) return false;
		if(!Objects.equals(this.__architectural_design_unit_contact_id, o.getArchitecturalDesignUnitContactId())) return false;
		if(!Objects.equals(this.__region, o.getRegion())) return false;
		if(!Objects.equals(this.__comparison_form, o.getComparisonForm())) return false;
		if(!Objects.equals(this.__is_original, o.getIsOriginal())) return false;
		if(!Objects.equals(this.__is_sub_project, o.getIsSubProject())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__is_publicly_bidding, o.getIsPubliclyBidding())) return false;
		if(!Objects.equals(this.__have_agents, o.getHaveAgents())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__owner_type_id, o.getOwnerTypeId())) return false;
		if(!Objects.equals(this.__estimate_price, o.getEstimatePrice())) return false;
		if(!Objects.equals(this.__project_phase, o.getProjectPhase())) return false;
		if(!Objects.equals(this.__project_attribute, o.getProjectAttribute())) return false;
		if(!Objects.equals(this.__project_name_one, o.getProjectNameOne())) return false;
		if(!Objects.equals(this.__winning_time, o.getWinningTime())) return false;
		if(!Objects.equals(this.__project_output_value, o.getProjectOutputValue())) return false;
		if(!Objects.equals(this.__main_project_stage_id, o.getMainProjectStageId())) return false;
		if(!Objects.equals(this.__is_modify_project, o.getIsModifyProject())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
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
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
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
		if(getBidDate() != null) sb.append(__wrapDate(count++, "bidDate", getBidDate()));
		if(getBidClassType() != null) sb.append(__wrapNumber(count++, "bidClassType", getBidClassType()));
		if(getBidUnitNum() != null) sb.append(__wrapNumber(count++, "bidUnitNum", getBidUnitNum()));
		if(getOurOrder() != null) sb.append(__wrapString(count++, "ourOrder", getOurOrder()));
		if(getBigPayAmount() != null) sb.append(__wrapDecimal(count++, "bigPayAmount", getBigPayAmount()));
		if(getBigIsAchieveAmount() != null) sb.append(__wrapBoolean(count++, "bigIsAchieveAmount", getBigIsAchieveAmount()));
		if(getBigAdvanceAmount() != null) sb.append(__wrapDecimal(count++, "bigAdvanceAmount", getBigAdvanceAmount()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getCustomerContactId() != null) sb.append(__wrapNumber(count++, "customerContactId", getCustomerContactId()));
		if(getArchitecturalDesignUnitId() != null) sb.append(__wrapNumber(count++, "architecturalDesignUnitId", getArchitecturalDesignUnitId()));
		if(getArchitecturalDesignUnitContactId() != null) sb.append(__wrapNumber(count++, "architecturalDesignUnitContactId", getArchitecturalDesignUnitContactId()));
		if(getRegion() != null) sb.append(__wrapNumber(count++, "region", getRegion()));
		if(getComparisonForm() != null) sb.append(__wrapNumber(count++, "comparisonForm", getComparisonForm()));
		if(getIsOriginal() != null) sb.append(__wrapBoolean(count++, "isOriginal", getIsOriginal()));
		if(getIsSubProject() != null) sb.append(__wrapBoolean(count++, "isSubProject", getIsSubProject()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getIsPubliclyBidding() != null) sb.append(__wrapBoolean(count++, "isPubliclyBidding", getIsPubliclyBidding()));
		if(getHaveAgents() != null) sb.append(__wrapBoolean(count++, "haveAgents", getHaveAgents()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getOwnerTypeId() != null) sb.append(__wrapNumber(count++, "ownerTypeId", getOwnerTypeId()));
		if(getEstimatePrice() != null) sb.append(__wrapDecimal(count++, "estimatePrice", getEstimatePrice()));
		if(getProjectPhase() != null) sb.append(__wrapNumber(count++, "projectPhase", getProjectPhase()));
		if(getProjectAttribute() != null) sb.append(__wrapNumber(count++, "projectAttribute", getProjectAttribute()));
		if(getProjectNameOne() != null) sb.append(__wrapString(count++, "projectNameOne", getProjectNameOne()));
		if(getWinningTime() != null) sb.append(__wrapDate(count++, "winningTime", getWinningTime()));
		if(getProjectOutputValue() != null) sb.append(__wrapDecimal(count++, "projectOutputValue", getProjectOutputValue()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(count++, "mainProjectStageId", getMainProjectStageId()));
		if(getIsModifyProject() != null) sb.append(__wrapBoolean(count++, "isModifyProject", getIsModifyProject()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
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
		if(getSpecialty() != null) res.put("specialty", getSpecialty());
		if(getProjectSalesTeam() != null) res.put("projectSalesTeam", getProjectSalesTeam());
		if(getHasSplitPrice() != null) res.put("hasSplitPrice", getHasSplitPrice());
		if(getHasOrderRelease() != null) res.put("hasOrderRelease", getHasOrderRelease());
		if(getHasDeposit() != null) res.put("hasDeposit", getHasDeposit());
		if(getHasRateOfPayment() != null) res.put("hasRateOfPayment", getHasRateOfPayment());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getSerialNumber() != null) res.put("serialNumber", getSerialNumber());
		if(getHasFormalContractTime() != null) res.put("hasFormalContractTime", getHasFormalContractTime());
		if(getHasOutQuotationTime() != null) res.put("hasOutQuotationTime", getHasOutQuotationTime());
		if(getHasOrderReleaseTime() != null) res.put("hasOrderReleaseTime", getHasOrderReleaseTime());
		if(getHasSplitPriceTime() != null) res.put("hasSplitPriceTime", getHasSplitPriceTime());
		if(getBidType() != null) res.put("bidType", getBidType());
		if(getBidDate() != null) res.put("bidDate", getBidDate());
		if(getBidClassType() != null) res.put("bidClassType", getBidClassType());
		if(getBidUnitNum() != null) res.put("bidUnitNum", getBidUnitNum());
		if(getOurOrder() != null) res.put("ourOrder", getOurOrder());
		if(getBigPayAmount() != null) res.put("bigPayAmount", getBigPayAmount());
		if(getBigIsAchieveAmount() != null) res.put("bigIsAchieveAmount", getBigIsAchieveAmount());
		if(getBigAdvanceAmount() != null) res.put("bigAdvanceAmount", getBigAdvanceAmount());
		if(getClientId() != null) res.put("clientId", getClientId());
		if(getContactName() != null) res.put("contactName", getContactName());
		if(getContactPhone() != null) res.put("contactPhone", getContactPhone());
		if(getApplyEmployeeId() != null) res.put("applyEmployeeId", getApplyEmployeeId());
		if(getCustomerContactId() != null) res.put("customerContactId", getCustomerContactId());
		if(getArchitecturalDesignUnitId() != null) res.put("architecturalDesignUnitId", getArchitecturalDesignUnitId());
		if(getArchitecturalDesignUnitContactId() != null) res.put("architecturalDesignUnitContactId", getArchitecturalDesignUnitContactId());
		if(getRegion() != null) res.put("region", getRegion());
		if(getComparisonForm() != null) res.put("comparisonForm", getComparisonForm());
		if(getIsOriginal() != null) res.put("isOriginal", getIsOriginal());
		if(getIsSubProject() != null) res.put("isSubProject", getIsSubProject());
		if(getContractStatus() != null) res.put("contractStatus", getContractStatus());
		if(getIsPubliclyBidding() != null) res.put("isPubliclyBidding", getIsPubliclyBidding());
		if(getHaveAgents() != null) res.put("haveAgents", getHaveAgents());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getCompanyNo() != null) res.put("companyNo", getCompanyNo());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getOwnerTypeId() != null) res.put("ownerTypeId", getOwnerTypeId());
		if(getEstimatePrice() != null) res.put("estimatePrice", getEstimatePrice());
		if(getProjectPhase() != null) res.put("projectPhase", getProjectPhase());
		if(getProjectAttribute() != null) res.put("projectAttribute", getProjectAttribute());
		if(getProjectNameOne() != null) res.put("projectNameOne", getProjectNameOne());
		if(getWinningTime() != null) res.put("winningTime", getWinningTime());
		if(getProjectOutputValue() != null) res.put("projectOutputValue", getProjectOutputValue());
		if(getMainProjectStageId() != null) res.put("mainProjectStageId", getMainProjectStageId());
		if(getIsModifyProject() != null) res.put("isModifyProject", getIsModifyProject());
		if(getGrade() != null) res.put("grade", getGrade());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
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
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
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
		if((val = values.get("bidDate")) != null) setBidDate(__getDate(val)); 
		if((val = values.get("bidClassType")) != null) setBidClassType(__getInt(val)); 
		if((val = values.get("bidUnitNum")) != null) setBidUnitNum(__getInt(val)); 
		if((val = values.get("ourOrder")) != null) setOurOrder(__getString(val));
		if((val = values.get("bigPayAmount")) != null) setBigPayAmount(__getDecimal(val));  
		if((val = values.get("bigIsAchieveAmount")) != null) setBigIsAchieveAmount(__getBoolean(val));
		if((val = values.get("bigAdvanceAmount")) != null) setBigAdvanceAmount(__getDecimal(val));  
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("customerContactId")) != null) setCustomerContactId(__getInt(val)); 
		if((val = values.get("architecturalDesignUnitId")) != null) setArchitecturalDesignUnitId(__getInt(val)); 
		if((val = values.get("architecturalDesignUnitContactId")) != null) setArchitecturalDesignUnitContactId(__getInt(val)); 
		if((val = values.get("region")) != null) setRegion(__getInt(val)); 
		if((val = values.get("comparisonForm")) != null) setComparisonForm(__getInt(val)); 
		if((val = values.get("isOriginal")) != null) setIsOriginal(__getBoolean(val));
		if((val = values.get("isSubProject")) != null) setIsSubProject(__getBoolean(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("isPubliclyBidding")) != null) setIsPubliclyBidding(__getBoolean(val));
		if((val = values.get("haveAgents")) != null) setHaveAgents(__getBoolean(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("ownerTypeId")) != null) setOwnerTypeId(__getInt(val)); 
		if((val = values.get("estimatePrice")) != null) setEstimatePrice(__getDecimal(val));  
		if((val = values.get("projectPhase")) != null) setProjectPhase(__getInt(val)); 
		if((val = values.get("projectAttribute")) != null) setProjectAttribute(__getInt(val)); 
		if((val = values.get("projectNameOne")) != null) setProjectNameOne(__getString(val));
		if((val = values.get("winningTime")) != null) setWinningTime(__getDate(val)); 
		if((val = values.get("projectOutputValue")) != null) setProjectOutputValue(__getDecimal(val));  
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val)); 
		if((val = values.get("isModifyProject")) != null) setIsModifyProject(__getBoolean(val));
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
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
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __detail_address ;
	protected java.util.Date  __project_end_time ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __customer_address ;
	protected java.lang.String  __bid_project ;
	protected java.lang.String  __construction_unit ;
	protected java.lang.String  __architectural_design_units ;
	protected java.lang.String  __rate_of_bid_winning ;
	protected java.util.Date  __follow_up_date ;
	protected java.lang.String  __equityedge_remark ;
	protected java.util.Date  __order_sign_up_time ;
	protected java.lang.String  __design_service_book ;
	protected java.lang.String  __service_suggest_book ;
	protected java.math.BigDecimal  __total_money ;
	protected java.math.BigDecimal  __covered_area ;
	protected java.math.BigDecimal  __design_area ;
	protected java.lang.Boolean  __has_formal_contracts ;
	protected java.lang.Boolean  __has_out_quotations ;
	protected java.lang.String  __specialty ;
	protected java.lang.String  __project_sales_team ;
	protected java.lang.Boolean  __has_split_price ;
	protected java.lang.Boolean  __has_order_release ;
	protected java.lang.Boolean  __has_deposit ;
	protected java.math.BigDecimal  __has_rate_of_payment ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __serial_number ;
	protected java.util.Date  __has_formal_contract_time ;
	protected java.util.Date  __has_out_quotation_time ;
	protected java.util.Date  __has_order_release_time ;
	protected java.util.Date  __has_split_price_time ;
	protected java.lang.Integer  __bid_type ;
	protected java.util.Date  __bid_date ;
	protected java.lang.Integer  __bid_class_type ;
	protected java.lang.Integer  __bid_unit_num ;
	protected java.lang.String  __our_order ;
	protected java.math.BigDecimal  __big_pay_amount ;
	protected java.lang.Boolean  __big_is_achieve_amount ;
	protected java.math.BigDecimal  __big_advance_amount ;
	protected java.lang.Integer  __client_id ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __customer_contact_id ;
	protected java.lang.Integer  __architectural_design_unit_id ;
	protected java.lang.Integer  __architectural_design_unit_contact_id ;
	protected java.lang.Integer  __region ;
	protected java.lang.Integer  __comparison_form ;
	protected java.lang.Boolean  __is_original ;
	protected java.lang.Boolean  __is_sub_project ;
	protected java.lang.Integer  __contract_status ;
	protected java.lang.Boolean  __is_publicly_bidding ;
	protected java.lang.Boolean  __have_agents ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.Integer  __owner_type_id ;
	protected java.math.BigDecimal  __estimate_price ;
	protected java.lang.Integer  __project_phase ;
	protected java.lang.Integer  __project_attribute ;
	protected java.lang.String  __project_name_one ;
	protected java.util.Date  __winning_time ;
	protected java.math.BigDecimal  __project_output_value ;
	protected java.lang.Integer  __main_project_stage_id ;
	protected java.lang.Boolean  __is_modify_project ;
	protected java.lang.String  __grade ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __process_status ;
}
