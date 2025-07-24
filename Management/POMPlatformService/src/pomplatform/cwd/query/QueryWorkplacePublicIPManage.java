package pomplatform.cwd.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.bean.BaseWorkplacePublicIPManage;
import pomplatform.cwd.bean.ConditionWorkplacePublicIPManage;

public class QueryWorkplacePublicIPManage extends AbstractQuery<BaseWorkplacePublicIPManage, ConditionWorkplacePublicIPManage>
{

	private static final Logger __logger = Logger.getLogger(QueryWorkplacePublicIPManage.class);

	public QueryWorkplacePublicIPManage() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cwpi.company_workplace_public_ip_id");
	}

	@Override
	public BaseCollection<BaseWorkplacePublicIPManage> executeQuery( KeyValuePair[] replacements, ConditionWorkplacePublicIPManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getActive(), 
				condition.getCompanyWorkplaceId(), 
				condition.getIpAddress()
			);
	}

	@Override
	public BaseWorkplacePublicIPManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseWorkplacePublicIPManage __base = new BaseWorkplacePublicIPManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyWorkplacePublicIpId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyWorkplaceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkplaceName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIpAddress(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "select cwpi.company_workplace_public_ip_id, cwpi.company_workplace_id, cw.workplace_name, cwpi.ip_address, cwpi.active from company_workplace_public_ips cwpi left join company_workplaces cw on cwpi.company_workplace_id = cw.company_workplace_id where cwpi.active = ? and cwpi.company_workplace_id = ? and cwpi.ip_address like ? order by cwpi.company_workplace_public_ip_id desc" ;
	private final static String RESULTSETFIELDLIST = "company_workplace_public_ip_id,company_workplace_id,workplace_name,ip_address,active";
	private final static String[] fieldNames = { "active", "company_workplace_id", "ip_address"};
}
