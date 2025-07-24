package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryBonusTotalData;
import pomplatform.payment.bean.ConditionOnSalaryBonusTotalData;

public class QueryOnSalaryBonusTotalData extends AbstractQuery<BaseOnSalaryBonusTotalData, ConditionOnSalaryBonusTotalData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryBonusTotalData.class);

	public QueryOnSalaryBonusTotalData() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.company_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryBonusTotalData> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryBonusTotalData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(),
				condition.getPersonnelBusinessId()
				
			);
	}

	@Override
	public BaseOnSalaryBonusTotalData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryBonusTotalData __base = new BaseOnSalaryBonusTotalData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectBonus(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.company_id,a.year,a.month ,COALESCE(sum(CAST(convert_from(decrypt(CAST(a.should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)),0)+COALESCE(sum(CAST(convert_from(decrypt(CAST(a.other_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)),0) as should_bonus ,sum(CAST(convert_from(decrypt(CAST(a.should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_tax ,sum(CAST(convert_from(decrypt(CAST(a.fact_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as fact_bonus ,sum(CAST(convert_from(decrypt(CAST(a.other_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as other_bonus,sum(CAST(convert_from(decrypt(CAST(a.should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as project_bonus from salary_of_bonus a left join employees b on a.employee_id = b.employee_id where a.flag in(2,3) and a.company_id = ? and a.year = ? and a.month = ? AND personnel_business_id =? GROUP BY a.company_id,a.year,a.month ORDER BY a.company_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,year,month,should_bonus,should_tax,fact_bonus,other_bonus,project_bonus";
	private final static String[] fieldNames = { "company_id", "year", "month","personnel_business_id"};
}
