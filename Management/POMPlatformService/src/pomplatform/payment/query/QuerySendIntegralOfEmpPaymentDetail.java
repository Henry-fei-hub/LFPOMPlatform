package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.bean.ConditionSendIntegralOfEmpPaymentDetail;

public class QuerySendIntegralOfEmpPaymentDetail extends AbstractQuery<BaseSendIntegralOfEmpPaymentDetail, ConditionSendIntegralOfEmpPaymentDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerySendIntegralOfEmpPaymentDetail.class);

	public QuerySendIntegralOfEmpPaymentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_payment_detail_id");
	}

	@Override
	public BaseCollection<BaseSendIntegralOfEmpPaymentDetail> executeQuery( KeyValuePair[] replacements, ConditionSendIntegralOfEmpPaymentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getPlateType(), 
				condition.getDetailDate()
			);
	}

	@Override
	public BaseSendIntegralOfEmpPaymentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSendIntegralOfEmpPaymentDetail __base = new BaseSendIntegralOfEmpPaymentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeePaymentDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDetailDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDayPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayAttendanceDeduction(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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

	private final static String __SQLText = "SELECT e.employee_payment_detail_id,e.employee_id, CASE WHEN a.plate_id is null THEN em.plate_id ELSE a.plate_id END,c.plate_type,e.detail_date ,e.day_pay,e.day_attendance_deduction,e.remark,em.department_id FROM employee_payment_details e LEFT JOIN employees em ON e.employee_id = em.employee_id LEFT JOIN employee_day_plate_records a ON e.employee_id = a.employee_id AND e.detail_date = a.record_date LEFT JOIN plate_records c ON CASE WHEN a.plate_id is null THEN em.plate_id ELSE a.plate_id END = c.plate_id WHERE e.detail_date BETWEEN ? AND ? AND CASE WHEN a.record_date is null THEN 1=1 ELSE a.record_date BETWEEN ? AND ? END AND e.is_locked = false AND e.employee_id = ? AND c.plate_type = ? and e.detail_date = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_payment_detail_id,employee_id,plate_id,plate_type,detail_date,day_pay,day_attendance_deduction,remark,department_id";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "employee_id", "plate_type", "detail_date"};
}
