package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseNormalBonusCommon;
import pomplatform.payment.bean.ConditionNormalBonusCommon;
import pomplatform.payment.query.QueryNormalBonusCommon;
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

public class NormalBonusCommonHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NormalBonusCommonHandler.class);

	public static BaseCollection<BaseNormalBonusCommon> executeQueryNormalBonusCommon(ConditionNormalBonusCommon c, KeyValuePair[] replacements ) throws Exception {
		QueryNormalBonusCommon dao = new QueryNormalBonusCommon();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNormalBonusCommon> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNormalBonusCommon c = new ConditionNormalBonusCommon();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNormalBonusCommon> result = executeQueryNormalBonusCommon(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNormalBonusCommon> result;
		ConditionNormalBonusCommon c = new ConditionNormalBonusCommon();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNormalBonusCommon dao = new QueryNormalBonusCommon();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNormalBonusCommon.ALL_CAPTIONS);
			for(BaseNormalBonusCommon b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


