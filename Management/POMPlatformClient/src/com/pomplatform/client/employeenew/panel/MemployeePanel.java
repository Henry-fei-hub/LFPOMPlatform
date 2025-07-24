package com.pomplatform.client.employeenew.panel;

import com.delicacy.client.*;
import com.delicacy.client.app.datasource.DSMemployee;
import com.delicacy.client.app.form.MemployeeViewer;
import com.delicacy.client.app.form.NewMemployeeForm;
import com.delicacy.client.app.panel.EmpRoleAndDepartmentRolePanel;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employee.form.UpdateMemployeeForm;
import com.pomplatform.client.employeeInformationDetails.panel.MemployeeeeedorPanel;
import com.pomplatform.client.employeenew.form.MemployeeSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.*;
import java.util.logging.Logger;

public class MemployeePanel extends AbstractSearchPanel {

	private static final Logger __logger = Logger.getLogger("");
    private static MemployeeSearchForm form1 = null;
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MemployeePanel cm = new MemployeePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Memployee";
        }

    }

    @Override
    public void init() {
        super.init();
        form1 = new MemployeeSearchForm();
    }

    @Override
    public void initComponents() {
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });


        IButton searchButton = new IButton("自定义查询条件");
        controlLayout.addMember(searchButton);
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                PopupWindow window = new PopupWindow();
                SearchSelectPanel searchSelectPanel = new SearchSelectPanel();
                searchSelectPanel.setPanel(window);
                searchSelectPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        form1.hideAll();
                        Record record = event.getData();
                        for (int i=0 ; i<=42 ; i++){
                            Integer temp = BaseHelpUtils.getIntValue(record.getAttribute(i + ""));
                            if (temp != 0){
                                switch (temp){
                                    case 1:
                                        form1.employeeNoItem.show();
                                        break;
                                    case 2:
                                        form1.employeeNameItem.show();
                                        break;
                                    case 3:
                                        form1.plateIdItem.show();
                                        break;
                                    case 4:
                                        form1.departmentIdItem.show();
                                        break;
                                    case 5:
                                        form1.roleIdItem.show();
                                        break;
                                    case 6:
                                        form1.gradeIdItem.show();
                                        break;
                                    case 7:
                                        form1.statusItem.show();
                                        break;
                                    case 8:
                                        form1.isDepartmentItem.show();
                                        break;
                                    case 9:
                                        form1.genderItem.show();
                                        break;
                                    case 10:
                                        form1.dutyIdItem.show();
                                        break;
                                    case 11:
                                        form1.onboardDateItem.show();
                                        break;
                                    case 12:
                                        form1.resignationDateItem.show();
                                        break;
                                    case 13:
                                        form1.onboardYearItem.show();
                                        break;
                                    case 14:
                                        form1.onboardMonthItem.show();
                                        break;
                                    case 15:
                                        form1.resiYearItem.show();
                                        break;
                                    case 16:
                                        form1.resiMonthItem.show();
                                        break;
                                    case 17:
                                        form1.birthMonthItem.show();
                                        break;
                                    case 18:
                                        form1.isCheckItem.show();
                                        break;
                                    case 19:
                                        form1.mobileItem.show();
                                        break;
                                    case 20:
                                        form1.emailItem.show();
                                        break;
                                    case 21:
                                        form1.cardItem.show();
                                        break;
                                    case 22:
                                        form1.addressItem.show();
                                        break;
                                    case 23:
                                        form1.educationItem.show();
                                        break;
                                    case 24:
                                        form1.degreeItem.show();
                                        break;
                                    case 25:
                                        form1.nationalityItem.show();
                                        break;
                                    case 26:
                                        form1.marriedStatusItem.show();
                                        break;
                                    case 27:
                                        form1.workaddressItem.show();
                                        break;
                                    case 28:
                                        form1.birthplaceItem.show();
                                        break;
                                    case 29:
                                        form1.accountLocationItem.show();
                                        break;
                                    case 30:
                                        form1.startWorkYearItem.show();
                                        break;
                                    case 31:
                                        form1.socialComputerNumberItem.show();
                                        break;
                                    case 32:
                                        form1.fundAccountItem.show();
                                        break;
                                    case 33:
                                        form1.positiveDateItem.show();
                                        break;
                                    case 34:
                                        form1.trytimeItem.show();
                                        break;
                                    case 35:
                                        form1.contractStartDateItem.show();
                                        break;
                                    case 36:
                                        form1.contractStartMonthItem.show();
                                        break;
                                    case 37:
                                        form1.contractEndYearItem.show();
                                        break;
                                    case 38:
                                        form1.contractEndMonthItem.show();
                                        break;
                                    case 39:
                                        form1.ownedCompanyItem.show();
                                        break;
                                    case 40:
                                        form1.bankCardNumItem.show();
                                        break;
                                    case 41:
                                        form1.companyWeixinItem.show();
                                        break;
                                    case 42:
                                        form1.companyEmailItem.show();
                                        break;
                                }
                            }
                        }
                        form1.redraw();
                    }
                });
                window.setWidth("20%");
                window.setHeight("65%");
                window.centerInPage();
                window.addMember(searchSelectPanel);
                window.setTitle("自定义查询条件");
                window.show();
            }
        });

        IButton empviewButton = new IButton("查看详情");
        controlLayout.addMember(empviewButton);
        empviewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton empnewButton = PermissionControl.createPermissionButton("职员新增", BasicPermissionStatic.EMPLOYEE_ADD_BUTTON);
//        controlLayout.addMember(empnewButton);
        empnewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                        NewMemployeeForm detailForm = new NewMemployeeForm();
                        detailForm.setTitle("职员新增");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
//                                RecordList list = resultGrid.getDataAsRecordList();
//                                RecordList newList = new RecordList();
//                                newList.addList(list.getRange(0, list.getLength()));
//                                newList.add(event.getData());
//                                resultGrid.setData(newList);
//                                resultGrid.selectSingleRecord(newList.getLength() - 1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });
        IButton empupdateButton = PermissionControl.createPermissionButton("职员修改", BasicPermissionStatic.EMPLOYEE_UPDATE_BUTTON);
        controlLayout.addMember(empupdateButton);
        empupdateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        final ListGridRecord selected1 = resultGrid.getSelectedRecord();
                        UpdateMemployeeForm detailForm = new UpdateMemployeeForm();
                        detailForm.setTitle("职员修改");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
//                                DBDataSource.copyRecord(event.getData(), selected1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
//                        detailForm.setRecord(selected1);
                        detailForm.reloadData(selected1.getAttributeAsInt("employeeId"));
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.setOperatorId(ClientUtil.getEmployeeId());
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });
        IButton removeButton = PermissionControl.createPermissionButton("职员移除", BasicPermissionStatic.EMPLOYEE_DELETE_BUTTON);
        controlLayout.addMember(removeButton);
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        SC.confirm("提示", "您确定要移除该职员吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean r) {
                                if (r) {
                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
                                    int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
                                    Map param = new LinkedHashMap();
                                    param.put("employeeId", employeeId);
                                    String message = MapUtils.toJSON(param);
                                    //删除方法
                                    DBDataSource.callOperation("EP_EmployeeDelete", "delete", message, new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                //执行成功后重新执行查询，刷新表格数据
                                                commonQuery();
                                            } else {
                                                Map errors = dsResponse.getErrors();
                                                SC.say("delete failure" + errors);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
        IButton resetButton = PermissionControl.createPermissionButton("密码重置", BasicPermissionStatic.EMPLOYEE_RESET_PWD_BUTTON);
        controlLayout.addMember(resetButton);
        resetButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
                        String employeeNo = BaseHelpUtils.getString(selected[0].getAttribute("employeeNo"));
                        String employeeName = BaseHelpUtils.getString(selected[0].getAttribute("employeeName"));
                        if(BaseHelpUtils.isNullOrEmpty(employeeNo)) {
                        	SC.say("该职员缺少职员编号");
                        	return ;
                        }
                        SC.confirm("提示", "您确定要重置("+employeeName+")职员的密码吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean r) {
                                if (r) {
                              
                                    Map param = new LinkedHashMap();
                                    param.put("employeeId", employeeId);
                                    param.put("employeeNo", employeeNo);
                                    String message = MapUtils.toJSON(param);
                                    //重置
                                    DBDataSource.callOperation("EP_EmployeePwdReset", "update", message, new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                //执行成功后提示重置成功
                                                SC.say("提示","密码重置成功");
                                            } else {
                                                Map errors = dsResponse.getErrors();
                                                SC.say("update failure" + errors);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
        IButton setRoleButton = PermissionControl.createPermissionButton("角色设置", BasicPermissionStatic.EMPLOYEE_ROLE_SET_BUTTON);
        controlLayout.addMember(setRoleButton);
        setRoleButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
                        String employeeName = selected[0].getAttribute("employeeName");
                        PopupWindow pw = new PopupWindow();
                    //    EmpDepartmentRolePanel panel = new EmpDepartmentRolePanel(employeeId);
                        EmpRoleAndDepartmentRolePanel panel = new EmpRoleAndDepartmentRolePanel(employeeId,employeeName);
                        pw.addItem(panel);
                        panel.setParentCanvas(pw);
                        pw.setTitle("职员(" + employeeName + ")的角色设置");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                    }
                });
            }
        });
        IButton viewButton = PermissionControl.createPermissionButton("查看详细明细", BasicPermissionStatic.EMPLOYEE_CHECK_ALL_DETAIL_DATA);
        controlLayout.addMember(viewButton);
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                    PopupWindow window = new PopupWindow("查看职员详细明细");
                    MemployeeeeedorPanel panel = new MemployeeeeedorPanel();
                    panel.commonQuery();
                    window.addMember(panel);
                    window.setWidth100();
                    window.setHeight100();
                    window.centerInPage();
                    window.show();
            }
        });
        IButton downButton = PermissionControl.createPermissionButton("导出", BasicPermissionStatic.EMPLOYEE_EXPORT_BUTTON);
        controlLayout.addMember(downButton);
        downButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Criteria record = searchForm.getValuesAsCriteria();
                Map param = record.getValues();
                param.put("type" , 2);
                checkSearchCriteria(param);
                ClientUtil.departmentParameterProcess(param);
                DBDataSource.downloadFile("DW_OnDownloadEmployeeInfo", param);
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
                detail.setTitle("职员信息");
                detail.setWidth100();
                detail.setHeight100();
                MemployeeViewer detailForm = new MemployeeViewer(resultGrid);
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detailForm.setGrid(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public boolean checkSearchCriteria(Map criteria) {
        ClientUtil.departmentParameterProcess(criteria);
        List<Map> keyvalues = new ArrayList<>();
        int type = BaseHelpUtils.getIntValue(criteria.get("type"));
//        if(BaseHelpUtils.isNullOrEmpty(criteria.get("onboardYear"))){
//        	Map<String, String> kv = new HashMap<>();
//        	kv.put("key", "( EXTRACT ( YEAR FROM onboard_date ))");
//        	kv.put("value", "1");
//        	keyvalues.add(kv);
//        }
//        if(BaseHelpUtils.isNullOrEmpty(criteria.get("onboardMonth"))){
//        	Map<String, String> kv = new HashMap<>();
//        	kv.put("key", "( EXTRACT ( MONTH FROM onboard_date ))");
//        	kv.put("value", "1");
//        	keyvalues.add(kv);
//        }
//        if(BaseHelpUtils.isNullOrEmpty(criteria.get("resiYear"))){
//        	Map<String, String> kv = new HashMap<>();
//        	kv.put("key", "( EXTRACT ( YEAR FROM resignation_date ))");
//        	kv.put("value", "1");
//        	keyvalues.add(kv);
//        }
//        if(BaseHelpUtils.isNullOrEmpty(criteria.get("resiMonth"))){
//        	Map<String, String> kv = new HashMap<>();
//        	kv.put("key", "( EXTRACT ( MONTH FROM resignation_date ))");
//        	kv.put("value", "1");
//        	keyvalues.add(kv);
//        }
//        if(BaseHelpUtils.isNullOrEmpty(criteria.get("birthMonth"))){
//        	Map<String, String> kv = new HashMap<>();
//        	kv.put("key", "( EXTRACT ( MONTH FROM birth ))");
//        	kv.put("value", "1");
//        	keyvalues.add(kv);
//        }
        if (!BaseHelpUtils.isNullOrEmpty(criteria.get("roleId"))) {
            Map<String, String> kv = new HashMap<>();
            kv.put("key", "2 = 2");
            kv.put("value", "e.employee_id IN ( SELECT employee_id FROM employee_roles WHERE role_id = "+criteria.get("roleId")+" )");
            keyvalues.add(kv);
        }

        if (type != 2) {
            if (!BaseHelpUtils.isNullOrEmpty(criteria.get("roleId"))) {
                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "e.employee_id IN ( SELECT employee_id FROM employee_roles WHERE role_id =? )");
                kv.put("key", "2 = 2");
                kv.put("value", "e.employee_id IN ( SELECT employee_id FROM employee_roles WHERE role_id = "+criteria.get("roleId")+" )");
                keyvalues.add(kv);
            }
//            if (BaseHelpUtils.isNullOrEmpty(criteria.get("startWorkYear"))) {
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "( EXTRACT ( YEAR FROM start_work_date ))");
//                kv.put("value", "1");
//                keyvalues.add(kv);
//            }
//            if (BaseHelpUtils.isNullOrEmpty(criteria.get("startWorkMonth"))) {
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "( EXTRACT ( MONTH FROM start_work_date ))");
//                kv.put("value", "1");
//                keyvalues.add(kv);
//            }
//            if (BaseHelpUtils.isNullOrEmpty(criteria.get("contractStartYear"))) {
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "( EXTRACT ( YEAR FROM contract_start_date ))");
//                kv.put("value", "1");
//                keyvalues.add(kv);
//            }
//            if (BaseHelpUtils.isNullOrEmpty(criteria.get("contractStartMonth"))) {
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "( EXTRACT ( MONTH FROM contract_start_date ))");
//                kv.put("value", "1");
//                keyvalues.add(kv);
//            }
//            if (BaseHelpUtils.isNullOrEmpty(criteria.get("contractEndYear"))) {
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "( EXTRACT ( YEAR FROM contract_end_date ))");
//                kv.put("value", "1");
//                keyvalues.add(kv);
//            }
//            if (BaseHelpUtils.isNullOrEmpty(criteria.get("contractEndMonth"))) {
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "( EXTRACT ( MONTH FROM contract_end_date ))");
//                kv.put("value", "1");
//                keyvalues.add(kv);
//            }
        }
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
            criteria.put("keyValues", keyvalues);
        }

        int isCheck = BaseHelpUtils.getIntValue(criteria.get("isCheck"));
        if(isCheck == 1){
            criteria.put("isCheck", Boolean.TRUE);
        }else if(isCheck == 2){
            criteria.put("isCheck", Boolean.FALSE);
        }
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return form1;
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployee.getInstance();
    }
    
    @Override
    public int getSearchFormHeight() {
        return 179;
    }
    
}
