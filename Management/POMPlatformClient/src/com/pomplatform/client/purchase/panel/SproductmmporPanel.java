package com.pomplatform.client.purchase.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.purchase.datasource.DSProductAttribute;
import com.pomplatform.client.purchase.datasource.DSSproductmmpor;
import com.pomplatform.client.purchase.form.NewSproductmmporForm;
import com.pomplatform.client.purchase.form.SproductmmporSearchForm;
import com.pomplatform.client.purchase.form.SproductmmporViewer;
import com.pomplatform.client.purchase.form.UpdateSproductmmporForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
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

public class SproductmmporPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SproductmmporPanel cm = new SproductmmporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sproductmmpor";
		}

	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton operation2Button = new IButton("修改");
		controlLayout.addMember(operation2Button);
		operation2Button.setIcon("[SKIN]/actions/edit.png");
		operation2Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateSproductmmporForm detailForm = new UpdateSproductmmporForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
//								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
//						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("80%");
						detailForm.setHeight("80%");
						detailForm.centerInPage();
						detailForm.show();
//						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		IButton operation3Button = new IButton("新建");
		controlLayout.addMember(operation3Button);
		operation3Button.setIcon("[SKIN]/actions/add.png");
		operation3Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						NewSproductmmporForm detailForm = new NewSproductmmporForm();
						detailForm.setTitle("新建");
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
						detailForm.setWidth("80%");
						detailForm.setHeight("80%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				SC.confirm("确认删除?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value) {
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							selected.setAttribute("deleteFlag", 1);
							DBDataSource.callOperation("ST_Product", "update", selected.toMap(), new DSCallback() {
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				SproductmmporViewer detailForm = new SproductmmporViewer();
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
		criteria.put("addtionalCondition", "order by product_id");
		criteria.put("deleteFlag", 0);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SproductmmporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSproductmmpor.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSProductAttribute.getInstance();
	}

}
