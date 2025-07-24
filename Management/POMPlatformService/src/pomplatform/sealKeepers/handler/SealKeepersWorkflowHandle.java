package pomplatform.sealKeepers.handler;

import com.pomplatform.db.bean.BaseSealKeeper;
import com.pomplatform.db.dao.SealKeeper;
import delicacy.connection.ThreadConnection;

import java.util.Date;

public class SealKeepersWorkflowHandle  {

    public String save(String json) throws Exception {
        BaseSealKeeper bean = new BaseSealKeeper();
        bean.setDataFromJSON(json);
        SealKeeper dao = new SealKeeper();
        dao.setDataFromBase(bean);
        dao.setCreatTime(new Date());
        dao.setDeleteFlag(0);
        int num = dao.save();
        return bean.toOneLineJSON(num, null);
    }
}
