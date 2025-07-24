package pomplatform.employeemoneymanagespeemmepemmor.handler;

import org.apache.log4j.Logger;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMprojectcspppcpdcor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMprojectcspppcpdcor;
import pomplatform.employeemoneymanagespeemmepemmor.query.QueryMprojectcspppcpdcor;
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

public class MprojectcspppcpdcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectcspppcpdcorHandler.class);

	public static BaseCollection<BaseMprojectcspppcpdcor> executeQueryMprojectcspppcpdcor(ConditionMprojectcspppcpdcor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectcspppcpdcor dao = new QueryMprojectcspppcpdcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectcspppcpdcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectcspppcpdcor c = new ConditionMprojectcspppcpdcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectcspppcpdcor> result = executeQueryMprojectcspppcpdcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectcspppcpdcor> result;
		ConditionMprojectcspppcpdcor c = new ConditionMprojectcspppcpdcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectcspppcpdcor dao = new QueryMprojectcspppcpdcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectcspppcpdcor.ALL_CAPTIONS);
			for(BaseMprojectcspppcpdcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


