package pomplatform.subjectType.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.subjectType.bean.BaseSubjectLinkSystemProcessType;
import pomplatform.subjectType.bean.ConditionSubjectLinkSystemProcessType;

public class QuerySubjectLinkSystemProcessType extends AbstractQuery<BaseSubjectLinkSystemProcessType, ConditionSubjectLinkSystemProcessType>
{

	private static final Logger __logger = Logger.getLogger(QuerySubjectLinkSystemProcessType.class);

	public QuerySubjectLinkSystemProcessType() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.process_type_id");
	}

	@Override
	public BaseCollection<BaseSubjectLinkSystemProcessType> executeQuery( KeyValuePair[] replacements, ConditionSubjectLinkSystemProcessType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSubjectTypeId()
			);
	}

	@Override
	public BaseSubjectLinkSystemProcessType generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSubjectLinkSystemProcessType __base = new BaseSubjectLinkSystemProcessType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentProcessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHasSelected(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "select a.process_type_id,a.process_type_name,a.parent_process_type_id ,case when (select count(*) from subject_process_types where process_type_id = a.process_type_id and subject_type_id = ?) > 0 then true else false end as has_selected from system_process_types a where a.is_enable = true ORDER BY a.process_type_id,a.parent_process_type_id" ;
	private final static String RESULTSETFIELDLIST = "process_type_id,process_type_name,parent_process_type_id,has_selected";
	private final static String[] fieldNames = { "subject_type_id"};
}
