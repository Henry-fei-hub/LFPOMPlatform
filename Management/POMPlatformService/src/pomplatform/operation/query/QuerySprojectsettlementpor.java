package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseSprojectsettlementpor;
import pomplatform.operation.bean.ConditionSprojectsettlementpor;

public class QuerySprojectsettlementpor extends AbstractQuery<BaseSprojectsettlementpor, ConditionSprojectsettlementpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectsettlementpor.class);

	public QuerySprojectsettlementpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.settlement_id");
	}

	@Override
	public BaseCollection<BaseSprojectsettlementpor> executeQuery( KeyValuePair[] replacements, ConditionSprojectsettlementpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSprojectsettlementpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectsettlementpor __base = new BaseSprojectsettlementpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select ps.settlement_id, ps.project_id, ps.employee_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost ,(ps.total_amount-ps.total_cost) as settlement_amount, ps.project_amount, ps.left_amount, ps.settlement_status from project_settlements ps where ps.project_id = ? ORDER BY ps.settlement_id" ;
	private final static String RESULTSETFIELDLIST = "settlement_id,project_id,employee_id,remark,settlement_date,total_amount,total_cost,settlement_amount,project_amount,left_amount,settlement_status";
	private final static String[] fieldNames = { "project_id"};
}
