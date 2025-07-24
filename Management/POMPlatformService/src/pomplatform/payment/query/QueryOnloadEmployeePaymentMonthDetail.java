package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnloadEmployeePaymentMonthDetail;
import pomplatform.payment.bean.ConditionOnloadEmployeePaymentMonthDetail;

public class QueryOnloadEmployeePaymentMonthDetail extends AbstractQuery<BaseOnloadEmployeePaymentMonthDetail, ConditionOnloadEmployeePaymentMonthDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnloadEmployeePaymentMonthDetail.class);

	public QueryOnloadEmployeePaymentMonthDetail() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("epmd.employee_payment_month_detail_id");
	}

	@Override
	public BaseCollection<BaseOnloadEmployeePaymentMonthDetail> executeQuery( KeyValuePair[] replacements, ConditionOnloadEmployeePaymentMonthDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnloadEmployeePaymentMonthDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnloadEmployeePaymentMonthDetail __base = new BaseOnloadEmployeePaymentMonthDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeePaymentMonthDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT epmd.employee_payment_month_detail_id,epmd.employee_id,e.employee_name,e.employee_no,e.department_id,e.plate_id,epmd.year,epmd.month,convert_from(decrypt(CAST(epmd.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_pay,epmd.basic_proportion_str,epmd.basic_proportion,convert_from(decrypt(CAST(epmd.month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_basic_pay,convert_from(decrypt(CAST(epmd.month_performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_performance_pay,convert_from(decrypt(CAST(epmd.foreman_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as foreman_pay,convert_from(decrypt(CAST(epmd.other_subsidy as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as other_subsidy,convert_from(decrypt(CAST(epmd.total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_pay,convert_from(decrypt(CAST(epmd.annual_performance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as annual_performance, epmd.cost_attribution,epmd.enabled FROM employee_payment_month_details epmd left join employees e on epmd.employee_id = e.employee_id WHERE epmd.employee_id = ? AND epmd.year = ? AND epmd.month = ? and e.employee_no like ? and e.department_id  in (select child_id from department_ids where department_id = ?) and e.plate_id = ? ORDER BY year,month ASC" ;
	private final static String RESULTSETFIELDLIST = "employee_payment_month_detail_id,employee_id,employee_name,employee_no,department_id,plate_id,year,month,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,other_subsidy,total_pay,annual_performance,cost_attribution,enabled";
	private final static String[] fieldNames = { "employee_id", "year", "month", "employee_no", "department_id", "plate_id"};
}
