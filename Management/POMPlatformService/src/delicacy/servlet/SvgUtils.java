package delicacy.servlet;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author lxf 用来生成svg背景用的图形，包括标题和标签
 */
public class SvgUtils {
	public static String SVG_SVG_TAG = "svg";
	public static String SVG_PUBLIC_ID = "-//W3C//DTD SVG 1.1//EN";
	public static String SVG_SYSTEM_ID = "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd";
	public static String SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg";
	public static String SVG_BODY_URI = "http://www.w3.org/1999/xhtml";
	
	public static String CSS_STROKE_PROPERTY = "stroke";
	public static String CSS_STROKE_WIDTH_PROPERTY = "stroke-width";
	public static String CSS_TD_STYLE = "border:1px solid #ccc;background:#fff;line-height:37px;color:#999;font-size:14px;text-align:center;font-family:微软雅黑;font-size:16px";

	public static String CSS_BLACK_VALUE = "black";
	
	public static int canvasWidth = 800; // 画布宽度
	public static int canvasHeight = 600; // 画布高度
	public static int mapWidth = 480; // 绘图区宽度
	public static int mapHeight = 300; // 绘图区高度
	public static int zeroX = 30; // 原点x坐标
	public static int zeroY = 40; // 原点y坐标
	public static int yStep = 30; // y轴步进长度（像素）
	public static int dataNum = 0; // 数据总数，默认值为0

	public int BARCODEUNIT = 2;
	public int HEIGHT = 100;
	String barcodeString;

	private String[] lineColors = { "#00008B", "#8A2BE2", "#FFEBCD", "#A52A2A", "#DEB887", "#5F9EA0", "#7FFF00",
			"#D2691E", "#FF7F50", "#6495ED" };

	/** Creates a new instance of BackgroundMap */
	public SvgUtils() {

	}

	/**
	 * 建立一个SVG文件，文件名由输入参数决定
	 * 
	 * @param filename
	 *            {String} 需要建立的文件名
	 * @param titleName
	 *            {String} 标题名
	 * @param pData
	 *            {String[]} 要绘制的数据源
	 * @param pDataName
	 *            {String[]} x轴标识
	 * @return 返回操作结果，0表示失败，1表示成功
	 **/
	public int createSvgFile(String filename, String titleName, String[] pData, String[] pDataName) {
		// 返回操作结果，0表示失败，1表示成功
		int returnValue = 0;
		// 建立document对象
		Document document = createSvgDom();
		// 创建SVG文件根节点
		Element svgRoot = createSvgRoot(document);
		// 设置标题
		writeTitle(svgRoot, titleName);
		// 设置背景
		WriteBackGround(svgRoot);
		// 设置数据
		// WriteDataLine(svgRoot, pData, pDataName);

		/** 将数据写入SVG文件 */
		if (writeDataToFile(document, filename))
			returnValue = 1;
		else
			returnValue = 0;
		return returnValue;
	}


	/**
	 * 创建SVG DOM
	 **/
	public static Document createSvgDom() {
		// 建立document对象
		Document doc = DocumentHelper.createDocument();
		// 设置文件编码
		doc.setXMLEncoding("UTF-8");
		// !DOCTYPE声明
		doc.addDocType(SVG_SVG_TAG, SVG_PUBLIC_ID,SVG_SYSTEM_ID);
		return doc;
	}

	/**
	 * 创建SVG文件根节点
	 * 
	 * @param document
	 *            {Document} 文档节点
	 * @return SVG根节点
	 **/
	public static Element createSvgRoot(Document document) {
		/** 建立SVG文档的根svg */
		Element svgRoot = document.addElement(SVG_SVG_TAG,SVG_NAMESPACE_URI);
		svgRoot.addAttribute("width", Integer.toString(canvasWidth));
		svgRoot.addAttribute("height", Integer.toString(canvasHeight));
		svgRoot.addAttribute("font-family", "SimSun");
		return svgRoot;
	}

	/**
	 * 将数据写入SVG文件
	 * 
	 * @param document
	 * @param filename
	 * @return
	 */
	public static boolean writeDataToFile(Document document, String filename) {
		try {
			/** 将document中的内容写入文件中 */
			OutputFormat format = OutputFormat.createPrettyPrint();
			// format.setEncoding("UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
			XMLWriter writer = new XMLWriter(osw, format);
			// XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)),format);
			writer.write(document);
			writer.close();
			/** 执行成功，返回1 */
			return true;
		} catch (Exception ex) {
			System.out.println("写SVG文件时出错！");
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * 绘制SVG的背景及坐标网格
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 **/
	private void WriteBackGround(Element svgRoot) {
		/** 画布景 */
		Element canvRec = svgRoot.addElement("ellipse");
		canvRec.addAttribute("cx", "300");
		canvRec.addAttribute("cy", "150");
		canvRec.addAttribute("rx", "200");
		canvRec.addAttribute("ry", "80");
		canvRec.addAttribute("fill", "rgb(200,100,50)");
		canvRec.addAttribute("stroke", "rgb(0,0,100)");
		canvRec.addAttribute("stroke-width", "2");

		// Element circle = svgRoot.addElement("circle");
		// circle.addAttribute("cx", "300");
		// circle.addAttribute("cy", "400");
		// circle.addAttribute("r", "100");
		// circle.addAttribute("fill", "red");
		// circle.addAttribute("stroke", "black");
		// circle.addAttribute("stroke-width", "2");
		//
		// Element text = svgRoot.addElement("text");
		// text.addAttribute("x", "300");
		// text.addAttribute("y", "400");
		// text.addAttribute("fill", "yellow");
		// text.addAttribute("stroke", "black");
		// text.addAttribute("stroke-width", "2");
		// text.setText("<p>测试</p>");

		Element table = svgRoot.addElement("table");
		table.addAttribute("x", "100");
		table.addAttribute("y", "220");
		table.addAttribute("width", "100");
		table.addAttribute("height", "200");
		table.addAttribute("fill", "yellow");
		table.addAttribute("stroke", "black");
		// table.addAttribute("stroke-width", "2");
		// table.setText("<p>测试dfsdfds</p>");

		// Element tspan = svgRoot.addElement("tspan");
		// tspan.addAttribute("x", "300");
		// tspan.addAttribute("y", "420");
		// tspan.setText("测试span");
		// text.add(tspan);
	}

	/**
	 * 书写标题
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param titleName
	 *            {String} 标题名
	 **/
	public static void writeTitle(Element svgRoot, String titleName) {
		int wordNum = titleName.length(); // 标题字符个数
		int font_size; // 字体大小
		int titleLength; // 标题字符串栅格长度
		int x, y; // 标题起始位置
		if (wordNum <= 40) {
			font_size = 20;
		} else {
			font_size = canvasWidth / wordNum;
		}
		titleLength = font_size * wordNum;
		x = (canvasWidth - titleLength) / 2;
		y = (zeroY - font_size);

		/** 绘标题元素 */
		Element title = svgRoot.addElement("text");
		title.addAttribute("x", Integer.toString(x));
		title.addAttribute("y", Integer.toString(y));
		title.addAttribute("fill", "black");
		title.addAttribute("font-size", Integer.toString(font_size));
		title.setText(titleName);
	}

	/**
	 * 绘制折线，x轴刻度，x轴刻度名称，y轴刻度值
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param pData
	 *            {String[]} 要绘制折线的数据
	 * @param pDataName
	 *            {String[]} x轴刻度名称
	 **/
	private void WriteDataLine(Element svgRoot, String[] pData, String[] pDataName) {
		/* 绘制x轴信息 */
		double[] xAxis = WriteXData(svgRoot, pDataName);
		/* 获取double型数据 */
		double[] data = convertDataToDouble(pData);
		/* y轴刻度值 */
		WriteYData(svgRoot, data);
		/** 绘制数据折线 */
		WriteLine(svgRoot, data, xAxis, lineColors[0]);
	}

	/**
	 * 绘制折线，x轴刻度，x轴刻度名称，y轴刻度值
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param pData
	 *            {String[][]} 要绘制折线的数据
	 * @param pDataName
	 *            {String[]} x轴刻度名称
	 **/
	private void WriteDataLine(Element svgRoot, String[][] pData, String[] pDataName) {
		/* 绘制x轴信息 */
		double[] xAxis = WriteXData(svgRoot, pDataName);
		/* 获取double型数据 */
		double[][] data = convertDataToDouble(pData);
		double[] tempValue = ChangePlanarQueue(data);
		/* y轴刻度值 */
		WriteYData(svgRoot, tempValue);
		/** 绘制数据折线 */
		WriteLine(svgRoot, data, xAxis);
	}

	/**
	 * 将二维数组转换为一维数组
	 **/
	private double[] ChangePlanarQueue(double[][] data) {
		double[] tempValue = new double[dataNum];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				tempValue[i * data[i].length + j] = data[i][j];
			}
		}
		return tempValue;
	}

	/**
	 * 绘制x轴刻度线和x轴标识
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param pDataName
	 *            {String[]} x轴刻度名称
	 * @return double[] x刻度的x轴坐标
	 **/
	private double[] WriteXData(Element svgRoot, String[] pDataName) {
		double xStep = (new BigDecimal(mapWidth / (pDataName.length - 1)).setScale(3, BigDecimal.ROUND_HALF_UP))
				.doubleValue();
		double[] xAxis = new double[pDataName.length]; // 保存每个x轴刻度值的数组
		xAxis[0] = zeroX; // x轴第一个刻度为y轴
		// System.out.println("length:"+pDataName.length);
		/** x轴刻度线 */
		for (int i = 1; i < pDataName.length; i++) {
			// i=0时的y线不用绘制
			// double tempX1 = i == 0 ? zeroX + i * xStep : zeroX + i * xStep + 10;
			// //每根X轴刻度线的起始位置
			double tempX1 = zeroX + i * xStep;
			// System.out.println(i+":"+tempX1);
			xAxis[i] = tempX1; // 保存每个x轴刻度值
			Element line = svgRoot.addElement("line");
			line.addAttribute("x1", Double.toString(tempX1));
			line.addAttribute("y1", Integer.toString(zeroY + mapHeight));
			line.addAttribute("x2", Double.toString(tempX1));
			line.addAttribute("y2", Integer.toString(zeroY));
			line.addAttribute("stroke-width", "1");
			line.addAttribute("stroke-dasharray", "3 2");
			line.addAttribute("stroke", "#333300");
		}
		/** 添加X轴字段说明 字无法在一行内显示的话，需要换行 */
		for (int i = 0; i < pDataName.length; i++) {
			int n = (int) xStep / 13; // 每行显示几个字符
			int m = pDataName[i].length() % n == 0 ? pDataName[i].length() / n : (int) (pDataName[i].length() / n + 1); // 总共显示几行
			int l = 0; // 记录总共处理了多少字符
			int font_size = 13; // 字体大小

			if (m > 1) {
				Element xName = svgRoot.addElement("text");
				xName.addAttribute("fill", "blue");
				xName.addAttribute("font-size", Integer.toString(font_size));
				xName.addAttribute("font-family", "SimSun");
				for (int j = 0; j < m; j++) {
					for (int z = 0; z < n; z++) {
						l = j * n + z;
						if (l == pDataName[i].length()) {
							break;
						}
						Element tspan = xName.addElement("tspan");
						tspan.addAttribute("x", Double.toString(xAxis[i]));
						tspan.addAttribute("y", Integer.toString(zeroY + mapHeight + font_size + j * (font_size + 3)));
						tspan.setText(pDataName[i].substring(l, l + 1));
					}
					if (l == pDataName[i].length()) {
						break;
					}
				}
			} else {
				double textOffset = pDataName[i].length() * font_size / 2;
				Element xName = svgRoot.addElement("text");
				xName.addAttribute("x", Double.toString(xAxis[i] - textOffset));
				xName.addAttribute("y", Integer.toString(zeroY + mapHeight + font_size));
				xName.addAttribute("fill", "blue");
				xName.addAttribute("font-size", Integer.toHexString(font_size));
				xName.addAttribute("font-family", "SimSun");
				xName.setText(pDataName[i]);
			}
		}

		return xAxis;
	}

	/**
	 * 绘制y轴刻度值
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param data
	 *            {double} 要绘制折线的数据
	 * @return double[] y轴最大最小值
	 **/
	private void WriteYData(Element svgRoot, double[] data) {
		double[] extr = GetExtremum(data);
		int maxValue = (int) (extr[0] - extr[1]);
		int valueX; // Y轴刻度值起始的X坐标
		int font_size;
		if (maxValue > 10000) {
			valueX = 5;
			font_size = 9;
		} else {
			valueX = 10;
			font_size = 11;
		}
		for (int i = 0; i < 11; i++) {
			Element yName = svgRoot.addElement("text");
			yName.addAttribute("x", Integer.toString(valueX));
			yName.addAttribute("y", Integer.toString(zeroY + i * yStep));
			yName.addAttribute("fill", "black");
			yName.addAttribute("font-family", "SimSun");
			yName.addAttribute("font-size", Integer.toString(font_size));
			yName.setText(Integer.toString((maxValue / 10) * (10 - i) + (int) extr[1]));
		}
	}

	/**
	 * 绘制数据折线
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param data
	 *            {double[]} 需要绘制的数据
	 * @param xAxis
	 *            {double[]} x轴刻度坐标值
	 **/
	private void WriteLine(Element svgRoot, double[] data, double[] xAxis, String lineColor) {
		String strPoints = "";
		double[] extr = GetExtremum(data); // 获取data的最大最小值
		int yValueStep = (int) (extr[0] - extr[1]);
		for (int i = 0; i < xAxis.length; i++) {
			double valueSpan = data[i] - extr[1];
			double ySpan = valueSpan / yValueStep * mapHeight;
			strPoints += xAxis[i] + "," + (zeroY + mapHeight - ySpan) + " ";
		}

		Element dataLine = svgRoot.addElement("polyline");
		dataLine.addAttribute("stroke-width", "2");
		dataLine.addAttribute("stroke", lineColor);
		dataLine.addAttribute("fill", "none");
		dataLine.addAttribute("points", strPoints.trim());
	}

	/**
	 * 绘制数据折线
	 * 
	 * @param svgRoot
	 *            {Element} SVG根节点
	 * @param data
	 *            {double[][]} 需要绘制的数据
	 * @param xAxis
	 *            {double[]} x轴刻度坐标值
	 **/
	private void WriteLine(Element svgRoot, double[][] data, double[] xAxis) {
		String strPoints = "";
		double[] tempValue = ChangePlanarQueue(data);
		double[] extr = GetExtremum(tempValue); // 获取data的最大最小值
		int yValueStep = (int) (extr[0] - extr[1]);
		Element dataLine;
		for (int i = 0; i < data.length; i++) {
			strPoints = "";
			for (int j = 0; j < data[i].length; j++) {
				double valueSpan = data[i][j] - extr[1];
				double ySpan = valueSpan / yValueStep * mapHeight;
				strPoints += xAxis[j] + "," + (zeroY + mapHeight - ySpan) + " ";
			}
			dataLine = svgRoot.addElement("polyline");
			dataLine.addAttribute("stroke-width", "2");
			dataLine.addAttribute("stroke", lineColors[i % lineColors.length]);
			dataLine.addAttribute("fill", "none");
			dataLine.addAttribute("points", strPoints.trim());
		}
	}

	/**
	 * 将元数据从String转换成double
	 *
	 * @param data
	 *            字符串数组形式的元数据
	 *
	 * @return 转换好的数据
	 **/
	static double[] convertDataToDouble(String[] data) {
		double[] dData = new double[data.length];
		dataNum = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null && !data[i].equalsIgnoreCase("") && !data[i].equalsIgnoreCase(" ")) {
				dData[i] = Double.valueOf(data[i]).doubleValue();
			} else {
				dData[i] = new Double(0.0).doubleValue();
			}
			dataNum += 1;
		}
		return dData;
	}

	/**
	 * 将元数据从String转换成double，用于多折线
	 *
	 * @param data
	 *            字符串数组形式的元数据
	 *
	 * @return 转换好的数据
	 */
	static double[][] convertDataToDouble(String[][] data) {
		double[][] dData = new double[data.length][data[0].length];
		dataNum = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] != null && !data[i][j].equalsIgnoreCase("") && !data[i][j].equalsIgnoreCase(" ")) {
					dData[i][j] = Double.parseDouble(data[i][j]);// Double.valueOf(data[i][j]).doubleValue();
					dataNum += 1;
				} else {
					dData[i][j] = new Double(0.0).doubleValue();
					dataNum += 1;
				}
			}
		}
		return dData;
	}

	/**
	 * 获得原始数据中的最大值和最小值
	 * 
	 * @param {double[]}
	 *            pData 原始数据
	 * @return {double[]} 最大值和最小值 0位保存最大值 1位保存最小值
	 **/
	static double[] GetExtremum(double[] pData) {
		double max = pData[0];
		double min = pData[0];
		double[] mum = new double[2];

		/** 获取数组中最大最小值 */
		for (int i = 0; i < pData.length; i++) {
			if (pData[i] > max)
				max = pData[i];
			if (pData[i] < min)
				min = pData[i];
		}

		/** 将最大最小值整数化 */
		max = Math.ceil(max);
		min = Math.floor(min);
		if (Math.abs(min) <= 1 && max <= 1)
			min = -1;
		else {
			min = min < 100 ? Math.ceil(min / 10) * 10 : Math.ceil(min / 50) * 50;
		}

		mum[0] = max;
		mum[1] = min;
		return mum;
	}
	
	/**
	 * 创建表格
	 * @param filename
	 * @param titleName
	 * @return
	 */
	public int createSvgTableFile(String filename, String titleName) {
		//返回操作结果，0表示失败，1表示成功
		int returnValue = 0;
		//建立document对象
		Document doc = SvgUtils.createSvgDom();
		//创建SVG文件根节点
		Element svgRoot = SvgUtils.createSvgRoot(doc);
		//设置标题
//		SvgUtils.writeTitle(svgRoot, titleName);
		
		Element fo = svgRoot.addElement("foreignObject");
		fo.addAttribute("x","0");
		fo.addAttribute("y", "0");
		fo.addAttribute("width","600");
		fo.addAttribute("height", "500");
		
		Element body = fo.addElement("body",SVG_BODY_URI);
		body.addAttribute("width","100%");
		body.addAttribute("height", "100%");
		
		Element table = body.addElement("table");
		table.addAttribute("border","2");
		table.addAttribute("cellpadding", "0");
		table.addAttribute("cellspacing","0");
		table.addAttribute("width","100%");
		table.addAttribute("height", "100%");
		
		Element tr = table.addElement("tr");
		
		
		Element td1 = tr.addElement("td");
		td1.addAttribute("width","50%");
		td1.addAttribute("scope", "col");
		td1.addAttribute("style",CSS_TD_STYLE);
		td1.setText("数量");
		
		Element td2 = tr.addElement("td");
		td2.addAttribute("width","50%");
		td2.addAttribute("scope", "col");
		td2.addAttribute("style",CSS_TD_STYLE);
		td2.setText("占比");
		
		/** 将数据写入SVG文件 */
		if (SvgUtils.writeDataToFile(doc, filename))
			returnValue = 1;
		else
			returnValue = 0;
		return returnValue;
	}

	public static void main(String[] args) {
		SvgUtils instance = new SvgUtils();
		String filename = "d:/test/1.svg";
		String[][] data = { { "54", "44", "122" }, { "10", "12", "-468" }, { "78", "520", "10" } };
		String[] data1 = { "54", "4424.225", "12200", "-4658" };
		String[] dataName = { "营业所一", "二二二二", "III", "adf" };
		// int result = instance.createSvgFile(filename, "测试实例", data1, dataName);

	}
}
