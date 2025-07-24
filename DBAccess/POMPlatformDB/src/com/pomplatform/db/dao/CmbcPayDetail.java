package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCmbcPayDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CmbcPayDetail extends AbstractTable<BaseCmbcPayDetail>
{

	public CmbcPayDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 42;

		initTables();

		__tableName            = "cmbc_pay_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCmbcPayDetail.CS_CMBC_PAY_DETAIL_ID;
		__column_names[1] = BaseCmbcPayDetail.CS_TYPE;
		__column_names[2] = BaseCmbcPayDetail.CS_YURREF;
		__column_names[3] = BaseCmbcPayDetail.CS_EPTDAT;
		__column_names[4] = BaseCmbcPayDetail.CS_DBTACC;
		__column_names[5] = BaseCmbcPayDetail.CS_DBTBBK;
		__column_names[6] = BaseCmbcPayDetail.CS_TRSAMT;
		__column_names[7] = BaseCmbcPayDetail.CS_CCYNBR;
		__column_names[8] = BaseCmbcPayDetail.CS_STLCHN;
		__column_names[9] = BaseCmbcPayDetail.CS_NUSAGE;
		__column_names[10] = BaseCmbcPayDetail.CS_BUSNAR;
		__column_names[11] = BaseCmbcPayDetail.CS_CRTACC;
		__column_names[12] = BaseCmbcPayDetail.CS_CRTNAM;
		__column_names[13] = BaseCmbcPayDetail.CS_BRDNBR;
		__column_names[14] = BaseCmbcPayDetail.CS_BNKFLG;
		__column_names[15] = BaseCmbcPayDetail.CS_CRTBNK;
		__column_names[16] = BaseCmbcPayDetail.CS_CTYCOD;
		__column_names[17] = BaseCmbcPayDetail.CS_CRTPVC;
		__column_names[18] = BaseCmbcPayDetail.CS_CRTCTY;
		__column_names[19] = BaseCmbcPayDetail.CS_PROVINCE;
		__column_names[20] = BaseCmbcPayDetail.CS_CITY;
		__column_names[21] = BaseCmbcPayDetail.CS_TOTAL_AMOUNT;
		__column_names[22] = BaseCmbcPayDetail.CS_TOTAL_NUM;
		__column_names[23] = BaseCmbcPayDetail.CS_CRTBBK;
		__column_names[24] = BaseCmbcPayDetail.CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID;
		__column_names[25] = BaseCmbcPayDetail.CS_REIMBURSEMENT_PACKAGE_ID;
		__column_names[26] = BaseCmbcPayDetail.CS_CREATE_TIME;
		__column_names[27] = BaseCmbcPayDetail.CS_OPERATOR;
		__column_names[28] = BaseCmbcPayDetail.CS_STATUS;
		__column_names[29] = BaseCmbcPayDetail.CS_ERROR_MSG;
		__column_names[30] = BaseCmbcPayDetail.CS_BUSCOD;
		__column_names[31] = BaseCmbcPayDetail.CS_BUSMOD;
		__column_names[32] = BaseCmbcPayDetail.CS_EACCTY;
		__column_names[33] = BaseCmbcPayDetail.CS_TRSTYP;
		__column_names[34] = BaseCmbcPayDetail.CS_TRSTYP_NAME;
		__column_names[35] = BaseCmbcPayDetail.CS_CMBC_PAYMENT_ID;
		__column_names[36] = BaseCmbcPayDetail.CS_OBJECT_ID;
		__column_names[37] = BaseCmbcPayDetail.CS_OBJECT_TYPE;
		__column_names[38] = BaseCmbcPayDetail.CS_OPRDAT;
		__column_names[39] = BaseCmbcPayDetail.CS_WITHDRAW_FLAG;
		__column_names[40] = BaseCmbcPayDetail.CS_WITHDRAW_ORIGIN_ID;
		__column_names[41] = BaseCmbcPayDetail.CS_WITHDRAW_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCmbcPayDetail b) {
		clear();
		setCmbcPayDetailIdClear(b.getCmbcPayDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getCmbcPayDetailId() == null;
	}

	@Override
	public BaseCmbcPayDetail generateBase(){
		BaseCmbcPayDetail b = new BaseCmbcPayDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCmbcPayDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCmbcPayDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYurref(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEptdat(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDbtacc(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDbtbbk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrsamt(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCcynbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStlchn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNusage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusnar(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCrtacc(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCrtnam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBrdnbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBnkflg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCrtbnk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCtycod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCrtpvc(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCrtcty(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCrtbbk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setErrorMsg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBuscod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusmod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEaccty(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrstyp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrstypName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCmbcPaymentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOprdat(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setWithdrawFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWithdrawOriginId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWithdrawStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCmbcPayDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCmbcPayDetailId();
		buff[count++] = b.getType();
		buff[count++] = b.getYurref();
		buff[count++] = generateTimestampFromDate(b.getEptdat());
		buff[count++] = b.getDbtacc();
		buff[count++] = b.getDbtbbk();
		buff[count++] = b.getTrsamt();
		buff[count++] = b.getCcynbr();
		buff[count++] = b.getStlchn();
		buff[count++] = b.getNusage();
		buff[count++] = b.getBusnar();
		buff[count++] = b.getCrtacc();
		buff[count++] = b.getCrtnam();
		buff[count++] = b.getBrdnbr();
		buff[count++] = b.getBnkflg();
		buff[count++] = b.getCrtbnk();
		buff[count++] = b.getCtycod();
		buff[count++] = b.getCrtpvc();
		buff[count++] = b.getCrtcty();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getTotalNum();
		buff[count++] = b.getCrtbbk();
		buff[count++] = b.getReimbursementPackageSummaryId();
		buff[count++] = b.getReimbursementPackageId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOperator();
		buff[count++] = b.getStatus();
		buff[count++] = b.getErrorMsg();
		buff[count++] = b.getBuscod();
		buff[count++] = b.getBusmod();
		buff[count++] = b.getEaccty();
		buff[count++] = b.getTrstyp();
		buff[count++] = b.getTrstypName();
		buff[count++] = b.getCmbcPaymentId();
		buff[count++] = b.getObjectId();
		buff[count++] = b.getObjectType();
		buff[count++] = generateTimestampFromDate(b.getOprdat());
		buff[count++] = b.getWithdrawFlag();
		buff[count++] = b.getWithdrawOriginId();
		buff[count++] = b.getWithdrawStatus();
	}

	@Override
	public void setDataFromBase(BaseCmbcPayDetail b){
		if(b.getCmbcPayDetailId() != null) setCmbcPayDetailIdClear(b.getCmbcPayDetailId());
		if(b.getType() != null) setType(b.getType());
		if(b.getYurref() != null) setYurref(b.getYurref());
		if(b.getEptdat() != null) setEptdat(b.getEptdat());
		if(b.getDbtacc() != null) setDbtacc(b.getDbtacc());
		if(b.getDbtbbk() != null) setDbtbbk(b.getDbtbbk());
		if(b.getTrsamt() != null) setTrsamt(b.getTrsamt());
		if(b.getCcynbr() != null) setCcynbr(b.getCcynbr());
		if(b.getStlchn() != null) setStlchn(b.getStlchn());
		if(b.getNusage() != null) setNusage(b.getNusage());
		if(b.getBusnar() != null) setBusnar(b.getBusnar());
		if(b.getCrtacc() != null) setCrtacc(b.getCrtacc());
		if(b.getCrtnam() != null) setCrtnam(b.getCrtnam());
		if(b.getBrdnbr() != null) setBrdnbr(b.getBrdnbr());
		if(b.getBnkflg() != null) setBnkflg(b.getBnkflg());
		if(b.getCrtbnk() != null) setCrtbnk(b.getCrtbnk());
		if(b.getCtycod() != null) setCtycod(b.getCtycod());
		if(b.getCrtpvc() != null) setCrtpvc(b.getCrtpvc());
		if(b.getCrtcty() != null) setCrtcty(b.getCrtcty());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getTotalNum() != null) setTotalNum(b.getTotalNum());
		if(b.getCrtbbk() != null) setCrtbbk(b.getCrtbbk());
		if(b.getReimbursementPackageSummaryId() != null) setReimbursementPackageSummaryId(b.getReimbursementPackageSummaryId());
		if(b.getReimbursementPackageId() != null) setReimbursementPackageId(b.getReimbursementPackageId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getErrorMsg() != null) setErrorMsg(b.getErrorMsg());
		if(b.getBuscod() != null) setBuscod(b.getBuscod());
		if(b.getBusmod() != null) setBusmod(b.getBusmod());
		if(b.getEaccty() != null) setEaccty(b.getEaccty());
		if(b.getTrstyp() != null) setTrstyp(b.getTrstyp());
		if(b.getTrstypName() != null) setTrstypName(b.getTrstypName());
		if(b.getCmbcPaymentId() != null) setCmbcPaymentId(b.getCmbcPaymentId());
		if(b.getObjectId() != null) setObjectId(b.getObjectId());
		if(b.getObjectType() != null) setObjectType(b.getObjectType());
		if(b.getOprdat() != null) setOprdat(b.getOprdat());
		if(b.getWithdrawFlag() != null) setWithdrawFlag(b.getWithdrawFlag());
		if(b.getWithdrawOriginId() != null) setWithdrawOriginId(b.getWithdrawOriginId());
		if(b.getWithdrawStatus() != null) setWithdrawStatus(b.getWithdrawStatus());
	}

	@Override
	public BaseCmbcPayDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCmbcPayDetail b = new BaseCmbcPayDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCmbcPayDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcPayDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYurref(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEptdat(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDbtacc(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDbtbbk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrsamt(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCcynbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStlchn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNusage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusnar(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCrtacc(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCrtnam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBrdnbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBnkflg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCrtbnk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCtycod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCrtpvc(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCrtcty(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCrtbbk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setErrorMsg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBuscod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusmod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEaccty(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrstyp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrstypName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcPaymentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOprdat(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithdrawFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithdrawOriginId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithdrawStatus(GenericBase.__getInt(val));
	}

	public void setCmbcPayDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCmbcPayDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCmbcPayDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYurref(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getYurref() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEptdat(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getEptdat() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setDbtacc(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getDbtacc() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDbtbbk(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getDbtbbk() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setTrsamt(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTrsamt() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setCcynbr(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getCcynbr() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setStlchn(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getStlchn() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setNusage(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getNusage() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setBusnar(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getBusnar() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setCrtacc(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getCrtacc() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setCrtnam(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getCrtnam() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setBrdnbr(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getBrdnbr() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setBnkflg(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getBnkflg() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setCrtbnk(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getCrtbnk() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setCtycod(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getCtycod() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setCrtpvc(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getCrtpvc() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setCrtcty(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getCrtcty() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setProvince(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getProvince() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setCity(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getCity() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setTotalNum(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getTotalNum() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setCrtbbk(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getCrtbbk() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setReimbursementPackageSummaryId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setReimbursementPackageId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getReimbursementPackageId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(26, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[26]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setErrorMsg(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getErrorMsg() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setBuscod(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getBuscod() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setBusmod(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getBusmod() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setEaccty(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getEaccty() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setTrstyp(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getTrstyp() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setTrstypName(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getTrstypName() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setCmbcPaymentId(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getCmbcPaymentId() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setObjectId(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getObjectId() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setObjectType(java.lang.Integer val) {
		setCurrentData(37, val);
	}

	public java.lang.Integer getObjectType() {
		return GenericBase.__getInt(__current_data[37]);
	}

	public void setOprdat(java.util.Date val) {
		setCurrentData(38, generateTimestampFromDate(val));
	}

	public java.util.Date getOprdat() {
		return GenericBase.__getDateFromSQL(__current_data[38]);
	}

	public void setWithdrawFlag(java.lang.Integer val) {
		setCurrentData(39, val);
	}

	public java.lang.Integer getWithdrawFlag() {
		return GenericBase.__getInt(__current_data[39]);
	}

	public void setWithdrawOriginId(java.lang.Integer val) {
		setCurrentData(40, val);
	}

	public java.lang.Integer getWithdrawOriginId() {
		return GenericBase.__getInt(__current_data[40]);
	}

	public void setWithdrawStatus(java.lang.Integer val) {
		setCurrentData(41, val);
	}

	public java.lang.Integer getWithdrawStatus() {
		return GenericBase.__getInt(__current_data[41]);
	}

	public void setConditionCmbcPayDetailId(String op, java.lang.Integer val) {
		setConditionCmbcPayDetailId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcPayDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCmbcPayDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYurref(String op, java.lang.String val) {
		setConditionYurref(op, val, CONDITION_AND);
	}

	public void setConditionYurref(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYurref(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEptdat(String op, java.util.Date val) {
		setConditionEptdat(op, val, CONDITION_AND);
	}

	public void setConditionEptdat(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEptdat(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDbtacc(String op, java.lang.String val) {
		setConditionDbtacc(op, val, CONDITION_AND);
	}

	public void setConditionDbtacc(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDbtacc(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDbtbbk(String op, java.lang.String val) {
		setConditionDbtbbk(op, val, CONDITION_AND);
	}

	public void setConditionDbtbbk(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDbtbbk(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTrsamt(String op, java.math.BigDecimal val) {
		setConditionTrsamt(op, val, CONDITION_AND);
	}

	public void setConditionTrsamt(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTrsamt(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCcynbr(String op, java.lang.String val) {
		setConditionCcynbr(op, val, CONDITION_AND);
	}

	public void setConditionCcynbr(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCcynbr(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStlchn(String op, java.lang.String val) {
		setConditionStlchn(op, val, CONDITION_AND);
	}

	public void setConditionStlchn(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStlchn(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionNusage(String op, java.lang.String val) {
		setConditionNusage(op, val, CONDITION_AND);
	}

	public void setConditionNusage(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectNusage(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBusnar(String op, java.lang.String val) {
		setConditionBusnar(op, val, CONDITION_AND);
	}

	public void setConditionBusnar(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBusnar(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCrtacc(String op, java.lang.String val) {
		setConditionCrtacc(op, val, CONDITION_AND);
	}

	public void setConditionCrtacc(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCrtacc(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCrtnam(String op, java.lang.String val) {
		setConditionCrtnam(op, val, CONDITION_AND);
	}

	public void setConditionCrtnam(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCrtnam(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionBrdnbr(String op, java.lang.String val) {
		setConditionBrdnbr(op, val, CONDITION_AND);
	}

	public void setConditionBrdnbr(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectBrdnbr(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionBnkflg(String op, java.lang.String val) {
		setConditionBnkflg(op, val, CONDITION_AND);
	}

	public void setConditionBnkflg(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectBnkflg(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCrtbnk(String op, java.lang.String val) {
		setConditionCrtbnk(op, val, CONDITION_AND);
	}

	public void setConditionCrtbnk(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectCrtbnk(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCtycod(String op, java.lang.String val) {
		setConditionCtycod(op, val, CONDITION_AND);
	}

	public void setConditionCtycod(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCtycod(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCrtpvc(String op, java.lang.String val) {
		setConditionCrtpvc(op, val, CONDITION_AND);
	}

	public void setConditionCrtpvc(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCrtpvc(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCrtcty(String op, java.lang.String val) {
		setConditionCrtcty(op, val, CONDITION_AND);
	}

	public void setConditionCrtcty(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectCrtcty(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionProvince(String op, java.lang.Integer val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCity(String op, java.lang.Integer val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionTotalNum(String op, java.lang.Integer val) {
		setConditionTotalNum(op, val, CONDITION_AND);
	}

	public void setConditionTotalNum(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectTotalNum(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionCrtbbk(String op, java.lang.String val) {
		setConditionCrtbbk(op, val, CONDITION_AND);
	}

	public void setConditionCrtbbk(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectCrtbbk(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionReimbursementPackageSummaryId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageSummaryId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageSummaryId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectReimbursementPackageSummaryId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectReimbursementPackageId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(26, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionErrorMsg(String op, java.lang.String val) {
		setConditionErrorMsg(op, val, CONDITION_AND);
	}

	public void setConditionErrorMsg(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectErrorMsg(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionBuscod(String op, java.lang.String val) {
		setConditionBuscod(op, val, CONDITION_AND);
	}

	public void setConditionBuscod(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectBuscod(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionBusmod(String op, java.lang.String val) {
		setConditionBusmod(op, val, CONDITION_AND);
	}

	public void setConditionBusmod(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectBusmod(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionEaccty(String op, java.lang.String val) {
		setConditionEaccty(op, val, CONDITION_AND);
	}

	public void setConditionEaccty(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectEaccty(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionTrstyp(String op, java.lang.String val) {
		setConditionTrstyp(op, val, CONDITION_AND);
	}

	public void setConditionTrstyp(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectTrstyp(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionTrstypName(String op, java.lang.String val) {
		setConditionTrstypName(op, val, CONDITION_AND);
	}

	public void setConditionTrstypName(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectTrstypName(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionCmbcPaymentId(String op, java.lang.Integer val) {
		setConditionCmbcPaymentId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcPaymentId(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectCmbcPaymentId(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionObjectId(String op, java.lang.Integer val) {
		setConditionObjectId(op, val, CONDITION_AND);
	}

	public void setConditionObjectId(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectObjectId(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionObjectType(String op, java.lang.Integer val) {
		setConditionObjectType(op, val, CONDITION_AND);
	}

	public void setConditionObjectType(String op, java.lang.Integer val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectObjectType(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionOprdat(String op, java.util.Date val) {
		setConditionOprdat(op, val, CONDITION_AND);
	}

	public void setConditionOprdat(String op, java.util.Date val, String relation) {
		addCondition(38, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOprdat(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionWithdrawFlag(String op, java.lang.Integer val) {
		setConditionWithdrawFlag(op, val, CONDITION_AND);
	}

	public void setConditionWithdrawFlag(String op, java.lang.Integer val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectWithdrawFlag(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionWithdrawOriginId(String op, java.lang.Integer val) {
		setConditionWithdrawOriginId(op, val, CONDITION_AND);
	}

	public void setConditionWithdrawOriginId(String op, java.lang.Integer val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectWithdrawOriginId(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionWithdrawStatus(String op, java.lang.Integer val) {
		setConditionWithdrawStatus(op, val, CONDITION_AND);
	}

	public void setConditionWithdrawStatus(String op, java.lang.Integer val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectWithdrawStatus(boolean val) {
		__select_flags[41] = val;
	}


}

