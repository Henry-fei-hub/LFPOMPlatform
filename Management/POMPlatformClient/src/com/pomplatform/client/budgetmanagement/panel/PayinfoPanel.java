package com.pomplatform.client.budgetmanagement.panel;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import java.util.logging.Logger;

import javax.management.Query;
import javax.net.ssl.KeyManager;

import org.moxieapps.gwt.highcharts.client.AxisTitle.Align;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.docs.ComponentBinding;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PayinfoPanel extends VLayout implements HasHandlers{
	private  DynamicForm  searchForm;
	private VLayout mainLayout;
	private HLayout topLayout;
	private HLayout middleLayout;
	private HLayout bottomButtonLayout;
	private VLayout middleRightButtonLaout;
	private SelectItem payforTypeItem;
	private DoubleItem  bdTotalAmountItem;
	private DateTimeItem  bdApplyTimeItem;
	private DateTimeItem  bdEstimatecloseTimeItem;
	private TextAreaItem  remarkItem;
	private ComboBoxItem  bdApplyEmployeeIdItem;
	private  ComboBoxItem projectItem;
	private DelicacyListGrid bdDetailGrid;
	private IButton addButton;
	private IButton saveButton;
	private IButton quitButton;

	private static Logger __logger = Logger.getLogger("");
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public void initCompnts() {
		setPadding(5);
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		topLayout=new HLayout();
		topLayout.setWidth100();
		topLayout.setMargin(10);
		topLayout.setAlign(Alignment.CENTER);
		topLayout.setHeight("10%");
		mainLayout.addMember(topLayout);

		payforTypeItem=new SelectItem("bdType",shouldNotBeNull+"收款类型");
		payforTypeItem.setValueMap("个人","非个人");
		payforTypeItem.setRequired(true);
		payforTypeItem.setWidth("*");


		bdTotalAmountItem=new DoubleItem("bdTotalAmount",shouldNotBeNull+"预算总金额");
		bdTotalAmountItem.setRequired(true);
		bdTotalAmountItem.setWidth("*");

		bdApplyTimeItem=new DateTimeItem("bdApplyTime",shouldNotBeNull+"申请时间");
		bdApplyTimeItem.setRequired(true);
		bdApplyTimeItem.setDefaultValue(new Date());
		bdApplyTimeItem.setCanEdit(false);
		bdApplyTimeItem.setDisabled(true);
		bdApplyTimeItem.setWidth("*");

		bdEstimatecloseTimeItem=new DateTimeItem("bdEstimatecloseTime",shouldNotBeNull+"预期关闭时间");
		bdEstimatecloseTimeItem.setRequired(true);
		bdEstimatecloseTimeItem.setWidth("*");
		
		bdApplyEmployeeIdItem=new ComboBoxItem("bdApplyEmployeeId","申请人");
		bdApplyEmployeeIdItem.setWidth("*");
		bdApplyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		bdApplyEmployeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		bdApplyEmployeeIdItem.setRequired(true);
		bdApplyEmployeeIdItem.setCanEdit(false);
		bdApplyEmployeeIdItem.setDisabled(true);
		

		projectItem=new ComboBoxItem("projectId","项目");
		projectItem.setWidth("*");
		projectItem.setChangeOnKeypress(false);
//		projectItem.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects", projectItem);
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		remarkItem=new TextAreaItem("bdRemark","备注");
		remarkItem.setWidth("*");
		remarkItem.setLength(2048);
        remarkItem.setColSpan(3);


		searchForm=new DynamicForm();
		searchForm.setNumCols(4);
		searchForm.setPadding(3);
		searchForm.setMargin(5);
		searchForm.setWidth("100%");;
		searchForm.setHeight("20%");
		searchForm.setFields(payforTypeItem,bdTotalAmountItem,bdApplyTimeItem,bdEstimatecloseTimeItem,bdApplyEmployeeIdItem,projectItem,remarkItem);
		topLayout.addMember(searchForm);

		
		middleLayout=new HLayout();
		middleLayout.setWidth100();
		middleLayout.setHeight("80%");
		middleLayout.setMargin(15);
		middleLayout.setAlign(Alignment.CENTER);
		mainLayout.addMember(middleLayout);
		
		bdDetailGrid = new DelicacyListGrid();
		bdDetailGrid.setWidth("99%");
		bdDetailGrid.setAlign(Alignment.RIGHT);
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("budgetManagemenDetailId","预算详情id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId","预算管理Id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("bddTpye","预算类别");
		ComboBoxItem bddTpyeBoxItem = new ComboBoxItem();
		bddTpyeBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(bddTpyeBoxItem);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_188"));
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("bddAmount","预算金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(true);
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setAutoFitFieldWidths(false);
		bdDetailGrid.setCanRemoveRecords(true);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setHeaderHeight(60);
		bdDetailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"预算详情", new String[] {"budgetManagemenDetailId","budgetManagementId","bddTpye","bddAmount"}));

		addButton = new IButton("新增");
		addButton.setMargin(1);
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				bdDetailGrid.startEditingNew();
			}
		});
		middleLayout.addMember(bdDetailGrid);
		
		
		
		middleRightButtonLaout=new VLayout(10);
		middleRightButtonLaout.setWidth("1%");
		middleRightButtonLaout.setHeight("20%");
		middleRightButtonLaout.addMember(addButton);
		middleLayout.addMember(middleRightButtonLaout);
		
		
		bottomButtonLayout=new HLayout(10);
		bottomButtonLayout.setWidth("98%");
		bottomButtonLayout.setHeight("20%");
		bottomButtonLayout.setMargin(10);
		bottomButtonLayout.setAlign(Alignment.RIGHT);
		mainLayout.addMember(bottomButtonLayout);
		
		saveButton=new IButton("保存");
		saveButton.setMargin(2);
		bottomButtonLayout.addMember(saveButton);
		
		quitButton=new IButton("取消");
		quitButton.setMargin(3);
		bottomButtonLayout.addMember(quitButton);
		
		
		


		addMember(mainLayout);

	}

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	private   PopupWindow  pop;

	public PopupWindow getPop() {
		return pop;
	}

	public void setPop(PopupWindow pop) {
		this.pop = pop;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}


	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	
	
}

