package pomplatform.outQuotations.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.outQuotations.bean.BaseOnLoadApplyListOfOutQuotations;
import pomplatform.outQuotations.bean.ConditionOnLoadApplyListOfOutQuotations;

public class QueryOnLoadApplyListOfOutQuotations extends AbstractQuery<BaseOnLoadApplyListOfOutQuotations, ConditionOnLoadApplyListOfOutQuotations>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfOutQuotations.class);

	public QueryOnLoadApplyListOfOutQuotations() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfOutQuotations> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfOutQuotations condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfOutQuotations> runQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfOutQuotations condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfOutQuotations> execute( KeyValuePair[] replacements, ConditionOnLoadApplyListOfOutQuotations condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadApplyListOfOutQuotations generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfOutQuotations __base = new BaseOnLoadApplyListOfOutQuotations();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationFiles(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQuotationStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDisableType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time AS start_time, oq.info_code, oq.project_code, oq.project_code AS project_name, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time, a.new_create_quotation_name FROM system_process_instances spi LEFT JOIN out_quotations oq ON spi.business_id = oq.out_quotation_id left join (select DISTINCT out_quotation_id,new_create_quotation_name from out_design_considerations order by out_quotation_id desc ) as a ON spi.business_id = a.out_quotation_id WHERE spi.process_type = 75 and spi.process_status IN ( 0, 1 ) and oq.out_quotation_id = ? and oq.quotation_number like ? and oq.quotation_name like ? and oq.info_code like ? and oq.project_code like ? and oq.quotation_status = ? and spi.employee_id = ? ORDER BY spi.create_time DESC" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time AS start_time, oq.info_code, oq.project_code, oq.project_code AS project_name, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time, a.new_create_quotation_name FROM system_process_instances spi LEFT JOIN out_quotations oq ON spi.business_id = oq.out_quotation_id left join (select DISTINCT out_quotation_id,new_create_quotation_name from out_design_considerations order by out_quotation_id desc ) as a ON spi.business_id = a.out_quotation_id WHERE spi.process_type = 75 AND spi.process_status IN ( 0, 1 ) AND oq.out_quotation_id =:out_quotation_id AND oq.quotation_number LIKE :quotation_number AND oq.quotation_name LIKE :quotation_name AND oq.info_code LIKE :info_code AND oq.project_code LIKE :project_code AND oq.quotation_status =:quotation_status AND spi.employee_id =:employee_id ORDER BY spi.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type = 75 AND spi.process_status IN ( 0, 1 ) AND oq.out_quotation_id =:out_quotation_id AND oq.quotation_number LIKE :quotation_number AND oq.quotation_name LIKE :quotation_name AND oq.info_code LIKE :info_code AND oq.project_code LIKE :project_code AND oq.quotation_status =:quotation_status AND spi.employee_id =:employee_id\",\"startIndex\": 818,\"stopIndex\":1155,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type = 75\",\"nextToken\":\"and\",\"startIndex\": 818,\"stopIndex\":838,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status IN ( 0, 1 )\",\"nextToken\":\"and\",\"startIndex\": 844,\"stopIndex\":873,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.out_quotation_id =:out_quotation_id\",\"fullFieldName\":\"oq.out_quotation_id\",\"operationName\":\"=\",\"variableName\":\"outQuotationId\",\"nextToken\":\"and\",\"startIndex\": 879,\"stopIndex\":916,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_number LIKE :quotation_number\",\"fullFieldName\":\"oq.quotation_number\",\"operationName\":\"like\",\"variableName\":\"quotationNumber\",\"nextToken\":\"and\",\"startIndex\": 922,\"stopIndex\":963,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_name LIKE :quotation_name\",\"fullFieldName\":\"oq.quotation_name\",\"operationName\":\"like\",\"variableName\":\"quotationName\",\"nextToken\":\"and\",\"startIndex\": 969,\"stopIndex\":1006,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.info_code LIKE :info_code\",\"fullFieldName\":\"oq.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"nextToken\":\"and\",\"startIndex\": 1012,\"stopIndex\":1039,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.project_code LIKE :project_code\",\"fullFieldName\":\"oq.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 1045,\"stopIndex\":1078,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_status =:quotation_status\",\"fullFieldName\":\"oq.quotation_status\",\"operationName\":\"=\",\"variableName\":\"quotationStatus\",\"nextToken\":\"and\",\"startIndex\": 1084,\"stopIndex\":1121,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1127,\"stopIndex\":1155,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,process_type,out_quotation_id,quotation_number,quotation_name,money_sum,start_time,info_code,project_code,project_name,business_type,project_type,quotation_files,quotation_status,disable_type,employee_id,contract_id,update_time,new_create_quotation_name";
	private final static String[] fieldNames = { "out_quotation_id", "quotation_number", "quotation_name", "info_code", "project_code", "quotation_status", "employee_id"};
}
