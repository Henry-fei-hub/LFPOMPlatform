package com.pomplatform.client.applyfunctions.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.management.datasource.DSCopyEmployeeAllFunctionToOther;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
public class FuntionDetailPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private final TreeGrid SourceGrid = new TreeGrid();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private Label TitleView;
	

	public FuntionDetailPanel() {
		VLayout  mainLayout=new VLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		addMember(mainLayout);

		HLayout topLaout=new HLayout(10);
		topLaout.setWidth100();
		topLaout.setHeight("4%");
		mainLayout.addMember(topLaout);
		
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.setWidth100();
		mainLayout.addMember(SearchSourceLayout);

		TitleView = new Label();
		TitleView.setContents("<font style=\"color:black;font-size:14px;font-weight:bold;\">已拥有的权限</font>");
		TitleView.setWidth("100%");
		TitleView.setHeight("10%");
		TitleView.setAlign(Alignment.CENTER);
		topLaout.addMember(TitleView);
		mainLayout.addMember(topLaout);

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
		fields[idx] = new TreeGridField("empFun");
		idx++;
		fields[idx] = new TreeGridField("roleFun");
		idx++;
		fields[idx] = new TreeGridField("departmentRoleFun");
		idx++;
		SourceGrid.setFields(fields);
		SourceGrid.setDataSource(DSCopyEmployeeAllFunctionToOther.getInstance());
		SourceGrid.setShowOpenIcons(false);
		SourceGrid.setShowDropIcons(false);
		SourceGrid.setShowSelectedStyle(false);
		SourceGrid.setShowPartialSelection(true);
		SourceGrid.setCascadeSelection(true);
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
	}

	/**
	 * 开始数据填充的地方
	 */
	@Override
	public void startEdit() {
		Map condition = new HashMap();
		condition.put("employeeId", employeeId);
		DBDataSource.callOperation("NQ_CopyEmployeeAllFunctionToOther", "find", condition, new DSCallback() {
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
		return null;
	}

	@Override
	public String getName() {
		return "";
	}
	
	private int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
