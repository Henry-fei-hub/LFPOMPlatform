package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseRevenueYearRecordSubOfRevenue;
import pomplatform.OnRevenue.bean.ConditionRevenueYearRecordSubOfRevenue;

public class QueryRevenueYearRecordSubOfRevenue extends AbstractQuery<BaseRevenueYearRecordSubOfRevenue, ConditionRevenueYearRecordSubOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryRevenueYearRecordSubOfRevenue.class);

	public QueryRevenueYearRecordSubOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseRevenueYearRecordSubOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionRevenueYearRecordSubOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSigningCompany(), 
				condition.getIsFinish(), 
				condition.getYearRevenue(), 
				condition.getParentId()
			);
	}

	@Override
	public BaseRevenueYearRecordSubOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRevenueYearRecordSubOfRevenue __base = new BaseRevenueYearRecordSubOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRevenueYearRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJanuaryRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruaryRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarchRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprilRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuneRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulyRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugustRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctoberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYearRevenue(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
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

	private final static String __SQLText = "select * from revenue_year_records where flag = 2 and signing_company = ? and is_finish =? and year_revenue = ? and parent_id = ?" ;
	private final static String RESULTSETFIELDLIST = "revenue_year_record_id,contract_id,code,name,money,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue,total_revenue,parent_id,year_revenue,flag,signing_company,is_finish,operate_employee_id,operate_time";
	private final static String[] fieldNames = { "signing_company", "is_finish", "year_revenue", "parent_id"};
}
