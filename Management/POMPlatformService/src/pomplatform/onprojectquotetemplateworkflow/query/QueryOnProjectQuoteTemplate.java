package pomplatform.onprojectquotetemplateworkflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.onprojectquotetemplateworkflow.bean.BaseOnProjectQuoteTemplate;
import pomplatform.onprojectquotetemplateworkflow.bean.ConditionOnProjectQuoteTemplate;

public class QueryOnProjectQuoteTemplate extends AbstractQuery<BaseOnProjectQuoteTemplate, ConditionOnProjectQuoteTemplate>
{

	private static final Logger __logger = Logger.getLogger(QueryOnProjectQuoteTemplate.class);

	public QueryOnProjectQuoteTemplate() throws java.sql.SQLException 
	{
		setParameterNumber(23);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pq.project_quote_id");
	}

	@Override
	public BaseCollection<BaseOnProjectQuoteTemplate> executeQuery( KeyValuePair[] replacements, ConditionOnProjectQuoteTemplate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectQuoteId(), 
				condition.getProjectId(), 
				condition.getTitleName(), 
				condition.getFileId(), 
				condition.getVersionNumber(), 
				condition.getQuoteStatus(), 
				condition.getBasicAmount(), 
				condition.getTotalAmount(), 
				condition.getUpAmount(), 
				condition.getUpPercent(), 
				condition.getPreferentialAmount(), 
				condition.getPerferentialPercent(), 
				condition.getSpecialDiscountAmount(), 
				condition.getSpecialDiscountPercent(), 
				condition.getTaxAmount(), 
				condition.getOtherTaxAmount(), 
				condition.getFinalPercent(), 
				condition.getFinalAmount(), 
				condition.getTaxFinalAmount(), 
				condition.getOperateEmployeeId(), 
				condition.getOperateTime(), 
				condition.getRemark(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseOnProjectQuoteTemplate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnProjectQuoteTemplate __base = new BaseOnProjectQuoteTemplate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectQuoteId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVersionNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuoteStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBasicAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUpAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUpPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPreferentialAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPerferentialPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDiscountAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDiscountPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[8]));
		if(args[9] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[9]));
		if(args[10] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[10]));
		if(args[11] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[11]));
		if(args[12] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[12]));
		if(args[13] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[13]));
		if(args[14] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[14]));
		if(args[15] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[15]));
		if(args[16] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[16]));
		if(args[17] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[17]));
		if(args[18] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setString(count++, GenericBase.__getString(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
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

	private final static String __SQLText = "select pq.project_quote_id, pq.project_id, pq.title_name, pq.file_id, pq.version_number, pq.quote_status, pq.basic_amount, pq.total_amount, pq.up_amount, pq.up_percent, pq.preferential_amount, pq.perferential_percent, pq.special_discount_amount, pq.special_discount_percent, pq.tax_amount, pq.other_tax_amount, pq.final_percent, pq.final_amount, pq.tax_final_amount, pq.operate_employee_id, pq.operate_time, pq.remark, pq.company_id from project_quotes pq where pq.project_quote_id = ? and pq.project_id = ? and pq.title_name = ? and pq.file_id = ? and pq.version_number = ? and pq.quote_status = ? and pq.basic_amount = ? and pq.total_amount = ? and pq.up_amount = ? and pq.up_percent = ? and pq.preferential_amount = ? and pq.perferential_percent = ? and pq.special_discount_amount = ? and pq.special_discount_percent = ? and pq.tax_amount = ? and pq.other_tax_amount = ? and pq.final_percent = ? and pq.final_amount = ? and pq.tax_final_amount = ? and pq.operate_employee_id = ? and pq.operate_time = ? and pq.remark = ? and pq.company_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_quote_id,project_id,title_name,file_id,version_number,quote_status,basic_amount,total_amount,up_amount,up_percent,preferential_amount,perferential_percent,special_discount_amount,special_discount_percent,tax_amount,other_tax_amount,final_percent,final_amount,tax_final_amount,operate_employee_id,operate_time,remark,company_id";
	private final static String[] fieldNames = { "project_quote_id", "project_id", "title_name", "file_id", "version_number", "quote_status", "basic_amount", "total_amount", "up_amount", "up_percent", "preferential_amount", "perferential_percent", "special_discount_amount", "special_discount_percent", "tax_amount", "other_tax_amount", "final_percent", "final_amount", "tax_final_amount", "operate_employee_id", "operate_time", "remark", "company_id"};
}
