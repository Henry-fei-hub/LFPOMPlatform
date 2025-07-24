package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeGradeTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeGradeTotalByDepartment;

public class QueryReportOnEmployeeGradeTotalByDepartment extends AbstractQuery<BaseReportOnEmployeeGradeTotalByDepartment, ConditionReportOnEmployeeGradeTotalByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeGradeTotalByDepartment.class);

	public QueryReportOnEmployeeGradeTotalByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("B.department_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeGradeTotalByDepartment> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeGradeTotalByDepartment condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getStatus(), 
				condition.getPlateId()
			);
	}

	public BaseCollection<BaseReportOnEmployeeGradeTotalByDepartment> runQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeGradeTotalByDepartment condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getStatus(), 
				condition.getPlateId()
			);
	}

	public BaseCollection<BaseReportOnEmployeeGradeTotalByDepartment> execute( KeyValuePair[] replacements, ConditionReportOnEmployeeGradeTotalByDepartment condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getStatus(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOnEmployeeGradeTotalByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeGradeTotalByDepartment __base = new BaseReportOnEmployeeGradeTotalByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setA1(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA2(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA3(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA4(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA5(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA6(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA7(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA8(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA9(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA10(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA11(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA12(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA13(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA14(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA15(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA16(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA17(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA18(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA19(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setA20(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB1(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB2(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB3(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB4(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB5(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB6(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB7(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB8(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB9(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB10(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB11(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB12(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB13(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB14(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB15(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB16(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB17(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB18(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB19(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setB20(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC1(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC2(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC3(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC4(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC5(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC6(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC7(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC8(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC9(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC10(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC11(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC12(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC13(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC14(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC15(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC16(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC17(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC18(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC19(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setC20(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOtherNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum(GenericBase.__getLong(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "SELECT B.department_id, A.YEAR, SUM ( CASE WHEN grade_id = 1 THEN 1 ELSE 0 END ) AS A1, SUM ( CASE WHEN grade_id = 2 THEN 1 ELSE 0 END ) AS A2, SUM ( CASE WHEN grade_id = 3 THEN 1 ELSE 0 END ) AS A3, SUM ( CASE WHEN grade_id = 4 THEN 1 ELSE 0 END ) AS A4, SUM ( CASE WHEN grade_id = 5 THEN 1 ELSE 0 END ) AS A5, SUM ( CASE WHEN grade_id = 6 THEN 1 ELSE 0 END ) AS A6, SUM ( CASE WHEN grade_id = 7 THEN 1 ELSE 0 END ) AS A7, SUM ( CASE WHEN grade_id = 8 THEN 1 ELSE 0 END ) AS A8, SUM ( CASE WHEN grade_id = 9 THEN 1 ELSE 0 END ) AS A9, SUM ( CASE WHEN grade_id = 10 THEN 1 ELSE 0 END ) AS A10, SUM ( CASE WHEN grade_id = 11 THEN 1 ELSE 0 END ) AS A11, SUM ( CASE WHEN grade_id = 12 THEN 1 ELSE 0 END ) AS A12, SUM ( CASE WHEN grade_id = 13 THEN 1 ELSE 0 END ) AS A13, SUM ( CASE WHEN grade_id = 14 THEN 1 ELSE 0 END ) AS A14, SUM ( CASE WHEN grade_id = 15 THEN 1 ELSE 0 END ) AS A15, SUM ( CASE WHEN grade_id = 16 THEN 1 ELSE 0 END ) AS A16, SUM ( CASE WHEN grade_id = 17 THEN 1 ELSE 0 END ) AS A17, SUM ( CASE WHEN grade_id = 18 THEN 1 ELSE 0 END ) AS A18, SUM ( CASE WHEN grade_id = 19 THEN 1 ELSE 0 END ) AS A19, SUM ( CASE WHEN grade_id = 20 THEN 1 ELSE 0 END ) AS A20, SUM ( CASE WHEN grade_id = 21 THEN 1 ELSE 0 END ) AS B1, SUM ( CASE WHEN grade_id = 22 THEN 1 ELSE 0 END ) AS B2, SUM ( CASE WHEN grade_id = 23 THEN 1 ELSE 0 END ) AS B3, SUM ( CASE WHEN grade_id = 24 THEN 1 ELSE 0 END ) AS B4, SUM ( CASE WHEN grade_id = 25 THEN 1 ELSE 0 END ) AS B5, SUM ( CASE WHEN grade_id = 26 THEN 1 ELSE 0 END ) AS B6, SUM ( CASE WHEN grade_id = 27 THEN 1 ELSE 0 END ) AS B7, SUM ( CASE WHEN grade_id = 28 THEN 1 ELSE 0 END ) AS B8, SUM ( CASE WHEN grade_id = 29 THEN 1 ELSE 0 END ) AS B9, SUM ( CASE WHEN grade_id = 30 THEN 1 ELSE 0 END ) AS B10, SUM ( CASE WHEN grade_id = 31 THEN 1 ELSE 0 END ) AS B11, SUM ( CASE WHEN grade_id = 32 THEN 1 ELSE 0 END ) AS B12, SUM ( CASE WHEN grade_id = 33 THEN 1 ELSE 0 END ) AS B13, SUM ( CASE WHEN grade_id = 34 THEN 1 ELSE 0 END ) AS B14, SUM ( CASE WHEN grade_id = 35 THEN 1 ELSE 0 END ) AS B15, SUM ( CASE WHEN grade_id = 36 THEN 1 ELSE 0 END ) AS B16, SUM ( CASE WHEN grade_id = 37 THEN 1 ELSE 0 END ) AS B17, SUM ( CASE WHEN grade_id = 38 THEN 1 ELSE 0 END ) AS B18, SUM ( CASE WHEN grade_id = 39 THEN 1 ELSE 0 END ) AS B19, SUM ( CASE WHEN grade_id = 40 THEN 1 ELSE 0 END ) AS B20, SUM ( CASE WHEN grade_id = 41 THEN 1 ELSE 0 END ) AS C1, SUM ( CASE WHEN grade_id = 42 THEN 1 ELSE 0 END ) AS C2, SUM ( CASE WHEN grade_id = 43 THEN 1 ELSE 0 END ) AS C3, SUM ( CASE WHEN grade_id = 44 THEN 1 ELSE 0 END ) AS C4, SUM ( CASE WHEN grade_id = 45 THEN 1 ELSE 0 END ) AS C5, SUM ( CASE WHEN grade_id = 46 THEN 1 ELSE 0 END ) AS C6, SUM ( CASE WHEN grade_id = 47 THEN 1 ELSE 0 END ) AS C7, SUM ( CASE WHEN grade_id = 48 THEN 1 ELSE 0 END ) AS C8, SUM ( CASE WHEN grade_id = 49 THEN 1 ELSE 0 END ) AS C9, SUM ( CASE WHEN grade_id = 50 THEN 1 ELSE 0 END ) AS C10, SUM ( CASE WHEN grade_id = 51 THEN 1 ELSE 0 END ) AS C11, SUM ( CASE WHEN grade_id = 52 THEN 1 ELSE 0 END ) AS C12, SUM ( CASE WHEN grade_id = 53 THEN 1 ELSE 0 END ) AS C13, SUM ( CASE WHEN grade_id = 54 THEN 1 ELSE 0 END ) AS C14, SUM ( CASE WHEN grade_id = 55 THEN 1 ELSE 0 END ) AS C15, SUM ( CASE WHEN grade_id = 56 THEN 1 ELSE 0 END ) AS C16, SUM ( CASE WHEN grade_id = 57 THEN 1 ELSE 0 END ) AS C17, SUM ( CASE WHEN grade_id = 58 THEN 1 ELSE 0 END ) AS C18, SUM ( CASE WHEN grade_id = 59 THEN 1 ELSE 0 END ) AS C19, SUM ( CASE WHEN grade_id = 60 THEN 1 ELSE 0 END ) AS C20, SUM ( CASE WHEN grade_id IS NULL OR grade_id > 60 OR grade_id < 1 THEN 1 ELSE 0 END ) AS other_num, SUM ( 1 ) AS total_num FROM ( SELECT DISTINCT employee_id, plate_id, department_id, YEAR, MONTH FROM employee_day_plate_records WHERE YEAR = ? and MONTH = ? ) AS A LEFT JOIN plate_departments B ON A.department_id = B.department_id LEFT JOIN ( SELECT employee_id, plate_id, department_id, birth, status, grade_id FROM employees WHERE employee_id > 0 ) AS C ON C.employee_id = A.employee_id WHERE B.plate_id > 0 and C.status = ? and B.plate_id = ? GROUP BY B.department_id, A.YEAR ORDER BY B.department_id, A.YEAR" ;
	private final static String __originalSQL = "SELECT B.department_id, A.YEAR, SUM ( CASE WHEN grade_id = 1 THEN 1 ELSE 0 END ) AS A1, SUM ( CASE WHEN grade_id = 2 THEN 1 ELSE 0 END ) AS A2, SUM ( CASE WHEN grade_id = 3 THEN 1 ELSE 0 END ) AS A3, SUM ( CASE WHEN grade_id = 4 THEN 1 ELSE 0 END ) AS A4, SUM ( CASE WHEN grade_id = 5 THEN 1 ELSE 0 END ) AS A5, SUM ( CASE WHEN grade_id = 6 THEN 1 ELSE 0 END ) AS A6, SUM ( CASE WHEN grade_id = 7 THEN 1 ELSE 0 END ) AS A7, SUM ( CASE WHEN grade_id = 8 THEN 1 ELSE 0 END ) AS A8, SUM ( CASE WHEN grade_id = 9 THEN 1 ELSE 0 END ) AS A9, SUM ( CASE WHEN grade_id = 10 THEN 1 ELSE 0 END ) AS A10, SUM ( CASE WHEN grade_id = 11 THEN 1 ELSE 0 END ) AS A11, SUM ( CASE WHEN grade_id = 12 THEN 1 ELSE 0 END ) AS A12, SUM ( CASE WHEN grade_id = 13 THEN 1 ELSE 0 END ) AS A13, SUM ( CASE WHEN grade_id = 14 THEN 1 ELSE 0 END ) AS A14, SUM ( CASE WHEN grade_id = 15 THEN 1 ELSE 0 END ) AS A15, SUM ( CASE WHEN grade_id = 16 THEN 1 ELSE 0 END ) AS A16, SUM ( CASE WHEN grade_id = 17 THEN 1 ELSE 0 END ) AS A17, SUM ( CASE WHEN grade_id = 18 THEN 1 ELSE 0 END ) AS A18, SUM ( CASE WHEN grade_id = 19 THEN 1 ELSE 0 END ) AS A19, SUM ( CASE WHEN grade_id = 20 THEN 1 ELSE 0 END ) AS A20, SUM ( CASE WHEN grade_id = 21 THEN 1 ELSE 0 END ) AS B1, SUM ( CASE WHEN grade_id = 22 THEN 1 ELSE 0 END ) AS B2, SUM ( CASE WHEN grade_id = 23 THEN 1 ELSE 0 END ) AS B3, SUM ( CASE WHEN grade_id = 24 THEN 1 ELSE 0 END ) AS B4, SUM ( CASE WHEN grade_id = 25 THEN 1 ELSE 0 END ) AS B5, SUM ( CASE WHEN grade_id = 26 THEN 1 ELSE 0 END ) AS B6, SUM ( CASE WHEN grade_id = 27 THEN 1 ELSE 0 END ) AS B7, SUM ( CASE WHEN grade_id = 28 THEN 1 ELSE 0 END ) AS B8, SUM ( CASE WHEN grade_id = 29 THEN 1 ELSE 0 END ) AS B9, SUM ( CASE WHEN grade_id = 30 THEN 1 ELSE 0 END ) AS B10, SUM ( CASE WHEN grade_id = 31 THEN 1 ELSE 0 END ) AS B11, SUM ( CASE WHEN grade_id = 32 THEN 1 ELSE 0 END ) AS B12, SUM ( CASE WHEN grade_id = 33 THEN 1 ELSE 0 END ) AS B13, SUM ( CASE WHEN grade_id = 34 THEN 1 ELSE 0 END ) AS B14, SUM ( CASE WHEN grade_id = 35 THEN 1 ELSE 0 END ) AS B15, SUM ( CASE WHEN grade_id = 36 THEN 1 ELSE 0 END ) AS B16, SUM ( CASE WHEN grade_id = 37 THEN 1 ELSE 0 END ) AS B17, SUM ( CASE WHEN grade_id = 38 THEN 1 ELSE 0 END ) AS B18, SUM ( CASE WHEN grade_id = 39 THEN 1 ELSE 0 END ) AS B19, SUM ( CASE WHEN grade_id = 40 THEN 1 ELSE 0 END ) AS B20, SUM ( CASE WHEN grade_id = 41 THEN 1 ELSE 0 END ) AS C1, SUM ( CASE WHEN grade_id = 42 THEN 1 ELSE 0 END ) AS C2, SUM ( CASE WHEN grade_id = 43 THEN 1 ELSE 0 END ) AS C3, SUM ( CASE WHEN grade_id = 44 THEN 1 ELSE 0 END ) AS C4, SUM ( CASE WHEN grade_id = 45 THEN 1 ELSE 0 END ) AS C5, SUM ( CASE WHEN grade_id = 46 THEN 1 ELSE 0 END ) AS C6, SUM ( CASE WHEN grade_id = 47 THEN 1 ELSE 0 END ) AS C7, SUM ( CASE WHEN grade_id = 48 THEN 1 ELSE 0 END ) AS C8, SUM ( CASE WHEN grade_id = 49 THEN 1 ELSE 0 END ) AS C9, SUM ( CASE WHEN grade_id = 50 THEN 1 ELSE 0 END ) AS C10, SUM ( CASE WHEN grade_id = 51 THEN 1 ELSE 0 END ) AS C11, SUM ( CASE WHEN grade_id = 52 THEN 1 ELSE 0 END ) AS C12, SUM ( CASE WHEN grade_id = 53 THEN 1 ELSE 0 END ) AS C13, SUM ( CASE WHEN grade_id = 54 THEN 1 ELSE 0 END ) AS C14, SUM ( CASE WHEN grade_id = 55 THEN 1 ELSE 0 END ) AS C15, SUM ( CASE WHEN grade_id = 56 THEN 1 ELSE 0 END ) AS C16, SUM ( CASE WHEN grade_id = 57 THEN 1 ELSE 0 END ) AS C17, SUM ( CASE WHEN grade_id = 58 THEN 1 ELSE 0 END ) AS C18, SUM ( CASE WHEN grade_id = 59 THEN 1 ELSE 0 END ) AS C19, SUM ( CASE WHEN grade_id = 60 THEN 1 ELSE 0 END ) AS C20, SUM ( CASE WHEN grade_id IS NULL OR grade_id > 60 OR grade_id < 1 THEN 1 ELSE 0 END ) AS other_num, SUM ( 1 ) AS total_num FROM ( SELECT DISTINCT employee_id, plate_id, department_id, YEAR, MONTH FROM employee_day_plate_records WHERE YEAR = :YEAR AND MONTH = :MONTH ) AS A LEFT JOIN plate_departments B ON A.department_id = B.department_id LEFT JOIN ( SELECT employee_id, plate_id, department_id, birth, status, grade_id FROM employees WHERE employee_id > 0 ) AS C ON C.employee_id = A.employee_id WHERE B.plate_id > 0 AND C.status = :status AND B.plate_id = :plate_id GROUP BY B.department_id, A.YEAR ORDER BY B.department_id, A.YEAR";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"YEAR = :YEAR AND MONTH = :MONTH\",\"startIndex\": 3710,\"stopIndex\":3740,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"YEAR = :YEAR\",\"fullFieldName\":\"YEAR\",\"operationName\":\"=\",\"variableName\":\"year\",\"nextToken\":\"and\",\"startIndex\": 3710,\"stopIndex\":3721,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"MONTH = :MONTH\",\"fullFieldName\":\"MONTH\",\"operationName\":\"=\",\"variableName\":\"month\",\"startIndex\": 3727,\"stopIndex\":3740,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"B.plate_id > 0 AND C.status = :status AND B.plate_id = :plate_id\",\"startIndex\": 3980,\"stopIndex\":4043,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"B.plate_id > 0\",\"nextToken\":\"and\",\"startIndex\": 3980,\"stopIndex\":3993,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.status = :status\",\"fullFieldName\":\"C.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"and\",\"startIndex\": 3999,\"stopIndex\":4016,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"B.plate_id = :plate_id\",\"fullFieldName\":\"B.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"startIndex\": 4022,\"stopIndex\":4043,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "department_id,year,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,other_num,total_num";
	private final static String[] fieldNames = { "year", "month", "status", "plate_id"};
}
