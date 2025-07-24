package com.pomplatform.client.cwd.form;

import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddOrUpdateUpdateFilePanel extends VLayout implements HasHandlers {

	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	private final TextItem toFilePathItem;
	private final TextItem fileUrlItem;
	private final SelectItem fileTypeItem;
	private final IntegerItem fileIdItem;
	private final TextAreaItem remarkItem;
	private final TextItem fileNameItem;
	

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public AddOrUpdateUpdateFilePanel() {

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		
		fileNameItem = new TextItem("fileName", "文件名称");
		fileNameItem.setRequired(true);
		fileNameItem.setWidth("*");
		fileNameItem.setHidden(true);
		
		fileIdItem = new IntegerItem("fileId", "文件ID");
		fileIdItem.setDisabled(true);
		fileIdItem.setRequired(true);
		fileIdItem.setHidden(true);
		
		fileTypeItem = new SelectItem("fileType", "文件类型");
		fileTypeItem.setRequired(true);;
		fileTypeItem.setWidth("*");
		fileTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_202"));
		
		fileUrlItem = new TextItem("fileUrl", "文件地址(点击该框上传文件)");
		fileUrlItem.setCanEdit(false);
		fileUrlItem.setWidth("*");
		fileUrlItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				if(BaseHelpUtils.isNullOrEmpty(fileTypeItem.getValue())) {
					SC.say("请选择文件类型");
					return;
				}
				CommonUploadWindow uploadWindow = new CommonUploadWindow("选择上传文件", false, null, null, null, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for (String key : data.keySet()) {
							Record rData = data.get(key);
							fileIdItem.setValue(rData.getAttribute("fileId"));
							fileNameItem.setValue(rData.getAttribute("fileName"));
							fileUrlItem.setValue(rData.getAttribute("fileUrl"));
							toFilePathItem.setValue(fileTypeItem.getDisplayValue().split("--")[1] + fileNameItem.getValueAsString());
						}
					}
				});
				uploadWindow.show();
				
			}
		});
		
		toFilePathItem = new TextItem("toFilePath", "相对文件路径(<font color='red'>切记补全到文件名</font>)");
		toFilePathItem.setRequired(true);
		toFilePathItem.setWidth("*");

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);

		form.setNumCols(2);
		form.setItems(fileIdItem, fileTypeItem, fileUrlItem, toFilePathItem, fileNameItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		vLayout.addMember(form);
		form.setWidth100();
		form.setHeight100();
		
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
		return form.validate();
	}

}
