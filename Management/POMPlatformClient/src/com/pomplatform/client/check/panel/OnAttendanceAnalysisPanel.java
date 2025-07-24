package com.pomplatform.client.check.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.check.datasource.DSOnAttendanceAnalysis;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnAttendanceAnalysisPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    
    private final HLayout hLayout;
    private VLayout gridVLayout;
    private final VLayout controlLayout;
    private DelicacyListGrid resultGrid;
    
    private final IButton searchButton;
    private final IButton refreshButton;
    
    //业务部门 搜索框
    private ComboBoxItem plateIdItem;
    private DateItem recordDateItem;
    
	public OnAttendanceAnalysisPanel() {
    
        hLayout = new HLayout(10);
        hLayout.setWidth100();
        hLayout.setHeight100();
        
        gridVLayout = new VLayout(10);
        gridVLayout.setWidth("95%");
        gridVLayout.setHeight100();
        
        HLayout searchButtonHLayout = new HLayout(10);
    	searchButtonHLayout.setWidth100();
    	searchButtonHLayout.setHeight("5%");
    	searchButtonHLayout.setBackgroundColor("#e2e2e2");
    	searchButtonHLayout.setLayoutTopMargin(10);
    	searchButtonHLayout.setAlign(Alignment.CENTER);
    	
    	//向按钮搜索栏添加搜索按钮
    	IButton todayButton = new IButton("今日");
    	IButton tomorrowButton = new IButton("明日");
    	IButton lastButton = new IButton("后日");
    	searchButtonHLayout.addMember(todayButton);
    	searchButtonHLayout.addMember(tomorrowButton);
    	searchButtonHLayout.addMember(lastButton);
    	
    	gridVLayout.addMember(searchButtonHLayout);
    	//按钮搜索事件处理开始************************************
    	todayButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setRecordDate(new Date());
				onSearch();
			}
		});
    	tomorrowButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				Date date = new Date();
				date.setDate(date.getDate()+1);
				setRecordDate(date);
				onSearch();
			}
		});
    	lastButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				Date date = new Date();
				date.setDate(date.getDate()+2);
				setRecordDate(date);
				onSearch();
			}
		});
    	//按钮搜索事件处理结束************************************
    	
    	//文本搜索栏
    	HLayout searchTextHLayout = new HLayout(10);
    	searchTextHLayout.setWidth100();
    	searchTextHLayout.setHeight("5%");
    	searchTextHLayout.setBackgroundColor("#e2e2e2");
    	searchTextHLayout.setAlign(Alignment.CENTER);
    	//项目文本搜索栏添加文本搜索项
    	DynamicForm __searchForm = new DynamicForm();
    	__searchForm.setNumCols(6);
    	ClientUtil.DynamicFormProcessAccordingToDevice(__searchForm);
    	plateIdItem = new ComboBoxItem("业务部门");
    	plateIdItem.setWidth("*");
    	plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
    	recordDateItem = new DateItem("recordDate", "分析日期");
    	recordDateItem.setWidth("*");
    	recordDateItem.setUseTextField(true);
    	recordDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
    	recordDateItem.setDefaultValue(new Date());
    	__searchForm.setItems(plateIdItem,recordDateItem);
    	searchTextHLayout.addMember(__searchForm);
    	gridVLayout.addMember(searchTextHLayout);
        
        resultGrid = new DelicacyListGrid();
        resultGrid.setShowRowNumbers(true);
        resultGrid.setAutoFitFieldWidths(false);
        resultGrid.setWidth100();
        resultGrid.setDataSource(DSOnAttendanceAnalysis.getInstance());
        resultGrid.setHeight("80%");
        gridVLayout.addMember(resultGrid);
        
		hLayout.addMember(gridVLayout);
		
		controlLayout = new VLayout();
		controlLayout.setBackgroundColor("#e2e2e2");
        controlLayout.setHeight100();
        controlLayout.setWidth("5%");
        controlLayout.setLayoutTopMargin(10);
        controlLayout.setLayoutLeftMargin(5);
        controlLayout.setLayoutRightMargin(5);
        controlLayout.setMembersMargin(10);
        
        searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        
        controlLayout.addMember(searchButton);
        controlLayout.addMember(refreshButton);
        hLayout.addMember(controlLayout);
        
        addMember(hLayout);
        
        //中间的grid点击事件开始***********************************
        resultGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			
			@Override
			public void onCellDoubleClick(CellDoubleClickEvent event) {
				Record r = event.getRecord();
				//获取业务部门
				int plateId = BaseHelpUtils.getIntValue(r.getAttribute("plateId"));
				int colNum = event.getColNum();
				int processType = 0; 
				String name = "";
				if(colNum == 3){//出差
					processType = 14;
					name = "出差";
				}else if(colNum == 4){//外出
					processType = 16;
					name = "外出";
				}else if(colNum == 5){//请假
					processType = 13;
					name = "请假";
				}else if(colNum == 6){//迟到
					processType = 2;
					name = "迟到";
				}else if(colNum == 7){//早退
					processType = 3;
					name = "早退";
				}else if(colNum == 8){//旷工
					processType = 4;
					name = "旷工";
				}else{
					processType = 14;
					name = "出差";
				}
				String plateName = KeyValueManager.getValue("system_dictionary_1",plateId+"");
				final PopupWindow popupWindow = new PopupWindow(plateName+name+"详情");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				OnAttendanceAnalysisDetailPanel assignIntegral = new OnAttendanceAnalysisDetailPanel(processType);
				assignIntegral.setPlateId(plateId);
				assignIntegral.setProcessType(processType);
				assignIntegral.setRecordDate(recordDate);
				popupWindow.addItem(assignIntegral);
				assignIntegral.startEdit();
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				popupWindow.addChild(assignIntegral);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
        
	    //搜索按钮处理事件
	    searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onSearch();
			}
		});
	    
	    //重置按钮处理事件
	    refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				plateIdItem.setValue("");
				recordDateItem.setValue(new Date());
			}
		});
        
    }
    

    @Override
    public void startEdit() {
    }
    
    //搜索方法
	private void onSearch(){
		Map<String,Object> param = new HashMap<>();
		param.put("optType","onCheckTotalAccount");
		param.put("recordDate", recordDate);
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
		if(plateId > 0){
			param.put("plateId", plateId);
		}
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_OnShiftManageProcess", param, new DSCallback() {
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
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_OnShiftManageProcess";
    }
    
    private Date recordDate = new Date();

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
    
}

