package pomplatform.clocks.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClock;
import com.pomplatform.db.bean.BaseHrEmpFace;
import com.pomplatform.db.bean.BaseHrEmpFinger;
import com.pomplatform.db.dao.Clock;

import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseEmployee;

/**
 * 设备命令控制器 该类主要用于控制不同机器的命令下发。 由于生产厂商的不同，所以不同的机器的命令也不一样，
 * 而系统的功能是一样的，控制下发的命令必须和对应的设备统一才行
 * @author lxf
 * 
 */
public class CmdController {
	private static Logger log = Logger.getLogger(CmdController.class);
	/**
	 * 定义设备统一命令标识符
	 */
	// 传送设备上的人员数据
	public static final int CMD_CHECK = 3;
	// 传送设备上的考勤数据
	public static final int CMD_ATTLOG = 4;
	// 检查并传送新数据
	public static final int CMD_LOG = 6;
	// 更新设备信息
	public static final int CMD_INFO = 8;
	// 重启设备
	public static final int CMD_REBOOT = 7;
	// 清除设备上的数据
	public static final int CMD_CLEARDATA = 9;
	// 清除设备上的考勤记录
	public static final int CMD_CLEARLOG = 10;
	// 清除设备上的照片
	public static final int CMD_CLEARPHOTO = 11;
	// 下发人员到设备
	protected static final int CMD_SENDUSER = 100;
	// 删除设备人员
	protected static final int CMD_DELUSER = 200;
	// 修改人员信息
	protected static final int CMD_UPDATEUSER = 300;

	// 设备信息
	private BaseClock clock;
	// 操作人ID
	private String userId;

	public CmdController() {

	}

	public CmdController(BaseClock clock, String userId) {
		this.clock = clock;
		this.userId = userId;
	}

	/**
	 * 根据设备标识和命令标识，返回相应的命令.主要针对一键操作命令：如重启设备
	 * 
	 * @param cmd:命令标识符
	 * @return
	 * @throws Exception 
	 */
	public void clockCmd(int cmd) throws Exception {
		String c = "";
		// 获取命令
		ZKDevice zkd = new ZKDevice();
		c = zkd.getCmd(cmd);
		// 保存命令
		zkd.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		Clock dao = new Clock();
		dao.setConditionSn("=",clock.getSn());
		clock = dao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(clock)){
			if (cmd == CMD_CHECK) {
				clock.setOplogStamp("");
			} else if (cmd == CMD_ATTLOG) {
				clock.setLogStamp("");
			}
			dao.clear();
			dao.setDataFromBase(clock);
			dao.update();
			// 对机器发送信号
			clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
		}
	}

	/**
	 * 向设备添加人员
	 * 
	 * @param emp：人员信息
	 * @throws Exception 
	 */
	public void sendUser(BaseEmployee emp) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.sendUser(emp);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 删除设备人员
	 * 
	 * @param emp:人员信息
	 * @throws Exception 
	 */
	public void delUser(String code) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.delUser(code);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "0");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 修改设备人员
	 * 
	 * @param emp:人员信息
	 * @throws Exception 
	 */
	public void updateUser(BaseEmployee emp) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.updateUser(emp);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 下发人脸到设备
	 * @throws Exception 
	 */
	public void sendFace(BaseHrEmpFace face) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.sendFace(face);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 下发指纹到设备
	 * 
	 * @param face
	 * @throws Exception 
	 */
	public void sendFinger(BaseHrEmpFinger finger) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.sendFinger(finger);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 删除设备上的人员指纹
	 * 
	 * @param finger
	 * @throws Exception 
	 */
	public void delFinger(String code,int fid) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.delFinger(code,fid);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 删除设备上的人脸
	 * 
	 * @param face
	 * @throws Exception 
	 */
	public void delFace(String code) throws Exception {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.delFace(code);
		zki.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
		ClockMsgProcess clockService = new ClockMsgProcess();
		// 对机器发送信号
		clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
	}

	/**
	 * 设置打卡间隔时间
	 * @param minute:分钟
	 */
	public void setAlarmReRec(int minute) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.setAlarmReRec(minute);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
//		ZKClockService clockService = ZKClockService.getInstance();
//		try {
//			clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
//		} catch (BusinessRuleException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 按时间段传送考勤数据
	 * 
	 * @param starttime
	 * @param endtime
	 */
	public void queryAttLog(String starttime, String endtime) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.queryAttLog(starttime, endtime);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
//		ZKClockService clockService = ZKClockService.getInstance();
//		try {
//			clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
//		} catch (BusinessRuleException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 考勤对账
	 * 
	 * @param starttime
	 * @param endtime
	 */
	public void queryAttLog(String starttime, String endtime, String count) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.queryAttLog(starttime, endtime, count);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
//		ZKClockService clockService = ZKClockService.getInstance();
//		try {
//			clockService.UDPSendMsgToMac(clock.getIpaddress(), 4374, "R-CMD" + "\n");
//		} catch (BusinessRuleException e) {
//			e.printStackTrace();
//		}

	}

	/**
	 * 下发时间段
	 * 
	 * @param group
	 */
//	public void timeZone(AccTimesGroup group) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.timeZone(group);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
//	}

	/**
	 * 门禁人员信息
	 * 
	 * @param emp
	 * @param startTime
	 * 有效时间段
	 * @param endTime
	 */
	public void accUser(BaseEmployee emp, String startTime, String endTime) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.accUser(emp, startTime, endTime);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	/**
	 * 人员门禁授权
	 * 
	 * @param pin
	 * @param list
	 * @param timeZone
	 *            时间ID
	 */
//	public void userAuthorize(String pin, List<AccPermissionGroup> list, String timeZone) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.userAuthorize(pin, list, timeZone);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
//	}

	/**
	 * 门禁指纹信息
	 * 
	 * @param finger
	 */
	public void accFinger(BaseHrEmpFinger finger) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.accFinger(finger);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	/**
	 * 节假日
	 * 
	 * @param list
	 */
//	public void holiday(List<BaseHoliday> list) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.holiday(list);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
//	}

	/**
	 * 删除时间段
	 * 
	 * @param timeZoneId
	 * @return
	 */
	public void delTimeZone(String timeZoneId) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.delTimeZone(timeZoneId);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	/**
	 * 删除节假日
	 * 
	 * @param
	 * @return
	 */
	public void delHoliday() {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.delHoliday();
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	/**
	 * 删除门禁事件记录
	 * 
	 * @return
	 */
	public void delTransaction() {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.delTransaction();
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	/**
	 * 删除授权
	 * 
	 * @param PIN
	 * @param authorizeDoorId
	 * @return
	 */
	public void delUserAuthorize(String PIN, String authorizeDoorId) {
//		String c = "";
//		CmdInterface zki = new ZKDevice();
//		c = zki.delUserAuthorize(PIN, authorizeDoorId);
//		CmdFactory zkf = new ZKDevice();
//		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	/**
	 * 设置
	 * 
	 * @param options
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	public void setOptions(String options) throws NumberFormatException, SQLException {
		String c = "";
		ZKDevice zki = new ZKDevice();
		c = zki.setOptions(options);
		ZKDevice zkf = new ZKDevice();
		zkf.saveRecevieCmdsService(clock.getSn(), Long.valueOf(userId), c, "1");
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BaseClock getClock() {
		return clock;
	}

	public void setClock(BaseClock clock) {
		this.clock = clock;
	}

}
