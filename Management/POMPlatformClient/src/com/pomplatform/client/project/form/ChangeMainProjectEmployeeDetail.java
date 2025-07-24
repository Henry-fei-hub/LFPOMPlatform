package com.pomplatform.client.project.form;

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
import com.pomplatform.client.cdcmanage.datasource.DSMainProjectEmployee;
import com.pomplatform.client.cdcmanage.datasource.DSMainProjectEmployeeShow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ChangeMainProjectEmployeeDetail extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");

    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final DelicacyListGrid grid = new DelicacyListGrid();
    private DynamicForm form;
    private DynamicForm targetForm;
    private SelectItem relationItem;
    private ComboBoxItem sourceItem;
    private ComboBoxItem targetItem;
    private LinkedHashMap<Integer, String> linkMap =new LinkedHashMap<>();

    public ChangeMainProjectEmployeeDetail() {
		SC.debugger();
		//左侧面板
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


        relationItem = new SelectItem("relation","角色类型");
        relationItem.setWidth("*");
        relationItem.setColSpan(2);
        relationItem.setCanEdit(true);
        relationItem.setDefaultValue(1);
        relationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_158"));
        relationItem.addChangedHandler(new ChangedHandler() {
        	@Override
        	public void onChanged(ChangedEvent event) {
        		if(BaseHelpUtils.getIntValue(sourceItem.getValue())<=0) {
//                    if(BaseHelpUtils.getString(sourceItem.getValue()).length()<=0) {
//                        SC.say("提示", "目标项目人员不能为空");
//                    }
        			return;
        		}
        		if(BaseHelpUtils.getIntValue(event.getValue())<=0) {
        			SC.say("提示","类型不能为空");
        			return;
        		}
        		Map map =new HashMap<>();
        		map.put("employeeId", sourceItem.getValue());
        		map.put("relation", event.getValue());
        		DBDataSource.callOperation("NQ_OnLoadContractByMainProjectEmployeeId", map, new DSCallback() {
        			@Override
        			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
        				if (dsResponse.getStatus() >= 0) {
        					SourceGrid.setData(dsResponse.getData());
        				}
        			}
        		});
        	}
        });


        sourceItem = new ComboBoxItem("source","目标项目人员");
        sourceItem.setWidth("*");
        sourceItem.setColSpan(2);
        sourceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        sourceItem.setCanEdit(true);
        sourceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(BaseHelpUtils.getIntValue(relationItem.getValue())<=0) {
        			SC.say("提示","类型不能为空");
        			return;
        		}
				SC.debugger();
        		if(BaseHelpUtils.getIntValue(event.getValue())<=0) {
//        		    if(BaseHelpUtils.getString(event.getValue()).length()<=0){
//        			    SC.say("提示","目标项目人员不能为空");
//                    }
        			return;
        		}
				Map map =new HashMap<>();
				map.put("employeeId", event.getValue());
        		map.put("relation", relationItem.getValue());
		        DBDataSource.callOperation("NQ_OnLoadContractByMainProjectEmployeeId", map, new DSCallback() {
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
        form.setItems(relationItem,sourceItem);
        infoLayout.addMember(form);
        SearchSourceLayout.addMember(infoLayout);

        HLayout SourceLayout = new HLayout(5);
        SourceLayout.setWidth100();
        SourceLayout.setHeight100();
        SearchSourceLayout.addMember(SourceLayout);
		SourceGrid.setDataSource(DSMainProjectEmployeeShow.getInstance());
        SourceGrid.setAutoFitFieldWidths(false);
        SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceLayout.addMember(SourceGrid);

        //中间按钮
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
        addMember(SearchSourceLayout);


        //右侧面板
        VLayout rightLayout = new VLayout(10);
        rightLayout.setWidth("50%");
        rightLayout.setHeight100();

        HLayout projectStages = new HLayout();
        projectStages.setWidth100();
        projectStages.setHeight("90%");
        projectStages.setLayoutLeftMargin(20);

        HLayout info2Layout = new HLayout(10);
        info2Layout.setWidth("90%");
        info2Layout.setHeight("10%");
        info2Layout.setLayoutTopMargin(30);

        targetItem = new ComboBoxItem("target","更换项目人员");
        targetItem.setWidth("*");
        targetItem.setColSpan(4);
        targetItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        targetItem.setCanEdit(true);
//        targetItem.setValueMap(KeyValueManager.getValueMap("employees"));

        targetForm = new DynamicForm();
        targetForm.setNumCols(8);
        targetForm.setWidth100();
        targetForm.setHeight100();
        targetForm.setItems(targetItem);
        info2Layout.addMember(targetForm);
        rightLayout.addMember(info2Layout);


        int a = 0;
		ListGridField[] aFields = new ListGridField[8];
		aFields[a] = new ListGridField("contractId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("mainProjectId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("relation");
		aFields[a].setWidth("*");
		a++;
		aFields[a] = new ListGridField("contractCode","合同编号");
		aFields[a].setWidth("*");
		a++;
		aFields[a] = new ListGridField("contractName","合同名称");
		aFields[a].setWidth("*");
		a++;
		aFields[a] = new ListGridField("mainProjectEmployeeId");
		aFields[a].setWidth("*");
		aFields[a].setHidden(true);
        grid.setCanReorderRecords(true);
        grid.setAutoFitFieldWidths(false);
        grid.setFields(aFields);
        grid.setDataSource(DSMainProjectEmployeeShow.getInstance());
        grid.setCanRemoveRecords(true);
//        grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        projectStages.addMember(grid);
        rightLayout.addMember(projectStages);

        addMember(rightLayout);

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void startEdit() {
    	Map<String,Object> map = new HashMap<>();
		map.put("optType", "loadDataForAddInfo");
		DBDataSource.callOperation("EP_PreProjectProcess", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(records.length>0) {
						for (Record record : records) {
							linkMap.put(BaseHelpUtils.getIntValue(record.getAttribute("employeeId")), BaseHelpUtils.getString(record.getAttribute("employeeNo"))+"-"+BaseHelpUtils.getString(record.getAttribute("employeeName")));
						}
						 sourceItem.setValueMap(linkMap);
					}
				}
			}
		});
        Map<String,Object> condition = new HashMap<>();
        map.put("optType", "loadDataForAddInfo");
        map.put("loadType", "1");
        DBDataSource.callOperation("EP_PreProjectProcess", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if(dsResponse.getStatus() >= 0){
                    Record[] records = dsResponse.getData();
                    if(records.length>0) {
                        for (Record record : records) {
                            linkMap.put(BaseHelpUtils.getIntValue(record.getAttribute("employeeId")), BaseHelpUtils.getString(record.getAttribute("employeeNo"))+"-"+BaseHelpUtils.getString(record.getAttribute("employeeName")));
                        }
                        targetItem.setValueMap(linkMap);
                    }
                }
            }
        });
    }


    @Override
    public boolean checkData() {
    	if(BaseHelpUtils.isNullOrEmpty(grid.getRecords())||grid.getRecords().length<=0) {
    		SC.say("提示","合同列表不能为空");
    		return false;
    	}
    	if(BaseHelpUtils.isNullOrEmpty(sourceItem.getValue())||BaseHelpUtils.getIntValue(sourceItem.getValue())<=0) {
    		SC.say("提示","目标项目人员不能为空");
    		return false;
    	}
    	if(BaseHelpUtils.isNullOrEmpty(targetItem.getValue())||BaseHelpUtils.getIntValue(targetItem.getValue())<=0) {
    		SC.say("提示","更换项目人员不能为空");
    		return false;
    	}
        return true;
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("detailMainProjectEmployee");
        return res;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        java.util.Map param = new java.util.HashMap();
        param.put("optType","changeMainProjectEmployeeRelation1");
        param.put("source",sourceItem.getValue());
        param.put("target",targetItem.getValue());
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(DSMainProjectEmployeeShow.getInstance(), rows, param, "detailMainProjectEmployee");
        return param;
    }

    @Override
    public void initEventHandlers() {
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
            newList.add(selectedRecord);
        }
        target.setData(newList);
    }



}
