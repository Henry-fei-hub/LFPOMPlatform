package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseContractThatCanEnd;
import pomplatform.workflow.contractstatus.bean.ConditionContractThatCanEnd;

public class QueryContractThatCanEnd extends AbstractQuery<BaseContractThatCanEnd, ConditionContractThatCanEnd>
{

	private static final Logger __logger = Logger.getLogger(QueryContractThatCanEnd.class);

	public QueryContractThatCanEnd() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("n.contract_id");
	}

	@Override
	public BaseCollection<BaseContractThatCanEnd> executeQuery( KeyValuePair[] replacements, ConditionContractThatCanEnd condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMoneyAttribute(), 
				condition.getContractId(), 
				condition.getContractStatus(), 
				condition.getContractStatus(), 
				condition.getProjectCostStatus()
			);
	}

	@Override
	public BaseContractThatCanEnd generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractThatCanEnd __base = new BaseContractThatCanEnd();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select n.contract_id, c.contract_code, c.contract_name from ( select m.contract_id, sum(coalesce(pc.amount, 0)) as project_cost from ( select l.contract_id, sum(coalesce(p.project_integral, 0)) as project_integral, sum(coalesce(ps.total_amount, 0)) as sure_integral from (select a.contract_id, coalesce(a.signing_money_sum, 0) as signing_money_sum, sum(coalesce(b.borrow_money, 0)) as receive_money from contracts a LEFT JOIN capitals b on a.contract_id = b.contract_id and b.money_attribute = ? where a.contract_id = ? and a.contract_status != ? and a.contract_id not in (select contract_id from contract_logs where new_status = ? and process_status in (0, 1)) group by a.contract_id order by a.contract_id) l LEFT JOIN projects p on l.contract_id = p.contract_id LEFT JOIN project_settlements ps on p.project_id = ps.project_id where l.signing_money_sum = l.receive_money group by l.contract_id order by l.contract_id) m LEFT JOIN projects p on m.contract_id = p.contract_id LEFT JOIN project_cost pc on p.project_id = pc.project_id and pc.status = ? where m.project_integral = m.sure_integral group by m.contract_id order by m.contract_id ) n LEFT JOIN contracts c on n.contract_id = c.contract_id where n.project_cost = 0" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name";
	private final static String[] fieldNames = { "money_attribute", "contract_id", "contract_status", "contract_status", "project_cost_status"};
}
