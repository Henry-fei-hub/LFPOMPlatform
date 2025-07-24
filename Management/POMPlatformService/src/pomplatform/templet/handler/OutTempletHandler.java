package pomplatform.templet.handler;

import org.apache.log4j.Logger;
import pomplatform.templet.bean.BaseOutTemplet;
import pomplatform.templet.bean.ConditionOutTemplet;
import pomplatform.templet.query.QueryOutTemplet;
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

public class OutTempletHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OutTempletHandler.class);

	public static BaseCollection<BaseOutTemplet> executeQueryOutTemplet(ConditionOutTemplet c, KeyValuePair[] replacements ) throws Exception {
		QueryOutTemplet dao = new QueryOutTemplet();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOutTemplet> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOutTemplet c = new ConditionOutTemplet();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOutTemplet> result = executeQueryOutTemplet(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOutTemplet> result;
		ConditionOutTemplet c = new ConditionOutTemplet();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOutTemplet dao = new QueryOutTemplet();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOutTemplet.ALL_CAPTIONS);
			for(BaseOutTemplet b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


