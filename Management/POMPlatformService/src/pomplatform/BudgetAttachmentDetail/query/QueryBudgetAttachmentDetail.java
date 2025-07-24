package pomplatform.BudgetAttachmentDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.BudgetAttachmentDetail.bean.BaseBudgetAttachmentDetail;
import pomplatform.BudgetAttachmentDetail.bean.ConditionBudgetAttachmentDetail;

public class QueryBudgetAttachmentDetail extends AbstractQuery<BaseBudgetAttachmentDetail, ConditionBudgetAttachmentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryBudgetAttachmentDetail.class);

	public QueryBudgetAttachmentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("budget_attachment_id");
	}

	@Override
	public BaseCollection<BaseBudgetAttachmentDetail> executeQuery( KeyValuePair[] replacements, ConditionBudgetAttachmentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId(), 
				condition.getBudgetAttachmentId()
			);
	}

	@Override
	public BaseBudgetAttachmentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBudgetAttachmentDetail __base = new BaseBudgetAttachmentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUploadEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUploadRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountRest(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBddType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsApproval(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "SELECT budget_attachment_id, budget_management_id, b.file_id, b.attachment_name, upload_employee_id, upload_time, upload_remark, budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest, receive_unit_manage_id, f.file_url,bdd_type,case WHEN budget_contract_amount<=0 OR budget_contract_amount IS NULL then '0.00%' ELSE CAST ( budget_contract_amount_use / budget_contract_amount * 100 AS DECIMAL ( 18, 2 )) || '%' END AS pay_percent,is_approval,project_id,is_lock FROM budget_attachment b LEFT JOIN file_manages f ON b.file_id=f.file_id WHERE b.budget_management_id=? AND b.budget_attachment_id=? ORDER BY budget_attachment_id" ;
	private final static String RESULTSETFIELDLIST = "budget_attachment_id,budget_management_id,file_id,attachment_name,upload_employee_id,upload_time,upload_remark,budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest,receive_unit_manage_id,file_url,bdd_type,pay_percent,is_approval,project_id,is_lock";
	private final static String[] fieldNames = { "budget_management_id", "budget_attachment_id"};
}
