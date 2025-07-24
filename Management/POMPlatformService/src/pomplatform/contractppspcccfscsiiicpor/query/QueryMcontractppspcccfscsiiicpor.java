package pomplatform.contractppspcccfscsiiicpor.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.contractppspcccfscsiiicpor.bean.BaseMcontractppspcccfscsiiicpor;
import pomplatform.contractppspcccfscsiiicpor.bean.ConditionMcontractppspcccfscsiiicpor;

public class QueryMcontractppspcccfscsiiicpor extends AbstractQuery<BaseMcontractppspcccfscsiiicpor, ConditionMcontractppspcccfscsiiicpor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractppspcccfscsiiicpor.class);

	public QueryMcontractppspcccfscsiiicpor() throws java.sql.SQLException 
	{
		setParameterNumber(20);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.flag");
	}

	@Override
	public BaseCollection<BaseMcontractppspcccfscsiiicpor> executeQuery( KeyValuePair[] replacements, ConditionMcontractppspcccfscsiiicpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectName(), 
				condition.getSubContractCode(), 
				condition.getProjectId(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getFlowStatus(), 
				condition.getSigningMoneySum(), 
				condition.getContractPrice(), 
				condition.getStatus(), 
				condition.getIsFinish(), 
				condition.getIsSystemAdd(), 
				condition.getInfoCode(), 
				condition.getCustomerName(), 
				condition.getProjectCode(), 
				condition.getPlateId(), 
				condition.getProjectManageId(), 
				condition.getContractStatus(), 
				condition.getContractSigningStatus(), 
				condition.getFlag()
			);
	}

	@Override
	public BaseMcontractppspcccfscsiiicpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractppspcccfscsiiicpor __base = new BaseMcontractppspcccfscsiiicpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployeesName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMsgCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMsgStatus(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[10]));
		if(args[11] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
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

	private final static String __SQLText = "SELECT a.flag,a.contract_id,a.contract_code,a.contract_name,a.customer_name,a.start_date,a.end_date,a.status,a.project_code,a.contract_type, a.project_level,a.total_project_time,a.signing_money_sum,a.design_areas,a.contract_price,a.project_address,a.contract_follower,a.remark, a.contract_date,a.signing_company_name,a.create_time,a.update_time,a.business_type,a.flow_status,a.serial_number,a.project_type, a.covered_area,a.professional_cooperation,a.province,a.city,a.detail_address,a.customer_address,a.service_suggest_book,a.project_approval_time, a.order_no,a.parent_id,a.info_code,a.contract_status,a.client_contract_id,a.is_finish,a.is_system_add,a.operator,a.attachment_remark,a.financial_contract_code,a.contract_area,a.customer_id,a.contract_info_audited,a.contract_signing_status,a.sending_date,a.department_id, a.relevant_employees,a.relevant_employees_name,CASE WHEN cm.msg_count ISNULL  THEN 0 ELSE cm.msg_count  END as msg_count,CASE WHEN cm.msg_status ISNULL THEN	0 ELSE cm.msg_status END as msg_status	 FROM ( SELECT DISTINCT CASE WHEN ct.signing_money_sum = C.sheet_amount THEN 1 ELSE 2 END AS FLAG, ct.* FROM contracts ct LEFT JOIN ( SELECT contract_id, SUM ( sheet_amount ) AS sheet_amount FROM projects GROUP BY contract_id ) AS C ON ct.contract_id = C.contract_id LEFT JOIN projects pj ON pj.contract_id = ct.contract_id WHERE pj.project_name LIKE ? AND pj.contract_code LIKE ? AND pj.project_id = ? AND ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND ct.flow_status = ? AND ct.signing_money_sum = ? AND ct.contract_price = ? AND ct.status = ? AND ct.is_finish = ? AND ct.is_system_add = ? AND ct.info_code LIKE ? AND ct.customer_name LIKE ? AND ct.project_code LIKE ? AND pj.plate_id = ? AND pj.project_manage_id = ? AND ct.contract_status = ? AND ct.contract_signing_status = ? ) A left join (	select * from  contract_messages cm where cm.create_time in (select max(b.create_time) from contract_messages b where b.msg_status = 1 GROUP BY b.contract_id )) as cm ON A.contract_id = cm.contract_id WHERE A.FLAG = ?" ;
	private final static String RESULTSETFIELDLIST = "flag,contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,parent_id,info_code,contract_status,client_contract_id,is_finish,is_system_add,operator,attachment_remark,financial_contract_code,contract_area,customer_id,contract_info_audited,contract_signing_status,sending_date,department_id,relevant_employees,relevant_employees_name,msg_count,msg_status";
	private final static String[] fieldNames = { "project_name", "sub_contract_code", "project_id", "contract_id", "contract_code", "contract_name", "flow_status", "signing_money_sum", "contract_price", "status", "is_finish", "is_system_add", "info_code", "customer_name", "project_code", "plate_id", "project_manage_id", "contract_status", "contract_signing_status", "flag"};
}
