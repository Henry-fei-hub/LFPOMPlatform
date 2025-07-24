package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseSprojectpricechangedrecordgroupor;
import pomplatform.project.bean.ConditionSprojectpricechangedrecordgroupor;
import pomplatform.project.query.QuerySprojectpricechangedrecordgroupor;
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

public class SprojectpricechangedrecordgrouporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectpricechangedrecordgrouporHandler.class);

	public static BaseCollection<BaseSprojectpricechangedrecordgroupor> executeQuerySprojectpricechangedrecordgroupor(ConditionSprojectpricechangedrecordgroupor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectpricechangedrecordgroupor dao = new QuerySprojectpricechangedrecordgroupor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectpricechangedrecordgroupor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectpricechangedrecordgroupor c = new ConditionSprojectpricechangedrecordgroupor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectpricechangedrecordgroupor> result = executeQuerySprojectpricechangedrecordgroupor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectpricechangedrecordgroupor> result;
		ConditionSprojectpricechangedrecordgroupor c = new ConditionSprojectpricechangedrecordgroupor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectpricechangedrecordgroupor dao = new QuerySprojectpricechangedrecordgroupor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectpricechangedrecordgroupor.ALL_CAPTIONS);
			for(BaseSprojectpricechangedrecordgroupor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


