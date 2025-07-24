package com.pomplatform.client.applyfunctions.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.app.datasource.DSFunction;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

/**
 * 赋予的权限
 * @author J&A
 */
public class GiveFunctionPanel extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private DelicacyListGrid grid = new DelicacyListGrid();
    private final TreeGrid SourceGrid = new TreeGrid();
    private String functionCode = "";
    private String functionName = "";
    private Label TitleView;

    public GiveFunctionPanel() {

        VLayout mainLayout = new VLayout();
        mainLayout.setHeight100();
        mainLayout.setWidth100();
        addMember(mainLayout);

        HLayout topLaout = new HLayout(10);
        topLaout.setWidth100();
        topLaout.setHeight("4%");
        mainLayout.addMember(topLaout);

        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.setWidth100();
        mainLayout.addMember(SearchSourceLayout);


        TitleView = new Label();
        TitleView.setContents("<font style=\"color:black;font-size:14px;font-weight:bold;\">准备赋予的权限</font>");
        TitleView.setWidth("100%");
        TitleView.setHeight("4%");
        TitleView.setAlign(Alignment.CENTER);
        topLaout.addMember(TitleView);

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
        SourceGrid.setFields(fields);
        SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
        SourceGrid.setDataSource(DSFunction.getInstance());
        SourceGrid.setShowOpenIcons(false);
        SourceGrid.setShowDropIcons(false);
        SourceGrid.setShowSelectedStyle(true);
        SourceGrid.setShowPartialSelection(true);
        // 当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        SourceGrid.setCascadeSelection(true);
        SearchSourceLayout.setHeight100();
        SearchSourceLayout.setLayoutTopMargin(10);
        SearchSourceLayout.setLayoutRightMargin(5);
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.addMember(SourceGrid);
        mainLayout.addMember(SearchSourceLayout);
    }

    @Override
    public void startEdit() {
        Map condition = new HashMap(0);
        condition.put("personnelBusinessId", personnelBusinessId);
        DBDataSource.callOperation("NQ_MyAuthorityApplication", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {

                __logger.info("返回的数据===================="+data);

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
                    SourceGrid.setData(tree);
                }
            }
        });
    }


    @Override
    public boolean checkData() {
        for (ListGridRecord r : SourceGrid.getSelectedRecords()) {
            __logger.info(MapUtils.convertRecordToMap(SourceGrid.getDataSource(), r).toString());
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
        Map param = new HashMap();
        //param.put("optType", "employeeData");
        Record record = grid.getSelectedRecord();
		/*if (!BaseHelpUtils.isNullOrEmpty(record)) {
			param.put("employeeId", record.getAttributeAsInt("employeeId"));
		}*/
        ListGridRecord[] selected = SourceGrid.getSelectedRecords();
        List resList = new ArrayList();
        for (ListGridRecord r : selected) {
            Map lm = new HashMap();
            lm.put("functionId", r.getAttribute("functionId"));
            lm.put("applicationId", r.getAttribute("applicationId"));
            resList.add(lm);
        }
        param.put("detailRoleFunction", resList);
        return param;
    }

    @Override
    public String getName() {
        return "";
    }

    // 初始化
    private int roleId = -1;
    private int departmentId;

    /**
     * @return the roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
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
        return SourceGrid;
    }

    public DelicacyListGrid getGrid() {
        return grid;
    }

    public void setGrid(DelicacyListGrid grid) {
        this.grid = grid;
    }

    private int employeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    private int personnelBusinessId;


    public int getPersonnelBusinessId() {
        return personnelBusinessId;
    }

    public void setPersonnelBusinessId(int personnelBusinessId) {
        this.personnelBusinessId = personnelBusinessId;
    }

    public void setSourceGrid() {
        SourceGrid.setCanEdit(false);
    }

    private int functionBusinessId;

    public int getFunctionBusinessId() {
        return functionBusinessId;
    }

    public void setFunctionBusinessId(int functionBusinessId) {
        this.functionBusinessId = functionBusinessId;
    }
}


