package pomplatform.memployeechangeplatedetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.memployeechangeplatedetail.bean.BaseMEmployeeChangePlateDetail;
import pomplatform.memployeechangeplatedetail.bean.ConditionMEmployeeChangePlateDetail;

public class QueryMEmployeeChangePlateDetail extends AbstractQuery<BaseMEmployeeChangePlateDetail, ConditionMEmployeeChangePlateDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryMEmployeeChangePlateDetail.class);

	public QueryMEmployeeChangePlateDetail() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ecpd.employee_change_plate_detail_id");
	}

	@Override
	public BaseCollection<BaseMEmployeeChangePlateDetail> executeQuery( KeyValuePair[] replacements, ConditionMEmployeeChangePlateDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth(), 
				condition.getInPlateId(), 
				condition.getOutPlateId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMEmployeeChangePlateDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMEmployeeChangePlateDetail __base = new BaseMEmployeeChangePlateDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeChangePlateDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOutPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "select ecpd.employee_change_plate_detail_id,e.employee_no, ecpd.employee_id, ecpd.year, ecpd.month, ecpd.out_plate_id, ecpd.in_plate_id, ecpd.remark, ecpd.create_time, ecpd.update_time from employee_change_plate_details ecpd left join employees e on ecpd.employee_id = e.employee_id where ecpd.year = ? and ecpd.month >= ? and ecpd.month <= ? and ecpd.in_plate_id = ? and ecpd.out_plate_id = ? and e.employee_no like ? and ecpd.employee_id = ? order by ecpd.change_plate_date desc" ;
	private final static String RESULTSETFIELDLIST = "employee_change_plate_detail_id,employee_no,employee_id,year,month,out_plate_id,in_plate_id,remark,create_time,update_time";
	private final static String[] fieldNames = { "year", "start_month", "end_month", "in_plate_id", "out_plate_id", "employee_no", "employee_id"};
}
