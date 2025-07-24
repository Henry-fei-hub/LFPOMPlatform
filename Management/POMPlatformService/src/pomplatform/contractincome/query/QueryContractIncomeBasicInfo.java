package pomplatform.contractincome.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractincome.bean.BaseContractIncomeBasicInfo;
import pomplatform.contractincome.bean.ConditionContractIncomeBasicInfo;

public class QueryContractIncomeBasicInfo extends AbstractQuery<BaseContractIncomeBasicInfo, ConditionContractIncomeBasicInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryContractIncomeBasicInfo.class);

	public QueryContractIncomeBasicInfo() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.company_id");
	}

	@Override
	public BaseCollection<BaseContractIncomeBasicInfo> executeQuery( KeyValuePair[] replacements, ConditionContractIncomeBasicInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getStartDate(), 
				condition.getCopyIncomeLedger(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseContractIncomeBasicInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractIncomeBasicInfo __base = new BaseContractIncomeBasicInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceiveContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnreceivedContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentReceiveAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentReceiveDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCurrentReceiveRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCopyIncomeLedger(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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

	private final static String __SQLText = "select aa.company_id, aa.project_manager, aa.contract_id, aa.contract_code, aa.contract_name, aa.signing_money_sum, (aa.history_receive_amount + aa.current_receive_amount) as receive_contract_amount, (aa.signing_money_sum - aa.history_receive_amount - aa.current_receive_amount) as unreceived_contract_amount, (sum(COALESCE(bb.invoice_amount, 0)) - aa.history_receive_amount) as invoice_amount, aa.current_receive_amount, aa.current_receive_date, aa.current_receive_remark, aa.plate_manager, aa.copy_income_ledger, aa.client_id from (select k.*, SUM (COALESCE(f.borrow_money, 0)) AS current_receive_amount, array_to_string(ARRAY(SELECT UNNEST (ARRAY_AGG (DISTINCT(to_char(f.happen_date, 'YYYY-MM-DD'))))), '，') as current_receive_date, array_to_string(ARRAY(SELECT UNNEST (ARRAY_AGG (DISTINCT concat(f.remark, ' ', f.borrow_money)))), '；') as current_receive_remark from (select a.signing_company_name as company_id, array_to_string(ARRAY(SELECT UNNEST (ARRAY_AGG (DISTINCT d.employee_name))), '，') as project_manager, a.contract_id, a.contract_code, a.contract_name, a.signing_money_sum, SUM (COALESCE(c.borrow_money, 0)) AS history_receive_amount, array_to_string(ARRAY(SELECT UNNEST (ARRAY_AGG (DISTINCT e.employee_name))), '，') as plate_manager, a.copy_income_ledger, a.customer_id as client_id from contracts a LEFT JOIN projects b on a.contract_id = b.contract_id and b.project_type = ? LEFT JOIN capitals c on a.contract_id = c.contract_id and c.happen_date < ? LEFT JOIN employees d on b.project_manage_id = d.employee_id LEFT JOIN employees e on b.plate_manager_id = e.employee_id where c.happen_date < ? and a.copy_income_ledger = ? group by a.signing_company_name, a.contract_id, a.contract_code, a.contract_name, a.signing_money_sum, a.copy_income_ledger) k LEFT JOIN capitals f on k.contract_id = f.contract_id and f.happen_date >= ? and f.happen_date < ? group by k.company_id, k.project_manager, k.contract_id, k.contract_code, k.contract_name, k.signing_money_sum, k.history_receive_amount, k.plate_manager, k.copy_income_ledger, k.client_id) aa LEFT JOIN invoices bb on aa.contract_id = bb.contract_id and aa.contract_code not like '%999999999%' and bb.invoice_date < ? group by aa.company_id, aa.project_manager, aa.contract_id, aa.contract_code, aa.contract_name, aa.signing_money_sum, aa.current_receive_date, aa.current_receive_remark, aa.plate_manager, aa.history_receive_amount, aa.current_receive_amount, aa.copy_income_ledger, aa.client_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,project_manager,contract_id,contract_code,contract_name,signing_money_sum,receive_contract_amount,unreceived_contract_amount,invoice_amount,current_receive_amount,current_receive_date,current_receive_remark,plate_manager,copy_income_ledger,client_id";
	private final static String[] fieldNames = { "project_type", "start_date", "start_date", "copy_income_ledger", "start_date", "end_date", "end_date"};
}
