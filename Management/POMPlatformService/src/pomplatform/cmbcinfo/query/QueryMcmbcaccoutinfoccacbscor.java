package pomplatform.cmbcinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cmbcinfo.bean.BaseMcmbcaccoutinfoccacbscor;
import pomplatform.cmbcinfo.bean.ConditionMcmbcaccoutinfoccacbscor;

public class QueryMcmbcaccoutinfoccacbscor extends AbstractQuery<BaseMcmbcaccoutinfoccacbscor, ConditionMcmbcaccoutinfoccacbscor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcmbcaccoutinfoccacbscor.class);

	public QueryMcmbcaccoutinfoccacbscor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	cai.cmbc_accout_info_id");
	}

	@Override
	public BaseCollection<BaseMcmbcaccoutinfoccacbscor> executeQuery( KeyValuePair[] replacements, ConditionMcmbcaccoutinfoccacbscor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyRecordId(), 
				condition.getAccnbr(), 
				condition.getCmbcAccoutInfoId(), 
				condition.getBbknbr(), 
				condition.getStscod(), 
				condition.getCcynbr()
			);
	}

	@Override
	public BaseMcmbcaccoutinfoccacbscor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcmbcaccoutinfoccacbscor __base = new BaseMcmbcaccoutinfoccacbscor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCmbcAccoutInfoId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCcynbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCCcynbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccitm(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBbknbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccnbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccnam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccblv(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOnlblv(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHldblv(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAvlblv(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLmtovr(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStscod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntcod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCIntrat(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntrat(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOpndat(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMutdat(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInttyp(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDpstxt(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompanyRecordId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "SELECT DISTINCT cai.cmbc_accout_info_id, cai.ccynbr, cai.c_ccynbr, cai.accitm, cai.bbknbr, cai.accnbr, cai.accnam, cai.accblv, cai.onlblv, cai.hldblv, cai.avlblv, cai.lmtovr, cai.stscod, cai.intcod, cai.c_intrat, cai.intrat, cai.opndat, cai.mutdat, cai.inttyp, cai.dpstxt, cai.create_time, cai.update_time, cr.company_record_id FROM cmbc_accout_info cai LEFT JOIN company_records cr ON cai.accnam = cr.company_name WHERE cr.company_record_id = ? AND cai.accnbr LIKE ? AND cai.cmbc_accout_info_id = ? AND cai.bbknbr = ? AND cai.stscod = ? AND cai.ccynbr = ? ORDER BY cr.company_record_id" ;
	private final static String RESULTSETFIELDLIST = "cmbc_accout_info_id,ccynbr,c_ccynbr,accitm,bbknbr,accnbr,accnam,accblv,onlblv,hldblv,avlblv,lmtovr,stscod,intcod,c_intrat,intrat,opndat,mutdat,inttyp,dpstxt,create_time,update_time,company_record_id";
	private final static String[] fieldNames = { "company_record_id", "accnbr", "cmbc_accout_info_id", "bbknbr", "stscod", "ccynbr"};
}
