package pomplatform.capitalsinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.capitalsinfo.bean.BaseCapitalsInfo;
import pomplatform.capitalsinfo.bean.ConditionCapitalsInfo;
import pomplatform.capitalsinfo.query.QueryCapitalsInfo;
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

public class CapitalsInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalsInfoHandler.class);

	public static BaseCollection<BaseCapitalsInfo> executeQueryCapitalsInfo(ConditionCapitalsInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalsInfo dao = new QueryCapitalsInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalsInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalsInfo c = new ConditionCapitalsInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalsInfo> result = executeQueryCapitalsInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalsInfo> result;
		ConditionCapitalsInfo c = new ConditionCapitalsInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalsInfo dao = new QueryCapitalsInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalsInfo.ALL_CAPTIONS);
			for(BaseCapitalsInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


