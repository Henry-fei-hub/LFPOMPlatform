package com.pomplatform.client.contracticcisiior.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Label;
import com.pomplatform.client.contractreceivablecipor.datasource.DSScontractreceivablecipor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

/**
 * 
 * @ClassName: ContractReceivablePanel 
 * @Description:  合同收款阶段显示面板
 * @author CL
 * @date 2016年11月7日 
 *
 */
public class ContractReceivablePanel extends AbstractWizadPage implements HasHandlers{
	
	public TreeGrid SourceGrid;
	
	public final ComboBoxItem contractIdItem;
	public static Label msgLabel;//合同与发票数据统计信息
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public ContractReceivablePanel(final Integer contractId){
		setBorder(BORDER_STYLE);
		setPadding(5);
		SourceGrid = new TreeGrid();
		int idx = 0;
		TreeGridField [] fields = new TreeGridField[3];
		fields[idx] = new TreeGridField("receivableName");
		idx++ ;
		fields[idx] = new TreeGridField("receivablePercentage");
		idx++ ;
		fields[idx] = new TreeGridField("receivableSumMoney");
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSScontractreceivablecipor.getInstance());
        SourceGrid.setShowOpenIcons(false);
        SourceGrid.setShowDropIcons(false);
        SourceGrid.setShowSelectedStyle(false);
        SourceGrid.setShowPartialSelection(true);
        //当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        SourceGrid.setCascadeSelection(true);
//		setBorder(BORDER_STYLE);
//		setBackgroundColor(BACKGROUND_COLOR);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		msgLabel = new Label("");
		msgLabel.setHeight("30");
		
		contractIdItem = new ComboBoxItem("contractId", "选择合同");
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractIdItem.setWidth("*");
		contractIdItem.setRequired(true);
		if(null != contractId && contractId > 0){
			contractIdItem.setDefaultValue(contractId);
			getContractInfo(contractId);
		}
		contractIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				String __contractId = contractIdItem.getValueAsString();
				int ___contractId = Integer.parseInt(null == __contractId ? "-1" : __contractId);
				setContractId(___contractId);
				getContractInfo(___contractId);
				startEdit();
			}
		});
		
		//设置下拉值
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getContractToInvoice");
		KeyValueManager.setValueMapFromQuery("EP_CustomSinvoiceitiorHandler", MapUtils.toJSON(params), contractIdItem);
		
		__formItems.add(contractIdItem);
		__form.setItems(getFormItemArray());
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight("60");
		__form.setWidth100();
		
		allH.addMember(__form);
		allH.addMember(msgLabel);
//		allH.addMember(SourceGrid);
		
		addMember(allH);
		
	}

	public String customerName;//设置客户名称
	
	private void getContractInfo(int contractId){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getContractInfoByContract");
		params.put("contractId", contractId);
		DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					Record record = dsResponse.getData()[0];
					//设置客户名称
					customerName = record.getAttribute("customerName");
					msgLabel.setText(dsResponse.getErrors().get("errorMsg").toString());
				}
				
			}
		});
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
			params.put("opt_type", "getContractReceivableByContractId");
			DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "getContractReceivableByContractId", params, new DSCallback() {
				
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
		}else{
			SourceGrid.clear();
		}
	}
	
	private Integer contractId;
	
	private String contractName;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
}
