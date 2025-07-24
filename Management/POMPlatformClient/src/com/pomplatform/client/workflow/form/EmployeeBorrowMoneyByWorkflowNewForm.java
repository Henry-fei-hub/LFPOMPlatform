package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.budgetmanagement.panel.OnPayForSeqPanel;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.PersonnalMoneyManagePanel;
import com.pomplatform.client.financialtransactionaccount.panel.TransDetailPanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.datasource.DSEmployeeBorrowMoneyByWorkflow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeBorrowMoneyByWorkflowNewForm extends AbstractWizadPage
{

	private final Logger __logger = Logger.getLogger("");
	private final ComboBoxItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;
	private final SpinnerItem borrowMoneyItem;
	private final DateItem borrowDateItem;
	private final DateItem anticipatedDateItem;
	private final TextAreaItem reasonItem;
	private final SelectItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem titleNameItem;
	private final ComboBoxItem companyIdItem;
	private final SelectItem currencyItem;
	/*private final DoubleItem projectIntegralItem;
	private final DoubleItem costIntegralItem;
	private final DoubleItem leftIntegralItem;
	private final ComboBoxItem projectItem;*/
	private Label view;
	private Label checkView;
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	String groupBorderCSS = "1px solid grey";
	private final ButtonItem payseqIButItem;
	private ButtonItem uploadItem;
	private  LinkItem attachmentItem;
	private Integer accountId = null;

	public EmployeeBorrowMoneyByWorkflowNewForm() {
		DSEmployeeBorrowMoneyByWorkflow ds = DSEmployeeBorrowMoneyByWorkflow.getInstance();
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
//		__form.setIsGroup(true);
//		__form.setGroupBorderCSS(groupBorderCSS);
//		__form.setGroupLabelStyleName("groupTitleStyle");
		__form.setWidth100();
		__form.setHeight("90%");
		__form.setPadding(1);
		__form.setMargin(1);
		
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(0);
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				loadCustomData();
			}
		});
		__formItems.add(companyIdItem);
		
		borrowDateItem = new DateItem("borrowDate", "借款日期");
		borrowDateItem.setDisabled(true);
		borrowDateItem.setUseTextField(true);  
		borrowDateItem.setUseMask(true);
		borrowDateItem.setWidth("*");
		borrowDateItem.setDefaultValue(new Date());
		__formItems.add(borrowDateItem);
		
		borrowMoneyItem = new SpinnerItem("borrowMoney", "借款金额");
		borrowMoneyItem.setWidth("*");
		borrowMoneyItem.setMin(50);  
		borrowMoneyItem.setStep(500f);  
		borrowMoneyItem.setWriteStackedIcons(false);
		borrowMoneyItem.setDefaultValue(100);
		__formItems.add(borrowMoneyItem);
		
		currencyItem = new SelectItem("currency", "货币种类");
		currencyItem.setWidth("*");
		currencyItem.setDefaultValue(0);
		currencyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyItem);
		
		anticipatedDateItem = new DateItem("anticipatedDate", "预计还款日期");
		anticipatedDateItem.setWidth("*");
		anticipatedDateItem.setUseTextField(true);  
		anticipatedDateItem.setUseMask(true);
		anticipatedDateItem.setDefaultValue(new Date());
		__formItems.add(anticipatedDateItem);
		
		
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
	  
	    __formItems.add(projectItem);
		
	    projectIntegralItem=new DoubleItem("projectIntegral","项目积分");  
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
	    __formItems.add( leftIntegralItem); */
	    
	    
	    payseqIButItem=new ButtonItem("预算付款序列");
		payseqIButItem.setStartRow(true);
		payseqIButItem.hide();
		payseqIButItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
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
		
		
		attachmentItem = new LinkItem("attachment");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		__formItems.add(attachmentItem);
		
		uploadItem = new ButtonItem("附件上传");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.setColSpan(1);
		uploadItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				CommonUploadWindow contractForm = new CommonUploadWindow("借款相关文件上传",false, null, 2, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						if(!BaseHelpUtils.isNullOrEmpty(data)){
							for(String key : data.keySet()){
								//获取文件Id和文件名称
								int fId = BaseHelpUtils.getIntValue(data.get(key).getAttribute("fileId"));
								String fileName = BaseHelpUtils.getString(data.get(key).getAttribute("fileName"));
								attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
								attachmentItem.setLinkTitle(fileName);
								setFileId(fId);
								break;
							}
						}
					}
				});
				contractForm.centerInPage();
				contractForm.show();
			}
		});
		__formItems.add(uploadItem);
		
		reasonItem = new TextAreaItem("reason", "借款事由");
		reasonItem.setColSpan(4);
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);
		
		titleNameItem = new TextItem("titleName", "主题名称");
		titleNameItem.hide();
		titleNameItem.setWidth("*");
		__formItems.add(titleNameItem);
		
		operateEmployeeIdItem = new SelectItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.hide();
		operateEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.setDefaultValue(new Date());
		operateTimeItem.hide();
		__formItems.add(operateTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		__form.setBackgroundColor("#f2f2f2");
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		
		HLayout viewLayout = new HLayout();
		viewLayout.setWidth100();
		viewLayout.setHeight("10%");
		viewLayout.setBackgroundColor("#f2f2f2");
		
		
		view = new Label();
		view.setWidth("35%");
		view.setHeight100();
		view.setAlign(Alignment.LEFT);
		view.addStyleName("groupTitleStyle");
		
		checkView = new Label();
		checkView.setContents("查看账单明细？点击我哟");
		checkView.setWidth("65%");
		checkView.setHeight100();
		checkView.setAlign(Alignment.LEFT);
		checkView.addStyleName("groupTitleStyleClick");
		checkView.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(null == accountId || null == companyIdItem.getValue()) {
					return;
				}
				PopupWindow window = new PopupWindow("账单明细");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				TransDetailPanel panel = new TransDetailPanel();
				panel.setAccountId(accountId.toString());
				panel.setCompanyId(companyIdItem.getValue().toString());
				panel.commonQuery();
				window.addMember(panel);
				window.show();
			}
		});
		
		viewLayout.addMember(view);
		viewLayout.addMember(checkView);
		
		vLayout.addMember(viewLayout);
		vLayout.addMember(__form);
		addMember(vLayout);
	}
	
	public void loadCustomData() {
		if(BaseHelpUtils.isNullOrEmpty(companyIdItem.getValue())) {
			return;
		}
		//加载当前申请人欠款数
		Map param = new HashMap();
		param.put("employeeId", ClientUtil.getEmployeeId());
		param.put("companyId", companyIdItem.getValue());
		param.put("optType", "onGetEmployeeBorrowMoney");
		DBDataSource.callOperation("EP_OnWrokflowProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(null == records || records.length == 0) {
						return;
					}
					Record r = records[0];
					//获取人员借款额度
					double borrowLimit = BaseHelpUtils.getDoubleValue(r.getAttribute("borrowLimit"));
					//获取人员借款当前欠款金额
					double borrowMoneyTotal = BaseHelpUtils.getDoubleValue(r.getAttribute("standardDebit"));
					//可借款金额
//					BigDecimal canBorrowMoneyValue = BigDecimal.valueOf(borrowLimit).subtract(BigDecimal.valueOf(borrowMoneyTotal));
//					setCanBorrowMoney(canBorrowMoneyValue);
					view.setContents("您的借款额度:"+borrowLimit+" 当前欠款:"+borrowMoneyTotal);
					int id = BaseHelpUtils.getIntValue(r.getAttribute("financialTransactionAccountId"));
					if(id == 0) {
						accountId = null;
					}else {
						accountId = id;
					}
				} else {
					view.setContents("");
					accountId = null;
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		if(null == reasonItem.getValue()){
			SC.say("请填写借款事由");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
		/*projectIntegralItem.hide();
		costIntegralItem.hide(); 
		leftIntegralItem.hide();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", ClientUtil.getEmployeeId());
		map.put("optType", "getProjectName");
		DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
						for (Record obj : record) {
							projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
					}
					projectItem.setValueMap(projectMap);
				}
			}
		});
		projectItem.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(final KeyPressEvent event) {
				if (event.getKeyName().equals("Enter")) {
					final String value = projectItem.getValueAsString();
					Map<String, Object> map = new HashMap<>();
					map.put("projectName", value);
					DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] record = dsResponse.getData();
									for (Record obj : record) {
										projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
								}
								projectItem.setValueMap(projectMap);
							} else {
								SC.say("没有找到与关键字：【" + value + "】相匹配的项目");
							}
							event.cancel();
						}
					});
				}
				
			}
		});*/
		loadBudgetDate();
		loadCustomData();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeBorrowMoneyByWorkflow.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		Map<Object,Object> param = __form.getValues();
		if(!BaseHelpUtils.isNullOrEmpty(fileId)) {
			param.put("fileId", fileId);
		}
		param.put("canBorrowMoney", getCanBorrowMoney());
		//获取职员部门、职员名称、流程名称、金额设置主题名称的值
		int departmentId = BaseHelpUtils.getIntValue(departmentIdItem.getValue());
		int employeeId = BaseHelpUtils.getIntValue(employeeIdItem.getValue());
		//获取金额
		String amount = BaseHelpUtils.getString(param.get("borrowMoney"));
		String titleName = PomPlatformClientUtil.getReimbursementTittle(departmentId, employeeId, "", amount, null);
		param.put("titleName", titleName);
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

		Integer employeeFundIssuanceId = getEmployeeFundIssuanceId();
		if (null != employeeFundIssuanceId && employeeFundIssuanceId != 0) {
			SC.debugger();
			param.put("employeeFundIssuanceId", employeeFundIssuanceId);
		}
		return param;
	}

	private Integer employeeFundIssuanceId;

	public Integer getEmployeeFundIssuanceId() {
		return employeeFundIssuanceId;
	}

	public void setEmployeeFundIssuanceId(Integer employeeFundIssuanceId) {
		this.employeeFundIssuanceId = employeeFundIssuanceId;
	}

	private BigDecimal canBorrowMoney = BigDecimal.ZERO;

	public BigDecimal getCanBorrowMoney() {
		return canBorrowMoney;
	}

	public void setCanBorrowMoney(BigDecimal canBorrowMoney) {
		this.canBorrowMoney = canBorrowMoney;
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
			BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(budgetRecord.getAttribute("payAmount"));
			borrowMoneyItem.setValue(payAmount);
			//获取项目ID
			/*int projectIds=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("projectId"));
			String projectId=BaseHelpUtils.getString(projectIds);
			String value = KeyValueManager.getValue("projects", projectId);
			Map<String, Object> map = new HashMap<>();
			map.put("projectName", value);
			DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] record = dsResponse.getData();
						projectMap.clear();
						for (Record obj : record) {
							projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
						}
						projectItem.setValueMap(projectMap);
						projectItem.setValue(projectIds);
					}
				}
			});

			if(projectIds>0) {
				Map<String, Object> maps = new HashMap<>();
				maps.put("projectId",projectIds);
				DBDataSource.callOperation("NQ_PayMoneyProject",maps, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						//projectItem.setValueMap(KeyValueManager.getValueMap("projects"));
						//						String projectIds=BaseHelpUtils.getString(projectId);
						//						projectItem.setValue(projectIds);
						projectIntegralItem.show();
						costIntegralItem.show(); 
						leftIntegralItem.show();
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
			}*/

		}
	}
	
	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

}
