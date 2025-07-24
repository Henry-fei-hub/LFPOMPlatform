package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseSearchCostData;
import pomplatform.payment.bean.ConditionSearchCostData;

public class QuerySearchCostData extends AbstractQuery<BaseSearchCostData, ConditionSearchCostData>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchCostData.class);

	public QuerySearchCostData() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseSearchCostData> executeQuery( KeyValuePair[] replacements, ConditionSearchCostData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getPlateType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseSearchCostData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchCostData __base = new BaseSearchCostData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlateType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select a.employee_id,a.total_amount,a.type,a.business_id,a.record_date,d.plate_type,d.plate_id,b.department_id from( select employee_id,convert_from(decrypt(CAST(total_amount as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_amount ,record_date,1 as type,salary_fill_send_deduct_id as business_id,year,month,is_sended from salary_fill_send_deducts UNION ALL select employee_id,CASE WHEN (positive_account is NOT NULL AND CAST((convert_from(decrypt(CAST(positive_account as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) as decimal) <> 0) THEN CAST(CAST((convert_from(decrypt(CAST(total_amount as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) as decimal)-CAST((convert_from(decrypt(CAST(positive_account as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) as decimal) as VARCHAR) ELSE convert_from(decrypt(CAST(total_amount as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') END as total_amount ,record_date,2 as type,salary_job_subsidy_id as business_id,year,month,is_sended from salary_job_subsidys UNION ALL select employee_id,convert_from(decrypt(CAST(total_amount as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_amount ,record_date,3 as type,salary_leave_subsidy_id as business_id,year,month,is_sended from salary_leave_subsidys ) a left join employees b on a.employee_id = b.employee_id LEFT JOIN employee_day_plate_records c ON a.employee_id = c.employee_id AND a.record_date = c.record_date LEFT JOIN plate_records d ON CASE WHEN c.plate_id is null then b.plate_id else c.plate_id end = d.plate_id where a.employee_id = ? AND d.plate_type = ? and a.record_date BETWEEN ? and ? and a.year = ? AND a.month = ? and a.is_sended = false ORDER BY b.department_id,a.record_date desc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,total_amount,type,business_id,record_date,plate_type,plate_id,department_id";
	private final static String[] fieldNames = { "employee_id", "plate_type", "start_date", "end_date", "year", "month"};
}
