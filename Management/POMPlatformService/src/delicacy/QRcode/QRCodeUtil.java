package delicacy.QRcode;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


/** 
 * 二维码生成工具 
 * @author ljheee 
 * 
 */  
public class QRCodeUtil {  
  
    private static final String CHARSET = "utf-8";  
    private static final String FORMAT_NAME = "JPG";  
    // 二维码尺寸  
    private static final int QRCODE_SIZE = 300;  
    // LOGO宽度  
    private static final int WIDTH = 60;  
    // LOGO高度  
    private static final int HEIGHT = 60;  
      
    private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
  
    /** 
     * 生成二维码 
     * @param content   源内容 
     * @param imgPath   生成二维码保存的路径 
     * @param needCompress  是否要压缩 
     * @return      返回二维码图片 
     * @throws Exception 
     */  
    private static BufferedImage createImage(String content, String imgPath, boolean needCompress) throws Exception {  
        Hashtable hints = new Hashtable();  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);  
        hints.put(EncodeHintType.MARGIN, 1);  
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,  
                hints);  
        int width = bitMatrix.getWidth();  
        int height = bitMatrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        for (int x = 0; x < width; x++) {  
            for (int y = 0; y < height; y++) {  
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);  
            }  
        }  
        if (imgPath == null || "".equals(imgPath)) {  
            return image;  
        }  
        // 插入图片  
        QRCodeUtil.insertImage(image, imgPath, needCompress);  
        return image;  
    }  
  
    /** 
     * 在生成的二维码中插入图片 
     * @param source 
     * @param imgPath 
     * @param needCompress 
     * @throws Exception 
     */  
    private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {  
        File file = new File(imgPath);  
        if (!file.exists()) {  
            System.err.println("" + imgPath + "   该文件不存在！");  
            return;  
        }  
        Image src = ImageIO.read(new File(imgPath));  
        int width = src.getWidth(null);  
        int height = src.getHeight(null);  
        if (needCompress) { // 压缩LOGO  
            if (width > WIDTH) {  
                width = WIDTH;  
            }  
            if (height > HEIGHT) {  
                height = HEIGHT;  
            }  
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);  
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            Graphics g = tag.getGraphics();  
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
            g.dispose();  
            src = image;  
        }  
        // 插入LOGO  
        Graphics2D graph = source.createGraphics();  
        int x = (QRCODE_SIZE - width) / 2;  
        int y = (QRCODE_SIZE - height) / 2;  
        graph.drawImage(src, x, y, width, height, null);  
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);  
        graph.setStroke(new BasicStroke(3f));  
        graph.draw(shape);  
        graph.dispose();  
    }  
  
    /** 
     * 生成带logo二维码，并保存到磁盘 
     * @param content 
     * @param imgPath   logo图片 
     * @param destPath 
     * @param needCompress 
     * @throws Exception 
     */  
    public static String encode(String content, String imgPath, String destPath, boolean needCompress) throws Exception {  
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);  
        mkdirs(destPath + "/images/qrcode/");  
        String file = SDF.format(new Date()) + "_" + Math.random() * (9999) + ".jpg";//生成随机文件名

        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/images/qrcode/" + file));
        return "/images/qrcode/" + file;
    }  
  
    public static void mkdirs(String destPath) {  
        File file = new File(destPath);  
        // 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir。(mkdir如果父目录不存在则会抛出异常)  
        if (!file.exists() && !file.isDirectory()) {  
            file.mkdirs();  
        }  
    }  
  
    public static String encode(String content, String imgPath, String destPath) throws Exception {  
        return QRCodeUtil.encode(content, imgPath, destPath, false);  
    }  
  
    public static String encode(String content, String destPath, boolean needCompress) throws Exception {  
        return QRCodeUtil.encode(content, null, destPath, needCompress);  
    }  
  
    public static void encode(String content, String destPath) throws Exception {  
        QRCodeUtil.encode(content, null, destPath, false);  
    }  
  
    public static void encode(String content, String imgPath, OutputStream output, boolean needCompress)  
            throws Exception {  
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);  
        ImageIO.write(image, FORMAT_NAME, output);  
    }  
  
    public static void encode(String content, OutputStream output) throws Exception {  
        QRCodeUtil.encode(content, null, output, false);  
    }  
  
      
    /** 
     * 从二维码中，解析数据 
     * @param file  二维码图片文件 
     * @return   返回从二维码中解析到的数据值 
     * @throws Exception 
     */  
    public static String decode(File file) throws Exception {  
        BufferedImage image;  
        image = ImageIO.read(file);  
        if (image == null) {  
            return null;  
        }  
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);  
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
        Result result;  
        Hashtable hints = new Hashtable();  
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);  
        result = new MultiFormatReader().decode(bitmap, hints);  
        String resultStr = result.getText();  
        return resultStr;  
    }  
  
    public static String decode(String path) throws Exception {  
        return QRCodeUtil.decode(new File(path));  
    }  
  
}  