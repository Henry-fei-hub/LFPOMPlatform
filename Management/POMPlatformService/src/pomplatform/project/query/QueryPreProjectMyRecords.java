package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BasePreProjectMyRecords;
import pomplatform.project.bean.ConditionPreProjectMyRecords;

public class QueryPreProjectMyRecords extends AbstractQuery<BasePreProjectMyRecords, ConditionPreProjectMyRecords>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectMyRecords.class);

	public QueryPreProjectMyRecords() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .apply_employee_id");
	}

	@Override
	public BaseCollection<BasePreProjectMyRecords> executeQuery( KeyValuePair[] replacements, ConditionPreProjectMyRecords condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getApplyEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getStatus(), 
				condition.getProjectStatus(), 
				condition.getProjectBaseOn(), 
				condition.getRelevantEmployees(),
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasePreProjectMyRecords generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectMyRecords __base = new BasePreProjectMyRecords();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWinRate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTrackDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectRecordRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
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
	private final static String __SQLText = "SELECT A .apply_employee_id, A .register_date, A .info_code, A .project_name, A .customer_name, A .province, A .city, A .business_type, A .project_level, A .win_rate, A .project_status, A .process_status, A .status, A .project_base_on, A .project_approval_time, A .estimate_the_design_areas, A .actual_design_areas, A .contract_amount, A .track_date, A .project_record_remark, A .project_origination, A .department_id, A .design_team, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG (A .project_leader) ) ), '，' ) AS project_leader, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG (A .project_manager) ) ), '，' ) AS project_manager FROM ( SELECT  DISTINCT CASE WHEN M .relation = 4 THEN e.employee_name END AS project_leader, CASE WHEN M .relation = 3 THEN e.employee_name END AS project_manager,p.project_sales_team,P .project_approval_time, P .apply_employee_id, P .project_level, pe.department_id, P .create_time AS register_date, sp.process_status, P .status, P .project_status, P .project_base_on, P .info_code, P .project_name, P .design_team, P .business_type, CASE P .is_original WHEN 't' THEN '是' ELSE '否' END AS is_original, P .customer_name, P .province, P .city, P .contact_name, P .grade, P .contact_phone, P .estimate_the_design_areas, P .actual_design_areas, pr.design_price, Pr.contract_amount, pr.track_date, pr.remark AS project_record_remark, cu. NAME AS competitive_unit, P .project_origination, P .project_origination_remark, P .win_rate FROM pre_projects P LEFT JOIN pre_project_records pr ON P .pre_project_id = pr.pre_project_id LEFT JOIN main_project_competition_units mpcu ON mpcu.pre_project_id = P .pre_project_id LEFT JOIN competition_units cu ON cu.competition_unit_id = mpcu.competition_unit_id LEFT JOIN main_project_employees M ON P .pre_project_id = M .pre_project_id AND M .pre_project_id = pr.pre_project_id LEFT JOIN employees e ON e.employee_id = M .employee_id LEFT JOIN employees pe ON pe.employee_id = P .apply_employee_id LEFT JOIN departments d ON d.department_id = pe.department_id LEFT JOIN system_process_instances sp ON P .pre_project_id = sp.business_id AND sp.process_type = 42 WHERE P.apply_employee_id=? AND pe.department_id IN ( SELECT child_id FROM department_ids WHERE department_id=? ) AND P.status=? AND P.project_status=? AND P.project_base_on=? AND pr.relevant_employees LIKE ? AND p.create_time BETWEEN ? AND ?) A GROUP BY A .apply_employee_id, A .register_date, A .info_code, A .project_name, A .customer_name, A .province, A .city, A .business_type, A .project_level, A .win_rate, A .status, A .process_status, A .project_status, A .project_base_on, A .project_approval_time, A .estimate_the_design_areas, A .actual_design_areas, A .contract_amount, A .track_date, A .project_record_remark, A .project_origination, A .department_id, A .design_team ORDER BY A .win_rate DESC, A .register_date DESC, A .info_code" ;
	private final static String RESULTSETFIELDLIST = "apply_employee_id,register_date,info_code,project_name,customer_name,province,city,business_type,project_level,win_rate,project_status,process_status,status,project_base_on,project_approval_time,estimate_the_design_areas,actual_design_areas,contract_amount,track_date,project_record_remark,project_origination,department_id,design_team,project_leader,project_manager";
	private final static String[] fieldNames = { "apply_employee_id", "department_id", "status", "project_status", "project_base_on", "relevant_employees","start_date","end_date"};
}
