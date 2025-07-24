package pomplatform.bonusPaymentByDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPaymentByDetail.bean.BaseBonusPaymentByDetail;
import pomplatform.bonusPaymentByDetail.bean.ConditionBonusPaymentByDetail;

public class QueryBonusPaymentByDetail extends AbstractQuery<BaseBonusPaymentByDetail, ConditionBonusPaymentByDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentByDetail.class);

	public QueryBonusPaymentByDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseBonusPaymentByDetail> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentByDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseBonusPaymentByDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentByDetail __base = new BaseBonusPaymentByDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select employee_id,employee_no,pay_integral, pay_date from bonus_payment_details where state = 1 and employee_id = ? and extract(year from pay_date) = ? and extract(month from pay_date) = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,pay_integral,pay_date";
	private final static String[] fieldNames = { "employee_id", "year", "month"};
}
