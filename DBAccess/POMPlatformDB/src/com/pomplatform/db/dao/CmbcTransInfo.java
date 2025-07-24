package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCmbcTransInfo;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CmbcTransInfo extends AbstractTable<BaseCmbcTransInfo>
{

	public CmbcTransInfo() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 39;

		initTables();

		__tableName            = "cmbc_trans_info";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCmbcTransInfo.CS_CMBC_TRANS_INFO_ID;
		__column_names[1] = BaseCmbcTransInfo.CS_BANK_ACCOUNT;
		__column_names[2] = BaseCmbcTransInfo.CS_ETYDAT;
		__column_names[3] = BaseCmbcTransInfo.CS_ETYTIM;
		__column_names[4] = BaseCmbcTransInfo.CS_TRANS_DATE;
		__column_names[5] = BaseCmbcTransInfo.CS_VLTDAT;
		__column_names[6] = BaseCmbcTransInfo.CS_TRSCOD;
		__column_names[7] = BaseCmbcTransInfo.CS_NARYUR;
		__column_names[8] = BaseCmbcTransInfo.CS_TRSAMTD;
		__column_names[9] = BaseCmbcTransInfo.CS_TRSAMTC;
		__column_names[10] = BaseCmbcTransInfo.CS_AMTCDR;
		__column_names[11] = BaseCmbcTransInfo.CS_TRSBLV;
		__column_names[12] = BaseCmbcTransInfo.CS_REFNBR;
		__column_names[13] = BaseCmbcTransInfo.CS_REQNBR;
		__column_names[14] = BaseCmbcTransInfo.CS_BUSNAM;
		__column_names[15] = BaseCmbcTransInfo.CS_NUSAGE;
		__column_names[16] = BaseCmbcTransInfo.CS_YURREF;
		__column_names[17] = BaseCmbcTransInfo.CS_BUSNAR;
		__column_names[18] = BaseCmbcTransInfo.CS_OTRNAR;
		__column_names[19] = BaseCmbcTransInfo.CS_C_RPYBBK;
		__column_names[20] = BaseCmbcTransInfo.CS_RPYNAM;
		__column_names[21] = BaseCmbcTransInfo.CS_RPYACC;
		__column_names[22] = BaseCmbcTransInfo.CS_RPYBBN;
		__column_names[23] = BaseCmbcTransInfo.CS_RPYBNK;
		__column_names[24] = BaseCmbcTransInfo.CS_RPYADR;
		__column_names[25] = BaseCmbcTransInfo.CS_C_GSBBBK;
		__column_names[26] = BaseCmbcTransInfo.CS_GSBACC;
		__column_names[27] = BaseCmbcTransInfo.CS_GSBNAM;
		__column_names[28] = BaseCmbcTransInfo.CS_INFFLG;
		__column_names[29] = BaseCmbcTransInfo.CS_ATHFLG;
		__column_names[30] = BaseCmbcTransInfo.CS_CHKNBR;
		__column_names[31] = BaseCmbcTransInfo.CS_RSVFLG;
		__column_names[32] = BaseCmbcTransInfo.CS_NAREXT;
		__column_names[33] = BaseCmbcTransInfo.CS_TRSANL;
		__column_names[34] = BaseCmbcTransInfo.CS_REFSUB;
		__column_names[35] = BaseCmbcTransInfo.CS_FRMCOD;
		__column_names[36] = BaseCmbcTransInfo.CS_CREATE_TIME;
		__column_names[37] = BaseCmbcTransInfo.CS_UPDATE_TIME;
		__column_names[38] = BaseCmbcTransInfo.CS_TRANS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCmbcTransInfo b) {
		clear();
		setCmbcTransInfoIdClear(b.getCmbcTransInfoId());
	}

	public boolean isPrimaryKeyNull() {
		return getCmbcTransInfoId() == null;
	}

	@Override
	public BaseCmbcTransInfo generateBase(){
		BaseCmbcTransInfo b = new BaseCmbcTransInfo();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCmbcTransInfo b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCmbcTransInfoId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEtydat(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEtytim(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setVltdat(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTrscod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNaryur(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrsamtd(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTrsamtc(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAmtcdr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrsblv(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRefnbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReqnbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusnam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNusage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYurref(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusnar(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtrnar(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCRpybbk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRpynam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRpyacc(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRpybbn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRpybnk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRpyadr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCGsbbbk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGsbacc(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGsbnam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInfflg(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAthflg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setChknbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRsvflg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNarext(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrsanl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRefsub(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFrmcod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTransType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCmbcTransInfo b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCmbcTransInfoId();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getEtydat();
		buff[count++] = b.getEtytim();
		buff[count++] = generateTimestampFromDate(b.getTransDate());
		buff[count++] = generateTimestampFromDate(b.getVltdat());
		buff[count++] = b.getTrscod();
		buff[count++] = b.getNaryur();
		buff[count++] = b.getTrsamtd();
		buff[count++] = b.getTrsamtc();
		buff[count++] = b.getAmtcdr();
		buff[count++] = b.getTrsblv();
		buff[count++] = b.getRefnbr();
		buff[count++] = b.getReqnbr();
		buff[count++] = b.getBusnam();
		buff[count++] = b.getNusage();
		buff[count++] = b.getYurref();
		buff[count++] = b.getBusnar();
		buff[count++] = b.getOtrnar();
		buff[count++] = b.getCRpybbk();
		buff[count++] = b.getRpynam();
		buff[count++] = b.getRpyacc();
		buff[count++] = b.getRpybbn();
		buff[count++] = b.getRpybnk();
		buff[count++] = b.getRpyadr();
		buff[count++] = b.getCGsbbbk();
		buff[count++] = b.getGsbacc();
		buff[count++] = b.getGsbnam();
		buff[count++] = b.getInfflg();
		buff[count++] = b.getAthflg();
		buff[count++] = b.getChknbr();
		buff[count++] = b.getRsvflg();
		buff[count++] = b.getNarext();
		buff[count++] = b.getTrsanl();
		buff[count++] = b.getRefsub();
		buff[count++] = b.getFrmcod();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getTransType();
	}

	@Override
	public void setDataFromBase(BaseCmbcTransInfo b){
		if(b.getCmbcTransInfoId() != null) setCmbcTransInfoIdClear(b.getCmbcTransInfoId());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getEtydat() != null) setEtydat(b.getEtydat());
		if(b.getEtytim() != null) setEtytim(b.getEtytim());
		if(b.getTransDate() != null) setTransDate(b.getTransDate());
		if(b.getVltdat() != null) setVltdat(b.getVltdat());
		if(b.getTrscod() != null) setTrscod(b.getTrscod());
		if(b.getNaryur() != null) setNaryur(b.getNaryur());
		if(b.getTrsamtd() != null) setTrsamtd(b.getTrsamtd());
		if(b.getTrsamtc() != null) setTrsamtc(b.getTrsamtc());
		if(b.getAmtcdr() != null) setAmtcdr(b.getAmtcdr());
		if(b.getTrsblv() != null) setTrsblv(b.getTrsblv());
		if(b.getRefnbr() != null) setRefnbr(b.getRefnbr());
		if(b.getReqnbr() != null) setReqnbr(b.getReqnbr());
		if(b.getBusnam() != null) setBusnam(b.getBusnam());
		if(b.getNusage() != null) setNusage(b.getNusage());
		if(b.getYurref() != null) setYurref(b.getYurref());
		if(b.getBusnar() != null) setBusnar(b.getBusnar());
		if(b.getOtrnar() != null) setOtrnar(b.getOtrnar());
		if(b.getCRpybbk() != null) setCRpybbk(b.getCRpybbk());
		if(b.getRpynam() != null) setRpynam(b.getRpynam());
		if(b.getRpyacc() != null) setRpyacc(b.getRpyacc());
		if(b.getRpybbn() != null) setRpybbn(b.getRpybbn());
		if(b.getRpybnk() != null) setRpybnk(b.getRpybnk());
		if(b.getRpyadr() != null) setRpyadr(b.getRpyadr());
		if(b.getCGsbbbk() != null) setCGsbbbk(b.getCGsbbbk());
		if(b.getGsbacc() != null) setGsbacc(b.getGsbacc());
		if(b.getGsbnam() != null) setGsbnam(b.getGsbnam());
		if(b.getInfflg() != null) setInfflg(b.getInfflg());
		if(b.getAthflg() != null) setAthflg(b.getAthflg());
		if(b.getChknbr() != null) setChknbr(b.getChknbr());
		if(b.getRsvflg() != null) setRsvflg(b.getRsvflg());
		if(b.getNarext() != null) setNarext(b.getNarext());
		if(b.getTrsanl() != null) setTrsanl(b.getTrsanl());
		if(b.getRefsub() != null) setRefsub(b.getRefsub());
		if(b.getFrmcod() != null) setFrmcod(b.getFrmcod());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getTransType() != null) setTransType(b.getTransType());
	}

	@Override
	public BaseCmbcTransInfo generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCmbcTransInfo b = new BaseCmbcTransInfo();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCmbcTransInfo __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcTransInfoId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEtydat(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEtytim(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVltdat(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrscod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNaryur(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrsamtd(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrsamtc(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmtcdr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrsblv(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRefnbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReqnbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusnam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNusage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYurref(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusnar(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtrnar(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCRpybbk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRpynam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRpyacc(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRpybbn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRpybnk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRpyadr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCGsbbbk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGsbacc(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGsbnam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfflg(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAthflg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChknbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRsvflg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNarext(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrsanl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRefsub(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFrmcod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransType(GenericBase.__getInt(val));
	}

	public void setCmbcTransInfoId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCmbcTransInfoId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCmbcTransInfoIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEtydat(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEtydat() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEtytim(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEtytim() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTransDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getTransDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setVltdat(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getVltdat() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setTrscod(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getTrscod() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setNaryur(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getNaryur() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setTrsamtd(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getTrsamtd() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setTrsamtc(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getTrsamtc() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setAmtcdr(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getAmtcdr() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setTrsblv(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getTrsblv() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setRefnbr(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRefnbr() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setReqnbr(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getReqnbr() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setBusnam(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getBusnam() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setNusage(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getNusage() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setYurref(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getYurref() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setBusnar(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getBusnar() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setOtrnar(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getOtrnar() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setCRpybbk(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getCRpybbk() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setRpynam(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getRpynam() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setRpyacc(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getRpyacc() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setRpybbn(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getRpybbn() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setRpybnk(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getRpybnk() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setRpyadr(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getRpyadr() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setCGsbbbk(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getCGsbbbk() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setGsbacc(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getGsbacc() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setGsbnam(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getGsbnam() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setInfflg(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getInfflg() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setAthflg(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getAthflg() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setChknbr(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getChknbr() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setRsvflg(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getRsvflg() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setNarext(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getNarext() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setTrsanl(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getTrsanl() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setRefsub(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getRefsub() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setFrmcod(java.lang.String val) {
		setCurrentData(35, val);
	}

	public java.lang.String getFrmcod() {
		return GenericBase.__getString(__current_data[35]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(36, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[36]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(37, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[37]);
	}

	public void setTransType(java.lang.Integer val) {
		setCurrentData(38, val);
	}

	public java.lang.Integer getTransType() {
		return GenericBase.__getInt(__current_data[38]);
	}

	public void setConditionCmbcTransInfoId(String op, java.lang.Integer val) {
		setConditionCmbcTransInfoId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcTransInfoId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCmbcTransInfoId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEtydat(String op, java.lang.String val) {
		setConditionEtydat(op, val, CONDITION_AND);
	}

	public void setConditionEtydat(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEtydat(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEtytim(String op, java.lang.String val) {
		setConditionEtytim(op, val, CONDITION_AND);
	}

	public void setConditionEtytim(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEtytim(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTransDate(String op, java.util.Date val) {
		setConditionTransDate(op, val, CONDITION_AND);
	}

	public void setConditionTransDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTransDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionVltdat(String op, java.util.Date val) {
		setConditionVltdat(op, val, CONDITION_AND);
	}

	public void setConditionVltdat(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectVltdat(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTrscod(String op, java.lang.String val) {
		setConditionTrscod(op, val, CONDITION_AND);
	}

	public void setConditionTrscod(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTrscod(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionNaryur(String op, java.lang.String val) {
		setConditionNaryur(op, val, CONDITION_AND);
	}

	public void setConditionNaryur(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectNaryur(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTrsamtd(String op, java.math.BigDecimal val) {
		setConditionTrsamtd(op, val, CONDITION_AND);
	}

	public void setConditionTrsamtd(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTrsamtd(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTrsamtc(String op, java.math.BigDecimal val) {
		setConditionTrsamtc(op, val, CONDITION_AND);
	}

	public void setConditionTrsamtc(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTrsamtc(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAmtcdr(String op, java.lang.String val) {
		setConditionAmtcdr(op, val, CONDITION_AND);
	}

	public void setConditionAmtcdr(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAmtcdr(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTrsblv(String op, java.math.BigDecimal val) {
		setConditionTrsblv(op, val, CONDITION_AND);
	}

	public void setConditionTrsblv(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTrsblv(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRefnbr(String op, java.lang.String val) {
		setConditionRefnbr(op, val, CONDITION_AND);
	}

	public void setConditionRefnbr(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRefnbr(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionReqnbr(String op, java.lang.String val) {
		setConditionReqnbr(op, val, CONDITION_AND);
	}

	public void setConditionReqnbr(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectReqnbr(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionBusnam(String op, java.lang.String val) {
		setConditionBusnam(op, val, CONDITION_AND);
	}

	public void setConditionBusnam(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectBusnam(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionNusage(String op, java.lang.String val) {
		setConditionNusage(op, val, CONDITION_AND);
	}

	public void setConditionNusage(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectNusage(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionYurref(String op, java.lang.String val) {
		setConditionYurref(op, val, CONDITION_AND);
	}

	public void setConditionYurref(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectYurref(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionBusnar(String op, java.lang.String val) {
		setConditionBusnar(op, val, CONDITION_AND);
	}

	public void setConditionBusnar(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectBusnar(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionOtrnar(String op, java.lang.String val) {
		setConditionOtrnar(op, val, CONDITION_AND);
	}

	public void setConditionOtrnar(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectOtrnar(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCRpybbk(String op, java.lang.String val) {
		setConditionCRpybbk(op, val, CONDITION_AND);
	}

	public void setConditionCRpybbk(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectCRpybbk(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionRpynam(String op, java.lang.String val) {
		setConditionRpynam(op, val, CONDITION_AND);
	}

	public void setConditionRpynam(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectRpynam(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionRpyacc(String op, java.lang.String val) {
		setConditionRpyacc(op, val, CONDITION_AND);
	}

	public void setConditionRpyacc(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectRpyacc(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionRpybbn(String op, java.lang.String val) {
		setConditionRpybbn(op, val, CONDITION_AND);
	}

	public void setConditionRpybbn(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectRpybbn(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionRpybnk(String op, java.lang.String val) {
		setConditionRpybnk(op, val, CONDITION_AND);
	}

	public void setConditionRpybnk(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectRpybnk(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionRpyadr(String op, java.lang.String val) {
		setConditionRpyadr(op, val, CONDITION_AND);
	}

	public void setConditionRpyadr(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectRpyadr(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionCGsbbbk(String op, java.lang.String val) {
		setConditionCGsbbbk(op, val, CONDITION_AND);
	}

	public void setConditionCGsbbbk(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectCGsbbbk(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionGsbacc(String op, java.lang.String val) {
		setConditionGsbacc(op, val, CONDITION_AND);
	}

	public void setConditionGsbacc(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectGsbacc(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionGsbnam(String op, java.lang.String val) {
		setConditionGsbnam(op, val, CONDITION_AND);
	}

	public void setConditionGsbnam(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectGsbnam(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionInfflg(String op, java.lang.Integer val) {
		setConditionInfflg(op, val, CONDITION_AND);
	}

	public void setConditionInfflg(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectInfflg(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionAthflg(String op, java.lang.String val) {
		setConditionAthflg(op, val, CONDITION_AND);
	}

	public void setConditionAthflg(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectAthflg(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionChknbr(String op, java.lang.String val) {
		setConditionChknbr(op, val, CONDITION_AND);
	}

	public void setConditionChknbr(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectChknbr(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionRsvflg(String op, java.lang.String val) {
		setConditionRsvflg(op, val, CONDITION_AND);
	}

	public void setConditionRsvflg(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectRsvflg(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionNarext(String op, java.lang.String val) {
		setConditionNarext(op, val, CONDITION_AND);
	}

	public void setConditionNarext(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectNarext(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionTrsanl(String op, java.lang.String val) {
		setConditionTrsanl(op, val, CONDITION_AND);
	}

	public void setConditionTrsanl(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectTrsanl(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionRefsub(String op, java.lang.String val) {
		setConditionRefsub(op, val, CONDITION_AND);
	}

	public void setConditionRefsub(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectRefsub(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionFrmcod(String op, java.lang.String val) {
		setConditionFrmcod(op, val, CONDITION_AND);
	}

	public void setConditionFrmcod(String op, java.lang.String val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectFrmcod(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(36, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(37, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionTransType(String op, java.lang.Integer val) {
		setConditionTransType(op, val, CONDITION_AND);
	}

	public void setConditionTransType(String op, java.lang.Integer val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectTransType(boolean val) {
		__select_flags[38] = val;
	}


}

