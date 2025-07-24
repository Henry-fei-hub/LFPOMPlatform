package com.pomplatform.client.capitaldistribution.panel;

import java.math.BigDecimal;
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
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.capitaldistribution.datasource.DSAllCapitalDistributionInfo;
import com.pomplatform.client.capitaldistribution.form.AllCapitalDistributionInfoSearchForm;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class AllCapitalDistributionInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AllCapitalDistributionInfoPanel cm = new AllCapitalDistributionInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AllCapitalDistributionInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (null != record.getAttribute("locked") && record.getAttribute("locked").equals("true")) {  //定稿标灰色
					return "color:#A5A5A5;";  
                } else if(null != record.getAttribute("locked") && record.getAttribute("locked").equals("false")) { //有分配，还没锁定，正常颜色 
                	if(null != record.getAttribute("leftAmount") && null != record.getAttribute("distributionAmount")){
                		BigDecimal distributionAmount = new BigDecimal(record.getAttribute("distributionAmount"));
                		BigDecimal leftAmount = new BigDecimal(record.getAttribute("leftAmount"));
                		if(distributionAmount.compareTo(BigDecimal.ZERO) == 0){
                			//没有分配，正常颜色，字体加粗 
                			return "font-weight:bold;";  
                		}else{
                			if(leftAmount.compareTo(BigDecimal.ZERO) > 0){
                				//没分完回款的显示黄色
                    			return "font-weight:bold; color:#F19E02;";
                			}else if(leftAmount.compareTo(BigDecimal.ZERO) < 0){
                				//分配的金额大于回款金额，显示紫色
                    			return "font-weight:bold; color:#E24BB3;";
                			}
                		}
                	}
                	//刚好分完了的，正常显示
                	return super.getCellCSSText(record, rowNum, colNum); 
                }  else{//没有分配，正常颜色，字体加粗 
                	return "font-weight:bold;";  
                }
			}
		};
		resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		int idx = 0;
		ListGridField[] fields = new ListGridField[8];
		fields[idx] = new ListGridField("contractCode");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("contractName");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("happenDate");
		fields[idx++].setShowGridSummary(false);
		fields[idx++] = new ListGridField("borrowMoney");
		fields[idx++] = new ListGridField("distributionAmount");
		fields[idx++] = new ListGridField("leftAmount");
		fields[idx] = new ListGridField("operator");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("createTime");
		fields[idx++].setShowGridSummary(false);
		
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		
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
		
		IButton distributeButton = PermissionControl.createPermissionButton("回款分配", ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_DISTRIBUTION);
		controlLayout.addMember(distributeButton);
		distributeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton deleteButton = PermissionControl.createPermissionButton("删除回款分配", ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_DEL_DISTRIBUTION);
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要删除回款分配的记录");
							return;
						}
						SC.ask("确定要删除这些数据吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Map<String, String> params = new HashMap<>();
									Record[] records = resultGrid.getSelectedRecords();
									StringBuilder sb = new StringBuilder();
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
											commonQuery();
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
		
		IButton lockedButton = PermissionControl.createPermissionButton("回款分配锁定", ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_LOCK);
		controlLayout.addMember(lockedButton);
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
		
			IButton unlockedButton = PermissionControl.createPermissionButton("回款分配解锁", ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_UNLOCK);
			controlLayout.addMember(unlockedButton);
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
		
		IButton autoFitButton = PermissionControl.createPermissionButton("自动分配", ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_AUTO_DISTRIBUTION);
		controlLayout.addMember(autoFitButton);
		autoFitButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要自动分配的回款记录");
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
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
								commonQuery();
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
		
		IButton downloadButton = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_EXPORT);
		controlLayout.addMember(downloadButton);
		downloadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						Map condition = generateCriteria();
						DBDataSource.downloadFile("DW_AllCapitalDistributionInfo", condition);
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
			public void onSuccess() {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条回款记录");
					return;
				}
				CapitalDistributionBarChartPanel panel = new CapitalDistributionBarChartPanel();
				panel.initComponents();
				panel.setContractId(resultGrid.getSelectedRecords()[0].getAttribute("contractId"));
				panel.loadData();
				PopupWindow window = new PopupWindow("回款分配");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.addMember(panel);
				window.show();
			}
			
			@Override
			public void onFailure(Throwable reason) {
				SC.say(ClientStaticUtils.WARNING);
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		SC.debugger();
	  //没有查看所有
	  if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_ALL)) {
	   //没有查看管理部门
	   if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST_PLATE)) {
		   String plateIds = PomPlatformClientUtil.getRolePlateId();
		   criteria.put("projectManageId", ClientUtil.getUserId());
	   }else {
		   String plateIds = PomPlatformClientUtil.getRolePlateId();
		   if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
			   Map<String, String> kv = new HashMap<>();
			   kv.put("key", "and contract_id >0");
			   kv.put("value","AND plate_id in("+plateIds+") and contract_id >0");
			   keyvalues.add(kv);
		   }else {
			   criteria.put("projectManageId", ClientUtil.getUserId());
		   }
	   	}
	  }
	  
	  if(null != criteria.get("status")){
	   int status = BaseHelpUtils.getIntValue(criteria.get("status"));
	   Map<String, String> kv = new HashMap<>();
	   kv.put("key", "WHERE m.locked = ?");
	   StringBuilder sb = new StringBuilder();
	   sb.append("WHERE m.locked = ?");
	   if(status == 0){
	    //尚未回款分配
	    sb.append(" and m.distribution_amount = 0");
	   }else if(status == 1){
	    //已分配金额 > 回款金额
	    sb.append(" and m.distribution_amount != 0 and m.distribution_amount > m.borrow_money");
	   }else if(status == 2){
	    //已分配金额 = 回款金额
	    sb.append(" and m.distribution_amount != 0 and m.distribution_amount = m.borrow_money");
	   }else if(status == 3){
	    //已分配金额 < 回款金额
	    sb.append(" and m.distribution_amount != 0 and m.distribution_amount < m.borrow_money");
	   }
	   kv.put("value", sb.toString());
	   keyvalues.add(kv);
	  }
	  criteria.put("keyValues", keyvalues);
	  return true;
	 }


	@Override
	public SearchForm generateSearchForm() {
		return new AllCapitalDistributionInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAllCapitalDistributionInfo.getInstance();
	}

	public void lockOrUnlockCapitalDistribution(boolean locked){
		if(!resultGrid.anySelected()){
			SC.say("请选择需要锁定的数据");
			return;
		}
		Record[] records = resultGrid.getSelectedRecords();
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
					resultGrid.redraw();
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
/*	*//**
	 * 只有财务部和信息化中心才显示解锁的按钮
	 * @return
	 *//*
	public boolean displayButton(){
		int plateId = ClientUtil.getPlateId();
		if(plateId == ClientStaticUtils.PLATE_ID_19 || plateId == ClientStaticUtils.PLATE_ID_23 || plateId == ClientStaticUtils.PLATE_ID_17){
			return true;
		}
		return false;
	}*/
}

