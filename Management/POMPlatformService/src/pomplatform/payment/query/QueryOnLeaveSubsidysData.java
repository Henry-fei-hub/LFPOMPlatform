package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLeaveSubsidysData;
import pomplatform.payment.bean.ConditionOnLeaveSubsidysData;

public class QueryOnLeaveSubsidysData extends AbstractQuery<BaseOnLeaveSubsidysData, ConditionOnLeaveSubsidysData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLeaveSubsidysData.class);

	public QueryOnLeaveSubsidysData() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.salary_leave_subsidy_id");
	}

	@Override
	public BaseCollection<BaseOnLeaveSubsidysData> executeQuery( KeyValuePair[] replacements, ConditionOnLeaveSubsidysData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnLeaveSubsidysData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLeaveSubsidysData __base = new BaseOnLeaveSubsidysData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryLeaveSubsidyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setNoDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSended(GenericBase.__getBoolean(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = "select a.salary_leave_subsidy_id,a.employee_id,b.employee_no,b.employee_name,b.company_id,b.plate_id,b.department_id, a.record_date,convert_from(decrypt(CAST(a.no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as no_deduct_tax,convert_from(decrypt(CAST(a.deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as deduct_tax,convert_from(decrypt(CAST(a.total_amount as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_amount,a.is_sended from salary_leave_subsidys a left join employees b on a.employee_id = b.employee_id where a.employee_id = ? and b.employee_no like ? and b.employee_name like ? and b.company_id = ? and b.department_id in(select child_id from department_ids where department_id = ?) and a.record_date BETWEEN ? and ? ORDER BY b.department_id,a.record_date desc" ;
	private final static String RESULTSETFIELDLIST = "salary_leave_subsidy_id,employee_id,employee_no,employee_name,company_id,plate_id,department_id,record_date,no_deduct_tax,deduct_tax,total_amount,is_sended";
	private final static String[] fieldNames = { "employee_id", "employee_no", "employee_name", "company_id", "department_id", "start_date", "end_date"};
}
