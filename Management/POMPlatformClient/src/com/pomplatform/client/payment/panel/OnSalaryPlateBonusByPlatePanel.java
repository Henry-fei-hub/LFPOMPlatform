package com.pomplatform.client.payment.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryPlateBonusByCompany;
import com.pomplatform.client.payment.form.OnSalaryBonusByPlateSearchForm;
import com.pomplatform.client.payment.form.OnSalaryPlateBonusByCompanyViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class OnSalaryPlateBonusByPlatePanel extends AbstractSearchPanel {
	
	private Integer year;
	private Integer month;
	private Integer flowStatus;
	private Integer personnelBusinessId;
	private List<Map> keyvalues;
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryPlateBonusByPlatePanel cm = new OnSalaryPlateBonusByPlatePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryPlateBonusByPlate";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needViewPage = false;
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
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
				//获取业务Id
				int personnelBusinessId = BaseHelpUtils.getIntValue(getPersonnelBusinessId());
				PopupWindow pw = new PopupWindow();
				OnSalaryDepartmentBonusByPlatePanel panel = new OnSalaryDepartmentBonusByPlatePanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.setMonth(month);
				panel.setPersonnelBusinessId(personnelBusinessId);
				panel.commonQuery();
				panel.initComponents();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("奖金分表");
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
	public int getSearchFormHeight() {
		return 60;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != getYear()){
			criteria.put("year", getYear());
		}
		if (null != getMonth()) {
			criteria.put("month", getMonth());
		}
		if(null != getPersonnelBusinessId()){
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		}
		if(null != getFlowStatus()){
			criteria.put("flowStatus", getFlowStatus());
		}
		if(null != getKeyvalues()){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnSalaryBonusByPlateSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryPlateBonusByCompany.getInstance();
	}

	public void initSearchData(int type, int year, int month) {
		searchForm.getField("year").setDefaultValue(year);
		searchForm.getField("year").setValue(year);
		searchForm.getField("year").setDisabled(true);
		searchForm.getField("month").setDefaultValue(month);
		searchForm.getField("month").setValue(month);
		searchForm.getField("month").setDisabled(true);
		// type等于1时 为 部门分管领导 //一个部门分管领导有可能查询多个业务部门
		if (type == 1) {
			Map<String, Object> params = new HashMap<>();
			params.put("employeeId", ClientUtil.getEmployeeId());
			params.put("opt_type", "getPlateByRole");
			DBDataSource.callOperation("EP_CustomSemployeeProcess", params, new DSCallback() {

				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() > 0) {
						String ids = dsResponse.getErrors().get("errorMsg").toString();
						ids = ids.replace("[", "").replace("]", "");
						if (ids.length() > 0) {
							String tmpSql = "GROUP BY pd.plate_id, A.YEAR, A.MONTH ORDER BY pd.plate_id, A.YEAR, A.MONTH";
							List<Map> keyvalues = new ArrayList<>();
							Map<String, String> kv = new HashMap<>();
							kv.put("key", tmpSql);
							kv.put("value", " and a.plate_id in (" + ids + ") " + tmpSql);
							keyvalues.add(kv);
							setKeyvalues(keyvalues);
							LinkedHashMap<String, String> valueMap = new LinkedHashMap<>();
							Record[] records = dsResponse.getData();
							for (Record record : records) {
								valueMap.put(record.getAttribute("plateId"), record.getAttribute("plateName"));
							}
							searchForm.getField("plateId").setValueMap(valueMap);
							commonQuery();
						} else {

						}
					} else {

					}

				}
			});
		}

	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(Integer flowStatus) {
		this.flowStatus = flowStatus;
	}

	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(Integer personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

	
	public List<Map> getKeyvalues() {
		return keyvalues;
	}

	public void setKeyvalues(List<Map> keyvalues) {
		this.keyvalues = keyvalues;
	}
}
