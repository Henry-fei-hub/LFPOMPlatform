package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BasePlateSalaryAdjustmentSummary;
import pomplatform.workflow.personnelbusiness.bean.ConditionPlateSalaryAdjustmentSummary;

public class QueryPlateSalaryAdjustmentSummary extends AbstractQuery<BasePlateSalaryAdjustmentSummary, ConditionPlateSalaryAdjustmentSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateSalaryAdjustmentSummary.class);

	public QueryPlateSalaryAdjustmentSummary() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
	}

	@Override
	public BaseCollection<BasePlateSalaryAdjustmentSummary> executeQuery( KeyValuePair[] replacements, ConditionPlateSalaryAdjustmentSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BasePlateSalaryAdjustmentSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateSalaryAdjustmentSummary __base = new BasePlateSalaryAdjustmentSummary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriginalPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setChangePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.plate_id, sum(a.month_pay) as original_pay, sum(a.change_pay) as change_pay, sum(a.month_pay+a.change_pay) as month_pay, round(sum(a.change_pay)/sum(a.month_pay)*100,2) as percent from ((SELECT b.plate_id, sum(cast ((convert_from(decrypt(CAST(a.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) as numeric)) as month_pay, 0 as change_pay FROM employee_payment_month_details a LEFT JOIN employees b ON a.employee_id = b.employee_id AND a.enabled = TRUE WHERE a.year = ? and a.month = ? and b.plate_id in(select e.plate_id from personnel_business pb LEFT JOIN system_process_instances spi on pb.personnel_business_id = spi.business_id and pb.process_type = spi.process_type LEFT JOIN employees e on pb.employee_id = e.employee_id where spi.process_status IN (0, 1, 3) AND spi.delete_flag = 0 AND spi.process_type = 30 and extract(year from spi.create_time) = a.year and extract(month from spi.create_time) = a.month) group by b.plate_id) union all (SELECT c.plate_id, 0 as month_pay, sum(b.severance) as change_pay FROM system_process_instances a LEFT JOIN personnel_business b ON a.process_type = b.process_type AND a.business_id = b.personnel_business_id LEFT JOIN employees c ON b.employee_id = c.employee_id WHERE a.process_status IN (0, 1, 3) AND a.delete_flag = 0 AND a.process_type = 30 and extract(year from a.create_time) = ? and extract(month from a.create_time) = ? group by c.plate_id)) a where a.plate_id = ? group by a.plate_id order by a.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,original_pay,change_pay,month_pay,percent";
	private final static String[] fieldNames = { "year", "month", "year", "month", "plate_id"};
}
