package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.account.datasource.DSPlateAccountMonthReportSource;
import com.pomplatform.client.account.datasource.DSPlateAccountSource;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.company.panel.CompanyRepaymentPanel;
import com.pomplatform.client.company.panel.PlateGiveIntegralToCompanyPanel;
import com.pomplatform.client.contract.panel.ContractDistributionMonthlyDetailPanel;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.employeereportrecorddetail.panel.PlateGetViolationChargesPanel;
import com.pomplatform.client.platecostrecord.panel.PlateCostMonthlyDetailPanel;
import com.pomplatform.client.platereportrecorddetail.panel.IntegralReturnOfPlateAccountPanel;
import com.pomplatform.client.platereportrecorddetail.panel.PlateSalaryAdvincePanel;
import com.pomplatform.client.platereportrecorddetail.panel.ProjectAdvancePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlateAccountDesignPanel extends HLayout implements HasHandlers {
	private static Logger __logger = Logger.getLogger("");
	// 定义面板样式
	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
	//**************************定义部门账户的业务功能类型*************
	public static final int PLATE_BT_SURE_INTEGRAL = 1;//确认积分(收入)
    public static final int PLATE_BT_COMPANY_SUBSIDY = 2;//公司补贴(收入)
    public static final int PLATE_BT_INTEGRAL_RECYCLE = 3;//积分回收(收入)
    public static final int PLATE_BT_SALAEY_REFUND = 4;//积分还款(收入)
    public static final int PLATE_BT_INTEGRAL_ADVANCE = 5;//积分借款(支出)
    public static final int PLATE_BT_BONUS_SUBSIDY = 6;//奖金补贴(支出)
    public static final int PLATE_BT_PLATE_COST = 7;//运营成本(支出)
    public static final int PLATE_BT_PROJECT_SUBSIDY = 8;//项目补贴(支出)
    public static final int PLATE_BT_COLLABORATIVE_ACHIEVE = 9;//协作收入(收入)
    public static final int PLATE_BT_COLLABORATIVE_PAY = 10;//协作支出(支出)
    public static final int PLATE_BT_PERFORMANCE_BONUS = 11;//绩效奖金(支出)
    public static final int PLATE_BT_COMPANY_FEE = 12;//公司费用(支出)
    public static final int PLATE_BT_VIOLATION_CHARGES = 13;//资源绩效(收入)
    public static final int PLATE_BT_COMPANY_REFUND = 14;//公司还款(支出)
    public static final int PLATE_BT_COMPANY_ADVANCE = 15;//公司借款(收入)
    public static final int PLATE_BT_DEVELOP_PROJECT = 16;//研发项目(支出)
    public static final int PLATE_BT_MANAGE_PROJECT = 17;//管理项目(支出)
    public static final int PLATE_BT_ATTENDANCE_DEDUCT = 18;//考勤扣款(收入)
    public static final int PLATE_BT_CONTRACT_CHANGE = 19;//合同变更(支出)
    public static final int PLATE_BT_END_PROJECT = 20;//项目结项（收入）
    public static final int PLATE_BT_SALE_INTEGRAL = 21;//销售积分（收入）
    public static final int PLATE_BT_SEND_ACHIEVE = 22;//分配收入（收入）
    public static final int PLATE_BT_SEND_PAY = 23;//分配支出（支出）
    public static final int PLATE_BT_EMPLOYEE_COST = 24;//人工成本（支出）
    public static final int PLATE_BT_CONTRACT_DISTRIBUTION_INCOME = 25;//提成收入
    public static final int PLATE_BT_CONTRACT_DISTRIBUTION_EXPENDITURE = 26;//提成支出
    public static final int PLATE_BT_PROJECT_PERFORMANCE = 27;//项目绩效收入
    public static final int PLATE_BT_PROJECT_PERFORMANCE_PAY = 28;//项目绩效支出
	public static final int PLATE_BT_DEP_DEPLOY = 29;//部门调配支出
	public static final int PLATE_BT_OUTPUT_ACCOUNT = 30;//产值结算支出
	// 定义整个面板的layout,整个面板分头部面板和中心面板
	private VLayout mainLayout;
	// 定义头部面板，包括左右两个面板
	private HLayout topVLayout;
	// 定义中心面板，包括左、中、右三个主面板
	private HLayout centerLayout;
	// 定义中心面板的左面板，包括上、下连个面板
	private VLayout centerLeftLayout;
	// 定义中心面板的中面板，包括上、下连个面板
	private VLayout centerMiddleLayout;
	// 定义中心面板的右面板
	private VLayout centerRightLayout;
	private HLayout chartOneLayout;
	private HLayout chartTwoLayout;
	private Chart chartOne;
	private Chart chartTwo;
	private DateItem startDateItem;
	private DateItem endDateItem;
	private DelicacyListGrid achieveGrid;
	private DelicacyListGrid payGrid;
	private HLayout middleTopLayout;
	private HLayout middleBottomLayout;
	private DelicacyListGrid monthReportGrid;
	private SelectItem plateIdItem;

	@SuppressWarnings("deprecation")
	public void initComponents() {
		mainLayout = new VLayout();
		mainLayout.setBackgroundColor("#FFF");
		mainLayout.setBorder("2px solid #e2e2e2;border-radius:5px");
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		topVLayout = new HLayout();
		topVLayout.setWidth100();
		topVLayout.setHeight("5%");
		topVLayout.setBackgroundColor("#e2e2e2");

		startDateItem = new DateItem("startDate", "开始年月份");
		startDateItem.setWidth("*");
		startDateItem.setShowIcons(false);
		if(startDate != null){
			startDateItem.setDefaultValue(startDate);
		}else{
			startDateItem.setDefaultValue(new Date("2016-01-01"));
		}
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		endDateItem = new DateItem("endDate", "结束年月份");
		endDateItem.setWidth("*");
		endDateItem.setShowIcons(false);
		if(endDate != null){
			endDateItem.setDefaultValue(endDate);
		}else{
			Date date = new Date();
			date.setMonth(11);
			endDateItem.setDefaultValue(date);
		}
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		DynamicForm dateForm = new DynamicForm();
		dateForm.setWidth100();
		dateForm.setHeight100();
		dateForm.setNumCols(7);
		dateForm.setMargin(10);
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查看所有的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)){
			plateIdItem.setDefaultValue(plateId);
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		//如果只拥有查看自己管理部门的权限
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
//			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
//				String[] palteIdArr = plateIds.split(","); 
				plateIdItem.setDefaultValue(plateId);
//			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		plateIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int plateIdValue = BaseHelpUtils.getIntValue(event.getValue());
				setPlateId(plateIdValue);
			}
		});
		dateForm.setItems(plateIdItem,startDateItem, endDateItem);

		IButton calculateButton = new IButton("账户统计");

		HLayout topLeftHLayout = new HLayout();
        topLeftHLayout.setWidth("25%");
        
        HLayout topMiddleHLayout = new HLayout();
        topMiddleHLayout.setWidth("70%");
        topMiddleHLayout.setLayoutLeftMargin(5);
        topMiddleHLayout.setLayoutRightMargin(5);
        topMiddleHLayout.setMembersMargin(10);
        topMiddleHLayout.addMember(dateForm);
		
		HLayout topRightHLayout = new HLayout();
		topRightHLayout.setBackgroundColor("#e2e2e2");
		topRightHLayout.setHeight100();
		topRightHLayout.setWidth("5%");
		topRightHLayout.setLayoutTopMargin(10);
		topRightHLayout.setLayoutLeftMargin(5);
		topRightHLayout.setLayoutRightMargin(5);
		topRightHLayout.setMembersMargin(10);
		topRightHLayout.addMember(calculateButton);

		topVLayout.addMember(topLeftHLayout);
		topVLayout.addMember(topMiddleHLayout);
		topVLayout.addMember(topRightHLayout);
		mainLayout.addMember(topVLayout);

		centerLayout = new HLayout(10);
		centerLayout.setHeight("95%");
		centerLayout.setWidth100();
		centerLayout.setMembersMargin(10);
		centerLayout.setLayoutTopMargin(10);
		mainLayout.addMember(centerLayout);
		
		HLayout centerLeft = new HLayout(10);
		centerLeft.setHeight100();
		centerLeft.setWidth("95%");
		centerLeft.setMembersMargin(10);
		centerLayout.addMember(centerLeft);
		
		VLayout centerRight= new VLayout(10);
		centerRight.setHeight100();
		centerRight.setWidth("5%");
		centerRight.setLayoutTopMargin(10);
		centerRight.setBackgroundColor("#e2e2e2");
		centerRight.setMembersMargin(10);
		centerRight.setLayoutLeftMargin(5);
		centerRight.setLayoutRightMargin(5);
		centerLayout.addMember(centerRight);
		
		IButton returnIntegralButton = PermissionControl.createPermissionButton("积分回收",ERPPermissionStatic.PLATE_ACCOUNT_ACHIEVE_INTEGRAL_RETURN_BUTTON);
		IButton salaryAdvinceButton = PermissionControl.createPermissionButton("积分借款",ERPPermissionStatic.PLATE_ACCOUNT_ADVINCE_BUTTON);
		IButton projectAdvanceButton = PermissionControl.createPermissionButton("项目补贴",ERPPermissionStatic.PLATE_ACCOUNT_PROJECT_ADVANCE_BUTTON);
		IButton qualityManageButton = PermissionControl.createPermissionButton("品质管理",ERPPermissionStatic.PLATE_ACCOUNT_QUALITY_MANAGE_BUTTON);
		IButton companyFeeButton = PermissionControl.createPermissionButton("公司费用",ERPPermissionStatic.PLATE_ACCOUNT_COMPANY_FEE_BUTTON);
		IButton porferManceButton = PermissionControl.createPermissionButton("绩效奖金",ERPPermissionStatic.PLATE_ACCOUNT_PORGER_MANCE_BUTTON);
		IButton integralReturnButton = PermissionControl.createPermissionButton("积分还款",ERPPermissionStatic.PLATE_ACCOUNT_RETURN_INTEGRAL_BUTTON);
		IButton companyRepaymentButton = PermissionControl.createPermissionButton("公司还款",ERPPermissionStatic.PLATE_ACCOUNT_COMPANY_RETURN_BUTTON);
		IButton violationChargesButton = PermissionControl.createPermissionButton("资源绩效",ERPPermissionStatic.PLATE_ACCOUNT_VIOLATION_BUTTON);
		IButton integralDistributionsButton = PermissionControl.createPermissionButton("分配积分",ERPPermissionStatic.PLATE_ACCOUNT_INTEGRAL_DISTRIBUTION_BUTTON);
		IButton collaborativeFeeButton = PermissionControl.createPermissionButton("协作费用",ERPPermissionStatic.PLATE_ACCOUNT_COLLABORATIVE_FEE_BUTTON);
		IButton depDeployButton = PermissionControl.createPermissionButton("部门调配",ERPPermissionStatic.PLATE_ACCOUNT_DEP_DEPLOY_BUTTON);
        IButton outputAccountButton = PermissionControl.createPermissionButton("产值结算",ERPPermissionStatic.PLATE_ACCOUNT_OUTPUT_ACCOUNT_BUTTON);

		centerRight.addMember(returnIntegralButton);
		centerRight.addMember(salaryAdvinceButton);
		centerRight.addMember(projectAdvanceButton);
		centerRight.addMember(qualityManageButton);
		centerRight.addMember(companyFeeButton);
		centerRight.addMember(porferManceButton);
		centerRight.addMember(integralReturnButton);
		centerRight.addMember(companyRepaymentButton);
		centerRight.addMember(violationChargesButton);
		centerRight.addMember(collaborativeFeeButton);
		centerRight.addMember(depDeployButton);
        centerRight.addMember(outputAccountButton);

		//积分回收
		returnIntegralButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				final PopupWindow popupWindow = new PopupWindow(palteName + "-积分回收");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				IntegralReturnPanel assignIntegral = new IntegralReturnPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, valueOfIntegral);
				assignIntegral.load(plateId);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		//积分借款
		salaryAdvinceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = valueOfIntegral;
				final PopupWindow popupWindow = new PopupWindow(palteName + "-积分借款");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				PlateSalaryAdvincePanel assignIntegral = new PlateSalaryAdvincePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				assignIntegral.load(plateId);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//项目补贴
		projectAdvanceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = valueOfIntegral;
				final PopupWindow popupWindow = new PopupWindow(palteName + "-项目补贴");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				ProjectAdvancePanel assignIntegral = new ProjectAdvancePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//品质管理
		qualityManageButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = valueOfIntegral;
				final PopupWindow popupWindow = new PopupWindow(palteName + "-品质管理");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				PlateIntegralAchievePanel assignIntegral = new PlateIntegralAchievePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral,1);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//协作费用
		collaborativeFeeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = valueOfIntegral;
				final PopupWindow popupWindow = new PopupWindow(palteName + "-协作费用");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				PlateIntegralAchievePanel assignIntegral = new PlateIntegralAchievePanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral,2);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//公司费用
		companyFeeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = valueOfIntegral;
				final PopupWindow popupWindow = new PopupWindow("公司费用");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				PlateGiveIntegralToCompanyPanel assignIntegral = new PlateGiveIntegralToCompanyPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//绩效奖金
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
						loadData();
					}
				});
				assignIntegral.initComponents();
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//资源绩效
		violationChargesButton.addClickHandler(new ClickHandler() {
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
							PopupWindow popupWindow = new PopupWindow("收取职员的资源绩效");
							popupWindow.setWidth("80%");
							popupWindow.setHeight("80%");
							popupWindow.centerInPage();
							PlateGetViolationChargesPanel panel = new PlateGetViolationChargesPanel();
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									loadData();
								}
							});
							panel.initComponents(plateId);
							panel.load(plateId);
							popupWindow.addItem(panel);
							panel.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}
					}
				});
			}
		});
		
		//公司还款
		companyRepaymentButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				final PopupWindow popupWindow = new PopupWindow(palteName + "-公司还款");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				
				CompanyRepaymentPanel assignIntegral = new CompanyRepaymentPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, valueOfIntegral);
				assignIntegral.load(plateId, new Date());
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
				
			}
		});
		
	
		//积分还款
		integralReturnButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				final PopupWindow popupWindow = new PopupWindow(palteName + "-积分还款");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("90%");
				popupWindow.centerInPage();
				IntegralReturnOfPlateAccountPanel assignIntegral = new IntegralReturnOfPlateAccountPanel();
				assignIntegral.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						loadData();
					}
				});
				assignIntegral.initComponents(plateId, palteName, valueOfIntegral);
				assignIntegral.load(plateId);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		//查看该部门是不是一级部门
		Map<String,Object> map = new HashMap<>();
		map.put("plateId", plateId);
		DBDataSource.callOperation("ST_PlateRecord", "find", map, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("parentId"))){
						//如果是一级部门，则显示[分配积分]按钮
						if(record.getAttributeAsInt("parentId") == 0){
							centerRight.addMember(integralDistributionsButton);
							//加载该部门下面的子部门
							onLoadPlates();
						}
					}
				}
			}
		});
		
		
		//分配积分
		integralDistributionsButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				BigDecimal achieveIntegral = valueOfIntegral;
				final PopupWindow popupWindow = new PopupWindow(palteName + "-分配积分");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				PlateIntegralDistributionsPanel assignIntegral = new PlateIntegralDistributionsPanel();
				assignIntegral.setMap(lhm);
				assignIntegral.initComponents(plateId, palteName, achieveIntegral);
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						loadData();
					}
				});
				assignIntegral.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		//部门调配
		depDeployButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						// 获取业务部门价值积分
						BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(valueOfIntegral);
						if(achieveIntegral.compareTo(BigDecimal.ZERO) <= 0){
							SC.say("提示","部门剩余积分不足");
							return;
						}
						PopupWindow popupWindow = new PopupWindow("部门调配");
						popupWindow.setWidth("80%");
						popupWindow.setHeight("80%");
						popupWindow.centerInPage();
						DepDeployPanel panel = new DepDeployPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								loadData();
							}
						});
						panel.initComponents(plateId,achieveIntegral);
						panel.load();
						popupWindow.addItem(panel);
						panel.setParentWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});

        //产值结算
        outputAccountButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }
                    @Override
                    public void onSuccess() {
                        // 获取业务部门价值积分
                        BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(valueOfIntegral);
                        if(achieveIntegral.compareTo(BigDecimal.ZERO) < 0){
                            achieveIntegral = BigDecimal.ZERO;
                        }
                        PopupWindow popupWindow = new PopupWindow("产值结算");
                        popupWindow.setWidth("80%");
                        popupWindow.setHeight("90%");
                        popupWindow.centerInPage();
                        OutputAccountPanel panel = new OutputAccountPanel();
                        panel.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                loadData();
                            }
                        });
                        panel.initComponents(plateId,achieveIntegral);
                        panel.load(plateId);
                        popupWindow.addItem(panel);
                        panel.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }
                });
            }
        });
		
		centerLeftLayout = new VLayout(20);
		centerLeftLayout.setIsGroup(true);
		centerLeftLayout.setGroupBorderCSS(layoutGroupStyle);
		centerLeftLayout.setGroupLabelBackgroundColor("#555555");
		centerLeftLayout.setGroupTitle("数据模型图");
		centerLeftLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerLeftLayout.setHeight100();
		centerLeftLayout.setWidth("25%");
		centerLeftLayout.setMembersMargin(20);

		centerLeft.addMember(centerLeftLayout);

		chartOneLayout = new HLayout();
		chartOneLayout.setWidth100();
		chartOneLayout.setHeight("50%");

		centerLeftLayout.addMember(chartOneLayout);

		chartTwoLayout = new HLayout();
		chartTwoLayout.setWidth100();
		chartTwoLayout.setHeight("50%");

		centerLeftLayout.addMember(chartTwoLayout);

		centerMiddleLayout = new VLayout();
		centerMiddleLayout.setHeight("98%");
		centerMiddleLayout.setWidth("25%");
		centerMiddleLayout.setMembersMargin(10);
		centerLeft.addMember(centerMiddleLayout);

		middleTopLayout = new HLayout();
		middleTopLayout.setWidth100();
		middleTopLayout.setHeight("50%");
		middleTopLayout.setIsGroup(true);
		middleTopLayout.setGroupBorderCSS(layoutGroupStyle);
		middleTopLayout.setGroupLabelBackgroundColor("#555555");
		middleTopLayout.setGroupTitle("收入栏");
		middleTopLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerMiddleLayout.addMember(middleTopLayout);
		
		achieveGrid = new DelicacyListGrid();
		achieveGrid.setAutoFitFieldWidths(false);
		achieveGrid.setDataSource(DSPlateAccountSource.getInstance());
		achieveGrid.setShowGridSummary(true);
		ListGridField[] achieveFields = new ListGridField[2];
		int achieveIdx = 0;
		achieveFields[achieveIdx] = new ListGridField("businessTypeId");
		achieveFields[achieveIdx].setShowGridSummary(false);
		achieveIdx++;
		achieveFields[achieveIdx] = new ListGridField("integral");
		achieveIdx++;
		achieveGrid.setFields(achieveFields);
		middleTopLayout.addMember(achieveGrid);

		middleBottomLayout = new HLayout();
		middleBottomLayout.setWidth100();
		middleBottomLayout.setHeight("50%");
		middleBottomLayout.setIsGroup(true);
		middleBottomLayout.setGroupBorderCSS(layoutGroupStyle);
		middleBottomLayout.setGroupLabelBackgroundColor("#555555");
		middleBottomLayout.setGroupTitle("支出栏");
		middleBottomLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerMiddleLayout.addMember(middleBottomLayout);
		
		payGrid = new DelicacyListGrid();
		payGrid.setAutoFitFieldWidths(false);
		payGrid.setDataSource(DSPlateAccountSource.getInstance());
		payGrid.setShowGridSummary(true);
		ListGridField[] payFields = new ListGridField[2];
		int payIdx = 0;
		payFields[payIdx] = new ListGridField("businessTypeId");
		payFields[payIdx].setShowGridSummary(false);
		payIdx++;
		payFields[payIdx] = new ListGridField("integral");
		payIdx++;
		payGrid.setFields(payFields);
		middleBottomLayout.addMember(payGrid);

		centerRightLayout = new VLayout(20);
		centerRightLayout.setIsGroup(true);
		centerRightLayout.setGroupBorderCSS(layoutGroupStyle);
		centerRightLayout.setGroupLabelBackgroundColor("#555555");
		centerRightLayout.setGroupTitle("明细栏");
		centerRightLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerRightLayout.setHeight("98%");
		centerRightLayout.setWidth("50%");
		centerRightLayout.setMembersMargin(10);
		centerLeft.addMember(centerRightLayout);
		
		chartOneSet();
		chartOneLayout.addMember(chartOne);
		chartTwo = new Chart();
		chartTwoSet();
		chartTwoLayout.addMember(chartTwo);

		addMember(mainLayout);
		
		monthReportGrid = new DelicacyListGrid();
		monthReportGrid.setAutoFitFieldWidths(false);
		monthReportGrid.setDataSource(DSPlateAccountMonthReportSource.getInstance());
		monthReportGrid.setShowGridSummary(true);
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("businessTypeId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("month");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("integral");
		idx++;
		monthReportGrid.setFields(fields);
		loadData();
		//收入支出双击事件
		achieveGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = achieveGrid.getSelectedRecords();
				// 业务功能类型
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				onLoadMonthReportData(businessTypeId);
			}
		});
		payGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = payGrid.getSelectedRecords();
				// 业务功能类型
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				onLoadMonthReportData(businessTypeId);
			}
		});
		//月统计双击事件
		monthReportGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!monthReportGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = monthReportGrid.getSelectedRecords();
				//获取业务类型ID
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				//获取年份
				int year = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("year"));
				//获取月份
				int month = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("month"));
				String name = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				PopupWindow pw = new PopupWindow();
				//项目结算明细、项目补贴、合同变更明细
				if(businessTypeId == PLATE_BT_SURE_INTEGRAL || businessTypeId == PLATE_BT_PROJECT_SUBSIDY || businessTypeId == PLATE_BT_CONTRACT_CHANGE){
					OnLoadProjectSettlementDetailOfPlateAccountPanel panel = new OnLoadProjectSettlementDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//积分回收、积分还款、积分借款、项目违约金明细、考勤扣款
				}else if(businessTypeId == PLATE_BT_INTEGRAL_RECYCLE || businessTypeId == PLATE_BT_SALAEY_REFUND || businessTypeId == PLATE_BT_INTEGRAL_ADVANCE || businessTypeId == PLATE_BT_VIOLATION_CHARGES || businessTypeId == PLATE_BT_ATTENDANCE_DEDUCT){
					OnLoadCommonTwoDetailOfPlateAccountPanel panel  = new OnLoadCommonTwoDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//奖金补贴明细
				}else if(businessTypeId == PLATE_BT_BONUS_SUBSIDY){
					OnLoadBonusAdvanceDetailOfPlateAccountPanel panel = new OnLoadBonusAdvanceDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//运营成本明细
				}else if(businessTypeId == PLATE_BT_PLATE_COST){
					PlateCostMonthlyDetailPanel panel = new PlateCostMonthlyDetailPanel();
					pw.addItem(panel);
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//研发项目明细
				}else if(businessTypeId == PLATE_BT_DEVELOP_PROJECT || businessTypeId == PLATE_BT_MANAGE_PROJECT){
					OnLoadOtherProjectDetailOfPlateAccountPanel panel = new OnLoadOtherProjectDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setPlateId(plateId);
					panel.setBusinessTypeId(businessTypeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				}else if(businessTypeId == PLATE_BT_CONTRACT_DISTRIBUTION_INCOME || businessTypeId == PLATE_BT_CONTRACT_DISTRIBUTION_EXPENDITURE){
//					ContractDistributionMonthlyDetailPanel panel = new ContractDistributionMonthlyDetailPanel();
					OnLoadCommonOneDetailOfPlateAccountPanel panel  = new OnLoadCommonOneDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setPlateId(plateId);
					panel.setBusinessTypeId(businessTypeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				}else if(businessTypeId == PLATE_BT_COLLABORATIVE_ACHIEVE || businessTypeId == PLATE_BT_COLLABORATIVE_PAY) {
					CollaborativeFeeDetailOfPlateAccountPanel panel = new CollaborativeFeeDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setPlateId(plateId);
					panel.setBusinessTypeId(businessTypeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				}else{
					OnLoadCommonOneDetailOfPlateAccountPanel panel  = new OnLoadCommonOneDetailOfPlateAccountPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				}
				pw.setTitle("部门(" + name + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		// 统计按钮点击事件
		calculateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				loadData();
				//如果不是一级部门，则移除[分配积分]按钮
				map.put("plateId", plateId);
				DBDataSource.callOperation("ST_PlateRecord", "find", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record record = dsResponse.getData()[0];
							if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("parentId"))){
								if(record.getAttributeAsInt("parentId") == 0){
									centerRight.addMember(integralDistributionsButton);
									//加载该部门下面的子部门
									onLoadPlates();
								}else{
									centerRight.removeMember(integralDistributionsButton);
									centerRight.redraw();
								}
							}
						}
					}
				});
			}
		});
	}
	
	public void chartOneSet() {
		chartOne = new Chart().setType(Series.Type.COLUMN)
		.setCredits(new Credits().setEnabled(false))//去除链接属性
		.setPlotBackgroundColor((String) null).setPlotBorderWidth(null).setPlotShadow(true)
		.setPiePlotOptions(new PiePlotOptions().setAllowPointSelect(true).setCursor(PlotOptions.Cursor.POINTER)
		.setPieDataLabels(new PieDataLabels().setEnabled(false)).setShowInLegend(true))
		.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
			public String format(ToolTipData toolTipData) {
				return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " 万";
			}
		}));
		chartOne.getXAxis().setCategories("积分收支分析");  
		chartOne.setWidth100();
		chartOne.setHeight100();
		chartOne.setBackgroundColor("#FFF");
		chartOne.setBorderColor("#e2e2e2");
	}

	public void chartTwoSet() {
		chartTwo.setType(Series.Type.COLUMN);
		chartTwo.setChartTitleText("收入支出项").setChartSubtitleText("")
				.setColumnPlotOptions(new ColumnPlotOptions().setPointPadding(0.2).setBorderWidth(0))
				.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL).setAlign(Legend.Align.LEFT)
						.setVerticalAlign(Legend.VerticalAlign.TOP).setX(100).setY(70).setFloating(true)
						.setBackgroundColor("#f2f2f2").setShadow(true))
				.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
					public String format(ToolTipData toolTipData) {
						return toolTipData.getXAsString() + "（" + toolTipData.getSeriesName() + "）: "
								+ toolTipData.getYAsDouble() + " 万";
					}
				}));
		// 设置Y轴显示
		chartTwo.getYAxis().setAxisTitleText("积分(万)").setMin(0);
		chartTwo.setWidth100();
		chartTwo.setHeight100();
		chartTwo.setBackgroundColor("#FFF");
		chartTwo.setBorderColor("#e2e2e2");
	}
	
	/**
	 * 加载[分配积分]的积分提取部门下面的子部门
	 */
	public void onLoadPlates(){
		Map<String,Object> params = new HashMap<>();
		params.put("parentId", plateId);
		DBDataSource.callOperation("ST_PlateRecord", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] record = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						lhm.clear();
						for (Record r : record) {
							lhm.put(r.getAttribute("plateId"), KeyValueManager.getValue("plate_records", r.getAttribute("plateId")));
						}
					}
				}
			}
		});
	}
	
	
	/**
	 * 加载月统计明细数据
	 * @param businessTypeId
	 */
	public void onLoadMonthReportData(int businessTypeId){
		// 获取开始年月的值
		Date startDate = startDateItem.getValueAsDate();
		// 获取结束年月的值
		Date endDate = endDateItem.getValueAsDate();
		Map<Object, Object> param = new HashMap<>();
		param.put("optType", "onLoadMonthStatisticOfPlateAccount");
		param.put("plateId", plateId);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("businessTypeId", businessTypeId);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					centerRightLayout.removeMember(centerRightLayout.getMember(0));
					monthReportGrid.setData(records);
					centerRightLayout.addMember(monthReportGrid);
					centerRightLayout.redraw();
				}
			}
		});
	}
	
	// 加载数据集
	public void loadData() {
		Map<Object, Object> param = new HashMap<>();
		// 获取开始年月的值
		Date startDate = startDateItem.getValueAsDate();
		// 获取结束年月的值
		Date endDate = endDateItem.getValueAsDate();
		param.put("optType", "onLoadPlateIntegralData");
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("plateId", plateId);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					middleTopLayout.removeMember(achieveGrid);
					middleBottomLayout.removeMember(payGrid);
					Record[] records = dsResponse.getData();
					int len = records.length;
					// title字符串数组
					String[] titleArr = new String[len];
					// 结余的数组
					Double[] integralArr = new Double[len];
					//定义结余
					BigDecimal leftIntegral = BigDecimal.ZERO;
					//定义收入
					BigDecimal achieveIntegral = BigDecimal.ZERO;
					//定义支出
					BigDecimal payIntegral = BigDecimal.ZERO;
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						int i = 0;
						int count = 0;//记录支出项的数目
						for (Record e : records) {
							int businessTypeId = BaseHelpUtils.getIntValue(e.getAttribute("businessTypeId"));
							String name = BaseHelpUtils.getString(e.getAttribute("businessTypeName"));
							e.setAttribute("name", name);
							titleArr[i] = name;
							BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("integral"));
							integralArr[i] = BaseHelpUtils.format(integral.divide(BigDecimal.valueOf(10000)), 2).doubleValue();
							if(getDepIsAchieve(businessTypeId)){//说明是收入项
								achieveIntegral = achieveIntegral.add(integral);
							}else{//说明是支出项
								payIntegral = payIntegral.add(integral);
								count++;
							}
							i++;
						}
						Record[] achieveRecords = new Record[len-count];
						Record[] payRecords = new Record[count];
						int achieveI = 0;
						int payI = 0;
						for (Record e : records) {
							int businessTypeId = BaseHelpUtils.getIntValue(e.getAttribute("businessTypeId"));
							if(getDepIsAchieve(businessTypeId)){//说明是收入项
								achieveRecords[achieveI] = e;
								achieveI++;
							}else{//说明是支出项
								payRecords[payI] = e;
								payI++;
							}
						}
						achieveGrid.setData(achieveRecords);
						payGrid.setData(payRecords);
						middleTopLayout.addMember(achieveGrid);
						middleBottomLayout.addMember(payGrid);
						middleTopLayout.redraw();
						middleBottomLayout.redraw();
					}
					//设置价值积分
					setValueOfIntegral(achieveIntegral.subtract(payIntegral));
					achieveIntegral = BaseHelpUtils.format(achieveIntegral.divide(BigDecimal.valueOf(10000)), 2);
					payIntegral = BaseHelpUtils.format(payIntegral.divide(BigDecimal.valueOf(10000)), 2);
					leftIntegral = achieveIntegral.subtract(payIntegral);
					chartOne.removeFromParent();
					chartOne.setWidth(chartOneLayout.getWidth());
					chartOne.setHeight100();
					chartOne.removeAllSeries();
					chartOne.addSeries(chartOne.createSeries().setName("积分结余")
							.setPoints(new Point[] {new Point("积分结余",leftIntegral)}));
					chartOne.addSeries(chartOne.createSeries().setName("积分收入")
							.setPoints(new Point[] {new Point("积分收入",achieveIntegral)}));
					chartOne.addSeries(chartOne.createSeries().setName("积分支出")
							.setPoints(new Point[] {new Point("积分支出",payIntegral)}));
					chartTwo.removeAllSeries();
					// 设置X轴title显示
					chartTwo.getXAxis().setCategories(titleArr);
					// 设置X轴数据
					chartTwo.addSeries(chartTwo.createSeries().setName("积分").setPoints(integralArr));
					//加载部门实时余额
					Map<Object, Object> paramChild = new HashMap<>();
					paramChild.put("optType", "onLoadLeftIntegralOFPlate");
					paramChild.put("plateId", plateId);
					DBDataSource.callOperation("EP_AccountManageProcess", paramChild, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							BigDecimal integral = BigDecimal.ZERO;
							if (dsResponse.getStatus() >= 0) {
								Record record = dsResponse.getData()[0];
								if(!BaseHelpUtils.isNullOrEmpty(record)){
									integral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
									chartOne.setChartTitleText("<font style=\"color:rgb(255, 0, 102);font-size:18px;font:bold 16px;\">实时余额("+integral+")</font><br/><font>积分结余("+valueOfIntegral+")</font>");
								}
							}
							chartOneLayout.addMember(chartOne);
						}
					});
					
					
				}
			}
		});
	}
	
	/**
     * 
     * @Title: getDepIsAchieve 
     * @Description: 根据业务ID获取  部门数据操作是支出还是收入
     * @param @param businessTypeId
     * @param @return   
     * @return Boolean   
     * @throws
     */
	public static Boolean getDepIsAchieve(int businessTypeId){
    	Boolean flag = null ;
    	switch (businessTypeId) {
		case PLATE_BT_SURE_INTEGRAL:
			flag = true;
			break;
		case PLATE_BT_COMPANY_SUBSIDY:
			flag = true;
			break;
		case PLATE_BT_INTEGRAL_RECYCLE:
			flag = true;
			break;
		case PLATE_BT_SALAEY_REFUND:
			flag = true;
			break;
		case PLATE_BT_INTEGRAL_ADVANCE:
			flag = false;
			break;
		case PLATE_BT_BONUS_SUBSIDY:
			flag = false;
			break;
		case PLATE_BT_PLATE_COST:
			flag = false;
			break;
		case PLATE_BT_PROJECT_SUBSIDY:
			flag = false;
			break;
		case PLATE_BT_COLLABORATIVE_ACHIEVE:
			flag = true;
			break;
		case PLATE_BT_COLLABORATIVE_PAY:
			flag = false;
			break;
		case PLATE_BT_PERFORMANCE_BONUS:
			flag = false;
			break;	
		case PLATE_BT_COMPANY_FEE:
			flag = false;
			break;	
		case PLATE_BT_VIOLATION_CHARGES:
			flag = true;
			break;	
		case PLATE_BT_COMPANY_REFUND:
			flag = false;
			break;	
		case PLATE_BT_COMPANY_ADVANCE:
			flag = true;
			break;	
		case PLATE_BT_DEVELOP_PROJECT:
			flag = false;
			break;	
		case PLATE_BT_MANAGE_PROJECT:
			flag = false;
			break;	
		case PLATE_BT_ATTENDANCE_DEDUCT:
			flag = true;
			break;	
		case PLATE_BT_CONTRACT_CHANGE:
			flag = false;
			break;
		case PLATE_BT_END_PROJECT:
			flag = true;
			break;
		case PLATE_BT_SALE_INTEGRAL:
			flag = true;
			break;
		case PLATE_BT_SEND_ACHIEVE:
			flag = true;
			break;
		case PLATE_BT_SEND_PAY:
			flag = false;
			break;
		case PLATE_BT_EMPLOYEE_COST:
			flag = false;
			break;
		case PLATE_BT_CONTRACT_DISTRIBUTION_INCOME:
			flag = true;
			break;
		case PLATE_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
			flag = false;
			break;
		case PLATE_BT_PROJECT_PERFORMANCE:
			flag = true;
			break;
		case PLATE_BT_PROJECT_PERFORMANCE_PAY:
			flag = false;
			break;
		case PLATE_BT_DEP_DEPLOY:
			flag = false;
			break;
		case PLATE_BT_OUTPUT_ACCOUNT:
			flag = false;
			break;
		default:
			break;
		}
    	return flag;
    }

	private int plateId;
	private Date startDate;
	private Date endDate;
	private BigDecimal valueOfIntegral;
	private BigDecimal leftIntegral;
	LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
	
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

	public BigDecimal getValueOfIntegral() {
		return valueOfIntegral;
	}

	public void setValueOfIntegral(BigDecimal valueOfIntegral) {
		this.valueOfIntegral = valueOfIntegral;
	}

	public BigDecimal getLeftIntegral() {
		return leftIntegral;
	}

	public void setLeftIntegral(BigDecimal leftIntegral) {
		this.leftIntegral = leftIntegral;
	}
	

}