package com.pomplatform.client.annoucement.panel;

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
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;


/**
 * 我的权限界面
 */
public class MyPermissionsFunctionPanel extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
	private final TreeGrid SourceGrid = new TreeGrid();
	private IButton applyBut;
	public MyPermissionsFunctionPanel() {
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.setWidth100();

		applyBut=new IButton("申请权限");
		applyBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取流程process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
				if(!PomPlatformClientUtil.isNullOrEmpty(str)){
					String[] arr = str.split(",");
					for(String tempStr : arr){
						String[] tempArr = tempStr.split(":");
						//获取父级ID
						if(tempArr[0].replaceAll("\"", "").equals("Apply_Functions")){
							processId = tempArr[1];
						}
					}
				}
				NewProcessWindow panel=new NewProcessWindow();
				panel.setTitle("申请权限");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				Record record=new Record();
				record.setAttribute("employeeId", ClientUtil.getEmployeeId());
				panel.setData(record);
				panel.setLayoutMode(2);
				panel.initComponents();
				panel.setWidth("100%");
				panel.setHeight("100%");
				panel.centerInPage();
				panel.show();
			}
		});

		SearchSourceLayout.addMember(applyBut);

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
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
		addMember(SearchSourceLayout);
		startEdit();
	}


	@Override
	public void startEdit() {

		Map condition = new HashMap(0);
		condition.put("employeeId", ClientUtil.getUserId());
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

}
