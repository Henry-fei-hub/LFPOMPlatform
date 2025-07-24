package pomplatform.common.business;

import com.pomplatform.db.bean.BasePlateIntegralTransferRecord;
import com.pomplatform.db.dao.PlateIntegralTransferRecord;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 部门积分转移处理
 * @author lxf
 */
public class OnPlateReserveIntegral implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
        bean.setDataFromJSON(creteria);
//        bean.setTransferDate(new Date());
        PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
        dao.setDataFromBase(bean);
        dao.save();
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0,null);
    }

}
