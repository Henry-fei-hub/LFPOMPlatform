package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseEmployeeInfoOfNoSalaryAdjustment;
import pomplatform.employee.bean.ConditionEmployeeInfoOfNoSalaryAdjustment;

public class QueryEmployeeInfoOfNoSalaryAdjustment extends AbstractQuery<BaseEmployeeInfoOfNoSalaryAdjustment, ConditionEmployeeInfoOfNoSalaryAdjustment>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeInfoOfNoSalaryAdjustment.class);

	public QueryEmployeeInfoOfNoSalaryAdjustment() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.* from (SELECT a.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeInfoOfNoSalaryAdjustment> executeQuery( KeyValuePair[] replacements, ConditionEmployeeInfoOfNoSalaryAdjustment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(),
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseEmployeeInfoOfNoSalaryAdjustment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeInfoOfNoSalaryAdjustment __base = new BaseEmployeeInfoOfNoSalaryAdjustment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
//		if((val = __data[count++]) != null) __base.setChangeDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOriginalPay(GenericBase.__getString(val));
//		if((val = __data[count++]) != null) __base.setChangePay(GenericBase.__getString(val));
//		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getString(val));
//		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "select aa.* from (SELECT a.employee_id, a.employee_name, a.employee_no, a.company_id, a.plate_id, a.department_id, a.onboard_date, convert_from(decrypt(CAST(b.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as original_pay from employees a LEFT JOIN employee_payments b on a.employee_id = b.employee_id and b.enabled = true WHERE a.status = 0 and a.plate_id = ? and a.employee_name like ? and a.department_id in (select child_id from department_ids where department_id = ?) and a.employee_id !=0 ) aa LEFT JOIN (SELECT d.employee_id, count(c.process_instance_id) as num from system_process_instances c left join personnel_business d on c.process_type = d.process_type and c.business_id = d.personnel_business_id where c.process_type = 30 and c.delete_flag = 0 and c.process_status in (0,1,3) and d.end_date >= ? and d.end_date < ? group by d.employee_id) bb on aa.employee_id = bb.employee_id where bb.num is null or bb.num = 0 order by aa.plate_id, aa.employee_id" ;
//	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,employee_no,plate_id,department_id,onboard_date,change_date,original_pay,change_pay,month_pay,percent";
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,employee_no,company_id,plate_id,department_id,onboard_date,original_pay";
	private final static String[] fieldNames = { "plate_id", "employee_name", "department_id", "start_time", "end_time"};
}
