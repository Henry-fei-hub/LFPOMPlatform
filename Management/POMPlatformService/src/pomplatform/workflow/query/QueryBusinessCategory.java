package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseBusinessCategory;
import pomplatform.workflow.bean.ConditionBusinessCategory;


public class QueryBusinessCategory extends AbstractQuery<BaseBusinessCategory, ConditionBusinessCategory>
{

	private static final Logger __logger = Logger.getLogger(QueryBusinessCategory.class);

	public QueryBusinessCategory() throws java.sql.SQLException
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseBusinessCategory> executeQuery( KeyValuePair[] replacements, ConditionBusinessCategory condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseBusinessCategory generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBusinessCategory __base = new BaseBusinessCategory();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessCategoryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessCategoryName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessCategoryCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
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

	private final static String __SQLText = "select * from business_category where parent_id > 0" ;
	private final static String RESULTSETFIELDLIST = "business_category_id,business_category_name,business_category_code,parent_id";
	private final static String[] fieldNames = { };
}
