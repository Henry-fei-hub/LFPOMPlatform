package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BasePreProjectAnalysisData;
import pomplatform.project.bean.ConditionPreProjectAnalysisData;

public class QueryPreProjectAnalysisData extends AbstractQuery<BasePreProjectAnalysisData, ConditionPreProjectAnalysisData>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectAnalysisData.class);

	public QueryPreProjectAnalysisData() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.info_code");
	}

	@Override
	public BaseCollection<BasePreProjectAnalysisData> executeQuery( KeyValuePair[] replacements, ConditionPreProjectAnalysisData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(),
				condition.getBusinessType(), 
				condition.getStatus(),
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasePreProjectAnalysisData generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectAnalysisData __base = new BasePreProjectAnalysisData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCloseReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompetitiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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
	private final static String __SQLText ="SELECT A .info_code, A .business_type, A .specialty, A .status,A.project_base_on, A .project_name, A .region, A .province, A .city, A .register_date, A .project_approval_time, A .comparison_form, A .contract_amount, A .close_reason, A .close_remark, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG (A .competitive_unit) ) ), '，' ) AS competitive_unit, A .apply_employee_id, A .project_sales_team, A.department_id,A .design_team FROM ( SELECT DISTINCT cu. NAME AS competitive_unit, P .info_code, P .business_type, P .specialty, P .status, P .project_name, P .region, P .province, P .city, P .create_time AS register_date, P .project_approval_time, P .comparison_form, pr.contract_amount, P .close_reason, P .close_remark, P .apply_employee_id, P .project_sales_team, P .design_team,P.project_base_on,es.department_id FROM pre_projects P LEFT JOIN ( SELECT pre_project_id, MAX (track_date) AS track_date FROM pre_project_records GROUP BY pre_project_id ) b ON P .pre_project_id = b.pre_project_id LEFT JOIN pre_project_records pr ON P .pre_project_id = pr.pre_project_id AND b.track_date = pr.track_date LEFT JOIN main_project_competition_units mpcu ON mpcu.pre_project_id = P .pre_project_id LEFT JOIN competition_units cu ON cu.competition_unit_id = mpcu.competition_unit_id LEFT JOIN employees es ON P .apply_employee_id = es.employee_id WHERE es.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) ) A WHERE A.business_type =? AND A.status =? AND A.project_approval_time BETWEEN ? AND ? GROUP BY A .info_code, A .business_type, A .specialty, A .status, A .project_name, A .region, A .province, A .city, A .register_date, A .project_approval_time, A .comparison_form, A .contract_amount, A .close_reason, A .close_remark, A .apply_employee_id, A .project_sales_team, A .design_team, A .info_code,A.project_base_on,A.department_id ORDER BY A.register_date DESC,A.project_approval_time DESC";
	private final static String RESULTSETFIELDLIST = "info_code,business_type,specialty,status,project_base_on,project_name,region,province,city,register_date,project_approval_time,comparison_form,contract_amount,close_reason,close_remark,competitive_unit,apply_employee_id,project_sales_team,department_id,design_team";
	private final static String[] fieldNames = { "department_id","business_type", "status","start_date","end_date"};
}
