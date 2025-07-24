package com.pomplatform.client.project.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.settlement.datasource.DSOnLoadProjectEmployeePerformance;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class ProjectPerformanceSettlementPanel extends Window {
    private final Logger __logger = Logger.getLogger("");
    private IButton resertSureIntegral = null;
    private IButton settlement = null;
    private IButton setProjectCost = null;
    private DynamicForm __form = null;
    private TextItem sheetCodeItem = null;
    private TextItem sheetNameItem = null;
    private TextItem performanceTypeItem = null;
    private TextItem integralItem = null;
    private TextItem leftIntegralItem = null;
    private DateItem recordDateItem =null;
    private TextAreaItem remarkItem = null;
    public ProjectPerformanceSettlementPanel() {
    }

    public void initComponents() {
        VLayout global = new VLayout();
        addItem(global);
        global.setWidth100();
        global.setHeight100();
        __form = new DynamicForm();
        __form.setNumCols(6);
        __form.setWidth100();
        __form.setHeight("20%");
        global.addMember(__form);
        
        sheetCodeItem = new TextItem("订单编号");
        sheetCodeItem.setDisabled(true);
        sheetCodeItem.setDefaultValue(sheetCodeValue);
        sheetCodeItem.setWidth("*");
        
        sheetNameItem = new TextItem("订单名称");
        sheetNameItem.setDisabled(true);
        sheetNameItem.setDefaultValue(sheetNameValue);
        sheetNameItem.setWidth("*");
        
        performanceTypeItem = new TextItem("绩效类型");
        performanceTypeItem.setDisabled(true);
        performanceTypeItem.setWidth("*");
        
        integralItem = new TextItem("绩效积分");
        integralItem.setStartRow(true);
        integralItem.setDisabled(true);
        integralItem.setWidth("*");
        
        leftIntegralItem = new TextItem("剩余绩效积分");
        leftIntegralItem.setDisabled(true);
        leftIntegralItem.setWidth("*");
        
        recordDateItem = new DateItem("日期");
        recordDateItem.setDisabled(true);
        recordDateItem.setWidth("*");
        recordDateItem.setDefaultValue(new Date());
        recordDateItem.setUseTextField(true);
        
        remarkItem = new TextAreaItem("备注");
        remarkItem.setWidth("*");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(4);
        
        __form.setFields(sheetCodeItem,sheetNameItem,performanceTypeItem,integralItem,leftIntegralItem,recordDateItem,remarkItem);
        
        grid.setAutoFitFieldWidths(false);
        grid.setHeight("70%");
        grid.setShowRowNumbers(true);
        grid.setDataSource(DSOnLoadProjectEmployeePerformance.getInstance());
        grid.setCanRemoveRecords(false);
        grid.setCanEdit(false);
        global.addMember(grid);
        
        grid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				Record record = event.getRecord();
				int colNum = event.getColNum();
				if(colNum == 4){//表示是确认积分的输入
					SC.askforValue("提示","请输入本次确认的积分",new ValueCallback() {
						@Override
						public void execute(String value) {
							if(BaseHelpUtils.isNullOrEmpty(value)){
								return;
							}
							//获取改变前的数据
							BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
							//获取新输入的数据
							BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value);
							if(newValue.compareTo(BigDecimal.ZERO) < 0){
								SC.say("提示","结算的绩效积分不可为负数");
		                    	return;
							}
							//设置改变后的最终值
							BigDecimal finalValue = newValue.subtract(oldValue);
							//获取剩余积分
		                    BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
		                    //判断剩余积分是否够分配，如果不够分配则提示不可分配过多积分
		                    if(leftIntegral.compareTo(finalValue) < 0){//说明不够分配
		                    	SC.say("提示","当前绩效积分分配过多,已超出剩余可分配的积分,当前最多可分配积分("+leftIntegral+")");
		                    	return;
		                    }
		                    record.setAttribute("integral",newValue);
							grid.updateData(record);
							leftIntegralItem.setValue(leftIntegral.subtract(finalValue));
						}
					});
				}
			}
		});
        ToolStrip controlLayout = new ToolStrip();
        controlLayout.setHeight("10%");
        global.addMember(controlLayout);
        controlLayout.addFill();
        resertSureIntegral = new IButton("重置积分");
        resertSureIntegral.setAutoFit(true);
        resertSureIntegral.setWidth(100);
        controlLayout.addMember(resertSureIntegral);
        controlLayout.addSpacer(10);
        resertSureIntegral.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确定要重置绩效积分吗?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if(value){
                            ListGridRecord[] records = grid.getRecords();
                            if (records == null || records.length == 0) {
                                return;
                            }else{
                                for(ListGridRecord record : records){
                                    record.setAttribute("integral", 0);
                                }
                                grid.setData(records);
                                //重置剩余积分
                                leftIntegralItem.setValue(performanceIntegral);
                            }
                        }
                    }
                });
            }
        });
        setProjectCost = new IButton("按比例分配");
        setProjectCost.setAutoFit(true);
        setProjectCost.setWidth(100);
        controlLayout.addMember(setProjectCost);
        controlLayout.addSpacer(10);
        setProjectCost.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确定要按比例结算绩效积分吗?",new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if(value){
                            //获取未结算的绩效积分小于或等于0,则不可进行结算
                            if(performanceIntegral.compareTo(BigDecimal.ZERO) <= 0){
                                SC.say("提示","没有需要结算的绩效积分");
                                return;
                            }else{
                                //获取项目成员的确认积分
                                ListGridRecord[] records = grid.getRecords();
                                if (records == null || records.length == 0) {
                                    return;
                                }else{
                                	//历史确认总积分
                                	BigDecimal totalSureIntegral = BigDecimal.ZERO;
                                	int len = 0;
                                	for(Record e : records){
                                		int status = BaseHelpUtils.getIntValue(e.getAttribute("status"));
                                		if(status == 0){
                                			totalSureIntegral = totalSureIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("totalSureIntegral")));
                                			len++;
                                		}
                                	}
                                	int i = 1;
                                	BigDecimal totalIntegral = BigDecimal.ZERO;
                                	for(Record e : records){
                                		BigDecimal sureIntegral =BaseHelpUtils.getBigDecimalValue(e.getAttribute("totalSureIntegral"));
                                		BigDecimal integral = BigDecimal.ZERO;
                                		int status = BaseHelpUtils.getIntValue(e.getAttribute("status"));
                                		if(status == 0){
                                			if(i == len){//说明是最后一个人
                                				integral = BaseHelpUtils.format(performanceIntegral.subtract(totalIntegral),2);
                                			}else{
                                				if(sureIntegral.compareTo(BigDecimal.ZERO) != 0 && totalSureIntegral.compareTo(BigDecimal.ZERO) != 0){
                                					integral = sureIntegral.multiply(performanceIntegral).divide(totalSureIntegral,2, BigDecimal.ROUND_DOWN);
                                					totalIntegral = totalIntegral.add(integral);
                                				}
                                				i++;
                                			}
                                			e.setAttribute("integral",integral);
                                		}
                                	}
                                    //分摊后，设置为分配的项目成本为0,并更新grid
                                    grid.setData(records);
                                    leftIntegralItem.setValue(0);
                                }
                            }
                        }
                    }
                });
            }
        });
        settlement = new IButton("结算");
        settlement.setAutoFit(true);
        settlement.setWidth(100);
        controlLayout.addMember(settlement);
        controlLayout.addSpacer(10);
        IButton cancel = new IButton("退出");
        cancel.setAutoFit(true);
        cancel.setWidth(100);
        controlLayout.addMember(cancel);
        cancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                destroy();
            }

        });
        settlement.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确认要进行结算操作吗?", new BooleanCallback() {
					@Override
                    public void execute(Boolean value) {
                        if(value){
                            if (getProjectId() == 0) {
                                SC.say("没有要结算的项目");
                                return;
                            }
                            final Map<String,Object> params = new HashMap<>();
                            params.put("projectId", projectId);
                            params.put("performanceFlag", performanceFlag);
                            params.put("projectPerformanceId", projectPerformanceId);
                            String remark = BaseHelpUtils.getString(remarkItem.getValue());
                            params.put("remark", remark);
                            params.put("operateEmployeeId", ClientUtil.getEmployeeId());
                            if(projectPerformanceId == 0){
                            	SC.say("提示","没有可结算的绩效积分");
                                return;
                            }
                            //判断这这一次提交是否有分配确认积分或分摊成本
                            Record[] records = grid.getRecords();
                            BigDecimal totalIntegral = BigDecimal.ZERO;
                            for(Record e:records){
                            	BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("integral"));
                            	totalIntegral = totalIntegral.add(integral);
                            }
                            //获取剩余积分
                            BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
                            if(leftIntegral.compareTo(BigDecimal.ZERO) != 0){
                            	SC.say("提示","绩效积分分配有误,您还有剩余的绩效积分未分配");
                                return;
                            }
                            if(totalIntegral.compareTo(performanceIntegral) != 0){
                            	SC.say("提示","绩效积分分配有误,分配到成员积分不等于总分配积分");
                                return;
                            }
                            params.put("optType", "onSaveProjectPerformance");
                            MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "projectPerformanceEmployees");
                            DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
                                @Override
                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                    if (dsResponse.getStatus() >= 0) {
                                    	closeWindow();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }

	private void closeWindow() {
        this.destroy();
    }

    public void load() {
        if (projectId == 0) {
            return;
        }
        Map<String,Object> params = new HashMap<>();
        params.put("projectPerformanceId", projectPerformanceId);
        DBDataSource.callOperation("ST_ProjectPerformance","find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
                	Record record = dsResponse.getData()[0];
                	//获取积分
                	BigDecimal integral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
                	//获取绩效类型:1:扣除;2:奖励
                	performanceFlag = BaseHelpUtils.getIntValue(record.getAttribute("performanceFlag"));
                	if(performanceFlag == 1){//说明是绩效扣除
                		performanceTypeItem.setValue("绩效扣除");
                	}else if(performanceFlag == 2){//说明是绩效奖励
                		performanceTypeItem.setValue("绩效奖励");
                	}
                	integralItem.setValue(integral);
                	leftIntegralItem.setValue(integral);
                	performanceIntegral = integral;
                }
            }
        });
        
        //加载项目成员信息
        params.put("projectId", projectId);
        params.put("performanceFlag", performanceFlag);
        DBDataSource.callOperation("NQ_OnLoadProjectEmployeePerformance","find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
                	Record[] record = dsResponse.getData();
                	grid.setData(record);
                }
            }

        });
    }

    private final DelicacyListGrid grid = new DelicacyListGrid(true);
    private Window parentWindow;
    private int projectId = 0;
    private int performanceFlag;
    private int projectPerformanceId;
    private BigDecimal performanceIntegral = BigDecimal.ZERO;
    private String sheetNameValue;
    private String sheetCodeValue;
    
    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
    /**
     * @return the parentWindow
     */
    public Window getParentWindow() {
        return parentWindow;
    }

    /**
     * @param parentWindow the parentWindow to set
     */
    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

	public int getPerformanceFlag() {
		return performanceFlag;
	}

	public void setPerformanceFlag(int performanceFlag) {
		this.performanceFlag = performanceFlag;
	}

	public BigDecimal getPerformanceIntegral() {
		return performanceIntegral;
	}

	public void setPerformanceIntegral(BigDecimal performanceIntegral) {
		this.performanceIntegral = performanceIntegral;
	}

	public String getSheetNameValue() {
		return sheetNameValue;
	}

	public void setSheetNameValue(String sheetNameValue) {
		this.sheetNameValue = sheetNameValue;
	}

	public String getSheetCodeValue() {
		return sheetCodeValue;
	}

	public void setSheetCodeValue(String sheetCodeValue) {
		this.sheetCodeValue = sheetCodeValue;
	}

	public int getProjectPerformanceId() {
		return projectPerformanceId;
	}

	public void setProjectPerformanceId(int projectPerformanceId) {
		this.projectPerformanceId = projectPerformanceId;
	}


	
}
