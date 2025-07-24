package delicacy.email;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import delicacy.connection.ThreadUtil;
import message.common.SendEmailTemplate;

/**
 *
 * @author cl
 */
public class SendEmailUtils {

    private static final Logger __logger = Logger.getLogger(SendEmailUtils.class);
    
    public static boolean sendWelcomeEmail(String toEmail, String employeeName, String employeeNo, String departmentName, String jobs) {
        try {
            //获取发送内容
            StringBuilder msg = getJspToStr(ThreadUtil.getRealPath() + "/htmlEmail/welcome.html");
            String htmlStr = msg.toString();
            htmlStr = htmlStr.replace("###employeeName###",null == employeeName ? "" : employeeName)
            			.replace("###departmentName###", null == departmentName ? "" : departmentName)
            			.replace("###employeeNo###", null == employeeNo ? "" : employeeNo)
            			.replace("###jobs###", null == jobs ? "" : jobs);
            SendEmailTemplate.sendEmail(toEmail, null, htmlStr, "欢迎加入J&A family");
        } catch (Exception e) {
            __logger.error(String.format("发送欢迎新员工邮件失败  Cause by :{%1$s}", e.getMessage()));
            return false;
        }
        return true;
    }

    /**
     * 获取jsp页面将页面作为html页面发送
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public static StringBuilder getJspToStr(String filePath) throws Exception {
        StringBuilder builder;
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        try (BufferedReader reader = new BufferedReader(isr)) {
            builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n"); //appende a new line
            }
        }
        return builder;
    }

    public static void main(String[] args) throws Exception {
    	sendWelcomeEmail("chencai@jaid.cn", "逗逼彩", "JA2222222", "逗逼部门", "逗逼职位");
    }
}
