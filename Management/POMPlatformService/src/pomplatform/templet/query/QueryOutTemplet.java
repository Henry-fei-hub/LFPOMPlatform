package pomplatform.templet.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.templet.bean.BaseOutTemplet;
import pomplatform.templet.bean.ConditionOutTemplet;

public class QueryOutTemplet extends AbstractQuery<BaseOutTemplet, ConditionOutTemplet>
{

	private static final Logger __logger = Logger.getLogger(QueryOutTemplet.class);

	public QueryOutTemplet() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ot.out_templet_id");
	}

	@Override
	public BaseCollection<BaseOutTemplet> executeQuery( KeyValuePair[] replacements, ConditionOutTemplet condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseOutTemplet generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOutTemplet __base = new BaseOutTemplet();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOutTempletId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTempletName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDefaultTemplet(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDisableType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select ot.out_templet_id, ot.business_type, ot.templet_name, ot.create_time, ot.default_templet, ot.disable_type from out_templets ot where ot.business_type = ? order by ot.default_templet desc " ;
	private final static String RESULTSETFIELDLIST = "out_templet_id,business_type,templet_name,create_time,default_templet,disable_type";
	private final static String[] fieldNames = { "business_type"};
}
