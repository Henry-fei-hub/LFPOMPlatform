package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeBenefitTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeBenefitTotal;

public class QueryReportOnEmployeeBenefitTotal extends AbstractQuery<BaseReportOnEmployeeBenefitTotal, ConditionReportOnEmployeeBenefitTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeBenefitTotal.class);

	public QueryReportOnEmployeeBenefitTotal() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pd.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeBenefitTotal> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeBenefitTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOnEmployeeBenefitTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeBenefitTotal __base = new BaseReportOnEmployeeBenefitTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pd.plate_id, B.YEAR, SUM ( CASE WHEN AAA.month =1 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num1, SUM ( CASE WHEN AAA.month =1 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num1, SUM ( CASE WHEN AAA.month =1 THEN 1 ELSE 0 END) AS total_num1 , SUM ( CASE WHEN AAA.month =2 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num2, SUM ( CASE WHEN AAA.month =2 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num2, SUM ( CASE WHEN AAA.month =2 THEN 1 ELSE 0 END) AS total_num2 , SUM ( CASE WHEN AAA.month =3 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num3, SUM ( CASE WHEN AAA.month =3 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num3, SUM ( CASE WHEN AAA.month =3 THEN 1 ELSE 0 END) AS total_num3 , SUM ( CASE WHEN AAA.month =4 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num4, SUM ( CASE WHEN AAA.month =4 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num4, SUM ( CASE WHEN AAA.month =4 THEN 1 ELSE 0 END) AS total_num4 , SUM ( CASE WHEN AAA.month =5 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num5, SUM ( CASE WHEN AAA.month =5 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num5, SUM ( CASE WHEN AAA.month =5 THEN 1 ELSE 0 END) AS total_num5 , SUM ( CASE WHEN AAA.month =6 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num6, SUM ( CASE WHEN AAA.month =6 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num6, SUM ( CASE WHEN AAA.month =6 THEN 1 ELSE 0 END) AS total_num6 , SUM ( CASE WHEN AAA.month =7 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num7, SUM ( CASE WHEN AAA.month =7 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num7, SUM ( CASE WHEN AAA.month =7 THEN 1 ELSE 0 END) AS total_num7 , SUM ( CASE WHEN AAA.month =8 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num8, SUM ( CASE WHEN AAA.month =8 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num8, SUM ( CASE WHEN AAA.month =8 THEN 1 ELSE 0 END) AS total_num8 , SUM ( CASE WHEN AAA.month =9 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num9, SUM ( CASE WHEN AAA.month =9 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num9, SUM ( CASE WHEN AAA.month =9 THEN 1 ELSE 0 END) AS total_num9 , SUM ( CASE WHEN AAA.month =10 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num10, SUM ( CASE WHEN AAA.month =10 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num10, SUM ( CASE WHEN AAA.month =10 THEN 1 ELSE 0 END) AS total_num10 , SUM ( CASE WHEN AAA.month =11 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num11, SUM ( CASE WHEN AAA.month =11 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num11, SUM ( CASE WHEN AAA.month =11 THEN 1 ELSE 0 END) AS total_num11 , SUM ( CASE WHEN AAA.month =12 and AAA.benefit<1 THEN 1 ELSE 0 END ) AS one_num12, SUM ( CASE WHEN AAA.month =12 and AAA.benefit>=1 THEN 1 ELSE 0 END ) AS two_num12, SUM ( CASE WHEN AAA.month =12 THEN 1 ELSE 0 END) AS total_num12 from ( SELECT DISTINCT employee_id, plate_id, department_id, YEAR, MONTH FROM employee_day_plate_records WHERE YEAR =? ) as B left join ( select AA.employee_id, AA.year, AA.month, e.plate_id, e.department_id, (AA.integral-AA.project_cost)/AA.employee_cost as benefit from ( select A.employee_id, A.year, A.month, sum(CASE WHEN A.business_type_id = 1 OR A.business_type_id = 4 THEN A.integral ELSE 0 END ) as integral, sum(CASE WHEN A.business_type_id = 7 THEN A.integral ELSE 0 END ) as project_cost, sum(CASE WHEN A.business_type_id = 6 THEN A.integral ELSE 0 END ) as employee_cost from ( SELECT employee_id, SUM ( integral ) AS integral, business_type_id , EXTRACT ( YEAR FROM record_date ) as year, EXTRACT ( MONTH FROM record_date ) as month FROM employee_account_records WHERE EXTRACT ( YEAR FROM record_date ) =? GROUP BY employee_id, business_type_id , EXTRACT ( YEAR FROM record_date ) , EXTRACT ( MONTH FROM record_date ) ORDER BY employee_id, business_type_id ) as A GROUP BY A.employee_id, A.year, A.month ) as AA left join employees e on e.employee_id = AA.employee_id where AA.employee_id >0 and AA.employee_cost>0 ) as AAA on AAA.employee_id =B.employee_id and AAA.month = B.month left join plate_departments pd on B.department_id = pd.department_id WHERE pd.plate_id > 0 AND AAA.employee_id >0 and pd.plate_id=? GROUP BY pd.plate_id, B.YEAR" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,one_num1,two_num1,total_num1,one_num2,two_num2,total_num2,one_num3,two_num3,total_num3,one_num4,two_num4,total_num4,one_num5,two_num5,total_num5,one_num6,two_num6,total_num6,one_num7,two_num7,total_num7,one_num8,two_num8,total_num8,one_num9,two_num9,total_num9,one_num10,two_num10,total_num10,one_num11,two_num11,total_num11,one_num12,two_num12,total_num12";
	private final static String[] fieldNames = { "year", "year", "plate_id"};
}
