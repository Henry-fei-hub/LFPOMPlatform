package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseSelectGridEmployeeValues;
import pomplatform.workflow.bean.ConditionSelectGridEmployeeValues;


public class QuerySelectGridEmployeeValues extends AbstractQuery<BaseSelectGridEmployeeValues, ConditionSelectGridEmployeeValues>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectGridEmployeeValues.class);

	public QuerySelectGridEmployeeValues() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseSelectGridEmployeeValues> executeQuery( KeyValuePair[] replacements, ConditionSelectGridEmployeeValues condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getRoleId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNameEn()
			);
	}

	@Override
	public BaseSelectGridEmployeeValues generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectGridEmployeeValues __base = new BaseSelectGridEmployeeValues();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUserAcct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkAddress(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT employee_id, employee_no, employee_name, department_id, role_id, mobile, phone, qq, email, photo, card, user_acct, employee_name_en, work_address FROM employees WHERE status = 0 AND employee_id = ? AND employee_no LIKE ? AND role_id = ? AND employee_name LIKE ? AND employee_name_en = ?_en AND employee_id <> 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,mobile,phone,qq,email,photo,card,user_acct,employee_name_en,work_address";
	private final static String[] fieldNames = { "employee_id", "employee_no", "role_id", "employee_name", "employee_name_en"};
}
