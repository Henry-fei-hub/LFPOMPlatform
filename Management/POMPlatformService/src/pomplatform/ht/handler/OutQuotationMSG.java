package pomplatform.ht.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.ProjectPerformanceNodeEmployee;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import message.common.ERPWeixinUtils;

public class OutQuotationMSG implements GenericProcessor {

	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        int businessType = BaseHelpUtils.getIntValue(param.get("businessType"));
        String infoCode = BaseHelpUtils.getString(param.get("infoCode"));
//        String projectCode = BaseHelpUtils.getString(param.get("projectCode"));
		
        String msg="";
        if(businessType==1) {
        	msg = "您好，项目编号为:%1$s的%2$s项目报价单已提交，请尽快拆分价";
        }else {
        	msg = "您好，项目编号为:%1$s的%2$s项目拆分价已提交，请尽快下达订单";
        }
        
        PreProject pdao =new PreProject();
        pdao.setConditionInfoCode("=", infoCode);
        BasePreProject executeQueryOneRow = pdao.executeQueryOneRow();
        String projectName ="";
        String projectCode ="";
        if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
        	projectName=executeQueryOneRow.getProjectName();
        	projectCode=executeQueryOneRow.getProjectCode();
        }
        
		//查询符合条件的人员
		ProjectPerformanceNodeEmployee dao =new ProjectPerformanceNodeEmployee();
		dao.setConditionBusinessType("=", businessType);
		List<BaseProjectPerformanceNodeEmployee> conditionalLoad = dao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()>0) {
			for (BaseProjectPerformanceNodeEmployee baseProjectPerformanceNodeEmployee : conditionalLoad) {
				Integer employeeId = baseProjectPerformanceNodeEmployee.getEmployeeId();
				if(!BaseHelpUtils.isNullOrEmpty(projectName)&&!BaseHelpUtils.isNullOrEmpty(projectCode)) {
					ERPWeixinUtils.sendWXMsgToUser(employeeId,String.format(msg,projectCode,projectName));
				}
			}
		}
		 BaseOutQuotation baseOQ=new BaseOutQuotation();
		 return baseOQ.toOneLineJSON(1,"");
	}
	
	
/*	public static void main(String[] args) throws Exception {
		
		execute("",null);
	}*/
	
	/*
    public void getOneData(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("businessType", 1);
    	DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","find",params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	oneGrid.setData(dsResponse.getData());
                } else {
					Map errors = dsResponse.getErrors();
                    SC.say("加载失败",errors.get("errorMsg")+"");
                }
            }
        });
    }
    
    public void getTwoData(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("businessType", 2);
    	DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","find",params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	twoGrid.setData(dsResponse.getData());
                } else {
					Map errors = dsResponse.getErrors();
                    SC.say("加载失败",errors.get("errorMsg")+"");
                }
            }
        });
    }*/

}
