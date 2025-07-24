package com.pomplatform.client.workflow.personnel.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.workflow.personnel.datasource.DSApplicationForFiling;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;


public class ApplicationForFilingUpdateForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNameItem;
	private final DateItem birthItem;
	private final TextItem ageItem;
	private final DateItem startWorkDateItem;
	private final DateItem onboardDateItem;
	private final TextItem graduatedSchoolItem;
	private final TextItem specialtyItem;
	private final TextItem cardAttachmentItem;
	private final TextItem technicalAttachmentItem;
	private final TextItem educationProofItem;
	private final ButtonItem uploadButton7;
	private final ButtonItem uploadButton1;
	private final ButtonItem uploadButton2;

	public ApplicationForFilingUpdateForm() {
		DSApplicationForFiling ds = DSApplicationForFiling.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeIdItem = new TextItem("employeeId", "员工工号");
		employeeIdItem.hide();
		employeeIdItem.setDisabled(true);
		employeeIdItem.setRequired(true);
		IsIntegerValidator employeeIdValidator = new IsIntegerValidator();
		employeeIdItem.setValidators(employeeIdValidator);
		__formItems.add(employeeIdItem);

		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();
		employeeNameItem.setWidth("*");
		employeeNameItem.setRequired(true);
		employeeNameItem.setDisabled(true);
		IsStringValidator employeeNameValidator = new IsStringValidator();
		LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
		employeeNameLengthValidator.setMax(64);
		employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
		__formItems.add(employeeNameItem);

		birthItem = new DateItem("birth", "出生日期");
		birthItem.hide();
		birthItem.setWidth("*");
		birthItem.setDisabled(true);
		birthItem.setUseTextField(true);
		birthItem.setUseMask(true);
		__formItems.add(birthItem);

		ageItem = new TextItem("age", "年龄");
		ageItem.hide();
		ageItem.setDisabled(true);
		ageItem.setWidth("*");
		__formItems.add(ageItem);

		startWorkDateItem = new DateItem("startWorkDate", "参加工作时间");
		startWorkDateItem.hide();
		startWorkDateItem.setDisabled(true);
		startWorkDateItem.setWidth("*");
		startWorkDateItem.setUseTextField(true);
		startWorkDateItem.setUseMask(true);
		__formItems.add(startWorkDateItem);

		onboardDateItem = new DateItem("onboardDate", "入职日期");
		onboardDateItem.hide();
		onboardDateItem.setDisabled(true);
		onboardDateItem.setWidth("*");
		onboardDateItem.setUseTextField(true);
		onboardDateItem.setUseMask(true);
		__formItems.add(onboardDateItem);

		graduatedSchoolItem = new TextItem("graduatedSchool", "毕业院校");
		graduatedSchoolItem.setDisabled(true);
		graduatedSchoolItem.setWidth("*");
		__formItems.add(graduatedSchoolItem);

		specialtyItem = new TextItem("specialty", "所学专业");
		specialtyItem.setDisabled(true);
		specialtyItem.setWidth("*");
		__formItems.add(specialtyItem);

		cardAttachmentItem = new TextItem("cardAttachment", "身份证附件");
		cardAttachmentItem.setDisabled(true);
		cardAttachmentItem.setWidth("*");
		__formItems.add(cardAttachmentItem);

		uploadButton7 = new ButtonItem("下载身份证附件");
		uploadButton7.setStartRow(false);
		uploadButton7.setWidth(120);
		uploadButton7.setVAlign(VerticalAlignment.BOTTOM);
		uploadButton7.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				Map<String, Object> params = new HashMap<>();
				params.put("optType", "ST_FileManagesWatermark");
				params.put("fileUrl",BaseHelpUtils.getString(cardAttachmentItem.getValue()));

				params.put("employeeId",employeeIdItem.getValue());
				params.put("fileType",1);
				DBDataSource.callOperation("EP_FileManagesWatermarkProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SC.debugger();
						if(null !=dsResponse.getData()) {
							Record record1 = dsResponse.getData()[0];
							String fileUrl = BaseHelpUtils.getString(record1.getAttribute("fileUrl"));
							if(null!=fileUrl){
								DownloadFileByUrl.download(fileUrl);
							}
						}
					}
				});

			}

		});
		__formItems.add(uploadButton7);



		technicalAttachmentItem = new TextItem("technicalAttachment", "职称证附件");
		technicalAttachmentItem.setDisabled(true);
		technicalAttachmentItem.setWidth("*");
		__formItems.add(technicalAttachmentItem);

		uploadButton1 = new ButtonItem("下载职称证附件");
		uploadButton1.setStartRow(false);
		uploadButton1.setWidth(120);
		uploadButton1.setVAlign(VerticalAlignment.BOTTOM);
		uploadButton1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				SC.debugger();
				params.put("optType", "ST_FileManagesWatermark");
				params.put("fileUrl",BaseHelpUtils.getString(technicalAttachmentItem.getValue()));
				params.put("employeeId",employeeIdItem.getValue());
				params.put("fileType",2);
				DBDataSource.callOperation("EP_FileManagesWatermarkProcess", "find",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(null !=dsResponse.getData()) {
							Record record1 = dsResponse.getData()[0];
							String fileUrl = BaseHelpUtils.getString(record1.getAttribute("fileUrl"));
							if(null!=fileUrl){
								DownloadFileByUrl.download(fileUrl);
							}
						}
					}
				});
			}
		});
		__formItems.add(uploadButton1);

		educationProofItem = new TextItem("educationProof", "学历证附件");
		educationProofItem.setDisabled(true);
		educationProofItem.setWidth("*");
		__formItems.add(educationProofItem);


		uploadButton2 = new ButtonItem("下载学历证附件");
		uploadButton2.setStartRow(false);
		uploadButton2.setWidth(120);
		uploadButton2.setVAlign(VerticalAlignment.BOTTOM);
		uploadButton2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				Map<String, Object> params = new HashMap<>();
				SC.debugger();
				params.put("optType", "ST_FileManagesWatermark");
				params.put("fileUrl",BaseHelpUtils.getString(educationProofItem.getValue()));
				params.put("employeeId",employeeIdItem.getValue());
				params.put("fileType",3);
				DBDataSource.callOperation("EP_FileManagesWatermarkProcess", "find",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(null !=dsResponse.getData()) {
							Record record1 = dsResponse.getData()[0];
							String fileUrl = BaseHelpUtils.getString(record1.getAttribute("fileUrl"));
							if(null!=fileUrl){
								DownloadFileByUrl.download(fileUrl);
							}
						}
					}
				});
			}
		});
		__formItems.add(uploadButton2);


		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSApplicationForFiling.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	public void reloadData(int employeeId){
		Map<String,Object> param = new HashMap<>();
		param.put("employeeId", employeeId);
		SC.debugger();
		DBDataSource.callOperation("NQ_ApplicationForFiling", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					if (null != record) {
						birthItem.setValue(record.getAttributeAsDate("birth"));

						employeeIdItem.setValue(record.getAttributeAsString("employeeId"));
						employeeNameItem.setValue(record.getAttributeAsString("employeeName"));
						startWorkDateItem.setValue(record.getAttributeAsDate("startWorkDate"));
						ageItem.setValue(record.getAttributeAsString("age"));
						onboardDateItem.setValue(record.getAttributeAsDate("onboardDate"));
						graduatedSchoolItem.setValue(record.getAttributeAsString("graduatedSchool"));
						specialtyItem.setValue(record.getAttributeAsString("specialty"));
						cardAttachmentItem.setValue(record.getAttributeAsString("cardAttachment"));
						technicalAttachmentItem.setValue(record.getAttributeAsString("technicalAttachment"));
						educationProofItem.setValue(record.getAttributeAsString("educationProof"));
					}
				}
			}
		});
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
