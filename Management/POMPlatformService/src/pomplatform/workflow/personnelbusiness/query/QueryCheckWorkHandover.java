package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.bean.ConditionCheckWorkHandover;

public class QueryCheckWorkHandover extends AbstractQuery<BaseCheckWorkHandover, ConditionCheckWorkHandover>
{

	private static final Logger __logger = Logger.getLogger(QueryCheckWorkHandover.class);

	public QueryCheckWorkHandover() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("wh.work_handover_id");
	}

	@Override
	public BaseCollection<BaseCheckWorkHandover> executeQuery( KeyValuePair[] replacements, ConditionCheckWorkHandover condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getType(), 
				condition.getLinkId(), 
				condition.getFromEmployeeId(), 
				condition.getToEmployeeId()
			);
	}

	@Override
	public BaseCheckWorkHandover generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCheckWorkHandover __base = new BaseCheckWorkHandover();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setWorkHandoverId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFromEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setToEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select wh.work_handover_id, wh.type, wh.link_id, wh.name, wh.content, wh.from_employee_id, wh.to_employee_id, wh.create_time, e.employee_name from work_handovers wh left join employees e on wh.to_employee_id = e.employee_id where wh.type = ? and wh.link_id = ? and wh.from_employee_id = ? and wh.to_employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "work_handover_id,type,link_id,name,content,from_employee_id,to_employee_id,create_time,employee_name";
	private final static String[] fieldNames = { "type", "link_id", "from_employee_id", "to_employee_id"};
}
