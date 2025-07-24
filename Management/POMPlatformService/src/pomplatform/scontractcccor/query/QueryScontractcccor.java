package pomplatform.scontractcccor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.scontractcccor.bean.BaseScontractcccor;
import pomplatform.scontractcccor.bean.ConditionScontractcccor;

public class QueryScontractcccor extends AbstractQuery<BaseScontractcccor, ConditionScontractcccor>
{

	private static final Logger __logger = Logger.getLogger(QueryScontractcccor.class);

	public QueryScontractcccor() throws java.sql.SQLException 
	{
		setParameterNumber(23);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ct.contract_id");
	}

	@Override
	public BaseCollection<BaseScontractcccor> executeQuery( KeyValuePair[] replacements, ConditionScontractcccor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getHasSplitPrice(), 
				condition.getIsSystemAdd(), 
				condition.getFlowStatus(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getStatus(), 
				condition.getProjectCode(), 
				condition.getContractType(), 
				condition.getProjectLevel(), 
				condition.getTotalProjectTime(), 
				condition.getContractFollower(), 
				condition.getRemark(), 
				condition.getSigningCompanyName(), 
				condition.getFlowStatus(), 
				condition.getSerialNumber(), 
				condition.getInfoCode(), 
				condition.getContractStatus(), 
				condition.getClientContractId(), 
				condition.getIsFinish(), 
				condition.getIsSystemAdd(), 
				condition.getDetailAddress(), 
				condition.getCustomerAddress()
			);
	}

	@Override
	public BaseScontractcccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScontractcccor __base = new BaseScontractcccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalProjectTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignAreas(GenericBase.__getDecimal(val));
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
		if((val = __data[count++]) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotations(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[0]));
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
		if(args[19] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[19]));
		if(args[20] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[20]));
		if(args[21] != null) __statement.setString(count++, GenericBase.__getString(args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
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

	private final static String __SQLText = "SELECT ct.contract_id, ct.contract_code, ct.contract_name, ct.customer_name, ct.start_date, ct.end_date, ct.status, ct.project_code, ct.contract_type, ct.project_level, M.design_team AS total_project_time, ct.signing_money_sum, ct.design_areas, ct.contract_price, ct.project_address, ct.contract_follower, ct.remark, ct.contract_date, ct.signing_company_name, ct.create_time, ct.update_time, ct.business_type, ct.flow_status, ct.serial_number, ct.project_type, ct.covered_area, ct.professional_cooperation, ct.province, ct.city, ct.detail_address, ct.customer_address, ct.service_suggest_book, ct.project_approval_time, ct.order_no, ct.info_code, ct.contract_status, ct.client_contract_id, ct.is_finish, ct.is_system_add, M.has_split_price, M.has_out_quotations ,ct.file_id,ct.file_url FROM contracts ct LEFT JOIN main_projects M ON ct.info_code = M.info_code and ct.project_code = M.project_code LEFT JOIN out_quotations o ON ct.info_code = o.info_code and ct.project_code = o.project_code AND o.quotation_status =1 WHERE o.out_quotation_id > 0 AND M.process_status = 2 AND M.has_split_price=? AND ct.is_system_add =? AND ct.flow_status =? AND ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND ct.status = ? AND ct.project_code LIKE ? AND ct.contract_type = ? AND ct.project_level = ? AND ct.total_project_time = ? AND ct.contract_follower = ? AND ct.remark LIKE ? AND ct.signing_company_name = ? AND ct.flow_status = ? AND ct.serial_number LIKE ? AND ct.info_code = ? AND ct.contract_status = ? AND ct.client_contract_id LIKE ? AND ct.is_finish = ? AND ct.is_system_add = ? AND ct.detail_address LIKE ? AND ct.customer_address LIKE ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,info_code,contract_status,client_contract_id,is_finish,is_system_add,has_split_price,has_out_quotations,file_id,file_url";
	private final static String[] fieldNames = { "has_split_price", "is_system_add", "flow_status", "contract_id", "contract_code", "contract_name", "status", "project_code", "contract_type", "project_level", "total_project_time", "contract_follower", "remark", "signing_company_name", "flow_status", "serial_number", "info_code", "contract_status", "client_contract_id", "is_finish", "is_system_add", "detail_address", "customer_address"};
}
