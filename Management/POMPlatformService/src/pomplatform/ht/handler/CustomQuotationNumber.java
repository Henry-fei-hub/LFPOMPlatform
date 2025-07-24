package pomplatform.ht.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.SubContract;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import pomplatform.common.utils.StaticUtils;

public class CustomQuotationNumber implements GenericProcessor {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		 int res = 0;
		//1.获取报价单编号
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String infoCode = BaseHelpUtils.getString(param.get("infoCode"));
        String projectCode = BaseHelpUtils.getString(param.get("projectCode"));
        OutQuotation outQuotation=new OutQuotation();
        outQuotation.setConditionInfoCode("=", infoCode);
        outQuotation.setConditionProjectCode("=", projectCode);
        outQuotation.setConditionQuotationStatus("=", StaticUtils.QUOTATION_STATUS_ONE);
        int outQuotationId = 0;
        if(outQuotation.countRows() <= 0){
        	throw new Exception("没有成功报价单无法进行报价单变更");
        }else{
        	outQuotationId = outQuotation.executeQueryOneRow().getOutQuotationId();
        }
        
        //判断是否有流程以及流程的状态
		SystemProcessInstance spi = new SystemProcessInstance();
		spi.setConditionBusinessId("=", outQuotationId);
		spi.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_75);
		spi.setConditionDeleteFlag("=", 0);// 未删除
		BaseSystemProcessInstance baseSystemProcessInstance = spi.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(baseSystemProcessInstance)) {
			int processStatus = BaseHelpUtils.getIntValue(baseSystemProcessInstance.getProcessStatus());
			if (processStatus == 5||processStatus == 3) {// 流程处于发生中
				
			}else {
				throw new Exception("报价单流程正进行中，无法操作！");
			}
		}
        BaseOutQuotation baseOQ=new BaseOutQuotation();
		String quotationNumber = getQuotationNumber(projectCode, infoCode);
    	baseOQ.setQuotationNumber(quotationNumber.toString());
    	String errorMsg = null;
    	//如果为克隆报价单事件时  执行克隆数据
    	if(null != param.get("clone") && BaseHelpUtils.getBoolean(param.get("clone"))){
    		
    		int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    		outQuotation.clear();
    		outQuotation.setOutQuotationId(outQuotationId);
    		if(outQuotation.load()){
    			//如果有创建合同  将合同下的已下达的子订单改成历史版本的子订单
    			Contract cDao = new Contract();
//    			cDao.setConditionInfoCode("=", outQuotation.getInfoCode());
    			cDao.setConditionProjectCode("=", outQuotation.getProjectCode());
    			BaseContract cBean = cDao.executeQueryOneRow();
    			if(null != cBean){
    				cDao.setFlowStatus(StaticUtils.FLOW_STATUS_99);
    				cDao.update();
    				SubContract scDao = new SubContract();
    				scDao.setConditionParentId("=", cBean.getContractId());
    				List<BaseSubContract> sbList = scDao.conditionalLoad();
    				if(sbList.size() > 0){
    					Project pDao = new Project();
    					for (BaseSubContract baseSubContract : sbList) {
    						pDao.clear();
    						pDao.setConditionSubContractId("=", baseSubContract.getSubContractId());
    						if(pDao.countRows() > 0){
    							scDao.clear();
        						scDao.setConditionSubContractId("=", baseSubContract.getSubContractId());
        						scDao.setIsHistory(true);
        	    				scDao.conditionalUpdate();
    						}
    					}
    				}
    			}
    			//将项目拥有拆分价与报价单的状态改为false
    			MainProject pDao = new MainProject();
    			pDao.setConditionInfoCode("=", outQuotation.getInfoCode());
    			pDao.setConditionProjectCode("=", outQuotation.getProjectCode());
    			pDao.setHasSplitPrice(false);
    			pDao.setHasOutQuotations(false);
    			pDao.conditionalUpdate();
    			//将原有的报价单改为历史版本
    			outQuotation.setQuotationStatus(StaticUtils.QUOTATION_STATUS_TWO);
    			outQuotation.update();
    			//创建新报价单
    			outQuotation.setQuotationNumber(quotationNumber.toString());
    			outQuotation.setQuotationStatus(StaticUtils.QUOTATION_STATUS);
    			outQuotation.setCreateTime(new Date()); 
    			outQuotation.setQuotationName("报价单" + quotationNumber.toString());
    			outQuotation.setDisableType(0);
    			outQuotation.setEmployeeId(employeeId);
    			outQuotation.save();
    			int newOutQuotation = outQuotation.getOutQuotationId();
    			
    			OutDesignConsideration outDao = new OutDesignConsideration();
    			outDao.setConditionOutQuotationId("=", outQuotationId);
    			List<BaseOutDesignConsideration> list = outDao.conditionalLoad();
    			if(list.size() > 0){
    				for (BaseOutDesignConsideration baseOutDesignConsideration : list) {
    					baseOutDesignConsideration.setOutQuotationId(newOutQuotation);
					}
    				outDao.clear();
    				int num = outDao.save(list);
    				if(num <= 0){
    					res = -3;
    	    			errorMsg = "插入失败";
    				}
    			}
    			
    			MainProjectBusinessType mpDao =new MainProjectBusinessType();
    			mpDao.setConditionOutQuotationId("=", outQuotationId);
    			List<BaseMainProjectBusinessType> list2 = mpDao.conditionalLoad();
    			if(list2.size()>0) {
    				for (BaseMainProjectBusinessType baseMainProjectBusinessType : list2) {
    					baseMainProjectBusinessType.setOutQuotationId(newOutQuotation);
					}
    				mpDao.clear();
    				int num = mpDao.save(list2);
    				if(num <= 0){
    					res = -3;
    	    			errorMsg = "插入失败";
    				}
    			}
    			
    			
    		}else{
    			res = -3;
    			errorMsg = "数据错误";
    		}
    	}
    	
    	res++;
		return baseOQ.toOneLineJSON(res,errorMsg);
	}
	
	public static String getQuotationNumber(String projectCode , String infoCode) throws SQLException{
		StringBuffer quotationNumber=new StringBuffer();
		OutQuotation outQuotation=new OutQuotation();
        outQuotation.setConditionInfoCode("=", infoCode);
        outQuotation.setConditionProjectCode("=", projectCode);
        List<BaseOutQuotation> l=outQuotation.conditionalLoad();
        int number=l.size();
        SimpleDateFormat sdf=new SimpleDateFormat("MMdd");
    	String tempNumber=sdf.format(new Date());
    	quotationNumber.append(projectCode);
    	quotationNumber.append("-");	
    	quotationNumber.append(tempNumber);
    	quotationNumber.append("-");	
    	quotationNumber.append((number+1));
		return BaseHelpUtils.getString(quotationNumber);
	}

}
