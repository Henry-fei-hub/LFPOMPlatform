package com.pomplatform.client.platereportrecorddetail.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
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
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.account.panel.PlateIntegralAchievePanel;
import com.pomplatform.client.account.panel.PlatePerformanceBonusPanel;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SetPlateIntegralAccount;
import com.pomplatform.client.company.panel.PlateGiveIntegralToCompanyPanel;
import com.pomplatform.client.plateIntegralAccount.panel.PlateIntegralAccountPanel;
import com.pomplatform.client.platereportrecorddetail.datasource.DSPlateReportRecordDetail;
import com.pomplatform.client.platereportrecorddetail.form.PlateReportRecordDetailSearchForm;
import com.pomplatform.client.platereportrecorddetail.form.PlateReportRecordDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PlateReportRecordDetailPanel extends AbstractSearchPanel {

	private static final Logger logger = Logger.getLogger("");
	private String plateIds;
	private String[] plateIdArr;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PlateReportRecordDetailPanel cm = new PlateReportRecordDetailPanel();
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
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton accountButton = PermissionControl.createPermissionButton("汇总计算",
				ERPPermissionStatic.PLATE_ACCOUNT_CALCULATE_BUTTON);
		controlLayout.addMember(accountButton);
		accountButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (ClientUtil
								.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
								|| ClientUtil.checkIsHavePermission(
										ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
							PopupWindow popupWindow = new PopupWindow("汇总计算");
							popupWindow.setWidth("30%");
							popupWindow.setHeight("40%");
							popupWindow.centerInPage();
							SetPlateIntegralAccount account = new SetPlateIntegralAccount();
							account.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							account.initComponents(1, plateIds);
							popupWindow.addItem(account);
							account.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}
					}
				});
			}
		});

		IButton lockButton = PermissionControl.createPermissionButton("汇总加锁",
				ERPPermissionStatic.PLATE_ACCOUNT_LOCK_BUTTON);
		controlLayout.addMember(lockButton);
		lockButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (ClientUtil
								.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
								|| ClientUtil.checkIsHavePermission(
										ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
							PopupWindow popupWindow = new PopupWindow("汇总加锁");
							popupWindow.setWidth("30%");
							popupWindow.setHeight("40%");
							popupWindow.centerInPage();
							SetPlateIntegralAccount account = new SetPlateIntegralAccount();
							account.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							account.initComponents(2, plateIds);
							popupWindow.addItem(account);
							account.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}
					}
				});
			}
		});

		IButton unlockButton = PermissionControl.createPermissionButton("汇总解锁",
				ERPPermissionStatic.PLATE_ACCOUNT_MOVE_LOCK_BUTTON);
		controlLayout.addMember(unlockButton);
		unlockButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (ClientUtil
								.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
								|| ClientUtil.checkIsHavePermission(
										ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
							PopupWindow popupWindow = new PopupWindow("汇总解锁");
							popupWindow.setWidth("30%");
							popupWindow.setHeight("40%");
							popupWindow.centerInPage();
							SetPlateIntegralAccount account = new SetPlateIntegralAccount();
							account.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							account.initComponents(3, plateIds);
							popupWindow.addItem(account);
							account.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}
					}
				});
			}
		});
		
		IButton returnIntegralButton = PermissionControl.createPermissionButton("积分回收",
				ERPPermissionStatic.PLATE_ACCOUNT_ACHIEVE_INTEGRAL_RETURN_BUTTON);
		controlLayout.addMember(returnIntegralButton);
		returnIntegralButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (ClientUtil
								.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
								|| ClientUtil.checkIsHavePermission(
										ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
							PopupWindow popupWindow = new PopupWindow("积分回收");
							popupWindow.setWidth("30%");
							popupWindow.setHeight("40%");
							popupWindow.centerInPage();
							SetPlateIntegralAccount account = new SetPlateIntegralAccount();
							account.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							account.initComponents(4, plateIds);
							popupWindow.addItem(account);
							account.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}
					}
				});
			}
		});

		IButton downLoadButton = PermissionControl.createPermissionButton("汇总导出",
				ERPPermissionStatic.PLATE_ACCOUNT_DOWNLOAD_BUTTON);
		controlLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_PlateReportRecordDetail", condition);
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
				// 获取板块名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取检索栏的开始日期和结束日期
				Map condition = generateCriteria();
				PopupWindow pw = new PopupWindow();
				PlateIntegralAccountPanel plateIntegralAccountPanel = new PlateIntegralAccountPanel(plateId, palteName,
						resultGrid, condition);
				pw.addItem(plateIntegralAccountPanel);
				pw.setTitle("业务部门(" + palteName + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});

		IButton salaryAdvinceButton = PermissionControl.createPermissionButton("积分借款",
				ERPPermissionStatic.PLATE_ACCOUNT_ADVINCE_BUTTON);
		controlLayout.addMember(salaryAdvinceButton);
		salaryAdvinceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("achieveIntegral"));
				final PopupWindow popupWindow = new PopupWindow(palteName + "-积分借款");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				PlateSalaryAdvincePanel assignIntegral = new PlateSalaryAdvincePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				assignIntegral.load(plateId);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		IButton integralReturnButton = new IButton("积分还款");
		controlLayout.addMember(integralReturnButton);
		integralReturnButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("achieveIntegral"));
				final PopupWindow popupWindow = new PopupWindow(palteName + "-积分还款");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				
				
				IntegralReturnOfPlateAccountPanel assignIntegral = new IntegralReturnOfPlateAccountPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				assignIntegral.load(plateId);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		

		IButton projectAdvanceButton = PermissionControl.createPermissionButton("项目补贴",
				ERPPermissionStatic.PLATE_ACCOUNT_PROJECT_ADVANCE_BUTTON);
		controlLayout.addMember(projectAdvanceButton);
		projectAdvanceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("achieveIntegral"));
				final PopupWindow popupWindow = new PopupWindow(palteName + "-项目补贴");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				ProjectAdvancePanel assignIntegral = new ProjectAdvancePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		IButton qualityManageButton = new IButton("品质管理");
		controlLayout.addMember(qualityManageButton);
		qualityManageButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("achieveIntegral"));
				final PopupWindow popupWindow = new PopupWindow(palteName + "-品质管理");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				PlateIntegralAchievePanel assignIntegral = new PlateIntegralAchievePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral,1);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		IButton companyFeeButton = new IButton("公司费用");
		controlLayout.addMember(companyFeeButton);
		companyFeeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("achieveIntegral"));
				final PopupWindow popupWindow = new PopupWindow("公司费用");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				PlateGiveIntegralToCompanyPanel assignIntegral = new PlateGiveIntegralToCompanyPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		IButton porferManceButton = new IButton("绩效奖金");
		controlLayout.addMember(porferManceButton);
		porferManceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("绩效奖金发放");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				PlatePerformanceBonusPanel assignIntegral = new PlatePerformanceBonusPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				assignIntegral.initComponents();
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
//		IButton violationChargesButton = new IButton("项目违规金");
//		controlLayout.addMember(violationChargesButton);
//		violationChargesButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say("failure to download code");
//					}
//
//					@Override
//					public void onSuccess() {
//						if (ClientUtil
//								.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
//								|| ClientUtil.checkIsHavePermission(
//										ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
//							PopupWindow popupWindow = new PopupWindow("收取职员的项目违规金");
//							popupWindow.setWidth("80%");
//							popupWindow.setHeight("80%");
//							popupWindow.centerInPage();
//							PlateGetViolationChargesPanel panel = new PlateGetViolationChargesPanel();
//							panel.addDataEditedHandler(new DataEditedHandler() {
//								@Override
//								public void onDataEdited(DataEditEvent event) {
//									commonQuery();
//								}
//							});
//							panel.initComponents(plateIds);
//							panel.load();
//							popupWindow.addItem(panel);
//							panel.setParentWindow(popupWindow);
//							popupWindow.centerInPage();
//							popupWindow.show();
//						}
//					}
//				});
//			}
//		});

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double achieveIntegral = 0;
					double projectSettlement = 0;
					double companySubsidy = 0;
					double employeeAchieveIntegralReturn = 0;
					double salaryReturn = 0;
					double salaryAdvance = 0;
					double managerProjectIntegral = 0;
					double plateCost = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("achieveIntegral"));
						projectSettlement += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("projectSettlement"));
						companySubsidy += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("companySubsidy"));
						employeeAchieveIntegralReturn += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("employeeAchieveIntegralReturn"));
						salaryReturn += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("salaryReturn"));
						salaryAdvance += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("salaryAdvance"));
						managerProjectIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("managerProjectIntegral"));
						plateCost += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("plateCost"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					record.setAttribute("projectSettlement", projectSettlement);
					record.setAttribute("companySubsidy", companySubsidy);
					record.setAttribute("employeeAchieveIntegralReturn", employeeAchieveIntegralReturn);
					record.setAttribute("salaryReturn", salaryReturn);
					record.setAttribute("salaryAdvance", salaryAdvance);
					record.setAttribute("managerProjectIntegral", managerProjectIntegral);
					record.setAttribute("plateCost", plateCost);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});

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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
			/*
			 * 只拥有查看自己部门数据的权限 ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？ ②Y:用户是否拥有该部门的数据查看权限？
			 * →有权限：返回true； 没有权限：返回false ③N:默认加载该用户所可以查看的所有部门的信息
			 */
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				criteria.put("plateId", plateIds);
				return true;
			} else {
				for (String str : plateIdArr) {
					if (selectPlateId.equals(str)) {
						return true;
					}
				}
			}
		}
		SC.warn("提示", "您没有查看该部门数据的权限");
		return false;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PlateReportRecordDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateReportRecordDetail.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
    public Canvas getViewPanel() {
        init();
        searchForm = generateSearchForm();
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundColor("#e2e2e2");

        if (searchForm != null) {
            ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);

            searchLayout.addMember(buttonLayout);

            searchButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
        }
        VLayout resultLayout = new VLayout();
        resultLayout.setWidth100();
        resultLayout.setHeight100();
        if (__needControl) {
            switch (__controlPosition) {
                case LayoutConstant.TOP:
                case LayoutConstant.BOTTOM:
                    toolBar = new ToolStrip();
                    toolBar.setHeight(40);
                    break;
                case LayoutConstant.RIGHT:
                case LayoutConstant.LEFT:
                    controlLayout = new VLayout();
                    controlLayout.setHeight100();
                    controlLayout.setWidth(120);
                    controlLayout.setLayoutTopMargin(30);
                    controlLayout.setLayoutLeftMargin(5);
                    controlLayout.setLayoutRightMargin(5);
                    controlLayout.setMembersMargin(10);
                    break;
            }
        }
        if (__needControl && __controlPosition == LayoutConstant.TOP) {
            resultLayout.addMember(toolBar);
        }
        HLayout main = new HLayout();
        main.setWidth100();
        main.setHeight100();
        resultLayout.addMember(main);
        if (__needControl && __controlPosition == LayoutConstant.LEFT) {
            main.addMember(controlLayout);
        }
        Canvas mainCanvas = null;
        if (__layoutMode == LayoutConstant.LEFTRIGHT) {
            mainCanvas = generateHDataCanvas();
        } else {
            mainCanvas = generateVDataCanvas();
        }
        main.addMember(mainCanvas);
        if (__needControl && __controlPosition == LayoutConstant.RIGHT) {
            main.addMember(controlLayout);
        }
        if (__needControl && __controlPosition == LayoutConstant.BOTTOM) {
            resultLayout.addMember(toolBar);
        }
        layout.addMember(resultLayout);
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
    }
}
