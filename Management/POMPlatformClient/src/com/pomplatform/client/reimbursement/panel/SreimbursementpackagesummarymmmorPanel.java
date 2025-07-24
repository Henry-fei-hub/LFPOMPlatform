package com.pomplatform.client.reimbursement.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.reimbursement.datasource.DSSreimbursementpackagesummarymmmor;
import com.pomplatform.client.reimbursement.form.SreimbursementpackagesummarymmmorSearchForm;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdateReimbursementpackagePanel;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SreimbursementpackagesummarymmmorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SreimbursementpackagesummarymmmorPanel cm = new SreimbursementpackagesummarymmmorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sreimbursementpackagesummarymmmor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		int index = 0;
		ListGridField[] fields = new ListGridField[9];
		fields[index] = new ListGridField("payFor");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("payeeName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("otherName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("otherBankName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("otherBankAccount");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("amount");
		index ++;
		fields[index] = new ListGridField("paymentAmount");
		index ++;
		fields[index] = new ListGridField("strikeABalanceAmount");
		index ++;
		fields[index] = new ListGridField("updateTime");
		fields[index].setShowGridSummary(false);
		
		resultGrid.setShowGridSummary(true);
		resultGrid.setFields(fields);
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
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Sreimbursementpackagesummarymmmor", generateCriteria());
				
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
				ListGridRecord selectRecord = resultGrid.getSelectedRecord();

				boolean isTopUpdate = false;// 顶部的修改标志
				boolean isBottomUpdate = false;// 底部的修改标志

				PopupWindow pw = new PopupWindow();
				pw.setWidth100();
				pw.setHeight100();
				int packageId = selectRecord.getAttributeAsInt("reimbursementPackageId");
				UpdateReimbursementpackagePanel panel = new UpdateReimbursementpackagePanel(packageId, isTopUpdate,
						isBottomUpdate, true, null);
				panel.setPackageId(packageId);
				panel.setFatherWindow(pw);
				panel.startEdit();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				pw.addItem(panel);
				pw.setTitle("报销单打包详情");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();

			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by reimbursement_package_summary_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SreimbursementpackagesummarymmmorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSreimbursementpackagesummarymmmor.getInstance();
	}

}
