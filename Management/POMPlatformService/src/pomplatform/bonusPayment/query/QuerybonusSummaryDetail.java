package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BasebonusSummaryDetail;
import pomplatform.bonusPayment.bean.ConditionbonusSummaryDetail;

public class QuerybonusSummaryDetail extends AbstractQuery<BasebonusSummaryDetail, ConditionbonusSummaryDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerybonusSummaryDetail.class);

	public QuerybonusSummaryDetail() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("AAA.*");
	}

	@Override
	public BaseCollection<BasebonusSummaryDetail> executeQuery( KeyValuePair[] replacements, ConditionbonusSummaryDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFirststart(), 
				condition.getFirstend(), 
				condition.getSecondstart(), 
				condition.getSecondend(), 
				condition.getThirdstart(), 
				condition.getThirdend(), 
				condition.getFourthstart(), 
				condition.getFourthend(), 
				condition.getPlateId()
			);
	}

	@Override
	public BasebonusSummaryDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BasebonusSummaryDetail __base = new BasebonusSummaryDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFirstPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSecondPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThirdPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourthPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "select AAA.*,'0' as year from ( select AA.department_id, ds.department_name, sum(AA.first_pay_integral) as first_pay_integral, sum(AA.second_pay_integral) as second_pay_integral, sum(AA.third_pay_integral) as third_pay_integral, sum(AA.fourth_pay_integral) as fourth_pay_integral, SUM(AA.first_pay_integral+AA.second_pay_integral+AA.third_pay_integral+AA.fourth_pay_integral) as total_pay_integral from ( select pd.department_id, CASE WHEN A.pay_integral ISNULL THEN 0 ELSE A.pay_integral END as first_pay_integral, CASE WHEN B.pay_integral ISNULL THEN 0 ELSE B.pay_integral END as second_pay_integral, CASE WHEN C.pay_integral ISNULL THEN 0 ELSE C.pay_integral END as third_pay_integral, CASE WHEN D.pay_integral ISNULL THEN 0 ELSE D.pay_integral END as fourth_pay_integral from plate_departments pd left join ( select bpd.department_id , sum(bpd.pay_integral) as pay_integral from bonus_payment_details bpd where bpd.state =1 and bpd.pay_date>=? and bpd.pay_date<=? group by bpd.department_id ) as A on pd.department_id =A.department_id left join ( select bpd.department_id , sum(bpd.pay_integral)as pay_integral from bonus_payment_details bpd where bpd.state =1 and bpd.pay_date>=? and bpd.pay_date<=? group by bpd.department_id ) as B on pd.department_id =B.department_id left join ( select bpd.department_id , sum(bpd.pay_integral) as pay_integral from bonus_payment_details bpd where bpd.state =1 and bpd.pay_date>=? and bpd.pay_date<=? group by bpd.department_id ) as C on pd.department_id =C.department_id left join ( select bpd.department_id , sum(bpd.pay_integral) as pay_integral from bonus_payment_details bpd where bpd.state =1 and bpd.pay_date>=? and bpd.pay_date<=? group by bpd.department_id ) as D on pd.department_id =D.department_id where pd.plate_id =? ) as AA LEFT JOIN departments ds on ds.department_id = AA.department_id GROUP BY AA.department_id, ds.department_name ORDER BY AA.department_id ) as AAA" ;
	private final static String RESULTSETFIELDLIST = "department_id,department_name,first_pay_integral,second_pay_integral,third_pay_integral,fourth_pay_integral,total_pay_integral,year";
	private final static String[] fieldNames = { "firstStart", "firstEnd", "secondStart", "secondEnd", "thirdStart", "thirdEnd", "fourthStart", "fourthEnd", "plate_id"};
}
