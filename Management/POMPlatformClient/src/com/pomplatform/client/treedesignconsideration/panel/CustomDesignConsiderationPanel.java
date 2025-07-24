package com.pomplatform.client.treedesignconsideration.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.contractreceivablecipor.datasource.DSScontractreceivablecipor;
import com.pomplatform.client.contractreceivables.datasource.DSContractReceivable;
import com.pomplatform.client.designconsiderationinfo.datasource.DSDesignConsiderationInfo;
import com.pomplatform.client.designer.datasource.DSDesignerBaseInfo;
import com.pomplatform.client.ja.ht.datasource.DSDesignConsideration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DragCompleteEvent;
import com.smartgwt.client.widgets.events.DragCompleteHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
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

public class CustomDesignConsiderationPanel extends AbstractWizadPage implements HasHandlers{
	private static Logger __LOGGER = Logger.getLogger("");
	public TreeGrid SourceGrid;
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public CustomDesignConsiderationPanel(final String infoCode,
			final String projectCode,final int outQuotationId){
		
		this.infoCode = infoCode;
		this.projectCode=projectCode;
		this.outQuotationId=outQuotationId;
		setBorder(BORDER_STYLE);
		setPadding(5);
		SourceGrid = new TreeGrid();
		SourceGrid.setCanEdit(false);
		TreeGridField [] fields = new TreeGridField[7];
		int idx = 0;
		fields[idx] = new TreeGridField("businessType");
		fields[idx].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "saveOrUpdateDesignConsideration");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("businessType", event.getNewValue());
				
				//配合专业能修改，装饰专业不能修改
				if(BaseHelpUtils.getIntValue(params,"optionType")==2){
					SC.say("装饰不能修改数据");
					startEdit();
					return;
				}
				
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
			}
		});
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		fields[idx] = new TreeGridField("projectType");
		fields[idx].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "saveOrUpdateDesignConsideration");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("projectType", event.getNewValue());
				
				//配合专业能修改，装饰专业不能修改
				if(BaseHelpUtils.getIntValue(params,"optionType")==2){
					SC.say("装饰不能修改数据");
					startEdit();
					return;
				}
				
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
			}
		});
		SelectItem projectTypeItem = new SelectItem();
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(projectTypeItem);
		
		idx ++;
		fields[idx] = new TreeGridField("mainDesignAreaName");
		fields[idx].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "saveOrUpdateDesignConsideration");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("mainDesignAreaName", event.getNewValue());
				
				//配合专业能修改，装饰专业不能修改
				if(BaseHelpUtils.getIntValue(params,"optionType")==2){
					SC.say("装饰不能修改数据");
					startEdit();
					return;
				}
				
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
			}
		});
		idx ++;
		fields[idx] = new TreeGridField("designArea");
		fields[idx].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "saveOrUpdateDesignConsideration");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("designArea", event.getNewValue());
				
				//配合专业能修改，装饰专业不能修改
				if(BaseHelpUtils.getIntValue(params,"optionType")==2){
					SC.say("装饰不能修改数据");
					startEdit();
					return;
				}
				
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
			}
		});
		idx ++;
		fields[idx] = new TreeGridField("splitPrice");
		fields[idx].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "saveOrUpdateDesignConsideration");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("splitPrice", event.getNewValue());
				
				//配合专业能修改，装饰专业不能修改
				if(BaseHelpUtils.getIntValue(params,"optionType")==2){
					SC.say("装饰不能修改数据");
					startEdit();
					return;
				}
				
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
			}
		});
		idx ++;
		fields[idx] = new TreeGridField("outputValue");
		idx ++;
		fields[idx] = new TreeGridField("remark");
		fields[idx].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "saveOrUpdateDesignConsideration");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("remark", event.getNewValue());
				
				//配合专业能修改，装饰专业不能修改
				if(BaseHelpUtils.getIntValue(params,"optionType")==2){
					SC.say("装饰不能修改数据");
					startEdit();
					return;
				}
				
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
			}
		});
		SourceGrid.setFields(fields);
//		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSDesignConsideration.getInstance());
        SourceGrid.setShowOpenIcons(false);
        SourceGrid.setShowDropIcons(false);
        SourceGrid.setShowSelectedStyle(false);
        SourceGrid.setShowPartialSelection(true);
        SourceGrid.setShowGridSummary(true);
        //当为true时表示父级选中时子级自动选中，当子级选中时父级自动选中
        SourceGrid.setCascadeSelection(true);
        
//        SourceGrid.setShowFilterEditor(true);
//        SourceGrid.setFilterOnKeypress(true);
        
        SourceGrid.addDropCompleteHandler(new DropCompleteHandler() {
			
			@Override
			public void onDropComplete(DropCompleteEvent event) {
				// TODO Auto-generated method stub
				Record[] rs = event.getTransferredRecords();
				DBDataSource.printRecord(rs[0]);
				for (Record r : rs) {
					DBDataSource.callOperation("ST_DesignConsideration", "update", r.toMap(), new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});

        
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
	
	private Integer outQuotationId;
	private String projectCode;
	private String infoCode;
	private BigDecimal projectOutputValue = null;

	public Integer getOutQuotationId() {
		return outQuotationId;
	}

	public void setOutQuotationId(Integer outQuotationId) {
		this.outQuotationId = outQuotationId;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}
}