package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseSheetStageFinishPercentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionSheetStageFinishPercentOfRevenue;

public class QuerySheetStageFinishPercentOfRevenue extends AbstractQuery<BaseSheetStageFinishPercentOfRevenue, ConditionSheetStageFinishPercentOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QuerySheetStageFinishPercentOfRevenue.class);

	public QuerySheetStageFinishPercentOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_id");
	}

	@Override
	public BaseCollection<BaseSheetStageFinishPercentOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionSheetStageFinishPercentOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getProjectId(), 
				condition.getStageId()
			);
	}

	@Override
	public BaseSheetStageFinishPercentOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSheetStageFinishPercentOfRevenue __base = new BaseSheetStageFinishPercentOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHasAttachment(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentPercent(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT abc.*,case when abc.assign_integral = 0 then 0 else round(abc.sure_integral/abc.assign_integral,4) end as finish_percent,case when abc.has_attachment = 0 then 0 else 1 end attachment_percent from (select a.project_id,a.stage_id,a.PERCENT,case when a.project_amount is null then 0 else round(a.project_amount,0) end as assign_integral,(select round(sum(total_amount),0) from project_settlements where project_id = a.project_id and stage_id = a.stage_id and settlement_date BETWEEN ? and ?) as sure_integral ,(select count(*) from project_attachments where project_id = a.project_id and stage_id = a.stage_id and upload_time BETWEEN ? and ?) as has_attachment from project_stages a ) abc where abc.project_id = ? and abc.stage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,stage_id,percent,assign_integral,sure_integral,finish_percent,has_attachment,attachment_percent";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "project_id", "stage_id"};
}
