package pomplatform.mobile.approvalcount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mobile.approvalcount.bean.BaseMyApprovalProcessDetail;
import pomplatform.mobile.approvalcount.bean.ConditionMyApprovalProcessDetail;

public class QueryMyApprovalProcessDetail extends AbstractQuery<BaseMyApprovalProcessDetail, ConditionMyApprovalProcessDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryMyApprovalProcessDetail.class);

	public QueryMyApprovalProcessDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.process_type");
	}

	@Override
	public BaseCollection<BaseMyApprovalProcessDetail> executeQuery( KeyValuePair[] replacements, ConditionMyApprovalProcessDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMyApprovalProcessDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMyApprovalProcessDetail __base = new BaseMyApprovalProcessDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNeedDeal(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT aa.process_type, aa.process_type_name, COUNT(1) AS need_deal FROM( SELECT spia.process_type, spt.process_type_name FROM system_process_instance_activities spia LEFT JOIN system_process_types spt ON spt.process_type_id = spia.process_type WHERE spia.status = 1 AND spia.activity_type IN (2, 3) AND delete_flag = 0 AND spia.employee_id > 0 AND spia.employee_id = ? UNION ALL SELECT sppt.process_type, spt.process_type_name FROM system_process_pooled_tasks sppt LEFT JOIN system_process_types spt ON spt.process_type_id = sppt.process_type WHERE sppt.status = 1 AND sppt.employee_id > 0 AND sppt.delete_flag = 0 AND sppt.employee_id = ? ) aa GROUP BY aa.process_type,aa.process_type_name ORDER BY aa.process_type" ;
	private final static String RESULTSETFIELDLIST = "process_type,process_type_name,need_deal";
	private final static String[] fieldNames = { "employee_id", "employee_id"};
}
