package pomplatform.projectprice.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectprice.bean.BaseSprojectunitpricepagor;
import pomplatform.projectprice.bean.ConditionSprojectunitpricepagor;

public class QuerySprojectunitpricepagor extends AbstractQuery<BaseSprojectunitpricepagor, ConditionSprojectunitpricepagor> {

	private static final Logger __logger = Logger.getLogger(QuerySprojectunitpricepagor.class);

	public QuerySprojectunitpricepagor() throws java.sql.SQLException {
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pup.project_unit_price_id");
	}

	@Override
	public BaseCollection<BaseSprojectunitpricepagor> executeQuery(KeyValuePair[] replacements, ConditionSprojectunitpricepagor condition) throws java.sql.SQLException {
		return executeQuery(replacements,
			condition.getPlateId(),
			condition.getAreaId(),
			condition.getGradeId(),
			condition.getSquareId(),
			condition.getSquare(),
			condition.getSquare(),
			condition.getSquare()
		);
	}

	@Override
	public BaseSprojectunitpricepagor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectunitpricepagor __base = new BaseSprojectunitpricepagor();
		int count = 0;
		Object val;
		if ((val = __data[count++]) != null) {
			__base.setProjectUnitPriceId(GenericBase.__getInt(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setPlateId(GenericBase.__getInt(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setAreaId(GenericBase.__getInt(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setGradeId(GenericBase.__getInt(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setSquareId(GenericBase.__getInt(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setMinSquare(GenericBase.__getDecimal(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setMaxSquare(GenericBase.__getDecimal(val));
		}
		if ((val = __data[count++]) != null) {
			__base.setUnitPrice(GenericBase.__getDecimal(val));
		}
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object... args) throws java.sql.SQLException {

		int index = 0;
		for (int ii = 0; ii < args.length; ii++) {
			if (args[ii] == null) {
				continue;
			}
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if (index > 0) {
			__logger.info("=================================================");
		}
		if (args[0] != null) {
			__statement.setInt(count++, GenericBase.__getInt(args[0]));
		}
		if (args[1] != null) {
			__statement.setInt(count++, GenericBase.__getInt(args[1]));
		}
		if (args[2] != null) {
			__statement.setInt(count++, GenericBase.__getInt(args[2]));
		}
		if (args[3] != null) {
			__statement.setInt(count++, GenericBase.__getInt(args[3]));
		}
		if (args[4] != null) {
			__statement.setBigDecimal(count++, GenericBase.__getDecimal(args[4]));
		}
		if (args[5] != null) {
			__statement.setBigDecimal(count++, GenericBase.__getDecimal(args[5]));
		}
		if (args[6] != null) {
			__statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		}
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList() {
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select pup.project_unit_price_id, pup.plate_id, pup.area_id, pup.grade_id, pup.square_id, pup.min_square, pup.max_square, pup.unit_price from project_unit_prices pup where pup.plate_id = ? and pup.area_id = ? and pup.grade_id = ? and pup.square_id = ? and ( pup.max_square <= ? or ( pup.min_square < ? and pup.max_square >= ? ) ) order by min_square";
	private final static String RESULTSETFIELDLIST = "project_unit_price_id,plate_id,area_id,grade_id,square_id,min_square,max_square,unit_price";
	private final static String[] fieldNames = {"plate_id", "area_id", "grade_id", "square_id", "square", "square", "square"};
}
