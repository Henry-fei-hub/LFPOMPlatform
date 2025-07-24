package pomplatform.ht.handler;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis2.databinding.types.soapencoding.Array;

import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutQuotation;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import pomplatform.common.utils.StaticUtils;
import pomplatform.soutdesignconsiderationoor.bean.BaseSoutdesignconsiderationoor;
import pomplatform.soutdesignconsiderationoor.bean.BaseSoutdesignconsiderationoor2;
import pomplatform.soutdesignconsiderationoor.bean.ConditionSoutdesignconsiderationoor2;
import pomplatform.soutdesignconsiderationoor.query.QuerySoutdesignconsiderationoor2;

public class CustomQuotationStatus implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		BaseCollection bc = new BaseCollection();
		StringBuffer quotationNumber=new StringBuffer();
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        int outQuotationId = BaseHelpUtils.getIntValue(param.get("outQuotationId"));
        String infoCode=BaseHelpUtils.getString(param.get("infoCode"));
        String projectCode=BaseHelpUtils.getString(param.get("projectCode"));
        //true >> all     ;  false  >> one
        boolean allOrOne=BaseHelpUtils.getBoolean(param.get("allOrOne"));
		
		//flag ==1 则表示这是删除操作
		int flag = BaseHelpUtils.getIntValue(param.get("flag"));
		
		QuerySoutdesignconsiderationoor2 query =new QuerySoutdesignconsiderationoor2();
		ConditionSoutdesignconsiderationoor2 condition =new ConditionSoutdesignconsiderationoor2();
		condition.setOutQuotationId(outQuotationId);
		BaseCollection<BaseSoutdesignconsiderationoor2> executeQuery = query.executeQuery(null, condition);
		BaseCollection<BaseOutQuotation> ac = new BaseCollection<>();
		List<BaseOutQuotation> list = new ArrayList<>();
		BaseOutQuotation baseOQ=new BaseOutQuotation();
		
		int res=0; 
		String msg ="";
		
		
		if(flag!=1&&!BaseHelpUtils.isNullOrEmpty(executeQuery)&&executeQuery.getCollections().size()>0) {
			res=-1;
			msg="已存在报价单子项,请进行删除或修改操作！";
		}else {
			/**
			 * 获取报价单的状态
		     *  quotationStatusValues.put("1", "成功");
			    quotationStatusValues.put("2", "不成功");
			    quotationStatusValues.put("3", "报价中");
			 */
	        OutQuotation outQuotation=new OutQuotation();
	        if(allOrOne){
	        	outQuotation.setConditionInfoCode("=", infoCode);
	        	outQuotation.setConditionProjectCode("=", projectCode);
	        }else{
	        	outQuotation.setConditionOutQuotationId("=", outQuotationId);
	        }
	        
	        List<BaseOutQuotation> l=outQuotation.conditionalLoad();
	        int number=l.size();
	        if(number>0){
	        	for(BaseOutQuotation base:l){
	        		if(base.getQuotationStatus()==3){
	        			baseOQ.setQuotationStatus(3);//报价中
	        			break;
	        		}
	        		if(base.getQuotationStatus()==1){
	        			baseOQ.setQuotationStatus(1);//成功
	        			break;
	        		}
	        	}
	        }
	        res = 1;
		}
		
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
		
		list.add(baseOQ);
//		return baseOQ.toOneLineJSON(res,msg);
		ac.setCollections(list);
		
		//新增一份MainProjectBusinessType的数据
		if(res>=0) {
			MainProject m = new MainProject();
			m.setConditionProjectCode("=", projectCode);
			m.setConditionInfoCode("=", infoCode);
			BaseMainProject executeQueryOneRow = m.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
				MainProjectBusinessType mDao = new MainProjectBusinessType();
				mDao.setConditionMainProjectId("=", executeQueryOneRow.getMainProjectId());
				mDao.setConditionOutQuotationId("=",outQuotationId );
				List<BaseMainProjectBusinessType> load = mDao.conditionalLoad();
				if(load.size()<=0) {
					mDao.clear();
					mDao.setConditionMainProjectId("=", executeQueryOneRow.getMainProjectId());
					mDao.setConditionOutQuotationId("=", 0);
					List<BaseMainProjectBusinessType> list2 = mDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(list2)&&list2.size()>0) {//新增页面
						List<BaseMainProjectBusinessType> l =new ArrayList<>();
						for (BaseMainProjectBusinessType baseMainProjectBusinessType : list2) {
							baseMainProjectBusinessType.setMainProjectBusinessTypeId(null);
							baseMainProjectBusinessType.setOutQuotationId(outQuotationId);
							l.add(baseMainProjectBusinessType);
						}
						if(l.size()>0) {
							mDao.clear();
							mDao.save(l);
						}
				
					}	
				}
			}
		}
		return ac.toJSON(res, msg);
		
	}
}
