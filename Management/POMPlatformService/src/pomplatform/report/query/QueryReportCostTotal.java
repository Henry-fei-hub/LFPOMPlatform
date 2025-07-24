package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportCostTotal;
import pomplatform.report.bean.ConditionReportCostTotal;

public class QueryReportCostTotal extends AbstractQuery<BaseReportCostTotal, ConditionReportCostTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportCostTotal.class);

	public QueryReportCostTotal() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportCostTotal> executeQuery( KeyValuePair[] replacements, ConditionReportCostTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getFeeType(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportCostTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportCostTotal __base = new BaseReportCostTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFeeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJanuary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarch(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApril(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJune(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuly(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugust(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctober(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecember(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "SELECT aa.plate_id, aa.year, aa.fee_type, sum(january) as january, sum(february) as february, sum(march) as march, sum(april) as april, sum(may) as may, sum(june) as june, sum(july) as july, sum(august) as august, sum(september) as september, sum(october) as october, sum(november) as november, sum(december) as december from ( SELECT a.plate_id, extract(year from a.create_time) as year, a.fee_type, case when extract(month from a.create_time) = 1 then sum(a.final_amount) else 0 end as january, case when extract(month from a.create_time) = 2 then sum(a.final_amount) else 0 end as february, case when extract(month from a.create_time) = 3 then sum(a.final_amount) else 0 end as march, case when extract(month from a.create_time) = 4 then sum(a.final_amount) else 0 end as april, case when extract(month from a.create_time) = 5 then sum(a.final_amount) else 0 end as may, case when extract(month from a.create_time) = 6 then sum(a.final_amount) else 0 end as june, case when extract(month from a.create_time) = 7 then sum(a.final_amount) else 0 end as july, case when extract(month from a.create_time) = 8 then sum(a.final_amount) else 0 end as august, case when extract(month from a.create_time) = 9 then sum(a.final_amount) else 0 end as september, case when extract(month from a.create_time) = 10 then sum(a.final_amount) else 0 end as october, case when extract(month from a.create_time) = 11 then sum(a.final_amount) else 0 end as november, case when extract(month from a.create_time) = 12 then sum(a.final_amount) else 0 end as december from ( (SELECT 3 as fee_type, d.create_time as create_time, b.final_amount as final_amount, c.plate_id from project_normal_reimbursements a LEFT JOIN normal_reimbursement_link_departments b on a.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN departments c on b.department_id = c.department_id LEFT JOIN system_process_instances d on a.project_normal_reimbursement_id = d.business_id and d.process_type = 3 and d.delete_flag = 0 where a.project_normal_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 3 and extract(year from d.create_time) = ?) ) union all ( SELECT 1 as fee_type, d.create_time as create_time, b.final_amount as final_amount, c.plate_id from project_normal_reimbursements a LEFT JOIN normal_reimbursement_link_projects b on a.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN projects c on b.project_id = c.project_id LEFT JOIN system_process_instances d on a.project_normal_reimbursement_id = d.business_id and d.process_type = 2 and d.delete_flag = 0 where a.project_normal_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 2 and extract(year from d.create_time) = ?) ) union all( SELECT 2 as fee_type, d.create_time as create_time, b.final_amount as final_amount, c.plate_id from project_normal_reimbursements a LEFT JOIN normal_reimbursement_link_main_projects b on a.project_normal_reimbursement_id = b.project_normal_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers c on b.main_project_id = c.pre_project_reimbursement_number_id LEFT JOIN system_process_instances d on a.project_normal_reimbursement_id = d.business_id and d.process_type = 8 and d.delete_flag = 0 where a.project_normal_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 8 and extract(year from d.create_time) = ?) ) union all( SELECT 3 as fee_type,d.create_time as create_time, b.final_amount as final_amount, c.plate_id from travel_reimbursements a LEFT JOIN travel_reimbursement_link_departments b on a.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN departments c on b.department_id = c.department_id LEFT JOIN system_process_instances d on a.travel_reimbursement_id = d.business_id and d.process_type = 5 and d.delete_flag = 0 where a.travel_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 5 and extract(year from d.create_time) = ?) ) union all( SELECT 1 as fee_type, d.create_time as create_time, b.final_amount as final_amount, c.plate_id from travel_reimbursements a LEFT JOIN travel_reimbursement_link_projects b on a.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN projects c on b.project_id = c.project_id LEFT JOIN system_process_instances d on a.travel_reimbursement_id = d.business_id and d.process_type = 4 and d.delete_flag = 0 where a.travel_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 4 and extract(year from d.create_time) = ?) ) union all ( SELECT 2 as fee_type, d.create_time as create_time, b.final_amount as final_amount, c.plate_id from travel_reimbursements a LEFT JOIN travel_reimbursement_link_main_projects b on a.travel_reimbursement_id = b.travel_reimbursement_id LEFT JOIN pre_project_reimbursement_numbers c on b.main_project_id = c.pre_project_reimbursement_number_id LEFT JOIN system_process_instances d on a.travel_reimbursement_id = d.business_id and d.process_type = 9 and d.delete_flag = 0 where a.travel_reimbursement_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 9 and extract(year from d.create_time) = ?) ) union all ( SELECT a.cost_type as fee_type,d.create_time as create_time, case when a.cost is not null then -a.cost else 0 end as final_amount, a.plate_id from reset_costs a LEFT JOIN system_process_instances d on a.reset_cost_id = d.business_id and d.process_type = 39 and d.delete_flag = 0 where a.reset_cost_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 39 and extract(year from d.create_time) = ?) ) union all ( SELECT b.type as fee_type, d.create_time as create_time, b.cost as final_amount, c.plate_id from reset_costs a LEFT JOIN cost_allocations b on a.reset_cost_id = b.reset_cost_id and b.type = 3 LEFT JOIN departments c on b.id = c.department_id LEFT JOIN system_process_instances d on a.reset_cost_id = d.business_id and d.process_type = 39 and d.delete_flag = 0 where a.reset_cost_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 39 and extract(year from d.create_time) = ?) ) union all ( SELECT b.type as fee_type, d.create_time as create_time, b.cost as final_amount, c.plate_id from reset_costs a LEFT JOIN cost_allocations b on a.reset_cost_id = b.reset_cost_id and b.type = 1 LEFT JOIN projects c on b.id = c.project_id LEFT JOIN system_process_instances d on a.reset_cost_id = d.business_id and d.process_type = 39 and d.delete_flag = 0 where a.reset_cost_id in (SELECT business_id from system_process_instances WHERE process_status != 5 and delete_flag = 0 and process_type = 39 and extract(year from d.create_time) = ?) ) ) a where a.fee_type = ? and a.plate_id = ? and a.plate_id in (1,2,3,4,5,6,7,9,10,11,15,25) GROUP BY a.plate_id, a.fee_type, a.create_time ) aa GROUP BY aa.plate_id, aa.year, aa.fee_type order by aa.plate_id, aa.fee_type" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,fee_type,january,february,march,april,may,june,july,august,september,october,november,december";
	private final static String[] fieldNames = { "year", "year", "year", "year", "year", "year", "year", "year", "year", "fee_type", "plate_id"};
}
