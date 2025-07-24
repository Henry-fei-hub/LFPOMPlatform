package pomplatform.plateProjectCost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateProjectCost.bean.BaseMplateProjectCost;
import pomplatform.plateProjectCost.bean.ConditionMplateProjectCost;

public class QueryMplateProjectCost extends AbstractQuery<BaseMplateProjectCost, ConditionMplateProjectCost>
{

	private static final Logger __logger = Logger.getLogger(QueryMplateProjectCost.class);

	public QueryMplateProjectCost() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("distinct a.plate_id");
	}

	@Override
	public BaseCollection<BaseMplateProjectCost> executeQuery( KeyValuePair[] replacements, ConditionMplateProjectCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId()
			);
	}

	@Override
	public BaseMplateProjectCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMplateProjectCost __base = new BaseMplateProjectCost();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select distinct a.plate_id,b.employee_id,c.salary_month,c.basic_salary from projects a left join project_employees b on a.project_id = b.project_id left join employee_salary_details c on b.employee_id = c.employee_id where a.plate_id = ? and c.salary_year='2016' and cast(c.salary_month as integer) >=1 and cast(c.salary_month as integer) <=6" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,salary_month,basic_salary";
	private final static String[] fieldNames = { "plate_id"};
}
