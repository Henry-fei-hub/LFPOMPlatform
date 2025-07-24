package pomplatform.clocks.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseClockList extends GenericBase implements BaseFactory<BaseClockList>, Comparable<BaseClockList> 
{


	public static BaseClockList newInstance(){
		return new BaseClockList();
	}

	@Override
	public BaseClockList make(){
		BaseClockList b = new BaseClockList();
		return b;
	}

	public final static java.lang.String CS_CLOCK_ID = "clock_id" ;
	public final static java.lang.String CS_SN = "sn" ;
	public final static java.lang.String CS_CLOCK_TYPE_ID = "clock_type_id" ;
	public final static java.lang.String CS_FW_VERSION = "fw_version" ;
	public final static java.lang.String CS_DEVICE_NAME = "device_name" ;
	public final static java.lang.String CS_ALIAS = "alias" ;
	public final static java.lang.String CS_FP_COUNT = "fp_count" ;
	public final static java.lang.String CS_USER_COUNT = "user_count" ;
	public final static java.lang.String CS_MAX_USER_COUNT = "max_user_count" ;
	public final static java.lang.String CS_MAX_FINGER_COUNT = "max_finger_count" ;
	public final static java.lang.String CS_MAX_ATTLOG_COUNT = "max_attlog_count" ;
	public final static java.lang.String CS_MAX_COMM_SIZE = "max_comm_size" ;
	public final static java.lang.String CS_MAX_COMM_COUNT = "max_comm_count" ;
	public final static java.lang.String CS_FLASH_SIZE = "flash_size" ;
	public final static java.lang.String CS_FREE_FLASH_SIZE = "free_flash_size" ;
	public final static java.lang.String CS_LANGUAGE = "language" ;
	public final static java.lang.String CS_LNG_ENCODE = "lng_encode" ;
	public final static java.lang.String CS_VOLUME = "volume" ;
	public final static java.lang.String CS_PLATFORM = "platform" ;
	public final static java.lang.String CS_BRIGHTNESS = "brightness" ;
	public final static java.lang.String CS_OEM_VENDOR = "oem_vendor" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_AGENT_IPADDRESS = "agent_ipaddress" ;
	public final static java.lang.String CS_IPADDRESS = "ipaddress" ;
	public final static java.lang.String CS_IP_PORT = "ip_port" ;
	public final static java.lang.String CS_COM_PORT = "com_port" ;
	public final static java.lang.String CS_BAUDRATE = "baudrate" ;
	public final static java.lang.String CS_COM_ADDRESS = "com_address" ;
	public final static java.lang.String CS_COMM_PWD = "comm_pwd" ;
	public final static java.lang.String CS_ACPANEL_TYPE = "acpanel_type" ;
	public final static java.lang.String CS_SYNC_TIME = "sync_time" ;
	public final static java.lang.String CS_MAIN_TIME = "main_time" ;
	public final static java.lang.String CS_TRANSACTION_COUNT = "transaction_count" ;
	public final static java.lang.String CS_LAST_ACTIVITY = "last_activity" ;
	public final static java.lang.String CS_TRANS_TIMES = "trans_times" ;
	public final static java.lang.String CS_TRANS_INTERVAL = "trans_interval" ;
	public final static java.lang.String CS_LOG_STAMP = "log_stamp" ;
	public final static java.lang.String CS_OPLOG_STAMP = "oplog_stamp" ;
	public final static java.lang.String CS_PHOTO_STAMP = "photo_stamp" ;
	public final static java.lang.String CS_FPVERSION = "fpversion" ;
	public final static java.lang.String CS_REALTIME = "realtime" ;
	public final static java.lang.String CS_DELAY = "delay" ;
	public final static java.lang.String CS_DSTIME_ID = "dstime_id" ;
	public final static java.lang.String CS_UPDATE_DB = "update_db" ;
	public final static java.lang.String CS_CHANGE_OPERATOR = "change_operator" ;
	public final static java.lang.String CS_CHANGE_TIME = "change_time" ;
	public final static java.lang.String CS_CREATE_OPERATOR = "create_operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_OPERATOR = "delete_operator" ;
	public final static java.lang.String CS_DELETE_TIME = "delete_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_TZADJ = "tzadj" ;
	public final static java.lang.String CS_ENCRYPT = "encrypt" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,序列号,设备类型,固件版本,设备名称,别名,指纹数,已注册用户数,最大用户数,最大指纹数,最大考勤日志数,最大连接空间,最大连接数,内存大小,剩余空间,语言,语言编码,音量,平台,亮度,生产商,城市,代理IP,IP地址,端口号,网络端口,波特率,区域,连接密码,Ac面板类型,同步时间,主时间,传送次数,最后联机时间,传送时间,传送间隔时间（分）,传送签到记录标记,传送用户数据标记,传送图像标记,指纹版本,实时上传数据,连接服务器的间隔时间,打卡类型,数据库更新标记,修改人,修改时间,创建人,创建时间,删除人,删除时间,状态,时区,encrypt,机器是否可用  0 不可用   1 可用";

	public java.lang.Integer getClockId() {
		return this.__clock_id;
	}

	public void setClockId( java.lang.Integer value ) {
		this.__clock_id = value;
	}

	public java.lang.String getSn() {
		return this.__sn;
	}

	public void setSn( java.lang.String value ) {
		this.__sn = value;
	}

	public java.lang.Integer getClockTypeId() {
		return this.__clock_type_id;
	}

	public void setClockTypeId( java.lang.Integer value ) {
		this.__clock_type_id = value;
	}

	public java.lang.String getFwVersion() {
		return this.__fw_version;
	}

	public void setFwVersion( java.lang.String value ) {
		this.__fw_version = value;
	}

	public java.lang.String getDeviceName() {
		return this.__device_name;
	}

	public void setDeviceName( java.lang.String value ) {
		this.__device_name = value;
	}

	public java.lang.String getAlias() {
		return this.__alias;
	}

	public void setAlias( java.lang.String value ) {
		this.__alias = value;
	}

	public java.lang.Integer getFpCount() {
		return this.__fp_count;
	}

	public void setFpCount( java.lang.Integer value ) {
		this.__fp_count = value;
	}

	public java.lang.Integer getUserCount() {
		return this.__user_count;
	}

	public void setUserCount( java.lang.Integer value ) {
		this.__user_count = value;
	}

	public java.lang.Integer getMaxUserCount() {
		return this.__max_user_count;
	}

	public void setMaxUserCount( java.lang.Integer value ) {
		this.__max_user_count = value;
	}

	public java.lang.Integer getMaxFingerCount() {
		return this.__max_finger_count;
	}

	public void setMaxFingerCount( java.lang.Integer value ) {
		this.__max_finger_count = value;
	}

	public java.lang.Integer getMaxAttlogCount() {
		return this.__max_attlog_count;
	}

	public void setMaxAttlogCount( java.lang.Integer value ) {
		this.__max_attlog_count = value;
	}

	public java.lang.Integer getMaxCommSize() {
		return this.__max_comm_size;
	}

	public void setMaxCommSize( java.lang.Integer value ) {
		this.__max_comm_size = value;
	}

	public java.lang.Integer getMaxCommCount() {
		return this.__max_comm_count;
	}

	public void setMaxCommCount( java.lang.Integer value ) {
		this.__max_comm_count = value;
	}

	public java.lang.String getFlashSize() {
		return this.__flash_size;
	}

	public void setFlashSize( java.lang.String value ) {
		this.__flash_size = value;
	}

	public java.lang.String getFreeFlashSize() {
		return this.__free_flash_size;
	}

	public void setFreeFlashSize( java.lang.String value ) {
		this.__free_flash_size = value;
	}

	public java.lang.String getLanguage() {
		return this.__language;
	}

	public void setLanguage( java.lang.String value ) {
		this.__language = value;
	}

	public java.lang.String getLngEncode() {
		return this.__lng_encode;
	}

	public void setLngEncode( java.lang.String value ) {
		this.__lng_encode = value;
	}

	public java.lang.String getVolume() {
		return this.__volume;
	}

	public void setVolume( java.lang.String value ) {
		this.__volume = value;
	}

	public java.lang.String getPlatform() {
		return this.__platform;
	}

	public void setPlatform( java.lang.String value ) {
		this.__platform = value;
	}

	public java.lang.String getBrightness() {
		return this.__brightness;
	}

	public void setBrightness( java.lang.String value ) {
		this.__brightness = value;
	}

	public java.lang.String getOemVendor() {
		return this.__oem_vendor;
	}

	public void setOemVendor( java.lang.String value ) {
		this.__oem_vendor = value;
	}

	public java.lang.Integer getCity() {
		return this.__city;
	}

	public void setCity( java.lang.Integer value ) {
		this.__city = value;
	}

	public java.lang.String getAgentIpaddress() {
		return this.__agent_ipaddress;
	}

	public void setAgentIpaddress( java.lang.String value ) {
		this.__agent_ipaddress = value;
	}

	public java.lang.String getIpaddress() {
		return this.__ipaddress;
	}

	public void setIpaddress( java.lang.String value ) {
		this.__ipaddress = value;
	}

	public java.lang.Integer getIpPort() {
		return this.__ip_port;
	}

	public void setIpPort( java.lang.Integer value ) {
		this.__ip_port = value;
	}

	public java.lang.Integer getComPort() {
		return this.__com_port;
	}

	public void setComPort( java.lang.Integer value ) {
		this.__com_port = value;
	}

	public java.lang.Integer getBaudrate() {
		return this.__baudrate;
	}

	public void setBaudrate( java.lang.Integer value ) {
		this.__baudrate = value;
	}

	public java.lang.Integer getComAddress() {
		return this.__com_address;
	}

	public void setComAddress( java.lang.Integer value ) {
		this.__com_address = value;
	}

	public java.lang.String getCommPwd() {
		return this.__comm_pwd;
	}

	public void setCommPwd( java.lang.String value ) {
		this.__comm_pwd = value;
	}

	public java.lang.Integer getAcpanelType() {
		return this.__acpanel_type;
	}

	public void setAcpanelType( java.lang.Integer value ) {
		this.__acpanel_type = value;
	}

	public java.lang.Integer getSyncTime() {
		return this.__sync_time;
	}

	public void setSyncTime( java.lang.Integer value ) {
		this.__sync_time = value;
	}

	public java.lang.String getMainTime() {
		return this.__main_time;
	}

	public void setMainTime( java.lang.String value ) {
		this.__main_time = value;
	}

	public java.lang.Integer getTransactionCount() {
		return this.__transaction_count;
	}

	public void setTransactionCount( java.lang.Integer value ) {
		this.__transaction_count = value;
	}

	public java.util.Date getLastActivity() {
		return this.__last_activity;
	}

	public void setLastActivity( java.util.Date value ) {
		this.__last_activity = value;
	}

	public java.lang.String getTransTimes() {
		return this.__trans_times;
	}

	public void setTransTimes( java.lang.String value ) {
		this.__trans_times = value;
	}

	public java.lang.Integer getTransInterval() {
		return this.__trans_interval;
	}

	public void setTransInterval( java.lang.Integer value ) {
		this.__trans_interval = value;
	}

	public java.lang.String getLogStamp() {
		return this.__log_stamp;
	}

	public void setLogStamp( java.lang.String value ) {
		this.__log_stamp = value;
	}

	public java.lang.String getOplogStamp() {
		return this.__oplog_stamp;
	}

	public void setOplogStamp( java.lang.String value ) {
		this.__oplog_stamp = value;
	}

	public java.lang.String getPhotoStamp() {
		return this.__photo_stamp;
	}

	public void setPhotoStamp( java.lang.String value ) {
		this.__photo_stamp = value;
	}

	public java.lang.String getFpversion() {
		return this.__fpversion;
	}

	public void setFpversion( java.lang.String value ) {
		this.__fpversion = value;
	}

	public java.lang.Integer getRealtime() {
		return this.__realtime;
	}

	public void setRealtime( java.lang.Integer value ) {
		this.__realtime = value;
	}

	public java.lang.Integer getDelay() {
		return this.__delay;
	}

	public void setDelay( java.lang.Integer value ) {
		this.__delay = value;
	}

	public java.lang.Integer getDstimeId() {
		return this.__dstime_id;
	}

	public void setDstimeId( java.lang.Integer value ) {
		this.__dstime_id = value;
	}

	public java.lang.String getUpdateDb() {
		return this.__update_db;
	}

	public void setUpdateDb( java.lang.String value ) {
		this.__update_db = value;
	}

	public java.lang.Integer getChangeOperator() {
		return this.__change_operator;
	}

	public void setChangeOperator( java.lang.Integer value ) {
		this.__change_operator = value;
	}

	public java.util.Date getChangeTime() {
		return this.__change_time;
	}

	public void setChangeTime( java.util.Date value ) {
		this.__change_time = value;
	}

	public java.lang.Integer getCreateOperator() {
		return this.__create_operator;
	}

	public void setCreateOperator( java.lang.Integer value ) {
		this.__create_operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteOperator() {
		return this.__delete_operator;
	}

	public void setDeleteOperator( java.lang.Integer value ) {
		this.__delete_operator = value;
	}

	public java.util.Date getDeleteTime() {
		return this.__delete_time;
	}

	public void setDeleteTime( java.util.Date value ) {
		this.__delete_time = value;
	}

	public java.lang.Short getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Short value ) {
		this.__status = value;
	}

	public java.lang.Short getTzadj() {
		return this.__tzadj;
	}

	public void setTzadj( java.lang.Short value ) {
		this.__tzadj = value;
	}

	public java.lang.Integer getEncrypt() {
		return this.__encrypt;
	}

	public void setEncrypt( java.lang.Integer value ) {
		this.__encrypt = value;
	}

	public java.lang.Integer getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Integer value ) {
		this.__is_enable = value;
	}

	public void cloneCopy(BaseClockList __bean){
		__bean.setClockId(getClockId());
		__bean.setSn(getSn());
		__bean.setClockTypeId(getClockTypeId());
		__bean.setFwVersion(getFwVersion());
		__bean.setDeviceName(getDeviceName());
		__bean.setAlias(getAlias());
		__bean.setFpCount(getFpCount());
		__bean.setUserCount(getUserCount());
		__bean.setMaxUserCount(getMaxUserCount());
		__bean.setMaxFingerCount(getMaxFingerCount());
		__bean.setMaxAttlogCount(getMaxAttlogCount());
		__bean.setMaxCommSize(getMaxCommSize());
		__bean.setMaxCommCount(getMaxCommCount());
		__bean.setFlashSize(getFlashSize());
		__bean.setFreeFlashSize(getFreeFlashSize());
		__bean.setLanguage(getLanguage());
		__bean.setLngEncode(getLngEncode());
		__bean.setVolume(getVolume());
		__bean.setPlatform(getPlatform());
		__bean.setBrightness(getBrightness());
		__bean.setOemVendor(getOemVendor());
		__bean.setCity(getCity());
		__bean.setAgentIpaddress(getAgentIpaddress());
		__bean.setIpaddress(getIpaddress());
		__bean.setIpPort(getIpPort());
		__bean.setComPort(getComPort());
		__bean.setBaudrate(getBaudrate());
		__bean.setComAddress(getComAddress());
		__bean.setCommPwd(getCommPwd());
		__bean.setAcpanelType(getAcpanelType());
		__bean.setSyncTime(getSyncTime());
		__bean.setMainTime(getMainTime());
		__bean.setTransactionCount(getTransactionCount());
		__bean.setLastActivity(getLastActivity());
		__bean.setTransTimes(getTransTimes());
		__bean.setTransInterval(getTransInterval());
		__bean.setLogStamp(getLogStamp());
		__bean.setOplogStamp(getOplogStamp());
		__bean.setPhotoStamp(getPhotoStamp());
		__bean.setFpversion(getFpversion());
		__bean.setRealtime(getRealtime());
		__bean.setDelay(getDelay());
		__bean.setDstimeId(getDstimeId());
		__bean.setUpdateDb(getUpdateDb());
		__bean.setChangeOperator(getChangeOperator());
		__bean.setChangeTime(getChangeTime());
		__bean.setCreateOperator(getCreateOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteOperator(getDeleteOperator());
		__bean.setDeleteTime(getDeleteTime());
		__bean.setStatus(getStatus());
		__bean.setTzadj(getTzadj());
		__bean.setEncrypt(getEncrypt());
		__bean.setIsEnable(getIsEnable());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getClockId() == null ? "" : getClockId());
		sb.append(",");
		sb.append(getSn() == null ? "" : getSn());
		sb.append(",");
		sb.append(getClockTypeId() == null ? "" : getClockTypeId());
		sb.append(",");
		sb.append(getFwVersion() == null ? "" : getFwVersion());
		sb.append(",");
		sb.append(getDeviceName() == null ? "" : getDeviceName());
		sb.append(",");
		sb.append(getAlias() == null ? "" : getAlias());
		sb.append(",");
		sb.append(getFpCount() == null ? "" : getFpCount());
		sb.append(",");
		sb.append(getUserCount() == null ? "" : getUserCount());
		sb.append(",");
		sb.append(getMaxUserCount() == null ? "" : getMaxUserCount());
		sb.append(",");
		sb.append(getMaxFingerCount() == null ? "" : getMaxFingerCount());
		sb.append(",");
		sb.append(getMaxAttlogCount() == null ? "" : getMaxAttlogCount());
		sb.append(",");
		sb.append(getMaxCommSize() == null ? "" : getMaxCommSize());
		sb.append(",");
		sb.append(getMaxCommCount() == null ? "" : getMaxCommCount());
		sb.append(",");
		sb.append(getFlashSize() == null ? "" : getFlashSize());
		sb.append(",");
		sb.append(getFreeFlashSize() == null ? "" : getFreeFlashSize());
		sb.append(",");
		sb.append(getLanguage() == null ? "" : getLanguage());
		sb.append(",");
		sb.append(getLngEncode() == null ? "" : getLngEncode());
		sb.append(",");
		sb.append(getVolume() == null ? "" : getVolume());
		sb.append(",");
		sb.append(getPlatform() == null ? "" : getPlatform());
		sb.append(",");
		sb.append(getBrightness() == null ? "" : getBrightness());
		sb.append(",");
		sb.append(getOemVendor() == null ? "" : getOemVendor());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getAgentIpaddress() == null ? "" : getAgentIpaddress());
		sb.append(",");
		sb.append(getIpaddress() == null ? "" : getIpaddress());
		sb.append(",");
		sb.append(getIpPort() == null ? "" : getIpPort());
		sb.append(",");
		sb.append(getComPort() == null ? "" : getComPort());
		sb.append(",");
		sb.append(getBaudrate() == null ? "" : getBaudrate());
		sb.append(",");
		sb.append(getComAddress() == null ? "" : getComAddress());
		sb.append(",");
		sb.append(getCommPwd() == null ? "" : getCommPwd());
		sb.append(",");
		sb.append(getAcpanelType() == null ? "" : getAcpanelType());
		sb.append(",");
		sb.append(getSyncTime() == null ? "" : getSyncTime());
		sb.append(",");
		sb.append(getMainTime() == null ? "" : getMainTime());
		sb.append(",");
		sb.append(getTransactionCount() == null ? "" : getTransactionCount());
		sb.append(",");
		sb.append(getLastActivity() == null ? "" : sdf.format(getLastActivity()));
		sb.append(",");
		sb.append(getTransTimes() == null ? "" : getTransTimes());
		sb.append(",");
		sb.append(getTransInterval() == null ? "" : getTransInterval());
		sb.append(",");
		sb.append(getLogStamp() == null ? "" : getLogStamp());
		sb.append(",");
		sb.append(getOplogStamp() == null ? "" : getOplogStamp());
		sb.append(",");
		sb.append(getPhotoStamp() == null ? "" : getPhotoStamp());
		sb.append(",");
		sb.append(getFpversion() == null ? "" : getFpversion());
		sb.append(",");
		sb.append(getRealtime() == null ? "" : getRealtime());
		sb.append(",");
		sb.append(getDelay() == null ? "" : getDelay());
		sb.append(",");
		sb.append(getDstimeId() == null ? "" : getDstimeId());
		sb.append(",");
		sb.append(getUpdateDb() == null ? "" : getUpdateDb());
		sb.append(",");
		sb.append(getChangeOperator() == null ? "" : getChangeOperator());
		sb.append(",");
		sb.append(getChangeTime() == null ? "" : sdf.format(getChangeTime()));
		sb.append(",");
		sb.append(getCreateOperator() == null ? "" : getCreateOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteOperator() == null ? "" : getDeleteOperator());
		sb.append(",");
		sb.append(getDeleteTime() == null ? "" : sdf.format(getDeleteTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getTzadj() == null ? "" : getTzadj());
		sb.append(",");
		sb.append(getEncrypt() == null ? "" : getEncrypt());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseClockList o) {
		return __clock_id == null ? -1 : __clock_id.compareTo(o.getClockId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__clock_id);
		hash = 97 * hash + Objects.hashCode(this.__sn);
		hash = 97 * hash + Objects.hashCode(this.__clock_type_id);
		hash = 97 * hash + Objects.hashCode(this.__fw_version);
		hash = 97 * hash + Objects.hashCode(this.__device_name);
		hash = 97 * hash + Objects.hashCode(this.__alias);
		hash = 97 * hash + Objects.hashCode(this.__fp_count);
		hash = 97 * hash + Objects.hashCode(this.__user_count);
		hash = 97 * hash + Objects.hashCode(this.__max_user_count);
		hash = 97 * hash + Objects.hashCode(this.__max_finger_count);
		hash = 97 * hash + Objects.hashCode(this.__max_attlog_count);
		hash = 97 * hash + Objects.hashCode(this.__max_comm_size);
		hash = 97 * hash + Objects.hashCode(this.__max_comm_count);
		hash = 97 * hash + Objects.hashCode(this.__flash_size);
		hash = 97 * hash + Objects.hashCode(this.__free_flash_size);
		hash = 97 * hash + Objects.hashCode(this.__language);
		hash = 97 * hash + Objects.hashCode(this.__lng_encode);
		hash = 97 * hash + Objects.hashCode(this.__volume);
		hash = 97 * hash + Objects.hashCode(this.__platform);
		hash = 97 * hash + Objects.hashCode(this.__brightness);
		hash = 97 * hash + Objects.hashCode(this.__oem_vendor);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__agent_ipaddress);
		hash = 97 * hash + Objects.hashCode(this.__ipaddress);
		hash = 97 * hash + Objects.hashCode(this.__ip_port);
		hash = 97 * hash + Objects.hashCode(this.__com_port);
		hash = 97 * hash + Objects.hashCode(this.__baudrate);
		hash = 97 * hash + Objects.hashCode(this.__com_address);
		hash = 97 * hash + Objects.hashCode(this.__comm_pwd);
		hash = 97 * hash + Objects.hashCode(this.__acpanel_type);
		hash = 97 * hash + Objects.hashCode(this.__sync_time);
		hash = 97 * hash + Objects.hashCode(this.__main_time);
		hash = 97 * hash + Objects.hashCode(this.__transaction_count);
		hash = 97 * hash + Objects.hashCode(this.__last_activity);
		hash = 97 * hash + Objects.hashCode(this.__trans_times);
		hash = 97 * hash + Objects.hashCode(this.__trans_interval);
		hash = 97 * hash + Objects.hashCode(this.__log_stamp);
		hash = 97 * hash + Objects.hashCode(this.__oplog_stamp);
		hash = 97 * hash + Objects.hashCode(this.__photo_stamp);
		hash = 97 * hash + Objects.hashCode(this.__fpversion);
		hash = 97 * hash + Objects.hashCode(this.__realtime);
		hash = 97 * hash + Objects.hashCode(this.__delay);
		hash = 97 * hash + Objects.hashCode(this.__dstime_id);
		hash = 97 * hash + Objects.hashCode(this.__update_db);
		hash = 97 * hash + Objects.hashCode(this.__change_operator);
		hash = 97 * hash + Objects.hashCode(this.__change_time);
		hash = 97 * hash + Objects.hashCode(this.__create_operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_operator);
		hash = 97 * hash + Objects.hashCode(this.__delete_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__tzadj);
		hash = 97 * hash + Objects.hashCode(this.__encrypt);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseClockList o = (BaseClockList)obj;
		if(!Objects.equals(this.__clock_id, o.getClockId())) return false;
		if(!Objects.equals(this.__sn, o.getSn())) return false;
		if(!Objects.equals(this.__clock_type_id, o.getClockTypeId())) return false;
		if(!Objects.equals(this.__fw_version, o.getFwVersion())) return false;
		if(!Objects.equals(this.__device_name, o.getDeviceName())) return false;
		if(!Objects.equals(this.__alias, o.getAlias())) return false;
		if(!Objects.equals(this.__fp_count, o.getFpCount())) return false;
		if(!Objects.equals(this.__user_count, o.getUserCount())) return false;
		if(!Objects.equals(this.__max_user_count, o.getMaxUserCount())) return false;
		if(!Objects.equals(this.__max_finger_count, o.getMaxFingerCount())) return false;
		if(!Objects.equals(this.__max_attlog_count, o.getMaxAttlogCount())) return false;
		if(!Objects.equals(this.__max_comm_size, o.getMaxCommSize())) return false;
		if(!Objects.equals(this.__max_comm_count, o.getMaxCommCount())) return false;
		if(!Objects.equals(this.__flash_size, o.getFlashSize())) return false;
		if(!Objects.equals(this.__free_flash_size, o.getFreeFlashSize())) return false;
		if(!Objects.equals(this.__language, o.getLanguage())) return false;
		if(!Objects.equals(this.__lng_encode, o.getLngEncode())) return false;
		if(!Objects.equals(this.__volume, o.getVolume())) return false;
		if(!Objects.equals(this.__platform, o.getPlatform())) return false;
		if(!Objects.equals(this.__brightness, o.getBrightness())) return false;
		if(!Objects.equals(this.__oem_vendor, o.getOemVendor())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__agent_ipaddress, o.getAgentIpaddress())) return false;
		if(!Objects.equals(this.__ipaddress, o.getIpaddress())) return false;
		if(!Objects.equals(this.__ip_port, o.getIpPort())) return false;
		if(!Objects.equals(this.__com_port, o.getComPort())) return false;
		if(!Objects.equals(this.__baudrate, o.getBaudrate())) return false;
		if(!Objects.equals(this.__com_address, o.getComAddress())) return false;
		if(!Objects.equals(this.__comm_pwd, o.getCommPwd())) return false;
		if(!Objects.equals(this.__acpanel_type, o.getAcpanelType())) return false;
		if(!Objects.equals(this.__sync_time, o.getSyncTime())) return false;
		if(!Objects.equals(this.__main_time, o.getMainTime())) return false;
		if(!Objects.equals(this.__transaction_count, o.getTransactionCount())) return false;
		if(!Objects.equals(this.__last_activity, o.getLastActivity())) return false;
		if(!Objects.equals(this.__trans_times, o.getTransTimes())) return false;
		if(!Objects.equals(this.__trans_interval, o.getTransInterval())) return false;
		if(!Objects.equals(this.__log_stamp, o.getLogStamp())) return false;
		if(!Objects.equals(this.__oplog_stamp, o.getOplogStamp())) return false;
		if(!Objects.equals(this.__photo_stamp, o.getPhotoStamp())) return false;
		if(!Objects.equals(this.__fpversion, o.getFpversion())) return false;
		if(!Objects.equals(this.__realtime, o.getRealtime())) return false;
		if(!Objects.equals(this.__delay, o.getDelay())) return false;
		if(!Objects.equals(this.__dstime_id, o.getDstimeId())) return false;
		if(!Objects.equals(this.__update_db, o.getUpdateDb())) return false;
		if(!Objects.equals(this.__change_operator, o.getChangeOperator())) return false;
		if(!Objects.equals(this.__change_time, o.getChangeTime())) return false;
		if(!Objects.equals(this.__create_operator, o.getCreateOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_operator, o.getDeleteOperator())) return false;
		if(!Objects.equals(this.__delete_time, o.getDeleteTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__tzadj, o.getTzadj())) return false;
		if(!Objects.equals(this.__encrypt, o.getEncrypt())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getClockId() != null) sb.append(__wrapNumber(count++, "clockId", getClockId()));
		if(getSn() != null) sb.append(__wrapString(count++, "sn", getSn()));
		if(getClockTypeId() != null) sb.append(__wrapNumber(count++, "clockTypeId", getClockTypeId()));
		if(getFwVersion() != null) sb.append(__wrapString(count++, "fwVersion", getFwVersion()));
		if(getDeviceName() != null) sb.append(__wrapString(count++, "deviceName", getDeviceName()));
		if(getAlias() != null) sb.append(__wrapString(count++, "alias", getAlias()));
		if(getFpCount() != null) sb.append(__wrapNumber(count++, "fpCount", getFpCount()));
		if(getUserCount() != null) sb.append(__wrapNumber(count++, "userCount", getUserCount()));
		if(getMaxUserCount() != null) sb.append(__wrapNumber(count++, "maxUserCount", getMaxUserCount()));
		if(getMaxFingerCount() != null) sb.append(__wrapNumber(count++, "maxFingerCount", getMaxFingerCount()));
		if(getMaxAttlogCount() != null) sb.append(__wrapNumber(count++, "maxAttlogCount", getMaxAttlogCount()));
		if(getMaxCommSize() != null) sb.append(__wrapNumber(count++, "maxCommSize", getMaxCommSize()));
		if(getMaxCommCount() != null) sb.append(__wrapNumber(count++, "maxCommCount", getMaxCommCount()));
		if(getFlashSize() != null) sb.append(__wrapString(count++, "flashSize", getFlashSize()));
		if(getFreeFlashSize() != null) sb.append(__wrapString(count++, "freeFlashSize", getFreeFlashSize()));
		if(getLanguage() != null) sb.append(__wrapString(count++, "language", getLanguage()));
		if(getLngEncode() != null) sb.append(__wrapString(count++, "lngEncode", getLngEncode()));
		if(getVolume() != null) sb.append(__wrapString(count++, "volume", getVolume()));
		if(getPlatform() != null) sb.append(__wrapString(count++, "platform", getPlatform()));
		if(getBrightness() != null) sb.append(__wrapString(count++, "brightness", getBrightness()));
		if(getOemVendor() != null) sb.append(__wrapString(count++, "oemVendor", getOemVendor()));
		if(getCity() != null) sb.append(__wrapNumber(count++, "city", getCity()));
		if(getAgentIpaddress() != null) sb.append(__wrapString(count++, "agentIpaddress", getAgentIpaddress()));
		if(getIpaddress() != null) sb.append(__wrapString(count++, "ipaddress", getIpaddress()));
		if(getIpPort() != null) sb.append(__wrapNumber(count++, "ipPort", getIpPort()));
		if(getComPort() != null) sb.append(__wrapNumber(count++, "comPort", getComPort()));
		if(getBaudrate() != null) sb.append(__wrapNumber(count++, "baudrate", getBaudrate()));
		if(getComAddress() != null) sb.append(__wrapNumber(count++, "comAddress", getComAddress()));
		if(getCommPwd() != null) sb.append(__wrapString(count++, "commPwd", getCommPwd()));
		if(getAcpanelType() != null) sb.append(__wrapNumber(count++, "acpanelType", getAcpanelType()));
		if(getSyncTime() != null) sb.append(__wrapNumber(count++, "syncTime", getSyncTime()));
		if(getMainTime() != null) sb.append(__wrapString(count++, "mainTime", getMainTime()));
		if(getTransactionCount() != null) sb.append(__wrapNumber(count++, "transactionCount", getTransactionCount()));
		if(getLastActivity() != null) sb.append(__wrapDate(count++, "lastActivity", getLastActivity()));
		if(getTransTimes() != null) sb.append(__wrapString(count++, "transTimes", getTransTimes()));
		if(getTransInterval() != null) sb.append(__wrapNumber(count++, "transInterval", getTransInterval()));
		if(getLogStamp() != null) sb.append(__wrapString(count++, "logStamp", getLogStamp()));
		if(getOplogStamp() != null) sb.append(__wrapString(count++, "oplogStamp", getOplogStamp()));
		if(getPhotoStamp() != null) sb.append(__wrapString(count++, "photoStamp", getPhotoStamp()));
		if(getFpversion() != null) sb.append(__wrapString(count++, "fpversion", getFpversion()));
		if(getRealtime() != null) sb.append(__wrapNumber(count++, "realtime", getRealtime()));
		if(getDelay() != null) sb.append(__wrapNumber(count++, "delay", getDelay()));
		if(getDstimeId() != null) sb.append(__wrapNumber(count++, "dstimeId", getDstimeId()));
		if(getUpdateDb() != null) sb.append(__wrapString(count++, "updateDb", getUpdateDb()));
		if(getChangeOperator() != null) sb.append(__wrapNumber(count++, "changeOperator", getChangeOperator()));
		if(getChangeTime() != null) sb.append(__wrapDate(count++, "changeTime", getChangeTime()));
		if(getCreateOperator() != null) sb.append(__wrapNumber(count++, "createOperator", getCreateOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteOperator() != null) sb.append(__wrapNumber(count++, "deleteOperator", getDeleteOperator()));
		if(getDeleteTime() != null) sb.append(__wrapDate(count++, "deleteTime", getDeleteTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getTzadj() != null) sb.append(__wrapNumber(count++, "tzadj", getTzadj()));
		if(getEncrypt() != null) sb.append(__wrapNumber(count++, "encrypt", getEncrypt()));
		if(getIsEnable() != null) sb.append(__wrapNumber(count++, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("clockId")) != null) setClockId(__getInt(val)); 
		if((val = values.get("sn")) != null) setSn(__getString(val));
		if((val = values.get("clockTypeId")) != null) setClockTypeId(__getInt(val)); 
		if((val = values.get("fwVersion")) != null) setFwVersion(__getString(val));
		if((val = values.get("deviceName")) != null) setDeviceName(__getString(val));
		if((val = values.get("alias")) != null) setAlias(__getString(val));
		if((val = values.get("fpCount")) != null) setFpCount(__getInt(val)); 
		if((val = values.get("userCount")) != null) setUserCount(__getInt(val)); 
		if((val = values.get("maxUserCount")) != null) setMaxUserCount(__getInt(val)); 
		if((val = values.get("maxFingerCount")) != null) setMaxFingerCount(__getInt(val)); 
		if((val = values.get("maxAttlogCount")) != null) setMaxAttlogCount(__getInt(val)); 
		if((val = values.get("maxCommSize")) != null) setMaxCommSize(__getInt(val)); 
		if((val = values.get("maxCommCount")) != null) setMaxCommCount(__getInt(val)); 
		if((val = values.get("flashSize")) != null) setFlashSize(__getString(val));
		if((val = values.get("freeFlashSize")) != null) setFreeFlashSize(__getString(val));
		if((val = values.get("language")) != null) setLanguage(__getString(val));
		if((val = values.get("lngEncode")) != null) setLngEncode(__getString(val));
		if((val = values.get("volume")) != null) setVolume(__getString(val));
		if((val = values.get("platform")) != null) setPlatform(__getString(val));
		if((val = values.get("brightness")) != null) setBrightness(__getString(val));
		if((val = values.get("oemVendor")) != null) setOemVendor(__getString(val));
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("agentIpaddress")) != null) setAgentIpaddress(__getString(val));
		if((val = values.get("ipaddress")) != null) setIpaddress(__getString(val));
		if((val = values.get("ipPort")) != null) setIpPort(__getInt(val)); 
		if((val = values.get("comPort")) != null) setComPort(__getInt(val)); 
		if((val = values.get("baudrate")) != null) setBaudrate(__getInt(val)); 
		if((val = values.get("comAddress")) != null) setComAddress(__getInt(val)); 
		if((val = values.get("commPwd")) != null) setCommPwd(__getString(val));
		if((val = values.get("acpanelType")) != null) setAcpanelType(__getInt(val)); 
		if((val = values.get("syncTime")) != null) setSyncTime(__getInt(val)); 
		if((val = values.get("mainTime")) != null) setMainTime(__getString(val));
		if((val = values.get("transactionCount")) != null) setTransactionCount(__getInt(val)); 
		if((val = values.get("lastActivity")) != null) setLastActivity(__getDate(val)); 
		if((val = values.get("transTimes")) != null) setTransTimes(__getString(val));
		if((val = values.get("transInterval")) != null) setTransInterval(__getInt(val)); 
		if((val = values.get("logStamp")) != null) setLogStamp(__getString(val));
		if((val = values.get("oplogStamp")) != null) setOplogStamp(__getString(val));
		if((val = values.get("photoStamp")) != null) setPhotoStamp(__getString(val));
		if((val = values.get("fpversion")) != null) setFpversion(__getString(val));
		if((val = values.get("realtime")) != null) setRealtime(__getInt(val)); 
		if((val = values.get("delay")) != null) setDelay(__getInt(val)); 
		if((val = values.get("dstimeId")) != null) setDstimeId(__getInt(val)); 
		if((val = values.get("updateDb")) != null) setUpdateDb(__getString(val));
		if((val = values.get("changeOperator")) != null) setChangeOperator(__getInt(val)); 
		if((val = values.get("changeTime")) != null) setChangeTime(__getDate(val)); 
		if((val = values.get("createOperator")) != null) setCreateOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteOperator")) != null) setDeleteOperator(__getInt(val)); 
		if((val = values.get("deleteTime")) != null) setDeleteTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getShort(val));
		if((val = values.get("tzadj")) != null) setTzadj(__getShort(val));
		if((val = values.get("encrypt")) != null) setEncrypt(__getInt(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getInt(val)); 
	}

	protected java.lang.Integer  __clock_id ;
	protected java.lang.String  __sn ;
	protected java.lang.Integer  __clock_type_id ;
	protected java.lang.String  __fw_version ;
	protected java.lang.String  __device_name ;
	protected java.lang.String  __alias ;
	protected java.lang.Integer  __fp_count ;
	protected java.lang.Integer  __user_count ;
	protected java.lang.Integer  __max_user_count ;
	protected java.lang.Integer  __max_finger_count ;
	protected java.lang.Integer  __max_attlog_count ;
	protected java.lang.Integer  __max_comm_size ;
	protected java.lang.Integer  __max_comm_count ;
	protected java.lang.String  __flash_size ;
	protected java.lang.String  __free_flash_size ;
	protected java.lang.String  __language ;
	protected java.lang.String  __lng_encode ;
	protected java.lang.String  __volume ;
	protected java.lang.String  __platform ;
	protected java.lang.String  __brightness ;
	protected java.lang.String  __oem_vendor ;
	protected java.lang.Integer  __city ;
	protected java.lang.String  __agent_ipaddress ;
	protected java.lang.String  __ipaddress ;
	protected java.lang.Integer  __ip_port ;
	protected java.lang.Integer  __com_port ;
	protected java.lang.Integer  __baudrate ;
	protected java.lang.Integer  __com_address ;
	protected java.lang.String  __comm_pwd ;
	protected java.lang.Integer  __acpanel_type ;
	protected java.lang.Integer  __sync_time ;
	protected java.lang.String  __main_time ;
	protected java.lang.Integer  __transaction_count ;
	protected java.util.Date  __last_activity ;
	protected java.lang.String  __trans_times ;
	protected java.lang.Integer  __trans_interval ;
	protected java.lang.String  __log_stamp ;
	protected java.lang.String  __oplog_stamp ;
	protected java.lang.String  __photo_stamp ;
	protected java.lang.String  __fpversion ;
	protected java.lang.Integer  __realtime ;
	protected java.lang.Integer  __delay ;
	protected java.lang.Integer  __dstime_id ;
	protected java.lang.String  __update_db ;
	protected java.lang.Integer  __change_operator ;
	protected java.util.Date  __change_time ;
	protected java.lang.Integer  __create_operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_operator ;
	protected java.util.Date  __delete_time ;
	protected java.lang.Short  __status ;
	protected java.lang.Short  __tzadj ;
	protected java.lang.Integer  __encrypt ;
	protected java.lang.Integer  __is_enable ;
}
