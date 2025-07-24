package pomplatform.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.personnelbusiness.bean.BaseRegularEmployeeInfo;
import pomplatform.personnelbusiness.bean.ConditionRegularEmployeeInfo;

public class QueryRegularEmployeeInfo extends AbstractQuery<BaseRegularEmployeeInfo, ConditionRegularEmployeeInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryRegularEmployeeInfo.class);

	public QueryRegularEmployeeInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseRegularEmployeeInfo> executeQuery( KeyValuePair[] replacements, ConditionRegularEmployeeInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEndDate()
			);
	}

	@Override
	public BaseRegularEmployeeInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRegularEmployeeInfo __base = new BaseRegularEmployeeInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOriginalPay(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.employee_id, a.end_date, convert_from(decrypt(CAST(a.original_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as original_pay, convert_from(decrypt(CAST(a.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_pay, a.basic_proportion_str, a.basic_proportion, convert_from(decrypt(CAST(a.month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_basic_pay, convert_from(decrypt(CAST(a.month_performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_performance_pay, convert_from(decrypt(CAST(a.foreman_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as foreman_pay, convert_from(decrypt(CAST(a.other_subsidy as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as other_subsidy, convert_from(decrypt(CAST(a.total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_pay, convert_from(decrypt(CAST(a.annual_performance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as annual_performance, a.cost_attribution from personnel_business a LEFT JOIN employees b on a.employee_id = b.employee_id where a.is_completed = true and b.onboard_status != 2 and a.process_type = 29 and a.end_date < ? and a.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,end_date,original_pay, month_pay, basic_proportion_str, basic_proportion, month_basic_pay, month_performance_pay, foreman_pay, other_subsidy, total_pay, annual_performance, cost_attribution";
	private final static String[] fieldNames = { "end_date"};
}
