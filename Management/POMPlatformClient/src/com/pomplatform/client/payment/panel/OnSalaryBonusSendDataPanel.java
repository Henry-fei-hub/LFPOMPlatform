package com.pomplatform.client.payment.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryBonusSendData;
import com.pomplatform.client.payment.form.OnSalaryBonusSendDataSearchForm;
import com.pomplatform.client.payment.form.OnSalaryBonusSendDataViewer;
import com.pomplatform.client.payment.form.OnSalarySendDataSearchForm;
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

public class OnSalaryBonusSendDataPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private List<Map> keyvalues;

	private OnSalaryBonusSendDataSearchForm form;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryBonusSendDataPanel cm = new OnSalaryBonusSendDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryBonusSendData";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
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
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				DBDataSource.downloadFile("DW_OnSalaryBonusSendData", generateCriteria());
			}
		});
//		commonQuery();
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
				detail.setTitle("奖金发放表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalaryBonusSendDataViewer detailForm = new OnSalaryBonusSendDataViewer();
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

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != getKeyvalues()){
			criteria.put("keyValues", keyvalues);
		}
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		form =  new OnSalaryBonusSendDataSearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryBonusSendData.getInstance();
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

	public void initPanel(int type, int year, int month) {
		// 该模块需要进行优化 delay_deal
		if (type == 1) {// 出纳
			SC.debugger();
			String tmpSql = "ORDER BY b.company_id,b.plate_id,b.department_id";
			int employeeId = ClientUtil.getEmployeeId();
			
			form.getField("year").setDefaultValue(year);
			form.getField("month").setDefaultValue(month);
			form.getField("year").setValue(year);
			form.getField("month").setValue(month);
			form.getField("year").setDisabled(true);
			form.getField("month").setDisabled(true);
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", tmpSql);
			kv.put("value", " and b.company_id in (SELECT company_id FROM cashier_companys WHERE employee_id =" + employeeId + ") " + tmpSql);
			keyvalues.add(kv);
			setKeyvalues(keyvalues);
			setCompanySelectValue();
		}
	}
	
	private Integer personnelBusinessId;
	
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
