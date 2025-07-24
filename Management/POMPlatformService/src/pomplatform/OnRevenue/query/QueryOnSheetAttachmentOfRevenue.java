package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseOnSheetAttachmentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnSheetAttachmentOfRevenue;

public class QueryOnSheetAttachmentOfRevenue extends AbstractQuery<BaseOnSheetAttachmentOfRevenue, ConditionOnSheetAttachmentOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSheetAttachmentOfRevenue.class);

	public QueryOnSheetAttachmentOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.* from ( select a.project_attachment_id");
	}

	@Override
	public BaseCollection<BaseOnSheetAttachmentOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionOnSheetAttachmentOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getIsHandle()
			);
	}

	@Override
	public BaseOnSheetAttachmentOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSheetAttachmentOfRevenue __base = new BaseOnSheetAttachmentOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHandle(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
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

	private final static String __SQLText = "select abc.* from ( select a.project_attachment_id,a.is_handle,a.project_id,a.stage_id,a.attachment_file,a.upload_time,b.contract_code as sheet_code,b.project_name ,substr(b.contract_code,1,strpos(b.contract_code,'-')-4) as contract_code from project_attachments a left join projects b on a.project_id = b.project_id where b.contract_code is not null ORDER BY a.project_id,a.upload_time ) abc where abc.contract_code = ? and abc.is_handle = ?" ;
	private final static String RESULTSETFIELDLIST = "project_attachment_id,is_handle,project_id,stage_id,attachment_file,upload_time,sheet_code,project_name,contract_code";
	private final static String[] fieldNames = { "contract_code", "is_handle"};
}
