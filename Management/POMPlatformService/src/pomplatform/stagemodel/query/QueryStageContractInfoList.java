package pomplatform.stagemodel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.common.utils.StaticUtils;
import pomplatform.stagemodel.bean.BaseStageContractInfoList;
import pomplatform.stagemodel.bean.ConditionStageContractInfoList;

public class QueryStageContractInfoList extends AbstractQuery<BaseStageContractInfoList, ConditionStageContractInfoList>
{

	private static final Logger __logger = Logger.getLogger(QueryStageContractInfoList.class);

	public QueryStageContractInfoList() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("temp.*");
	}

	@Override
	public BaseCollection<BaseStageContractInfoList> executeQuery( KeyValuePair[] replacements, ConditionStageContractInfoList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getContractStatus(),
				condition.getContractId()
			);
	}

	@Override
	public BaseStageContractInfoList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseStageContractInfoList __base = new BaseStageContractInfoList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCalculatePercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordNo(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setRevenuePercent(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT temp.*, case when temp.signing_money_sum = 0 then 0 else round((temp.revenue/temp.signing_money_sum),4) end as revenue_percent from( select c.contract_id, c.contract_code, c.contract_name, COALESCE(c.signing_money_sum, 0) as signing_money_sum, c.contract_status, COALESCE((select sum(current_revenue) from revenue_statistical_records a LEFT JOIN projects b on a.project_id = b.project_id where b.contract_id = c.contract_id group by b.contract_id), 0) as revenue, COALESCE((select sum(actual_percent) from contract_stage_models where contract_id = c.contract_id and leaf_node = true and locked = true group by contract_id), 0) as actual_percent, COALESCE((select sum(actual_percent) from contract_stage_models where contract_id = c.contract_id and leaf_node = true group by contract_id), 0) as calculate_percent, COALESCE((select sum(invoice_amount) from invoices where contract_id = c.contract_id and sign in (" + StaticUtils.INVOICE_STATUS_1 + "," + StaticUtils.INVOICE_STATUS_2+") group by contract_id), 0) as invoice_amount, COALESCE((select sum(borrow_money) from capitals where contract_id = c.contract_id and money_attribute = " + StaticUtils.CAPITAL_MONEY_ATTRIBUTION_1 + " group by contract_id), 0) as capital_amount, count(csm.*) as record_no from contracts c LEFT JOIN contract_stage_models csm on c.contract_id = csm.contract_id and csm.parent_id = 0 where c.contract_code like ? and c.contract_name like ? and c.contract_status = ? and c.contract_id = ? GROUP BY c.contract_id ) temp order by temp.contract_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,signing_money_sum,contract_status,revenue,actual_percent,calculate_percent,invoice_amount,capital_amount,record_no,revenue_percent";
	private final static String[] fieldNames = { "contract_code", "contract_name", "contract_status", "contract_id"};
}
