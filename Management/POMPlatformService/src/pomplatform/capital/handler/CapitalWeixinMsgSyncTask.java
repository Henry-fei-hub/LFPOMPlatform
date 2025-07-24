package pomplatform.capital.handler;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.Contract;

import delicacy.common.BaseHelpUtils;
import message.common.ERPWeixinUtils;

/**
 * 
 * @Title: WeixinMsgSyncTask.java 
 * @Package delicacy.wx 
 * @Description: 
 * @author CL  
 * @date 2017年5月3日
 */
public class CapitalWeixinMsgSyncTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(CapitalWeixinMsgSyncTask.class);

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    
    //谭晓华 ，王运芳
    private static final String USER_STR = "2321|qy01a78ab2686bac00284ca8d59d";
    
    public static void main(String[] args) {
    	CapitalWeixinMsgSyncTask a = new CapitalWeixinMsgSyncTask();
    	a.run();
	}
    
    @Override
    public void run() {
        __logger.debug("开始发送商票到期7、10天前通知");
		try {
			Capital cDao = new Capital();
			String sql = "(expire_date - current_date) = 7 or (expire_date - current_date) = 10";
			List<BaseCapital> list = cDao.conditionalLoad(sql);
			Contract contractDao = new Contract();
			
			for (BaseCapital baseCapital : list) {
				String issueDateStr = "";
				String contractName = "";
				if(!BaseHelpUtils.isNullOrEmpty(baseCapital.getIssueDate())) {
					issueDateStr = SDF.format(baseCapital.getIssueDate());
				}
				if(!BaseHelpUtils.isNullOrEmpty(baseCapital.getContractId())) {
					contractDao.clear();
					contractDao.setContractId(baseCapital.getContractId());
					if(contractDao.load()) {
						contractName = contractDao.getContractName();
					}
				}
				StringBuilder sb = new StringBuilder("【商票到期提醒】\r\n");
				
				sb.append("合同名称: ")
					.append(contractName)
					.append("\r\n商票金额: ")
					.append(baseCapital.getBorrowMoney())
					.append("\r\n出票日: ")
					.append(issueDateStr)
					.append("\r\n到日期: ")
					.append(SDF.format(baseCapital.getExpireDate()))
					.append("\r\n付款方: ")
					.append(baseCapital.getOtherName());
				ERPWeixinUtils.sendTextMsgToUser(USER_STR, sb.toString());
			}
			
		} catch (Exception e) {
			__logger.error("发送商票到期7、10天前通知错误", e);
		}
    }

}
