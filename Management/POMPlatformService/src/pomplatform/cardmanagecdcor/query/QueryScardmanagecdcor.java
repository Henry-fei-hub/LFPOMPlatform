package pomplatform.cardmanagecdcor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cardmanagecdcor.bean.BaseScardmanagecdcor;
import pomplatform.cardmanagecdcor.bean.ConditionScardmanagecdcor;

public class QueryScardmanagecdcor extends AbstractQuery<BaseScardmanagecdcor, ConditionScardmanagecdcor>
{

	private static final Logger __logger = Logger.getLogger(QueryScardmanagecdcor.class);

	public QueryScardmanagecdcor() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cm.card_manage_id");
	}

	@Override
	public BaseCollection<BaseScardmanagecdcor> executeQuery( KeyValuePair[] replacements, ConditionScardmanagecdcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCardType(), 
				condition.getDefaultCard(), 
				condition.getCurrencyType(), 
				condition.getCmbcCodeId(), 
				condition.getBankAccount(), 
				condition.getBankAddress(), 
				condition.getCardManageId(), 
				condition.getObjectId(), 
				condition.getObjectType(), 
				condition.getBankId(), 
				condition.getTruePayment()
			);
	}

	@Override
	public BaseScardmanagecdcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScardmanagecdcor __base = new BaseScardmanagecdcor();
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
		if((val = __data[count++]) != null) __base.setCmbcCodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTruePayment(GenericBase.__getBoolean(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[10]));
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

	private final static String __SQLText = "select cm.card_manage_id, cm.object_id, cm.object_type, cm.bank_id, cm.bank_account, cm.bank_address, cm.card_type, cm.default_card, cm.enabled, cm.currency_type, cm.cmbc_code_id , cm.true_payment from card_manages cm where cm.card_type = ? and cm.default_card = ? and cm.currency_type = ? and cm.cmbc_code_id = ? and cm.bank_account like ? and cm.bank_address like ? and cm.card_manage_id = ? and cm.object_id = ? and cm.object_type = ? and cm.bank_id = ? and cm.true_payment = ? order by cm.object_id,cm.card_manage_id" ;
	private final static String RESULTSETFIELDLIST = "card_manage_id,object_id,object_type,bank_id,bank_account,bank_address,card_type,default_card,enabled,currency_type,cmbc_code_id,true_payment";
	private final static String[] fieldNames = { "card_type", "default_card", "currency_type", "cmbc_code_id", "bank_account", "bank_address", "card_manage_id", "object_id", "object_type", "bank_id", "true_payment"};
}
