package pomplatform.annoucement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.annoucement.bean.BaseSannoucementaaaor;
import pomplatform.annoucement.bean.ConditionSannoucementaaaor;

public class QuerySannoucementaaaor extends AbstractQuery<BaseSannoucementaaaor, ConditionSannoucementaaaor>
{

	private static final Logger __logger = Logger.getLogger(QuerySannoucementaaaor.class);

	public QuerySannoucementaaaor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.annoucement_id");
	}

	@Override
	public BaseCollection<BaseSannoucementaaaor> executeQuery( KeyValuePair[] replacements, ConditionSannoucementaaaor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getOperateEmployeeId(), 
				condition.getAnnoucementTime(), 
				condition.getAnnoucementTitle(), 
				condition.getAnnoucementContent()
			);
	}

	@Override
	public BaseSannoucementaaaor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSannoucementaaaor __base = new BaseSannoucementaaaor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAnnoucementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAnnoucementTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnoucementContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnoucementTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAnnoucementEmployeeIds(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnoucementEmployeeNames(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select a.annoucement_id, a.main_project_id, a.customer_id, a.annoucement_title, a.annoucement_content, a.annoucement_time, a.annoucement_employee_ids, a.annoucement_employee_names, a.operate_employee_id, a.operate_time, a.remark, a.status from annoucements a where a.status = ? and a.operate_employee_id = ? and a.annoucement_time = ? and a.annoucement_title like ? and a.annoucement_content like ?" ;
	private final static String RESULTSETFIELDLIST = "annoucement_id,main_project_id,customer_id,annoucement_title,annoucement_content,annoucement_time,annoucement_employee_ids,annoucement_employee_names,operate_employee_id,operate_time,remark,status";
	private final static String[] fieldNames = { "status", "operate_employee_id", "annoucement_time", "annoucement_title", "annoucement_content"};
}
