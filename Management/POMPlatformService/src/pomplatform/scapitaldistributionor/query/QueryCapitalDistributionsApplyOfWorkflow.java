package pomplatform.scapitaldistributionor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionsApplyOfWorkflow;
import pomplatform.scapitaldistributionor.bean.ConditionCapitalDistributionsApplyOfWorkflow;

public class QueryCapitalDistributionsApplyOfWorkflow extends AbstractQuery<BaseCapitalDistributionsApplyOfWorkflow, ConditionCapitalDistributionsApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalDistributionsApplyOfWorkflow.class);

	public QueryCapitalDistributionsApplyOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseCapitalDistributionsApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionCapitalDistributionsApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getContractName(), 
				condition.getBorrowMoney(), 
				condition.getCustomerName(), 
				condition.getTitle(), 
				condition.getOtherName(), 
				condition.getDepartmentId(), 
				condition.getCode()
			);
	}

	@Override
	public BaseCapitalDistributionsApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalDistributionsApplyOfWorkflow __base = new BaseCapitalDistributionsApplyOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractChangeAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMainProfessional(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAllBorrowMoney(GenericBase.__getDecimal(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, a.department_id, a.employee_id, a.code, a.company_id, a.title, a.contract_change_amount, a.main_professional, a.remark, ct.contract_code, ct.signing_money_sum, ct.contract_name, ct.customer_name, cp.happen_date, cp.other_name, cp.borrow_money, aa.all_borrow_money FROM system_process_instances spi LEFT JOIN capital_distributions a ON spi.business_id = a.capital_distribution_id LEFT JOIN contracts ct ON ct.contract_id = a.contract_id LEFT JOIN capitals cp ON cp.capital_id = a.capital_id LEFT JOIN (SELECT SUM(borrow_money) AS all_borrow_money,contract_id FROM capitals GROUP BY contract_id) aa ON aa.contract_id = a.contract_id WHERE spi.process_type = ? AND spi.business_id = ? AND spi.process_status IN (0, 1) AND spi.delete_flag = 0 AND a.delete_flag = 0 AND a.employee_id = ? AND a.company_id = ? AND ct.contract_name LIKE ? AND cp.borrow_money = ? AND ct.customer_name LIKE ? AND a.title LIKE ? AND cp.other_name LIKE ? AND a.department_id = ?  AND a.code LIKE ? ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,department_id,employee_id,code,company_id,title,contract_change_amount,main_professional,remark,contract_code,signing_money_sum,contract_name,customer_name,happen_date,other_name,borrow_money,all_borrow_money";
	private final static String[] fieldNames = { "process_type", "business_id", "employee_id", "company_id", "contract_name", "borrow_money", "customer_name", "title", "other_name", "department_id", "code"};
}
