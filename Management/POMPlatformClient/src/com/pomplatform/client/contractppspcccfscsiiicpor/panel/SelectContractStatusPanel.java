package com.pomplatform.client.contractppspcccfscsiiicpor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SelectContractStatusPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final SelectItem contractStatusItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public SelectContractStatusPanel() {

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setTitleOrientation(TitleOrientation.TOP);
		contractStatusItem.setTitleAlign(Alignment.LEFT);
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));

		form.setNumCols(1);
		form.setItems(contractStatusItem);
		form.setWidth100();
		form.setHeight("80%");
		
		vLayout.addMember(form);

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(getValueAsRecord());
					fireEvent(dee);
					if (null == getParentWindow()) {
						return;
					}
					getParentWindow().destroy();
				} else {
					return;
				}
			}
		});

		cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				getParentWindow().destroy();
			}
		});
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight100();
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		vLayout.addMember(buttonLayout);

		addMember(vLayout);
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public Record getValueAsRecord() {
		Map map = form.getValues();
		Record record = new Record();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				record.setAttribute(key.toString(), map.get(key));
			}
		}
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}


	// 数据验证
	public boolean DataValidate() {
		if(null == contractStatusItem.getValue()){
			SC.warn("提示", "请选择合同状态");
			return false;
		}
		return true;
	}

}
