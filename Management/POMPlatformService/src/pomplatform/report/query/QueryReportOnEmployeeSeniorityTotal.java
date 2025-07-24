package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeSeniorityTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeSeniorityTotal;

public class QueryReportOnEmployeeSeniorityTotal extends AbstractQuery<BaseReportOnEmployeeSeniorityTotal, ConditionReportOnEmployeeSeniorityTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeSeniorityTotal.class);

	public QueryReportOnEmployeeSeniorityTotal() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("AA.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeSeniorityTotal> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeSeniorityTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPalteId()
			);
	}

	@Override
	public BaseReportOnEmployeeSeniorityTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeSeniorityTotal __base = new BaseReportOnEmployeeSeniorityTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOneNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveNum12(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT AA.plate_id, AA.YEAR, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.one_num ELSE 0 END ) AS one_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.two_num ELSE 0 END ) AS two_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.three_num ELSE 0 END ) AS three_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.four_num ELSE 0 END ) AS four_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.five_num ELSE 0 END ) AS five_num_1, SUM ( CASE WHEN AA.MONTH = 1 THEN AA.total_num ELSE 0 END ) AS total_num_1, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.one_num ELSE 0 END ) AS one_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.two_num ELSE 0 END ) AS two_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.three_num ELSE 0 END ) AS three_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.four_num ELSE 0 END ) AS four_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.five_num ELSE 0 END ) AS five_num_2, SUM ( CASE WHEN AA.MONTH = 2 THEN AA.total_num ELSE 0 END ) AS total_num_2, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.one_num ELSE 0 END ) AS one_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.two_num ELSE 0 END ) AS two_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.three_num ELSE 0 END ) AS three_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.four_num ELSE 0 END ) AS four_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.five_num ELSE 0 END ) AS five_num_3, SUM ( CASE WHEN AA.MONTH = 3 THEN AA.total_num ELSE 0 END ) AS total_num_3, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.one_num ELSE 0 END ) AS one_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.two_num ELSE 0 END ) AS two_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.three_num ELSE 0 END ) AS three_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.four_num ELSE 0 END ) AS four_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.five_num ELSE 0 END ) AS five_num_4, SUM ( CASE WHEN AA.MONTH = 4 THEN AA.total_num ELSE 0 END ) AS total_num_4, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.one_num ELSE 0 END ) AS one_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.two_num ELSE 0 END ) AS two_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.three_num ELSE 0 END ) AS three_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.four_num ELSE 0 END ) AS four_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.five_num ELSE 0 END ) AS five_num_5, SUM ( CASE WHEN AA.MONTH = 5 THEN AA.total_num ELSE 0 END ) AS total_num_5, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.one_num ELSE 0 END ) AS one_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.two_num ELSE 0 END ) AS two_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.three_num ELSE 0 END ) AS three_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.four_num ELSE 0 END ) AS four_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.five_num ELSE 0 END ) AS five_num_6, SUM ( CASE WHEN AA.MONTH = 6 THEN AA.total_num ELSE 0 END ) AS total_num_6, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.one_num ELSE 0 END ) AS one_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.two_num ELSE 0 END ) AS two_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.three_num ELSE 0 END ) AS three_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.four_num ELSE 0 END ) AS four_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.five_num ELSE 0 END ) AS five_num_7, SUM ( CASE WHEN AA.MONTH = 7 THEN AA.total_num ELSE 0 END ) AS total_num_7, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.one_num ELSE 0 END ) AS one_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.two_num ELSE 0 END ) AS two_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.three_num ELSE 0 END ) AS three_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.four_num ELSE 0 END ) AS four_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.five_num ELSE 0 END ) AS five_num_8, SUM ( CASE WHEN AA.MONTH = 8 THEN AA.total_num ELSE 0 END ) AS total_num_8, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.one_num ELSE 0 END ) AS one_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.two_num ELSE 0 END ) AS two_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.three_num ELSE 0 END ) AS three_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.four_num ELSE 0 END ) AS four_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.five_num ELSE 0 END ) AS five_num_9, SUM ( CASE WHEN AA.MONTH = 9 THEN AA.total_num ELSE 0 END ) AS total_num_9, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.one_num ELSE 0 END ) AS one_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.two_num ELSE 0 END ) AS two_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.three_num ELSE 0 END ) AS three_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.four_num ELSE 0 END ) AS four_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.five_num ELSE 0 END ) AS five_num_10, SUM ( CASE WHEN AA.MONTH = 10 THEN AA.total_num ELSE 0 END ) AS total_num_10, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.one_num ELSE 0 END ) AS one_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.two_num ELSE 0 END ) AS two_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.three_num ELSE 0 END ) AS three_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.four_num ELSE 0 END ) AS four_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.five_num ELSE 0 END ) AS five_num_11, SUM ( CASE WHEN AA.MONTH = 11 THEN AA.total_num ELSE 0 END ) AS total_num_11, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.one_num ELSE 0 END ) AS one_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.two_num ELSE 0 END ) AS two_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.three_num ELSE 0 END ) AS three_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.four_num ELSE 0 END ) AS four_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.five_num ELSE 0 END ) AS five_num_12, SUM ( CASE WHEN AA.MONTH = 12 THEN AA.total_num ELSE 0 END ) AS total_num_12 FROM ( SELECT B.plate_id, A.YEAR, A.MONTH, SUM ( CASE WHEN date_part( 'year', CURRENT_DATE :: TIMESTAMP - C.start_work_date :: TIMESTAMP ) <= 3 THEN 1 ELSE 0 END ) AS one_num, SUM ( CASE WHEN date_part( 'year', CURRENT_DATE :: TIMESTAMP - C.start_work_date :: TIMESTAMP ) <= 5 AND date_part( 'year', CURRENT_DATE :: TIMESTAMP - C.start_work_date :: TIMESTAMP ) > 3 THEN 1 ELSE 0 END ) AS two_num, SUM ( CASE WHEN date_part( 'year', CURRENT_DATE :: TIMESTAMP - C.start_work_date :: TIMESTAMP ) <= 10 AND date_part( 'year', CURRENT_DATE :: TIMESTAMP - C.start_work_date :: TIMESTAMP ) > 5 THEN 1 ELSE 0 END ) AS three_num, SUM ( CASE WHEN date_part( 'year', CURRENT_DATE :: TIMESTAMP - C.start_work_date :: TIMESTAMP ) > 10 THEN 1 ELSE 0 END ) AS four_num, SUM ( CASE WHEN C.start_work_date IS NULL THEN 1 ELSE 0 END ) AS five_num, SUM ( 1 ) AS total_num FROM employee_day_plate_records A LEFT JOIN plate_departments B ON B.department_id = A.department_id LEFT JOIN employees C ON A.employee_id = C.employee_id WHERE YEAR =? AND B.plate_id >= 0 AND B.plate_id =? AND record_date = date_trunc( 'day', date_trunc( 'month', record_date + INTERVAL '1 month' ) + INTERVAL '-1 day' ) AND A.onboard_status IN ( 1, 2 ) AND A.record_date <= ( CASE WHEN C.resignation_date IS NULL THEN now() ELSE C.resignation_date END ) GROUP BY B.plate_id, A.YEAR, A.MONTH ORDER BY B.plate_id, A.YEAR, A.MONTH ) AS AA GROUP BY AA.plate_id, AA.YEAR ORDER BY AA.plate_id, AA.YEAR" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,one_num_1,two_num_1,three_num_1,four_num_1,five_num_1,total_num_1,one_num_2,two_num_2,three_num_2,four_num_2,five_num_2,total_num_2,one_num_3,two_num_3,three_num_3,four_num_3,five_num_3,total_num_3,one_num_4,two_num_4,three_num_4,four_num_4,five_num_4,total_num_4,one_num_5,two_num_5,three_num_5,four_num_5,five_num_5,total_num_5,one_num_6,two_num_6,three_num_6,four_num_6,five_num_6,total_num_6,one_num_7,two_num_7,three_num_7,four_num_7,five_num_7,total_num_7,one_num_8,two_num_8,three_num_8,four_num_8,five_num_8,total_num_8,one_num_9,two_num_9,three_num_9,four_num_9,five_num_9,total_num_9,one_num_10,two_num_10,three_num_10,four_num_10,five_num_10,total_num_10,one_num_11,two_num_11,three_num_11,four_num_11,five_num_11,total_num_11,one_num_12,two_num_12,three_num_12,four_num_12,five_num_12,total_num_12";
	private final static String[] fieldNames = { "year", "palte_id"};
}
