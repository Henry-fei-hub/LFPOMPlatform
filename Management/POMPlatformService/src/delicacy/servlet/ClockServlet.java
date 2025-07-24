package delicacy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClock;
import com.pomplatform.db.bean.BaseClockRecevieCmd;
import com.pomplatform.db.dao.Clock;
import com.pomplatform.db.dao.ClockRecevieCmd;

import delicacy.common.BaseHelpUtils;
import delicacy.common.CommonUtils;
import delicacy.connection.ThreadConnection;
import pomplatform.clocks.business.ClockMsgProcess;
import pomplatform.clocks.business.ClockSendCmdsThread;
import pomplatform.clocks.business.CmdController;

@SuppressWarnings("serial")
@WebServlet(name = "ClockServlet", loadOnStartup = 1, urlPatterns = {"/ClockServlet"})
public class ClockServlet extends HttpServlet {
	private static final Logger __logger = Logger.getLogger(ClockServlet.class);
	public final static String ACTION_NAME = "action";
	public final static String SUBACTION_NAME = "subaction";
	public final static String CONTENT_NAME = "content";
	public final static String ENCODING_UTF = "text/plain;charset=gb2312";
	// 操作类型
	public final static String OPT_TYPE = "optType";

	// *************************************中控设备数据传输接口*********************//
	public final static String DO_CDATA = "do_cdata";
	public final static String DO_GET_REQUEST = "do_get_request";
	public final static String DO_DEVICE_CMD = "do_device_cmd";
	public final static String DO_FDATA = "do_fdata";
	public final static String DO_PUSH = "do_push";
	public final static String DO_REGISTRY = "do_registry";
	public final static String DO_RTDATA = "do_rtdata";
	public final static short CHN_TIMEZONE = 8;

	// ****************设备的状态*************
	public final static short PAUSE = 0;
	public final static short ONLINE = 1;
	public final static short OFFLINE = -1;
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		try {
			// 获取操作类型
			String optType = request.getParameter(OPT_TYPE);
			String method = request.getMethod();
			String content = "";
			if (method.equals("GET")) {
				content = request.getParameter(CONTENT_NAME);
			} else {
				content = CommonUtils.getRequestContent(request);
			}
			if (DO_CDATA.equals(optType)) {
				onDoCdata(request, response, content);
			} else if (DO_GET_REQUEST.equals(optType)) {
				onDoGetRequest(request, response);
			} else if (DO_DEVICE_CMD.equals(optType)) {
				onDoDeviceCmd(request, response, content);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (!ThreadConnection.isUseDB()) {
				try {
					if (!ThreadConnection.getConnection(false).getConnection().getAutoCommit()) {
						ThreadConnection.rollback();
					}
				} catch (SQLException ex1) {
					__logger.error(ex1.getMessage());
				}
			}
		}
	}
	
	
	/**
	 * Stamp 为设备最后上传考勤记录的最新记录时间戳标记 0 OpStamp 为设备最后上传操作记录的最新记录时间戳标记 1 ErrorDelay
	 * 为联网失败后重新联接服务器的间隔时间 2 Delay 为正常联网时联接服务器的间隔时间 3 TransTimes 为定时检查并传送新数据时间 4
	 * TransInterval 为检查并传送新数据间隔时间 5 TransFlag 为向服务器传送哪些新数据标记 6 Realtime
	 * 是否实时传送新记录 7 Encrypt 是否加密传送数据（加密传送使用中控专门的加密算法） 8
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public void onDoCdata(HttpServletRequest request, HttpServletResponse response,String creteria) throws Exception {
		ThreadConnection.beginTransaction();
		String sn = BaseHelpUtils.getString(request.getParameter("SN")); // 机器序列号
		String stamp = BaseHelpUtils.getString(request.getParameter("Stamp")); // 时间戳(考勤,照片)
		String pushVersion = BaseHelpUtils.getString(request.getParameter("pushver"));// 版本
		String language = BaseHelpUtils.getString(request.getParameter("language"));// 语言
		String table = BaseHelpUtils.getString(request.getParameter("table"));
		String curStamp = "";// 当前传送的标记
		int count = 0;// 传送的记录的条数
		List<BaseClock> clockList = new ArrayList<>();
		Clock clockDao = new Clock();
		clockDao.setConditionSn("=", sn);
		clockList = clockDao.conditionalLoad();
		BaseClock clock = null;
		String backInfo = "";
		// 是否允许上传数据
		boolean isUpload = false;
		// 如果取不到数据库里对应设备的信息,验证机器点数是否超标
		if (clockList.size() == 0 && !BaseHelpUtils.isNullOrEmpty(sn)) {
			String ip = ClockMsgProcess.getRemortIP(request);
			int port = request.getRemotePort();
			clock = new BaseClock();
			clock.setSn(sn);
			clock.setLogStamp("0");
			clock.setOplogStamp("0");
			clock.setPhotoStamp("0");
			clock.setFpversion(pushVersion);
			clock.setClockTypeId(10);// 中控考勤机
			clock.setDelay(30);
			clock.setStatus(ONLINE);
			clock.setTzadj(CHN_TIMEZONE);
			clock.setRealtime(1);
			clock.setTransInterval(1);
			clock.setTransTimes("00:00;14:05");
			clock.setAlias(ip);
			clock.setIpaddress(ip);
			clock.setIpPort(port);
			clock.setEncrypt(0);
			clock.setUpdateDb("1111101010");
			clock.setLanguage(language);
			// 机器设置是否可上传数据：0:否;1:是;默认为否
			clock.setEnabled(0);
			clockDao.clear();
			clockDao.setDataFromBase(clock);
			clockDao.save();
			CmdController ctl = new CmdController(clock, "1");
			// 发送INFO 命令
			ctl.clockCmd(CmdController.CMD_INFO);
			isUpload = true;
		} else {
			clock = clockList.get(0);
			isUpload = true;
		}

		// 验证当前设备SN 是否已经注册到数据库，只允许注册过并设置enable=1的设备进行上传数据
		if (isUpload && clock != null && clock.getEnabled() != null && clock.getEnabled() == 1) {
			// 上传数据:人员、指纹、人脸、考勤数据
			if (request.getMethod().equalsIgnoreCase("POST")) {
				String scc = creteria;
				//上传考勤数据
				if (!BaseHelpUtils.isNullOrEmpty(table) && table.equalsIgnoreCase("ATTLOG")) {
					count = ClockMsgProcess.FindAttInfo(scc, sn);
					clock.setLogStamp(stamp);
					curStamp = "stamp";
				//上传用户信息（包括指纹和人脸）
				}else if (!BaseHelpUtils.isNullOrEmpty(table) && table.equalsIgnoreCase("OPERLOG")) {
					curStamp = "opstamp";
				    count = ClockMsgProcess.FindUserInfo(scc, sn);
				    clock.setOplogStamp(stamp);
				}
//				ClockSendCmd clockSendCmdsDao= new ClockSendCmd();
//				BaseClockSendCmd clockSendCmdsBean = new BaseClockSendCmd();
//				clockSendCmdsBean.setSn(sn);
//				clockSendCmdsBean.setCount(count);
//				clockSendCmdsBean.setTransContext(scc);
//				clockSendCmdsBean.setTranstime(new Date());
//				clockSendCmdsBean.setFlag(curStamp);
//				clockSendCmdsDao.setDataFromBase(clockSendCmdsBean);
//				clockSendCmdsDao.save();
				backInfo = "OK";
			}else{//get请求,返回服务器上读取的设备的配置信息
				backInfo = ClockMsgProcess.optionsAll(clock, request.getSession().getId());
			}
		}
		ThreadConnection.commit();
		response.getWriter().write(backInfo);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 机器请求接口，用来发送获取服务器下发到机器的命令
	 * @param request
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void onDoGetRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		ThreadConnection.beginTransaction();
		String sn = BaseHelpUtils.getString(request.getParameter("SN")); // 机器序列号
		String info = BaseHelpUtils.getString(request.getParameter("INFO"));
		StringBuffer cmds = new StringBuffer();// 下发给机器的命令
		if(!BaseHelpUtils.isNullOrEmpty(sn) && !BaseHelpUtils.isNullOrEmpty(info)){
			//根据设备序列号检索设备是否已入库
			Clock clockDao = new Clock();
			clockDao.setConditionSn("=",sn);
			BaseClock clock = clockDao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(clock)){//说明设备已保存数据库
				// 获取设备信息，如固件，用户数，指纹数据，考勤记录，ip
				String[] infoArry = info.split(",");
				if(infoArry.length > 5){
					clock.setFwVersion(infoArry[0]);
				    clock.setUserCount(Integer.valueOf(infoArry[1]));
				    clock.setFpCount(Integer.valueOf(infoArry[2]));
				    clock.setTransactionCount(Integer.valueOf(infoArry[3]));
				    clock.setIpaddress(infoArry[4]);
				    String ip = ClockMsgProcess.getRemortIP(request);
				    clock.setIpaddress(ip);
				    clock.setLastActivity(new Timestamp(System.currentTimeMillis()));
				    clock.setStatus(ONLINE);
				    clockDao.clear();
				    clockDao.setDataFromBase(clock);
				    clockDao.update();
				}
				//检索未执行的指令
				ClockRecevieCmd dao = new ClockRecevieCmd();
				dao.setConditionSn("=",sn);
				dao.setConditionSuccessFlag("=",Short.valueOf("1"));//只检索未执行的指令
				List<BaseClockRecevieCmd> list = dao.conditionalLoad("order by "+BaseClockRecevieCmd.CS_CLOCK_RECEVIE_CMD_ID+" ASC");
				if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
					for (BaseClockRecevieCmd bean : list) {
						cmds.append("C:").append(bean.getClockRecevieCmdId()).append(":").append(bean.getCmdContent()).append("\r\n\r\n");
				    }
				}else{
					cmds.append("OK").append('\n');
				}
			}
		}else{
			cmds.append("UNKNOWN DEVICE").append('\n');
		}
		ThreadConnection.commit();
		response.setContentType(ENCODING_UTF);
		response.getWriter().write(cmds.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 获取机器执行完命令后返回的结果
	 * @param request
	 * @param creteria
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void onDoDeviceCmd(HttpServletRequest request, HttpServletResponse response,String creteria) throws SQLException, IOException {
		ThreadConnection.beginTransaction();
		String sn = BaseHelpUtils.getString(request.getParameter("SN")); // 机器序列号
		String backInfo = "";
		System.out.println("命令返回值:" + creteria);
		ClockSendCmdsThread t = new ClockSendCmdsThread(sn, creteria);
	    t.start();
	    backInfo = "OK";
	    ThreadConnection.commit();
	    response.setContentType(ENCODING_UTF);
		response.getWriter().write(backInfo);
		response.getWriter().flush();
		response.getWriter().close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

	@Override
	public void destroy() {
	}

}
