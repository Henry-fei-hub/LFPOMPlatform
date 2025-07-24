package pomplatform.mcontractisubccacccor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcontractisubccacccor.bean.BaseMcontractisubccacccor;
import pomplatform.mcontractisubccacccor.bean.ConditionMcontractisubccacccor;

public class QueryMcontractisubccacccor extends AbstractQuery<BaseMcontractisubccacccor, ConditionMcontractisubccacccor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractisubccacccor.class);

	public QueryMcontractisubccacccor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ct.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontractisubccacccor> executeQuery( KeyValuePair[] replacements, ConditionMcontractisubccacccor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getCustomerName(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseMcontractisubccacccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractisubccacccor __base = new BaseMcontractisubccacccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnReciveMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnReciveContractMoney(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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
//	private final static String __SQLText = "SELECT ct.contract_id, ct.contract_code, ct.contract_name, ct.signing_money_sum, ct.customer_name, i.invoice_amount, ca.borrow_money, CASE WHEN i.invoice_amount ISNULL OR ca.borrow_money ISNULL THEN CASE WHEN i.invoice_amount ISNULL AND ca.borrow_money ISNULL THEN 0 ELSE CASE WHEN i.invoice_amount ISNULL THEN 0 - ca.borrow_money WHEN ca.borrow_money ISNULL THEN i.invoice_amount END END ELSE i.invoice_amount - ca.borrow_money END AS un_recive_money, CASE WHEN ct.signing_money_sum ISNULL OR ca.borrow_money ISNULL THEN CASE WHEN ct.signing_money_sum ISNULL AND ca.borrow_money ISNULL THEN 0 ELSE CASE WHEN ct.signing_money_sum ISNULL THEN 0 - ca.borrow_money WHEN ca.borrow_money ISNULL THEN ct.signing_money_sum END END ELSE ct.signing_money_sum - ca.borrow_money END AS un_recive_contract_money FROM (SELECT * FROM contracts WHERE info_code IN (SELECT info_code FROM main_projects WHERE design_team = ?))ct LEFT JOIN ( SELECT contract_id, SUM (invoice_amount) AS invoice_amount FROM invoices WHERE sign IN (1, 2) AND contract_id > 0 GROUP BY contract_id ) i ON i.contract_id = ct.contract_id LEFT JOIN ( SELECT SUM (borrow_money) AS borrow_money, contract_id FROM capitals WHERE contract_id > 0 AND money_attribute = 1 GROUP BY contract_id ) ca ON ca.contract_id = ct.contract_id WHERE ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.customer_name LIKE ? AND ct.contract_name LIKE ? ORDER BY contract_id" ;

	private final static String __SQLText = "SELECT ct.contract_id, ct.contract_code, ct.contract_name, ct.signing_money_sum, ct.customer_name, i.invoice_amount, ca.borrow_money, CASE WHEN i.invoice_amount ISNULL OR ca.borrow_money ISNULL THEN CASE WHEN i.invoice_amount ISNULL AND ca.borrow_money ISNULL THEN 0 ELSE CASE WHEN i.invoice_amount ISNULL THEN 0 - ca.borrow_money WHEN ca.borrow_money ISNULL THEN i.invoice_amount END END ELSE i.invoice_amount - ca.borrow_money END AS un_recive_money, CASE WHEN ct.signing_money_sum ISNULL OR ca.borrow_money ISNULL THEN CASE WHEN ct.signing_money_sum ISNULL AND ca.borrow_money ISNULL THEN 0 ELSE CASE WHEN ct.signing_money_sum ISNULL THEN 0 - ca.borrow_money WHEN ca.borrow_money ISNULL THEN ct.signing_money_sum END END ELSE ct.signing_money_sum - ca.borrow_money END AS un_recive_contract_money FROM contracts ct LEFT JOIN ( SELECT contract_id, SUM (invoice_amount) AS invoice_amount FROM invoices WHERE sign IN (1, 2) AND contract_id > 0 GROUP BY contract_id ) i ON i.contract_id = ct.contract_id LEFT JOIN ( SELECT SUM (borrow_money) AS borrow_money, contract_id FROM capitals WHERE contract_id > 0 AND money_attribute = 1 GROUP BY contract_id ) ca ON ca.contract_id = ct.contract_id WHERE ct.business_type = ? AND ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.customer_name LIKE ? AND ct.contract_name LIKE ? ORDER BY contract_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,signing_money_sum,customer_name,invoice_amount,borrow_money,un_recive_money,un_recive_contract_money";
	private final static String[] fieldNames = { "department_id", "contract_id", "contract_code", "customer_name", "contract_name"};
}
