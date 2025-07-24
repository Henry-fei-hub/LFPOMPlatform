package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseScmbcpaydetailctyor;
import pomplatform.reimbursementpackage.bean.ConditionScmbcpaydetailctyor;

public class QueryScmbcpaydetailctyor extends AbstractQuery<BaseScmbcpaydetailctyor, ConditionScmbcpaydetailctyor>
{

	private static final Logger __logger = Logger.getLogger(QueryScmbcpaydetailctyor.class);

	public QueryScmbcpaydetailctyor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cpd.cmbc_pay_detail_id");
	}

	@Override
	public BaseCollection<BaseScmbcpaydetailctyor> executeQuery( KeyValuePair[] replacements, ConditionScmbcpaydetailctyor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCmbcPayDetailId(), 
				condition.getType(), 
				condition.getYurref(), 
				condition.getReimbursementPackageSummaryId(), 
				condition.getReimbursementPackageId(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseScmbcpaydetailctyor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScmbcpaydetailctyor __base = new BaseScmbcpaydetailctyor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCmbcPayDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYurref(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEptdat(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDbtacc(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDbtbbk(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrsamt(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCcynbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStlchn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNusage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusnar(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCrtacc(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCrtnam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBrdnbr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBnkflg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCrtbnk(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCtycod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCrtpvc(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCrtcty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCrtbbk(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setErrorMsg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBuscod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusmod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEaccty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrstyp(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrstypName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select cpd.cmbc_pay_detail_id, cpd.type, cpd.yurref, cpd.eptdat, cpd.dbtacc, cpd.dbtbbk, cpd.trsamt, cpd.ccynbr, cpd.stlchn, cpd.nusage, cpd.busnar, cpd.crtacc, cpd.crtnam, cpd.brdnbr, cpd.bnkflg, cpd.crtbnk, cpd.ctycod, cpd.crtpvc, cpd.crtcty, cpd.province, cpd.city, cpd.total_amount, cpd.total_num, cpd.crtbbk, cpd.reimbursement_package_summary_id, cpd.reimbursement_package_id, cpd.create_time, cpd.operator, cpd.status, cpd.error_msg, cpd.buscod, cpd.busmod, cpd.eaccty, cpd.trstyp, cpd.trstyp_name from cmbc_pay_details cpd where cpd.cmbc_pay_detail_id = ? and cpd.type = ? and cpd.yurref = ? and cpd.reimbursement_package_summary_id = ? and cpd.reimbursement_package_id = ? and cpd.status = ?" ;
	private final static String RESULTSETFIELDLIST = "cmbc_pay_detail_id,type,yurref,eptdat,dbtacc,dbtbbk,trsamt,ccynbr,stlchn,nusage,busnar,crtacc,crtnam,brdnbr,bnkflg,crtbnk,ctycod,crtpvc,crtcty,province,city,total_amount,total_num,crtbbk,reimbursement_package_summary_id,reimbursement_package_id,create_time,operator,status,error_msg,buscod,busmod,eaccty,trstyp,trstyp_name";
	private final static String[] fieldNames = { "cmbc_pay_detail_id", "type", "yurref", "reimbursement_package_summary_id", "reimbursement_package_id", "status"};
}
