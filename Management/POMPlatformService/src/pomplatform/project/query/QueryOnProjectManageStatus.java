package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnProjectManageStatus;
import pomplatform.project.bean.ConditionOnProjectManageStatus;

public class QueryOnProjectManageStatus extends AbstractQuery<BaseOnProjectManageStatus, ConditionOnProjectManageStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryOnProjectManageStatus.class);

	public QueryOnProjectManageStatus() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.* FROM ( SELECT DISTINCT A .main_project_id");
	}

	@Override
	public BaseCollection<BaseOnProjectManageStatus> executeQuery( KeyValuePair[] replacements, ConditionOnProjectManageStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInfoCode(), 
				condition.getHasOutQuotations(), 
				condition.getHasSplitPrice(), 
				condition.getHasSendSheet()
			);
	}

	@Override
	public BaseOnProjectManageStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnProjectManageStatus __base = new BaseOnProjectManageStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotations(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasSendSheet(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotationsTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasSplitPriceTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasSendSheetTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBidType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWinningTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
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

	private final static String __SQLText = " SELECT aa.* FROM ( SELECT DISTINCT A .main_project_id, A.info_code, A.project_name, CASE WHEN d.out_quotation_id IS NULL THEN FALSE ELSE TRUE END AS has_out_quotations, A.has_split_price, CASE WHEN C.contract_id IS NULL THEN FALSE ELSE TRUE END AS has_send_sheet, A.project_approval_time, o.update_time AS has_out_quotations_time, A.has_split_price_time, C.update_time AS has_send_sheet_time, A.project_base_on, A.bid_type, A.winning_time FROM main_projects A LEFT JOIN out_quotations o ON A.info_code = o.info_code AND quotation_status = 1 LEFT JOIN out_design_considerations d ON o.out_quotation_id = d.out_quotation_id LEFT JOIN contracts C ON A.info_code = C.info_code AND C.flow_status = 4 ) AS aa WHERE aa.project_approval_time > '2018-04-01' AND ( aa.project_base_on IN ( 2, 3 ) OR ( aa.project_base_on IN ( 1, 4 ) AND aa.bid_type = 2 )) AND aa.info_code = ? AND aa.has_out_quotations = ? AND aa.has_split_price = ? AND aa.has_send_sheet = ? ORDER BY aa.main_project_id ASC" ;
	private final static String RESULTSETFIELDLIST = "main_project_id,info_code,project_name,has_out_quotations,has_split_price,has_send_sheet,project_approval_time,has_out_quotations_time,has_split_price_time,has_send_sheet_time,project_base_on,bid_type,winning_time";
	private final static String[] fieldNames = { "info_code", "has_out_quotations", "has_split_price", "has_send_sheet"};
}
