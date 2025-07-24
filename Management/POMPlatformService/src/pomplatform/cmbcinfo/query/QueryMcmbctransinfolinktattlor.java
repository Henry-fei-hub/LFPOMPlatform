package pomplatform.cmbcinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cmbcinfo.bean.BaseMcmbctransinfolinktattlor;
import pomplatform.cmbcinfo.bean.ConditionMcmbctransinfolinktattlor;

public class QueryMcmbctransinfolinktattlor extends AbstractQuery<BaseMcmbctransinfolinktattlor, ConditionMcmbctransinfolinktattlor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcmbctransinfolinktattlor.class);

	public QueryMcmbctransinfolinktattlor() throws java.sql.SQLException 
	{
		setParameterNumber(27);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cti.cmbc_trans_info_id");
	}

	@Override
	public BaseCollection<BaseMcmbctransinfolinktattlor> executeQuery( KeyValuePair[] replacements, ConditionMcmbctransinfolinktattlor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getLinkType(),
				condition.getBankAccount(), 
				condition.getCompanyRecordId(), 
				condition.getNaryur(), 
				condition.getRefnbr(), 
				condition.getReqnbr(), 
				condition.getBusnam(), 
				condition.getNusage(), 
				condition.getYurref(), 
				condition.getRpynam(), 
				condition.getRpyacc(), 
				condition.getRpybnk(), 
				condition.getRpyadr(), 
				condition.getMinTransDate(), 
				condition.getMaxTransDate(), 
				condition.getMinVltdat(), 
				condition.getMaxVltdat(), 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getCmbcTransInfoId(), 
				condition.getTrscod(), 
				condition.getAmtcdr(), 
				condition.getTrsanl(), 
				condition.getTransType(), 
				condition.getLinkNum()
			);
	}

	@Override
	public BaseMcmbctransinfolinktattlor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcmbctransinfolinktattlor __base = new BaseMcmbctransinfolinktattlor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCmbcTransInfoId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccnam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEtydat(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEtytim(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setVltdat(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTrscod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNaryur(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrsamtd(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTrsamtc(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAmtcdr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrsblv(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRefnbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReqnbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusnam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNusage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYurref(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusnar(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtrnar(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCRpybbk(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRpynam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRpyacc(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRpybbn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRpybnk(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRpyadr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCGsbbbk(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGsbacc(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGsbnam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfflg(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAthflg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setChknbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRsvflg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNarext(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrsanl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRefsub(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFrmcod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTransType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkNum(GenericBase.__getInt(val));
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
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
		if(args[23] != null) __statement.setString(count++, GenericBase.__getString(args[23]));
		if(args[24] != null) __statement.setString(count++, GenericBase.__getString(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
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

	private final static String __SQLText = "SELECT cti.cmbc_trans_info_id, cti.bank_account, cai.accnam, cti.etydat, cti.etytim, cti.trans_date, cti.vltdat, cti.trscod, cti.naryur, cti.trsamtd, cti.trsamtc, cti.amtcdr, cti.trsblv, cti.refnbr, cti.reqnbr, cti.busnam, cti.nusage, cti.yurref, cti.busnar, cti.otrnar, cti.c_rpybbk, cti.rpynam, cti.rpyacc, cti.rpybbn, cti.rpybnk, cti.rpyadr, cti.c_gsbbbk, cti.gsbacc, cti.gsbnam, cti.infflg, cti.athflg, cti.chknbr, cti.rsvflg, cti.narext, cti.trsanl, cti.refsub, cti.frmcod, cti.create_time, cti.update_time, cti.trans_type, cr.company_record_id,bccl.link_num FROM cmbc_trans_info cti LEFT JOIN cmbc_accout_info cai ON cti.bank_account = cai.accnbr LEFT JOIN company_records cr ON cai.accnam = cr.company_name LEFT JOIN (SELECT business_id, count(1) AS link_num FROM bank_capital_check_links WHERE link_type = ? AND business_type = 1 GROUP BY business_id) bccl ON cti.cmbc_trans_info_id = bccl.business_id WHERE cti.bank_account LIKE ? AND cr.company_record_id = ? AND cti.naryur LIKE ? AND cti.refnbr LIKE ? AND cti.reqnbr LIKE ? AND cti.busnam LIKE ? AND cti.nusage LIKE ? AND cti.yurref LIKE ? AND cti.rpynam LIKE ? AND cti.rpyacc LIKE ? AND cti.rpybnk LIKE ? AND cti.rpyadr LIKE ? AND cti.trans_date BETWEEN ? AND ? AND cti.vltdat BETWEEN ? AND ? AND cti.create_time BETWEEN ? AND ? AND cti.update_time BETWEEN ? AND ? AND cti.cmbc_trans_info_id = ? AND cti.trscod = ? AND cti.amtcdr = ? AND cti.trsanl = ? AND cti.trans_type = ? AND bccl.link_num > ? ORDER BY cti.trans_date DESC" ;
	private final static String RESULTSETFIELDLIST = "cmbc_trans_info_id,bank_account,accnam,etydat,etytim,trans_date,vltdat,trscod,naryur,trsamtd,trsamtc,amtcdr,trsblv,refnbr,reqnbr,busnam,nusage,yurref,busnar,otrnar,c_rpybbk,rpynam,rpyacc,rpybbn,rpybnk,rpyadr,c_gsbbbk,gsbacc,gsbnam,infflg,athflg,chknbr,rsvflg,narext,trsanl,refsub,frmcod,create_time,update_time,trans_type,company_record_id,link_num";
	private final static String[] fieldNames = { "link_type", "bank_account", "company_record_id", "naryur", "refnbr", "reqnbr", "busnam", "nusage", "yurref", "rpynam", "rpyacc", "rpybnk", "rpyadr", "min_trans_date", "max_trans_date", "min_vltdat", "max_vltdat", "min_create_time", "max_create_time", "min_update_time", "max_update_time", "cmbc_trans_info_id", "trscod", "amtcdr", "trsanl", "trans_type", "link_num"};
}
