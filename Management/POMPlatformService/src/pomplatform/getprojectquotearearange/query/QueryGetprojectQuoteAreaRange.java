package pomplatform.getprojectquotearearange.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getprojectquotearearange.bean.BaseGetprojectQuoteAreaRange;
import pomplatform.getprojectquotearearange.bean.ConditionGetprojectQuoteAreaRange;

public class QueryGetprojectQuoteAreaRange extends AbstractQuery<BaseGetprojectQuoteAreaRange, ConditionGetprojectQuoteAreaRange>
{

	private static final Logger __logger = Logger.getLogger(QueryGetprojectQuoteAreaRange.class);

	public QueryGetprojectQuoteAreaRange() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseGetprojectQuoteAreaRange> executeQuery( KeyValuePair[] replacements, ConditionGetprojectQuoteAreaRange condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAreaRange(), 
				condition.getAreaRange(), 
				condition.getProjectQuoteTemplatesParentId(), 
				condition.getProjectQuoteTemplateId()
			);
	}

	@Override
	public BaseGetprojectQuoteAreaRange generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetprojectQuoteAreaRange __base = new BaseGetprojectQuoteAreaRange();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectQuoteAreaRangeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectQuoteTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaRangeStart(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAreaRangeEnd(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAreaPrice(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[0]));
		if(args[1] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT * FROM project_quote_area_range WHERE area_range_start <=? AND area_range_end >? AND project_quote_templates_parent_id=? ANd project_quote_template_id=?" ;
	private final static String RESULTSETFIELDLIST = "project_quote_area_range_id,project_quote_templates_parent_id,project_quote_template_id,area_range_start,area_range_end,area_price,remark";
	private final static String[] fieldNames = { "area_range", "area_range", "project_quote_templates_parent_id", "project_quote_template_id"};
}
