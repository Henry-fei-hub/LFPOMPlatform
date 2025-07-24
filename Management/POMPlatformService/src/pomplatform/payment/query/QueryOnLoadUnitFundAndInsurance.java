package pomplatform.payment.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadUnitFundAndInsurance;
import pomplatform.payment.bean.ConditionOnLoadUnitFundAndInsurance;

public class QueryOnLoadUnitFundAndInsurance extends AbstractQuery<BaseOnLoadUnitFundAndInsurance, ConditionOnLoadUnitFundAndInsurance>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadUnitFundAndInsurance.class);

	public QueryOnLoadUnitFundAndInsurance() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadUnitFundAndInsurance> executeQuery( KeyValuePair[] replacements, ConditionOnLoadUnitFundAndInsurance condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadUnitFundAndInsurance generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadUnitFundAndInsurance __base = new BaseOnLoadUnitFundAndInsurance();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setForemanPay(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select employee_id,sum(unit_total_fund) as unit_total_fund,sum(unit_total_insurance) as unit_total_insurance,sum(month_basic_pay) as month_basic_pay,sum(month_performance_pay) as month_performance_pay,sum(day_foreman_pay) as foreman_pay from employee_payment_details where employee_id = ? and EXTRACT(YEAR from detail_date) = ? and EXTRACT(MONTH from detail_date) = ? GROUP BY employee_id,EXTRACT(YEAR from detail_date),EXTRACT(MONTH from detail_date)" ;
	private final static String RESULTSETFIELDLIST = "employee_id,unit_total_fund,unit_total_insurance,month_basic_pay,month_performance_pay,foreman_pay";
	private final static String[] fieldNames = { "employee_id", "year", "month"};
}
