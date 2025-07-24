package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadStandardQuoteData;
import pomplatform.project.bean.ConditionOnLoadStandardQuoteData;

public class QueryOnLoadStandardQuoteData extends AbstractQuery<BaseOnLoadStandardQuoteData, ConditionOnLoadStandardQuoteData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadStandardQuoteData.class);

	public QueryOnLoadStandardQuoteData() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT a.info_code");
	}

	@Override
	public BaseCollection<BaseOnLoadStandardQuoteData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadStandardQuoteData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getClientName(), 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseOnLoadStandardQuoteData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadStandardQuoteData __base = new BaseOnLoadStandardQuoteData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBidType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setClientName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSamePercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaLevel(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select DISTINCT a.info_code,a.project_code,a.project_name,a.business_type,a.project_approval_time,a.project_base_on,a.bid_type,a.province,a.city,a.project_level,b.money_sum ,(select sum(design_area) as area from out_design_considerations where out_quotation_id = b.out_quotation_id and option_type = 2),d.client_company as client_name,0.0 as same_percent,b.out_quotation_id,e.area_level from main_projects a LEFT JOIN out_quotations b on a.info_code = b.info_code LEFT JOIN main_project_clients c on a.main_project_id = c.main_project_id and c.client_id <> 2 LEFT JOIN clients d on c.client_id = d.client_id LEFT JOIN areas e on a.city = e.all_name where b.quotation_status = 1 and b.money_sum > 0 and a.project_approval_time BETWEEN ? AND ? and d.client_company like ? and a.business_type like ? ORDER BY a.project_approval_time desc" ;
	private final static String RESULTSETFIELDLIST = "info_code,project_code,project_name,business_type,project_approval_time,project_base_on,bid_type,province,city,project_level,money_sum,area,client_name,same_percent,out_quotation_id,area_level";
	private final static String[] fieldNames = { "start_date", "end_date", "client_name", "business_type"};
}
