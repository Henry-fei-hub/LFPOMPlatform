package pomplatform.k3code.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3code.bean.BaseAllCardManage;
import pomplatform.k3code.bean.ConditionAllCardManage;

public class QueryAllCardManage extends AbstractQuery<BaseAllCardManage, ConditionAllCardManage>
{

	private static final Logger __logger = Logger.getLogger(QueryAllCardManage.class);

	public QueryAllCardManage() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cm.card_manage_id");
	}

	@Override
	public BaseCollection<BaseAllCardManage> executeQuery( KeyValuePair[] replacements, ConditionAllCardManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getObjectType(), 
				condition.getEnabled(), 
				condition.getCardManageId()
			);
	}

	@Override
	public BaseAllCardManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAllCardManage __base = new BaseAllCardManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCardManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setObjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setObjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDefaultCard(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCurrencyType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
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

	private final static String __SQLText = "select cm.card_manage_id, cm.object_id, cm.object_type, cm.bank_id, cm.bank_account, cm.bank_address, cm.card_type, cm.default_card, cm.enabled, cm.currency_type from card_manages cm where cm.object_type = ? and cm.enabled = ? and cm.card_manage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "card_manage_id,object_id,object_type,bank_id,bank_account,bank_address,card_type,default_card,enabled,currency_type";
	private final static String[] fieldNames = { "object_type", "enabled", "card_manage_id"};
}
