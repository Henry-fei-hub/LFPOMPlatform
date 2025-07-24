package pomplatform.subContractInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.subContractInfo.bean.BaseSubContractInfo;
import pomplatform.subContractInfo.bean.ConditionSubContractInfo;

public class QuerySubContractInfo extends AbstractQuery<BaseSubContractInfo, ConditionSubContractInfo>
{

	private static final Logger __logger = Logger.getLogger(QuerySubContractInfo.class);

	public QuerySubContractInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sc.sub_contract_id");
	}

	@Override
	public BaseCollection<BaseSubContractInfo> executeQuery( KeyValuePair[] replacements, ConditionSubContractInfo condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getParentId()
			);
	}

	public BaseCollection<BaseSubContractInfo> runQuery( KeyValuePair[] replacements, ConditionSubContractInfo condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getParentId()
			);
	}

	public BaseCollection<BaseSubContractInfo> execute( KeyValuePair[] replacements, ConditionSubContractInfo condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getParentId()
			);
	}

	@Override
	public BaseSubContractInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSubContractInfo __base = new BaseSubContractInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT sc.sub_contract_id, sc.parent_id, sc.sub_contract_code, sc.project_code, sc.business_type, sc.project_type, sc.department_id, sc.common_area, sc.logistics_area, sc.money_sum, sc.create_time, sc.sub_contract_name, sc.update_time, P.project_id, sc.sheet_total_integral, sc.design_area, sc.complaint_percentage, sc.complaint_integral, sc.sheet_integral, sc.percentage FROM sub_contracts sc LEFT JOIN projects P ON sc.sub_contract_code = P.contract_code WHERE sc.parent_id = ?" ;
	private final static String __originalSQL = "SELECT sc.sub_contract_id, sc.parent_id, sc.sub_contract_code, sc.project_code, sc.business_type, sc.project_type, sc.department_id, sc.common_area, sc.logistics_area, sc.money_sum, sc.create_time, sc.sub_contract_name, sc.update_time, P.project_id, sc.sheet_total_integral, sc.design_area, sc.complaint_percentage, sc.complaint_integral, sc.sheet_integral, sc.percentage FROM sub_contracts sc LEFT JOIN projects P ON sc.sub_contract_code = P.contract_code WHERE sc.parent_id =:parent_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"sc.parent_id =:parent_id\",\"startIndex\": 463,\"stopIndex\":486,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"sc.parent_id =:parent_id\",\"fullFieldName\":\"sc.parent_id\",\"operationName\":\"=\",\"variableName\":\"parentId\",\"startIndex\": 463,\"stopIndex\":486,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "sub_contract_id,parent_id,sub_contract_code,project_code,business_type,project_type,department_id,common_area,logistics_area,money_sum,create_time,sub_contract_name,update_time,project_id,sheet_total_integral,design_area,complaint_percentage,complaint_integral,sheet_integral,percentage";
	private final static String[] fieldNames = { "parent_id"};
}
