package pomplatform.employeeaccountrecordeeppccmmpebor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeaccountrecordeeppccmmpebor.bean.BaseMemployeeaccountrecordeeppccmmpebor;
import pomplatform.employeeaccountrecordeeppccmmpebor.bean.ConditionMemployeeaccountrecordeeppccmmpebor;

public class QueryMemployeeaccountrecordeeppccmmpebor extends AbstractQuery<BaseMemployeeaccountrecordeeppccmmpebor, ConditionMemployeeaccountrecordeeppccmmpebor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeaccountrecordeeppccmmpebor.class);

	public QueryMemployeeaccountrecordeeppccmmpebor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeeaccountrecordeeppccmmpebor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeaccountrecordeeppccmmpebor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinRecordDate(), 
				condition.getMaxRecordDate(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseMemployeeaccountrecordeeppccmmpebor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeaccountrecordeeppccmmpebor __base = new BaseMemployeeaccountrecordeeppccmmpebor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeAccountRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercente(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setConfirmIntegral(GenericBase.__getDecimal(val));
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
//	private final static String __SQLText = "SELECT a.employee_id, b.employee_no, b.employee_name, e.contract_code AS sheet_code, e.project_name AS sheet_name, a.integral, e.project_flag, d.project_id, e.sheet_amount, a.employee_account_record_id, pall.money, CASE WHEN e.sheet_amount ISNULL OR e.sheet_amount = 0 THEN 0 ELSE CASE WHEN pall.money ISNULL OR pall.money = 0 THEN 0 ELSE round((money / sheet_amount) * 100, 2) END END AS percente, CASE WHEN e.sheet_amount ISNULL OR e.sheet_amount = 0 THEN 0 ELSE CASE WHEN pall.money ISNULL OR pall.money = 0 THEN 0 ELSE a.integral * round((money / sheet_amount), 2) END END AS confirm_integral FROM employee_account_records A LEFT JOIN employees b ON a.employee_id = b.employee_id LEFT JOIN employee_change_plate_records C ON a.employee_id = c.employee_id AND EXTRACT (YEAR FROM a.record_date) = c.YEAR AND EXTRACT (MONTH FROM a.record_date) = c.MONTH LEFT JOIN project_settlement_details d ON a.business_id = d.settlement_detail_id LEFT JOIN projects e ON d.project_id = e.project_id LEFT JOIN (SELECT cd.sub_contract_id,SUM(money) AS money FROM capital_distribution_link_sub_contracts cd LEFT JOIN capital_distributions cp ON cp.capital_distribution_id = cd.capital_distribution_id WHERE (cp.is_completed = true OR cd.capital_id > 0) AND cd.money > 0 GROUP BY cd.sub_contract_id ) pall ON pall.sub_contract_id = e.project_id WHERE a.record_date BETWEEN ? AND ? AND c.plate_id = ? AND a.employee_id = ? AND a.business_type_id = ? ORDER BY d.project_id, a.integral DESC" ;

	private final static String __SQLText = "SELECT a.employee_id, b.employee_no, b.employee_name, e.contract_code AS sheet_code, e.project_name AS sheet_name, a.integral, e.project_flag, d.project_id, e.sheet_amount, a.employee_account_record_id, pall.money, CASE WHEN e.sheet_amount ISNULL OR e.sheet_amount = 0 THEN 0 ELSE CASE WHEN pall.money ISNULL OR pall.money = 0 THEN 0 ELSE round((money / sheet_amount) * 100, 2) END END AS percente, d.adjusted_amount AS confirm_integral FROM employee_account_records A LEFT JOIN employees b ON a.employee_id = b.employee_id LEFT JOIN employee_change_plate_records C ON a.employee_id = c.employee_id AND EXTRACT (YEAR FROM a.record_date) = c.YEAR AND EXTRACT (MONTH FROM a.record_date) = c.MONTH LEFT JOIN project_settlement_details d ON a.business_id = d.settlement_detail_id LEFT JOIN projects e ON d.project_id = e.project_id LEFT JOIN (SELECT cd.project_id, SUM(distribution_amount) as money FROM capital_distributions cd WHERE cd.delete_flag = 0 GROUP BY cd.project_id) pall ON pall.project_id = e.project_id WHERE a.record_date BETWEEN ? AND ? AND c.plate_id = ? AND a.employee_id = ? AND a.business_type_id = ? ORDER BY d.project_id, a.integral DESC" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,sheet_code,sheet_name,integral,project_flag,project_id,sheet_amount,employee_account_record_id,money,percente,confirm_integral";
	private final static String[] fieldNames = { "min_record_date", "max_record_date", "plate_id", "employee_id", "business_type_id"};
}
