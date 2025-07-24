package com.pomplatform.client.specialdeduction.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.specialdeduction.datasource.DSSpecialDeductionRecordsAuditOfWorkflow;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation2;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation3;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation4;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation5;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation6;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeEducationInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeFamilyInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeRewardExperience;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeTechnicalTitle;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeWorkExperience;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeEducationInformationViewer;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeFamilyInformationViewer;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeOnboardViewDetail;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeRewardExperienceViewer;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeTechnicalTitleViewer;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeWorkExperienceViewer;

public class SpecialDeductionRecordsAuditOfWorkflowViewer extends AbstractDetailViewer
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private SearchForm __parentSearchForm;
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

	public SpecialDeductionRecordsAuditOfWorkflowViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		leftLayout = new VLayout(10);
		leftLayout.setWidth("50%");
		leftLayout.setHeight100();
		leftLayout.setOverflow(Overflow.AUTO);
		allLayout.addMember(leftLayout);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
//		a = new EmployeeOnboardViewDetail(processName);
//		leftLayout.addMember(a);
		
		leftLayout.addMember(specialDeductionInformation1);
		leftLayout.addMember(specialDeductionInformation2);
		leftLayout.addMember(specialDeductionInformation3);
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
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId","专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(1);
		idx++;
		fields[idx] = new ListGridField("year","扣除年度");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("name","子女姓名");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherDocumentType","身份证件类型");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber","身份证件号码");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("brithdate","出生日期");
		idx++;
		fields[idx] = new ListGridField("nationalityRegion","国籍地区");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("schooling","当前受教育阶段");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("startDate","当前受教育阶段起始时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("endDate","当前受教育阶段结束时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("schoolingTerminationDate","教育终止时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("schoolingRegion","当前就读国家地区");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("school","当前就读学校");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("deductionPercentage","本人扣除比例");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount","金额");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId","fileId");
		fields[idx].setHidden(true);
		idx++;
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
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId","专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(2); 
		idx++;
		fields[idx] = new ListGridField("year","扣除年度");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("educationType", "继续教育类型");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("educationStage","教育阶段");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("startDate","当前继续教育起始时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("endDate","当前继续教育结束时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("issueDate","发证日期");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("credential","证书名称");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("credentialNumber","证书编号");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("issuingAuthority","发证机关");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount","金额");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId","fileID");
		fields[idx].setHidden(true);
		idx++;
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
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(3);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseBorrower");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("houseFirst");
		idx++;
		fields[idx] = new ListGridField("loanType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("creditorBank");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("creditorContractNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("repaymentFirstDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("repayment");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
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
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(4);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("province");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("city");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("leaseType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("name");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("leaseAddress");
		idx++;
		fields[idx] = new ListGridField("leaseContractNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("startDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("endDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("fileUrl");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation4.setFields(fields);
		
		specialDeductionInformation5.setHeaderHeight(60); 
		specialDeductionInformation5.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation5.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("赡养老人信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","year","singleChild",
				   "allocationWay","allocationAmount","name","otherDocumentType","otherIdentificationNumber",
				   "brithdate","nationalityRegion","relationship","fileId","fileUrl"})
	    });
		fields = new ListGridField[18];
		 idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(5);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("name","父母姓名");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("brithdate");
		idx++;
		fields[idx] = new ListGridField("nationalityRegion");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("singleChild");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("allocationWay");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("allocationAmount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("relationship","关系");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
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
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(6);
		idx++;
		fields[idx] = new ListGridField("changeType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("name");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherDocumentType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherIdentificationNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("fileUrl");
		fields[idx].setShowGridSummary(false);
		specialDeductionInformation6.setFields(fields);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "专项申请详情";
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
		params.put("processPooledTaskId", getBusinessId());
		DBDataSource.callOperation("NQ_SpecialDeductionRecordsAuditOfWorkflow", "find", new DSCallback() {
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
		SC.debugger();
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		condition = new java.util.HashMap();
		Integer attributeAsInt = selected.getAttributeAsInt("specialDeductionRecordId");
		condition.put("parentId", selected.getAttributeAsInt("specialDeductionRecordId"));
//		condition.put("year", selected.getAttributeAsInt("year"));
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
	public DataSource getMainDataSource() {
		return DSSpecialDeductionRecordsAuditOfWorkflow.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 0;
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
		res.add("子女教育");
		res.add("继续教育");
		res.add("住房贷款利息");
		res.add("住房租金");
		res.add("赡养老人");
		res.add("大病医疗");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

