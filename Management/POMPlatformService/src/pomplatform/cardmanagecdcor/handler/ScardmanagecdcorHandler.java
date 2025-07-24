package pomplatform.cardmanagecdcor.handler;

import org.apache.log4j.Logger;
import pomplatform.cardmanagecdcor.bean.BaseScardmanagecdcor;
import pomplatform.cardmanagecdcor.bean.ConditionScardmanagecdcor;
import pomplatform.cardmanagecdcor.query.QueryScardmanagecdcor;
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

public class ScardmanagecdcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScardmanagecdcorHandler.class);

	public static BaseCollection<BaseScardmanagecdcor> executeQueryScardmanagecdcor(ConditionScardmanagecdcor c, KeyValuePair[] replacements ) throws Exception {
		QueryScardmanagecdcor dao = new QueryScardmanagecdcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScardmanagecdcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScardmanagecdcor c = new ConditionScardmanagecdcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScardmanagecdcor> result = executeQueryScardmanagecdcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScardmanagecdcor> result;
		ConditionScardmanagecdcor c = new ConditionScardmanagecdcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScardmanagecdcor dao = new QueryScardmanagecdcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScardmanagecdcor.ALL_CAPTIONS);
			for(BaseScardmanagecdcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


