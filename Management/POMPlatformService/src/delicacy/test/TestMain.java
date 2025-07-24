package delicacy.test;

import delicacy.common.GenericBase;
import delicacy.date.util.DateUtil;
import delicacy.socket.SocketUtils;
import java.io.StringReader;
import java.net.Socket;
import java.util.*;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import pomplatform.workflow.bean.ConditionOnLoadFlowNormalReimbursementsApplyBuisnessData;

public class TestMain {

    /**
     * Compress a string to a list of output symbols.
     */
    public static List<Integer> compress(String uncompressed) {
        // Build the dictionary.
        int dictSize = 256;
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < 256; i++) {
            dictionary.put("" + (char) i, i);
        }

        String w = "";
        List<Integer> result = new ArrayList<Integer>();
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc)) {
                w = wc;
            } else {
                result.add(dictionary.get(w));
                // Add wc to the dictionary.
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }

        // Output the code for w.
        if (!w.equals("")) {
            result.add(dictionary.get(w));
        }
        return result;
    }

    /**
     * Decompress a list of output ks to a string.
     */
    public static String decompress(List<Integer> compressed) {
        // Build the dictionary.
        int dictSize = 256;
        Map<Integer, String> dictionary = new HashMap<Integer, String>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(i, "" + (char) i);
        }

        String w = "" + (char) (int) compressed.remove(0);
        StringBuffer result = new StringBuffer(w);
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k)) {
                entry = dictionary.get(k);
            } else if (k == dictSize) {
                entry = w + w.charAt(0);
            } else {
                throw new IllegalArgumentException("Bad compressed k: " + k);
            }

            result.append(entry);

            // Add w+entry[0] to the dictionary.
            dictionary.put(dictSize++, w + entry.charAt(0));

            w = entry;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try {

            long time1 = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                ConditionOnLoadFlowNormalReimbursementsApplyBuisnessData c = new ConditionOnLoadFlowNormalReimbursementsApplyBuisnessData();
                c.setEmployeeId(378);
                c.setProcessType(3);
                c.setCurrentPage(1);
                c.setPageLines(10);
                pomplatform.workflow.handler.OnLoadFlowNormalReimbursementsApplyBuisnessDataHandler.executeQueryOnLoadFlowNormalReimbursementsApplyBuisnessData(c, null);
            }
            long time2 = System.currentTimeMillis();
            System.out.println("time used : " + (time2 - time1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
