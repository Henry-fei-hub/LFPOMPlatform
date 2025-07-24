package com.pomplatform.client.projectstageauditinfo.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.attachment.datasource.DSSattachmentmanageaaaor;
import com.pomplatform.client.projectstageauditinfo.datasource.DSProjectStageAuditInfo;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
import com.pomplatform.client.settlement.datasource.DSMprojectppor;
import com.pomplatform.client.sinvoiceitiorcount.datasource.DSSinvoiceitiorcount;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectStageAuditInfoNewForm extends AbstractWizadPage
{
	private static final Logger __logger = Logger.getLogger("");

	private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
	private final TextItem plateIdItem;
	private final TextItem projectManageIdItem;
	private final TextItem currentStageIdItem;
	private final TextItem nextStageIdItem;
	private VLayout mainLayout;
	private HLayout topLayout;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private DelicacyListGrid aliGrid;
	private DelicacyListGrid capGrid;
	private DelicacyListGrid grid;
	private  TextItem attachmentCodeItem;
	private  TextItem attachmentNameItem;
	public ProjectStageAuditInfoNewForm() {
		//DSProjectStageAuditInfo ds = DSProjectStageAuditInfo.getInstance();
		DSMprojectppor ds = DSMprojectppor.getInstance();
		mainLayout=new VLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		contractCodeItem=new TextItem("contractCode","订单编号");
		contractCodeItem.setCanEdit(false);
		contractCodeItem.setDisabled(true);
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);

		projectNameItem=new TextItem("projectName","订单名称");
		projectNameItem.setCanEdit(false);
		projectNameItem.setDisabled(true);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);

		plateIdItem=new TextItem("plateId","业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setCanEdit(false);
		plateIdItem.setDisabled(true);
		plateIdItem.setWidth("*");
		__formItems.add(plateIdItem);

		projectManageIdItem=new TextItem("projectManageId","专业负责人");
		projectManageIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		projectManageIdItem.setCanEdit(false);
		projectManageIdItem.setDisabled(true);
		projectManageIdItem.setWidth("*");
		__formItems.add(projectManageIdItem);

		currentStageIdItem=new TextItem("currentStageId","当前阶段");
		currentStageIdItem.setCanEdit(false);
		currentStageIdItem.setDisabled(true);
		currentStageIdItem.setValueMap((LinkedHashMap) ds.getField("stageId").getValueMap());
		currentStageIdItem.setWidth("*");
		__formItems.add(currentStageIdItem);

		nextStageIdItem=new TextItem("nextStageId","下个阶段");
		nextStageIdItem.setCanEdit(false);
		nextStageIdItem.setDisabled(true);
		nextStageIdItem.setValueMap((LinkedHashMap) ds.getField("stageId").getValueMap());
		nextStageIdItem.setWidth("*");
		__formItems.add(nextStageIdItem);

		attachmentCodeItem=new TextItem("attachmentCode","绑定的确认函编码");
		attachmentCodeItem.setWidth("*");
		attachmentCodeItem.setDisabled(true);
		attachmentCodeItem.setCanEdit(false);
		__formItems.add(attachmentCodeItem);

		attachmentNameItem=new TextItem("attachmentName","绑定的确认函名称");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setDisabled(true);
		attachmentNameItem.setCanEdit(false);
		__formItems.add(attachmentNameItem);

		__form.setItems(getFormItemArray());
		__form.setHeight("50%");
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);

		topLayout=new HLayout(20);
		topLayout.setMargin(10);
		topLayout.setWidth("100%");
		topLayout.setHeight100();
		mainLayout.addMember(topLayout);
		addMember(mainLayout);
		
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null);
		Record record=getRecord();
		@SuppressWarnings("unchecked")
		Map<String,Object> params=record.getAttributeAsMap("info");
		int contractId=BaseHelpUtils.getIntValue(params.get("contractId"));
		int attachmentManageId=BaseHelpUtils.getIntValue(params.get("attachmentManageId"));
		int stageId=BaseHelpUtils.getIntValue(params.get("stageId"));
		int projectId=BaseHelpUtils.getIntValue(params.get("projectId"));
		currentStageIdItem.setValue(stageId);
		aliGrid = new DelicacyListGrid();
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("invoiceAmount","开票金额");
		fields[idx].setCanEdit(false);
		fields[idx].setAlign(Alignment.RIGHT);
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx].setFormat("##,###,###,###,##0.00");
		idx ++;
		fields[idx] = new ListGridField("taxRate","税率(%)");
		fields[idx].setCanEdit(false);
		fields[idx].setAlign(Alignment.RIGHT);
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx].setFormat("##,###,###,###,##0.00");
		idx ++;
		fields[idx] = new ListGridField("noTaxAmount","不含税金额");
		fields[idx].setCanEdit(false);
		fields[idx].setAlign(Alignment.RIGHT);
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx].setFormat("##,###,###,###,##0.00");
		idx ++;
		fields[idx] = new ListGridField("invoiceDate","开票日期");
		fields[idx].setCanEdit(false);
		fields[idx].setAlign(Alignment.RIGHT);
		idx ++;
		fields[idx] = new ListGridField("sign","发票状态");
		fields[idx].setAlign(Alignment.RIGHT);
		KeyValueManager.loadValueMap("system_dictionary_53", fields[idx]);
		fields[idx].setCanEdit(false);
		aliGrid.setDataSource(DSSinvoiceitiorcount.getInstance());
		aliGrid.setFields(fields);
		aliGrid.setAutoFitFieldWidths(false);
		aliGrid.setCanEdit(false);
		aliGrid.setSelectionType(SelectionStyle.SINGLE);
		aliGrid.setHeight100();
		aliGrid.setWidth("20%");
		aliGrid.setHeaderHeight(60);
		aliGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"确认函发票", new String[] {"invoiceAmount","taxRate","noTaxAmount","invoiceDate","sign"}));
		topLayout.addMember(aliGrid);

		capGrid= new DelicacyListGrid();
		ListGridField[] field = new ListGridField[5];
		int id = 0;
		field[id] = new ListGridField("borrowMoney","借(增加)");
		field[id].setCanEdit(false);
		field[id].setAlign(Alignment.RIGHT);
		field[id].setType(ListGridFieldType.FLOAT);
		field[id].setFormat("##,###,###,###,##0.00");
		id ++;
		field[id] = new ListGridField("exchangeRate","汇率");
		field[id].setCanEdit(false);
		field[id].setAlign(Alignment.RIGHT);
		field[id].setType(ListGridFieldType.FLOAT);
		field[id].setFormat("##,###,###,###,##0.00");
		id ++;
		field[id] = new ListGridField("originalCurrency","原币金额");
		field[id].setCanEdit(false);
		field[id].setAlign(Alignment.RIGHT);
		field[id].setType(ListGridFieldType.FLOAT);
		field[id].setFormat("##,###,###,###,##0.00");
		id ++;
		field[id] = new ListGridField("happenDate","发生日期");
		field[id].setAlign(Alignment.CENTER);
		field[id].setCanEdit(false);
		id ++;
		field[id] = new ListGridField("remark","备注");
		field[id].setAlign(Alignment.CENTER);
		field[id].setCanEdit(false);
		field[id].setAutoFitWidth(true);
		capGrid.setDataSource(DSMcapitalecoosmeor.getInstance());
		capGrid.setFields(field);
		capGrid.setAutoFitFieldWidths(false);
		capGrid.setCanEdit(false);
		capGrid.setSelectionType(SelectionStyle.SINGLE);
		capGrid.setHeight100();
		capGrid.setWidth("20%");
		capGrid.setHeaderHeight(60);
		capGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"确认函回款", new String[] {"borrowMoney","exchangeRate","originalCurrency","happenDate","remark"}));
		topLayout.addMember(capGrid);
		
		grid = new DelicacyListGrid(){
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				int attachmentManageIds=BaseHelpUtils.getIntValue(record.getAttribute("attachmentManageId"));
				if(attachmentManageIds==attachmentManageId) {
					return "color: red;";
				}
				else {
					return null;
				}
			}
		};
		ListGridField[] fieldss = new ListGridField[4];
		int idxs = 0;
		fieldss[idxs] = new ListGridField("attachmentManageId");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setHidden(true);
		idxs ++;
		fieldss[idxs] = new ListGridField("attachmentCode");
		fieldss[idxs].setAlign(Alignment.RIGHT);
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setHidden(true);
		idxs ++;
		fieldss[idxs] = new ListGridField("attachmentName","确认函名称");
		fieldss[idxs].setAlign(Alignment.CENTER);
		fieldss[idxs].setWidth("30%");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("attachmentAddress","浏览");
		fieldss[idxs].setAlign(Alignment.CENTER);
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("20%");
		fieldss[idxs].setLinkText("确认函下载/预览");
		idxs ++;
		fieldss[idxs] = new ListGridField("amount");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setAlign(Alignment.RIGHT);
		fieldss[idxs].setType(ListGridFieldType.FLOAT);
		fieldss[idxs].setFormat("##,###,###,###,##0.00");
		idxs ++;
		fieldss[idxs] = new ListGridField("returnAmount");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setAlign(Alignment.RIGHT);
		fieldss[idxs].setType(ListGridFieldType.FLOAT);
		fieldss[idxs].setFormat("##,###,###,###,##0.00");
		idxs ++;
		fieldss[idxs] = new ListGridField("recordDate");
		fieldss[idxs].setAlign(Alignment.CENTER);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("projectManageId");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setAlign(Alignment.CENTER);
		idxs ++;
		fieldss[idxs] = new ListGridField("paymentGradeDescription");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setAutoFitWidth(true);
		grid.setDataSource(DSSattachmentmanageaaaor.getInstance());
		grid.setFields(fieldss);
		grid.setAutoFitFieldWidths(false);
		grid.setCanEdit(false);
		grid.setSelectionType(SelectionStyle.SINGLE);
		grid.setHeight100();
		grid.setHeaderHeight(60);
		grid.setWidth("35%");
		grid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"合同下的确认函", new String[] {"attachmentManageId","attachmentCode","attachmentName","attachmentAddress","amount","returnAmount","recordDate","projectManageId","paymentGradeDescription"}));
		topLayout.addMember(grid);
		Map<String,Object> param=new HashMap<>();
		param.put("contractId",contractId);
		param.put("attachmentManageId", attachmentManageId);
		param.put("projectId", projectId);
		param.put("stageId", stageId);
		DBDataSource.callOperation("ST_AttachmentManage", "find", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					for (Record record : records) {
						attachmentCodeItem.setValue(record.getAttribute("attachmentCode"));
						attachmentNameItem.setValue(record.getAttribute("attachmentName"));
					}
				}
			}
		});
		params.put("optType", "lodaData");
		DBDataSource.callOperation("EP_AboutProjectStageAudit",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					@SuppressWarnings("unchecked")
					Map<String,Object> userDataMap = BaseHelpUtils.getResponseUserData(dsResponse);
					Object nextStageId=userDataMap.get("nextStageId");	
					String contractCode=BaseHelpUtils.getString(userDataMap.get("contractCode"));
					String projectName=BaseHelpUtils.getString(userDataMap.get("projectName"));
					int plateId=BaseHelpUtils.getIntValue(userDataMap.get("plateId"));
					int projectManageId=BaseHelpUtils.getIntValue(userDataMap.get("projectManageId"));	
					nextStageIdItem.setValue(nextStageId);
					contractCodeItem.setValue(contractCode);
					projectNameItem.setValue(projectName);
					plateIdItem.setValue(plateId);
					projectManageIdItem.setValue(projectManageId);
				}
			}
		});

		DBDataSource.callOperation("NQ_StageInvoiceAttachment", param, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					aliGrid.setData(dsResponse.getData());
				}
			}
		});

		DBDataSource.callOperation("ST_Capital", "find",param, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					capGrid.setData(dsResponse.getData());
				}
			}
		});
		
		Map<String,Object> map=new HashMap<>();
		map.put("contractId", contractId);
		DBDataSource.callOperation("NQ_Sattachmentmanageaaaor",  map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					grid.setData(records);
				}
			}
		});

	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectStageAuditInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> map=getRecord().getAttributeAsMap("info");
		map.put("departmentId", ClientUtil.getDepartmentId());
		map.put("employeeNo", ClientUtil.getUserNo());
		map.put("drafter", ClientUtil.getUserId());
		return map;
	}


}
