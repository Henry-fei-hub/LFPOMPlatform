package pomplatform.cwd.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.bean.BaseOssConfigManage;
import pomplatform.cwd.bean.ConditionOssConfigManage;

public class QueryOssConfigManage extends AbstractQuery<BaseOssConfigManage, ConditionOssConfigManage>
{

	private static final Logger __logger = Logger.getLogger(QueryOssConfigManage.class);

	public QueryOssConfigManage() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("coc.oss_config_id");
	}

	@Override
	public BaseCollection<BaseOssConfigManage> executeQuery( KeyValuePair[] replacements, ConditionOssConfigManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getOssAddress(), 
				condition.getOssBucket(), 
				condition.getOssAccessKeyId(), 
				condition.getOssAccessKeySecret()
			);
	}

	@Override
	public BaseOssConfigManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOssConfigManage __base = new BaseOssConfigManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOssConfigId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOssAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOssBucket(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOssAccessKeyId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOssAccessKeySecret(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select coc.oss_config_id, coc.oss_address, coc.oss_bucket, coc.oss_access_key_id, coc.oss_access_key_secret from cwd_oss_config coc where coc.oss_address like ? and coc.oss_bucket like ? and coc.oss_access_key_id like ? and coc.oss_access_key_secret like ? order by coc.oss_config_id" ;
	private final static String RESULTSETFIELDLIST = "oss_config_id,oss_address,oss_bucket,oss_access_key_id,oss_access_key_secret";
	private final static String[] fieldNames = { "oss_address", "oss_bucket", "oss_access_key_id", "oss_access_key_secret"};
}
