package com.pomplatform.client.revenue.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.revenue.datasource.DSRevenueStatisticalOfRevenue;
import com.pomplatform.client.revenue.form.RevenueStatisticalOfRevenueSearchForm;
import com.pomplatform.client.revenue.form.RevenueStatisticalOfRevenueViewer;
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
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class RevenueStatisticalOfRevenuePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RevenueStatisticalOfRevenuePanel cm = new RevenueStatisticalOfRevenuePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RevenueStatisticalOfRevenue";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		//如果有修改保存的权限，则设置为可编辑，否则不可编辑
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_STATISTICAL_UPDATEORSAVE)) {
			resultGrid.setCanEdit(true);
		}else{
			resultGrid.setCanEdit(false);
		}
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowFilterEditor(false);
		resultGrid.setShowGridSummary(true);
		
		ListGridField[] fields = new ListGridField[35];
		int idx = 0;
		fields[idx] = new ListGridField("projectId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("sheetCode");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("sheetName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setHidden(true);
		fields[idx].setShowGridSummary(false);
		idx ++;
		
		fields[idx] = new ListGridField("year");
		fields[idx].setHidden(false);
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("month");
		fields[idx].setHidden(false);
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		
		fields[idx] = new ListGridField("totalIntegral");
		fields[idx].setHidden(true);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("sheetAmount");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("contractAmount");
		fields[idx].setHidden(true);
		fields[idx].setShowGridSummary(false);
		idx ++;
		
		fields[idx] = new ListGridField("ratePercent");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		
		fields[idx] = new ListGridField("ratePercentStr");
		fields[idx].setHidden(false);
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		
		fields[idx] = new ListGridField("sheetPercent");
		fields[idx].setHidden(true);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("sheetPercentStr");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("modifyPercent");
		fields[idx].setHidden(true);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("modifyPercentStr");
		fields[idx].setHidden(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("totalPercent");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("totalPercentStr");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("totalTaxRevenue");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("totalRevenue");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("currentRevenue");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("lastMonthRevenue");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("revenueStatisticalRecordId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("totalSurePercentStr");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("totalSureRevenue");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("contractSave");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("contractSaveActive");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("contractSaveActiveUn");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("contractSaveActivePause");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("contractSaveActiveNever");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("contractSaveOther");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx ++;
		fields[idx] = new ListGridField("status","项目状态");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
		idx ++;
		fields[idx] = new ListGridField("projectManageId");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("flag");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx ++;
		fields[idx] = new ListGridField("projectIntegral");
		fields[idx].setHidden(true);
		idx ++;
		resultGrid.setFields(fields);
		resultGrid.setFilterOnKeypress(true);
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				ListGridRecord record = resultGrid.getRecord(event.getRowNum());
                String modifyPercentStr = (String)event.getNewValues().get("modifyPercentStr");
                //检索是否有百分号
                int len = modifyPercentStr.indexOf("%");
                if(len > 0){//说明是合法的百分比格式
                	BigDecimal modifyPercent = BaseHelpUtils.getBigDecimalValue(modifyPercentStr.substring(0,len));
                	modifyPercent = modifyPercent.divide(new BigDecimal(Double.toString(100)));
                	record.setAttribute("modifyPercent", modifyPercent);
                	record.setAttribute("totalPercent", modifyPercent);
                	record.setAttribute("totalPercentStr", modifyPercentStr);
                	//获取税率
                	BigDecimal ratePercent = BaseHelpUtils.getBigDecimalValue(record.getAttribute("ratePercent"));
                	//获取上月累计营收
                	BigDecimal lastMonthRevenue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("lastMonthRevenue"));
                	//获取订单金额
                	BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("sheetAmount"));
                	//设置累计含税营收，即订单金额*累计百分比
                	record.setAttribute("totalTaxRevenue",BaseHelpUtils.format(sheetAmount.multiply(modifyPercent),2));
                	//设置累计营收(不含税营收)，即累计含税营收/税率
                	BigDecimal totalRevenue = sheetAmount.multiply(modifyPercent).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
                	record.setAttribute("totalRevenue", totalRevenue);
                	//设置本月营收，即当月累计营收-上月累计营收
                	record.setAttribute("currentRevenue",totalRevenue.subtract(lastMonthRevenue));
                }else{
                	SC.say("提示","请输入标准的百分比格式,如(50.00%)");
                	return;
                }
                ListGridRecord[] records = new ListGridRecord[1];
                records[0] = record;
                onSaveOrUpdate(records);
			}
		});

		IButton saveButton = PermissionControl.createPermissionButton("保存",
				ERPPermissionStatic.REVENUE_STATISTICAL_UPDATEORSAVE);
		controlLayout.addMember(saveButton);
		saveButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				onSaveOrUpdate(resultGrid.getRecords());
			}
		});
		
		IButton lockButton = PermissionControl.createPermissionButton("加锁",ERPPermissionStatic.REVENUE_STATISTICAL_LOCK);
		controlLayout.addMember(lockButton);
		lockButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> params = new HashMap<>();
				//获取当前操作人
				int operateEmployeeId = ClientUtil.getEmployeeId();
				//获取年月份
				@SuppressWarnings("unchecked")
				Map<Object,Object> values = searchForm.getValues();;
				int year = BaseHelpUtils.getIntValue(values.get("year"));
				int month = BaseHelpUtils.getIntValue(values.get("month"));
				//如果当前年月份为空的话，则不允许提交
				if(year == 0 || month == 0){
					SC.say("提示","年月份不可为空,请选择年月份");
					return;
				}
		        params.put("optType", "onRevenueStatisticalLock");
		        params.put("operateEmployeeId", operateEmployeeId);
		        params.put("year", year);
		        params.put("month", month);
		        final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
		            @SuppressWarnings("rawtypes")
					@Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	loading.destroy();
		                if (dsResponse.getStatus() >= 0) {
		                    SC.say("保存成功");
		                    commonQuery();
		                } else {
		                    Map errors = dsResponse.getErrors();
		                    SC.say("保存失败" + errors.get("errorMsg"));
		                }
		            }
		        });
			}
		});
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_RevenueStatisticalOfRevenue", condition);
			}
		});
		
		IButton breakButton = PermissionControl.createPermissionButton("拆分订单",ERPPermissionStatic.REVENUE_STATISTICAL_BREAK_SHEET);
		controlLayout.addMember(breakButton);
		breakButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				Record record = selected[0];
				String sheetName = BaseHelpUtils.getString(record.getAttribute("sheetName"));
				PopupWindow pw = new PopupWindow();
				RevenueDesignPanel panel = new RevenueDesignPanel();
				pw.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						pw.destroy();
						commonQuery();
					}
				});
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				pw.addItem(panel);
				panel.setRecord(record);
				panel.initComponents();
				panel.setParentWindow(pw);
				pw.setTitle("订单(" + sheetName + ")拆分");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton checkUndoButton = new IButton("查看未保存");
		controlLayout.addMember(checkUndoButton);
		checkUndoButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = new HashMap();
		        if (searchForm != null) {
		            Map values = searchForm.getValues();
		            condition.putAll(values);
		        }
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
		                	Record[] selected = dsResponse.getData();
		    				if(selected != null && selected.length > 0){
		    					//定义map来存放
		    					Map<Integer,Record> map = new HashMap<>();
		    					for(Record e : selected){
		    						//获取flag
		    						int flag = BaseHelpUtils.getIntValue(e.getAttribute("flag"));
		    						//获取项目ID
		    						int projectId = BaseHelpUtils.getIntValue(e.getAttribute("projectId"));
		    						if(flag == 2){//说明是未保存的
		    							map.put(projectId,e);
		    						}
		    					}
		    					Record[] datas = new Record[map.size()];
		    					int i = 0;
		    					for(Record e : map.values()){
		    						datas[i] = e;
		    						i++;
		    					}
		    					resultGrid.setData(datas);
		    					resultGrid.redraw();
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
		});
		
		IButton checkDoButton = new IButton("查看已保存");
		controlLayout.addMember(checkDoButton);
		checkDoButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = new HashMap();
		        if (searchForm != null) {
		            Map values = searchForm.getValues();
		            condition.putAll(values);
		        }
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
		                	Record[] selected = dsResponse.getData();
		    				if(selected != null && selected.length > 0){
		    					//定义map来存放
		    					Map<Integer,Record> map = new HashMap<>();
		    					for(Record e : selected){
		    						//获取flag
		    						int flag = BaseHelpUtils.getIntValue(e.getAttribute("flag"));
		    						//获取项目ID
		    						int projectId = BaseHelpUtils.getIntValue(e.getAttribute("projectId"));
		    						if(flag == 1){//说明是已保存的
		    							map.put(projectId,e);
		    						}
		    					}
		    					Record[] datas = new Record[map.size()];
		    					int i = 0;
		    					for(Record e : map.values()){
		    						datas[i] = e;
		    						i++;
		    					}
		    					resultGrid.setData(datas);
		    					resultGrid.redraw();
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
		});
		
		IButton checkButton = new IButton("查看年度营收");
		controlLayout.addMember(checkButton);
		checkButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
				// 获取项目名称
//				String projectName = KeyValueManager.getValue("projects", projectId + "");
				String projectName = SyncDataUtil.getProjectName(projectId);
				PopupWindow pw = new PopupWindow();
				RevenueYearStatisticalOfRevenuePanel panel = new RevenueYearStatisticalOfRevenuePanel();
				panel.setProjectId(projectId);
				panel.commonQuery();
				pw.addItem(panel);
				pw.setTitle("项目(" + projectName + ")的年度营收表");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		IButton saleIntegralButton = PermissionControl.createPermissionButton("提取销售积分",ERPPermissionStatic.REVENUE_STATISTICAL_SALE_INTEGRAL);
		controlLayout.addMember(saleIntegralButton);
		saleIntegralButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				//获取年月份
				@SuppressWarnings("unchecked")
				Map<Object,Object> values = searchForm.getValues();;
				int year = BaseHelpUtils.getIntValue(values.get("year"));
				int month = BaseHelpUtils.getIntValue(values.get("month"));
				//如果当前年月份为空的话，则不允许提交
				if(year == 0 || month == 0){
					SC.say("提示","年月份不可为空,请选择年月份");
					return;
				}
				//检索当前年月份的数据是否已经提取过，如果已经提取过，则不可再进行提取
				Map<String,Object> params = new HashMap<>();
				params.put("year",year);
				params.put("month",month);
				DBDataSource.callOperation("ST_SaleIntegralRecord","find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if(records.length > 0){//说明当前年月数据已经提取过，不可再进行提取
								SC.say("提示","当前年月份的营收金额已经提取过,不可重复进行提取");
							}else{
								final PopupWindow popupWindow = new PopupWindow("销售积分提取");
								popupWindow.setWidth("60%");
								popupWindow.setHeight("70%");
								popupWindow.centerInPage();
								PlateSaleIntegralPanel saleIntegral = new PlateSaleIntegralPanel();
								saleIntegral.initComponents(year,month);
								popupWindow.addItem(saleIntegral);
								popupWindow.addCloseClickHandler(new CloseClickHandler() {
									@Override
									public void onCloseClick(CloseClickEvent event) {
										popupWindow.destroy();
									}
								});
								saleIntegral.addDataEditedHandler(new DataEditedHandler() {
									@Override
									public void onDataEdited(DataEditEvent event) {
										popupWindow.destroy();
										SC.say("提示","提取成功");
									}
								});
								saleIntegral.setParentWindow(popupWindow);
								popupWindow.centerInPage();
								popupWindow.show();
							}
						}
					}
				});
			}
		});
		commonQuery();
	}
	
	public void onSaveOrUpdate(ListGridRecord[] records){
		Map<Object,Object> params = new HashMap<>();
		//获取当前操作人
		int operateEmployeeId = ClientUtil.getEmployeeId();
		//获取年月份
		@SuppressWarnings("unchecked")
		Map<Object,Object> values = searchForm.getValues();;
		int year = BaseHelpUtils.getIntValue(values.get("year"));
		int month = BaseHelpUtils.getIntValue(values.get("month"));
		//如果当前年月份为空的话，则不允许提交
		if(year == 0 || month == 0){
			SC.say("提示","年月份不可为空,请选择年月份");
			return;
		}
        params.put("operateEmployeeId", operateEmployeeId);
        params.put("year", year);
        params.put("month", month);
        MapUtils.convertRecordToMap(resultGrid.getDataSource(),records, params, "revenueStatisticalList");
        final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_OnRevenueStatisticalProcess", params, new DSCallback() {
            @SuppressWarnings("rawtypes")
			@Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (dsResponse.getStatus() >= 0) {
                    SC.say("保存成功");
                    commonQuery();
                } else {
                    Map errors = dsResponse.getErrors();
                    SC.say("保存失败" + errors.get("errorMsg"));
                }
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
				detail.setTitle("营收统计"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				RevenueStatisticalOfRevenueViewer detailForm = new RevenueStatisticalOfRevenueViewer();
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
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data) && data.length > 0){
			for(Record e : data){
				//获取是否加锁
				boolean isLocked = e.getAttributeAsBoolean("isLocked");
				if(isLocked){//如果已发放，则设置为不可用，即不可以进行修改
					e.setAttribute("enabled", false);
				}
			}
		}
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		int year = BaseHelpUtils.getIntValue(criteria.get("year"));
		if(year == 0){
			Date d = new Date();
			DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
			DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
			year = BaseHelpUtils.getIntValue(dfYear.format(d));
			int month = BaseHelpUtils.getIntValue(dfMonth.format(d));
			criteria.put("year",year);
			criteria.put("month",month + 1);
		}
		//如果没有查看所有部门和自己管理部门的数据权限，则只能查看自己管理订单的权限
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_STATISTICAL_CHECK_ALL_DATA) && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_STATISTICAL_CHECK_MYSELF_DATA)) {
			criteria.put("projectManageId",ClientUtil.getEmployeeId());
		}
		criteria.put("addtionalCondition", "order by project_id");
		__LOGGER.info("day -------------------"+criteria);
		return true;
	}
	

	@Override
	public SearchForm generateSearchForm() {
		return new RevenueStatisticalOfRevenueSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRevenueStatisticalOfRevenue.getInstance();
	}

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}

}

