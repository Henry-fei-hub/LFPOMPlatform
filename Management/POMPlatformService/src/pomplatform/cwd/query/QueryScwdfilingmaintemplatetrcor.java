package pomplatform.cwd.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.bean.BaseScwdfilingmaintemplatetrcor;
import pomplatform.cwd.bean.ConditionScwdfilingmaintemplatetrcor;

public class QueryScwdfilingmaintemplatetrcor extends AbstractQuery<BaseScwdfilingmaintemplatetrcor, ConditionScwdfilingmaintemplatetrcor>
{

	private static final Logger __logger = Logger.getLogger(QueryScwdfilingmaintemplatetrcor.class);

	public QueryScwdfilingmaintemplatetrcor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cfmt.cwd_filing_main_template_id");
	}

	@Override
	public BaseCollection<BaseScwdfilingmaintemplatetrcor> executeQuery( KeyValuePair[] replacements, ConditionScwdfilingmaintemplatetrcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTemplateName(), 
				condition.getRemark(), 
				condition.getCwdFilingMainTemplateId(), 
				condition.getProjectType(), 
				condition.getOperatorId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseScwdfilingmaintemplatetrcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScwdfilingmaintemplatetrcor __base = new BaseScwdfilingmaintemplatetrcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCwdFilingMainTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTemplateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select cfmt.cwd_filing_main_template_id, cfmt.template_name, cfmt.project_type, cfmt.operator_id, cfmt.department_id, cfmt.remark, cfmt.create_time from cwd_filing_main_templates cfmt where cfmt.template_name like ? and cfmt.remark like ? and cfmt.cwd_filing_main_template_id = ? and cfmt.project_type = ? and cfmt.operator_id = ? and cfmt.department_id = ?" ;
	private final static String RESULTSETFIELDLIST = "cwd_filing_main_template_id,template_name,project_type,operator_id,department_id,remark,create_time";
	private final static String[] fieldNames = { "template_name", "remark", "cwd_filing_main_template_id", "project_type", "operator_id", "department_id"};
}
