package pomplatform.taskmanage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.taskmanage.bean.BaseScwdtasktemplatetccor;
import pomplatform.taskmanage.bean.ConditionScwdtasktemplatetccor;

public class QueryScwdtasktemplatetccor extends AbstractQuery<BaseScwdtasktemplatetccor, ConditionScwdtasktemplatetccor>
{

	private static final Logger __logger = Logger.getLogger(QueryScwdtasktemplatetccor.class);

	public QueryScwdtasktemplatetccor() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ctt.cwd_task_template_id");
	}

	@Override
	public BaseCollection<BaseScwdtasktemplatetccor> executeQuery( KeyValuePair[] replacements, ConditionScwdtasktemplatetccor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTemplateName(), 
				condition.getCompanyNo(), 
				condition.getCwdTaskTemplateId(), 
				condition.getProjectArea(), 
				condition.getOperator(), 
				condition.getDepartmentId(), 
				condition.getCompanyId(), 
				condition.getNumberOfDay(), 
				condition.getProjectLevel(), 
				condition.getNumberOfParticipant()
			);
	}

	@Override
	public BaseScwdtasktemplatetccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScwdtasktemplatetccor __base = new BaseScwdtasktemplatetccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTemplateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectArea(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNumberOfDay(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNumberOfParticipant(GenericBase.__getInt(val));
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
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "select ctt.cwd_task_template_id, ctt.template_name, ctt.project_area, ctt.operator, ctt.create_time, ctt.department_id, ctt.company_id, ctt.company_no, ctt.number_of_day, ctt.project_level, ctt.number_of_participant from cwd_task_templates ctt where ctt.template_name like ? and ctt.company_no like ? and ctt.cwd_task_template_id = ? and ctt.project_area = ? and ctt.operator = ? and ctt.department_id = ? and ctt.company_id = ? and ctt.number_of_day = ? and ctt.project_level = ? and ctt.number_of_participant = ?" ;
	private final static String RESULTSETFIELDLIST = "cwd_task_template_id,template_name,project_area,operator,create_time,department_id,company_id,company_no,number_of_day,project_level,number_of_participant";
	private final static String[] fieldNames = { "template_name", "company_no", "cwd_task_template_id", "project_area", "operator", "department_id", "company_id", "number_of_day", "project_level", "number_of_participant"};
}
