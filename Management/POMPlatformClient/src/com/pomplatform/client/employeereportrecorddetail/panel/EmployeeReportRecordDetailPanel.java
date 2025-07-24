package com.pomplatform.client.employeereportrecorddetail.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.employeereportrecorddetail.datasource.DSEmployeeReportRecordDetail;
import com.pomplatform.client.employeereportrecorddetail.form.EmployeeReportRecordDetailSearchForm;
import com.pomplatform.client.employeereportrecorddetail.form.EmployeeReportRecordDetailViewer;
import com.pomplatform.client.plateIntegralAccount.panel.PlateEmpIntegralAccountPanel;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class EmployeeReportRecordDetailPanel extends AbstractSearchPanel {

	private String plateIds;
	private String[] plateIdArr;
	private static final Logger logger = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			EmployeeReportRecordDetailPanel cm = new EmployeeReportRecordDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeReportRecordDetail";
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
				// 获取职员名称
				String employeeName = selected[0].getAttribute("employeeName");
				// 获取检索栏的开始日期和结束日期
				Map condition = generateCriteria();
				Date startDate = null==condition.get("startDate")?new Date("2016-01-01"):(Date) condition.get("startDate");
				Date endDate = null==condition.get("endDate")?new Date():(Date) condition.get("endDate");
				PopupWindow pw = new PopupWindow();
				PlateEmpIntegralAccountPanel plateEmpIntegralAccountPanel = new PlateEmpIntegralAccountPanel(employeeId,
						employeeName, resultGrid, startDate, endDate);
				pw.addItem(plateEmpIntegralAccountPanel);
				pw.setTitle("职员(" + employeeName + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});

		IButton viewButton = new IButton("查看详细");
		viewButton.hide();
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);

		IButton downLoadButton = new IButton("导出");
		controlLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_EmployeeReportRecordDetail", condition);
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
					BigDecimal achieveIntegral = BigDecimal.ZERO;
					BigDecimal sureIntegral = BigDecimal.ZERO;
					BigDecimal managerProjectIntegral = BigDecimal.ZERO;
					BigDecimal salaryAdvance = BigDecimal.ZERO;
					BigDecimal salaryReturn = BigDecimal.ZERO;
					BigDecimal salary = BigDecimal.ZERO;
					BigDecimal projectCost = BigDecimal.ZERO;
					BigDecimal projectAdvance = BigDecimal.ZERO;
					BigDecimal bonusPayment = BigDecimal.ZERO;
					BigDecimal integralReturn = BigDecimal.ZERO;
					BigDecimal violationCharges = BigDecimal.ZERO;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("employeeName"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral = achieveIntegral.add(new BigDecimal(recordList[i].getAttribute("achieveIntegral")));
						sureIntegral = sureIntegral.add(new BigDecimal(recordList[i].getAttribute("sureIntegral")));
						managerProjectIntegral = managerProjectIntegral.add(new BigDecimal(recordList[i].getAttribute("managerProjectIntegral")));
						salaryAdvance = salaryAdvance.add(new BigDecimal(recordList[i].getAttribute("salaryAdvance")));
						salaryReturn = salaryReturn.add(new BigDecimal(recordList[i].getAttribute("salaryReturn")));
						salary = salary.add(new BigDecimal(recordList[i].getAttribute("salary")));
						projectCost = projectCost.add(new BigDecimal(recordList[i].getAttribute("projectCost")));
						projectAdvance = projectAdvance.add(new BigDecimal(recordList[i].getAttribute("projectAdvance")));
						bonusPayment = bonusPayment.add(new BigDecimal(recordList[i].getAttribute("bonusPayment")));
						integralReturn = integralReturn.add(new BigDecimal(recordList[i].getAttribute("integralReturn")));
						violationCharges = violationCharges.add(new BigDecimal(recordList[i].getAttribute("violationCharges")));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("employeeName", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					record.setAttribute("sureIntegral", sureIntegral);
					record.setAttribute("managerProjectIntegral", managerProjectIntegral);
					record.setAttribute("salaryAdvance", salaryAdvance);
					record.setAttribute("salaryReturn", salaryReturn);
					record.setAttribute("salary", salary);
					record.setAttribute("projectCost", projectCost);
					record.setAttribute("projectAdvance", projectAdvance);
					record.setAttribute("bonusPayment", bonusPayment);
					record.setAttribute("integralReturn", integralReturn);
					record.setAttribute("violationCharges", violationCharges);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});
		resultGrid.setShowRowNumbers(true);
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
				detail.setTitle("职员积分汇总");
				detail.setWidth100();
				detail.setHeight100();
				EmployeeReportRecordDetailViewer detailForm = new EmployeeReportRecordDetailViewer();
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
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
			/*
			 * 只拥有查看自己部门数据的权限 ① 用户是否在部门选择下拉框选择了某一个部门想进行信息查看？ ②
			 * Y:用户是否拥有该部门的数据查看权限？ →有权限：返回true； 没有权限：返回false ③
			 * N:默认加载该用户所可以查看的所有部门的信息
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
		}else{
			//只拥有查看自己信息的权限
			criteria.put("employeeNo", ClientUtil.getUserNo());
			return true;
		}
		SC.warn("提示", "您没有查看该部门数据的权限");
		return false;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeReportRecordDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeReportRecordDetail.getInstance();
	}

	private int plateId;
	private Date startDate;
	private Date endDate;

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
