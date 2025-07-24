package pomplatform.getbudgetuplodanews.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getbudgetuplodanews.bean.BaseGetBudgetUplodaNews;
import pomplatform.getbudgetuplodanews.bean.ConditionGetBudgetUplodaNews;

public class QueryGetBudgetUplodaNews extends AbstractQuery<BaseGetBudgetUplodaNews, ConditionGetBudgetUplodaNews>
{

	private static final Logger __logger = Logger.getLogger(QueryGetBudgetUplodaNews.class);

	public QueryGetBudgetUplodaNews() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.budget_management_id");
	}

	@Override
	public BaseCollection<BaseGetBudgetUplodaNews> executeQuery( KeyValuePair[] replacements, ConditionGetBudgetUplodaNews condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId(), 
				condition.getFileId()
			);
	}

	@Override
	public BaseGetBudgetUplodaNews generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetBudgetUplodaNews __base = new BaseGetBudgetUplodaNews();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBdType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdUseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdRestAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBdEstimatecloseTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBdStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostBearing(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOutSourceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBdUploadRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT b.budget_management_id, b.bd_code, b.bd_type, b.bd_total_amount, b.bd_use_amount, b.bd_rest_amount, b.bd_apply_employee_id, b.bd_apply_time, b.bd_estimateclose_time, b.bd_status, b.project_id, b.bd_remark, b.input_tax_invoice_id, b.department_id, b.company_id, b.cost_bearing, b.out_source_type, b.file_id, b.bd_attachment_name, b.bd_upload_remark, f.file_url,f.create_time FROM budget_management b LEFT JOIN file_manages f ON b.file_id = f.file_id WHERE b.budget_management_id=? AND b.file_id=?" ;
	private final static String RESULTSETFIELDLIST = "budget_management_id,bd_code,bd_type,bd_total_amount,bd_use_amount,bd_rest_amount,bd_apply_employee_id,bd_apply_time,bd_estimateclose_time,bd_status,project_id,bd_remark,input_tax_invoice_id,department_id,company_id,cost_bearing,out_source_type,file_id,bd_attachment_name,bd_upload_remark,file_url,f.create_time";
	private final static String[] fieldNames = { "budget_management_id", "file_id"};
}
