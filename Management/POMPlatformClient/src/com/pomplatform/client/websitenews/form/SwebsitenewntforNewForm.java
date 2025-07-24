package com.pomplatform.client.websitenews.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.UploadReimbursementAttachments;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.websitenews.datasource.DSSwebsitenewntfor;

public class SwebsitenewntforNewForm extends AbstractWizadPage {

	private final TextItem titleItem;
	private final TextItem fileUrlItem;
	private final TextItem contentItem;
	private final DateTimeItem createTimeItem;
	private final TextItem newTypeItem;
	private final TextItem deleteFlagItem;
	private final TextItem orderNumItem;
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;

	public SwebsitenewntforNewForm() {
		DSSwebsitenewntfor ds = DSSwebsitenewntfor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		titleItem = new TextItem("title", "主题");
		titleItem.setWidth("*");
		__formItems.add(titleItem);
		fileUrlItem = new TextItem("fileUrl", "文件路径");
		fileUrlItem.hide();
		fileUrlItem.setWidth("*");
		__formItems.add(fileUrlItem);
		contentItem = new TextItem("content", "内容");
		contentItem.setHidden(true);
		__formItems.add(contentItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setDefaultValue(new Date());
		createTimeItem.setWidth("*");
		__formItems.add(createTimeItem);
		newTypeItem = new TextItem("newType", "新闻类型  1公告");
		newTypeItem.hide();
		__formItems.add(newTypeItem);
		deleteFlagItem = new TextItem("deleteFlag", "删除标志 1 未删除  2已删除");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);
		orderNumItem = new TextItem("orderNum", "排序标志 值越大越靠前");
		orderNumItem.setWidth("*");
		__formItems.add(orderNumItem);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);

		attachmentItem = new LinkItem("上传文件");
		attachmentItem.setLinkTitle("尚未上传文件,请点击标题【上传文件】上传");
		attachmentItem.setWidth("*");
		attachmentItem.setTitleStyle("labelTitleStyleClick");
		attachmentItem.setCanEdit(false);
		attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachmentItem.setRequired(true);
		__formItems.add(attachmentItem);
		attachmentItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传文件", false, 300, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						// 上传附件文件成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setTitle("更新文件");
							attachmentItem.setTitleStyle("labelTitleStyleClick");
							attachmentItem.setCanEdit(false);
							attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachmentItem.setLinkTitle("已上传文件,点击可下载/预览(点击【更新文件】上传新的文件)");
							attachmentItem.setValue(fileUrl);
							fileUrlItem.setValue(fileUrl);
							attachmentItem.redraw();
							attachmentIdItem.setValue(fileId);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSwebsitenewntfor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
