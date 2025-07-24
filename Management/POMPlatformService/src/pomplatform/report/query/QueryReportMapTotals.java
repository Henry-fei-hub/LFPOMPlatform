package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportMapTotals;
import pomplatform.report.bean.ConditionReportMapTotals;

public class QueryReportMapTotals extends AbstractQuery<BaseReportMapTotals, ConditionReportMapTotals>
{

	private static final Logger __logger = Logger.getLogger(QueryReportMapTotals.class);

	public QueryReportMapTotals() throws java.sql.SQLException
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.project_code AS project_code");
	}

	@Override
	public BaseCollection<BaseReportMapTotals> executeQuery( KeyValuePair[] replacements, ConditionReportMapTotals condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements,
				condition.getProjectName(),
				condition.getProjectCode(),
				condition.getEmployeeId(),
				condition.getPlateId()
		);
	}

	public BaseCollection<BaseReportMapTotals> runQuery( KeyValuePair[] replacements, ConditionReportMapTotals condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements,
				condition.getProjectName(),
				condition.getProjectCode(),
				condition.getEmployeeId(),
				condition.getPlateId()
		);
	}

	public BaseCollection<BaseReportMapTotals> execute( KeyValuePair[] replacements, ConditionReportMapTotals condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements,
				condition.getProjectName(),
				condition.getProjectCode(),
				condition.getEmployeeId(),
				condition.getPlateId()
		);
	}

	@Override
	public BaseReportMapTotals generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportMapTotals __base = new BaseReportMapTotals();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMapType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMapVersion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT pb.project_code AS project_code, pb.project_name AS project_name, e.employee_name AS employee_name, pr.plate_name AS department_name, sd1.dic_type_value AS map_type, ps.special_name AS special_name, sd2.dic_type_value AS map_version, pb.start_date AS start_date, pb.remark AS remark , spi.process_id AS process_id, spi.process_instance_id AS process_instance_id, spi.process_type AS process_type FROM personnel_business pb, employees e, departments d, system_dictionary sd1, system_dictionary sd2, pm_specials ps, system_process_instances spi, plate_records pr WHERE pb.project_name like ? and pb.project_code like ? and e.employee_id = ? and pr.plate_id = ? and pb.employee_id = e.employee_id and pb.department_id = d.department_id and pb.process_type = 78 and sd1.dic_type_id = '239' and sd2.dic_type_id = '242' and pb.TYPE = sd1.dic_type_value_id and pb.project_type = ps.pm_special_id and pb.start_date_detail = sd2.dic_type_value_id and pb.personnel_business_id = spi.business_id and spi.process_type = 78 and spi.process_status = 3 and d.plate_id = pr.plate_id ORDER BY pb.start_date desc" ;
	private final static String __originalSQL = "SELECT pb.project_code AS project_code, pb.project_name AS project_name, e.employee_name AS employee_name, pr.plate_name AS department_name, sd1.dic_type_value AS map_type, ps.special_name AS special_name, sd2.dic_type_value AS map_version, pb.start_date AS start_date, pb.remark AS remark , spi.process_id AS process_id, spi.process_instance_id AS process_instance_id, spi.process_type AS process_type FROM personnel_business pb, employees e, departments d, system_dictionary sd1, system_dictionary sd2, pm_specials ps, system_process_instances spi, plate_records pr WHERE pb.project_name like :project_name and pb.project_code like :project_code and e.employee_id = :employee_id and pr.plate_id = :plate_id and pb.employee_id = e.employee_id AND pb.department_id = d.department_id AND pb.process_type = 78 AND sd1.dic_type_id = '239' AND sd2.dic_type_id = '242' AND pb.TYPE = sd1.dic_type_value_id AND pb.project_type = ps.pm_special_id AND pb.start_date_detail = sd2.dic_type_value_id AND pb.personnel_business_id = spi.business_id AND spi.process_type = 78 AND spi.process_status = 3 AND d.plate_id = pr.plate_id ORDER BY pb.start_date desc";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"pb.project_name like :project_name and pb.project_code like :project_code and e.employee_id = :employee_id and pr.plate_id = :plate_id and pb.employee_id = e.employee_id AND pb.department_id = d.department_id AND pb.process_type = 78 AND sd1.dic_type_id = '239' AND sd2.dic_type_id = '242' AND pb.TYPE = sd1.dic_type_value_id AND pb.project_type = ps.pm_special_id AND pb.start_date_detail = sd2.dic_type_value_id AND pb.personnel_business_id = spi.business_id AND spi.process_type = 78 AND spi.process_status = 3 AND d.plate_id = pr.plate_id\",\"startIndex\": 574,\"stopIndex\":1115,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pb.project_name like :project_name\",\"fullFieldName\":\"pb.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 574,\"stopIndex\":607,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.project_code like :project_code\",\"fullFieldName\":\"pb.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 613,\"stopIndex\":646,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.employee_id = :employee_id\",\"fullFieldName\":\"e.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 652,\"stopIndex\":679,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pr.plate_id = :plate_id\",\"fullFieldName\":\"pr.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 685,\"stopIndex\":707,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.employee_id = e.employee_id\",\"nextToken\":\"and\",\"startIndex\": 713,\"stopIndex\":742,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.department_id = d.department_id\",\"nextToken\":\"and\",\"startIndex\": 748,\"stopIndex\":781,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.process_type = 78\",\"nextToken\":\"and\",\"startIndex\": 787,\"stopIndex\":806,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sd1.dic_type_id = '239'\",\"nextToken\":\"and\",\"startIndex\": 812,\"stopIndex\":834,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sd2.dic_type_id = '242'\",\"nextToken\":\"and\",\"startIndex\": 840,\"stopIndex\":862,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.TYPE = sd1.dic_type_value_id\",\"nextToken\":\"and\",\"startIndex\": 868,\"stopIndex\":898,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.project_type = ps.pm_special_id\",\"nextToken\":\"and\",\"startIndex\": 904,\"stopIndex\":937,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.start_date_detail = sd2.dic_type_value_id\",\"nextToken\":\"and\",\"startIndex\": 943,\"stopIndex\":986,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.personnel_business_id = spi.business_id\",\"nextToken\":\"and\",\"startIndex\": 992,\"stopIndex\":1033,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_type = 78\",\"nextToken\":\"and\",\"startIndex\": 1039,\"stopIndex\":1059,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status = 3\",\"nextToken\":\"and\",\"startIndex\": 1065,\"stopIndex\":1086,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"d.plate_id = pr.plate_id\",\"startIndex\": 1092,\"stopIndex\":1115,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_code,project_name,employee_name,department_name,map_type,special_name,map_version,start_date,remark,process_id,process_instance_id,process_type";
	private final static String[] fieldNames = { "project_name", "project_code", "employee_id", "plate_id"};
}
