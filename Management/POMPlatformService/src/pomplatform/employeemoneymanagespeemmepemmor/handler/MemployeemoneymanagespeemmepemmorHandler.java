package pomplatform.employeemoneymanagespeemmepemmor.handler;

import org.apache.log4j.Logger;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMemployeemoneymanagespeemmepemmor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMemployeemoneymanagespeemmepemmor;
import pomplatform.employeemoneymanagespeemmepemmor.query.QueryMemployeemoneymanagespeemmepemmor;
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

public class MemployeemoneymanagespeemmepemmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeemoneymanagespeemmepemmorHandler.class);

	public static BaseCollection<BaseMemployeemoneymanagespeemmepemmor> executeQueryMemployeemoneymanagespeemmepemmor(ConditionMemployeemoneymanagespeemmepemmor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeemoneymanagespeemmepemmor dao = new QueryMemployeemoneymanagespeemmepemmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeemoneymanagespeemmepemmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeemoneymanagespeemmepemmor c = new ConditionMemployeemoneymanagespeemmepemmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeemoneymanagespeemmepemmor> result = executeQueryMemployeemoneymanagespeemmepemmor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeemoneymanagespeemmepemmor> result;
		ConditionMemployeemoneymanagespeemmepemmor c = new ConditionMemployeemoneymanagespeemmepemmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeemoneymanagespeemmepemmor dao = new QueryMemployeemoneymanagespeemmepemmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeemoneymanagespeemmepemmor.ALL_CAPTIONS);
			for(BaseMemployeemoneymanagespeemmepemmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


