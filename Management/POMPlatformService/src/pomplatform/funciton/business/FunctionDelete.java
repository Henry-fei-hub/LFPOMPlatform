package pomplatform.funciton.business;

import com.pomplatform.db.bean.BaseFunction;
import com.pomplatform.db.dao.Function;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 功能删除
 *
 * @author lxf
 */
public class FunctionDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //删除功能表数据
        BaseFunction bean = new BaseFunction();
        bean.setDataFromJSON(creteria);
        Function dao = new Function();
        //根据功能ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        return bean.toOneLineJSON(0, null);
    }

}
