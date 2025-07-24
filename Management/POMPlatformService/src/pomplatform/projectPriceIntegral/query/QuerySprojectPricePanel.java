package pomplatform.projectPriceIntegral.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectPriceIntegral.bean.BaseSprojectPricePanel;
import pomplatform.projectPriceIntegral.bean.ConditionSprojectPricePanel;

public class QuerySprojectPricePanel extends AbstractQuery<BaseSprojectPricePanel, ConditionSprojectPricePanel>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectPricePanel.class);

	public QuerySprojectPricePanel() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pup.project_unit_price_id");
	}

	@Override
	public BaseCollection<BaseSprojectPricePanel> executeQuery( KeyValuePair[] replacements, ConditionSprojectPricePanel condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectUnitPriceId(), 
				condition.getPlateId(), 
				condition.getAreaId(), 
				condition.getGradeId(), 
				condition.getSquareId()
			);
	}

	@Override
	public BaseSprojectPricePanel generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectPricePanel __base = new BaseSprojectPricePanel();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectUnitPriceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSquareId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMinSquare(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaxSquare(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitPrice(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
		if(args[3] != null) __statement.setInt(count++, (java.lang.Integer)args[3]);
		if(args[4] != null) __statement.setInt(count++, (java.lang.Integer)args[4]);
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

	private final static String __SQLText = "select pup.project_unit_price_id, pup.plate_id, pup.area_id, pup.grade_id, pup.square_id, pup.min_square, pup.max_square, pup.unit_price from project_unit_prices pup where pup.project_unit_price_id = ? and pup.plate_id = ? and pup.area_id = ? and pup.grade_id = ? and pup.square_id = ? order by pup.plate_id" ;
	private final static String RESULTSETFIELDLIST = "project_unit_price_id,plate_id,area_id,grade_id,square_id,min_square,max_square,unit_price";
	private final static String[] fieldNames = { "project_unit_price_id", "plate_id", "area_id", "grade_id", "square_id"};
}
