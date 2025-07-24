package com.pomplatform.client.plateIntegralAccount.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeeachieveintegralreturnrecordbymonth.panel.EmployeeAchieveIntegralReturnRecordByMonthPanel;
import com.pomplatform.client.employeereportrecorddetail.panel.EmployeeViolationChargesMonthlyPanel;
import com.pomplatform.client.manageprojectbymonth.panel.ManageProjectByMonthPanel;
import com.pomplatform.client.platecostrecord.panel.PlateCostMonthlyPanel;
import com.pomplatform.client.platecostrecord.panel.PlateCostRecordPanel;
import com.pomplatform.client.plateintegralsendrecord.panel.PlateIntegralSendRecordPanel;
import com.pomplatform.client.plateprojectaccountrecordbymonth.panel.PlateProjectAccountRecordByMonthPanel;
import com.pomplatform.client.platereportrecorddetail.datasource.DSAchieveIntegralSource;
import com.pomplatform.client.platereportrecorddetail.datasource.DSAchieveIntegralToSource;
import com.pomplatform.client.platereportrecorddetail.form.PlateReportRecordDetailViewer;
import com.pomplatform.client.semployeesalaryreturneachmonthrecord.panel.SEmployeeSalaryReturnEachMonthRecordPanel;
import com.pomplatform.client.splatesalaryadvanceeachmonthrecord.panel.SPlateSalaryAdvanceEachMonthRecordPanel;
import com.pomplatform.client.sprojectadvancerecordeachmonth.panel.SProjectAdvanceRecordEachMonthPanel;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author lxf
 */
public class PlateIntegralAccountPanel extends VLayout {
	private static final Logger __logger = Logger.getLogger("");
	// 设置标示字段值flag:0:汇总;1:项目结算;2:公司补贴;3:积分回收;4:积分还款;5:积分补贴;6:积分发放;7:运营成本;8:项目补贴;9:品质管理费;10:公司费用
	private static final int flag_total = 0;
	private static final int flag_projectSettlement = 1;
	private static final int flag_companySubsidy = 2;
	private static final int flag_employeeAchieveIntegralReturn = 3;
	private static final int flag_salaryReturn = 4;
	private static final int flag_salaryAdvance = 5;
	private static final int flag_managerProjectIntegral = 6;
	private static final int flag_plateCost = 7;
	private static final int flag_projectAdvance = 8;
	private static final int flag_qualityFee = 9;
	private static final int flag_companyFee = 10;
	private static final int flag_violationCharges = 11;
	private static final String name_total = "汇总";
	private static final String name_projectSettlement = "项目结算";
	private static final String name_companySubsidy = "公司补贴";
	private static final String name_employeeAchieveIntegralReturn = "积分回收";
	private static final String name_salaryReturn = "积分还款";
	private static final String name_salaryAdvance = "积分借款";
	private static final String name_managerProjectIntegral = "奖金补贴";
	private static final String name_plateCost = "运营成本";
	private static final String name_projectAdvance = "项目补贴";
	private static final String name_qualityFee = "品质管理费";
	private static final String name_companyFee = "公司费用";
	private static final String name_violationCharges = "项目违规金";
	public static PlateReportRecordDetailViewer plateIntegralAccountView;
	public static DelicacyListGrid achieveIntegralComeGrid;
	public static DelicacyListGrid achieveIntegralToGrid;

	public static Label plateIntegralAccountViewTitle;
	public static Label achieveIntegralComeTitle;
	public static Label achieveIntegralToTitle;
	public static Label recordPanelTitle;
	// 积分明细item
	final VLayout recordPanelLayout;

	public PlateIntegralAccountPanel(final int plateId, String palteName, DelicacyListGrid resultGrid, Map condition) {
		final Date startDate = (Date) condition.get("startDate");
		final Date endDate = (Date) condition.get("endDate");
		recordPanelLayout = new VLayout(5);
		plateIntegralAccountViewTitle = new Label(palteName + "-部门汇总");
		plateIntegralAccountViewTitle.addStyleName("colorLabel");
		achieveIntegralComeTitle = new Label(palteName + "-积分收入");
		achieveIntegralComeTitle.addStyleName("colorLabel");
		achieveIntegralToTitle = new Label(palteName + "-积分支出");
		achieveIntegralToTitle.addStyleName("colorLabel");
		recordPanelTitle = new Label("积分明细");
		recordPanelTitle.addStyleName("colorLabel");
		plateIntegralAccountView = new PlateReportRecordDetailViewer();
		plateIntegralAccountView.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
		plateIntegralAccountView.initComponents();
		plateIntegralAccountView.viewSelectedData(resultGrid);

		// 获取到积分汇总双击的那条数据记录
		ListGridRecord record = resultGrid.getSelectedRecord();

		achieveIntegralComeGrid = new DelicacyListGrid();
		achieveIntegralComeGrid.setDataSource(DSAchieveIntegralSource.getInstance());
		achieveIntegralComeGrid.setData(getAchieveIntegralComeData(record));
		achieveIntegralComeGrid.setShowGridSummary(true);
		// 默认选中“项目结算”，并在积分明细展示“项目结算”的具体信息
		achieveIntegralComeGrid.selectRecord(0);
		setFlag(1);
		achieveIntegralComeGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				achieveIntegralToGrid.setSelectedState("false");
				ListGridRecord[] selected = achieveIntegralComeGrid.getSelectedRecords();
				// 获取flag
				int flagValue = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("flag"));
				if (flagValue != flag_total) {
					recordPanelLayout.removeMember(recordPanelLayout.getMember(1));
					setFlag(flagValue);
					recordPanelLayout.addMember(getAchieveIntegralDetailPanel(plateId, startDate, endDate));
					recordPanelLayout.redraw();
				}
			}
		});

		achieveIntegralToGrid = new DelicacyListGrid();
		achieveIntegralToGrid.setDataSource(DSAchieveIntegralToSource.getInstance());
		achieveIntegralToGrid.setShowGridSummary(true);
		achieveIntegralToGrid.setData(getAchieveIntegralToData(record));
		achieveIntegralToGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				achieveIntegralComeGrid.setSelectedState("false");
				ListGridRecord[] selected = achieveIntegralToGrid.getSelectedRecords();
				// 获取flag
				int flagValue = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("flag"));
				if (flagValue != flag_total) {
					recordPanelLayout.removeMember(recordPanelLayout.getMember(1));
					setFlag(flagValue);
					recordPanelLayout.addMember(getAchieveIntegralDetailPanel(plateId, startDate, endDate));
					recordPanelLayout.redraw();
				}
			}
		});

		setHeight100();
		setMembersMargin(5);

		// 部门汇总item
		VLayout plateIntegralAccountLayout = new VLayout(5);
		plateIntegralAccountViewTitle.setHeight(50);
		plateIntegralAccountViewTitle.setAlign(Alignment.CENTER);
		plateIntegralAccountLayout.addMember(plateIntegralAccountViewTitle);
		plateIntegralAccountLayout.addMember(plateIntegralAccountView);

		// 价值积分来源item
		VLayout achieveIntegralComeLayout = new VLayout(5);
		achieveIntegralComeTitle.setHeight(50);
		achieveIntegralComeTitle.setAlign(Alignment.CENTER);
		achieveIntegralComeLayout.addMember(achieveIntegralComeTitle);
		achieveIntegralComeLayout.addMember(achieveIntegralComeGrid);

		// 价值积分去向item
		VLayout achieveIntegralToLayout = new VLayout(5);
		achieveIntegralToTitle.setHeight(50);
		achieveIntegralToTitle.setAlign(Alignment.CENTER);
		achieveIntegralToLayout.addMember(achieveIntegralToTitle);
		achieveIntegralToLayout.addMember(achieveIntegralToGrid);

		recordPanelTitle.setHeight(50);
		recordPanelTitle.setAlign(Alignment.CENTER);
		recordPanelLayout.addMember(recordPanelTitle);
		recordPanelLayout.addMember(getAchieveIntegralDetailPanel(plateId, startDate, endDate));

		if (Browser.getIsDesktop()) {// pc端展示
			// 定义整个面板
			HLayout plateIntegralAccountRecordLayout = new HLayout(10);
			plateIntegralAccountRecordLayout.setWidth100();
			plateIntegralAccountRecordLayout.setHeight100();

			// 定义左边的部门积分汇总的展示item，并设置其占整个面板的20%宽度，100%高度
			plateIntegralAccountLayout.setWidth("20%");
			plateIntegralAccountLayout.setHeight100();
			plateIntegralAccountRecordLayout.addMember(plateIntegralAccountLayout);

			// 定义中间部分的Valyout,用于垂直布局价值积分来源item和价值积分去向item，并设置其占整个面板的40的宽度，100%高度
			VLayout achieveIntegralLayout = new VLayout();
			achieveIntegralLayout.setWidth("20%");
			achieveIntegralLayout.setHeight100();
			// 定义价值积分来源item，并设置其占当前Vlayout的50%高度和100%宽度
			achieveIntegralComeLayout.setWidth100();
			achieveIntegralComeLayout.setHeight("50%");
			achieveIntegralLayout.addMember(achieveIntegralComeLayout);
			// 定义价值积分去向item，并设置其占当前Vlayout的50%高度和100%宽度
			achieveIntegralToLayout.setWidth100();
			achieveIntegralToLayout.setHeight("50%");
			achieveIntegralLayout.addMember(achieveIntegralToLayout);
			plateIntegralAccountRecordLayout.addMember(achieveIntegralLayout);

			// 定义右边部分的积分明细面板，并设置其占整个面板的60%宽度，100%高度
			recordPanelLayout.setWidth("60%");
			recordPanelLayout.setHeight100();
			plateIntegralAccountRecordLayout.addMember(recordPanelLayout);

			addMember(plateIntegralAccountRecordLayout);
		} else {// 移动端展示
			plateIntegralAccountLayout.setWidth100();
			plateIntegralAccountLayout.setHeight("25%");
			addMember(plateIntegralAccountLayout);

			achieveIntegralComeLayout.setWidth100();
			achieveIntegralComeLayout.setHeight("25%");
			addMember(achieveIntegralComeLayout);

			achieveIntegralToLayout.setWidth100();
			achieveIntegralToLayout.setHeight("25%");
			addMember(achieveIntegralToLayout);

			recordPanelLayout.setWidth100();
			recordPanelLayout.setHeight("25%");
			addMember(recordPanelLayout);
		}
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			PlateIntegralAccountPanel cm = new PlateIntegralAccountPanel(0, "", null, null);
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateIntegralAccount";
		}

	}

	/**
	 * 获取积分来源的数据集
	 * 
	 * @param record
	 * @return
	 */
	private Record[] getAchieveIntegralComeData(ListGridRecord record) {
		// 重新封装价值积分来源和去向的gird
		if (record == null) {
			return null;
		} else {
			// 获取项目结算
			double projectSettlement = ClientUtil.checkAndGetDoubleValue(record.getAttribute("projectSettlement"));
			// 获取公司补贴
			double companySubsidy = ClientUtil.checkAndGetDoubleValue(record.getAttribute("companySubsidy"));
			// 获取积分还款
			double employeeAchieveIntegralReturn = ClientUtil
					.checkAndGetDoubleValue(record.getAttribute("employeeAchieveIntegralReturn"));
			// 获取积分还款
			double salaryReturn = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salaryReturn"));
			//获取项目违规金
			double violationCharges = ClientUtil.checkAndGetDoubleValue(record.getAttribute("violationCharges"));
			// 汇总
//			double total = projectSettlement + companySubsidy + employeeAchieveIntegralReturn + salaryReturn;

			Record[] comeRecord = new Record[5];
			Record record0 = new Record();
			record0.setAttribute("achieveIntegralName", name_projectSettlement);
			record0.setAttribute("achieveIntegral", projectSettlement);
			record0.setAttribute("flag", flag_projectSettlement);
			comeRecord[0] = record0;
			Record record1 = new Record();
			record1.setAttribute("achieveIntegralName", name_companySubsidy);
			record1.setAttribute("achieveIntegral", companySubsidy);
			record1.setAttribute("flag", flag_companySubsidy);
			comeRecord[1] = record1;
			Record record2 = new Record();
			record2.setAttribute("achieveIntegralName", name_employeeAchieveIntegralReturn);
			record2.setAttribute("achieveIntegral", employeeAchieveIntegralReturn);
			record2.setAttribute("flag", flag_employeeAchieveIntegralReturn);
			comeRecord[2] = record2;
			Record record3 = new Record();
			record3.setAttribute("achieveIntegralName", name_salaryReturn);
			record3.setAttribute("achieveIntegral", salaryReturn);
			record3.setAttribute("flag", flag_salaryReturn);
			comeRecord[3] = record3;
			Record record4 = new Record();
			record4.setAttribute("achieveIntegralName", name_violationCharges);
			record4.setAttribute("achieveIntegral", violationCharges);
			record4.setAttribute("flag", flag_violationCharges);
			comeRecord[4] = record4;

			return comeRecord;
		}
	}

	/**
	 * 获取积分去向的数据集
	 * 
	 * @param record
	 * @return
	 */
	private Record[] getAchieveIntegralToData(ListGridRecord record) {
		// 重新封装价值积分来源和去向的gird
		if (record == null) {
			return null;
		} else {
			// 获取积分补贴
			double salaryAdvance = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salaryAdvance"));
			// 获取积分发放
			double managerProjectIntegral = ClientUtil
					.checkAndGetDoubleValue(record.getAttribute("managerProjectIntegral"));
			// 获取运营成本
			double plateCost = ClientUtil.checkAndGetDoubleValue(record.getAttribute("plateCost"));
			//获取项目补贴
			double projectAdvance = ClientUtil.checkAndGetDoubleValue(record.getAttribute("projectAdvance"));
			//获取品质管理费
			double qualityFee = ClientUtil.checkAndGetDoubleValue(record.getAttribute("qualityFee"));
			//获取公司费用
			double companyFee = ClientUtil.checkAndGetDoubleValue(record.getAttribute("companyFee"));
			// 汇总
//			double total = salaryAdvance + managerProjectIntegral + plateCost;

			Record[] toRecord = new Record[6];
			Record record0 = new Record();
			record0.setAttribute("achieveIntegralName", name_salaryAdvance);
			record0.setAttribute("achieveIntegral", salaryAdvance);
			record0.setAttribute("flag", flag_salaryAdvance);
			toRecord[0] = record0;
			Record record1 = new Record();
			record1.setAttribute("achieveIntegralName", name_managerProjectIntegral);
			record1.setAttribute("achieveIntegral", managerProjectIntegral);
			record1.setAttribute("flag", flag_managerProjectIntegral);
			toRecord[1] = record1;
			Record record2 = new Record();
			record2.setAttribute("achieveIntegralName", name_plateCost);
			record2.setAttribute("achieveIntegral", plateCost);
			record2.setAttribute("flag", flag_plateCost);
			toRecord[2] = record2;
			Record record3 = new Record();
			record3.setAttribute("achieveIntegralName", name_projectAdvance);
			record3.setAttribute("achieveIntegral", projectAdvance);
			record3.setAttribute("flag", flag_projectAdvance);
			toRecord[3] = record3;
			Record record4 = new Record();
			record4.setAttribute("achieveIntegralName", name_qualityFee);
			record4.setAttribute("achieveIntegral", qualityFee);
			record4.setAttribute("flag", flag_qualityFee);
			toRecord[4] = record4;
			Record record5 = new Record();
			record5.setAttribute("achieveIntegralName", name_companyFee);
			record5.setAttribute("achieveIntegral", companyFee);
			record5.setAttribute("flag", flag_companyFee);
			toRecord[5] = record5;

			return toRecord;
		}
	}

	/**
	 * 获取价值积分汇总的明细面板
	 * 
	 * @return
	 */
	private Canvas getAchieveIntegralDetailPanel(int plateId, Date startDate, Date endDate) {
		int flag = getFlag();
		switch (flag) {
		case flag_projectSettlement:// 项目结算
			recordPanelTitle.setContents(name_projectSettlement + "-积分明细");
			PlateProjectAccountRecordByMonthPanel panel1 = new PlateProjectAccountRecordByMonthPanel();
			panel1.setPlateId(plateId);
			panel1.setStartDate(startDate);
			panel1.setEndDate(endDate);
			panel1.commonQuery();
			return panel1;
		case flag_companySubsidy:// 公司补贴
			recordPanelTitle.setContents(name_companySubsidy + "-积分明细");
			PlateIntegralSendRecordPanel panel2 = new PlateIntegralSendRecordPanel();
			panel2.setPlateId(plateId);
			panel2.setStartDate(startDate);
			panel2.setEndDate(endDate);
			panel2.commonQuery();
			return panel2;
		case flag_employeeAchieveIntegralReturn:// 积分回收
			recordPanelTitle.setContents(name_employeeAchieveIntegralReturn + "-积分明细");
			EmployeeAchieveIntegralReturnRecordByMonthPanel panel3 = new EmployeeAchieveIntegralReturnRecordByMonthPanel();
			panel3.setPlateId(plateId);
			panel3.setStartDate(startDate);
			panel3.setEndDate(endDate);
			panel3.commonQuery();
			return panel3;
		case flag_salaryReturn:// 积分还款
			recordPanelTitle.setContents(name_salaryReturn + "-积分明细");
			SEmployeeSalaryReturnEachMonthRecordPanel panel4 = new SEmployeeSalaryReturnEachMonthRecordPanel();
			panel4.setPlateId(plateId);
			panel4.setStartDate(startDate);
			panel4.setEndDate(endDate);
			panel4.commonQuery();
			return panel4;
		case flag_salaryAdvance:// 积分借款
			recordPanelTitle.setContents(name_salaryAdvance + "-积分明细");
			SPlateSalaryAdvanceEachMonthRecordPanel panel5 = new SPlateSalaryAdvanceEachMonthRecordPanel();
			panel5.setPlateId(plateId);
			panel5.setStartDate(startDate);
			panel5.setEndDate(endDate);
			panel5.commonQuery();
			return panel5;
		case flag_managerProjectIntegral:// 奖金补贴
			recordPanelTitle.setContents(name_managerProjectIntegral + "-积分明细");
			ManageProjectByMonthPanel panel6 = new ManageProjectByMonthPanel();
			panel6.setPlateId(plateId);
			panel6.setStartDate(startDate);
			panel6.setEndDate(endDate);
			panel6.commonQuery();
			return panel6;
		case flag_plateCost:// 运营成本
			recordPanelTitle.setContents(name_plateCost + "-积分明细");
			PlateCostMonthlyPanel panel7 = new PlateCostMonthlyPanel();
//			PlateCostRecordPanel panel7 = new PlateCostRecordPanel();
			panel7.setPlateId(plateId);
			panel7.setStartDate(startDate);
			panel7.setEndDate(endDate);
			panel7.commonQuery();
			return panel7;
		case flag_projectAdvance://项目补贴
			recordPanelTitle.setContents(name_projectAdvance + "-积分明细");
			SProjectAdvanceRecordEachMonthPanel panel8 = new SProjectAdvanceRecordEachMonthPanel();
			panel8.setPlateId(plateId);
			panel8.setStartDate(startDate);
			panel8.setEndDate(endDate);
			panel8.commonQuery();
			return panel8;
		case flag_qualityFee://品质管理费
			recordPanelTitle.setContents(name_qualityFee + "-积分明细");
			QualityFeeSumByMonthPanel panel9 = new QualityFeeSumByMonthPanel();
			panel9.setPlateId(plateId);
			panel9.setStartDate(startDate);
			panel9.setEndDate(endDate);
			panel9.commonQuery();
			return panel9;
		case flag_companyFee://公司费用
			recordPanelTitle.setContents(name_companyFee + "-积分明细");
			CompanyFeeSumByMonthPanel panel10 = new CompanyFeeSumByMonthPanel();
			panel10.setPlateId(plateId);
			panel10.setStartDate(startDate);
			panel10.setEndDate(endDate);
			panel10.commonQuery();
			return panel10;
		case flag_violationCharges://项目违规金
			recordPanelTitle.setContents(name_violationCharges + "-积分明细");
			EmployeeViolationChargesMonthlyPanel panel11 = new EmployeeViolationChargesMonthlyPanel();
			panel11.setPlateId(plateId);
			panel11.setStartDate(startDate);
			panel11.setEndDate(endDate);
			panel11.commonQuery();
			return panel11;
		default:
			return new VLayout();
		}
	}

	public int flag = -1;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
