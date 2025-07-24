package com.pomplatform.client.annoucement.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.annoucement.datasource.DSSannoucementaaaor;
import com.pomplatform.client.annoucement.form.NewAnnoucementForm;
import com.pomplatform.client.annoucement.form.SannoucementaaaorSearchForm;
import com.pomplatform.client.annoucement.form.SannoucementaaaorViewer;
import com.pomplatform.client.annoucement.form.UpdateAnnoucementPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.plugins.Flashlet;

public class SannoucementaaaorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SannoucementaaaorPanel cm = new SannoucementaaaorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sannoucementaaaor";
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
//		IButton viewButton = new IButton("查看详细");
//		viewButton.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
//		controlLayout.addMember(viewButton);
		

		IButton addButton = new IButton("新增");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewAnnoucementForm detailForm = new NewAnnoucementForm();
						detailForm.setTitle("新增公告");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength() - 1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("60%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		controlLayout.addMember(addButton);
		
		IButton updateButton = new IButton("修改");
		updateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据进行操作");
							return;
						}
						Record selected = resultGrid.getSelectedRecord();
						if (!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("status"))) {
							if (selected.getAttributeAsInt("status")==2) {
								SC.say("本条公告信息已发布不能修改");
								return;
							}
						}
						UpdateAnnoucementPanel detailForm = new UpdateAnnoucementPanel();
						detailForm.setTitle("修改公告");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("60%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		controlLayout.addMember(updateButton);
		
		IButton deleteButton = new IButton("删除");
		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据进行操作");
					return;
				}
				SC.ask("提示","您确认要删除当前公告信息吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							
							if (!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("status"))) {
								if (selected.getAttributeAsInt("status")==2) {
									SC.say("本条公告信息已发布不能删除");
									return;
								}
							}
							DBDataSource.callOperation("ST_Annoucement", "delete", selected.toMap(), new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										int indexNum = resultGrid.getRowNum(selected);
										resultGrid.removeData(selected);
										resultGrid.selectSingleRecord(indexNum);
									}
								}
							});
						}
					}
				});
			}
		});
		controlLayout.addMember(deleteButton);
		
		IButton publishButton = new IButton("发布");
		publishButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据进行操作");
					return;
				}
				SC.ask("提示","您确认要发布当前公告信息吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							if (BaseHelpUtils.isNullOrEmpty(selected.getAttribute("status"))) {
								return;
							}
							if (!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("status"))) {
								if (selected.getAttributeAsInt("status")==2) {
									SC.say("本条公告信息已发布");
									return;
								}
							}
							Map<String, Object> params = new HashMap<String, Object>();
							params.put("optType", "publishAnnoucement");
							params.putAll(selected.toMap());
							DBDataSource.callOperation("EP_OtherAnnoucementProcess", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										SC.say("公告信息发布成功");
										commonQuery();
									}
								}
							});
						}
					}
				});
			}
		});
		controlLayout.addMember(publishButton);
		
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
				detail.setTitle("公告详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SannoucementaaaorViewer detailForm = new SannoucementaaaorViewer();
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
		criteria.put("addtionalCondition", "order by annoucement_id");
		criteria.put("operateEmployeeId", ClientUtil.getEmployeeId());
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SannoucementaaaorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSannoucementaaaor.getInstance();
	}


}

