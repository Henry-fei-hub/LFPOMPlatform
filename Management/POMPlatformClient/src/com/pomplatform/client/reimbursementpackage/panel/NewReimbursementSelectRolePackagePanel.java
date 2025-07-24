package com.pomplatform.client.reimbursementpackage.panel;

import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class NewReimbursementSelectRolePackagePanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	
	private final ComboBoxItem roleItem;
	private final TextAreaItem remarkItem;
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public NewReimbursementSelectRolePackagePanel(int companyId) {
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		
		int roleId = 37;
//		switch (companyId) {
//		case 0://杰恩
//		case 1://博普森
//		case 2://姜峰
//		case 3://杰加
//		case 8://杰拓
//		case 9://姜峰室内设计(香港)有限公司
//			roleId = 37;
//			break;
//		case 4://武汉
//			roleId = 49;
//			break;
//		case 6://北京
//		case 12://北京
//			roleId = 50;
//			break;
//		case 7://大连
//		case 10://大连
//			roleId = 51;
//			break;
//		case 5://上海
//		case 13://上海
//			roleId = 52;
//			break;
//		}
		
		roleItem = new ComboBoxItem("role", "可审批(角色)");
		roleItem.setWidth("*");
//		roleItem.setValueMap(KeyValueManager.getValueMap("roles_package"));
		KeyValueManager.loadValueMap("roles_package",roleItem);
		roleItem.setRequired(true);
		roleItem.setDisabled(true);
		roleItem.setDefaultValue(roleId);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(3);
		remarkItem.setRowSpan(2);
		
		form.setNumCols(2);
//		form.setDataSource(DSSreimbursementpackagesummaryrror.getInstance());
		form.setItems(roleItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		vLayout.addMember(form);
		form.setWidth100();
		form.setHeight100();

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(form.getValuesAsRecord());
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
		buttonLayout.setHeight(20);
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

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	// 数据验证
	public boolean DataValidate() {
		return form.validate();
	}

}
