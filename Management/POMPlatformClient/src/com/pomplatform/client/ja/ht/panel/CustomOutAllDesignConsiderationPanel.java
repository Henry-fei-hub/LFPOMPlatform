package com.pomplatform.client.ja.ht.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.EditorExitEvent;
import com.smartgwt.client.widgets.form.fields.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomOutAllDesignConsiderationPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	private TextItem favorableTotalItem;

	public CustomOutAllDesignConsiderationPanel(String infoCode, String projectCode, int outQuotationId) {
		CustomOutAllDesignConsiderationPanel.infoCode = infoCode;
		CustomOutAllDesignConsiderationPanel.projectCode = projectCode;
		CustomOutAllDesignConsiderationPanel.outQuotationId = outQuotationId;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setCanEdit(false);
		
		VLayout SearchSourceLayout = new VLayout();
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("outDesignConsiderationId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("businessType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		
		//专项 子项
		fields[idx] = new ListGridField("optionType");
		fields[idx].setShowGridSummary(false);
		SelectItem selectOptionTypeItem = new SelectItem();
		selectOptionTypeItem.setValueMap(KeyValueManager.getValueMap("sys_classifications"));
		fields[idx].setEditorProperties(selectOptionTypeItem);
		idx++;
		fields[idx] = new ListGridField("projectType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("designArea");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("type","类型");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null) return null;  
                try {  
                	if(BaseHelpUtils.getIntValue(value)==1){
                		return "设计面积";
                	}else{
                		return "建筑面积";
                	}
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        }); 
		idx++;
		fields[idx] = new ListGridField("newCreateQuotationName");
		idx++;
		fields[idx] = new ListGridField("designUnitPrice");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("moneySum");
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("interiorPrice");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("interiorMoneySum");
		idx++;
		fields[idx] = new ListGridField("subContractId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("orderNo");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("disableType");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("outQuotationId");
		fields[idx].setHidden(true);
		idx++;

		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setDataSource(DSOutDesignConsideration.getInstance());
		SourceGrid.setShowGridSummary(true);
		//标题从新写
		SourceGrid.setHeaderHeight(60);  
		SourceGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("基本信息", new String[] {"businessType","optionType","mainDesignAreaName","type","newCreateQuotationName"}),
		   new HeaderSpan("合同报价", new String[] {"designArea","designUnitPrice","moneySum"}),
		   new HeaderSpan("内部分配", new String[] {"remark","interiorPrice","interiorMoneySum"}),
	    });
		
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				// 验证数据是否合法
				if (checkData()) {
					final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
					params.put("opt_type", "saveOrUpdateOutDesignConsideration");
					final int rowNumModified=event.getRowNum();
					DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params,
					new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data,
								DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								startEdit();
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								startEdit();
							}
						}
					});
				}
			}
		});
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		totalItem = new TextItem("xxxx","报价单汇总  ");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		favorableTotalItem=new TextItem("最终报价");
		favorableTotalItem.setCanEdit(true);
		favorableTotalItem.setWidth(120);
		favorableTotalItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				
				final Map m = new HashMap<>();
				m.put("outQuotationId", CustomOutAllDesignConsiderationPanel.outQuotationId);
				m.put("moneySum", BaseHelpUtils.getDoubleValue(event.getValue()));
				m.put("opt_type", "setFinalQuotation");
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", m, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() <= 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
				
			}
		});
		__infoForm.setFields(favorableTotalItem);
		
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
		SearchSourceLayout.addMember(__infoForm);
		addMember(SearchSourceLayout);
	}

	@Override
	public void startEdit() {
		__LOGGER.info(
				"CustomOutDesigneConsiderationHandler start load infoCode=" + infoCode + " projectCode=" + projectCode);

		if (!BaseHelpUtils.isNullOrEmpty(infoCode)) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getConsiderationsList");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
					// 设置汇总信息
					Object o=dsResponse.getErrors().get("errorMsg");
					String[] val=BaseHelpUtils.getString(o).split("-");
				    totalItem.setValue(BaseHelpUtils.getString(val[0]).substring(1));
				    String temp=BaseHelpUtils.getString(val[1]);
				    favorableTotalItem.setValue(temp.substring(0,(temp.length()-1)));
				}
			});
		}
	}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutDesignConsideration");
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

	private static String infoCode;
	private static String projectCode;
	private static int outQuotationId;

	public DelicacyListGrid getSourceGrid() {
		return SourceGrid;
	}

	public void setSourceGrid(DelicacyListGrid sourceGrid) {
		SourceGrid = sourceGrid;
	}

}
