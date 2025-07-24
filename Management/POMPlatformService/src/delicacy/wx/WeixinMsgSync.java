package delicacy.wx;

import java.util.ArrayList;
import java.util.List;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseSystemProcessInstanceActivity;
import delicacy.system.bean.BaseSystemProcessPooledTask;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import message.common.CWDWeixinUtils;
import message.common.ERPWeixinUtils;
import pomplatform.awaitingapproval.bean.BaseAwaitingapproval;
import pomplatform.awaitingapproval.bean.ConditionAwaitingapproval;
import pomplatform.awaitingapproval.query.QueryAwaitingapproval;

/**
 * 
 * @Title: WeixinMsgSync.java 
 * @Package delicacy.wx 
 * @Description: 
 * @author CL  
 * @date 2017年5月3日
 */
public class WeixinMsgSync {
	private final static int MSG_STATUS_ONE = 1;
	
	private final static List<Integer> CWD_TYPE_IDS = new ArrayList<Integer>() ;
	static {
		CWD_TYPE_IDS.add(47);
		CWD_TYPE_IDS.add(48);
		CWD_TYPE_IDS.add(49);
		CWD_TYPE_IDS.add(50);
		CWD_TYPE_IDS.add(55);
	}

    public static void syncSendWeixinMsg() throws Exception{
    	List<Integer> activeIds = new ArrayList<>();
    	List<Integer> poolIds = new ArrayList<>();
    	QueryAwaitingapproval dao = new QueryAwaitingapproval();
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		BaseCollection<BaseAwaitingapproval> result = dao.executeQuery(null, new ConditionAwaitingapproval());
		List<BaseAwaitingapproval> list = result.getCollections();
		if(list.size() > 0){
			for (BaseAwaitingapproval baseAwaitingapproval : list) {
				if(baseAwaitingapproval.getIdType() == 2){
					poolIds.add(baseAwaitingapproval.getId());
				}else{
					activeIds.add(baseAwaitingapproval.getId());
				}
				if(!BaseHelpUtils.isNullOrEmpty(baseAwaitingapproval.getCompanyWeixin())){
					String processTypeName = baseAwaitingapproval.getProcessTypeName();
					StringBuilder sb = new StringBuilder();

					String params = "type_" + baseAwaitingapproval.getIdType() + "__" + "id_" + baseAwaitingapproval.getId()
										+ "__msgType_2";
					if(CWD_TYPE_IDS.contains(baseAwaitingapproval.getProcessType())) {
						sb.append("https://2001.cube-architects.com/cwdMobileIndex.html?");
					}else {
						sb.append("https://2001.cube-architects.com/minindex.html?");
					}
					
					sb.append("state=")
						.append(params);
					
					String applicationName = "";
					if(CWD_TYPE_IDS.contains(baseAwaitingapproval.getProcessType())) {
						applicationName = "CWD";
					} else {
						applicationName = "ERP";
					}
					
					String sendMsg = String.format(WeixinStatics.MSG_TEMPLATE, processTypeName, sb.toString(), applicationName);
					if(CWD_TYPE_IDS.contains(baseAwaitingapproval.getProcessType())) {
						CWDWeixinUtils.sendTextMsgToUser(baseAwaitingapproval.getCompanyWeixin(), sendMsg);
					}else {
						ERPWeixinUtils.sendTextMsgToUser(baseAwaitingapproval.getCompanyWeixin(), sendMsg);
					}
				}
			}
			//改变消息状态
			if(activeIds.size() > 0){
				SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
				spiaDao.addCondition(BaseSystemProcessInstanceActivity.CS_PROCESS_INSTANCE_ACTIVITY_ID, "in", activeIds.toArray(new Object[activeIds.size()]));
				spiaDao.setMessageStatus(MSG_STATUS_ONE);
				spiaDao.conditionalUpdate();
			}
			if(poolIds.size() > 0){
				SystemProcessPooledTask spptDao = new SystemProcessPooledTask();
				spptDao.addCondition(BaseSystemProcessPooledTask.CS_PROCESS_POOLED_TASK_ID, "in", poolIds.toArray(new Object[poolIds.size()]));
				spptDao.setMessageStatus(MSG_STATUS_ONE);
				spptDao.conditionalUpdate();
			}
		}
		
    }

}
