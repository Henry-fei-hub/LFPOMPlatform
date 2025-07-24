package com.pomplatform.client.check.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnAttendanceAnalysisDetailPanel extends AbstractWizadPage {
    
    private final HLayout hLayout;
    private VLayout gridVLayout;
    private DelicacyListGrid resultGrid;
    
	public OnAttendanceAnalysisDetailPanel(int type) {
    
        hLayout = new HLayout(10);
        hLayout.setWidth100();
        hLayout.setHeight100();
        
        gridVLayout = new VLayout(10);
        gridVLayout.setWidth100();
        gridVLayout.setHeight100();
        
        resultGrid = new DelicacyListGrid();
        resultGrid.setShowRowNumbers(true);
        resultGrid.setAutoFitFieldWidths(false);
        resultGrid.setWidth100();
        resultGrid.setHeight("80%");
        ListGridField employeeNoField = new ListGridField("employeeNo", "编号");  
        ListGridField employeeNameField = new ListGridField("employeeName", "姓名");
        ListGridField typeField = new ListGridField("type", "假期类型");
//        typeField.setValueMap(KeyValueManager.getValueMap("leave_types"));
        KeyValueManager.loadValueMap("leave_types",typeField);
        ListGridField reasonField = new ListGridField("reason", "事由");  
         
        if(type == 13){//说明是请假
        	resultGrid.setFields(employeeNoField,employeeNameField,typeField,reasonField);
        }else{
        	resultGrid.setFields(employeeNoField,employeeNameField,reasonField);
        }
        
        gridVLayout.addMember(resultGrid);
        
		hLayout.addMember(gridVLayout);
        
        addMember(hLayout);
        
    }
    

    @Override
    public void startEdit() {
    	onSearch();
    }
    
    //搜索方法
	private void onSearch(){
		Map<String,Object> param = new HashMap<>();
		param.put("startDate", recordDate);
		param.put("endDate", recordDate);
		param.put("plateId", plateId);
		param.put("processType", processType);
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("NQ_OnLoadAttendanceStatusDetial", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					resultGrid.setData(dsResponse.getData());
				}
				loading.destroy();
			}
		});
    }
    

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCompanyReportIntegralDataSource.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_OnShiftManageProcess";
    }
    
    private Date recordDate = new Date();
    private int plateId;
    private int processType;

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	public int getPlateId() {
		return plateId;
	}


	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}


	public int getProcessType() {
		return processType;
	}


	public void setProcessType(int processType) {
		this.processType = processType;
	}
    
	
}

