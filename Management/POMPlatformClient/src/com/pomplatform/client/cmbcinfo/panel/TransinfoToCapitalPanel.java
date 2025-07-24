package com.pomplatform.client.cmbcinfo.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.cmbcinfo.datasource.DSMcmbctransinfolinktattlor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @author CL
 *
 */
public class TransinfoToCapitalPanel extends VLayout {

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";
	public final static String BORDER_STYLE_TITLE = "2px solid #ABABAB;border-radius:8px;";
	
	DelicacyListGrid transInfoGrid ;
	
	public TransinfoToCapitalPanel(Record [] records) {
		transInfoGrid = new DelicacyListGrid();
		
		int index = 0;
		ListGridField [] fields = new ListGridField[10];
		fields[index] = new ListGridField("accnam");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("bankAccount");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("trsamtd");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("transDate");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("trsamtc");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("rpynam");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("rpyacc");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("rpybnk");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("rpyadr");
		fields[index].setCanEdit(false);
		index ++;
		
		SelectItem moneyAttributeItem = new SelectItem("moneyAttribute", "款项属性");
		moneyAttributeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		
		fields[index] = new ListGridField("moneyAttribute", "款项属性");
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		fields[index].setWidth(150);
		fields[index].setEditorProperties(moneyAttributeItem);
		fields[index].setCanEdit(true);
		index ++;
		
		TextItem remarkItem = new TextItem("capitalRemark", "备注");
		fields[index] = new ListGridField("capitalRemark", "备注");
		fields[index].setWidth(200);
		fields[index].setEditorProperties(remarkItem);
		fields[index].setCanEdit(true);
		index ++;
		
		ComboBoxItem contractIdItem = new ComboBoxItem("contractId", "合同");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdItem);
		contractIdItem.setChangeOnKeypress(false);
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[index] = new ListGridField("contractId", "合同");
		fields[index].setWidth(200);
//		fields[index].setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", fields[index]);
		fields[index].setEditorProperties(contractIdItem);
		fields[index].setCanEdit(true);
		
		transInfoGrid.setFields(fields);
		transInfoGrid.setCanEdit(true);
		transInfoGrid.setDataSource(DSMcmbctransinfolinktattlor.getInstance());
		transInfoGrid.setData(records);
		
		setMargin(5);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();// 最外层面板
		mainLayout.setBorder(BORDER_STYLE);

		VLayout tranInfoLayout = new VLayout(20);
		tranInfoLayout.setHeight100();
		tranInfoLayout.setWidth100();
		tranInfoLayout.addMember(transInfoGrid);
		
		// 底部工具栏添加
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();

		IButton unbindBtn = new IButton("确定");
		btnLayout.addMember(unbindBtn);
		btnLayout.addSpacer(10);
		unbindBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("是否确定?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value){
							Map<String, Object> params = new HashMap<>();
							
							Record [] records = transInfoGrid.getRecords();
							if(records.length == 0){
								return;
							}
							List<Map<String, Object>> list = new ArrayList<>();
							for (Record record : records) {
								list.add(record.toMap());
							}
							params.put("list", list);
							params.put("opt_type", "cmbTransToCapital");
							params.put("employeeId", ClientUtil.getEmployeeId());
							DBDataSource.callOperation("EP_BankCapitalCheckProcess", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										getFatherWindow().destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
									
								}
							});
						}
						
					}
				});
				
			}
		});
		
		
		IButton cancelBtn = new IButton("关闭");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getFatherWindow().destroy();
			}
		});

		// 面板布局添加
		mainLayout.addMember(tranInfoLayout);

		addMember(mainLayout);
		addMember(btnLayout);
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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

}
