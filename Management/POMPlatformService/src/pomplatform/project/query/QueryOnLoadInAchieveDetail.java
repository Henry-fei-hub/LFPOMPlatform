package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadInAchieveDetail;
import pomplatform.project.bean.ConditionOnLoadInAchieveDetail;

public class QueryOnLoadInAchieveDetail extends AbstractQuery<BaseOnLoadInAchieveDetail, ConditionOnLoadInAchieveDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadInAchieveDetail.class);

	public QueryOnLoadInAchieveDetail() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("case when b.plate_id > 0 then b.plate_id else b.revenue_plate_id end as plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadInAchieveDetail> executeQuery( KeyValuePair[] replacements, ConditionOnLoadInAchieveDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getPlateId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getSheetCode(), 
				condition.getSheetName()
			);
	}

	@Override
	public BaseOnLoadInAchieveDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadInAchieveDetail __base = new BaseOnLoadInAchieveDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinancialContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastTotalRevenue(GenericBase.__getDecimal(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
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

	private final static String __SQLText = "select case when b.plate_id > 0 then b.plate_id else b.revenue_plate_id end as plate_id,c.financial_contract_code,c.contract_code,c.contract_name ,b.contract_code as sheet_code,b.project_name as sheet_name,a.total_revenue,a.current_revenue ,(a.total_revenue-a.current_revenue) as last_total_revenue from revenue_statistical_records a left join projects b on a.project_id = b.project_id left join contracts c on b.contract_id = c.contract_id where a.project_id = ? and a.year = ? and month = ? and (b.plate_id =? or b.revenue_plate_id =?) and c.contract_code like ? and c.contract_name like ? and b.contract_code like ? and b.project_name like ? ORDER BY b.contract_id,plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,financial_contract_code,contract_code,contract_name,sheet_code,sheet_name,total_revenue,current_revenue,last_total_revenue";
	private final static String[] fieldNames = { "project_id", "year", "month", "plate_id", "plate_id", "contract_code", "contract_name", "sheet_code", "sheet_name"};
}
