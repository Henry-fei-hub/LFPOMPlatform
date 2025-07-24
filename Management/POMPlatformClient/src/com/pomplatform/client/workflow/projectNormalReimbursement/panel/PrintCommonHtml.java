package com.pomplatform.client.workflow.projectNormalReimbursement.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.NumberToCN;
import com.delicacy.client.data.BarCodeGWT;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.data.Record;

/**
 * 
 * @Title: PrintCommonHtml.java 
 * @Package com.pomplatform.client.workflow.projectNormalReimbursement.panel 
 * @Description: 打印功能公用模板
 * @author CL  
 * @date 2017年1月5日
 */
public class PrintCommonHtml {
	
	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] RECIVE_MONEY_ABELS = { "序号", "户名", "账号", "开户银行", "付款金额", "冲账金额"};
	
	public static final String[] RECIVE_MONEY_BORROW_ABELS = { "序号", "户名", "账号", "开户银行", "付款金额"};
	
	public static final String[] WORKFLOW_ABELS = { "审批人", "角色", "处理开始时间", "处理结束时间", "状态", "意见"};

	public static final String RECIVE_MONEY_TITLE = "收款方信息";
	
	public final static String ACTIVITIES_NAME = "activities";
	
	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");
	
	/**
	 * 
	 * @Title: workflowHtml 
	 * @Description: 流程面板定义
	 * @param @param record
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel workflowHtml(Record record){
		VerticalPanel vl = new VerticalPanel();
		//流程节点数据
//		Record processInstance = record.getAttributeAsRecord("processInstance");
//		Record[] activities = processInstance.getAttributeAsRecordArray(ACTIVITIES_NAME);
//		if (activities != null && activities.length > 0) {
//			for (Record record2 : activities) {
//				__LOGGER.info("workflow=" + record2.toMap().toString());
//				Record __record [] = record2.getAttributeAsRecordArray("tasks");
//				for (Record record3 : __record) {
//					__LOGGER.info("tasks=" + record3.toMap().toString());
//				}
//				
//			}
//			FlexTable decimalTable = new FlexTable();
//			decimalTable.setWidth("100%");
//			decimalTable.setBorderWidth(0);
//			decimalTable.setHTML(0, 0, "<img src='http://www.sohovita.com/files/projects/developers/69/photos/photos_20161223165206693.png'/>");
//			vl.setWidth("100%");
//			vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//			vl.setSpacing(10);
//			vl.add(decimalTable);
//			
//		}
		return vl;
	}
	
	/**
	 * 
	 * @Title: summaryTable 
	 * @Description: 汇总公用表格
	 * @param @param decimal
	 * @param @return   
	 * @return FlexTable   
	 * @throws
	 */
	public static FlexTable summaryTable(BigDecimal decimal){
		//添加汇总布局
		String cnMoney  = NumberToCN.number2CNMontrayUnit(decimal);
		FlexTable decimalTable = new FlexTable();
		decimalTable.setWidth("100%");
		decimalTable.setBorderWidth(0);
		decimalTable.setText(0, 0, "合计(大写): " + cnMoney);
		decimalTable.setText(0, 1, "合计: " + __NF.format(decimal));
		HTMLTable.CellFormatter oneCellFormatter = decimalTable.getCellFormatter();
		oneCellFormatter.setAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_MIDDLE);
		oneCellFormatter.setAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT, HasVerticalAlignment.ALIGN_MIDDLE);
		return decimalTable;
	}
	
	/**
	 * 
	 * @Title: headHtml 
	 * @Description: 公用头部
	 * @param @param title
	 * @param @param map
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel headHtml(String [] headAbels, String title , Map map, String applyEmployeeId){
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		
		String companyId = ClientUtil.getStringFromMap(map, "companyId");
		String departmentId = ClientUtil.getStringFromMap(map, "departmentId");
		
		HTML tital = new HTML(title);
		tital.getElement().getStyle().setFontSize(32, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);
		final HTML svgcontainer = new HTML();
		svgcontainer.setSize("226px", "50px");
		String code = ClientUtil.getStringFromMapNotNull(map, "code");
		final BarCodeGWT bc = new BarCodeGWT(getBarCode(code));
		bc.HEIGHT = 50;
		svgcontainer.getElement().appendChild(bc.generateSVG().getElement());
		vl.add(svgcontainer);

		FlexTable threeRowTable = new FlexTable();
		threeRowTable.setWidth("100%");
		threeRowTable.setBorderWidth(0);
		
		threeRowTable.setText(0, 0, headAbels[0]);
		threeRowTable.setText(0, 1, KeyValueManager.getValueMap("system_dictionary_26").get(companyId));
		threeRowTable.setHTML(0, 2, headAbels[1]);
		threeRowTable.setText(0, 3, ClientUtil.getStringFromMapNotNull(map, "code"));
		
		threeRowTable.setHTML(1, 0, headAbels[2]);
		threeRowTable.setHTML(1, 1, KeyValueManager.getValueMap("departments").get(departmentId));
		threeRowTable.setHTML(1, 2, headAbels[3]);
		threeRowTable.setHTML(1, 3, __DF.format((Date) map.get("applyTime")));
		
		threeRowTable.setText(2, 0, headAbels[4]);
		threeRowTable.setText(2, 1, KeyValueManager.getValueMap("employees").get(applyEmployeeId));
		threeRowTable.setHTML(2, 2, headAbels[5]);
		int currency = BaseHelpUtils.getIntValue(map.get("currency"));
		if(currency == 1){
			threeRowTable.setHTML(2, 3, "港币");
		}else if(currency == 2){
			threeRowTable.setHTML(2, 3, "美元");
		}else if(currency == 3){
			threeRowTable.setHTML(2, 3, "欧元");
		}else{
			threeRowTable.setHTML(2, 3, "元");
		}

		HTMLTable.CellFormatter oneCellFormatter = threeRowTable.getCellFormatter();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				switch (j) {
				case 0:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "11%");
					break;
				case 1:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "45%");
					break;
				case 2:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_RIGHT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "24%");
					break;
				case 3:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "20%");
					break;
				}
			}
		}
		vl.add(threeRowTable);
		return vl;
	}
	
	/**
	 * 
	 * @Title: footHtml 
	 * @Description: 公用底部
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel footHtml(){
		VerticalPanel vl = new VerticalPanel();
		vl.setHeight("100%");
		vl.setWidth("100%");
		vl.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		FlexTable footTable = new FlexTable();
		footTable.setWidth("100%");
		footTable.setBorderWidth(0);
		footTable.setText(0, 0, "审核: ");
		footTable.setText(0, 1, "复核: ");
		footTable.setHTML(0, 2, "出纳: &nbsp;&nbsp;&nbsp;");
		HTMLTable.CellFormatter oneCellFormatter = footTable.getCellFormatter();
		oneCellFormatter.setAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_MIDDLE);
		oneCellFormatter.setAlignment(0, 1, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
		oneCellFormatter.setAlignment(0, 2, HasHorizontalAlignment.ALIGN_RIGHT, HasVerticalAlignment.ALIGN_MIDDLE);
		oneCellFormatter.setWidth(0, 0, "33.3%");
		oneCellFormatter.setWidth(0, 1, "33.3%");
		oneCellFormatter.setWidth(0, 2, "33.3%");
		vl.add(footTable);
		vl.getElement().getStyle().setBottom(0, Style.Unit.PX);
		vl.getElement().getStyle().setPosition(Position.ABSOLUTE);
		return vl;
	}
	
	/**
	 * 
	 * @Title: generateReciveList 
	 * @Description: 收款方信息
	 * @param @param reciveList
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel generateReciveList(List<Map> reciveList) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(RECIVE_MONEY_TITLE);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = reciveList.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < RECIVE_MONEY_ABELS.length; i++) {
			orderItemContent.setText(0, i, RECIVE_MONEY_ABELS[i]);
		}
		double allMoney = 0;
		int count = 1;
		for (Map rr : reciveList) {
			int payFor = BaseHelpUtils.getIntValue(rr.get("payFor"));
//			String accountName = "";
//			String employeeOrCompanyId = BaseHelpUtils.getString("employeeOrCompanyId");
//			if(payFor == 1){
//				accountName = KeyValueManager.getValueMap("employees").get(employeeOrCompanyId);
//			}else{
//				accountName = KeyValueManager.getValueMap("receive_unit_manages_company").get(employeeOrCompanyId);
//			}
			orderItemContent.setText(count, 0, count + "");
			orderItemContent.setText(count, 1, BaseHelpUtils.getString(rr.get("payeeName")));
			orderItemContent.setText(count, 2, BaseHelpUtils.getString(rr.get("selfBankAccount")));
			orderItemContent.setText(count, 3, BaseHelpUtils.getString(rr.get("selfBankName")));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("payMoney"))));
			orderItemContent.setText(count, 5, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("balanceAmount"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("payMoney"));
			count++;
		}

		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < RECIVE_MONEY_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 4 || i== 5){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 4 || i== 5){
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		//添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}
	
	/**
	 * 
	 * @Title: generateReciveList 
	 * @Description: 收款方信息
	 * @param @param reciveList
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel generateMoneyReciveList(List<Map> reciveList) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(RECIVE_MONEY_TITLE);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = reciveList.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < RECIVE_MONEY_BORROW_ABELS.length; i++) {
			orderItemContent.setText(0, i, RECIVE_MONEY_BORROW_ABELS[i]);
		}
		double allMoney = 0;
		int count = 1;
		for (Map rr : reciveList) {
			int payFor = BaseHelpUtils.getIntValue(rr.get("payFor"));
//			String accountName = "";
//			String employeeOrCompanyId = BaseHelpUtils.getString("employeeOrCompanyId");
//			if(payFor == 1){
//				accountName = KeyValueManager.getValueMap("employees").get(employeeOrCompanyId);
//			}else{
//				accountName = KeyValueManager.getValueMap("receive_unit_manages_company").get(employeeOrCompanyId);
//			}
			orderItemContent.setText(count, 0, count + "");
			orderItemContent.setText(count, 1, BaseHelpUtils.getString(rr.get("payeeName")));
			orderItemContent.setText(count, 2, BaseHelpUtils.getString(rr.get("selfBankAccount")));
			orderItemContent.setText(count, 3, BaseHelpUtils.getString(rr.get("selfBankName")));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("payMoney"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("payMoney"));
			count++;
		}

		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < RECIVE_MONEY_BORROW_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 4){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 4){
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		//添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}
	
	
	/**
     * 
     * @Title: getBarCode  
     * @Description: 根据报销编码获取真实的条形码
     * @param @param code
     * @param @return
     * @return String 
     * @throws
     */
    public static String getBarCode(String code){
    	String barCode = null;
    	code = code.replace("-", "0");
    	code = code.length() == 11 ? "8" + code : code;
//    	a、从代码位置序号2开始，所有偶数位的数字代码求和。 
//    	b、将步骤a的和乘以3。 
//    	c、从代码位置序号3开始，所有奇数位的数字代码求和。 
//    	d、将步骤b与步骤c的结果相加。 
//    	e、用大于或等于步骤d所得结果且为10最小整数倍的数减去步骤d所得结果，其差即为所求校验码的值。 
    	
    	//计算校验码  计算出 奇数位和偶数位 的总和      		   13	12  11  10  9   8	7	6	5	4	3	2	1
    	//	X未知 校验码							2	0	1	6	1	2	0	0	0	3	6	8	X
    	int evenNumbers = 0;
    	int sigleNumbers = 0;
    	char [] codeArra = code.toCharArray();
    	for (int i = 0; i < codeArra.length; i++) {
			if(isBarCodeEvenNumbers(i)){
				evenNumbers += Integer.parseInt(codeArra[i] + "");
			}else{
				sigleNumbers += Integer.parseInt(codeArra[i] + "");
			}
		}
    	evenNumbers = evenNumbers * 3;//偶数位乘3   
    	
    	int allVal = evenNumbers + sigleNumbers;//奇数位总值加偶数位总值
    	//计算大于或等于步骤d所得结果且为10最小整数倍的数
    	int remainderNumber = allVal%10;
    	int	tenNumber = allVal + (10 - remainderNumber);
    	int checkNumber = tenNumber - allVal;
    	if(remainderNumber == 0){
    		barCode = code + "0";
    	}else{
    		barCode = code + checkNumber;
    	}
    	return barCode;
    }
    
    /**
     * 
     * @Title: isBarCodeEvenNumbers  
     * @Description: 获取自定义编码的奇偶数  return true is evenNumber; return false is not evenNumber;
     * @param @param val
     * @param @return
     * @return boolean 
     * @throws
     */
    public static boolean isBarCodeEvenNumbers(int val){
    	if(val%2 == 0){
    		return false;
    	}else{
    		return true;
    	}
    }
}
