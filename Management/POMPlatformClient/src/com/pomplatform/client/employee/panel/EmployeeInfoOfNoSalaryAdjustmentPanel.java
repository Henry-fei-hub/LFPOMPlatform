package com.pomplatform.client.employee.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.employee.datasource.DSEmployeeInfoOfNoSalaryAdjustment;
import com.pomplatform.client.employee.form.EmployeeInfoOfNoSalaryAdjustmentSearchForm;
import com.pomplatform.client.employee.form.EmployeeInfoOfNoSalaryAdjustmentViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class EmployeeInfoOfNoSalaryAdjustmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeInfoOfNoSalaryAdjustmentPanel cm = new EmployeeInfoOfNoSalaryAdjustmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeInfoOfNoSalaryAdjustment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[13];
		int idx = 0;
		fields[idx] = new ListGridField("employeeName");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("employeeNo");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("departmentId");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("onboardDate");
		fields[idx++].setCanEdit(false);
		fields[idx++] = new ListGridField("changeDate");
		fields[idx] = new ListGridField("fee");
		fields[idx++].setCanEdit(true);
		fields[idx++] = new ListGridField("type");
		fields[idx] = new ListGridField("originalPay");
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx++].setCanEdit(true);
		fields[idx] = new ListGridField("changePay");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("monthPay");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("percent");
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("remark");
		resultGrid.setFields(fields);

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map map = event.getNewValues();
				ListGridRecord record = resultGrid.getRecord(event.getRowNum());
				if(map.containsKey("changePay")){
					record.setAttribute("monthPay", BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay")).add(BaseHelpUtils.getBigDecimalValue(map.get("changePay"))));
					record.setAttribute("percent", BaseHelpUtils.getBigDecimalValue(map.get("changePay")).multiply(new BigDecimal(100)).divide(BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay")), 2, BigDecimal.ROUND_HALF_UP));
				}else if(map.containsKey("monthPay")){
					record.setAttribute("changePay", BaseHelpUtils.getBigDecimalValue(map.get("monthPay")).subtract(BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay"))));
					record.setAttribute("percent", BaseHelpUtils.getBigDecimalValue(record.getAttribute("changePay")).multiply(new BigDecimal(100)).divide(BaseHelpUtils.getBigDecimalValue(record.getAttribute("originalPay")), 2, BigDecimal.ROUND_HALF_UP));
				}
				resultGrid.updateData(record);
			}
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
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

		IButton applyButton = new IButton("调薪申请");
		applyButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = resultGrid.getSelectedRecords();
				for(ListGridRecord record : records){
					if(null == record.getAttributeAsObject("changeDate")){
						SC.say("请填写员工[" + record.getAttribute("employeeName") + "]的调薪日期");
						return;
					}
					if(null == record.getAttributeAsObject("type")){
						SC.say("请填写员工[" + record.getAttribute("employeeName") + "]的调薪类型");
						return;
					}
					if(null == record.getAttributeAsObject("changePay")){
						SC.say("请填写员工[" + record.getAttribute("employeeName") + "]的调薪金额");
						return;
					}
					if(null == record.getAttributeAsObject("monthPay")){
						SC.say("请填写员工[" + record.getAttribute("employeeName") + "]的调整后薪资总额");
						return;
					}
				}
				Map<String, Object> params = new HashMap<>();
				MapUtils.convertRecordToMap(resultGrid.getDataSource(), records, params, "list");
				params.put("optType", "salaryAdjustment");
				params.put("drafter", ClientUtil.getUserId());
				DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						commonQuery();
					}
				});
				
				
			}
		});
		controlLayout.addMember(applyButton);
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
				detail.setTitle("某段时间内没有调薪的人员信息"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				EmployeeInfoOfNoSalaryAdjustmentViewer detailForm = new EmployeeInfoOfNoSalaryAdjustmentViewer();
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
		criteria.put("drafter", ClientUtil.getUserId());
		List<Map> keyvalues = new ArrayList<>();
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_PLATE)) {
			criteria.put("functionCode", ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_PLATE);
		}else if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_ALL)
				&& !ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_PLATE)){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "WHERE a.status = 0 and a.plate_id");
			kv.put("value", "WHERE a.status = 0 and a.employee_id = " + ClientUtil.getUserId() + " and a.plate_id ");
			keyvalues.add(kv);
		}
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		criteria.put("addtionalCondition", "order by plate_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeInfoOfNoSalaryAdjustmentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeInfoOfNoSalaryAdjustment.getInstance();
	}


}

