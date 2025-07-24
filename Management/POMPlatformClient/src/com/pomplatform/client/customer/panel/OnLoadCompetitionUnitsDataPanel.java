package com.pomplatform.client.customer.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.customer.datasource.DSOnLoadCompetitionUnitsData;
import com.pomplatform.client.customer.form.OnLoadCompetitionUnitsDataSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class OnLoadCompetitionUnitsDataPanel extends AbstractSearchPanel
{
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadCompetitionUnitsDataPanel cm = new OnLoadCompetitionUnitsDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadCompetitionUnitsData";
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
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		controlLayout.addMember(viewButton);
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton addButton = PermissionControl.createPermissionButton("新增",ERPPermissionStatic.COMPETITION_UNITS_ADD); 
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						PopupWindow popupWindow = new PopupWindow("竞争对手新增");
						popupWindow.setWidth("55%");
						popupWindow.setHeight("75%");
						CompetitionUnitsNewDesignPanel panel = new CompetitionUnitsNewDesignPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						popupWindow.addItem(panel);
						panel.setParWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
		
		IButton updateButton = PermissionControl.createPermissionButton("修改",ERPPermissionStatic.COMPETITION_UNITS_UPDATE);
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record record = resultGrid.getSelectedRecord();
						Map valueMap = record.toMap();
						PopupWindow popupWindow = new PopupWindow("竞争对手修改");
						popupWindow.setWidth("55%");
						popupWindow.setHeight("75%");
						CompetitionUnitsNewDesignPanel panel = new CompetitionUnitsNewDesignPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						popupWindow.addItem(panel);
						panel.setParWindow(popupWindow);
						panel.setValueRecord(valueMap);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
		
		IButton deleteButton = PermissionControl.createPermissionButton("删除",ERPPermissionStatic.COMPETITION_UNITS_DELETE);
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@SuppressWarnings({ "rawtypes"})
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record record = resultGrid.getSelectedRecord();
						Map valueMap = record.toMap();
						SC.ask("提示","您确认要删除该数据吗?", new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if(value){
									DBDataSource.callOperation("ST_CompetitionUnit","delete",valueMap, new DSCallback() {
							            @Override
							            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							                if (dsResponse.getStatus() >= 0) {
							                    SC.say("提示","删除成功");
							                    commonQuery();
							                } 
							            }
							        });
								}
							}
						});
					}
				});
			}
		});
		
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				Map valueMap = record.toMap();
				PopupWindow popupWindow = new PopupWindow("竞争对手详情");
				popupWindow.setWidth("55%");
				popupWindow.setHeight("75%");
				CompetitionUnitsNewDesignPanel panel = new CompetitionUnitsNewDesignPanel();
				popupWindow.addItem(panel);
				panel.setParWindow(popupWindow);
				panel.setValueRecord(valueMap);
				panel.setFormDisabled();
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadCompetitionUnitsDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadCompetitionUnitsData.getInstance();
	}


}

