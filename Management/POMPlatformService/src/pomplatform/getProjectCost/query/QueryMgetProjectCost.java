package pomplatform.getProjectCost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getProjectCost.bean.BaseMgetProjectCost;
import pomplatform.getProjectCost.bean.ConditionMgetProjectCost;

public class QueryMgetProjectCost extends AbstractQuery<BaseMgetProjectCost, ConditionMgetProjectCost>
{

	private static final Logger __logger = Logger.getLogger(QueryMgetProjectCost.class);

	public QueryMgetProjectCost() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseMgetProjectCost> executeQuery( KeyValuePair[] replacements, ConditionMgetProjectCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMgetProjectCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMgetProjectCost __base = new BaseMgetProjectCost();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryMonth(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicSalary(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
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

	private final static String __SQLText = "select a.plate_id,a.project_id,b.employee_id,c.salary_month,c.basic_salary from projects a left join project_employees b on a.project_id = b.project_id left join employee_salary_details c on b.employee_id = c.employee_id where a.plate_id = ? and a.project_id = ? and c.salary_year='2016' and cast(c.salary_month as integer) >=1 and cast(c.salary_month as integer) <=6" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,employee_id,salary_month,basic_salary";
	private final static String[] fieldNames = { "plate_id", "project_id"};
}
