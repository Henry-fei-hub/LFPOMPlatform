package com.pomplatform.client.workflow.form;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.budgetmanagement.panel.OnPayForSeqPanel;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.datasource.DSPayMoneyManageOfWorkflow;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.TitleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.TitleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class PayMoneyManageOfWorkflowNewForm extends AbstractWizadPage
{

	private final Logger __logger = Logger.getLogger("");
	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final FloatItem payAmountItem;
	private final ComboBoxItem employeeIdItem;
	private final IntegerItem departmentIdItem;
	private final LinkItem attachmentFileItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final TextAreaItem reasonItem;
	private final SelectItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	/*private final DoubleItem projectIntegralItem;
	private final DoubleItem costIntegralItem;
	private final DoubleItem leftIntegralItem;*/
	private final ComboBoxItem companyIdItem;
	private final SelectItem currencyItem;
	//private final ComboBoxItem projectItem;
	private final TextItem titleNameItem;
	private final ButtonItem payseqIButItem;
	private final SelectItem useOfFundItem;
	private final CheckboxItem relatedToContractItem;
	private final TextItem contractAmountItem;
	private final ComboBoxItem receiveUnitIdItem;
	private final PickTreeItem purchaserDepartmentItem;
	private final ComboBoxItem purchaserItem;
	private final TextItem purchasingCategoryItem;

	private ProcessBillListApplyPanel pblPanel;
	
	private Tree tree = KeyValueManager.getTree("departments");


	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();

	public PayMoneyManageOfWorkflowNewForm() {
		DSPayMoneyManageOfWorkflow ds = DSPayMoneyManageOfWorkflow.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		__form.setPadding(1);
		__form.setMargin(1);

		receiveUnitItem = new TextItem("receiveUnit", "收款单位(添加收款信息后自动带入)");
		receiveUnitItem.setRequired(true);
		receiveUnitItem.setWidth("*");
		receiveUnitItem.disable();
		//		receiveUnitItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		//		receiveUnitItem.setValueMap(KeyValueManager.getValueMap("receive_unit_manages"));
		__formItems.add(receiveUnitItem);

		//		receiveUnitItem.addChangedHandler(new ChangedHandler() {
		//			@Override
		//			public void onChanged(ChangedEvent event) {
		//				String value = BaseHelpUtils.getString(event.getValue());
		//				if(!BaseHelpUtils.isNullOrEmpty(value)){
		//					Map<String,Object> param = new HashMap<>();
		//					param.put("idd", value);
		//					DBDataSource.callOperation("NQ_OnPayMoneyManageBusiness", "find", param, new DSCallback() {
		//			            @Override
		//			            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		//			                if (dsResponse.getStatus() >= 0) {
		//			                	Record record = dsResponse.getData()[0];
		//			                	if(!BaseHelpUtils.isNullOrEmpty(record)){
		//			                		//获取银行账号
		//			                		String bankAccount = BaseHelpUtils.getString(record.getAttribute("bankAccount"));
		//			                		//获取账户名称
		//			                		String bankName = BaseHelpUtils.getString(record.getAttribute("bankName"));
		//			                		//设置账号和账户名称
		//			                		bankAccountItem.setValue(bankAccount);
		//			                		bankNameItem.setValue(bankName);
		//			                	}
		//			                } else {
		//			                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		//			                }
		//			            }
		//			        });
		//				}
		//			}
		//		});

		bankAccountItem = new TextItem("bankAccount", "银行账号(添加收款信息后自动带入)");
		bankAccountItem.setRequired(true);
		bankAccountItem.setWidth("*");
		bankAccountItem.setDisabled(true);
		__formItems.add(bankAccountItem);

		bankNameItem = new TextItem("bankName", "开户行(添加收款信息后自动带入)");
		bankNameItem.setRequired(true);
		bankNameItem.setDisabled(true);
		bankNameItem.setWidth("*");
		__formItems.add(bankNameItem);

		payAmountItem = new FloatItem("payAmount", "付款金额");
		payAmountItem.setRequired(true);
		payAmountItem.setDisabled(true);
		//		payAmountItem.setMin(50);  
		//		payAmountItem.setStep(500f);  
		//		payAmountItem.setWriteStackedIcons(false);
		payAmountItem.setDefaultValue(100);
		payAmountItem.setWidth("*");
		__formItems.add(payAmountItem);

		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);

		departmentIdItem = new IntegerItem("departmentId","部门");
		departmentIdItem.hide();
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		__formItems.add(departmentIdItem);

		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(0);
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);

		currencyItem = new SelectItem("currency", "货币种类");
		currencyItem.setWidth("*");
		currencyItem.setDefaultValue(0);
		currencyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyItem);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);

		attachmentFileItem = new LinkItem("上传附件");
		attachmentFileItem.setLinkTitle("尚未上传附件,请点击标题【上传附件】上传");
		attachmentFileItem.setWidth("*");
		attachmentFileItem.setTitleStyle("labelTitleStyleClick");
		attachmentFileItem.setCanEdit(false);
		attachmentFileItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		__formItems.add(attachmentFileItem);
		attachmentFileItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							attachmentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentNameItem.setValue(fileName);
							attachmentFileItem.setTitle("更新附件");
							attachmentFileItem.setTitleStyle("labelTitleStyleClick");
							attachmentFileItem.setCanEdit(false);
							attachmentFileItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachmentFileItem.setLinkTitle("已上传附件,点击可下载/预览(点击【更新附件】上传新的附件)");
							attachmentFileItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentFileItem.redraw();
						}
					}
				});
			}
		});


		/*projectItem=new ComboBoxItem("projectId","项目");
		projectItem.setWidth("*");
		projectItem.setChangeOnKeypress(false);
		projectItem.setColSpan(4);
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != projectItem.getValue() && null != projectMap && !projectMap.isEmpty()){
					//获取项目名称
					String value = projectMap.get(ClientUtil.checkAndGetIntValue(projectItem.getValue()));
					projectIntegralItem.show();
					costIntegralItem.show(); 
					leftIntegralItem.show();
					Map<String, Object> map = new HashMap<>();
					int projectId=BaseHelpUtils.getIntValue(projectItem.getValue());
					map.put("projectId",projectId);
					DBDataSource.callOperation("NQ_PayMoneyProject",map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record record[] = dsResponse.getData();
								for (Record obj : record) {
									projectIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("totalIntegral")));
									costIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("costIntegral")));
									leftIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("leftIntegral")));
								}
							}
						}
					});
				}
			}
		});

		__formItems.add(projectItem);*/

		/*projectIntegralItem=new DoubleItem("projectIntegral","项目积分");  
		projectIntegralItem.setWidth("*");
		projectIntegralItem.setDisabled(true);
		projectIntegralItem.setWidth("*");
		projectIntegralItem.setCanEdit(false);
		__formItems.add( projectIntegralItem);

		costIntegralItem=new DoubleItem("costIntegral","项目已用积分");
		costIntegralItem.setWidth("*");
		costIntegralItem.setDisabled(true);
		costIntegralItem.setWidth("*");
		costIntegralItem.setCanEdit(false);
		__formItems.add( costIntegralItem);


		leftIntegralItem=new DoubleItem("leftIntegral","项目剩余积分");
		leftIntegralItem.setWidth("*");
		leftIntegralItem.setDisabled(true);
		leftIntegralItem.setWidth("*");
		leftIntegralItem.setCanEdit(false);
		__formItems.add( leftIntegralItem);*/

		payseqIButItem=new ButtonItem("预算付款序列");
		payseqIButItem.setStartRow(true);
		payseqIButItem.hide();
		payseqIButItem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow popupWindow = new PopupWindow("预算付款序列");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("40%");
				OnPayForSeqPanel payseqPanel=new OnPayForSeqPanel();
				payseqPanel.setRecord(budgetRecord);
				payseqPanel.init();
				popupWindow.addItem(payseqPanel);
				popupWindow.centerInPage();
				popupWindow.show();

			}
		});
		__formItems.add(payseqIButItem);

		reasonItem = new TextAreaItem("reason", "付款原因");
		reasonItem.setRequired(true);
		reasonItem.setWidth("*");
		reasonItem.setColSpan(4);
		__formItems.add(reasonItem);

		operateEmployeeIdItem = new SelectItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		operateEmployeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		operateEmployeeIdItem.hide();
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.hide();
		operateTimeItem.setDefaultValue(new Date());
		__formItems.add(operateTimeItem);

		titleNameItem = new TextItem("titleName", "主题名称");
		titleNameItem.setWidth("*");
		titleNameItem.hide();
		__formItems.add(titleNameItem);

		useOfFundItem = new SelectItem("useOfFund", "资金用途");
		useOfFundItem.setWidth("*");
		useOfFundItem.setDefaultValue(1);
		useOfFundItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_236"));
		__formItems.add(useOfFundItem);
		
		relatedToContractItem = new CheckboxItem("relatedToContract", "本报销与合同或协议有关");
		relatedToContractItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(BaseHelpUtils.getBoolean(event.getValue())) {
					contractAmountItem.show();
					receiveUnitIdItem.show();
					purchaserDepartmentItem.show();
					purchaserItem.show();
					purchasingCategoryItem.show();
				}else {
					contractAmountItem.hide();
					contractAmountItem.clearValue();
					receiveUnitIdItem.hide();
					receiveUnitIdItem.clearValue();
					purchaserDepartmentItem.hide();
					purchaserDepartmentItem.clearValue();
					purchaserItem.hide();
					purchaserItem.clearValue();
					purchasingCategoryItem.hide();
					purchasingCategoryItem.clearValue();
				}
			}
		});
		__formItems.add(relatedToContractItem);
		
		contractAmountItem = new FloatItem("contractAmount", "合同金额");
		contractAmountItem.setLength(18);
		contractAmountItem.setDecimalPad(3);
		contractAmountItem.setWidth("*");
		contractAmountItem.setFormat("#,###,###,###,###,##0.00");
		contractAmountItem.hide();
		contractAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					item.setValue(BaseHelpUtils.format(item.getValue(), 2));
				}
			}
		});
		__formItems.add(contractAmountItem);
		
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		receiveUnitIdItem= new ComboBoxItem("receiveUnitId", "供应商");
		receiveUnitIdItem.setChangeOnKeypress(false);
		receiveUnitIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		receiveUnitIdItem.setWidth("*");
		receiveUnitIdItem.hide();
		receiveUnitIdItem.setValueField("receiveUnitManageId");
		receiveUnitIdItem.setDisplayField("receiveUnit");
		receiveUnitIdItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		receiveUnitIdItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		receiveUnitIdItem.setPickListWidth(700);
		__formItems.add(receiveUnitIdItem);
		
		purchaserDepartmentItem = new PickTreeItem("departmentTree", "采购人归属部门");
		purchaserDepartmentItem.setWidth("*");
		purchaserDepartmentItem.setCanSelectParentItems(true);
		purchaserDepartmentItem.setValueTree(KeyValueManager.getTree("departments"));	
		purchaserDepartmentItem.hide();
		purchaserDepartmentItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if (null != event.getValue()) {
					String[] arr = BaseHelpUtils.getString(event.getValue()).split("/");
					if (arr.length <= 2) {
						event.cancel();
					}else if(arr.length > 4) {
						event.cancel();
						TreeNode[] nodes = tree.getAllNodes();
						for (TreeNode node : nodes) {
							if (node.getName().equals(arr[3])) {
								purchaserDepartmentItem.setValue(tree.getPath(node));
								break;
							}
						}
					}
				}
			}
		});
		__formItems.add(purchaserDepartmentItem);
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		KeyValueManager.loadValueMap("all_departments",departmentIdField);
		
        purchaserItem = new ComboBoxItem("purchaser", "采购人");
        purchaserItem.setTitleOrientation(TitleOrientation.TOP);
        purchaserItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
        purchaserItem.setChangeOnKeypress(false);
        purchaserItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        purchaserItem.setValueField(employeeIdField.getName());
        purchaserItem.setDisplayField(employeeNameField.getName());
        purchaserItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
        purchaserItem.setPickListWidth(500);
        //只查询出在职的员工
        Criteria employeeCondition = new Criteria();
        employeeCondition.addCriteria("status", 0);
        purchaserItem.setPickListCriteria(employeeCondition);
        purchaserItem.setWidth("*");
        purchaserItem.hide();
		__formItems.add(purchaserItem);
		
		purchasingCategoryItem = new TextItem("purchasingCategory", "采购类别");
		purchasingCategoryItem.setWidth("*");
		purchasingCategoryItem.hide();
		__formItems.add(purchasingCategoryItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		__form.setBackgroundColor("#e2e2e2");
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(__form.validate()) {
			if(BaseHelpUtils.getBoolean(relatedToContractItem.getValue())) {
				if(BaseHelpUtils.isNullOrEmpty(contractAmountItem.getValue())) {
					SC.say("请填写合同金额");
					return false;
				}
				if(!(contractAmountItem.getValue() instanceof Number)) {
					SC.say("合同金额填写有误");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(receiveUnitIdItem.getValue())) {
					SC.say("请选择供应商");
					return false;
				}
				Record[] receiveUnitArr = pblPanel.getValuesAsRecords();
				if(null == receiveUnitArr || receiveUnitArr.length != 1 || BaseHelpUtils.getIntValue(receiveUnitArr[0].getAttribute("payFor")) != ClientStaticUtils.PAY_FOR_COMPANY || BaseHelpUtils.getIntValue(receiveUnitArr[0].getAttribute("employeeOrCompanyId")) != BaseHelpUtils.getIntValue(receiveUnitIdItem.getValue())) {
					SC.say("选择供应商与收款信息的供应商不一致");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(purchaserDepartmentItem.getValue())) {
					SC.say("请选择采购人归属部门");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(purchaserItem.getValue())) {
					SC.say("请选择采购人");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(purchasingCategoryItem.getValue())) {
					SC.say("请填写采购类别");
					return false;
				}
			}
			return true;
		}else {
			SC.say("请按照系统提示填好信息");
			return false;
		}
	}

	public void initReNewData(Record record){
		if (record == null) {
			return;
		}
		if (record.getAttribute("businessId") != null && record.getAttribute("businessId") != "") {
			int businessId = record.getAttributeAsInt("businessId");
			Map params = new HashMap<>();
			params.put("payMoneyManageId", businessId);
			DBDataSource.callOperation("ST_PayMoneyManage", "find", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					Record record2 = dsResponse.getData()[0];
					showItemByData(record2);
					Map map = record2.toMap();
					map.put("payMoneyManageId", null);
					map.put("operateEmployeeId", null);
					map.put("deleteFlag", null);
					map.put("isCompleted", null);
					map.put("bePacked", null);
					map.put("operateTime", new Date());
					map.put("currency", null);
					map.put("code", null);
					map.put("attachmentFile", null);
					map.put("attachmentId", null);
					map.put("attachmentName", null);
					__form.setValues(map);
				}
			});
		}
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) { 
			Record record = getRecord();
			showItemByData(record);
			__form.editRecord(record);
		}else {
			__form.editNewRecord();
		}
		
		loadBudgetDate();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSPayMoneyManageOfWorkflow.getInstance());
		manager.addMember(__form);
	}


	@Override
	public Map getValuesAsMap() {
		//获取职员部门、职员名称、流程名称、金额设置主题名称的值
		int departmentId = BaseHelpUtils.getIntValue(departmentIdItem.getValue());
		int employeeId = BaseHelpUtils.getIntValue(employeeIdItem.getValue());
		Map<Object,Object> param = __form.getValues();
		if (null != param && !param.isEmpty()) {
			for (Object key : param.keySet()) {
				if (key.toString().equals("departmentTree") && null != param.get(key)) {
					// 如果是部门的选择结果，则根据选择结果得到>=第三级部门的结果
					String[] paths = param.get(key).toString().split("/");
					int idx = paths.length - 1;
					if(paths.length > 4) {
						idx = 3;
					}
					param.put("purchaserDepartment", paths[idx]);
					break;
				}
			}
		}
		//获取金额
		String amount = BaseHelpUtils.getString(param.get("payAmount"));
		//根据已有的信息，生成默认的主题：部门+姓名+主题+金额 ================ 机电事业二部　　　　　　徐启文　　　　　　　100.00　
		String titleName = PomPlatformClientUtil.getReimbursementTittle(departmentId, employeeId, "", amount, null);
		param.put("titleName", titleName);
		//获取附件
		String attachmentFile = BaseHelpUtils.getString(attachmentFileItem.getValue());
		param.put("attachmentFile", attachmentFile);
		if(budgetRecord!=null) {
			//获取预算管理Id
			int budgetManagementId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("budgetManagementId"));
			//获取附件id
			int budgetAttachmentId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("budgetAttachmentId"));
			//获取付款序列id
			int paymentSequenceId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("paymentSequenceId"));
			param.put("budgetManagementId", budgetManagementId);
			param.put("budgetAttachmentId", budgetAttachmentId);
			param.put("paymentSequenceId",paymentSequenceId);
		}
		return param;
	}

	private int processId;

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	private  Record budgetRecord;

	public Record getBudgetRecord() {
		return budgetRecord;
	}

	public void setBudgetRecord(Record budgetRecord) {
		this.budgetRecord = budgetRecord;
	}

	public void loadBudgetDate() {
		if(budgetRecord!=null) {
			payseqIButItem.show();
		}
	}

	public ProcessBillListApplyPanel getPblPanel() {
		return pblPanel;
	}

	public void setPblPanel(ProcessBillListApplyPanel pblPanel) {
		this.pblPanel = pblPanel;
	}
	
	public void showItemByData(Record record){
		if(BaseHelpUtils.getBoolean(record.getAttribute("relatedToContract"))) {
			contractAmountItem.show();
			receiveUnitIdItem.show();
			purchaserDepartmentItem.show();
			purchaserItem.show();
			purchasingCategoryItem.show();
			if (!BaseHelpUtils.isNullOrEmpty(record.getAttribute("purchaserDepartment"))) {
				TreeNode[] nodes = tree.getAllNodes();
				String value = record.getAttribute("purchaserDepartment");
				for (TreeNode node : nodes) {
					if (node.getName().equals(value)) {
						record.setAttribute("departmentTree", tree.getPath(node));
						break;
					}
				}
			}
		}
	}

}
