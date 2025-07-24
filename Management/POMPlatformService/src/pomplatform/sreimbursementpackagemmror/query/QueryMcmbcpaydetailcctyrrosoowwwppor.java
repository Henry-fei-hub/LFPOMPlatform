package pomplatform.sreimbursementpackagemmror.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sreimbursementpackagemmror.bean.BaseMcmbcpaydetailcctyrrosoowwwppor;
import pomplatform.sreimbursementpackagemmror.bean.ConditionMcmbcpaydetailcctyrrosoowwwppor;

public class QueryMcmbcpaydetailcctyrrosoowwwppor extends AbstractQuery<BaseMcmbcpaydetailcctyrrosoowwwppor, ConditionMcmbcpaydetailcctyrrosoowwwppor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcmbcpaydetailcctyrrosoowwwppor.class);

	public QueryMcmbcpaydetailcctyrrosoowwwppor() throws java.sql.SQLException 
	{
		setParameterNumber(14);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cpd.cmbc_pay_detail_id");
	}

	@Override
	public BaseCollection<BaseMcmbcpaydetailcctyrrosoowwwppor> executeQuery( KeyValuePair[] replacements, ConditionMcmbcpaydetailcctyrrosoowwwppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCmbcPayDetailId(), 
				condition.getType(), 
				condition.getYurref(), 
				condition.getReimbursementPackageSummaryId(), 
				condition.getReimbursementPackageId(), 
				condition.getOperator(), 
				condition.getStatus(), 
				condition.getObjectId(), 
				condition.getObjectType(), 
				condition.getWithdrawFlag(), 
				condition.getWithdrawOriginId(), 
				condition.getWithdrawStatus(), 
				condition.getPayResult(), 
				condition.getPayStatus()
			);
	}

	@Override
	public BaseMcmbcpaydetailcctyrrosoowwwppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcmbcpaydetailcctyrrosoowwwppor __base = new BaseMcmbcpaydetailcctyrrosoowwwppor();
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
		if((val = __data[count++]) != null) __base.setCmbcPaymentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setObjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setObjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOprdat(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWithdrawFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWithdrawOriginId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWithdrawStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayResult(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCperrorMsg(GenericBase.__getString(val));
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
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
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

	private final static String __SQLText = "SELECT cpd.cmbc_pay_detail_id, cpd.type, cpd.yurref, cpd.eptdat, cpd.dbtacc, cpd.dbtbbk, cpd.trsamt, cpd.ccynbr, cpd.stlchn, cpd.nusage, cpd.busnar, cpd.crtacc, cpd.crtnam, cpd.brdnbr, cpd.bnkflg, cpd.crtbnk, cpd.ctycod, cpd.crtpvc, cpd.crtcty, cpd.province, cpd.city, cpd.total_amount, cpd.total_num, cpd.crtbbk, cpd.reimbursement_package_summary_id, cpd.reimbursement_package_id, cpd.create_time, cpd.operator, cpd.status, cpd.error_msg, cpd.buscod, cpd.busmod, cpd.eaccty, cpd.trstyp, cpd.trstyp_name, cpd.cmbc_payment_id, cpd.object_id, cpd.object_type, cpd.oprdat, cpd.withdraw_flag, cpd.withdraw_origin_id, cpd.withdraw_status, cp.pay_result, cp.pay_status, cp.error_msg AS cperror_msg FROM cmbc_pay_details cpd LEFT JOIN cmbc_payments cp ON cpd.cmbc_payment_id = cp.cmbc_payment_id WHERE cpd.cmbc_pay_detail_id = ? AND cpd.type = ? AND cpd.yurref = ? AND cpd.reimbursement_package_summary_id = ? AND cpd.reimbursement_package_id = ? AND cpd.operator = ? AND cpd.status = ? AND cpd.object_id = ? AND cpd.object_type = ? AND cpd.withdraw_flag = ? AND cpd.withdraw_origin_id = ? AND cpd.withdraw_status = ? AND cp.pay_result = ? AND cp.pay_status = ? ORDER BY cpd.type desc, cpd.reimbursement_package_summary_id" ;
	private final static String RESULTSETFIELDLIST = "cmbc_pay_detail_id,type,yurref,eptdat,dbtacc,dbtbbk,trsamt,ccynbr,stlchn,nusage,busnar,crtacc,crtnam,brdnbr,bnkflg,crtbnk,ctycod,crtpvc,crtcty,province,city,total_amount,total_num,crtbbk,reimbursement_package_summary_id,reimbursement_package_id,create_time,operator,status,error_msg,buscod,busmod,eaccty,trstyp,trstyp_name,cmbc_payment_id,object_id,object_type,oprdat,withdraw_flag,withdraw_origin_id,withdraw_status,pay_result,pay_status,cperror_msg";
	private final static String[] fieldNames = { "cmbc_pay_detail_id", "type", "yurref", "reimbursement_package_summary_id", "reimbursement_package_id", "operator", "status", "object_id", "object_type", "withdraw_flag", "withdraw_origin_id", "withdraw_status", "pay_result", "pay_status"};
}
