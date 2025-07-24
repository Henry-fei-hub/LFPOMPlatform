package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseMProjectSettlementForProject;
import pomplatform.operation.bean.ConditionMProjectSettlementForProject;

public class QueryMProjectSettlementForProject extends AbstractQuery<BaseMProjectSettlementForProject, ConditionMProjectSettlementForProject>
{

	private static final Logger __logger = Logger.getLogger(QueryMProjectSettlementForProject.class);

	public QueryMProjectSettlementForProject() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.settlement_id");
	}

	@Override
	public BaseCollection<BaseMProjectSettlementForProject> executeQuery( KeyValuePair[] replacements, ConditionMProjectSettlementForProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMProjectSettlementForProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMProjectSettlementForProject __base = new BaseMProjectSettlementForProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManager(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
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

	private final static String __SQLText = "select ps.settlement_id, ps.project_id, ps.employee_id as manager, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.status ,psd.employee_id,psd.work_content, psd.plan_amount, psd.real_amount, psd.project_cost, psd.final_amount from project_settlements ps, project_settlement_details psd where ps.project_id = ? and psd.settlement_id = ps.settlement_id" ;
	private final static String RESULTSETFIELDLIST = "settlement_id,project_id,manager,remark,settlement_date,total_amount,total_cost,project_amount,left_amount,status,employee_id,work_content,plan_amount,real_amount,project_cost,final_amount";
	private final static String[] fieldNames = { "project_id"};
}
