package pomplatform.taskmanage.handler;

import org.apache.log4j.Logger;
import pomplatform.taskmanage.bean.BaseScwdtasktemplatetccor;
import pomplatform.taskmanage.bean.ConditionScwdtasktemplatetccor;
import pomplatform.taskmanage.query.QueryScwdtasktemplatetccor;
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

public class ScwdtasktemplatetccorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScwdtasktemplatetccorHandler.class);

	public static BaseCollection<BaseScwdtasktemplatetccor> executeQueryScwdtasktemplatetccor(ConditionScwdtasktemplatetccor c, KeyValuePair[] replacements ) throws Exception {
		QueryScwdtasktemplatetccor dao = new QueryScwdtasktemplatetccor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScwdtasktemplatetccor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScwdtasktemplatetccor c = new ConditionScwdtasktemplatetccor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScwdtasktemplatetccor> result = executeQueryScwdtasktemplatetccor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScwdtasktemplatetccor> result;
		ConditionScwdtasktemplatetccor c = new ConditionScwdtasktemplatetccor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScwdtasktemplatetccor dao = new QueryScwdtasktemplatetccor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScwdtasktemplatetccor.ALL_CAPTIONS);
			for(BaseScwdtasktemplatetccor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


