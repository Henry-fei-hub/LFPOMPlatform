package com.pomplatform.client.ja.ht.panel;

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
import com.pomplatform.client.ja.ht.datasource.DSDesignConsideration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomDesignConsiderationPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm ;
	private TextItem totalItem ;

	public CustomDesignConsiderationPanel(String infoCode,String projectCode,int outQuotationId) {
		this.infoCode=infoCode;
		this.projectCode=projectCode;
		this.outQuotationId=outQuotationId;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setCanEdit(true);
		
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("designConsiderationId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("businessType");
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		
		//专项 子项
		fields[idx] = new ListGridField("optionType");
		SelectItem selectOptionTypeItem = new SelectItem();
		selectOptionTypeItem.setValueMap(KeyValueManager.getValueMap("sys_classifications"));
		fields[idx].setEditorProperties(selectOptionTypeItem);
		idx++;
		fields[idx] = new ListGridField("projectType");
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("decorationStatus");
		SelectItem selectDecorationStatusItem = new SelectItem();
		selectDecorationStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_30"));
		fields[idx].setEditorProperties(selectDecorationStatusItem);
		idx ++;
		fields[idx] = new ListGridField("designArea");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("designUnitPrice").getValue())){
						double designUnitPrice = BaseHelpUtils.getDoubleValue(df.getField("designUnitPrice").getValue());
						df.getField("moneySum").setValue(BaseHelpUtils.get2Double(thisVal * designUnitPrice));
					}else if(!BaseHelpUtils.isNullOrEmpty(df.getField("moneySum").getValue())){
						double moneySum = BaseHelpUtils.getDoubleValue(df.getField("moneySum").getValue());
						df.getField("designUnitPrice").setValue(BaseHelpUtils.get2Double(moneySum/thisVal));
					}
				}
				
			}
		});
		idx++;
		fields[idx] = new ListGridField("designUnitPrice");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("designArea").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						df.getField("moneySum").setValue(BaseHelpUtils.get2Double(thisVal * designArea));
					}
				}
				
			}
		});
		idx++;
		fields[idx] = new ListGridField("moneySum");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("moneySum").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						df.getField("designUnitPrice").setValue(BaseHelpUtils.get2Double(thisVal * designArea));
					}
				}
				
			}
		});
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("interiorPrice");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("designArea").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						df.getField("interiorMoneySum").setValue(BaseHelpUtils.get2Double(thisVal * designArea));
					}
				}
				
			}
		});
		idx++;
		fields[idx] = new ListGridField("interiorMoneySum");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("designArea").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						df.getField("interiorPrice").setValue(BaseHelpUtils.get2Double(thisVal * designArea));
					}
				}
				
			}
		});
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
		fields[idx] = new ListGridField("splitPrice");
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setDataSource(DSDesignConsideration.getInstance());
		//标题从新写
		SourceGrid.setHeaderHeight(60);  
		SourceGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("基本信息", new String[] {"businessType","optionType","mainDesignAreaName","projectType","decorationStatus"}),
		   new HeaderSpan("合同报价", new String[] {"designArea","designUnitPrice","moneySum"}),
		   new HeaderSpan("内部分配", new String[] {"remark","interiorPrice","interiorMoneySum"}),
	    });
		
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				if(checkData()){
					final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
					
					__LOGGER.info("params="+params);
					
					params.put("opt_type", "saveOrUpdateDesignConsideration");
					params.put("employeeId", ClientUtil.getEmployeeId());
					int type=BaseHelpUtils.getIntValue(params, "jobMix");
					if(type==2){
						startEdit();
						SC.say("合计项不能操作");
					}else if(type==3){//最终报价单项
						final Map m = SourceGrid.getRecord(event.getRowNum()).toMap();
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
					}else{
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
					
				}
			}
		});
		__infoForm = new DynamicForm();
        __infoForm.setWidth100();
        __infoForm.setHeight("16%");
        __infoForm.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
        totalItem = new TextItem("拆分价汇总  ");
        totalItem.setCanEdit(false);
        totalItem.setWidth("*");
        
        __infoForm.setFields(totalItem);
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
		if (!BaseHelpUtils.isNullOrEmpty(infoCode)) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getDesignConsiderationList");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
			DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
					//设置汇总信息
					totalItem.setValue(dsResponse.getErrors().get("errorMsg"));
				}
			});
		}
	}

	//效验数据
		@Override
		public boolean checkData() {
			boolean isFlag=true;
			for (ListGridRecord r : SourceGrid.getSelectedRecords()) {
				__LOGGER.info(MapUtils.convertRecordToMap(SourceGrid.getDataSource(), r).toString());
				Map<String,Object> checkMap=MapUtils.convertRecordToMap(SourceGrid.getDataSource(), r);
				//判断当前需不需要数据效验
				int type=0;
				type=BaseHelpUtils.getIntValue(checkMap, "jobMix");
				if(type==1){
					//业务类型
					//项目类别
					//这2不能为空
					int businessType=0,projectType=0;
					businessType=BaseHelpUtils.getIntValue(checkMap, "businessType");
					projectType=BaseHelpUtils.getIntValue(checkMap, "projectType");
					if(businessType<=0){
						SC.say("业务类型必填");
						isFlag=false;
					}if(projectType<=0){
						SC.say("项目类别必填");
						isFlag=false;
					}
				}
			}
			return isFlag;
		}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customDesignConsideration");
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
