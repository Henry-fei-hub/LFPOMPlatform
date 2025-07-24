package pomplatform.clientctractor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.clientctractor.bean.BaseMclientctractor;
import pomplatform.clientctractor.bean.ConditionMclientctractor;

public class QueryMclientctractor extends AbstractQuery<BaseMclientctractor, ConditionMclientctractor>
{

	private static final Logger __logger = Logger.getLogger(QueryMclientctractor.class);

	public QueryMclientctractor() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cl.client_id");
	}

	@Override
	public BaseCollection<BaseMclientctractor> executeQuery( KeyValuePair[] replacements, ConditionMclientctractor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getClientName(), 
				condition.getClientPhone(), 
				condition.getClientCompany(), 
				condition.getClientJob(), 
				condition.getClientWeixin(), 
				condition.getClientQq(), 
				condition.getClientEmail(), 
				condition.getClientRole()
			);
	}

	@Override
	public BaseMclientctractor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMclientctractor __base = new BaseMclientctractor();
		int count = 0;
		Object val;
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "SELECT cl.client_id, cl.client_name, cl.client_phone, cl.client_company, cl.client_address, cl.client_job, cl.client_weixin, cl.client_qq, cl.client_email, cl.client_role FROM clients cl, contract_clients ctc WHERE cl.client_id = ctc.client_id AND ctc.contract_id = ? AND cl.client_name LIKE ? AND cl.client_phone LIKE ? AND cl.client_company LIKE ? AND cl.client_job LIKE ? AND cl.client_weixin LIKE ? AND cl.client_qq LIKE ? AND cl.client_email LIKE ? AND cl.client_role = ?" ;
	private final static String RESULTSETFIELDLIST = "client_id,client_name,client_phone,client_company,client_address,client_job,client_weixin,client_qq,client_email,client_role";
	private final static String[] fieldNames = { "contract_id", "client_name", "client_phone", "client_company", "client_job", "client_weixin", "client_qq", "client_email", "client_role"};
}
