package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseMmainprojectclientccmor;
import pomplatform.mainProjectInfo.bean.ConditionMmainprojectclientccmor;

public class QueryMmainprojectclientccmor extends AbstractQuery<BaseMmainprojectclientccmor, ConditionMmainprojectclientccmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMmainprojectclientccmor.class);

	public QueryMmainprojectclientccmor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mpc.main_project_id");
	}

	@Override
	public BaseCollection<BaseMmainprojectclientccmor> executeQuery( KeyValuePair[] replacements, ConditionMmainprojectclientccmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getClientRole(), 
				condition.getMainProjectId(),
                                condition.getClientName()
			);
	}

	@Override
	public BaseMmainprojectclientccmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMmainprojectclientccmor __base = new BaseMmainprojectclientccmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setClientName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientJob(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientWeixin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientRole(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
                if(args[2] != null) __statement.setString(count++, (java.lang.String)args[2]);
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

	private final static String __SQLText = "select mpc.main_project_id, mpc.client_id , c.client_name, c.client_phone, c.client_company, c.client_address, c.client_job, c.client_weixin, c.client_qq, c.client_email, c.client_role from main_project_clients mpc left join clients c on mpc.client_id = c.client_id where c.client_role = ? and mpc.main_project_id = ? and c.client_name like ? order by c.client_role" ;
	private final static String RESULTSETFIELDLIST = "main_project_id,client_id,client_name,client_phone,client_company,client_address,client_job,client_weixin,client_qq,client_email,client_role";
	private final static String[] fieldNames = { "client_role", "main_project_id", "client_name"};
}
