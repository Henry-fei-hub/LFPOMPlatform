package com.pomplatform.client.trainingmanagement.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.trainingmanagement.datasource.DSTrainingManagementInformation;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TrainingManagementInformationNewForm extends AbstractWizadPage
{

	private final TextItem subjectItem;
	private final SelectItem compereTypeItem;
	private final TextItem compereItem;
	private final DateTimeItem startTimeItem;
	private final DateTimeItem endTimeItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem courseScoreItem;
//	private final SelectItem employeeIdItem;
	private final TextItem signInDelayItem;
	private final TextItem signOutDelayItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem siteTextItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem isSiteItem;
	private final SelectItem trainingTypeItem;
	private final TextItem trainingFeeItem;
	private final TextItem fileIdItem;
	private final TextItem fileUrlItem;
	private final SelectItem isSendItem;
	private final SelectItem plateidsItem;
	private final PickTreeItem departmentidsItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public TrainingManagementInformationNewForm() {
		DSTrainingManagementInformation ds = DSTrainingManagementInformation.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		subjectItem = new TextItem("subject", shouldNotBeNull+"主题");
		__formItems.add(subjectItem);
		subjectItem.setWidth("*");
		courseScoreItem = new TextItem("courseScore", "课程分数");
		courseScoreItem.hide();
		__formItems.add(courseScoreItem);
		courseScoreItem.setWidth("*");
		compereTypeItem = new SelectItem("compereType", shouldNotBeNull+"主持人类型");
		compereTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));
		__formItems.add(compereTypeItem);
		compereTypeItem.setWidth("*");
		compereTypeItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()){
					String obj = event.getValue().toString();
					if (obj == "1") {
						compereItem.hide();
						employeeIdItem.show();
					}else {
						employeeIdItem.hide();
						compereItem.show();
					}
					
				}
				
			}
		});
		compereItem = new TextItem("compere", "主持人");
		__formItems.add(compereItem);
		compereItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "主持人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		employeeIdItem.setWidth("*");
		employeeIdItem.hide();
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				String compere = employeeIdItem.getDisplayValue();
				compereItem.setValue(compere);
			}
		});
		startTimeItem = new DateTimeItem("startTime", shouldNotBeNull+"开始时间");
		__formItems.add(startTimeItem);
		startTimeItem.setWidth("*");
		endTimeItem = new DateTimeItem("endTime", shouldNotBeNull+"结束时间");
		__formItems.add(endTimeItem);
		endTimeItem.setWidth("*");
		signInDelayItem = new TextItem("signInDelay", "签到推迟时间");
		__formItems.add(signInDelayItem);
		signInDelayItem.setWidth("*");
		signOutDelayItem = new TextItem("signOutDelay", "签退推迟时间");
		__formItems.add(signInDelayItem);
		signInDelayItem.setWidth("*");
		departmentIdItem = new PickTreeItem("departmentId", shouldNotBeNull+"所属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		__formItems.add(departmentIdItem);
		plateIdItem = new ComboBoxItem("plateId", shouldNotBeNull+"业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setDefaultValue(ClientUtil.getPlateId());
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(plateIdItem);
		departmentIdItem.setWidth("*");
		isSiteItem = new SelectItem("isSite", shouldNotBeNull+"培训地点类型");
		isSiteItem.setWidth("*");
		Map map =new HashMap<Integer, String>();
		map.put(0, "内部");
		map.put(1, "外部");
		isSiteItem.setValueMap(map);
		__formItems.add(isSiteItem);
		siteTextItem = new TextItem("site",shouldNotBeNull+"培训地点");
		siteTextItem.setWidth("*");
		__formItems.add(siteTextItem);
		trainingTypeItem = new SelectItem("trainingType", shouldNotBeNull+"培训类型");
		trainingTypeItem.setValueMap(map);
		trainingTypeItem.setWidth("*");
		__formItems.add(trainingTypeItem);
		trainingFeeItem = new TextItem("trainingFee", "外部培训预计费用(内部可不填)");
		trainingFeeItem.setWidth("*");
		__formItems.add(trainingFeeItem);
		fileIdItem = new TextItem("fileId", "fileId");
		fileIdItem.hide();
		__formItems.add(fileIdItem);
		fileUrlItem = new TextItem("fileUrl", shouldNotBeNull+"课程附件");
		fileUrlItem.setWidth("*");
		fileUrlItem.setCanEdit(false);
		__formItems.add(fileUrlItem);
		isSendItem = new SelectItem("isSend", shouldNotBeNull+"是否进行消息推送");
		isSendItem.setWidth("*");
		isSendItem.setDefaultValue(1);
		isSendItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		__formItems.add(isSendItem);
		plateidsItem = new SelectItem("plateids", shouldNotBeNull+"需要推送的业务部门");
		plateidsItem.setWidth("*");
		plateidsItem.setDefaultValue(ClientUtil.getPlateId());
		plateidsItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateidsItem.setMultiple(true);
		__formItems.add(plateidsItem);
		departmentidsItem = new PickTreeItem("departmentids", "需要推送的归属部门");
		departmentidsItem.setCanSelectParentItems(true);
		departmentidsItem.setMultipleValueSeparator(",");
		departmentidsItem.setValueField("treeId");
		departmentidsItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentidsItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		departmentidsItem.setMultiple(true);
		departmentidsItem.hide();
		__formItems.add(departmentidsItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
//		addMember(__form);
		
			IButton upButton = new IButton("上传课程附件");
		upButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传课程附件", false, 500, null, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						// 上传附件文件成功
						for(String key : data.keySet()) {
							SC.debugger();
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							fileIdItem.setValue(fileId);
							fileUrlItem.setValue(fileUrl);
						}
					}
				});
			}
		});
		
		//中间
		VLayout center = new VLayout();
		center.setHeight100();
		center.setWidth100();
		
		//form
		HLayout top = new HLayout();
		top.setHeight100();
		top.setWidth100();
		top.addMember(__form);
		
		//按钮
		HLayout button = new HLayout();
		button.setHeight100();
		button.setWidth100();
		button.addMember(upButton);
		
		center.addMember(top);
		center.addMember(button);
		addMember(center);
	}

	@Override
	public boolean checkData() {
		if(null==subjectItem.getValue()) {
			SC.warn("提示","主题不能为空");
			return false;
		}
		if(null==compereTypeItem.getValue()) {
			SC.warn("提示","主持人类型不能为空");
			return false;
		}else {
			if(BaseHelpUtils.getIntValue(compereTypeItem.getValue())==1) {
				if(null==employeeIdItem.getValue()) {
					SC.warn("提示","主持人不能为空");
					return false;
				}
			}else {
				if(null==compereItem.getValue()) {
					SC.warn("提示","主持人不能为空");
					return false;
				}
			}
		}
		if(null==startTimeItem.getValue()) {
			SC.warn("提示","开始时间不能为空");
			return false;
		}
		if(null==endTimeItem.getValue()) {
			SC.warn("提示","结束时间不能为空");
			return false;
		}
		if(null==departmentIdItem.getValue()) {
			SC.warn("提示","归属部门不能为空");
			return false;
		}
		if(null==plateIdItem.getValue()) {
			SC.warn("提示","业务部门不能为空");
			return false;
		}
		if(null==isSiteItem.getValue()||null==siteTextItem.getValue()) {
			SC.warn("提示","培训地点不能为空");
			return false;
		}
		if(null==trainingTypeItem.getValue()) {
			SC.warn("提示","培训类型不能为空");
			return false;
		}else if(BaseHelpUtils.getIntValue(trainingTypeItem.getValue())==1) {
			if(null==trainingFeeItem.getValue()) {
				SC.warn("提示","外部培训预计费用不能为空");
				return false;
			}
		}
		if(null!=isSendItem.getValue()&&BaseHelpUtils.getIntValue(isSendItem.getValue())==0) {
			if(BaseHelpUtils.isNullOrEmpty(plateidsItem.getValue())) {
				SC.warn("提示","请选择要推送的业务部门");
				return false;
			}
		}
		if(null==fileUrlItem.getValue()||null==fileIdItem.getValue()) {
			SC.warn("提示","请上传附件");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSTrainingManagementInformation.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
