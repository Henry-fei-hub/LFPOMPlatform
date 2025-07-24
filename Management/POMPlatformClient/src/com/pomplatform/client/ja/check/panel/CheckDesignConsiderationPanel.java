package com.pomplatform.client.ja.check.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ja.ht.datasource.DSDesignConsideration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CheckDesignConsiderationPanel extends AbstractWizadPage implements HasHandlers {

	private static Logger __LOGGER = Logger.getLogger("");
	public TreeGrid SourceGrid;
	private DynamicForm __infoForm ;
	private TextItem totalItem ;

	public CheckDesignConsiderationPanel(String infoCode,String projectCode,int outQuotationId) {
		this.infoCode=infoCode;
		this.projectCode=projectCode;
		this.outQuotationId=outQuotationId;
		SourceGrid = new TreeGrid();
		SourceGrid.setCanEdit(false);
		
		TreeGridField [] fields = new TreeGridField[7];
		int idx = 0;
		fields[idx] = new TreeGridField("businessType");
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		fields[idx] = new TreeGridField("projectType");
		SelectItem projectTypeItem = new SelectItem();
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(projectTypeItem);
		
		idx ++;
		fields[idx] = new TreeGridField("mainDesignAreaName");
		idx ++;
		fields[idx] = new TreeGridField("designArea");
		idx ++;
		fields[idx] = new TreeGridField("splitPrice");
		idx ++;
		fields[idx] = new TreeGridField("remark");
		idx ++;
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setDataSource(DSDesignConsideration.getInstance());
         
        SourceGrid.setShowSelectedStyle(false);
        SourceGrid.setShowPartialSelection(true);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		allH.addMember(SourceGrid);
		addMember(allH);
	}

	@Override
	public void startEdit() {
		if (!BaseHelpUtils.isNullOrEmpty(infoCode)) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getDesignConsiderationList");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
			DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					int len = dsResponse.getData().length;
                    TreeNode[] nodes = new TreeNode[len];
                    for (int i = 0; i < len; i++) {
                        nodes[i] = new TreeNode();
                        DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
                    }
                    Tree tree = new Tree();
                    tree.setModelType(TreeModelType.PARENT);
                    tree.setRootValue("0");
                    tree.setIdField("designConsiderationId");
                    tree.setParentIdField("parentId");
                    tree.setData(nodes);
                    tree.openAll();
                    SourceGrid.setData(tree);
				}
			});
		}
	}

	//效验数据
		@Override
		public boolean checkData() {
			boolean isFlag=true;
			return isFlag;
		}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("checkDesignConsideration");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}
	private String infoCode;
	private String projectCode;
	private int outQuotationId;
	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public int getOutQuotationId() {
		return outQuotationId;
	}

	public void setOutQuotationId(int outQuotationId) {
		this.outQuotationId = outQuotationId;
	}

}
