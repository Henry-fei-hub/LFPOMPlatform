package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSClockList extends DBDataSource
{


	public static DSClockList instance = null;

	public static DSClockList getInstance() {
		if(instance == null) {
			instance = new DSClockList("DSClockList");
		}
		return instance;
	}

	private final DataSourceIntegerField clockIdField;
	private final DataSourceTextField snField;
	private final DataSourceIntegerField clockTypeIdField;
	private final DataSourceTextField fwVersionField;
	private final DataSourceTextField deviceNameField;
	private final DataSourceTextField aliasField;
	private final DataSourceIntegerField fpCountField;
	private final DataSourceIntegerField userCountField;
	private final DataSourceIntegerField maxUserCountField;
	private final DataSourceIntegerField maxFingerCountField;
	private final DataSourceIntegerField maxAttlogCountField;
	private final DataSourceIntegerField maxCommSizeField;
	private final DataSourceIntegerField maxCommCountField;
	private final DataSourceTextField flashSizeField;
	private final DataSourceTextField freeFlashSizeField;
	private final DataSourceTextField languageField;
	private final DataSourceTextField lngEncodeField;
	private final DataSourceTextField volumeField;
	private final DataSourceTextField platformField;
	private final DataSourceTextField brightnessField;
	private final DataSourceTextField oemVendorField;
	private final DataSourceIntegerField cityField;
	private final DataSourceTextField agentIpaddressField;
	private final DataSourceTextField ipaddressField;
	private final DataSourceIntegerField ipPortField;
	private final DataSourceIntegerField comPortField;
	private final DataSourceIntegerField baudrateField;
	private final DataSourceIntegerField comAddressField;
	private final DataSourceTextField commPwdField;
	private final DataSourceIntegerField acpanelTypeField;
	private final DataSourceIntegerField syncTimeField;
	private final DataSourceTextField mainTimeField;
	private final DataSourceIntegerField transactionCountField;
	private final DataSourceDateTimeField lastActivityField;
	private final DataSourceTextField transTimesField;
	private final DataSourceIntegerField transIntervalField;
	private final DataSourceTextField logStampField;
	private final DataSourceTextField oplogStampField;
	private final DataSourceTextField photoStampField;
	private final DataSourceTextField fpversionField;
//	private final DataSourceIntegerField enabledField;
	private final DataSourceIntegerField realtimeField;
	private final DataSourceIntegerField delayField;
	private final DataSourceIntegerField dstimeIdField;
	private final DataSourceTextField updateDbField;
	private final DataSourceIntegerField changeOperatorField;
	private final DataSourceDateTimeField changeTimeField;
	private final DataSourceIntegerField createOperatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteOperatorField;
	private final DataSourceDateTimeField deleteTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField tzadjField;
	private final DataSourceIntegerField encryptField;
	private final DataSourceIntegerField isEnableField;

	public DSClockList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ClockList");


		clockIdField = new DataSourceIntegerField("clockId", "主键编码");
		clockIdField.setLength(11);
		clockIdField.setPrimaryKey(true);
		clockIdField.setRequired(true);
		clockIdField.setHidden(true);


		snField = new DataSourceTextField("sn", "序列号");
		snField.setLength(32);
		snField.setRequired(false);
		snField.setHidden(false);


		clockTypeIdField = new DataSourceIntegerField("clockTypeId", "设备类型");
		clockTypeIdField.setLength(11);
		clockTypeIdField.setRequired(true);
		clockTypeIdField.setHidden(false);
		clockTypeIdField.setCanEdit(true);
		clockTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_87"));


		fwVersionField = new DataSourceTextField("fwVersion", "固件版本");
		fwVersionField.setLength(32);
		fwVersionField.setRequired(false);
		fwVersionField.setHidden(false);


		deviceNameField = new DataSourceTextField("deviceName", "设备名称");
		deviceNameField.setLength(64);
		deviceNameField.setRequired(false);
		deviceNameField.setHidden(false);


		aliasField = new DataSourceTextField("alias", "别名");
		aliasField.setLength(64);
		aliasField.setRequired(false);
		aliasField.setHidden(false);
		aliasField.setCanEdit(true);


		fpCountField = new DataSourceIntegerField("fpCount", "指纹数");
		fpCountField.setLength(11);
		fpCountField.setRequired(false);
		fpCountField.setHidden(false);


		userCountField = new DataSourceIntegerField("userCount", "已注册用户数");
		userCountField.setLength(11);
		userCountField.setRequired(false);
		userCountField.setHidden(false);


		maxUserCountField = new DataSourceIntegerField("maxUserCount", "最大用户数");
		maxUserCountField.setLength(11);
		maxUserCountField.setRequired(false);
		maxUserCountField.setHidden(true);


		maxFingerCountField = new DataSourceIntegerField("maxFingerCount", "最大指纹数");
		maxFingerCountField.setLength(11);
		maxFingerCountField.setRequired(false);
		maxFingerCountField.setHidden(true);


		maxAttlogCountField = new DataSourceIntegerField("maxAttlogCount", "最大考勤日志数");
		maxAttlogCountField.setLength(11);
		maxAttlogCountField.setRequired(false);
		maxAttlogCountField.setHidden(true);


		maxCommSizeField = new DataSourceIntegerField("maxCommSize", "最大连接空间");
		maxCommSizeField.setLength(11);
		maxCommSizeField.setRequired(false);
		maxCommSizeField.setHidden(true);


		maxCommCountField = new DataSourceIntegerField("maxCommCount", "最大连接数");
		maxCommCountField.setLength(11);
		maxCommCountField.setRequired(false);
		maxCommCountField.setHidden(true);


		flashSizeField = new DataSourceTextField("flashSize", "内存大小");
		flashSizeField.setLength(32);
		flashSizeField.setRequired(false);
		flashSizeField.setHidden(true);


		freeFlashSizeField = new DataSourceTextField("freeFlashSize", "剩余空间");
		freeFlashSizeField.setLength(32);
		freeFlashSizeField.setRequired(false);
		freeFlashSizeField.setHidden(true);


		languageField = new DataSourceTextField("language", "语言");
		languageField.setLength(32);
		languageField.setRequired(false);
		languageField.setHidden(true);


		lngEncodeField = new DataSourceTextField("lngEncode", "语言编码");
		lngEncodeField.setLength(32);
		lngEncodeField.setRequired(false);
		lngEncodeField.setHidden(true);


		volumeField = new DataSourceTextField("volume", "音量");
		volumeField.setLength(32);
		volumeField.setRequired(false);
		volumeField.setHidden(true);


		platformField = new DataSourceTextField("platform", "平台");
		platformField.setLength(32);
		platformField.setRequired(false);
		platformField.setHidden(true);


		brightnessField = new DataSourceTextField("brightness", "亮度");
		brightnessField.setLength(32);
		brightnessField.setRequired(false);
		brightnessField.setHidden(true);


		oemVendorField = new DataSourceTextField("oemVendor", "生产商");
		oemVendorField.setLength(64);
		oemVendorField.setRequired(false);
		oemVendorField.setHidden(true);


		cityField = new DataSourceIntegerField("city", "城市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setHidden(true);


		agentIpaddressField = new DataSourceTextField("agentIpaddress", "代理IP");
		agentIpaddressField.setLength(64);
		agentIpaddressField.setRequired(false);
		agentIpaddressField.setHidden(true);


		ipaddressField = new DataSourceTextField("ipaddress", "IP地址");
		ipaddressField.setLength(64);
		ipaddressField.setRequired(false);
		ipaddressField.setHidden(false);


		ipPortField = new DataSourceIntegerField("ipPort", "端口号");
		ipPortField.setLength(11);
		ipPortField.setRequired(false);
		ipPortField.setHidden(true);


		comPortField = new DataSourceIntegerField("comPort", "网络端口");
		comPortField.setLength(11);
		comPortField.setRequired(false);
		comPortField.setHidden(true);


		baudrateField = new DataSourceIntegerField("baudrate", "波特率");
		baudrateField.setLength(11);
		baudrateField.setRequired(false);
		baudrateField.setHidden(true);


		comAddressField = new DataSourceIntegerField("comAddress", "区域");
		comAddressField.setLength(11);
		comAddressField.setRequired(false);
		comAddressField.setHidden(true);


		commPwdField = new DataSourceTextField("commPwd", "连接密码");
		commPwdField.setLength(64);
		commPwdField.setRequired(false);
		commPwdField.setHidden(true);


		acpanelTypeField = new DataSourceIntegerField("acpanelType", "Ac面板类型");
		acpanelTypeField.setLength(11);
		acpanelTypeField.setRequired(false);
		acpanelTypeField.setHidden(true);


		syncTimeField = new DataSourceIntegerField("syncTime", "同步时间");
		syncTimeField.setLength(11);
		syncTimeField.setRequired(false);
		syncTimeField.setHidden(true);


		mainTimeField = new DataSourceTextField("mainTime", "主时间");
		mainTimeField.setLength(32);
		mainTimeField.setRequired(false);
		mainTimeField.setHidden(true);


		transactionCountField = new DataSourceIntegerField("transactionCount", "传送次数");
		transactionCountField.setLength(11);
		transactionCountField.setRequired(false);
		transactionCountField.setHidden(true);


		lastActivityField = new DataSourceDateTimeField("lastActivity", "最后联机时间");
		lastActivityField.setRequired(false);
		lastActivityField.setHidden(false);


		transTimesField = new DataSourceTextField("transTimes", "传送时间");
		transTimesField.setLength(64);
		transTimesField.setRequired(false);
		transTimesField.setHidden(true);


		transIntervalField = new DataSourceIntegerField("transInterval", "传送间隔时间（分）");
		transIntervalField.setLength(11);
		transIntervalField.setRequired(false);
		transIntervalField.setHidden(true);


		logStampField = new DataSourceTextField("logStamp", "传送签到记录标记");
		logStampField.setLength(32);
		logStampField.setRequired(false);
		logStampField.setHidden(true);


		oplogStampField = new DataSourceTextField("oplogStamp", "传送用户数据标记");
		oplogStampField.setLength(32);
		oplogStampField.setRequired(false);
		oplogStampField.setHidden(true);


		photoStampField = new DataSourceTextField("photoStamp", "传送图像标记");
		photoStampField.setLength(32);
		photoStampField.setRequired(false);
		photoStampField.setHidden(true);


		fpversionField = new DataSourceTextField("fpversion", "指纹版本");
		fpversionField.setLength(32);
		fpversionField.setRequired(false);
		fpversionField.setHidden(true);


/*		enabledField = new DataSourceIntegerField("enabled", "设备是否可用");
		enabledField.setLength(11);
		enabledField.setRequired(false);
		enabledField.setHidden(true);
		enabledField.setValueMap(KeyValueManager.getValueMap("system_dictionary_89"));
		enabledField.setCanEdit(true);*/
		
		realtimeField = new DataSourceIntegerField("realtime", "实时上传数据");
		realtimeField.setLength(11);
		realtimeField.setRequired(false);
		realtimeField.setHidden(true);


		delayField = new DataSourceIntegerField("delay", "连接服务器的间隔时间");
		delayField.setLength(11);
		delayField.setRequired(false);
		delayField.setHidden(true);


		dstimeIdField = new DataSourceIntegerField("dstimeId", "打卡类型");
		dstimeIdField.setLength(11);
		dstimeIdField.setRequired(false);
		dstimeIdField.setHidden(true);


		updateDbField = new DataSourceTextField("updateDb", "数据库更新标记");
		updateDbField.setLength(32);
		updateDbField.setRequired(false);
		updateDbField.setHidden(true);


		changeOperatorField = new DataSourceIntegerField("changeOperator", "修改人");
		changeOperatorField.setLength(11);
		changeOperatorField.setRequired(false);
		changeOperatorField.setHidden(true);


		changeTimeField = new DataSourceDateTimeField("changeTime", "修改时间");
		changeTimeField.setRequired(false);
		changeTimeField.setHidden(true);


		createOperatorField = new DataSourceIntegerField("createOperator", "创建人");
		createOperatorField.setLength(11);
		createOperatorField.setRequired(false);
		createOperatorField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		deleteOperatorField = new DataSourceIntegerField("deleteOperator", "删除人");
		deleteOperatorField.setLength(11);
		deleteOperatorField.setRequired(false);
		deleteOperatorField.setHidden(true);


		deleteTimeField = new DataSourceDateTimeField("deleteTime", "删除时间");
		deleteTimeField.setRequired(false);
		deleteTimeField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(5);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_90"));

		tzadjField = new DataSourceIntegerField("tzadj", "时区");
		tzadjField.setLength(5);
		tzadjField.setRequired(false);
		tzadjField.setHidden(true);


		encryptField = new DataSourceIntegerField("encrypt", "encrypt");
		encryptField.setLength(11);
		encryptField.setRequired(false);
		encryptField.setHidden(true);
		
		isEnableField = new DataSourceIntegerField("isEnable", "是否可用");
		isEnableField.setLength(11);
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);
		isEnableField.setValueMap(KeyValueManager.getValueMap("system_dictionary_89"));
		isEnableField.setCanEdit(true);


		setFields(clockIdField, snField, deviceNameField, aliasField, ipaddressField, statusField, lastActivityField, fwVersionField, clockTypeIdField, userCountField, fpCountField, maxUserCountField, maxFingerCountField, maxAttlogCountField, maxCommSizeField, maxCommCountField, flashSizeField, freeFlashSizeField, languageField, lngEncodeField, volumeField, platformField, brightnessField, oemVendorField, cityField, agentIpaddressField, ipPortField, comPortField, baudrateField, comAddressField, commPwdField, acpanelTypeField, syncTimeField, mainTimeField, transactionCountField, transTimesField, transIntervalField, logStampField, oplogStampField, photoStampField, fpversionField,isEnableField, realtimeField, delayField, dstimeIdField, updateDbField, changeOperatorField, changeTimeField, createOperatorField, createTimeField, deleteOperatorField, deleteTimeField, tzadjField, encryptField);
	}


}

