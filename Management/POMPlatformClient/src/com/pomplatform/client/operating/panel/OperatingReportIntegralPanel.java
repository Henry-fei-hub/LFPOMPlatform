package com.pomplatform.client.operating.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.operating.datasource.DSOperatingReportIntegralSource;
import com.pomplatform.client.platereportrecorddetail.form.PlateReportRecordDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class OperatingReportIntegralPanel extends AbstractSearchPanel {

	private String plateIds;
	private String[] plateIdArr;

	private static final Logger logger = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OperatingReportIntegralPanel cm = new OperatingReportIntegralPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OperatingReportIntegral";
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
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(ClickEvent event) {
//				ListGridRecord[] records = resultGrid.getRecords();
                Map<String,Object> param  = generateCriteria();
//                MapUtils.convertRecordToMap(resultGrid.getDataSource(), records, param, "exportData");
                //导出方法
                DBDataSource.downloadFile("DW_OnAboutOperatingIntegral", param);
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
					//收入项*********************************
					BigDecimal sureIntegral = BigDecimal.ZERO;// 确认积分
					BigDecimal companySubsidy = BigDecimal.ZERO;// 公司补贴
					BigDecimal achieveOtherPlateIntegral = BigDecimal.ZERO;// 来自其它部门
					BigDecimal developProject = BigDecimal.ZERO;// 研发项目
					BigDecimal manageProject = BigDecimal.ZERO;// 管理项目
					BigDecimal companyAdvance = BigDecimal.ZERO;// 公司借款
					BigDecimal collaborativeAchieve = BigDecimal.ZERO;// 协作收入
					//支出项*********************************
					BigDecimal salaryCost = BigDecimal.ZERO;// 人工成本
					BigDecimal plateCost = BigDecimal.ZERO;// 运营成本
					BigDecimal projectCost = BigDecimal.ZERO;// 项目成本
					BigDecimal payCommonPlateIntegral = BigDecimal.ZERO;// 公共部门分摊
					BigDecimal payOtherPlateIntegral = BigDecimal.ZERO;// 給其它部门积分
					BigDecimal collaborativePay = BigDecimal.ZERO;// 协作支出
					BigDecimal companyFee = BigDecimal.ZERO;// 公司费用
					BigDecimal companyRefund = BigDecimal.ZERO;// 公司还款
					//结余项*********************************
					BigDecimal achieveIntegral = BigDecimal.ZERO;// 价值积分
					BigDecimal awardSend = BigDecimal.ZERO;// 奖金发放
					BigDecimal leftAchieveIntegral = BigDecimal.ZERO;// 剩余价值积分
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						sureIntegral = sureIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("sureIntegral")));
						companySubsidy = companySubsidy.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("companySubsidy")));
						achieveOtherPlateIntegral = achieveOtherPlateIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("achieveOtherPlateIntegral")));
						developProject = developProject.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("developProject")));
						manageProject = manageProject.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("manageProject")));
						companyAdvance = companyAdvance.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("companyAdvance")));
						collaborativeAchieve = collaborativeAchieve.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("collaborativeAchieve")));
						
						salaryCost = salaryCost.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("salaryCost")));
						plateCost = plateCost.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("plateCost")));
						projectCost = projectCost.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("projectCost")));
						payCommonPlateIntegral = payCommonPlateIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("payCommonPlateIntegral")));
						payOtherPlateIntegral = payOtherPlateIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("payOtherPlateIntegral")));
						collaborativePay = collaborativePay.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("collaborativePay")));
						companyFee = companyFee.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("companyFee")));
						companyRefund = companyRefund.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("companyRefund")));
						
						achieveIntegral = achieveIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("achieveIntegral")));
						awardSend = awardSend.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("awardSend")));
						leftAchieveIntegral = leftAchieveIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("leftAchieveIntegral")));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					//收入项*********************************
					record.setAttribute("sureIntegral", sureIntegral);
					record.setAttribute("companySubsidy", companySubsidy);
					record.setAttribute("achieveOtherPlateIntegral", achieveOtherPlateIntegral);
					record.setAttribute("developProject", developProject);
					record.setAttribute("manageProject", manageProject);
					record.setAttribute("companyAdvance", companyAdvance);
					record.setAttribute("collaborativeAchieve", collaborativeAchieve);
					//支出项*********************************
					record.setAttribute("salaryCost", salaryCost);
					record.setAttribute("plateCost", plateCost);
					record.setAttribute("projectCost", projectCost);
					record.setAttribute("payCommonPlateIntegral", payCommonPlateIntegral);
					record.setAttribute("payOtherPlateIntegral", payOtherPlateIntegral);
					record.setAttribute("collaborativePay", collaborativePay);
					record.setAttribute("companyFee", companyFee);
					record.setAttribute("companyRefund", companyRefund);
					//结余项*********************************
					record.setAttribute("achieveIntegral", achieveIntegral);
					record.setAttribute("awardSend", awardSend);
					record.setAttribute("leftAchieveIntegral", leftAchieveIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});
		//commonQuery();
		
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
		criteria.put("optType", "onLoadGirdData");
		Date startDate = (Date) criteria.get("startDate");
		Date endDate = (Date) criteria.get("endDate");
		if (startDate == null) {
			startDate = new Date(116,0,1);
		}

		if (endDate == null) {
			endDate = new Date();
		}
		criteria.put("startDate", startDate);
		criteria.put("endDate", endDate);
		String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
		// 如果没有查看所有部门数据，则只检索自己部门下的数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AWARD_SEND_CHECK_ALL_DATA)) {
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				criteria.put("plateId", "all");
			}
			return true;
		} else {
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
			SC.warn("提示", "您没有查看该部门数据的权限");
			return false;
		}
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OperatingReportIntegralSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOperatingReportIntegralSource.getInstance();
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
        //标题从新写
        resultGrid.setHeaderHeight(60); 
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("分析栏", new String[] {"plateId","achieveIntegral","awardSend","leftAchieveIntegral"}),
		   new HeaderSpan("收入栏", new String[] {"sureIntegral","companySubsidy","achieveOtherPlateIntegral","violationCharges","developProject","manageProject","companyAdvance","collaborativeAchieve"}),
		   new HeaderSpan("支出栏", new String[] {"salaryCost","plateCost","projectCost","payCommonPlateIntegral","payOtherPlateIntegral","collaborativePay","companyFee","companyRefund"})
	    });
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
