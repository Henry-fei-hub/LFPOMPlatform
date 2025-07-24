package com.pomplatform.client.minvocieapplydedaocor.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.minvocieapplydedaocor.datasource.DSMcontracticcccsprfiiibaadicrbbior;
import com.pomplatform.client.minvocieapplydedaocor.datasource.DSMinvocieapplydedaocor;
import com.pomplatform.client.minvocieapplydedaocor.form.McontracticcccsprfiiibaadicrbbiorSearchForm;
import com.pomplatform.client.minvocieapplydedaocor.form.McontracticcccsprfiiibaadicrbbiorViewer;
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

public class McontracticcccsprfiiibaadicrbbiorPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McontracticcccsprfiiibaadicrbbiorPanel cm = new McontracticcccsprfiiibaadicrbbiorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcontracticcccsprfiiibaadicrbbior";
		}

	}

	// @Override
	// public void init(){
	// super.init();
	// __controlPosition = LayoutConstant.RIGHT;
	// }

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
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton updateRemarkBtn = new IButton("修改备注");
		controlLayout.addMember(updateRemarkBtn);
		updateRemarkBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					int contractId = resultGrid.getSelectedRecord().getAttributeAsInt("contractId");
					PopupWindow pw = new PopupWindow();
					UpdateContractRemarkPanel panel = new UpdateContractRemarkPanel();
					panel.setContractId(contractId);
					panel.setRecord(resultGrid.getSelectedRecord());
					panel.startEdit();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery(resultGrid.getRowNum(resultGrid.getSelectedRecord()));
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("合同特殊事项备注");
					pw.setWidth("30%");
					pw.setHeight("40%");
					pw.centerInPage();
					pw.show();
				} else {
					SC.say("请选择需要修改的合同信息");
				}

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
				McontracticcccsprfiiibaadicrbbiorViewer detailForm = new McontracticcccsprfiiibaadicrbbiorViewer();
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
		criteria.put("addtionalCondition", "order by contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McontracticcccsprfiiibaadicrbbiorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontracticcccsprfiiibaadicrbbior.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSMinvocieapplydedaocor.getInstance();
	}

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas[] canvas = new Canvas[3];
		IButton addBtn = new IButton("新增联系人");
		addBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					int contractId = resultGrid.getSelectedRecord().getAttributeAsInt("contractId");
					PopupWindow pw = new PopupWindow();
					AddOrUpdateContactsPanel panel = new AddOrUpdateContactsPanel(false);
					panel.setContractId(contractId);
					panel.startEdit();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("添加联系人");
					pw.setWidth("30%");
					pw.setHeight("90%");
					pw.centerInPage();
					pw.show();
				} else {
					SC.say("请选择一条合同数据");
				}
			}
		});
		IButton updateBtn = new IButton("修改联系人");
		updateBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultChildGrid.anySelected()) {
					int contractId = resultChildGrid.getSelectedRecord().getAttributeAsInt("contractId");
					PopupWindow pw = new PopupWindow();
					AddOrUpdateContactsPanel panel = new AddOrUpdateContactsPanel(true);
					panel.setContractId(contractId);
					panel.setRecord(resultChildGrid.getSelectedRecord());
					panel.startEdit();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("修改联系人");
					pw.setWidth("30%");
					pw.setHeight("80%");
					pw.centerInPage();
					pw.show();
				} else {
					SC.say("请选择一条联系人数据");
				}
			}
		});
		IButton deleteBtn = new IButton("删除联系人");
		deleteBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultChildGrid.anySelected()) {
					SC.confirm("确认删除?", new BooleanCallback() {

						@SuppressWarnings("unchecked")
						@Override
						public void execute(Boolean value) {
							if (value) {
								Map<String, Object> params = new HashMap<>();
								int invoiceApplyId = resultChildGrid.getSelectedRecord()
										.getAttributeAsInt("invoiceApplyId");
								params.put("invoiceApplyId", invoiceApplyId);
								params.put("opt_type", "deleteContacts");
								DBDataSource.callOperation("EP_CustomMinvocieapplydedaocor", params, new DSCallback() {

									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											resultChildGrid.refreshData();
										} else {
											ClientUtil.displayErrorMessage(dsResponse);
										}

									}
								});
							}

						}
					});

				} else {
					SC.say("请选择需要删除的联系人数据");
				}

			}
		});
		canvas[0] = addBtn;
		canvas[1] = updateBtn;
		canvas[2] = deleteBtn;
		return canvas;
	}

}
