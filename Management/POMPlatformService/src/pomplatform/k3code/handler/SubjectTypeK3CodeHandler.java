package pomplatform.k3code.handler;

import org.apache.log4j.Logger;
import pomplatform.k3code.bean.BaseSubjectTypeK3Code;
import pomplatform.k3code.bean.ConditionSubjectTypeK3Code;
import pomplatform.k3code.query.QuerySubjectTypeK3Code;
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

public class SubjectTypeK3CodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SubjectTypeK3CodeHandler.class);

	public static BaseCollection<BaseSubjectTypeK3Code> executeQuerySubjectTypeK3Code(ConditionSubjectTypeK3Code c, KeyValuePair[] replacements ) throws Exception {
		QuerySubjectTypeK3Code dao = new QuerySubjectTypeK3Code();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSubjectTypeK3Code> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSubjectTypeK3Code c = new ConditionSubjectTypeK3Code();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSubjectTypeK3Code> result = executeQuerySubjectTypeK3Code(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSubjectTypeK3Code> result;
		ConditionSubjectTypeK3Code c = new ConditionSubjectTypeK3Code();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySubjectTypeK3Code dao = new QuerySubjectTypeK3Code();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSubjectTypeK3Code.ALL_CAPTIONS);
			for(BaseSubjectTypeK3Code b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


