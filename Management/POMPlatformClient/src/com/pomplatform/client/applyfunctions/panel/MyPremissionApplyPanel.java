package com.pomplatform.client.applyfunctions.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.TransferImgBt;
import com.delicacy.client.app.datasource.DSFunction;
import com.delicacy.client.app.datasource.DSFunctionList;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * 我的权限申请界面
 *
 * @author J&A
 */
public class MyPremissionApplyPanel extends AbstractWizadPage {
    private static final Logger __logger = Logger.getLogger("MyPremissionApplyPanel");
    private DelicacyListGrid grid = new DelicacyListGrid();
    private final TreeGrid premissionTreeGrid = new TreeGrid();
    private final TreeGrid premissionTreeRsultGrid = new TreeGrid();
    //用户已有且已选中的权限
    private Map<Object, Object> selectedMap = null;
    //用户打算申请的权限
    private Map<Object, Object> claimesPriorityMap = null;

    private String functionCode;
    private String functionName;
    private VLayout mainLayout;
    private VLayout leftPremissionLayout;
    private VLayout rightPremissionLayout;
    private HLayout premissionLayout;
    private Label TitleView;
    private Label TitleViews;

    public MyPremissionApplyPanel() {

        mainLayout = new VLayout(10);
        mainLayout.setWidth100();
        mainLayout.setHeight100();

        TitleView = new Label();
        TitleView.setContents("<font style=\"color:black;font-size:14px;\">可赋予权限</font>");
        TitleView.setWidth("100%");
        TitleView.setHeight("5%");
        TitleView.setAlign(Alignment.CENTER);

        TitleViews = new Label();
        TitleViews.setContents("<font style=\"color:black;font-size:14px;\">准备申请的权限</font>");
        TitleViews.setWidth("100%");
        TitleViews.setHeight("5%");
        TitleViews.setAlign(Alignment.CENTER);

        premissionLayout = new HLayout();
        premissionLayout.setWidth100();
        premissionLayout.setHeight100();

        leftPremissionLayout = new VLayout(10);
        leftPremissionLayout.setWidth100();
        leftPremissionLayout.setHeight100();
        leftPremissionLayout.setLayoutMargin(10);

        rightPremissionLayout = new VLayout(10);
        rightPremissionLayout.setWidth100();
        rightPremissionLayout.setHeight100();
        rightPremissionLayout.setLayoutMargin(10);
        rightPremissionLayout.setAlign(Alignment.RIGHT);

        TreeGridField[] fields = new TreeGridField[6];
        int idx = 0;
        fields[idx] = new TreeGridField("functionId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("functionCode");
        idx++;
        fields[idx] = new TreeGridField("parentId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("functionName");
        fields[idx].setFrozen(true);
        idx++;
        fields[idx] = new TreeGridField("applicationId");
        idx++;
        fields[idx] = new TreeGridField("enabled");
        fields[idx].setHidden(true);
        idx++;
        premissionTreeGrid.setFields(fields);
        premissionTreeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        premissionTreeGrid.setDataSource(DSFunction.getInstance());
        premissionTreeGrid.setShowOpenIcons(false);
        premissionTreeGrid.setShowDropIcons(false);
        premissionTreeGrid.setShowSelectedStyle(true);
        premissionTreeGrid.setShowPartialSelection(true);
        //当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        premissionTreeGrid.setCascadeSelection(true);
        leftPremissionLayout.addMember(TitleView);
        leftPremissionLayout.addMember(premissionTreeGrid);
        premissionLayout.addMember(leftPremissionLayout);

        //添加权限的按钮
        TransferImgBt addToButton2 = new TransferImgBt(TransferImgBt.RIGHT);
        premissionLayout.addMember(addToButton2);


        addToButton2.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!premissionTreeGrid.anySelected()) {
                    return;
                }
                //将两个treegrid进行关联
                addSelectTreGridToTarget(premissionTreeGrid, premissionTreeRsultGrid);
            }
        });

        //右边接收权限的界面
        TreeGridField[] fields2 = new TreeGridField[6];
        int idx2 = 0;
        fields2[idx2] = new TreeGridField("functionId");
        fields2[idx2].setHidden(true);
        idx2++;
        fields2[idx2] = new TreeGridField("functionCode");
        idx2++;
        fields2[idx2] = new TreeGridField("parentId");
        fields2[idx2].setHidden(true);
        idx2++;
        fields2[idx2] = new TreeGridField("functionName");
        fields2[idx2].setFrozen(true);
        idx2++;
        fields2[idx2] = new TreeGridField("applicationId");
        idx2++;
        fields2[idx2] = new TreeGridField("enabled");
        fields2[idx2].setHidden(true);
        idx2++;

        premissionTreeRsultGrid.setFields(fields2);
        premissionTreeRsultGrid.setDataSource(DSFunctionList.getInstance());
        premissionTreeRsultGrid.setShowOpenIcons(false);
        premissionTreeRsultGrid.setShowDropIcons(false);
        //父控件的勾选样式
        premissionTreeRsultGrid.setShowSelectedStyle(false);
        premissionTreeRsultGrid.setShowPartialSelection(true);

        rightPremissionLayout.addMember(TitleViews);
        rightPremissionLayout.addMember(premissionTreeRsultGrid);
        premissionLayout.addMember(rightPremissionLayout);
        mainLayout.addMember(premissionLayout);
        addMember(mainLayout);

    }

    /**
     * 数据关联方法
     *
     * @param premissionTreeGrid
     * @param premissionTreeRsultGrid
     */
    private void addSelectTreGridToTarget(TreeGrid premissionTreeGrid, TreeGrid premissionTreeRsultGrid) {

        /**
         * 将左边可赋予的权限组合成一个list数组
         */
        ListGridRecord[] selectedRecords = premissionTreeGrid.getSelectedRecords();
        RecordList recordList = premissionTreeRsultGrid.getDataAsRecordList();

        int originalLength = recordList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(recordList.getRange(0, originalLength));
        }

        selectedMap = new HashMap<>(0);
        int selectLength = selectedRecords.length;
        TreeNode[] nodes = new TreeNode[selectLength];
        Map searchMap = new HashMap(0);

        Tree originalList = premissionTreeGrid.getData();

        //数据转为树状结构并显示
        for (int i = 0; i < selectLength; i++) {
            int functionId = ClientUtil.checkAndGetIntValue(selectedRecords[i].getAttribute("functionId"));
            searchMap.put("functionId", functionId);
            searchMap.put("applicationId", selectedRecords[i].getAttribute("applicationId"));
            nodes[i] = new TreeNode();
            DBDataSource.copyRecordNotInclude(selectedRecords[i], nodes[i], "children");
            int idx = originalList.findIndex(searchMap);
            if (idx == -1) {
                continue;
            }
            //把已选择的功能放入map中
            selectedMap.put(functionId, functionId);
            TreeNode node = premissionTreeGrid.getRecord(idx);
            if (originalList.isFolder(node)) {
                continue;
            }
            premissionTreeRsultGrid.selectRecord(idx);
        }

        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setRootValue("0");
        tree.setIdField("functionId");
        tree.setParentIdField("parentId");
        tree.setData(nodes);
        tree.openAll();
        premissionTreeRsultGrid.setData(tree);

    }

    @Override
    public void startEdit() {
        Map condition = new HashMap(0);
        condition.put("functionCode", functionCode);
        condition.put("functionName", functionName);
        DBDataSource.callOperation("EP_SerachRoleFunction", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    int len = dsResponse.getData().length;
                    TreeNode[] nodes = new TreeNode[len];
                    for (int i = 0; i < len; i++) {
                        nodes[i] = new TreeNode();
                        DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
                    }
                    Tree tree = new Tree();
                    tree.setModelType(TreeModelType.PARENT);
                    tree.setRootValue("0");
                    tree.setIdField("functionId");
                    tree.setParentIdField("parentId");
                    tree.setData(nodes);
                    tree.openAll();
                    premissionTreeGrid.setData(tree);

                    reloadDetailTableData();
                }
            }
        });

        /**
         * 获取可以申请的权限
         */
//        Map condition = new HashMap(0);
//        condition.put("employeeId", ClientUtil.getEmployeeId());
//        DBDataSource.callOperation("NQ_NotApplyPermission", "find", condition, new DSCallback() {
//            @Override
//            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
//                if (dsResponse.getStatus() >= 0) {
//                    int len = dsResponse.getData().length;
//
//                    //将数据类型转成treenode
//                    TreeNode[] nodes = new TreeNode[len];
//                    for (int i = 0; i < len; i++) {
//                        nodes[i] = new TreeNode();
//                        DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
//                    }
//                    Tree tree = new Tree();
//                    tree.setModelType(TreeModelType.PARENT);
//                    tree.setRootValue("0");
//                    tree.setIdField("functionId");
//                    tree.setParentIdField("parentId");
//                    tree.setData(nodes);
//                    tree.openAll();
//                    premissionTreeGrid.setData(tree);
//                    if (getRecord() != null) {
//                        reloadDetailTableData();
//                    }
//                }
//            }
//        });

    }


    public void reloadDetailTableData() {
        claimesPriorityMap = new HashMap(0);
        Map condition = new HashMap(0);
        condition.put("employeeId", ClientUtil.getEmployeeId());
        condition.put("optType", "functionData");
        DBDataSource.callOperation("EP_UpdateRoleDepartmentEmployeeFunction", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    int len = dsResponse.getData().length;
                    if (len == 0) {
                        return;
                    }

                    Map searchMap = new HashMap(0);
                    Tree originalList = premissionTreeGrid.getData();

                    for (int i = 0; i < len; i++) {
                        int functionId = ClientUtil.checkAndGetIntValue(dsResponse.getData()[i].getAttribute("functionId"));
                        searchMap.put("functionId", functionId);
                        searchMap.put("applicationId", dsResponse.getData()[i].getAttribute("applicationId"));
                        int idx = originalList.findIndex(searchMap);
                        if (idx == -1) {
                            continue;
                        }
                        //把已选择的功能放入map中
                        claimesPriorityMap.put(functionId, functionId);
                        TreeNode node = premissionTreeGrid.getRecord(idx);
                        if (originalList.isFolder(node)) {
                            continue;
                        }

                        premissionTreeGrid.selectRecord(idx);
                    }
                }
            }
        });
    }

    @Override
    public boolean checkData() {
        for (ListGridRecord r : premissionTreeGrid.getSelectedRecords()) {
            __logger.info(MapUtils.convertRecordToMap(premissionTreeGrid.getDataSource(), r).toString());
        }
        return true;
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("detailRoleFunction");
        return res;
    }

    @Override
    public Map getValuesAsMap() {
        Map param = new HashMap(0);

        param.put("optType", "employeeData");

        Record record = grid.getSelectedRecord();
        if (!BaseHelpUtils.isNullOrEmpty(record)) {
            param.put("employeeId", record.getAttributeAsInt("employeeId"));
        }

        ListGridRecord[] selected = premissionTreeGrid.getSelectedRecords();
        List resList = new ArrayList();
        //获取准备赋予的权限的长度
        int originalLength = premissionTreeRsultGrid.getDataAsRecordList().getLength();

        for (ListGridRecord r : selected) {
            Map lm = new HashMap(0);
            lm.put("functionId", r.getAttribute("functionId"));
            lm.put("applicationId", r.getAttribute("applicationId"));
            resList.add(lm);
        }
        __logger.info("准备赋予的权限的list" + resList);

        param.put("detailRoleFunction", resList);

        param.put("originalLength", originalLength);
        return param;
    }

    @Override
    public String getName() {
        return "";
    }

    //初始化
    private int roleId = -1;
    private int departmentId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public TreeGrid getSourceGrid() {
        return premissionTreeGrid;
    }
}