package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionDetail;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;

public class SpecialDeductionRecordWithSDetailSpecialDeductionDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
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
	
	public SpecialDeductionRecordWithSDetailSpecialDeductionDetail(){

		allLayout = new HLayout(10);
		allLayout.setHeight100();
		allLayout.setWidth("80%");
		allLayout.setLayoutTopMargin(30);
		allLayout.setLayoutLeftMargin(5);
		allLayout.setLayoutRightMargin(5);
		allLayout.setMembersMargin(10);
		
//		leftLayout = new VLayout(10);
//		leftLayout.setWidth("50%");
//		leftLayout.setHeight100();
//		leftLayout.setOverflow(Overflow.AUTO);
//		allLayout.addMember(leftLayout);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth100();
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
//		a = new EmployeeOnboardViewDetail(processName);
//		leftLayout.addMember(a);
		
		rightLayout.addMember(specialDeductionInformation1);
		rightLayout.addMember(specialDeductionInformation2);
		rightLayout.addMember(specialDeductionInformation3);
		rightLayout.addMember(specialDeductionInformation4);
		rightLayout.addMember(specialDeductionInformation5);
		rightLayout.addMember(specialDeductionInformation6);
		
		addMember(allLayout);
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
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId","专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(1);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("year","扣除年度");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("name","子女姓名");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherDocumentType","身份证件类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber","身份证件号码");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("brithdate","出生日期");
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("nationalityRegion","国籍地区");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("schooling","当前受教育阶段");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("startDate","当前受教育阶段起始时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("endDate","当前受教育阶段结束时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("schoolingTerminationDate","教育终止时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("schoolingRegion","当前就读国家地区");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("school","当前就读学校");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("deductionPercentage","本人扣除比例");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("amount","金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("fileId","fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
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
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId","专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(2); 
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("year","扣除年度");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("educationType", "继续教育类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("educationStage","教育阶段");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("startDate","当前继续教育起始时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("endDate","当前继续教育结束时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("issueDate","发证日期");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("credential","证书名称");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("credentialNumber","证书编号");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("issuingAuthority","发证机关");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("amount","金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("fileId","fileID");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
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
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(3);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("houseBorrower");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("houseType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("houseNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("houseFirst");
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("loanType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("creditorBank");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("creditorContractNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("repaymentFirstDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("repayment");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
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
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(4);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("province");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("city");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("leaseType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("name","出租房姓名（组织名称）");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("leaseAddress");
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("leaseContractNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("startDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("endDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
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
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(5);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("name","被赡养人姓名");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("brithdate");
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("nationalityRegion");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("singleChild");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("allocationWay");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("relationship","关系");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
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
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(6);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("changeType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("name","病患姓名");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		fields[idx].setCanEdit(true);idx++;
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
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
//		reloadDetailTableData();
		viewDetailData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("parentId", getRecord().getAttribute("specialDeductionRecordId"));
		Date d = new Date();
		condition.put("year", d.getYear()+1900);
		condition.put("parentId", getRecord().getAttribute("specialDeductionRecordId"));
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}
	
	public void viewDetailData(){
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		condition = new java.util.HashMap();
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
		
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailSpecialDeductionDetail");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
/*		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailSpecialDeductionDetail");
		return param;*/
		
		Map values = new HashMap();

		List<Map> list =new  ArrayList<>();
		
		Map valuesAsMap1 = new HashMap();
		Map valuesAsMap2 = new HashMap();
		Map valuesAsMap3 = new HashMap();
		Map valuesAsMap4 = new HashMap();
		Map valuesAsMap5 = new HashMap();
		Map valuesAsMap6 = new HashMap();
		
		SC.debugger();
		ListGridRecord[] rows1 = specialDeductionInformation1.getRecords();
		ListGridRecord[] rows2 = specialDeductionInformation2.getRecords();
		ListGridRecord[] rows3 = specialDeductionInformation3.getRecords();
		ListGridRecord[] rows4 = specialDeductionInformation4.getRecords();
		ListGridRecord[] rows5 = specialDeductionInformation5.getRecords();
		ListGridRecord[] rows6 = specialDeductionInformation6.getRecords();
		
		
		if(rows1.length>0) {
			MapUtils.convertRecordToMap(specialDeductionInformation1.getDataSource(), rows1, valuesAsMap1, "specialDeductionInformation1");
		}
		if(rows2.length>0) {
			MapUtils.convertRecordToMap(specialDeductionInformation2.getDataSource(), rows2, valuesAsMap2, "specialDeductionInformation2");
		}
		if(rows3.length>0) {
			MapUtils.convertRecordToMap(specialDeductionInformation3.getDataSource(), rows3, valuesAsMap3, "specialDeductionInformation3");
		}
		if(rows4.length>0) {
			MapUtils.convertRecordToMap(specialDeductionInformation4.getDataSource(), rows4, valuesAsMap4, "specialDeductionInformation4");
		}
		if(rows5.length>0) {
			MapUtils.convertRecordToMap(specialDeductionInformation5.getDataSource(), rows5, valuesAsMap5, "specialDeductionInformation5");
		}
		if(rows6.length>0) {
			MapUtils.convertRecordToMap(specialDeductionInformation5.getDataSource(), rows6, valuesAsMap6, "specialDeductionInformation6");
		}
		
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap1)&&valuesAsMap1.size()>0) {
			List<Map> map1 =(List<Map>) valuesAsMap1.get("specialDeductionInformation1");
			list.addAll(map1);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap2)&&valuesAsMap2.size()>0) {
			List<Map> map2 =(List<Map>) valuesAsMap2.get("specialDeductionInformation2");
			list.addAll(map2);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap3)&&valuesAsMap3.size()>0) {
			List<Map> map3 =(List<Map>) valuesAsMap3.get("specialDeductionInformation3");
			list.addAll(map3);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap4)&&valuesAsMap4.size()>0) {
			List<Map> map4 =(List<Map>) valuesAsMap4.get("specialDeductionInformation4");
			list.addAll(map4);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap5)&&valuesAsMap5.size()>0) {
			List<Map> map5 =(List<Map>) valuesAsMap5.get("specialDeductionInformation5");
			list.addAll(map5);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap6)&&valuesAsMap6.size()>0) {
			List<Map> map6 =(List<Map>) valuesAsMap6.get("specialDeductionInformation6");
			list.addAll(map6);
		}
		values.put("detailSpecialDeductionDetail", list);
		return values;
	
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


}

