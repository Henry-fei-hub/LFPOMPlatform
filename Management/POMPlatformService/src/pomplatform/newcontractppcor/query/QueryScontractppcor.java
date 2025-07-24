package pomplatform.newcontractppcor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.newcontractppcor.bean.BaseScontractppcor;
import pomplatform.newcontractppcor.bean.ConditionScontractppcor;

public class QueryScontractppcor extends AbstractQuery<BaseScontractppcor, ConditionScontractppcor>
{

	private static final Logger __logger = Logger.getLogger(QueryScontractppcor.class);

	public QueryScontractppcor() throws java.sql.SQLException 
	{
		setParameterNumber(27);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.* FROM ( SELECT DISTINCT C .contract_id");
	}

	@Override
	public BaseCollection<BaseScontractppcor> executeQuery( KeyValuePair[] replacements, ConditionScontractppcor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectSecretaryId(), 
				condition.getProjectManagerId(), 
				condition.getProjectLeaderId(), 
				condition.getProjectLevel(), 
				condition.getProjectType(), 
				condition.getContractStatus(), 
				condition.getProjectLevel(), 
				condition.getContractStatus(), 
				condition.getClientContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getCustomerId(), 
				condition.getProjectCode(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getProjectManageId(), 
				condition.getContractSigningStatus(), 
				condition.getPreProjectType(), 
				condition.getContractType(), 
				condition.getProjectApprovalTimeStartDate(), 
				condition.getProjectApprovalTimeEndDate(), 
				condition.getGroupId(), 
				condition.getSignCompany(), 
				condition.getDesignTeam(), 
				condition.getMainProjectStageId(), 
				condition.getFlag()
			);
	}

	public BaseCollection<BaseScontractppcor> runQuery( KeyValuePair[] replacements, ConditionScontractppcor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectSecretaryId(), 
				condition.getProjectManagerId(), 
				condition.getProjectLeaderId(), 
				condition.getProjectLevel(), 
				condition.getProjectType(), 
				condition.getContractStatus(), 
				condition.getProjectLevel(), 
				condition.getContractStatus(), 
				condition.getClientContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getCustomerId(), 
				condition.getProjectCode(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getProjectManageId(), 
				condition.getContractSigningStatus(), 
				condition.getPreProjectType(), 
				condition.getContractType(), 
				condition.getProjectApprovalTimeStartDate(), 
				condition.getProjectApprovalTimeEndDate(), 
				condition.getGroupId(), 
				condition.getSignCompany(), 
				condition.getDesignTeam(), 
				condition.getMainProjectStageId(), 
				condition.getFlag()
			);
	}

	public BaseCollection<BaseScontractppcor> execute( KeyValuePair[] replacements, ConditionScontractppcor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectSecretaryId(), 
				condition.getProjectManagerId(), 
				condition.getProjectLeaderId(), 
				condition.getProjectLevel(), 
				condition.getProjectType(), 
				condition.getContractStatus(), 
				condition.getProjectLevel(), 
				condition.getContractStatus(), 
				condition.getClientContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getCustomerId(), 
				condition.getProjectCode(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getProjectManageId(), 
				condition.getContractSigningStatus(), 
				condition.getPreProjectType(), 
				condition.getContractType(), 
				condition.getProjectApprovalTimeStartDate(), 
				condition.getProjectApprovalTimeEndDate(), 
				condition.getGroupId(), 
				condition.getSignCompany(), 
				condition.getDesignTeam(), 
				condition.getMainProjectStageId(), 
				condition.getFlag()
			);
	}

	@Override
	public BaseScontractppcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScontractppcor __base = new BaseScontractppcor();
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
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractSigningStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployeesName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoBorrowMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGroupName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSecretary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPayableButNotPaid(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
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

	private final static String __SQLText = "SELECT aa.* FROM ( SELECT DISTINCT C .contract_id, C.contract_code, C.contract_name, C.customer_name, C.start_date, C.end_date, C.status, C.project_code, C.contract_type, C.project_level, C.total_project_time, C.signing_money_sum, C.design_areas, C.contract_price, C.project_address, C.contract_follower, C.remark, C.contract_date, C.signing_company_name, C.create_time, C.update_time, C.business_type, C.flow_status, C.serial_number, C.project_type, C.covered_area, C.professional_cooperation, C.province, C.city, C.detail_address, pp.customer_address, fm.file_url AS service_suggest_book, C.project_approval_time, C.order_no, C.parent_id, C.info_code, C.contract_status, C.client_contract_id, C.OPERATOR, CASE WHEN C.signing_money_sum = P.sheet_amount THEN 1 ELSE 2 END AS FLAG, C.contract_signing_status, C.sending_date, C.department_id, C.relevant_employees, C.relevant_employees_name, C.customer_id, d.borrow_money_sum, d.percent, d.signing_money_sum - d.borrow_money_sum AS no_borrow_money_sum, 1 - d.percent AS no_percent, CASE WHEN E.percent_sum ISNULL THEN 0 ELSE E.percent_sum END AS percent_sum, cte.customer_id AS group_name, mp.sign_company AS sign_company, pp.project_type AS pre_project_type, mp.main_project_stage_id AS main_project_type, io.have_invoice_amount AS have_invoice_amount, 0 AS un_invoice_amount, mp.design_team, remp.project_secretary, remp.project_manager, remp.project_leader, mp.project_approval_time AS main_project_approval_time, CASE WHEN E.percent_sum IS NULL THEN 0 ELSE C.signing_money_sum * E.percent_sum * 0.01 - d.borrow_money_sum END AS payable_but_not_paid FROM contracts C LEFT JOIN ( SELECT contract_id, SUM ( sheet_amount ) AS sheet_amount FROM projects GROUP BY contract_id ) AS P ON C.contract_id = P.contract_id LEFT JOIN file_manages fm ON C.service_suggest_book_id = fm.file_id LEFT JOIN projects pj ON pj.contract_id = C.contract_id LEFT JOIN ( SELECT B.contract_id, CASE WHEN A.borrow_money_sum ISNULL THEN 0 ELSE A.borrow_money_sum END AS borrow_money_sum, CASE WHEN b.signing_money_sum ISNULL THEN 0 ELSE b.signing_money_sum END AS signing_money_sum, CASE WHEN b.signing_money_sum > 0 AND A.borrow_money_sum > 0 THEN round( A.borrow_money_sum / b.signing_money_sum, 4 ) WHEN ( b.signing_money_sum <= 0 OR b.signing_money_sum ISNULL ) AND A.borrow_money_sum > 0 THEN 1 ELSE 0 END AS percent FROM contracts AS B LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN borrow_money ISNULL THEN 0 ELSE borrow_money END ) AS borrow_money_sum FROM capitals WHERE contract_id > 0 AND borrow_money NOTNULL GROUP BY contract_id ORDER BY contract_id ) AS A ON A.contract_id = b.contract_id ) AS D ON D.contract_id = C.contract_id LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 GROUP BY contract_id ) AS E ON E.contract_id = C.contract_id LEFT JOIN customers ct ON ct.customer_id = C.customer_id LEFT JOIN customers cte ON cte.customer_id = ct.parent_id LEFT JOIN main_projects mp ON mp.project_code = C.project_code LEFT JOIN pre_projects pp ON pp.info_code = mp.info_code LEFT JOIN ( SELECT contract_id, SUM ( invoice_amount ) AS have_invoice_amount FROM invoices WHERE contract_id IS NOT NULL AND sign IN ( 1, 2 ) GROUP BY contract_id ) AS io ON io.contract_id = C.contract_id LEFT JOIN ( SELECT mpem.main_project_id, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpem.relation = 1 THEN mpee.employee_name END )) ), '，' ) AS project_secretary, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpem.relation = 5 THEN mpee.employee_name END )) ), '，' ) AS project_manager, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpem.relation = 4 THEN mpee.employee_name END )) ), '，' ) AS project_leader FROM main_projects mpep LEFT JOIN main_project_employees mpem ON mpep.main_project_id = mpem.main_project_id LEFT JOIN employees mpee ON mpem.employee_id = mpee.employee_id WHERE mpem.main_project_id IS NOT NULL AND ( mpee.department_id IN ( SELECT child_id FROM department_ids WHERE 1 = 1 )) GROUP BY mpem.main_project_id ) remp ON remp.main_project_id = mp.main_project_id WHERE remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id = ? ), '%' ) and remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id = ? ), '%' ) and remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id = ? ), '%' ) and C.project_level = ? and C.project_type = ? and C.contract_status = ? and C.project_level = ? and C.contract_status = ? and C.client_contract_id like ? and C.contract_code like ? and C.contract_name like ? and C.customer_id = ? and C.project_code like ? and C.contract_date between ? and ? and pj.plate_id = ? and pj.project_manage_id = ? and C.contract_signing_status = ? and pp.project_type = ? and C.contract_type = ? and mp.project_approval_time between ? and ? and cte.customer_id = ? and mp.sign_company = ? and mp.design_team = ? and mp.main_project_stage_id = ? ) AS AA WHERE AA.FLAG = ?" ;
	private final static String __originalSQL = "SELECT aa.* FROM ( SELECT DISTINCT C .contract_id, C.contract_code, C.contract_name, C.customer_name, C.start_date, C.end_date, C.status, C.project_code, C.contract_type, C.project_level, C.total_project_time, C.signing_money_sum, C.design_areas, C.contract_price, C.project_address, C.contract_follower, C.remark, C.contract_date, C.signing_company_name, C.create_time, C.update_time, C.business_type, C.flow_status, C.serial_number, C.project_type, C.covered_area, C.professional_cooperation, C.province, C.city, C.detail_address, pp.customer_address, fm.file_url AS service_suggest_book, C.project_approval_time, C.order_no, C.parent_id, C.info_code, C.contract_status, C.client_contract_id, C.OPERATOR, CASE WHEN C.signing_money_sum = P.sheet_amount THEN 1 ELSE 2 END AS FLAG, C.contract_signing_status, C.sending_date, C.department_id, C.relevant_employees, C.relevant_employees_name, C.customer_id, d.borrow_money_sum, d.percent, d.signing_money_sum - d.borrow_money_sum AS no_borrow_money_sum, 1 - d.percent AS no_percent, CASE WHEN E.percent_sum ISNULL THEN 0 ELSE E.percent_sum END AS percent_sum, cte.customer_id AS group_name, mp.sign_company AS sign_company, pp.project_type AS pre_project_type, mp.main_project_stage_id AS main_project_type, io.have_invoice_amount AS have_invoice_amount, 0 AS un_invoice_amount, mp.design_team, remp.project_secretary, remp.project_manager, remp.project_leader, mp.project_approval_time AS main_project_approval_time, CASE WHEN E.percent_sum IS NULL THEN 0 ELSE C.signing_money_sum * E.percent_sum * 0.01 - d.borrow_money_sum END AS payable_but_not_paid FROM contracts C LEFT JOIN ( SELECT contract_id, SUM ( sheet_amount ) AS sheet_amount FROM projects GROUP BY contract_id ) AS P ON C.contract_id = P.contract_id LEFT JOIN file_manages fm ON C.service_suggest_book_id = fm.file_id LEFT JOIN projects pj ON pj.contract_id = C.contract_id LEFT JOIN ( SELECT B.contract_id, CASE WHEN A.borrow_money_sum ISNULL THEN 0 ELSE A.borrow_money_sum END AS borrow_money_sum, CASE WHEN b.signing_money_sum ISNULL THEN 0 ELSE b.signing_money_sum END AS signing_money_sum, CASE WHEN b.signing_money_sum > 0 AND A.borrow_money_sum > 0 THEN round( A.borrow_money_sum / b.signing_money_sum, 4 ) WHEN ( b.signing_money_sum <= 0 OR b.signing_money_sum ISNULL ) AND A.borrow_money_sum > 0 THEN 1 ELSE 0 END AS percent FROM contracts AS B LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN borrow_money ISNULL THEN 0 ELSE borrow_money END ) AS borrow_money_sum FROM capitals WHERE contract_id > 0 AND borrow_money NOTNULL GROUP BY contract_id ORDER BY contract_id ) AS A ON A.contract_id = b.contract_id ) AS D ON D.contract_id = C.contract_id LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 GROUP BY contract_id ) AS E ON E.contract_id = C.contract_id LEFT JOIN customers ct ON ct.customer_id = C.customer_id LEFT JOIN customers cte ON cte.customer_id = ct.parent_id LEFT JOIN main_projects mp ON mp.project_code = C.project_code LEFT JOIN pre_projects pp ON pp.info_code = mp.info_code LEFT JOIN ( SELECT contract_id, SUM ( invoice_amount ) AS have_invoice_amount FROM invoices WHERE contract_id IS NOT NULL AND sign IN ( 1, 2 ) GROUP BY contract_id ) AS io ON io.contract_id = C.contract_id LEFT JOIN ( SELECT mpem.main_project_id, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpem.relation = 1 THEN mpee.employee_name END )) ), '，' ) AS project_secretary, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpem.relation = 5 THEN mpee.employee_name END )) ), '，' ) AS project_manager, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpem.relation = 4 THEN mpee.employee_name END )) ), '，' ) AS project_leader FROM main_projects mpep LEFT JOIN main_project_employees mpem ON mpep.main_project_id = mpem.main_project_id LEFT JOIN employees mpee ON mpem.employee_id = mpee.employee_id WHERE mpem.main_project_id IS NOT NULL AND ( mpee.department_id IN ( SELECT child_id FROM department_ids WHERE 1 = 1 )) GROUP BY mpem.main_project_id ) remp ON remp.main_project_id = mp.main_project_id WHERE remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_secretary_id ), '%' ) AND remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_manager_id ), '%' ) AND remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_leader_id ), '%' ) AND C.project_level =:project_level AND C.project_type =:project_type AND C.contract_status =:contract_status AND C.project_level =:project_level AND C.contract_status =:contract_status AND C.client_contract_id LIKE :client_contract_id AND C.contract_code LIKE :contract_code AND C.contract_name LIKE :contract_name AND C.customer_id =:customer_id AND C.project_code LIKE :project_code AND C.contract_date BETWEEN :start_date AND :end_date AND pj.plate_id =:plate_id AND pj.project_manage_id =:project_manage_id AND C.contract_signing_status =:contract_signing_status AND pp.project_type =:pre_project_type AND C.contract_type =:contract_type AND mp.project_approval_time BETWEEN :project_approval_time_start_date AND :project_approval_time_end_date AND cte.customer_id =:group_id AND mp.sign_company =:sign_company AND mp.design_team =:design_team AND mp.main_project_stage_id =:main_project_stage_id ) AS AA WHERE AA.FLAG = :FLAG";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_secretary_id ), '%' ) AND remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_manager_id ), '%' ) AND remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_leader_id ), '%' ) AND C.project_level =:project_level AND C.project_type =:project_type AND C.contract_status =:contract_status AND C.project_level =:project_level AND C.contract_status =:contract_status AND C.client_contract_id LIKE :client_contract_id AND C.contract_code LIKE :contract_code AND C.contract_name LIKE :contract_name AND C.customer_id =:customer_id AND C.project_code LIKE :project_code AND C.contract_date BETWEEN :start_date AND :end_date AND pj.plate_id =:plate_id AND pj.project_manage_id =:project_manage_id AND C.contract_signing_status =:contract_signing_status AND pp.project_type =:pre_project_type AND C.contract_type =:contract_type AND mp.project_approval_time BETWEEN :project_approval_time_start_date AND :project_approval_time_end_date AND cte.customer_id =:group_id AND mp.sign_company =:sign_company AND mp.design_team =:design_team AND mp.main_project_stage_id =:main_project_stage_id\",\"startIndex\": 4183,\"stopIndex\":5471,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_secretary_id ), '%' )\",\"nextToken\":\"and\",\"startIndex\": 4183,\"stopIndex\":4311,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"employee_id =:project_secretary_id\",\"startIndex\": 4269,\"stopIndex\":4302,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"employee_id =:project_secretary_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"projectSecretaryId\",\"startIndex\": 4269,\"stopIndex\":4302,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_manager_id ), '%' )\",\"nextToken\":\"and\",\"startIndex\": 4317,\"stopIndex\":4441,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"employee_id =:project_manager_id\",\"startIndex\": 4401,\"stopIndex\":4432,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"employee_id =:project_manager_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"projectManagerId\",\"startIndex\": 4401,\"stopIndex\":4432,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_leader_id ), '%' )\",\"nextToken\":\"and\",\"startIndex\": 4447,\"stopIndex\":4569,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"employee_id =:project_leader_id\",\"startIndex\": 4530,\"stopIndex\":4560,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"employee_id =:project_leader_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"projectLeaderId\",\"startIndex\": 4530,\"stopIndex\":4560,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"C.project_level =:project_level\",\"fullFieldName\":\"C.project_level\",\"operationName\":\"=\",\"variableName\":\"projectLevel\",\"nextToken\":\"and\",\"startIndex\": 4575,\"stopIndex\":4605,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.project_type =:project_type\",\"fullFieldName\":\"C.project_type\",\"operationName\":\"=\",\"variableName\":\"projectType\",\"nextToken\":\"and\",\"startIndex\": 4611,\"stopIndex\":4639,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_status =:contract_status\",\"fullFieldName\":\"C.contract_status\",\"operationName\":\"=\",\"variableName\":\"contractStatus\",\"nextToken\":\"and\",\"startIndex\": 4645,\"stopIndex\":4679,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.project_level =:project_level\",\"fullFieldName\":\"C.project_level\",\"operationName\":\"=\",\"variableName\":\"projectLevel\",\"nextToken\":\"and\",\"startIndex\": 4685,\"stopIndex\":4715,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_status =:contract_status\",\"fullFieldName\":\"C.contract_status\",\"operationName\":\"=\",\"variableName\":\"contractStatus\",\"nextToken\":\"and\",\"startIndex\": 4721,\"stopIndex\":4755,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.client_contract_id LIKE :client_contract_id\",\"fullFieldName\":\"C.client_contract_id\",\"operationName\":\"like\",\"variableName\":\"clientContractId\",\"nextToken\":\"and\",\"startIndex\": 4761,\"stopIndex\":4805,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_code LIKE :contract_code\",\"fullFieldName\":\"C.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 4811,\"stopIndex\":4845,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_name LIKE :contract_name\",\"fullFieldName\":\"C.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"nextToken\":\"and\",\"startIndex\": 4851,\"stopIndex\":4885,\"variableNum\": 10,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.customer_id =:customer_id\",\"fullFieldName\":\"C.customer_id\",\"operationName\":\"=\",\"variableName\":\"customerId\",\"nextToken\":\"and\",\"startIndex\": 4891,\"stopIndex\":4917,\"variableNum\": 11,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.project_code LIKE :project_code\",\"fullFieldName\":\"C.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 4923,\"stopIndex\":4955,\"variableNum\": 12,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_date BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"C.contract_date\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"nextToken\":\"and\",\"startIndex\": 4961,\"stopIndex\":5009,\"variableNum\": 13,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pj.plate_id =:plate_id\",\"fullFieldName\":\"pj.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 5015,\"stopIndex\":5036,\"variableNum\": 15,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pj.project_manage_id =:project_manage_id\",\"fullFieldName\":\"pj.project_manage_id\",\"operationName\":\"=\",\"variableName\":\"projectManageId\",\"nextToken\":\"and\",\"startIndex\": 5042,\"stopIndex\":5081,\"variableNum\": 16,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_signing_status =:contract_signing_status\",\"fullFieldName\":\"C.contract_signing_status\",\"operationName\":\"=\",\"variableName\":\"contractSigningStatus\",\"nextToken\":\"and\",\"startIndex\": 5087,\"stopIndex\":5137,\"variableNum\": 17,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pp.project_type =:pre_project_type\",\"fullFieldName\":\"pp.project_type\",\"operationName\":\"=\",\"variableName\":\"preProjectType\",\"nextToken\":\"and\",\"startIndex\": 5143,\"stopIndex\":5176,\"variableNum\": 18,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_type =:contract_type\",\"fullFieldName\":\"C.contract_type\",\"operationName\":\"=\",\"variableName\":\"contractType\",\"nextToken\":\"and\",\"startIndex\": 5182,\"stopIndex\":5212,\"variableNum\": 19,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_approval_time BETWEEN :project_approval_time_start_date AND :project_approval_time_end_date\",\"fullFieldName\":\"mp.project_approval_time\",\"operationName\":\"between\",\"variableName\":\"projectApprovalTimeStartDate\",\"secondName\":\"projectApprovalTimeEndDate\",\"nextToken\":\"and\",\"startIndex\": 5218,\"stopIndex\":5319,\"variableNum\": 20,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cte.customer_id =:group_id\",\"fullFieldName\":\"cte.customer_id\",\"operationName\":\"=\",\"variableName\":\"groupId\",\"nextToken\":\"and\",\"startIndex\": 5325,\"stopIndex\":5350,\"variableNum\": 22,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.sign_company =:sign_company\",\"fullFieldName\":\"mp.sign_company\",\"operationName\":\"=\",\"variableName\":\"signCompany\",\"nextToken\":\"and\",\"startIndex\": 5356,\"stopIndex\":5385,\"variableNum\": 23,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.design_team =:design_team\",\"fullFieldName\":\"mp.design_team\",\"operationName\":\"=\",\"variableName\":\"designTeam\",\"nextToken\":\"and\",\"startIndex\": 5391,\"stopIndex\":5418,\"variableNum\": 24,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.main_project_stage_id =:main_project_stage_id\",\"fullFieldName\":\"mp.main_project_stage_id\",\"operationName\":\"=\",\"variableName\":\"mainProjectStageId\",\"startIndex\": 5424,\"stopIndex\":5471,\"variableNum\": 25,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"AA.FLAG = :FLAG\",\"startIndex\": 5487,\"stopIndex\":5501,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"AA.FLAG = :FLAG\",\"fullFieldName\":\"AA.FLAG\",\"operationName\":\"=\",\"variableName\":\"flag\",\"startIndex\": 5487,\"stopIndex\":5501,\"variableNum\": 26,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,create_time,update_time,business_type,flow_status,serial_number,project_type,covered_area,professional_cooperation,province,city,detail_address,customer_address,service_suggest_book,project_approval_time,order_no,parent_id,info_code,contract_status,client_contract_id,operator,flag,contract_signing_status,sending_date,department_id,relevant_employees,relevant_employees_name,customer_id,borrow_money_sum,percent,no_borrow_money_sum,no_percent,percent_sum,group_name,sign_company,pre_project_type,main_project_type,have_invoice_amount,un_invoice_amount,design_team,project_secretary,project_manager,project_leader,main_project_approval_time,payable_but_not_paid";
	private final static String[] fieldNames = { "project_secretary_id", "project_manager_id", "project_leader_id", "project_level", "project_type", "contract_status", "project_level", "contract_status", "client_contract_id", "contract_code", "contract_name", "customer_id", "project_code", "start_date", "end_date", "plate_id", "project_manage_id", "contract_signing_status", "pre_project_type", "contract_type", "project_approval_time_start_date", "project_approval_time_end_date", "group_id", "sign_company", "design_team", "main_project_stage_id", "flag"};
}
