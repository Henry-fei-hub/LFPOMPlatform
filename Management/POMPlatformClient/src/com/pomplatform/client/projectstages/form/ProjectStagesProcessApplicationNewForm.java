package com.pomplatform.client.projectstages.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectstages.datasource.DSProjectStagesProcessApplication;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectStagesProcessApplicationNewForm extends AbstractWizadPage
{


	private final TextItem contractIdItem;
	private final TextItem mainProjectIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem projectAmountSumItem;
	private final TextItem applyAmountItem;
//	private final TextItem fileIdItem;
//	private final TextItem fileUrlItem;
	private final TextItem remarkItem;
    //附件
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
    public static IButton uploadButton;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final DateTimeItem createTimeItem;
	//剩余积分
	private final TextItem remainingAmountItem;
	//已申请比例
	private final TextItem applyRateItem;
	//本次申请比例
	private final TextItem currentApplyRateItem;
	//剩余比例
	private final TextItem remainingRateItem;

	private BigDecimal remainingAmountBefore = BigDecimal.ZERO;
	private BigDecimal applyRateBefore = BigDecimal.ZERO;

	public ProjectStagesProcessApplicationNewForm() {
		DSProjectStagesProcessApplication ds = DSProjectStagesProcessApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractIdItem = new TextItem("contractId", "contract_id");
		contractIdItem.hide();
		__formItems.add(contractIdItem);
		mainProjectIdItem = new TextItem("mainProjectId", "main_project_id");
		mainProjectIdItem.hide();
		__formItems.add(mainProjectIdItem);

		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setCanEdit(false);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValue(ClientUtil.getEmployeeId());
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "申请人工号");
		employeeNoItem.setCanEdit(false);
		employeeNoItem.setWidth("*");
		employeeNoItem.setValue(ClientUtil.getUserNo());
		__formItems.add(employeeNoItem);

		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setCanEdit(false);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);

		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setCanEdit(false);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);

		projectAmountSumItem = new TextItem("projectAmountSum", "项目产值");
		projectAmountSumItem.setCanEdit(false);
		projectAmountSumItem.setWidth("*");
		__formItems.add(projectAmountSumItem);

		applyAmountItem = new TextItem("applyAmount", "本次申请的积分");
		applyAmountItem.setDefaultValue(0);
		applyAmountItem.setCanEdit(false);
		applyAmountItem.setWidth("*");
		__formItems.add(applyAmountItem);

		remainingAmountItem = new TextItem("remainingAmount", "剩余积分");
		remainingAmountItem.setDefaultValue(0);
		remainingAmountItem.setCanEdit(false);
		remainingAmountItem.setWidth("*");
		__formItems.add(remainingAmountItem);

		applyRateItem = new TextItem("applyRate", "已申请比例（%）");
		applyRateItem.setDefaultValue(0);
		applyRateItem.setCanEdit(false);
		applyRateItem.setWidth("*");
		__formItems.add(applyRateItem);

		currentApplyRateItem = new TextItem("currentApplyRate", "本次申请比例(%)");
		currentApplyRateItem.setDefaultValue(0);
		currentApplyRateItem.setCanEdit(false);
		currentApplyRateItem.setWidth("*");
		__formItems.add(currentApplyRateItem);

		remainingRateItem = new TextItem("remainingRate", "剩余比例(%)");
		remainingRateItem.setDefaultValue(0);
		remainingRateItem.setCanEdit(false);
		remainingRateItem.setWidth("*");
		__formItems.add(remainingRateItem);

		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.setValue(new Date());
		__formItems.add(createTimeItem);

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setCanEdit(true);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		attachmentItem = new LinkItem("fileUrl");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		__formItems.add(attachmentItem);

		attachmentIdItem = new TextItem("fileId", "附件ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);

		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);

		uploadButton= new IButton("上传附件", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, null, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						SC.debugger();
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setLinkTitle(fileName);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);

        VLayout mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
//        mainLayout.setLayoutTopMargin(10);
//        mainLayout.setLayoutRightMargin(5);
//        mainLayout.setMembersMargin(10);
//        mainLayout.setShowResizeBar(false);
        mainLayout.addMember(__form);
        mainLayout.addMember(uploadButton);

		addMember(mainLayout);


	}

	public void loadValue(Record record) {
		//获取业务主表的ID
		int projectStageProcessRecordId = BaseHelpUtils.getIntValue(record.getAttribute("projectStageProcessRecordId"));
		Map<String, Object> params = new HashMap<>();
		params.put("projectStageProcessRecordId", projectStageProcessRecordId);
		DBDataSource.callOperation("NQ_ProjectStagesProcessApplication", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record datum = dsResponse.getData()[0];
					__form.editRecord(datum);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
    	BigDecimal applyAmount = BaseHelpUtils.getBigDecimalValue(applyAmountItem.getValue());
    	if(applyAmount.compareTo(BigDecimal.ZERO)<=0) {
    		SC.say("提示","本次申请的积分小于等于0");
    		return false;
    	}

    	BigDecimal projectAmountSum = BaseHelpUtils.getBigDecimalValue(projectAmountSumItem.getValue());
    	if(applyAmount.compareTo(projectAmountSum)>0) {
    		SC.say("提示","本次申请的积分不能大于订单积分");
    		return false;
    	}

    	String remark = BaseHelpUtils.getString(remarkItem.getValue());
    	if(BaseHelpUtils.isNullOrEmpty(remark)) {
    		SC.say("提示","备注不能为空");
    		return false;
    	}

		String attachment=BaseHelpUtils.getString(attachmentItem.getValue());
		String attachmentId=BaseHelpUtils.getString(attachmentIdItem.getValue());
//		String attachmentName=BaseHelpUtils.getString(attachmentNameItem.getValue());
//		if(BaseHelpUtils.isNullOrEmpty(attachment)){
//			SC.say("提示","附件不能空");
//			return false;
//		}
		return true;
	}

	@Override
	public void startEdit() {
		Record r = getRecord();
		if (r != null) {
			record.setAttribute("employeeId", ClientUtil.getUserId());
			record.setAttribute("employeeNo", ClientUtil.getUserNo());
			__form.editRecord(r);
			//获取合同ID，重新加载新的合同对应阶段的总产值
			int contractId = BaseHelpUtils.getIntValue(r.getAttribute("contractId"));
			if(contractId > 0) {
				Map<String,Object> params = new HashMap<>();
				params.put("contractId", contractId);
				int projectStageProcessRecordId = BaseHelpUtils.getIntValue(r.getAttribute("projectStageProcessRecordId"));
				if(projectStageProcessRecordId > 0) {
					params.put("projectStageProcessRecordId", projectStageProcessRecordId);
				}
				DBDataSource.callOperation("NQ_ProjectStagesProcessApplication", "find", params, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] records = dsResponse.getData();
							if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
								Record re = records[0];//取第一条的产值总金额
								BigDecimal projectAmountSum = BaseHelpUtils.getBigDecimalValue(re.getAttribute("projectAmountSum"));
								projectAmountSumItem.setValue(projectAmountSum);

								//查询已经分配的积分
								params.put("status", 2);
								DBDataSource.callOperation("ST_ProjectStage", "find", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											Record[] data = dsResponse.getData();
											if (!BaseHelpUtils.isNullOrEmpty(data) && data.length > 0) {
												for (Record datum : data) {
													BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(datum.getAttribute("projectAmount"));
													BigDecimal percent = BaseHelpUtils.getBigDecimalValue(datum.getAttribute("percent"));
													remainingAmountBefore = remainingAmountBefore.add(projectAmount);
													applyRateBefore = applyRateBefore.add(percent);
													remainingAmountItem.setValue(projectAmountSum.subtract(remainingAmountBefore));
													applyRateItem.setValue(applyRateBefore);
												}
											}
										}
									}
								});
							}
						}
					}
				});
			}

		} else {
			__form.editNewRecord();
		}
	}

	/**
	 * 设置数据
	 */
	public void loadMainValue() {
		//获取已经申请的比例
		BigDecimal applyRate = BaseHelpUtils.getBigDecimalValue(applyRateItem.getValue());
		//获取本次申请的比例
		BigDecimal currentApplyRate = BaseHelpUtils.getBigDecimalValue(currentApplyRateItem.getValue());
		BigDecimal subtract = BigDecimal.valueOf(100).subtract(applyRate).subtract(currentApplyRate);
		remainingRateItem.setValue(subtract);
	}


	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectStagesProcessApplication.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		return values;
	}


}
