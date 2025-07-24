package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.bean.ConditionOnLoadSpecialDeductionYear;

public class QueryOnLoadSpecialDeductionYear extends AbstractQuery<BaseOnLoadSpecialDeductionYear, ConditionOnLoadSpecialDeductionYear>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSpecialDeductionYear.class);

	public QueryOnLoadSpecialDeductionYear() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSpecialDeductionYear condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getIsEnable(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getMonth(), 
				condition.getMonth(), 
				condition.getEndMonth(), 
				condition.getSpecialDeductionTypeId()
			);
	}

	@Override
	public BaseOnLoadSpecialDeductionYear generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSpecialDeductionYear __base = new BaseOnLoadSpecialDeductionYear();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherOperation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.employee_id, spi.create_time, spi.complete_time, spi.delete_flag, spi.other_operation, sdd.amount, sdd.special_deduction_type_id, sdr.create_date, sdd.start_date, sdd.end_date FROM system_process_instances spi LEFT JOIN special_deduction_records sdr ON sdr.special_deduction_record_id = spi.business_id LEFT JOIN special_deduction_details sdd ON sdd.parent_id = sdr.special_deduction_record_id WHERE spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3 AND spi.employee_id =? AND sdr.employee_name =? AND sdr.is_enable =? AND sdd.start_date <=? AND sdd.end_date >=? AND EXTRACT ( MONTH FROM sdd.start_date ) <=? AND EXTRACT ( MONTH FROM sdd.end_date ) >=? AND EXTRACT ( MONTH FROM sdd.end_date ) <? AND sdd.special_deduction_type_id =?" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,employee_id,create_time,complete_time,delete_flag,other_operation,amount,special_deduction_type_id,create_date,start_date,end_date";
	private final static String[] fieldNames = { "employee_id", "year", "is_enable", "start_date", "end_date", "month", "month", "end_month", "special_deduction_type_id"};
}
