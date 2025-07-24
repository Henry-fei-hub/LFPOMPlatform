package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.account.datasource.DSEmployeeAccountAll;
import com.pomplatform.client.account.form.EmployeeAccountAllSearchForm;
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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeAccountAllPanel extends AbstractSearchPanel {

	private static final Logger logger = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			EmployeeAccountAllPanel cm = new EmployeeAccountAllPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeAccountAllPanel";
		}

	}
	
	@Override
	public void init() {
		super.init();
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setStatus(0);//初始化为在职
				setFlag(1);//初始化为未转岗
				commonQuery();
			}
		});
		
		IButton statusButton = new IButton("离职人员");
		controlLayout.addMember(statusButton);
		statusButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setStatus(1);
				commonQuery();
			}
		});
		
		IButton turnButton = new IButton("转岗人员");
		controlLayout.addMember(turnButton);
		turnButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setFlag(2);
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@SuppressWarnings({ "rawtypes", "deprecation" })
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
				String employeeName = BaseHelpUtils.getString(selected[0].getAttribute("employeeName"));
				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("leftIntegral"));
				BigDecimal benefitsYear = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("benefitsYear"));
				// 获取检索栏的开始日期和结束日期
				Map condition = generateCriteria();
				Date startDate = null==condition.get("startDate")?new Date("2016-01-01"):(Date) condition.get("startDate");
				Date endDate = null==condition.get("endDate")?new Date():(Date) condition.get("endDate");
				PopupWindow pw = new PopupWindow();
				EmployeeAccountDesignPanel panel = new EmployeeAccountDesignPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setEmployeeId(employeeId);
				panel.setStartDate(startDate);
				panel.setEndDate(endDate);
				panel.setLeftIntegral(leftIntegral);
				panel.setBenefits(benefitsYear);
				panel.initComponents();
				pw.setTitle("职员(" + employeeName + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler(){
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				condition.put("optType","onEmployeeAccountExportData");
				//导出所有的效益指数
//				condition.put("plateId",0);
				DBDataSource.downloadFile("DW_AccountManageProcess", condition);
			}
		});
		
		//导出所有的数据
		IButton allDateButton = PermissionControl.createPermissionButton("导出所有", ERPPermissionStatic.EXPORT_ALL_DATE);
		controlLayout.addMember(allDateButton);
		allDateButton.addClickHandler(new ClickHandler(){
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void onClick(ClickEvent event) {
//				SC.say("1111");
				Map condition = generateCriteria();
				condition.put("optType","onEmployeeAccountExportData");
				//导出所有的效益指数
				condition.put("plateId",0);
				DBDataSource.downloadFile("DW_AccountManageProcess", condition);
			}
		});
		
		
		resultGrid.setShowRowNumbers(true);
		resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("基本信息栏", new String[] {"employeeNo","employeeName","status","gradeId","plateId"}),
				   new HeaderSpan("分析栏", new String[] {"leftIntegral","achieveIntegral","benefits","benefitsYear"}),
				   new HeaderSpan("收入栏", new String[] {"sureIntegral","managerProjectIntegral","salaryAdvance","projectAdvance","performanceBonus","pmPerformanceAward","projectPerformance","plateChangeAchieve","contractDistributionIncome","depDeploy"}),
				   new HeaderSpan("支出栏", new String[] {"salaryReturn","salary","projectCost","bonusPayment","integralReturn","violationCharges","attendanceDeduct","pmPerformanceDeduct","contractChange","plateChangePay","projectPerformancePay","contractDistributionExpenditure","outputAccount"})
			    }); 
		commonQuery();
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		String cancelSummaryFields = "employeeNoField,employeeNameField,statusField,gradeIdField,plateIdField";
		ClientUtil.setCancelGridSummaryFields(resultGrid, cancelSummaryFields);
	}
	
	public void commonQuery() {
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
        condition.put("optType","onLoadEmployeeAccountCustomData");
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                	//获取数据集
                	Record[] records = dsResponse.getData();
                    resultGrid.setData(records);
                    afterDataReceived(records);
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

	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("status",status);
		if(flag == 2){//说明是已转岗
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "and b.plate_id =");
			kv.put("value", "and b.plate_id <>");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)){//如果没有查看所有数据权限
			if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {//如果有查看管理部门权限
				if(BaseHelpUtils.isNullOrEmpty(criteria.get("plateId")) || BaseHelpUtils.getIntValue(criteria.get("plateId")) == 0) {
					SC.say("提示","请选择您管理部门");
					return false;
				}
			}else {//只能查看自己的权限
				criteria.put("employeeId",ClientUtil.getEmployeeId());
			}
		}
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeAccountAllSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeAccountAll.getInstance();
	}
	
	private int status = 0;//在职状态：0：默认是在职;1:离职
	private int flag = 1;//转岗状态：1：默认是未转岗；2：已转岗

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	

}
