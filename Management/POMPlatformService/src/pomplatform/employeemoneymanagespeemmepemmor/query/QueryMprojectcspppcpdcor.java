package pomplatform.employeemoneymanagespeemmepemmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMprojectcspppcpdcor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMprojectcspppcpdcor;

public class QueryMprojectcspppcpdcor extends AbstractQuery<BaseMprojectcspppcpdcor, ConditionMprojectcspppcpdcor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectcspppcpdcor.class);

	public QueryMprojectcspppcpdcor() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pj.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectcspppcpdcor> executeQuery( KeyValuePair[] replacements, ConditionMprojectcspppcpdcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getContractCode(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseMprojectcspppcpdcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectcspppcpdcor __base = new BaseMprojectcspppcpdcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectSetupFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReturnMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReturnPercent(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT pj.project_id, pj.contract_code, pj.project_code, pj.project_name, pj.plate_id, pj.department_id, pj.project_manage_id, pj.status, pj.total_integral, pj.total_amount, pj.project_integral, pj.sheet_amount, pj.create_time, pj.project_flag, pj.money_sum, pj.project_setup_flag, pj.contract_id, pj.sub_contract_id, cs.return_money, case when (pj.sheet_amount is null or pj.sheet_amount = 0 or cs.return_money is null or cs.return_money = 0) then 0 else round(cs.return_money/pj.sheet_amount*100,2) end as return_percent FROM projects pj LEFT JOIN ( SELECT sub_contract_id, sum(money) as return_money FROM( SELECT sub_contract_id, money FROM capital_distribution_link_sub_contracts WHERE capital_distribution_id IN ( SELECT business_id FROM system_process_instances spi WHERE process_type = 11 AND process_status = 3 ) AND capital_id ISNULL AND capital_distribution_id NOTNULL UNION ALL SELECT sub_contract_id, money FROM capital_distribution_link_sub_contracts WHERE capital_id NOTNULL AND capital_distribution_id ISNULL )aa GROUP BY aa.sub_contract_id ) cs ON cs.sub_contract_id = pj.project_id WHERE pj.project_id = ? AND pj.project_code LIKE ? AND pj.project_name LIKE ? AND pj.contract_code LIKE ? AND pj.plate_id = ? AND pj.department_id = ? AND pj.contract_id =?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,plate_id,department_id,project_manage_id,status,total_integral,total_amount,project_integral,sheet_amount,create_time,project_flag,money_sum,project_setup_flag,contract_id,sub_contract_id,return_money,return_percent";
	private final static String[] fieldNames = { "project_id", "project_code", "project_name", "contract_code", "plate_id", "department_id", "contract_id"};
}
