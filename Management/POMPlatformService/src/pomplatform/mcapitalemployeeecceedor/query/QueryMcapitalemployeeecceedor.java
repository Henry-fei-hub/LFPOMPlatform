package pomplatform.mcapitalemployeeecceedor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcapitalemployeeecceedor.bean.BaseMcapitalemployeeecceedor;
import pomplatform.mcapitalemployeeecceedor.bean.ConditionMcapitalemployeeecceedor;

public class QueryMcapitalemployeeecceedor extends AbstractQuery<BaseMcapitalemployeeecceedor, ConditionMcapitalemployeeecceedor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitalemployeeecceedor.class);

	public QueryMcapitalemployeeecceedor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ce.capital_employee_id");
	}

	@Override
	public BaseCollection<BaseMcapitalemployeeecceedor> executeQuery( KeyValuePair[] replacements, ConditionMcapitalemployeeecceedor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalEmployeeId(), 
				condition.getCapitalId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseMcapitalemployeeecceedor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitalemployeeecceedor __base = new BaseMcapitalemployeeecceedor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT ce.capital_employee_id, ce.capital_id, ce.employee_id, ep.employee_name, ep.employee_name_en, ep.employee_no, ep.department_id, ce.money, ce.operator_id, ce.creat_time FROM capital_employees ce LEFT JOIN employees ep ON ce.employee_id = ep.employee_id WHERE ce.capital_employee_id = ? AND ce.capital_id = ? AND ce.employee_id = ? AND ep.employee_name LIKE ? AND ep.department_id = ?" ;
	private final static String RESULTSETFIELDLIST = "capital_employee_id,capital_id,employee_id,employee_name,employee_name_en,employee_no,department_id,money,operator_id,creat_time";
	private final static String[] fieldNames = { "capital_employee_id", "capital_id", "employee_id", "employee_name", "department_id"};
}
