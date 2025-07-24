package pomplatform.projectStageStorages.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectStageStorages.bean.BaseSprojectstagestoragepor;
import pomplatform.projectStageStorages.bean.ConditionSprojectstagestoragepor;

public class QuerySprojectstagestoragepor extends AbstractQuery<BaseSprojectstagestoragepor, ConditionSprojectstagestoragepor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectstagestoragepor.class);

	public QuerySprojectstagestoragepor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pss.project_stage_storage_id");
	}

	@Override
	public BaseCollection<BaseSprojectstagestoragepor> executeQuery( KeyValuePair[] replacements, ConditionSprojectstagestoragepor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectStageStorageId()
			);
	}

	@Override
	public BaseSprojectstagestoragepor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectstagestoragepor __base = new BaseSprojectstagestoragepor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageStorageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select pss.project_stage_storage_id, pss.project_id, pss.stage_id, pss.percent, pss.project_amount, pss.stage_name, pss.remark from project_stage_storages pss where pss.project_stage_storage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_stage_storage_id,project_id,stage_id,percent,project_amount,stage_name,remark";
	private final static String[] fieldNames = { "project_stage_storage_id"};
}
