package pomplatform.projectlog.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectlog.bean.BaseSprojectlogppoor;
import pomplatform.projectlog.bean.ConditionSprojectlogppoor;

public class QuerySprojectlogppoor extends AbstractQuery<BaseSprojectlogppoor, ConditionSprojectlogppoor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectlogppoor.class);

	public QuerySprojectlogppoor() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pl.project_log_id");
	}

	@Override
	public BaseCollection<BaseSprojectlogppoor> executeQuery( KeyValuePair[] replacements, ConditionSprojectlogppoor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectLogId(), 
				condition.getProjectId(), 
				condition.getOperateId(), 
				condition.getDepartmentId(), 
				condition.getManagerId(), 
				condition.getDesignPhase(), 
				condition.getLogType()
			);
	}

	@Override
	public BaseSprojectlogppoor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectlogppoor __base = new BaseSprojectlogppoor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectLogId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLogType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
		if(args[3] != null) __statement.setInt(count++, (java.lang.Integer)args[3]);
		if(args[4] != null) __statement.setInt(count++, (java.lang.Integer)args[4]);
		if(args[5] != null) __statement.setInt(count++, (java.lang.Integer)args[5]);
		if(args[6] != null) __statement.setInt(count++, (java.lang.Integer)args[6]);
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

	private final static String __SQLText = "select pl.project_log_id, pl.project_id, pl.operate_id, pl.department_id, pl.manager_id, pl.design_phase, pl.operate_time, pl.log_type, pl.log_content, pl.alternate_field1, pl.alternate_field2, pl.alternate_field3, pl.status from project_logs pl where pl.project_log_id = ? and pl.project_id = ? and pl.operate_id = ? and pl.department_id in (select child_id from department_ids where department_id = ? ) and pl.manager_id = ? and pl.design_phase = ? and pl.log_type = ?" ;
	private final static String RESULTSETFIELDLIST = "project_log_id,project_id,operate_id,department_id,manager_id,design_phase,operate_time,log_type,log_content,alternate_field1,alternate_field2,alternate_field3,status";
	private final static String[] fieldNames = { "project_log_id", "project_id", "operate_id", "department_id", "manager_id", "design_phase", "log_type"};
}
