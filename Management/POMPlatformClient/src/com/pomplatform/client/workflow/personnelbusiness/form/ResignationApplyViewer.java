package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.account.panel.EmployeeAccountDesignPanel;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.personnel.panel.PersonnelPrintPanel;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSResignationApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
/*人事专员可下载离职面谈表；部门经理提示更换专业负责人；运营中心显示积分个人账户*/
public class ResignationApplyViewer extends AbstractDetailViewer
{

	private String processName;
	private VLayout mainLayout;
	private VLayout warning;
	private Label label;
	private ResignationApplyUpdateForm form;
	private SearchForm __parentSearchForm;
	/**
	 * 运营中心分管领导
	 */
	private String processName_1 = "运营中心分管领导";
	/**
	 * 人事专员
	 */
	private String processName_2 = "招聘专员";
	/**
	 * 部门经理
	 */
	private String processName_3 = "部门经理";
	/**
	 * 部门分管领导
	 */
	private String processName_4 = "部门分管领导";
	/**
	 * 人资总监
	 */
	private String processName_5 = "人资总监";
	/**
	 * 部门负责人
	 */
	private String processName_6 = "部门负责人";
	/**
	 * 人事专员
	 */
	private String processName_7 = "人事专员";
	/**
	 * 运营专员
	 */
	private String processName_8 = "运营专员";
	/**
	 * 资源经理
	 */
	private String processName_9 = "资源经理";
	/**
	 * 薪酬专员
	 */
	private String processName_10 = "薪酬专员";
	/**
	 * 部门行政负责人
	 */
	private String processName_11 = "部门行政负责人";

	public ResignationApplyViewer( String processName) {
		setProcessName(processName);
	}

	@Override
	public void initComponents() {
		setWidth100();
		setHeight100();
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		
		form = new ResignationApplyUpdateForm(processName);

		form.setWidth100();
		form.setHeight("90%");
		mainLayout.addMember(form);
		
		if(null != processName && processName.equals(processName_10)){
			FormItem[] items = form.getFormItemArray();
			for(FormItem item : items){
				if(item.getName().equals("projectName") || item.getName().equals("subType") || item.getName().equals("projectCode")||item.getName().equals("startDateDetail") || item.getName().equals("endDateDetail") || item.getName().equals("address")){
					item.hide();
				}else{
					item.show();
				}
				item.setCanEdit(false);
				item.setDisabled(false);
			}
		}
		int width = (form.getWidth()-30)/23*10;
		warning = new VLayout();
		warning.setWidth100();
		warning.setHeight("10%");
		label = new Label("<font style='color:#FF7F27;font-weight:bold;'>温馨提示：该离职员工是专业负责人，请及时将其管理的订单更换专业负责人！</font>");
		label.setHeight(40);
		label.hide();
		warning.addMember(label);
		warning.setLayoutLeftMargin(width * 3 / 10 + 10);
		if(null != processName && processName.equals(processName_2)){
			IButton button_1 = new IButton("离职面谈表");
			button_1.setBaseStyle("customButton");
			button_1.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					GWT.runAsync(new RunAsyncCallback() {
						
						@Override
						public void onFailure(Throwable reason) {
							SC.say("failure to download");
						}
						
						@Override
						public void onSuccess() {
							Record record = getRecord();
							Map<String, String> params = new HashMap<>();
							params.put("optType", "getResignationInfo");
							params.put("personnelBusinessId", record.getAttribute("personnelBusinessId"));
							DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										Record dataRecord = dsResponse.getData()[0];
										if(null != dataRecord){
											String startDateStr = "";
											if(null != dataRecord.getAttribute("startDate")){
												Date date = dataRecord.getAttributeAsDate("startDate");
												startDateStr = (date.getYear()+1900)+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
											}
											PopupWindow window = new PopupWindow();
											HTMLPane htmlPane = new HTMLPane();  
									        htmlPane.setWidth100();  
									        htmlPane.setHeight100();  
									        htmlPane.setShowEdges(true);  
									        htmlPane.setBackgroundColor("#fff");
									        String contents = "	<style>"
													+" 		*{"
													+"		font-family:'微软雅黑';"
													+"		} "
													+"		th{"
													+"			font-weight:normal;"
													+"		}"
													+"		td{"
													+"			text-align:center;"
													+"		}"
													+"	</style>"
													+"    <div style='width: 750px;'>		"
													+"		<!--表格3内容star--> "
													+"		<div style='height:1090px;position: relative;'>  	"
													+"			<!--表头star-->"
													+"			<div style='height:43px; border-bottom: 1px solid #000;'>"
													+"				<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>"
													+"			</div>"
													+"			<!--表头over-->"
													+"				<!--离职员工面谈表star-->"
													+"				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;font-size:15px;'>"
													+"							<caption style='font-size: 22px;font-weight: bold;margin-bottom:5px;'>"
													+"							   离职员工面谈表"
													+"							</caption>						"
													+"							<tr>"
													+"								<td colspan='6' style='text-align:left;line-height: 26px;height:65px;font-size:15px;'>“人之将走，其言也善”，您对我们的直言有助于我们改进工作！以下内容请您照实填写，不会损害您的任何利益，感谢您的支持！</td>"
													+"							</tr>	"
													+"							<tr >"
													+"								<td width='125' height='42'>姓名</td>"
													+"								<td width='125' height='42'>"+KeyValueManager.getValue("employees", dataRecord.getAttribute("employeeId"))+"</td>"
													+"								<td width='125' height='42'>所在部门</td>"
													+"								<td width='125' height='42'>"+KeyValueManager.getValue("departments", dataRecord.getAttribute("departmentId"))+"</td>"
													+"								<td width='125' height='42'>担任职位</td>"
													+"								<td width='125' height='42'>"+KeyValueManager.getValue("duties", dataRecord.getAttribute("dutyId"))+"</td>								"
													+"							</tr>										"
													+""
													+"							<tr >"
													+"								<td width='125' height='42'>入职时间</td>"
													+"								<td width='250' height='42'>"+startDateStr+"</td>"
													+"								<td width='125' height='42'>最后工作日</td>"
													+"								<td width='250' height='42'></td>"
													+"								<td width='125' height='42'>面谈者</td>"
													+"								<td width='250' height='42'></td>								"
													+"							</tr>	"
													+"							<tr>"
													+"								<td width='125' height='42'>聘用类别</td>"
													+"								<td width='250' height='42' colspan='2'>□重新聘用  □第一次聘用</td>"
													+"								<td width='125' height='42'>离职类别</td>"
													+"								<td width='250' height='42' colspan='2'>□合同期满  □自愿离职  □非自愿离职</td>							"
													+"							</tr>			"
													+""
													+"							<tr>"
													+"								<td width='125' height='42' rowspan='2'>离职原因</td>"
													+"								<td width='125' height='42' >内部原因（单选）</td>"
													+"								<td width='500' height='42' colspan='4' style='text-align:left;line-height: 26px;padding-left: 5px;    height: 115px;'>□薪资福利与期望存在差距　□无晋升机会　　　□工作量大/经常加班</br>"
													+"									□工作环境差/工作压力大　□领导分工不公正　□与领导、同事关系不和谐   </br>     "
													+"									□个人价值观和企业文化不匹配　　　　　　　□不满意公司的政策和制度  </br>         "
													+"									□其他 _______________________</td>							"
													+"							</tr>	"
													+"							<tr>"
													+"								<td width='125' height='42' >外部原因（单选）</td>"
													+"								<td width='500' height='42' colspan='4' style='text-align:left;line-height: 26px;padding-left: 5px;    height: 65px;'>□创业   □家庭原因  □回校深造  □转换行业   □个人身体健康因素</br>"
													+"									□找到更好的企业工作 _____________ □其他 _____________</br></td>							"
													+"							</tr>								"
													+"							<tr>"
													+"								<td width='125' height='42' style='text-align:left;padding: 0 3px;'>3.您认为公司哪些方面需要加以改善（最多三项）</td>"
													+"								<td width='500' height='42' colspan='5' style='text-align:left;line-height: 26px;padding-left: 5px;    height: 90px;'>□公司政策及工作程序      □部门之间沟通      □上层管理能力      □工作环境及设施</br>"
													+"									□教育培训与发展机会      □团队合作精神      □员工发展机会      □工资与福利</br>"
													+"									□其他（请手写）："
													+"								</td>							"
													+"							</tr>							"
													+"							<tr>"
													+"								<td width='125' height='42' style='text-align:left;padding: 0 3px;'>4、您离职后的打算？（单选）</td>"
													+"								<td width='500' height='42' colspan='5' style='text-align:left;line-height: 26px;padding-left: 5px;height: 70px;'>□马上找新工作  □先休息一段时间再做打算    □继续深造或接受短期培训  □自主创业</br>"
													+"									□其他________</td>							"
													+"							</tr>	"
													+"							<tr>"
													+"								<td width='125' height='42' style='height:90px;text-align:left;padding: 0 3px;' >5、请问是否考虑在未来重新加入本公司？</td>"
													+"								<td width='500' height='42' colspan='5' style='text-align:left;padding-left:5px;'> □是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;□否</td>							"
													+"							</tr>	"
													+"							<tr>"
													+"								<td width='125' height='42' style='height:90px;text-align:left;padding: 0 3px;'>6、是什么促使您当初选择加入本公司。</td>"
													+"								<td width='250' height='42' colspan='2' style='padding:0 5px;'></td>"
													+"								<td width='125' height='42' style='text-align:left;padding: 0 3px;'>7、在您做出离职决定时，您发现公司在哪些地方与您的想象和期望差距较大。</td>"
													+"								<td width='250' height='42' colspan='2' style='padding:0 5px;'></td>							"
													+"							</tr>	"
													+"							<tr>"
													+"								<td width='125' height='42' style='height:125px;text-align:left;padding: 0 3px;'>8、您最喜欢本公司的方面有哪些，最不喜欢本公司的哪些方面。</td>"
													+"								<td width='250' height='42' colspan='2' style='padding:0 5px;'></td>"
													+"								<td width='125' height='42' style='text-align:left;padding: 0 3px;'>9、您认为公司应该采取哪些措施来更有效地吸引和留住人才。</td>"
													+"								<td width='250' height='42' colspan='2' style='padding:0 5px;'></td>							"
													+"							</tr>	"
													+"							<tr>"
													+"								<td width='125' height='42' style='height:55px;text-align:left;padding: 0 3px;'>您的最后联系地址</td>"
													+"								<td width='250' height='42' colspan='2'></td>"
													+"								<td width='125' height='42' style='text-align:left;padding: 0 3px;'>您的最后联系电话</td>"
													+"								<td width='250' height='42' colspan='2'></td>							"
													+"							</tr>																																																																																																										"
													+"				</table>"
													+"				<p style='color:#999;text-align:left;margin-top:10px;padding-left:15px;'>备注：本表适用于主动离职员工，离职日为最后工作日。</p>"
													+"		</div>"
													+"		<!--表格3内容over--> 				"
													+"    </div>";
									        htmlPane.setContents(contents);  
									        htmlPane.setSelectContentOnSelectAll(true);  
									        htmlPane.draw(); 
									        htmlPane.show();
									        window.addMember(htmlPane);
									        window.setWidth100();
									        window.setHeight100();
									        window.centerInPage();
									        window.show();
									        Object[] arr = new Object[1];
											arr[0] = htmlPane;
											showPrintPreview(arr, null, "离职面谈表", new PrintPreviewCallback() {
												@Override
												public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
													printWindow.addCloseClickHandler(new CloseClickHandler() {
														@Override
														public void onCloseClick(CloseClickEvent event) {
															htmlPane.destroy();
															window.destroy();
														}
													});
												}
											});
										}else{
											SC.say("找不到相关的离职信息，无法打印离职面谈表");
										}
									}else{
										SC.say("找不到相关的离职信息，无法打印离职面谈表");
									}
								}
							});
						}
					});
				}
			});
			warning.addMember(button_1);
		}
		mainLayout.addMember(warning);
		addMember(mainLayout);
	}
	
	@Override
	public void viewRecord(Record r, boolean includeDetail) {
		if (null != r.getAttribute("personnelBusinessId")) {
			form.setRecord(r);
			form.startEdit();
			FormItem[] items = form.getFormItemArray();
			for (FormItem item : items) {
				item.setDisabled(false);
				item.setCanEdit(false);
			}
			if (null != processName && processName.equals(processName_3)) {
				Map<String, String> params = new HashMap<>();
				params.put("optType", "needToChangeProjectManager");
				params.put("employeeId", r.getAttribute("employeeId"));
				DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] record = dsResponse.getData();
							if (null != record && record.length > 0) {
								label.show();
								redraw();
							}
						}
					}
				});
			}
		}
	}
	
	@Override
	public Map getValues() {
		return super.getValues();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "离职申请";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_ResignationApply", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSResignationApply.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
}

