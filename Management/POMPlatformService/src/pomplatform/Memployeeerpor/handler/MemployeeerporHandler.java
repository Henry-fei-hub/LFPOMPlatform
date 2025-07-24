package pomplatform.Memployeeerpor.handler;

import org.apache.log4j.Logger;
import pomplatform.Memployeeerpor.bean.BaseMemployeeerpor;
import pomplatform.Memployeeerpor.bean.ConditionMemployeeerpor;
import pomplatform.Memployeeerpor.query.QueryMemployeeerpor;
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

public class MemployeeerporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeerporHandler.class);

	public static BaseCollection<BaseMemployeeerpor> executeQueryMemployeeerpor(ConditionMemployeeerpor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeerpor dao = new QueryMemployeeerpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeerpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeerpor c = new ConditionMemployeeerpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeerpor> result = executeQueryMemployeeerpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeerpor> result;
		ConditionMemployeeerpor c = new ConditionMemployeeerpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeerpor dao = new QueryMemployeeerpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeerpor.ALL_CAPTIONS);
			for(BaseMemployeeerpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


