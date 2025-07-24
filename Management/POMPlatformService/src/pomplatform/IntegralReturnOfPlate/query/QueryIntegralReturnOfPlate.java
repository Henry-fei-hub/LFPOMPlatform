package pomplatform.IntegralReturnOfPlate.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.IntegralReturnOfPlate.bean.BaseIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.bean.ConditionIntegralReturnOfPlate;

public class QueryIntegralReturnOfPlate extends AbstractQuery<BaseIntegralReturnOfPlate, ConditionIntegralReturnOfPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryIntegralReturnOfPlate.class);

	public QueryIntegralReturnOfPlate() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseIntegralReturnOfPlate> executeQuery( KeyValuePair[] replacements, ConditionIntegralReturnOfPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId()
			);
	}

	@Override
	public BaseIntegralReturnOfPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseIntegralReturnOfPlate __base = new BaseIntegralReturnOfPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveintegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSearchPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegralreturnofplate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select aa.employee_id, e.employee_no, e.employee_name, e.status , e.plate_id, sum(aa.achieveIntegral) as achieveIntegral, aa.plate_id as search_plate_id,sum(aa.sum1)-sum(aa.sum2) AS IntegralReturnOfPlate,e.grade_id from (select a.employee_id,a.business_type_id,c.plate_id,case when d.parent_id = -1 then -(sum(a.integral)) else sum(a.integral) end as achieveIntegral,case when a.business_type_id = 3 then sum(a.integral) else 0 end as sum1,case when a.business_type_id = 5 then sum(a.integral) else 0 end as sum2 from employee_account_records a LEFT JOIN employee_day_plate_records C ON A.employee_id = C.employee_id AND a.record_date = c.record_date left join system_dictionary d on dic_type_id = 66 and a.business_type_id = d.dic_type_value_id  where  c.plate_id = ? GROUP BY a.employee_id,a.business_type_id,c.plate_id,d.parent_id ) as aa left join employees e on aa.employee_id = e.employee_id where e.status = 0 and e.plate_id = aa.plate_id GROUP BY aa.employee_id, e.employee_no, e.employee_name, e.status,e.plate_id,aa.plate_id,e.grade_id HAVING sum(aa.sum1)-sum(aa.sum2)>0 ORDER BY e.status " ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,status,plate_id,achieveintegral,search_plate_id,integralreturnofplate,grade_id";
	private final static String[] fieldNames = { "plate_id"};
}
