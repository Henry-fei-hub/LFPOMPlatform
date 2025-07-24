package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryEmpBonusByDepartment;
import pomplatform.payment.bean.ConditionOnSalaryEmpBonusByDepartment;

public class QueryOnSalaryEmpBonusByDepartment extends AbstractQuery<BaseOnSalaryEmpBonusByDepartment, ConditionOnSalaryEmpBonusByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryEmpBonusByDepartment.class);

	public QueryOnSalaryEmpBonusByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_no");
	}

	@Override
	public BaseCollection<BaseOnSalaryEmpBonusByDepartment> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryEmpBonusByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(),
				condition.getPersonnelBusinessId(),
				condition.getFlowStatus(),
				condition.getStartTime(),
				condition.getEndTime()
			);
	}

	@Override
	public BaseOnSalaryEmpBonusByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryEmpBonusByDepartment __base = new BaseOnSalaryEmpBonusByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectBonus(GenericBase.__getDecimal(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
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

	private final static String __SQLText = "SELECT e.employee_no,a.employee_id,a.year,a.month, COALESCE(CAST(convert_from(decrypt(CAST(a.should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric),0)+COALESCE(CAST(convert_from(decrypt(CAST(a.other_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric),0) as should_bonus ,CAST(convert_from(decrypt(CAST(a.should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric) as should_tax ,CAST(convert_from(decrypt(CAST(a.fact_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric) as fact_bonus,CAST(convert_from(decrypt(CAST(a.other_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric) as other_bonus,CAST(convert_from(decrypt(CAST(a.should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric) as project_bonus FROM salary_of_bonus a left join employees e on a.employee_id = e.employee_id WHERE flag in(2,3) AND a.company_id = ? AND a.plate_id = ? AND a.year = ? AND a.month = ? AND a.department_id = ? and a.employee_id = ? and e.employee_no like ? and a.personnel_business_id =? and a.flow_status =? AND a.send_time BETWEEN ? AND ? ORDER BY a.employee_id,a.year,a.month" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_id,year,month,should_bonus,should_tax,fact_bonus,other_bonus,project_bonus";
	private final static String[] fieldNames = { "company_id", "plate_id", "year", "month", "department_id", "employee_id", "employee_no","personnel_business_id", "flow_status", "start_time", "end_time" };
}
