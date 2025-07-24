package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadShiftAndDayPayment;
import pomplatform.payment.bean.ConditionOnLoadShiftAndDayPayment;

public class QueryOnLoadShiftAndDayPayment extends AbstractQuery<BaseOnLoadShiftAndDayPayment, ConditionOnLoadShiftAndDayPayment>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadShiftAndDayPayment.class);

	public QueryOnLoadShiftAndDayPayment() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadShiftAndDayPayment> executeQuery( KeyValuePair[] replacements, ConditionOnLoadShiftAndDayPayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRecordDate()
			);
	}

	@Override
	public BaseOnLoadShiftAndDayPayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadShiftAndDayPayment __base = new BaseOnLoadShiftAndDayPayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPaymentChangeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setChangeDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherSubsidy(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformance(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "select employee_id,payment_change_type,basic_proportion,change_date ,convert_from(decrypt(CAST(month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_pay ,convert_from(decrypt(CAST(month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_basic_pay ,convert_from(decrypt(CAST(month_performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_performance_pay ,convert_from(decrypt(CAST(other_subsidy as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as other_subsidy ,convert_from(decrypt(CAST(total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_pay ,convert_from(decrypt(CAST(annual_performance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as annual_performance from employee_payments where employee_id = ? and change_date <= ? order by change_date desc limit 1" ;
	private final static String RESULTSETFIELDLIST = "employee_id,payment_change_type,basic_proportion,change_date,month_pay,month_basic_pay,month_performance_pay,other_subsidy,total_pay,annual_performance";
	private final static String[] fieldNames = { "employee_id", "record_date"};
}
