package pomplatform.finance.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.finance.bean.BaseMcapitalecoosmeor;
import pomplatform.finance.bean.ConditionMcapitalecoosmeor;

public class QueryMcapitalecoosmeor extends AbstractQuery<BaseMcapitalecoosmeor, ConditionMcapitalecoosmeor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitalecoosmeor.class);

	public QueryMcapitalecoosmeor() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.capital_id");
	}

	@Override
	public BaseCollection<BaseMcapitalecoosmeor> executeQuery( KeyValuePair[] replacements, ConditionMcapitalecoosmeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getOtherName(), 
				condition.getOtherBankAccount(), 
				condition.getSelfName(), 
				condition.getMoneyAttribute(), 
				condition.getEmployeeId(),
				condition.getHasInvoices(),
				condition.getHasContractReceivable(),
				condition.getHasDistributionCollection(),
				condition.getHaveVoucher()
			);
	}

	@Override
	public BaseMcapitalecoosmeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitalecoosmeor __base = new BaseMcapitalecoosmeor();
		int count = 0;
		Object val;
		
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSelfName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLoanMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasInvoices(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasContractReceivable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasDistributionCollection(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIssueDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setExpireDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActualAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualReceiveDate(GenericBase.__getDateFromSQL(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[7]));
		if(args[8] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[8]));
		if(args[9] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[9]));
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

	private final static String __SQLText = "select c.capital_id, c.have_voucher, c.info_code, c.project_code, c.contract_id,st.contract_name,st.contract_code, c.money_attribute, c.self_name, c.self_bank_name, c.self_bank_account, c.other_name, c.other_bank_name, c.other_bank_account, c.borrow_money, c.loan_money, c.operator, c.happen_date, c.create_date, c.has_invoices, c.has_contract_receivable,e.employee_name,c.remark,c.has_distribution_collection, c.issue_date, c.expire_date, c.receive_unit_id, rum.receive_unit, c.actual_amount, c.actual_receive_date from capitals c left join employees e on c.operator=e.employee_id left join contracts st on st.contract_id=c.contract_id left join receive_unit_manages rum on c.receive_unit_id = rum.receive_unit_manage_id where (c.contract_id is null or c.contract_id= ? ) and c.other_name like ? and c.other_bank_account like ? and c.self_name = ? and c.money_attribute = ? and e.employee_id=? and c.has_invoices=? and c.has_contract_receivable=? and c.has_distribution_collection=? and c.have_voucher = ? and c.capital_type = 1 order by c.capital_id" ;
	private final static String RESULTSETFIELDLIST = "capital_id,have_voucher,info_code,project_code,contract_id,contract_name,contract_code,money_attribute,self_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,borrow_money,loan_money,operator,happen_date,create_date,has_invoices,has_contract_receivable,employee_name,remark,has_distribution_collection,issue_date,expire_date,receive_unit_id,receive_unit,actual_amount,actual_receive_date";
	private final static String[] fieldNames = { "contract_id", "other_name", "other_bank_account", "self_name", "money_attribute", "employee_id","has_invoices","has_contract_receivable","has_distribution_collection","have_voucher"};
}
