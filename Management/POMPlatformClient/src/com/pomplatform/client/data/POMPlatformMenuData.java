package com.pomplatform.client.data;

import com.delicacy.client.app.panel.SfunctionffaorPanel;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DelicacyMenuData;
import com.delicacy.client.data.ExplorerTreeNode;
import com.google.gwt.i18n.client.LocaleInfo;
import com.pomplatform.client.check.panel.MemployeecheckinouteeseorPanel;
import com.pomplatform.client.check.panel.SemployeemonthlycheckymorPanel;
import com.pomplatform.client.contract.panel.ScontractccorPanel;
import com.pomplatform.client.contractinfo.panel.ContractInfoPanel;
import com.pomplatform.client.departmentdirector.panel.MDepartmentDirectorPanel;
import com.pomplatform.client.designer.panel.DesignMessagePanel;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.designer.panel.MprojectemployeeporPanel;
import com.pomplatform.client.employeeaward.panel.MyAwardPanel;
import com.pomplatform.client.employeeawardtotal.panel.MemployeeAwardTotalPanel;
import com.pomplatform.client.employeenew.panel.SplateManagerPanel;
import com.pomplatform.client.employeesalary.panel.MemployeeSalaryPanel;
import com.pomplatform.client.gcontractinfo.panel.GContractInfoPanel;
import com.pomplatform.client.operation.panel.ProjectManagerPanel;
import com.pomplatform.client.plateintegraltotal.panel.MplateIntegralTotalPanel;
import com.pomplatform.client.project.panel.SprojectManagerPanel;
import com.pomplatform.client.projectcostlist.panel.ProjectCostListPanel;
import com.pomplatform.client.projectintegralassign.panel.SprojectIntegralAssignPanel;
import com.pomplatform.client.projectintegraltransferrecord.panel.MprojectintegraltransferrecordPanel;
import com.pomplatform.client.projectpriceintegral.panel.SprojectPricePanelPanel;

/**
 * @author Peter
 */
public class POMPlatformMenuData extends DelicacyMenuData {

    @SuppressWarnings("unused")
    private final String idSuffix;

    public POMPlatformMenuData(String idSuffix) {
        this.idSuffix = idSuffix;
        int roleID = ClientUtil.getRoleId();
        String localName = LocaleInfo.getCurrentLocale().getLocaleName();
        //编码总共12位,第一位表示类型:S:系统;A:应用;第二位表示应用类型:M:菜单;B:按钮;D:数据;-00000：表示菜单级别数：第一个0表示一级菜单第二个表示二级，依次类推;-000:表示按钮或者数据权限
        menuMap.put("SM-00000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "人力资源管理平台" : "Human Resource Manage", "hr_managment", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-10000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "客户管理平台" : "Customer Manage", "customer_managment", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-20000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "营销管理平台" : "Market Manage", "market_managment", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-30000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "运营管理平台" : "Operate Manage", "operate_managment", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-40000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "OA管理平台" : "OA Manage", "OA_managment", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-50000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "财务K3管理平台" : "K3 Manage", "K3_managment", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-60000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "个人管理" : "Myself Manage", "myself_management", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-70000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "系统管理" : "System Manage", "system_management", "root", "silk/layout_content.png", null, true, "", null));
        menuMap.put("AM-80000-000", new ExplorerTreeNode(localName.equals("zh_CN") ? "报表管理" : "Report Manage", "report_management", "root", "silk/layout_content.png", null, true, "", null));

//                menuMap.put("101", new ExplorerTreeNode("人事管理", "hr_managment", "root", "silk/layout_content.png", null, true, idSuffix, null));
        menuMap.put("102", new ExplorerTreeNode("项目管理", "project_management", "root", "silk/layout_content.png", null, true, idSuffix, null));
//		menuMap.put("103", new ExplorerTreeNode("系统管理", "system_management", "root", "silk/layout_content.png", null, true, idSuffix, null));
//		menuMap.put("104", new ExplorerTreeNode("个人管理", "myself_management", "root", "silk/layout_content.png", null, true, idSuffix, null));
        menuMap.put("10401", new ExplorerTreeNode("我的资料", "myMessage_management", "myself_management", "silk/layout_content.png",
                new DesignMessagePanel.Factory(), true, idSuffix, DesignMessagePanel.class));
        menuMap.put("10402", new ExplorerTreeNode("我的积分", "myIntegral_management", "myself_management", "silk/layout_content.png",
                new MyAwardPanel.Factory(), true, idSuffix, MyAwardPanel.class));
//		menuMap.put("105", new ExplorerTreeNode("报表管理", "report_management", "root", "silk/layout_content.png", null, true, idSuffix, null));
        menuMap.put("106", new ExplorerTreeNode("合同管理", "contract_management", "root", "silk/layout_content.png", null, true, idSuffix, null));
        menuMap.put("107", new ExplorerTreeNode("报销管理", "cost_management", "root", "silk/layout_content.png", null, true, idSuffix, null));
        //人力资源部和高管
        if (RoleDefinition.ROLE_HUMAN_RESOURCE_TEAM == roleID || RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID) {
//			menuMap.put("10101", new ExplorerTreeNode("部门管理", "department_managment", "hr_managment", "silk/layout_content.png",
//				new SdepartmentdorPanel.Factory(), true, idSuffix, SdepartmentdorPanel.class));
//			menuMap.put("10102", new ExplorerTreeNode("职务管理", "duty_management", "hr_managment", "silk/layout_content.png",
//				new SemployeeDutyPanel.Factory(), true, idSuffix, SemployeeDutyPanel.class));
//			menuMap.put("10103", new ExplorerTreeNode("角色管理", "role_management", "hr_managment", "silk/layout_content.png",
//				new SrolerorPanel.Factory(), true, idSuffix, SrolerorPanel.class));
//			menuMap.put("10104", new ExplorerTreeNode("职员管理", "emloyee_managment", "hr_managment", "silk/layout_content.png",
//				new SemployeeNewPanel.Factory(), true, idSuffix, SemployeeNewPanel.class));
            menuMap.put("10105", new ExplorerTreeNode("人工成本", "salary_managment", "hr_managment", "silk/layout_content.png",
                    new MemployeeSalaryPanel.Factory(), true, idSuffix, MemployeeSalaryPanel.class));
            
        }
        //人力资源部和考勤管理员
        if (RoleDefinition.ROLE_HUMAN_RESOURCE_TEAM == roleID || RoleDefinition.ROLE_CHECK_TEAM == roleID) {
            menuMap.put("10106", new ExplorerTreeNode("考勤数据", "check_managment", "hr_managment", "silk/layout_content.png",
                    new MemployeecheckinouteeseorPanel.Factory(), true, idSuffix, MemployeecheckinouteeseorPanel.class));
            menuMap.put("10107", new ExplorerTreeNode("考勤汇总", "check_total", "hr_managment", "silk/layout_content.png",
                    new SemployeemonthlycheckymorPanel.Factory(), true, idSuffix, SemployeemonthlycheckymorPanel.class));
        }
        //合同部、高管和运营部
        if (RoleDefinition.ROLE_CONTRACT_TEAM == roleID || RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID || RoleDefinition.ROLE_OPERATION_TEAM == roleID) {
            menuMap.put("10201", new ExplorerTreeNode("项目合同", "project_contract", "project_management", "silk/layout_content.png",
                    new ScontractccorPanel.Factory(), true, idSuffix, ScontractccorPanel.class));
        }
        //专业负责人项目
        if (RoleDefinition.ROLE_PROJECT_MANAGER == roleID) {
            menuMap.put("10202", new ExplorerTreeNode("我的项目", "projectManager_my_project", "project_management", "silk/layout_content.png",
                    null, true, idSuffix, null));
            menuMap.put("1020201", new ExplorerTreeNode("我管理的项目", "my_manage_project", "projectManager_my_project", "silk/layout_content.png",
                    new SprojectManagerPanel.Factory(), true, idSuffix, SprojectManagerPanel.class));
            menuMap.put("1020202", new ExplorerTreeNode("我参与的项目", "my_involved_project", "projectManager_my_project", "silk/layout_content.png",
                    new DesignerProjectPanel.Factory(), true, idSuffix, DesignerProjectPanel.class));
            menuMap.put("1020203", new ExplorerTreeNode("我的邀请", "my_invited_project", "projectManager_my_project", "silk/layout_content.png",
                    new MprojectemployeeporPanel.Factory(), true, idSuffix, MprojectemployeeporPanel.class));
        }
        //部门经理项目
        if (RoleDefinition.ROLE_DEPARTMENT_MANAGER == roleID) {
            menuMap.put("10203", new ExplorerTreeNode("我的项目", "departmentManager_my_project", "project_management", "silk/layout_content.png",
                    null, true, idSuffix, null));
//                    menuMap.put("1020301", new ExplorerTreeNode("我管理的项目", "my_manage_project", "departmentManager_my_project", "silk/layout_content.png",
//                        new MDepartmentManagerProjectPanel.Factory(), true, idSuffix, MDepartmentManagerProjectPanel.class));
            menuMap.put("1020304", new ExplorerTreeNode("我管理的项目", "my_manage_project", "departmentManager_my_project", "silk/layout_content.png",
                    new ProjectManagerPanel.Factory(), true, idSuffix, ProjectManagerPanel.class));
            menuMap.put("1020302", new ExplorerTreeNode("我参与的项目", "my_involved_project", "departmentManager_my_project", "silk/layout_content.png",
                    new DesignerProjectPanel.Factory(), true, idSuffix, DesignerProjectPanel.class));
            menuMap.put("1020303", new ExplorerTreeNode("我的邀请", "my_invited_project", "departmentManager_my_project", "silk/layout_content.png",
                    new MprojectemployeeporPanel.Factory(), true, idSuffix, MprojectemployeeporPanel.class));
            menuMap.put("10207", new ExplorerTreeNode("我的团队", "my_team", "project_management", "silk/layout_content.png",
                    new SplateManagerPanel.Factory(), true, idSuffix, SplateManagerPanel.class));
        }
        //事业部负责人项目
        if (RoleDefinition.ROLE_DEPARTMENT_DIRECTOR == roleID) {
            menuMap.put("10204", new ExplorerTreeNode("我的项目", "departmentDirector_my_project", "project_management", "silk/layout_content.png",
                    new MDepartmentDirectorPanel.Factory(), true, idSuffix, MDepartmentDirectorPanel.class));
            menuMap.put("10207", new ExplorerTreeNode("我的团队", "my_team", "project_management", "silk/layout_content.png",
                    new SplateManagerPanel.Factory(), true, idSuffix, SplateManagerPanel.class));
        }
        //高管项目
        if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID) {
//			menuMap.put("10205", new ExplorerTreeNode("公司项目", "managermentTeam_my_project", "project_management", "silk/layout_content.png",
//				new MManagementTeamProjectPanel.Factory(), true, idSuffix, MManagementTeamProjectPanel.class));
            menuMap.put("10211", new ExplorerTreeNode("公司项目", "new_managermentTeam_my_project", "project_management", "silk/layout_content.png",
                    new GContractInfoPanel.Factory(), true, idSuffix, GContractInfoPanel.class));
            menuMap.put("10207", new ExplorerTreeNode("项目成员", "my_team", "project_management", "silk/layout_content.png",
                    new SplateManagerPanel.Factory(), true, idSuffix, SplateManagerPanel.class));
        }
        //设计师项目
        if (RoleDefinition.ROLE_DESIGNER == roleID) {
            menuMap.put("10206", new ExplorerTreeNode("我的项目", "designer_my_project", "project_management", "silk/layout_content.png",
                    null, true, idSuffix, null));
            menuMap.put("1020601", new ExplorerTreeNode("我参与的项目", "myProject_management", "designer_my_project", "silk/layout_content.png",
                    new DesignerProjectPanel.Factory(), true, idSuffix, DesignerProjectPanel.class));
            menuMap.put("1020602", new ExplorerTreeNode("我的邀请", "myInvite_management", "designer_my_project", "silk/layout_content.png",
                    new MprojectemployeeporPanel.Factory(), true, idSuffix, MprojectemployeeporPanel.class));
        }
        //运营部
        if (RoleDefinition.ROLE_OPERATION_TEAM == roleID) {
            menuMap.put("10208", new ExplorerTreeNode("项目价格表", "project_price", "project_management", "silk/layout_content.png",
                    new SprojectPricePanelPanel.Factory(), true, idSuffix, SprojectPricePanelPanel.class));
        }

        //成员积分汇总
        if (RoleDefinition.ROLE_OPERATION_TEAM == roleID || RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID || RoleDefinition.ROLE_DEPARTMENT_DIRECTOR == roleID) {
            menuMap.put("10209", new ExplorerTreeNode("积分汇总", "plate_integral_total", "project_management", "silk/layout_content.png",
                    new MplateIntegralTotalPanel.Factory(), true, idSuffix, MplateIntegralTotalPanel.class));
            menuMap.put("10210", new ExplorerTreeNode("成员积分汇总", "award_total", "project_management", "silk/layout_content.png",
                    new MemployeeAwardTotalPanel.Factory(), true, idSuffix, MemployeeAwardTotalPanel.class));
        }
        //高管和事业部负责人
        if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID || RoleDefinition.ROLE_DEPARTMENT_DIRECTOR == roleID) {
            //项目积分转移记录(只有高管能看全部的记录，其它只能看自己板块的)
            menuMap.put("10212", new ExplorerTreeNode("积分转移记录", "project_integral_transfer", "project_management", "silk/layout_content.png",
                    new MprojectintegraltransferrecordPanel.Factory(), true, idSuffix, MprojectintegraltransferrecordPanel.class));
            menuMap.put("10213", new ExplorerTreeNode("积分发放记录", "project_integral_assign", "project_management", "silk/layout_content.png",
                    new SprojectIntegralAssignPanel.Factory(), true, idSuffix, SprojectIntegralAssignPanel.class));
        }

        //功能管理
        if (RoleDefinition.ROLE_INFORMATION_TEAM == roleID) {
            menuMap.put("10301", new ExplorerTreeNode("功能管理", "function_management", "system_management", "silk/layout_content.png",
                    new SfunctionffaorPanel.Factory(), true, idSuffix, SfunctionffaorPanel.class));
        }
        //合同管理暂时开放给高管
        if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID) {
//                menuMap.put("10601", new ExplorerTreeNode("协同项目信息", "main_project", "contract_management", "silk/layout_content.png",
//                        new MainProjectInfoPanel.Factory(), true, idSuffix, MainProjectInfoPanel.class));
            menuMap.put("10602", new ExplorerTreeNode("合同信息", "main_contract", "contract_management", "silk/layout_content.png",
                    new ContractInfoPanel.Factory(), true, idSuffix, ContractInfoPanel.class));
//                menuMap.put("10701", new ExplorerTreeNode("旧项目经费", "project_cost", "cost_management", "silk/layout_content.png", 
//                        new SprojectcostpcorPanel.Factory(), true, idSuffix, SprojectcostpcorPanel.class));
            menuMap.put("10702", new ExplorerTreeNode("项目成本", "project_cost_list", "cost_management", "silk/layout_content.png",
                    new ProjectCostListPanel.Factory(), true, idSuffix, ProjectCostListPanel.class));
        }
    }
}
