package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseBonusCommon;
import pomplatform.payment.bean.ConditionBonusCommon;
import pomplatform.payment.query.QueryBonusCommon;
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

public class BonusCommonHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusCommonHandler.class);

	public static BaseCollection<BaseBonusCommon> executeQueryBonusCommon(ConditionBonusCommon c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusCommon dao = new QueryBonusCommon();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusCommon> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusCommon c = new ConditionBonusCommon();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusCommon> result = executeQueryBonusCommon(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusCommon> result;
		ConditionBonusCommon c = new ConditionBonusCommon();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusCommon dao = new QueryBonusCommon();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusCommon.ALL_CAPTIONS);
			for(BaseBonusCommon b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


