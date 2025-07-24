package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
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
 * @Title: SreimbursementpackagePrintPanel.java 
 * @Package com.pomplatform.client.sreimbursementpackagemmror.panel 
 * @Description: 汇总单信息打印
 * @author CL  
 * @date 2017年2月22日
 */
public class SreimbursementpackagePrintPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Map<String, Object> printData;
	
	public static final String[] TOP_ABELS = { "序号", "报销类型", "报销编号", "摘要", "报销金额", "进项税", "成本", "审批人", "复核" };

	public static final String[] CENTER_ABELS = {"序号", "报销科目", "报销选项", "报销金额"};
	
	public static final String[] BOTTOM_ABELS = {"序号", "收款方", "银行名称", "银行账号", "实付金额", "冲账金额"};
	
	public static final String [] HEAD_ABELS = {"汇 总 人:", "汇总时间:", "出&nbsp;&nbsp;纳:", "付款时间:", "付款单位:", "单位:"};
	
	public static final String MAIN_TITLE = "公司日常报销";

	public static final String TOP_TITLE = "报销单汇总信息";

	public static final String CENTER_TITLE = "科目汇总信息";
	
	public static final String BOTTOM_TITLE = "收款方汇总信息";
	
	
	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");

	public HTML generatePrintHTML() {
		HTML layout = new HTML();
		layout.setHeight("100%");
		Map map = getPrintData();
		__LOGGER.info(map.toString());
		//报销单汇总数据处理
		Record [] childZeroRecord = (Record[]) map.get("topData");
		List<Map> childZero = new ArrayList<>();
		double childZeroPay = 0d;
		double childZeroInputTax = 0d;
		for (Record record : childZeroRecord) {
			Map tmpMap = record.toMap();
			childZeroPay = childZeroPay + BaseHelpUtils.getDoubleValue(tmpMap.get("amount"));
			childZeroInputTax = childZeroInputTax + BaseHelpUtils.getDoubleValue(tmpMap.get("inputTax"));
			childZero.add(tmpMap);
		}
		if(childZero.size() > 0){
			Map childZeroMap = new HashMap<>();
			childZeroMap.put("amount", childZeroPay);
			childZeroMap.put("inputTax", childZeroInputTax);
			childZero.add(childZeroMap);
		}
		
		//科目汇总信息数据处理
		double childOnePay = 0d;
		Record [] childOneRecord = (Record[]) map.get("centerData");
		List<Map> childOne = new ArrayList<>();
		for (Record record : childOneRecord) {
			Map tmpMap = record.toMap();
			childOnePay = childOnePay + BaseHelpUtils.getDoubleValue(tmpMap.get("amount"));
			childOne.add(tmpMap);
		}
		if(childOne.size() > 0){
			Map childOneMap = new HashMap<>();
			childOneMap.put("amount", childOnePay);
			childOne.add(childOneMap);
		}
		
		//收款方汇总信息
		double childTwoPay = 0d;
		double childTwoBlance = 0d;
		Record [] childTwoRecord = (Record[]) map.get("bottomData");
		List<Map> childTwo = new ArrayList<>();
		for (Record record : childTwoRecord) {
			Map tmpMap = record.toMap();
			childTwoPay = childTwoPay + BaseHelpUtils.getDoubleValue(tmpMap.get("paymentAmount"));
			childTwoBlance = childTwoBlance + BaseHelpUtils.getDoubleValue(tmpMap.get("strikeABalanceAmount"));
			childTwo.add(tmpMap);
		}
		if(childTwo.size() > 0 ){
			Map childTwoMap = new HashMap<>();
			childTwoMap.put("paymentAmount", childTwoPay);
			childTwoMap.put("strikeABalanceAmount", childTwoBlance);
			childTwo.add(childTwoMap);
		}
		
		layout.getElement().appendChild(headHtml(map).getElement());
		layout.getElement().appendChild(generateMianData(childZero).getElement());
		if(childOne.size() > 0 ){
			layout.getElement().appendChild(generateChildOneList(childOne).getElement());
		}
		layout.getElement().appendChild(generateChildTwoList(childTwo).getElement());
//		layout.getElement().appendChild(footHtml().getElement());
		return layout;
	}
	
	public static VerticalPanel headHtml(Map map){
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		
		String operatorId = ClientUtil.getStringFromMap(map, "operatorId");
		String companyId = ClientUtil.getStringFromMap(map, "companyId");
		
		HTML tital = new HTML("报销汇总单");
		tital.getElement().getStyle().setFontSize(32, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);
		final HTML svgcontainer = new HTML();
		svgcontainer.setSize("226px", "50px");
		int packageId = BaseHelpUtils.getIntValue(map, "reimbursementPackageId");
		String code = getBarCode(packageId);
		final BarCodeGWT bc = new BarCodeGWT(code);
		bc.HEIGHT = 50;
		svgcontainer.getElement().appendChild(bc.generateSVG().getElement());
		vl.add(svgcontainer);

		FlexTable threeRowTable = new FlexTable();
		threeRowTable.setWidth("100%");
		threeRowTable.setBorderWidth(0);
		
		threeRowTable.setText(0, 0, HEAD_ABELS[0]);
		threeRowTable.setText(0, 1, KeyValueManager.getValueMap("employees").get(operatorId));
		threeRowTable.setHTML(0, 2, HEAD_ABELS[1]);
		threeRowTable.setText(0, 3, __DF.format((Date) map.get("createTime")));
		
		threeRowTable.setHTML(1, 0, HEAD_ABELS[2]);
		threeRowTable.setHTML(1, 1, "");
		threeRowTable.setHTML(1, 2, HEAD_ABELS[3]);
		threeRowTable.setHTML(1, 3, "");
		
		threeRowTable.setText(2, 0, HEAD_ABELS[4]);
		threeRowTable.setText(2, 1, KeyValueManager.getValueMap("system_dictionary_26").get(companyId));
		threeRowTable.setHTML(2, 2, HEAD_ABELS[5]);
		threeRowTable.setHTML(2, 3, "元");

		HTMLTable.CellFormatter oneCellFormatter = threeRowTable.getCellFormatter();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				switch (j) {
				case 0:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "10%");
					break;
				case 1:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "50%");
					break;
				case 2:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_RIGHT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "25%");
					break;
				case 3:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "15%");
					break;
				}
			}
		}
		vl.add(threeRowTable);
		return vl;
	}
	
	public static VerticalPanel footHtml(){
		VerticalPanel vl = new VerticalPanel();
		vl.setHeight("100%");
		vl.setWidth("100%");
		vl.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		FlexTable footTable = new FlexTable();
		footTable.setWidth("100%");
		footTable.setBorderWidth(0);
		footTable.setText(0, 0, "付款人: ");
		footTable.setText(0, 1, "");
		footTable.setHTML(0, 2, "付款时间: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
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
	 * @Title: generateChildTwoList 
	 * @Description: 收款方数据
	 * @param @param childTwoList
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel generateChildTwoList(List<Map> childTwoList) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(BOTTOM_TITLE);
		tital.getElement().getStyle().setFontSize(14, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = childTwoList.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < BOTTOM_ABELS.length; i++) {
			orderItemContent.setText(0, i, BOTTOM_ABELS[i]);
		}
		double allMoney = 0;
		int count = 1;
		for (int i = 0; i < childTwoList.size(); i++) {
			Map rr = childTwoList.get(i);
			if(count == childTwoList.size()){
				orderItemContent.setText(count, 0, "汇总");
			}else{
				orderItemContent.setText(count, 0, count + "");
			}
			orderItemContent.setText(count, 1, BaseHelpUtils.getStringValue(rr, "payeeName"));
			orderItemContent.setText(count, 2, BaseHelpUtils.getStringValue(rr, "selfBankName"));
			orderItemContent.setText(count, 3, BaseHelpUtils.getStringValue(rr, "selfBankAccount"));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("paymentAmount"))));
			orderItemContent.setText(count, 5, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("strikeABalanceAmount"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("paymentAmount"));
			count++;
		}

		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < BOTTOM_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(12, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 4 || i == 5){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					} else if(i ==1 || i == 2 || i == 3){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_LEFT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					} else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 4 || i == 5){
					cellFormatter.getElement(y, i).getStyle().setWidth(90, Style.Unit.PX);
				}
				if(i == 0){
					cellFormatter.getElement(y, i).getStyle().setWidth(34, Style.Unit.PX);
				}
			}
		}
		//添加汇总模块
//		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		
		return vl;
	}

	public static VerticalPanel generateChildOneList(List<Map> childOneList) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(CENTER_TITLE);
		tital.getElement().getStyle().setFontSize(14, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = childOneList.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < CENTER_ABELS.length; i++) {
			orderItemContent.setText(0, i, CENTER_ABELS[i]);
		}

		double allMoney = 0;
		int count = 1;
		for (int i = 0; i < childOneList.size(); i++) {
			Map rr = childOneList.get(i);
			if(count == childOneList.size()){
				orderItemContent.setText(count, 0, "汇总");
			}else{
				orderItemContent.setText(count, 0, count + "");
			}
			String mainItemId = BaseHelpUtils.getStringValue(rr, "mainItemId");
			String subItemId = BaseHelpUtils.getStringValue(rr, "subItemId");
//			orderItemContent.setText(count, 1, BaseHelpUtils.getString(rr.get("remark")));
			orderItemContent.setText(count, 1, KeyValueManager.getValueMap("parent_subject_types").get(mainItemId));
			orderItemContent.setText(count, 2, KeyValueManager.getValueMap("subject_types").get(subItemId));
			orderItemContent.setText(count, 3, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("amount"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("amount"));
			count++;
		}

		vl.add(orderItemContent);

		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < CENTER_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(12, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 3){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					} else if(i ==1 || i == 2){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_LEFT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					} else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 3){
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
				if(i == 1 || i ==2){
					cellFormatter.getElement(y, i).getStyle().setWidth(120, Style.Unit.PX);
				}
				if(i == 0){
					cellFormatter.getElement(y, i).getStyle().setWidth(34, Style.Unit.PX);
				}
			}
		}
		//添加汇总模块
//		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}

	/**
	 * 
	 * @Title: generateMianData 
	 * @Description: 主表数据HTML构建 
	 * @param @param map 
	 * @param @return 
	 * @return VerticalPanel 
	 * @throws
	 */
	public static VerticalPanel generateMianData(List<Map> dataListMap) {
		
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(TOP_TITLE);
		tital.getElement().getStyle().setFontSize(14, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);
		
		int length = dataListMap.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();
		// 设置表头
		for (int i = 0; i < TOP_ABELS.length; i++) {
			orderItemContent.setText(0, i, TOP_ABELS[i]);
		}
		// 第二行数据
		int count = 1;
		double allMoney = 0;
		for (int i = 0; i < dataListMap.size(); i++) {
			Map rr = dataListMap.get(i);
			String processType = BaseHelpUtils.getStringValue(rr, "processType");
			if(count == dataListMap.size()){
				orderItemContent.setText(count, 0, "汇总");
			}else{
				orderItemContent.setText(count, 0, count + "");
			}
			
			orderItemContent.setText(count, 1, KeyValueManager.getValueMap("system_process_types").get(processType));
			orderItemContent.setText(count, 2, BaseHelpUtils.getStringValue(rr, "code"));
			orderItemContent.setText(count, 3, BaseHelpUtils.getStringValue(rr, "processComment"));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("amount"))));
			orderItemContent.setText(count, 5, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("inputTax"))));
			orderItemContent.setText(count, 6, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("amount")) - BaseHelpUtils.getDoubleValue(rr.get("inputTax"))));
			orderItemContent.setText(count, 7, BaseHelpUtils.getStringValue(rr, "approveName"));
			orderItemContent.setText(count, 8, BaseHelpUtils.getStringValue(rr, "financeName"));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("amount"));
			count ++;
		}
		
		vl.add(orderItemContent);

		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < TOP_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(12, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 4 || i == 5 || i == 6){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else if(i == 1 || i == 2 || i== 3){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_LEFT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 0){
					cellFormatter.getElement(y, i).getStyle().setWidth(30, Style.Unit.PX);
				}
				if(i == 1 || i == 2){
					cellFormatter.getElement(y, i).getStyle().setWidth(80, Style.Unit.PX);
				}
				if(i == 3){
					cellFormatter.getElement(y, i).getStyle().setWidth(240, Style.Unit.PX);
				}
				if(i == 4 || i == 5 || i == 6){
					cellFormatter.getElement(y, i).getStyle().setWidth(55, Style.Unit.PX);
				}
				if(i == 7 || i == 8){
					cellFormatter.getElement(y, i).getStyle().setWidth(50, Style.Unit.PX);
				}
				
			}
		}
		//添加汇总模块
//		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}


	public Map<String, Object> getPrintData() {
		return printData;
	}


	public void setPrintData(Map<String, Object> printData) {
		this.printData = printData;
	}
	
    public static String getBarCode(int packageId){
    	String barCode = null;
    	String packageIdStr = packageId + "";
    	int subLength = 12 - packageIdStr.length();
    	String code = "";
    	String zeroStr = "";
    	for (int i = 0; i < subLength; i++) {
    		zeroStr += "0";
		}
    	code = zeroStr + packageIdStr;
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
