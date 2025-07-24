package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfTransferEmp;
import pomplatform.report.bean.ConditionReportOfTransferEmp;

public class QueryReportOfTransferEmp extends AbstractQuery<BaseReportOfTransferEmp, ConditionReportOfTransferEmp>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfTransferEmp.class);

	public QueryReportOfTransferEmp() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseReportOfTransferEmp> executeQuery( KeyValuePair[] replacements, ConditionReportOfTransferEmp condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getPlateId()
				
			);
	}

	@Override
	public BaseReportOfTransferEmp generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfTransferEmp __base = new BaseReportOfTransferEmp();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOldPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOldDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT e.employee_id,e.employee_no,e.employee_name,e.gender ,(SELECT plate_id FROM departments WHERE department_id = pb.department_id) as old_plate_id, pb.department_id as old_department_id,(SELECT plate_id FROM departments WHERE department_id = pb.parent_id) as new_plate_id,pb.parent_id as new_department_id, pb.end_date FROM employees e LEFT JOIN personnel_business pb ON e.employee_id = pb.employee_id WHERE pb.process_type = 26 AND pb.is_completed = TRUE AND EXTRACT(YEAR FROM pb.end_date) = ? AND EXTRACT(MONTH FROM pb.end_date) = ?  AND ((SELECT plate_id FROM departments WHERE department_id = pb.department_id) = ? OR (SELECT plate_id FROM departments WHERE department_id = pb.parent_id) = ?) ORDER BY e.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,gender,old_plate_id,old_department_id,new_plate_id,new_department_id,end_date";
	private final static String[] fieldNames = { "year", "month","plate_id","plate_id"};
}
