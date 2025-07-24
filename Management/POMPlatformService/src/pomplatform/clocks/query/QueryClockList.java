package pomplatform.clocks.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.clocks.bean.BaseClockList;
import pomplatform.clocks.bean.ConditionClockList;

public class QueryClockList extends AbstractQuery<BaseClockList, ConditionClockList>
{

	private static final Logger __logger = Logger.getLogger(QueryClockList.class);

	public QueryClockList() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("C .clock_id");
	}

	@Override
	public BaseCollection<BaseClockList> executeQuery( KeyValuePair[] replacements, ConditionClockList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDeviceName(), 
				condition.getAlias(), 
				condition.getClockTypeId(), 
				condition.getSn(), 
				condition.getIsEnable()
			);
	}

	@Override
	public BaseClockList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseClockList __base = new BaseClockList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setClockId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClockTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFwVersion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeviceName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlias(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFpCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUserCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaxUserCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaxFingerCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaxAttlogCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaxCommSize(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaxCommCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlashSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFreeFlashSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLanguage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLngEncode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setVolume(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlatform(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBrightness(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOemVendor(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAgentIpaddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIpaddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIpPort(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setComPort(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBaudrate(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setComAddress(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommPwd(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAcpanelType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSyncTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransactionCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLastActivity(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTransTimes(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransInterval(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogStamp(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOplogStamp(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhotoStamp(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFpversion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealtime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDelay(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDstimeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUpdateDb(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setChangeOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setChangeTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setTzadj(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setEncrypt(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT C .clock_id, C.sn, C.clock_type_id, C.fw_version, C.device_name, C.ALIAS, C.fp_count, C.user_count, C.max_user_count, C.max_finger_count, C.max_attlog_count, C.max_comm_size, C.max_comm_count, C.flash_size, C.free_flash_size, C.LANGUAGE, C.lng_encode, C.volume, C.platform, C.brightness, C.oem_vendor, C.city, C.agent_ipaddress, C.ipaddress, C.ip_port, C.com_port, C.baudrate, C.com_address, C.comm_pwd, C.acpanel_type, C.sync_time, C.main_time, C.transaction_count, C.last_activity, C.trans_times, C.trans_interval, C.log_stamp, C.oplog_stamp, C.photo_stamp, C.fpversion, C.realtime, C.delay, C.dstime_id, C.update_db, C.change_operator, C.change_time, C.create_operator, C.create_time, C.delete_operator, C.delete_time, C.status, C.tzadj, C.encrypt, C.is_enable FROM clocks C WHERE C.device_name LIKE ? AND C.ALIAS LIKE ? AND C.clock_type_id =? AND C.sn LIKE ? AND C.is_enable =?" ;
	private final static String RESULTSETFIELDLIST = "clock_id,sn,clock_type_id,fw_version,device_name,alias,fp_count,user_count,max_user_count,max_finger_count,max_attlog_count,max_comm_size,max_comm_count,flash_size,free_flash_size,language,lng_encode,volume,platform,brightness,oem_vendor,city,agent_ipaddress,ipaddress,ip_port,com_port,baudrate,com_address,comm_pwd,acpanel_type,sync_time,main_time,transaction_count,last_activity,trans_times,trans_interval,log_stamp,oplog_stamp,photo_stamp,fpversion,realtime,delay,dstime_id,update_db,change_operator,change_time,create_operator,create_time,delete_operator,delete_time,status,tzadj,encrypt,is_enable";
	private final static String[] fieldNames = { "device_name", "ALIAS", "clock_type_id", "sn", "is_enable"};
}
