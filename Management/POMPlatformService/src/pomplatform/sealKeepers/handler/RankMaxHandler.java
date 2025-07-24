package pomplatform.sealKeepers.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.sealKeepers.bean.BaseRankMax;
import pomplatform.sealKeepers.bean.ConditionRankMax;
import pomplatform.sealKeepers.query.QueryRankMax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class RankMaxHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RankMaxHandler.class);

	public static BaseCollection<BaseRankMax> executeQueryRankMax(ConditionRankMax c, KeyValuePair[] replacements ) throws Exception {
		QueryRankMax dao = new QueryRankMax();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRankMax> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRankMax c = new ConditionRankMax();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRankMax> result = executeQueryRankMax(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRankMax> result;
		ConditionRankMax c = new ConditionRankMax();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRankMax dao = new QueryRankMax();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRankMax.ALL_CAPTIONS);
			for(BaseRankMax b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


