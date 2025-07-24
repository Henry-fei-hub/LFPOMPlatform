package pomplatform.minvocieapplydedaocor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.minvocieapplydedaocor.bean.BaseMcontracticcccsprfiiibaadicrbbior;
import pomplatform.minvocieapplydedaocor.bean.ConditionMcontracticcccsprfiiibaadicrbbior;

public class QueryMcontracticcccsprfiiibaadicrbbior extends AbstractQuery<BaseMcontracticcccsprfiiibaadicrbbior, ConditionMcontracticcccsprfiiibaadicrbbior>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontracticcccsprfiiibaadicrbbior.class);

	public QueryMcontracticcccsprfiiibaadicrbbior() throws java.sql.SQLException 
	{
		setParameterNumber(21);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	c.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontracticcccsprfiiibaadicrbbior> executeQuery( KeyValuePair[] replacements, ConditionMcontracticcccsprfiiibaadicrbbior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getCustomerName(), 
				condition.getStatus(), 
				condition.getProjectCode(), 
				condition.getRemark(), 
				condition.getFlowStatus(), 
				condition.getInfoCode(), 
				condition.getIsSystemAdd(), 
				condition.getIsFinish(), 
				condition.getBusinessType(), 
				condition.getApplyRemark(), 
				condition.getApplicantId(), 
				condition.getDutyParagraph(), 
				condition.getIaCustomerName(), 
				condition.getCustomerPhone(), 
				condition.getRegisteredAddress(), 
				condition.getBankName(), 
				condition.getBankAccount(), 
				condition.getInvoiceApplyStatus()
			);
	}

	@Override
	public BaseMcontracticcccsprfiiibaadicrbbior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontracticcccsprfiiibaadicrbbior __base = new BaseMcontracticcccsprfiiibaadicrbbior();
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[9]));
		if(args[10] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
		if(args[19] != null) __statement.setString(count++, GenericBase.__getString(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
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

	private final static String __SQLText = "SELECT DISTINCT c.contract_id, c.contract_code, c.contract_name, c.customer_name, c.start_date, c.end_date, c.status, c.project_code, c.contract_type, c.project_level, c.total_project_time, c.signing_money_sum, c.design_areas, c.contract_price, c.project_address, c.contract_follower, c.remark, c.contract_date, c.signing_company_name, c.create_time, c.update_time, c.business_type, c.flow_status, c.serial_number, c.project_type, c.covered_area, c.professional_cooperation, c.province, c.city, c.detail_address, c.customer_address, c.service_suggest_book, c.project_approval_time, c.order_no, c.parent_id, c.info_code, c.contract_status, c.client_contract_id, c.is_finish, c.is_system_add, c.operator, c.attachment_remark FROM contracts c LEFT JOIN invoice_apply ia ON ia.contract_id = c.contract_id WHERE c.contract_id = ? AND c.contract_code LIKE ? AND c.contract_name LIKE ? AND c.customer_name LIKE ? AND c.status = ? AND c.project_code LIKE ? AND c.remark LIKE ? AND c.flow_status = ? AND c.info_code LIKE ? AND c.is_system_add = ? AND c.is_finish = ? AND c.business_type = ? AND ia.apply_remark LIKE ? AND ia.applicant_id = ? AND ia.duty_paragraph LIKE ? AND ia.customer_name LIKE ? AND ia.customer_phone LIKE ? AND ia.registered_address LIKE ? AND ia.bank_name LIKE ? AND ia.bank_account LIKE ? AND ia.invoice_apply_status =?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,parent_id,info_code,contract_status,client_contract_id,is_finish,is_system_add,operator,attachment_remark";
	private final static String[] fieldNames = { "contract_id", "contract_code", "contract_name", "customer_name", "status", "project_code", "remark", "flow_status", "info_code", "is_system_add", "is_finish", "business_type", "apply_remark", "applicant_id", "duty_paragraph", "ia_customer_name", "customer_phone", "registered_address", "bank_name", "bank_account", "invoice_apply_status"};
}
