package pomplatform.employeeReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeViolationCharges;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeViolationCharges;

public class QueryEmployeeViolationCharges extends AbstractQuery<BaseEmployeeViolationCharges, ConditionEmployeeViolationCharges>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeViolationCharges.class);

	public QueryEmployeeViolationCharges() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("evc.employee_violation_charges_id");
	}

	@Override
	public BaseCollection<BaseEmployeeViolationCharges> executeQuery( KeyValuePair[] replacements, ConditionEmployeeViolationCharges condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getOperator(), 
				condition.getOperator(), 
				condition.getEmployeeId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseEmployeeViolationCharges generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeViolationCharges __base = new BaseEmployeeViolationCharges();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeViolationChargesId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setViolationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = "select evc.employee_violation_charges_id, evc.employee_id, evc.plate_id, evc.violation_charges, evc.violation_date, evc.operator, evc.operate_time, evc.remark, evc.status from employee_violation_charges evc where evc.plate_id = ? and evc.operator = ? and evc.operator = ? and evc.status in (1,3) and evc.employee_id = ? and evc.violation_date between ? and ? and evc.employee_id > 0" ;
	private final static String RESULTSETFIELDLIST = "主键id,employee_id,plate_id,violation_charges,violation_date,operator,operate_time,remark,status";
	private final static String[] fieldNames = { "plate_id", "operator", "operator", "employee_id", "start_date", "end_date"};
}
