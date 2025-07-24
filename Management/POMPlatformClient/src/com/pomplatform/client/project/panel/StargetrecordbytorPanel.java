package com.pomplatform.client.project.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.project.datasource.DSStargetrecordbytor;
import com.pomplatform.client.project.form.StargetrecordbytorSearchForm;
import com.pomplatform.client.project.form.StargetrecordbytorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class StargetrecordbytorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			StargetrecordbytorPanel cm = new StargetrecordbytorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Stargetrecordbytor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		
	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton viewButton = new IButton("新增");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("新增指标");
				TargetRecordEidtPanel editPanel = new TargetRecordEidtPanel();
				popupWindow.addItem(editPanel);
				editPanel.setParentCanvas(popupWindow);
				editPanel.setParentWindow(popupWindow);
				editPanel.initComponents();
				editPanel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("保存成功");
					}
				});
				popupWindow.setWidth("33%");
				popupWindow.setHeight("37%");
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(viewButton);
		
		
		IButton updateButton = new IButton("编辑");
		updateButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record selectedRecord = resultGrid.getSelectedRecord();
				final PopupWindow popupWindow = new PopupWindow("编辑指标");
				TargetRecordEidtPanel editPanel = new TargetRecordEidtPanel();
				popupWindow.addItem(editPanel);
				editPanel.setParentCanvas(popupWindow);
				editPanel.setParentWindow(popupWindow);
				editPanel.initComponents();
				editPanel.setRecord(selectedRecord);
				editPanel.startEdit();
				editPanel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("保存成功");
					}
				});
				popupWindow.setWidth("33%");
				popupWindow.setHeight("37%");
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(updateButton);
		
		
		IButton delButton = new IButton("删除");
		delButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				SC.ask("确定要删除吗?", new  BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value==true) {
							SC.debugger();
							Record selectedRecord = resultGrid.getSelectedRecord();
							int targetRecordId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("targetRecordId"));
							Map <String,Object> map =new HashMap<>();
							map.put("targetRecordId", targetRecordId);
							DBDataSource.callOperation("ST_TargetRecord","delete",map, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus()>=0) {
										SC.say("删除成功");
										commonQuery();
									}else {
										SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
									}
								}
							});
						}
					}
				});
			}	
		});
		controlLayout.addMember(delButton);
		
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Stargetrecordbytor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				StargetrecordbytorViewer detailForm = new StargetrecordbytorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by year desc");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new StargetrecordbytorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSStargetrecordbytor.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}
	
	
	private int year;


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	


}

