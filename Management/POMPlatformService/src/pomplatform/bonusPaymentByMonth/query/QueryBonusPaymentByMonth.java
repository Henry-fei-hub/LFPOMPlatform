package pomplatform.bonusPaymentByMonth.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPaymentByMonth.bean.BaseBonusPaymentByMonth;
import pomplatform.bonusPaymentByMonth.bean.ConditionBonusPaymentByMonth;

public class QueryBonusPaymentByMonth extends AbstractQuery<BaseBonusPaymentByMonth, ConditionBonusPaymentByMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentByMonth.class);

	public QueryBonusPaymentByMonth() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseBonusPaymentByMonth> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentByMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseBonusPaymentByMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentByMonth __base = new BaseBonusPaymentByMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select employee_id,employee_no,sum(pay_integral) as pay_integral,extract(year from pay_date) as year ,extract(month from pay_date) as month from bonus_payment_details where state = 1 and employee_id = ? group by employee_id,employee_no,year,month" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,pay_integral,year,month";
	private final static String[] fieldNames = { "employee_id"};
}
