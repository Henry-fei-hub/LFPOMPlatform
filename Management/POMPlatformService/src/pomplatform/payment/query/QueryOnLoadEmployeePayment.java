package pomplatform.payment.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadEmployeePayment;
import pomplatform.payment.bean.ConditionOnLoadEmployeePayment;

public class QueryOnLoadEmployeePayment extends AbstractQuery<BaseOnLoadEmployeePayment, ConditionOnLoadEmployeePayment>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeePayment.class);

	public QueryOnLoadEmployeePayment() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeePayment> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeePayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getEnabled(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadEmployeePayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeePayment __base = new BaseOnLoadEmployeePayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPaymentChangeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setChangeDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setForemanPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherSubsidy(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no,b.employee_name,b.plate_id,b.department_id ,a.payment_change_type,a.change_date,convert_from(decrypt(CAST(a.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_pay,a.basic_proportion_str,a.basic_proportion,convert_from(decrypt(CAST(a.month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_basic_pay,convert_from(decrypt(CAST(a.month_performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_performance_pay ,convert_from(decrypt(CAST(a.foreman_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as foreman_pay,convert_from(decrypt(CAST(a.total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_pay,convert_from(decrypt(CAST(a.annual_performance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as annual_performance,convert_from(decrypt(CAST(a.other_subsidy as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as other_subsidy,a.cost_attribution from employee_payments a left join employees b on a.employee_id = b.employee_id where  b.employee_no like ? and b.employee_name like ? and b.plate_id =? and b.department_id in(select child_id from department_ids where department_id = ?) and a.enabled = ? and a.employee_id = ? ORDER BY a.change_date desc,a.employee_payment_id desc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,department_id,payment_change_type,change_date,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,total_pay,annual_performance,other_subsidy,cost_attribution";
	private final static String[] fieldNames = { "employee_no", "employee_name", "plate_id", "department_id", "enabled", "employee_id"};
}
