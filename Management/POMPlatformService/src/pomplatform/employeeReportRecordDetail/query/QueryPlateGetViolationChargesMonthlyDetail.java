package pomplatform.employeeReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeReportRecordDetail.bean.BasePlateGetViolationChargesMonthlyDetail;
import pomplatform.employeeReportRecordDetail.bean.ConditionPlateGetViolationChargesMonthlyDetail;

public class QueryPlateGetViolationChargesMonthlyDetail extends AbstractQuery<BasePlateGetViolationChargesMonthlyDetail, ConditionPlateGetViolationChargesMonthlyDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateGetViolationChargesMonthlyDetail.class);

	public QueryPlateGetViolationChargesMonthlyDetail() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("evc.employee_violation_charges_id");
	}

	@Override
	public BaseCollection<BasePlateGetViolationChargesMonthlyDetail> executeQuery( KeyValuePair[] replacements, ConditionPlateGetViolationChargesMonthlyDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getEmployeeId(),
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BasePlateGetViolationChargesMonthlyDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateGetViolationChargesMonthlyDetail __base = new BasePlateGetViolationChargesMonthlyDetail();
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

	private final static String __SQLText = "select evc.employee_violation_charges_id, evc.employee_id, evc.plate_id, evc.violation_charges, evc.violation_date, evc.operator, evc.operate_time, evc.remark from employee_violation_charges evc where evc.plate_id = ? AND employee_id = ? and extract(year from evc.violation_date) = ? and extract(month from evc.violation_date) = ? order by evc.violation_date" ;
	private final static String RESULTSETFIELDLIST = "employee_violation_charges_id,employee_id,plate_id,violation_charges,violation_date,operator,operate_time,remark";
	private final static String[] fieldNames = { "plate_id", "employee_id", "year", "month"};
}
