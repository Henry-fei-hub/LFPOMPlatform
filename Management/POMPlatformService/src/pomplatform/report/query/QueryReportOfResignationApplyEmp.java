package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfResignationApplyEmp;
import pomplatform.report.bean.ConditionReportOfResignationApplyEmp;

public class QueryReportOfResignationApplyEmp extends AbstractQuery<BaseReportOfResignationApplyEmp, ConditionReportOfResignationApplyEmp>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfResignationApplyEmp.class);

	public QueryReportOfResignationApplyEmp() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseReportOfResignationApplyEmp> executeQuery( KeyValuePair[] replacements, ConditionReportOfResignationApplyEmp condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOfResignationApplyEmp generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfResignationApplyEmp __base = new BaseReportOfResignationApplyEmp();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTransportation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTargetProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUnit(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT e.employee_id,e.employee_no,e.employee_name,e.gender,e.department_id,pb.end_date,pb.transportation,pb.target_province,pb.unit FROM employees e LEFT JOIN personnel_business pb ON e.employee_id = pb.employee_id WHERE process_type = 25 AND pb.is_completed = TRUE AND EXTRACT(YEAR FROM pb.end_date) = ? AND EXTRACT(MONTH FROM pb.end_date) = ? AND e.department_id in (SELECT department_id FROM departments WHERE plate_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,gender,department_id,end_date,transportation,target_province,unit";
	private final static String[] fieldNames = { "year", "month", "plate_id"};
}
