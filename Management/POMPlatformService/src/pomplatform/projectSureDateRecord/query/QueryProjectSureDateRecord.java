package pomplatform.projectSureDateRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSureDateRecord.bean.BaseProjectSureDateRecord;
import pomplatform.projectSureDateRecord.bean.ConditionProjectSureDateRecord;

public class QueryProjectSureDateRecord extends AbstractQuery<BaseProjectSureDateRecord, ConditionProjectSureDateRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectSureDateRecord.class);

	public QueryProjectSureDateRecord() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseProjectSureDateRecord> executeQuery( KeyValuePair[] replacements, ConditionProjectSureDateRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getProjectName(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseProjectSureDateRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectSureDateRecord __base = new BaseProjectSureDateRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSureDate(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select a.project_id,a.contract_code,a.project_name,a.plate_id,a.project_manage_id ,b.sure_date from projects a left join (select MAX(settlement_date) as sure_date,project_id from project_settlements GROUP BY project_id) as b on a.project_id = b.project_id where a.plate_id = ? and a.project_name like ? and b.sure_date BETWEEN ? and ? ORDER BY a.plate_id,a.project_id,b.sure_date desc" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_name,plate_id,project_manage_id,sure_date";
	private final static String[] fieldNames = { "plate_id", "project_name", "start_date", "end_date"};
}
