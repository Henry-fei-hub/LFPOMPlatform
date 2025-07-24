package com.pomplatform.client.reimbursement.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.reimbursement.datasource.DSResetAllReimbursementCost;
import com.pomplatform.client.reimbursement.form.ResetAllReimbursementCostSearchForm;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ResetAllReimbursementCostPanel extends AbstractSearchPanel
{

	private String processId;
	private String plateIds;
	private String[] plateIdArr;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ResetAllReimbursementCostPanel cm = new ResetAllReimbursementCostPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ResetAllReimbursementCost";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (ClientUtil.checkAndGetIntValue(record.getAttribute("resetTimes")) > 0) {  //已调整成本的标绿色
                    return "color:#00B736;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
		Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
    		String[] arr = str.split(",");
    		for(String tempStr : arr){
    			String[] tempArr = tempStr.split(":");
    			//获取父级ID
    			if(tempArr[0].replaceAll("\"", "").equals("Cost_allocation")){
    				processId = tempArr[1];
    			}
    		}
    	}
	}

	@Override
	public void initComponents() {
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
		ListGridField[] fields = new ListGridField[14];
		int idx = 0;
		fields[idx] = new ListGridField("code");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("processType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("feeType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("bearFeeCode");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("bearFeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setShowGridSummary(false);
		fields[idx] = new ListGridField("currency");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("exchangeRate");
		fields[idx++].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		idx++;
		fields[idx] = new ListGridField("inputTax");
		idx++;
		fields[idx] = new ListGridField("finalAmount");
		idx++;
		fields[idx] = new ListGridField("processStatus");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("costStatus");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("completeTime");
		fields[idx].setShowGridSummary(false);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
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
		IButton viewButton = new IButton("查看报销单");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton download = new IButton("导出");
		controlLayout.addMember(download);
		download.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object, Object> condition = generateCriteria();
				DBDataSource.downloadFile("DW_ResetAllReimbursementCost", condition);
			}
		});
		
		IButton costAllocation = new IButton("成本调节");
		controlLayout.addMember(costAllocation);
		costAllocation.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(null != processId){
					if(!resultGrid.anySelected()){
						SC.say("请选择一条数据");
					}else{
						Record selected = resultGrid.getSelectedRecords()[0];
						if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processStatus"))==ClientStaticUtils.PROCESS_STATUS_COMPLETED){
							if(ClientUtil.checkAndGetIntValue(selected.getAttribute("feeType")) == ClientStaticUtils.PROJECT_COST && ClientUtil.checkAndGetIntValue(selected.getAttribute("costStatus")) == ClientStaticUtils.PROJECT_COST_SETTLED){
								SC.say("该项目成本已结算，无法进行成本调节");
							}else if(ClientUtil.checkAndGetIntValue(selected.getAttribute("feeType")) == ClientStaticUtils.PROJECT_COST && ClientUtil.checkAndGetIntValue(selected.getAttribute("costStatus")) == ClientStaticUtils.PROJECT_COST_ADJUSTING){
								SC.say("该项目成本正在调节中，无法继续进行成本调节");
							}else{
								if(ClientUtil.checkAndGetIntValue(selected.getAttribute("resetTimes")) > 0){
									SC.say("该成本已进行过调节，无法再次调节");
								}else{
									Record record = new Record();
									record.setAttribute("processType", selected.getAttribute("processType"));
									record.setAttribute("businessId", selected.getAttribute("businessId"));
									record.setAttribute("processId", selected.getAttribute("processId"));
									record.setAttribute("processInstanceId", selected.getAttribute("processInstanceId"));
									record.setAttribute("plateId", selected.getAttribute("plateId"));
									record.setAttribute("id", selected.getAttribute("bearFeeId"));
									record.setAttribute("code", selected.getAttribute("bearFeeCode"));
									record.setAttribute("name", selected.getAttribute("bearFeeName"));
									record.setAttribute("cost", selected.getAttribute("finalAmount"));
									record.setAttribute("linkId", selected.getAttribute("subTableId"));
									record.setAttribute("drafter", ClientUtil.getUserId());
									record.setAttribute("costType", selected.getAttribute("feeType"));
									record.setAttribute("currency", selected.getAttribute("currency"));
									record.setAttribute("exchangeRate", selected.getAttribute("exchangeRate"));
							    	NewProcessWindow Reimbursement = new NewProcessWindow();
									Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(processId));
									Reimbursement.setLayoutMode(0);
									Reimbursement.setData(record);
									Reimbursement.initComponents();
									Reimbursement.setTitle(KeyValueManager.getValue("employee_processes", processId));
									Reimbursement.show();
									Reimbursement.addDataEditedHandler(new DataEditedHandler() {
										@Override
										public void onDataEdited(DataEditEvent event) {
											commonQuery();
										}
									});
								}
							}
						}else{
							SC.say("该流程尚未完成，无法进行成本调节");
						}
					}
				}else{
					SC.say("找不到相对应的流程");
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record selected = resultGrid.getSelectedRecords()[0];
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setWidth("80%");
                Reimbursement.setHeight("80%");
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.RESET_REIMBURSEMENT_COST_CHECK_ALL)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.RESET_REIMBURSEMENT_COST_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.RESET_REIMBURSEMENT_COST_CHECK_MYPLATE)) {
			/*
			 * 只拥有查看自己部门数据的权限 ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？ ②Y:用户是否拥有该部门的数据查看权限？
			 * →有权限：返回true； 没有权限：返回false ③N:默认加载该用户所可以查看的所有部门的信息
			 */
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				criteria.put("plateId", plateIds.split(",")[0]);
				return true;
			} else {
				for (String str : plateIdArr) {
					if (selectPlateId.equals(str)) {
						return true;
					}
				}
			}
		}
		SC.warn("提示", "您没有查看该部门数据的权限");
		return false;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ResetAllReimbursementCostSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSResetAllReimbursementCost.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 160;
	}
}

