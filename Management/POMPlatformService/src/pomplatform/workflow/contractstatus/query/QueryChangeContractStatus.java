package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseChangeContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionChangeContractStatus;

public class QueryChangeContractStatus extends AbstractQuery<BaseChangeContractStatus, ConditionChangeContractStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryChangeContractStatus.class);

	public QueryChangeContractStatus() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseChangeContractStatus> executeQuery( KeyValuePair[] replacements, ConditionChangeContractStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractId(), 
				condition.getContractId(), 
				condition.getContractId(), 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseChangeContractStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseChangeContractStatus __base = new BaseChangeContractStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWorkflowNum(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "select c.contract_id, c.contract_code, c.contract_name, c.contract_status, COALESCE(c.signing_money_sum, 0) as signing_money_sum, COALESCE(r.amount, 0) as revenue_amount, COALESCE(i.amount, 0) as invoice_amount, COALESCE(cp.borrow_money, 0) as borrow_money, COALESCE(spi.num, 0) as workflow_num from contracts c LEFT JOIN (select COALESCE(sum(borrow_money), 0) as borrow_money, contract_id from capitals where contract_id = ? and contract_id > 0 and record_receive_capital = true group by contract_id) cp on c.contract_id = cp.contract_id LEFT JOIN (select a.contract_id, COALESCE(a.amount, 0) - COALESCE(b.amount, 0) as amount from (select COALESCE(sum(invoice_amount), 0) as amount, contract_id from invoices where contract_id = ? and sign != 4 and contract_id > 0 group by contract_id) a LEFT JOIN (select COALESCE(sum(invoice_amount), 0) as amount, contract_id from invoices where contract_id = ? and sign = 3 and contract_id > 0 group by contract_id) b on a.contract_id = b.contract_id) i on c.contract_id = i.contract_id LEFT JOIN (select p.contract_id, COALESCE(sum(rsr.total_revenue), 0) as amount from projects p LEFT JOIN revenue_statistical_records rsr on p.project_id = rsr.project_id where p.contract_id = ? and p.contract_id > 0 and rsr.year = extract(year from now()) and rsr.month = extract(month from now()) group by p.contract_id) r on c.contract_id = r.contract_id LEFT JOIN (select b.contract_id, count(a.process_instance_id) as num from system_process_instances a LEFT JOIN contract_logs b on a.process_type = 64 and a.business_id = b.contract_log_id where a.process_type = ? and a.process_status in (0, 1) and a.delete_flag = 0 and b.contract_id = ? and b.contract_id > 0 group by b.contract_id) spi on c.contract_id = spi.contract_id where c.contract_id = ? order by c.contract_code" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,contract_status,signing_money_sum,revenue_amount,invoice_amount,borrow_money,workflow_num";
	private final static String[] fieldNames = { "contract_id", "contract_id", "contract_id", "contract_id", "process_type", "contract_id", "contract_id"};
}
