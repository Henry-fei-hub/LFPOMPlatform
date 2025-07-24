package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseProfessionalApprovalApplication;
import pomplatform.projectSettlement.bean.ConditionProfessionalApprovalApplication;

public class QueryProfessionalApprovalApplication extends AbstractQuery<BaseProfessionalApprovalApplication, ConditionProfessionalApprovalApplication>
{

	private static final Logger __logger = Logger.getLogger(QueryProfessionalApprovalApplication.class);

	public QueryProfessionalApprovalApplication() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pa.professional_approval__id");
	}

	@Override
	public BaseCollection<BaseProfessionalApprovalApplication> executeQuery( KeyValuePair[] replacements, ConditionProfessionalApprovalApplication condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProfessionalApproval_id()
			);
	}

	public BaseCollection<BaseProfessionalApprovalApplication> runQuery( KeyValuePair[] replacements, ConditionProfessionalApprovalApplication condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProfessionalApproval_id()
			);
	}

	public BaseCollection<BaseProfessionalApprovalApplication> execute( KeyValuePair[] replacements, ConditionProfessionalApprovalApplication condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProfessionalApproval_id()
			);
	}

	@Override
	public BaseProfessionalApprovalApplication generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProfessionalApprovalApplication __base = new BaseProfessionalApprovalApplication();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProfessionalApproval_id(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select pa.professional_approval__id, pa.employee_id, pa.employee_no, pa.start_date, pa.delete_flag, pa.project_id, pa.project_code, pa.project_name, pa.contract_id, pa.contract_code, pa.contract_name, pa.plate_id, pa.design_type, pa.project_type, pa.plate_manager_id, pa.project_level, pa.department_manager_id, pa.project_manage_id, pa.project_manage_name, pa.project_manage_department_id, pa.common_area, pa.logistics_area, pa.cad_area, pa.total_integral, pa.project_integral, pa.reserve_integral, pa.percentage from professional_approval pa where pa.professional_approval__id = ?" ;
	private final static String __originalSQL = "select pa.professional_approval__id, pa.employee_id, pa.employee_no, pa.start_date, pa.delete_flag, pa.project_id, pa.project_code, pa.project_name, pa.contract_id, pa.contract_code, pa.contract_name, pa.plate_id, pa.design_type, pa.project_type, pa.plate_manager_id, pa.project_level, pa.department_manager_id, pa.project_manage_id, pa.project_manage_name, pa.project_manage_department_id, pa.common_area, pa.logistics_area, pa.cad_area, pa.total_integral, pa.project_integral, pa.reserve_integral, pa.percentage from professional_approval pa where pa.professional_approval__id = :professional_approval__id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"pa.professional_approval__id = :professional_approval__id\",\"startIndex\": 550,\"stopIndex\":606,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pa.professional_approval__id = :professional_approval__id\",\"fullFieldName\":\"pa.professional_approval__id\",\"operationName\":\"=\",\"variableName\":\"professionalApproval_id\",\"startIndex\": 550,\"stopIndex\":606,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "professional_approval__id,employee_id,employee_no,start_date,delete_flag,project_id,project_code,project_name,contract_id,contract_code,contract_name,plate_id,design_type,project_type,plate_manager_id,project_level,department_manager_id,project_manage_id,project_manage_name,project_manage_department_id,common_area,logistics_area,cad_area,total_integral,project_integral,reserve_integral,percentage";
	private final static String[] fieldNames = { "professional_approval__id"};
}
