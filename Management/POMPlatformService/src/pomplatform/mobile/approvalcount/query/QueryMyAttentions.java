package pomplatform.mobile.approvalcount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mobile.approvalcount.bean.BaseMyAttentions;
import pomplatform.mobile.approvalcount.bean.ConditionMyAttentions;

public class QueryMyAttentions extends AbstractQuery<BaseMyAttentions, ConditionMyAttentions>
{

	private static final Logger __logger = Logger.getLogger(QueryMyAttentions.class);

	public QueryMyAttentions() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.process_type");
	}

	@Override
	public BaseCollection<BaseMyAttentions> executeQuery( KeyValuePair[] replacements, ConditionMyAttentions condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMyAttentions generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMyAttentions __base = new BaseMyAttentions();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNeedDeal(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT aa.process_type, aa.process_type_name, COUNT(1) AS need_deal FROM ( SELECT spa.process_type, spt.process_type_name FROM system_process_attentions spa LEFT JOIN system_process_types spt ON spt.process_type_id = spa.process_type WHERE spa.status = ? AND spa.employee_id > 0 AND spa.delete_flag = 0 AND spa.employee_id = ? ) aa GROUP BY aa.process_type, aa.process_type_name" ;
	private final static String RESULTSETFIELDLIST = "process_type,process_type_name,need_deal";
	private final static String[] fieldNames = { "status", "employee_id"};
}
