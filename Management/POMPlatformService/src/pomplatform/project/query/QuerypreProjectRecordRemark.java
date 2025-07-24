package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BasepreProjectRecordRemark;
import pomplatform.project.bean.ConditionpreProjectRecordRemark;

public class QuerypreProjectRecordRemark extends AbstractQuery<BasepreProjectRecordRemark, ConditionpreProjectRecordRemark>
{

	private static final Logger __logger = Logger.getLogger(QuerypreProjectRecordRemark.class);

	public QuerypreProjectRecordRemark() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .department_id");
	}

	@Override
	public BaseCollection<BasepreProjectRecordRemark> executeQuery( KeyValuePair[] replacements, ConditionpreProjectRecordRemark condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getApplyEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getStatus(), 
				condition.getProjectStatus(), 
				condition.getProjectBaseOn(),
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasepreProjectRecordRemark generateBase(Object[] __data) throws java.sql.SQLException {
		BasepreProjectRecordRemark __base = new BasepreProjectRecordRemark();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignPrice(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTrackDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectRecordRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompetitiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWinRate(GenericBase.__getString(val));
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
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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
	private final static String __SQLText ="SELECT A.department_id , A .project_sales_team, A .apply_employee_id, A .register_date, A .info_code, A .project_name, A .business_type, A .is_original, A .customer_name, A .province, A .city, A .contact_name, A .grade, A .contact_phone, A .estimate_the_design_areas, A .design_price, A .contract_amount, A .track_date, A .project_record_remark, A .competitive_unit, A .project_origination, A .project_origination_remark, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG (A .project_leader) ) ), '，' ) AS project_leader, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG (A .project_manager) ) ), '，' ) AS project_manager, A .win_rate FROM ( SELECT DISTINCT CASE WHEN M .relation = 4 THEN e.employee_name END AS project_leader, CASE WHEN M .relation = 3 THEN e.employee_name END AS project_manager, P .apply_employee_id, P .create_time AS register_date, P .info_code, P .project_name, P .business_type, CASE P .is_original WHEN 't' THEN '是' ELSE '否' END AS is_original, p.project_sales_team, P .customer_name, P .province, P .city, P .contact_name, P .grade, P .contact_phone, P .estimate_the_design_areas, pr.design_price, Pr.contract_amount, pr.track_date, pr.remark AS project_record_remark, cu. NAME AS competitive_unit, P .project_origination, P .project_origination_remark, P .win_rate,es.department_id FROM pre_projects P LEFT JOIN pre_project_records pr ON P .pre_project_id = pr.pre_project_id LEFT JOIN main_project_competition_units mpcu ON mpcu.pre_project_id = P .pre_project_id LEFT JOIN competition_units cu ON cu.competition_unit_id = mpcu.competition_unit_id LEFT JOIN main_project_employees M ON P .pre_project_id = M .pre_project_id LEFT JOIN employees e ON e.employee_id = M .employee_id LEFT JOIN employees es ON P.apply_employee_id = es.employee_id WHERE P.apply_employee_id =? AND es.department_id in ( SELECT child_id FROM department_ids WHERE department_id =? ) AND P.status =? AND P.project_status =? AND P.project_base_on =? AND P.create_time BETWEEN ? AND ? ) A GROUP BY A .project_sales_team, A .apply_employee_id, A .register_date, A .info_code, A .project_name, A .business_type, A .is_original, A .customer_name, A .province, A .city, A .contact_name, A .grade, A .contact_phone, A .estimate_the_design_areas, A .design_price, A .contract_amount, A .track_date, A .project_record_remark, A .competitive_unit, A .project_origination, A .project_origination_remark, A .win_rate,A.department_id  ORDER BY A .win_rate DESC, A .register_date DESC, A .info_code";
	private final static String RESULTSETFIELDLIST = "department_id,project_sales_team,apply_employee_id,register_date,info_code,project_name,business_type,is_original,customer_name,province,city,contact_name,grade,contact_phone,estimate_the_design_areas,design_price,contract_amount,track_date,project_record_remark,competitive_unit,project_origination,project_origination_remark,project_leader,project_manager,win_rate";
	private final static String[] fieldNames = { "apply_employee_id", "department_id", "status", "project_status", "project_base_on","start_date","end_date"};
}
