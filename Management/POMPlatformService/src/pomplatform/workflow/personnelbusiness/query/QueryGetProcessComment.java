package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseGetProcessComment;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetProcessComment;

public class QueryGetProcessComment extends AbstractQuery<BaseGetProcessComment, ConditionGetProcessComment>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProcessComment.class);

	public QueryGetProcessComment() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.back_view_name");
	}

	@Override
	public BaseCollection<BaseGetProcessComment> executeQuery( KeyValuePair[] replacements, ConditionGetProcessComment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId()
			);
	}

	@Override
	public BaseGetProcessComment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProcessComment __base = new BaseGetProcessComment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT a.back_view_name, a.process_comment, b.employee_name, a.operate_time from system_process_instance_activities a LEFT JOIN employees b on a.employee_id = b.employee_id where a.process_type = ? and a.business_id = ? and a.activity_type in (2,3) and a.status = 2 order by a.activity_id" ;
	private final static String RESULTSETFIELDLIST = "back_view_name,process_comment,employee_name,operate_time";
	private final static String[] fieldNames = { "process_type", "business_id"};
}
