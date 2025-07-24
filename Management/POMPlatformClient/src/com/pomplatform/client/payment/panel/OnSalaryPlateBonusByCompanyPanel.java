package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryPlateBonusByCompany;
import com.pomplatform.client.payment.form.OnSalaryPlateBonusByCompanyViewer;
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

public class OnSalaryPlateBonusByCompanyPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryPlateBonusByCompanyPanel cm = new OnSalaryPlateBonusByCompanyPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryPlateBonusByCompany";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		
		IButton printButton = new IButton("打印");
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
						if(dsResponse.getStatus() >= 0){
							String auditPerson = dsResponse.getAttributeAsMap("userData").get("auditPerson")+"";
							String formPerson = dsResponse.getAttributeAsMap("userData").get("formPerson")+"";
							String adminPerson = dsResponse.getAttributeAsMap("userData").get("adminPerson")+"";
							Map<String,Object> param = new HashMap<>(); 
							param.put("companyId",companyId);
							param.put("year",year);
							param.put("month",month);
							param.put("auditPerson",auditPerson);
							param.put("formPerson",formPerson);
							param.put("adminPerson",adminPerson);
							OnPrintSalaryBonusTotalOfPlate printHtml = new OnPrintSalaryBonusTotalOfPlate();
							//获取列表数据集
							Record[] records = resultGrid.getRecords();
							if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
								printHtml.setRecords(records);
								printHtml.setPrintData(param);
								Print.it(printHtml.generatePrintHTML());
							}else{
								SC.say("提示","没有可打印的数据");
							}
						}
					}
				});
			}
		});
		controlLayout.addMember(printButton);
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				// 获取业务部门名称
				String plateName = KeyValueManager.getValue("plate_records", plateId + "");
				// 获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				int month = BaseHelpUtils.getIntValue(record.getAttribute("month"));
				int personnelBusinessId = BaseHelpUtils.getIntValue(getPersonnelBusinessId());
				
				PopupWindow pw = new PopupWindow();
				OnSalaryDepartmentBonusByPlatePanel panel = new OnSalaryDepartmentBonusByPlatePanel();
				pw.addItem(panel);
				panel.setCompanyId(companyId);
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.setMonth(month);
				panel.setPersonnelBusinessId(personnelBusinessId);
//				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的归属部门奖金明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
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
				detail.setTitle("OnSalaryPlateBonusByCompany"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryPlateBonusByCompanyViewer detailForm = new OnSalaryPlateBonusByCompanyViewer();
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
		if(companyId >= 0){
			criteria.put("companyId", companyId);
		}
		if(year > 0){
			criteria.put("year", year);
		}
		if(month > 0){
			criteria.put("month", month);
		}
		if (null != getPersonnelBusinessId() && getPersonnelBusinessId() > 0) {
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryPlateBonusByCompany.getInstance();
	}
	
	private int companyId=-1;
	private int year;
	private int month;
	private Integer personnelBusinessId;
	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(Integer personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}


}

