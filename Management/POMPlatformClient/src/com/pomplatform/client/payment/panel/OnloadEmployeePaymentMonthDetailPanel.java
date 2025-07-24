package com.pomplatform.client.payment.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeesalary.panel.PasswordPanel;
import com.pomplatform.client.payment.datasource.DSOnloadEmployeePaymentMonthDetail;
import com.pomplatform.client.payment.form.OnloadEmployeePaymentMonthDetailSearchForm;
import com.pomplatform.client.payment.form.OnloadEmployeePaymentMonthDetailViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class OnloadEmployeePaymentMonthDetailPanel extends AbstractSearchPanel
{

	private static boolean canCheck = false;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnloadEmployeePaymentMonthDetailPanel cm = new OnloadEmployeePaymentMonthDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnloadEmployeePaymentMonthDetail";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
		resultGrid.setCanEdit(true);
		canCheck = false;
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[19];
		int index = 0;
		fields[index] = new ListGridField("employeePaymentMonthDetailId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("employeeId");
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		fields[index].setEditorProperties(employeeIdItem);
		fields[index].setValueMap(KeyValueManager.getValueMap("employees"));
		index++;
		fields[index] = new ListGridField("employeeName");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("departmentId");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("plateId");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("year");
		index++;
		fields[index] = new ListGridField("month");
		index++;
		fields[index] = new ListGridField("monthPay");
		fields[index].setDefaultValue("0");
		index++;
		fields[index] = new ListGridField("basicProportionStr");
		fields[index].setDefaultValue("0%");
		index++;
		fields[index] = new ListGridField("basicProportion");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("monthBasicPay");
		fields[index].setCellFormatter(new CellFormatter() {
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if (value != null) {
					BigDecimal monthBasicPay = new BigDecimal(""+ value);
					BigDecimal tem1 = monthBasicPay.setScale(2, BigDecimal.ROUND_HALF_DOWN);
					return tem1.toString();
				}else {
					return "";
				}
			}
		});
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("monthPerformancePay");
		fields[index].setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if (value != null) {
					BigDecimal monthPerformancePaynew = new BigDecimal(""+ value);
					BigDecimal tem1 = monthPerformancePaynew.setScale(2, BigDecimal.ROUND_HALF_DOWN);
					return tem1.toString();
				}else {
					return "";
				}
			}
		});
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("foremanPay");
		fields[index].setDefaultValue("0");
		index++;
		fields[index] = new ListGridField("otherSubsidy");
		fields[index].setDefaultValue("0");
		index++;
		fields[index] = new ListGridField("totalPay");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("annualPerformance");
		fields[index].setDefaultValue("0");
		index++;
		fields[index] = new ListGridField("costAttribution");
		SelectItem costAttributionItem = new SelectItem("costAttribution");
		fields[index].setEditorProperties(costAttributionItem);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_114"));
		index++;
		fields[index] = new ListGridField("enabled");
		fields[index].setHidden(true);
		resultGrid.setFields(fields);
		
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
		
		IButton calculateButton = new IButton("计算月薪");
		calculateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = generateCriteria();
				if(BaseHelpUtils.isNullOrEmpty(params.get("year"))){
					SC.say("请选择要计算的年份");
					return;
				}
				if(BaseHelpUtils.isNullOrEmpty(params.get("month"))){
					SC.say("请选择要计算的月份");
					return;
				}
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_ToCalculateEmployeePaymentMonth", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
			}
		});
		controlLayout.addMember(calculateButton);
		
		IButton addButton = new IButton("新增");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
			}
		});
		controlLayout.addMember(addButton);
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int rowNum = event.getRowNum();
				Map<String,Object> record = resultGrid.getRecord(rowNum).toMap();
				
				String basicProportionStr = "";
				BigDecimal basicProportion = BigDecimal.ZERO;
				BigDecimal monthPay = BigDecimal.ZERO;
				BigDecimal monthBasicPay = BigDecimal.ZERO;
				BigDecimal monthPerformancePay = BigDecimal.ZERO; 
				
				if(!BaseHelpUtils.isNullOrEmpty(record.get("basicProportionStr"))){
					basicProportionStr = BaseHelpUtils.getString(record.get("basicProportionStr"));
					int len = basicProportionStr.indexOf("%");
					if(len > 0){
						//基本比例
						basicProportion = BaseHelpUtils.getBigDecimalValue(basicProportionStr.substring(0, len)).divide(BigDecimal.valueOf(100));
						record.put("basicProportion", basicProportion);
					}else{
						SC.say("请输入正确的比例，如：50%");
						return;
					}
				}
				monthPay = BaseHelpUtils.getBigDecimalValue(record.get("monthPay"));
				//月基本工资
				monthBasicPay = monthPay.multiply(basicProportion);
				record.put("monthBasicPay", monthBasicPay);
				//月绩效工资
				monthPerformancePay = monthPay.subtract(monthBasicPay);
				record.put("monthPerformancePay", monthPerformancePay);
				//工龄工资
				BigDecimal foremanPay = BaseHelpUtils.getBigDecimalValue(record.get("foremanPay"));
				//其他补贴
				BigDecimal otherSubsidy = BaseHelpUtils.getBigDecimalValue(record.get("otherSubsidy"));
				//全薪
				BigDecimal totalPay = monthBasicPay.add(monthPerformancePay).add(foremanPay).add(otherSubsidy);
				record.put("totalPay", totalPay);
				DBDataSource.callOperation("ST_EmployeePaymentMonthDetail", "saveOrUpdate", record, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
			}
		});
		
		IButton deleteButton = new IButton("删除");
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				SC.ask("确认删除该条数据吗?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String,Object> map = resultGrid.getSelectedRecord().toMap();
							DBDataSource.callOperation("ST_EmployeePaymentMonthDetail", "delete", map, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
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
		});
		controlLayout.addMember(deleteButton);
		
		
		IButton deleteAllButton = new IButton("删除所有");
		deleteAllButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				if(canCheck==false) {
					SC.say("提示","请输入正确的解锁密码");
					return;
				}
				
				Map criteria = generateCriteria();
				final int year = BaseHelpUtils.getIntValue(criteria.get("year"));
				final int month = BaseHelpUtils.getIntValue(criteria.get("month"));
				SC.ask("确认删除"+year+"年"+month+"月"+"的所有数据吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							if(BaseHelpUtils.isNullOrEmpty(year)||year<=0) {
								SC.say("提示","年份不能为空");
								return;
							}
							if(BaseHelpUtils.isNullOrEmpty(month)||month<=0) {
								SC.say("提示","月份不能为空");
								return;
							}
							Map<String,Object> map = new HashMap<>();
							map.put("year", year);
							map.put("month", month);
							DBDataSource.callOperation("ST_EmployeePaymentMonthDetail", "delete", map, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
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
		});
		controlLayout.addMember(deleteAllButton);
		
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_DownLoadEmployeePaymentMonthDetail", generateCriteria());
			}
		});
		controlLayout.addMember(downloadButton);
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
				detail.setTitle("月薪详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnloadEmployeePaymentMonthDetailViewer detailForm = new OnloadEmployeePaymentMonthDetailViewer();
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
	public void commonQuery() {
		if(!canCheck){
			PopupWindow pWindow = new PopupWindow();
			pWindow.setTitle("您需输入正确的解锁密码方可查看数据");
			pWindow.setWidth("20%");
			pWindow.setHeight("13%");
			pWindow.centerInPage();
			PasswordPanel panel = new PasswordPanel();
			panel.setParentWindow(pWindow);
			panel.addDataEditedHandler(new DataEditedHandler() {
				@Override
				public void onDataEdited(DataEditEvent event) {
					Record record1 = event.getData();
					String value = BaseHelpUtils.getString(record1.getAttribute("password"));
					if(BaseHelpUtils.isNullOrEmpty(value)){
						SC.say("提示","请输入正确的解锁密码");
					}else{
						Map<String,Object> params = new HashMap<>();
						params.put("password",value);
						params.put("optType","onComparePassword");
						DBDataSource.callOperation("EP_OnPaymentManageProcess","find", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									SC.say("提示","密码匹配错误");
								}else {
									canCheck = true;
									query();
								}
							}
						});
					}
				}

			});
			pWindow.addItem(panel);
			pWindow.show();

//			SC.askforValue("提示","您需输入正确的解锁密码方可查看数据",new ValueCallback() {
//				@Override
//				public void execute(String value) {
//					if(BaseHelpUtils.isNullOrEmpty(value)){
//						SC.say("提示","请输入正确的解锁密码");
//					}else{
//						Map<String,Object> params = new HashMap<>();
//						params.put("password",BaseHelpUtils.getString(value));
//						params.put("optType","onComparePassword");
//						DBDataSource.callOperation("EP_OnPaymentManageProcess","find", params, new DSCallback() {
//							@Override
//							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//								if (dsResponse.getStatus() < 0) {
//									SC.say("提示","密码匹配错误");
//								}else {
//									canCheck = true;
//									query();
//								}
//							}
//						});
//					}
//				}
//			});
			return;
		}else{
			query();
		}
	}
	
	public void query(){
		Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//只加载可用的数据
		criteria.put("enabled", Boolean.TRUE);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnloadEmployeePaymentMonthDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnloadEmployeePaymentMonthDetail.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

