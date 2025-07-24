package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BasePaymentTemplateWithP;
import pomplatform.purchase.bean.ConditionPaymentTemplateWithP;

public class QueryPaymentTemplateWithP extends AbstractQuery<BasePaymentTemplateWithP, ConditionPaymentTemplateWithP>
{

	private static final Logger __logger = Logger.getLogger(QueryPaymentTemplateWithP.class);

	public QueryPaymentTemplateWithP() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pt.payment_template_id");
	}

	@Override
	public BaseCollection<BasePaymentTemplateWithP> executeQuery( KeyValuePair[] replacements, ConditionPaymentTemplateWithP condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getOperatorId(), 
				condition.getMinPaymentCycle(), 
				condition.getMaxPaymentCycle(), 
				condition.getTemplateName(), 
				condition.getRemark()
			);
	}

	@Override
	public BasePaymentTemplateWithP generateBase(Object[] __data) throws java.sql.SQLException {
		BasePaymentTemplateWithP __base = new BasePaymentTemplateWithP();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPaymentTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTemplateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPaymentCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select pt.payment_template_id, pt.template_name, pt.payment_cycle, pt.remark, pt.operator_id, pt.create_time from payment_templates pt where pt.operator_id = ? and pt.payment_cycle between ? and ? and pt.template_name like ? and pt.remark like ?" ;
	private final static String RESULTSETFIELDLIST = "payment_template_id,template_name,payment_cycle,remark,operator_id,create_time";
	private final static String[] fieldNames = { "operator_id", "min_payment_cycle", "max_payment_cycle", "template_name", "remark"};
}
