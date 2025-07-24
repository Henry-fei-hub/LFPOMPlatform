package com.pomplatform.client.specialdeduction.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.layout.HLayout;

import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.specialdeduction.datasource.DSMspecialdeductionrecordsor;
import com.pomplatform.client.specialdeduction.form.MspecialdeductionrecordsorSearchForm;
import com.pomplatform.client.specialdeduction.form.MspecialdeductionrecordsorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MspecialdeductionrecordsorPanel extends AbstractSearchPanel
{

	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MspecialdeductionrecordsorPanel cm = new MspecialdeductionrecordsorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mspecialdeductionrecordsor";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setShowGridSummary(true);
		
		ListGridField processStatus = new ListGridField("processStatus", 80);  
		processStatus.setFrozen(true); 
		processStatus.setShowGridSummary(false);
		ListGridField employeId = new ListGridField("employeId", 80);  
		employeId.setFrozen(true);  
		employeId.setShowGridSummary(false);
		ListGridField companyId = new ListGridField("companyId", 150);  
		companyId.setShowGridSummary(false);
		ListGridField plateId = new ListGridField("plateId", 150);  
		plateId.setShowGridSummary(false);
		ListGridField documentType = new ListGridField("documentType", 150);  
		documentType.setShowGridSummary(false);
		ListGridField identificationNumber = new ListGridField("identificationNumber", 150);  
		identificationNumber.setShowGridSummary(false);
		ListGridField phone = new ListGridField("phone", 150);  
		ListGridField taxpayerRegistrationNumber = new ListGridField("taxpayerRegistrationNumber", 150);  
		ListGridField address = new ListGridField("address", 150);  
		ListGridField email = new ListGridField("email", 150);  
		ListGridField withholdName = new ListGridField("withholdName", 150);  
		ListGridField withholdRegistrationNumber = new ListGridField("withholdRegistrationNumber", 150);  
		ListGridField spouseSituation = new ListGridField("spouseSituation", 150);  
		spouseSituation.setShowGridSummary(false);
		ListGridField spouseName = new ListGridField("spouseName", 150);  
		ListGridField spouseDocumentType = new ListGridField("spouseDocumentType", 150); 
		spouseDocumentType.setShowGridSummary(false);
		ListGridField spouseIdentificationNumber = new ListGridField("spouseIdentificationNumber", 150);  
        ListGridField specialDeductionTypeId = new ListGridField("specialDeductionTypeId", 80);  
        specialDeductionTypeId.setFrozen(true);  
        specialDeductionTypeId.setShowGridSummary(false);
        ListGridField year = new ListGridField("year", 80);  
        year.setFrozen(true);  
        year.setShowGridSummary(false);
        ListGridField name = new ListGridField("name", 150);  
        ListGridField otherDocumentType = new ListGridField("otherDocumentType", 150);  
        otherDocumentType.setShowGridSummary(false);
        ListGridField otherIdentificationNumber = new ListGridField("otherIdentificationNumber", 150);  
        ListGridField brithdate = new ListGridField("brithdate", 150);  
        ListGridField nationalityRegion = new ListGridField("nationalityRegion", 150);  
        ListGridField schooling = new ListGridField("schooling", 150);  
        schooling.setShowGridSummary(false);
        ListGridField startDate = new ListGridField("startDate", 150);  
        ListGridField endDate = new ListGridField("endDate", 150);  
        ListGridField schoolingTerminationDate = new ListGridField("schoolingTerminationDate", 150);  
        ListGridField schoolingRegion = new ListGridField("schoolingRegion", 150);  
        ListGridField school = new ListGridField("school", 150);  
        ListGridField deductionPercentage = new ListGridField("deductionPercentage", 150);  
        deductionPercentage.setShowGridSummary(false);
        ListGridField amount = new ListGridField("amount", 80);  
        amount.setFrozen(true); 
        amount.setShowGridSummary(true);
        ListGridField educationType = new ListGridField("educationType", 150); 
        educationType.setShowGridSummary(false);
        ListGridField educationStage = new ListGridField("educationStage", 150); 
        educationStage.setShowGridSummary(false);
        ListGridField issueDate = new ListGridField("issueDate", 150);  
        ListGridField credential = new ListGridField("credential", 150);  
        ListGridField credentialNumber = new ListGridField("credentialNumber", 150);  
        ListGridField issuingAuthority = new ListGridField("issuingAuthority", 150);  
        issuingAuthority.setShowGridSummary(false);
        ListGridField houseAddress = new ListGridField("houseAddress", 150);  
        ListGridField houseBorrower = new ListGridField("houseBorrower", 150); 
        houseBorrower.setShowGridSummary(false);
        ListGridField houseType = new ListGridField("houseType", 150);  
        houseType.setShowGridSummary(false);
        ListGridField houseNumber = new ListGridField("houseNumber", 150);  
        ListGridField houseFirst = new ListGridField("houseFirst", 150);  
        houseFirst.setShowGridSummary(false);
        ListGridField loanType = new ListGridField("loanType", 150);  
        loanType.setShowGridSummary(false);
        ListGridField creditorBank = new ListGridField("creditorBank", 150);  
        ListGridField creditorContractNumber = new ListGridField("creditorContractNumber", 150);  
        ListGridField repaymentFirstDate = new ListGridField("repaymentFirstDate", 150);  
        ListGridField repayment = new ListGridField("repayment", 150); 
        repayment.setShowGridSummary(false);
        ListGridField province = new ListGridField("province", 150);  
        ListGridField city = new ListGridField("city", 150);  
        ListGridField leaseType = new ListGridField("leaseType", 150);  
        leaseType.setShowGridSummary(false);
        ListGridField leaseAddress = new ListGridField("leaseAddress", 150);  
        ListGridField leaseContractNumber = new ListGridField("leaseContractNumber", 150);  
        ListGridField singleChild = new ListGridField("singleChild", 150);  
        singleChild.setShowGridSummary(false);
        ListGridField allocationWay = new ListGridField("allocationWay", 150);  
        ListGridField allocationAmount = new ListGridField("allocationAmount", 150);  
        ListGridField changeType = new ListGridField("changeType", 150);  
        changeType.setShowGridSummary(false);
        ListGridField hospitalizationTotalCost = new ListGridField("hospitalizationTotalCost", 150);
        hospitalizationTotalCost.setShowGridSummary(false);
        ListGridField hospitalizationPersonalCost = new ListGridField("hospitalizationPersonalCost", 150); 
        hospitalizationPersonalCost.setShowGridSummary(false);
        ListGridField relationship = new ListGridField("relationship", 150);  
        relationship.setShowGridSummary(false);
        ListGridField fileUrl = new ListGridField("fileUrl", 150);  
        ListGridField fid = new ListGridField("fid", 150);  
        fid.setHidden(true);
        ListGridField furl = new ListGridField("furl", 150);  
        furl.setHidden(true);
//        grid.setFields(nameField);  
        resultGrid.setFields(processStatus,employeId,specialDeductionTypeId, year,amount,companyId,plateId,documentType,identificationNumber,phone,taxpayerRegistrationNumber,address,email,withholdName,withholdRegistrationNumber,spouseSituation,spouseName,spouseDocumentType,spouseIdentificationNumber, name, otherDocumentType, otherIdentificationNumber, brithdate, nationalityRegion, schooling, startDate, endDate, schoolingTerminationDate, schoolingRegion, school, deductionPercentage, educationType, educationStage, issueDate, credential, credentialNumber, issuingAuthority, houseAddress, houseBorrower, houseType, houseNumber, houseFirst, loanType, creditorBank, creditorContractNumber, repaymentFirstDate, repayment, province, city, leaseType, leaseAddress, leaseContractNumber, singleChild, allocationWay, allocationAmount, changeType, hospitalizationTotalCost, hospitalizationPersonalCost, relationship, fileUrl,fid,furl);

		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
/*		IButton downButton = new IButton("下载专项扣除附件");
		downButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				
				if(!resultGrid.anySelected()) {
					SC.say("提示","请选择一条数据");
					return;
				}else {
					ListGridRecord listGridRecord = resultGrid.getSelectedRecords()[0];
					String furl = listGridRecord.getAttribute("furl");
					if(furl!=null) {
						DownloadFileByUrl.download(furl);
					}else {
						SC.say("提示","专项扣除附件不存在");
						return;
					}
				}
			}
		});
		controlLayout.addMember(downButton);*/
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Mspecialdeductionrecordsor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				MspecialdeductionrecordsorViewer detailForm = new MspecialdeductionrecordsorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by special_deduction_record_id desc");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new MspecialdeductionrecordsorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMspecialdeductionrecordsor.getInstance();
	}

	public int getSearchFormHeight() {
		return 130;
	}
}

