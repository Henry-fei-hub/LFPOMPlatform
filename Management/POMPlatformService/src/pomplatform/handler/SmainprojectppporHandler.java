package pomplatform.handler;

import org.apache.log4j.Logger;
import pomplatform.bean.BaseSmainprojectpppor;
import pomplatform.bean.ConditionSmainprojectpppor;
import pomplatform.query.QuerySmainprojectpppor;
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

public class SmainprojectppporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SmainprojectppporHandler.class);

	public static BaseCollection<BaseSmainprojectpppor> executeQuerySmainprojectpppor(ConditionSmainprojectpppor c, KeyValuePair[] replacements ) throws Exception {
		QuerySmainprojectpppor dao = new QuerySmainprojectpppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSmainprojectpppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSmainprojectpppor c = new ConditionSmainprojectpppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSmainprojectpppor> result = executeQuerySmainprojectpppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSmainprojectpppor> result;
		ConditionSmainprojectpppor c = new ConditionSmainprojectpppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySmainprojectpppor dao = new QuerySmainprojectpppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSmainprojectpppor.ALL_CAPTIONS);
			for(BaseSmainprojectpppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


