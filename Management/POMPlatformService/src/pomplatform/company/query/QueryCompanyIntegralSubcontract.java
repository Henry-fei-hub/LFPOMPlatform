package pomplatform.company.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.company.bean.BaseCompanyIntegralSubcontract;
import pomplatform.company.bean.ConditionCompanyIntegralSubcontract;

public class QueryCompanyIntegralSubcontract extends AbstractQuery<BaseCompanyIntegralSubcontract, ConditionCompanyIntegralSubcontract>
{

	private static final Logger __logger = Logger.getLogger(QueryCompanyIntegralSubcontract.class);

	public QueryCompanyIntegralSubcontract() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sc.sub_contract_code");
	}

	@Override
	public BaseCollection<BaseCompanyIntegralSubcontract> executeQuery( KeyValuePair[] replacements, ConditionCompanyIntegralSubcontract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getBusinessType(), 
				condition.getProjectType(), 
				condition.getDepartmentId(), 
				condition.getSubContractCode(), 
				condition.getSubContractName()
			);
	}

	@Override
	public BaseCompanyIntegralSubcontract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCompanyIntegralSubcontract __base = new BaseCompanyIntegralSubcontract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAgreeDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT sc.sub_contract_code, sc.sub_contract_name, sc.business_type, sc.project_type, sc.department_id, sc.sheet_total_integral, sc.complaint_percentage, sc.complaint_integral, sc.sheet_integral, sc.money_sum, sc.common_area, sc.logistics_area, sc.design_area, sc.agree_date, sc.project_code from sub_contracts sc WHERE sc.agree_date >= ? AND sc.agree_date < ? AND sc.business_type = ? AND sc.project_type = ? AND sc.department_id = ? AND sc.sub_contract_code LIKE ? AND sc.sub_contract_name LIKE ?" ;
	private final static String RESULTSETFIELDLIST = "sub_contract_code,sub_contract_name,business_type,project_type,department_id,sheet_total_integral,complaint_percentage,complaint_integral,sheet_integral,money_sum,common_area,logistics_area,design_area,agree_date,project_code";
	private final static String[] fieldNames = { "start_date", "end_date", "business_type", "project_type", "department_id", "sub_contract_code", "sub_contract_name"};
}
