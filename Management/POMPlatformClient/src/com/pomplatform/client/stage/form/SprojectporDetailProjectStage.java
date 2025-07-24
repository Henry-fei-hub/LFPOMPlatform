package com.pomplatform.client.stage.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.stage.datasource.DSProjectStage;
import com.pomplatform.client.stage.datasource.DSSsystemdictionaryor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SprojectporDetailProjectStage extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid grid = new DelicacyListGrid();
    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final DynamicForm form;
    private int countPercent = 0;
    private BigDecimal projectIntegral;
    private BigDecimal settlementIntegral;
    private int attachmentNum;
    private String oldValue = null;
    private TextItem projectIntegralLeftItem;
    private TextItem projectIntegralItem;
    private TextItem projectNameItem;

    public SprojectporDetailProjectStage(Map<String,Object> map) {

        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth("50%");
        SearchSourceLayout.setHeight100();
        SearchSourceLayout.setLayoutTopMargin(10);
        SearchSourceLayout.setLayoutRightMargin(5);
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.setShowResizeBar(false);
        
        HLayout SourceLayout = new HLayout(5);
        SourceLayout.setWidth100();
        SourceLayout.setHeight100();
        SearchSourceLayout.addMember(SourceLayout);
        SourceGrid.setAutoFitFieldWidths(false);
        SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setDataSource(DSSsystemdictionaryor.getInstance());
        SourceLayout.addMember(SourceGrid);
        
        VLayout SourceControls = new VLayout();
        SourceControls.setHeight100();
        SourceControls.setWidth(60);
        SourceControls.setLayoutTopMargin(150);
        SourceControls.setLayoutLeftMargin(15);
        SourceControls.setLayoutRightMargin(5);
        SourceControls.setMembersMargin(10);
        SourceLayout.addMember(SourceControls);
        TransferImgButton AddToButton = new TransferImgButton(TransferImgButton.RIGHT);
        SourceControls.addMember(AddToButton);
        AddToButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!SourceGrid.anySelected()) {
                    return;
                }
                //项目积分为0的话，不能添加阶段
                if(BaseHelpUtils.getIntValue(map.get("projectIntegral")) == 0){
                	SC.say("提示","项目积分为0，无法添加阶段");
                	return;
                }
                addSelectedDataToTarget(SourceGrid, grid);
            }
        });
        SourceGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                if (!SourceGrid.anySelected()) {
                    return;
                }
              //项目积分为0的话，不能添加阶段
                if(BaseHelpUtils.getIntValue(map.get("projectIntegral")) == 0){
                	SC.say("提示","项目积分为0，无法添加阶段");
                	return;
                }
                addSelectedDataToTarget(SourceGrid, grid);
            }
        });
        addMember(SearchSourceLayout);
        
        VLayout rightLayout = new VLayout(10);
        rightLayout.setWidth("50%");
        rightLayout.setHeight100();
        
        HLayout infoLayout = new HLayout(10);
        infoLayout.setWidth("90%");
        infoLayout.setHeight("10%");
        infoLayout.setLayoutTopMargin(30);
        
        projectNameItem = new TextItem("projectName","订单名称");
        projectNameItem.setWidth("*");
        projectNameItem.setValue(map.get("projectName"));
        projectNameItem.setCanEdit(false);
        
        projectIntegralItem = new TextItem("projectIntegral","项目积分");
        projectIntegralItem.setWidth("*");
        projectIntegralItem.setValue(map.get("projectIntegral"));
        projectIntegralItem.setCanEdit(false);
        
        projectIntegralLeftItem = new TextItem("projectIntegralLeft","剩余积分");
        projectIntegralLeftItem.setWidth("*");
        projectIntegralLeftItem.setCanEdit(false);
        projectIntegral = BaseHelpUtils.getBigDecimalValue(projectIntegralItem.getValue());
        
        form = new DynamicForm();
        form.setNumCols(8);
        form.setWidth100();
        form.setHeight100();
        form.setItems(projectNameItem,projectIntegralItem,projectIntegralLeftItem);
        projectNameItem.setColSpan(3);
        infoLayout.addMember(form);
        rightLayout.addMember(infoLayout);
        
        
        HLayout projectStages = new HLayout();
        projectStages.setWidth100();
        projectStages.setHeight("90%");
        projectStages.setLayoutLeftMargin(20);
        grid.setCanReorderRecords(true);
        grid.setAutoFitFieldWidths(false);
        grid.setDataSource(DSProjectStage.getInstance());
        grid.setShowGridSummary(true);
        grid.setShowRowNumbers(true);
        grid.setCanRemoveRecords(true);
        projectStages.addMember(grid);
        
        
        VLayout projectStagesControls = new VLayout();
        projectStagesControls.setHeight100();
        projectStagesControls.setWidth(60);
        projectStagesControls.setLayoutTopMargin(30);
        projectStagesControls.setLayoutLeftMargin(5);
        projectStagesControls.setLayoutRightMargin(5);
        projectStagesControls.setMembersMargin(10);
        projectStages.addMember(projectStagesControls);
        rightLayout.addMember(projectStages);
        
        grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				Record record = grid.getSelectedRecord();
				Record[] oldData = grid.getRecords();
				Map<String,Object> params = new HashMap<>();
				params.put("projectId", record.getAttribute("projectId"));
				params.put("stageId", record.getAttribute("stageId"));
				DBDataSource.callOperation("ST_ProjectSettlement","find", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] result = dsResponse.getData();
							if(!BaseHelpUtils.isNullOrEmpty(result) && result.length > 0){
								grid.setData(oldData);
								grid.redraw();
								SC.say("提示","该阶段已有确认积分，无法删除");
							}else{
								BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmount"));
								BigDecimal projectIntegralLeft = BaseHelpUtils.getBigDecimalValue(projectIntegralLeftItem.getValue());
								projectIntegralLeftItem.setValue(projectAmount.add(projectIntegralLeft));
							}
						}
					}
				});
			}
		});
        
        grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				SC.debugger();
				ListGridRecord selected = grid.getSelectedRecord();
				ListGridRecord[] gridData = grid.getRecords();
				Map<String,Object> params = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(selected)){
                    Map<String,Object> param = new HashMap<>();
                    param.put("optType", "ModificationLimitationofStageProportion");
                    param.put("projectId", selected.getAttribute("projectId"));
                    param.put("stageId", selected.getAttribute("stageId"));
                    DBDataSource.callOperation("EP_ModificationLimitationofStageProportionProcess","find", param, new DSCallback() {

                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            SC.debugger();
                            if (dsResponse.getStatus() >= 0) {
                                Record record = dsResponse.getData()[0];
                                if(BaseHelpUtils.isNullOrEmpty(record)){
                                    params.put("projectId", selected.getAttribute("projectId"));
                                    params.put("stageId", selected.getAttribute("stageId"));
                                    DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", params, new DSCallback() {

                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if(dsResponse.getStatus() >= 0){
                                                oldValue = "";
                                                Record record = dsResponse.getData()[0];
                                                if(!BaseHelpUtils.isNullOrEmpty(record)){
                                                    attachmentNum = record.getAttributeAsInt("attachmentNum");
                                                    if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("settlementIntegral"))){
                                                        settlementIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("settlementIntegral"));
                                                    }else{
                                                        settlementIntegral = BigDecimal.ZERO;
                                                    }
                                                    if(attachmentNum > 0){
                                                        SC.say("提示","该阶段已确认，不能再修改");
                                                        return;
                                                    }
                                                }
                                                countPercent = 0;
                                                for(ListGridRecord e : gridData){
                                                    countPercent += BaseHelpUtils.getIntValue(e.getAttribute("percent"));
                                                }
                                                if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
                                                    countPercent = countPercent - BaseHelpUtils.getIntValue(selected.getAttribute("percent"));
                                                }
                                                if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
                                                    oldValue = BaseHelpUtils.getString(selected.getAttribute("percent"));
                                                }
                                                SC.askforValue("阶段占比:", new ValueCallback() {

                                                    @Override
                                                    public void execute(String value) {
                                                        if(BaseHelpUtils.isNullOrEmpty(value)){
                                                            value = oldValue;
                                                        }else{
                                                            if(BaseHelpUtils.getIntValue(value) < 0){
                                                                SC.say("提示","该阶段占比不可为负数");
                                                                value = oldValue;
                                                            }else if(BaseHelpUtils.getIntValue(value) == 0){
                                                                SC.say("提示","阶段占比不可等于0或不可输入小数点");
                                                                value = oldValue;
                                                            }
                                                        }
                                                        if(!BaseHelpUtils.isNullOrEmpty(settlementIntegral)){
                                                            if(settlementIntegral.compareTo(BigDecimal.ZERO) > 0 && attachmentNum == 0 && BaseHelpUtils.getIntValue(value) < BaseHelpUtils.getIntValue(oldValue)){
                                                                SC.say("提示","该阶段已在确认积分，阶段占比不可减少");
                                                                return;
                                                            }
                                                        }
                                                        int add = countPercent + BaseHelpUtils.getIntValue(value);
                                                        if(add > 100){
                                                            SC.say("提示","阶段总占比不能大于100%");
                                                            return;
                                                        }
                                                        selected.setAttribute("percent", BaseHelpUtils.getIntValue(value));
                                                        //阶段占比
                                                        BigDecimal percent = BaseHelpUtils.getBigDecimalValue(value).divide(BigDecimal.valueOf(100));
                                                        //阶段积分
                                                        BigDecimal projectAmount = BaseHelpUtils.format(projectIntegral.multiply(percent), 2);
                                                        selected.setAttribute("projectAmount", projectAmount);
                                                        BigDecimal projectUsed = BigDecimal.ZERO;
                                                        for(ListGridRecord e : gridData){
                                                            //已分配积分
                                                            projectUsed = projectUsed.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("projectAmount")));
                                                        }
                                                        //剩余积分
                                                        BigDecimal leftIntegral = projectIntegral.subtract(projectUsed);
                                                        //如果当前阶段总和为100,且剩余积分存在残余数据，则追加到当前阶段上
                                                        if(add == 100 && leftIntegral.compareTo(BigDecimal.ZERO) != 0){
                                                            projectAmount = projectAmount.add(leftIntegral);
                                                            leftIntegral = BigDecimal.ZERO;
                                                            selected.setAttribute("projectAmount", projectAmount);
                                                        }
                                                        grid.updateData(selected);
                                                        //剩余积分
                                                        projectIntegralLeftItem.setValue(leftIntegral);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                                int processStatus = record.getAttributeAsInt("processStatus");
                                SC.debugger();

                                if(processStatus!=5){
                                    SC.say("提示","该阶段已跨阶段审批或正在跨阶段审批，不能再修改");
                                    return;
                                }else {
                                    params.put("projectId", selected.getAttribute("projectId"));
                                    params.put("stageId", selected.getAttribute("stageId"));
                                    DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", params, new DSCallback() {

                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if(dsResponse.getStatus() >= 0){
                                                oldValue = "";
                                                Record record = dsResponse.getData()[0];
                                                if(!BaseHelpUtils.isNullOrEmpty(record)){
                                                    attachmentNum = record.getAttributeAsInt("attachmentNum");
                                                    if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("settlementIntegral"))){
                                                        settlementIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("settlementIntegral"));
                                                    }else{
                                                        settlementIntegral = BigDecimal.ZERO;
                                                    }
                                                    if(attachmentNum > 0){
                                                        SC.say("提示","该阶段已确认，不能再修改");
                                                        return;
                                                    }
                                                }
                                                countPercent = 0;
                                                for(ListGridRecord e : gridData){
                                                    countPercent += BaseHelpUtils.getIntValue(e.getAttribute("percent"));
                                                }
                                                if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
                                                    countPercent = countPercent - BaseHelpUtils.getIntValue(selected.getAttribute("percent"));
                                                }
                                                if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
                                                    oldValue = BaseHelpUtils.getString(selected.getAttribute("percent"));
                                                }
                                                SC.askforValue("阶段占比:", new ValueCallback() {

                                                    @Override
                                                    public void execute(String value) {
                                                        if(BaseHelpUtils.isNullOrEmpty(value)){
                                                            value = oldValue;
                                                        }else{
                                                            if(BaseHelpUtils.getIntValue(value) < 0){
                                                                SC.say("提示","该阶段占比不可为负数");
                                                                value = oldValue;
                                                            }else if(BaseHelpUtils.getIntValue(value) == 0){
                                                                SC.say("提示","阶段占比不可等于0或不可输入小数点");
                                                                value = oldValue;
                                                            }
                                                        }
                                                        if(!BaseHelpUtils.isNullOrEmpty(settlementIntegral)){
                                                            if(settlementIntegral.compareTo(BigDecimal.ZERO) > 0 && attachmentNum == 0 && BaseHelpUtils.getIntValue(value) < BaseHelpUtils.getIntValue(oldValue)){
                                                                SC.say("提示","该阶段已在确认积分，阶段占比不可减少");
                                                                return;
                                                            }
                                                        }
                                                        int add = countPercent + BaseHelpUtils.getIntValue(value);
                                                        if(add > 100){
                                                            SC.say("提示","阶段总占比不能大于100%");
                                                            return;
                                                        }
                                                        selected.setAttribute("percent", BaseHelpUtils.getIntValue(value));
                                                        //阶段占比
                                                        BigDecimal percent = BaseHelpUtils.getBigDecimalValue(value).divide(BigDecimal.valueOf(100));
                                                        //阶段积分
                                                        BigDecimal projectAmount = BaseHelpUtils.format(projectIntegral.multiply(percent), 2);
                                                        selected.setAttribute("projectAmount", projectAmount);
                                                        BigDecimal projectUsed = BigDecimal.ZERO;
                                                        for(ListGridRecord e : gridData){
                                                            //已分配积分
                                                            projectUsed = projectUsed.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("projectAmount")));
                                                        }
                                                        //剩余积分
                                                        BigDecimal leftIntegral = projectIntegral.subtract(projectUsed);
                                                        //如果当前阶段总和为100,且剩余积分存在残余数据，则追加到当前阶段上
                                                        if(add == 100 && leftIntegral.compareTo(BigDecimal.ZERO) != 0){
                                                            projectAmount = projectAmount.add(leftIntegral);
                                                            leftIntegral = BigDecimal.ZERO;
                                                            selected.setAttribute("projectAmount", projectAmount);
                                                        }
                                                        grid.updateData(selected);
                                                        //剩余积分
                                                        projectIntegralLeftItem.setValue(leftIntegral);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });


				}
			}
		});
        
        addMember(rightLayout);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void startEdit() {
        if (getPageMode() != PAGE_MODE_UPDATE) {
            return;
        }
        Map condition = new HashMap();
        condition.put("projectId", getRecord().getAttribute("projectId"));
        condition.put("addtionalCondition", " order by project_stage_id asc");
        DBDataSource.callOperation("ST_ProjectStage", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    grid.setData(dsResponse.getData());
                    Record[] records = dsResponse.getData();
                    BigDecimal projectUsed = BigDecimal.ZERO;
                    for(Record record : records){
                    	//已分配积分
						projectUsed = projectUsed.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmount")));
                    }
                    //剩余积分
                    projectIntegralLeftItem.setValue(projectIntegral.subtract(projectUsed));
                }
            }
        });
    }

    @Override
    public boolean checkData() {
        for (ListGridRecord r : grid.getRecords()) {
            __logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
        }
        return true;
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("detailProjectStage");
        return res;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        java.util.Map param = new java.util.HashMap();
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProjectStage");
        return param;
    }

    @Override
    public void initEventHandlers() {
    }

    @Override
    public void reloadSourceData() {
        Criteria condition = new Criteria();
        reloadSource(SourceGrid, condition);
    }

    private void reloadSource(final ListGrid source, Criteria condition) {
        if (condition == null) {
            condition = new Criteria();
        }
        FormItem item;
        Object val = null;
        DBDataSource.callOperation("NQ_Ssystemdictionaryor", "find", condition.getValues(), new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    source.setData(dsResponse.getData());
                }
            }
        });
    }

    private void addSelectedDataToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        RecordList originalList = target.getDataAsRecordList();
        FormItem item;
        Map<String, FormItem> items = getParentWindow().getFormItems();
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map searchMap = new HashMap();
            searchMap.put("projectId", getRecord().getAttribute("projectId"));
            searchMap.put("stageId", selectedRecord.getAttribute("dicTypeValueId"));
            searchMap.put("stageName", selectedRecord.getAttribute("dicTypeValue"));
            if (originalLength > 0) {
                int index = originalList.findIndex(searchMap);
                if (index != -1) {
                    continue;
                }
            }
            newList.add(new Record(searchMap));
        }
        target.setData(newList);
    }

}
