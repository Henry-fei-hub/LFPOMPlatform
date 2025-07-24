package pomplatform.areas.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.areas.bean.BaseSareaaaor;
import pomplatform.areas.bean.ConditionSareaaaor;

public class QuerySareaaaor extends AbstractQuery<BaseSareaaaor, ConditionSareaaaor>
{

	private static final Logger __logger = Logger.getLogger(QuerySareaaaor.class);

	public QuerySareaaaor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.area_id");
	}

	@Override
	public BaseCollection<BaseSareaaaor> executeQuery( KeyValuePair[] replacements, ConditionSareaaaor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAreaName(), 
				condition.getAreaLevel(), 
				condition.getParentId()
			);
	}

	@Override
	public BaseSareaaaor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSareaaaor __base = new BaseSareaaaor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAreaNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAllName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAreaLevel(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select a.area_id, a.area_name, a.area_name_en, a.parent_id, a.all_name, a.area_level from areas a where a.area_name like ? and a.area_level = ? and parent_id = ? order by area_id" ;
	private final static String RESULTSETFIELDLIST = "area_id,area_name,area_name_en,parent_id,all_name,area_level";
	private final static String[] fieldNames = { "area_name", "area_level","parent_id"};
}
