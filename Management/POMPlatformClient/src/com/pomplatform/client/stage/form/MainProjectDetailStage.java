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
import com.delicacy.client.data.KeyValueManager;
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
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class MainProjectDetailStage extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid grid = new DelicacyListGrid();
    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final DynamicForm form;
    private BigDecimal countPercent = BigDecimal.ZERO;
    private BigDecimal projectIntegral;
    private BigDecimal settlementIntegral;
    private int attachmentNum;
    private String oldValue = null;
    public SelectItem contractTypeItem;

    public MainProjectDetailStage() {

        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth("50%");
        SearchSourceLayout.setHeight100();
        SearchSourceLayout.setLayoutTopMargin(10);
        SearchSourceLayout.setLayoutRightMargin(5);
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.setShowResizeBar(false);
        
        HLayout infoLayout = new HLayout(10);
        infoLayout.setWidth("90%");
        infoLayout.setHeight("10%");
        infoLayout.setLayoutTopMargin(30);
        
        contractTypeItem = new SelectItem("contractType","合同类型");
        contractTypeItem.setWidth("*");
        contractTypeItem.setColSpan(4);
        contractTypeItem.setCanEdit(true);
        contractTypeItem.setValueMap(KeyValueManager.getValueMap("main_project_stages"));
        contractTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map map =new HashMap<>();
				map.put("parentId", event.getValue());
		        DBDataSource.callOperation("NQ_OnLoadMainProjectStageByParentId", map, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	SourceGrid.setData(dsResponse.getData());
		                }
		            }
		        });
			}
		});
        
        form = new DynamicForm();
        form.setNumCols(8);
        form.setWidth100();
        form.setHeight100();
        form.setItems(contractTypeItem);
        infoLayout.addMember(form);
        SearchSourceLayout.addMember(infoLayout);
        
        VLayout rightLayout = new VLayout(10);
        rightLayout.setWidth("50%");
        rightLayout.setHeight100();
        
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
        
        int a = 0;
		ListGridField[] aFields = new ListGridField[6];
		aFields[a] = new ListGridField("projectStageId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("stageId");
		aFields[a].setHidden(true);
		aFields[a].setWidth("*");
		a++;
		aFields[a] = new ListGridField("stageName");
		aFields[a].setWidth("*");
		a++;
		aFields[a] = new ListGridField("percent");
		aFields[a].setWidth("*");
        HLayout projectStages = new HLayout();
        projectStages.setWidth100();
        projectStages.setHeight("90%");
        projectStages.setLayoutLeftMargin(20);
        grid.setCanReorderRecords(true);
        grid.setAutoFitFieldWidths(false);
        grid.setFields(aFields);
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
        
        grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord selected = grid.getSelectedRecord();
				ListGridRecord[] gridData = grid.getRecords();
				Map<String,Object> params = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(selected)){
					   countPercent = BigDecimal.ZERO;
					   oldValue = "";
                       for(ListGridRecord e : gridData){
//                         countPercent += BaseHelpUtils.getIntValue(e.getAttribute("percent"));
                           countPercent= countPercent.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("percent")));
                       }
                       if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("percent"))){
                           countPercent = countPercent .subtract(BaseHelpUtils.getBigDecimalValue(selected.getAttribute("percent"))) ;
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
                                   }else if(BaseHelpUtils.getBigDecimalValue(value).compareTo(BigDecimal.ZERO)==0){
                                       SC.say("提示","阶段占比不可等于0");
                                       value = oldValue;
                                   }
                               }
                               BigDecimal add = countPercent .add(BaseHelpUtils.getBigDecimalValue(value));
                               if(add .compareTo(new BigDecimal(100))>0){
                                   SC.say("提示","阶段总占比不能大于100%");
                                   return;
                               }
                               
                               selected.setAttribute("percent", BaseHelpUtils.getBigDecimalValue(value));
                               //阶段占比
                               BigDecimal percent = BaseHelpUtils.getBigDecimalValue(value).divide(BigDecimal.valueOf(100));
                               grid.updateData(selected);
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
    	Criteria condition = new Criteria();
    	reloadSource(SourceGrid, condition);
    	
    	if(null != r) {
    		int mainProjectId = BaseHelpUtils.getIntValue(r.getAttribute("mainProjectId"));
    		if(mainProjectId>0) {
    			condition.setAttribute("mainProjectId", mainProjectId);
    		}
			DBDataSource.callOperation("ST_ProjectStage", "find", condition.getValues(), new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						grid.setData(dsResponse.getData());
					}
				}
			});
    	}
    }
    
    public void changeContractType() {
    	Criteria condition = new Criteria();
        int parentId = BaseHelpUtils.getIntValue(contractTypeItem.getValue());
        if(parentId>0) {
        	condition.addCriteria("parentId", parentId);
        }
        
        DBDataSource.callOperation("NQ_OnLoadMainProjectStageByParentId", condition.getValues(), new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	SourceGrid.setData(dsResponse.getData());
                	
//                    ListGridRecord[] selectedRecords = SourceGrid.getRecords();
//                    RecordList newList = new RecordList();
//                    for (ListGridRecord selectedRecord : selectedRecords) {
//                        Map searchMap = new HashMap();
//                        searchMap.put("stageId", selectedRecord.getAttribute("dicTypeValueId"));
//                        searchMap.put("stageName", selectedRecord.getAttribute("dicTypeValue"));
////                        searchMap.put("percent", BaseHelpUtils.getBigDecimalValue(selectedRecord.getAttribute("percent")).setScale(2));
//                        newList.add(new Record(searchMap));
//                    }
//                    grid.setData(newList);
                }
            }
        });
    }

    @Override
    public boolean checkData() {
    	if(BaseHelpUtils.isNullOrEmpty(grid.getRecords())||grid.getRecords().length<=0) {
    		SC.say("提示","阶段列表不能为空");
    		return false;
    	}else {
    		ListGridRecord[] records = grid.getRecords();
    		BigDecimal percent =BigDecimal.ZERO;
    		for (ListGridRecord listGridRecord : records) {
    			percent =percent.add(BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("percent"))) ;
			}
    		if(percent.compareTo(new BigDecimal(100))!=0) {
    			SC.say("提示","阶段比例总和不等于100%");
        		return false;
    		}
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

    private void reloadSource(final ListGrid source, Criteria condition) {
        if (condition == null) {
            condition = new Criteria();
        }
        
        int parentId = BaseHelpUtils.getIntValue(contractTypeItem.getValue());
        if(parentId>0) {
        	condition.addCriteria("parentId", parentId);
        }
        
        DBDataSource.callOperation("NQ_OnLoadMainProjectStageByParentId", condition.getValues(), new DSCallback() {
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
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map searchMap = new HashMap();
            searchMap.put("stageId", selectedRecord.getAttribute("dicTypeValueId"));
            searchMap.put("stageName", selectedRecord.getAttribute("dicTypeValue"));
            searchMap.put("percent", BaseHelpUtils.getDoubleValue(selectedRecord.getAttribute("percent")));
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
    
    private Record r ;

	public Record getR() {
		return r;
	}

	public void setR(Record r) {
		this.r = r;
	}
    

}
