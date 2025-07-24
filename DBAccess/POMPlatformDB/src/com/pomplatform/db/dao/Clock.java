package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseClock;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Clock extends AbstractTable<BaseClock>
{

	public Clock() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 55;

		initTables();

		__tableName            = "clocks";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseClock.CS_CLOCK_ID;
		__column_names[1] = BaseClock.CS_SN;
		__column_names[2] = BaseClock.CS_CLOCK_TYPE_ID;
		__column_names[3] = BaseClock.CS_FW_VERSION;
		__column_names[4] = BaseClock.CS_DEVICE_NAME;
		__column_names[5] = BaseClock.CS_ALIAS;
		__column_names[6] = BaseClock.CS_FP_COUNT;
		__column_names[7] = BaseClock.CS_USER_COUNT;
		__column_names[8] = BaseClock.CS_MAX_USER_COUNT;
		__column_names[9] = BaseClock.CS_MAX_FINGER_COUNT;
		__column_names[10] = BaseClock.CS_MAX_ATTLOG_COUNT;
		__column_names[11] = BaseClock.CS_MAX_COMM_SIZE;
		__column_names[12] = BaseClock.CS_MAX_COMM_COUNT;
		__column_names[13] = BaseClock.CS_FLASH_SIZE;
		__column_names[14] = BaseClock.CS_FREE_FLASH_SIZE;
		__column_names[15] = BaseClock.CS_LANGUAGE;
		__column_names[16] = BaseClock.CS_LNG_ENCODE;
		__column_names[17] = BaseClock.CS_VOLUME;
		__column_names[18] = BaseClock.CS_PLATFORM;
		__column_names[19] = BaseClock.CS_BRIGHTNESS;
		__column_names[20] = BaseClock.CS_OEM_VENDOR;
		__column_names[21] = BaseClock.CS_CITY;
		__column_names[22] = BaseClock.CS_AGENT_IPADDRESS;
		__column_names[23] = BaseClock.CS_IPADDRESS;
		__column_names[24] = BaseClock.CS_IP_PORT;
		__column_names[25] = BaseClock.CS_COM_PORT;
		__column_names[26] = BaseClock.CS_BAUDRATE;
		__column_names[27] = BaseClock.CS_COM_ADDRESS;
		__column_names[28] = BaseClock.CS_COMM_PWD;
		__column_names[29] = BaseClock.CS_ACPANEL_TYPE;
		__column_names[30] = BaseClock.CS_SYNC_TIME;
		__column_names[31] = BaseClock.CS_MAIN_TIME;
		__column_names[32] = BaseClock.CS_TRANSACTION_COUNT;
		__column_names[33] = BaseClock.CS_LAST_ACTIVITY;
		__column_names[34] = BaseClock.CS_TRANS_TIMES;
		__column_names[35] = BaseClock.CS_TRANS_INTERVAL;
		__column_names[36] = BaseClock.CS_LOG_STAMP;
		__column_names[37] = BaseClock.CS_OPLOG_STAMP;
		__column_names[38] = BaseClock.CS_PHOTO_STAMP;
		__column_names[39] = BaseClock.CS_FPVERSION;
		__column_names[40] = BaseClock.CS_ENABLED;
		__column_names[41] = BaseClock.CS_REALTIME;
		__column_names[42] = BaseClock.CS_DELAY;
		__column_names[43] = BaseClock.CS_DSTIME_ID;
		__column_names[44] = BaseClock.CS_UPDATE_DB;
		__column_names[45] = BaseClock.CS_CHANGE_OPERATOR;
		__column_names[46] = BaseClock.CS_CHANGE_TIME;
		__column_names[47] = BaseClock.CS_CREATE_OPERATOR;
		__column_names[48] = BaseClock.CS_CREATE_TIME;
		__column_names[49] = BaseClock.CS_DELETE_OPERATOR;
		__column_names[50] = BaseClock.CS_DELETE_TIME;
		__column_names[51] = BaseClock.CS_STATUS;
		__column_names[52] = BaseClock.CS_TZADJ;
		__column_names[53] = BaseClock.CS_ENCRYPT;
		__column_names[54] = BaseClock.CS_IS_ENABLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseClock b) {
		clear();
		setClockIdClear(b.getClockId());
	}

	public boolean isPrimaryKeyNull() {
		return getClockId() == null;
	}

	@Override
	public BaseClock generateBase(){
		BaseClock b = new BaseClock();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseClock b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setClockId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClockTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFwVersion(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeviceName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlias(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFpCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaxUserCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaxFingerCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaxAttlogCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaxCommSize(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaxCommCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlashSize(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFreeFlashSize(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLanguage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLngEncode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setVolume(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlatform(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBrightness(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOemVendor(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAgentIpaddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIpaddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIpPort(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setComPort(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBaudrate(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setComAddress(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCommPwd(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAcpanelType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSyncTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransactionCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLastActivity(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTransTimes(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransInterval(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLogStamp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOplogStamp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPhotoStamp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFpversion(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRealtime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDelay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDstimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUpdateDb(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setChangeOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setChangeTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setTzadj(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setEncrypt(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseClock b, Object[] buff){
		int count = 0;
		buff[count++] = b.getClockId();
		buff[count++] = b.getSn();
		buff[count++] = b.getClockTypeId();
		buff[count++] = b.getFwVersion();
		buff[count++] = b.getDeviceName();
		buff[count++] = b.getAlias();
		buff[count++] = b.getFpCount();
		buff[count++] = b.getUserCount();
		buff[count++] = b.getMaxUserCount();
		buff[count++] = b.getMaxFingerCount();
		buff[count++] = b.getMaxAttlogCount();
		buff[count++] = b.getMaxCommSize();
		buff[count++] = b.getMaxCommCount();
		buff[count++] = b.getFlashSize();
		buff[count++] = b.getFreeFlashSize();
		buff[count++] = b.getLanguage();
		buff[count++] = b.getLngEncode();
		buff[count++] = b.getVolume();
		buff[count++] = b.getPlatform();
		buff[count++] = b.getBrightness();
		buff[count++] = b.getOemVendor();
		buff[count++] = b.getCity();
		buff[count++] = b.getAgentIpaddress();
		buff[count++] = b.getIpaddress();
		buff[count++] = b.getIpPort();
		buff[count++] = b.getComPort();
		buff[count++] = b.getBaudrate();
		buff[count++] = b.getComAddress();
		buff[count++] = b.getCommPwd();
		buff[count++] = b.getAcpanelType();
		buff[count++] = b.getSyncTime();
		buff[count++] = b.getMainTime();
		buff[count++] = b.getTransactionCount();
		buff[count++] = generateTimestampFromDate(b.getLastActivity());
		buff[count++] = b.getTransTimes();
		buff[count++] = b.getTransInterval();
		buff[count++] = b.getLogStamp();
		buff[count++] = b.getOplogStamp();
		buff[count++] = b.getPhotoStamp();
		buff[count++] = b.getFpversion();
		buff[count++] = b.getEnabled();
		buff[count++] = b.getRealtime();
		buff[count++] = b.getDelay();
		buff[count++] = b.getDstimeId();
		buff[count++] = b.getUpdateDb();
		buff[count++] = b.getChangeOperator();
		buff[count++] = generateTimestampFromDate(b.getChangeTime());
		buff[count++] = b.getCreateOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteOperator();
		buff[count++] = generateTimestampFromDate(b.getDeleteTime());
		buff[count++] = b.getStatus();
		buff[count++] = b.getTzadj();
		buff[count++] = b.getEncrypt();
		buff[count++] = b.getIsEnable();
	}

	@Override
	public void setDataFromBase(BaseClock b){
		if(b.getClockId() != null) setClockIdClear(b.getClockId());
		if(b.getSn() != null) setSn(b.getSn());
		if(b.getClockTypeId() != null) setClockTypeId(b.getClockTypeId());
		if(b.getFwVersion() != null) setFwVersion(b.getFwVersion());
		if(b.getDeviceName() != null) setDeviceName(b.getDeviceName());
		if(b.getAlias() != null) setAlias(b.getAlias());
		if(b.getFpCount() != null) setFpCount(b.getFpCount());
		if(b.getUserCount() != null) setUserCount(b.getUserCount());
		if(b.getMaxUserCount() != null) setMaxUserCount(b.getMaxUserCount());
		if(b.getMaxFingerCount() != null) setMaxFingerCount(b.getMaxFingerCount());
		if(b.getMaxAttlogCount() != null) setMaxAttlogCount(b.getMaxAttlogCount());
		if(b.getMaxCommSize() != null) setMaxCommSize(b.getMaxCommSize());
		if(b.getMaxCommCount() != null) setMaxCommCount(b.getMaxCommCount());
		if(b.getFlashSize() != null) setFlashSize(b.getFlashSize());
		if(b.getFreeFlashSize() != null) setFreeFlashSize(b.getFreeFlashSize());
		if(b.getLanguage() != null) setLanguage(b.getLanguage());
		if(b.getLngEncode() != null) setLngEncode(b.getLngEncode());
		if(b.getVolume() != null) setVolume(b.getVolume());
		if(b.getPlatform() != null) setPlatform(b.getPlatform());
		if(b.getBrightness() != null) setBrightness(b.getBrightness());
		if(b.getOemVendor() != null) setOemVendor(b.getOemVendor());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getAgentIpaddress() != null) setAgentIpaddress(b.getAgentIpaddress());
		if(b.getIpaddress() != null) setIpaddress(b.getIpaddress());
		if(b.getIpPort() != null) setIpPort(b.getIpPort());
		if(b.getComPort() != null) setComPort(b.getComPort());
		if(b.getBaudrate() != null) setBaudrate(b.getBaudrate());
		if(b.getComAddress() != null) setComAddress(b.getComAddress());
		if(b.getCommPwd() != null) setCommPwd(b.getCommPwd());
		if(b.getAcpanelType() != null) setAcpanelType(b.getAcpanelType());
		if(b.getSyncTime() != null) setSyncTime(b.getSyncTime());
		if(b.getMainTime() != null) setMainTime(b.getMainTime());
		if(b.getTransactionCount() != null) setTransactionCount(b.getTransactionCount());
		if(b.getLastActivity() != null) setLastActivity(b.getLastActivity());
		if(b.getTransTimes() != null) setTransTimes(b.getTransTimes());
		if(b.getTransInterval() != null) setTransInterval(b.getTransInterval());
		if(b.getLogStamp() != null) setLogStamp(b.getLogStamp());
		if(b.getOplogStamp() != null) setOplogStamp(b.getOplogStamp());
		if(b.getPhotoStamp() != null) setPhotoStamp(b.getPhotoStamp());
		if(b.getFpversion() != null) setFpversion(b.getFpversion());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
		if(b.getRealtime() != null) setRealtime(b.getRealtime());
		if(b.getDelay() != null) setDelay(b.getDelay());
		if(b.getDstimeId() != null) setDstimeId(b.getDstimeId());
		if(b.getUpdateDb() != null) setUpdateDb(b.getUpdateDb());
		if(b.getChangeOperator() != null) setChangeOperator(b.getChangeOperator());
		if(b.getChangeTime() != null) setChangeTime(b.getChangeTime());
		if(b.getCreateOperator() != null) setCreateOperator(b.getCreateOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteOperator() != null) setDeleteOperator(b.getDeleteOperator());
		if(b.getDeleteTime() != null) setDeleteTime(b.getDeleteTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getTzadj() != null) setTzadj(b.getTzadj());
		if(b.getEncrypt() != null) setEncrypt(b.getEncrypt());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
	}

	@Override
	public BaseClock generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseClock b = new BaseClock();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseClock __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClockId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClockTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFwVersion(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeviceName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlias(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFpCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxUserCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxFingerCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxAttlogCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxCommSize(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxCommCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlashSize(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFreeFlashSize(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLanguage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLngEncode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVolume(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlatform(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBrightness(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOemVendor(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgentIpaddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIpaddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIpPort(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComPort(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBaudrate(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComAddress(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommPwd(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAcpanelType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSyncTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransactionCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastActivity(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransTimes(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransInterval(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogStamp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOplogStamp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPhotoStamp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFpversion(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealtime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDelay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDstimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateDb(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTzadj(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEncrypt(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getInt(val));
	}

	public void setClockId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getClockId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setClockIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSn(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSn() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setClockTypeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getClockTypeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setFwVersion(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getFwVersion() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setDeviceName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getDeviceName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAlias(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getAlias() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setFpCount(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getFpCount() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setUserCount(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getUserCount() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setMaxUserCount(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMaxUserCount() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setMaxFingerCount(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getMaxFingerCount() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setMaxAttlogCount(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getMaxAttlogCount() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setMaxCommSize(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getMaxCommSize() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setMaxCommCount(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getMaxCommCount() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setFlashSize(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getFlashSize() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setFreeFlashSize(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getFreeFlashSize() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setLanguage(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getLanguage() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setLngEncode(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getLngEncode() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setVolume(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getVolume() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setPlatform(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getPlatform() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setBrightness(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getBrightness() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setOemVendor(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getOemVendor() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setCity(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getCity() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setAgentIpaddress(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getAgentIpaddress() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setIpaddress(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getIpaddress() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setIpPort(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getIpPort() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setComPort(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getComPort() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setBaudrate(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getBaudrate() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setComAddress(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getComAddress() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setCommPwd(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getCommPwd() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setAcpanelType(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getAcpanelType() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setSyncTime(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getSyncTime() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setMainTime(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getMainTime() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setTransactionCount(java.lang.Integer val) {
		setCurrentData(32, val);
	}

	public java.lang.Integer getTransactionCount() {
		return GenericBase.__getInt(__current_data[32]);
	}

	public void setLastActivity(java.util.Date val) {
		setCurrentData(33, generateTimestampFromDate(val));
	}

	public java.util.Date getLastActivity() {
		return GenericBase.__getDateFromSQL(__current_data[33]);
	}

	public void setTransTimes(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getTransTimes() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setTransInterval(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getTransInterval() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setLogStamp(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getLogStamp() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setOplogStamp(java.lang.String val) {
		setCurrentData(37, val);
	}

	public java.lang.String getOplogStamp() {
		return GenericBase.__getString(__current_data[37]);
	}

	public void setPhotoStamp(java.lang.String val) {
		setCurrentData(38, val);
	}

	public java.lang.String getPhotoStamp() {
		return GenericBase.__getString(__current_data[38]);
	}

	public void setFpversion(java.lang.String val) {
		setCurrentData(39, val);
	}

	public java.lang.String getFpversion() {
		return GenericBase.__getString(__current_data[39]);
	}

	public void setEnabled(java.lang.Integer val) {
		setCurrentData(40, val);
	}

	public java.lang.Integer getEnabled() {
		return GenericBase.__getInt(__current_data[40]);
	}

	public void setRealtime(java.lang.Integer val) {
		setCurrentData(41, val);
	}

	public java.lang.Integer getRealtime() {
		return GenericBase.__getInt(__current_data[41]);
	}

	public void setDelay(java.lang.Integer val) {
		setCurrentData(42, val);
	}

	public java.lang.Integer getDelay() {
		return GenericBase.__getInt(__current_data[42]);
	}

	public void setDstimeId(java.lang.Integer val) {
		setCurrentData(43, val);
	}

	public java.lang.Integer getDstimeId() {
		return GenericBase.__getInt(__current_data[43]);
	}

	public void setUpdateDb(java.lang.String val) {
		setCurrentData(44, val);
	}

	public java.lang.String getUpdateDb() {
		return GenericBase.__getString(__current_data[44]);
	}

	public void setChangeOperator(java.lang.Integer val) {
		setCurrentData(45, val);
	}

	public java.lang.Integer getChangeOperator() {
		return GenericBase.__getInt(__current_data[45]);
	}

	public void setChangeTime(java.util.Date val) {
		setCurrentData(46, generateTimestampFromDate(val));
	}

	public java.util.Date getChangeTime() {
		return GenericBase.__getDateFromSQL(__current_data[46]);
	}

	public void setCreateOperator(java.lang.Integer val) {
		setCurrentData(47, val);
	}

	public java.lang.Integer getCreateOperator() {
		return GenericBase.__getInt(__current_data[47]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(48, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[48]);
	}

	public void setDeleteOperator(java.lang.Integer val) {
		setCurrentData(49, val);
	}

	public java.lang.Integer getDeleteOperator() {
		return GenericBase.__getInt(__current_data[49]);
	}

	public void setDeleteTime(java.util.Date val) {
		setCurrentData(50, generateTimestampFromDate(val));
	}

	public java.util.Date getDeleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[50]);
	}

	public void setStatus(java.lang.Short val) {
		setCurrentData(51, val);
	}

	public java.lang.Short getStatus() {
		return GenericBase.__getShort(__current_data[51]);
	}

	public void setTzadj(java.lang.Short val) {
		setCurrentData(52, val);
	}

	public java.lang.Short getTzadj() {
		return GenericBase.__getShort(__current_data[52]);
	}

	public void setEncrypt(java.lang.Integer val) {
		setCurrentData(53, val);
	}

	public java.lang.Integer getEncrypt() {
		return GenericBase.__getInt(__current_data[53]);
	}

	public void setIsEnable(java.lang.Integer val) {
		setCurrentData(54, val);
	}

	public java.lang.Integer getIsEnable() {
		return GenericBase.__getInt(__current_data[54]);
	}

	public void setConditionClockId(String op, java.lang.Integer val) {
		setConditionClockId(op, val, CONDITION_AND);
	}

	public void setConditionClockId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectClockId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSn(String op, java.lang.String val) {
		setConditionSn(op, val, CONDITION_AND);
	}

	public void setConditionSn(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSn(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionClockTypeId(String op, java.lang.Integer val) {
		setConditionClockTypeId(op, val, CONDITION_AND);
	}

	public void setConditionClockTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectClockTypeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFwVersion(String op, java.lang.String val) {
		setConditionFwVersion(op, val, CONDITION_AND);
	}

	public void setConditionFwVersion(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFwVersion(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDeviceName(String op, java.lang.String val) {
		setConditionDeviceName(op, val, CONDITION_AND);
	}

	public void setConditionDeviceName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDeviceName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAlias(String op, java.lang.String val) {
		setConditionAlias(op, val, CONDITION_AND);
	}

	public void setConditionAlias(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAlias(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFpCount(String op, java.lang.Integer val) {
		setConditionFpCount(op, val, CONDITION_AND);
	}

	public void setConditionFpCount(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFpCount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUserCount(String op, java.lang.Integer val) {
		setConditionUserCount(op, val, CONDITION_AND);
	}

	public void setConditionUserCount(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectUserCount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMaxUserCount(String op, java.lang.Integer val) {
		setConditionMaxUserCount(op, val, CONDITION_AND);
	}

	public void setConditionMaxUserCount(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMaxUserCount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMaxFingerCount(String op, java.lang.Integer val) {
		setConditionMaxFingerCount(op, val, CONDITION_AND);
	}

	public void setConditionMaxFingerCount(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMaxFingerCount(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionMaxAttlogCount(String op, java.lang.Integer val) {
		setConditionMaxAttlogCount(op, val, CONDITION_AND);
	}

	public void setConditionMaxAttlogCount(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMaxAttlogCount(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionMaxCommSize(String op, java.lang.Integer val) {
		setConditionMaxCommSize(op, val, CONDITION_AND);
	}

	public void setConditionMaxCommSize(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMaxCommSize(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionMaxCommCount(String op, java.lang.Integer val) {
		setConditionMaxCommCount(op, val, CONDITION_AND);
	}

	public void setConditionMaxCommCount(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectMaxCommCount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionFlashSize(String op, java.lang.String val) {
		setConditionFlashSize(op, val, CONDITION_AND);
	}

	public void setConditionFlashSize(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectFlashSize(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionFreeFlashSize(String op, java.lang.String val) {
		setConditionFreeFlashSize(op, val, CONDITION_AND);
	}

	public void setConditionFreeFlashSize(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectFreeFlashSize(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionLanguage(String op, java.lang.String val) {
		setConditionLanguage(op, val, CONDITION_AND);
	}

	public void setConditionLanguage(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectLanguage(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionLngEncode(String op, java.lang.String val) {
		setConditionLngEncode(op, val, CONDITION_AND);
	}

	public void setConditionLngEncode(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectLngEncode(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionVolume(String op, java.lang.String val) {
		setConditionVolume(op, val, CONDITION_AND);
	}

	public void setConditionVolume(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectVolume(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionPlatform(String op, java.lang.String val) {
		setConditionPlatform(op, val, CONDITION_AND);
	}

	public void setConditionPlatform(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectPlatform(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionBrightness(String op, java.lang.String val) {
		setConditionBrightness(op, val, CONDITION_AND);
	}

	public void setConditionBrightness(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectBrightness(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOemVendor(String op, java.lang.String val) {
		setConditionOemVendor(op, val, CONDITION_AND);
	}

	public void setConditionOemVendor(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectOemVendor(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCity(String op, java.lang.Integer val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionAgentIpaddress(String op, java.lang.String val) {
		setConditionAgentIpaddress(op, val, CONDITION_AND);
	}

	public void setConditionAgentIpaddress(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectAgentIpaddress(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionIpaddress(String op, java.lang.String val) {
		setConditionIpaddress(op, val, CONDITION_AND);
	}

	public void setConditionIpaddress(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectIpaddress(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionIpPort(String op, java.lang.Integer val) {
		setConditionIpPort(op, val, CONDITION_AND);
	}

	public void setConditionIpPort(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectIpPort(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionComPort(String op, java.lang.Integer val) {
		setConditionComPort(op, val, CONDITION_AND);
	}

	public void setConditionComPort(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectComPort(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionBaudrate(String op, java.lang.Integer val) {
		setConditionBaudrate(op, val, CONDITION_AND);
	}

	public void setConditionBaudrate(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectBaudrate(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionComAddress(String op, java.lang.Integer val) {
		setConditionComAddress(op, val, CONDITION_AND);
	}

	public void setConditionComAddress(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectComAddress(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionCommPwd(String op, java.lang.String val) {
		setConditionCommPwd(op, val, CONDITION_AND);
	}

	public void setConditionCommPwd(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectCommPwd(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionAcpanelType(String op, java.lang.Integer val) {
		setConditionAcpanelType(op, val, CONDITION_AND);
	}

	public void setConditionAcpanelType(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectAcpanelType(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionSyncTime(String op, java.lang.Integer val) {
		setConditionSyncTime(op, val, CONDITION_AND);
	}

	public void setConditionSyncTime(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectSyncTime(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionMainTime(String op, java.lang.String val) {
		setConditionMainTime(op, val, CONDITION_AND);
	}

	public void setConditionMainTime(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectMainTime(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionTransactionCount(String op, java.lang.Integer val) {
		setConditionTransactionCount(op, val, CONDITION_AND);
	}

	public void setConditionTransactionCount(String op, java.lang.Integer val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectTransactionCount(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionLastActivity(String op, java.util.Date val) {
		setConditionLastActivity(op, val, CONDITION_AND);
	}

	public void setConditionLastActivity(String op, java.util.Date val, String relation) {
		addCondition(33, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectLastActivity(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionTransTimes(String op, java.lang.String val) {
		setConditionTransTimes(op, val, CONDITION_AND);
	}

	public void setConditionTransTimes(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectTransTimes(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionTransInterval(String op, java.lang.Integer val) {
		setConditionTransInterval(op, val, CONDITION_AND);
	}

	public void setConditionTransInterval(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectTransInterval(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionLogStamp(String op, java.lang.String val) {
		setConditionLogStamp(op, val, CONDITION_AND);
	}

	public void setConditionLogStamp(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectLogStamp(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionOplogStamp(String op, java.lang.String val) {
		setConditionOplogStamp(op, val, CONDITION_AND);
	}

	public void setConditionOplogStamp(String op, java.lang.String val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectOplogStamp(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionPhotoStamp(String op, java.lang.String val) {
		setConditionPhotoStamp(op, val, CONDITION_AND);
	}

	public void setConditionPhotoStamp(String op, java.lang.String val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectPhotoStamp(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionFpversion(String op, java.lang.String val) {
		setConditionFpversion(op, val, CONDITION_AND);
	}

	public void setConditionFpversion(String op, java.lang.String val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectFpversion(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionEnabled(String op, java.lang.Integer val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Integer val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionRealtime(String op, java.lang.Integer val) {
		setConditionRealtime(op, val, CONDITION_AND);
	}

	public void setConditionRealtime(String op, java.lang.Integer val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectRealtime(boolean val) {
		__select_flags[41] = val;
	}

	public void setConditionDelay(String op, java.lang.Integer val) {
		setConditionDelay(op, val, CONDITION_AND);
	}

	public void setConditionDelay(String op, java.lang.Integer val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectDelay(boolean val) {
		__select_flags[42] = val;
	}

	public void setConditionDstimeId(String op, java.lang.Integer val) {
		setConditionDstimeId(op, val, CONDITION_AND);
	}

	public void setConditionDstimeId(String op, java.lang.Integer val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectDstimeId(boolean val) {
		__select_flags[43] = val;
	}

	public void setConditionUpdateDb(String op, java.lang.String val) {
		setConditionUpdateDb(op, val, CONDITION_AND);
	}

	public void setConditionUpdateDb(String op, java.lang.String val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectUpdateDb(boolean val) {
		__select_flags[44] = val;
	}

	public void setConditionChangeOperator(String op, java.lang.Integer val) {
		setConditionChangeOperator(op, val, CONDITION_AND);
	}

	public void setConditionChangeOperator(String op, java.lang.Integer val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectChangeOperator(boolean val) {
		__select_flags[45] = val;
	}

	public void setConditionChangeTime(String op, java.util.Date val) {
		setConditionChangeTime(op, val, CONDITION_AND);
	}

	public void setConditionChangeTime(String op, java.util.Date val, String relation) {
		addCondition(46, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectChangeTime(boolean val) {
		__select_flags[46] = val;
	}

	public void setConditionCreateOperator(String op, java.lang.Integer val) {
		setConditionCreateOperator(op, val, CONDITION_AND);
	}

	public void setConditionCreateOperator(String op, java.lang.Integer val, String relation) {
		addCondition(47, op, relation, val);
	}

	public void setSelectCreateOperator(boolean val) {
		__select_flags[47] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(48, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[48] = val;
	}

	public void setConditionDeleteOperator(String op, java.lang.Integer val) {
		setConditionDeleteOperator(op, val, CONDITION_AND);
	}

	public void setConditionDeleteOperator(String op, java.lang.Integer val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectDeleteOperator(boolean val) {
		__select_flags[49] = val;
	}

	public void setConditionDeleteTime(String op, java.util.Date val) {
		setConditionDeleteTime(op, val, CONDITION_AND);
	}

	public void setConditionDeleteTime(String op, java.util.Date val, String relation) {
		addCondition(50, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDeleteTime(boolean val) {
		__select_flags[50] = val;
	}

	public void setConditionStatus(String op, java.lang.Short val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Short val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[51] = val;
	}

	public void setConditionTzadj(String op, java.lang.Short val) {
		setConditionTzadj(op, val, CONDITION_AND);
	}

	public void setConditionTzadj(String op, java.lang.Short val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectTzadj(boolean val) {
		__select_flags[52] = val;
	}

	public void setConditionEncrypt(String op, java.lang.Integer val) {
		setConditionEncrypt(op, val, CONDITION_AND);
	}

	public void setConditionEncrypt(String op, java.lang.Integer val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectEncrypt(boolean val) {
		__select_flags[53] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Integer val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Integer val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
		__select_flags[54] = val;
	}


}

