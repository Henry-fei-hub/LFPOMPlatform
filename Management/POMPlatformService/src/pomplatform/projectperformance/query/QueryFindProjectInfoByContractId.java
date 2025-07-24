package pomplatform.projectperformance.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.projectperformance.bean.BaseFindProjectInfoByContractId;
import pomplatform.projectperformance.bean.ConditionFindProjectInfoByContractId;

public class QueryFindProjectInfoByContractId extends AbstractQuery<BaseFindProjectInfoByContractId, ConditionFindProjectInfoByContractId>
{

	private static final Logger __logger = Logger.getLogger(QueryFindProjectInfoByContractId.class);

	public QueryFindProjectInfoByContractId() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.*");
	}

	@Override
	public BaseCollection<BaseFindProjectInfoByContractId> executeQuery( KeyValuePair[] replacements, ConditionFindProjectInfoByContractId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getContractId(),
				condition.getPlateId(),
				condition.getSheetCode(),
				condition.getSheetName(),
				condition.getProjectManageId()
			);
	}

	@Override
	public BaseFindProjectInfoByContractId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFindProjectInfoByContractId __base = new BaseFindProjectInfoByContractId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDeductIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAwardIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "select aa.* ,(case when aa.project_integral > 0 then (case when aa.sure_integral > 0 then round(aa.sure_integral/aa.project_integral*100,2) else 0 end) else 0 end) ||'%' as finish_percent ,round((case when aa.project_integral > 0 then (case when aa.sure_integral > 0 then aa.sure_integral/aa.project_integral else 0 end) else 0 end)*aa.sheet_amount,2) as total_revenue,(COALESCE(aa.complaint_integral,0) - COALESCE(aa.deduct_integral,0)) as left_integral from (select a.contract_id,a.project_id,a.plate_id,a.status,a.contract_code as sheet_code,a.project_name as sheet_name,a.business_type,a.project_type ,a.sheet_amount,a.total_integral,a.project_integral,a.reserve_integral,case when a.complaint_integral > 0 then a.complaint_integral else COALESCE((select sum(integral) from project_settlement_performances where project_id = a.project_id GROUP BY project_id),0) end as  complaint_integral,(select sum(total_amount) from project_settlements where project_id = a.project_id) as sure_integral ,(select sum(amount) from project_cost where project_id = a.project_id) as project_cost ,(select sum(performance_integral) from project_performances where project_id = a.project_id and is_submit = true and business_type = 2 and performance_flag = 1 and record_date BETWEEN ? and ?) as deduct_integral ,(select sum(performance_integral) from project_performances where project_id = a.project_id and is_submit = true and business_type = 2 and performance_flag = 2 and record_date BETWEEN ? and ?) as award_integral, a.project_manage_id as project_manage_id from projects a where a.project_flag = 1 ) as aa where aa.contract_id = ? and aa.plate_id = ? and aa.sheet_code like ? and aa.sheet_name like ? and aa.project_manage_id = ? ORDER BY plate_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,project_id,plate_id,status,sheet_code,sheet_name,business_type,project_type,sheet_amount,total_integral,project_integral,reserve_integral,complaint_integral,sure_integral,project_cost,deduct_integral,award_integral,project_manage_id,finish_percent,total_revenue,left_integral";
	private final static String[] fieldNames = { "start_date","end_date","start_date","end_date","contract_id","plate_id","sheet_code","sheet_name","project_manage_id"};
}
