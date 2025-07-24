package pomplatform.workflow.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BasePayMoneyManage;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.ReceiveUnitManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PayMoneyHistoryRecordProcessor implements GenericProcessor {
	
	
	private static final String GET_PAYMONEY_HISTORYRECORD = "getPayMoneyHistoryRecord";
	
	private static final String GET_PAYMONEY_SUM_MONEY = "getPayMoneySumMoney";
	
	@SuppressWarnings("unchecked")
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String optType = BaseHelpUtils.getStringValue(result, "opt_type");
        if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)){
        	switch (optType) {
    		case GET_PAYMONEY_HISTORYRECORD:
        		return getPayMoneyHistoryRecord(result);
    		case GET_PAYMONEY_SUM_MONEY:
    			return getPayMoneySumMoney(result);
    		}
        }
    	return null;
    }
	
	/**
	 * 
	 * @Title: getPayMoneySumMoney 
	 * @Description: 获取预付款总金额
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getPayMoneySumMoney(Map<String, Object> params) throws Exception{
		int receiveUnitManageId = BaseHelpUtils.getIntValue(params.get("receiveUnitManageId"));
		double sum = 0;
		if (receiveUnitManageId >= 0) {
			ReceiveUnitManage ruDao = new ReceiveUnitManage();
			ruDao.setReceiveUnitManageId(receiveUnitManageId);
			if(ruDao.load()){
				PayMoneyManage pmDao = new PayMoneyManage();
				pmDao.setConditionReceiveUnit("=", ruDao.getReceiveUnit());
				
				List<BasePayMoneyManage> list = pmDao.conditionalLoad();
				for (BasePayMoneyManage basePayMoneyManage : list) {
					sum += basePayMoneyManage.getPayAmount().doubleValue();
				}
			}
			
		}
		return sum + "";
	}
	
	/**
	 * 
	 * @Title: getPayMoneyHistoryRecord 
	 * @Description: 获取预付款历史记录
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getPayMoneyHistoryRecord(Map<String, Object> params) throws Exception{
		int receiveUnitManageId = BaseHelpUtils.getIntValue(params.get("receiveUnitManageId"));
		BaseCollection<BasePayMoneyManage> bc = new BaseCollection<>();
		if (receiveUnitManageId >= 0) {
			ReceiveUnitManage ruDao = new ReceiveUnitManage();
			ruDao.setReceiveUnitManageId(receiveUnitManageId);
			if(ruDao.load()){
				PayMoneyManage pmDao = new PayMoneyManage();
				pmDao.setConditionReceiveUnit("=", ruDao.getReceiveUnit());
				
				List<BasePayMoneyManage> list = pmDao
						.conditionalLoad("order by " + BasePayMoneyManage.CS_RECEIVE_UNIT);
				bc.setCollections(list);
			}
			
		}
		return bc.toJSON();
	}
}
