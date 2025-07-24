package com.pomplatform.client.purchase.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.purchase.datasource.DSMpurchaseplanmsommpmosror;
import com.pomplatform.client.purchase.form.MpurchaseplanmsommpmosrorSearchForm;
import com.pomplatform.client.purchase.form.MpurchaseplanmsommpmosrorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MpurchaseplanmsommpmosrorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MpurchaseplanmsommpmosrorPanel cm = new MpurchaseplanmsommpmosrorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mpurchaseplanmsommpmosror";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsInt("dealStatus") == 0) {
					return "font-weight: bold;";
				} else if (record.getAttributeAsInt("dealStatus") == 1) {
					return "color: #8191a7; font-weight: bold;";
				} else if (record.getAttributeAsInt("dealStatus") == 2) {
					return "color: red;";
				} else if (record.getAttributeAsInt("dealStatus") == 3) {
					return "color: #ABABAB;";
				} else {
					return super.getCellCSSText(record, rowNum, colNum);
				}

			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	@Override
	public void initComponents() {

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

		IButton viewProcessBtn = new IButton("查看采购实施");
		controlLayout.addMember(viewProcessBtn);
		viewProcessBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					Record selectRecord = resultGrid.getSelectedRecord();
					Integer dealStatus = selectRecord.getAttributeAsInt("dealStatus");
					Integer toPersonnelBusinessId = selectRecord.getAttributeAsInt("toPersonnelBusinessId");
					if (null == dealStatus || dealStatus == 0 || null == toPersonnelBusinessId) {
						SC.say("还没有发起采购实施");
					} else {
						Map<String, Object> params = new HashMap<>();
						params.put("businessId", toPersonnelBusinessId);
						params.put("processType", 63);
						params.put("opt_type", "getSystemInstanceData");
						DBDataSource.callOperation("EP_CollectionDistribution", params, new DSCallback() {

							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									Record[] records = dsResponse.getData();
									if (records.length > 0) {
										Record selected = records[0];
										ViewProcessWindow Reimbursement = new ViewProcessWindow();
										Reimbursement.setWidth("80%");
										Reimbursement.setHeight("80%");
										Reimbursement.setLayoutMode(0);
										Reimbursement.setInstanceData(selected);
										Reimbursement.initComponents();
										Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
										Reimbursement.show();
									}
								}

							}
						});
					}
				} else {
					SC.say("请选择一条需要查看的数据");
				}

			}
		});

		IButton purchaseActionBtn = new IButton("采购实施");
		controlLayout.addMember(purchaseActionBtn);
		purchaseActionBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					Record selectRecord = resultGrid.getSelectedRecord();
					Integer dealStatus = selectRecord.getAttributeAsInt("dealStatus");
					if (null == dealStatus || dealStatus == 0 || dealStatus == 2) {
						NewProcessWindow distribution = new NewProcessWindow();
						distribution.setData(selectRecord);
						distribution.setTitle("采购实施");
						distribution.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								// 操作成功
								commonQuery();
							}
						});
						Map<String, String> processIdMap = PomPlatformClientUtil
								.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
						Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Purchase_action_apply"));
						distribution.setProcessId(value);
						distribution.setLayoutMode(0);
						distribution.initComponents();
						distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
						distribution.show();
					} else {
						SC.say("该采购计划正在处理或已处理完毕,请勿重复采购");
					}

				} else {
					SC.say("请选择一条数据");
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
				detail.setTitle("采购计划");
				detail.setWidth100();
				detail.setHeight100();
				MpurchaseplanmsommpmosrorViewer detailForm = new MpurchaseplanmsommpmosrorViewer();
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
		criteria.put("addtionalCondition", "order by purchase_plan_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MpurchaseplanmsommpmosrorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMpurchaseplanmsommpmosror.getInstance();
	}

}
