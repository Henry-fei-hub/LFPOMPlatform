package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryBonusSendData;
import pomplatform.payment.bean.ConditionOnSalaryBonusSendData;

public class QueryOnSalaryBonusSendData extends AbstractQuery<BaseOnSalaryBonusSendData, ConditionOnSalaryBonusSendData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryBonusSendData.class);

	public QueryOnSalaryBonusSendData() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.company_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryBonusSendData> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryBonusSendData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(),
				condition.getPersonnelBusinessId()
			);
	}

	@Override
	public BaseOnSalaryBonusSendData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryBonusSendData __base = new BaseOnSalaryBonusSendData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select b.company_id,a.employee_id,b.employee_no,b.employee_name,c.bank_account,a.year,a.month ,CAST(convert_from(decrypt(CAST(a.fact_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric) as fact_bonus from salary_of_bonus a left join employees b on a.employee_id = b.employee_id left join card_manages c on a.employee_id = c.object_id and object_type=1 and enabled = true and default_card = true where a.flag = 2 and b.company_id = ? and a.year = ? and a.month = ? and b.employee_no like ? and b.employee_name like ? and personnel_business_id = ? ORDER BY b.company_id,b.plate_id,b.department_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,employee_id,employee_no,employee_name,bank_account,year,month,fact_bonus";
	private final static String[] fieldNames = { "company_id", "year", "month", "employee_no", "employee_name","personnel_business_id"};
}
