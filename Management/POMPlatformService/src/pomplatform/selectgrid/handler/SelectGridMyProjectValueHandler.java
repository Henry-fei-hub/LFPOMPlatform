package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseDepartmentId;
import com.pomplatform.db.dao.DepartmentId;

import pomplatform.common.utils.StaticUtils;
import pomplatform.selectgrid.bean.BaseSelectGridMyProjectValue;
import pomplatform.selectgrid.bean.ConditionSelectGridMyProjectValue;
import pomplatform.selectgrid.query.QuerySelectGridMyProjectValue;
import delicacy.common.KeyValuePair;
import delicacy.system.dao.Employee;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class SelectGridMyProjectValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridMyProjectValueHandler.class);

	public static BaseCollection<BaseSelectGridMyProjectValue> executeQuerySelectGridMyProjectValue(ConditionSelectGridMyProjectValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridMyProjectValue dao = new QuerySelectGridMyProjectValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridMyProjectValue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridMyProjectValue c = new ConditionSelectGridMyProjectValue();
		c.setDataFromJSON(creteria);
		if(null != c.getEmployeeId()){
			//如果为营销部门则可查看所有的项目
			DepartmentId diDao = new DepartmentId();
			diDao.setConditionDepartmentId("=", 9);
			List<BaseDepartmentId> diList = diDao.conditionalLoad();
			Employee eDao = new Employee();
			eDao.setEmployeeId(c.getEmployeeId());
			if(eDao.load() && diList.size() > 0){
				for (BaseDepartmentId baseDepartmentId : diList) {
					if(Objects.equals(eDao.getDepartmentId(), baseDepartmentId.getChildId())){
						c.setEmployeeId(null);
						break;
					}
				}
			}
		}
		BaseCollection<BaseSelectGridMyProjectValue> result = executeQuerySelectGridMyProjectValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridMyProjectValue> result;
		ConditionSelectGridMyProjectValue c = new ConditionSelectGridMyProjectValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridMyProjectValue dao = new QuerySelectGridMyProjectValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridMyProjectValue.ALL_CAPTIONS);
			for(BaseSelectGridMyProjectValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


