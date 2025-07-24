package pomplatform.payment.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadEmployeePaymentDetail;
import pomplatform.payment.bean.ConditionOnLoadEmployeePaymentDetail;

public class QueryOnLoadEmployeePaymentDetail extends AbstractQuery<BaseOnLoadEmployeePaymentDetail, ConditionOnLoadEmployeePaymentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeePaymentDetail.class);

	public QueryOnLoadEmployeePaymentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.employee_no");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeePaymentDetail> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeePaymentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getCompanyId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadEmployeePaymentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeePaymentDetail __base = new BaseOnLoadEmployeePaymentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeePaymentDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDetailDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDetailWeek(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setForemanPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthWorkDay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthTotalDay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayWorkTime(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayForemanPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLateLeave10m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave30m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThingLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllPercentStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIllPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLateLeaveTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThingTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDeductTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAllSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayAttendanceDeduction(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "select b.employee_no,b.employee_name,b.company_id,b.department_id,a.* from employee_payment_details a LEFT JOIN employees b on a.employee_id = b.employee_id where a.employee_id = ? and a.detail_date BETWEEN ? AND ? and b.employee_no like ? and b.employee_name like ? and b.company_id = ? and b.department_id in(select child_id from department_ids where department_id =?) ORDER BY a.employee_id,a.detail_date asc" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,company_id,department_id,employee_payment_detail_id,employee_id,detail_date,detail_week,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,month_work_day,month_total_day,day_work_time,day_pay,day_foreman_pay,day_cost,unit_total_fund,remark,late_leave_10m,late_leave_30m,late_leave,thing_leave_days,thing_leave_hours,ill_leave_days,ill_percent_str,ill_percent,late_leave_total,thing_total,ill_total,deduct_total,ill_leave_hours,unit_total_insurance,all_salary,day_attendance_deduction";
	private final static String[] fieldNames = { "employee_id", "start_date", "end_date", "employee_no", "employee_name", "company_id", "department_id"};
}
