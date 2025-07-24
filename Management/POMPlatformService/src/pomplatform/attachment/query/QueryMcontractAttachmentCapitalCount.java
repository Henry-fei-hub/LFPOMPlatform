package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseMcontractAttachmentCapitalCount;
import pomplatform.attachment.bean.ConditionMcontractAttachmentCapitalCount;

public class QueryMcontractAttachmentCapitalCount extends AbstractQuery<BaseMcontractAttachmentCapitalCount, ConditionMcontractAttachmentCapitalCount>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractAttachmentCapitalCount.class);

	public QueryMcontractAttachmentCapitalCount() throws java.sql.SQLException 
	{
		setParameterNumber(21);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	ct.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontractAttachmentCapitalCount> executeQuery( KeyValuePair[] replacements, ConditionMcontractAttachmentCapitalCount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate(), 
				condition.getBeforeSettlementDate(), 
				condition.getAfterSettlementDate(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getContractStatus(), 
				condition.getContractType(), 
				condition.getAttachmentAddress(), 
				condition.getAttachmentCode(), 
				condition.getAttachmentManageId(), 
				condition.getReturnAmount(), 
				condition.getAmount(), 
				condition.getAttachmentName(), 
				condition.getBorrowMoney(), 
				condition.getBusinessType(), 
				condition.getInfoCode(), 
				condition.getFlowStatus(), 
				condition.getIsFinish(), 
				condition.getIsSystemAdd()
			);
	}

	@Override
	public BaseMcontractAttachmentCapitalCount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractAttachmentCapitalCount __base = new BaseMcontractAttachmentCapitalCount();
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
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setAttachmentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBeforeAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAfterAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAllBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUncollectedAmount(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[12]));
		if(args[13] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[19]));
		if(args[20] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[20]));
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

	private final static String __SQLText = "SELECT DISTINCT ct.contract_id, ct.contract_code, ct.contract_name, ct.customer_name, ct.start_date, ct.end_date, ct.status, ct.project_code, ct.contract_type, ct.project_level, ct.total_project_time, ct.signing_money_sum, ct.design_areas, ct.contract_price, ct.project_address, ct.contract_follower, ct.remark, ct.contract_date, ct.signing_company_name, ct.create_time, ct.update_time, ct.business_type, ct.flow_status, ct.serial_number, ct.project_type, ct.covered_area, ct.professional_cooperation, ct.province, ct.city, ct.detail_address, ct.customer_address, ct.service_suggest_book, ct.project_approval_time, ct.order_no, ct.parent_id, ct.info_code, ct.contract_status, ct.client_contract_id, ct.is_finish, ct.is_system_add, ct.operator, ct.attachment_remark, cp.borrow_money, ( SELECT COUNT (1) FROM attachment_manages amm WHERE amm.contract_ID = ct.contract_id AND amm.delete_flag = 0 ) AS COUNT, aa.am_amount AS attachment_amount, bb.amount AS before_amount, cc.amount AS after_amount, (COALESCE(bb.amount, 0) - COALESCE(cc.amount, 0)) AS final_amount, dd.borrow_money AS all_borrow_money, (COALESCE(ct.signing_money_sum, 0) - COALESCE(dd.borrow_money, 0)) AS uncollected_amount FROM contracts ct LEFT JOIN ( SELECT SUM (borrow_money) AS borrow_money, contract_id FROM capitals WHERE contract_id > 0 AND happen_date BETWEEN ? AND ? GROUP BY contract_id ) cp ON cp.contract_id = ct.contract_id LEFT JOIN attachment_manages am ON am.contract_id = ct.contract_id LEFT JOIN ( SELECT contract_id,SUM(amount - return_amount) AS am_amount FROM attachment_manages GROUP BY contract_id ) aa ON aa.contract_id = ct.contract_id LEFT JOIN ( SELECT aa.contract_id, SUM (aa.amount) AS amount FROM ( SELECT aa.project_id, aa.contract_id, CASE WHEN aa.project_integral > 0 THEN round( ( SELECT SUM (total_amount) FROM project_settlements WHERE project_id = aa.project_id AND settlement_date <= ? ) / aa.project_integral, 4 ) * aa.sheet_amount ELSE 0 END AS amount FROM projects aa ) aa GROUP BY aa.contract_id ) bb ON bb.contract_id = ct.contract_id LEFT JOIN ( SELECT aa.contract_id, SUM (aa.amount) AS amount FROM ( SELECT aa.project_id, aa.contract_id, CASE WHEN aa.project_integral > 0 THEN round( ( SELECT SUM (total_amount) FROM project_settlements WHERE project_id = aa.project_id AND settlement_date <= ? ) / aa.project_integral, 4 ) * aa.sheet_amount ELSE 0 END AS amount FROM projects aa ) aa GROUP BY aa.contract_id ) cc ON cc.contract_id = ct.contract_id LEFT JOIN ( SELECT SUM (borrow_money) AS borrow_money, contract_id FROM capitals WHERE contract_id > 0 GROUP BY contract_id ) dd ON dd.contract_id = ct.contract_id WHERE ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND ct.contract_status = ? AND ct.contract_type = ? AND am.attachment_address LIKE ? AND am.attachment_code LIKE ? AND am.attachment_manage_id = ? AND am.return_amount = ? AND am.amount = ? AND am.attachment_name LIKE ? AND cp.borrow_money = ? AND ct.business_type = ? AND ct.info_code LIKE ? AND ct.flow_status = ? AND ct.is_finish = ? AND ct.is_system_add =? AND ct.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace))" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,parent_id,info_code,contract_status,client_contract_id,is_finish,is_system_add,operator,attachment_remark,borrow_money,count,attachment_amount,before_amount,after_amount,final_amount,all_borrow_money,uncollected_amount";
	private final static String[] fieldNames = { "min_happen_date", "max_happen_date", "before_settlement_date", "after_settlement_date", "contract_id", "contract_code", "contract_name", "contract_status", "contract_type", "attachment_address", "attachment_code", "attachment_manage_id", "return_amount", "amount", "attachment_name", "borrow_money", "business_type", "info_code", "flow_status", "is_finish", "is_system_add"};
}
