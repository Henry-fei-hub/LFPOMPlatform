package com.pomplatform.client.budgetmanagementworkflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BudgetUplodaEditPanel extends VLayout implements HasHandlers{
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private TextItem bdAttachmentNameItem;
	private TextAreaItem bdUploadRemarkItem;
	private ButtonItem uploadItem;
	private Button OKBut;
	private DynamicForm form ;
	private HLayout  topLaout;
	private HLayout    buttonLayout;
	private Label TitleView;
	public void  initComponents(){
		topLaout=new HLayout(10);
		topLaout.setWidth100();
		topLaout.setHeight("60%");

		TitleView = new Label();
		TitleView.setContents("<font style=\"color:red;font-size:13px;font-weight:bold;\">若要上传多个文件,请将文件打包为压缩包上传</font>");
		TitleView.setWidth("100%");
		TitleView.setHeight("7%");
		TitleView.setAlign(Alignment.CENTER);
		addMember(TitleView);


		bdAttachmentNameItem=new TextItem("bdAttachmentName",shouldNotBeNull+"上传文件名称");
		bdAttachmentNameItem.setWidth("*");

		uploadItem = new ButtonItem("选择附件上传");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.setColSpan(1);
		uploadItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				CommonUploadWindow contractForm = new CommonUploadWindow("预算单相关文件上传",false, null, null, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						if(!BaseHelpUtils.isNullOrEmpty(data)){
							for(String key : data.keySet()){
								//获取文件Id和文件名称
								int fId = BaseHelpUtils.getIntValue(data.get(key).getAttribute("fileId"));
								String fileName = BaseHelpUtils.getString(data.get(key).getAttribute("fileName"));
								bdAttachmentNameItem.setValue(fileName);
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

		bdUploadRemarkItem=new TextAreaItem("bdUploadRemark","上传备注");
		bdUploadRemarkItem.setStartRow(false);
		bdUploadRemarkItem.setColSpan(6);
		bdUploadRemarkItem.setRowSpan(3);
		bdUploadRemarkItem.setWidth("*");

		OKBut=new Button("确定上传");
		OKBut.setAlign(Alignment.CENTER);
		if(getDelrecord()!=null) {
			int fileId=BaseHelpUtils.getIntValue(getDelrecord().getAttribute("fileId"));
			if(fileId>0) {
				OKBut.setDisabled(true);
			}else {
				OKBut.setDisabled(false);
			}
		}else {
			OKBut.setDisabled(false);
		}
		OKBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取上传文件名称
				String bdAttachmentName=BaseHelpUtils.getString(bdAttachmentNameItem.getValue());
				//获取上传备注
				String bdUploadRemark=BaseHelpUtils.getString(bdUploadRemarkItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(bdAttachmentName)) {SC.say("上传文件名称不能为空"); return;}
				Map<Object,Object> params = new HashMap<>();
				params.put("bdAttachmentName", bdAttachmentName);
				params.put("bdUploadRemark", bdUploadRemark);
				params.put("fileId",fileId);
				params.put("optType", "BudgetApplyUpload");
				DBDataSource.callOperation("EP_BudetAboutUpload",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record record=new Record();
							record.setAttribute("bdAttachmentName", bdAttachmentName);
							record.setAttribute("bdUploadRemark", bdUploadRemark);
							record.setAttribute("fileId", fileId);
							DataEditEvent dee = new DataEditEvent();
							dee.setData(record);
							fireEvent(dee);
							OKBut.setDisabled(true);
							SC.say("上传成功！");
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
			}
		});

		form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();
		form.setItems(bdAttachmentNameItem,uploadItem,bdUploadRemarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		topLaout.addMember(form);


		buttonLayout=new HLayout(10);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.setWidth100();
		buttonLayout.setHeight("40%");
		buttonLayout.setMembersMargin(10);
		buttonLayout.addMember(OKBut);


		addMember(topLaout);
		addMember(buttonLayout);



	}


	private Record delrecord;


	public Record getDelrecord() {
		return delrecord;
	}

	public void setDelrecord(Record delrecord) {
		this.delrecord = delrecord;
	}

	public void setOKbut(boolean value) {
		this.OKBut.setDisabled(value);
	}


	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}


}
