package com.pomplatform.client.k3voucher.panel;

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
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.k3voucher.datasource.DSGenerateCapitalVoucher;
import com.pomplatform.client.k3voucher.form.GenerateCapitalVoucherSearchForm;
import com.pomplatform.client.k3voucher.form.GenerateCapitalVoucherViewer;
import com.pomplatform.client.reimbursement.panel.CreateVoucherErrorPanel;
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

public class GenerateCapitalVoucherPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			GenerateCapitalVoucherPanel cm = new GenerateCapitalVoucherPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "GenerateCapitalVoucher";
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
		
		IButton createVoucherButton = PermissionControl.createPermissionButton("生成凭证", ERPPermissionStatic.ZD_SCPZ);
		createVoucherButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						createVoucherButton.setDisabled(true);
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
							createVoucherButton.setDisabled(false);
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						int length = records.length;
						Object[] ids = new Object[length];
						for(int i = 0; i < length; i++){
							ids[i] = records[i].getAttribute("capitalId");
						}
						Map<String, Object> params = new HashMap<>();
						params.put("capitalId", ids);
						params.put("optType", "createCapitalK3Voucher");
						DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								createVoucherButton.setDisabled(false);
								if (dsResponse.getStatus() < 0) {
									Record[] records = dsResponse.getData();
									if(null != records && records.length > 0) {
										PopupWindow window = new PopupWindow("错误信息");
										window.setWidth100();
										window.setHeight100();
										window.centerInPage();
										CreateVoucherErrorPanel panel = new CreateVoucherErrorPanel();
										panel.initPanel();
										panel.setRecords(records);
										panel.setDataToGrid();
										window.addItem(panel);
										window.show();
									}else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								} else {
									SC.say("凭证生成成功");
									commonQuery();
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(createVoucherButton);
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
				detail.setTitle("账单流水"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				GenerateCapitalVoucherViewer detailForm = new GenerateCapitalVoucherViewer();
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
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "having have_voucher = ?");
		if(BaseHelpUtils.getBoolean(criteria.get("haveVoucher"))) {
			kv.put("value", "having 1 = ? and kv.link_id is not null");
		}else {
			kv.put("value", "having 1 = ? and kv.link_id is null");
		}
		list.add(kv);
		criteria.remove("haveVoucher");
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))) {
			Map<String, String> keyValue = new HashMap<>();
			keyValue.put("key", "extract(year from c.happen_date) = ?");
			keyValue.put("value", "1 = ?");
			list.add(keyValue);
		}
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))) {
			Map<String, String> keyValue = new HashMap<>();
			keyValue.put("key", "extract(month from c.happen_date) = ?");
			keyValue.put("value", "1 = ?");
		}
		if(!list.isEmpty()) {
			criteria.put("keyValues", list);
		}
		criteria.put("addtionalCondition", "order by capital_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new GenerateCapitalVoucherSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSGenerateCapitalVoucher.getInstance();
	}

	private Integer year;
	private Integer month;
	private Integer companyId;
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		if(null != searchForm) {
			searchForm.getItem("year").setValue(year);
		}
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		if(null != searchForm) {
			searchForm.getItem("month").setValue(month);
		}
		this.month = month;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		if(null != searchForm) {
			searchForm.getItem("selfName").setValue(companyId);
		}
		this.companyId = companyId;
	}
	
}

