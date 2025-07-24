package pomplatform.common.business;

import com.pomplatform.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.DelicacyServlet;
import java.io.StringReader;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;

/**
 * 根据旧秘钥去检索是否匹配
 * @author lxf
 */
public class OnCheckKeyValue implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //初始化返回值操作失败
        int backResult = -2;
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            //获取到旧的秘钥
            String oldKeyValue = BaseHelpUtils.getStringValue(result,"oldKeyValue");
            //对旧的秘钥进行加密
            DES des = new DES(DelicacyServlet.PUBLIC_KEY);
            String keyValue = des.ENC(oldKeyValue);
            //更新系统表中的秘钥值
            SystemConfig dao = new SystemConfig();
            dao.setSystemConfigId(StaticUtils.SYSTEM_KEY2);
            //获取老的秘钥
            if(dao.load()){
                if(keyValue.equals(BaseHelpUtils.getString(dao.getImagePath()))){
                    backResult = 0;
                }else{
                    backResult = -1;
                }
            }
        }
        BaseCollection bean = new BaseCollection();
        return bean.toJSON(backResult, null);
    }

}
