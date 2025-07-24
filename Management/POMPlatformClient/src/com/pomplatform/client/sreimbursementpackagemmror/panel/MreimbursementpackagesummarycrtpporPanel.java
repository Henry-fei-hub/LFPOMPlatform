package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.minvocieapplydedaocor.panel.AddOrUpdateContactsPanel;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSMreimbursementpackagesummarycrtppor;
import com.pomplatform.client.sreimbursementpackagemmror.form.MreimbursementpackagesummarycrtpporViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class MreimbursementpackagesummarycrtpporPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Integer packageId;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MreimbursementpackagesummarycrtpporPanel cm = new MreimbursementpackagesummarycrtpporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mreimbursementpackagesummarycrtppor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		IButton viewDetailButton = new IButton("查看支付详细");
		viewDetailButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					ListGridRecord record = resultGrid.getSelectedRecord();
					GWT.runAsync(new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							PopupWindow pw = new PopupWindow();
							VLayout mainLayout = new VLayout();
							mainLayout.setHeight100();
							mainLayout.setWidth100();
							
							Label label = new Label("<font size='5px'>正常支付单</font>");
							label.setHeight("50");
							label.setValign(VerticalAlignment.CENTER);
							label.setAlign(Alignment.CENTER);
							Label tdlabel = new Label("<font size='5px'>退单支付单</font>");
							tdlabel.setHeight("50");
							tdlabel.setValign(VerticalAlignment.CENTER);
							tdlabel.setAlign(Alignment.CENTER);
							
							//退单重新发起单
							McmbcpaydetailctswoowycoorPanel withdrawPanel = new McmbcpaydetailctswoowycoorPanel();
							
							//正常支付单
							MCmbcPaymentDetailporPanel panel = new MCmbcPaymentDetailporPanel();
							panel.setWithdrawPanel(withdrawPanel);
							panel.setCmbcPaymentId(record.getAttributeAsInt("cmbcPaymentId"));
							panel.commonQuery();
							mainLayout.addMember(label);
							mainLayout.addMember(panel);
							mainLayout.addMember(tdlabel);
							mainLayout.addMember(withdrawPanel);
							
							pw.addItem(mainLayout);
							pw.setTitle("查看支付详细");
							pw.setWidth100();
							pw.setHeight100();
							pw.centerInPage();
							pw.show();
							
						}
						
						@Override
						public void onFailure(Throwable reason) {
							// TODO Auto-generated method stub
							
						}
					});
				}else{
					SC.say("请选择一条数据进行查看");
				}
				
			}
		});
		controlLayout.addMember(viewDetailButton);
		
		IButton repayBtn = new IButton("重新发起支付");
		controlLayout.addMember(repayBtn);
		repayBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record selectRecord = resultGrid.getSelectedRecord();
					Integer payStatus = selectRecord.getAttributeAsInt("payStatus");
					if(1 == payStatus){
						PopupWindow pw = new PopupWindow();
						UpdateCmbcPaymentDetailPanel panel = new UpdateCmbcPaymentDetailPanel();
						panel.setRecord(selectRecord);
						panel.startEdit();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						panel.setParentCanvas(pw);
						panel.setFatherWindow(pw);
						pw.addItem(panel);
						pw.setTitle("修改数据/重新发起支付");
						pw.setWidth("30%");
						pw.setHeight("80%");
						pw.centerInPage();
						pw.show();
						
					}else{
						SC.say("请选择一条支付失败的单子进行重新支付");
					}
				}else{
					SC.say("请选择一条失败的支付单重新发起支付。");
				}
				
			}
		});
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				MreimbursementpackagesummarycrtpporViewer detailForm = new MreimbursementpackagesummarycrtpporViewer();
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != getPackageId()){
			criteria.put("reimbursementPackageId", getPackageId());
		}
		criteria.put("addtionalCondition", "order by reimbursement_package_summary_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new MreimbursementpackagesummarycrtpporSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMreimbursementpackagesummarycrtppor.getInstance();
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

}
