package com.pomplatform.client.salary.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.payment.form.OnSalaryBonusSendDataSearchForm;
import com.pomplatform.client.salary.datasource.DSSalaryAnnualbonus;
import com.pomplatform.client.salary.form.SalaryAnnualbonusSearchForm;
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
import com.smartgwt.client.widgets.grid.ListGridField;

public class SalaryAnnualbonusSendPanel extends AbstractSearchPanel {
	
	private List<Map> keyvalues;
	
	private SalaryAnnualbonusSearchForm form;
	
	private Integer personnelBusinessId;
	
	private Integer year;
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SalaryAnnualbonusSendPanel cm = new SalaryAnnualbonusSendPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryAnnualbonus";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setCanEdit(false);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("companyId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeNo");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("bankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("factBonus");
		idx++;
		resultGrid.setFields(fields);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != getPersonnelBusinessId()){
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		}
		if(null != getKeyvalues()){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	private void setCompanySelectValue(){
		int employeeId = ClientUtil.getEmployeeId();
		Map<String, Object> params = new HashMap<>();
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("ST_CashierCompany", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				LinkedHashMap<String, String> newMap = new LinkedHashMap<>();
				if(dsResponse.getStatus() >= 0){
					Map<String, String> maps = KeyValueManager.getValueMap("system_dictionary_26");
					Record [] records = dsResponse.getData();
					for (Record record : records) {
						String companyId = record.getAttributeAsString("companyId");
						newMap.put(companyId, maps.get(companyId));
					}
					
				}
				form.getField("companyId").setValueMap(newMap);
			}
		});
	}
	
	public void initPanel(int type, Integer year, Integer personnelBusinessId) {
		if (type == 1) {// 出纳
			setPersonnelBusinessId(personnelBusinessId);
			setYear(year);
			SC.debugger();
			String tmpSql = "order by sab.employee_id";
			int employeeId = ClientUtil.getEmployeeId();

			form.getField("year").setDefaultValue(year);
			form.getField("year").setValue(year);
			form.getField("year").setDisabled(true);
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", tmpSql);
			kv.put("value", " and sab.company_id in (SELECT company_id FROM cashier_companys WHERE employee_id ="
					+ employeeId + ") " + tmpSql);
			keyvalues.add(kv);
			setKeyvalues(keyvalues);
			setCompanySelectValue();
		}
	}

	@Override
	public SearchForm generateSearchForm() {
		form =  new SalaryAnnualbonusSearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryAnnualbonus.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	public List<Map> getKeyvalues() {
		return keyvalues;
	}

	public void setKeyvalues(List<Map> keyvalues) {
		this.keyvalues = keyvalues;
	}

	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(Integer personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
