package com.pomplatform.client.project.form;

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

public class UpdateProjectManagerForm extends GenericWizadWindow {

	private static final Logger __logger = Logger.getLogger("");
	@Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_UpdateProjectWithStage";
//        return "EP_OnProjectWithStageCommon";
    }

    @Override
    public boolean checkData(Map data) {
        return DataVerification.checkProjectStagePercent(data);
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
        map.put("projectId", projectId);
        map.put("projectName", projectName);
        map.put("projectIntegral", projectIntegral);
        map.put("projectType", projectType);
        map.put("plateId", plateId);
//        res.add(new SProjectManagerUpdateForm());
        SprojectporDetailProjectStage projectstage = new SprojectporDetailProjectStage(map);
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
    
    
    
    
    //订单表查询(业务部门，项目类别，业务类别)plate_id,project_type,business_type
    private String plateId;
    private String projectType;
    private String businessType;
    private String projectName;
	private BigDecimal projectIntegral;
	private int projectId;

	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public BigDecimal getProjectIntegral() {
		return projectIntegral;
	}
	
	public void setProjectIntegral(BigDecimal projectIntegral) {
		this.projectIntegral = projectIntegral;
	}

}
