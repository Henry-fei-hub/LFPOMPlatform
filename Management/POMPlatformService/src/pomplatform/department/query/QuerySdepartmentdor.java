package pomplatform.department.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.department.bean.BaseSdepartmentdor;
import pomplatform.department.bean.ConditionSdepartmentdor;

public class QuerySdepartmentdor extends AbstractQuery<BaseSdepartmentdor, ConditionSdepartmentdor>
{

	private static final Logger __logger = Logger.getLogger(QuerySdepartmentdor.class);

	public QuerySdepartmentdor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("d.department_id");
	}

	@Override
	public BaseCollection<BaseSdepartmentdor> executeQuery( KeyValuePair[] replacements, ConditionSdepartmentdor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentName(),
				condition.getParentId(),
				condition.getPlateId()
			);
	}

	@Override
	public BaseSdepartmentdor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSdepartmentdor __base = new BaseSdepartmentdor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAbbreviation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManagerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setString(count++, (java.lang.String)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
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

	private final static String __SQLText = "select d.department_id, d.department_name, d.abbreviation, d.manager_id, d.manager_name, d.parent_id, d.enabled from departments d where d.department_name like ? and d.parent_id = ? and d.plate_id = ? and d.delete_flag = 0 ORDER BY d.parent_id" ;
	private final static String RESULTSETFIELDLIST = "department_id,department_name,abbreviation,manager_id,manager_name,parent_id,enabled";
	private final static String[] fieldNames = { "department_name","parent_id","plate_id"};
}
