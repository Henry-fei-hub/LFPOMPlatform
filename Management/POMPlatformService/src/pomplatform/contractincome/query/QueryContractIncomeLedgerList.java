package pomplatform.contractincome.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractincome.bean.BaseContractIncomeLedgerList;
import pomplatform.contractincome.bean.ConditionContractIncomeLedgerList;

public class QueryContractIncomeLedgerList extends AbstractQuery<BaseContractIncomeLedgerList, ConditionContractIncomeLedgerList>
{

	private static final Logger __logger = Logger.getLogger(QueryContractIncomeLedgerList.class);

	public QueryContractIncomeLedgerList() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cil.contract_income_ledger_id");
	}

	@Override
	public BaseCollection<BaseContractIncomeLedgerList> executeQuery( KeyValuePair[] replacements, ConditionContractIncomeLedgerList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getCompanyId(), 
				condition.getProjectManager(), 
				condition.getPlateManager(), 
				condition.getSigningMoneySum(), 
				condition.getLedgerYear(), 
				condition.getLedgerMonth(), 
				condition.getClientId(), 
				condition.getIsLocked(),
				condition.getContractYear(),
				condition.getPlateId()
			);
	}

	@Override
	public BaseContractIncomeLedgerList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractIncomeLedgerList __base = new BaseContractIncomeLedgerList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractIncomeLedgerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceiveContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnreceivedContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceStage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentReceiveAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentReceiveDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCurrentReceiveRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContacts(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLedgerYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLedgerMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIncomeLedgerNumber(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "select k.contract_income_ledger_id, k.contract_id, k.contract_code, k.contract_name, k.company_id, k.client_id, k.customer_name, k.project_manager, k.plate_manager, k.signing_money_sum, k.receive_contract_amount, k.unreceived_contract_amount, k.invoice_date, k.invoice_number, k.invoice_stage, k.invoice_amount, k.current_receive_amount, k.current_receive_date, k.current_receive_remark, k.project_status, k.remark, k.contacts, k.ledger_year, k.ledger_month, k.create_time, k.update_time, k.is_locked, k.income_ledger_number from (select cil.contract_income_ledger_id, cil.contract_id, cil.contract_code, cil.contract_name, cil.company_id, cil.client_id, d.customer_name, cil.project_manager, cil.plate_manager, cil.signing_money_sum, cil.receive_contract_amount, cil.unreceived_contract_amount, cil.invoice_date, cil.invoice_number, cil.invoice_stage, cil.invoice_amount, cil.current_receive_amount, cil.current_receive_date, cil.current_receive_remark, cil.project_status, cil.remark, cil.contacts, cil.ledger_year, cil.ledger_month, cil.create_time, cil.update_time, cil.is_locked, c.income_ledger_number, case when (cil.signing_money_sum is null or cil.signing_money_sum = 0) then 0 else COALESCE(cil.unreceived_contract_amount, 0) / cil.signing_money_sum end as unreceived_percent from contract_income_ledgers cil LEFT JOIN contracts c on cil.contract_id = c.contract_id LEFT JOIN customers d on cil.client_id = d.customer_id LEFT JOIN projects p on c.contract_id = p.contract_id and p.project_type = 16 where cil.contract_code like ? and cil.contract_name like ? and cil.company_id = ? and cil.project_manager like ? and cil.plate_manager like ? and cil.signing_money_sum = ? and cil.ledger_year = ? and cil.ledger_month = ? and cil.client_id = ? and cil.is_locked = ? and c.contract_year >= ? and p.plate_id = ? ) k order by k.income_ledger_number" ;
	private final static String RESULTSETFIELDLIST = "contract_income_ledger_id,contract_id,contract_code,contract_name,company_id,client_id,customer_name,project_manager,plate_manager,signing_money_sum,receive_contract_amount,unreceived_contract_amount,invoice_date,invoice_number,invoice_stage,invoice_amount,current_receive_amount,current_receive_date,current_receive_remark,project_status,remark,contacts,ledger_year,ledger_month,create_time,update_time,is_locked,income_ledger_number";
	private final static String[] fieldNames = { "contract_code", "contract_name", "company_id", "project_manager", "plate_manager", "signing_money_sum", "ledger_year", "ledger_month", "client_id", "is_locked", "contract_year", "plate_id"};
}
