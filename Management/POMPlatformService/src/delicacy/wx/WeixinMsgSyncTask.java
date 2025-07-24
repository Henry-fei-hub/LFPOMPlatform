package delicacy.wx;

import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * 
 * @Title: WeixinMsgSyncTask.java 
 * @Package delicacy.wx 
 * @Description: 
 * @author CL  
 * @date 2017年5月3日
 */
public class WeixinMsgSyncTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(WeixinMsgSyncTask.class);

    @Override
    public void run() {
        __logger.debug("开始发送通知审批消息");
		try {
			WeixinMsgSync.syncSendWeixinMsg();
		} catch (Exception e) {
			__logger.error("发送消息错误", e);
		}
    }

}
