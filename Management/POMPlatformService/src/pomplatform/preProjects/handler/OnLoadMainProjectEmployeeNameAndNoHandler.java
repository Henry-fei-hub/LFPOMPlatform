package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.bean.ConditionOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.query.QueryOnLoadMainProjectEmployeeNameAndNo;
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

public class OnLoadMainProjectEmployeeNameAndNoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMainProjectEmployeeNameAndNoHandler.class);

	public static BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> executeQueryOnLoadMainProjectEmployeeNameAndNo(ConditionOnLoadMainProjectEmployeeNameAndNo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMainProjectEmployeeNameAndNo dao = new QueryOnLoadMainProjectEmployeeNameAndNo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMainProjectEmployeeNameAndNo c = new ConditionOnLoadMainProjectEmployeeNameAndNo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> result = executeQueryOnLoadMainProjectEmployeeNameAndNo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> result;
		ConditionOnLoadMainProjectEmployeeNameAndNo c = new ConditionOnLoadMainProjectEmployeeNameAndNo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMainProjectEmployeeNameAndNo dao = new QueryOnLoadMainProjectEmployeeNameAndNo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMainProjectEmployeeNameAndNo.ALL_CAPTIONS);
			for(BaseOnLoadMainProjectEmployeeNameAndNo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


