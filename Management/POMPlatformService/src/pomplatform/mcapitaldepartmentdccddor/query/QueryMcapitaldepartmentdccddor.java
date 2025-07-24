package pomplatform.mcapitaldepartmentdccddor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcapitaldepartmentdccddor.bean.BaseMcapitaldepartmentdccddor;
import pomplatform.mcapitaldepartmentdccddor.bean.ConditionMcapitaldepartmentdccddor;

public class QueryMcapitaldepartmentdccddor extends AbstractQuery<BaseMcapitaldepartmentdccddor, ConditionMcapitaldepartmentdccddor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitaldepartmentdccddor.class);

	public QueryMcapitaldepartmentdccddor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cd.capital_department_id");
	}

	@Override
	public BaseCollection<BaseMcapitaldepartmentdccddor> executeQuery( KeyValuePair[] replacements, ConditionMcapitaldepartmentdccddor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalDepartmentId(), 
				condition.getCapitalId(), 
				condition.getDepartmentId(), 
				condition.getDepartmentName()
			);
	}

	@Override
	public BaseMcapitaldepartmentdccddor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitaldepartmentdccddor __base = new BaseMcapitaldepartmentdccddor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepratmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT cd.capital_department_id, cd.capital_id, cd.department_id, cd.money, cd.operator_id, cd.creat_time, de.department_name FROM capital_departments cd LEFT JOIN departments de ON de.department_id = cd.department_id WHERE cd.capital_department_id = ? AND cd.capital_id = ? AND cd.department_id = ? AND de.department_name LIKE ?" ;
	private final static String RESULTSETFIELDLIST = "capital_department_id,capital_id,department_id,money,operator_id,creat_time,department_name";
	private final static String[] fieldNames = { "capital_department_id", "capital_id", "department_id", "department_name"};
}
