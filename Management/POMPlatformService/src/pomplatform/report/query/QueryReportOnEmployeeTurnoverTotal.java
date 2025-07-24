package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeTurnoverTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeTurnoverTotal;

public class QueryReportOnEmployeeTurnoverTotal extends AbstractQuery<BaseReportOnEmployeeTurnoverTotal, ConditionReportOnEmployeeTurnoverTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeTurnoverTotal.class);

	public QueryReportOnEmployeeTurnoverTotal() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("AAA.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeTurnoverTotal> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeTurnoverTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOnEmployeeTurnoverTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeTurnoverTotal __base = new BaseReportOnEmployeeTurnoverTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOneNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum7(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum8(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum9(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum10(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum11(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOneNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeNum12(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourNum12(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "select AAA.plate_id, AAA.year, SUM(CASE WHEN AAA.month = 1 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_1, SUM(CASE WHEN AAA.month = 1 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_1, SUM(CASE WHEN AAA.month = 1 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_1, SUM(CASE WHEN AAA.month = 1 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_1, SUM(CASE WHEN AAA.month = 2 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_2, SUM(CASE WHEN AAA.month = 2 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_2, SUM(CASE WHEN AAA.month = 2 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_2, SUM(CASE WHEN AAA.month = 2 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_2, SUM(CASE WHEN AAA.month = 3 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_3, SUM(CASE WHEN AAA.month = 3 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_3, SUM(CASE WHEN AAA.month = 3 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_3, SUM(CASE WHEN AAA.month = 3 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_3, SUM(CASE WHEN AAA.month = 4 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_4, SUM(CASE WHEN AAA.month = 4 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_4, SUM(CASE WHEN AAA.month = 4 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_4, SUM(CASE WHEN AAA.month = 4 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_4, SUM(CASE WHEN AAA.month = 5 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_5, SUM(CASE WHEN AAA.month = 5 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_5, SUM(CASE WHEN AAA.month = 5 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_5, SUM(CASE WHEN AAA.month = 5 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_5, SUM(CASE WHEN AAA.month = 6 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_6, SUM(CASE WHEN AAA.month = 6 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_6, SUM(CASE WHEN AAA.month = 6 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_6, SUM(CASE WHEN AAA.month = 6 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_6, SUM(CASE WHEN AAA.month = 7 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_7, SUM(CASE WHEN AAA.month = 7 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_7, SUM(CASE WHEN AAA.month = 7 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_7, SUM(CASE WHEN AAA.month = 7 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_7, SUM(CASE WHEN AAA.month = 8 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_8, SUM(CASE WHEN AAA.month = 8 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_8, SUM(CASE WHEN AAA.month = 8 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_8, SUM(CASE WHEN AAA.month = 8 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_8, SUM(CASE WHEN AAA.month = 9 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_9, SUM(CASE WHEN AAA.month = 9 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_9, SUM(CASE WHEN AAA.month = 9 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_9, SUM(CASE WHEN AAA.month = 9 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_9, SUM(CASE WHEN AAA.month = 10 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_10, SUM(CASE WHEN AAA.month = 10 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_10, SUM(CASE WHEN AAA.month = 10 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_10, SUM(CASE WHEN AAA.month = 10 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_10, SUM(CASE WHEN AAA.month = 11 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_11, SUM(CASE WHEN AAA.month = 11 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_11, SUM(CASE WHEN AAA.month = 11 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_11, SUM(CASE WHEN AAA.month = 11 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_11, SUM(CASE WHEN AAA.month = 12 and AAA.type = 1 THEN AAA.total_num else 0 END ) AS one_num_12, SUM(CASE WHEN AAA.month = 12 and AAA.type = 2 THEN AAA.total_num else 0 END) AS two_num_12, SUM(CASE WHEN AAA.month = 12 and AAA.type = 3 THEN AAA.total_num else 0 END) AS three_num_12, SUM(CASE WHEN AAA.month = 12 and AAA.type = 4 THEN AAA.total_num else 0 END) AS four_num_12 from ( ( select B.plate_id, A.year, A.month, 1 as type , sum(1) as total_num from (select employee_id ,plate_id ,department_id ,year,month from employee_day_plate_records where year =? and employee_day_plate_record_id in( select min(employee_day_plate_record_id) from employee_day_plate_records GROUP BY employee_id) order by employee_id) as A left join plate_departments B on A.department_id = B.department_id left join (select employee_id,plate_id ,department_id,status,onboard_date,resignation_date from employees where employee_id >0) as C on C.employee_id =A.employee_id where B.plate_id >0 and C.status=0 and B.plate_id=? GROUP BY B.plate_id, A.year, A.month order by B.plate_id, A.year,A.month ) UNION All ( SELECT AA.plate_id, AA.YEAR, AA.MONTH, 2 AS TYPE, SUM ( 1 ) AS total_num FROM ( SELECT B.employee_id, C.plate_id, EXTRACT ( YEAR FROM A.complete_time ) AS YEAR, EXTRACT ( MONTH FROM A.complete_time ) AS MONTH FROM system_process_instances AS A LEFT JOIN personnel_business AS B ON B.personnel_business_id = A.business_id LEFT JOIN plate_departments C ON C.department_id = B.department_id WHERE A.process_type = 25 AND A.process_status = 3 ) AS AA WHERE AA.YEAR =? AND AA.plate_id > 0 AND AA.plate_id =month GROUP BY AA.plate_id, AA.YEAR, AA.MONTH ) UNION All ( select AA.plate_id, AA.year, AA.month, 3 as type , sum(1) as total_num from ( select B.employee_id , C.plate_id ,extract(year from A.complete_time) as year ,extract(month from A.complete_time) as month from system_process_instances as A left join personnel_business as B on B.personnel_business_id = A.business_id left join plate_departments C on C.department_id = B.department_id where A.process_type = 26 and A.process_status =3 ) as AA where AA.year =? and AA.plate_id >0 and AA.plate_id =? GROUP BY AA.plate_id, AA.year, AA.month ) UNION All ( select AA.plate_id, AA.year, AA.month, 4 as type , sum(1) as total_num from ( select B.employee_id , C.plate_id ,extract(year from A.complete_time) as year ,extract(month from A.complete_time) as month from system_process_instances as A left join personnel_business as B on B.personnel_business_id = A.business_id left join plate_departments C on C.department_id = B.parent_id where A.process_type = 26 and A.process_status =3 ) as AA where AA.year =? and AA.plate_id >0 and AA.plate_id =? GROUP BY AA.plate_id, AA.year, AA.month )) as AAA where AAA.plate_id =? GROUP BY AAA.plate_id, AAA.year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,one_num_1,two_num_1,three_num_1,four_num_1,one_num_2,two_num_2,three_num_2,four_num_2,one_num_3,two_num_3,three_num_3,four_num_3,one_num_4,two_num_4,three_num_4,four_num_4,one_num_5,two_num_5,three_num_5,four_num_5,one_num_6,two_num_6,three_num_6,four_num_6,one_num_7,two_num_7,three_num_7,four_num_7,one_num_8,two_num_8,three_num_8,four_num_8,one_num_9,two_num_9,three_num_9,four_num_9,one_num_10,two_num_10,three_num_10,four_num_10,one_num_11,two_num_11,three_num_11,four_num_11,one_num_12,two_num_12,three_num_12,four_num_12";
	private final static String[] fieldNames = { "year", "plate_id", "year", "year", "plate_id", "year", "plate_id", "plate_id"};
}
