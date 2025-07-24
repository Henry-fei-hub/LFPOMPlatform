package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeAgeTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeAgeTotalByDepartment;

public class QueryReportOnEmployeeAgeTotalByDepartment extends AbstractQuery<BaseReportOnEmployeeAgeTotalByDepartment, ConditionReportOnEmployeeAgeTotalByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeAgeTotalByDepartment.class);

	public QueryReportOnEmployeeAgeTotalByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("AA.department_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeAgeTotalByDepartment> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeAgeTotalByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOnEmployeeAgeTotalByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeAgeTotalByDepartment __base = new BaseReportOnEmployeeAgeTotalByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSixNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setZeroNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum12(GenericBase.__getDecimal(val));
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
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT AA.department_id, AA.YEAR, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.six_num ELSE 0 END ) AS six_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.seven_num ELSE 0 END ) AS seven_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.eight_num ELSE 0 END ) AS eight_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.nine_num ELSE 0 END ) AS nine_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.zero_num ELSE 0 END ) AS zero_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.total_num ELSE 0 END ) AS total_num_1, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.six_num ELSE 0 END ) AS six_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.seven_num ELSE 0 END ) AS seven_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.eight_num ELSE 0 END ) AS eight_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.nine_num ELSE 0 END ) AS nine_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.zero_num ELSE 0 END ) AS zero_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.total_num ELSE 0 END ) AS total_num_2, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.six_num ELSE 0 END ) AS six_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.seven_num ELSE 0 END ) AS seven_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.eight_num ELSE 0 END ) AS eight_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.nine_num ELSE 0 END ) AS nine_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.zero_num ELSE 0 END ) AS zero_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.total_num ELSE 0 END ) AS total_num_3, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.six_num ELSE 0 END ) AS six_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.seven_num ELSE 0 END ) AS seven_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.eight_num ELSE 0 END ) AS eight_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.nine_num ELSE 0 END ) AS nine_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.zero_num ELSE 0 END ) AS zero_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.total_num ELSE 0 END ) AS total_num_4, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.six_num ELSE 0 END ) AS six_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.seven_num ELSE 0 END ) AS seven_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.eight_num ELSE 0 END ) AS eight_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.nine_num ELSE 0 END ) AS nine_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.zero_num ELSE 0 END ) AS zero_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.total_num ELSE 0 END ) AS total_num_5, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.six_num ELSE 0 END ) AS six_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.seven_num ELSE 0 END ) AS seven_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.eight_num ELSE 0 END ) AS eight_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.nine_num ELSE 0 END ) AS nine_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.zero_num ELSE 0 END ) AS zero_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.total_num ELSE 0 END ) AS total_num_6, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.six_num ELSE 0 END ) AS six_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.seven_num ELSE 0 END ) AS seven_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.eight_num ELSE 0 END ) AS eight_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.nine_num ELSE 0 END ) AS nine_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.zero_num ELSE 0 END ) AS zero_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.total_num ELSE 0 END ) AS total_num_7, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.six_num ELSE 0 END ) AS six_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.seven_num ELSE 0 END ) AS seven_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.eight_num ELSE 0 END ) AS eight_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.nine_num ELSE 0 END ) AS nine_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.zero_num ELSE 0 END ) AS zero_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.total_num ELSE 0 END ) AS total_num_8, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.six_num ELSE 0 END ) AS six_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.seven_num ELSE 0 END ) AS seven_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.eight_num ELSE 0 END ) AS eight_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.nine_num ELSE 0 END ) AS nine_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.zero_num ELSE 0 END ) AS zero_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.total_num ELSE 0 END ) AS total_num_9, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.six_num ELSE 0 END ) AS six_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.seven_num ELSE 0 END ) AS seven_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.eight_num ELSE 0 END ) AS eight_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.nine_num ELSE 0 END ) AS nine_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.zero_num ELSE 0 END ) AS zero_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.total_num ELSE 0 END ) AS total_num_10, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.six_num ELSE 0 END ) AS six_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.seven_num ELSE 0 END ) AS seven_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.eight_num ELSE 0 END ) AS eight_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.nine_num ELSE 0 END ) AS nine_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.zero_num ELSE 0 END ) AS zero_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.total_num ELSE 0 END ) AS total_num_11, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.six_num ELSE 0 END ) AS six_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.seven_num ELSE 0 END ) AS seven_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.eight_num ELSE 0 END ) AS eight_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.nine_num ELSE 0 END ) AS nine_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.zero_num ELSE 0 END ) AS zero_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.total_num ELSE 0 END ) AS total_num_12 FROM ( SELECT A .department_id, A.YEAR, A.MONTH, SUM ( CASE WHEN C.birth > '1960-01-01' AND C.birth < '1969-12-31' THEN 1 ELSE 0 END ) AS six_num, SUM ( CASE WHEN C.birth > '1970-01-01' AND C.birth < '1979-12-31' THEN 1 ELSE 0 END ) AS seven_num, SUM ( CASE WHEN C.birth > '1980-01-01' AND C.birth < '1989-12-31' THEN 1 ELSE 0 END ) AS eight_num, SUM ( CASE WHEN C.birth > '1990-01-01' AND C.birth < '1999-12-31' THEN 1 ELSE 0 END ) AS nine_num, SUM ( CASE WHEN C.birth > '2000-01-01' AND C.birth < '2009-12-31' THEN 1 ELSE 0 END ) AS zero_num, SUM ( 1 ) AS total_num FROM employee_day_plate_records A LEFT JOIN plate_departments B ON B.department_id = A.department_id LEFT JOIN employees C ON A.employee_id = C.employee_id WHERE YEAR =? AND B.plate_id >= 0 AND B.plate_id =? AND record_date = date_trunc( 'day', date_trunc( 'month', record_date + INTERVAL '1 month' ) + INTERVAL '-1 day' ) AND A.onboard_status IN ( 1, 2 ) AND A.record_date <= ( CASE WHEN C.resignation_date IS NULL THEN now() ELSE C.resignation_date END ) GROUP BY A.department_id, A.YEAR, A.MONTH ORDER BY A.department_id, A.YEAR, A.MONTH ) AS AA GROUP BY AA.department_id, AA.YEAR ORDER BY AA.department_id, AA.YEAR" ;
	private final static String RESULTSETFIELDLIST = "department_id,year,six_num_1,seven_num_1,eight_num_1,nine_num_1,zero_num_1,total_num_1,six_num_2,seven_num_2,eight_num_2,nine_num_2,zero_num_2,total_num_2,six_num_3,seven_num_3,eight_num_3,nine_num_3,zero_num_3,total_num_3,six_num_4,seven_num_4,eight_num_4,nine_num_4,zero_num_4,total_num_4,six_num_5,seven_num_5,eight_num_5,nine_num_5,zero_num_5,total_num_5,six_num_6,seven_num_6,eight_num_6,nine_num_6,zero_num_6,total_num_6,six_num_7,seven_num_7,eight_num_7,nine_num_7,zero_num_7,total_num_7,six_num_8,seven_num_8,eight_num_8,nine_num_8,zero_num_8,total_num_8,six_num_9,seven_num_9,eight_num_9,nine_num_9,zero_num_9,total_num_9,six_num_10,seven_num_10,eight_num_10,nine_num_10,zero_num_10,total_num_10,six_num_11,seven_num_11,eight_num_11,nine_num_11,zero_num_11,total_num_11,six_num_12,seven_num_12,eight_num_12,nine_num_12,zero_num_12,total_num_12";
	private final static String[] fieldNames = { "year", "plate_id"};
}
