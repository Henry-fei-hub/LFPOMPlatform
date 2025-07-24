package pomplatform.common.business;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.DelicacyServlet;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;

/**
 * 重置系统表的加密秘钥
 * @author lxf
 */
public class OnResetKeyValue implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            ThreadConnection.beginTransaction();
            //获取到新的秘钥
            String newKeyValue = BaseHelpUtils.getStringValue(result,"keyValue");
            //对新的秘钥进行加密
            DES des = new DES(DelicacyServlet.PUBLIC_KEY);
            String keyValue = des.ENC(newKeyValue);
            //更新系统表中的秘钥值
            SystemConfig dao = new SystemConfig();
            dao.setSystemConfigId(StaticUtils.SYSTEM_KEY2);
            //获取老的秘钥
            if(dao.load()){
                String oldKeyValue = BaseHelpUtils.getString(dao.getImagePath());
                dao.setImagePath(keyValue);
                dao.update();
//                //根据新的秘钥更新人工成本表中的人员薪资
//                EmployeeSalaryDetail daos = new EmployeeSalaryDetail();
//                daos.setSelectEmployeeSalaryDetailId(true);
//                daos.setSelectBasicSalary(true);
//                List<BaseEmployeeSalaryDetail> listBeans = daos.conditionalLoad();
//                if(!BaseHelpUtils.isNullOrEmpty(listBeans) && listBeans.size()>0){
//                    des = new DES(oldKeyValue);
//                    DES newDes = new DES(keyValue);
//                    for(BaseEmployeeSalaryDetail e : listBeans){
//                        String basicSalaryNew = BaseHelpUtils.getString(e.getBasicSalary());
//                        //用旧的秘钥先对基本薪资进行解密
//                        String basicSalary = des.DEC(basicSalaryNew);
//                        //用新的秘钥对基本薪资进行加密
//                        String basicSalaryOld = newDes.ENC(basicSalary);
//                        daos.clear();
//                        daos.setEmployeeSalaryDetailId(e.getEmployeeSalaryDetailId());
//                        if(daos.load()){
//                            daos.setBasicSalary(basicSalaryOld);
//                            daos.update();
//                        }
//                    }
//                }
            }
            ThreadConnection.commit();
        }
        BaseCollection bean = new BaseCollection();
        return bean.toJSON(0, null);
    }

}
