package pomplatform.contractchange.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractchange.bean.BaseProjectChangeRecord;
import pomplatform.contractchange.bean.ConditionProjectChangeRecord;

public class QueryProjectChangeRecord extends AbstractQuery<BaseProjectChangeRecord, ConditionProjectChangeRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectChangeRecord.class);

	public QueryProjectChangeRecord() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pc.project_change_id");
	}

	@Override
	public BaseCollection<BaseProjectChangeRecord> executeQuery( KeyValuePair[] replacements, ConditionProjectChangeRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getFlag()
			);
	}

	@Override
	public BaseProjectChangeRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectChangeRecord __base = new BaseProjectChangeRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectChangeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetChangeAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetChangeView(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalChangeIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalFinalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalChangeView(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "select pc.project_change_id, pc.project_id, pc.sheet_amount, pc.sheet_change_amount, pc.sheet_final_amount, pc.sheet_change_view, pc.total_integral, pc.total_change_integral, pc.total_final_integral, pc.total_change_view, pc.common_area, pc.logistics_area, pc.design_area, pc.complaint_percentage, pc.complaint_integral, pc.flag, pc.operate_employee_id, pc.operate_time, pc.remark from project_changes pc where pc.project_id in (SELECT project_id from projects where contract_id = ?) and pc.flag = ?" ;
	private final static String RESULTSETFIELDLIST = "project_change_id,project_id,sheet_amount,sheet_change_amount,sheet_final_amount,sheet_change_view,total_integral,total_change_integral,total_final_integral,total_change_view,common_area,logistics_area,design_area,complaint_percentage,complaint_integral,flag,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "contract_id", "flag"};
}
