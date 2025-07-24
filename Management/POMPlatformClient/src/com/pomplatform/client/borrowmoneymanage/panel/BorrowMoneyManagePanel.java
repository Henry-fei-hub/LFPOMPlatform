package com.pomplatform.client.borrowmoneymanage.panel;

import java.util.Map;
import java.util.logging.Logger;

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
import com.pomplatform.client.borrowmoneymanage.datasource.DSBorrowMoneyManage;
import com.pomplatform.client.borrowmoneymanage.form.BorrowMoneyManageSearchForm;
import com.pomplatform.client.borrowmoneymanage.form.BorrowMoneyManageViewer;
import com.pomplatform.client.borrowmoneymanage.form.NewBorrowMoneyManageForm;
import com.pomplatform.client.borrowmoneymanage.form.UpdateBorrowMoneyManageForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
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

public class BorrowMoneyManagePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			BorrowMoneyManagePanel cm = new BorrowMoneyManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "BorrowMoneyManage";
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
		IButton operation2Button = new IButton("新建");
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewBorrowMoneyManageForm detailForm = new NewBorrowMoneyManageForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
//								RecordList list = resultGrid.getDataAsRecordList();
//								RecordList newList = new RecordList();
//								newList.addList(list.getRange(0, list.getLength()));
//								newList.add(event.getData());
//								resultGrid.setData(newList);
//								resultGrid.selectSingleRecord(newList.getLength()-1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("50%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton operation3Button = new IButton("修改");
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
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
						UpdateBorrowMoneyManageForm detailForm = new UpdateBorrowMoneyManageForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
//								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("50%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				SC.ask("提示", "您确定要删除吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							DBDataSource.callOperation("ST_BorrowLimitManage", "delete", selected.toMap(), new DSCallback() {
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
				detail.setTitle("借款额度管理"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				BorrowMoneyManageViewer detailForm = new BorrowMoneyManageViewer();
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
		criteria.put("addtionalCondition", "order by borrow_limit_manage_id");
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new BorrowMoneyManageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSBorrowMoneyManage.getInstance();
	}


}

