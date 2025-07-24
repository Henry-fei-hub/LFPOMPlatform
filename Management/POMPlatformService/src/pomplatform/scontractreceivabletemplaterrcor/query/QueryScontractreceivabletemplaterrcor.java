package pomplatform.scontractreceivabletemplaterrcor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.scontractreceivabletemplaterrcor.bean.BaseScontractreceivabletemplaterrcor;
import pomplatform.scontractreceivabletemplaterrcor.bean.ConditionScontractreceivabletemplaterrcor;

public class QueryScontractreceivabletemplaterrcor extends AbstractQuery<BaseScontractreceivabletemplaterrcor, ConditionScontractreceivabletemplaterrcor>
{

	private static final Logger __logger = Logger.getLogger(QueryScontractreceivabletemplaterrcor.class);

	public QueryScontractreceivabletemplaterrcor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("crt.contract_receivable_template_id");
	}

	@Override
	public BaseCollection<BaseScontractreceivabletemplaterrcor> executeQuery( KeyValuePair[] replacements, ConditionScontractreceivabletemplaterrcor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getReceivableName(), 
				condition.getRemark(), 
				condition.getContractReceivableTemplateId(), 
				condition.getParentId(), 
				condition.getOperator()
			);
	}

	public BaseCollection<BaseScontractreceivabletemplaterrcor> runQuery( KeyValuePair[] replacements, ConditionScontractreceivabletemplaterrcor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getReceivableName(), 
				condition.getRemark(), 
				condition.getContractReceivableTemplateId(), 
				condition.getParentId(), 
				condition.getOperator()
			);
	}

	public BaseCollection<BaseScontractreceivabletemplaterrcor> execute( KeyValuePair[] replacements, ConditionScontractreceivabletemplaterrcor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getReceivableName(), 
				condition.getRemark(), 
				condition.getContractReceivableTemplateId(), 
				condition.getParentId(), 
				condition.getOperator()
			);
	}

	@Override
	public BaseScontractreceivabletemplaterrcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScontractreceivabletemplaterrcor __base = new BaseScontractreceivabletemplaterrcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractReceivableTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceivableName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT crt.contract_receivable_template_id, crt.receivable_name, crt.remark, crt.parent_id, crt.OPERATOR, crt.create_time, crt.update_time, crt.receivable_percentage FROM contract_receivable_templates crt WHERE crt.receivable_name like ? and crt.remark like ? and crt.contract_receivable_template_id = ? and crt.parent_id = ? and crt.OPERATOR = ?" ;
	private final static String __originalSQL = "SELECT crt.contract_receivable_template_id, crt.receivable_name, crt.remark, crt.parent_id, crt.OPERATOR, crt.create_time, crt.update_time, crt.receivable_percentage FROM contract_receivable_templates crt WHERE crt.receivable_name LIKE :receivable_name AND crt.remark LIKE :remark AND crt.contract_receivable_template_id =:contract_receivable_template_id AND crt.parent_id =:parent_id AND crt.OPERATOR =:OPERATOR";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"crt.receivable_name LIKE :receivable_name AND crt.remark LIKE :remark AND crt.contract_receivable_template_id =:contract_receivable_template_id AND crt.parent_id =:parent_id AND crt.OPERATOR =:OPERATOR\",\"startIndex\": 211,\"stopIndex\":411,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"crt.receivable_name LIKE :receivable_name\",\"fullFieldName\":\"crt.receivable_name\",\"operationName\":\"like\",\"variableName\":\"receivableName\",\"nextToken\":\"and\",\"startIndex\": 211,\"stopIndex\":251,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"crt.remark LIKE :remark\",\"fullFieldName\":\"crt.remark\",\"operationName\":\"like\",\"variableName\":\"remark\",\"nextToken\":\"and\",\"startIndex\": 257,\"stopIndex\":279,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"crt.contract_receivable_template_id =:contract_receivable_template_id\",\"fullFieldName\":\"crt.contract_receivable_template_id\",\"operationName\":\"=\",\"variableName\":\"contractReceivableTemplateId\",\"nextToken\":\"and\",\"startIndex\": 285,\"stopIndex\":353,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"crt.parent_id =:parent_id\",\"fullFieldName\":\"crt.parent_id\",\"operationName\":\"=\",\"variableName\":\"parentId\",\"nextToken\":\"and\",\"startIndex\": 359,\"stopIndex\":383,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"crt.OPERATOR =:OPERATOR\",\"fullFieldName\":\"crt.OPERATOR\",\"operationName\":\"=\",\"variableName\":\"operator\",\"startIndex\": 389,\"stopIndex\":411,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_receivable_template_id,receivable_name,remark,parent_id,operator,create_time,update_time,receivable_percentage";
	private final static String[] fieldNames = { "receivable_name", "remark", "contract_receivable_template_id", "parent_id", "operator"};
}
