package pomplatform.revenueStatistical.business;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import com.pomplatform.db.dao.RevenueStatisticalRecord;
import com.pomplatform.db.dao.RevenueYearStatisticalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 运营营收统计保存
 * @author lxf
 */
public class OnRevenueStatisticalProcess implements GenericProcessor,GenericDownloadProcessor {
	private static Logger __logger = Logger.getLogger("");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> result = (Map<String, Object>) parser.parse(new BasicHandler());
		int operateEmployeeId = BaseHelpUtils.getIntValue(result, "operateEmployeeId");
		//获取年月份
		int year = BaseHelpUtils.getIntValue(result, "year");
		int month = BaseHelpUtils.getIntValue(result, "month");
		RevenueStatisticalRecord rsdao = new RevenueStatisticalRecord();
		rsdao.setConditionYear("=",year);
		rsdao.setConditionMonth("=",month);
		rsdao.setConditionIsLocked("=",Boolean.TRUE);
    	if(rsdao.isExist()){
    		throw new SQLException("操作异常:当前年月份数据已加锁过,不可再进行保存操作");
    	}
		Date currentDate = new Date();
		List<BaseRevenueStatisticalRecord> records = GenericBase.__getList(result.get("revenueStatisticalList"),
				BaseRevenueStatisticalRecord.newInstance());
		if(!records.isEmpty() && records.size() > 0){
			//如果只有一条，则更新当前月的数据集，也针对后面的数据的营收做更新处理
			if(records.size() == 1){
				//获取当月累计营收
				BigDecimal totalRevenue = records.get(0).getTotalRevenue();
				int projectId = records.get(0).getProjectId();
				updateRevenue(projectId, year, month, totalRevenue, operateEmployeeId, currentDate);
			}
			RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
			RevenueYearStatisticalRecord yearDao = new RevenueYearStatisticalRecord();
			for(BaseRevenueStatisticalRecord e : records){
				e.setYear(year);
				e.setMonth(month);
				e.setOperateEmployeeId(operateEmployeeId);
				e.setOperateTime(currentDate);
				//先判断该订单在当前年月份是否有保存，如果有则更新，没有则新增
				int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
				dao.clear();
				dao.setConditionProjectId("=",projectId);
				dao.setConditionYear("=",year);
				dao.setConditionMonth("=",month);
				dao.setDataFromBase(e);
				if(dao.countRows()>0){//说明存在，则做更新
					dao.conditionalUpdate();
				}else{
					dao.save();
				}
				//更新或新增该订单的年度营收表数据
				yearDao.clear();
				yearDao.setConditionProjectId("=",projectId);
				yearDao.setConditionYear("=",year);
				onSetRevenue(month,e.getCurrentRevenue(), yearDao);
				yearDao.setOperateEmployeeId(operateEmployeeId);
				yearDao.setOperateTime(currentDate);
				if(yearDao.countRows() > 0){//说明存在，则做更新
					yearDao.conditionalUpdate();
				}else{
					yearDao.setProjectId(projectId);
					yearDao.setYear(year);
					yearDao.save();
				}
			}
		}

		ThreadConnection.commit();
		BaseCollection bc = new BaseCollection();
		return bc.toJSON(0, null);
	}
	
	/**
	 * 更新
	 * @param projectId
	 * @param year
	 * @param month
	 * @param lastRevenue
	 * @param operateEmployeeId
	 * @param currentDate
	 * @throws SQLException
	 */
	public void updateRevenue(int projectId,int year,int month,BigDecimal lastRevenue,int operateEmployeeId,Date currentDate) throws SQLException{
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setConditionProjectId("=",projectId);
		dao.setConditionYear(">=",year);
		dao.setConditionMonth(">",month);
		List<BaseRevenueStatisticalRecord> list = dao.conditionalLoad(" order by year,month asc");
		if(!list.isEmpty() && list.size() > 0){
			RevenueYearStatisticalRecord yearDao = new RevenueYearStatisticalRecord();
			for(BaseRevenueStatisticalRecord e : list){
				//获取本月累计营收
				BigDecimal totalRevenue = e.getTotalRevenue()==null?BigDecimal.ZERO:e.getTotalRevenue();
				//设置本月营收，即本月累计营收-上月累计营收
				BigDecimal currentRevenue = totalRevenue.subtract(lastRevenue);
				e.setCurrentRevenue(currentRevenue);
				e.setOperateEmployeeId(operateEmployeeId);
				e.setOperateTime(currentDate);
				dao.clear();
				dao.setRevenueStatisticalRecordId(e.getRevenueStatisticalRecordId());
				if(dao.load()){
					dao.setDataFromBase(e);
					dao.update();
				}
				//更新年营收数据
				yearDao.clear();
				yearDao.setConditionProjectId("=",projectId);
				yearDao.setConditionYear("=",e.getYear());
				onSetRevenue(e.getMonth(),currentRevenue, yearDao);
				yearDao.setOperateEmployeeId(operateEmployeeId);
				yearDao.setOperateTime(currentDate);
				if(yearDao.countRows() > 0){//说明存在，则做更新
					yearDao.conditionalUpdate();
				}else{
					yearDao.setProjectId(projectId);
					yearDao.setYear(year);
					yearDao.save();
				}
				lastRevenue = totalRevenue;
			}
		}
	}
	
	/**
     * 设置营收
     * @param month
     * @param revenueMoney
     * @param yearDao
     */
    public void onSetRevenue(int month,BigDecimal revenueMoney,RevenueYearStatisticalRecord yearDao){
    	switch (month) {
		case 1:
			yearDao.setJanuaryRevenue(revenueMoney);
			break;
		case 2:
			yearDao.setFebruaryRevenue(revenueMoney);
			break;
		case 3:
			yearDao.setMarchRevenue(revenueMoney);
			break;
		case 4:
			yearDao.setAprilRevenue(revenueMoney);
			break;
		case 5:
			yearDao.setMayRevenue(revenueMoney);
			break;
		case 6:
			yearDao.setJuneRevenue(revenueMoney);
			break;
		case 7:
			yearDao.setJulyRevenue(revenueMoney);
			break;
		case 8:
			yearDao.setAugustRevenue(revenueMoney);
			break;
		case 9:
			yearDao.setSeptemberRevenue(revenueMoney);
			break;
		case 10:
			yearDao.setOctoberRevenue(revenueMoney);
			break;
		case 11:
			yearDao.setNovemberRevenue(revenueMoney);
			break;
		case 12:
			yearDao.setDecemberRevenue(revenueMoney);
			break;
		default:
			break;
		}
    }

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> result = (Map<String, Object>) parser.parse(new BasicHandler());
		List<BaseRevenueStatisticalRecord> records = GenericBase.__getList(result.get("revenueStatisticalList"),BaseRevenueStatisticalRecord.newInstance());
		if(!records.isEmpty() && records.size() > 0){
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(BaseRevenueStatisticalRecord.ALL_CAPTIONS);
				for(BaseRevenueStatisticalRecord b : records){
					ps.println(b.toCSVString());
				}
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return "csv";
	}

}

