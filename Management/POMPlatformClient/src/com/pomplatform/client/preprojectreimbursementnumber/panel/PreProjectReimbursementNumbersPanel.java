package com.pomplatform.client.preprojectreimbursementnumber.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.preprojectreimbursementnumber.datasource.DSPreProjectReimbursementNumbers;
import com.pomplatform.client.preprojectreimbursementnumber.form.PreProjectReimbursementNumbersSearchForm;
import com.pomplatform.client.preprojectreimbursementnumber.form.PreProjectReimbursementNumbersViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PreProjectReimbursementNumbersPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PreProjectReimbursementNumbersPanel cm = new PreProjectReimbursementNumbersPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PreProjectReimbursementNumbers";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
		final IButton operation3Button = PermissionControl.createPermissionButton("新增", ERPPermissionStatic.PRE_REIMBURSEMENT_PROJECT_ADD_BTN);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
//						NewPreProjectReimbursementNumbersForm detailForm = new NewPreProjectReimbursementNumbersForm();
//						detailForm.setTitle("新增");
//						detailForm.addDataEditedHandler(new DataEditedHandler(){
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								RecordList list = resultGrid.getDataAsRecordList();
//								RecordList newList = new RecordList();
//								newList.addList(list.getRange(0, list.getLength()));
//								newList.add(event.getData());
//								resultGrid.setData(newList);
//								resultGrid.selectSingleRecord(newList.getLength()-1);
//								commonQuery();
//							}
//						});
//						detailForm.setSearchForm(searchForm);
//						detailForm.initComponents();
//						detailForm.startEdit();
//						detailForm.setWidth("50%");
//						detailForm.setHeight("50%");
//						detailForm.centerInPage();
//						detailForm.show();
						
						PopupWindow pw = new PopupWindow("新增前期项目");
						AddNewPreProjectNumberPanel panel=new AddNewPreProjectNumberPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						panel.setPw(pw);
						pw.addCloseClickHandler(new CloseClickHandler() {
							
							@Override
							public void onCloseClick(CloseClickEvent event) {
								commonQuery();
							}
						});
						pw.addItem(panel);
						pw.setWidth("50%");
						pw.setHeight("50%");
						pw.centerInPage();
						pw.show();
					}
				});
			}
		});
		final IButton operation2Button = PermissionControl.createPermissionButton("修改", ERPPermissionStatic.PRE_REIMBURSEMENT_PROJECT_UPDATE_BTN);
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
//						UpdatePreProjectReimbursementNumbersForm detailForm = new UpdatePreProjectReimbursementNumbersForm();
//						detailForm.setTitle("修改");
//						detailForm.addDataEditedHandler(new DataEditedHandler(){
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								commonQuery();
//							}
//						});
//						detailForm.setSearchForm(searchForm);
//						detailForm.setRecord(selected1);
//						detailForm.setCurrentPage(getCurrentPage());
//						detailForm.initComponents();
//						detailForm.startEdit();
//						detailForm.setWidth("50%");
//						detailForm.setHeight("50%");
//						detailForm.centerInPage();
//						detailForm.show();
//						setCurrentPage(detailForm.getCurrentPage());
						
						PopupWindow pw = new PopupWindow("前期项目修改");
						CustomPreProjectNumberPanel panel=new CustomPreProjectNumberPanel(selected1);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						panel.setPw(pw);
						pw.addCloseClickHandler(new CloseClickHandler() {
							
							@Override
							public void onCloseClick(CloseClickEvent event) {
								commonQuery();
							}
						});
						pw.addItem(panel);
						pw.setWidth("50%");
						pw.setHeight("50%");
						pw.centerInPage();
						pw.show();
						
						
					}
				});
			}
		});
		final IButton removeButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.PRE_REIMBURSEMENT_PROJECT_DELETE_BTN);
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				Map param=new HashMap<>();
				param.put("opt_type", "delPreProject");
				param.put("preProjectReimbursementNumberId", selected.getAttributeAsInt("preProjectReimbursementNumberId"));
				param.put("customNumber", selected.getAttributeAsString("customNumber"));
				DBDataSource.callOperation("EP_CustomPreProject", param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							commonQuery();
						}
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
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("PreProjectReimbursementNumbers"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				PreProjectReimbursementNumbersViewer detailForm = new PreProjectReimbursementNumbersViewer();
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
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new PreProjectReimbursementNumbersSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPreProjectReimbursementNumbers.getInstance();
	}

	 public int getSearchFormHeight() {
	        return 60;
	    }

}

