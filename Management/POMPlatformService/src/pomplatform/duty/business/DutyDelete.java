package pomplatform.duty.business;

import com.pomplatform.db.bean.BaseDuty;
import com.pomplatform.db.dao.Duty;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 职位删除
 *
 * @author lxf
 */
public class DutyDelete implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        //删除职位表数据
        BaseDuty bean = new BaseDuty();
        bean.setDataFromJSON(creteria);
        Duty dao = new Duty();
        //根据职位ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        //删除上级也删除下级职位
        int parentDutyId = bean.getDutyId();
        dao.setConditionParentDutyId("=", parentDutyId);
        dao.conditionalDelete();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
