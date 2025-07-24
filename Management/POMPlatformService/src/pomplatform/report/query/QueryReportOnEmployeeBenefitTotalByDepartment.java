package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeBenefitTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeBenefitTotalByDepartment;

public class QueryReportOnEmployeeBenefitTotalByDepartment extends AbstractQuery<BaseReportOnEmployeeBenefitTotalByDepartment, ConditionReportOnEmployeeBenefitTotalByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeBenefitTotalByDepartment.class);

	public QueryReportOnEmployeeBenefitTotalByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pd.department_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeBenefitTotalByDepartment> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeBenefitTotalByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOnEmployeeBenefitTotalByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeBenefitTotalByDepartment __base = new BaseReportOnEmployeeBenefitTotalByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOneNum1(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum1(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum1(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum2(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum2(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum2(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum3(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum3(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum3(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum4(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum4(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum4(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum5(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum5(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum5(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum6(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum6(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum6(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum7(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum7(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum7(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum8(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum8(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum8(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum9(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum9(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum9(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum10(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum10(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum10(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum11(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum11(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum11(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneNum12(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoNum12(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum12(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT pd.department_id, B.YEAR, SUM ( CASE WHEN AAA.MONTH = 1 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num1, SUM ( CASE WHEN AAA.MONTH = 1 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num1, SUM ( CASE WHEN AAA.MONTH = 1 THEN 1 ELSE 0 END ) AS total_num1, SUM ( CASE WHEN AAA.MONTH = 2 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num2, SUM ( CASE WHEN AAA.MONTH = 2 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num2, SUM ( CASE WHEN AAA.MONTH = 2 THEN 1 ELSE 0 END ) AS total_num2, SUM ( CASE WHEN AAA.MONTH = 3 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num3, SUM ( CASE WHEN AAA.MONTH = 3 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num3, SUM ( CASE WHEN AAA.MONTH = 3 THEN 1 ELSE 0 END ) AS total_num3, SUM ( CASE WHEN AAA.MONTH = 4 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num4, SUM ( CASE WHEN AAA.MONTH = 4 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num4, SUM ( CASE WHEN AAA.MONTH = 4 THEN 1 ELSE 0 END ) AS total_num4, SUM ( CASE WHEN AAA.MONTH = 5 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num5, SUM ( CASE WHEN AAA.MONTH = 5 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num5, SUM ( CASE WHEN AAA.MONTH = 5 THEN 1 ELSE 0 END ) AS total_num5, SUM ( CASE WHEN AAA.MONTH = 6 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num6, SUM ( CASE WHEN AAA.MONTH = 6 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num6, SUM ( CASE WHEN AAA.MONTH = 6 THEN 1 ELSE 0 END ) AS total_num6, SUM ( CASE WHEN AAA.MONTH = 7 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num7, SUM ( CASE WHEN AAA.MONTH = 7 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num7, SUM ( CASE WHEN AAA.MONTH = 7 THEN 1 ELSE 0 END ) AS total_num7, SUM ( CASE WHEN AAA.MONTH = 8 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num8, SUM ( CASE WHEN AAA.MONTH = 8 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num8, SUM ( CASE WHEN AAA.MONTH = 8 THEN 1 ELSE 0 END ) AS total_num8, SUM ( CASE WHEN AAA.MONTH = 9 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num9, SUM ( CASE WHEN AAA.MONTH = 9 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num9, SUM ( CASE WHEN AAA.MONTH = 9 THEN 1 ELSE 0 END ) AS total_num9, SUM ( CASE WHEN AAA.MONTH = 10 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num10, SUM ( CASE WHEN AAA.MONTH = 10 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num10, SUM ( CASE WHEN AAA.MONTH = 10 THEN 1 ELSE 0 END ) AS total_num10, SUM ( CASE WHEN AAA.MONTH = 11 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num11, SUM ( CASE WHEN AAA.MONTH = 11 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num11, SUM ( CASE WHEN AAA.MONTH = 11 THEN 1 ELSE 0 END ) AS total_num11, SUM ( CASE WHEN AAA.MONTH = 12 AND AAA.benefit < 1 THEN 1 ELSE 0 END ) AS one_num12, SUM ( CASE WHEN AAA.MONTH = 12 AND AAA.benefit >= 1 THEN 1 ELSE 0 END ) AS two_num12, SUM ( CASE WHEN AAA.MONTH = 12 THEN 1 ELSE 0 END ) AS total_num12 FROM ( SELECT DISTINCT employee_id, plate_id, department_id, YEAR, MONTH FROM employee_day_plate_records WHERE YEAR =? ) AS B LEFT JOIN ( SELECT AA.employee_id, AA.YEAR, AA.MONTH, e.plate_id, e.department_id, ( AA.integral - AA.project_cost ) / AA.employee_cost AS benefit FROM ( SELECT A .employee_id, A.YEAR, A.MONTH, SUM ( CASE WHEN A.business_type_id = 1 OR A.business_type_id = 4 THEN A.integral ELSE 0 END ) AS integral, SUM ( CASE WHEN A.business_type_id = 7 THEN A.integral ELSE 0 END ) AS project_cost, SUM ( CASE WHEN A.business_type_id = 6 THEN A.integral ELSE 0 END ) AS employee_cost FROM ( SELECT employee_id, SUM ( integral ) AS integral, business_type_id, EXTRACT ( YEAR FROM record_date ) AS YEAR, EXTRACT ( MONTH FROM record_date ) AS MONTH FROM employee_account_records WHERE EXTRACT ( YEAR FROM record_date ) =? GROUP BY employee_id, business_type_id, EXTRACT ( YEAR FROM record_date ), EXTRACT ( MONTH FROM record_date ) ORDER BY employee_id, business_type_id ) AS A GROUP BY A.employee_id, A.YEAR, A.MONTH ) AS AA LEFT JOIN employees e ON e.employee_id = AA.employee_id WHERE AA.employee_id > 0 AND AA.employee_cost > 0 ) AS AAA ON AAA.employee_id = B.employee_id AND AAA.MONTH = B. MONTH LEFT JOIN plate_departments pd ON B.department_id = pd.department_id WHERE pd.plate_id > 0 AND AAA.employee_id > 0 AND pd.plate_id =? GROUP BY pd.department_id, B.YEAR" ;
	private final static String RESULTSETFIELDLIST = "department_id,year,one_num1,two_num1,total_num1,one_num2,two_num2,total_num2,one_num3,two_num3,total_num3,one_num4,two_num4,total_num4,one_num5,two_num5,total_num5,one_num6,two_num6,total_num6,one_num7,two_num7,total_num7,one_num8,two_num8,total_num8,one_num9,two_num9,total_num9,one_num10,two_num10,total_num10,one_num11,two_num11,total_num11,one_num12,two_num12,total_num12";
	private final static String[] fieldNames = { "year", "year", "plate_id"};
}
