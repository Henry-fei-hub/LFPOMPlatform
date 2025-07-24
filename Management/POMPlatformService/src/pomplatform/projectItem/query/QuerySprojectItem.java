package pomplatform.projectItem.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectItem.bean.BaseSprojectItem;
import pomplatform.projectItem.bean.ConditionSprojectItem;

public class QuerySprojectItem extends AbstractQuery<BaseSprojectItem, ConditionSprojectItem>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectItem.class);

	public QuerySprojectItem() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_id as idd");
	}

	@Override
	public BaseCollection<BaseSprojectItem> executeQuery( KeyValuePair[] replacements, ConditionSprojectItem condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getDepartmentManagerId()
			);
	}

	@Override
	public BaseSprojectItem generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectItem __base = new BaseSprojectItem();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setIdd(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVal(GenericBase.__getString(val));
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

	private final static String __SQLText = "select project_id as idd, contract_code||'--'||project_name as val from projects where plate_id = ? and department_manager_id = ? and status != 10 and status != 11 order by reserve_integral desc" ;
	private final static String RESULTSETFIELDLIST = "idd,val";
	private final static String[] fieldNames = { "plate_id", "department_manager_id"};
}
