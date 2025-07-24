package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseFileManagesWatermark;
import pomplatform.workflow.bean.ConditionFileManagesWatermark;

public class QueryFileManagesWatermark extends AbstractQuery<BaseFileManagesWatermark, ConditionFileManagesWatermark>
{

	private static final Logger __logger = Logger.getLogger(QueryFileManagesWatermark.class);

	public QueryFileManagesWatermark() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("fmw.watermark_id");
	}

	@Override
	public BaseCollection<BaseFileManagesWatermark> executeQuery( KeyValuePair[] replacements, ConditionFileManagesWatermark condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseFileManagesWatermark generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFileManagesWatermark __base = new BaseFileManagesWatermark();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setWatermarkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
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

	private final static String __SQLText = "select fmw.watermark_id, fmw.employee_id, fmw.file_id, fmw.file_url from file_manages_watermark fmw" ;
	private final static String RESULTSETFIELDLIST = "watermark_id,employee_id,file_id,file_url";
	private final static String[] fieldNames = { };
}
