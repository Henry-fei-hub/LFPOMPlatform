package pomplatform.clocks.business;

import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseClock;
import com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail;
import com.pomplatform.db.bean.BaseHrEmpFace;
import com.pomplatform.db.bean.BaseHrEmpFinger;
import com.pomplatform.db.dao.Clock;
import com.pomplatform.db.dao.ClockRecevieCmd;
import com.pomplatform.db.dao.EmployeeCheckinoutDetail;
import com.pomplatform.db.dao.HrEmpFace;
import com.pomplatform.db.dao.HrEmpFinger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

public class ClockMsgProcess implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";
	public final static String RESEND_CMD = "resendCmd";//重新下发
	public final static String RESEND_ALL_CMD = "resendAllCmd";//一键下发
	public final static String CHECK_DATA_UPDATE = "checkDataUpdate";//检查数据更新
	public final static String CLEAR_DATA = "clearData";//清除数据
	public final static String CHECK_CLOCK_INFO = "checkClockInfo";//检查设备信息
	public final static String CLOCK_REBOOT = "clockReboot";//设备重启
	public final static String CHECK_AND_SEND_NEW_DATA = "checkAndSendNewData";//检查并传送新数据
	public final static String CLEAR_LOG = "clearLog";//清除设备上的考勤记录
	public final static String CLEAR_PHOTO = "clearPhoto";//清楚设备上的照片
	public final static String ON_DELETE_EMPLOYEE_FINGER = "onDeleteEmployeeFinger";//员工指纹删除
	public final static String ON_DELETE_EMPLOYEE_FACE = "onDeleteEmployeeFace";//员工人脸删除
	public final static String ON_SAVE_EMP_TO_CLOCK = "onSaveEmpToClock";//下发人员到设备的保存
	public final static String DELETE_ALL_CMD = "deleteAllCmd";//一键删除
	public static boolean isSendDataByNo = false;//设备上传数据是否按编号关联，默认按ID关联

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		if (RESEND_CMD.equals(optType)) {
			return resendCmd(params);
		} else if (RESEND_ALL_CMD.equals(optType)) {
			return resendAllCmd();
		} else if(CHECK_DATA_UPDATE.equals(optType)){
			return onClockOperate(params);
		} else if(CLEAR_DATA.equals(optType)){
			return onClockOperate(params);
		} else if(CHECK_CLOCK_INFO.equals(optType)){
			return onClockOperate(params);
		} else if(CLOCK_REBOOT.equals(optType)){
			return onClockOperate(params);
		} else if(CHECK_AND_SEND_NEW_DATA.equals(optType)){
			return onClockOperate(params);
		} else if(CLEAR_LOG.equals(optType)){
			return onClockOperate(params);
		} else if(CLEAR_PHOTO.equals(optType)){
			return onClockOperate(params);
		} else if(ON_DELETE_EMPLOYEE_FINGER.equals(optType)){
			return onDeleteEmployeeFinger(params);
		} else if(ON_DELETE_EMPLOYEE_FACE.equals(optType)){
			return onDeleteEmployeeFace(params);
		} else if(ON_SAVE_EMP_TO_CLOCK.equals(optType)){
			return onSaveEmpToClock(params);
		} else if(DELETE_ALL_CMD.equals(optType)){
			return deleteAllCmd();
		}
		return null;
	}
	
	/**
	 * 下发人员到设备的保存
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public String onSaveEmpToClock(Map<String,Object> param) throws Exception{
		//获取设备序列号
		String sn = BaseHelpUtils.getStringValue(param, "sn");
		//获取操作人id
		String operateEmployeeId = BaseHelpUtils.getStringValue(param, "operateEmployeeId");
		//获取要下发的设备列表
		List<BaseClock> clockList = GenericBase.__getList(param.get("clockList"),BaseClock.newInstance());
		//获取要下发的人员列表
		List<BaseEmployee> employeeList = GenericBase.__getList(param.get("employeeList"),BaseEmployee.newInstance());
		if(BaseHelpUtils.isNullOrEmpty(clockList)){//说明设备列表为空，则跑出异常
			throw new SQLException("操作异常：设备列表不可为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(employeeList)){//说明人员列表为空，则跑出异常
			throw new SQLException("操作异常：人员列表不可为空");
		}
		//开始遍历要下发的设备列表
		for(BaseClock clock : clockList){
			//获取设备类型
			int clockTypeId =  BaseHelpUtils.getIntValue(clock.getClockTypeId());
			CmdController co = new CmdController();
			co.setClock(clock);
			co.setUserId(operateEmployeeId);
			//开始遍历人员列表
			for(BaseEmployee e : employeeList){
				//获取employeeId
				int employeeId = e.getEmployeeId();
				//下发人员
				Employee employeeDao = new Employee();
				employeeDao.setConditionEmployeeId("=", employeeId);
				BaseEmployee employee = employeeDao.executeQueryOneRow();
				co.sendUser(employee);
				if(clockTypeId == 0){//如果为考勤机，则下发人脸
					//下发人脸
					HrEmpFace faceDao = new HrEmpFace();
					faceDao.setConditionEmployeeId("=",employeeId);
					List<BaseHrEmpFace> list = faceDao.conditionalLoad("order by "+BaseHrEmpFace.CS_FID+" asc");
					if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
						for(BaseHrEmpFace face : list){
							co.sendFace(face);
						}
					}
				}
				//下发指纹
				HrEmpFinger fingerDao = new HrEmpFinger();
				fingerDao.setConditionEmployeeId("=",employeeId);
				List<BaseHrEmpFinger> fingerList = fingerDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(fingerList) && fingerList.size() > 0){
					for(BaseHrEmpFinger finger : fingerList){
						co.sendFinger(finger);
					}
				}
			}
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}
	
	/**
	 * 删除员工人脸
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public String onDeleteEmployeeFace(Map<String, Object> param) throws Exception{
		//获取操作人id
		String operateEmployeeId = BaseHelpUtils.getStringValue(param, "operateEmployeeId");
		//获取人员id
		int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
		//检索设备数据
		Clock clockDao = new Clock();
		List<BaseClock> clockList = clockDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(clockList) && clockList.size() > 0 ){
			//删除员工指纹在数据库中的数据
			HrEmpFace dao = new HrEmpFace();
			dao.setConditionEmployeeId("=",employeeId);
			if(dao.countRows() > 0){//说明数据库中有数据
				BaseHrEmpFace bean = dao.executeQueryOneRow();
				String code = null;
				if(isSendDataByNo){
					code = bean.getEmpCode();
				}else{
					code = employeeId+"";
				}
				//删除数据库中数据
				dao.conditionalDelete();
				//删除该员工在所有设备中的指纹数据
				for(BaseClock e : clockList){
					CmdController co = new CmdController();
					co.setClock(e);
					co.setUserId(operateEmployeeId);
					co.delFace(code);
				}
			}else{
				throw new SQLException("操作异常：未检索到该员工的人脸数据");
			}
		}else{
			throw new SQLException("操作异常：未检索到设备信息");
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}
	
	/**
	 * 删除员工指纹
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public String onDeleteEmployeeFinger(Map<String, Object> param) throws Exception{
		//获取操作人id
		String operateEmployeeId = BaseHelpUtils.getStringValue(param, "operateEmployeeId");
		//获取人员id
		int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
		//获取指纹序列号
		int fid = BaseHelpUtils.getIntValue(param, "fid");
		//检索设备数据
		Clock clockDao = new Clock();
		List<BaseClock> clockList = clockDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(clockList) && clockList.size() > 0 ){
			//删除员工指纹在数据库中的数据
			HrEmpFinger dao = new HrEmpFinger();
			dao.setConditionEmployeeId("=",employeeId);
			dao.setConditionFid("=",fid);
			if(dao.countRows() > 0){//说明数据库中有数据
				BaseHrEmpFinger bean = dao.executeQueryOneRow();
				String code = null;
				if(isSendDataByNo){
					code = bean.getEmpCode();
				}else{
					code = employeeId+"";
				}
				//删除数据库中数据
				dao.conditionalDelete();
				//删除该员工在所有设备中的指纹数据
				for(BaseClock e : clockList){
					CmdController co = new CmdController();
					co.setClock(e);
					co.setUserId(operateEmployeeId);
					co.delFinger(code,fid);
				}
			}else{
				throw new SQLException("操作异常：未检索到该员工的指纹数据");
			}
		}else{
			throw new SQLException("操作异常：未检索到设备信息");
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}

	/**
	 * 设备操作
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	public String onClockOperate(Map<String, Object> param) throws Exception {
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(param, OPT_TYPE);
		// 获取设备序列号
		String sn = BaseHelpUtils.getStringValue(param, "sn");
		// 获取操作人id
		String employeeId = BaseHelpUtils.getStringValue(param, "operateEmployeeId");
		// 检索设备信息
		Clock clockDao = new Clock();
		clockDao.setConditionSn("=", sn);
		BaseClock clock = clockDao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(clock)) {// 说明设备存在
			CmdController co = new CmdController();
			co.setClock(clock);
			co.setUserId(employeeId);
			if (CHECK_DATA_UPDATE.equals(optType)) {
				co.clockCmd(co.CMD_ATTLOG);
			} else if (CLEAR_DATA.equals(optType)) {
				co.clockCmd(co.CMD_CLEARDATA);
			} else if (CHECK_CLOCK_INFO.equals(optType)) {
				co.clockCmd(co.CMD_INFO);
			} else if (CLOCK_REBOOT.equals(optType)) {
				co.clockCmd(co.CMD_REBOOT);
			} else if (CHECK_AND_SEND_NEW_DATA.equals(optType)) {
				co.clockCmd(co.CMD_LOG);
			} else if (CLEAR_PHOTO.equals(optType)) {
				co.clockCmd(co.CMD_CLEARPHOTO);
			} else if (CLEAR_LOG.equals(optType)) {
				co.clockCmd(co.CMD_CLEARLOG);
			}
		} else {
			throw new SQLException("操作异常：设备不存在");
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}

	/**
	 * 重新下发
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public String resendCmd(Map<String,Object> param) throws SQLException{
		ClockRecevieCmd dao = new ClockRecevieCmd();
		int clockRecevieCmdId = BaseHelpUtils.getIntValue(param.get("clockRecevieCmdId"));
		dao.setClockRecevieCmdId(clockRecevieCmdId);
		dao.setCmdReturn(1);
		dao.setSuccessFlag((short) 1);
		dao.update();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,"");
	}
	
	/**
	 * 一键下发
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public String resendAllCmd() throws Exception{
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setConditionCmdReturn("<>",0);
		dao.setConditionSuccessFlag("<>",(short) 1);
		dao.setCmdReturn(1);
		dao.setSuccessFlag((short) 1);
		dao.conditionalUpdate();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,"");
	}
	
	/**
	 * 一键删除
	 * @return
	 * @throws Exception
	 */
	public String deleteAllCmd() throws Exception{
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setConditionClockRecevieCmdId(">",0);
		dao.conditionalDelete();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,"");
	}
	
	/**
	 * 上传考勤记录
	 * @param scc
	 * @param sn
	 * @return
	 * @throws SQLException 
	 */
	public static int FindAttInfo(String scc, String sn) throws SQLException {
		String[] sp = scc.split("\n");
		for (int i = 0; i < sp.length; i++) {
			String[] att = sp[i].split("\t");
			if (att.length >= 4) {
				OnInsertCheckinout(att[0].trim(), att[1].trim());
			}
		}
		return sp.length;
	}
	
	/**
	 * 考勤机上来的记录插入到刷卡明细表
	 * @param code：员工编号或者ID
	 * @param time：打卡时间
	 * @return
	 * @throws SQLException 
	 */
	public static String OnInsertCheckinout(String code, String time) throws SQLException {
		Timestamp checkTime = Timestamp.valueOf(time);
		String ret = "";
		Employee empDao = new Employee();
		int employeeId = 0;
		if(isSendDataByNo){
			String employeeNo = BaseHelpUtils.getString(code);
			empDao.setConditionEmployeeNo("=",employeeNo);
			BaseEmployee empBean = empDao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(empBean)){
				employeeId = BaseHelpUtils.getIntValue(empBean.getEmployeeId());
			}
		}else{
			employeeId = BaseHelpUtils.getIntValue(code);
		}
		if (employeeId > 0) {// 说明该员工已经入数据库
			EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
			dao.setConditionEmployeeId("=", employeeId);
			dao.setConditionCheckTime("=", checkTime);
			if(!dao.isExist()) {
				BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
				bean.setEmployeeId(employeeId);
				bean.setCheckDate(checkTime);
				bean.setCheckTime(checkTime);
				bean.setOperateTime(new Date());
				dao.clear();
				dao.setDataFromBase(bean);
				dao.save();
			}
			ret = "success";
		}
		return ret;
	}

	/**
	 * 获取机器传上来的用户和指纹信息，保存到数据库
	 * 
	 * @param scc
	 * @param sn
	 * @return
	 * @throws SQLException 
	 * @throws BusinessRuleException
	 */
	public static int FindUserInfo(String scc, String sn) throws SQLException{
		String[] AllRecord = FindAttInfoStr(scc);
		String OneRecordStr;
		int jk = AllRecord.length;
		for (int ls = 0; ls < jk; ls++) {
			OneRecordStr = AllRecord[ls];
			if (OneRecordStr == null) {
				continue;
			}
			String[] ret;
			//获取用户信息，但目前不需要从设备上传人员数据，需从平台上录入人员数据后下发至设备
			if (OneRecordStr.indexOf("USER PIN", 0) >= 0) {
				continue;
			//获取用户指纹信息
			}else if (OneRecordStr.indexOf("FP PIN", 0) >= 0) {
				//获取用户指纹信息
				ret = GetUserTmp(OneRecordStr);
				if (ret != null && ret.length > 0) {
					// 写用户指纹信息到数据库
					OnInsertEmpFinger(ret, sn);
				}
			}else if (OneRecordStr.indexOf("FACE PIN", 0) >= 0) {
				//获取用户人脸信息
				ret = GetUserFace(OneRecordStr);
				if (ret != null && ret.length > 0) {
					// 写用户人脸到数据库
					OnInsertEmpFace(ret, sn);
				}
			}

		}
		return jk;
	}
	
	/**
	 * 考勤机上传的人脸信息插入到员工人脸表中
	 * @param tmp
	 * @param sn
	 * @return
	 * @throws SQLException
	 */
	public static String OnInsertEmpFace(String[] tmp, String sn) throws SQLException {
		String ret = "";
		if (!BaseHelpUtils.isNullOrEmpty(tmp)) {
			int i = tmp.length;
			if (i > 0) {
				Employee empDao = new Employee();
				BaseEmployee empBean = null;
				HrEmpFace dao = new HrEmpFace();
				BaseHrEmpFace bean = new BaseHrEmpFace();
				int employeeId = 0;
				if(isSendDataByNo){
					String employeeNo = BaseHelpUtils.getString(tmp[0]);
					empDao.setConditionEmployeeNo("=",employeeNo);
					if(empDao.countRows() == 1){
						empBean = empDao.executeQueryOneRow();
						employeeId = BaseHelpUtils.getIntValue(empBean.getEmployeeId());
					}
				}else{
					// 获取员工主键ID
					employeeId = BaseHelpUtils.getIntValue(tmp[0]);
					empDao.setEmployeeId(employeeId);
					if(empDao.load()){
						empBean = empDao.generateBase();
					}
				}
				empDao.setEmployeeId(employeeId);
				if (!BaseHelpUtils.isNullOrEmpty(empBean) && employeeId > 0) {// 说明该员工已经存在数据库
					String template = tmp[4];
					dao.setConditionEmployeeId("=", employeeId);
					// 检索该人脸是否已经保存数据库
					if (dao.countRows() == 0) {// 说明没有入库
						bean.setEmployeeId(employeeId);
						bean.setEmpCode(empDao.getEmployeeNo());
						bean.setFid(BaseHelpUtils.getIntValue(tmp[1]));
						bean.setSize(BaseHelpUtils.getIntValue(tmp[2]));
						bean.setValid(BaseHelpUtils.getIntValue(tmp[3]));
						bean.setTmp(template);
						bean.setSn(sn);
						dao.clear();
						dao.setDataFromBase(bean);
						dao.save();
						ret = "success";
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * 考勤机上传的指纹信息插入到员工指纹表中
	 * @param tmp
	 * @param sn
	 * @return
	 * @throws SQLException 
	 */
	public static String OnInsertEmpFinger(String[] tmp, String sn) throws SQLException {
		String ret = "";
		if (!BaseHelpUtils.isNullOrEmpty(tmp)) {
			int i = tmp.length;
			if (i > 0) {
				Employee empDao = new Employee();
				BaseEmployee empBean = null;
				HrEmpFinger dao = new HrEmpFinger();
				BaseHrEmpFinger bean = new BaseHrEmpFinger();
				int employeeId = 0;
				if(isSendDataByNo){
					String employeeNo = BaseHelpUtils.getString(tmp[0]);
					empDao.setConditionEmployeeNo("=",employeeNo);
					if(empDao.countRows() == 1){
						empBean = empDao.executeQueryOneRow();
						employeeId = BaseHelpUtils.getIntValue(empBean.getEmployeeId());
					}
				}else{
					// 获取员工主键ID
					employeeId = BaseHelpUtils.getIntValue(tmp[0]);
					empDao.setEmployeeId(employeeId);
					if(empDao.load()){
						empBean = empDao.generateBase();
					}
				}
				if (!BaseHelpUtils.isNullOrEmpty(empBean) && employeeId > 0) {// 说明该员工已经存在数据库
					String template = tmp[4];
					int fid = BaseHelpUtils.getIntValue(tmp[1]);
					dao.setConditionEmployeeId("=", employeeId);
					dao.setConditionFid("=",fid);
					// 检索该指纹是否已经保存数据库
					if (dao.countRows() == 0) {// 说明没有入库
						bean.setEmployeeId(employeeId);
						bean.setEmpCode(empDao.getEmployeeNo());
						bean.setFingerType(BaseHelpUtils.getIntValue(tmp[1]));
						bean.setValid(BaseHelpUtils.getIntValue(tmp[3]));
						bean.setTemplate(template);
						bean.setFid(fid);
						bean.setSn(sn);
						bean.setFpversion(10);
						dao.clear();
						dao.setDataFromBase(bean);
						dao.save();
						ret = "success";
					}
				}
			}
		}
		return ret;
	}

	/**
	 * 解析用户信息
	 * 
	 * @param str
	 * @return
	 */
	public String[] GetUser(String str) {
		String[] ret = null;
		String[] users = { "USER PIN", "Name", "Pri", "Passwd", "Card", "Grp", "TZ" };
		ret = getAttrubute("\t", str, users);
		return ret;

	}

	/**
	 * 用户信息数据解析 USER PIN=23 Name=测贾 Passwd= Card= Grp=1 TZ=0001000100000000
	 * Pri=0"
	 * 
	 * @param split
	 * @param str:原始数据
	 * @param key:需要解析的属性值
	 * @return
	 */
	public static String[] getAttrubute(String split, String str, String[] key) {
		final String s = str;
		String arr[] = s.split(split);
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i].indexOf("=");
			if (arr[i].trim().equals("")) {
				continue;
			}
			String k = arr[i].substring(0, index);
			for (int j = 0; j < key.length; j++) {
				if (key[j].equalsIgnoreCase(k)) {
					key[j] = arr[i].substring(index + 1);
				}
			}

		}
		return key;
	}

	/**
	 * 解析人脸信息
	 * 
	 * @param str
	 * @return
	 */
	public static String[] GetUserFace(String str) {
		String[] usersTmp = { "FACE PIN", "FID", "SIZE", "VALID", "TMP" };
		usersTmp = getAttrubute("\t", str, usersTmp);
		return usersTmp;
	}

	/**
	 * 解析考勤照片图片
	 * 
	 * @param str
	 * @return
	 */
	public String[] GetAttPhoto(String str) {
		String[] attPhoto = { "PIN", "SN", "size" };
		str = str.substring(0, str.indexOf("CMD"));
		attPhoto = getAttrubute("\n", str, attPhoto);
		return attPhoto;
	}

	/**
	 * 解析指纹信息
	 * 
	 * @param sb1
	 * @return
	 */
	public static String[] GetUserTmp(String str) {
		String[] usersTmp = { "FP PIN", "FID", "Size", "Valid", "TMP" };
		usersTmp = getAttrubute("\t", str, usersTmp); // 保存指纹信息
		return usersTmp;
	}

	/**
	 * 解析人脸照片
	 * 
	 * @param str
	 * @return
	 */
	public String[] GetUserFacePic(String str) {
		String[] usersTmp = { "USERPIC PIN", "Size", "Content" };
		usersTmp = getAttrubute("\t", str, usersTmp);
		return usersTmp;
	}

	/**
	 * 解析数据
	 * @param scc
	 * @return
	 */
	public static String[] FindAttInfoStr(String scc) {
		int ll;
		String a = scc;
		int i = 0;
		int count = GetSubStr(scc, "\n");
		String[] ret = new String[count];
		while (a != "") {
			ll = a.indexOf("\n", 0);
			if (ll > 0) {
				ret[i] = a.substring(0, ll);
				i++;
				a = a.substring(ll + 1);
			} else {
				a = "";
			}
		}
		return ret;
	}

	/**
	 * 统计字符串里出现子字串的个数
	 * 
	 * @param scc
	 * @param search
	 * @return
	 */
	public static int GetSubStr(String scc, String search) {
		String temp = scc;
		int j = 0;
		while (temp != "") {
			int ll = temp.indexOf(search, 0);
			if (ll >= 0) {
				j++;
				temp = temp.substring(ll + 1);
			} else
				temp = "";
		}
		return j;
	}

	/**
	 * 获取客户端真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemortIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 考勤设备设置信息
	 * 
	 * @param clock
	 * @return
	 */
	public static String optionsAll(BaseClock clock, String sessionId) {
		StringBuffer sb = new StringBuffer();
		// 考勤机和考勤门禁一体机返回值
		sb.append("GET OPTION FROM:").append(clock.getSn()).append('\n');
		sb.append("Stamp=").append(clock.getLogStamp()).append('\n');
		sb.append("OpStamp=").append(clock.getOplogStamp()).append('\n');
		sb.append("PhotoStamp=").append(clock.getPhotoStamp()).append('\n');
		sb.append("ErrorDelay=").append(clock.getDelay()).append('\n');
		sb.append("delay=").append(clock.getDelay()).append('\n');
		sb.append("TransTimes=").append(clock.getTransTimes()).append('\n');
		sb.append("TransInterval=").append(clock.getTransInterval()).append('\n');
		sb.append("TransFlag=").append(clock.getUpdateDb()).append('\n');
		sb.append("TimeZone=").append(clock.getTzadj()).append('\n');
		sb.append("Realtime=").append(clock.getRealtime()).append('\n');
		sb.append("ServerVer=IIS5+").append('\n');
		sb.append("Encrypt=").append(clock.getEncrypt()).append('\n');
		sb.append("ATTLOGStamp=").append(clock.getLogStamp()).append('\n');
		sb.append("OPERLOGStamp=").append(clock.getOplogStamp()).append('\n');
		sb.append("ATTPHOTOStamp=").append(clock.getPhotoStamp()).append('\n');
		sb.append("Language=").append(clock.getLanguage()).append('\n');
		return sb.toString();
	}

	/**
	 * 对机器发送信号
	 * 
	 * @param ip
	 * @param port
	 * @param cmd
	 * @return
	 * @throws Exception 
	 * @throws BusinessRuleException
	 */
	public String UDPSendMsgToMac(String ip, int port, String cmd) throws Exception {
		String ret = "1";
		try {
			InetAddress target = InetAddress.getByName(ip);
			DatagramSocket ds = new DatagramSocket();
			byte[] buf = cmd.getBytes();
			DatagramPacket op = new DatagramPacket(buf, buf.length, target, port);
			ds.send(op);
			ds.close();
		} catch (Exception e) {
			ret = "0";
			throw new Exception("UDPSendMsgToMac ", e);
		} finally {
			System.out.println("finisher UDPSendMsgToMac");
		}
		return ret;
	}
	
	/**
	 * 离职时删除人员在所有设备的人员数据
	 * @param employeeId
	 * @throws Exception 
	 */
	public static void deleteEmployeeOfAllClock(int employeeId) throws Exception{
		Employee dao = new Employee();
		dao.setEmployeeId(employeeId);
		if(dao.load()){
			String code = null;
			if(isSendDataByNo){
				code = dao.getEmployeeNo();
			}else{
				code = employeeId + "";
			}
			Clock clockDao = new Clock();
			List<BaseClock> clockList = clockDao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(clockList) && clockList.size() > 0){
				for(BaseClock clock : clockList){
					CmdController co = new CmdController();
					co.setUserId("1");
					co.setClock(clock);
					co.delUser(code);
				}
			}
		}
	}
	
	/**
	 * 入职时下发人员到所有的设备中
	 * @param employeeId
	 * @throws Exception
	 */
	public static void addEmployeeOfAllClock(int employeeId) throws Exception{
		Clock clockDao = new Clock();
		List<BaseClock> clockList = clockDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(clockList) && clockList.size() > 0){
			Employee dao = new Employee();
			dao.setEmployeeId(employeeId);
			if(dao.load()){
				BaseEmployee bean = dao.generateBase();
				for(BaseClock clock : clockList){
					CmdController co = new CmdController();
					co.setUserId("1");
					co.setClock(clock);
					co.sendUser(bean);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Clock clockDao = new Clock();
		clockDao.setConditionSn("=", "3668170100087");
		BaseClock clock = clockDao.executeQueryOneRow();
		CmdController co = new CmdController();
		co.setClock(clock);
		co.setUserId("1");
		//下发人员
//		Employee dao = new Employee();
//		dao.setConditionStatus("=",0);
//		dao.setConditionEmployeeId(">",0);
//		List<BaseEmployee> list = dao.conditionalLoad();
//		for(BaseEmployee bean : list){
//			co.sendUser(bean);
//		}
		//删除员工指纹
//		co.delFinger(411, 6);
//		删除人脸
//		co.delFace(411);
		//删除人员
//		co.delUser(389);
//		下发指纹
//		HrEmpFinger dao = new HrEmpFinger();
//		dao.setConditionEmployeeId("=",411);
//		dao.setConditionFid("=",6);
//		BaseHrEmpFinger finger = dao.executeQueryOneRow();
//		co.sendFinger(finger);
//		下发人脸
//		HrEmpFace dao = new HrEmpFace();
//		dao.setConditionEmployeeId("=",411);
//		List<BaseHrEmpFace> list = dao.conditionalLoad("order by "+BaseHrEmpFace.CS_FID+" asc");
//		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
//			for(BaseHrEmpFace face : list){
//				co.sendFace(face);
//			}
//		}
		//设备重启
//		co.clockCmd(co.CMD_CHECK);
	}
}
