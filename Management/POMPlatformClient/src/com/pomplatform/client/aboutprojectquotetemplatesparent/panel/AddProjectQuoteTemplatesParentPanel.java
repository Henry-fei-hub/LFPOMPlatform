package com.pomplatform.client.aboutprojectquotetemplatesparent.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddProjectQuoteTemplatesParentPanel  extends VLayout implements HasHandlers{
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private TextItem parentNameItem;
	private SelectItem businessTypeItem;
	private SelectItem companyIdItem;
	private TextItem createEmployeeIdItem;
	private DateTimeItem createDateItem;
	private TextAreaItem remarkItem;
	private  DynamicForm form;
	private HLayout formLayout;
	private HLayout buttonLayout;
	private IButton addBut;
	private IButton quitBut;

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	public void initComponents() {
		formLayout = new HLayout();
		formLayout.setHeight100();
		formLayout.setMargin(30);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		parentNameItem=new TextItem("parentName",shouldNotBeNull+"模板名称");
		parentNameItem.setRequired(true);
		parentNameItem.setWidth("*");

		businessTypeItem=new SelectItem("businessType",shouldNotBeNull+"业务类别");
		businessTypeItem.setRequired(true);
		KeyValueManager.loadValueMap("pre_business_type", businessTypeItem);
		businessTypeItem.setWidth("*");

		companyIdItem=new SelectItem("companyId",shouldNotBeNull+"归属公司");
		companyIdItem.setRequired(true);
		KeyValueManager.loadValueMap("company_records", companyIdItem);
		companyIdItem.setWidth("*");

		createEmployeeIdItem=new TextItem("createEmployeeId",shouldNotBeNull+"创建人");
		createEmployeeIdItem.setRequired(true);
		createEmployeeIdItem.setDisabled(true);
		createEmployeeIdItem.setDefaultValue(ClientUtil.getUserId());
		KeyValueManager.loadValueMap("employees", createEmployeeIdItem);
		createEmployeeIdItem.setWidth("*");

		createDateItem=new DateTimeItem("createDate",shouldNotBeNull+"创建时间");
		createDateItem.setRequired(true);
		createDateItem.setDisabled(true);
		createDateItem.setDefaultValue(new Date());
		createDateItem.setWidth("*");

		remarkItem=new TextAreaItem("remark",shouldNotBeNull+"备注");
		remarkItem.setRequired(true);
		remarkItem.setColSpan(6);
		remarkItem.setLength(120);
		remarkItem.setWidth("*");

		form = new DynamicForm();
		//ClientUtil.DynamicFormProcessAccordingToDevice(form);
		form.setCellPadding(6);
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(3);
		form.setWidth100();
		form.setHeight100();
		form.setItems(parentNameItem,businessTypeItem,companyIdItem,createEmployeeIdItem,createDateItem,remarkItem);

		formLayout.addMember(form);

		buttonLayout = new HLayout();
		buttonLayout.setHeight("40%");
		buttonLayout.setMargin(30);
		buttonLayout.setWidth100();
		buttonLayout.setMembersMargin(30);
		buttonLayout.setAlign(Alignment.CENTER);
		addMember(buttonLayout);


		addBut = new IButton("保存");
		addBut.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(form.validate()) {
					Record reocrd=form.getValuesAsRecord();
					Map<String,Object> map=reocrd.toMap();
					DBDataSource.callOperation("ST_ProjectQuoteTemplatesParent", "save", map, new DSCallback(){
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
								addBut.setDisabled(true);
								if (getParentWindow() == null) {
									return;
								}
								getParentWindow().destroy();
								DataEditEvent dee = new DataEditEvent();
								fireEvent(dee);
								SC.say("新增成功!");
							}
						}
					});



				}else {
					SC.say("请按照系统提示输入信息！");
				}

			}
		});
		buttonLayout.addMember(addBut);

		quitBut = new IButton("关闭");
		quitBut.addClickHandler(new ClickHandler() {

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
		buttonLayout.addMember(quitBut);


	}

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




}
