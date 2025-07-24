package com.pomplatform.client.onrevenue.panel;

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
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.onrevenue.datasource.DSAttachmentRecord;
import com.pomplatform.client.onrevenue.datasource.DSBusinessStateOtherRecord;
import com.pomplatform.client.onrevenue.datasource.DSFinishPercentRecord;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FinishPercentSureDesignPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    //定义一个map，用于存放已经处理的附件的id
    private Map<Integer,Integer> isHandleMap;
    //定义一个map，用于存放新处理的附件的id
    private Map<Integer,Integer> newIsHandleMap;
    
    private VLayout totalLayout;
    private HLayout topHLayout;
    private HLayout topLeftHLayout;
    private VLayout topRightHLayout;
    
    private HLayout centerHLayout;
    private DynamicForm searchForm;
    private VLayout vLayout;
    
    private ComboBoxItem signingCompanyItem;
    private DateItem endDateItem;
    
    private IButton searchButton;
    private IButton refreshButton;
    
    private HLayout sureHLayout;
    private DynamicForm finishPercentForm;
    private TextItem finishPercentItem;
    private TextItem finishPercentDetailItem;
    private IButton sureButton;
    private IButton loadButton;
    
    //定义左边的汇总数据集的gird开始***********************
    
    //业态表grid
    private DelicacyListGrid sourceGrid;
    //附件grid
    private DelicacyListGrid attachmentGrid;
    //订单grid
    private DelicacyListGrid finishPercentGrid;
    
    //定义左边的汇总数据集的gird结束***********************
    
    public FinishPercentSureDesignPanel() {
    	
    	totalLayout = new VLayout(10);
        totalLayout.setWidth100();
        totalLayout.setHeight100();
        
    	topHLayout = new HLayout();
        topHLayout.setWidth100();
        topHLayout.setHeight("8%");
        topHLayout.setBackgroundColor("#e2e2e2");
        
        topLeftHLayout = new HLayout();
        topLeftHLayout.setWidth("25%");
        
        signingCompanyItem = new ComboBoxItem("signingCompany", "签约公司");
        signingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
        
        endDateItem = new DateItem("endDate", "结束年月份");
        endDateItem.setDefaultValue(new Date());
        endDateItem.setShowIcons(false);
        endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        searchForm = new DynamicForm();
        searchForm.setWidth("70%");
        searchForm.setHeight100();
        searchForm.setNumCols(5);
        searchForm.setMargin(10);
        searchForm.setItems(signingCompanyItem,endDateItem);
        
        topRightHLayout = new VLayout();
        topRightHLayout.setBackgroundColor("#e2e2e2");
        topRightHLayout.setHeight100();
        topRightHLayout.setWidth("5%");
        topRightHLayout.setLayoutTopMargin(10);
        topRightHLayout.setLayoutLeftMargin(5);
        topRightHLayout.setLayoutRightMargin(5);
        topRightHLayout.setMembersMargin(10);
        
        searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        
        topRightHLayout.addMember(searchButton);
        topRightHLayout.addMember(refreshButton);
        
        topHLayout.addMember(topLeftHLayout);
        topHLayout.addMember(searchForm);
        topHLayout.addMember(topRightHLayout);
        
        centerHLayout = new HLayout();
        centerHLayout.setWidth100();
        centerHLayout.setHeight("92%");
        
    	//业态表grid
    	sourceGrid = new DelicacyListGrid();
    	sourceGrid.setWidth("30%");
    	DSBusinessStateOtherRecord recordDataSource = DSBusinessStateOtherRecord.getInstance();
    	sourceGrid.setDataSource(recordDataSource);
    	
    	vLayout = new VLayout(10);
        vLayout.setBackgroundColor("#e2e2e2");
        vLayout.setHeight100();
        vLayout.setWidth("40%");
        vLayout.setOverflow(Overflow.AUTO);
        vLayout.setMargin(10);
        
        sureHLayout = new HLayout();
        sureHLayout.setHeight("3%");
        sureHLayout.setMargin(10);
        
        finishPercentItem = new TextItem("finishPercent", "完工比");
        finishPercentItem.setWidth("*");
        
        finishPercentDetailItem = new TextItem("finishPercentDetail", "增量比");
        finishPercentDetailItem.setWidth("*");
       
        finishPercentForm = new DynamicForm();
        finishPercentForm.setWidth("80%");
//        finishPercentForm.setTitleOrientation(TitleOrientation.TOP);
//        finishPercentForm.setTitleAlign(Alignment.LEFT);
        finishPercentForm.setNumCols(4);
        finishPercentForm.setMargin(10);
        finishPercentForm.setItems(finishPercentItem,finishPercentDetailItem);
        
        sureButton = new IButton("确认");
        loadButton = new IButton("加载未处理附件");
        
        VLayout sureButtonLayout = new VLayout();
        sureButtonLayout.setMargin(10);
        sureButtonLayout.setWidth("20%");
        sureButtonLayout.setLayoutLeftMargin(10);
        sureButtonLayout.setMembersMargin(10);
        sureButtonLayout.addMember(sureButton);
        sureButtonLayout.addMember(loadButton);
        
        sureHLayout.addMember(finishPercentForm);
        sureHLayout.addMember(sureButtonLayout);
        
    	//附件grid
        attachmentGrid = new DelicacyListGrid();
        attachmentGrid.setHeight("97%");
        DSAttachmentRecord attachmentDataSource = DSAttachmentRecord.getInstance();
    	attachmentGrid.setDataSource(attachmentDataSource);
    	attachmentGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
    	attachmentGrid.setShowSelectedStyle(false);
    	attachmentGrid.setShowPartialSelection(true);
    	attachmentGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				ListGridRecord record = event.getRecord();
				//获取当前gird的附件id
				int projectAttachmentId = record.getAttributeAsInt("projectAttachmentId");
				//先判读该附件是否在上一次确认营收时已做处理，如果是，则不可做任何操作
				if(isHandleMap.containsKey(projectAttachmentId)){
					return;
				}
				boolean isHandle = event.getState();
				if(isHandle){
					newIsHandleMap.put(projectAttachmentId,projectAttachmentId);
				}else{
					newIsHandleMap.remove(projectAttachmentId);
				}
			}
		});
    	
    	vLayout.addMember(sureHLayout);
        vLayout.addMember(attachmentGrid);
    	
    	//订单grid
    	finishPercentGrid = new DelicacyListGrid();
    	finishPercentGrid.setWidth("30%");
    	DSFinishPercentRecord finishPercentDataSource = DSFinishPercentRecord.getInstance();
    	finishPercentGrid.setDataSource(finishPercentDataSource);
    	
    	centerHLayout.addMember(sourceGrid);
        centerHLayout.addMember(vLayout);
        centerHLayout.addMember(finishPercentGrid);
    	
    	totalLayout.addMember(topHLayout);
    	totalLayout.addMember(centerHLayout);
    	
    	addMember(totalLayout);
    	
    	//左边grid双击事件处理开始**********************************
        sourceGrid.addDoubleClickHandler(new com.smartgwt.client.widgets.events.DoubleClickHandler() {
			@Override
			public void onDoubleClick(com.smartgwt.client.widgets.events.DoubleClickEvent event) {
				ListGridRecord[] selected = sourceGrid.getSelectedRecords();
				//获取合同编号
				String contractCode = selected[0].getAttribute("contractCode");
				//获取完工比
				String finishPercent = selected[0].getAttribute("finishPercent");
				//获取完工比明细
				String finishPercentDetail = selected[0].getAttribute("finishPercentDetail");
				finishPercentItem.setValue(finishPercent);
				finishPercentDetailItem.setValue(finishPercentDetail);
				setFinishPercentDetail(BaseHelpUtils.getDoubleValue(finishPercentDetail));
				//加载拥有附件的订单信息
				loadSheetAttachment(contractCode,true);
				//加载订单完工比信息
				loadSheetFinishPercent(contractCode);
			}
		});
        
        attachmentGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			@Override
			public void onCellDoubleClick(CellDoubleClickEvent event) {
				// TODO Auto-generated method stub
				ListGridRecord record = event.getRecord();
				//获取合同编号
				String contractCode = record.getAttribute("contractCode");
				//加载业态信息
				loadBusinessState(contractCode);
				//加载完工比信息
				loadSheetFinishPercent(contractCode);
			}
		});
        
        //左边grid双击事件处理结束**********************************
        
        
        //右边按钮点击事件处理开始***********************************
        
        //搜索按钮处理事件
        searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
				onSearch();
			}
		});
        
        //重置按钮处理事件
        refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
				endDateItem.setValue(new Date());
				signingCompanyItem.setValue("");
				onSearch();
			}
		});
        
        //点击确认按钮
        sureButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
				//获取结束日期
				Date endDateValue = endDateItem.getValueAsDate();
				//获取完工比
				final double finishPercent = ClientUtil.checkAndGetDoubleValue(finishPercentItem._getValue());
				final double finishPercentDetail = ClientUtil.checkAndGetDoubleValue(finishPercentDetailItem._getValue());
				if(finishPercent == 0.0){//如果完工比为空的话请先输入完工比
					SC.say("提示","请输入标准格式的完工比");
					return;
				}
				if(finishPercentDetail == 0.0){//如果完工比明细为空的话请先输入完工比
					SC.say("提示","请输入标准格式的完工比明细");
					return;
				}
				if(finishPercentDetail < finishPercent){
					SC.say("提示","您输入的完工比明细不可小于完工比");
					return;
				}
				if (!sourceGrid.anySelected()) {
					SC.say("请选择一条业态信息");
					return;
				}
				
				if(finishPercentDetail== getFinishPercentDetail()){
					SC.say("提示","完工比未有调整,无需提交");
					return;
				}
				
				String ids="";
				int len = newIsHandleMap.size();
				int i = 1;
				for(Integer id : newIsHandleMap.keySet()){
					ids += id;
					if(i < len){
						ids += ",";
					}
					i++;
				}
				final ListGridRecord record = sourceGrid.getSelectedRecord();
				//获取合同编号
				String contractCode = record.getAttribute("contractCode");
				//获取业态编号
				String businessCode = record.getAttribute("businessCode"); 
				//获取业态名称
				String businessName = record.getAttribute("businessName");
				//获取业态总金额
				double businessIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("businessIntegral"));
				//获取签约公司
				int signingCompany = ClientUtil.checkAndGetIntValue(record.getAttribute("signingCompany"));
				//获取当前操作人
				int operateEmployeeId = ClientUtil.getEmployeeId();
				Map param = new HashMap<>();
				param.put("optType","onSaveFinishPercent");
				param.put("accountDate", endDateValue);
				param.put("finishPercent", finishPercent);
				param.put("finishPercentDetail", finishPercentDetail);
				param.put("contractCode", contractCode);
				param.put("businessCode", businessCode);
				param.put("businessName", businessName);
				param.put("businessIntegral", businessIntegral);
				param.put("signingCompany", signingCompany);
				param.put("operateEmployeeId", operateEmployeeId);
				param.put("ids", ids);
				
				DBDataSource.callOperation("EP_OnAboutRevenue", param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							SC.say("提示","操作成功");
							record.setAttribute("finishPercent", finishPercent);
							record.setAttribute("finishPercentDetail", finishPercentDetail);
							sourceGrid.updateData(record);
						} else {
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});
        
        loadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//加载未处理的所有附件信息
				loadSheetAttachment(null,false);
				//清空完工比
				finishPercentItem.setValue("");
			}
		});
    }

    @Override
    public void startEdit() {
    	onSearch();
    }
    
    //搜索方法
    private void onSearch(){
    	//加载业态表信息
    	loadBusinessState(null);
    	//加载拥有附件的订单信息
    	loadSheetAttachment(null,true);
    }
    
    //加载业态表信息
    public void loadBusinessState(String contractCode){
    	//获取结束日期
		Date endDateValue = endDateItem.getValueAsDate();
		int month = endDateValue.getMonth();
		//设置当前月累加一个月,并初始化为第一天
		endDateValue.setMonth(month+1);
		endDateValue.setDate(1);
		Map param = new HashMap<>();
		param.put("optType","onLoadBusinessState");
		param.put("signingCompany", signingCompanyItem._getValue());
		param.put("endDate", endDateValue);
		param.put("month", (month+1));
		param.put("contractCode", contractCode);
		DBDataSource.callOperation("EP_OnAboutRevenue", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					sourceGrid.setData(dsResponse.getData());
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
    }
    
    //加载拥有附件的订单信息(loadAll表示是否加载所有的附件，包含已处理和未处理的)
    public void loadSheetAttachment(String contractCode,boolean loadAll){
    	isHandleMap = new HashMap<>();
    	newIsHandleMap = new HashMap<>();
    	Map paramChild = new HashMap<>();
    	paramChild.put("optType", "onLoadSheetAttachment");
    	paramChild.put("contractCode", contractCode);
    	paramChild.put("loadAll", loadAll);
		DBDataSource.callOperation("EP_OnAboutRevenue", paramChild, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					attachmentGrid.setData(records);
					if(records.length>0){
						for(Record e : records){//遍历将已处理的附件id，保存至map中
							//获取附件是否处理
							boolean isHandle = e.getAttributeAsBoolean("isHandle");
							if(isHandle){
								//获取附件ID
								int projectAttachmentId = e.getAttributeAsInt("projectAttachmentId");
								isHandleMap.put(projectAttachmentId, projectAttachmentId);
								attachmentGrid.selectRecord(e);
							}
						}
					}
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
    }
    
    //加载订单完工比信息
    public void loadSheetFinishPercent(String contractCode){
    	Map paramChild = new HashMap<>();
    	paramChild.put("optType", "onLoadSheetFinishPercent");
    	paramChild.put("contractCode", contractCode);
		DBDataSource.callOperation("EP_OnAboutRevenue", paramChild, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					finishPercentGrid.setData(dsResponse.getData());
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
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

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_CompanyReportIntegral";
    }
    
    double finishPercentDetail;

	public double getFinishPercentDetail() {
		return finishPercentDetail;
	}

	public void setFinishPercentDetail(double finishPercentDetail) {
		this.finishPercentDetail = finishPercentDetail;
	}
    
    
}
