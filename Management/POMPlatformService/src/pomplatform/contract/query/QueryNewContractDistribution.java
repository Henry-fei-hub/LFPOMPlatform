package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseNewContractDistribution;
import pomplatform.contract.bean.ConditionNewContractDistribution;

public class QueryNewContractDistribution extends AbstractQuery<BaseNewContractDistribution, ConditionNewContractDistribution>
{

	private static final Logger __logger = Logger.getLogger(QueryNewContractDistribution.class);

	public QueryNewContractDistribution() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("C .contract_id");
	}

	@Override
	public BaseCollection<BaseNewContractDistribution> executeQuery( KeyValuePair[] replacements, ConditionNewContractDistribution condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getSelectYear(), 
				condition.getSelectMonth(), 
				condition.getBusinessType(), 
				condition.getContractSigningStatus()
			);
	}

	@Override
	public BaseNewContractDistribution generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNewContractDistribution __base = new BaseNewContractDistribution();
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
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setClientContractId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSystemAdd(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinancialContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractArea(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractInfoAudited(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContractSigningStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActualMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT C .contract_id, C .contract_code, C .contract_name, C .customer_name, C .start_date, C .end_date, C .status, C .project_code, C .contract_type, C .project_level, C .total_project_time, C .signing_money_sum, C .design_areas, C .contract_price, C .project_address, C .contract_follower, C .remark, C .contract_date, C .signing_company_name, C .create_time, C .update_time, C .business_type, C .flow_status, C .serial_number, C .project_type, C .covered_area, C .professional_cooperation, C .province, C .city, C .detail_address, C .customer_address, C .service_suggest_book, C .project_approval_time, C .order_no, C .parent_id, C .info_code, C .contract_status, C .client_contract_id, C .is_finish, C .is_system_add, C . OPERATOR, C .attachment_remark, C .financial_contract_code, C .contract_area, C .customer_id, C .contract_info_audited, C .contract_signing_status, C .sending_date, ( SELECT string_agg (b.plate_name, ',') FROM contract_distributions A LEFT JOIN plate_records b ON A .plate_id = b.plate_id WHERE A .contract_id = C .contract_id AND A .delete_flag = 0 ) AS team, cd.actual_money, ppt.is_original, ppt.is_sub_project FROM contracts C LEFT JOIN contract_distributions cd ON C .contract_id = cd.contract_id LEFT JOIN main_projects ppt ON ppt.project_code = C.project_code WHERE 1=1 AND C.contract_code LIKE ? AND C.contract_name LIKE ? AND EXTRACT (YEAR FROM C .contract_date) = ? AND EXTRACT (MONTH FROM C .contract_date) = ? AND C.business_type = ? AND C.contract_signing_status = ? GROUP BY C .contract_id, C .contract_code, C .contract_name, C .customer_name, C .start_date, C .end_date, C .status, C .project_code, C .contract_type, C .project_level, C .total_project_time, C .signing_money_sum, C .design_areas, C .contract_price, C .project_address, C .contract_follower, C .remark, C .contract_date, C .signing_company_name, C .create_time, C .update_time, C .business_type, C .flow_status, C .serial_number, C .project_type, C .covered_area, C .professional_cooperation, C .province, C .city, C .detail_address, C .customer_address, C .service_suggest_book, C .project_approval_time, C .order_no, C .parent_id, C .info_code, C .contract_status, C .client_contract_id, C .is_finish, C .is_system_add, C . OPERATOR, C .attachment_remark, C .financial_contract_code, C .contract_area, C .customer_id, C .contract_info_audited, C .contract_signing_status, C .sending_date, cd.actual_money, ppt.is_original, ppt.is_sub_project ORDER BY C .contract_code" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,parent_id,info_code,contract_status,client_contract_id,is_finish,is_system_add,operator,attachment_remark,financial_contract_code,contract_area,customer_id,contract_info_audited,contract_signing_status,sending_date,team,actual_money,is_original,is_sub_project";
	private final static String[] fieldNames = { "contract_code", "contract_name", "select_year", "select_month", "business_type", "contract_signing_status"};
}
