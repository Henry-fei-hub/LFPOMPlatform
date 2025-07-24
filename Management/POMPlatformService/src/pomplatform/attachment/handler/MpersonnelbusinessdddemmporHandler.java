package pomplatform.attachment.handler;

import org.apache.log4j.Logger;
import pomplatform.attachment.bean.BaseMpersonnelbusinessdddemmpor;
import pomplatform.attachment.bean.ConditionMpersonnelbusinessdddemmpor;
import pomplatform.attachment.query.QueryMpersonnelbusinessdddemmpor;
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

public class MpersonnelbusinessdddemmporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MpersonnelbusinessdddemmporHandler.class);

	public static BaseCollection<BaseMpersonnelbusinessdddemmpor> executeQueryMpersonnelbusinessdddemmpor(ConditionMpersonnelbusinessdddemmpor c, KeyValuePair[] replacements ) throws Exception {
		QueryMpersonnelbusinessdddemmpor dao = new QueryMpersonnelbusinessdddemmpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMpersonnelbusinessdddemmpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMpersonnelbusinessdddemmpor c = new ConditionMpersonnelbusinessdddemmpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMpersonnelbusinessdddemmpor> result = executeQueryMpersonnelbusinessdddemmpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMpersonnelbusinessdddemmpor> result;
		ConditionMpersonnelbusinessdddemmpor c = new ConditionMpersonnelbusinessdddemmpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMpersonnelbusinessdddemmpor dao = new QueryMpersonnelbusinessdddemmpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMpersonnelbusinessdddemmpor.ALL_CAPTIONS);
			for(BaseMpersonnelbusinessdddemmpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


