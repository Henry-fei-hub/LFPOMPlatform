package com.pomplatform.client.ja.ht.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.signatory.datasource.DSMainProjectMajorEmployee;
import com.pomplatform.client.signatory.form.MainProjectMajorEmployeeViewer;
import com.pomplatform.client.stage.datasource.DSProjectStage;
import com.pomplatform.client.stage.datasource.DSSsystemdictionaryor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ChangeMainProjectEmployeePanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ChangeMainProjectEmployeePanel cm = new ChangeMainProjectEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MainProjectMajorEmployee";
		}
	}

    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final DelicacyListGrid grid = new DelicacyListGrid();
    private DynamicForm form;
    private DynamicForm targetForm;
    private SelectItem sourceItem;
    private SelectItem targetItem;

	
	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		
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
        
        sourceItem = new SelectItem("source","目标项目秘书");
        sourceItem.setWidth("*");
        sourceItem.setColSpan(4);
        sourceItem.setCanEdit(true);
        sourceItem.setValueMap(KeyValueManager.getValueMap("main_project_stages"));
        sourceItem.addChangedHandler(new ChangedHandler() {
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
        form.setItems(sourceItem);
        infoLayout.addMember(form);
        SearchSourceLayout.addMember(infoLayout);
        
        HLayout SourceLayout = new HLayout(5);
        SourceLayout.setWidth100();
        SourceLayout.setHeight100();
        SearchSourceLayout.addMember(SourceLayout);
//        SourceGrid.setAutoFitFieldWidths(false);
        SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setDataSource(DSSsystemdictionaryor.getInstance());
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
        
        targetItem = new SelectItem("target","目标项目秘书");
        targetItem.setWidth("*");
        targetItem.setColSpan(4);
        targetItem.setCanEdit(true);
        targetItem.setValueMap(KeyValueManager.getValueMap("main_project_stages"));
        targetItem.addChangedHandler(new ChangedHandler() {
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
        
        targetForm = new DynamicForm();
        targetForm.setNumCols(8);
        targetForm.setWidth100();
        targetForm.setHeight100();
        targetForm.setItems(targetItem);
        info2Layout.addMember(targetForm);
        rightLayout.addMember(info2Layout);
        
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
        grid.setCanReorderRecords(true);
//        grid.setAutoFitFieldWidths(false);
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
        
        addMember(rightLayout);
    }


	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMainProjectMajorEmployee.getInstance();
	}
	
    private void addSelectedDataToTarget(ListGrid source, ListGrid target) {
    	
    	
    }


}
