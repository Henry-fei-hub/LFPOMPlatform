package pomplatform.ht.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ht.bean.BaseOutQuotation;
import pomplatform.ht.bean.ConditionOutQuotation;

public class QueryOutQuotation extends AbstractQuery<BaseOutQuotation, ConditionOutQuotation>
{

	private static final Logger __logger = Logger.getLogger(QueryOutQuotation.class);

	public QueryOutQuotation() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("oq.out_quotation_id");
	}

	@Override
	public BaseCollection<BaseOutQuotation> executeQuery( KeyValuePair[] replacements, ConditionOutQuotation condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getOutQuotationId()
			);
	}

	public BaseCollection<BaseOutQuotation> runQuery( KeyValuePair[] replacements, ConditionOutQuotation condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getOutQuotationId()
			);
	}

	public BaseCollection<BaseOutQuotation> execute( KeyValuePair[] replacements, ConditionOutQuotation condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getOutQuotationId()
			);
	}

	@Override
	public BaseOutQuotation generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOutQuotation __base = new BaseOutQuotation();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationFiles(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQuotationStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDisableType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
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
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "select oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time, oq.info_code, oq.project_code, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time from out_quotations oq where oq.out_quotation_id = ?" ;
	private final static String __originalSQL = "select oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time, oq.info_code, oq.project_code, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time from out_quotations oq where oq.out_quotation_id =:out_quotation_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"oq.out_quotation_id =:out_quotation_id\",\"startIndex\": 298,\"stopIndex\":335,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"oq.out_quotation_id =:out_quotation_id\",\"fullFieldName\":\"oq.out_quotation_id\",\"operationName\":\"=\",\"variableName\":\"outQuotationId\",\"startIndex\": 298,\"stopIndex\":335,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "out_quotation_id,quotation_number,quotation_name,money_sum,create_time,info_code,project_code,business_type,project_type,quotation_files,quotation_status,disable_type,employee_id,contract_id,update_time";
	private final static String[] fieldNames = { "out_quotation_id"};
}
