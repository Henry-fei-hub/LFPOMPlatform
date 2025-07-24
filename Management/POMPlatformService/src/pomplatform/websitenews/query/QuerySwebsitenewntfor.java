package pomplatform.websitenews.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.websitenews.bean.BaseSwebsitenewntfor;
import pomplatform.websitenews.bean.ConditionSwebsitenewntfor;

public class QuerySwebsitenewntfor extends AbstractQuery<BaseSwebsitenewntfor, ConditionSwebsitenewntfor>
{

	private static final Logger __logger = Logger.getLogger(QuerySwebsitenewntfor.class);

	public QuerySwebsitenewntfor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("wn.website_new_id");
	}

	@Override
	public BaseCollection<BaseSwebsitenewntfor> executeQuery( KeyValuePair[] replacements, ConditionSwebsitenewntfor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getNewType(), 
				condition.getTitle(), 
				condition.getFileUrl(), 
				condition.getContent(), 
				condition.getWebsiteNewId(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseSwebsitenewntfor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSwebsitenewntfor __base = new BaseSwebsitenewntfor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setWebsiteNewId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setNewType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select wn.website_new_id, wn.title, wn.file_url, wn.content, wn.create_time, wn.new_type, wn.delete_flag, wn.order_num, wn.attachment_id, wn.attachment_name from website_news wn where wn.new_type = ? and wn.title like ? and wn.file_url like ? and wn.content like ? and wn.website_new_id = ? and wn.delete_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "website_new_id,title,file_url,content,create_time,new_type,delete_flag,order_num,attachment_id,attachment_name";
	private final static String[] fieldNames = { "new_type", "title", "file_url", "content", "website_new_id", "delete_flag"};
}
