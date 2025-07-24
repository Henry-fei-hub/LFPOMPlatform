package pomplatform.contractMessage.handler;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractMessage;
import com.pomplatform.db.bean.BaseContractMessageDetail;
import com.pomplatform.db.dao.ContractMessage;
import com.pomplatform.db.dao.ContractMessageDetail;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.KeyValuePair;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.contractMessage.bean.BaseMcontractmor;
import pomplatform.contractMessage.bean.BaseOnLoadContractMessageByEmployeeId;
import pomplatform.contractMessage.bean.ConditionMcontractmor;
import pomplatform.contractMessage.bean.ConditionOnLoadContractMessageByEmployeeId;
import pomplatform.contractMessage.query.QueryMcontractmor;
import pomplatform.contractMessage.query.QueryOnLoadContractMessageByEmployeeId;
import pomplatform.preProjects.bean.BaseOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.bean.ConditionOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.query.QueryOnLoadMainProjectEmployeeNameAndNo;

/**
 * 每周一上午9点正，对contract_messages表中msg_status = 1 的合同进行消息推送
 * @author 
 */
public class OnLoadContractMsgEmployeeTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnLoadContractMsgEmployeeTimer.class);
    public static String TEMPLATE = "您好，目前系统上有以下合同（%1$s） ,出图阶段超过项目回款进度，请您尽快登录系统进行审批，谢谢！";
    @SuppressWarnings("deprecation")
	public void run() {
    	__logger.debug("开始计算时间");
        try {
			Calendar cal = Calendar.getInstance();
			int week = cal.get(Calendar.DAY_OF_WEEK);//1--7的值,对应：星期日，星期一，星期二，星期三....星期六
			if(week==2) {//周一
				ContractMessage cmDao =new ContractMessage();
				cmDao.setConditionMsgStatus("=", 1);
				cmDao.setConditionContractId(">", 0);
				List<BaseContractMessage> conditionalLoad = cmDao.conditionalLoad();
				if(conditionalLoad.size()>0) {
					StringBuffer str = new StringBuffer();
					for (int i = 0; i <conditionalLoad.size(); i++) {
						BaseContractMessage baseContractMessage = conditionalLoad.get(i);
						Integer contractMessageId = baseContractMessage.getContractMessageId();
						if(i == conditionalLoad.size()-1){
							str.append(contractMessageId);
						}else {
							str.append(contractMessageId+",");
						}
					}
					
					QueryMcontractmor query =new QueryMcontractmor();
					ConditionMcontractmor condition =new ConditionMcontractmor();
					KeyValuePair[] replacements =new KeyValuePair[1];
		    		KeyValuePair keyValue = new KeyValuePair();
		    		keyValue.setKey("A.contract_id >0");
					keyValue.setValue(" A.contract_id >0 and c.contract_message_id in ("+str.toString()+") ");
					replacements[0] = keyValue;
					BaseCollection<BaseMcontractmor> collection = query.executeQuery(replacements , condition);
					
					if(!BaseHelpUtils.isNullOrEmpty(collection)&&collection.getCollections().size()>0) {
						ContractMessageDetail cmd =new ContractMessageDetail();
						BaseContractMessageDetail bcmd =new BaseContractMessageDetail();
						List<BaseMcontractmor> list = collection.getCollections();
						HashSet<Integer> set = new HashSet<>();
						Map<Integer, String> map =new HashMap<>();
						
						for (BaseMcontractmor baseMcontractmor : list) {
							QueryOnLoadMainProjectEmployeeNameAndNo q = new QueryOnLoadMainProjectEmployeeNameAndNo();
							ConditionOnLoadMainProjectEmployeeNameAndNo  c =new ConditionOnLoadMainProjectEmployeeNameAndNo();
							c.setMainProjectId(BaseHelpUtils.getIntValue(baseMcontractmor.getMainProjectId()));
							BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> execute = q.execute(null,c);
							
							if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
								List<BaseOnLoadMainProjectEmployeeNameAndNo> employeeList = execute.getCollections();
//								String content ="("+baseMcontractmor.getContractCode()+"--"+baseMcontractmor.getContractName()+")";
								String content ="您好,("+baseMcontractmor.getContractCode()+")"+baseMcontractmor.getContractName()+",出图阶段超过项目回款进度，请尽快处理!";
								set.clear();
								StringBuffer employeeStr =new StringBuffer();
								for (BaseOnLoadMainProjectEmployeeNameAndNo baseMainProjectEmployee : employeeList) {
									set.add(baseMainProjectEmployee.getEmployeeId());
									employeeStr.append(baseMainProjectEmployee.getEmployeeName()+";");
								}
//								Iterator<Integer> it = set.iterator();
//								Object[] employeeIds = new Object[set.size()];
//								int i = 0 ;
//								while (it.hasNext()) {
//									Integer j = it.next();
//									employeeIds[i] = j;
//									i++;
//									if(BaseHelpUtils.isNullOrEmpty(map.get(j))) {
//										map.put(j, content);
//									}else {
//										String string = map.get(j);
//										map.put(j, string+","+content);
//									}
//								}
//								ERPWeixinUtils.sendWXMsgToUser(content, employeeIds);
								bcmd.setContractId(baseMcontractmor.getContractId());
								bcmd.setContractMessageId(baseMcontractmor.getContractMessageId());
								bcmd.setOperator(-1);
								bcmd.setRemark(employeeStr.toString());
								cmd.clear();
								cmd.setDataFromBase(bcmd);
								cmd.save();
							}else {
								bcmd.setContractId(baseMcontractmor.getContractId());
								bcmd.setContractMessageId(baseMcontractmor.getContractMessageId());
								bcmd.setOperator(-1);
								bcmd.setRemark("本次消息推送未找到相关的项目人员");
								cmd.clear();
								cmd.setDataFromBase(bcmd);
								cmd.save();
							}
						}
						
//						if(map.size()>0) {
//							for(Map.Entry<Integer, String> entry : map.entrySet()){
//								Integer mapKey = entry.getKey();
//							    String mapValue = entry.getValue();
//							    System.out.println(mapKey+"======="+"您好,"+mapValue+",出图阶段超过项目回款进度，请尽快处理!");
//							    ERPWeixinUtils.sendWXMsgToUser(mapKey, "您好,"+mapValue+",出图阶段超过项目回款进度，请尽快处理!");
//							}
//						}
						
						//更新本次所有的次数+1
						for (BaseContractMessage baseContractMessage : conditionalLoad) {
							cmDao.clear();
							baseContractMessage.setMsgCount(baseContractMessage.getMsgCount()+1);
							cmDao.setDataFromBase(baseContractMessage);
							cmDao.update();
						}
						
						//消息推送
						QueryOnLoadContractMessageByEmployeeId q = new QueryOnLoadContractMessageByEmployeeId();
						ConditionOnLoadContractMessageByEmployeeId c = new ConditionOnLoadContractMessageByEmployeeId();
						BaseCollection<BaseOnLoadContractMessageByEmployeeId> execute = q.execute(null, c);
						if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
							List<BaseOnLoadContractMessageByEmployeeId> collections = execute.getCollections();
							for (BaseOnLoadContractMessageByEmployeeId baseOnLoadContractMessageByEmployeeId : collections) {
								String sendMsg = String.format(TEMPLATE, baseOnLoadContractMessageByEmployeeId.getStringAgg());
								ERPWeixinUtils.sendWXMsgToUser(baseOnLoadContractMessageByEmployeeId.getEmployeeId(), sendMsg);
							}
						}
					}
				}
			}
        } catch (Exception e1) {
			e1.printStackTrace();
		} 
    }
    
    
    
    public static void main(String[] args) throws Exception {
    	
    	OnLoadContractMsgEmployeeTimer a =new OnLoadContractMsgEmployeeTimer();
    	a.run();
    	
	}
    
}
