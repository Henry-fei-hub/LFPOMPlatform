package com.pomplatform.client.employee.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.employee.datasource.DSUpdateFrozenIntegral;
import com.pomplatform.client.employee.form.UpdateFrozenIntegralSearchForm;
import com.pomplatform.client.employee.form.UpdateFrozenIntegralViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class UpdateFrozenIntegralPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			UpdateFrozenIntegralPanel cm = new UpdateFrozenIntegralPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "UpdateFrozenIntegral";
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
		
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx++] = new ListGridField("plateId");
		fields[idx++] = new ListGridField("departmentId");
		fields[idx++] = new ListGridField("employeeNo");
		fields[idx++] = new ListGridField("employeeName");
		fields[idx] = new ListGridField("endDate");
		fields[idx++].setWidth(150);
		fields[idx++] = new ListGridField("livingExpenses");
		fields[idx++] = new ListGridField("housingFinance");
		fields[idx++] = new ListGridField("fee");
		resultGrid.setFields(fields);
		
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
		
		IButton updateButton = new IButton("修改冻结积分");
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()) {
							SC.say("请选择需要修改冻结节分的数据");
							return;
						}
						final Record selected = resultGrid.getSelectedRecord();
						SC.askforValue("请输入冻结积分", new ValueCallback() {
							
							@Override
							public void execute(String value) {
								if(BaseHelpUtils.isNullOrEmpty(value)) {
									return;
								}
								String personnelBusinessId = selected.getAttribute("personnelBusinessId");
								if(BaseHelpUtils.isNullOrEmpty(personnelBusinessId)) {
									return;
								}
								final BigDecimal allIntegral = BaseHelpUtils.getBigDecimalValue(selected.getAttributeAsObject("livingExpenses"));
								final BigDecimal frozenIntegral = BaseHelpUtils.getBigDecimalValue(value).setScale(2, BigDecimal.ROUND_DOWN);
								BigDecimal tempFee = allIntegral.subtract(frozenIntegral);
								if(tempFee.compareTo(BigDecimal.ZERO) < 0) {
									tempFee = BigDecimal.ZERO;
								}
								final BigDecimal fee = tempFee;
								if(frozenIntegral.compareTo(BigDecimal.ZERO) == 0) {
									SC.confirm("您确定要将该员工的冻结积分设置为0吗？", new BooleanCallback() {
										
										@Override
										public void execute(Boolean value) {
											if(value) {
												Map<String, Object> params = new HashMap<>();
												params.put("personnelBusinessId", personnelBusinessId);
												params.put("livingExpenses", allIntegral);
												params.put("housingFinance", frozenIntegral);
												params.put("fee", fee);
												DBDataSource.callOperation("ST_PersonnelBusines", "update", params, new DSCallback() {
													
													@Override
													public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
														if(dsResponse.getStatus() >= 0) {
															SC.say("修改成功");
															commonQuery();
														}else {
															ClientUtil.displayErrorMessage(dsResponse);
														}
													}
												});
											}
										}
									});
								}else {
									Map<String, Object> params = new HashMap<>();
									params.put("personnelBusinessId", personnelBusinessId);
									params.put("livingExpenses", allIntegral);
									params.put("housingFinance", frozenIntegral);
									params.put("fee", fee);
									DBDataSource.callOperation("ST_PersonnelBusines", "update", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() >= 0) {
												SC.say("修改成功");
												commonQuery();
											}else {
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
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
				detail.setTitle("修改离职人员冻结积分"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				UpdateFrozenIntegralViewer detailForm = new UpdateFrozenIntegralViewer();
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
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))) {
			Map<String, String> map = new HashMap<>();
			map.put("key", "extract(year from a.end_date) = ?");
			map.put("value", "1 = ?");
			list.add(map);
		}
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("month"))) {
			Map<String, String> map = new HashMap<>();
			map.put("key", "extract(month from a.end_date) = ?");
			map.put("value", "1 = ?");
			list.add(map);
		}
		if(!list.isEmpty()) {
			criteria.put("keyValues", list);
		}
		criteria.put("addtionalCondition", "order by personnel_business_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new UpdateFrozenIntegralSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSUpdateFrozenIntegral.getInstance();
	}


}

