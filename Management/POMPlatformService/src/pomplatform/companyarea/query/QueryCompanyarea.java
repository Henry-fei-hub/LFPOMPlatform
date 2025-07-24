package pomplatform.companyarea.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.companyarea.bean.BaseCompanyarea;
import pomplatform.companyarea.bean.ConditionCompanyarea;

public class QueryCompanyarea extends AbstractQuery<BaseCompanyarea, ConditionCompanyarea>
{

	private static final Logger __logger = Logger.getLogger(QueryCompanyarea.class);

	public QueryCompanyarea() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ca.company_area_id");
	}

	@Override
	public BaseCollection<BaseCompanyarea> executeQuery( KeyValuePair[] replacements, ConditionCompanyarea condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAreaId(), 
				condition.getCompanyRecordId()
			);
	}

	@Override
	public BaseCompanyarea generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCompanyarea __base = new BaseCompanyarea();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyNameSimple(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAreaNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAllName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAreaLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select ca.company_area_id, ca.company_id, ca.area_id, cr.company_name, cr.company_code, cr.is_enabled, cr.company_no, cr.company_name_simple, a.area_name, a.area_name_en, a.parent_id, a.all_name, a.area_level, a.region from company_areas ca left join company_records cr on ca.company_id =cr.company_record_id left join areas a on a.area_id = ca.area_id where ca.area_id =? and cr.company_record_id =? order by ca.company_area_id" ;
	private final static String RESULTSETFIELDLIST = "company_area_id,company_id,area_id,company_name,company_code,is_enabled,company_no,company_name_simple,area_name,area_name_en,parent_id,all_name,area_level,region";
	private final static String[] fieldNames = { "area_id", "company_record_id"};
}
