package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseSpersonnelbusinesppor;
import pomplatform.workflow.personnelbusiness.bean.ConditionSpersonnelbusinesppor;
import pomplatform.workflow.personnelbusiness.query.QuerySpersonnelbusinesppor;
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

public class SpersonnelbusinespporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SpersonnelbusinespporHandler.class);

	public static BaseCollection<BaseSpersonnelbusinesppor> executeQuerySpersonnelbusinesppor(ConditionSpersonnelbusinesppor c, KeyValuePair[] replacements ) throws Exception {
		QuerySpersonnelbusinesppor dao = new QuerySpersonnelbusinesppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSpersonnelbusinesppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSpersonnelbusinesppor c = new ConditionSpersonnelbusinesppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSpersonnelbusinesppor> result = executeQuerySpersonnelbusinesppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSpersonnelbusinesppor> result;
		ConditionSpersonnelbusinesppor c = new ConditionSpersonnelbusinesppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySpersonnelbusinesppor dao = new QuerySpersonnelbusinesppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSpersonnelbusinesppor.ALL_CAPTIONS);
			for(BaseSpersonnelbusinesppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


