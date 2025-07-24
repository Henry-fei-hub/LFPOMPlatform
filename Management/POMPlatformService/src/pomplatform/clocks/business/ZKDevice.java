package pomplatform.clocks.business;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.pomplatform.db.bean.BaseClockRecevieCmd;
import com.pomplatform.db.bean.BaseHrEmpFace;
import com.pomplatform.db.bean.BaseHrEmpFinger;
import com.pomplatform.db.dao.ClockRecevieCmd;

import delicacy.system.bean.BaseEmployee;


/**
 * 中控设备命令
 * 
 * @author lxf
 * 
 */
public class ZKDevice {

	/**
	 * 根据命令标识，返回相应命令
	 * 
	 * @param cmd
	 * @return
	 */
	public String getCmd(int cmd) {
		String c = "";
		switch (cmd) {
		case CmdController.CMD_CHECK:
			c = ZKSDKCmd.CHECK();
			break;
		case CmdController.CMD_ATTLOG:
			c = ZKSDKCmd.CHECK();
			break;

		case CmdController.CMD_LOG:
			c = ZKSDKCmd.LOG();
			break;
		case CmdController.CMD_INFO:
			c = ZKSDKCmd.INFO();
			break;

		case CmdController.CMD_REBOOT:
			c = ZKSDKCmd.REBOOT();
			break;

		case CmdController.CMD_CLEARDATA:
			c = ZKSDKCmd.CLEARDATA();
			break;

		case CmdController.CMD_CLEARLOG:
			c = ZKSDKCmd.CLEARLOG();
			break;

		case CmdController.CMD_CLEARPHOTO:
			c = ZKSDKCmd.CLEARPHOTO();
			break;

		default:
			break;
		}
		return c;
	}

	/**
	 * 删除设备人员信息命令
	 * 
	 * @param hrEmp
	 * @return
	 */
	public String delUser(String code) {
		return ZKSDKCmd.DATA_DEL_USER(code);
	}

	/**
	 * 下发人员信息到设备命令
	 * 
	 * @param hrEmp
	 * @return
	 */
	public String sendUser(BaseEmployee hrEmp) {
		return ZKSDKCmd.empInfo2MacStr(hrEmp);
	}

	/**
	 * 修改人员信息命令
	 * 
	 * @param hrEmp
	 * @return
	 */
	public String updateUser(BaseEmployee hrEmp) {
		return ZKSDKCmd.empInfo2MacStr(hrEmp);
	}

	/**
	 * 下发人脸到设备命令
	 * 
	 * @param face
	 * @return
	 */
	public String sendFace(BaseHrEmpFace face) {
		return ZKSDKCmd.empFace2MacStr(face);
	}

	/**
	 * 下发人员指纹到设备命令
	 * 
	 * @param finger
	 * @return
	 */
	public String sendFinger(BaseHrEmpFinger finger) {
		return ZKSDKCmd.empTemp2MacStr(finger);
	}

	/**
	 * 删除设备上的人员指纹
	 * 
	 * @param finger
	 * @return
	 */
	public String delFinger(String code,int fid) {
		return ZKSDKCmd.DATA_DEL_FP(code,fid);
	}

	/**
	 * 删除设备上的人脸
	 * 
	 * @param employeeId
	 * @return
	 */
	public String delFace(String code) {
		return ZKSDKCmd.DATA_DEL_FC(code);
	}

	/**
	 * 修改设备名称
	 * 
	 * @param deviceName
	 * @return
	 */
	public String updateDeviceName(String deviceName) {
		return null;
	}

	/**
	 * 设置打开时间间隔分钟数
	 * 
	 * @param minute
	 * @return
	 */
	public String setAlarmReRec(int minute) {
		return ZKSDKCmd.ALARMREREC(minute);
	}

	/**
	 * 按时间端传输考勤数据
	 * 
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public String queryAttLog(String starttime, String endtime) {
		return ZKSDKCmd.QUERYATTCOUNT(starttime, endtime);
	}

	/**
	 * 考勤对账
	 * 
	 * @param starttime
	 * @param endtime
	 * @param count
	 * @return
	 */
	public String queryAttLog(String starttime, String endtime, String count) {
		return ZKSDKCmd.QUERYATTCOUNT(starttime, endtime, count);
	}

	/**
	 * 参数设置
	 * 
	 * @param doorId
	 * @return
	 */
	public String setOptions(String setOptions) {
		return setOptions;
	}

	/**
	 * 中控设备保存下发命令到数据库 1：为正常，0：为删除人员命令，需做特殊处理
	 * 
	 * @param sn
	 * @param userId
	 * @throws SQLException 
	 * @throws PresentationRuleException
	 */
	public void saveRecevieCmdsService(String sn, Long userId, String cmd, String cmdType) throws SQLException {
		ClockRecevieCmd dao = new ClockRecevieCmd();
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		bean.setCmdContent(cmd);
		bean.setCmdCommitTime(new Timestamp(System.currentTimeMillis()));
		bean.setSuccessFlag(new Short("1"));
		bean.setStatus(new Short("1"));
		bean.setSn(sn);
		bean.setUserId(userId);
		bean.setCmdType(Short.valueOf(cmdType));
		dao.setDataFromBase(bean);
		dao.save();
	}

}
