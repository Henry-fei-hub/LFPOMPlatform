package pomplatform.employeechangeplaterecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeechangeplaterecord.bean.BaseMemployeechangeplaterecordeeepyseor;
import pomplatform.employeechangeplaterecord.bean.ConditionMemployeechangeplaterecordeeepyseor;

public class QueryMemployeechangeplaterecordeeepyseor extends AbstractQuery<BaseMemployeechangeplaterecordeeepyseor, ConditionMemployeechangeplaterecordeeepyseor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeechangeplaterecordeeepyseor.class);

	public QueryMemployeechangeplaterecordeeepyseor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ecpr.employee_change_plate_record_id");
	}

	@Override
	public BaseCollection<BaseMemployeechangeplaterecordeeepyseor> executeQuery( KeyValuePair[] replacements, ConditionMemployeechangeplaterecordeeepyseor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseMemployeechangeplaterecordeeepyseor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeechangeplaterecordeeepyseor __base = new BaseMemployeechangeplaterecordeeepyseor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeChangePlateRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select ecpr.employee_change_plate_record_id,e.employee_no, ecpr.employee_id, ecpr.year, ecpr.month, ecpr.plate_id, ecpr.create_time, ecpr.update_time,ecpr.department_id from employee_change_plate_records ecpr left join employees e on ecpr.employee_id = e.employee_id where e.employee_no like ? and ecpr.employee_id = ? and ecpr.plate_id = ? and ecpr.year = ? and ecpr.month >= ? and ecpr.month <= ? order by ecpr.change_plate_date desc, ecpr.plate_id, ecpr.update_time desc" ;
	private final static String RESULTSETFIELDLIST = "employee_change_plate_record_id,employee_no,employee_id,year,month,plate_id,create_time,update_time";
	private final static String[] fieldNames = { "employee_no", "employee_id", "plate_id", "year", "start_month", "end_month"};
}
