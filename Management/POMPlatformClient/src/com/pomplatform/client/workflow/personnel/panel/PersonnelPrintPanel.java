package com.pomplatform.client.workflow.personnel.panel;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class PersonnelPrintPanel extends VLayout{
	
	/**
	 * 打印离职证明
	 * @param map
	 */
	public void printWindow1(Map<String, Object> map){
		if(map.containsKey("startDate") && map.containsKey("endDate") && map.containsKey("employeeId") && map.containsKey("card") && map.containsKey("departmentId") && map.containsKey("dutyId") && map.containsKey("reason")){
			Date startDate = (Date)(map.get("startDate"));
			Date endDate = (Date)(map.get("endDate"));
			int companyId = ClientUtil.checkAndGetIntValue(map.get("companyId"));
			PopupWindow window = new PopupWindow();
			HTMLPane htmlPane = new HTMLPane();  
	        htmlPane.setWidth100();  
	        htmlPane.setHeight100();  
	        htmlPane.setShowEdges(true);  
	        htmlPane.setBackgroundColor("#fff");
	        StringBuilder sb = new StringBuilder();
	        sb.append("	<style>")
	        .append(" 		*{")
	        .append("		font-family:'微软雅黑';")
	        .append("		} ")
	        .append("	</style>")
	        .append("<div style = 'width:570px; margin-left:65px;'>")
	        .append("	<div style='height:415px; position: relative'>")
	        .append("		<div style='position: absolute; top: 0px; left: 0px;'>");
	        if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("		<img src = '/images/companyLogo/BPS.png' style='float:left; height:75px;'/>");
	        }else if(companyId == 2){//姜峰设计（深圳）有限公司
	        	sb.append("		<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
	        }else{
	        	sb.append("		<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
	        }
	        sb.append("		</div>");
	        if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("	<div style='clear:both; margin-top:30px;'></div>")
	        	.append("	<div style='position: absolute; margin-top: 50px;'>");
	        }else{
	        	sb.append("	<div style='clear:both; margin-top:45px;'></div>")
	        	.append("	<div style='position: absolute; margin-top: 32px;'>");
	        }
	        sb.append("			<p style='font-size:21px;font-weight:bold;text-align:center'>离职证明<font style='font-size:17px'>（公司存根）</font></p>")
	        .append("			<p style='font-size:16px;line-height:30px;'>　　兹证明<u>  ").append(KeyValueManager.getValue("employees", map.get("employeeId").toString())).append("  </u>（男士/女士）（身份证号码：<u>  ").append(map.get("card")).append("  </u>），自<u> ")
	        .append((startDate.getYear()+1900)).append(" </u>年<u> ").append((startDate.getMonth()+1)).append(" </u>月<u> ").append(startDate.getDate()).append(" </u>日在我司<u> ")
	        .append(KeyValueManager.getValue("departments", map.get("departmentId").toString())).append(" </u>（部门）担任<u> ").append(KeyValueManager.getValue("duties", map.get("dutyId").toString())).append(" </u>职务，现因<u> ")
	        .append(map.get("reason")).append(" </u>，自<u> ").append((endDate.getYear()+1900)).append(" </u>年<u> ").append((endDate.getMonth()+1)).append(" </u>月<u> ").append(endDate.getDate()).append(" </u>日起，本公司与该员工解除劳动合同关系。</p>")
	        .append("			<p style='font-size:16px'>　　特此证明。</p>")
	        .append("			<p style='font-size:16px'>当事人确认（签字）</p>")
	        .append("			<p style='font-size:16px'>　　年　　月　　日</p>");
        	sb.append("		<p style='font-size:16px; text-align:right'>").append(KeyValueManager.getValue("company_records", companyId+"")).append("</p>");
	        sb.append("			<p style='font-size:16px; text-align:right'>　　年　　月　　日</p>")
	        .append("		</div>")
	        .append("	</div>")
	        .append("	<div style='clear:both;'></div>")
	        .append("	<div style='position: relative;'>")
	        .append("		<div style='position: relative'>")
	        .append("			<div style='position: absolute; top: 0px; left: 0px;'>");
	        if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("			<img src = '/images/companyLogo/BPS.png' style='float:left; height:75px;'/>");
	        }else if(companyId == 2){//姜峰设计（深圳）有限公司
	        	sb.append("			<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
	        }else{
	        	sb.append("			<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
	        }
	        sb.append("			</div>");
	        if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("		<div style='clear:both; margin-top:125px;'></div>")
	        	.append("			<div style='position: absolute; margin-top: 50px;'>");
	        }else{
	        	sb.append("		<div style='clear:both; margin-top:100px;'></div>")
	        	.append("			<div style='position: absolute; margin-top: 32px;'>");
	        }
	        sb.append("<p style='font-size:21px;font-weight:bold;text-align:center'>离职证明<font style='font-size:17px'>（个人存根）</font></p>")
	        .append("			<p style='font-size:16px;line-height:30px;'>　　兹证明<u>  ").append(KeyValueManager.getValue("employees", map.get("employeeId").toString())).append("  </u>（男士/女士）（身份证号码：<u>  ").append(map.get("card")).append("  </u>），自<u> ")
	        .append((startDate.getYear()+1900)).append(" </u>年<u> ").append((startDate.getMonth()+1)).append(" </u>月<u> ").append(startDate.getDate()).append(" </u>日在我司<u> ")
	        .append(KeyValueManager.getValue("departments", map.get("departmentId").toString())).append(" </u>（部门）担任<u> ").append(KeyValueManager.getValue("duties", map.get("dutyId").toString())).append(" </u>职务，现因<u> ")
	        .append(map.get("reason")).append(" </u>，自<u> ").append((endDate.getYear()+1900)).append(" </u>年<u> ").append((endDate.getMonth()+1)).append(" </u>月<u> ").append(endDate.getDate()).append(" </u>日起，本公司与该员工解除劳动合同关系。</p>")
	        .append("			<p style='font-size:16px'>　　特此证明。</p>")
	        .append("			<p style='font-size:16px'>　　</p>");
	        sb.append("		<p style='font-size:16px; text-align:right'>").append(KeyValueManager.getValue("company_records", companyId+"")).append("</p>");
	        sb.append("			<p style='font-size:16px; text-align:right'>　　年　　月　　日</p>")
	        .append("		</div>")
	        .append("	</div>")
	        .append("</div>");
	        String contents = sb.toString(); 
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
			showPrintPreview(arr, null, "离职证明", new PrintPreviewCallback() {
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
			SC.say("离职信息不全，无法打印离职证明");
		}
		
	}
	
	/**
	 * 打印转正申请书
	 * @param map
	 * @param nameStr
	 * @param departmentStr
	 * @param dutyStr
	 */
	public void printWindow2(Map<String, Object> map, String nameStr, String departmentStr, String dutyStr){
		if(map.containsKey("startDate") && map.containsKey("employeeId") && map.containsKey("remark") && map.containsKey("departmentId") && map.containsKey("dutyId") && map.containsKey("reason")){
			int companyId = ClientUtil.checkAndGetIntValue(map.get("companyId"));
			String remarkStr = map.get("remark").toString();
			String reasonStr = map.get("reason").toString();
			Date startDate = (Date)(map.get("startDate"));
			DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy年MM月dd日");
			String timeStr = dateFormat.format(startDate);
			PopupWindow window = new PopupWindow();
			HTMLPane htmlPane = new HTMLPane();  
	        htmlPane.setWidth100();  
	        htmlPane.setHeight100();  
	        htmlPane.setShowEdges(true);  
	        htmlPane.setBackgroundColor("#fff");
	        StringBuilder sb = new StringBuilder();
			sb.append("	<style>")
			.append(" 		*{")
			.append("		font-family:'微软雅黑';")
			.append("} ")
			.append("		th{")
			.append("			font-weight:normal;")
			.append("		}")
			.append("		td{")
			.append("			text-align:center;")
			.append("		}")
			.append("	</style>")
			.append("    <div style='width: 750px;'>")
			.append("		<!--表格1内容star--> ")
			.append("		<div style='height:1097px;position: relative;'>  	")
			.append("			<!--表头star-->")
			.append("			<div style='height:43px; border-bottom: 1px solid #000;'>");
			if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("		<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
	        }else if(companyId == 2){//姜峰设计（深圳）有限公司
	        	sb.append("		<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
	        }else{
	        	sb.append("		<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
	        }
			sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62P-ARH　</font>")
			.append("			</div>")
			.append("			<!--表头over-->")
			.append("				<table border='0' cellpadding='0' cellspacing='0' style ='margin-top:100px;margin-left:187px;'>")
			.append("							<caption style='font-size:45px;font-weight: bold;margin-bottom:280px;'>")
			.append("							   员工转正申请表")
			.append("							</caption>	")
			.append("")
			.append("							<tr style='font-size:16px;'>")
			.append("								<td width='100' height='60' valign='bottom'>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>")
			.append("								<td width='250' height='60' style='border-bottom:1px solid #333;' valign='bottom'>nameStr</td>")
			.append("							</tr>")
			.append("							<tr style='font-size:16px;'>")
			.append("								<td widtd='100' height='60' valign='bottom'>入职时间：</td>")
			.append("								<td width='250' height='60' style='border-bottom:1px solid #333;' valign='bottom'>")
			.append("									timeStr</td>")
			.append("							</tr>")
			.append("							<tr style='font-size:16px;'>")
			.append("								<td widtd='100' height='60' valign='bottom'>入职部门：</td>")
			.append("								<td width='250' height='60' style='border-bottom:1px solid #333;' valign='bottom'>departmentStr</td>")
			.append("							</tr>																									")
			.append("				</table>							")
			.append("			<!--表尾star-->")
			.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 1 页 共 3 页</div>")
			.append("			<!--表尾over-->	")
			.append("		</div>")
			.append("		<!--表格1内容over-->     	")
			.append("		<!--表格2内容star--> ")
			.append("		<div style='height:1097px;position: relative;'>  	")
			.append("			<!--表头star-->")
			.append("			<div style='height:43px; border-bottom: 1px solid #000;'>");
			if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("		<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
	        }else if(companyId == 2){//姜峰设计（深圳）有限公司
	        	sb.append("		<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
	        }else{
	        	sb.append("		<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
	        }
			sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62P-ARH　</font>")
			.append("			</div>")
			.append("			<!--表头over-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
			.append("							<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
			.append("							   员工转正申请表")
			.append("							</caption>	")
			.append("")
			.append("							<tr style='font-size:15px;'>")
			.append("								<td width='125' height='42'>姓名</td>")
			.append("								<td width='250' height='42'>nameStr</td>")
			.append("								<td width='125' height='42'>入职时间</td>")
			.append("								<td width='250' height='42'>timeStr</td>")
			.append("							</tr>")
			.append("							<tr style='font-size:15px;'>")
			.append("								<td widtd='125' height='42'>部门</td>")
			.append("								<td width='250' height='42'>departmentStr</td>")
			.append("								<td width='125' height='42'>职务</td>")
			.append("								<td width='250' height='42'>dutyStr</td>")
			.append("							</tr>																									")
			.append("				</table>")
			.append("				<!--一、自我鉴定star-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;' height='800'>			")
			.append("							<tr style='font-size:15px;' >")
			.append("								<td width='750' height='800' colspan='4' style='text-align:left;padding-left:15px;padding-top:15px;' valign='top' >")
			.append("									<span>自我鉴定：</span><br>")
			.append("									<span style='word-break:break-all;'>reasonStr</span>")
			.append("								</td>")
			.append("							</tr>																																																				")
			.append("				</table>")
			.append("				<!--一、自我鉴定over-->	")
			.append("				<!--二、员工签字star-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;'>")
			.append("						<tr style='font-size:15px;'>")
			.append("							<td width='750' height='33' colspan='4' style='text-align:left;padding-left:5px;'>员工手工签名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
			.append("				日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
			.append("				")
			.append("							</td>						")
			.append("						</tr>																																																																		")
			.append("				</table>")
			.append("				<!--二、员工签字over-->								")
			.append("			<!--表尾star-->")
			.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 2 页 共 3 页</div>")
			.append("			<!--表尾over-->	")
			.append("		</div>")
			.append("		<!--表格2内容over--> ")
			.append("		<!--表格3内容star--> ")
			.append("		<div style='height:1097px;position: relative;'>  	")
			.append("			<!--表头star-->")
			.append("			<div style='height:53px; border-bottom: 1px solid #000;'>");
			if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("		<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
	        }else if(companyId == 2){//姜峰设计（深圳）有限公司
	        	sb.append("		<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
	        }else{
	        	sb.append("		<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
	        }
			sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62P-ARH　</font>")
			.append("			</div>")
			.append("			<!--表头over-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
			.append("							<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
			.append("							   试用期工作总结")
			.append("							</caption>	")
			.append("")
			.append("							<tr style='font-size:15px;'>")
			.append("								<td width='125' height='42'>姓名</td>")
			.append("								<td width='250' height='42'>nameStr</td>")
			.append("								<td width='125' height='42'>入职时间</td>")
			.append("								<td width='250' height='42'>timeStr</td>")
			.append("							</tr>")
			.append("							<tr style='font-size:15px;'>")
			.append("								<td widtd='125' height='42'>部门</td>")
			.append("								<td width='250' height='42'>departmentStr</td>")
			.append("								<td width='125' height='42'>职务</td>")
			.append("								<td width='250' height='42'>dutyStr</td>")
			.append("							</tr>																									")
			.append("				</table>")
			.append("				<!--一、自我鉴定star-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;' height='600'>			")
			.append("							<tr style='font-size:15px;' >")
			.append("								<td width='750' colspan='4' style='text-align:left;padding-left:15px;padding-top:15px;' valign='top' align='left'>")
			.append("									<span>工作总结：</span><br>")
			.append("									<span style='word-break:break-all;'>remarkStr</span>")
			.append("								</td>")
			.append("							</tr>																																																				")
			.append("				</table>")
			.append("				<!--一、自我鉴定over-->	")
			.append("				<!--二、员工签字star-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;'>")
			.append("						<tr style='font-size:15px;'>")
			.append("							<td width='750' height='33' colspan='4' style='text-align:left;padding-left:5px;'>员工手工签名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
			.append("				日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
			.append("				")
			.append("							</td>						")
			.append("						</tr>																																																																		")
			.append("				</table>")
			.append("				<!--二、员工签字over-->		")
			.append("				<!--三、部门负责人意见star-->")
			.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;'>							")
			.append("							<tr style='font-size:15px;'>")
			.append("								<td width='150' height='205' >部门负责人意见</td>")
			.append("								<td width='600' colspan='3' height='205' align='left' style='text-align:left;'>")
			.append("									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门负责人手工签名：")
			.append("									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日期：")
			.append("								</td>")
			.append("							</tr>																								")
			.append("				</table>					")
			.append("				<!--三、部门负责人意见over-->						")
			.append("			<!--表尾star-->")
			.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 3 页 共 3 页</div>")
			.append("			<!--表尾over-->	")
			.append("		</div>")
			.append("		<!--表格3内容over--> 		")
			.append("    </div>");
	        String contents = sb.toString().replaceAll("nameStr", nameStr).replaceAll("departmentStr", departmentStr).replaceAll("timeStr", timeStr).replaceAll("dutyStr", dutyStr).replaceAll("reasonStr", reasonStr).replaceAll("remarkStr", remarkStr); 
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
			showPrintPreview(arr, null, "转正申请书", new PrintPreviewCallback() {
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
			SC.say("信息不全，无法打印转正申请书");
		}
	}
	
	public void printWindow3(int companyId, int employeeId, int departmentId, Date endDate, String reason){
		if(employeeId > 0 && null != endDate && null != reason){
			DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy年MM月dd日");
			PopupWindow window = new PopupWindow();
			HTMLPane htmlPane = new HTMLPane();  
	        htmlPane.setWidth100();  
	        htmlPane.setHeight100();  
	        htmlPane.setShowEdges(true);  
	        htmlPane.setBackgroundColor("#fff");
	        StringBuilder sb = new StringBuilder();
			sb.append("	<style>")
			.append(" 		*{")
			.append("		font-family:'微软雅黑';")
			.append("} ")
			.append("		th{")
			.append("			font-weight:normal;")
			.append("		}")
			.append("		td{")
			.append("			text-align:center;")
			.append("		}")
			.append("	</style>")
			.append("    <div style='width: 750px;'>")
			.append("		<!--表格1内容star--> ")
			.append("		<div style='height:1090px;position: relative;'>  	")
			.append("			<!--表头star-->")
			.append("			<div style='height:43px; border-bottom: 1px solid #000;'>");
			if(companyId == 1){//深圳市博普森机电顾问有限公司
	        	sb.append("		<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
	        }else if(companyId == 2){//姜峰设计（深圳）有限公司
	        	sb.append("		<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
	        }else{
	        	sb.append("		<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
	        }
			sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62O-ARH　</font>")
			.append("			</div>")
			.append("			<!--表头over-->")
			.append("				<div style ='margin-top:100px;'>")
			.append("					<div style='text-align:center;font-size:36px;font-weight: bold;margin-bottom:130px;'> 离职申请书</div>")
			.append("					<p style='text-align:left; font-weight:bold; font-size:20px;'>尊敬的公司领导：</p>")
			.append("					<p style='text-align:left; font-size:20px;'>　　您好！</p>")
			.append("					<p style='text-align:left; font-size:20px; line-height:50px;'>　　兹有").append(KeyValueManager.getValue("company_records", companyId+"")).append("<u>　").append(KeyValueManager.getValue("departments", departmentId+"")).append("　</u>（部门）<u>　").append(KeyValueManager.getValue("employees", employeeId+"")).append("　</u>（姓名）因<u>　").append(reason).append("　</u>原因，无法继续为公司服务，特申请离职，计划离职日期<u>　").append(dateFormat.format(endDate)).append("　</u>，望领导予以批准。</p>")
			.append("					<p style='text-align:left; font-size:20px;'>　　此致</p>")
			.append("					<p style='text-align:left; font-size:20px;'>敬礼！</p>")
			.append("					<p style='text-align:right; font-size:20px; padding-right:150px; margin-top:50px;'>申请人（签名）：</p>")
			.append("					<p style='text-align:right; font-size:20px; padding-right:10px;'>年　　月　　日</p>")
			.append("				</div>							")
			.append("			<!--表尾star-->")
			.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 1 页 共 1 页</div>")
			.append("			<!--表尾over-->	")
			.append("		</div>")
			.append("		<!--表格1内容over-->     	")
			.append("    </div>");
	        htmlPane.setContents(sb.toString());  
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
			showPrintPreview(arr, null, "离职申请书", new PrintPreviewCallback() {
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
		}
	}
}
