package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.account.datasource.DSPlateAccountAllChildSource;
import com.pomplatform.client.account.datasource.DSPlateAccountAllSource;
import com.pomplatform.client.account.form.PlateAccountAllSearchForm;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.platereportrecorddetail.form.PlateReportRecordDetailViewer;
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
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PlateAccountAllPanel extends AbstractExpansionRelatedPage {

	private static final Logger logger = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PlateAccountAllPanel cm = new PlateAccountAllPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateReportRecordDetail";
		}

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


		IButton downLoadButton = PermissionControl.createPermissionButton("导出",
				ERPPermissionStatic.PLATE_ACCOUNT_DOWNLOAD_BUTTON);
		controlLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				condition.remove("parentId");
				condition.put("optType","onPlateAccountExportData");
				DBDataSource.downloadFile("DW_AccountManageProcess", condition);
			}
		});
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
//				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("leftIntegral"));
				// 获取检索栏的开始日期和结束日期
				Map condition = generateCriteria();
				Date startDate = (Date)condition.get("startDate");
				Date endDate = (Date)condition.get("endDate");
				PopupWindow pw = new PopupWindow();
				PlateAccountDesignPanel panel = new PlateAccountDesignPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setStartDate(startDate);
				panel.setEndDate(endDate);
//				panel.setLeftIntegral(leftIntegral);
				panel.initComponents();
				pw.setTitle("业务部门汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});


		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal achieveIntegral = BigDecimal.ZERO;
					//*******************收入项******************
					BigDecimal projectSettlement = BigDecimal.ZERO;
					BigDecimal companySubsidy = BigDecimal.ZERO;
					BigDecimal employeeAchieveIntegralReturn = BigDecimal.ZERO;
					BigDecimal salaryReturn = BigDecimal.ZERO;
					BigDecimal violationCharges = BigDecimal.ZERO;
					BigDecimal collaborativeAchieve = BigDecimal.ZERO;
					BigDecimal attendanceDeduct = BigDecimal.ZERO;
					BigDecimal endProject = BigDecimal.ZERO;
					BigDecimal saleIntegral = BigDecimal.ZERO;
					BigDecimal sendAchieve = BigDecimal.ZERO;
					BigDecimal contractDistributionIncome = BigDecimal.ZERO;
					BigDecimal projectPerformance = BigDecimal.ZERO;
					//*******************支出项******************
					BigDecimal salaryAdvance = BigDecimal.ZERO;
					BigDecimal managerProjectIntegral = BigDecimal.ZERO;
					BigDecimal plateCost = BigDecimal.ZERO;
					BigDecimal projectAdvance = BigDecimal.ZERO;
					BigDecimal companyFee = BigDecimal.ZERO;
					BigDecimal collaborativePay = BigDecimal.ZERO;
					BigDecimal performanceBonus = BigDecimal.ZERO;
					BigDecimal developProject = BigDecimal.ZERO;
					BigDecimal manageProject = BigDecimal.ZERO;
					BigDecimal contractChange = BigDecimal.ZERO;
					BigDecimal sendPay = BigDecimal.ZERO;
					BigDecimal employeeCost = BigDecimal.ZERO;
					BigDecimal contractDistributionExpenditure = BigDecimal.ZERO;
					BigDecimal projectPerformancePay = BigDecimal.ZERO;
					BigDecimal depDeploy = BigDecimal.ZERO;
					BigDecimal outputAccount = BigDecimal.ZERO;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						leftIntegral = leftIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("leftIntegral")));
						achieveIntegral = achieveIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("achieveIntegral")));
						//*******************收入项******************
						projectSettlement = projectSettlement.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("projectSettlement")));
						companySubsidy = companySubsidy.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("companySubsidy")));
						employeeAchieveIntegralReturn = employeeAchieveIntegralReturn.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("employeeAchieveIntegralReturn")));
						salaryReturn = salaryReturn.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("salaryReturn")));
						violationCharges = violationCharges.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("violationCharges")));
						collaborativeAchieve = collaborativeAchieve.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("collaborativeAchieve")));
						attendanceDeduct = attendanceDeduct.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("attendanceDeduct")));
						endProject = endProject.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("endProject")));
						saleIntegral = saleIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("saleIntegral")));
						sendAchieve = sendAchieve.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("sendAchieve")));
						contractDistributionIncome = contractDistributionIncome.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("contractDistributionIncome")));
						projectPerformance = projectPerformance.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("projectPerformance")));
						//*******************支出项******************
						salaryAdvance = salaryAdvance.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("salaryAdvance")));
						managerProjectIntegral = managerProjectIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("managerProjectIntegral")));
						plateCost = plateCost.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("plateCost")));
						projectAdvance = projectAdvance.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("projectAdvance")));
						companyFee = companyFee.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("companyFee")));
						collaborativePay = collaborativePay.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("collaborativePay")));
						performanceBonus = performanceBonus.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("performanceBonus")));
						developProject = developProject.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("developProject")));
						manageProject = manageProject.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("manageProject")));
						contractChange = contractChange.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("contractChange")));
						sendPay = sendPay.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("sendPay")));
						employeeCost = employeeCost.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("employeeCost")));
						contractDistributionExpenditure = contractDistributionExpenditure.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("contractDistributionExpenditure")));
						projectPerformancePay = projectPerformancePay.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("projectPerformancePay")));
						depDeploy = depDeploy.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("depDeploy")));
						outputAccount = outputAccount.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("outputAccount")));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("leftIntegral", leftIntegral);
					record.setAttribute("achieveIntegral", achieveIntegral);
					//*******************收入项******************
					record.setAttribute("projectSettlement", projectSettlement);
					record.setAttribute("companySubsidy", companySubsidy);
					record.setAttribute("employeeAchieveIntegralReturn", employeeAchieveIntegralReturn);
					record.setAttribute("salaryReturn", salaryReturn);
					record.setAttribute("violationCharges", violationCharges);
					record.setAttribute("collaborativeAchieve", collaborativeAchieve);
					record.setAttribute("attendanceDeduct", attendanceDeduct);
					record.setAttribute("endProject", endProject);
					record.setAttribute("saleIntegral", saleIntegral);
					record.setAttribute("sendAchieve", sendAchieve);
					record.setAttribute("contractDistributionIncome", contractDistributionIncome);
					record.setAttribute("projectPerformance", projectPerformance);
					//*******************支出项******************
					record.setAttribute("salaryAdvance", salaryAdvance);
					record.setAttribute("managerProjectIntegral", managerProjectIntegral);
					record.setAttribute("plateCost", plateCost);
					record.setAttribute("projectAdvance", projectAdvance);
					record.setAttribute("companyFee", companyFee);
					record.setAttribute("collaborativePay", collaborativePay);
					record.setAttribute("performanceBonus", performanceBonus);
					record.setAttribute("developProject", developProject);
					record.setAttribute("manageProject", manageProject);
					record.setAttribute("contractChange", contractChange);
					record.setAttribute("sendPay", sendPay);
					record.setAttribute("employeeCost", employeeCost);
					record.setAttribute("contractDistributionExpenditure", contractDistributionExpenditure);
					record.setAttribute("projectPerformancePay", projectPerformancePay);
					record.setAttribute("depDeploy", depDeploy);
					record.setAttribute("outputAccount", outputAccount);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});
		setCommonHeaderSpans(resultGrid);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("业务部门积分汇总");
				detail.setWidth100();
				detail.setHeight100();
				PlateReportRecordDetailViewer detailForm = new PlateReportRecordDetailViewer();
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("parentId", 1);
		criteria.put("optType","onLoadPlateAccountData");
		// 如果没有任何权限，则不可进行查询操作
		//拥有查看所有部门信息的权限
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)){
			criteria.put("checkType",1);
			return true;
		//拥有查看自己管理部门的信息
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)){
			criteria.put("checkType",2);
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			criteria.put("plateIds",plateIds);
			return true;
		}else{
			SC.warn("提示", "您没有查看部门数据的权限");
			return false;
		}
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PlateAccountAllSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateAccountAllSource.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public DataSource getChildDataSource() {
		return DSPlateAccountAllChildSource.getInstance();
	}
	
	@Override
	public boolean doCustomCommonQuery() {
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void customCommonQuery(ListGridRecord record,ListGrid childGrid) {
		//根据父级plateId去检索子级的数据集
		int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
		//获取父级查询的开始日期和结束日期
		Map param = generateCriteria();
		Map<String,Object> map = new HashMap<>();
		map.put("parentId", plateId);
		map.put("optType", "onLoadPlateAccountData");
		map.put("startDate", param.get("startDate"));
		map.put("endDate", param.get("endDate"));
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_AccountManageProcess", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					childGrid.setData(dsResponse.getData());
				}
			}
		});
	}
	
	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		resultChildGrid.setCanRemoveRecords(false);
		resultChildGrid.setAutoFitFieldWidths(false);
		resultChildGrid.setHeight(400);
		resultChildGrid.setShowGridSummary(true);
		resultChildGrid.setWidth(resultGrid.getWidth()+400);
		setCommonHeaderSpans(resultChildGrid);
		resultChildGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultChildGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultChildGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("leftIntegral"));
				// 获取检索栏的开始日期和结束日期
				Map condition = generateCriteria();
				Date startDate = (Date)condition.get("startDate");
				Date endDate = (Date)condition.get("endDate");
				PopupWindow pw = new PopupWindow();
				PlateAccountDesignPanel panel = new PlateAccountDesignPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setStartDate(startDate);
				panel.setEndDate(endDate);
				panel.setLeftIntegral(leftIntegral);
				panel.initComponents();
				pw.setTitle("业务部门汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
	}
	
	//设置标题栏分组
	public void setCommonHeaderSpans(ListGrid grid){
		grid.setHeaderHeight(60);  
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("分析栏", new String[] {"plateId","leftIntegral","achieveIntegral"}),
		   new HeaderSpan("收入栏", new String[] {"projectSettlement","companySubsidy","employeeAchieveIntegralReturn","salaryReturn","violationCharges","collaborativeAchieve","companyAdvance","attendanceDeduct","endProject","saleIntegral","sendAchieve","contractDistributionIncome","projectPerformance"}),
		   new HeaderSpan("支出栏", new String[] {"salaryAdvance","managerProjectIntegral","plateCost","projectAdvance","companyFee","collaborativePay","companyRefund","performanceBonus","developProject","manageProject","contractChange","sendPay","employeeCost","contractDistributionExpenditure","projectPerformancePay","depDeploy","outputAccount"})
	    });
	}

}
