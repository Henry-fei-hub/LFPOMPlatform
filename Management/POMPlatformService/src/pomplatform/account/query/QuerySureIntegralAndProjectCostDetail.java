package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseSureIntegralAndProjectCostDetail;
import pomplatform.account.bean.ConditionSureIntegralAndProjectCostDetail;

public class QuerySureIntegralAndProjectCostDetail extends AbstractQuery<BaseSureIntegralAndProjectCostDetail, ConditionSureIntegralAndProjectCostDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerySureIntegralAndProjectCostDetail.class);

	public QuerySureIntegralAndProjectCostDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseSureIntegralAndProjectCostDetail> executeQuery( KeyValuePair[] replacements, ConditionSureIntegralAndProjectCostDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseSureIntegralAndProjectCostDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSureIntegralAndProjectCostDetail __base = new BaseSureIntegralAndProjectCostDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no,b.employee_name,e.contract_code as sheet_code,e.project_name as sheet_name,a.integral,e.project_flag , a.record_date from employee_account_records a left join employees b on a.employee_id = b.employee_id LEFT JOIN employee_day_plate_records C ON A .employee_id = C .employee_id AND A.record_date = C.record_date left join project_settlement_details d on a.business_id = d.settlement_detail_id left join projects e on d.project_id = e.project_id where EXTRACT(YEAR from a.record_date) =? and EXTRACT(MONTH from a.record_date) =? and c.plate_id =? and a.employee_id =? and a.business_type_id =? ORDER BY d.project_id,a.integral desc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,sheet_code,sheet_name,integral,project_flag,record_date";
	private final static String[] fieldNames = { "year", "month", "plate_id", "employee_id", "business_type_id"};
}
