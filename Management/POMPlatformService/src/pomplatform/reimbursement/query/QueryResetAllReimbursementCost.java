package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseResetAllReimbursementCost;
import pomplatform.reimbursement.bean.ConditionResetAllReimbursementCost;

public class QueryResetAllReimbursementCost extends AbstractQuery<BaseResetAllReimbursementCost, ConditionResetAllReimbursementCost>
{

	private static final Logger __logger = Logger.getLogger(QueryResetAllReimbursementCost.class);

	public QueryResetAllReimbursementCost() throws java.sql.SQLException 
	{
		setParameterNumber(32);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.* from ((SELECT d.process_type as process_type");
	}

	@Override
	public BaseCollection<BaseResetAllReimbursementCost> executeQuery( KeyValuePair[] replacements, ConditionResetAllReimbursementCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartTime(), 
				condition.getEndTime(), 
				condition.getStartCompleteTime(),
				condition.getEndCompleteTime(),
				condition.getStartTime(), 
				condition.getEndTime(),  
				condition.getStartCompleteTime(),
				condition.getEndCompleteTime(),
				condition.getStartTime(), 
				condition.getEndTime(),  
				condition.getStartCompleteTime(),
				condition.getEndCompleteTime(),
				condition.getStartTime(), 
				condition.getEndTime(),  
				condition.getStartCompleteTime(),
				condition.getEndCompleteTime(),
				condition.getStartTime(), 
				condition.getEndTime(),  
				condition.getStartCompleteTime(),
				condition.getEndCompleteTime(),
				condition.getStartTime(), 
				condition.getEndTime(),  
				condition.getStartCompleteTime(),
				condition.getEndCompleteTime(),
				condition.getProcessType(), 
				condition.getFeeType(), 
				condition.getBearFeeCode(), 
				condition.getBearFeeName(), 
				condition.getCode(), 
				condition.getEmployeeId(), 
				condition.getPlateId(),
				condition.getProcessStatus()
			);
	}

	@Override
	public BaseResetAllReimbursementCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseResetAllReimbursementCost __base = new BaseResetAllReimbursementCost();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFeeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBearFeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBearFeeCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBearFeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSubTableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrency(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setResetTimes(GenericBase.__getLong(val));
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
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[21]));
		if(args[22] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[22]));
		if(args[23] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setString(count++, GenericBase.__getString(args[26]));
		if(args[27] != null) __statement.setString(count++, GenericBase.__getString(args[27]));
		if(args[28] != null) __statement.setString(count++, GenericBase.__getString(args[28]));
		if(args[29] != null) __statement.setInt(count++, GenericBase.__getInt(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setInt(count++, GenericBase.__getInt(args[31]));
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

	private final static String __SQLText = "SELECT a.*, count(c.process_instance_id) as reset_times from ((SELECT d.process_type as process_type, a.project_normal_reimbursement_id as business_id, d.process_id as process_id, d.process_instance_id as process_instance_id, 3 as fee_type, b.department_id as bear_fee_id, '' as bear_fee_code, c.department_name as bear_fee_name, a.code as code, a.employee_id as employee_id, d.create_time as create_time, d.process_status as process_status, case when d.process_status = 3 then 1 else 0 end as cost_status, b.amount as amount, b.input_tax as input_tax, b.final_amount as final_amount, c.plate_id, d.complete_time,b.normal_reimbursement_link_department_id as sub_table_id, a.currency, a.exchange_rate from project_normal_reimbursements a LEFT JOIN normal_reimbursement_link_departments b on a.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN departments c on b.department_id = c.department_id LEFT JOIN system_process_instances d on a.project_normal_reimbursement_id = d.business_id and d.process_type = 3 and d.delete_flag = 0 where a.project_normal_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 3 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ?)) union all (SELECT d.process_type as process_type, a.project_normal_reimbursement_id as business_id, d.process_id as process_id, d.process_instance_id as process_instance_id, 1 as fee_type, b.project_id as bear_fee_id, c.contract_code as bear_fee_code, c.project_name as bear_fee_name, a.code as code, a.employee_id as employee_id, d.create_time as create_time, d.process_status as process_status, f.status as cost_status, b.amount as amount, b.input_tax as input_tax, b.final_amount as final_amount, c.plate_id, d.complete_time, b.normal_reimbursement_link_project_id as sub_table_id, a.currency, a.exchange_rate from project_normal_reimbursements a LEFT JOIN normal_reimbursement_link_projects b on a.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN projects c on b.project_id = c.project_id LEFT JOIN system_process_instances d on a.project_normal_reimbursement_id = d.business_id and d.process_type = 2 and d.delete_flag = 0 LEFT JOIN project_cost f on d.process_instance_id = f.process_instance_id and b.project_id = f.project_id where a.project_normal_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 2 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ?)) union all(SELECT d.process_type as process_type, a.project_normal_reimbursement_id as business_id, d.process_id as process_id, d.process_instance_id as process_instance_id, 2 as fee_type, b.main_project_id as bear_fee_id, c.custom_number as bear_fee_code, g.project_name as bear_fee_name, a.code as code, a.employee_id as employee_id, d.create_time as create_time, d.process_status as process_status, 0 as cost_status, b.amount as amount, b.input_tax as input_tax, b.final_amount as final_amount, c.plate_id, d.complete_time, b.normal_reimbursement_link_main_project_id as sub_table_id, a.currency, a.exchange_rate from project_normal_reimbursements a LEFT JOIN normal_reimbursement_link_main_projects b on a.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers c on b.main_project_id = c.pre_project_reimbursement_number_id LEFT JOIN system_process_instances d on a.project_normal_reimbursement_id = d.business_id and d.process_type = 8 and d.delete_flag = 0 LEFT JOIN pre_projects g on c.main_project_id = g.pre_project_id where a.project_normal_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 8 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ?) ) union all(SELECT d.process_type as process_type, a.travel_reimbursement_id as business_id, d.process_id as process_id, d.process_instance_id as process_instance_id, 3 as fee_type, b.department_id as bear_fee_id, '' as bear_fee_code, c.department_name as bear_fee_name, a.code as code, a.applicant as employee_id, d.create_time as create_time, d.process_status as process_status, case when d.process_status = 3 then 1 else 0 end as cost_status, b.amount as amount, b.input_tax as input_tax, b.final_amount as final_amount, c.plate_id, d.complete_time, b.travel_reimbursement_link_department_id as sub_table_id, a.currency, a.exchange_rate from travel_reimbursements a LEFT JOIN travel_reimbursement_link_departments b on a.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN departments c on b.department_id = c.department_id LEFT JOIN system_process_instances d on a.travel_reimbursement_id = d.business_id and d.process_type = 5 and d.delete_flag = 0 where a.travel_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 5 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ?)) union all(SELECT d.process_type as process_type, a.travel_reimbursement_id as business_id, d.process_id as process_id, d.process_instance_id as process_instance_id, 1 as fee_type, b.project_id as bear_fee_id, c.contract_code as bear_fee_code, c.project_name as bear_fee_name, a.code as code, a.applicant as employee_id, d.create_time as create_time, d.process_status as process_status, f.status as cost_status, b.amount as amount, b.input_tax as input_tax, b.final_amount as final_amount, c.plate_id, d.complete_time, b.travel_reimbursement_link_project_id as sub_table_id, a.currency, a.exchange_rate from travel_reimbursements a LEFT JOIN travel_reimbursement_link_projects b on a.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN projects c on b.project_id = c.project_id LEFT JOIN system_process_instances d on a.travel_reimbursement_id = d.business_id and d.process_type = 4 and d.delete_flag = 0 LEFT JOIN project_cost f on d.process_instance_id = f.process_instance_id and b.project_id = f.project_id where a.travel_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 4 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ?)) union all (SELECT d.process_type as process_type, a.travel_reimbursement_id as business_id, d.process_id as process_id, d.process_instance_id as process_instance_id, 2 as fee_type, b.main_project_id as bear_fee_id, c.custom_number as bear_fee_code, g.project_name as bear_fee_name, a.code as code, a.applicant as employee_id, d.create_time as create_time, d.process_status as process_status, 0 as cost_status, b.amount as amount, b.input_tax as input_tax, b.final_amount as final_amount, c.plate_id, d.complete_time, b.travel_reimbursement_link_main_project_id as sub_table_id, a.currency, a.exchange_rate from travel_reimbursements a LEFT JOIN travel_reimbursement_link_main_projects b on a.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers c on b.main_project_id = c.pre_project_reimbursement_number_id LEFT JOIN system_process_instances d on a.travel_reimbursement_id = d.business_id and d.process_type = 9 and d.delete_flag = 0 LEFT JOIN pre_projects g on c.main_project_id = g.pre_project_id where a.travel_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 9 and create_time >= ? and create_time < ? and complete_time >= ? and complete_time < ?) )) a LEFT JOIN reset_costs b on a.process_instance_id = b.process_instance_id and a.sub_table_id = b.link_id LEFT JOIN system_process_instances c on b.reset_cost_id = c.business_id and c.process_type = 39 and c.delete_flag = 0 and c.process_status in (0,1,3) where a.process_type = ? and a.fee_type = ? and a.bear_fee_code like ? and a.bear_fee_name like ? and a.code like ? and a.employee_id = ? and a.plate_id = ? and a.process_status = ? GROUP BY a.process_type, a.business_id, a.process_id, a.process_instance_id, a.fee_type, a.bear_fee_id, a.bear_fee_code, a.bear_fee_name, a.code, a.employee_id, a.create_time, a.process_status, a.cost_status, a.amount, a.input_tax, a.final_amount, a.plate_id, a.complete_time, a.sub_table_id, a.currency, a.exchange_rate order by a.code" ;
	private final static String RESULTSETFIELDLIST = "process_type,business_id,process_id,process_instance_id,fee_type,bear_fee_id,bear_fee_code,bear_fee_name,code,employee_id,create_time,process_status,cost_status,amount,input_tax,final_amount,plate_id,complete_time,sub_table_id,currency,exchange_rate,reset_times";
	private final static String[] fieldNames = { "start_time", "end_time", "start_complete_time", "end_complete_time", "start_time", "end_time", "start_complete_time", "end_complete_time", "start_time", "end_time", "start_complete_time", "end_complete_time", "start_time", "end_time", "start_complete_time", "end_complete_time", "start_time", "end_time", "start_complete_time", "end_complete_time", "start_time", "end_time", "start_complete_time", "end_complete_time", "process_type", "fee_type", "bear_fee_code", "bear_fee_name", "code", "employee_id", "plate_id", "process_status"};
}
