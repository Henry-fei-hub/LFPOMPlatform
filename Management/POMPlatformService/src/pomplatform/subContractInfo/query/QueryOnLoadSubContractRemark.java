package pomplatform.subContractInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.subContractInfo.bean.BaseOnLoadSubContractRemark;
import pomplatform.subContractInfo.bean.ConditionOnLoadSubContractRemark;

public class QueryOnLoadSubContractRemark extends AbstractQuery<BaseOnLoadSubContractRemark, ConditionOnLoadSubContractRemark>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSubContractRemark.class);

	public QueryOnLoadSubContractRemark() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .contract_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSubContractRemark> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSubContractRemark condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadSubContractRemark> runQuery( KeyValuePair[] replacements, ConditionOnLoadSubContractRemark condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadSubContractRemark> execute( KeyValuePair[] replacements, ConditionOnLoadSubContractRemark condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseOnLoadSubContractRemark generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSubContractRemark __base = new BaseOnLoadSubContractRemark();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractRemarks(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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

	private final static String __SQLText = "SELECT A .contract_id, b.content_info AS sub_contract_remarks, C.file_id AS attachment_id, C.file_name AS attachment_name, C.file_url AS attachment, d.remark FROM contracts AS A LEFT JOIN sub_contract_remarks AS b ON A.contract_id = b.contract_id LEFT JOIN file_manages AS C ON A.file_id = C.file_id left join( SELECT * FROM ( SELECT *, row_number() over (partition by contract_id order by create_time desc) FROM order_info ) AS tmp WHERE row_number = 1 ) as d on A.contract_id = d.contract_id WHERE A.contract_id > 0 and A.contract_id = ?" ;
	private final static String __originalSQL = "SELECT A .contract_id, b.content_info AS sub_contract_remarks, C.file_id AS attachment_id, C.file_name AS attachment_name, C.file_url AS attachment, d.remark FROM contracts AS A LEFT JOIN sub_contract_remarks AS b ON A.contract_id = b.contract_id LEFT JOIN file_manages AS C ON A.file_id = C.file_id left join( SELECT * FROM ( SELECT *, row_number() over (partition by contract_id order by create_time desc) FROM order_info ) AS tmp WHERE row_number = 1 ) as d on A.contract_id = d.contract_id WHERE A.contract_id > 0 AND A.contract_id =:contract_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.contract_id > 0 AND A.contract_id =:contract_id\",\"startIndex\": 500,\"stopIndex\":548,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.contract_id > 0\",\"nextToken\":\"and\",\"startIndex\": 500,\"stopIndex\":516,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_id =:contract_id\",\"fullFieldName\":\"A.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 522,\"stopIndex\":548,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,sub_contract_remarks,attachment_id,attachment_name,attachment,remark";
	private final static String[] fieldNames = { "contract_id"};
}
