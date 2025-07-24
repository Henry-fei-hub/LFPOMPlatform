package com.pomplatform.client.budgetmanagement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.net.ssl.KeyManager;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BudetUpdateUploadPanel extends HLayout implements HasHandlers {
	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem uploadEmployeeItem;
	private ComboBoxItem departmentIdItem;
	private DateTimeItem uploadTimeItem;
	private TextItem attachmentNameItem;
	private DoubleItem  budgetContractAmountItem;
	private ComboBoxItem receiveUnitManageIdItem; 
	private ComboBoxItem bddTypeItem;
	private DoubleItem  bddAmountItem;
	private DoubleItem bdTotalAmountItem;
	private DoubleItem bdRestAmountItem;
	private DoubleItem budgetContractAmountUseItem;
	private DoubleItem budgetContractAmountRestItem;
	private BigDecimal oriBudgetContractAmount;


	private ButtonItem uploadItem;
	private TextAreaItem remarkItem;
	private IButton uploadOkBtn;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public void initComponents() {
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight100();
		formLayout.setMembersMargin(5);
		formLayout.setWidth("90%");
		formLayout.setAlign(Alignment.RIGHT);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("80%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();



		uploadEmployeeItem = new ComboBoxItem("uploadEmployeeId", "上传人员"); 
		uploadEmployeeItem.setChangeOnKeypress(false);
		uploadEmployeeItem.setValueMap(KeyValueManager.getValueMap("employees"));
		uploadEmployeeItem.setWidth("*");
		uploadEmployeeItem.setCanEdit(true);
		uploadEmployeeItem.setDisabled(false);
		uploadEmployeeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int employeeId=BaseHelpUtils.getIntValue(event.getValue());
				Map<String,Object> params=new HashMap<>();
				params.put("employeeId", employeeId);
				DBDataSource.callOperation("ST_Employee","find",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] resultData = dsResponse.getData();
							for (Record record : resultData) {
								departmentIdItem.setValue(record.getAttributeAsInt("departmentId"));
							}

						} else {
							SC.say("找不到该人员所在的部门！" );
						}
					}
				});		
			}
		});




		departmentIdItem = new ComboBoxItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setChangeOnKeypress(false);
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(false);
		departmentIdItem.setCanEdit(true);



		uploadTimeItem=new DateTimeItem("uploadTime","上传时间");
		uploadTimeItem.setRequired(true);
		uploadTimeItem.setDefaultValue(new Date());
		uploadTimeItem.setCanEdit(false);
		uploadTimeItem.setDisabled(true);
		uploadTimeItem.setWidth("*");

		bdTotalAmountItem=new DoubleItem("bdTotalAmount","预算单总金额");
		bdTotalAmountItem.setFormat("#,###,###,###,###,##0.00");
		bdTotalAmountItem.setWidth("*");
		bdTotalAmountItem.setCanEdit(false);
		bdTotalAmountItem.setDisabled(true);
		bdTotalAmountItem.setTextBoxStyle("customInputTextStyle");

		bdRestAmountItem=new DoubleItem("bdRestAmount","预算单剩余金额");
		bdRestAmountItem.setFormat("#,###,###,###,###,##0.00");
		bdRestAmountItem.setWidth("*");
		bdRestAmountItem.setCanEdit(false);
		bdRestAmountItem.setDisabled(true);
		bdRestAmountItem.setTextBoxStyle("customInputTextStyle");

		budgetContractAmountItem=new DoubleItem("budgetContractAmount","合同预算金额");   
		budgetContractAmountItem.setWidth("*");
		budgetContractAmountItem.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				//获取合同已付金额
				BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(budgetContractAmountUseItem.getValue());
				//获取合同预算金额
				BigDecimal budgetContractAmount=BaseHelpUtils.getBigDecimalValue(event.getValue());
				//获取合同剩余金额
				BigDecimal budgetContractAmountRest=budgetContractAmount.subtract(budgetContractAmountUse);
				budgetContractAmountRestItem.setValue(budgetContractAmountRest);
			}
		});

		budgetContractAmountUseItem=new DoubleItem("budgetContractAmountUse","合同已付金额");   
		budgetContractAmountUseItem.setWidth("*");
		budgetContractAmountUseItem.setCanEdit(false);
		budgetContractAmountUseItem.setDisabled(true);
		budgetContractAmountUseItem.setFormat("#,###,###,###,###,##0.00");

		budgetContractAmountRestItem=new DoubleItem("budgetContractAmountRest","合同剩余金额");   
		budgetContractAmountRestItem.setWidth("*");
		budgetContractAmountRestItem.setCanEdit(false);
		budgetContractAmountRestItem.setDisabled(true);
		budgetContractAmountRestItem.setFormat("#,###,###,###,###,##0.00");


		receiveUnitManageIdItem=new ComboBoxItem("receiveUnitManageId","供应商");
		//KeyValueManager.loadValueMap("receive_unit_manages_company",receiveUnitManageIdItem);
		Map<String,Object> map=new HashMap<>();
		Record[] receiveRecord=SyncDataUtil.getValueByTableNames("ST_ReceiveUnitManage", "find", map);
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		for (Record record : receiveRecord) {
			int receiveUnitManageId=BaseHelpUtils.getIntValue(record.getAttribute("receiveUnitManageId"));
			String receiveUnit=BaseHelpUtils.getString(record.getAttribute("receiveUnit"));
			linkMap.put(receiveUnitManageId, receiveUnit);
		}
		receiveUnitManageIdItem.setValueMap(linkMap);
		receiveUnitManageIdItem.setChangeOnKeypress(false);
		receiveUnitManageIdItem.setWidth("*");


		attachmentNameItem = new TextItem("attachmentName", shouldNotBeNull + "文件名称");
		attachmentNameItem.setWidth("*");

		uploadItem = new ButtonItem("选择附件上传");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.setColSpan(1);
		uploadItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				CommonUploadWindow contractForm = new CommonUploadWindow("预算相关文件上传",false, null, null, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						if(!BaseHelpUtils.isNullOrEmpty(data)){
							for(String key : data.keySet()){
								//获取文件Id和文件名称
								int fId = BaseHelpUtils.getIntValue(data.get(key).getAttribute("fileId"));
								String fileName = BaseHelpUtils.getString(data.get(key).getAttribute("fileName"));
								attachmentNameItem.setValue(fileName);
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

		bddTypeItem=new ComboBoxItem("bddType","预算类别");
		bddTypeItem.setWidth("*");
		bddTypeItem.setChangeOnKeypress(false);
		bddTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				//获取预算类别
				String bddType=BaseHelpUtils.getString(event.getValue());
				//获取预算管理ID
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				if(bddType.length()>0&budgetManagementId>0) {
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("budgetManagementId", budgetManagementId);
					map.put("bddType", bddType);
					DBDataSource.callOperation("ST_BudgetManagementDetail","find",map,new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus()>=0) {
								//预算类别金额
								BigDecimal bddAmount=BigDecimal.ZERO;
								Record[] records=dsResponse.getData();
								for (Record record : records) {
									bddAmount=bddAmount.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("bddAmount")));
								}
								bddAmountItem.setValue(bddAmount);
							}
						}
					});
				}

			}
		});


		bddAmountItem=new DoubleItem("bddAmount","预算类别金额");
		bddAmountItem.setCanEdit(false);
		bddAmountItem.setDisabled(true);
		bddAmountItem.setFormat("#,###,###,###,###,##0.00");
		bddAmountItem.setWidth("*");

		remarkItem = new TextAreaItem("uploadRemark", "上传备注"); 
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");

		form.setItems(uploadEmployeeItem, departmentIdItem,uploadTimeItem,bdTotalAmountItem,bdRestAmountItem,bddTypeItem,bddAmountItem,budgetContractAmountItem,budgetContractAmountUseItem,budgetContractAmountRestItem,receiveUnitManageIdItem,attachmentNameItem,uploadItem,remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		//budgetContractAmountItem.setColSpan(3);
		//receiveUnitManageIdItem.setColSpan(3);
		bddTypeItem.setColSpan(3);
		bddAmountItem.setColSpan(3);
		bdTotalAmountItem.setColSpan(3);
		bdRestAmountItem.setColSpan(3);

		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);


		uploadOkBtn = new IButton("更新上传");
		uploadOkBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> params = new HashMap<>();
				//获取文件名称
				String attachmentName = BaseHelpUtils.getString(attachmentNameItem.getValue());
				/*if(BaseHelpUtils.isNullOrEmpty(attachmentName)){
					SC.say("提示","文件名称不可为空");
					return;
				}*/
				//获取供应商ID
				int receiveUnitManageId=BaseHelpUtils.getIntValue(receiveUnitManageIdItem.getValue());
				//获取预算类别金额
				BigDecimal bddAmount=BaseHelpUtils.getBigDecimalValue(bddAmountItem.getValue());
				//获取合同预算金额
				BigDecimal budgetContractAmount=BaseHelpUtils.getBigDecimalValue(budgetContractAmountItem.getValue());
				//获取预算合同已付金额
				BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(budgetContractAmountUseItem.getValue());
				//获取预算合同剩余金额
				BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(budgetContractAmountRestItem.getValue());
				//获取预算单剩余金额
				BigDecimal bdRestAmount=BaseHelpUtils.getBigDecimalValue(bdRestAmountItem.getValue());
				//获取附件总金额
				BigDecimal totalBudgetContractAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalBudgetContractAmount"));
				//获取预算总金额
				BigDecimal bdTotalAmount=BaseHelpUtils.getBigDecimalValue(bdTotalAmountItem.getValue());
				if(receiveUnitManageId<=0) {
					SC.say("供应商不能为空,若不存在可以添加供应商");
					return;
				}
				/*if(budgetContractAmount.compareTo(bddAmount)>0) {
					SC.say("提示","合同预算金额["+budgetContractAmount+"]不能大于预算类别金额["+bddAmount+"]");
					return;
				}*/
				if((budgetContractAmount.subtract(oriBudgetContractAmount)).compareTo(bdRestAmount)>0) {
					SC.say("提示","合同预算金额["+budgetContractAmount+"]不能大于预算单剩余金额["+bdRestAmount+"]");
					return;
				}
				/*if(budgetContractAmount.compareTo(bdTotalAmount.subtract(totalBudgetContractAmount))>0) {
					SC.say("提示","合同预算金额["+budgetContractAmount+"]不能大于预算总金额，当前可用金额为["+bdTotalAmount.subtract(totalBudgetContractAmount)+"]");
					return;
				}*/
				if(BaseHelpUtils.isNullOrEmpty(attachmentName)){
					SC.ask("提示","没有上传相关附件，确定不上传附件吗？",new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if(value) {
								//获取备注信息
								final String remark =remarkItem.getValueAsString();
								//获取预算金额
								BigDecimal budgetContractAmount=BaseHelpUtils.getBigDecimalValue(budgetContractAmountItem.getValue());
								//获取附件id
								int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
								//获取预算管理id
								int  budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
								//获取预算类别
								String  bddType=BaseHelpUtils.getString(bddTypeItem.getValue());
								//获取项目ID
								int projectId=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
								if(budgetAttachmentId<=0) {
									SC.say("找不到更新附件的主键！");
									return;
								}
								params.put("budgetAttachmentId",budgetAttachmentId);
								params.put("uploadRemark",remark);
								params.put("uploadEmployeeId",ClientUtil.getEmployeeId());
								params.put("budgetManagementId",budgetManagementId);
								params.put("receiveUnitManageId",receiveUnitManageId);
								params.put("budgetContractAmount",budgetContractAmount);
								params.put("budgetContractAmountUse",budgetContractAmountUse);
								params.put("budgetContractAmountRest",budgetContractAmountRest);
								params.put("projectId", projectId);
								params.put("bddType", bddType);
								params.put("optType", "UpdateBudgetUpload");
								uploadOkBtn.setDisabled(false);
								DBDataSource.callOperation("EP_BudetAboutUpload",params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											uploadOkBtn.setDisabled(true);
											if (getParentWindow() == null) {
												return;
											}
											getParentWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											fireEvent(dee);
											SC.say("更新成功!");
										} else {
											SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
										}
									}
								});
							}
						}
					});
					return;
				}
				//获取备注信息
				final String remark =remarkItem.getValueAsString();
				//获取附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				//获取预算管理id
				int  budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				//获取项目ID
				int projectId=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
				//获取预算类别
				String  bddType=BaseHelpUtils.getString(bddTypeItem.getValue());
				if(budgetAttachmentId<=0) {
					SC.say("找不到更新附件的主键！");
					return;
				}
				params.put("budgetAttachmentId",budgetAttachmentId);
				params.put("fileId",fileId);
				params.put("attachmentName",attachmentName);
				params.put("uploadRemark",remark);
				params.put("uploadEmployeeId",ClientUtil.getEmployeeId());
				params.put("budgetManagementId",budgetManagementId);
				params.put("receiveUnitManageId",receiveUnitManageId);
				params.put("budgetContractAmount",budgetContractAmount);
				params.put("budgetContractAmountUse",budgetContractAmountUse);
				params.put("budgetContractAmountRest",budgetContractAmountRest);
				params.put("projectId", projectId);
				params.put("bddType", bddType);
				params.put("optType", "UpdateBudgetUpload");
				uploadOkBtn.setDisabled(false);
				DBDataSource.callOperation("EP_BudetAboutUpload",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							uploadOkBtn.setDisabled(true);
							if (getParentWindow() == null) {
								return;
							}
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
							SC.say("更新成功!");
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
			}
		});

		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(uploadOkBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);

	}

	public void loadDate() {
		//获取附件主键id
		int budgetAttachmentId=record.getAttributeAsInt("budgetAttachmentId");
		Map<String,Object> map=new HashMap<>();
		map.put("budgetAttachmentId", budgetAttachmentId);
		DBDataSource.callOperation("ST_BudgetAttachment","find",map,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0) {
					Record[] records=dsResponse.getData();
					//获取上传人员ID
					int	uploadEmployeeId=0;
					//获取部门id
					int departmentId=0;
					//获取上传时间
					Date uploadTime=new Date();
					//获取供应商
					int receiveUnitManageId=0;
					//获取预算合同金额
					BigDecimal  budgetContractAmount=BigDecimal.ZERO;
					//获取预算合同已付金额
					BigDecimal budgetContractAmountUse=BigDecimal.ZERO;
					//获取预算合同剩余金额
					BigDecimal budgetContractAmountRest=BigDecimal.ZERO;
					//获取附件名称
					String attachmentName="";
					//获取备注
					String remark="";
					//获取预算类别
					String bddType=BaseHelpUtils.getString(record.getAttribute("bddType"));
					for (Record record : records) {
						uploadEmployeeId=record.getAttributeAsInt("uploadEmployeeId");
						departmentId=record.getAttributeAsInt("departmentId");
						uploadTime=record.getAttributeAsDate("uploadTime");
						budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmountUse"));
						budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmountRest"));
						receiveUnitManageId=record.getAttributeAsInt("receiveUnitManageId");
						budgetContractAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmount"));
						attachmentName=record.getAttributeAsString("attachmentName");
						remark=record.getAttributeAsString("uploadRemark");
						fileId=BaseHelpUtils.getIntValue(record.getAttribute("fileId"));
					}
					uploadEmployeeItem.setValue(uploadEmployeeId);
					departmentIdItem.setValue(departmentId);
					uploadTimeItem.setValue(uploadTime);
					receiveUnitManageIdItem.setValue(receiveUnitManageId);
					budgetContractAmountItem.setValue(budgetContractAmount);
					oriBudgetContractAmount = budgetContractAmount;
					budgetContractAmountUseItem.setValue(budgetContractAmountUse);
					budgetContractAmountRestItem.setValue(budgetContractAmountRest);
					attachmentNameItem.setValue(attachmentName);
					remarkItem.setValue(remark);
					bddTypeItem.setValue(bddType);
					if(bddType.length()>0) {
						//获取预算管理ID
						int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
						if(bddType.length()>0&budgetManagementId>0) {
							Map<String,Object> map=new HashMap<String,Object>();
							map.put("budgetManagementId", budgetManagementId);
							map.put("bddType", bddType);
							DBDataSource.callOperation("ST_BudgetManagementDetail","find",map,new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus()>=0) {
										//预算类别金额
										BigDecimal bddAmount=BigDecimal.ZERO;
										Record[] records=dsResponse.getData();
										for (Record record : records) {
											bddAmount=bddAmount.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("bddAmount")));
										}
										bddAmountItem.setValue(bddAmount);
									}
								}
							});
						}
					}
				}
			}
		});
		//获取预算管理ID
		int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("budgetManagementId", budgetManagementId);
		DBDataSource.callOperation("ST_BudgetManagement","find",maps, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0) {
					Record record=dsResponse.getData()[0];
					if(record!=null) {
						//获取预算单总金额
						BigDecimal bdTotalAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("bdTotalAmount"));
						//获取预算剩余金额
						BigDecimal bdRestAmount=bdTotalAmount.subtract(BaseHelpUtils.getBigDecimalValue(getRecord().getAttribute("totalBudgetContractAmount")));
						bdTotalAmountItem.setValue(bdTotalAmount);
						bdRestAmountItem.setValue(bdRestAmount);
					}

				}

			}
		});
		
		DBDataSource.callOperation("ST_BudgetManagementDetail","find",maps, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0) {
					LinkedHashMap<String, String> linkMap=new LinkedHashMap<String, String>();
					Record[]  records=dsResponse.getData();
					for (Record record : records) {
						String bddType=BaseHelpUtils.getString(record.getAttribute("bddType"));
						linkMap.put(bddType, bddType);
					}
					bddTypeItem.setValueMap(linkMap);
				}

			}
		});

	}

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}


}
