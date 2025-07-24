package pomplatform.outQuotations.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.outQuotations.bean.BaseOnLoadAttentionListOfOutQuotations;
import pomplatform.outQuotations.bean.ConditionOnLoadAttentionListOfOutQuotations;

public class QueryOnLoadAttentionListOfOutQuotations extends AbstractQuery<BaseOnLoadAttentionListOfOutQuotations, ConditionOnLoadAttentionListOfOutQuotations>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttentionListOfOutQuotations.class);

	public QueryOnLoadAttentionListOfOutQuotations() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttentionListOfOutQuotations> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfOutQuotations condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfOutQuotations> runQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfOutQuotations condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfOutQuotations> execute( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfOutQuotations condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus()
			);
	}

	@Override
	public BaseOnLoadAttentionListOfOutQuotations generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttentionListOfOutQuotations __base = new BaseOnLoadAttentionListOfOutQuotations();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.process_type, oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time AS start_time, oq.info_code, oq.project_code, oq.project_code AS project_name, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time, a.new_create_quotation_name FROM system_process_attentions spa LEFT JOIN out_quotations oq ON spa.business_id = oq.out_quotation_id LEFT JOIN employees b ON spa.employee_id = b.employee_id left join (select DISTINCT out_quotation_id,new_create_quotation_name from out_design_considerations order by out_quotation_id desc ) as a ON spa.business_id = a.out_quotation_id WHERE spa.status = ? and spa.process_type = 75 and spa.employee_id = ? and b.employee_name like ? and b.employee_no like ? and oq.out_quotation_id = ? and oq.quotation_number like ? and oq.quotation_name like ? and oq.info_code like ? and oq.project_code like ? and oq.quotation_status = ? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.process_type, oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time AS start_time, oq.info_code, oq.project_code, oq.project_code AS project_name, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time, a.new_create_quotation_name FROM system_process_attentions spa LEFT JOIN out_quotations oq ON spa.business_id = oq.out_quotation_id LEFT JOIN employees b ON spa.employee_id = b.employee_id left join (select DISTINCT out_quotation_id,new_create_quotation_name from out_design_considerations order by out_quotation_id desc ) as a ON spa.business_id = a.out_quotation_id WHERE spa.status =:status AND spa.process_type = 75 AND spa.employee_id =:employee_id AND b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND oq.out_quotation_id =:out_quotation_id AND oq.quotation_number LIKE :quotation_number AND oq.quotation_name LIKE :quotation_name AND oq.info_code LIKE :info_code AND oq.project_code LIKE :project_code AND oq.quotation_status =:quotation_status ORDER BY spa.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spa.status =:status AND spa.process_type = 75 AND spa.employee_id =:employee_id AND b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND oq.out_quotation_id =:out_quotation_id AND oq.quotation_number LIKE :quotation_number AND oq.quotation_name LIKE :quotation_name AND oq.info_code LIKE :info_code AND oq.project_code LIKE :project_code AND oq.quotation_status =:quotation_status\",\"startIndex\": 1010,\"stopIndex\":1412,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spa.status =:status\",\"fullFieldName\":\"spa.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"and\",\"startIndex\": 1010,\"stopIndex\":1028,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.process_type = 75\",\"nextToken\":\"and\",\"startIndex\": 1034,\"stopIndex\":1054,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.employee_id =:employee_id\",\"fullFieldName\":\"spa.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1060,\"stopIndex\":1088,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 1094,\"stopIndex\":1128,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_no LIKE :employee_no\",\"fullFieldName\":\"b.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 1134,\"stopIndex\":1164,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.out_quotation_id =:out_quotation_id\",\"fullFieldName\":\"oq.out_quotation_id\",\"operationName\":\"=\",\"variableName\":\"outQuotationId\",\"nextToken\":\"and\",\"startIndex\": 1170,\"stopIndex\":1207,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_number LIKE :quotation_number\",\"fullFieldName\":\"oq.quotation_number\",\"operationName\":\"like\",\"variableName\":\"quotationNumber\",\"nextToken\":\"and\",\"startIndex\": 1213,\"stopIndex\":1254,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_name LIKE :quotation_name\",\"fullFieldName\":\"oq.quotation_name\",\"operationName\":\"like\",\"variableName\":\"quotationName\",\"nextToken\":\"and\",\"startIndex\": 1260,\"stopIndex\":1297,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.info_code LIKE :info_code\",\"fullFieldName\":\"oq.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"nextToken\":\"and\",\"startIndex\": 1303,\"stopIndex\":1330,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.project_code LIKE :project_code\",\"fullFieldName\":\"oq.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 1336,\"stopIndex\":1369,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_status =:quotation_status\",\"fullFieldName\":\"oq.quotation_status\",\"operationName\":\"=\",\"variableName\":\"quotationStatus\",\"startIndex\": 1375,\"stopIndex\":1412,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,process_type,out_quotation_id,quotation_number,quotation_name,money_sum,start_time,info_code,project_code,project_name,business_type,project_type,quotation_files,quotation_status,disable_type,employee_id,contract_id,update_time,new_create_quotation_name";
	private final static String[] fieldNames = { "status", "employee_id", "employee_name", "employee_no", "out_quotation_id", "quotation_number", "quotation_name", "info_code", "project_code", "quotation_status"};
}

