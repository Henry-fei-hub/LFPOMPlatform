package pomplatform.ht.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ht.bean.BaseContractPrice;
import pomplatform.ht.bean.ConditionContractPrice;

public class QueryContractPrice extends AbstractQuery<BaseContractPrice, ConditionContractPrice>
{

	private static final Logger __logger = Logger.getLogger(QueryContractPrice.class);

	public QueryContractPrice() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.project_code");
	}

	@Override
	public BaseCollection<BaseContractPrice> executeQuery( KeyValuePair[] replacements, ConditionContractPrice condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getMainProjectStageId(), 
				condition.getClientId(), 
				condition.getCustomerName(), 
				condition.getCustomerId(), 
				condition.getCustomerName()
			);
	}

	public BaseCollection<BaseContractPrice> runQuery( KeyValuePair[] replacements, ConditionContractPrice condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getMainProjectStageId(), 
				condition.getClientId(), 
				condition.getCustomerName(), 
				condition.getCustomerId(), 
				condition.getCustomerName()
			);
	}

	public BaseCollection<BaseContractPrice> execute( KeyValuePair[] replacements, ConditionContractPrice condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getMainProjectStageId(), 
				condition.getClientId(), 
				condition.getCustomerName(), 
				condition.getCustomerId(), 
				condition.getCustomerName()
			);
	}

	@Override
	public BaseContractPrice generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractPrice __base = new BaseContractPrice();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainDesignAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignUnitPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT mp.project_code, mp.project_name, mp.main_project_stage_id, cc.customer_id, cc.customer_name as parent_name, mp.client_id, mp.customer_name, CASE quotation_status WHEN 1 THEN odc.main_design_area_name WHEN 2 THEN odc.main_design_area_name ELSE NULL END main_design_area_name, CASE quotation_status WHEN 1 THEN odc.design_area WHEN 2 THEN odc.design_area ELSE NULL END design_area, CASE quotation_status WHEN 1 THEN odc.design_unit_price WHEN 2 THEN odc.design_unit_price ELSE NULL END design_unit_price, CASE quotation_status WHEN 1 THEN odc.money_sum WHEN 2 THEN odc.money_sum ELSE NULL END money_sum FROM main_projects mp LEFT JOIN out_quotations oq ON mp.info_code = oq.info_code AND mp.project_code = oq.project_code LEFT JOIN out_design_considerations odc ON odc.out_quotation_id = oq.out_quotation_id LEFT JOIN customers C ON mp.client_id = C.customer_id LEFT JOIN customers cc ON cc.customer_id = C.parent_id WHERE mp.process_status = 2 and mp.project_code like ? and mp.project_name like ? and mp.main_project_stage_id = ? and mp.client_id = ? and mp.customer_name like ? and cc.customer_id = ? and cc.customer_name like ?" ;
	private final static String __originalSQL = "SELECT mp.project_code, mp.project_name, mp.main_project_stage_id, cc.customer_id, cc.customer_name as parent_name, mp.client_id, mp.customer_name, CASE quotation_status WHEN 1 THEN odc.main_design_area_name WHEN 2 THEN odc.main_design_area_name ELSE NULL END main_design_area_name, CASE quotation_status WHEN 1 THEN odc.design_area WHEN 2 THEN odc.design_area ELSE NULL END design_area, CASE quotation_status WHEN 1 THEN odc.design_unit_price WHEN 2 THEN odc.design_unit_price ELSE NULL END design_unit_price, CASE quotation_status WHEN 1 THEN odc.money_sum WHEN 2 THEN odc.money_sum ELSE NULL END money_sum FROM main_projects mp LEFT JOIN out_quotations oq ON mp.info_code = oq.info_code AND mp.project_code = oq.project_code LEFT JOIN out_design_considerations odc ON odc.out_quotation_id = oq.out_quotation_id LEFT JOIN customers C ON mp.client_id = C.customer_id LEFT JOIN customers cc ON cc.customer_id = C.parent_id WHERE mp.process_status = 2 AND mp.project_code LIKE :project_code AND mp.project_name LIKE :project_name AND mp.main_project_stage_id =:main_project_stage_id AND mp.client_id =:client_id AND mp.customer_name LIKE :customer_name AND cc.customer_id =:customer_id AND cc.customer_name LIKE :customer_name";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"mp.process_status = 2 AND mp.project_code LIKE :project_code AND mp.project_name LIKE :project_name AND mp.main_project_stage_id =:main_project_stage_id AND mp.client_id =:client_id AND mp.customer_name LIKE :customer_name AND cc.customer_id =:customer_id AND cc.customer_name LIKE :customer_name\",\"startIndex\": 929,\"stopIndex\":1224,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.process_status = 2\",\"nextToken\":\"and\",\"startIndex\": 929,\"stopIndex\":949,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_code LIKE :project_code\",\"fullFieldName\":\"mp.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 955,\"stopIndex\":988,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_name LIKE :project_name\",\"fullFieldName\":\"mp.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 994,\"stopIndex\":1027,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.main_project_stage_id =:main_project_stage_id\",\"fullFieldName\":\"mp.main_project_stage_id\",\"operationName\":\"=\",\"variableName\":\"mainProjectStageId\",\"nextToken\":\"and\",\"startIndex\": 1033,\"stopIndex\":1080,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.client_id =:client_id\",\"fullFieldName\":\"mp.client_id\",\"operationName\":\"=\",\"variableName\":\"clientId\",\"nextToken\":\"and\",\"startIndex\": 1086,\"stopIndex\":1109,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.customer_name LIKE :customer_name\",\"fullFieldName\":\"mp.customer_name\",\"operationName\":\"like\",\"variableName\":\"customerName\",\"nextToken\":\"and\",\"startIndex\": 1115,\"stopIndex\":1150,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cc.customer_id =:customer_id\",\"fullFieldName\":\"cc.customer_id\",\"operationName\":\"=\",\"variableName\":\"customerId\",\"nextToken\":\"and\",\"startIndex\": 1156,\"stopIndex\":1183,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cc.customer_name LIKE :customer_name\",\"fullFieldName\":\"cc.customer_name\",\"operationName\":\"like\",\"variableName\":\"customerName\",\"startIndex\": 1189,\"stopIndex\":1224,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_code,project_name,main_project_stage_id,customer_id,parent_name,client_id,customer_name,main_design_area_name,design_area,design_unit_price,money_sum";
	private final static String[] fieldNames = { "project_code", "project_name", "main_project_stage_id", "client_id", "customer_name", "customer_id", "customer_name"};
}
