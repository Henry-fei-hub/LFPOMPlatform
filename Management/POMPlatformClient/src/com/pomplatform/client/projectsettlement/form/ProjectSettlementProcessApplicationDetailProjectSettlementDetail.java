package com.pomplatform.client.projectsettlement.form;

import java.math.BigDecimal;
import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.employeerole.datasource.DSGetRole93Employees;
import com.pomplatform.client.platereportrecorddetail.panel.ProjectLinkAttachmentPanel;
import com.pomplatform.client.preprojects.datasource.DSGetPlateManagers;
import com.pomplatform.client.projectsettlement.datasource.DSOnLoadProjectSettlementEmployees;
import com.pomplatform.client.projectsettlement.datasource.DSProjectSettlementDetail;
import com.pomplatform.client.settlement.datasource.DSMprojectemployeeppor;
import com.pomplatform.client.settlement.form.MprojectpporUpdateForm;

public class ProjectSettlementProcessApplicationDetailProjectSettlementDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
    private IButton resertSureIntegral = null;
    private IMenuButton setProjectCost = null;
    private IButton resertProjectCost = null;
    
    private final MprojectpporUpdateForm projectOverview = new MprojectpporUpdateForm();
    
	public ProjectSettlementProcessApplicationDetailProjectSettlementDetail() {

		VLayout global = new VLayout();
		addMember(global);
		global.setWidth100();
		global.setHeight100();
		ListGridField[] fields = new ListGridField[14];
		int idx = 0;
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("employeeNo");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("finishPercent");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("realAmount");
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
		fields[idx] = new ListGridField("finalAmount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("status");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("workContent");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("settlementDetailid");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setAutoFitFieldWidths(false);
		grid.setShowRowNumbers(true);
//		grid.setDataSource(DSMprojectemployeeppor.getInstance());
		grid.setDataSource(DSOnLoadProjectSettlementEmployees.getInstance());
		grid.setCanRemoveRecords(false);
		grid.setCanEdit(false);
		grid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				SC.debugger();
				Record record = event.getRecord();
				// 获取在职状态
				int status = BaseHelpUtils.getIntValue(record.getAttribute("status"));
				if (status == 1) {// 说明是离职
					SC.say("提示", "离职人员不可确认积分和分摊成本");
					return;
				}
				int colNum = event.getColNum();
				if (colNum == 3) {// 表示是确认比例
					if (getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_10) {
						SC.say("该订单处于订单暂停状态，目前只能结算成本，无法继续确认积分");
						return;
					} else if (getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_14) {
						SC.say("该订单处于订单终止—结算中状态，目前只能结算成本，无法继续确认积分");
						return;
					} else if (getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_15) {
						SC.say("该订单处于订单终止状态，目前只能结算成本，无法继续确认积分");
						return;
					}
					
					SC.askforValue("提示", "请输入本次确认的比例",  new ValueCallback() {
						
						@Override
						public void execute(String value) {
							if (BaseHelpUtils.isNullOrEmpty(value)) {
								return;
							}
							
							// 获取改变前的realAmount
							BigDecimal oldRealAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("realAmount"));
							// 获取改变前的数据
							BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("finishPercent"));
							// 获取新输入的数据
							BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value).setScale(2,BigDecimal.ROUND_HALF_UP);
							if(newValue.compareTo(BigDecimal.ZERO )<0) {
								SC.say("提示","阶段占比不能为负数");
								return;
							}
							
							ListGridRecord[] records = grid.getRecords();
							BigDecimal realAmountPercentSum = BigDecimal.ZERO;
							BigDecimal realAmountSum = BigDecimal.ZERO;
							for (ListGridRecord listGridRecord : records) {
								BigDecimal finishPercent = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("finishPercent"));
								BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realAmount"));
								realAmountPercentSum = realAmountPercentSum.add(finishPercent);
								realAmountSum = realAmountSum.add(realAmount);
							}
							
							BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.projectIntegralItem.getValue());
							BigDecimal otherRealAmountPercentSum = realAmountPercentSum.subtract(oldValue);
							BigDecimal otherRealAmount = realAmountSum.subtract(oldRealAmount);
							
							
							if((otherRealAmountPercentSum.add(newValue)).compareTo(new BigDecimal(100))==0) {
								record.setAttribute("realAmount", projectAmount.subtract(otherRealAmount));
								record.setAttribute("finishPercent", newValue);
								grid.updateData(record);
							}else {
								record.setAttribute("realAmount", projectAmount.multiply(newValue).divide(new BigDecimal(100),2, BigDecimal.ROUND_HALF_DOWN));
								record.setAttribute("finishPercent", newValue);
								grid.updateData(record);
							}
							
							ListGridRecord[] gridRecords = grid.getRecords();
							BigDecimal totalAmount =BigDecimal.ZERO;
							for (ListGridRecord listGridRecord : gridRecords) {
								BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realAmount"));
								totalAmount= totalAmount.add(realAmount);
							}
							
							
							projectOverview.totalAmountItem.setValue(totalAmount);
							projectOverview.leftAmountItem.setValue(projectAmount.subtract(totalAmount));
						}
					});
					
				}	
				
				
				if (colNum == 4) {// 表示是确认积分的输入
					if (getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_10) {
						SC.say("该订单处于订单暂停状态，目前只能结算成本，无法继续确认积分");
						return;
					} else if (getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_14) {
						SC.say("该订单处于订单终止—结算中状态，目前只能结算成本，无法继续确认积分");
						return;
					} else if (getProjectStatus() == ClientStaticUtils.PROJECT_STATUS_15) {
						SC.say("该订单处于订单终止状态，目前只能结算成本，无法继续确认积分");
						return;
					}
					SC.askforValue("提示", "请输入本次确认的积分", new ValueCallback() {
						@Override
						public void execute(String value) {
							if (BaseHelpUtils.isNullOrEmpty(value)) {
								return;
							}
							// 获取新输入的数据
							BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value).setScale(2,BigDecimal.ROUND_HALF_UP);
							if(newValue.compareTo(BigDecimal.ZERO)<0) {
								SC.say("提示","确认积分不能为负数");
								return;
							}
							// 获取改变前的数据
							BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("realAmount"));
							// 设置改变后的最终值
							BigDecimal finalValue = newValue.subtract(oldValue);
							// 获取剩余积分
							BigDecimal leftAmount = BaseHelpUtils
									.getBigDecimalValue(projectOverview.leftAmountItem.getValue());
							// 判断剩余积分是否够分配，如果不够分配则提示不可分配过多积分
							if (leftAmount.compareTo(finalValue) < 0) {// 说明不够分配
								SC.say("提示", "当前确认积分分配过多,已超出剩余可分配的积分,当前最多可分配积分(" + leftAmount + ")");
								return;
							}
							// 历史确认积分总和
							BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("sureIntegral"));
							// 如果输入确认积分为负数，则判断是否小于或等于历史确认积分
							if (newValue.compareTo(BigDecimal.ZERO) < 0) {
								if (newValue.abs().compareTo(sureIntegral) > 0) {
									SC.say("提示", "当前最多可扣减积分(" + (sureIntegral) + ")");
									return;
								}
							}
							projectOverview.leftAmountItem.setValue(leftAmount.subtract(finalValue));
							//本次计算积分之和
							BigDecimal oldTotalAmount= BaseHelpUtils.getBigDecimalValue(projectOverview.totalAmountItem.getValue());
							projectOverview.totalAmountItem.setValue(oldTotalAmount.add(finalValue));
							record.setAttribute("realAmount", newValue);
							grid.updateData(record);
							
							// 获取可确认积分
							BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.projectIntegralItem.getValue());
							//已确认积分的占比和
							BigDecimal percentSum =new BigDecimal(100);
							if((oldTotalAmount.add(finalValue)).compareTo(projectAmount)<0) {
								percentSum = (oldTotalAmount.add(finalValue)).divide(projectAmount,4,BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100));
							}
							
							ListGridRecord[] records = grid.getRecords();
							if(records.length>0) {
								int i = 0;
								int k = 0;
								int j = 0;
								for (ListGridRecord listGridRecord : records) {
									BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realAmount"));
									if(realAmount.compareTo(BigDecimal.ZERO)>0) {
										i+=1;
									}else {
										k+=1;
									}
								}
								
								ListGridRecord[] needList = new ListGridRecord[i];
								ListGridRecord[] noNeedList = new ListGridRecord[k];
								
								i = 0;
								k = 0;
								for (ListGridRecord listGridRecord : records) {
									BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realAmount"));
									if (realAmount.compareTo(BigDecimal.ZERO) > 0) {
										needList[i] = listGridRecord;
										i += 1;
									} else {
										listGridRecord.setAttribute("finishPercent", 0);
										listGridRecord.setAttribute("realAmount", 0);
										noNeedList[k] = listGridRecord;
										k += 1;
									}
								}
								
								if(noNeedList.length>0&&needList.length>0) {
									ListGridRecord[] newList = new ListGridRecord[records.length];
									BigDecimal realAmountPercentSum = BigDecimal.ZERO;
									for ( j = 0; j < needList.length; j++) {
										ListGridRecord listGridRecord = needList[j];
										if(j==(needList.length-1)) {
											listGridRecord.setAttribute("finishPercent", percentSum.subtract(realAmountPercentSum));
										}else {
											BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realAmount"));
											BigDecimal finishPercent = realAmount.divide(projectAmount,4, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100));
											realAmountPercentSum = realAmountPercentSum.add(finishPercent);
											listGridRecord.setAttribute("finishPercent", finishPercent);
										}
										newList[j] = listGridRecord;
									}
									
									
									j=needList.length;
									for ( int l = 0; l < noNeedList.length; l++) {
										ListGridRecord listGridRecord = noNeedList[l];
										newList[j] = listGridRecord;
										j+=1;
									}
									
									grid.setData(newList);
									
								}else if(noNeedList.length<=0&&needList.length>0){
									BigDecimal realAmountPercentSum = BigDecimal.ZERO;
									for ( j = 0; j < needList.length; j++) {
										ListGridRecord listGridRecord = needList[j];
										if(j==(needList.length-1)) {
											listGridRecord.setAttribute("finishPercent", percentSum.subtract(realAmountPercentSum));
										}else {
											BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("realAmount"));
											BigDecimal finishPercent = realAmount.divide(projectAmount,4, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100));
											realAmountPercentSum = realAmountPercentSum.add(finishPercent);
											listGridRecord.setAttribute("finishPercent", finishPercent);
										}
									}
									grid.setData(needList);
								}else if(noNeedList.length>0&&needList.length<=0) {
									grid.setData(noNeedList);
								}
								
								
							}
						}
					});
				}
			}
		});

		// 上半部
		projectOverview.setWidth100();
		projectOverview.setHeight("45%");
		global.addMember(projectOverview);
		global.addMember(grid);
		ToolStrip controlLayout = new ToolStrip();
		global.addMember(controlLayout);
		controlLayout.addFill();

		resertSureIntegral = new IButton("重置确认积分");
		resertSureIntegral.setAutoFit(true);
		resertSureIntegral.setWidth(100);
		controlLayout.addMember(resertSureIntegral);
		controlLayout.addSpacer(10);
		resertSureIntegral.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "您确定要重置确认积分吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							ListGridRecord[] records = grid.getRecords();
							if (records == null || records.length == 0) {
								return;
							} else {
								for (ListGridRecord record : records) {
									record.setAttribute("realAmount", 0);
									record.setAttribute("finishPercent", 0);
								}
								grid.setData(records);
								// 重置剩余积分
								projectOverview.leftAmountItem.setValue(leftAmount);
								projectOverview.totalAmountItem.setValue(BigDecimal.ZERO);
							}
						}
					}
				});
			}
		});
		resertProjectCost = new IButton("重置分摊成本");
		resertProjectCost.setAutoFit(true);
		resertProjectCost.setWidth(100);
//		controlLayout.addMember(resertProjectCost);
		controlLayout.addSpacer(10);
		resertProjectCost.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "您确定要重置分摊成本吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							ListGridRecord[] records = grid.getRecords();
							if (records == null || records.length == 0) {
								return;
							} else {
								for (ListGridRecord record : records) {
									record.setAttribute("cost", 0);
								}
								grid.setData(records);
								// 重置未分配的项目成本
								projectOverview.finalAmountItem.setValue(finalAmount);
							}
						}
					}
				});
			}
		});

		Menu menu = new Menu();
		setProjectCost = new IMenuButton("按比例分摊成本", menu);
		setProjectCost.setAutoFit(true);
		setProjectCost.setWidth(100);
//		controlLayout.addMember(setProjectCost);
		controlLayout.addSpacer(10);

	}
	

	@Override
	public void startEdit() {
		projectId = ClientUtil.checkAndGetIntValue(getRecord().getAttribute("projectId"));
		contractId = ClientUtil.checkAndGetIntValue(getRecord().getAttribute("contractId"));
		projectStatus = ClientUtil.checkAndGetIntValue(getRecord().getAttribute("status"));
		if(getPageMode() != PAGE_MODE_UPDATE) {
			load();
		}else {
//			projectOverview.ourEmployeesItem.setHidden(true);
//			projectOverview.ourEmployeesItem.hide();
//			projectOverview.ourEmployeesItem.setCanEdit(false);
//			projectOverview.draw();
			reloadDetailTableData();
		}
	}
	
	public void load() {
		if (projectId == 0 || contractId == 0) {
			return;
		}
		Map<String, Object> params = new HashMap<>();
		params.put("projectId", projectId);
		params.put("contractId", contractId);
		params.put("settlementStatus", 2);
		DBDataSource.callOperation("NQ_OnLoadProjectOverview", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
					Record r = dsResponse.getData()[0];
					projectOverview.setRecord(r);
					projectOverview.startEdit();
					setLeftAmount(
							ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("leftAmount")));
					setFinalAmount(
							ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("finalAmount")));
					setLeftSettlementIntegral(
							BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("leftAmount")));
					setLeftProjectCost(
							BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("finalAmount")));
				} else {
					@SuppressWarnings({ "rawtypes" })
					Map errors = dsResponse.getErrors();
					SC.say("提示", errors.get("errorMsg") + "");
				}
			}
		});

		DBDataSource.callOperation("NQ_OnLoadProjectSettlementEmployees", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					grid.setData(record);
				}
			}
		});

	}

	public void reloadDetailTableData(){
		
		Map<String, Object> params = new HashMap<>();
		params.put("projectId", projectId);
		params.put("settlementId", getRecord().getAttribute("settlementId"));
		DBDataSource.callOperation("ST_ProjectSettlement","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
					Record r = dsResponse.getData()[0];
					projectOverview.setRecord(r);
					projectOverview.startEdit();
					setLeftAmount(
							ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("leftAmount")));
					setFinalAmount(
							ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("finalAmount")));
					setLeftSettlementIntegral(
							BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("leftAmount")));
					setLeftProjectCost(
							BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("finalAmount")));
				} else {
					@SuppressWarnings({ "rawtypes" })
					Map errors = dsResponse.getErrors();
					SC.say("提示", errors.get("errorMsg") + "");
				}
			}
		});
		
		
		DBDataSource.callOperation("NQ_OnLoadSettlementEmployees", "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
		
//		DBDataSource.callOperation("NQ_OnLoadProjectSettlementEmployees", params, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					Record[] record = dsResponse.getData();
//					grid.setData(record);
//				}
//			}
//		});		
		

	}

	@Override
	public boolean checkData() {
		if (getProjectId() == 0) {
            SC.say("没有要结算的项目");
            return false;
        }
		
		if(grid.getRecords().length<=0) {
			SC.say("请先进行团队组建");
			return false;
		}else {
			 //判断这这一次提交是否有分配确认积分或分摊成本
            Record[] records = grid.getRecords();
            boolean isCanCommit = false;
            BigDecimal totalSureIntegral = BigDecimal.ZERO;
            for(Record e:records){
            	BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("realAmount"));
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
//            if(totalSureIntegral.compareTo(BigDecimal.ZERO) < 0){//这一次的结算分配的确认积分一定要大于或等于0
//            	SC.say("提示","本次结算没有分配的确认积分不可小于0");
//            	return false;
//            }
            if(!isCanCommit){//说明这一次结算没有分配确认积分和分摊成本,无需提交
            	SC.say("提示","本次结算没有分配确认积分和分摊成本,无需提交");
            	return false;
            }
		}
		
//		if(getPageMode() != PAGE_MODE_UPDATE) {
//			if(BaseHelpUtils.isNullOrEmpty(projectOverview.ourEmployeesItem.getValue())) {
//				SC.say("请选择审核人");
//				return false;
//			}
//		}
    	
//    	if(BaseHelpUtils.isNullOrEmpty(projectOverview.settlementRemarkItem.getValue())) {
//    		SC.say("请填写结算备注");
//    		return false;
//    	}
    	
    	//获取剩余积分为负数
    	BigDecimal leftAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.leftAmountItem.getValue());//剩余积分
        if (leftAmount.compareTo(BigDecimal.ZERO) < 0) {
            SC.say("结算积分超过了可分配积分，请重新分配积分");
            return false;
        } 
        
        if (leftAmount.compareTo(BigDecimal.ZERO) > 0) {
            SC.say("结算积分比例未达100%，请重新分配积分");
            return false;
        } 
    	
    	//获取未结算的项目成本
//        BigDecimal finalAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.finalAmountItem.getValue());
//        if(finalAmount.compareTo(BigDecimal.ZERO) > 0){
//            SC.say("提示","您还有未结算的项目成本("+finalAmount+"),请分摊到项目成员");
//            return false;
//        }
        return true;
    
		
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailProjectSettlementDetail");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
        final Map<String,Object> param = new HashMap<>();
        param.put("projectId", projectId);
        param.put("employeeId", ClientUtil.getEmployeeId());
        param.put("stageId", -1);
        param.put("settlementStatus", 1);
        param.putAll(projectOverview.getValuesAsMap());
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProjectSettlementDetail");
//		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "projectEmployees");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}
	
	
	 	private int projectId = 0;
	    private int contractId = 0;
	    private int settlementStatus = 2;//默认计算状态为已确认
	    private double leftAmount;
	    private double finalAmount;
	    private Window parentWindow;
	    private int projectFlag;
	    private BigDecimal leftSettlementIntegral = BigDecimal.ZERO;
	    private BigDecimal leftProjectCost = BigDecimal.ZERO;
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

