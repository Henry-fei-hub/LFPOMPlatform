package com.pomplatform.client.payment.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.payment.datasource.DSOnSalarySendData;
import com.pomplatform.client.payment.form.OnSalarySendDataSearchForm;
import com.pomplatform.client.payment.form.OnSalarySendDataViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.*;
import java.util.logging.Logger;

public class OnSalarySendDataPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private OnSalarySendDataSearchForm form;
	
	private List<Map> keyvalues;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalarySendDataPanel cm = new OnSalarySendDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalarySendData";
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
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				DBDataSource.downloadFile("DW_OnSalarySendData", params);
			}
		});
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});

		IButton loanButton = new IButton("借款申请");
		controlLayout.addMember(loanButton);
		loanButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				PopupWindow pw = new PopupWindow();
				Map<String, Object> condition = new HashMap<String, Object>();
				pw.setTitle("剩余发放人员详情");
				pw.setWidth("80%");
				pw.setHeight("80%");
				ResidualwageDataPanel panel = new ResidualwageDataPanel();
				pw.addMember(panel);
				pw.show();
				//点击保存跳转到借款申请页面
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						record.setAttribute("optType", "工资发放总表");
						pw.close();
						NewProcessWindow distribution = new NewProcessWindow();
						Map<String, String> processIdMap = PomPlatformClientUtil
								.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_1);
						Integer processId = ClientUtil.checkAndGetIntValue(processIdMap.get("Borrow_money_manage"));
						distribution.setTitle("借款申请");
						distribution.setData(record);
						distribution.setProcessId(processId);
						distribution.setLayoutMode(0);
						distribution.initComponents();
						distribution.show();
					}
				});
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
				detail.setTitle("工资发放表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalarySendDataViewer detailForm = new OnSalarySendDataViewer();
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
		if(null != getKeyvalues()){
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
		form = new OnSalarySendDataSearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalarySendData.getInstance();
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
		//该模块需要进行优化  delay_deal
		if(type == 1){//出纳
			SC.debugger();
			String tmpSql = "ORDER BY a.company_id,a.employee_id";
			int employeeId = ClientUtil.getEmployeeId();
			
			form.getField("year").setDefaultValue(year);
			form.getField("month").setDefaultValue(month );
			form.getField("year").setValue(year);
			form.getField("month").setValue(month );
			form.getField("year").setDisabled(true);
			form.getField("month").setDisabled(true);
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", tmpSql);
			kv.put("value", " and a.company_id in (SELECT company_id FROM cashier_companys WHERE employee_id =" + employeeId + ") " + tmpSql);
			keyvalues.add(kv);
			setKeyvalues(keyvalues);
			setCompanySelectValue();
		}
	}

	public List<Map> getKeyvalues() {
		return keyvalues;
	}

	public void setKeyvalues(List<Map> keyvalues) {
		this.keyvalues = keyvalues;
	}
	
}
