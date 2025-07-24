package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseOnLoadProjectSettlementEmployees;
import pomplatform.projectSettlement.bean.ConditionOnLoadProjectSettlementEmployees;

public class QueryOnLoadProjectSettlementEmployees extends AbstractQuery<BaseOnLoadProjectSettlementEmployees, ConditionOnLoadProjectSettlementEmployees>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectSettlementEmployees.class);

	public QueryOnLoadProjectSettlementEmployees() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .project_employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectSettlementEmployees> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectSettlementEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseOnLoadProjectSettlementEmployees> runQuery( KeyValuePair[] replacements, ConditionOnLoadProjectSettlementEmployees condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseOnLoadProjectSettlementEmployees> execute( KeyValuePair[] replacements, ConditionOnLoadProjectSettlementEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadProjectSettlementEmployees generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectSettlementEmployees __base = new BaseOnLoadProjectSettlementEmployees();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementDetailId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT A .project_employee_id, A.project_id, P.project_manage_id, P.contract_code AS sheet_code, P.project_name AS sheet_name, A.employee_id, e.employee_no, e.employee_name, ( CASE WHEN C.real_integral ISNULL THEN 0 ELSE C.real_integral END ) AS real_amount, ( CASE WHEN C.sure_integral ISNULL THEN 0 ELSE C.sure_integral END ) AS sure_integral, ( CASE WHEN C.COST ISNULL THEN 0 ELSE C.COST END ) AS COST, ( CASE WHEN C.project_cost ISNULL THEN 0 ELSE C.project_cost END ) AS project_cost, ( CASE WHEN C.real_amount ISNULL THEN 0 ELSE C.real_amount END ) AS final_amount, e.status, A.work_content, A.FLAG, D.settlement_detail_id FROM project_employees AS A LEFT JOIN ( SELECT project_id, employee_id, SUM ( CASE WHEN settlement_status = 2 THEN real_amount ELSE 0 END ) AS sure_integral, SUM ( CASE WHEN settlement_status = 2 THEN project_cost ELSE 0 END ) AS project_cost, SUM ( CASE WHEN settlement_status = 1 THEN real_amount ELSE 0 END ) AS real_integral, SUM ( CASE WHEN settlement_status = 1 THEN project_cost ELSE 0 END ) AS COST, SUM ( final_amount ) AS real_amount FROM project_settlement_details where settlement_status in(1,2) GROUP BY project_id, employee_id ) C ON A.project_id = C.project_id AND A.employee_id = C.employee_id LEFT JOIN project_settlement_details AS D ON A.project_id = D.project_id AND A.employee_id = D.employee_id AND d.settlement_status = 1 LEFT JOIN projects P ON A.project_id = P.project_id LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE A.project_id = ? and A.employee_id = ? and A.status = 2" ;
	private final static String __originalSQL = "SELECT A .project_employee_id, A.project_id, P.project_manage_id, P.contract_code AS sheet_code, P.project_name AS sheet_name, A.employee_id, e.employee_no, e.employee_name, ( CASE WHEN C.real_integral ISNULL THEN 0 ELSE C.real_integral END ) AS real_amount, ( CASE WHEN C.sure_integral ISNULL THEN 0 ELSE C.sure_integral END ) AS sure_integral, ( CASE WHEN C.COST ISNULL THEN 0 ELSE C.COST END ) AS COST, ( CASE WHEN C.project_cost ISNULL THEN 0 ELSE C.project_cost END ) AS project_cost, ( CASE WHEN C.real_amount ISNULL THEN 0 ELSE C.real_amount END ) AS final_amount, e.status, A.work_content, A.FLAG, D.settlement_detail_id FROM project_employees AS A LEFT JOIN ( SELECT project_id, employee_id, SUM ( CASE WHEN settlement_status = 2 THEN real_amount ELSE 0 END ) AS sure_integral, SUM ( CASE WHEN settlement_status = 2 THEN project_cost ELSE 0 END ) AS project_cost, SUM ( CASE WHEN settlement_status = 1 THEN real_amount ELSE 0 END ) AS real_integral, SUM ( CASE WHEN settlement_status = 1 THEN project_cost ELSE 0 END ) AS COST, SUM ( final_amount ) AS real_amount FROM project_settlement_details where settlement_status in(1,2) GROUP BY project_id, employee_id ) C ON A.project_id = C.project_id AND A.employee_id = C.employee_id LEFT JOIN project_settlement_details AS D ON A.project_id = D.project_id AND A.employee_id = D.employee_id AND d.settlement_status = 1 LEFT JOIN projects P ON A.project_id = P.project_id LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE A.project_id =:project_id AND A.employee_id =:employee_id and A.status = 2";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.project_id =:project_id AND A.employee_id =:employee_id\",\"startIndex\": 1487,\"stopIndex\":1543,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.project_id =:project_id\",\"fullFieldName\":\"A.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 1487,\"stopIndex\":1511,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.employee_id =:employee_id\",\"fullFieldName\":\"A.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1517,\"stopIndex\":1543,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,project_manage_id,sheet_code,sheet_name,employee_id,employee_no,employee_name,real_amount,sure_integral,cost,project_cost,final_amount,status,work_content,flag,settlement_detail_id";
	private final static String[] fieldNames = { "project_id", "employee_id"};
}
