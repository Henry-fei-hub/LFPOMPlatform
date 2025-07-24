package pomplatform.mobile.approvalcount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mobile.approvalcount.bean.BaseMyApprovalSummary;
import pomplatform.mobile.approvalcount.bean.ConditionMyApprovalSummary;

public class QueryMyApprovalSummary extends AbstractQuery<BaseMyApprovalSummary, ConditionMyApprovalSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryMyApprovalSummary.class);

	public QueryMyApprovalSummary() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("SUM (aa.num) AS need_deal");
	}

	@Override
	public BaseCollection<BaseMyApprovalSummary> executeQuery( KeyValuePair[] replacements, ConditionMyApprovalSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(),
				condition.getEmployeeId(),
				condition.getEmployeeId(), 
				condition.getEmployeeId(),
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMyApprovalSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMyApprovalSummary __base = new BaseMyApprovalSummary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setNeedDeal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT SUM (aa.num) AS need_deal, aa.type FROM ( SELECT COUNT (1) AS num, 1 AS type FROM system_process_instance_activities spia WHERE spia.status = 1 AND spia.activity_type IN (2, 3) AND delete_flag = 0 AND spia.employee_id > 0 AND spia.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status IN (0, 1) ) AND spia.employee_id = ? UNION ALL SELECT COUNT (1) AS num, 1 AS type FROM system_process_pooled_tasks sppt WHERE sppt.status = 1 AND sppt.employee_id > 0 AND sppt.delete_flag = 0 AND sppt.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status IN (0, 1) ) AND sppt.employee_id = ? UNION ALL SELECT COUNT (1) AS num, 2 AS type FROM system_process_attentions spa WHERE spa.status = 1 AND spa.employee_id > 0 AND spa.delete_flag = 0 AND spa.employee_id = ? UNION ALL SELECT count(1) AS num, CASE WHEN process_status = 0 OR process_status = 1 THEN 3 WHEN process_status = 3 THEN 4 WHEN process_status = 5 THEN 5 END AS type FROM system_process_instances WHERE employee_id = ? AND delete_flag = 0 GROUP BY process_status UNION ALL SELECT COUNT(1) AS num, 6 as type FROM system_process_instance_activities spia LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id WHERE spia.employee_id = ? AND spia.delete_flag = 0 AND spia.status in (2, 3, 6) AND spia.activity_type IN (2, 3) AND spi.delete_flag = 0 UNION ALL SELECT COUNT(1) AS num, 6 as type FROM system_process_pooled_tasks spt LEFT JOIN system_process_instances spi ON spi.process_instance_id = spt.process_instance_id WHERE spt.employee_id = ? AND spt.delete_flag = 0 AND spt.status = 2 AND spi.delete_flag = 0 UNION ALL SELECT COUNT (1) AS num, 7 AS type FROM system_process_attentions spa LEFT JOIN system_process_instances spi ON spi.process_instance_id = spa.process_instance_id WHERE spa.status = 2 AND spa.employee_id > 0 AND spa.delete_flag = 0 AND spa.employee_id = ? AND spi.delete_flag = 0) aa GROUP BY aa.type" ;
	private final static String RESULTSETFIELDLIST = "need_deal,type";
	private final static String[] fieldNames = { "employee_id", "employee_id", "employee_id", "employee_id", "employee_id", "employee_id", "employee_id"};
}
