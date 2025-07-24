package pomplatform.ssubcontractsspor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ssubcontractsspor.bean.BaseSsubcontractsspor;
import pomplatform.ssubcontractsspor.bean.ConditionSsubcontractsspor;

public class QuerySsubcontractsspor extends AbstractQuery<BaseSsubcontractsspor, ConditionSsubcontractsspor>
{

	private static final Logger __logger = Logger.getLogger(QuerySsubcontractsspor.class);

	public QuerySsubcontractsspor() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sc.sub_contract_id");
	}

	@Override
	public BaseCollection<BaseSsubcontractsspor> executeQuery( KeyValuePair[] replacements, ConditionSsubcontractsspor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSubContractId(), 
				condition.getSubContractCode(), 
				condition.getProjectCode(), 
				condition.getSubContractName(), 
				condition.getInfoCode(), 
				condition.getRemark(), 
				condition.getParentId(), 
				condition.getBusinessType(), 
				condition.getProjectType(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseSsubcontractsspor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSsubcontractsspor __base = new BaseSsubcontractsspor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAgreeDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessStateRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "select sc.sub_contract_id, sc.parent_id, sc.sub_contract_code, sc.project_code, sc.business_type, sc.project_type, sc.department_id, sc.common_area, sc.logistics_area, sc.money_sum, sc.create_time, sc.sub_contract_name, sc.update_time, sc.design_area, sc.order_no, sc.sheet_total_integral, sc.complaint_integral, sc.sheet_integral, sc.complaint_percentage, sc.agree_date, sc.info_code, sc.business_state_record_id, sc.remark from sub_contracts sc where sc.sub_contract_id = ? and sc.sub_contract_code like ? and sc.project_code like ? and sc.sub_contract_name like ? and sc.info_code like ? and sc.remark like ? and sc.parent_id = ? and sc.business_type = ? and sc.project_type = ? and sc.department_id = ?" ;
	private final static String RESULTSETFIELDLIST = "sub_contract_id,parent_id,sub_contract_code,project_code,business_type,project_type,department_id,common_area,logistics_area,money_sum,create_time,sub_contract_name,update_time,design_area,order_no,sheet_total_integral,complaint_integral,sheet_integral,complaint_percentage,agree_date,info_code,business_state_record_id,remark";
	private final static String[] fieldNames = { "sub_contract_id", "sub_contract_code", "project_code", "sub_contract_name", "info_code", "remark", "parent_id", "business_type", "project_type", "department_id"};
}
