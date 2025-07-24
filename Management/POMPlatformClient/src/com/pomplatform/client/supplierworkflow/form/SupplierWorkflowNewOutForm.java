package com.pomplatform.client.supplierworkflow.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.user.client.Window;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierComeIn;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SupplierWorkflowNewOutForm extends AbstractWizadPage
{

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private final TextItem supplierNameItem;
	private final SelectItem supplierTypeItem;
	private final TextItem supplierAddressItem;
	private final TextItem supplierContactItem;
	private final TextItem supplierPhoneItem;
	private final TextItem supplierEmailItem;
	private final TextItem teamSizeItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentItem;
	private ButtonItem uploadItem;
	private DateTimeItem operateTimeItem;
	private VLayout mainLayout;
	private HLayout topLayout;
	private final SelectItem areasExpertiseItem;
	private DelicacyListGrid detailGrid;
	private DelicacyListGrid coopGrid;
	private IButton  addBut;
	private IButton  adBut;
	private VLayout butrLayout;
	private VLayout butlLayout;
	private SupplierWorkflowNewAddReceiveFrom mainInfoPage;

	public SupplierWorkflowNewOutForm() {
		DSSupplierComeIn ds = DSSupplierComeIn.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		mainLayout=new VLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();


		topLayout=new HLayout(10);
		topLayout.setMargin(3);
		topLayout.setWidth("100%");
		topLayout.setHeight100();
		supplierNameItem=new TextItem("supplierName",shouldNotBeNull+"供应商名称");
		supplierNameItem.setRequired(true);
		supplierNameItem.setWidth("*");
		supplierNameItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				String value=BaseHelpUtils.getString(event.getValue());
				SupplierWorkflowNewAddReceiveFrom nextPanel = getMainInfoPage();
				nextPanel.findNamedItem("receiveUnit").setValue(value);
			}
		});
		__formItems.add(supplierNameItem);
		
		Map<String,Object> map=new HashMap<>();
		map.put("optType", "supplieTypeInfo");
		LinkedHashMap<Integer, String> userData =SyncDataUtil.getValues("EP_GetSupplierInfo", "find", map);
		supplierTypeItem=new SelectItem("supplierType",shouldNotBeNull+"供应商类型");
		supplierTypeItem.setWidth("*");
		supplierTypeItem.setValueMap(userData);
		__formItems.add(supplierTypeItem);
		

		supplierAddressItem=new TextItem("supplierAddress",shouldNotBeNull+"供应商地址");
		supplierAddressItem.setRequired(true);
		supplierAddressItem.setWidth("*");
		supplierAddressItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				String value=BaseHelpUtils.getString(event.getValue());
				SupplierWorkflowNewAddReceiveFrom nextPanel = getMainInfoPage();
				nextPanel.findNamedItem("receiveUnitAddress").setValue(value);
			}
		});
		__formItems.add(supplierAddressItem);

		supplierContactItem=new TextItem("supplierContact",shouldNotBeNull+"主要负责人");
		supplierContactItem.setRequired(true);
		supplierContactItem.setWidth("*");
		__formItems.add(supplierContactItem);


		supplierPhoneItem=new TextItem("supplierPhone",shouldNotBeNull+"联系电话");
		supplierPhoneItem.setRequired(true);
		supplierPhoneItem.setWidth("*");
		__formItems.add(supplierPhoneItem);

		supplierEmailItem=new TextItem("supplierEmail","邮箱");
		supplierEmailItem.setWidth("*");
		__formItems.add(supplierEmailItem);

		teamSizeItem=new TextItem("teamSize",shouldNotBeNull+"团队规模");
		teamSizeItem.setWidth("*");
		__formItems.add(teamSizeItem);

		areasExpertiseItem=new SelectItem("areasExpertise",shouldNotBeNull+"擅长领域");
		areasExpertiseItem.setRequired(true);
		KeyValueManager.loadValueMap("system_dictionary_213", areasExpertiseItem);
		areasExpertiseItem.setWidth("*");
		__formItems.add(areasExpertiseItem);
		
		operateTimeItem=new DateTimeItem("operateTime",shouldNotBeNull+"操作时间");
		//operateTimeItem.setStartRow(false);
		operateTimeItem.setRequired(true);
		operateTimeItem.setDefaultValue(new Date());
		operateTimeItem.setDisabled(true);
		operateTimeItem.setWidth("*");
		__formItems.add(operateTimeItem);

		attachmentNameItem=new TextItem("attachmentName","附件名称");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setHint("附件一般为预审文件");
		attachmentNameItem.setShowHintInField(true);
		attachmentNameItem.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(attachmentItem.getValue())){
					Window.open(attachmentItem.getValue().toString(), "查看附件", "");
				}				
			}
		});
		__formItems.add(attachmentNameItem);
		
		attachmentItem=new TextItem("attachment","附件路径");
		attachmentItem.setWidth("*");
		attachmentItem.hide();
		__formItems.add(attachmentItem);

		uploadItem = new ButtonItem("附件上传");
		uploadItem.setStartRow(false);
		uploadItem.setColSpan(2);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				CommonUploadWindow contractForm = new CommonUploadWindow("供应商相关文件上传",false, null, null, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						if(!BaseHelpUtils.isNullOrEmpty(data)){
							for(String key : data.keySet()){
								//获取文件Id和文件名称
								int fId = BaseHelpUtils.getIntValue(data.get(key).getAttribute("fileId"));
								String fileName = BaseHelpUtils.getString(data.get(key).getAttribute("fileName"));
								attachmentNameItem.setValue(fileName);
								attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
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
		
		

		detailGrid = new DelicacyListGrid();
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("supplierDetailId","供应商详情ID");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("supplierId","供应商ID");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("projectName","项目名称");
		fields[idx].setCanEdit(true);
		fields[idx].setAlign(Alignment.CENTER);
		idx ++;
		fields[idx] = new ListGridField("projectAddress","项目地址");
		fields[idx].setCanEdit(true);
		fields[idx].setAlign(Alignment.CENTER);
		idx ++;
		fields[idx] = new ListGridField("supplierDuty","主要负责内容");
		fields[idx].setCanEdit(true);
		fields[idx].setAlign(Alignment.CENTER);
		detailGrid.setFields(fields);
		detailGrid.setAutoFitFieldWidths(false);
		detailGrid.setSelectionType(SelectionStyle.SINGLE);
		detailGrid.setHeight100();
		detailGrid.setWidth("20%");
		detailGrid.setCanRemoveRecords(true);
		detailGrid.setHeaderHeight(60);
		detailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"供应商详情", new String[] {"supplierDetailId","supplierId","projectName","projectAddress","supplierDuty"}));
		topLayout.addMember(detailGrid);

		
		butrLayout=new VLayout(5);
		butrLayout.setHeight100();
		butrLayout.setWidth("2%");
		butrLayout.setMembersMargin(5);
		butrLayout.setAlign(Alignment.LEFT);
		topLayout.addMember(butrLayout);
		
		addBut=new IButton("新增");
		addBut.setWidth("80%");
		addBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				detailGrid.startEditingNew();
			}
		});
		butrLayout.addMember(addBut);
		
		coopGrid= new DelicacyListGrid();
		ListGridField[] field = new ListGridField[5];
		int id = 0;
		field[id] = new ListGridField("supplierCooperationiId");
		field[id].setCanEdit(false);
		field[id].setHidden(true);
		id ++;
		field[id] = new ListGridField("supplierId");
		field[id].setCanEdit(false);
		field[id].setHidden(true);
		id ++;
		field[id] = new ListGridField("projectName","合作的项目名称");
		field[id].setCanEdit(true);
		field[id].setWidth("25%");
		field[id].setAutoFitWidth(false);
		field[id].setAlign(Alignment.CENTER);
		id ++;
		field[id] = new ListGridField("projectLeader","J&A负责人");
		ComboBoxItem employeeItem = new ComboBoxItem();
		employeeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		field[id].setEditorProperties(employeeItem);
		KeyValueManager.loadValueMap("employees", field[id]);
		field[id].setCanEdit(true);
		field[id].setWidth("20%");
		field[id].setAlign(Alignment.CENTER);
		id ++;
		field[id] = new ListGridField("supplierEvaluate","供应商评价");
		field[id].setAlign(Alignment.CENTER);
		field[id].setCanEdit(true);
		field[id].setWidth("35%");
		//field[id].setAutoFitWidth(true);
		coopGrid.setFields(field);
		coopGrid.setAutoFitFieldWidths(false);
		coopGrid.setSelectionType(SelectionStyle.SINGLE);
		coopGrid.setCanRemoveRecords(true);
		coopGrid.setHeight100();
		coopGrid.setWidth("20%");
		coopGrid.setHeaderHeight(60);
		coopGrid.setHeaderSpans(new HeaderSpan("与JA合作过的项目", new String[] {"supplierCooperationiId","supplierId","projectName","projectLeader","supplierEvaluate"}));
		topLayout.addMember(coopGrid);

		
		butlLayout=new VLayout(5);
		butlLayout.setHeight100();
		butlLayout.setWidth("2%");
		butlLayout.setMembersMargin(5);
		butlLayout.setAlign(Alignment.LEFT);
		topLayout.addMember(butlLayout);
		
		
		adBut=new IButton("新增");
		adBut.setWidth("80%");
		adBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				coopGrid.startEditingNew();
			}
		});
		butlLayout.addMember(adBut);


		__form.setItems(getFormItemArray());
		__form.setNumCols(10);
		__form.setHeight("30%");
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		attachmentNameItem.setColSpan(3);
		mainLayout.addMember(__form);
		mainLayout.addMember(topLayout);
		addMember(mainLayout);

	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}else if(detailGrid.getRecords().length==0) {
			SC.say("供应商详情不能为空");
			return false;
		}else {
		return true;
		}
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();


	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSupplierComeIn.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object>  valueMap=__form.getValues();
		if(fileId>0) {
			valueMap.put("fileId", fileId);
		}
		MapUtils.convertRecordToMap(detailGrid,detailGrid.getRecords(),valueMap,"detailSupplierDetail");
		if(coopGrid.getRecords().length>0) {
			MapUtils.convertRecordToMap(coopGrid,coopGrid.getRecords(),valueMap,"detailSupplierCooperation");
		}
		return valueMap;
	}

	private int fileId=0;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public SupplierWorkflowNewAddReceiveFrom getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(SupplierWorkflowNewAddReceiveFrom mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

}
