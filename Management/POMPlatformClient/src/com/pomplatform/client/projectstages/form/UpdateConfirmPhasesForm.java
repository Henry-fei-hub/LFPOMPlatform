package com.pomplatform.client.projectstages.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.dataverification.DataVerification;
import com.pomplatform.client.stage.form.SprojectporDetailProjectStage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class UpdateConfirmPhasesForm extends GenericWizadWindow {

	private static final Logger __logger = Logger.getLogger("");
	@Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_UpdateProjectWithStage";
    }

    @Override
    public boolean checkData(Map data) {
//        return DataVerification.checkProjectStagePercent(data);
		boolean flag =  true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if(!abstractWizadPage.checkData()){
				flag = false;
				break;
			}
		}
		return flag;
    }

    @Override
    public int getPageCount() {
        return 1;
    }

    @Override
    public List<AbstractWizadPage> getPages() {
        setCallback(new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                // 请在此编写成功保存后要做的工作
            }
        });
        setSubaction("update");
        List<AbstractWizadPage> res = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("contractId", contractId);
        map.put("projectAmountSum", projectAmountSum);
        map.put("contractName", contractName);
        SProjectStage projectstage = new SProjectStage(map);
        projectstage.setRecord(getRecord());
        projectstage.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
        res.add(projectstage);
        return res;
    }
    
    @Override
    public Map getValues() {
    	Map<String,Object> values = new HashMap<>();
    	for (AbstractWizadPage p : __pages) {
    		values = p.getValuesAsMap();
    	}
    	values.put("contractId", contractId);
    	return values;
    }
    
    
    private int contractId;
    private BigDecimal projectAmountSum;
    private String contractName;
    
	public BigDecimal getProjectAmountSum() {
		return projectAmountSum;
	}

	public void setProjectAmountSum(BigDecimal projectAmountSum) {
		this.projectAmountSum = projectAmountSum;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
    
    
    
    
    
    

}
