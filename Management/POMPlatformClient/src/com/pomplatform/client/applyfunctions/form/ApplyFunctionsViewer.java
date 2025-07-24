package com.pomplatform.client.applyfunctions.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.applyfunctions.datasource.DSApplyFunctions;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

import java.util.*;
import java.util.logging.Logger;

public class ApplyFunctionsViewer extends AbstractDetailViewer {
    private SearchForm __parentSearchForm;
    private TextItem employeeIdItem;
    private TextItem employeeNoItem;
    private TextItem departmentIdItem;
    private TextItem companyIdItem;
    private DateItem startDateItem;
    private DateItem endDateItem;
    private TextItem daysItem;
    private TextAreaItem reasonItem;
    private DynamicForm searchForm;
    private SelectItem parentIdItem;
    private CheckboxItem isForeverItem;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private static Logger __logger = Logger.getLogger("");
    private HLayout mainLayout;
    private HLayout rightLayout;
    private HLayout leftLayout;

    FuntionDetailPanel panel=new FuntionDetailPanel();
    GiveFunctionPanel  givePanel=new GiveFunctionPanel();

    @Override
    public void initComponents() {
        mainLayout=new HLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        addMember(mainLayout);

        leftLayout=new HLayout();
        leftLayout.setHeight100();
        leftLayout.setWidth("30%");
        mainLayout.addMember(leftLayout);

        rightLayout=new HLayout();
        rightLayout.setHeight100();
        rightLayout.setWidth("70%");
        mainLayout.addMember(rightLayout);

        rightLayout.addMember(panel);
        rightLayout.addMember(givePanel);


        DSApplyFunctions ds = DSApplyFunctions.getInstance();
        employeeIdItem = new TextItem("employeeId", "申请人");
        employeeIdItem.setWidth("*");
        employeeIdItem.setDisabled(true);
        employeeIdItem.setTextBoxStyle("customInputTextStyle");
        KeyValueManager.loadValueMap("employees", employeeIdItem);
        employeeIdItem.setCanEdit(false);


        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setDisabled(true);
        employeeNoItem.setTextBoxStyle("customInputTextStyle");
        employeeNoItem.setCanEdit(false);


        departmentIdItem = new TextItem("departmentId", "部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setDisabled(true);
        departmentIdItem.setTextBoxStyle("customInputTextStyle");
        KeyValueManager.loadValueMap("departments", departmentIdItem);
        departmentIdItem.setCanEdit(false);


        companyIdItem = new TextItem("companyId", "归属公司");
        companyIdItem.setWidth("*");
        companyIdItem.setDisabled(true);
        companyIdItem.setTextBoxStyle("customInputTextStyle");
        KeyValueManager.loadValueMap("company_records", companyIdItem);
        companyIdItem.setCanEdit(false);

        startDateItem = new DateItem("startDate", "开始日期");
        startDateItem.setWidth("*");
        startDateItem.setDisabled(true);
        startDateItem.setUseTextField(true);
        startDateItem.setDefaultValue(new Date());
        startDateItem.setUseMask(true);
        startDateItem.setTextBoxStyle("customInputTextStyle");
        startDateItem.setCanEdit(false);


        endDateItem = new DateItem("endDate", shouldNotBeNull+"结束时间");
        endDateItem.setWidth("*");
        endDateItem.setUseTextField(true);
        endDateItem.setUseMask(true);
        endDateItem.setDisabled(true);
        endDateItem.setTextBoxStyle("customInputTextStyle");
        endDateItem.setRequired(true);
        endDateItem.setCanEdit(false);


        daysItem = new TextItem("days", shouldNotBeNull+"天数");
        daysItem.setWidth("*");
        daysItem.setDisabled(true);
        daysItem.setRequired(true);
        daysItem.setTextBoxStyle("customInputTextStyle");
        daysItem.setStartRow(false);
        daysItem.setCanEdit(false);


        LinkedHashMap<Integer,String> linkMap=new LinkedHashMap<>();
        linkMap.put(1, "Erp权限");
        linkMap.put(2, "cwd权限");


        parentIdItem=new SelectItem("parentId","权限类型");
        parentIdItem.setWidth("*");
        parentIdItem.setRequired(true);
        parentIdItem.setValueMap(linkMap);
        parentIdItem.setDisabled(true);
        parentIdItem.setTextBoxStyle("customInputTextStyle");
        parentIdItem.setCanEdit(false);


        isForeverItem=new CheckboxItem("isForever","永久有效");
        isForeverItem.setWidth("*");
        //CheckBox不能选中
        isForeverItem.setCanEdit(false);

        reasonItem = new TextAreaItem("reason", shouldNotBeNull+"申请权限模块描述");
        reasonItem.setWidth("*");
        reasonItem.setRequired(true);
        reasonItem.setCanEdit(false);

        searchForm=new DynamicForm();
        searchForm.setNumCols(4);
        searchForm.setPadding(3);
        searchForm.setMargin(5);
        searchForm.setWidth("100%");;
        searchForm.setHeight("100%");
        searchForm.setFields(employeeIdItem,employeeNoItem,departmentIdItem,companyIdItem,startDateItem,endDateItem,daysItem,parentIdItem,isForeverItem,reasonItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(searchForm);
        reasonItem.setColSpan(4);
        leftLayout.addMember(searchForm);
    }

    @Override
    public int getHorizontalPercent() {
        return 0;
    }

    @Override
    public String getName() {
        return "ApplyFunctions";
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<GroupColumn>();
        return gcs;
    }


    /**
     * 数据加载
     */
    @Override
    public void load() {
        if (getBusinessId() == null) {
            return;
        }
        Map params = new HashMap();
        params.put("personnelBusinessId", getBusinessId());

        DBDataSource.callOperation("NQ_ApplyFunctions", "find", new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    for (DetailViewer v : detailViewers) {
                        v.setData(dsResponse.getData());
                        if (dsResponse.getData().length == 0) {
                            continue;
                        }
                        v.selectRecord(0);
                        v.redraw();
                    }
                    setRecord(dsResponse.getData()[0]);
                    viewDetailData();
                }
            }
        });

        //加载和显示左右两边的布局的内容

    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
        setRecord(grid.getSelectedRecord());
        viewDetailData();
    }

    @Override
    public void viewDetailData() {
        searchForm.editRecord(getRecord());
        __logger.info("viewDetail"+getRecord().toMap().toString());

        //判断是否是永久权限
        boolean value = BaseHelpUtils.getBoolean(getRecord().getAttribute("isRemoteCity"));
        if (value == true) {
            endDateItem.hide();
            daysItem.hide();
            isForeverItem.setValue(true);
        } else {
            endDateItem.show();
            daysItem.show();
            isForeverItem.setValue(false);
        }

        panel.setEmployeeId(BaseHelpUtils.getIntValue(getRecord().getAttribute("employeeId")));
        panel.startEdit();
        rightLayout.addMember(panel);

        givePanel.setSourceGrid();
        givePanel.setEmployeeId(BaseHelpUtils.getIntValue(getRecord().getAttribute("employeeId")));
        givePanel.setPersonnelBusinessId(BaseHelpUtils.getIntValue(getRecord().getAttribute("personnelBusinessId")));
        givePanel.startEdit();
        rightLayout.addMember(givePanel);

    }

    @Override
    public DataSource getMainDataSource() {
        return DSApplyFunctions.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 0;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<ListGrid>();
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<String>();
        return res;
    }

    public SearchForm getParentSearchForm() {
        return this.__parentSearchForm;
    }

    public void setParentSearchForm(SearchForm value) {
        this.__parentSearchForm = value;
    }

    private String processName;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

}

