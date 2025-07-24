package pomplatform.poolmanage.handler;

import org.apache.log4j.Logger;
import pomplatform.poolmanage.bean.BaseOnloadPoolData;
import pomplatform.poolmanage.bean.ConditionOnloadPoolData;
import pomplatform.poolmanage.query.QueryOnloadPoolData;
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

public class OnloadPoolDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnloadPoolDataHandler.class);

	public static BaseCollection<BaseOnloadPoolData> executeQueryOnloadPoolData(ConditionOnloadPoolData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnloadPoolData dao = new QueryOnloadPoolData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnloadPoolData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnloadPoolData c = new ConditionOnloadPoolData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnloadPoolData> result = executeQueryOnloadPoolData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnloadPoolData> result;
		ConditionOnloadPoolData c = new ConditionOnloadPoolData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnloadPoolData dao = new QueryOnloadPoolData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnloadPoolData.ALL_CAPTIONS);
			for(BaseOnloadPoolData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


