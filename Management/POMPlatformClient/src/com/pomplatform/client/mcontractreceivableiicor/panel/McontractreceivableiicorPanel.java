package com.pomplatform.client.mcontractreceivableiicor.panel;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.mcontractreceivableiicor.datasource.DSMcontractreceivableiicor;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class McontractreceivableiicorPanel extends AbstractWizadPage implements HasHandlers
{


	private static final Logger __LOGGER = Logger.getLogger("");

	private Integer contractId;
	
	private Integer invoiceApplyId;
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Integer getInvoiceApplyId() {
		return invoiceApplyId;
	}

	public void setInvoiceApplyId(Integer invoiceApplyId) {
		this.invoiceApplyId = invoiceApplyId;
	}

	public TreeGrid SourceGrid;

	public McontractreceivableiicorPanel(boolean isUpdate){
		setBorder(BORDER_STYLE);
		int idx = 0;
		TreeGridField [] fields = new TreeGridField[4];
		fields[idx] = new TreeGridField("receivableName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new TreeGridField("receivablePercentage");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new TreeGridField("receivableSumMoney");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new TreeGridField("receivableApplyMoney");
		fields[idx].setCanEdit(isUpdate);
		fields[idx].setShowGridSummary(true);
		SourceGrid = new TreeGrid();
		SourceGrid.setFields(fields);
		SourceGrid.setSaveLocally(true);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setDataSource(DSMcontractreceivableiicor.getInstance());
        SourceGrid.setShowOpenIcons(false);
        SourceGrid.setShowDropIcons(false);
        SourceGrid.setShowSelectedStyle(false);
        SourceGrid.setShowPartialSelection(true);
        SourceGrid.setCanEdit(isUpdate);
        SourceGrid.setShowGridSummary(true);
        //当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        SourceGrid.setCascadeSelection(false);
        addMember(SourceGrid);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return false;
	}

	@Override
	public void startEdit() {
		Map<String, Object> params = new HashMap<>();
		if(null != getContractId())params.put("contractId", getContractId());
		if(null == getInvoiceApplyId()){
			params.put("invoiceApplyId", -1);
		}else{
			params.put("invoiceApplyId", getInvoiceApplyId());
		};
		DSMcontractreceivableiicor ds = getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        DBDataSource.callOperation(operationName, "find", params, new DSCallback() {
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
                tree.setIdField("contractReceivableId");
                tree.setParentIdField("parentId");
                tree.setData(nodes);
                tree.openAll();
                SourceGrid.setData(tree);
            }
        });
	}
	
	public DSMcontractreceivableiicor getDataSource() {
		return DSMcontractreceivableiicor.getInstance();
	}
}

