package delicacy.servlet;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 *
 * @author lxf
 */
public class BarCodeUtils {
	private static Logger __logger = Logger.getLogger("");

    private static final int[][] EANA
        = {
            {0, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 1, 1}
        };
    private static final int[][] EANB
        = {
            {0, 1, 0, 0, 1, 1, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {0, 0, 1, 1, 0, 1, 1},
            {0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 1},
            {0, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 1, 1, 1}
        };
    private static final int[][] EANC
        = {
            {1, 1, 1, 0, 0, 1, 0},
            {1, 1, 0, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 1, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 0, 0},
            {1, 1, 1, 0, 1, 0, 0}
        };
    private static final int[][] EAND
        = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 1},
            {0, 0, 1, 1, 0, 1},
            {0, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 0}
        };
    private static final int[] EANSTM = {11, 13, 57, 59, 103, 105};

    private final int[] barcodeArray = new int[113];
    public int BARCODEUNIT = 2;
    public int HEIGHT = 120;
    String barcodeString;

    public BarCodeUtils(String strbc) {
        barcodeString = strbc;
        int fc = strbc.charAt(0) - '0';
        int[] larr = EAND[fc];
        for (int i = 1; i < 13; i++) {
            char c = strbc.charAt(i);
            int cc = c - '0';
            int[] bbcode;
            if (i < 7) {
                if (larr[i - 1] == 0) {
                    bbcode = EANA[cc];
                } else {
                    bbcode = EANB[cc];
                }
            } else {
                bbcode = EANC[cc];
            }
            int idx = i < 7 ? (i - 1) * 7 + 14 : (i - 7) * 7 + 61;
            System.arraycopy(bbcode, 0, barcodeArray, idx, 7);
        }
    }

    public void generateSVG(Element svgRoot) {
    	for (int i = 0; i < EANSTM.length; i++) {
            int x = EANSTM[i] * BARCODEUNIT;
            Element line = svgRoot.addElement("line");
            line.addAttribute("x1", String.valueOf(x));
            line.addAttribute("y1", "0");
            line.addAttribute("x2", String.valueOf(x));
            line.addAttribute("y2", String.valueOf(HEIGHT));
            line.addAttribute("stroke",SvgUtils.CSS_BLACK_VALUE);
            line.addAttribute("stroke-width", String.valueOf(BARCODEUNIT));
        }
        for (int i = 0; i < 113; i++) {
            if (barcodeArray[i] == 0) {
                continue;
            }
            int x = i * BARCODEUNIT;
            Element line = svgRoot.addElement("line");
            line.addAttribute("x1", String.valueOf(x));
            line.addAttribute("y1", "0");
            line.addAttribute("x2", String.valueOf(x));
            line.addAttribute("y2", String.valueOf(HEIGHT - 15));
            line.addAttribute("stroke", SvgUtils.CSS_BLACK_VALUE);
            line.addAttribute("stroke-width", String.valueOf(BARCODEUNIT));
        }
        Element text1 = svgRoot.addElement("text");
        text1.addAttribute("x", String.valueOf(3 * BARCODEUNIT + 1));
        text1.addAttribute("y", String.valueOf(HEIGHT - 2));
        text1.addAttribute("unitType", "5");
        text1.setText(String.valueOf(barcodeString.charAt(0)));
        text1.addAttribute("stroke", "black");
        text1.addAttribute("stroke-width", String.valueOf(BARCODEUNIT));
        
        for (int i = 1; i < 13; i++) {
            int idx = i < 7 ? (i - 1) * 7 + 14 : (i - 7) * 7 + 61;
            Element text = svgRoot.addElement("text");
            text.addAttribute("x", String.valueOf(idx * BARCODEUNIT + 1));
            text.addAttribute("y", String.valueOf(HEIGHT - 2));
            text.addAttribute("unitType", "5");
            text.setText(String.valueOf(String.valueOf(barcodeString.charAt(i))));
            text.addAttribute("stroke", SvgUtils.CSS_BLACK_VALUE);
            text.addAttribute("stroke-width", String.valueOf(BARCODEUNIT));
        }
    }
    
    /**
     * 创建svg文件
     * @param filename
     * @param titleName
     * @return
     */
    public int createSvgFiles(String filename, String titleName) {
		//返回操作结果，0表示失败，1表示成功
		int returnValue = 0;
		//建立document对象
		Document doc = SvgUtils.createSvgDom();
		//创建SVG文件根节点
		Element svgRoot = SvgUtils.createSvgRoot(doc);
		//设置标题
		SvgUtils.writeTitle(svgRoot, titleName);
		//创建二维码
		generateSVG(svgRoot);
		/** 将数据写入SVG文件 */
		if (SvgUtils.writeDataToFile(doc, filename))
			returnValue = 1;
		else
			returnValue = 0;
		return returnValue;
	}
    
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
		
		Element body = fo.addElement("body",SvgUtils.SVG_BODY_URI);
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
		td1.addAttribute("style",SvgUtils.CSS_TD_STYLE);
		td1.setText("数量");
		
		Element td2 = tr.addElement("td");
		td2.addAttribute("width","50%");
		td2.addAttribute("scope", "col");
		td2.addAttribute("style",SvgUtils.CSS_TD_STYLE);
		td2.setText("占比");
		
		/** 将数据写入SVG文件 */
		if (SvgUtils.writeDataToFile(doc, filename))
			returnValue = 1;
		else
			returnValue = 0;
		return returnValue;
	}
    
    public static void main(String[] args) {
    	BarCodeUtils bc = new BarCodeUtils("2019010000144");
    	String filename = "d:/test/1.svg";
		int resutl = bc.createSvgTableFile(filename, "项目日常报销");
		if(resutl == 1) {
			__logger.info("操作成功");
		}else {
			__logger.info("操作失败");
		}
	}

}

