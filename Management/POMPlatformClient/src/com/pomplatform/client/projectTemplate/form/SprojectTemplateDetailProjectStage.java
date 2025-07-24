package com.pomplatform.client.projectTemplate.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.project.datasource.DSSprojectstagetemplatepor;
import com.pomplatform.client.projectStageTemplate.datasource.DSSprojectstagetemplateor;
import com.pomplatform.client.projectTemplate.datasource.DSSprojecttemplateor;
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
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SprojectTemplateDetailProjectStage extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid grid = new DelicacyListGrid();
    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final DynamicForm form;
    private final DynamicForm form2;
    private int countPercent = 0;
    private int booleanGridStageStorageor ;
    private BigDecimal projectIntegral;
    private BigDecimal settlementIntegral;
    private int attachmentNum;
    private String oldValue = null;
    private TextItem projectTemplateNameItem;
    private SelectItem projectTypeItem;
    private SelectItem plateIdItem;
    private SelectItem businessTypeItem;
    private int projectTemplateId=0;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    
    public SprojectTemplateDetailProjectStage(Map<String,Object> map) {

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
            addSelectedDataToTarget(SourceGrid, grid);
        }
        });
        SourceGrid.addDoubleClickHandler(new DoubleClickHandler() {
        @Override
        public void onDoubleClick(DoubleClickEvent event) {
            if (!SourceGrid.anySelected()) {
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
        
        projectTemplateNameItem = new TextItem("projectTemplateName",shouldNotBeNull+"模板名称");
        projectTemplateNameItem.setWidth("*");
        projectTemplateNameItem.setColSpan(10);
        projectTemplateNameItem.setCanEdit(true);
        projectTemplateNameItem.setValue(map.get("projectTemplateName"));
        
        
        form = new DynamicForm();
        form.setNumCols(10);
        form.setWidth100();
        form.setHeight100();
        form.setItems(projectTemplateNameItem);
        infoLayout.addMember(form);
        rightLayout.addMember(infoLayout);
        
        HLayout infoLayout2 = new HLayout(10);
        infoLayout2.setWidth("90%");
        infoLayout2.setHeight("10%");
        infoLayout2.setLayoutTopMargin(30);
        projectTypeItem = new SelectItem("projectType", shouldNotBeNull+"项目类型");
        projectTypeItem.setWidth("*");
        projectTypeItem.setColSpan(10);
        if(BaseHelpUtils.getIntValue(map.get("projectType"))!=0) {
        	projectTypeItem.setDefaultValue(map.get("projectType"));
        }
        projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
        projectTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
			}
		});
        
        plateIdItem = new SelectItem("plateId", shouldNotBeNull+"业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setColSpan(10);
        if(BaseHelpUtils.getIntValue(map.get("plateId"))!=0) {
        	plateIdItem.setDefaultValue(map.get("plateId"));
        }
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        plateIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				
			}
		});
        businessTypeItem = new SelectItem("businessType", shouldNotBeNull+"业务类型");
        businessTypeItem.setWidth("*");
        businessTypeItem.setColSpan(10);
        if(BaseHelpUtils.getIntValue(map.get("businessType"))!=0) {
        	businessTypeItem.setDefaultValue(map.get("businessType"));
        }
        businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
        businessTypeItem.addChangedHandler(new ChangedHandler() {
        	@Override
        	public void onChanged(ChangedEvent event) {
        		
        	}
        });
        
        form2 = new DynamicForm();
        form2.setNumCols(10);
        form2.setWidth100();
        form2.setHeight(20);
        form2.setItems(businessTypeItem,plateIdItem,projectTypeItem);
        infoLayout2.addMember(form2);
        rightLayout.addMember(infoLayout2);
        
        
        
        HLayout projectStages = new HLayout();
        projectStages.setWidth100();
        projectStages.setHeight("90%");
        projectStages.setLayoutLeftMargin(20);
        grid.setCanReorderRecords(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(true);
        grid.setDataSource(DSSprojectstagetemplateor.getInstance());
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
				grid.setData(oldData);
				grid.redraw();
			}
		});
        
        grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord selected = grid.getSelectedRecord();
				ListGridRecord[] gridData = grid.getRecords();
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
						SC.debugger();
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
						grid.updateData(selected);
					}
				});
			}
		});
        
        addMember(rightLayout);
        
        if(BaseHelpUtils.getIntValue(map.get("projectTemplateId"))>0) {
        	projectTemplateId=BaseHelpUtils.getIntValue(map.get("projectTemplateId"));
        	reloadProjectTemplate(map);
        }
        
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
        SC.debugger();
        param.put("businessType",BaseHelpUtils.getIntValue(businessTypeItem.getValue()));
        param.put("projectType",BaseHelpUtils.getIntValue(projectTypeItem.getValue()));
        param.put("plateId",BaseHelpUtils.getIntValue(plateIdItem.getValue()));
        param.put("projectTemplateName",projectTemplateNameItem.getValue());
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProjectStage");
        
        if(projectTemplateId>0) {
        	param.put("optType","UpdateProjecTempletWithStage");
        	param.put("projectTemplateId",projectTemplateId);
        }else {
        	param.put("optType","AddProjecTempletWithStage");
        }
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
    	SC.debugger();
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

	@Override
	public void startEdit() {
		// TODO Auto-generated method stub
		
	}
	
	//projectTemplateId不为空加载grid的数据  
    private void reloadProjectTemplate(Map<String,Object> map) {
    	LinkedHashMap<String,Object> params = new LinkedHashMap<>();
		params.put("projectTemplateId",map.get("projectTemplateId"));
		DBDataSource.callOperation("ST_ProjectStageTemplate","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
    	 
	}
	
}
