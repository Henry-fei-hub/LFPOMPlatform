package pomplatform.projectattachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectattachment.bean.BaseSprojectattachmentpor;
import pomplatform.projectattachment.bean.ConditionSprojectattachmentpor;

public class QuerySprojectattachmentpor extends AbstractQuery<BaseSprojectattachmentpor, ConditionSprojectattachmentpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectattachmentpor.class);

	public QuerySprojectattachmentpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pa.project_attachment_id");
	}

	@Override
	public BaseCollection<BaseSprojectattachmentpor> executeQuery( KeyValuePair[] replacements, ConditionSprojectattachmentpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSprojectattachmentpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectattachmentpor __base = new BaseSprojectattachmentpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "select pa.project_attachment_id, pa.project_id, pa.stage_id, pa.upload_time, pa.attachment_file, pa.remark from project_attachments pa where pa.project_id = ? order by pa.project_attachment_id desc" ;
	private final static String RESULTSETFIELDLIST = "project_attachment_id,project_id,stage_id,upload_time,attachment_file,remark";
	private final static String[] fieldNames = { "project_id"};
}
