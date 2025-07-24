package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseSearchReimbursementInfo;
import pomplatform.reimbursement.bean.ConditionSearchReimbursementInfo;

public class QuerySearchReimbursementInfo extends AbstractQuery<BaseSearchReimbursementInfo, ConditionSearchReimbursementInfo>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchReimbursementInfo.class);

	public QuerySearchReimbursementInfo() throws java.sql.SQLException 
	{
		setParameterNumber(73);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("business_id");
	}

	public static BaseSearchReimbursementInfo selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseSearchReimbursementInfo> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseSearchReimbursementInfo selectOne(ConditionSearchReimbursementInfo c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseSearchReimbursementInfo> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseSearchReimbursementInfo> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseSearchReimbursementInfo> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseSearchReimbursementInfo> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionSearchReimbursementInfo c = new ConditionSearchReimbursementInfo();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QuerySearchReimbursementInfo dao = new QuerySearchReimbursementInfo();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseSearchReimbursementInfo> select(ConditionSearchReimbursementInfo c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QuerySearchReimbursementInfo dao = new QuerySearchReimbursementInfo();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseSearchReimbursementInfo> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseSearchReimbursementInfo> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseSearchReimbursementInfo> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionSearchReimbursementInfo c = new ConditionSearchReimbursementInfo();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QuerySearchReimbursementInfo dao = new QuerySearchReimbursementInfo();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseSearchReimbursementInfo> executeQuery( KeyValuePair[] replacements, ConditionSearchReimbursementInfo condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getProcessType(), 
				condition.getBearFeeCode(), 
				condition.getBearFeeName(), 
				condition.getCode(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getProcessStatus(), 
				condition.getPackageCode(), 
				condition.getCurrency(), 
				condition.getContractCode(), 
				condition.getRemark(), 
				condition.getBackViewName(), 
				condition.getBdCode(), 
				condition.getSubType(), 
				condition.getSubType()
			);
	}

	public BaseCollection<BaseSearchReimbursementInfo> runQuery( KeyValuePair[] replacements, ConditionSearchReimbursementInfo condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getProcessType(), 
				condition.getBearFeeCode(), 
				condition.getBearFeeName(), 
				condition.getCode(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getProcessStatus(), 
				condition.getPackageCode(), 
				condition.getCurrency(), 
				condition.getContractCode(), 
				condition.getRemark(), 
				condition.getBackViewName(), 
				condition.getBdCode(), 
				condition.getSubType(), 
				condition.getSubType()
			);
	}

	public BaseCollection<BaseSearchReimbursementInfo> execute( KeyValuePair[] replacements, ConditionSearchReimbursementInfo condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getSubType(), 
				condition.getSubType(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getCompanyId(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getStartCreateTime(), 
				condition.getEndCreateTime(), 
				condition.getStartCompleteTime(), 
				condition.getEndCompleteTime(), 
				condition.getProcessType(), 
				condition.getBearFeeCode(), 
				condition.getBearFeeName(), 
				condition.getCode(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getProcessStatus(), 
				condition.getPackageCode(), 
				condition.getCurrency(), 
				condition.getContractCode(), 
				condition.getRemark(), 
				condition.getBackViewName(), 
				condition.getBdCode(), 
				condition.getSubType(), 
				condition.getSubType()
			);
	}

	@Override
	public BaseSearchReimbursementInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchReimbursementInfo __base = new BaseSearchReimbursementInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBearFeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBearFeeCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBearFeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSubTableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPackageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCurrency(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBdCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainItemId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubItemId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOutDay(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
		if(args[24] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[24]));
		if(args[25] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[25]));
		if(args[26] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[26]));
		if(args[27] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[27]));
		if(args[28] != null) __statement.setInt(count++, GenericBase.__getInt(args[28]));
		if(args[29] != null) __statement.setInt(count++, GenericBase.__getInt(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[31]));
		if(args[32] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[32]));
		if(args[33] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[33]));
		if(args[34] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[34]));
		if(args[35] != null) __statement.setInt(count++, GenericBase.__getInt(args[35]));
		if(args[36] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[36]));
		if(args[37] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[37]));
		if(args[38] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[38]));
		if(args[39] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[39]));
		if(args[40] != null) __statement.setInt(count++, GenericBase.__getInt(args[40]));
		if(args[41] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[41]));
		if(args[42] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[42]));
		if(args[43] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[43]));
		if(args[44] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[44]));
		if(args[45] != null) __statement.setInt(count++, GenericBase.__getInt(args[45]));
		if(args[46] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[46]));
		if(args[47] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[47]));
		if(args[48] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[48]));
		if(args[49] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[49]));
		if(args[50] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[50]));
		if(args[51] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[51]));
		if(args[52] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[52]));
		if(args[53] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[53]));
		if(args[54] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[54]));
		if(args[55] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[55]));
		if(args[56] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[56]));
		if(args[57] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[57]));
		if(args[58] != null) __statement.setInt(count++, GenericBase.__getInt(args[58]));
		if(args[59] != null) __statement.setString(count++, GenericBase.__getString(args[59]));
		if(args[60] != null) __statement.setString(count++, GenericBase.__getString(args[60]));
		if(args[61] != null) __statement.setString(count++, GenericBase.__getString(args[61]));
		if(args[62] != null) __statement.setInt(count++, GenericBase.__getInt(args[62]));
		if(args[63] != null) __statement.setInt(count++, GenericBase.__getInt(args[63]));
		if(args[64] != null) __statement.setInt(count++, GenericBase.__getInt(args[64]));
		if(args[65] != null) __statement.setString(count++, GenericBase.__getString(args[65]));
		if(args[66] != null) __statement.setInt(count++, GenericBase.__getInt(args[66]));
		if(args[67] != null) __statement.setString(count++, GenericBase.__getString(args[67]));
		if(args[68] != null) __statement.setString(count++, GenericBase.__getString(args[68]));
		if(args[69] != null) __statement.setString(count++, GenericBase.__getString(args[69]));
		if(args[70] != null) __statement.setString(count++, GenericBase.__getString(args[70]));
		if(args[71] != null) __statement.setInt(count++, GenericBase.__getInt(args[71]));
		if(args[72] != null) __statement.setInt(count++, GenericBase.__getInt(args[72]));
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
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	public final static String __SQLText = "SELECT A .*, spia.back_view_name, spia.instance_activity_start_time, CURRENT_DATE - DATE ( to_char( spia.instance_activity_start_time, 'yyyy-mm-dd' ) ) AS out_day FROM ( ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.employee_or_company_id AS bear_fee_id, NULL AS bear_fee_code, b.payee_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.pay_money AS amount, 0 AS input_tax, 0 AS final_amount, C.plate_id, d.complete_time, b.process_bill_list_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.reason AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM employee_money_manages AS A LEFT JOIN process_bill_list AS b ON A.employee_money_manage_id = b.business_id AND b.process_type = 6 LEFT JOIN departments AS C ON A.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.employee_money_manage_id = d.business_id AND d.process_type = 6 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.employee_money_manage_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 6 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.employee_or_company_id, b.payee_name, A.code, A.employee_id, d.create_time, d.process_status, b.pay_money, C.plate_id, d.complete_time, b.process_bill_list_id, f.code, A.currency, A.reason, A.company_id, A.department_id, G.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.employee_or_company_id AS bear_fee_id, NULL AS bear_fee_code, b.payee_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.pay_money AS amount, 0 AS input_tax, 0 AS final_amount, C.plate_id, d.complete_time, b.process_bill_list_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.reason AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM pay_money_manages AS A LEFT JOIN process_bill_list AS b ON A.pay_money_manage_id = b.business_id AND b.process_type = 7 LEFT JOIN departments AS C ON A.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.pay_money_manage_id = d.business_id AND d.process_type = 7 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.pay_money_manage_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 7 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.employee_or_company_id, b.payee_name, A.code, A.employee_id, d.create_time, d.process_status, b.pay_money, C.plate_id, d.complete_time, b.process_bill_list_id, f.code, A.currency, A.reason, A.company_id, A.department_id, G.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.department_id AS bear_fee_id, NULL AS bear_fee_code, C.department_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_department_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, b.main_item_id, b.sub_item_id FROM project_normal_reimbursements AS A LEFT JOIN normal_reimbursement_link_departments AS b ON A.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN departments AS C ON b.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.project_normal_reimbursement_id = d.business_id AND d.process_type = 3 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.project_normal_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 3 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? and (b.main_item_id = ? or b.sub_item_id = ?) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.department_id, C.department_name, A.code, A.employee_id, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_department_id, f.code, A.currency, A.remark, A.company_id, A.department_id, G.bd_code, b.main_item_id, b.sub_item_id ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.project_id AS bear_fee_id, b.contract_code AS bear_fee_code, i.project_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, i.design_team as plate_id, d.complete_time, b.normal_reimbursement_link_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, G.contract_code AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, b.main_item_id, b.sub_item_id FROM project_normal_reimbursements AS A LEFT JOIN normal_reimbursement_link_projects AS b ON A.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN system_process_instances AS d ON A.project_normal_reimbursement_id = d.business_id AND d.process_type = 2 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id LEFT JOIN main_projects AS i ON i.main_project_id = b.project_id LEFT JOIN contracts G on G.project_code = i.project_code WHERE A.project_normal_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 2 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? and (b.main_item_id = ? or b.sub_item_id = ?) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.project_id, b.contract_code, i.project_name, A.code, A.employee_id, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, i.design_team, d.complete_time, b.normal_reimbursement_link_project_id, f.code, A.currency, G.contract_code, A.remark, A.company_id, A.department_id, h.bd_code, b.main_item_id, b.sub_item_id ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.main_project_id AS bear_fee_id, C.custom_number AS bear_fee_code, G.project_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_main_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, b.main_item_id, b.sub_item_id FROM project_normal_reimbursements AS A LEFT JOIN normal_reimbursement_link_main_projects AS b ON A.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers AS C ON b.main_project_id = C.pre_project_reimbursement_number_id LEFT JOIN system_process_instances AS d ON A.project_normal_reimbursement_id = d.business_id AND d.process_type = 8 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN main_projects AS G ON C.main_project_id = G.main_project_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id WHERE A.project_normal_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 8 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? and (b.main_item_id = ? or b.sub_item_id = ?) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.main_project_id, C.custom_number, G.project_name, A.code, A.employee_id, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_main_project_id, f.code, A.currency, A.remark, A.company_id, A.department_id, h.bd_code, b.main_item_id, b.sub_item_id ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.department_id AS bear_fee_id, '' AS bear_fee_code, C.department_name AS bear_fee_name, A.code AS code, A.applicant AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_department_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM travel_reimbursements AS A LEFT JOIN travel_reimbursement_link_departments AS b ON A.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN departments AS C ON b.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.travel_reimbursement_id = d.business_id AND d.process_type = 5 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.travel_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 5 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.department_id, C.department_name, A.code, A.applicant, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_department_id, f.code, A.currency, A.remark, A.company_id, A.department_id, G.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.project_id AS bear_fee_id, b.contract_code AS bear_fee_code, i.project_name AS bear_fee_name, A.code AS code, A.applicant AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, i.design_team as plate_id, d.complete_time, b.travel_reimbursement_link_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, G.contract_code AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM travel_reimbursements AS A LEFT JOIN travel_reimbursement_link_projects AS b ON A.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN system_process_instances AS d ON A.travel_reimbursement_id = d.business_id AND d.process_type = 4 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id LEFT JOIN main_projects AS i ON i.main_project_id = b.project_id LEFT JOIN contracts G on G.project_code = i.project_code WHERE A.travel_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 4 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.project_id, b.contract_code, i.project_name, A.code, A.applicant, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, i.design_team, d.complete_time, b.travel_reimbursement_link_project_id, f.code, A.currency, G.contract_code, A.remark, A.company_id, A.department_id, h.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.main_project_id AS bear_fee_id, C.custom_number AS bear_fee_code, G.project_name AS bear_fee_name, A.code AS code, A.applicant AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_main_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM travel_reimbursements AS A LEFT JOIN travel_reimbursement_link_main_projects AS b ON A.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers AS C ON b.main_project_id = C.pre_project_reimbursement_number_id LEFT JOIN system_process_instances AS d ON A.travel_reimbursement_id = d.business_id AND d.process_type = 9 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN main_projects AS G ON C.main_project_id = G.main_project_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id WHERE A.travel_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 9 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) and A.company_id = ? GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.main_project_id, C.custom_number, G.project_name, A.code, A.applicant, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_main_project_id, f.code, A.currency, A.remark, A.company_id, A.department_id, h.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, A.ID AS bear_fee_id, A.code AS bear_fee_code, A.NAME AS bear_fee_name, NULL AS code, A.drafter AS employee_id, d.create_time AS create_time, d.process_status AS process_status, NULL AS amount, NULL AS input_tax, CASE WHEN A.COST IS NOT NULL THEN - A.COST ELSE 0 END AS final_amount, A.plate_id, d.complete_time, A.link_id AS sub_table_id, NULL AS package_code, 0 AS currency, NULL AS contract_code, A.reason AS remark, NULL AS company_id, NULL AS department_id, NULL AS bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM reset_costs AS A LEFT JOIN system_process_instances AS d ON A.reset_cost_id = d.business_id AND d.process_type = 39 AND d.delete_flag = 0 WHERE A.reset_cost_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 39 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, A.ID, A.code, A.NAME, A.drafter, d.create_time, d.process_status, A.plate_id, d.complete_time, A.link_id, A.reason, A.COST, company_id, department_id, bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.ID AS bear_fee_id, b.code AS bear_fee_code, b.NAME AS bear_fee_name, NULL AS code, A.drafter AS employee_id, d.create_time AS create_time, d.process_status AS process_status, NULL AS amount, NULL AS input_tax, b.COST AS final_amount, C.plate_id, d.complete_time, b.cost_allocation_id AS sub_table_id, NULL AS package_code, 0 AS currency, NULL AS contract_code, A.reason AS remark, NULL AS company_id, NULL AS department_id, NULL AS bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM reset_costs AS A LEFT JOIN cost_allocations AS b ON A.reset_cost_id = b.reset_cost_id AND b.TYPE = 3 LEFT JOIN departments AS C ON b.ID = C.department_id LEFT JOIN system_process_instances AS d ON A.reset_cost_id = d.business_id AND d.process_type = 39 AND d.delete_flag = 0 WHERE A.reset_cost_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 39 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.ID, b.code, b.NAME, A.drafter, d.create_time, d.process_status, b.COST, C.plate_id, d.complete_time, b.cost_allocation_id, A.reason, company_id, department_id, bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.ID AS bear_fee_id, b.code AS bear_fee_code, b.NAME AS bear_fee_name, NULL AS code, A.drafter AS employee_id, d.create_time AS create_time, d.process_status AS process_status, NULL AS amount, NULL AS input_tax, b.COST AS final_amount, C.plate_id, d.complete_time, b.cost_allocation_id AS sub_table_id, NULL AS package_code, 0 AS currency, NULL AS contract_code, A.reason AS remark, NULL AS company_id, NULL AS department_id, NULL AS bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM reset_costs AS A LEFT JOIN cost_allocations AS b ON A.reset_cost_id = b.reset_cost_id AND b.TYPE = 1 LEFT JOIN projects AS C ON b.ID = C.project_id LEFT JOIN system_process_instances AS d ON A.reset_cost_id = d.business_id AND d.process_type = 39 AND d.delete_flag = 0 LEFT JOIN project_cost AS e ON d.process_instance_id = e.process_instance_id AND b.ID = e.project_id WHERE A.reset_cost_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 and process_type = 39 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ? ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.ID, b.code, b.NAME, A.drafter, d.create_time, d.process_status, b.COST, C.plate_id, d.complete_time, b.cost_allocation_id, A.reason, company_id, department_id, bd_code ) ) AS A LEFT JOIN system_process_instance_activities AS spia ON spia.process_instance_id = A.process_instance_id AND spia.status = 1 WHERE 1 = 1 and 2 = 2 and A.process_type = ? and A.bear_fee_code LIKE ? and A.bear_fee_name LIKE ? and A.code LIKE ? and A.employee_id = ? and A.plate_id = ? and A.process_status = ? and A.package_code LIKE ? and A.currency = ? and A.contract_code LIKE ? and A.remark LIKE ? and spia.back_view_name LIKE ? and A.bd_code LIKE ? and (A.main_item_id = ? or A.sub_item_id = ?) ORDER BY A.code, A.process_type, A.business_id, A.final_amount" ;
	public final static String __originalSQL = "SELECT A .*, spia.back_view_name, spia.instance_activity_start_time, CURRENT_DATE - DATE ( to_char( spia.instance_activity_start_time, 'yyyy-mm-dd' ) ) AS out_day FROM ( ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.employee_or_company_id AS bear_fee_id, NULL AS bear_fee_code, b.payee_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.pay_money AS amount, 0 AS input_tax, 0 AS final_amount, C.plate_id, d.complete_time, b.process_bill_list_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.reason AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM employee_money_manages AS A LEFT JOIN process_bill_list AS b ON A.employee_money_manage_id = b.business_id AND b.process_type = 6 LEFT JOIN departments AS C ON A.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.employee_money_manage_id = d.business_id AND d.process_type = 6 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.employee_money_manage_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 6 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.employee_or_company_id, b.payee_name, A.code, A.employee_id, d.create_time, d.process_status, b.pay_money, C.plate_id, d.complete_time, b.process_bill_list_id, f.code, A.currency, A.reason, A.company_id, A.department_id, G.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.employee_or_company_id AS bear_fee_id, NULL AS bear_fee_code, b.payee_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.pay_money AS amount, 0 AS input_tax, 0 AS final_amount, C.plate_id, d.complete_time, b.process_bill_list_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.reason AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM pay_money_manages AS A LEFT JOIN process_bill_list AS b ON A.pay_money_manage_id = b.business_id AND b.process_type = 7 LEFT JOIN departments AS C ON A.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.pay_money_manage_id = d.business_id AND d.process_type = 7 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.pay_money_manage_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 7 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.employee_or_company_id, b.payee_name, A.code, A.employee_id, d.create_time, d.process_status, b.pay_money, C.plate_id, d.complete_time, b.process_bill_list_id, f.code, A.currency, A.reason, A.company_id, A.department_id, G.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.department_id AS bear_fee_id, NULL AS bear_fee_code, C.department_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_department_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, b.main_item_id, b.sub_item_id FROM project_normal_reimbursements AS A LEFT JOIN normal_reimbursement_link_departments AS b ON A.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN departments AS C ON b.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.project_normal_reimbursement_id = d.business_id AND d.process_type = 3 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.project_normal_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 3 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id AND ( b.main_item_id = :sub_type OR b.sub_item_id = :sub_type ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.department_id, C.department_name, A.code, A.employee_id, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_department_id, f.code, A.currency, A.remark, A.company_id, A.department_id, G.bd_code, b.main_item_id, b.sub_item_id ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.project_id AS bear_fee_id, b.contract_code AS bear_fee_code, i.project_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, i.design_team as plate_id, d.complete_time, b.normal_reimbursement_link_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, G.contract_code AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, b.main_item_id, b.sub_item_id FROM project_normal_reimbursements AS A LEFT JOIN normal_reimbursement_link_projects AS b ON A.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN system_process_instances AS d ON A.project_normal_reimbursement_id = d.business_id AND d.process_type = 2 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id LEFT JOIN main_projects AS i ON i.main_project_id = b.project_id LEFT JOIN contracts G on G.project_code = i.project_code WHERE A.project_normal_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 2 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id AND ( b.main_item_id = :sub_type OR b.sub_item_id = :sub_type ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.project_id, b.contract_code, i.project_name, A.code, A.employee_id, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, i.design_team, d.complete_time, b.normal_reimbursement_link_project_id, f.code, A.currency, G.contract_code, A.remark, A.company_id, A.department_id, h.bd_code, b.main_item_id, b.sub_item_id ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.main_project_id AS bear_fee_id, C.custom_number AS bear_fee_code, G.project_name AS bear_fee_name, A.code AS code, A.employee_id AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_main_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, b.main_item_id, b.sub_item_id FROM project_normal_reimbursements AS A LEFT JOIN normal_reimbursement_link_main_projects AS b ON A.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers AS C ON b.main_project_id = C.pre_project_reimbursement_number_id LEFT JOIN system_process_instances AS d ON A.project_normal_reimbursement_id = d.business_id AND d.process_type = 8 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN main_projects AS G ON C.main_project_id = G.main_project_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id WHERE A.project_normal_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 8 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id AND ( b.main_item_id = :sub_type OR b.sub_item_id = :sub_type ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.main_project_id, C.custom_number, G.project_name, A.code, A.employee_id, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.normal_reimbursement_link_main_project_id, f.code, A.currency, A.remark, A.company_id, A.department_id, h.bd_code, b.main_item_id, b.sub_item_id ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.department_id AS bear_fee_id, '' AS bear_fee_code, C.department_name AS bear_fee_name, A.code AS code, A.applicant AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_department_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, G.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM travel_reimbursements AS A LEFT JOIN travel_reimbursement_link_departments AS b ON A.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN departments AS C ON b.department_id = C.department_id LEFT JOIN system_process_instances AS d ON A.travel_reimbursement_id = d.business_id AND d.process_type = 5 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS G ON A.budget_management_id = G.budget_management_id WHERE A.travel_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 5 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.department_id, C.department_name, A.code, A.applicant, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_department_id, f.code, A.currency, A.remark, A.company_id, A.department_id, G.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.project_id AS bear_fee_id, b.contract_code AS bear_fee_code, i.project_name AS bear_fee_name, A.code AS code, A.applicant AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, i.design_team as plate_id, d.complete_time, b.travel_reimbursement_link_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, G.contract_code AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM travel_reimbursements AS A LEFT JOIN travel_reimbursement_link_projects AS b ON A.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN system_process_instances AS d ON A.travel_reimbursement_id = d.business_id AND d.process_type = 4 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id LEFT JOIN main_projects AS i ON i.main_project_id = b.project_id LEFT JOIN contracts G on G.project_code = i.project_code WHERE A.travel_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 4 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.project_id, b.contract_code, i.project_name, A.code, A.applicant, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, i.design_team, d.complete_time, b.travel_reimbursement_link_project_id, f.code, A.currency, G.contract_code, A.remark, A.company_id, A.department_id, h.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.main_project_id AS bear_fee_id, C.custom_number AS bear_fee_code, G.project_name AS bear_fee_name, A.code AS code, A.applicant AS employee_id, d.create_time AS create_time, d.process_status AS process_status, b.amount AS amount, b.input_tax AS input_tax, b.final_amount AS final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_main_project_id AS sub_table_id, f.code AS package_code, A.currency AS currency, NULL AS contract_code, A.remark AS remark, CAST ( A.company_id AS VARCHAR ) AS company_id, CAST ( A.department_id AS VARCHAR ) AS department_id, h.bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM travel_reimbursements AS A LEFT JOIN travel_reimbursement_link_main_projects AS b ON A.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers AS C ON b.main_project_id = C.pre_project_reimbursement_number_id LEFT JOIN system_process_instances AS d ON A.travel_reimbursement_id = d.business_id AND d.process_type = 9 AND d.delete_flag = 0 LEFT JOIN reimbursement_package_details AS e ON d.process_instance_id = e.process_instance_id LEFT JOIN reimbursement_packages AS f ON e.reimbursement_package_id = f.reimbursement_package_id LEFT JOIN main_projects AS G ON C.main_project_id = G.main_project_id LEFT JOIN budget_management AS h ON A.budget_management_id = h.budget_management_id WHERE A.travel_reimbursement_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 9 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) AND A.company_id = :company_id GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.main_project_id, C.custom_number, G.project_name, A.code, A.applicant, d.create_time, d.process_status, b.amount, b.input_tax, b.final_amount, C.plate_id, d.complete_time, b.travel_reimbursement_link_main_project_id, f.code, A.currency, A.remark, A.company_id, A.department_id, h.bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, A.ID AS bear_fee_id, A.code AS bear_fee_code, A.NAME AS bear_fee_name, NULL AS code, A.drafter AS employee_id, d.create_time AS create_time, d.process_status AS process_status, NULL AS amount, NULL AS input_tax, CASE WHEN A.COST IS NOT NULL THEN - A.COST ELSE 0 END AS final_amount, A.plate_id, d.complete_time, A.link_id AS sub_table_id, NULL AS package_code, 0 AS currency, NULL AS contract_code, A.reason AS remark, NULL AS company_id, NULL AS department_id, NULL AS bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM reset_costs AS A LEFT JOIN system_process_instances AS d ON A.reset_cost_id = d.business_id AND d.process_type = 39 AND d.delete_flag = 0 WHERE A.reset_cost_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 39 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, A.ID, A.code, A.NAME, A.drafter, d.create_time, d.process_status, A.plate_id, d.complete_time, A.link_id, A.reason, A.COST, company_id, department_id, bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.ID AS bear_fee_id, b.code AS bear_fee_code, b.NAME AS bear_fee_name, NULL AS code, A.drafter AS employee_id, d.create_time AS create_time, d.process_status AS process_status, NULL AS amount, NULL AS input_tax, b.COST AS final_amount, C.plate_id, d.complete_time, b.cost_allocation_id AS sub_table_id, NULL AS package_code, 0 AS currency, NULL AS contract_code, A.reason AS remark, NULL AS company_id, NULL AS department_id, NULL AS bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM reset_costs AS A LEFT JOIN cost_allocations AS b ON A.reset_cost_id = b.reset_cost_id AND b.TYPE = 3 LEFT JOIN departments AS C ON b.ID = C.department_id LEFT JOIN system_process_instances AS d ON A.reset_cost_id = d.business_id AND d.process_type = 39 AND d.delete_flag = 0 WHERE A.reset_cost_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 39 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.ID, b.code, b.NAME, A.drafter, d.create_time, d.process_status, b.COST, C.plate_id, d.complete_time, b.cost_allocation_id, A.reason, company_id, department_id, bd_code ) UNION ALL ( SELECT d.process_type AS process_type, d.business_id AS business_id, d.process_id AS process_id, d.process_instance_id AS process_instance_id, b.ID AS bear_fee_id, b.code AS bear_fee_code, b.NAME AS bear_fee_name, NULL AS code, A.drafter AS employee_id, d.create_time AS create_time, d.process_status AS process_status, NULL AS amount, NULL AS input_tax, b.COST AS final_amount, C.plate_id, d.complete_time, b.cost_allocation_id AS sub_table_id, NULL AS package_code, 0 AS currency, NULL AS contract_code, A.reason AS remark, NULL AS company_id, NULL AS department_id, NULL AS bd_code, 0 AS main_item_id, 0 AS sub_item_id FROM reset_costs AS A LEFT JOIN cost_allocations AS b ON A.reset_cost_id = b.reset_cost_id AND b.TYPE = 1 LEFT JOIN projects AS C ON b.ID = C.project_id LEFT JOIN system_process_instances AS d ON A.reset_cost_id = d.business_id AND d.process_type = 39 AND d.delete_flag = 0 LEFT JOIN project_cost AS e ON d.process_instance_id = e.process_instance_id AND b.ID = e.project_id WHERE A.reset_cost_id IN ( SELECT business_id FROM system_process_instances WHERE delete_flag = 0 AND process_type = 39 AND create_time >= :start_create_time AND create_time < :end_create_time AND complete_time >= :start_complete_time AND complete_time < :end_complete_time ) GROUP BY d.process_type, d.business_id, d.process_id, d.process_instance_id, b.ID, b.code, b.NAME, A.drafter, d.create_time, d.process_status, b.COST, C.plate_id, d.complete_time, b.cost_allocation_id, A.reason, company_id, department_id, bd_code ) ) AS A LEFT JOIN system_process_instance_activities AS spia ON spia.process_instance_id = A.process_instance_id AND spia.status = 1 WHERE 1 = 1 AND 2 = 2 AND A.process_type = :process_type AND A.bear_fee_code LIKE :bear_fee_code AND A.bear_fee_name LIKE :bear_fee_name AND A.code LIKE :code AND A.employee_id = :employee_id AND A.plate_id = :plate_id AND A.process_status = :process_status AND A.package_code LIKE :package_code AND A.currency = :currency AND A.contract_code LIKE :contract_code AND A.remark LIKE :remark AND spia.back_view_name LIKE :back_view_name AND A.bd_code LIKE :bd_code AND ( A.main_item_id = :sub_type OR A.sub_item_id = :sub_type ) ORDER BY A.code, A.process_type, A.business_id, A.final_amount";
	private final static String RESULTSETFIELDLIST = "process_type,business_id,process_id,process_instance_id,bear_fee_id,bear_fee_code,bear_fee_name,code,employee_id,create_time,process_status,amount,input_tax,final_amount,plate_id,complete_time,sub_table_id,package_code,currency,contract_code,remark,company_id,department_id,bd_code,main_item_id,sub_item_id,back_view_name,instance_activity_start_time,out_day";
	private final static String[] fieldNames = { "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "sub_type", "sub_type", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "sub_type", "sub_type", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "sub_type", "sub_type", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "company_id", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "start_create_time", "end_create_time", "start_complete_time", "end_complete_time", "process_type", "bear_fee_code", "bear_fee_name", "code", "employee_id", "plate_id", "process_status", "package_code", "currency", "contract_code", "remark", "back_view_name", "bd_code", "sub_type", "sub_type"};
}
