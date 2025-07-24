package pomplatform.myProject.handler;

import org.apache.log4j.Logger;
import pomplatform.myProject.bean.BaseMprojectemployeeppedsesor;
import pomplatform.myProject.bean.ConditionMprojectemployeeppedsesor;
import pomplatform.myProject.query.QueryMprojectemployeeppedsesor;
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

public class MprojectemployeeppedsesorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectemployeeppedsesorHandler.class);

	public static BaseCollection<BaseMprojectemployeeppedsesor> executeQueryMprojectemployeeppedsesor(ConditionMprojectemployeeppedsesor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectemployeeppedsesor dao = new QueryMprojectemployeeppedsesor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectemployeeppedsesor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectemployeeppedsesor c = new ConditionMprojectemployeeppedsesor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeeppedsesor> result = executeQueryMprojectemployeeppedsesor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectemployeeppedsesor> result;
		ConditionMprojectemployeeppedsesor c = new ConditionMprojectemployeeppedsesor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectemployeeppedsesor dao = new QueryMprojectemployeeppedsesor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseMprojectemployeeppedsesor.ALL_CAPTIONS);
			for(BaseMprojectemployeeppedsesor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


