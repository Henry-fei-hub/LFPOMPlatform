package com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.datasource.DSMemployeemoneymanageeeedcieftrcvmmor;
import com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.form.MemployeemoneymanageeeedcieftrcvmmorSearchForm;
import com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.form.MemployeemoneymanageeeedcieftrcvmmorViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;

public class MemployeemoneymanageeeedcieftrcvmmorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MemployeemoneymanageeeedcieftrcvmmorPanel cm = new MemployeemoneymanageeeedcieftrcvmmorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeemoneymanageeeedcieftrcvmmor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
		__needViewPage = false;
		__needControl = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		// IButton refreshButton = new IButton("刷新");
		// controlLayout.addMember(refreshButton);
		// refreshButton.setIcon("[SKIN]/actions/refresh.png");
		// refreshButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// commonQuery();
		// }
		// });
		//
		// resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		// @Override
		// public void onDoubleClick(DoubleClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton operation1Button = new IButton("查看详情");
		// controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		// operation1Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton removeButton = new IButton("删除");
		// controlLayout.addMember(removeButton);
		// removeButton.setIcon("[SKIN]/actions/remove.png");
		// removeButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// if (!resultGrid.anySelected()) {
		// SC.say("Please select a data to remove.");
		// }
		// final ListGridRecord selected = resultGrid.getSelectedRecord();
		// DBDataSource.callOperation("ST_Memployeemoneymanageeeedcieftrcvmmor",
		// "delete", selected.toMap(), new DSCallback() {
		// @Override
		// public void execute(DSResponse dsResponse, Object data, DSRequest
		// dsRequest) {
		// if (dsResponse.getStatus() < 0) {
		// ClientUtil.displayErrorMessage(dsResponse);
		// } else {
		// int indexNum = resultGrid.getRowNum(selected);
		// resultGrid.removeData(selected);
		// resultGrid.selectSingleRecord(indexNum);
		// }
		// }
		// });
		// }
		// });
		//
		// commonQuery();
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
				detail.setTitle("memployeemoneymanageeeedcieftrcvmmor");
				detail.setWidth100();
				detail.setHeight100();
				MemployeemoneymanageeeedcieftrcvmmorViewer detailForm = new MemployeemoneymanageeeedcieftrcvmmorViewer();
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
		criteria.put("addtionalCondition", "order by employee_money_manage_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MemployeemoneymanageeeedcieftrcvmmorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeemoneymanageeeedcieftrcvmmor.getInstance();
	}
	
	public void initData(Record record){
		int employeeId = record.getAttributeAsInt("employeeOrCompanyId");
		searchForm.getItem("employeeId").setValue(employeeId);
		commonQuery();
	}
	
}
