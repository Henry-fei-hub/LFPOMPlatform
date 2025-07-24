package pomplatform.clocks.business;

import com.pomplatform.db.bean.BaseHrEmpFace;
import com.pomplatform.db.bean.BaseHrEmpFinger;

import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseEmployee;

public class ZKSDKCmd {

	/**
	 * 上传 某一时间段的考勤数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String QUERYATTCOUNT(String startTime, String endTime) {
		String ret = "DATA QUERY ATTLOG StartTime=" + startTime;
		ret += " EndTime=" + endTime;
		return ret;
	}

	/**
	 * 考勤对账
	 * 
	 * @param startTime
	 * @param endTime
	 * @param count
	 *            服务器条数
	 *            设置执行该命令后会返回设备上该时间段的考勤数据总条数，如果设备上的考勤数据大于服务器，则会重新传送该时间段的考勤数据。
	 * @return
	 */
	public static String QUERYATTCOUNT(String startTime, String endTime, String count) {
		String ret = "ACCOUNT Start=" + startTime + " End=" + endTime + " Count=" + count;
		return ret;
	}

	/**
	 * 允许打卡的时间间隔 min间隔分钟数
	 * 
	 * @return
	 */
	public static String ALARMREREC(int minute) {
		return "SET OPTION AlarmReRec=" + minute;
	}

	/**
	 * 检查数据更新
	 * 
	 * @return
	 */
	public static String CHECK() {
		return "CHECK";
	}

	/**
	 * 更新设备信息
	 * 
	 * @return
	 */
	public static String INFO() {
		return "INFO";
	}

	/**
	 * 检查并传送新数据
	 * 
	 * @return
	 */
	public static String LOG() {
		return "LOG";
	}

	/**
	 * 重启设备
	 * 
	 * @return
	 */
	public static String REBOOT() {
		return "REBOOT";
	}

	/**
	 * 清除设备考勤记录
	 * 
	 * @return
	 */
	public static String CLEARLOG() {
		return "CLEAR LOG";
	}

	/**
	 * 清除设备照片
	 * 
	 * @return
	 */
	public static String CLEARPHOTO() {
		return "CLEAR PHOTO";
	}

	/**
	 * 清除设备数据
	 * 
	 * @return
	 */
	public static String CLEARDATA() {
		return "CLEAR DATA";
	}

	/**
	 * 删除设备指定用户信息和指纹
	 * 
	 * @param PIN
	 *            人员编号
	 * @return 删除命令
	 */
	public static String DATA_DEL_USER(String PIN) {
		String cmd = "DATA DEL_USER PIN=" + PIN;
		return cmd;
	}

	/**
	 * 删除设备用户指纹
	 * 
	 * @param PIN
	 *            人员编号
	 * @param FID
	 *            指纹序号
	 * @return 删除命令
	 */
	public static String DATA_DEL_FP(String PIN, int FID) {
		// 指纹信息
		String ret = "DATA DEL_FP PIN=" + PIN;
		ret += "\tFID=" + FID;// 指纹序号
		ret += "\n";
		return ret;
	}

	/**
	 * 删除设备上的人脸
	 * 
	 * @param PIN
	 * @return
	 */
	public static String DATA_DEL_FC(String PIN) {
		String ret = "DATA DELETE FACE PIN=" + PIN;
		return ret;
	}

	/**
	 * 下发人员信息
	 * 
	 * @return 返回机器识别的字符串
	 */
	public static String empInfo2MacStr(BaseEmployee emp) {
		// 员工信息
		String cmd = "DATA USER PIN=";
		if(ClockMsgProcess.isSendDataByNo){
			cmd += emp.getEmployeeNo();
		}else{
			cmd += emp.getEmployeeId();
		}
		cmd += "\tName=";
		cmd += emp.getEmployeeName();
		cmd += "\tPasswd=";
		cmd += "666888";
		cmd += "\tGrp=";
		cmd += 0;
		cmd += "\tCard=[" + EncodeCard("0") + "] Pri=";
		cmd += 0;
		cmd += "\n";
		return cmd;
	}

	/**
	 * 下发指纹
	 * 
	 * @return 返回机器识别的字符串
	 */
	public static String empTemp2MacStr(BaseHrEmpFinger finger) {
		String code = null;
		if(ClockMsgProcess.isSendDataByNo){
			code = finger.getEmpCode();
		}else{
			code = finger.getEmployeeId()+"";
		}
		// 指纹信息
		String cmd = "DATA FP PIN=" + code;// 用户考勤号码（id）
		cmd += "\tValid=" + finger.getValid();// 当前指纹是否可以用
		cmd += "\tSize=" + finger.getTemplate().length();// 指纹大小
		cmd += "\tFID=" + finger.getFid();// 指纹序号
		cmd += "\tTMP=" + finger.getTemplate();// 指纹模板
		cmd += "\n";
		return cmd;
	}

	/**
	 * 下发人脸
	 * 
	 * @return 返回机器识别的字符串
	 */
	public static String empFace2MacStr(BaseHrEmpFace face) {
		String code = null;
		if(ClockMsgProcess.isSendDataByNo){
			code = face.getEmpCode();
		}else{
			code = face.getEmployeeId()+"";
		}
		String ret = "DATA UPDATE FACE PIN=" + code;// 用户考勤号码（id）
		ret += "\tFID=" + face.getFid();// 人脸序号
		ret += "\tSIZE=" + face.getSize();// 人脸大小
		ret += "\tTMP=" + face.getTmp();// 人脸模板
		ret += "\tVALID=" + face.getValid();// 当前人脸是否可以用
		ret += "\n";
		return ret;
	}

	/**
	 * 卡号处理
	 * 
	 * @param cardNo
	 * @return
	 */
	public static String EncodeCard(String cardNo) {
		String scardno = "";
		if (BaseHelpUtils.isNullOrEmpty(cardNo)) {
			long cardno = new Long(cardNo);
			long itemp = 0;
			// char[] abc = dd.ToCharArray();
			char[] dda = new char[10];
			for (int i = 0; i < 10; i++) {
				dda[i] = '0';
			}
			for (int i = 0; i < 4; i++) {
				itemp = (cardno >> (i * 8)) & 0xff;
				if (itemp <= 0x0f)
					scardno += "0";
				scardno += Long.toHexString(itemp);
			}
			return scardno += "00";
		}
		return "";
	}
}
