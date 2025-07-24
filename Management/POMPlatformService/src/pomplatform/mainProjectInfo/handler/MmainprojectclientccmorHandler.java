package pomplatform.mainProjectInfo.handler;

import com.pomplatform.db.bean.BaseClient;
import com.pomplatform.db.bean.BaseMainProjectClient;
import com.pomplatform.db.dao.Client;
import com.pomplatform.db.dao.MainProjectClient;
import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseMmainprojectclientccmor;
import pomplatform.mainProjectInfo.bean.ConditionMmainprojectclientccmor;
import pomplatform.mainProjectInfo.query.QueryMmainprojectclientccmor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;

public class MmainprojectclientccmorHandler implements GenericQuery, GenericDownloadProcessor {

    private static final Logger __logger = Logger.getLogger(MmainprojectclientccmorHandler.class);

    public static BaseCollection<BaseMmainprojectclientccmor> executeQueryMmainprojectclientccmor(ConditionMmainprojectclientccmor c, KeyValuePair[] replacements) throws Exception {
        QueryMmainprojectclientccmor dao = new QueryMmainprojectclientccmor();
        dao.setCurrentPage(c.getCurrentPage());
        dao.setPageLines(c.getPageLines());
        BaseCollection<BaseMmainprojectclientccmor> result = dao.executeQuery(c.getKeyValues(), c);
        return result;
    }

    @Override
    public String find(String creteria) throws Exception {
        ConditionMmainprojectclientccmor c = new ConditionMmainprojectclientccmor();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMmainprojectclientccmor> result = executeQueryMmainprojectclientccmor(c, c.getKeyValues());
        return result.toJSON(null);
    }

    @Override
    public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseCollection<BaseMmainprojectclientccmor> result;
        ConditionMmainprojectclientccmor c = new ConditionMmainprojectclientccmor();
        c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
        QueryMmainprojectclientccmor dao = new QueryMmainprojectclientccmor();
        dao.setCurrentPage(1);
        dao.setPageLines(1);
        result = dao.executeQuery(c.getKeyValues(), c);
        if (result.getTotalLines() > GenericBase.MAX_EXPORT_LINES) {
            throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
        }
        dao.setCurrentPage(0);
        result = dao.executeQuery(c.getKeyValues(), c);
        try (PrintStream ps = new PrintStream(downFile, "GBK")) {
            ps.println(BaseMmainprojectclientccmor.ALL_CAPTIONS);
            for (BaseMmainprojectclientccmor b : result.getCollections()) {
                ps.println(b.toCSVString());
            }
        }
    }

    @Override
    public String getDownloadFileExtension() {
        return "csv";
    }

    public void save(String json) throws Exception {
        ThreadConnection.beginTransaction();
        BaseClient bean = new BaseClient();
        bean.setDataFromJSON(json);
        Client dao = new Client();
        dao.setDataFromBase(bean);
        dao.save();
        BaseMainProjectClient base = new BaseMainProjectClient();
        base.setDataFromJSON(json);
        MainProjectClient mpc = new MainProjectClient();
        mpc.setDataFromBase(base);
        mpc.setClientId(dao.getClientId());
        mpc.save();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~"+dao.generateBase().toJSONString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~"+mpc.generateBase().toJSONString());
        ThreadConnection.commit();
    }
}
