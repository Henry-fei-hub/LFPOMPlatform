package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BasePayMoneyManageOfWorkflow;
import pomplatform.workflow.bean.ConditionPayMoneyManageOfWorkflow;

public class QueryPayMoneyManageOfWorkflow extends AbstractQuery<BasePayMoneyManageOfWorkflow, ConditionPayMoneyManageOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryPayMoneyManageOfWorkflow.class);

	public QueryPayMoneyManageOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pmm.pay_money_manage_id");
	}

	@Override
	public BaseCollection<BasePayMoneyManageOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionPayMoneyManageOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReceiveUnit(), 
				condition.getBankAccount(), 
				condition.getBankName(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BasePayMoneyManageOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BasePayMoneyManageOfWorkflow __base = new BasePayMoneyManageOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPayMoneyManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTitleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "select pmm.pay_money_manage_id, pmm.receive_unit, pmm.bank_account, pmm.bank_name, pmm.title_name, pmm.pay_amount, pmm.employee_id,pmm.department_id,pmm.attachment_file, pmm.reason, pmm.operate_employee_id, pmm.operate_time,pmm.code,pmm.company_id from pay_money_manages pmm where pmm.receive_unit like ? and pmm.bank_account like ? and pmm.bank_name like ? and pmm.employee_id = ? order by pmm.pay_amount,pmm.operate_time desc" ;
	private final static String RESULTSETFIELDLIST = "pay_money_manage_id,receive_unit,bank_account,bank_name,title_name,pay_amount,employee_id,department_id,attachment_file,reason,operate_employee_id,operate_time,code,company_id";
	private final static String[] fieldNames = { "receive_unit", "bank_account", "bank_name", "employee_id"};
}
