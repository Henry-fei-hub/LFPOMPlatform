/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delicacy.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.HashSet;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 *
 * @author Administrator
 */
public class TestWord {

    public static void main(String[] args) {
        try {
            HashSet<String> processors = new HashSet<>();
            processFile(new File("D:\\work\\common_new\\DelicacyCommon\\build\\classes"), "", processors);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public final static String ABSTRACTPROCESSOR = "delicacy.servlet.AbstractProcessores";
    
    public static void processFile(File file, String packageName, HashSet<String> processors) throws ClassNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String pn = packageName + (packageName.length() > 0 ? "." : "") + f.getName();
                processFile(f, pn, processors);
            }
        } else {
            if (!(file.getName().endsWith(".class"))) {
                return;
            }
            String className = packageName;
            int idx = className.lastIndexOf(".class");
            className = className.substring(0, idx);
            
            Class clazz = Class.forName(className);
            if(clazz.getName().equals(ABSTRACTPROCESSOR)) return;
            Class sc = clazz.getSuperclass();
            if(sc == null) return;
            if(!sc.getName().equals(ABSTRACTPROCESSOR)) return;
            processors.add(className);
        }
    }

}
