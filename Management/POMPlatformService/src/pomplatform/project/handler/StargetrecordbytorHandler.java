package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseStargetrecordbytor;
import pomplatform.project.bean.ConditionStargetrecordbytor;
import pomplatform.project.query.QueryStargetrecordbytor;
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

public class StargetrecordbytorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StargetrecordbytorHandler.class);

	public static BaseCollection<BaseStargetrecordbytor> executeQueryStargetrecordbytor(ConditionStargetrecordbytor c, KeyValuePair[] replacements ) throws Exception {
		QueryStargetrecordbytor dao = new QueryStargetrecordbytor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStargetrecordbytor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStargetrecordbytor c = new ConditionStargetrecordbytor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStargetrecordbytor> result = executeQueryStargetrecordbytor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStargetrecordbytor> result;
		ConditionStargetrecordbytor c = new ConditionStargetrecordbytor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStargetrecordbytor dao = new QueryStargetrecordbytor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseStargetrecordbytor.ALL_CAPTIONS);
			for(BaseStargetrecordbytor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


