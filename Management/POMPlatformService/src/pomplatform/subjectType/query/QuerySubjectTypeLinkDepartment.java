package pomplatform.subjectType.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.subjectType.bean.BaseSubjectTypeLinkDepartment;
import pomplatform.subjectType.bean.ConditionSubjectTypeLinkDepartment;

public class QuerySubjectTypeLinkDepartment extends AbstractQuery<BaseSubjectTypeLinkDepartment, ConditionSubjectTypeLinkDepartment>
{

	private static final Logger __logger = Logger.getLogger(QuerySubjectTypeLinkDepartment.class);

	public QuerySubjectTypeLinkDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.department_id");
	}

	@Override
	public BaseCollection<BaseSubjectTypeLinkDepartment> executeQuery( KeyValuePair[] replacements, ConditionSubjectTypeLinkDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSubjectTypeId()
			);
	}

	@Override
	public BaseSubjectTypeLinkDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSubjectTypeLinkDepartment __base = new BaseSubjectTypeLinkDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.department_id,a.department_name,a.parent_id ,case when (select count(*) from subject_departments where department_id = a.department_id and subject_type_id = ?) > 0 then true else false end as has_selected from departments a where a.enabled = TRUE ORDER BY a.department_id,a.parent_id" ;
	private final static String RESULTSETFIELDLIST = "department_id,department_name,parent_id,has_selected";
	private final static String[] fieldNames = { "subject_type_id"};
}
