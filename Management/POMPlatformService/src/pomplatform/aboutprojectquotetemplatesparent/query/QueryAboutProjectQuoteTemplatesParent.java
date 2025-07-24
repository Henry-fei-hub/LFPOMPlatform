package pomplatform.aboutprojectquotetemplatesparent.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.aboutprojectquotetemplatesparent.bean.BaseAboutProjectQuoteTemplatesParent;
import pomplatform.aboutprojectquotetemplatesparent.bean.ConditionAboutProjectQuoteTemplatesParent;

public class QueryAboutProjectQuoteTemplatesParent extends AbstractQuery<BaseAboutProjectQuoteTemplatesParent, ConditionAboutProjectQuoteTemplatesParent>
{

	private static final Logger __logger = Logger.getLogger(QueryAboutProjectQuoteTemplatesParent.class);

	public QueryAboutProjectQuoteTemplatesParent() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pqtp.project_quote_templates_parent_id");
	}

	@Override
	public BaseCollection<BaseAboutProjectQuoteTemplatesParent> executeQuery( KeyValuePair[] replacements, ConditionAboutProjectQuoteTemplatesParent condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getParentName(), 
				condition.getBusinessType(), 
				condition.getCompanyId(), 
				condition.getCreateEmployeeId(), 
				condition.getCreateDateStart(), 
				condition.getCreateDateEnd(), 
				condition.getRemark()
			);
	}

	@Override
	public BaseAboutProjectQuoteTemplatesParent generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAboutProjectQuoteTemplatesParent __base = new BaseAboutProjectQuoteTemplatesParent();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "select pqtp.project_quote_templates_parent_id, pqtp.parent_name, pqtp.business_type, pqtp.company_id, pqtp.create_employee_id, pqtp.create_date, pqtp.remark from project_quote_templates_parent pqtp where pqtp.parent_name like ? and pqtp.business_type = ? and pqtp.company_id = ? and pqtp.create_employee_id = ? and pqtp.create_date between ? and ? and pqtp.remark = ?" ;
	private final static String RESULTSETFIELDLIST = "project_quote_templates_parent_id,parent_name,business_type,company_id,create_employee_id,create_date,remark";
	private final static String[] fieldNames = { "parent_name", "business_type", "company_id", "create_employee_id", "create_date_start", "create_date_end", "remark"};
}
