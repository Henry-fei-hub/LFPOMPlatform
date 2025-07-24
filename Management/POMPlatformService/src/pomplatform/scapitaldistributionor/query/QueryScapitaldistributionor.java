package pomplatform.scapitaldistributionor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.scapitaldistributionor.bean.BaseScapitaldistributionor;
import pomplatform.scapitaldistributionor.bean.ConditionScapitaldistributionor;

public class QueryScapitaldistributionor extends AbstractQuery<BaseScapitaldistributionor, ConditionScapitaldistributionor>
{

	private static final Logger __logger = Logger.getLogger(QueryScapitaldistributionor.class);

	public QueryScapitaldistributionor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cd.capital_distribution_id");
	}

	@Override
	public BaseCollection<BaseScapitaldistributionor> executeQuery( KeyValuePair[] replacements, ConditionScapitaldistributionor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalDistributionId()
			);
	}

	@Override
	public BaseScapitaldistributionor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScapitaldistributionor __base = new BaseScapitaldistributionor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setMainProfessional(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractChangeAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select cd.capital_distribution_id, cd.code, cd.process_instance_id, cd.apply_employee_id, cd.employee_id, cd.department_id, cd.title, cd.company_id, cd.contract_id, cd.capital_id, cd.apply_time, cd.complete_time, cd.remark, cd.is_completed, cd.main_professional, cd.contract_change_amount from capital_distributions cd where cd.capital_distribution_id = ?" ;
	private final static String RESULTSETFIELDLIST = "capital_distribution_id,code,process_instance_id,apply_employee_id,employee_id,department_id,title,company_id,contract_id,capital_id,apply_time,complete_time,remark,is_completed,main_professional,contract_change_amount";
	private final static String[] fieldNames = { "capital_distribution_id"};
}
