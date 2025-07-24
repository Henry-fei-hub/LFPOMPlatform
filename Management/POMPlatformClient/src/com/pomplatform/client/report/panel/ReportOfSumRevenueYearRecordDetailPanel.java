package com.pomplatform.client.report.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.pomplatform.client.report.datasource.DSReportOfSumRevenueYearRecordDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportOfSumRevenueYearRecordDetailPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板
    private VLayout mainLayout;
    //定义top层，搜索栏
    private HLayout topLayout;
    //内容展示grid
    private HLayout contentLayout;
    
    private DelicacyListGrid summaryGrid;
    
    private DynamicForm __infoForm; 
    private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
    private IButton searchIbutton;
    private IButton resetIbutton;
    
	public ReportOfSumRevenueYearRecordDetailPanel() {
    	mainLayout = new VLayout(10);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(0);
    	
    	topLayout = new HLayout(10);
    	topLayout.setWidth100();
    	topLayout.setHeight("10%");
    	topLayout.setBorder(BORDER_STYLE);
    	topLayout.setLayoutTopMargin(10);
    	topLayout.setBackgroundColor("#f2f2f2");
    	
    	contractCodeItem = new TextItem("contractCode", "订单编号");
    	contractCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
    	
    	__infoForm = new DynamicForm();
    	__infoForm.setItems(contractCodeItem,projectNameItem);
    	__infoForm.setNumCols(4);
    	__infoForm.setWidth("80%");
    	__infoForm.setHeight100();
    	ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
    	topLayout.addMember(__infoForm);
    	
    	searchIbutton = new IButton("搜索");
    	searchIbutton.setHeight(26);
    	HLayout vbtn=new HLayout(10);
    	vbtn.setLayoutTopMargin(20);
        vbtn.addMember(searchIbutton);
    	searchIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
    	
    	resetIbutton = new IButton("重置");
    	resetIbutton.setHeight(26);
    	vbtn.addMember(resetIbutton);
    	topLayout.addMember(vbtn);
    	resetIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				__infoForm.editNewRecord();
			}
		});
    	
    	IButton downloadButton = new IButton("导出");
    	downloadButton.setHeight(26);
    	vbtn.addMember(downloadButton);
    	downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ReportOfSumRevenueYearRecordDetail", condition);
			}
		});
    	
    	
    	contentLayout = new HLayout(10);
    	contentLayout.setWidth100();
    	contentLayout.setLayoutTopMargin(20);
    	contentLayout.setHeight("90%");
    	
    	summaryGrid = new DelicacyListGrid();
    	summaryGrid.setWidth100();
    	summaryGrid.setHeight100();
    	summaryGrid.setDataSource(DSReportOfSumRevenueYearRecordDetail.getInstance());
    	summaryGrid.setCanEdit(false);
    	contentLayout.addMember(summaryGrid);
    	
    	summaryGrid.setAutoFitFieldWidths(false);
    	summaryGrid.setShowGridSummary(true);
    	summaryGrid.setShowRowNumbers(true);
    	mainLayout.addMember(topLayout);
    	mainLayout.addMember(contentLayout);
    	addMember(mainLayout);
    }

	public Map<String,Object> generateCriteria() {
		Map<String,Object> param = new HashMap<>();
		param.put("plateId", plateId);
		param.put("year", year);
    	if(!BaseHelpUtils.isNullOrEmpty(contractCodeItem.getValue())){
    		param.put("contractCode", contractCodeItem.getValue());
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(projectNameItem.getValue())){
    		param.put("projectName", projectNameItem.getValue());
    	}
    	return param;
	}
	
    @Override
    public void startEdit() {
    	Map<String,Object> param = generateCriteria();
    	final LoadingWindow loading = new LoadingWindow();
    	DBDataSource.callOperation("NQ_ReportOfSumRevenueYearRecordDetail", param, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if(dsResponse.getStatus() >= 0){
					summaryGrid.setData(dsResponse.getData());
				}
			}
		});
    }
    
    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    
    int plateId;
	int year;
	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
    
}
