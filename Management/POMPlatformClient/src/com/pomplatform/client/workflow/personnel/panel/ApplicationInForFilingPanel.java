package com.pomplatform.client.workflow.personnel.panel;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.pomplatform.client.workflow.form.FileDetailsForm;
import com.pomplatform.client.workflow.personnel.datasource.DSApplicationInForFiling;
import com.pomplatform.client.workflow.personnel.form.ApplicationForFilingUpdateForm;
import com.pomplatform.client.workflow.personnel.form.ApplicationInForFilingSearchForm;
import com.pomplatform.client.workflow.personnel.form.ApplicationInForFilingViewer;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class ApplicationInForFilingPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton viewButton1;
	private static IButton viewButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ApplicationInForFilingPanel cm = new ApplicationInForFilingPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ApplicationInForFiling";
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
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});


		 viewButton = new IButton("查看员工档案");
		viewButton.setWidth(100);
		viewButton.setHeight(30);
		viewButton.setLeft(0);
		viewButton.hide();
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {


				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据"); return;
				}
				final ListGridRecord selected1 = resultGrid.getSelectedRecord();
				SC.debugger();
				int processStatus = selected1.getAttributeAsInt("processStatus");
				if(processStatus==5){
					SC.say("驳回的不能执行查看"); return;
				}
				int employeeId = selected1.getAttributeAsInt("employeeId");

//				PopupWindow window = new PopupWindow("查看员工档案明细");
//				ApplicationForFilingPanel panel = new ApplicationForFilingPanel();
//				final ListGridRecord selected = resultGrid.getSelectedRecord();
//				String employeeId = selected.getAttribute("nextAuditor");
//				SC.debugger();
//				panel.setEmployeeId(employeeId);
//				window.addMember(panel);
//				window.setWidth100();
//				window.setHeight100();
//				window.centerInPage();
//				window.show();


				PopupWindow popupWindow = new PopupWindow();
				FileDetailsForm detailForm = new FileDetailsForm();
				popupWindow.setTitle("查看员工档案明细");
				popupWindow.addMember(detailForm);
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				popupWindow.centerInPage();
				detailForm.initComponents();
				detailForm.initGrid(selected1.getAttributeAsInt("unit"));
				popupWindow.show();

			}
		});
		controlLayout.addMember(viewButton);

		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_ApplicationInForFiling", "delete", selected.toMap(), new DSCallback() {
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
				detail.setTitle("查看明细");
				detail.setWidth100(); 
				detail.setHeight100(); 
				ApplicationInForFilingViewer detailForm = new ApplicationInForFilingViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId",ClientUtil.getEmployeeId());
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "spi.process_status IN ( 0, 1 )");
			kv2.put("value", status);
			keyvalues.add(kv2);

		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)) {
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ApplicationInForFilingSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSApplicationInForFiling.getInstance();
	}

	private String status;



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals("spi.process_status IN ( 3, 5 )")) {// 如果是已审核，则隐藏审批按钮
			viewButton.show();
		}
		this.status = status;
	}
	private int processType;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}



}

