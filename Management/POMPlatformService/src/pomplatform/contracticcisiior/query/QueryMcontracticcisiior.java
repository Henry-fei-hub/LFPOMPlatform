package pomplatform.contracticcisiior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contracticcisiior.bean.BaseMcontracticcisiior;
import pomplatform.contracticcisiior.bean.ConditionMcontracticcisiior;

public class QueryMcontracticcisiior extends AbstractQuery<BaseMcontracticcisiior, ConditionMcontracticcisiior>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontracticcisiior.class);

	public QueryMcontracticcisiior() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	ct.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontracticcisiior> executeQuery( KeyValuePair[] replacements, ConditionMcontracticcisiior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getInvoiceType(), 
				condition.getSign(), 
				condition.getInvoiceCode(), 
				condition.getInvoiceNumber()
			);
	}

	@Override
	public BaseMcontracticcisiior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontracticcisiior __base = new BaseMcontracticcisiior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "SELECT DISTINCT ct.contract_id, ct.info_code, ct.business_type, ct.contract_code, ct.contract_name, ct.contract_type, ct.order_no, ct.create_time, ct.signing_money_sum FROM contracts ct, invoices i WHERE i.contract_id = ct.contract_id AND ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND i.invoice_type = ? AND i.sign = ? AND i.invoice_code LIKE ? AND i.invoice_number LIKE ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,info_code,business_type,contract_code,contract_name,contract_type,order_no,create_time,signing_money_sum";
	private final static String[] fieldNames = { "contract_id", "contract_code", "contract_name", "invoice_type", "sign", "invoice_code", "invoice_number"};
}
