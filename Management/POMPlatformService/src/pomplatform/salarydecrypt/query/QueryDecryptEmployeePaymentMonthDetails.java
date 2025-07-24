package pomplatform.salarydecrypt.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salarydecrypt.bean.BaseDecryptEmployeePaymentMonthDetails;
import pomplatform.salarydecrypt.bean.ConditionDecryptEmployeePaymentMonthDetails;

public class QueryDecryptEmployeePaymentMonthDetails extends AbstractQuery<BaseDecryptEmployeePaymentMonthDetails, ConditionDecryptEmployeePaymentMonthDetails>
{

	private static final Logger __logger = Logger.getLogger(QueryDecryptEmployeePaymentMonthDetails.class);

	public QueryDecryptEmployeePaymentMonthDetails() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("epmd.employee_payment_month_detail_id");
	}

	@Override
	public BaseCollection<BaseDecryptEmployeePaymentMonthDetails> executeQuery( KeyValuePair[] replacements, ConditionDecryptEmployeePaymentMonthDetails condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeePaymentMonthDetailId(), 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getCostAttribution(), 
				condition.getEnabled()
			);
	}

	@Override
	public BaseDecryptEmployeePaymentMonthDetails generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDecryptEmployeePaymentMonthDetails __base = new BaseDecryptEmployeePaymentMonthDetails();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeePaymentMonthDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setForemanPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherSubsidy(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setMonthPayDecrypt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPayDecrypt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePayDecrypt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setForemanPayDecrypt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherSubsidyDecrypt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPayDecrypt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformanceDecrypt(GenericBase.__getDecimal(val));
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
		if(args[5] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[5]));
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

	private final static String __SQLText = "SELECT epmd.employee_payment_month_detail_id, epmd.employee_id, epmd.year, epmd.month, epmd.month_pay, epmd.basic_proportion_str, epmd.basic_proportion, epmd.month_basic_pay, epmd.month_performance_pay, epmd.foreman_pay, epmd.other_subsidy, epmd.total_pay, epmd.annual_performance, epmd.cost_attribution, epmd.enabled, 	convert_from(decrypt(CAST(month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as month_pay_decrypt,convert_from(decrypt(CAST(month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as month_basic_pay_decrypt,convert_from(decrypt(CAST(month_performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as month_performance_pay_decrypt,convert_from(decrypt(CAST(foreman_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as foreman_pay_decrypt,convert_from(decrypt(CAST(other_subsidy as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as other_subsidy_decrypt,convert_from(decrypt(CAST(total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as total_pay_decrypt,convert_from(decrypt(CAST(annual_performance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')  as annual_performance_decrypt FROM employee_payment_month_details epmd WHERE epmd.employee_payment_month_detail_id = ? AND epmd.employee_id = ? AND epmd.year = ? AND epmd.month = ? AND epmd.cost_attribution = ? AND epmd.enabled = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_payment_month_detail_id,employee_id,year,month,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,other_subsidy,total_pay,annual_performance,cost_attribution,enabled,month_pay_decrypt,month_basic_pay_decrypt,month_performance_pay_decrypt,foreman_pay_decrypt,other_subsidy_decrypt,total_pay_decrypt,annual_performance_decrypt";
	private final static String[] fieldNames = { "employee_payment_month_detail_id", "employee_id", "year", "month", "cost_attribution", "enabled"};
}
