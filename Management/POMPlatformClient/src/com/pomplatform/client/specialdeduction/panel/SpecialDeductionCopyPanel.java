package com.pomplatform.client.specialdeduction.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.client.workflow.specialdeduction.form.SpecialDeductionInformationUpdateForm;
import com.pomplatform.client.dataverification.DataVerification;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation7;
import com.pomplatform.client.stage.form.SprojectporDetailProjectStage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class SpecialDeductionCopyPanel extends GenericWizadWindow {

	private static final Logger __logger = Logger.getLogger("");
	@Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_UpdateSpecialDeductionInformation";
    }

    @Override
    public boolean checkData(Map data) {
		boolean status = true;
		for(AbstractWizadPage wp : __pages){
			if(!wp.checkData()){
				status = false;
			}
		}
		return status;
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
		List<AbstractWizadPage> res = new ArrayList<>();
		SpecialDeductionInformation7 specialDeductionInformation1 = new SpecialDeductionInformation7();
		specialDeductionInformation1.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);	
		res.add(specialDeductionInformation1);
		
        return res;
    }
    
    @Override
    public Map getValues() {
    	Map<String,Object> values = new HashMap<>();
    	for (AbstractWizadPage p : __pages) {
    		values = p.getValuesAsMap();
    	}
    	return values;
    }
}
