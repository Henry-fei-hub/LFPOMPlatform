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
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.ja.ht.datasource.DSOutRedesignConsideration;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomOutRedesignConsiderationPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm ;
	private TextItem totalItem ;
	
	public CustomOutRedesignConsiderationPanel(String infoCode,String projectCode,int outQuotationId,double moneySum,int type) {
		this.infoCode=infoCode;
		this.projectCode=projectCode;
		this.outQuotationId=outQuotationId;
		CustomOutRedesignConsiderationPanel.moneySum=moneySum;
		CustomOutRedesignConsiderationPanel.outQuotationId_STATIC=outQuotationId;
		SourceGrid = new DelicacyListGrid();
		if(type>0){
			SourceGrid.setCanEdit(true);
		}
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("businessType");
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		fields[idx] = new ListGridField("projectType");
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		idx ++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		idx ++;
		fields[idx] = new ListGridField("decorationStatus");
		SelectItem selectDecorationStatusItem = new SelectItem();
		selectDecorationStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_30"));
		fields[idx].setEditorProperties(selectDecorationStatusItem);
		idx ++;
		fields[idx] = new ListGridField("designArea");
		idx ++;
		fields[idx] = new ListGridField("designUnitPrice");
		idx ++;
		fields[idx] = new ListGridField("moneySum");
		idx ++;
		 
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setDataSource(DSOutRedesignConsideration.getInstance());
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				//验证数据是否合法
				if(checkData()){
					final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
					params.put("opt_type", "saveOrUpdateOutRedesignConsideration");
					params.put("outQuotationId", CustomOutRedesignConsiderationPanel.outQuotationId_STATIC);
					
					Map params__ = SourceGrid.getRecord(event.getRowNum()).toMap();
					final int rowNumModified = event.getRowNum();
					//判断保单的总价是不是被超过了
					//当设计面积designArea__，设计单价designUnitPrice__ 不为空的时候 总价
					double designArea__=BaseHelpUtils.getDoubleValue(params.get("designArea")),
						   designUnitPrice__=BaseHelpUtils.getDoubleValue(params.get("designUnitPrice"));
					double moneySum__=BaseHelpUtils.getDoubleValue(params.get("moneySum"));
					if(BaseHelpUtils.getDoubleValue(designArea__)>0&&BaseHelpUtils.getDoubleValue(designUnitPrice__)>0){
						moneySum__=designArea__*designUnitPrice__;
					}
					double withTheAmount__=BaseHelpUtils.getDoubleValue(params.get("withTheAmount"));
					double onSiteTotalMoney__=BaseHelpUtils.getDoubleValue(params.get("onSiteTotalMoney"));
					double sumCount=moneySum__+withTheAmount__+onSiteTotalMoney__;
					params__.put("opt_type", "checkSumMoney");
					params__.put("sumMoney__", CustomOutRedesignConsiderationPanel.moneySum);//报价单总价
					params__.put("nowMoney", sumCount);//当前追加的金额
					
					
					DBDataSource.callOperation("EP_CustomOutRedesigneConsiderationHandler", params__, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								DBDataSource.callOperation("EP_CustomOutRedesigneConsiderationHandler", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											startEdit();
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											startEdit();
//											DBDataSource.copyRecord(dsResponse.getData()[0], SourceGrid.getRecord(rowNumModified));
//											SourceGrid.redraw();
										}
									}
								});
							}
						}
					});
				}
			}
		});
		__infoForm = new DynamicForm();
        __infoForm.setWidth100();
        __infoForm.setHeight("16%");
        __infoForm.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
        totalItem = new TextItem("报价单汇总  ");
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
		__LOGGER.info("CustomOutRedesigneConsiderationHandler start load infoCode="+infoCode+" projectCode="+projectCode);
		
		if (!BaseHelpUtils.isNullOrEmpty(infoCode)&& BaseHelpUtils.getIntValue(outQuotationId)>0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getOutRedesignConsideration");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
			condition.put("moneySum", CustomOutRedesignConsiderationPanel.moneySum);
			DBDataSource.callOperation("EP_CustomOutRedesigneConsiderationHandler", "", condition, new DSCallback() {
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
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutDesignConsideration");
		return res;
	}

//	@Override
//	public Map getValuesAsMap() {
//		Map param = new HashMap();
//		ListGridRecord[] selected = SourceGrid.getSelectedRecords();
//		List resList = new ArrayList();
//		for (ListGridRecord r : selected) {
//			Map lm = new HashMap();
//			lm.put("roleId", r.getAttribute("roleId"));
//			lm.put("departmentId", r.getAttribute("departmentId"));
//			resList.add(lm);
//		}
//		param.put("detailEmployeeRole", resList);
//		return param;
//	}

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
	private static double moneySum;
	private static int outQuotationId_STATIC;

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
