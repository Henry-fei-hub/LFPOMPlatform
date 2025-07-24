package pomplatform.cwd.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.bean.BaseCompanyWorkplaceAndServerManage;
import pomplatform.cwd.bean.ConditionCompanyWorkplaceAndServerManage;

public class QueryCompanyWorkplaceAndServerManage extends AbstractQuery<BaseCompanyWorkplaceAndServerManage, ConditionCompanyWorkplaceAndServerManage>
{

	private static final Logger __logger = Logger.getLogger(QueryCompanyWorkplaceAndServerManage.class);

	public QueryCompanyWorkplaceAndServerManage() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cw.company_workplace_id");
	}

	@Override
	public BaseCollection<BaseCompanyWorkplaceAndServerManage> executeQuery( KeyValuePair[] replacements, ConditionCompanyWorkplaceAndServerManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getWorkplaceName(), 
				condition.getCompanyId(), 
				condition.getCountryId(), 
				condition.getProvinceId(), 
				condition.getCityId(), 
				condition.getActive()
			);
	}

	@Override
	public BaseCompanyWorkplaceAndServerManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCompanyWorkplaceAndServerManage __base = new BaseCompanyWorkplaceAndServerManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyWorkplaceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkplaceName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCountryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvinceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkplaceDir(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkplaceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHasInit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setActive(GenericBase.__getBoolean(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[5]));
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

	private final static String __SQLText = "select cw.company_workplace_id, cw.company_id, cw.workplace_name, cw.country_id, cw.province_id, cw.city_id, cw.workplace_dir, cw.workplace_type, cw.has_init, cw.active from company_workplaces cw where cw.workplace_name like ? and cw.company_id = ? and cw.country_id = ? and cw.province_id = ? and cw.city_id = ? and cw.active = ? order by cw.company_workplace_id" ;
	private final static String RESULTSETFIELDLIST = "company_workplace_id,company_id,workplace_name,country_id,province_id,city_id,workplace_dir,workplace_type,has_init,active";
	private final static String[] fieldNames = { "workplace_name", "company_id", "country_id", "province_id", "city_id", "active"};
}
