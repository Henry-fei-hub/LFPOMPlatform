package pomplatform.projectTemplate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectTemplate.bean.BaseSprojecttemplateor;
import pomplatform.projectTemplate.bean.ConditionSprojecttemplateor;

public class QuerySprojecttemplateor extends AbstractQuery<BaseSprojecttemplateor, ConditionSprojecttemplateor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojecttemplateor.class);

	public QuerySprojecttemplateor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pt.project_template_id");
	}

	@Override
	public BaseCollection<BaseSprojecttemplateor> executeQuery( KeyValuePair[] replacements, ConditionSprojecttemplateor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectType(), 
				condition.getPlateId(), 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseSprojecttemplateor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojecttemplateor __base = new BaseSprojecttemplateor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectTemplateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT pt.project_template_id, pt.project_template_name, pt.project_type, pt.plate_id, pt.business_type FROM project_templates pt WHERE pt.project_type =? AND pt.plate_id =? AND pt.business_type =? AND pt.project_template_id!=1" ;
	private final static String RESULTSETFIELDLIST = "project_template_id,project_template_name,project_type,plate_id,business_type";
	private final static String[] fieldNames = { "project_type", "plate_id", "business_type"};
}
