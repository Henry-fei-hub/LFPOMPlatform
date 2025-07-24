package pomplatform.contractreceivablecipor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractreceivablecipor.bean.BaseMcontractreceivablecipcor;
import pomplatform.contractreceivablecipor.bean.ConditionMcontractreceivablecipcor;

public class QueryMcontractreceivablecipcor extends AbstractQuery<BaseMcontractreceivablecipcor, ConditionMcontractreceivablecipcor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractreceivablecipcor.class);

	public QueryMcontractreceivablecipcor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cr.contract_receivable_id");
	}

	@Override
	public BaseCollection<BaseMcontractreceivablecipcor> executeQuery( KeyValuePair[] replacements, ConditionMcontractreceivablecipcor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractCode()
			);
	}

	public BaseCollection<BaseMcontractreceivablecipcor> runQuery( KeyValuePair[] replacements, ConditionMcontractreceivablecipcor condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getContractId(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractCode()
			);
	}

	public BaseCollection<BaseMcontractreceivablecipcor> execute( KeyValuePair[] replacements, ConditionMcontractreceivablecipcor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getContractId(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractCode()
			);
	}

	@Override
	public BaseMcontractreceivablecipcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractreceivablecipcor __base = new BaseMcontractreceivablecipcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivableName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceivableSumMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsConfirmationLetter(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select cr.contract_receivable_id, cr.info_code, cr.project_code, cr.contract_id, cr.contract_code, cr.receivable_name, cr.receivable_percentage, cr.receivable_sum_money, cr.is_confirmation_letter, cr.remark, cr.parent_id, cr.operator, cr.create_time, cr.update_time, CASE WHEN c.signing_money_sum ISNULL THEN 0 ELSE c.signing_money_sum END as signing_money_sum from contract_receivables as cr left join contracts c on cr.contract_id = c.contract_id where cr.contract_id = ? and cr.info_code like ? and cr.project_code like ? and cr.contract_code like ?" ;
	private final static String __originalSQL = "select cr.contract_receivable_id, cr.info_code, cr.project_code, cr.contract_id, cr.contract_code, cr.receivable_name, cr.receivable_percentage, cr.receivable_sum_money, cr.is_confirmation_letter, cr.remark, cr.parent_id, cr.operator, cr.create_time, cr.update_time, CASE WHEN c.signing_money_sum ISNULL THEN 0 ELSE c.signing_money_sum END as signing_money_sum from contract_receivables as cr left join contracts c on cr.contract_id = c.contract_id where cr.contract_id = :contract_id and cr.info_code like :info_code and cr.project_code like :project_code and cr.contract_code like :contract_code";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"cr.contract_id = :contract_id and cr.info_code like :info_code and cr.project_code like :project_code and cr.contract_code like :contract_code\",\"startIndex\": 455,\"stopIndex\":596,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"cr.contract_id = :contract_id\",\"fullFieldName\":\"cr.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 455,\"stopIndex\":483,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cr.info_code like :info_code\",\"fullFieldName\":\"cr.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"startIndex\": 489,\"stopIndex\":516,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cr.project_code like :project_code\",\"fullFieldName\":\"cr.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 522,\"stopIndex\":555,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cr.contract_code like :contract_code\",\"fullFieldName\":\"cr.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"startIndex\": 561,\"stopIndex\":596,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_receivable_id,info_code,project_code,contract_id,contract_code,receivable_name,receivable_percentage,receivable_sum_money,is_confirmation_letter,remark,parent_id,operator,create_time,update_time,signing_money_sum";
	private final static String[] fieldNames = { "contract_id", "info_code", "project_code", "contract_code"};
}
