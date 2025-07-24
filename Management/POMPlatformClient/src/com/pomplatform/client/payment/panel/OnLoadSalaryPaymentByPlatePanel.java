package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.payment.datasource.DSOnLoadSalaryPaymentByPlate;
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
import com.smartgwt.client.widgets.form.SearchForm;

public class OnLoadSalaryPaymentByPlatePanel extends AbstractSearchPanel
{
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadSalaryPaymentByPlatePanel cm = new OnLoadSalaryPaymentByPlatePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadSalaryPaymentByPlate";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
		currentPage = 0;
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
						Map<String,Object> param = new HashMap<>(); 
						String auditPerson = dsResponse.getAttributeAsMap("userData").get("auditPerson")+"";
						String formPerson = dsResponse.getAttributeAsMap("userData").get("formPerson")+"";
						String adminPerson = dsResponse.getAttributeAsMap("userData").get("adminPerson")+"";
						param.put("companyId",companyId);
						param.put("type",type);
						param.put("year",year);
						param.put("month",month);
						param.put("auditPerson",auditPerson);
						param.put("formPerson",formPerson);
						param.put("adminPerson",adminPerson);
						OnLoadSalaryPaymentByPlatePrintPanel printHtml = new OnLoadSalaryPaymentByPlatePrintPanel();
						//获取列表数据集
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
							printHtml.setRecords(records);
							printHtml.setPrintData(param);
							Print.it(printHtml.generatePrintHTML());
						}else{
							SC.say("提示","没有可打印的数据");
						}
					}
				});
			}
		});

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("companyId", companyId);
		criteria.put("year", year);
		criteria.put("month", month);
		criteria.put("type", type);
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadSalaryPaymentByPlate.getInstance();
	}

	private int companyId;
	private int year;
	private int month;
	private int type;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}

