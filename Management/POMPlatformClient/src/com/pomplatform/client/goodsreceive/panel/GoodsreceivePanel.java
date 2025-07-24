package com.pomplatform.client.goodsreceive.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Image;
import com.pomplatform.client.goodsreceive.datasource.DSGoodsreceive;
import com.pomplatform.client.goodsreceive.form.GoodsreceiveSearchForm;
import com.pomplatform.client.goodsreceive.form.GoodsreceiveViewer;
import com.pomplatform.client.goodsreceive.form.NewGoodsreceiveForm;
import com.pomplatform.client.goodsreceive.form.UpdateGoodsreceiveForm;
import com.pomplatform.client.goodsreceivedetail.datasource.DSGoodsreceivedetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class GoodsreceivePanel extends AbstractExpansionRelatedPage
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			GoodsreceivePanel cm = new GoodsreceivePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Goodsreceive";
		}

	}


	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = new IButton("修改");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/edit.png");
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateGoodsreceiveForm detailForm = new UpdateGoodsreceiveForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
//						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
//						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		IButton operation2Button = new IButton("查看二维码");
		controlLayout.addMember(operation2Button);
		operation2Button.setIcon("[SKIN]/actions/view.png");
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showQRcode();
			}
		});
		IButton operation3Button = new IButton("新建");
		controlLayout.addMember(operation3Button);
		operation3Button.setIcon("[SKIN]/actions/add.png");
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewGoodsreceiveForm detailForm = new NewGoodsreceiveForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength()-1);
								
								Record record = event.getData();
								Map<String,Integer> map = new HashMap<>();
								map.put("fileId", record.getAttributeAsInt("fileManageId"));
								String subject = record.getAttributeAsString("subject");
								String employee = record.getAttributeAsString("employeeId");
								String receiveTime = record.getAttribute("receiveDate");
								DBDataSource.callOperation("ST_FileManage", "find", map, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										Record record = dsResponse.getData()[0];
										String url = record.getAttribute("fileUrl");
										PopupWindow pWindow = new PopupWindow();
										pWindow.setTitle("二维码");
										pWindow.setWidth(315);
										pWindow.setHeight(415);
										pWindow.centerInPage();
										VLayout vLayout = new VLayout();
										vLayout.setWidth("100%");
										vLayout.setHeight("100%");
										vLayout.setAlign(Alignment.CENTER);
										
										HLayout aLayout = new HLayout();
										aLayout.setWidth100();
										aLayout.setHeight("90%");
										Image image = new Image();
//										image.setWidth("50%");
//										image.setHeight("100%");
										image.setUrl(url);
										aLayout.addMember(image);
										vLayout.addMember(aLayout);
										
										IButton printBtn = new IButton("打印");
										HLayout bLayout = new HLayout();
										bLayout.setWidth100();
										bLayout.setHeight("10%");
										bLayout.setAlign(Alignment.CENTER);
										bLayout.addMember(printBtn);
										printBtn.addClickHandler(new ClickHandler() {
											
											@Override
											public void onClick(ClickEvent event) {
												StringBuilder sb = new StringBuilder();
												sb.append("<html>");
												sb.append("<head>");
												sb.append("<meta charset='UTF-8'>");
												sb.append("<title>扫码进入培训</title>");
												sb.append("</head>");
												sb.append("<body style='position:relative;'>");
												sb.append("<table style='position:absolute;left:30%;font-size:20px;background-color:#333333'>");
												sb.append("<tr>");
												sb.append("<td>主题：</td>");
												sb.append("<td>");
												sb.append(subject);
												sb.append("<td/>");
												sb.append("<tr/>");
												sb.append("<tr>");
//												sb.append("<td>主讲人：</td>");
//												sb.append("<td>");
//												sb.append(employee);
												sb.append("<tr/>");
												sb.append("<td>时间：</td>");
												sb.append("<td>");
												sb.append(receiveTime);
												sb.append("<td/>");
												sb.append("<tr>");
//												sb.append("<td></td>");
												sb.append("<td colspan='2'>");
												sb.append("<img src='");
												sb.append(url);
												sb.append("' width='200px' height='200px'/>");
												Print.it(sb.toString());
												
											}
										});
										vLayout.addMember(bLayout);
										pWindow.addMember(vLayout);
										pWindow.show();
									}
								});
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("60%");
						detailForm.setHeight("50%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_GoodsReceive", "delete", selected.toMap(), new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							int indexNum = resultGrid.getRowNum(selected);
							resultGrid.removeData(selected);
							resultGrid.selectSingleRecord(indexNum);
						}
					}
				});
			}
		});

		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Goodreceive"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				GoodsreceiveViewer detailForm = new GoodsreceiveViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	public void showQRcode(){
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
					ListGridRecord listGridRecord = resultGrid.getSelectedRecord();
					Integer fileID = listGridRecord.getAttributeAsInt("fileManageId");
					String subject = listGridRecord.getAttributeAsString("subject");
					String compere = listGridRecord.getAttributeAsString("compere");
					String employee = listGridRecord.getAttributeAsString("employeeId");
					Date receiveTime = listGridRecord.getAttributeAsDate("receiveDate");
					DateTimeFormat tf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
					String times = tf.format(receiveTime);
					String spearker = "";
					if (compere != "" && compere != null) {
						spearker = compere;
					}
					if (employee != "" && employee != "") {
						spearker = compere;
					}
					Map<String,Integer> map = new HashMap<>();
					map.put("fileId", fileID);
					DBDataSource.callOperation("ST_FileManage", "find", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record record = dsResponse.getData()[0];
							String fileUrl = record.getAttribute("fileUrl");
							PopupWindow pWindow = new PopupWindow();
							pWindow.setTitle("二维码");
							pWindow.setWidth(315);
							pWindow.setHeight(415);
							pWindow.centerInPage();
							VLayout vLayout = new VLayout();
							vLayout.setWidth("100%");
							vLayout.setHeight("100%");
							vLayout.setAlign(Alignment.CENTER);
							
							HLayout aLayout = new HLayout();
							aLayout.setWidth100();
							aLayout.setHeight("90%");
							Image image = new Image();
//							image.setWidth("50%");
//							image.setHeight("100%");
							image.setUrl(fileUrl);
							aLayout.addMember(image);
							vLayout.addMember(aLayout);
							
							IButton printBtn = new IButton("打印");
							HLayout bLayout = new HLayout();
							bLayout.setWidth100();
							bLayout.setHeight("10%");
							bLayout.setAlign(Alignment.CENTER);
							bLayout.addMember(printBtn);
							printBtn.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									StringBuilder sb = new StringBuilder();
//									sb.append("<img src='")
//									.append(fileUrl)
//									.append("' width='600px' height='600px'/>");
//									Print.it(sb.toString());
									sb.append("<html>");
									sb.append("<head>");
									sb.append("<meta charset='UTF-8'>");
									sb.append("<title>扫码进入物品领用</title>");
									sb.append("</head>");
									sb.append("<body style='position:relative;'>");
									sb.append("<table style='position:absolute;left:30%;font-size:20px;background-color:#333333'>");
									sb.append("<tr>");
									sb.append("<td>主题：</td>");
									sb.append("<td>");
									sb.append(subject);
									sb.append("<td/>");
									sb.append("<tr/>");
//									sb.append("<tr>");
//									sb.append("<td>主讲人：</td>");
//									sb.append("<td>");
//									sb.append(compere);
//									sb.append("<tr/>");
									sb.append("<td>时间：</td>");
									sb.append("<td>");
									sb.append(times);
									sb.append("<td/>");
									sb.append("<tr>");
//									sb.append("<td></td>");
									sb.append("<td colspan='2'>");
									sb.append("<img src='");
									sb.append(fileUrl);
									sb.append("' width='200px' height='200px'/>");
									Print.it(sb.toString());
								
								}
							});
							vLayout.addMember(bLayout);
							pWindow.addMember(vLayout);
							pWindow.show();
						}
					});
				
				
			}
			
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
				
			}
		});
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by goods_receive_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new GoodsreceiveSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSGoodsreceive.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSGoodsreceivedetail.getInstance();
	}


}

