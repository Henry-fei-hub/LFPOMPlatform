package com.pomplatform.client.workflow.personnelbusiness.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.payment.panel.OnPrintChangeSalaryTotal;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSPlateSalaryAdjustmentSummary;
import com.pomplatform.client.workflow.personnelbusiness.form.PlateSalaryAdjustmentSummarySearchForm;
import com.pomplatform.client.workflow.personnelbusiness.form.PlateSalaryAdjustmentSummaryViewer;
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

public class PlateSalaryAdjustmentSummaryPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PlateSalaryAdjustmentSummaryPanel cm = new PlateSalaryAdjustmentSummaryPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateSalaryAdjustmentSummary";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton printButton = new IButton("打印");
		controlLayout.addMember(printButton);
		printButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取所有业务部门id数据集
				String plateIds ="";
				Record[] records = resultGrid.getRecords();
				if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
					for(Record r:records){
						String plateId = BaseHelpUtils.getString(r.getAttribute("plateId"));
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
							plateIds += ",";
						}
						plateIds += plateId;
					}
				}
				Map<String,Object> params = new HashMap<>();
				params.put("optType", "onFindEmpByRole");
				params.put("plateIds", plateIds);
				DBDataSource.callOperation("EP_OnPaymentManageProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						//部门审批人
						String auditPerson = dsResponse.getAttributeAsMap("userData").get("auditPerson")+"";
						//申请人
						String payPerson = dsResponse.getAttributeAsMap("userData").get("payPerson")+"";
						//运营审批
						String operatePerson = dsResponse.getAttributeAsMap("userData").get("operatePerson")+"";
						//人资审批
						String hrPerson = dsResponse.getAttributeAsMap("userData").get("hrPerson")+"";
						OnPrintChangeSalaryTotal printHtml = new OnPrintChangeSalaryTotal();
						Map<String,Object> map = new HashMap<>();
						int year = BaseHelpUtils.getIntValue(searchForm.getItem("year").getValue());
						int month = BaseHelpUtils.getIntValue(searchForm.getItem("month").getValue());
						int plateId = BaseHelpUtils.getIntValue(searchForm.getItem("plateId").getValue());
						map.put("year", year);
						map.put("month", month);
						map.put("plateId", plateId);
						map.put("auditPerson", auditPerson);
						map.put("payPerson", payPerson);
						map.put("operatePerson", operatePerson);
						map.put("hrPerson", hrPerson);
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
							printHtml.setRecords(records);
							printHtml.setPrintData(map);
							Print.it(printHtml.generatePrintHTML());
						}
					}
				});
			}
		});
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//获取所有业务部门id数据集
				String plateIds ="";
				Record[] records = resultGrid.getRecords();
				if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
					for(Record r:records){
						String plateId = BaseHelpUtils.getString(r.getAttribute("plateId"));
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
							plateIds += ",";
						}
						plateIds += plateId;
					}
				}
				Map<String,Object> map = new HashMap<>();
				map.put("optType", "onFindEmpByRole");
				map.put("plateIds", plateIds);
				DBDataSource.callOperation("EP_OnPaymentManageProcess", map, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						//部门审批人
						String auditPerson = dsResponse.getAttributeAsMap("userData").get("auditPerson")+"";
						//申请人
						String payPerson = dsResponse.getAttributeAsMap("userData").get("payPerson")+"";
						//运营审批
						String operatePerson = dsResponse.getAttributeAsMap("userData").get("operatePerson")+"";
						//人资审批
						String hrPerson = dsResponse.getAttributeAsMap("userData").get("hrPerson")+"";
						@SuppressWarnings("unchecked")
						Map<String,Object> param = generateCriteria();
						param.put("auditPerson", auditPerson);
						param.put("payPerson", payPerson);
						param.put("operatePerson", operatePerson);
						param.put("hrPerson", hrPerson);
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
							DBDataSource.downloadFile("DW_ExportPlateSalaryAdjustmentSummary", param);
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
				detail.setTitle("业务部门调薪汇总"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				PlateSalaryAdjustmentSummaryViewer detailForm = new PlateSalaryAdjustmentSummaryViewer();
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
			String plates = PomPlatformClientUtil.getRolePlateId();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "where a.plate_id");
			kv.put("value", "where a.plate_id in (" + plates + ") and a.plate_id ");
			keyvalues.add(kv);
		}
        if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))){
        	Map<String, String> kv = new HashMap<>();
        	kv.put("key", "extract(year from b.end_date)");
        	kv.put("value", "1");
        	keyvalues.add(kv);
        }
        if(BaseHelpUtils.isNullOrEmpty(criteria.get("month"))){
        	Map<String, String> kv = new HashMap<>();
        	kv.put("key", "extract(month from b.end_date)");
        	kv.put("value", "1");
        	keyvalues.add(kv);
        }
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new PlateSalaryAdjustmentSummarySearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateSalaryAdjustmentSummary.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 70;
	}
}

