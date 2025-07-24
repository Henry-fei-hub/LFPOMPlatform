package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseSpecialDeductionRecordsApplyOfWorkflow;
import pomplatform.specialDeduction.bean.ConditionSpecialDeductionRecordsApplyOfWorkflow;

public class QuerySpecialDeductionRecordsApplyOfWorkflow extends AbstractQuery<BaseSpecialDeductionRecordsApplyOfWorkflow, ConditionSpecialDeductionRecordsApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QuerySpecialDeductionRecordsApplyOfWorkflow.class);

	public QuerySpecialDeductionRecordsApplyOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseSpecialDeductionRecordsApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionSpecialDeductionRecordsApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeId(), 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getIsEnable(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseSpecialDeductionRecordsApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSpecialDeductionRecordsApplyOfWorkflow __base = new BaseSpecialDeductionRecordsApplyOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, sdr.special_deduction_record_id, sdr.employe_id, sdr.employee_name, sdr.start_date, sdr.end_date, sdr.create_date, sdr.is_enable, sdr.remark, e.company_id, e.department_id, e.plate_id, e.phone FROM system_process_instances spi LEFT JOIN special_deduction_records sdr ON spi.business_id = sdr.special_deduction_record_id left join employees e on e.employee_id = sdr.employe_id WHERE spi.process_type = 58 AND spi.process_status IN ( 0, 1 ) AND spi.delete_flag = 0 AND sdr.employe_id =? AND e.company_id =? AND e.plate_id =? AND sdr.is_enable =? AND e.department_id=? ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,special_deduction_record_id,employe_id,employee_name,start_date,end_date,create_date,is_enable,remark,company_id,department_id,plate_id,phone";
	private final static String[] fieldNames = { "employe_id", "company_id", "plate_id", "is_enable", "department_id"};
}
