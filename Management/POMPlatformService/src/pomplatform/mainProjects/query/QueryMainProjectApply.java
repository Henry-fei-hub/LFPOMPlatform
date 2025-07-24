package pomplatform.mainProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjects.bean.BaseMainProjectApply;
import pomplatform.mainProjects.bean.ConditionMainProjectApply;

public class QueryMainProjectApply extends AbstractQuery<BaseMainProjectApply, ConditionMainProjectApply>
{

	private static final Logger __logger = Logger.getLogger(QueryMainProjectApply.class);

	public QueryMainProjectApply() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.main_project_id");
	}

	@Override
	public BaseCollection<BaseMainProjectApply> executeQuery( KeyValuePair[] replacements, ConditionMainProjectApply condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseMainProjectApply> runQuery( KeyValuePair[] replacements, ConditionMainProjectApply condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseMainProjectApply> execute( KeyValuePair[] replacements, ConditionMainProjectApply condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseMainProjectApply generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMainProjectApply __base = new BaseMainProjectApply();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEnglishName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationEnglishName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasContract(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectModel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTotalInvestment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActualDesignAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBuildingHeight(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBuildingFloors(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDecorateMoneyControl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBidProject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setConstructionUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRateOfBidWinning(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFollowUpDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEquityedgeRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOrderSignUpTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDesignServiceBook(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setServiceSuggestBook(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCoveredArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHasFormalContracts(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotations(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasOrderRelease(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasDeposit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasRateOfPayment(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHasFormalContractTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotationTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasOrderReleaseTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasSplitPriceTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBidType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBidDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBidClassType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBidUnitNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOurOrder(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBigPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBigIsAchieveAmount(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBigAdvanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnitId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnitContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHaveAgents(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOwnerTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEstimatePrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWinningTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectOutputValue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsModifyProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "select mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province, mp.city, mp.detail_address, mp.project_end_time, mp.project_type, mp.customer_name, mp.customer_address, mp.bid_project, mp.construction_unit, mp.architectural_design_units, mp.rate_of_bid_winning, mp.follow_up_date, mp.equityedge_remark, mp.order_sign_up_time, mp.design_service_book, mp.service_suggest_book, mp.total_money, mp.covered_area, mp.design_area, mp.has_formal_contracts, mp.has_out_quotations, mp.specialty, mp.project_sales_team, mp.has_split_price, mp.has_order_release, mp.has_deposit, mp.has_rate_of_payment, mp.parent_id, mp.serial_number, mp.has_formal_contract_time, mp.has_out_quotation_time, mp.has_order_release_time, mp.has_split_price_time, mp.bid_type, mp.bid_date, mp.bid_class_type, mp.bid_unit_num, mp.our_order, mp.big_pay_amount, mp.big_is_achieve_amount, mp.big_advance_amount, mp.client_id, mp.contact_name, mp.contact_phone, mp.apply_employee_id, mp.customer_contact_id, mp.architectural_design_unit_id, mp.architectural_design_unit_contact_id, mp.region, mp.comparison_form, mp.is_original, mp.is_sub_project, mp.contract_status, mp.is_publicly_bidding, mp.have_agents, mp.company_id, mp.company_no, mp.percent, mp.owner_type_id, mp.estimate_price, mp.project_phase, mp.project_attribute, mp.project_name_one, mp.winning_time, mp.project_output_value, mp.main_project_stage_id, mp.is_modify_project, mp.grade, mp.remark from main_projects mp where mp.main_project_id = ?" ;
	private final static String __originalSQL = "select mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province, mp.city, mp.detail_address, mp.project_end_time, mp.project_type, mp.customer_name, mp.customer_address, mp.bid_project, mp.construction_unit, mp.architectural_design_units, mp.rate_of_bid_winning, mp.follow_up_date, mp.equityedge_remark, mp.order_sign_up_time, mp.design_service_book, mp.service_suggest_book, mp.total_money, mp.covered_area, mp.design_area, mp.has_formal_contracts, mp.has_out_quotations, mp.specialty, mp.project_sales_team, mp.has_split_price, mp.has_order_release, mp.has_deposit, mp.has_rate_of_payment, mp.parent_id, mp.serial_number, mp.has_formal_contract_time, mp.has_out_quotation_time, mp.has_order_release_time, mp.has_split_price_time, mp.bid_type, mp.bid_date, mp.bid_class_type, mp.bid_unit_num, mp.our_order, mp.big_pay_amount, mp.big_is_achieve_amount, mp.big_advance_amount, mp.client_id, mp.contact_name, mp.contact_phone, mp.apply_employee_id, mp.customer_contact_id, mp.architectural_design_unit_id, mp.architectural_design_unit_contact_id, mp.region, mp.comparison_form, mp.is_original, mp.is_sub_project, mp.contract_status, mp.is_publicly_bidding, mp.have_agents, mp.company_id, mp.company_no, mp.percent, mp.owner_type_id, mp.estimate_price, mp.project_phase, mp.project_attribute, mp.project_name_one, mp.winning_time, mp.project_output_value, mp.main_project_stage_id, mp.is_modify_project, mp.grade, mp.remark from main_projects mp where mp.main_project_id =:main_project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"mp.main_project_id =:main_project_id\",\"startIndex\": 2079,\"stopIndex\":2114,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.main_project_id =:main_project_id\",\"fullFieldName\":\"mp.main_project_id\",\"operationName\":\"=\",\"variableName\":\"mainProjectId\",\"startIndex\": 2079,\"stopIndex\":2114,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "main_project_id,project_code,project_name,project_english_name,project_status,design_status,sign_company,project_origination,project_origination_remark,design_cooperation_name,design_cooperation_english_name,design_team,is_high_rise_building,info_register_time,project_approval_time,has_contract,project_base_on,info_code,project_model,design_qualification,business_type,fire_resistance_rating,estimate_the_design_areas,project_total_investment,actual_design_areas,total_building_areas,building_height,building_floors,decorate_money_control,project_level,province,city,detail_address,project_end_time,project_type,customer_name,customer_address,bid_project,construction_unit,architectural_design_units,rate_of_bid_winning,follow_up_date,equityedge_remark,order_sign_up_time,design_service_book,service_suggest_book,total_money,covered_area,design_area,has_formal_contracts,has_out_quotations,specialty,project_sales_team,has_split_price,has_order_release,has_deposit,has_rate_of_payment,parent_id,serial_number,has_formal_contract_time,has_out_quotation_time,has_order_release_time,has_split_price_time,bid_type,bid_date,bid_class_type,bid_unit_num,our_order,big_pay_amount,big_is_achieve_amount,big_advance_amount,client_id,contact_name,contact_phone,apply_employee_id,customer_contact_id,architectural_design_unit_id,architectural_design_unit_contact_id,region,comparison_form,is_original,is_sub_project,contract_status,is_publicly_bidding,have_agents,company_id,company_no,percent,owner_type_id,estimate_price,project_phase,project_attribute,project_name_one,winning_time,project_output_value,main_project_stage_id,is_modify_project,grade,remark";
	private final static String[] fieldNames = { "main_project_id"};
}
