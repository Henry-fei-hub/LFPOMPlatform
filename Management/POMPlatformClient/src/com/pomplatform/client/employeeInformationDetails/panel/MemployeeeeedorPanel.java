package com.pomplatform.client.employeeInformationDetails.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeeInformationDetails.datasource.DSMemployeeeeedor;
import com.pomplatform.client.employeeInformationDetails.form.MemployeeeeedorSearchForm;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.delicacy.client.ui.LayoutConstant;

import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Map;
import java.util.logging.Logger;

public class MemployeeeeedorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MemployeeeeedorPanel cm = new MemployeeeeedorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeeeeedor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		IButton downButton = PermissionControl.createPermissionButton("导出", BasicPermissionStatic.EMPLOYEE_EXPORT_BUTTON);
		controlLayout.addMember(downButton);
		downButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Criteria record = searchForm.getValuesAsCriteria();
				Map param = record.getValues();
				checkSearchCriteria(param);
				ClientUtil.departmentParameterProcess(param);
				DBDataSource.downloadFile("DW_Memployeeeeedor", param);
			}
		});
//		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				showDetail();
//			}
//		});
//		IButton viewButton = new IButton("查看详细");
//		viewButton.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
//		controlLayout.addMember(viewButton);
//		commonQuery();
//	}
//
//	public void showDetail() {
//		GWT.runAsync(new RunAsyncCallback() {
//			@Override
//			public void onFailure(Throwable reason) {
//				SC.say("failure to download code");
//			}
//			@Override
//			public void onSuccess() {
//				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("Memployeeeeedor");
//				detail.setWidth100();
//				detail.setHeight100();
//				MemployeeeeedorViewer detailForm = new MemployeeeeedorViewer();
//				detailForm.setParentSearchForm(searchForm);
//				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				detailForm.initComponents();
//				detailForm.viewSelectedData(resultGrid);
//				detail.setContent(detailForm);
//				detail.centerInPage();
//				detail.show();
//			}if (getFieldName(colNum).equals("processStatus")) {
//		});
	}

	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				 if (getFieldName(colNum).equals("card")) {
					// 获取是否组建团队标识
					String card = BaseHelpUtils.getString(record.getAttribute("card"));
					if (card.equals("×")) {
						return "color: red;";
					}
				}else if(getFieldName(colNum).equals("employeeNameEn")){
					 String employeeNameEn = BaseHelpUtils.getString(record.getAttribute("employeeNameEn"));
					 if (employeeNameEn.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("fileNumber")){
					 String fileNumber = BaseHelpUtils.getString(record.getAttribute("fileNumber"));
					 if (fileNumber.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("mobile")){
					 String mobile = BaseHelpUtils.getString(record.getAttribute("mobile"));
					 if (mobile.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("country")){
					 String country = BaseHelpUtils.getString(record.getAttribute("country"));
					 if (country.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("birthplace")){
					 String birthplace = BaseHelpUtils.getString(record.getAttribute("birthplace"));
					 if (birthplace.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("accountLocation")){
					 String accountLocation = BaseHelpUtils.getString(record.getAttribute("accountLocation"));
					 if (accountLocation.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("householdRegistration")){
					 String householdRegistration = BaseHelpUtils.getString(record.getAttribute("householdRegistration"));
					 if (householdRegistration.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("nationality")){
					 String nationality = BaseHelpUtils.getString(record.getAttribute("nationality"));
					 if (nationality.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("marriedStatus")){
					 String marriedStatus = BaseHelpUtils.getString(record.getAttribute("marriedStatus"));
					 if (marriedStatus.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("politicalFace")){
					 String politicalFace = BaseHelpUtils.getString(record.getAttribute("politicalFace"));
					 if (politicalFace.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("educationProof")){
					 String educationProof = BaseHelpUtils.getString(record.getAttribute("educationProof"));
					 if (educationProof.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("degreeProof")){
					 String degreeProof = BaseHelpUtils.getString(record.getAttribute("degreeProof"));
					 if (degreeProof.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("startWorkDate")){
					 String startWorkDate = BaseHelpUtils.getString(record.getAttribute("startWorkDate"));
					 if (startWorkDate.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("positiveDate")){
					 String positiveDate = BaseHelpUtils.getString(record.getAttribute("positiveDate"));
					 if (positiveDate.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("onboardDate")){
					 String onboardDate = BaseHelpUtils.getString(record.getAttribute("onboardDate"));
					 if (onboardDate.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("personalBusinessRemark")){
					 String personalBusinessRemark = BaseHelpUtils.getString(record.getAttribute("personalBusinessRemark"));
					 if (personalBusinessRemark.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("contractStartDate")){
					 String contractStartDate = BaseHelpUtils.getString(record.getAttribute("contractStartDate"));
					 if (contractStartDate.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("contractEndDate")){
					 String contractEndDate = BaseHelpUtils.getString(record.getAttribute("contractEndDate"));
					 if (contractEndDate.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("ownedCompany")){
					 String ownedCompany = BaseHelpUtils.getString(record.getAttribute("ownedCompany"));
					 if (ownedCompany.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("dutyId")){
					 String dutyId = BaseHelpUtils.getString(record.getAttribute("dutyId"));
					 if (dutyId.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("socialComputerNumber")){
					 String socialComputerNumber = BaseHelpUtils.getString(record.getAttribute("socialComputerNumber"));
					 if (socialComputerNumber.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("fundAccount")){
					 String fundAccount = BaseHelpUtils.getString(record.getAttribute("fundAccount"));
					 if (fundAccount.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("bankCardNum")){
					 String bankCardNum = BaseHelpUtils.getString(record.getAttribute("bankCardNum"));
					 if (bankCardNum.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("workYearType")){
					 String workYearType = BaseHelpUtils.getString(record.getAttribute("workYearType"));
					 if (workYearType.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("emergencyContactPerson")){
					 String emergencyContactPerson = BaseHelpUtils.getString(record.getAttribute("emergencyContactPerson"));
					 if (emergencyContactPerson.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("emergencyContactPhone")){
					 String emergencyContactPhone = BaseHelpUtils.getString(record.getAttribute("emergencyContactPhone"));
					 if (emergencyContactPhone.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("cardAddress")){
					 String cardAddress = BaseHelpUtils.getString(record.getAttribute("cardAddress"));
					 if (cardAddress.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("graduatedSchool")){
					 String graduatedSchool = BaseHelpUtils.getString(record.getAttribute("graduatedSchool"));
					 if (graduatedSchool.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("specialty")){
					 String specialty = BaseHelpUtils.getString(record.getAttribute("specialty"));
					 if (specialty.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("learningWay")){
					 String learningWay = BaseHelpUtils.getString(record.getAttribute("learningWay"));
					 if (learningWay.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("cardAttachment")){
					 String cardAttachment = BaseHelpUtils.getString(record.getAttribute("cardAttachment"));
					 if (cardAttachment.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("educationProofId")){
					 String educationProofId = BaseHelpUtils.getString(record.getAttribute("educationProofId"));
					 if (educationProofId.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("degreeProofId")){
					 String degreeProofId = BaseHelpUtils.getString(record.getAttribute("degreeProofId"));
					 if (degreeProofId.equals("×")) {
						 return "color: red;";
					 }
				 }else if(getFieldName(colNum).equals("laborAttachments")){
					 String laborAttachments = BaseHelpUtils.getString(record.getAttribute("laborAttachments"));
					 if (laborAttachments.equals("×")) {
						 return "color: red;";
					 }
				 }
				return super.getCellCSSText(record, rowNum, colNum);
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MemployeeeeedorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeeeeedor.getInstance();
	}


}

