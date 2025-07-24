package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseOnBusinessStateOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnBusinessStateOfRevenue;

public class QueryOnBusinessStateOfRevenue extends AbstractQuery<BaseOnBusinessStateOfRevenue, ConditionOnBusinessStateOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryOnBusinessStateOfRevenue.class);

	public QueryOnBusinessStateOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.contract_code");
	}

	@Override
	public BaseCollection<BaseOnBusinessStateOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionOnBusinessStateOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMonth(), 
				condition.getSigningCompany(), 
				condition.getEndDate(), 
				condition.getContractCode()
			);
	}

	@Override
	public BaseOnBusinessStateOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnBusinessStateOfRevenue __base = new BaseOnBusinessStateOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSigningCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercentDetail(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "select abc.contract_code,bs.business_code,bs.business_name,bs.business_integral,bs.signing_company,rr.finish_percent,rr.finish_percent_detail from ( select a.project_id,a.stage_id,a.attachment_file,a.upload_time,b.contract_code as sheet_code,b.project_name ,substr(b.contract_code,1,strpos(b.contract_code,'-')-4) as contract_code from project_attachments a left join projects b on a.project_id = b.project_id where b.contract_code is not null ORDER BY a.project_id,a.upload_time) abc right join business_state_records bs on substr(bs.business_code,1,length(bs.business_code)-3) = abc.contract_code left join revenue_records rr on substr(rr.code,1,length(rr.code)-3) = abc.contract_code and rr.flag = 2 and EXTRACT(MONTH from rr.account_date) = ? where bs.business_code is not null and bs.signing_company = ? and abc.upload_time < ? and abc.contract_code = ? GROUP BY abc.contract_code,bs.business_code,bs.business_name,bs.business_integral,bs.signing_company,rr.finish_percent,rr.finish_percent_detail" ;
	private final static String RESULTSETFIELDLIST = "contract_code,business_code,business_name,business_integral,signing_company,finish_percent,finish_percent_detail";
	private final static String[] fieldNames = { "month", "signing_company", "end_date", "contract_code"};
}
