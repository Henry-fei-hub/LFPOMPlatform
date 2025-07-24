package pomplatform.clocks.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.clocks.bean.BaseEmployeeFaces;
import pomplatform.clocks.bean.ConditionEmployeeFaces;

public class QueryEmployeeFaces extends AbstractQuery<BaseEmployeeFaces, ConditionEmployeeFaces>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeFaces.class);

	public QueryEmployeeFaces() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("hef.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeFaces> executeQuery( KeyValuePair[] replacements, ConditionEmployeeFaces condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeFaces generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeFaces __base = new BaseEmployeeFaces();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmpCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT hef.employee_id,hef.sn,hef.emp_code,e.employee_name,e.employee_no,e.department_id,e.plate_id FROM hr_emp_faces hef LEFT JOIN employees e ON hef.employee_id = e.employee_id WHERE e.employee_no like ? and e.employee_id = ? AND e.department_id = ? GROUP BY hef.employee_id,hef.sn,hef.emp_code,e.employee_name,e.department_id,e.employee_no,e.plate_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,sn,emp_code,employee_name,employee_no,department_id,plate_id";
	private final static String[] fieldNames = { "employee_no", "employee_id", "department_id"};
}
