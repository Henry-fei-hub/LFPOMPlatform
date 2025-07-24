package com.pomplatform.client.capitaldistribution.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.capitaldistribution.datasource.DSProjectCapitalDistribution;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CapitalDistributionBarChartPanel extends HLayout{
	private VLayout leftLayout;
	private VLayout rightLayout;
	private VLayout leftChartLayout;
	private VLayout rightTopLayout;
	private VLayout preDistributionLayout;
	private Chart chart;
	private IButton changeDButton;
	private HLayout capitalLayout;
	private VLayout capitalButtonLayout;
	private DelicacyListGrid capitalGrid;
	private String contractId;
//	private String blueColor = "#1aabce";
//	private String greenColor = "#8bbc21";
//	private String grayColor = "#e3e3e3";
	private Map userData;
	private boolean displatePercent = true;
	private Integer viewNo = null;//值为：本次查看的record序号+1
	private Integer thisTimeNo = null;//值为：本次回款分配的record序号+1（只有回款分配页面点了“确定”按钮保存数据之后，才会改变该值）
	private Integer tempThisTimeNo = null;//值为：本次回款分配的record序号+1（只要点击了回款分配按钮就改变该值）
	private String color1 = "#e3e3e3,#1aabce,#f60,#8bbc21,#e3e3e3,#07810B";
	private String color2 = "#e3e3e3,#1aabce,#8bbc21,#f60,#e3e3e3,#07810B";
	private DelicacyListGrid grid;
	
	public void initComponents(){
		setWidth100();
		setHeight100();
		setBorder("1px solid #e3e3e3");
		setBackgroundColor("#fff");
		
		initLeftComponents();
		
		initRightComponents();
		
		addMembers(rightLayout, leftLayout);
	}
	
	public void initLeftComponents(){
		leftLayout = new VLayout();
		leftLayout.setWidth("50%");
		leftLayout.setHeight("100%");
		leftLayout.setMembersMargin(5);
		leftLayout.setLayoutLeftMargin(5);
		leftLayout.setLayoutTopMargin(5);
		
		leftChartLayout = new VLayout();
		leftChartLayout.setWidth("100%");
		leftChartLayout.setHeight("95%");
		
		chart = new Chart();
		leftLayout.addMembers(leftChartLayout);
		
		if(displayChangeButton()){
			changeDButton = new IButton("维度切换");
			changeDButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					setDisplatePercent(!isDisplatePercent());
					refreshChart();
				}
			});
			
			IButton resetChartButton = new IButton("初始化图表");
			resetChartButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					thisTimeNo = null;
					viewNo = null;
					refreshChart();
				}
			});
			
			ToolStrip navLayout = new ToolStrip();
			navLayout.setPadding(5);
			navLayout.setHeight(40);
			navLayout.setWidth100();
			navLayout.setMembersMargin(10);
			navLayout.addFill();
			navLayout.setBorder("none");
			navLayout.addMembers(changeDButton, resetChartButton);
			
			leftLayout.addMembers(navLayout);
		}
	}
	
	public void initRightComponents(){
		rightLayout = new VLayout();
		rightLayout.setWidth("50%");
		rightLayout.setHeight("100%");
		rightTopLayout = new VLayout();
		Label capitalTitle = new Label("<font style='font-weight:bold; font-size:16px;'>回款流水</font>");
		capitalTitle.setHeight(25);
		capitalTitle.setAlign(Alignment.CENTER);
		rightTopLayout.addMember(capitalTitle);
		rightTopLayout.setWidth("100%");
		rightTopLayout.setHeight("50%");
		rightTopLayout.setBackgroundColor("#f6f6f6");
		rightTopLayout.setBorder("1px solid #ababab");
		
		capitalLayout = new HLayout();
		capitalLayout.setWidth100();
		capitalLayout.setHeight100();
		rightTopLayout.addMember(capitalLayout);
		
		capitalGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (null != record.getAttribute("locked") && record.getAttribute("locked").equals("true")) {  //定稿标灰色
					return "color:#A5A5A5;";  
                } else if(null != record.getAttribute("locked") && record.getAttribute("locked").equals("false")) { //有分配，还没锁定，正常颜色 
                	if(null != record.getAttribute("borrowMoney") && null != record.getAttribute("distributionAmount")){
                		BigDecimal borrwoMoney = new BigDecimal(record.getAttribute("borrowMoney"));
                		BigDecimal distributionAmount = new BigDecimal(record.getAttribute("distributionAmount"));
                		if(borrwoMoney.compareTo(distributionAmount) > 0){
                			//没分完回款的显示黄色
                			return "font-weight:bold; color:#F19E02;";
                		}else if(borrwoMoney.compareTo(distributionAmount) < 0){
                			//分配的金额大于回款金额，显示紫色
                			return "font-weight:bold; color:#E24BB3;";
                		}
                	}
                	return super.getCellCSSText(record, rowNum, colNum); 
                }  else{//没有分配，正常颜色，字体加粗 
                	return "font-weight:bold;";  
                }
			}
		};
		capitalGrid.setWidth("90%");
		capitalGrid.setAutoFitFieldWidths(false);
		capitalGrid.setShowRowNumbers(true);
		capitalGrid.setShowGridSummary(true);
		ListGridField[] capitalFields = new ListGridField[6];
		int capitalNo = 0;
		capitalFields[capitalNo] = new ListGridField("happenDate", "回款日期");
		capitalFields[capitalNo++].setShowGridSummary(false);
		capitalFields[capitalNo] = new ListGridField("remark", "备注");
		capitalFields[capitalNo++].setShowGridSummary(false);
		capitalFields[capitalNo] = new ListGridField("borrowMoney", "回款金额");
		capitalFields[capitalNo].setType(ListGridFieldType.FLOAT);
		capitalFields[capitalNo].setDecimalPad(2);
		capitalFields[capitalNo++].setFormat("#,###,###,###,##0.00");
		capitalFields[capitalNo] = new ListGridField("distributionAmount", "已回款金额");
		capitalFields[capitalNo].setType(ListGridFieldType.FLOAT);
		capitalFields[capitalNo].setDecimalPad(2);
		capitalFields[capitalNo++].setFormat("#,###,###,###,##0.00");
		//最近一次操作的操作人和操作时间
		capitalFields[capitalNo] = new ListGridField("operator", "操作人");
		capitalFields[capitalNo++].setValueMap(KeyValueManager.getValueMap("employees"));;
		capitalFields[capitalNo++] = new ListGridField("createTime", "操作时间");
		capitalGrid.setFields(capitalFields);
		capitalGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						viewNo = capitalGrid.getRowNum(capitalGrid.getSelectedRecord()) + 1;
						refreshChart();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		capitalLayout.addMember(capitalGrid);
		
		capitalButtonLayout = new VLayout();
		capitalButtonLayout.setWidth("10%");
		capitalButtonLayout.setHeight100();
		capitalButtonLayout.setLayoutLeftMargin(5);
		capitalButtonLayout.setLayoutRightMargin(5);
		capitalButtonLayout.setLayoutTopMargin(12);
		capitalButtonLayout.setMembersMargin(12);
		capitalLayout.addMember(capitalButtonLayout);
		
		IButton viewCapitalDistributeButton = new IButton("查看分配明细");
		capitalButtonLayout.addMember(viewCapitalDistributeButton);
		viewCapitalDistributeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!capitalGrid.anySelected()){
							SC.say("请选择一条记录");
							return;
						}
						int capitalId = ClientUtil.checkAndGetIntValue(capitalGrid.getSelectedRecords()[0].getAttribute("capitalId"));
						if(capitalId > 0){
							PopupWindow window = new PopupWindow("回款分配明细");
							window.setWidth("80%");
							window.setHeight("80%");
							PlateAndProjectCapitalDistributionPanel panel = new PlateAndProjectCapitalDistributionPanel();
							panel.initComponents();
							panel.setCapitalId(capitalId);
							panel.loadData();
							window.addMember(panel);
							window.show();
							window.centerInPage();
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton distributeButton = new IButton("回款分配");
		capitalButtonLayout.addMember(distributeButton);
		distributeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!capitalGrid.anySelected()){
							SC.say("请选择一条数据");
							return;
						}
						ListGridRecord record = capitalGrid.getSelectedRecords()[0];
						if(!displayChangeButton() && null != record.getAttribute("locked") && record.getAttribute("locked").equals("true")){
							SC.say("数据已锁定，无法分配！");
							return;
						}
						thisTimeNo = null;
						tempThisTimeNo = capitalGrid.getRowNum(record) + 1;
						Map<String, Object> condition = new HashMap<>();
						condition.put("capitalId", record.getAttribute("capitalId"));
						condition.put("deleteFlag", ClientStaticUtils.NO_DELETE);
						DBDataSource.callOperation("ST_CapitalDistribution", "find", condition, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								Record[] datas = dsResponse.getData();
								Map<String, Object> typeMap = new HashMap<>();
								for(Record dataRecord : datas){
									if(null != dataRecord.getAttribute("type")){
										typeMap.put(dataRecord.getAttribute("type"), null);
									}
								}
								if(typeMap.size() == 1 && typeMap.keySet().toArray()[0].equals("1")){
									//只分配给部门
									PopupWindow window = new PopupWindow("部门回款分配");
									window.setWidth("60%");
									window.setHeight("80%");
									PlateCapitalDistribution panel = new PlateCapitalDistribution();
									panel.setRecord(record);
									panel.initComponents();
									panel.startEdit();
									panel.addDataEditedHandler(new DataEditedHandler() {
										
										@Override
										public void onDataEdited(DataEditEvent event) {
											loadData();
										}
									});
									panel.setParent(window);
									window.addMember(panel);
									window.centerInPage();
									window.show();
								}else{
									Map<String, String> params = new HashMap<>();
									params.put("capitalId", record.getAttribute("capitalId"));
									params.put("operator", ClientUtil.getUserId());
									params.put("optType", "prepareCapitalDistributionInfo");
									DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() >= 0){
												PopupWindow window = new PopupWindow("订单回款分配");
												window.setWidth("80%");
												window.setHeight("80%");
												ProjectCapitalDistribution panel = new ProjectCapitalDistribution();
												panel.initComponents();
												panel.setParent(window);
												panel.setCapitalId(record.getAttribute("capitalId"));
												panel.setData(dsResponse.getData());
												panel.startEdit();
												panel.addDataEditedHandler(new DataEditedHandler() {
													
													@Override
													public void onDataEdited(DataEditEvent event) {
														thisTimeNo = tempThisTimeNo;
//														refreshChart();
														loadData();
													}
												});
												window.addMember(panel);
												window.centerInPage();
												window.show();
											}else{
												//只分配给部门
												PopupWindow window = new PopupWindow("部门回款分配");
												window.setWidth("60%");
												window.setHeight("80%");
												PlateCapitalDistribution panel = new PlateCapitalDistribution();
												panel.setRecord(record);
												panel.initComponents();
												panel.startEdit();
												panel.addDataEditedHandler(new DataEditedHandler() {
													
													@Override
													public void onDataEdited(DataEditEvent event) {
														loadData();
													}
												});
												panel.setParent(window);
												window.addMember(panel);
												window.centerInPage();
												window.show();
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
		
		IButton lockedButton = new IButton("回款分配锁定");
		capitalButtonLayout.addMember(lockedButton);
		lockedButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						lockOrUnlockCapitalDistribution(true);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton unlockedButton = new IButton("回款分配解锁");
		capitalButtonLayout.addMember(unlockedButton);
		unlockedButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						lockOrUnlockCapitalDistribution(false);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton deleteButton = new IButton("删除回款分配");
		capitalButtonLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!capitalGrid.anySelected()){
							SC.say("请选择需要删除回款分配的记录");
							return;
						}
						SC.ask("确定要删除这些数据吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Map<String, String> params = new HashMap<>();
									Record[] records = capitalGrid.getSelectedRecords();
									StringBuilder sb = new StringBuilder();
									if(!displayChangeButton()){
										for(Record record : records){
											if(null != record.getAttribute("locked") && record.getAttribute("locked").equals("true")){
												SC.say("您想删除的数据中，包含了已锁定的数据，无法删除！");
												return;
											}
											if(sb.length() > 0){
												sb.append(",");
											}
											sb.append(record.getAttribute("capitalId"));
										}
									}else{
										for(Record record : records){
											if(sb.length() > 0){
												sb.append(",");
											}
											sb.append(record.getAttribute("capitalId"));
										}
									}
									params.put("ids", sb.toString());
									params.put("optType", "deleteCapitalDistribution");
									params.put("operator", ClientUtil.getUserName());
									params.put("operatorId", ClientUtil.getUserId());
									DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											String msg = "";
											if(dsResponse.getStatus() == 0){
												msg = "删除失败！";
											}else{
												msg = "删除成功！";
											}
											SC.say(msg + dsResponse.getErrors().get("errorMsg"));
											loadData();
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

		IButton autoFitButton = new IButton("确认积分分配");
		capitalButtonLayout.addMember(autoFitButton);
		autoFitButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!capitalGrid.anySelected()){
							SC.say("请选择需要按订单确认积分自动分配的回款记录");
							return;
						}
						Record[] records = capitalGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						int month = records[0].getAttributeAsDate("happenDate").getMonth();
						for(Record record : records){
							if(record.getAttributeAsDate("happenDate").getMonth() != month){
								SC.say("只能选择同一个月份的回款记录进行自动分配操作");
								return;
							}
							if(sb.length() > 0){
								sb.append(",");
							}
							sb.append(record.getAttribute("capitalId"));
						}
						PopupWindow window = new PopupWindow("请选择该回款对应的确认函");
						window.setWidth("50%");
						window.setHeight("50%");
						SelectContractAttachmentPanel panel = new SelectContractAttachmentPanel(sb.toString());
						panel.setParentWindow(window);
						panel.setContractId(records[0].getAttribute("contractId"));
						panel.loadData();
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								loadData();
							}
						});
						window.addMember(panel);
						window.show();
						window.centerInPage();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton sheetAmountButton = new IButton("合同金额分配");
		capitalButtonLayout.addMember(sheetAmountButton);
		sheetAmountButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!capitalGrid.anySelected()){
							SC.say("请选择需要按合同金额自动分配的回款记录");
							return;
						}
						Record[] records = capitalGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						for(Record record : records){
							if(sb.length() > 0){
								sb.append(",");
							}
							sb.append(record.getAttribute("capitalId"));
						}
						PopupWindow window = new PopupWindow("请选择该回款对应的订单");
						window.setWidth("80%");
						window.setHeight("60%");
						SelectProjectPanel panel = new SelectProjectPanel(sb.toString());
						panel.setParentWindow(window);
						panel.setContractId(records[0].getAttribute("contractId"));
						panel.loadData();
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								loadData();
							}
						});
						window.addMember(panel);
						window.show();
						window.centerInPage();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		grid = new DelicacyListGrid();
		grid.setShowRowNumbers(true);
		grid.setDataSource(DSProjectCapitalDistribution.getInstance());
		
		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("code");
		fields[idx].setMinWidth(220);
		fields[idx++].setShowGridSummary(false);
		fields[idx++] = new ListGridField("sheetAmount");//订单合同金额
		fields[idx++] = new ListGridField("distributedAmount");//已分配金额
		fields[idx++] = new ListGridField("leftAmount");//剩余可分配积分
		fields[idx++] = new ListGridField("projectIntegral");//订单积分
		fields[idx++] = new ListGridField("sureIntegral");//确认积分
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setAutoFitFieldWidths(false);
		
		preDistributionLayout = new VLayout();
		preDistributionLayout.setWidth("100%");
		preDistributionLayout.setHeight("50%");
		preDistributionLayout.setBorder("1px solid #ababab; border-top:none");
		preDistributionLayout.setBackgroundColor("#f6f6f6");
		Label prelTitle = new Label("<font style='font-weight:bold; font-size:16px;'>预分配</font>");
		prelTitle.setHeight(25);
		prelTitle.setAlign(Alignment.CENTER);
		preDistributionLayout.addMember(prelTitle);
		preDistributionLayout.addMember(grid);
		
		rightLayout.addMembers(rightTopLayout, preDistributionLayout);
		
		if(!displayChangeButton()){
			unlockedButton.hide();
		}
	}
	
	public void loadData(){
		Map<String, String> params = new HashMap<>();
		params.put("contractId", contractId);
		DBDataSource.callOperation("NQ_SimpleCapitalList", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				capitalGrid.setData(dsResponse.getData());
			}
		});
		params.put("optType", "getAllDistribution");
		DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				grid.setData(dsResponse.getData());
			}
		});
		refreshChart();
	}

	/**
	 * 
	 * @param viewNo	选中查看的回款记录的序号+1
	 */
	public void refreshChart(){
		Map<String, Object> params = new HashMap<>();
		params.put("contractId", contractId);
		params.put("optType", "loadCapitalDistributionOfProject");
		DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				userData = dsResponse.getAttributeAsMap("userData");
				if(null != userData){
					String[] projectIds = userData.get("projectId").toString().split(",");
					StringBuilder sb = new StringBuilder();
					//获取Y轴的数据，第一行订单编号，第二行是项目类型和业务类型，第三行是业务部门
					for(String key : projectIds){
						if(sb.length() > 0){
							sb.append(",");
						}
//						String code = KeyValueManager.getValue("project_code", key);
						String code = SyncDataUtil.getContractCode(BaseHelpUtils.getIntValue(key));
						String tempCode = code.substring(code.lastIndexOf(".") + 1);
						String[] codeArr = tempCode.split("-");
						if(codeArr.length >= 3){
							Integer num = null;
							for(int i = 0; i < codeArr.length; i++){
								if(codeArr[i].length() == 2){
									num = i;
									break;
								}
							}
							if(null != num){
								code = code + "<br>" + codeArr[num] + "：" + KeyValueManager.getValue("production_value_coefficient_type", ClientUtil.checkAndGetIntValue(codeArr[num]) + "");
								code = code + "　" + codeArr[num + 1] + "：" + KeyValueManager.getValue("system_dictionary_32", ClientUtil.checkAndGetIntValue(codeArr[num + 1]) + "");
								tempCode = codeArr[codeArr.length - 1].split("/")[0];
								code = code + "<br>" + tempCode + "：" + KeyValueManager.getValue("system_dictionary_34", tempCode);
							}
						}
						sb.append(code);
					}
					chart.removeFromParent();
					chart = new Chart()
							.setType(Series.Type.BAR)
							.setChartTitleText("回款明细")
							.setLegend(new Legend().setBackgroundColor("#fff").setReversed(true))
							.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
								public String format(ToolTipData toolTipData) {
									return toolTipData.getSeriesName() + ": " + toolTipData.getYAsDouble() + " ("
											+ Math.round(toolTipData.getPercentage() * 100) / 100.0 + "%)";
								}
							}));
					if(isDisplatePercent()){
						chart.setSeriesPlotOptions(new SeriesPlotOptions().setStacking(PlotOptions.Stacking.PERCENT));
						chart.getYAxis()
			            .setMin(0)
			            .setAxisTitleText("百分比");
					}else{
						chart.setSeriesPlotOptions(new SeriesPlotOptions().setStacking(PlotOptions.Stacking.NORMAL));
						chart.getYAxis()
			            .setMin(0)
			            .setAxisTitleText("金额/元");
					}
					chart.setBackgroundColor("#fff");
					chart.setSpacingRight(50);
					chart.setWidth100();
					chart.setHeight100();
					chart.getXAxis().setCategories(sb.toString().split(","));
					
					int capitalAmount = ClientUtil.checkAndGetIntValue(userData.get("capitalAmount"));
					int length = userData.get("0").toString().replace("[", "").replace("]", "").split(",").length;
					Number[] historyArr = new Number[length];
					Number[] leftMoneyArr = new Number[length];
					Number[] checkArr = new Number[length];
					Number[] thisTimeArr = new Number[length];
					for(int i = 0; i <= capitalAmount; i++){
						String[] arrString = userData.get(i+"").toString().replace("[", "").replace("]", "").split(",");
						if(i == 0){
							for(int no = 0; no < length; no++){
								leftMoneyArr[no] = ClientUtil.checkAndGetDoubleValue(arrString[no]);
							}
						}else{
							if(null != thisTimeNo && thisTimeNo.intValue() == i){
								//本次回款分配的数据
								for(int no = 0; no < length; no++){
									if(null == thisTimeArr[no]){
										thisTimeArr[no] = ClientUtil.checkAndGetDoubleValue(arrString[no]);
									}else{
										thisTimeArr[no] = ClientUtil.checkAndGetDoubleValue(thisTimeArr[no]) + ClientUtil.checkAndGetDoubleValue(arrString[no]);
									}
								}
							}else if(null != viewNo && viewNo.intValue() == i){
								//本次查看的数据
								for(int no = 0; no < length; no++){
									if(null == checkArr[no]){
										checkArr[no] = ClientUtil.checkAndGetDoubleValue(arrString[no]);
									}else{
										checkArr[no] = ClientUtil.checkAndGetDoubleValue(checkArr[no]) + ClientUtil.checkAndGetDoubleValue(arrString[no]);
									}
								}
							}else{
								for(int no = 0; no < length; no++){
									if(null == historyArr[no]){
										historyArr[no] = ClientUtil.checkAndGetDoubleValue(arrString[no]);
									}else{
										historyArr[no] = ClientUtil.checkAndGetDoubleValue(historyArr[no]) + ClientUtil.checkAndGetDoubleValue(arrString[no]);
									}
								}
							}
						}
					}
					chart.addSeries(chart.createSeries()  
			        		.setName("待回款")  
			        		.setPoints(leftMoneyArr)  
			        		.setStack("kk")  
			        		); 
					chart.addSeries(chart.createSeries()  
			        		.setName("本次回款")  
			        		.setPoints(thisTimeArr)  
			        		.setStack("kk")  
			        		); 
					if(null != viewNo && viewNo.intValue() == capitalGrid.getRecords().length){
						chart.addSeries(chart.createSeries()  
								.setName("历史回款")  
								.setPoints(historyArr)  
								.setStack("kk")  
								); 
						chart.addSeries(chart.createSeries()  
								.setName("查看的回款")  
								.setPoints(checkArr)  
								.setStack("kk")  
								); 
						chart.setColors(color2.split(","));
					}else{
						chart.addSeries(chart.createSeries()  
								.setName("查看的回款")  
								.setPoints(checkArr)  
								.setStack("kk")  
								); 
						chart.addSeries(chart.createSeries()  
								.setName("历史回款")  
								.setPoints(historyArr)  
								.setStack("kk")  
								); 
						chart.setColors(color1.split(","));
					}
					String[] leftArrString = userData.get("leftIntegral").toString().replace("[", "").replace("]", "").split(",");
					Number[] leftArr = new Number[length];
					for(int no = 0; no < length; no++){
						leftArr[no] = ClientUtil.checkAndGetDoubleValue(leftArrString[no]);
					}
					chart.addSeries(chart.createSeries()  
			        		.setName("剩余积分")  
			        		.setPoints(leftArr)  
			        		.setStack("kkk")  
			        		); 
					String[] sureArrString = userData.get("sureIntegral").toString().replace("[", "").replace("]", "").split(",");
					length = sureArrString.length;
					Number[] sureArr = new Number[length];
					for(int no = 0; no < length; no++){
						sureArr[no] = ClientUtil.checkAndGetDoubleValue(sureArrString[no]);
					}
					chart.addSeries(chart.createSeries()  
			        		.setName("确认积分")  
			        		.setPoints(sureArr)  
			        		.setStack("kkk")  
			        		); 
					for(Canvas obj : leftChartLayout.getMembers()){
						obj.destroy();
					}
					leftChartLayout.addMember(chart);
				}
			}
		});
	}
	
	public void lockOrUnlockCapitalDistribution(boolean locked){
		if(!capitalGrid.anySelected()){
			SC.say("请选择需要锁定的数据");
			return;
		}
		Record[] records = capitalGrid.getSelectedRecords();
		StringBuilder sb = new StringBuilder();
		for(Record record : records){
			if(null != record.getAttribute("capitalId")){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(record.getAttribute("capitalId"));
			}
		}
		Map<String, Object> params = new HashMap<>();
		params.put("capitalId", sb.toString());
		params.put("locked", locked);
		params.put("optType", "lockOrUnlockCapitalDistribution");
		DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(Record record : records){
						record.setAttribute("locked", locked);
					}
					capitalGrid.redraw();
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public boolean isDisplatePercent() {
		return displatePercent;
	}

	public void setDisplatePercent(boolean displatePercent) {
		this.displatePercent = displatePercent;
	}
	
	/**
	 * 只有财务部和信息化中心才显示维度切换的按钮
	 * @return
	 */
	public boolean displayChangeButton(){
		int plateId = ClientUtil.getPlateId();
		if(plateId == ClientStaticUtils.PLATE_ID_19 || plateId == ClientStaticUtils.PLATE_ID_23 || plateId == ClientStaticUtils.PLATE_ID_17){
			return true;
		}
		return false;
	}

	private static final Logger logger = Logger.getLogger("");
}
