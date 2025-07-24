package pomplatform.ht.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ht.bean.BaseMainProject;
import pomplatform.ht.bean.ConditionMainProject;

public class QueryMainProject extends AbstractQuery<BaseMainProject, ConditionMainProject>
{

	private static final Logger __logger = Logger.getLogger(QueryMainProject.class);

	public QueryMainProject() throws java.sql.SQLException
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.main_project_id");
	}

	@Override
	public BaseCollection<BaseMainProject> executeQuery( KeyValuePair[] replacements, ConditionMainProject condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements,
				condition.getProjectCode(),
				condition.getProjectName(),
				condition.getHasContract(),
				condition.getProjectBaseOn(),
				condition.getInfoCode(),
				condition.getDesignTeam(),
				condition.getLeader(),
				condition.getSecretary(),
				condition.getChargePerson()
		);
	}

	public BaseCollection<BaseMainProject> runQuery( KeyValuePair[] replacements, ConditionMainProject condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements,
				condition.getProjectCode(),
				condition.getProjectName(),
				condition.getHasContract(),
				condition.getProjectBaseOn(),
				condition.getInfoCode(),
				condition.getDesignTeam(),
				condition.getLeader(),
				condition.getSecretary(),
				condition.getChargePerson()
		);
	}

	public BaseCollection<BaseMainProject> execute( KeyValuePair[] replacements, ConditionMainProject condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements,
				condition.getProjectCode(),
				condition.getProjectName(),
				condition.getHasContract(),
				condition.getProjectBaseOn(),
				condition.getInfoCode(),
				condition.getDesignTeam(),
				condition.getLeader(),
				condition.getSecretary(),
				condition.getChargePerson()
		);
	}

	@Override
	public BaseMainProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMainProject __base = new BaseMainProject();
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
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
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
		if((val = __data[count++]) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasOrderRelease(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasDeposit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasRateOfPayment(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBidType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSecretary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setChargePerson(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
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

	private final static String __SQLText = "SELECT mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.project_sales_team, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province, mp.city, mp.detail_address, mp.project_end_time, mp.project_type, mp.customer_name, mp.customer_address, mp.bid_project, mp.construction_unit, mp.architectural_design_units, mp.rate_of_bid_winning, mp.follow_up_date, mp.equityedge_remark, mp.order_sign_up_time, mp.design_service_book, mp.service_suggest_book, mp.total_money, mp.covered_area, mp.design_area, mp.has_formal_contracts, mp.has_out_quotations, mp.has_split_price, has_order_release, has_deposit, has_rate_of_payment, bid_type, mpe1.employee_name AS secretary, mpe2.employee_name AS leader, mpe3.employee_name AS charge_person FROM main_projects mp LEFT JOIN ( SELECT array_to_string( ARRAY_AGG ( employee_name ), '，' ) employee_name, main_project_id, relation FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id GROUP BY main_project_id, relation ) mpe1 ON mp.main_project_id = mpe1.main_project_id AND mpe1.relation = 1 LEFT JOIN ( SELECT array_to_string( ARRAY_AGG ( employee_name ), '，' ) employee_name, main_project_id, relation FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id GROUP BY main_project_id, relation ) mpe2 ON mp.main_project_id = mpe2.main_project_id AND mpe2.relation = 4 LEFT JOIN ( SELECT array_to_string( ARRAY_AGG ( employee_name ), '，' ) employee_name, main_project_id, relation FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id GROUP BY main_project_id, relation ) mpe3 ON mp.main_project_id = mpe3.main_project_id and mpe3.relation = 5 and mp.project_code like ? and mp.project_name like ? and mp.has_contract = ? and mp.project_base_on = ? and mp.info_code like ? and mp.design_team = ? and mpe2.employee_name like ? and mpe1.employee_name like ? and mpe3.employee_name like ?" ;
	private final static String __originalSQL = "SELECT mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.project_sales_team, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province, mp.city, mp.detail_address, mp.project_end_time, mp.project_type, mp.customer_name, mp.customer_address, mp.bid_project, mp.construction_unit, mp.architectural_design_units, mp.rate_of_bid_winning, mp.follow_up_date, mp.equityedge_remark, mp.order_sign_up_time, mp.design_service_book, mp.service_suggest_book, mp.total_money, mp.covered_area, mp.design_area, mp.has_formal_contracts, mp.has_out_quotations, mp.has_split_price, has_order_release, has_deposit, has_rate_of_payment, bid_type, mpe1.employee_name AS secretary, mpe2.employee_name AS leader, mpe3.employee_name AS charge_person FROM main_projects mp LEFT JOIN ( SELECT array_to_string( ARRAY_AGG ( employee_name ), '，' ) employee_name, main_project_id, relation FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id GROUP BY main_project_id, relation ) mpe1 ON mp.main_project_id = mpe1.main_project_id AND mpe1.relation = 1 LEFT JOIN ( SELECT array_to_string( ARRAY_AGG ( employee_name ), '，' ) employee_name, main_project_id, relation FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id GROUP BY main_project_id, relation ) mpe2 ON mp.main_project_id = mpe2.main_project_id AND mpe2.relation = 4 LEFT JOIN ( SELECT array_to_string( ARRAY_AGG ( employee_name ), '，' ) employee_name, main_project_id, relation FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id GROUP BY main_project_id, relation ) mpe3 ON mp.main_project_id = mpe3.main_project_id AND mpe3.relation = 5 AND mp.project_code LIKE :project_code AND mp.project_name LIKE :project_name AND mp.has_contract = :has_contract AND mp.project_base_on = :project_base_on AND mp.info_code LIKE :info_code AND mp.design_team = :design_team AND mpe2.employee_name like :leader AND mpe1.employee_name like :secretary AND mpe3.employee_name like :charge_person";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"mp.main_project_id = mpe3.main_project_id AND mpe3.relation = 5 AND mp.project_code LIKE :project_code AND mp.project_name LIKE :project_name AND mp.has_contract = :has_contract AND mp.project_base_on = :project_base_on AND mp.info_code LIKE :info_code AND mp.design_team = :design_team AND mpe2.employee_name like :leader AND mpe1.employee_name like :secretary AND mpe3.employee_name like :charge_person\",\"startIndex\": 2196,\"stopIndex\":2599,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.main_project_id = mpe3.main_project_id\",\"nextToken\":\"and\",\"startIndex\": 2196,\"stopIndex\":2236,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe3.relation = 5\",\"nextToken\":\"and\",\"startIndex\": 2242,\"stopIndex\":2258,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_code LIKE :project_code\",\"fullFieldName\":\"mp.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 2264,\"stopIndex\":2297,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_name LIKE :project_name\",\"fullFieldName\":\"mp.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 2303,\"stopIndex\":2336,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.has_contract = :has_contract\",\"fullFieldName\":\"mp.has_contract\",\"operationName\":\"=\",\"variableName\":\"hasContract\",\"nextToken\":\"and\",\"startIndex\": 2342,\"stopIndex\":2372,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_base_on = :project_base_on\",\"fullFieldName\":\"mp.project_base_on\",\"operationName\":\"=\",\"variableName\":\"projectBaseOn\",\"nextToken\":\"and\",\"startIndex\": 2378,\"stopIndex\":2414,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.info_code LIKE :info_code\",\"fullFieldName\":\"mp.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"nextToken\":\"and\",\"startIndex\": 2420,\"stopIndex\":2447,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.design_team = :design_team\",\"fullFieldName\":\"mp.design_team\",\"operationName\":\"=\",\"variableName\":\"designTeam\",\"nextToken\":\"and\",\"startIndex\": 2453,\"stopIndex\":2481,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe2.employee_name like :leader\",\"fullFieldName\":\"mpe2.employee_name\",\"operationName\":\"like\",\"variableName\":\"leader\",\"nextToken\":\"and\",\"startIndex\": 2487,\"stopIndex\":2517,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe1.employee_name like :secretary\",\"fullFieldName\":\"mpe1.employee_name\",\"operationName\":\"like\",\"variableName\":\"secretary\",\"nextToken\":\"and\",\"startIndex\": 2523,\"stopIndex\":2556,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe3.employee_name like :charge_person\",\"fullFieldName\":\"mpe3.employee_name\",\"operationName\":\"like\",\"variableName\":\"chargePerson\",\"startIndex\": 2562,\"stopIndex\":2599,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "main_project_id,project_code,project_name,project_english_name,project_status,design_status,sign_company,project_origination,project_origination_remark,design_cooperation_name,design_cooperation_english_name,project_sales_team,design_team,is_high_rise_building,info_register_time,project_approval_time,has_contract,project_base_on,info_code,project_model,design_qualification,business_type,fire_resistance_rating,estimate_the_design_areas,project_total_investment,actual_design_areas,total_building_areas,building_height,building_floors,decorate_money_control,project_level,province,city,detail_address,project_end_time,project_type,customer_name,customer_address,bid_project,construction_unit,architectural_design_units,rate_of_bid_winning,follow_up_date,equityedge_remark,order_sign_up_time,design_service_book,service_suggest_book,total_money,covered_area,design_area,has_formal_contracts,has_out_quotations,has_split_price,has_order_release,has_deposit,has_rate_of_payment,bid_type,secretary,leader,charge_person";
	private final static String[] fieldNames = { "project_code", "project_name", "has_contract", "project_base_on", "info_code", "design_team", "leader", "secretary", "charge_person"};
}
