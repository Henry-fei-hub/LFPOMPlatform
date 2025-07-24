package pomplatform.orderplacement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.orderplacement.bean.BaseOrderPlacement;
import pomplatform.orderplacement.bean.ConditionOrderPlacement;

public class QueryOrderPlacement extends AbstractQuery<BaseOrderPlacement, ConditionOrderPlacement>
{

	private static final Logger __logger = Logger.getLogger(QueryOrderPlacement.class);

	public QueryOrderPlacement() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("oi.order_info_id");
	}

	@Override
	public BaseCollection<BaseOrderPlacement> executeQuery( KeyValuePair[] replacements, ConditionOrderPlacement condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getOrderInfoId()
			);
	}

	public BaseCollection<BaseOrderPlacement> runQuery( KeyValuePair[] replacements, ConditionOrderPlacement condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getOrderInfoId()
			);
	}

	public BaseCollection<BaseOrderPlacement> execute( KeyValuePair[] replacements, ConditionOrderPlacement condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getOrderInfoId()
			);
	}

	@Override
	public BaseOrderPlacement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOrderPlacement __base = new BaseOrderPlacement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOrderInfoId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractFollower(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSerialNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCoveredArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProfessionalCooperation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setServiceSuggestBook(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setClientContractId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSystemAdd(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotations(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalProjectTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "select oi.order_info_id, oi.contract_id, oi.contract_code, oi.contract_name, oi.customer_name, oi.start_date, oi.end_date, oi.status, oi.project_code, oi.contract_type, oi.project_level, oi.contract_price, oi.project_address, oi.contract_follower, oi.remark, oi.contract_date, oi.signing_company_name, oi.create_time, oi.update_time, oi.business_type, oi.flow_status, oi.serial_number, oi.project_type, oi.covered_area, oi.professional_cooperation, oi.province, oi.city, oi.detail_address, oi.customer_address, oi.service_suggest_book, oi.project_approval_time, oi.order_no, oi.info_code, oi.contract_status, oi.client_contract_id, oi.is_finish, oi.is_system_add, oi.has_out_quotations, oi.file_id, oi.file_url,oi.file_name, oi.total_project_time, oi.design_areas, oi.signing_money_sum, oi.has_split_price from order_info oi where oi.order_info_id = ?" ;
	private final static String __originalSQL = "select oi.order_info_id, oi.contract_id, oi.contract_code, oi.contract_name, oi.customer_name, oi.start_date, oi.end_date, oi.status, oi.project_code, oi.contract_type, oi.project_level, oi.contract_price, oi.project_address, oi.contract_follower, oi.remark, oi.contract_date, oi.signing_company_name, oi.create_time, oi.update_time, oi.business_type, oi.flow_status, oi.serial_number, oi.project_type, oi.covered_area, oi.professional_cooperation, oi.province, oi.city, oi.detail_address, oi.customer_address, oi.service_suggest_book, oi.project_approval_time, oi.order_no, oi.info_code, oi.contract_status, oi.client_contract_id, oi.is_finish, oi.is_system_add, oi.has_out_quotations, oi.file_id, oi.file_url, oi.total_project_time, oi.design_areas, oi.signing_money_sum, oi.has_split_price from order_info oi where oi.order_info_id = :order_info_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"oi.order_info_id = :order_info_id\",\"startIndex\": 818,\"stopIndex\":850,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"oi.order_info_id = :order_info_id\",\"fullFieldName\":\"oi.order_info_id\",\"operationName\":\"=\",\"variableName\":\"orderInfoId\",\"startIndex\": 818,\"stopIndex\":850,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "order_info_id,contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,info_code,contract_status,client_contract_id,is_finish,is_system_add,has_out_quotations,file_id,file_url,total_project_time,design_areas,signing_money_sum,has_split_price";
	private final static String[] fieldNames = { "order_info_id"};
}
