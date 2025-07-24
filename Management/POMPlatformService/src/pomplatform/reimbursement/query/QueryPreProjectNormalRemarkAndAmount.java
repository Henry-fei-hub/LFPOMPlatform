package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BasePreProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionPreProjectNormalRemarkAndAmount;

public class QueryPreProjectNormalRemarkAndAmount extends AbstractQuery<BasePreProjectNormalRemarkAndAmount, ConditionPreProjectNormalRemarkAndAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectNormalRemarkAndAmount.class);

	public QueryPreProjectNormalRemarkAndAmount() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.department_id");
	}

	@Override
	public BaseCollection<BasePreProjectNormalRemarkAndAmount> executeQuery( KeyValuePair[] replacements, ConditionPreProjectNormalRemarkAndAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId()
			);
	}

	@Override
	public BasePreProjectNormalRemarkAndAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectNormalRemarkAndAmount __base = new BasePreProjectNormalRemarkAndAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainItemId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubItemId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.department_id, e.main_item_id, e.sub_item_id, e.amount, e.input_tax, e.input_tax_rebate, concat(a.code, case when a.code is null then '' else '-' end, d.department_name, case when d.department_name is null then '' else '-' end, c.employee_name, case when c.employee_name is null then '' else '-' end, e.remark) as remark from project_normal_reimbursements a LEFT JOIN employees c on a.apply_employee_id = c.employee_id LEFT JOIN departments d on a.department_id = d.department_id LEFT JOIN normal_reimbursement_link_main_projects e on a.project_normal_reimbursement_id = e.project_normal_reimbursement_id where a.project_normal_reimbursement_id = ? " ;
	private final static String RESULTSETFIELDLIST = "department_id,main_item_id,sub_item_id,amount,input_tax,input_tax_rebate,remark";
	private final static String[] fieldNames = { "business_id"};
}
