package com.pomplatform.client.workflow.professional.panel;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.pomplatform.client.workflow.professional.datasource.DSOnLoadApplyListOfProfessionalApproval;
import com.pomplatform.client.workflow.professional.form.NewOnLoadApplyListOfProfessionalApprovalForm;
import com.pomplatform.client.workflow.professional.form.OnLoadApplyListOfProfessionalApprovalSearchForm;
import com.pomplatform.client.workflow.professional.form.OnLoadApplyListOfProfessionalApprovalViewer;
import com.pomplatform.client.workflow.professional.form.UpdateOnLoadApplyListOfProfessionalApprovalForm;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class OnLoadApplyListOfProfessionalApprovalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadApplyListOfProfessionalApprovalPanel cm = new OnLoadApplyListOfProfessionalApprovalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadApplyListOfProfessionalApproval";
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
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				//Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.setTitle("专业负责人审批");
				Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
				Reimbursement.show();

				/*GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("OnLoadApplyListOfProfessionalApproval");
				detail.setWidth100();
				detail.setHeight100();
				OnLoadApplyListOfProfessionalApprovalViewer detailForm = new OnLoadApplyListOfProfessionalApprovalViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();*/
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//if (ACTIVITY_TYPE_1 == activityType||ACTIVITY_TYPE_2 == activityType) {
		criteria.put("employeeId", ClientUtil.getUserId());
		//}
		criteria.put("processType",processType);

		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		if(!BaseHelpUtils.isNullOrEmpty(status)){
			kv.put("key", "ORDER BY spi.create_time");
			kv.put("value", "AND spi.process_status IN " + status+" ORDER BY spi.create_time ");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadApplyListOfProfessionalApprovalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadApplyListOfProfessionalApproval.getInstance();
	}

	private int processType;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private int activityType;

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	/**
	 * 我的发起(发起/进行中)
	 */
	//public static final int ACTIVITY_TYPE_1 = 1;

	//public static final int ACTIVITY_TYPE_2 = 2;

	//public static final int ACTIVITY_TYPE_3 = 3;
}



