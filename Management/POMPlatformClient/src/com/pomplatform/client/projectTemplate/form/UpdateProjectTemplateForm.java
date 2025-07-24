package com.pomplatform.client.projectTemplate.form;

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
import com.smartgwt.client.util.SC;

public class UpdateProjectTemplateForm extends GenericWizadWindow {

	private static final Logger __logger = Logger.getLogger("");
	@Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_OnProjectWithStageCommon";
    }

    @Override
    public boolean checkData(Map data) {
        return DataVerification.checkProjectStagePercent2(data);
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
        map.put("projectTemplateId", projectTemplateId);
        map.put("projectTemplateName", projectTemplateName);
        map.put("projectType", projectType);
        map.put("businessType", businessType);
        map.put("plateId", plateId);
        SprojectTemplateDetailProjectStage projectstage = new SprojectTemplateDetailProjectStage(map);
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
    	values.put("projectId", projectId);
    	return values;
    }
    
    
    
    
    private int plateId;
    private int projectType;
    private int businessType;
    private String projectTemplateName;
    private int projectTemplateId;
	private int projectId;
	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getProjectType() {
		return projectType;
	}

	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public String getProjectTemplateName() {
		return projectTemplateName;
	}

	public void setProjectTemplateName(String projectTemplateName) {
		this.projectTemplateName = projectTemplateName;
	}

	public int getProjectTemplateId() {
		return projectTemplateId;
	}

	public void setProjectTemplateId(int projectTemplateId) {
		this.projectTemplateId = projectTemplateId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


}
