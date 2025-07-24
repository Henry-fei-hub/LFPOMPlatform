package pomplatform.attachment.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseMcontractcacccccaaaraabbifiior;
import pomplatform.attachment.bean.ConditionMcontractcacccccaaaraabbifiior;

public class QueryMcontractcacccccaaaraabbifiior extends AbstractQuery<BaseMcontractcacccccaaaraabbifiior, ConditionMcontractcacccccaaaraabbifiior>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractcacccccaaaraabbifiior.class);

	public QueryMcontractcacccccaaaraabbifiior() throws java.sql.SQLException 
	{
		setParameterNumber(24);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT ct.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontractcacccccaaaraabbifiior> executeQuery( KeyValuePair[] replacements, ConditionMcontractcacccccaaaraabbifiior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinHappenDate(),
				condition.getMaxHappenDate(),
				condition.getMinHappenDate(),
				condition.getMaxHappenDate(),
				condition.getMinHappenDate(),
				condition.getMaxHappenDate(),
				condition.getContractInfoAudited(),
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
	public BaseMcontractcacccccaaaraabbifiior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractcacccccaaaraabbifiior __base = new BaseMcontractcacccccaaaraabbifiior();
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
		if((val = __data[count++]) != null) __base.setContractFollower(GenericBase.__getString(val));
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
		if((val = __data[count++]) != null) __base.setContractInfoAudited(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCheckAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[15]));
		if(args[16] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[18]));
		if(args[19] != null) __statement.setString(count++, GenericBase.__getString(args[19]));
		if(args[20] != null) __statement.setString(count++, GenericBase.__getString(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[22]));
		if(args[23] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[23]));
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

	private final static String __SQLText = "SELECT DISTINCT ct.contract_id, ct.contract_code, ct.contract_name, ct.customer_name, ct.start_date, ct.end_date, ct.status, ct.project_code, ct.contract_type, ct.project_level, ct.total_project_time, ct.signing_money_sum, ct.design_areas, ct.contract_price, ct.project_address, ct.contract_follower, ct.remark, ct.contract_date, ct.signing_company_name, ct.create_time, ct.update_time, ct.business_type, ct.flow_status, ct.serial_number, ct.project_type, ct.covered_area, ct.professional_cooperation, ct.province, ct.city, ct.detail_address, ct.customer_address, ct.service_suggest_book, ct.project_approval_time, ct.order_no, ct.parent_id, ct.info_code, ct.contract_status, ct.client_contract_id, ct.is_finish, ct.is_system_add, ct.operator, ct.attachment_remark, ct.contract_info_audited, cp.borrow_money, amm.count,aa.amount as invoice_amount, bb.amount as project_amount, am1.amount AS check_amount, cpbm.borrow_money as current_borrow_money, inac.amount as current_amount,cpc.capital_date, pjc.settlement_date, iv.invoice_date FROM contracts ct LEFT JOIN (SELECT iv.contract_id, MAX(invoice_date) as invoice_date FROM invoices iv GROUP BY iv.contract_id) iv ON iv.contract_id = ct.contract_id LEFT JOIN (SELECT cp.contract_id, MAX(happen_date) AS capital_date FROM capitals cp GROUP BY cp.contract_id) cpc ON cpc.contract_id = ct.contract_id LEFT JOIN (SELECT ct.contract_id, MAX(ps.settlement_date) as settlement_date FROM project_settlements ps, contracts ct, projects pj WHERE pj.contract_id = ct.contract_id AND ps.project_id = pj.project_id GROUP BY ct.contract_id ) pjc ON pjc.contract_id = ct.contract_id LEFT JOIN ( SELECT COALESCE(SUM (borrow_money), 0) AS borrow_money, contract_id FROM capitals WHERE contract_id > 0 and record_receive_capital = true GROUP BY contract_id )cp ON cp.contract_id = ct.contract_id LEFT JOIN attachment_manages am ON am.contract_id = ct.contract_id LEFT JOIN (SELECT aa.contract_id, (aa.amount - COALESCE(bb.amount, 0)) as amount FROM (SELECT SUM(invoice_amount) as amount,contract_id FROM invoices WHERE sign != 4 GROUP BY contract_id) aa LEFT JOIN(SELECT SUM(invoice_amount) as amount,contract_id FROM invoices WHERE sign = 3 GROUP BY contract_id) bb ON aa.contract_id = bb.contract_id) aa ON aa.contract_id = ct.contract_id LEFT JOIN (SELECT aa.contract_id,SUM (aa.total_revenue) AS amount FROM(SELECT pj.contract_id, rsr.total_revenue FROM projects pj LEFT JOIN revenue_statistical_records rsr ON rsr.project_id = pj.project_id AND rsr.year = EXTRACT(YEAR from now()) AND rsr.month = EXTRACT(MONTH from now()) WHERE pj.contract_id > 0 AND pj.project_id IN (SELECT project_id FROM revenue_statistical_records ) ) aa GROUP BY aa.contract_id) bb ON bb.contract_id = ct.contract_id LEFT JOIN (SELECT contract_id, COALESCE(SUM(return_amount), 0) AS amount FROM attachment_manages GROUP BY contract_id) am1 ON am1.contract_id = ct.contract_id LEFT JOIN (SELECT COUNT (1) as count, amm.contract_id FROM attachment_manages amm WHERE amm.delete_flag = 0 GROUP BY amm.contract_id) amm ON ct.contract_id = amm.contract_id LEFT JOIN (SELECT SUM (borrow_money) AS borrow_money,contract_id FROM capitals WHERE contract_id > 0 AND happen_date >= ? AND happen_date < ? GROUP BY contract_id) cpbm ON cpbm.contract_id = ct.contract_id LEFT JOIN (SELECT aa.contract_id, ( aa.amount - COALESCE (bb.amount, 0) ) AS amount FROM ( SELECT SUM (invoice_amount) AS amount, contract_id FROM invoices WHERE sign != 4 AND invoice_date >= ? AND invoice_date < ? GROUP BY contract_id ) aa LEFT JOIN ( SELECT SUM (invoice_amount) AS amount, contract_id FROM invoices WHERE sign = 3 AND invoice_date >= ? AND invoice_date < ? GROUP BY contract_id) bb ON aa.contract_id = bb.contract_id) inac ON inac.contract_id = ct.contract_id WHERE ct.contract_info_audited = ? AND ct.contract_id = ? AND ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND ct.contract_status = ? AND ct.contract_type = ? AND am.attachment_address LIKE ? AND am.attachment_code LIKE ? AND am.attachment_manage_id =? AND am.return_amount = ? AND am.amount =? AND am.attachment_name LIKE ? AND cp.borrow_money = ? AND ct.business_type =? AND ct.info_code LIKE ? AND ct.flow_status =? AND ct.is_finish =? AND ct.is_system_add =? AND ct.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace0)) AND replace1 AND replace2" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,parent_id,info_code,contract_status,client_contract_id,is_finish,is_system_add,operator,attachment_remark,contract_info_audited,borrow_money,count,invoice_amount,project_amount,check_amount,current_borrow_money,current_amount,capital_date,settlement_date,invoice_date";
	private final static String[] fieldNames = { "min_happen_date", "max_happen_date", "min_happen_date", "max_happen_date", "min_happen_date", "max_happen_date", "contract_info_audited", "contract_id", "contract_code", "contract_name", "contract_status", "contract_type", "attachment_address", "attachment_code", "attachment_manage_id", "return_amount", "amount", "attachment_name", "borrow_money", "business_type", "info_code", "flow_status", "is_finish", "is_system_add"};
}
