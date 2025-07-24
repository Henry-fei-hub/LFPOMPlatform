package pomplatform.projectperformance.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectperformance.bean.BaseProjectPerformanceDetail;
import pomplatform.projectperformance.bean.ConditionProjectPerformanceDetail;

public class QueryProjectPerformanceDetail extends AbstractQuery<BaseProjectPerformanceDetail, ConditionProjectPerformanceDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectPerformanceDetail.class);

	public QueryProjectPerformanceDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pp.project_performance_id");
	}

	@Override
	public BaseCollection<BaseProjectPerformanceDetail> executeQuery( KeyValuePair[] replacements, ConditionProjectPerformanceDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getContractId(), 
				condition.getProjectId(), 
				condition.getPerformanceFlag(), 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseProjectPerformanceDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectPerformanceDetail __base = new BaseProjectPerformanceDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectPerformanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPerformanceIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setClientComplaint(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSubmit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPerformanceFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "select pp.project_performance_id, pp.contract_id, pp.project_id, pp.integral, pp.percent, pp.performance_integral, pp.employee_id, pp.record_date, pp.client_complaint, pp.reason, pp.is_submit, pp.performance_flag, pp.business_type, pp.operate_employee_id, pp.operate_time, pp.remark, pp.type from project_performances pp where pp.employee_id = ? and pp.contract_id = ? and pp.project_id = ? and pp.performance_flag = ? and pp.business_type = ? and pp.is_submit = true order by pp.record_date" ;
	private final static String RESULTSETFIELDLIST = "project_performance_id,contract_id,project_id,integral,percent,performance_integral,employee_id,record_date,client_complaint,reason,is_submit,performance_flag,business_type,operate_employee_id,operate_time,remark,type";
	private final static String[] fieldNames = { "employee_id", "contract_id", "project_id", "performance_flag", "business_type"};
}
