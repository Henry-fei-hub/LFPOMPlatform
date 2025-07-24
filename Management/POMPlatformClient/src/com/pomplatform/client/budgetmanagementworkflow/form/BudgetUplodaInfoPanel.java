package com.pomplatform.client.budgetmanagementworkflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.getbudgetuplodanews.datasource.DSGetBudgetUplodaNews;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BudgetUplodaInfoPanel extends HLayout implements HasHandlers{
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private DelicacyListGrid grid;
	private IButton lodaBtu;
	private IButton deletBtu;
	private HLayout mainLayout;
	private VLayout buttoLayout;
	public void  initComponents(){
		
		mainLayout=new HLayout(10);
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		mainLayout.setMargin(5);
		mainLayout.setPadding(5);

		buttoLayout=new VLayout(10);
		buttoLayout.setPadding(5);
		buttoLayout.setMargin(5);
		buttoLayout.setHeight100();
		buttoLayout.setWidth("10%");
		buttoLayout.setMembersMargin(10);

		addMember(mainLayout);
		addMember(buttoLayout);

		
		grid = new DelicacyListGrid();
		grid.setWidth("70%");
		grid.setAlign(Alignment.LEFT);
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("fileId","fileId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("fileName","文件名称");
		aFields[a].setWidth("10%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setHidden(false);
		a++;
		aFields[a] = new ListGridField("fileUrl","路径");
		aFields[a].setWidth("10%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("createTime","上传时间");
		aFields[a].setWidth("10%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		grid.setFields(aFields);
		grid.setDataSource(DSGetBudgetUplodaNews.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setCanRemoveRecords(false);
		grid.setCanEdit(false);
		mainLayout.addMember(grid);

		lodaBtu=new IButton("刷新");
		lodaBtu.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				lodaDate();
			}
		});

		deletBtu=new IButton("删除");
		deletBtu.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!grid.anySelected()){ SC.say("请选择一条数据"); return;}
				SC.ask("删除附件","确定要删除上传的附件吗？",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							int fileId=grid.getSelectedRecord().getAttributeAsInt("fileId");
							if(fileId>0) {
								Map<String,Object> params = new HashMap<>();
								params.put("fileId",fileId);
								DBDataSource.callOperation("ST_FileManage", "delete", params, new DSCallback(){
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0) {
											record.setAttribute("fileId", 0);
											DataEditEvent dee = new DataEditEvent();
											dee.setData(record);
											fireEvent(dee);
											panel.redraw();
											panel.setOKbut(false);
											SC.say("删除附件成功!");
											lodaDate();
										}
									}
								});
							}else {
								SC.say("获取附件ID失败！");
								return;
							}
						}
						return;	
					}
				});
			}
		});

		buttoLayout.addMember(lodaBtu);
		buttoLayout.addMember(deletBtu);




	}


	public void lodaDate() {
		if(record!=null) {
			int fileId=BaseHelpUtils.getIntValue(record.getAttribute("fileId"));
			Map<String,Object> params = new HashMap<>();
			params.put("fileId",fileId);
			DBDataSource.callOperation("ST_FileManage", "find", params, new DSCallback(){
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0) {
						grid.setData(dsResponse.getData());
					}
				}
			});
		}
	}

	
	private BudgetUplodaEditPanel panel;


	public BudgetUplodaEditPanel getPanel() {
		return panel;
	}

	public void setPanel(BudgetUplodaEditPanel panel) {
		this.panel = panel;
	}

	
	private Record record;


	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

}
