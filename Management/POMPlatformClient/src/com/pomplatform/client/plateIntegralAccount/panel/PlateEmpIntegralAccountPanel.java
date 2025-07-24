package com.pomplatform.client.plateIntegralAccount.panel;

import java.util.Date;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.bonuspaymentbymonth.panel.BonusPaymentByMonthPanel;
import com.pomplatform.client.employeedetail.panel.SalaryAdvanceDetailPanel;
import com.pomplatform.client.employeedetail.panel.SalaryReturnDetailPanel;
import com.pomplatform.client.employeeprojectcosteachmonth.panel.EmployeeProjectCostEachMonthPanel;
import com.pomplatform.client.employeereportrecorddetail.datasource.DSAchieveIntegralSource;
import com.pomplatform.client.employeereportrecorddetail.datasource.DSAchieveIntegralToSource;
import com.pomplatform.client.employeereportrecorddetail.panel.EmployeeViolationChargesMonthlyPanel;
import com.pomplatform.client.employeesalary.panel.EmployeeSalaryDetailMonthPanel;
import com.pomplatform.client.manageprojectemployeerecordeachmonth.panel.ManageProjectEmployeeRecordEachMonthPanel;
import com.pomplatform.client.sprojectemployeeadvancerecord.panel.SProjectEmployeeAdvanceRecordPanel;
import com.pomplatform.client.sprojectsettlementdetaileachmonth.panel.SProjectSettlementDetailEachMonthPanel;
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
public class PlateEmpIntegralAccountPanel extends VLayout {
	private static final Logger __logger = Logger.getLogger("");
	//设置标示字段值flag:0:汇总;1:确认积分;2:积分发放;3:积分补贴;4:积分还款;5:人工成本;6:项目成本;7:项目补贴;8:奖金发放
	private static final int flag_total = 0;
	private static final int flag_sureIntegral = 1;
	private static final int flag_managerProjectIntegral = 2;
	private static final int flag_salaryAdvance = 3;
	private static final int flag_salaryReturn = 4;
	private static final int flag_salary = 5;
	private static final int flag_projectCost = 6;
	private static final int flag_projectAdvance = 7;
	private static final int flag_bonusPayment = 8;
	private static final int flag_integralReturn = 9;
	private static final int flag_violationCharges = 10;
	private static final String name_total = "汇总";
	private static final String name_sureIntegral= "确认积分";
	private static final String name_managerProjectIntegral = "奖金补贴";
	private static final String name_salaryAdvance = "积分借款";
	private static final String name_salaryReturn = "积分还款";
	private static final String name_salary = "人工成本";
	private static final String name_projectCost = "项目成本";
	private static final String name_projectAdvance = "项目补贴";
	private static final String name_bonusPayment = "奖金发放";
	private static final String name_integralReturn = "积分回收";
	private static final String name_violationCharges = "项目违规金";
    public static DelicacyListGrid achieveIntegralComeGrid;
    public static DelicacyListGrid achieveIntegralToGrid;
    public static Label recordPanelTitle;	
    
    //积分明细item
    final VLayout recordPanelLayout;
    
	public PlateEmpIntegralAccountPanel(final int employeeId,String employeeName,DelicacyListGrid resultGrid,final Date startDate,final Date endDate) {
		recordPanelLayout = new VLayout(5);
		recordPanelTitle = new Label("积分明细");
		recordPanelTitle.addStyleName("colorLabel");
		//获取到积分汇总双击的那条数据记录
		ListGridRecord record = resultGrid.getSelectedRecord();
		//获取价值积分
		double achieveIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("achieveIntegral"));
		//获取到积分借款
		double salaryAdvance = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salaryAdvance"));
		//获取积分还款
		double salaryReturn = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salaryReturn"));
		//获取积分负值，即积分借款-积分还款
		double plusIntegral = salaryAdvance-salaryReturn;
		
		achieveIntegralComeGrid = new DelicacyListGrid();
		achieveIntegralComeGrid.setDataSource(DSAchieveIntegralSource.getInstance());
		achieveIntegralComeGrid.setData(getAchieveIntegralComeData(record));
		achieveIntegralComeGrid.selectRecord(0);
		achieveIntegralComeGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				achieveIntegralToGrid.setSelectedState("false");
				ListGridRecord[] selected = achieveIntegralComeGrid.getSelectedRecords();
				//获取flag
                int flagValue = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("flag"));
                if(flagValue != flag_total){//除去汇总的跳转
                	recordPanelLayout.removeMember(recordPanelLayout.getMember(1));
                	setFlag(flagValue);
                	recordPanelLayout.addMember(getAchieveIntegralDetailPanel(employeeId,startDate,endDate));
                	recordPanelLayout.redraw();
                }
			}
		});
		
		achieveIntegralToGrid = new DelicacyListGrid();
		achieveIntegralToGrid.setDataSource(DSAchieveIntegralToSource.getInstance());
		achieveIntegralToGrid.setData(getAchieveIntegralToData(record));
		achieveIntegralToGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				achieveIntegralComeGrid.setSelectedState("false");
				ListGridRecord[] selected = achieveIntegralToGrid.getSelectedRecords();
				//获取flag
                int flagValue = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("flag"));
                if(flagValue != flag_total){
                	recordPanelLayout.removeMember(recordPanelLayout.getMember(1));
                	setFlag(flagValue);
                	recordPanelLayout.addMember(getAchieveIntegralDetailPanel(employeeId,startDate,endDate));
                	recordPanelLayout.redraw();
                }
			}
		});
		
        setHeight100();
        setMembersMargin(5);

        //部门汇总item
        VLayout plateIntegralAccountLayout = new VLayout(5);
        plateIntegralAccountLayout.setBackgroundColor("#e2e2e2");
        //定义标题栏
//        Label analiseTitle = new Label("分析栏");
//        analiseTitle.setTop(10);
//        analiseTitle.setBackgroundColor("#e2e2e2");
//        analiseTitle.addStyleName("LabelViewValueDefault");
//        analiseTitle.setAlign(Alignment.CENTER);
//        analiseTitle.setHeight("4%");
        //重构面板，定义一个VLayout存放连个HLayout，每个HLayout存放连个Label
        VLayout totalVLayout = new VLayout();
        totalVLayout.setHeight("100%");
        totalVLayout.setBackgroundColor("#e2e2e2");
        totalVLayout.setLayoutTopMargin(10);
        totalVLayout.setLayoutLeftMargin(5);
        totalVLayout.setLayoutRightMargin(5);
        
        //定义存放积分余额的HLayout
        HLayout achieveHLayout = new HLayout();
        achieveHLayout.setHeight("4%");
        achieveHLayout.setLayoutTopMargin(10);
        //定义存放积分负值的HLayout
        HLayout leftHLayout = new HLayout();
        leftHLayout.setHeight("4%");
        leftHLayout.setLayoutTopMargin(20);
        //定义占空间的HLayout
        HLayout spanceHLayout = new HLayout();
        spanceHLayout.setHeight("92%");
        //定义积分余额显示的Label
        Label achieveTitle = new Label("积分余额:");
        achieveTitle.setWidth("25%");
        achieveTitle.addStyleName("LabelViewTitle");
        //定义积分余额值的Label
        Label achieveValue = new Label(achieveIntegral+"");
        achieveValue.setAlign(Alignment.LEFT);
        achieveValue.setBackgroundColor("#FFF");
        achieveValue.setWidth("75%");
        achieveValue.addStyleName("LabelViewValueDefault");
        //向积分余额HLayout中添加标题和值
        achieveHLayout.addMember(achieveTitle);
        achieveHLayout.addMember(achieveValue);
        
        //定义积分负值显示的Label
        Label leftTitle = new Label("积分负值:");
        leftTitle.setWidth("25%");
        leftTitle.addStyleName("LabelViewTitle");
        //定义积分负值值的Label
        Label leftValue = new Label((plusIntegral)+"");
        leftValue.setAlign(Alignment.LEFT);
        leftValue.setBackgroundColor("#FFF");
        leftValue.setWidth("75%");
        leftValue.addStyleName("LabelViewValue");
        //向积分负值HLayout中添加标题和值
        leftHLayout.addMember(leftTitle);
        leftHLayout.addMember(leftValue);
        //向totalVLayout添加积分余额和积分负值的HLayout
        totalVLayout.addMember(achieveHLayout);
        totalVLayout.addMember(leftHLayout);
        totalVLayout.addMember(spanceHLayout);
        
//        plateIntegralAccountLayout.addMember(analiseTitle);
        plateIntegralAccountLayout.addMember(totalVLayout);
        

        //收入item
        VLayout achieveIntegralComeLayout = new VLayout(5);
        achieveIntegralComeLayout.setLayoutTopMargin(10);
        achieveIntegralComeLayout.addMember(achieveIntegralComeGrid);
        
        //支出item
        VLayout achieveIntegralToLayout = new VLayout(5);
        achieveIntegralToLayout.setLayoutTopMargin(10);
        achieveIntegralToLayout.addMember(achieveIntegralToGrid);
        
        recordPanelLayout.setBackgroundColor("#e2e2e2");
        recordPanelTitle.setHeight("4%");
        recordPanelTitle.setAlign(Alignment.CENTER);
        recordPanelLayout.addMember(recordPanelTitle);
        
        recordPanelLayout.setGroupTitle("积分明细");
        recordPanelLayout.addMember(getAchieveIntegralDetailPanel(employeeId,startDate,endDate));
        
        if (Browser.getIsDesktop()) {//pc端展示
        	//定义整个面板
            HLayout plateIntegralAccountRecordLayout = new HLayout(10);
            plateIntegralAccountRecordLayout.setWidth100();
            plateIntegralAccountRecordLayout.setHeight100();
            
            //定义左边的部门积分汇总的展示item，并设置其占整个面板的20%宽度，100%高度
            plateIntegralAccountLayout.setWidth("20%");
            plateIntegralAccountLayout.setHeight100();
            plateIntegralAccountRecordLayout.addMember(plateIntegralAccountLayout);
            
            //定义中间部分的Valyout,用于垂直布局价值积分来源item和价值积分去向item，并设置其占整个面板的20%的宽度，100%高度
            VLayout achieveIntegralLayout = new VLayout();
            achieveIntegralLayout.setWidth("20%");
            achieveIntegralLayout.setHeight100();
            //定义价值积分来源item，并设置其占当前Vlayout的50%高度和100%宽度
            achieveIntegralComeLayout.setWidth100();
            achieveIntegralComeLayout.setHeight("50%");
            achieveIntegralLayout.addMember(achieveIntegralComeLayout);
            //定义价值积分去向item，并设置其占当前Vlayout的50%高度和100%宽度
            achieveIntegralToLayout.setWidth100();
            achieveIntegralToLayout.setHeight("50%");
            achieveIntegralLayout.addMember(achieveIntegralToLayout);
            plateIntegralAccountRecordLayout.addMember(achieveIntegralLayout);
            
            //定义右边部分的积分明细面板，并设置其占整个面板的60%宽度，100%高度
            recordPanelLayout.setWidth("60%");
            recordPanelLayout.setHeight100();
            plateIntegralAccountRecordLayout.addMember(recordPanelLayout);
            
            addMember(plateIntegralAccountRecordLayout);
        } else {//移动端展示
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
        	PlateEmpIntegralAccountPanel cm = new PlateEmpIntegralAccountPanel(0,"",null,null,null);
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
     * @param record
     * @return
     */
    private Record[] getAchieveIntegralComeData(ListGridRecord record){
    	//重新封装价值积分来源和去向的gird
		if(record == null){
			return null;
		}else{
			//获取确认积分
			double sureIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("sureIntegral"));
			//获取奖金补贴
			double managerProjectIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("managerProjectIntegral"));
			//获取积分借款
			double salaryAdvance = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salaryAdvance"));
			//项目补贴
			double projectAdvance = ClientUtil.checkAndGetDoubleValue(record.getAttribute("projectAdvance"));
			//汇总
			double total = sureIntegral+managerProjectIntegral+salaryAdvance+projectAdvance;
			
			Record[] comeRecord = new Record[5];
			Record record0 = new Record();
			record0.setAttribute("achieveIntegralName", name_sureIntegral);
			record0.setAttribute("achieveIntegral", sureIntegral);
			record0.setAttribute("flag", flag_sureIntegral);
			comeRecord[0] = record0;
			Record record1 = new Record();
			record1.setAttribute("achieveIntegralName", name_managerProjectIntegral);
			record1.setAttribute("achieveIntegral", managerProjectIntegral);
			record1.setAttribute("flag", flag_managerProjectIntegral);
			comeRecord[1] = record1;
			Record record2 = new Record();
			record2.setAttribute("achieveIntegralName", name_salaryAdvance);
			record2.setAttribute("achieveIntegral", salaryAdvance);
			record2.setAttribute("flag", flag_salaryAdvance);
			comeRecord[2] = record2;
			Record record3 = new Record();
			record3.setAttribute("achieveIntegralName", name_projectAdvance);
			record3.setAttribute("achieveIntegral", projectAdvance);
			record3.setAttribute("flag", flag_projectAdvance);
			comeRecord[3] = record3;
			Record record4 = new Record();
			record4.setAttribute("achieveIntegralName", name_total);
			record4.setAttribute("achieveIntegral", total);
			record4.setAttribute("flag", flag_total);
			comeRecord[4] = record4;
			
			return comeRecord;
		}
    }
    
    /**
     * 获取积分去向的数据集
     * @param record
     * @return
     */
    private Record[] getAchieveIntegralToData(ListGridRecord record){
    	//重新封装价值积分来源和去向的gird
		if(record == null){
			return null;
		}else{
			//获取积分还款
			double salaryReturn = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salaryReturn"));
			//获取人工成本
			double salary = ClientUtil.checkAndGetDoubleValue(record.getAttribute("salary"));
			//获取项目成本
			double projectCost = ClientUtil.checkAndGetDoubleValue(record.getAttribute("projectCost"));
			//获取奖金发放
			double bonusPayment = ClientUtil.checkAndGetDoubleValue(record.getAttribute("bonusPayment"));
			//积分回收
			double integralReturn = ClientUtil.checkAndGetDoubleValue(record.getAttribute("integralReturn"));
			//项目违规金
			double violationCharges = ClientUtil.checkAndGetDoubleValue(record.getAttribute("violationCharges"));
			//汇总
			double total = salaryReturn+salary+projectCost+bonusPayment+integralReturn+violationCharges;
			
			Record[] toRecord = new Record[7];
			Record record0 = new Record();
			record0.setAttribute("achieveIntegralName", name_salaryReturn);
			record0.setAttribute("achieveIntegral", salaryReturn);
			record0.setAttribute("flag", flag_salaryReturn);
			toRecord[0] = record0;
			Record record1 = new Record();
			record1.setAttribute("achieveIntegralName", name_salary);
			record1.setAttribute("achieveIntegral", salary);
			record1.setAttribute("flag", flag_salary);
			toRecord[1] = record1;
			Record record2 = new Record();
			record2.setAttribute("achieveIntegralName", name_projectCost);
			record2.setAttribute("achieveIntegral", projectCost);
			record2.setAttribute("flag", flag_projectCost);
			toRecord[2] = record2;
			Record record3 = new Record();
			record3.setAttribute("achieveIntegralName", name_bonusPayment);
			record3.setAttribute("achieveIntegral", bonusPayment);
			record3.setAttribute("flag", flag_bonusPayment);
			toRecord[3] = record3;
			Record record4 = new Record();
			record4.setAttribute("achieveIntegralName", name_integralReturn);
			record4.setAttribute("achieveIntegral", integralReturn);
			record4.setAttribute("flag", flag_integralReturn);
			toRecord[4] = record4;
			Record record5 = new Record();
			record5.setAttribute("achieveIntegralName", name_violationCharges);
			record5.setAttribute("achieveIntegral", violationCharges);
			record5.setAttribute("flag", flag_violationCharges);
			toRecord[5] = record5;
			Record record6 = new Record();
			record6.setAttribute("achieveIntegralName", name_total);
			record6.setAttribute("achieveIntegral", total);
			record6.setAttribute("flag", flag_total);
			toRecord[6] = record6;
			
			return toRecord;
		}
    }
    
    /**
     * 获取价值积分汇总的明细面板
     * @return 
     */
    private Canvas getAchieveIntegralDetailPanel(int employeeId,Date startDate,Date endDate) {
        int flag = getFlag();
        switch (flag) {
            case flag_sureIntegral:
            	recordPanelTitle.setContents(name_sureIntegral+"-积分明细");
            	SProjectSettlementDetailEachMonthPanel sureIntegral = new SProjectSettlementDetailEachMonthPanel();
            	sureIntegral.setEmployeeId(employeeId);
            	sureIntegral.setStartDate(startDate);
            	sureIntegral.setEndDate(endDate);
            	sureIntegral.commonQuery();
                return sureIntegral;
            case flag_managerProjectIntegral:
            	recordPanelTitle.setContents(name_managerProjectIntegral+"-积分明细");
            	ManageProjectEmployeeRecordEachMonthPanel managerProjectIntegral = new ManageProjectEmployeeRecordEachMonthPanel();
            	managerProjectIntegral.setEmployeeId(employeeId);
            	managerProjectIntegral.setStartDate(startDate);
            	managerProjectIntegral.setEndDate(endDate);
            	managerProjectIntegral.commonQuery();
                return managerProjectIntegral;
            case flag_salaryAdvance:
            	recordPanelTitle.setContents(name_salaryAdvance+"-积分明细");
            	SalaryAdvanceDetailPanel salaryAdvance = new SalaryAdvanceDetailPanel();
            	salaryAdvance.setEmployeeId(employeeId);
            	salaryAdvance.setStartDate(startDate);
            	salaryAdvance.setEndDate(endDate);
            	salaryAdvance.commonQuery();
            	return salaryAdvance;
            case flag_salaryReturn:
            	recordPanelTitle.setContents(name_salaryReturn+"-积分明细");
            	SalaryReturnDetailPanel salaryReturn = new SalaryReturnDetailPanel();
            	salaryReturn.setEmployeeId(employeeId);
            	salaryReturn.setStartDate(startDate);
            	salaryReturn.setEndDate(endDate);
            	salaryReturn.commonQuery();
            	return salaryReturn;
            case flag_projectCost:
            	recordPanelTitle.setContents(name_projectCost+"-积分明细");
            	EmployeeProjectCostEachMonthPanel projectCost = new EmployeeProjectCostEachMonthPanel();
            	projectCost.setEmployeeId(employeeId);
            	projectCost.setStartDate(startDate);
            	projectCost.setEndDate(endDate);
            	projectCost.commonQuery();
                return projectCost;
            case flag_projectAdvance://项目补贴
            	recordPanelTitle.setContents(name_projectAdvance+"-积分明细");
            	SProjectEmployeeAdvanceRecordPanel projectAdvance = new SProjectEmployeeAdvanceRecordPanel();
            	projectAdvance.setEmployeeId(employeeId);
            	projectAdvance.setStartDate(startDate);
            	projectAdvance.setEndDate(endDate);
            	projectAdvance.commonQuery();
                return projectAdvance;
            case flag_bonusPayment://奖金发放
            	recordPanelTitle.setContents(name_bonusPayment+"-积分明细");
            	BonusPaymentByMonthPanel bonusPayment = new BonusPaymentByMonthPanel();
            	bonusPayment.setEmployeeId(employeeId);
            	bonusPayment.setStartDate(startDate);
            	bonusPayment.setEndDate(endDate);
            	bonusPayment.commonQuery();
            	return bonusPayment;
            case flag_salary://人工成本
            	recordPanelTitle.setContents(name_salary+"明细");
            	EmployeeSalaryDetailMonthPanel salaryDetail = new EmployeeSalaryDetailMonthPanel();
            	salaryDetail.setEmployeeId(employeeId);
            	salaryDetail.setStartDate(startDate);
            	salaryDetail.setEndDate(endDate);
            	salaryDetail.commonQuery();
            	return salaryDetail;
            case flag_integralReturn://积分回收
            	recordPanelTitle.setContents(name_integralReturn+"-积分明细");
            	EmployeeIntegralReturnPanel integralReturnPanel = new EmployeeIntegralReturnPanel();
            	integralReturnPanel.setEmployeeId(employeeId);
            	integralReturnPanel.setStartDate(startDate);
            	integralReturnPanel.setEndDate(endDate);
            	integralReturnPanel.commonQuery();
            	return integralReturnPanel;
            case flag_violationCharges://项目违规金
            	recordPanelTitle.setContents(name_violationCharges+"-积分明细");
            	EmployeeViolationChargesMonthlyPanel violationChargesPanel = new EmployeeViolationChargesMonthlyPanel();
    			violationChargesPanel.setEmployeeId(employeeId);
    			violationChargesPanel.setStartDate(startDate);
    			violationChargesPanel.setEndDate(endDate);
    			violationChargesPanel.commonQuery();
    			return violationChargesPanel;
            default:
            	recordPanelTitle.setContents(name_sureIntegral+"-积分明细");
            	SProjectSettlementDetailEachMonthPanel sureIntegralDefault = new SProjectSettlementDetailEachMonthPanel();
            	sureIntegralDefault.setEmployeeId(employeeId);
            	sureIntegralDefault.setStartDate(startDate);
            	sureIntegralDefault.setEndDate(endDate);
            	sureIntegralDefault.commonQuery();
                return sureIntegralDefault;
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
