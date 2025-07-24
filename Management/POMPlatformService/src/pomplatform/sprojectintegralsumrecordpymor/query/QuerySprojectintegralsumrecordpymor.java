package pomplatform.sprojectintegralsumrecordpymor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sprojectintegralsumrecordpymor.bean.BaseSprojectintegralsumrecordpymor;
import pomplatform.sprojectintegralsumrecordpymor.bean.ConditionSprojectintegralsumrecordpymor;

public class QuerySprojectintegralsumrecordpymor extends AbstractQuery<BaseSprojectintegralsumrecordpymor, ConditionSprojectintegralsumrecordpymor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectintegralsumrecordpymor.class);

	public QuerySprojectintegralsumrecordpymor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sc.sub_contract_code");
	}

	@Override
	public BaseCollection<BaseSprojectintegralsumrecordpymor> executeQuery( KeyValuePair[] replacements, ConditionSprojectintegralsumrecordpymor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseSprojectintegralsumrecordpymor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectintegralsumrecordpymor __base = new BaseSprojectintegralsumrecordpymor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegralSumRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUndistributedProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDistributedProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnsureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettledProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnsettledProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
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

	private final static String __SQLText = "select sc.sub_contract_code,sc.sub_contract_name, pisr.project_integral_sum_record_id, pisr.project_id, pisr.plate_id, pisr.year, pisr.month, pisr.project_integral_sum, pisr.reserve_integral, pisr.project_integral, pisr.undistributed_project_integral, pisr.distributed_project_integral, pisr.unsure_integral, pisr.sure_integral, pisr.settlement_integral, pisr.project_cost, pisr.settled_project_cost, pisr.unsettled_project_cost, pisr.is_lock, pisr.create_time, pisr.update_time,p.project_code from project_integral_sum_records pisr left join projects p on pisr.project_id = p.project_id left join sub_contracts sc on p.contract_code = sc.sub_contract_code where pisr.project_id = ? and pisr.year = ? and pisr.month >= ? and pisr.month <= ?" ;
	private final static String RESULTSETFIELDLIST = "sub_contract_code,sub_contract_name,project_integral_sum_record_id,project_id,plate_id,year,month,project_integral_sum,reserve_integral,project_integral,undistributed_project_integral,distributed_project_integral,unsure_integral,sure_integral,settlement_integral,project_cost,settled_project_cost,unsettled_project_cost,is_lock,create_time,update_time,project_code";
	private final static String[] fieldNames = { "porject_id", "year", "start_month", "end_month"};
}
