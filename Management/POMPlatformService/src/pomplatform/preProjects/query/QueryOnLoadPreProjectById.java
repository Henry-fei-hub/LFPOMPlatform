package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseOnLoadPreProjectById;
import pomplatform.preProjects.bean.ConditionOnLoadPreProjectById;

public class QueryOnLoadPreProjectById extends AbstractQuery<BaseOnLoadPreProjectById, ConditionOnLoadPreProjectById>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadPreProjectById.class);

	public QueryOnLoadPreProjectById() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pp.pre_project_id");
	}

	@Override
	public BaseCollection<BaseOnLoadPreProjectById> executeQuery( KeyValuePair[] replacements, ConditionOnLoadPreProjectById condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getPreProjectId()
			);
	}

	public BaseCollection<BaseOnLoadPreProjectById> runQuery( KeyValuePair[] replacements, ConditionOnLoadPreProjectById condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getPreProjectId()
			);
	}

	public BaseCollection<BaseOnLoadPreProjectById> execute( KeyValuePair[] replacements, ConditionOnLoadPreProjectById condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getPreProjectId()
			);
	}

	@Override
	public BaseOnLoadPreProjectById generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadPreProjectById __base = new BaseOnLoadPreProjectById();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTotalInvestment(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBuildingHeight(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBuildingFloors(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecorateMoneyControl(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasContract(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWinRate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHaveAgents(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsWinningBid(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBidCompanyNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBidRankingType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBidRanking(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOwnerTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEstimatePrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContactEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsOperationDepartment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessTypes(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessTypesName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOutputValue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentCustomerName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select pp.pre_project_id, pp.project_code, pp.info_code, pp.client_id, pp.customer_name, pp.customer_address, pp.project_name, pp.province, pp.city, pp.detail_address, pp.project_type, pp.total_building_areas, pp.project_origination, pp.project_origination_remark, pp.customer_contact_id, pp.contact_name, pp.contact_phone, pp.design_status, pp.project_sales_team, pp.design_team, pp.project_level, pp.sign_company, pp.design_qualification, pp.project_base_on, pp.project_approval_time, pp.is_high_rise_building, pp.design_cooperation_name, pp.architectural_design_units, pp.project_total_investment, pp.fire_resistance_rating, pp.estimate_the_design_areas, pp.actual_design_areas, pp.building_height, pp.building_floors, pp.decorate_money_control, pp.specialty, pp.business_type, pp.has_contract, pp.apply_employee_id, pp.create_time, pp.info_register_time, pp.project_status, pp.close_reason, pp.status, pp.comparison_form, pp.region, pp.win_rate, pp.remark, pp.close_remark, pp.grade, pp.is_original, pp.is_sub_project, pp.contract_status, pp.is_publicly_bidding, pp.have_agents, pp.is_winning_bid, pp.bid_company_num, pp.bid_ranking_type, pp.bid_ranking, pp.owner_type_id, pp.estimate_price, pp.contact_email, pp.is_operation_department, pp.project_name_one, pp.business_types, pp.business_types_name, pp.project_output_value, pp.parent_customer_name from pre_projects pp where pp.pre_project_id = ?" ;
	private final static String __originalSQL = "select pp.pre_project_id, pp.project_code, pp.info_code, pp.client_id, pp.customer_name, pp.customer_address, pp.project_name, pp.province, pp.city, pp.detail_address, pp.project_type, pp.total_building_areas, pp.project_origination, pp.project_origination_remark, pp.customer_contact_id, pp.contact_name, pp.contact_phone, pp.design_status, pp.project_sales_team, pp.design_team, pp.project_level, pp.sign_company, pp.design_qualification, pp.project_base_on, pp.project_approval_time, pp.is_high_rise_building, pp.design_cooperation_name, pp.architectural_design_units, pp.project_total_investment, pp.fire_resistance_rating, pp.estimate_the_design_areas, pp.actual_design_areas, pp.building_height, pp.building_floors, pp.decorate_money_control, pp.specialty, pp.business_type, pp.has_contract, pp.apply_employee_id, pp.create_time, pp.info_register_time, pp.project_status, pp.close_reason, pp.status, pp.comparison_form, pp.region, pp.win_rate, pp.remark, pp.close_remark, pp.grade, pp.is_original, pp.is_sub_project, pp.contract_status, pp.is_publicly_bidding, pp.have_agents, pp.is_winning_bid, pp.bid_company_num, pp.bid_ranking_type, pp.bid_ranking, pp.owner_type_id, pp.estimate_price, pp.contact_email, pp.is_operation_department, pp.project_name_one, pp.business_types, pp.business_types_name, pp.project_output_value, pp.parent_customer_name from pre_projects pp where pp.pre_project_id = :pre_project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"pp.pre_project_id = :pre_project_id\",\"startIndex\": 1382,\"stopIndex\":1416,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pp.pre_project_id = :pre_project_id\",\"fullFieldName\":\"pp.pre_project_id\",\"operationName\":\"=\",\"variableName\":\"preProjectId\",\"startIndex\": 1382,\"stopIndex\":1416,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "pre_project_id,project_code,info_code,client_id,customer_name,customer_address,project_name,province,city,detail_address,project_type,total_building_areas,project_origination,project_origination_remark,customer_contact_id,contact_name,contact_phone,design_status,project_sales_team,design_team,project_level,sign_company,design_qualification,project_base_on,project_approval_time,is_high_rise_building,design_cooperation_name,architectural_design_units,project_total_investment,fire_resistance_rating,estimate_the_design_areas,actual_design_areas,building_height,building_floors,decorate_money_control,specialty,business_type,has_contract,apply_employee_id,create_time,info_register_time,project_status,close_reason,status,comparison_form,region,win_rate,remark,close_remark,grade,is_original,is_sub_project,contract_status,is_publicly_bidding,have_agents,is_winning_bid,bid_company_num,bid_ranking_type,bid_ranking,owner_type_id,estimate_price,contact_email,is_operation_department,project_name_one,business_types,business_types_name,project_output_value,parent_customer_name";
	private final static String[] fieldNames = { "pre_project_id"};
}
