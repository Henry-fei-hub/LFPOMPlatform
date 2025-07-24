package com.pomplatform.client.collection.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.contractreceivablecipor.datasource.DSScontractreceivablecipor;
import com.pomplatform.client.contractreceivables.datasource.DSContractReceivable;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CustomContractReceivablePanel extends AbstractWizadPage implements HasHandlers{
	
	public TreeGrid SourceGrid;
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public CustomContractReceivablePanel(final int contractId){
		this.contractId = contractId;
		setBorder(BORDER_STYLE);
		setPadding(5);
		SourceGrid = new TreeGrid();
		int idx = 0;
		TreeGridField [] fields = new TreeGridField[3];
		fields[idx] = new TreeGridField("receivableName");
		idx++ ;
		fields[idx] = new TreeGridField("receivableSumMoney");
		idx++;
		fields[idx] = new TreeGridField("stageSumMoney");
		idx++ ;
		fields[idx] = new TreeGridField("stagePercentage");
		idx++ ;
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSContractReceivable.getInstance());
        SourceGrid.setShowOpenIcons(false);
        SourceGrid.setShowDropIcons(false);
        SourceGrid.setShowSelectedStyle(false);
        SourceGrid.setShowPartialSelection(true);
        //当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        SourceGrid.setCascadeSelection(true);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		allH.addMember(SourceGrid);
		addMember(allH);
		
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if(null != getContractId()){
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", getContractId());
			params.put("opt_type", "loadContractReceivable");
			//
			DBDataSource.callOperation("EP_CustomItemCollectionHandler", params, new DSCallback() {
				
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
                  //设置默认选中的
					ListGridRecord[] recordList=SourceGrid.getRecords();
					if(recordList!=null){
						for(int i=0;i<recordList.length;i++){
							Record record=recordList[i];
							//先检测这张发票还剩的余额
							double stageSumMoney=BaseHelpUtils.getDoubleValue(record.getAttributeAsInt("stageSumMoney"));
						    if(stageSumMoney>0){
						    	SourceGrid.selectRecord(i);//勾选中
						    }
						}
					}
                    
				}
			});
		}else{
			SourceGrid.clear();
		}
	}
	
	private Integer contractId;
	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
}