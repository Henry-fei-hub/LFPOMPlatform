package com.pomplatform.client.project.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.platereportrecorddetail.panel.ProjectLinkAttachmentPanel;
import com.pomplatform.client.settlement.datasource.DSMprojectemployeeppor;
import com.pomplatform.client.settlement.form.MprojectpporUpdateForm;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 *
 * @author guangxun
 */
public class SettlementPanel extends Window {
    private final Logger __logger = Logger.getLogger("");
    private IButton resertSureIntegral = null;
    private IButton settlement = null;
    private IMenuButton setProjectCost = null;
    private IButton resertProjectCost = null;
    private IButton projectLinkAtt = null;
    public SettlementPanel() {
    }

    public void initComponents() {
        VLayout global = new VLayout();
        addItem(global);
        global.setWidth100();
        global.setHeight100();
		ListGridField[] fields = new ListGridField[14];
		int idx = 0;
		fields[idx] = new ListGridField("employeeNo");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("realIntegral");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("sureIntegral");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("cost");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("projectCost");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("realAmount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("settlementStatus");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("status");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("workContent");
		fields[idx].setShowGridSummary(false);
		grid.setFields(fields);
		grid.setShowGridSummary(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowRowNumbers(true);
        grid.setDataSource(DSMprojectemployeeppor.getInstance());
        grid.setCanRemoveRecords(false);
        grid.setCanEdit(false);
        grid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				if(!isCanOperate){
					SC.say("提示","该项目在当前阶段处于待确认状态,不可进行任何操作");
					return;
				}
				SC.debugger();
				Record record = event.getRecord();
				//获取在职状态
				int status = BaseHelpUtils.getIntValue(record.getAttribute("status"));
				if(status == 1){//说明是离职
					SC.say("提示","离职人员不可确认积分和分摊成本");
					return;
				}
				int colNum = event.getColNum();
				if(colNum == 3){//表示是确认积分的输入
					if(getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_10){
						SC.say("该订单处于订单暂停状态，目前只能结算成本，无法继续确认积分");
						return;
					}else if(getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_14) {
						SC.say("该订单处于订单终止—结算中状态，目前只能结算成本，无法继续确认积分");
						return;
					}else if(getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_15) {
						SC.say("该订单处于订单终止状态，目前只能结算成本，无法继续确认积分");
						return;
					}
					SC.askforValue("提示","请输入本次确认的积分",new ValueCallback() {
						@Override
						public void execute(String value) {
							if(BaseHelpUtils.isNullOrEmpty(value)){
								return;
							}
							//获取改变前的数据
							BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("realIntegral"));
							//获取新输入的数据
							BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value).setScale(2, BigDecimal.ROUND_HALF_UP);
							//设置改变后的最终值
							BigDecimal finalValue = newValue.subtract(oldValue);
							//获取剩余积分
		                    BigDecimal leftAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.leftAmountItem.getValue());
		                    //判断剩余积分是否够分配，如果不够分配则提示不可分配过多积分
		                    if(leftAmount.compareTo(finalValue) < 0){//说明不够分配
		                    	SC.say("提示","当前确认积分分配过多,已超出剩余可分配的积分,当前最多可分配积分("+leftAmount+")");
		                    	return;
		                    }
		                    //获取预分配积分
//		                    BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("planIntegral"));
		                    //阶段历史确认积分总和
		                    BigDecimal stageSureIntegral= BaseHelpUtils.getBigDecimalValue(record.getAttribute("stageSureIntegral"));
		                    //如果输入确认积分为负数，则判断是否小于或等于历史确认积分
		                    if(newValue.compareTo(BigDecimal.ZERO) < 0){
		                    	if(newValue.abs().compareTo(stageSureIntegral) > 0){
		                    		SC.say("提示", "当前最多可扣减积分("+(stageSureIntegral)+")");
			                        return;
		                    	}
		                    }
		                    //当输入积分输入过多时，不允许提交
//		                    if(planIntegral.compareTo(newValue.add(stageSureIntegral)) < 0){
//		                        SC.say("提示", "输入实际积分超出了计划分配的积分,当前最多可输入积分("+(planIntegral.subtract(stageSureIntegral))+")");
//		                        return;
//		                    }
		                    projectOverview.leftAmountItem.setValue(leftAmount.subtract(finalValue));
		                    record.setAttribute("realIntegral",newValue);
							grid.updateData(record);
						}
					});
				}else if(colNum == 5){
					SC.askforValue("提示","请输入本次分摊的成本", new ValueCallback() {
						@Override
						public void execute(String value) {
							if(BaseHelpUtils.isNullOrEmpty(value)){
								return;
							}
							//获取改变前的数据
							BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("cost"));
							//获取新输入的数据
							BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value).setScale(2, BigDecimal.ROUND_HALF_UP);
							//设置改变后的最终值
							BigDecimal finalValue = newValue.subtract(oldValue);
							if(newValue.compareTo(BigDecimal.ZERO) < 0){
		                        SC.say("提示","您输入的分摊成本不可小于0");
		                        return;
		                    }
							//获取该项目当前需结算项目成本
		                	BigDecimal totalProjectCost = BaseHelpUtils.getBigDecimalValue(projectOverview.finalAmountItem.getValue());
							//如果分摊的成本大于了项目总的成本，则返回
		                    if(totalProjectCost.compareTo(finalValue) < 0){
		                        SC.say("提示","本次分摊的成本("+newValue+")不可大于未结算项目成本("+totalProjectCost+")");
		                        return;
		                    }
		                    projectOverview.finalAmountItem.setValue(totalProjectCost.subtract(finalValue)); 
		                    record.setAttribute("cost",newValue);
							grid.updateData(record);
						}
					});
				}
			}
		});
        
        
        //上半部
        projectOverview.setWidth100();
        projectOverview.setHeight("45%");
        global.addMember(projectOverview);
        global.addMember(grid);
        ToolStrip controlLayout = new ToolStrip();
        global.addMember(controlLayout);
        controlLayout.addFill();
        
        projectLinkAtt = new IButton("绑定确认函");
        projectLinkAtt.setAutoFit(true);
        projectLinkAtt.setWidth(100);
        projectLinkAtt.hide();
        controlLayout.addMember(projectLinkAtt);
        controlLayout.addSpacer(10);
        projectLinkAtt.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PopupWindow popupWindow = new PopupWindow("确认函绑定");
                popupWindow.setWidth("70%");
                popupWindow.setHeight("90%");
                popupWindow.centerInPage();
                ProjectLinkAttachmentPanel panel = new ProjectLinkAttachmentPanel();
                panel.addDataEditedHandler(new DataEditedHandler() {
            		@Override
            		public void onDataEdited(DataEditEvent event) {
            			load();
            			projectLinkAtt.hide();
            		}
            	});
                panel.setStageId(stageId);
                panel.initComponents(projectId);
                panel.load(projectId);
                popupWindow.addItem(panel);
                panel.setParentWindow(popupWindow);
                popupWindow.centerInPage();
                popupWindow.show();
            }
        });
        
        resertSureIntegral = new IButton("重置确认积分");
        resertSureIntegral.setAutoFit(true);
        resertSureIntegral.setWidth(100);
        controlLayout.addMember(resertSureIntegral);
        controlLayout.addSpacer(10);
        resertSureIntegral.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确定要重置确认积分吗?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if(value){
                            ListGridRecord[] records = grid.getRecords();
                            if (records == null || records.length == 0) {
                                return;
                            }else{
                                for(ListGridRecord record : records){
                                    record.setAttribute("realIntegral", 0);
                                }
                                grid.setData(records);
                                //重置剩余积分
                                projectOverview.leftAmountItem.setValue(leftAmount);
                            }
                        }
                    }
                });
            }
        });
        resertProjectCost = new IButton("重置分摊成本");
        resertProjectCost.setAutoFit(true);
        resertProjectCost.setWidth(100);
        controlLayout.addMember(resertProjectCost);
        controlLayout.addSpacer(10);
        resertProjectCost.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确定要重置分摊成本吗?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if(value){
                            ListGridRecord[] records = grid.getRecords();
                            if (records == null || records.length == 0) {
                                return;
                            }else{
                                for(ListGridRecord record : records){
                                    record.setAttribute("cost", 0);
                                }
                                grid.setData(records);
                                //重置未分配的项目成本
                                projectOverview.finalAmountItem.setValue(finalAmount);
                            }
                        }
                    }
                });
            }
        });
        
        
		Menu menu = new Menu(); 
		MenuItem returnLastItem = new MenuItem("按本次确认积分"); 
		returnLastItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			
			@Override
			public void onClick(MenuItemClickEvent event) {
				SC.confirm("你确认按本次确认积分吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							getCost(1);
						}
					}
				});
			}
		});
		
		MenuItem returnFirstItem = new MenuItem("按阶段历史确认积分"); 
		returnFirstItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			
			@Override
			public void onClick(MenuItemClickEvent event) {
				SC.confirm("你确定按阶段历史确认积分吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							getCost(2);
						}
					}
				});
			}
		});
		
		
		MenuItem returnSecondItem = new MenuItem("按项目历史确认积分"); 
		returnSecondItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			
			@Override
			public void onClick(MenuItemClickEvent event) {
				SC.confirm("你确定项目历史确认积分吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							getCost(3);
						}
					}
				});
			}
		});
		
		
		
		setProjectCost = new IMenuButton("按比例分摊成本", menu);  
		menu.setItems(returnLastItem, returnFirstItem,returnSecondItem);
//        setProjectCost = new IButton("按比例分摊成本");
        setProjectCost.setAutoFit(true);
        setProjectCost.setWidth(100);
        controlLayout.addMember(setProjectCost);
        controlLayout.addSpacer(10);
        
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
                    @SuppressWarnings("unchecked")
					@Override
                    public void execute(Boolean value) {
                        if(value){
                        	settlement.setDisabled(true);
                            if (getProjectId() == 0) {
                                SC.say("没有要结算的项目");
                                settlement.setDisabled(false);
                                return;
                            }
                            final Map<String,Object> params = new HashMap<>();
                            params.put("projectId", projectId);
                            params.putAll(projectOverview.getValuesAsMap());
                            if (ClientUtil.isNullOrEmpty(params.get("settlementRemark"))) {
                                SC.say("结算备注不能空");
                                settlement.setDisabled(false);
                                return;
                            }
                            //获取未结算的项目成本
                            BigDecimal finalAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.finalAmountItem.getValue());
                            if(finalAmount.compareTo(BigDecimal.ZERO) > 0){
                                SC.say("提示","您还有未结算的项目成本("+finalAmount+"),请分摊到项目成员");
                                settlement.setDisabled(false);
                                return;
                            }
                            //判断这这一次提交是否有分配确认积分或分摊成本
                            Record[] records = grid.getRecords();
                            boolean isCanCommit = false;
                            int settlementStatus = 2;//默认计算状态为已确认
                            BigDecimal totalSureIntegral = BigDecimal.ZERO;
                            for(Record e:records){
                            	BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("realIntegral"));
                            	totalSureIntegral = totalSureIntegral.add(sureIntegral);
                            	BigDecimal projectCost = BaseHelpUtils.getBigDecimalValue(e.getAttribute("cost"));
                            	if(sureIntegral.compareTo(BigDecimal.ZERO) != 0){
                            		isCanCommit = true;
                            		//如果有确认的积分为负数的,且分配负数的确认积分的人员为非项目经理，则这一次结算进入待确认状态，只有等分配负数的人员确认通过后方可
                            		if(sureIntegral.compareTo(BigDecimal.ZERO) < 0){
                            			//检索是否为项目经理
                            			int projectManageId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
                            			//获取当前登录人,即当前项目的项目经理
                            			int emploeeId = ClientUtil.getEmployeeId();
                            			if(projectManageId != emploeeId){
                            				settlementStatus = 1;//设置为待确认状态
                            			}
                            		}
                            	}
                            	if(projectCost.compareTo(BigDecimal.ZERO) != 0){
                            		isCanCommit = true;
                            	}
                            }
                            if(totalSureIntegral.compareTo(BigDecimal.ZERO) < 0){//这一次的结算分配的确认积分一定要大于或等于0
                            	SC.say("提示","本次结算没有分配的确认积分不可小于0");
                            	settlement.setDisabled(false);
                            	return;
                            }
                            if(!isCanCommit){//说明这一次结算没有分配确认积分和分摊成本,无需提交
                            	SC.say("提示","本次结算没有分配确认积分和分摊成本,无需提交");
                            	settlement.setDisabled(false);
                            	return;
                            }
                            params.put("settlementStatus", settlementStatus);
                            BigDecimal leftAmount = BaseHelpUtils.getBigDecimalValue(params.get("leftAmount"));//剩余积分
                            MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "projectEmployees");
                            if (leftAmount.compareTo(BigDecimal.ZERO) < 0) {
                                SC.say("结算积分超过了阶段可分配积分，请重新分配积分");
                                settlement.setDisabled(false);
                                return;
                            } 
//                            else if (leftAmount.compareTo(BigDecimal.ZERO) == 0 && projectFlag == 1) {//结算积分等于阶段积分,则表示该阶段已完成，需提交附件确认函
//                            	if(!(leftSettlementIntegral.compareTo(BigDecimal.ZERO) == 0 && leftProjectCost.compareTo(BigDecimal.ZERO) > 0)){
//                                	UploadProjectAttachment uploadImg = new UploadProjectAttachment(projectId, ClientUtil.checkAndGetIntValue(projectOverview.getValuesAsMap().get("stageId")), (String) params.get("settlementRemark"),(Date)params.get("settlementDate"));
//                                	uploadImg.addDataEditedHandler(new DataEditedHandler() {
//                                		@Override
//                                		public void onDataEdited(DataEditEvent event) {
//                                			//上传附件确认函成功
//                                			OnExecute(params);
//                                		}
//                                	});
//                                	uploadImg.show();
//                                }else{
//                                	OnExecute(params);
//                                }
//                            } 
                            else {
                                OnExecute(params);
                            }
                        }
                    }
                });
            }
        });
    }

    /**
     * 执行结算公用方法
     *
     * @param params
     */
    public void OnExecute(Map<String,Object> params) {
    	params.put("operateEmployeeId", ClientUtil.getEmployeeId());
    	settlement.setDisabled(true);
        DBDataSource.callOperation("EP_ProjectAccount", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	settlement.setDisabled(false);
                if (dsResponse.getStatus() >= 0) {
                    SC.say("提示","结算成功");
                    load();
                } else {
                    @SuppressWarnings("rawtypes")
					Map errors = dsResponse.getErrors();
                    SC.say("结算失败",errors.get("errorMsg")+"");
                }
            }
        });
    }

    private void closeWindow() {
        this.destroy();
    }
    
    
	public void load() {
		if (projectId == 0||contractId == 0 ) {
			return;
		}

		Map<String, Object> params = new HashMap<>();
		params.put("projectId", projectId);
		params.put("contractId", contractId);
		DBDataSource.callOperation("NQ_OnLoadProjectOverview", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
					Record r = dsResponse.getData()[0];
					projectOverview.setRecord(r);
					projectOverview.startEdit();
					setLeftAmount(ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("leftAmount")));
					setFinalAmount(ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("finalAmount")));
					setLeftSettlementIntegral(BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("leftAmount")));
					setLeftProjectCost(BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("finalAmount")));
				 }else{
                	@SuppressWarnings({ "rawtypes"})
					Map errors = dsResponse.getErrors();
                	SC.say("提示",errors.get("errorMsg")+"");
                }
			}
		});
		
		
      DBDataSource.callOperation("NQ_Mprojectemployeeppor", params, new DSCallback() {
      @Override
      public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
          if (dsResponse.getStatus() >= 0) {
              Record[] record = dsResponse.getData();
              grid.setData(record);
              //获取到所有成员确认积分的总和
//              BigDecimal sureIntegralTotal = BigDecimal.ZERO;//初始化确认积分
//              int len = record.length;
//              for(int i=0;i<len;i++){
//                  sureIntegralTotal = sureIntegralTotal.add(BaseHelpUtils.getBigDecimalValue(record[i].getAttribute("realIntegral")));
//              }
//              //重置剩余积分，即剩余积分-已确认的确认积分
//              projectOverview.leftAmountItem.setValue(BigDecimal.valueOf(leftAmount).subtract(sureIntegralTotal));
          }
      }

  });

	}
    
    

//    public void load() {
//        if (projectId == 0) {
//            return;
//        }
//        Map<String,Object> params = new HashMap<>();
//        params.put("projectId", projectId);
//        DBDataSource.callOperation("EP_StageSettlementDataQuery", params, new DSCallback() {
//            @Override
//            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
////                	if(dsResponse.getStatus() == 2 && projectFlag == 1){//说明当前阶段积分已经确认完，但未上传确认函
////                		projectLinkAtt.show();
////                		SC.say("提示","当前阶段积分已确认完毕,但尚未绑定确认函,请点击绑定确认函进行确认函的绑定操作方可流转到下个阶段");
////                	}
//                	Record r = dsResponse.getData()[0];
//                	//获取当前结算的阶段ID
//                	int stageId = BaseHelpUtils.getIntValue(r.getAttribute("stageId"));
//                	setStageId(stageId);
//                    projectOverview.setRecord(r);
//                    projectOverview.startEdit();
//                    setLeftAmount(ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("leftAmount")));
//                    setFinalAmount(ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("finalAmount")));
//                    setLeftSettlementIntegral(BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("leftAmount")));
//                    setLeftProjectCost(BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("finalAmount")));
//                    Map<String,Object> params = new HashMap<>();
//                    params.put("projectId", projectId);
//                    params.put("stageId", ClientUtil.checkAndGetIntValue(dsResponse.getData()[0].getAttribute("stageId")));
//                    params.put("settlementStatus",1);
//                    //加载当前阶段是否在待确认状态，如果是在待确认状态，则提示，并不可做任何操作
//                    DBDataSource.callOperation("ST_ProjectSettlement","find",params, new DSCallback() {
//                        @Override
//                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                            if (dsResponse.getStatus() >= 0) {
//                                Record[] record = dsResponse.getData();
//                                if(record.length > 0){
//                                	SC.say("提示","该项目在当前阶段处理待确认状态,不可进行任何操作");
//                                	//屏蔽所有操作按钮
//                                	resertSureIntegral.setDisabled(true);
//                                	settlement.setDisabled(true);
//                                	setProjectCost.setDisabled(true);
//                                	resertProjectCost.setDisabled(true);
//                                	isCanOperate = false;
//                                }
//                            }
//                        }
//                    });
//                    DBDataSource.callOperation("NQ_Mprojectemployeeppor", params, new DSCallback() {
//                        @Override
//                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                            if (dsResponse.getStatus() >= 0) {
//                                Record[] record = dsResponse.getData();
//                                grid.setData(record);
//                                //获取到所有成员确认积分的总和
//                                BigDecimal sureIntegralTotal = BigDecimal.ZERO;//初始化确认积分
//                                int len = record.length;
//                                for(int i=0;i<len;i++){
//                                    sureIntegralTotal = sureIntegralTotal.add(BaseHelpUtils.getBigDecimalValue(record[i].getAttribute("realIntegral")));
//                                }
//                                //重置剩余积分，即剩余积分-已确认的确认积分
//                                projectOverview.leftAmountItem.setValue(BigDecimal.valueOf(leftAmount).subtract(sureIntegralTotal));
//                            }
//                        }
//
//                    });
//                }else{
//                	@SuppressWarnings({ "rawtypes"})
//					Map errors = dsResponse.getErrors();
//                	SC.say("提示",errors.get("errorMsg")+"");
//                }
//            }
//
//        });
//    }

	private final DelicacyListGrid grid = new DelicacyListGrid(true) {
		@Override
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			if (null != record.getAttribute("status") && record.getAttributeAsInt("status") == 1) { // 离职，标灰色
				return "color:#A5A5A5;";
			} else {
				return super.getCellCSSText(record, rowNum, colNum);
			}
		}
	};
    private int projectId = 0;
    private int contractId = 0;
    private double leftAmount;
    private double finalAmount;
    private final MprojectpporUpdateForm projectOverview = new MprojectpporUpdateForm();
    private Window parentWindow;
    private int projectFlag;
    private BigDecimal leftSettlementIntegral = BigDecimal.ZERO;
    private BigDecimal leftProjectCost = BigDecimal.ZERO;
    private boolean isCanOperate = true;
    private int projectStatus;
    private int stageId;
    
    public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

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

    /**
     * @return the leftAmount
     */
    public double getLeftAmount() {
        return leftAmount;
    }

    /**
     * @param leftAmount the leftAmount to set
     */
    public void setLeftAmount(double leftAmount) {
        this.leftAmount = leftAmount;
    }

    /**
     * @return the finalAmount
     */
    public double getFinalAmount() {
        return finalAmount;
    }

    /**
     * @param finalAmount the finalAmount to set
     */
    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

	public int getProjectFlag() {
		return projectFlag;
	}

	public void setProjectFlag(int projectFlag) {
		this.projectFlag = projectFlag;
	}

	public BigDecimal getLeftSettlementIntegral() {
		return leftSettlementIntegral;
	}

	public void setLeftSettlementIntegral(BigDecimal leftSettlementIntegral) {
		this.leftSettlementIntegral = leftSettlementIntegral;
	}

	public BigDecimal getLeftProjectCost() {
		return leftProjectCost;
	}

	public void setLeftProjectCost(BigDecimal leftProjectCost) {
		this.leftProjectCost = leftProjectCost;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}
	
	
	private void getCost(int type) {
		//获取未结算的项目成本,如果等于0，则表示没有未结算的项目成本
        if(finalAmount <= 0){
            SC.say("提示","没有需要结算的项目成本");
            return;
        }else{
            //获取项目成员的确认积分
            ListGridRecord[] records = grid.getRecords();
            if (records == null || records.length == 0) {
                return;
            }else{
                //获取总的确认积分，即总的剩余积分-分配后剩余的积分
                //获取分配后的剩余积分
                BigDecimal lastLeftIntegral = BaseHelpUtils.getBigDecimalValue(projectOverview.leftAmountItem.getValue());
                //如果总的剩余积分=分配后的剩余积分，则表示未进行分配
                if(type==1&&leftAmount == lastLeftIntegral.doubleValue()){
                    SC.say("提示","未进行分配确认积分,请先分配确认积分");
                    return;
                }else{
                	 ListGridRecord[] records2  = new ListGridRecord[] {};
                	 int  len =0;
                    //获取已经分配的确认积分
                	BigDecimal assignedSureIntegral =new BigDecimal(0);
            
                   if(type==1) {

                	   for (ListGridRecord listGridRecord : records) {
                		   if(BaseHelpUtils.getIntValue(listGridRecord.getAttribute("status"))==0) {
                			   BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realIntegral"));
                			   if(bigDecimalValue.compareTo(BigDecimal.ZERO)>0) {
                				   assignedSureIntegral= assignedSureIntegral.add(bigDecimalValue);
                				   records2[len]=listGridRecord;
                				   len++;
                			   }
                		   }
                	   	}
                   }else if(type==2){
                	   for (ListGridRecord listGridRecord : records) {
                		   if(BaseHelpUtils.getIntValue(listGridRecord.getAttribute("status"))==0) {
                			   BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("stageSureIntegral"));
                			   assignedSureIntegral= assignedSureIntegral.add(bigDecimalValue);
                			   records2[len]=listGridRecord;
                			   len++;
                		   }
                	   	}
                   }else if(type==3){
                	   for (ListGridRecord listGridRecord : records) {
                		   if(BaseHelpUtils.getIntValue(listGridRecord.getAttribute("status"))==0) {
                			   BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("sureIntegral"));
                			   assignedSureIntegral= assignedSureIntegral.add(bigDecimalValue);
                			   records2[len]=listGridRecord;
                			   len++;
                		   }
                	   	}
                   }
                   
                    //按比例去分摊成本
                   
                    BigDecimal finalLeft = BigDecimal.valueOf(finalAmount);
                    String string ="";
                    if(type==1) {
                    	string ="realIntegral";
                    }else if(type==2){
                    	string ="stageSureIntegral";
                    }else if(type==3){
                    	string ="sureIntegral";
                    }
                    for(int i = 0; i < len; i++){
                    	ListGridRecord record = records2[i];
                    	//获取每一个成员的确认积分   ||获取每一个成员的阶段历史确认积分
                    	BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute(string));
                        //获取成员分配比例
                        if(i == len - 1){//如果是最后一个成员，则看该成员的确认积分是否为0，为0则将这笔费用加到上一个确认积分不为0的员工身上
                            if(BaseHelpUtils.getBigDecimalValue(record.getAttribute(string)).compareTo(BigDecimal.ZERO) == 0){
                            	for(int j = i; j > 0; j--){
                            		ListGridRecord tempRecord = records[j];
                            		 if(BaseHelpUtils.getBigDecimalValue(tempRecord.getAttribute(string)).compareTo(BigDecimal.ZERO) == 0){
                            			 continue;
                            		 }else{
                            			 tempRecord.setAttribute("cost", BaseHelpUtils.getBigDecimalValue(tempRecord.getAttribute("cost")).add(finalLeft));
                            			 break;
                            		 }
                            	}
                            }else{
                            	record.setAttribute("cost",finalLeft);
                            }
                        }else{
                            //按比例去分摊成本
                        	BigDecimal costAmount = BigDecimal.valueOf(finalAmount).multiply(sureIntegral).divide(assignedSureIntegral, 2, BigDecimal.ROUND_DOWN);
                            record.setAttribute("cost",costAmount);
                            finalLeft = finalLeft.subtract(costAmount) ;
                        }
                    }
                    //分摊后，设置为分配的项目成本为0,并更新grid
                    projectOverview.finalAmountItem.setValue(0);
                    grid.setData(records);
                }
            }
        }
    }
	
}
