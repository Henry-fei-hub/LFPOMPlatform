package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionRecordWithS;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionDetail;

public class SpecialDeductionRecordWithSViewer2 extends AbstractDetailViewer
{


	private final DelicacyListGrid specialDeductionDetailsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private VLayout contactLayout;
	private VLayout gridLayout;
	private DelicacyListGrid specialDeductionInformation1 =new DelicacyListGrid();
	private DelicacyListGrid specialDeductionInformation2=new DelicacyListGrid();
	private DelicacyListGrid specialDeductionInformation3=new DelicacyListGrid();
	private DelicacyListGrid specialDeductionInformation4=new DelicacyListGrid();
	private DelicacyListGrid specialDeductionInformation5=new DelicacyListGrid();
	private DelicacyListGrid specialDeductionInformation6=new DelicacyListGrid();
	

	public SpecialDeductionRecordWithSViewer2() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
	/*	allLayout = new HLayout(10);
		allLayout.setHeight100();
		allLayout.setWidth("80%");
		allLayout.setLayoutTopMargin(30);
		allLayout.setLayoutLeftMargin(5);
		allLayout.setLayoutRightMargin(5);
		allLayout.setMembersMargin(10);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth100();
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
		
		rightLayout.addMember(specialDeductionInformation1);
		rightLayout.addMember(specialDeductionInformation2);
		rightLayout.addMember(specialDeductionInformation3);
		rightLayout.addMember(specialDeductionInformation4);
		rightLayout.addMember(specialDeductionInformation5);
		rightLayout.addMember(specialDeductionInformation6);
		
		addMember(allLayout);*/
		
		specialDeductionInformation1.setHeaderHeight(60); 
		specialDeductionInformation1.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation1.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("子女教育信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year","name","otherDocumentType","otherIdentificationNumber",
				   "brithdate","nationalityRegion","schooling","startDate"
				   ,"endDate","schoolingTerminationDate","school","schoolingRegion","deductionPercentage","amount","fileId","fileUrl"})
	    });
		ListGridField[] fields = new ListGridField[18];
		int idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId","专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(1);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("year","扣除年度");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("name","子女姓名");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherDocumentType","身份证件类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber","身份证件号码");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("brithdate","出生日期");
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("nationalityRegion","国籍地区");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("schooling","当前受教育阶段");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("startDate","当前受教育阶段起始时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("endDate","当前受教育阶段结束时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("schoolingTerminationDate","教育终止时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("schoolingRegion","当前就读国家地区");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("school","当前就读学校");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("deductionPercentage","本人扣除比例");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("amount","金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileId","fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileUrl","附件url");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation1.setFields(fields);

		
		specialDeductionInformation2.setHeaderHeight(60); 
		specialDeductionInformation2.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation2.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("继续教育信息", 
				   new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId",
				   "year","educationType","educationStage","startDate",
				   "endDate","issueDate","credential","credentialNumber"
				   ,"issuingAuthority","amount","fileId","fileUrl"})
	    });
		
		fields = new ListGridField[18];
		idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId","专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(2); 
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("year","扣除年度");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("educationType", "继续教育类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("educationStage","教育阶段");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("startDate","当前继续教育起始时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("endDate","当前继续教育结束时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("issueDate","发证日期");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("credential","证书名称");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("credentialNumber","证书编号");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("issuingAuthority","发证机关");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("amount","金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileId","fileID");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileUrl","附件Url");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation2.setFields(fields);
		
		specialDeductionInformation3.setHeaderHeight(60); 
		specialDeductionInformation3.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation3.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("住房贷款信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year",
				   "houseBorrower","houseType","houseNumber",
				   "houseFirst","loanType","creditorBank","creditorContractNumber"
				   ,"repaymentFirstDate","repayment","amount","fileId","fileUrl"})
	    });
		fields = new ListGridField[18];
		idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(3);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("houseBorrower");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("houseType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("houseNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("houseFirst");
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("loanType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("creditorBank");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("creditorContractNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("repaymentFirstDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("repayment");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileUrl");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation3.setFields(fields);
		
		specialDeductionInformation4.setHeaderHeight(60); 
		specialDeductionInformation4.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation4.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("住房租金信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year",
				   "province","city","leaseType","name","otherDocumentType","otherIdentificationNumber","leaseAddress",
				   "leaseContractNumber","startDate"
				   ,"endDate","amount","fileId","fileUrl"})
	    });
		fields = new ListGridField[18];
		idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(4);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("province");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("city");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("leaseType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("name","出租房姓名（组织名称）");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("leaseAddress");
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("leaseContractNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("startDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("endDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileUrl");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation4.setFields(fields);
		
		specialDeductionInformation5.setHeaderHeight(60); 
		specialDeductionInformation5.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation5.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("赡养老人信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year","singleChild",
				   "allocationWay","amount","name","otherDocumentType","otherIdentificationNumber",
				   "brithdate","nationalityRegion","relationship","fileId","fileUrl"})
	    });
		fields = new ListGridField[18];
		 idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(5);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("name","被赡养人姓名");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("brithdate");
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("nationalityRegion");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("singleChild");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("allocationWay");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("relationship","关系");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileUrl","附件");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation5.setFields(fields);
		
		specialDeductionInformation6.setHeaderHeight(60); 
		specialDeductionInformation6.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation6.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("大病医疗信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year",
				   "name","otherDocumentType","otherIdentificationNumber","changeType",
				   "amount","fileId","fileUrl"})
	    });
		 fields = new ListGridField[18];
		 idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(6);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("changeType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("name","病患姓名");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(false);idx++;
		fields[idx] = new ListGridField("fileUrl");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation6.setFields(fields);
	
//		IButton specialDeductionDetailsNewButton = new IButton("新增");
//		specialDeductionDetailsNewButton.addClickHandler( new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				grid.startEditingNew();
//			}
//		});
//		IButton specialDeductionDetailsRemoveButton = new IButton("删除所有");
//		specialDeductionDetailsRemoveButton.addClickHandler( new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				grid.setData(new RecordList());
//			}
//		});
//		allLayout.addMember(specialDeductionDetailsNewButton);
//		allLayout.addMember(specialDeductionDetailsRemoveButton);
//			specialDeductionDetailsGrid.addDoubleClickHandler(new DoubleClickHandler(){
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("");
//				detail.setWidth(700); 
//				detail.setHeight(500); 
//				SpecialDeductionDetailViewer viewer = new SpecialDeductionDetailViewer();
//				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
//				viewer.initComponents();
//				viewer.viewSelectedData((ListGrid)event.getSource());
//				detail.setContent(viewer);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "SpecialDeductionInformation";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("specialDeductionRecordId", getBusinessId());
		DBDataSource.callOperation("NQ_SpecialDeductionRecordWithS", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){

		Record selected = getRecord();
		Object val;
		Map condition = null;
		condition = new HashMap();
		Integer attributeAsInt = selected.getAttributeAsInt("specialDeductionRecordId");
		condition.put("parentId", selected.getAttributeAsInt("specialDeductionRecordId"));
		condition.put("year", selected.getAttributeAsInt("year"));
		condition.put("specialDeductionTypeId", 1);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation1.setData(dsResponse.getData());
				}
			}
		});
		condition.put("specialDeductionTypeId", 2);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation2.setData(dsResponse.getData());
				}
			}
		});
		condition.put("specialDeductionTypeId", 3);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation3.setData(dsResponse.getData());
				}
			}
		});
		condition.put("specialDeductionTypeId", 4);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation4.setData(dsResponse.getData());
				}
			}
		});
		condition.put("specialDeductionTypeId", 5);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation5.setData(dsResponse.getData());
				}
			}
		});
		condition.put("specialDeductionTypeId", 6);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation6.setData(dsResponse.getData());
				}
			}
		});
		
	
		/*Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("parentId", selected.getAttributeAsString("specialDeductionRecordId"));
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionDetailsGrid.setData(dsResponse.getData());
				}
			}
		});*/
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSpecialDeductionRecordWithS.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 6;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(specialDeductionInformation1);
		res.add(specialDeductionInformation2);
		res.add(specialDeductionInformation3);
		res.add(specialDeductionInformation4);
		res.add(specialDeductionInformation5);
		res.add(specialDeductionInformation6);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("");
		res.add("");
		res.add("");
		res.add("");
		res.add("");
		res.add("");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

