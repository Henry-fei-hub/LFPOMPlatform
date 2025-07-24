package com.pomplatform.client.payment.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.pomplatform.client.payment.datasource.DSOnLoadEmployeePaymentDetail;
import com.pomplatform.client.payment.form.DayPaymentTotalSearchForm;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class DayPaymentTotalPanel extends AbstractSearchPanel
{
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			DayPaymentTotalPanel cm = new DayPaymentTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "DayPaymentTotal";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);
		resultGrid.setGroupByField("employeeId");  
        resultGrid.setShowGridSummary(true);  
        resultGrid.setShowGroupSummary(true);  
        resultGrid.setGroupByMaxRecords(50000);
        resultGrid.setShowGroupSummaryInHeader(true);
        resultGrid.setCanEdit(true);
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
		
		IButton accountMyselfButton = new IButton("统计个人");
		controlLayout.addMember(accountMyselfButton);
		accountMyselfButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onResetEmpDayPayment");
		    	param.put("employeeId",employeeId);
		    	//获取当前计算的年月份
		    	Map condition = generateCriteria();
		    	Date startDate = (Date)condition.get("startDate");
		    	Date endDate = (Date)condition.get("endDate");
		    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
		    		SC.say("提示","请选择开始日期");
		    		return;
		    	}
		    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
		    		SC.say("提示","请选择结束日期");
		    		return;
		    	}
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期需大于开始日期");
		    		return;
		    	}
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	loading.destroy();
		                if (dsResponse.getStatus() >= 0) {
		                	SC.say("提示","操作成功");
		                	commonQuery();
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
		
		IButton accountButton = new IButton("统计所有");
		controlLayout.addMember(accountButton);
		accountButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onResetEmpDayPayment");
		    	param.put("employeeId",0);
		    	//获取当前计算的年月份
		    	Map condition = generateCriteria();
		    	Date startDate = (Date)condition.get("startDate");
		    	Date endDate = (Date)condition.get("endDate");
		    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
		    		SC.say("提示","请选择开始日期");
		    		return;
		    	}
		    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
		    		SC.say("提示","请选择结束日期");
		    		return;
		    	}
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期需大于开始日期");
		    		return;
		    	}
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	param.put("operator",ClientUtil.getEmployeeId());
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	loading.destroy();
//		                if (dsResponse.getStatus() >= 0) {
//		                	SC.say("提示","操作成功");
//		                	commonQuery();
//		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
//		                }
		            }
		        });
			}
		});
		
		IButton deleteButton = new IButton("删除");
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				SC.ask("提示","您确定要删除该记录吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							ListGridRecord[] selected = resultGrid.getSelectedRecords();
							int employeePaymentDetailId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeePaymentDetailId"));
							Map<Object,Object> param = new HashMap<>();
							param.put("employeePaymentDetailId",employeePaymentDetailId);
							final LoadingWindow loading = new LoadingWindow();
							DBDataSource.callOperation("ST_EmployeePaymentDetail", "delete", param, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									loading.destroy();
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示","操作成功");
										commonQuery();
									} else {
										SC.say(dsResponse.getErrors().get("errorMsg").toString());
									}
								}
							});
						}
					}
				});
			}
		});
		
		IButton sendButton = new IButton("推送所有");
//		controlLayout.addMember(sendButton);
		sendButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onSendEmpDayPayment");
		    	//获取当前计算的年月份
		    	Map condition = generateCriteria();
		    	Date startDate = (Date)condition.get("startDate");
		    	Date endDate = (Date)condition.get("endDate");
		    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
		    		SC.say("提示","请选择开始日期");
		    		return;
		    	}
		    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
		    		SC.say("提示","请选择结束日期");
		    		return;
		    	}
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期需大于开始日期");
		    		return;
		    	}
		    	param.put("plateType", 0);//事业部门
		    	param.put("employeeId",0);
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	param.put("operator",ClientUtil.getEmployeeId());
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	loading.destroy();
		                if (dsResponse.getStatus() >= 0) {
		                	SC.say("提示","操作成功");
		                	commonQuery();
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
		
		IButton sendOneButton = new IButton("推送个人");
		controlLayout.addMember(sendOneButton);
		sendOneButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onSendEmpDayPaymentSingle");
		    	//获取当前计算的年月份
		    	Map condition = generateCriteria();
		    	Date startDate = (Date)condition.get("startDate");
		    	Date endDate = (Date)condition.get("endDate");
		    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
		    		SC.say("提示","请选择开始日期");
		    		return;
		    	}
		    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
		    		SC.say("提示","请选择结束日期");
		    		return;
		    	}
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期需大于开始日期");
		    		return;
		    	}
		    	param.put("plateType", 0);//事业部门
		    	param.put("employeeId",employeeId);
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	loading.destroy();
		                if (dsResponse.getStatus() >= 0) {
		                	SC.say("提示","操作成功");
		                	commonQuery();
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
		
		
		IButton sendPlateButton = new IButton("推送营销部");
		controlLayout.addMember(sendPlateButton);
		sendPlateButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onSendEmpDayPayment");
		    	//获取当前计算的年月份
		    	Map condition = generateCriteria();
		    	Date startDate = (Date)condition.get("startDate");
		    	Date endDate = (Date)condition.get("endDate");
		    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
		    		SC.say("提示","请选择开始日期");
		    		return;
		    	}
		    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
		    		SC.say("提示","请选择结束日期");
		    		return;
		    	}
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期需大于开始日期");
		    		return;
		    	}
		    	param.put("plateType", 3);//营销部门
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	param.put("employeeId",0);
		    	param.put("operator",ClientUtil.getEmployeeId());
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//		                if (dsResponse.getStatus() >= 0) {
//		                	loading.destroy();
//		                	SC.say("提示","操作成功");
//		                	commonQuery();
//		                } else {
		                	loading.destroy();
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
//		                }
		            }
		        });
			}
		});
		
		IButton sendPlatesButton = new IButton("推送事业部");
		controlLayout.addMember(sendPlatesButton);
		sendPlatesButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onSendEmpDayPayment");
		    	//获取当前计算的年月份
		    	Map condition = generateCriteria();
		    	Date startDate = (Date)condition.get("startDate");
		    	Date endDate = (Date)condition.get("endDate");
		    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
		    		SC.say("提示","请选择开始日期");
		    		return;
		    	}
		    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
		    		SC.say("提示","请选择结束日期");
		    		return;
		    	}
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期需大于开始日期");
		    		return;
		    	}
		    	param.put("plateType", 1);//事业部门
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	param.put("employeeId",0);
		    	param.put("operator",ClientUtil.getEmployeeId());
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//		                if (dsResponse.getStatus() >= 0) {
//		                	loading.destroy();
//		                	SC.say("提示","操作成功");
//		                	commonQuery();
//		                } else {
		                	loading.destroy();
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
//		                }
		            }
		        });
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("operateEmployeeId",ClientUtil.getEmployeeId());
				params.put("operateTime",new Date());
				DBDataSource.callOperation("ST_EmployeePaymentDetail","saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							commonQuery();
						}
					}
				});
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
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new DayPaymentTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadEmployeePaymentDetail.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
}

