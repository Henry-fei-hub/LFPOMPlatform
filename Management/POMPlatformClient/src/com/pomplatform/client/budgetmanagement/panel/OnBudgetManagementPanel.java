package com.pomplatform.client.budgetmanagement.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
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
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.budgetmanagement.datasource.DSOnBudgetManagement;
import com.pomplatform.client.budgetmanagement.form.OnBudgetManagementSearchForm;
import com.pomplatform.client.budgetmanagement.form.OnBudgetManagementViewer;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SyncDataUtil;
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
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class OnBudgetManagementPanel extends AbstractSearchPanel{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnBudgetManagementPanel cm = new OnBudgetManagementPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnBudgetManagement";
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);

		IButton uploadButton = new IButton("预算附件");
		controlLayout.addMember(uploadButton);
		uploadButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				final PopupWindow popupWindow = new PopupWindow("预算相关附件");
				popupWindow.setWidth("100%");
				popupWindow.setHeight("100%");
				Record record=resultGrid.getSelectedRecord();
				//获取预算单立项状态
				int bdStatus=BaseHelpUtils.getIntValue(record.getAttribute("bdStatus"));
				if(bdStatus==1) {//立项进行中
					SC.warn("提示","该预算单立项进行中,无法操作预算附件");
					return;
				}
				BudetUploadPanel uploadPanel = new BudetUploadPanel();
				uploadPanel.setRecord(record);
				uploadPanel.lodaDate();
				uploadPanel.initComponents();
				popupWindow.addItem(uploadPanel);
				uploadPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				uploadPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		IButton recordButton = new IButton("预算单立项");
		controlLayout.addMember(recordButton);
		recordButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				//获取流程process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
				if(!PomPlatformClientUtil.isNullOrEmpty(str)){
					String[] arr = str.split(",");
					for(String tempStr : arr){
						String[] tempArr = tempStr.split(":");
						//获取父级ID
						if(tempArr[0].replaceAll("\"", "").equals("Budget_Management")){
							processId = tempArr[1];
						}
					}
				}
				NewProcessWindow panel=new NewProcessWindow();
				panel.setTitle("预算单立项");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				panel.setLayoutMode(0);
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.initComponents();
				panel.setWidth("100%");
				panel.setHeight("100%");
				panel.centerInPage();
				panel.show();

			}
		});


		IButton payInfoButton = new IButton("预算单付款序列");
		controlLayout.addMember(payInfoButton);
		payInfoButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("查看付款序列"); 
				details.setWidth100(); 
				details.setHeight100(); 
				AbountPaymentSequenceinfoPanel detailsForm=new AbountPaymentSequenceinfoPanel();
				detailsForm.setRecord(record);
				detailsForm.commonQuery();
				details.setContent(detailsForm);
				details.centerInPage();
				details.show();

			}
		});

		IButton settlementbut=PermissionControl.createPermissionButton("结算", ERPPermissionStatic.BD_SETTLEMENT);
		settlementbut.hide();
		controlLayout.addMember(settlementbut);
		settlementbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			}
		});

		IButton progressButton=new IButton("流程进度");
		controlLayout.addMember(progressButton);
		progressButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				String sprocessInstanceId = record.getAttribute("processInstanceId");
				Map params = new HashMap();
				params.put("processInstanceId", sprocessInstanceId);
				DBDataSource.callOperation("EP_GetProcessInstance", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if (records.length == 0) {
								return;
							}
							Record record = records[0];
							Record processInstance = record.getAttributeAsRecord("processInstance");
							ClientUtil.showWorkFlow(processInstance);
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
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
				detail.setTitle("预算单信息"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnBudgetManagementViewer detailForm = new OnBudgetManagementViewer();
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
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.BD_SETTLEMENT_ALL) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.BD_SETTLEMENT_DEPARTMENT)) {
			//查看自己所在部门的权限
			List<Map> keyvalues = new ArrayList<>();
			//获取申请人业务部门ID
			int plateId=ClientUtil.getPlateId();
			Map<String,Object> parentMap=new HashMap<>();
			parentMap.put("plateId", plateId);
			Record records=SyncDataUtil.getValueByTableName("ST_PlateRecord", "find", parentMap);
			//获取父级parentId
			int parentId=BaseHelpUtils.getIntValue(records.getAttribute("parentId"));
			Map<String,Object> map=new HashMap<>();
			StringBuffer sb = new StringBuffer();
			if(parentId==0) {//说明当前部门是一级部门
				map.put("parentId", plateId);
				Record[] recordarr=SyncDataUtil.getValueByTableNames("ST_PlateRecord", "find", map);
				if(BaseHelpUtils.isNullOrEmpty(recordarr)) {//该部门没有二级部门
					sb.append(plateId);
				}else {//该部门有二级部门
					for (Record record : recordarr) {
						if(sb.length() > 0) {
							sb.append(",");
						}
						sb.append(BaseHelpUtils.getIntValue(record.getAttribute("plateId")));
					}
				}
			}else {
				map.put("parentId", parentId);
				Record[] recordarr=SyncDataUtil.getValueByTableNames("ST_PlateRecord", "find", map);
				for (Record record : recordarr) {
					if(sb.length() > 0) {
						sb.append(",");
					}
					sb.append(BaseHelpUtils.getIntValue(record.getAttribute("plateId")));
				}
			}
			if(criteria.size()<=0){
				if(BaseHelpUtils.isNullOrEmpty(criteria.get("departmentId"))){
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "bm.department_id=?");
					kv.put("value", "bm.department_id in("+sb+")");
					keyvalues.add(kv);
				}
			}

			if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
				criteria.put("keyValues", keyvalues);
			}
		}else if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.BD_SETTLEMENT_ALL) && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.BD_SETTLEMENT_DEPARTMENT) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.BD_SETTLEMENT) ){
			//只能查看自己申请的权限
			criteria.put("bdApplyEmployeeId", ClientUtil.getEmployeeId());
		}
		criteria.put("addtionalCondition", "order by bm.budget_management_id desc");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnBudgetManagementSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnBudgetManagement.getInstance();
	}



}

