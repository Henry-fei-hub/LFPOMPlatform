package pomplatform.ht.handler;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseOutDesignConsideration;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import pomplatform.common.utils.StaticUtils;
import pomplatform.orderplacement.bean.BaseOnLoadApplyListOfOrderInfo;
import pomplatform.orderplacement.bean.ConditionOnLoadApplyListOfOrderInfo;
import pomplatform.orderplacement.query.QueryOnLoadApplyListOfOrderInfo;

public class CheckQuotationStatus implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		BaseCollection bc = new BaseCollection();
		StringBuffer quotationNumber=new StringBuffer();
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		BaseCollection<BaseOutDesignConsideration> ac = new BaseCollection<>();
		List<BaseOutDesignConsideration> list = new ArrayList<>();
		BaseOutDesignConsideration baseOQ=new BaseOutDesignConsideration();
		
		int res=0; 
		String msg ="";
		int outQuotationId = BaseHelpUtils.getIntValue(param.get("outQuotationId"));
		
		//先判断是否有流程以及流程的状态
		SystemProcessInstance spi = new SystemProcessInstance();
		spi.setConditionBusinessId("=", outQuotationId);
		spi.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_75);
		spi.setConditionDeleteFlag("=", 0);//未删除
		BaseSystemProcessInstance baseSystemProcessInstance = spi.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(baseSystemProcessInstance)) {
			int processStatus = BaseHelpUtils.getIntValue(baseSystemProcessInstance.getProcessStatus());
			if(processStatus==3) {
				res=-1;
				msg="报价单流程已完成,无法再次操作！";
			}else if(processStatus!=5) {//流程处于发生中
				res=-1;
				msg="报价单流程正进行中，无法操作！";
			}
		}
		
		
		String projectCode = BaseHelpUtils.getString(param.get("projectCode"));
		QueryOnLoadApplyListOfOrderInfo  query = new  QueryOnLoadApplyListOfOrderInfo();
		ConditionOnLoadApplyListOfOrderInfo condition  = new ConditionOnLoadApplyListOfOrderInfo();
		condition.setProcessType(StaticUtils.PROCESS_TYPE_86);
		condition.setContractCode(projectCode);
		KeyValuePair[] replacements =new KeyValuePair[1];
		KeyValuePair keyValue = new KeyValuePair();
		keyValue.setKey("ORDER BY spi.create_time");
		keyValue.setValue("AND spi.process_status IN ( 0, 1 ) ORDER BY spi.create_time ");
		replacements[0] = keyValue;
		BaseCollection<BaseOnLoadApplyListOfOrderInfo> execute = query.execute(replacements, condition);
		if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0){
			res=-1;
			msg="该合同有订单下达流程进行中，无法操作";
		}
		
		
		//再判断是否有报价单子项
//		OutDesignConsideration oDao =new OutDesignConsideration();
//		oDao.setConditionOutQuotationId("=", outQuotationId);
//		List<BaseOutDesignConsideration> conditionalLoad = oDao.conditionalLoad();
//		if(BaseHelpUtils.isNullOrEmpty(conditionalLoad)||conditionalLoad.size()<=0) {
//			res=-1;
//			msg="报价单子项不能为空";
//		}else {
//			//判读子项是否有项目标题
//			BaseOutDesignConsideration baseOutDesignConsideration = conditionalLoad.get(0);
//			if(BaseHelpUtils.isNullOrEmpty(baseOutDesignConsideration.getNewCreateQuotationName())) {
//				res=-1;
//				msg="报价单子项标题不能为空";
//			}else {
//				baseOQ.setNewCreateQuotationName(baseOutDesignConsideration.getNewCreateQuotationName());
//			}
//		}
		list.add(baseOQ);
		ac.setCollections(list);
		return ac.toJSON(res, msg);
		
	}
}
