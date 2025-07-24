package delicacy.oa;

/**
 *
 * @author Peter
 */
public class ReaderEmployeeCheckin {

//	private static final Logger __logger = Logger.getLogger(ReaderEmployeeCheckin.class);
//	private static Map<String, List<BaseMemployeeworkor>> globalWorkDays = new HashMap<>();
//
//	public static void readFileAccess(String fileName, Date startDate, Date endDate) throws Exception {
//		Properties prop = new Properties();
//		prop.put("charSet", "utf8"); // 这里是解决中文乱码
//		prop.put("user", "");
//		prop.put("password", "");
//		String url = "jdbc:ucanaccess://" + fileName;
//		List<EmployeeAttendance> eas = new ArrayList<>();
//
//		if (fileName != null) {
//			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//			try (Connection conn = DriverManager.getConnection(url)) {
//				StringBuilder sb = new StringBuilder();
//				sb.append(
//						"select u.Badgenumber as employee_id, DateSerial(DatePart('yyyy',c.checktime),DatePart('m',c.checktime),DatePart('d',c.checktime)) as checkdate, ");
//				sb.append(
//						"min(c.checktime) as check_in, max(c.checktime) as check_out from checkinout c , userinfo u ");
//				sb.append("where c.userid = u.userid and c.checktime between ? and ? ");
//				sb.append(
//						"group by u.Badgenumber,DateSerial(DatePart('yyyy',c.checktime),DatePart('m',c.checktime),DatePart('d',c.checktime)) ");
//				try (PreparedStatement stmt = conn.prepareStatement(sb.toString())) {
//					stmt.setDate(1, DateUtil.generateSQLDateFromDate(startDate));
//					stmt.setDate(2, DateUtil.generateSQLDateFromDate(endDate));
//					try (ResultSet rs = stmt.executeQuery()) {
//						while (rs.next()) {
//							EmployeeAttendance ea = new EmployeeAttendance();
//							ea.setEmployeeId(BaseHelpUtils.getIntValue(rs.getString(1)));
//							ea.setCheckDate(DateUtil.generateDateFromSQLDate(rs.getDate(2)));
//							ea.setCheckIn(DateUtil.generateDateFromSQLTimestamp(rs.getTimestamp(3)));
//							ea.setCheckOut(DateUtil.generateDateFromSQLTimestamp(rs.getTimestamp(4)));
//							eas.add(ea);
//						}
//					}
//				}
//			}
//		} else {
//			ConditionScheckinfoseor c = new ConditionScheckinfoseor();
//			c.setMinLogindate(startDate);
//			c.setMaxLogindate(endDate);
//			QueryScheckinfoseor q = new QueryScheckinfoseor();
//			q.setConnection("oahr");
//			BaseCollection<BaseScheckinfoseor> bsis = q.executeQuery(null, c);
//			bsis.getCollections().stream().map((bsi) -> {
//				EmployeeAttendance ea = new EmployeeAttendance();
//				ea.setEmployeeId(BaseHelpUtils.getIntValue(bsi.getUserid()));
//				ea.setCheckDate(bsi.getCheckdate());
//				ea.setCheckIn(bsi.getCheckin());
//				ea.setCheckOut(bsi.getCheckout());
//				return ea;
//			}).forEach((ea) -> {
//				eas.add(ea);
//			});
//		}
//		Map<Integer, Integer> empMap = OAEmployeeSync.generateEmployeeMap();
//		EmployeeCheckinout ec = new EmployeeCheckinout();
//		ec.addCondition(BaseEmployeeCheckinout.CS_CHECK_DATE, "BETWEEN", startDate, endDate);
//		List<BaseEmployeeCheckinout> oldrecords = ec.conditionalLoad("order by employee_id, check_date");
//		List<BaseEmployeeCheckinout> becs = new ArrayList<>();
//		for (EmployeeAttendance ea : eas) {
//			BaseEmployeeCheckinout bec = new BaseEmployeeCheckinout();
//			bec.setEmployeeId(empMap.get(ea.getEmployeeId()));
//			if (bec.getEmployeeId() == null) {
//				BaseEmployee bbe = OAEmployeeSync.syncEmployeeFromOA(ea.getEmployeeId());
//				if (bbe == null) {
//					continue;
//				}
//				empMap.put(ea.getEmployeeId(), bbe.getEmployeeId());
//				bec.setEmployeeId(bbe.getEmployeeId());
//			}
//			if (bec.getEmployeeId() == null) {
//				continue;
//			}
//			bec.setOaEmployeeId(ea.getEmployeeId());
//			bec.setCheckDate(ea.getCheckDate());
//			bec.setDayOfWeek(DateUtil.getDayOfWeek(ea.getCheckDate()));
//			bec.setCheckInTime(ea.getCheckIn());
//			bec.setCheckOutTime(ea.getCheckOut());
//			bec.setStatus(-1);
//			bec.setFinalStatus(Boolean.FALSE);
//			bec.setLateTime(0);
//			bec.setOverTime(BigDecimal.ZERO);
//			bec.setIsWorkDay(true);
//			bec.setWeekOfYear(DateUtil.getWeekOfYear(ea.getCheckDate()));
//			if (bec.getWeekOfYear() % 2 == 0) {
//				bec.setBigWeek(Boolean.FALSE);
//			} else {
//				bec.setBigWeek(Boolean.TRUE);
//			}
//			BaseEmployeeCheckinout obec = findCheckInfo(oldrecords, bec.getEmployeeId(), bec.getCheckDate());
//			if (obec == null) {
//				becs.add(bec);
//			} else {
//				ec.clear();
//				ec.setDataFromBase(obec);
//				ec.clearModifiedFlags();
//				if (ec.getCheckInTime() == null) {
//					ec.setCheckInTime(bec.getCheckInTime());
//				} else if (bec.getCheckInTime() != null && bec.getCheckInTime().compareTo(ec.getCheckInTime()) < 0) {
//					ec.setCheckInTime(bec.getCheckInTime());
//				}
//				if (ec.getCheckOutTime() == null) {
//					ec.setCheckOutTime(bec.getCheckOutTime());
//				} else if (bec.getCheckOutTime() != null && bec.getCheckOutTime().compareTo(ec.getCheckOutTime()) > 0) {
//					ec.setCheckOutTime(bec.getCheckOutTime());
//				}
//				ec.update();
//			}
//		}
//		ec.save(becs);
//
//	}
//
//	public static void generateEmployeeCheckList(int employeeId, Date startDate, Date endDate) throws SQLException {
//
//		int year = DateUtil.getYearFromDate(startDate);
//		int month = DateUtil.getMonthFromDate(startDate);
//
//		Employee e = new Employee();
//		e.setEmployeeIdClear(employeeId);
//		if (!e.load()) {
//			throw new SQLException(String.format("没有发现员工，工号 %1$d", employeeId));
//		}
//		List<BaseEmployeeCheckinout> normalList;
//		if(e.getDepartmentId() == null){
//			__logger.error(String.format("部门编码为空，员工号：%1$d", e.getEmployeeId()));
//			return;
//		}
//		DepartmentTree dt = DepartmentTree.findDepartment(e.getDepartmentId());
//		if(dt == null){
//			__logger.error(String.format("找不到部门，员工号：%1$d, %2$d", e.getEmployeeId(), e.getDepartmentId()));
//			return;
//		}
//		if (e.getPlateId() == null || e.getPlateId() != dt.getPlateId()) {
//			e.setPlateId(dt.getPlateId());
//			e.update();
//		}
//		Holidaysetitem hsi = new Holidaysetitem();
//		hsi.setConnection("oahr");
//		hsi.addCondition(BaseHolidaysetitem.CS_HOLIDAYDATE, "BETWEEN", startDate, endDate);
//		List<BaseHolidaysetitem> holidaies = hsi.conditionalLoad("order by holidaydate");
//
//		if (e.getPlateId() == null || e.getPlateId() == 0) {
//			normalList = generateNormalCheckList(e.getOaId(), false, startDate, endDate, holidaies);
//		} else {
//			normalList = generateNormalCheckList(e.getOaId(), true, startDate, endDate, holidaies);
//		}
//		EmployeeMonthlyCheck emc = new EmployeeMonthlyCheck();
//		emc.setConditionEmployeeId("=", employeeId);
//		emc.setConditionYear("=", year);
//		emc.setConditionMonth("=", month);
//		BaseEmployeeMonthlyCheck bemc = new BaseEmployeeMonthlyCheck();
//		BaseEmployeeMonthlyCheck originalemc = emc.executeQueryOneRow();
//		if (originalemc != null) {
//			originalemc.cloneCopy(bemc);
//		} else {
//			bemc.setEmployeeId(employeeId);
//			bemc.setYear(year);
//			bemc.setMonth(month);
//		}
//		bemc.setLate(0);
//		bemc.setLate5m(0);
//		bemc.setLate10m(0);
//		bemc.setLate30m(0);
//		bemc.setThingLeave(0);
//		bemc.setThingDays(BigDecimal.ZERO);
//		bemc.setThingHours(BigDecimal.ZERO);
//		bemc.setIllLeave(0);
//		bemc.setIllDays(BigDecimal.ZERO);
//		bemc.setIllHours(BigDecimal.ZERO);
//		bemc.setOtherLeave(0);
//		bemc.setOtherDays(BigDecimal.ZERO);
//		bemc.setOtherHours(BigDecimal.ZERO);
//		bemc.setNormalOvertime(0);
//		bemc.setWeekendOvertime(0);
//		bemc.setHolidayOvertime(0);
//		bemc.setAbsenceDays(0);
//		bemc.setNornalOvertimeHours(BigDecimal.ZERO);
//		bemc.setWeekendOvertimeHours(BigDecimal.ZERO);
//		bemc.setHolidayOvertimeHours(BigDecimal.ZERO);
//
//		// 获取职员在指定的开始日期和结束日期的打卡记录数据
//		EmployeeCheckinout ec = new EmployeeCheckinout();
//		ec.addCondition(BaseEmployeeCheckinout.CS_CHECK_DATE, "BETWEEN", startDate, endDate);
//		ec.setConditionEmployeeId("=", employeeId);
//		List<BaseEmployeeCheckinout> checkList = ec.conditionalLoad("order by check_date");
//
//		// 获取职员在OA(指定的开始日期和结束日期)的请假记录数据
//		TLeave leaveDao = new TLeave();
//		leaveDao.setConnection("oahr");
//		leaveDao.setConditionBegintime("<=", endDate);
//		leaveDao.setConditionEndtime(">=", startDate);
//		leaveDao.setConditionUserid("=", String.valueOf(e.getOaId()));
//		// leaveDao.setConditionIsapply("=", "1");
//		List<BaseTLeave> leaves = leaveDao.conditionalLoad("order by beginTime");
//
//		// 获取职员在OA(指定的开始日期和结束日期)的补签记录数据
//		TFillcheck fillDao = new TFillcheck();
//		fillDao.setConnection("oahr");
//		fillDao.addCondition(BaseTFillcheck.CS_FILLDATE, "BETWEEN", startDate, endDate);
//		fillDao.setConditionUserid("=", String.valueOf(e.getOaId()));
//		// fillDao.setConditionIsapply("=", "1");
//		List<BaseTFillcheck> fills = fillDao.conditionalLoad("order by fillDate");
//
//		// 获取职员在OA(指定的开始日期和结束日期)的外出记录数据
//		Stayaway awayDao = new Stayaway();
//		awayDao.setConnection("oahr");
//		awayDao.setConditionBegindate("<=", endDate);
//		awayDao.setConditionEnddate(">=", startDate);
//		awayDao.setConditionUserid("=", String.valueOf(e.getOaId()));
//		// awayDao.setConditionIsapply("=", "1");
//		List<BaseStayaway> aways = awayDao.conditionalLoad("order by beginDate");
//
//		// 获取职员在OA(指定的开始日期和结束日期)的出差记录数据
//		Goonerrand gdao = new Goonerrand();
//		gdao.setConnection("oahr");
//		gdao.setConditionBegintime("<=", endDate);
//		gdao.setConditionEndtime(">=", startDate);
//		gdao.setConditionUserid("=", String.valueOf(e.getOaId()));
//		// gdao.setConditionIsapply("=", "1");
//		List<BaseGoonerrand> goes = gdao.conditionalLoad("order by beginTime");
//		// 检索OA人员的每一天的正常上班点和下班点时间
//		// 如果人员一天涉及多个班次的，则根据当前是星期几，去检索上班的那个班次
//		for (BaseEmployeeCheckinout bec : normalList) {
//			// Map<String, Date> dateMap =
//			// getEmployeeNormalDate(BaseHelpUtils.getIntValue(e.getOaId()),
//			// bec.getCheckDate());
//			// Date normalCheckin = dateMap.get("normalCheckin");
//			// Date normalCheckout = dateMap.get("normalCheckout");
//			Date normalCheckin = DateUtil.getDateOfSpecialHour(bec.getCheckDate(), 9, 1);
//			Date normalCheckout = DateUtil.getDateOfSpecialHour(bec.getCheckDate(), 18);
//			Date overCheckout = DateUtil.getDateOfSpecialHour(bec.getCheckDate(), 21);
//			bec.setOaEmployeeId(e.getOaId());
//			bec.setEmployeeId(employeeId);
//			BaseEmployeeCheckinout chke = findCheckInfo(checkList, bec.getCheckDate());
//			if (chke != null) {
//				chke.cloneCopy(bec);
//				if (bec.getCheckInTime() != null && bec.getCheckOutTime() != null
//						&& bec.getCheckInTime().compareTo(normalCheckin) <= 0
//						&& bec.getCheckOutTime().compareTo(normalCheckout) >= 0) {
//					if (overCheckout.compareTo(bec.getCheckOutTime()) < 0) {
//						bec.setStatus(14);// 加班
//						bec.setFinalStatus(true);
//						bec.setComments("加班" + DateUtil.generateStringTimeBetween(bec.getCheckOutTime(), overCheckout));
//						bec.setOverTime(
//								BigDecimal.valueOf(DateUtil.generateHoursBetween(bec.getCheckOutTime(), overCheckout)));
//
//						bemc.setNormalOvertime(bemc.getNormalOvertime() + 1);
//						bemc.setNornalOvertimeHours(bemc.getNornalOvertimeHours().add(bec.getOverTime()));
//						continue;
//					}
//					bec.setStatus(0);
//					bec.setFinalStatus(true);
//					bec.setComments("");
//					continue;
//				}
//				BaseGoonerrand bg = findGoonerrand(goes, bec.getCheckDate());
//				if (bg != null) {
//					bec.setStatus(7);// 出差
//					bec.setFinalStatus(true);
//					bec.setComments(bg.getSubject());
//					// bemc.setOtherLeave(bemc.getOtherLeave() + 1);
//					continue;
//				}
//				BaseTLeave btl = findLeaveInfo(leaves, bec.getCheckDate());
//				if (btl != null) {
//					bec.setStatus(getLeaveType(btl.getApplytype()));
//					bec.setFinalStatus(true);
//					bec.setComments(btl.getContent());
//					//如果当前计算日期小于请假结束日期，则设置为1天
//					if(DateUtil.compareDate(btl.getEndtime(),bec.getCheckDate())){
//						bec.setLeaveDays(BigDecimal.ONE);
//						bec.setLeaveHours(BigDecimal.valueOf(7.5));
//					}else{
//						bec.setLeaveDays(BigDecimal.ZERO);
//						bec.setLeaveHours(BigDecimal.ZERO);
//					}
//					switch (bec.getStatus()) {
//					case 3:// 病假
//						bemc.setIllLeave(bemc.getIllLeave() + 1);
//						bemc.setIllDays(bemc.getIllDays().add(bec.getLeaveDays()));
//						bemc.setIllHours(bemc.getIllHours().add(bec.getLeaveHours()));
//						break;
//					case 4:// 事假
//						bemc.setThingLeave(bemc.getThingLeave() + 1);
//						bemc.setThingDays(bemc.getThingDays().add(bec.getLeaveDays()));
//						bemc.setThingHours(bemc.getThingHours().add(bec.getLeaveHours()));
//						break;
//					default:// 其它假类
//						bemc.setOtherLeave(bemc.getOtherLeave() + 1);
//						bemc.setOtherDays(bemc.getOtherDays().add(bec.getLeaveDays()));
//						bemc.setOtherHours(bemc.getOtherHours().add(bec.getLeaveHours()));
//						break;
//					}
//					continue;
//				}
//				BaseStayaway sa = findAwayInfo(aways, bec.getCheckDate());
//				if (sa != null) {
//					bec.setStatus(8);// 外出
//					bec.setFinalStatus(true);
//					bec.setComments(sa.getContent());
//					continue;
//				}
//				BaseTFillcheck tf = findFillInfo(fills, bec.getCheckDate());
//				if (tf != null) {
//					bec.setStatus(0);
//					bec.setFinalStatus(true);
//					bec.setComments(tf.getRemark());
//				} else {
//					if (bec.getCheckInTime() == null || bec.getCheckOutTime() == null) {
//						bec.setStatus(13);// 旷工
//						bec.setFinalStatus(false);
//						bec.setComments("旷工");
//						bemc.setAbsenceDays(bemc.getAbsenceDays() + 1);
//						continue;
//					}
//					if (normalCheckin.compareTo(bec.getCheckInTime()) < 0) {
//						bec.setStatus(1);// 迟到
//						bec.setFinalStatus(false);
//						bec.setComments("迟到" + DateUtil.generateStringTimeBetween(bec.getCheckInTime(), normalCheckin));
//						bec.setLateTime(DateUtil.generateMinusBetween(bec.getCheckInTime(), normalCheckin));
//						lateProcess(bec, bemc);
//						continue;
//					}
//					if (normalCheckout.compareTo(bec.getCheckOutTime()) > 0) {
//						bec.setStatus(2);// 早退
//						bec.setFinalStatus(false);
//						bec.setComments(
//								"早退" + DateUtil.generateStringTimeBetween(normalCheckout, bec.getCheckOutTime()));
//						bec.setLateTime(DateUtil.generateMinusBetween(normalCheckout, bec.getCheckOutTime()));
//						lateProcess(bec, bemc);
//					}
//				}
//			} else {
//				BaseGoonerrand bg = findGoonerrand(goes, bec.getCheckDate());
//				if (bg != null) {
//					bec.setStatus(7);// 出差
//					bec.setFinalStatus(true);
//					bec.setComments(bg.getSubject());
//					// bemc.setOtherLeave(bemc.getOtherLeave() + 1);
//					continue;
//				}
//				BaseTLeave btl = findLeaveInfo(leaves, bec.getCheckDate());
//				if (btl != null) {
//					bec.setStatus(getLeaveType(btl.getApplytype()));
//					bec.setFinalStatus(true);
//					bec.setComments(btl.getContent());
//					//如果当前计算日期小于请假结束日期，则设置为1天
//					if(DateUtil.compareDate(btl.getEndtime(),bec.getCheckDate())){
//						bec.setLeaveDays(BigDecimal.ONE);
//						bec.setLeaveHours(BigDecimal.valueOf(7.5));
//					}else{
//						bec.setLeaveDays(BigDecimal.ZERO);
//						bec.setLeaveHours(BigDecimal.ZERO);
//					}
//					switch (bec.getStatus()) {
//					case 3:// 病假
//						bemc.setIllLeave(bemc.getIllLeave() + 1);
//						bemc.setIllDays(bemc.getIllDays().add(bec.getLeaveDays()));
//						bemc.setIllHours(bemc.getIllHours().add(bec.getLeaveHours()));
//						break;
//					case 4:// 事假
//						bemc.setThingLeave(bemc.getThingLeave() + 1);
//						bemc.setThingDays(bemc.getThingDays().add(bec.getLeaveDays()));
//						bemc.setThingHours(bemc.getThingHours().add(bec.getLeaveHours()));
//						break;
//					default:// 其它假类
//						bemc.setOtherLeave(bemc.getOtherLeave() + 1);
//						bemc.setOtherDays(bemc.getOtherDays().add(bec.getLeaveDays()));
//						bemc.setOtherHours(bemc.getOtherHours().add(bec.getLeaveHours()));
//						break;
//					}
//					continue;
//				}
//				BaseStayaway sa = findAwayInfo(aways, bec.getCheckDate());
//				if (sa != null) {
//					bec.setStatus(8);// 外出
//					bec.setFinalStatus(true);
//					bec.setComments(sa.getContent());
//					continue;
//				}
//				BaseTFillcheck tf = findFillInfo(fills, bec.getCheckDate());
//				if (tf != null) {
//					bec.setStatus(0);
//					bec.setFinalStatus(true);
//					bec.setComments(tf.getRemark());
//				} else {
//					bec.setStatus(13);// 旷工
//					bec.setFinalStatus(false);
//					bec.setComments("旷工");
//					bemc.setAbsenceDays(bemc.getAbsenceDays() + 1);
//				}
//			}
//		}
//		for (BaseEmployeeCheckinout bec : normalList) {
//			if (bec.getEmployeeCheckId() == null) {
//				ec.clear();
//				ec.setDataFromBase(bec);
//				ec.save();
//			} else {
//				BaseEmployeeCheckinout obe = findCheckInfoUsingId(checkList, bec.getEmployeeCheckId());
//				ec.clear();
//				ec.setDataFromBase(obe);
//				ec.clearModifiedFlags();
//				ec.setDataFromBase(bec);
//				ec.update();
//			}
//		}
//
//		for (BaseEmployeeCheckinout obec : checkList) {
//			BaseEmployeeCheckinout chke = findCheckInfo(normalList, obec.getCheckDate());
//			if (chke != null) {
//				continue;
//			}
//			ec.clear();
//			ec.setDataFromBase(obec);
//			ec.clearModifiedFlags();
//			if (obec.getCheckInTime() != null && obec.getCheckOutTime() != null) {
//				ec.setStatus(14);// 加班
//				ec.setFinalStatus(true);
//				ec.setIsWorkDay(false);
//				ec.setComments(
//						"加班" + DateUtil.generateStringTimeBetween(obec.getCheckOutTime(), obec.getCheckInTime()));
//				ec.setOverTime(BigDecimal
//						.valueOf(DateUtil.generateHoursBetween(obec.getCheckOutTime(), obec.getCheckInTime())));
//				if (isHoliday(obec.getCheckInTime(), holidaies)) {
//					bemc.setHolidayOvertime(bemc.getHolidayOvertime() + 1);
//					bemc.setHolidayOvertimeHours(bemc.getHolidayOvertimeHours().add(ec.getOverTime()));
//				} else {
//					bemc.setWeekendOvertime(bemc.getWeekendOvertime() + 1);
//					bemc.setWeekendOvertimeHours(bemc.getWeekendOvertimeHours().add(ec.getOverTime()));
//				}
//			} else {
//				ec.setStatus(13);
//				ec.setFinalStatus(false);
//				__logger.debug(obec.toString());
//			}
//			ec.update();
//
//		}
//		bemc.setDepartmentId(e.getDepartmentId());
//		bemc.setEmployeeNo(e.getEmployeeNo());
//		bemc.setOnBoard(e.getOnboardDate());
//		bemc.setWorkDays(normalList.size());
//		bemc.setDutyDate(e.getResignationDate());
//		if (bemc.getDutyDate() == null) {
//			if (bemc.getOnBoard() == null) {
//				bemc.setEmployeeType(0);
//			} else if (DateUtil.generateMonthsBetween(new Date(), bemc.getOnBoard()) >= 3) {
//				bemc.setEmployeeType(0);
//			} else {
//				bemc.setEmployeeType(1);
//			}
//		} else if (bemc.getDutyDate().compareTo(ec.getCheckDate()) > 0) {
//			bemc.setEmployeeType(1);
//		} else {
//			bemc.setEmployeeType(0);
//		}
//		if (bemc.getMonthCheckId() == null) {
//			emc.clear();
//			emc.setDataFromBase(bemc);
//			emc.save();
//		} else {
//			emc.clear();
//			emc.setDataFromBase(originalemc);
//			emc.clearModifiedFlags();
//			emc.setDataFromBase(bemc);
//			emc.update();
//		}
//	}
//
//	/**
//	 * 3:表示病假;4:表示事假;其它表示别的假类
//	 * 
//	 * @param val
//	 * @return
//	 */
//	public static int getLeaveType(String val) {
//		switch (val) {
//		case "leave.product.hos":
//			return 5;
//		case "leave.thing.hos":
//			return 4;
//		case "leave.adjust.rest.hos":
//			return 6;
//		case "leave.ill.hos":
//			return 3;
//		case "leave.marriage.hos":
//			return 10;
//		case "leave.lose.hos":
//			return 11;
//		case "leave.compo.hos":
//			return 12;
//		case "1":
//			return 9;
//		default:
//			return 4;
//		}
//	}
//
//	// 迟到处理,迟到5分钟,10分钟,30分钟的次数不能超过3次,如果超过3次,将累积到下一个档次
//	// 扣款迟到没有次数限制
//	public static void lateProcess(BaseEmployeeCheckinout bec, BaseEmployeeMonthlyCheck bemc) {
//		if (bec.getLateTime() <= 5) {
//			if (bemc.getLate5m() >= 3) {
//				if (bemc.getLate10m() >= 3) {
//					if (bemc.getLate30m() >= 3) {
//						bemc.setLate(bemc.getLate() + 1);
//					} else {
//						bemc.setLate30m(bemc.getLate30m() + 1);
//					}
//				} else {
//					bemc.setLate10m(bemc.getLate10m() + 1);
//				}
//			} else {
//				bemc.setLate5m(bemc.getLate5m() + 1);
//			}
//		} else if (bec.getLateTime() <= 10) {
//			if (bemc.getLate10m() >= 3) {
//				if (bemc.getLate30m() >= 3) {
//					bemc.setLate(bemc.getLate() + 1);
//				} else {
//					bemc.setLate30m(bemc.getLate30m() + 1);
//				}
//			} else {
//				bemc.setLate10m(bemc.getLate10m() + 1);
//			}
//		} else if (bec.getLateTime() <= 30) {
//			if (bemc.getLate30m() >= 3) {
//				bemc.setLate(bemc.getLate() + 1);
//			} else {
//				bemc.setLate30m(bemc.getLate30m() + 1);
//			}
//		} else {
//			bemc.setLate(bemc.getLate() + 1);
//		}
//	}
//
//	public static BaseTLeave findLeaveInfo(List<BaseTLeave> bls, Date d) {
//		for (BaseTLeave l : bls) {
//			if (DateUtil.isBetween(d, l.getBegintime(), l.getEndtime())) {
//				return l;
//			}
//		}
//		return null;
//	}
//
//	public static BaseTFillcheck findFillInfo(List<BaseTFillcheck> fcs, Date d) {
//		for (BaseTFillcheck b : fcs) {
//			if (DateUtil.isSameDay(d, b.getFilldate())) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public static BaseStayaway findAwayInfo(List<BaseStayaway> bss, Date d) {
//		for (BaseStayaway b : bss) {
//			if (DateUtil.isBetween(d, b.getBegindate(), b.getEnddate())) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public static BaseGoonerrand findGoonerrand(List<BaseGoonerrand> goes, Date d) {
//		for (BaseGoonerrand b : goes) {
//			if (DateUtil.isBetween(d, b.getBegintime(), b.getEndtime())) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public static BaseEmployeeCheckinout findCheckInfo(List<BaseEmployeeCheckinout> checkList, Date d) {
//		for (BaseEmployeeCheckinout b : checkList) {
//			if (DateUtil.isSameDay(b.getCheckDate(), d)) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public static BaseEmployeeCheckinout findCheckInfo(List<BaseEmployeeCheckinout> checkList, Integer id, Date d) {
//
//		for (BaseEmployeeCheckinout b : checkList) {
//			if (id.equals(b.getEmployeeId()) && DateUtil.isSameDay(b.getCheckDate(), d)) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public static BaseEmployeeCheckinout findCheckInfoUsingId(List<BaseEmployeeCheckinout> checkList, Integer d) {
//		for (BaseEmployeeCheckinout b : checkList) {
//			if (b.getEmployeeCheckId().equals(d)) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public static boolean isHoliday(Date d, List<BaseHolidaysetitem> bhsis) {
//		for (BaseHolidaysetitem b : bhsis) {
//			if (DateUtil.isSameDay(d, b.getHolidaydate())) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public static List<BaseEmployeeCheckinout> generateNormalCheckList(Integer oaid, boolean isDesigner, Date startDate,
//			Date endDate, List<BaseHolidaysetitem> bhsis) throws SQLException {
//		String soaid = String.valueOf(oaid);
//		List<BaseEmployeeCheckinout> becs = new ArrayList<>();
//		for (Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
//			int dayOfWeek = DateUtil.getDayOfWeek(s);
//			int weekOfYear = DateUtil.getWeekOfYear(s);
//			Boolean isWorkDay = isWorkDay(soaid, s, globalWorkDays);
//			if (isWorkDay == null) {
//				if (dayOfWeek == 7) {
//					continue;
//				}
//				if (!isDesigner && dayOfWeek == 6) {
//					continue;
//				}
//				if (isDesigner && dayOfWeek == 6 && weekOfYear % 2 == 0) {
//					continue;
//				}
//			} else {
//				if (!isWorkDay)
//					continue;
//				if (isDesigner && dayOfWeek == 6 && weekOfYear % 2 == 0) {
//					continue;
//				}
//			}
//			if (isHoliday(s, bhsis)) {
//				continue;
//			}
//			BaseEmployeeCheckinout bce = new BaseEmployeeCheckinout();
//			becs.add(bce);
//			bce.setBigWeek(weekOfYear % 2 == 1);
//			bce.setWeekOfYear(weekOfYear);
//			bce.setDayOfWeek(dayOfWeek);
//			bce.setLateTime(0);
//			bce.setIsWorkDay(true);
//			bce.setOverTime(BigDecimal.ZERO);
//			bce.setCheckDate(s);
//		}
//		return becs;
//	}
//
//	public static void readCheckData(int year, int month) throws Exception {
//		String fileName = generateCheckDataFileName(year, month);
//		byte[] buff = SocketClient.callBinaryOperation("BW_getMDBFile", "", "", null);
//		try (FileOutputStream fos = new FileOutputStream(fileName)) {
//			fos.write(buff);
//		}
//		Date startDate = DateUtil.createFirstDayOfMonth(year, month);
//		Date endDate = DateUtil.getFirstDayOfNextMonth(year, month);
//		if (endDate.compareTo(new Date()) > 0) {
//			endDate = DateUtil.getNextDayOfToday();
//		}
//		readFileAccess(fileName, startDate, endDate);
//
//	}
//
//	public static void processCheckData(int year, int month) throws Exception {
//		Employee e = new Employee();
//		e.unsetSelectFlags();
//		e.setSelectEmployeeId(true);
//		e.setConditionIsHeadcount("=", Boolean.TRUE);
//		e.setConditionIsCheck("=", Boolean.TRUE);
//
//		List<BaseEmployee> bes = e.conditionalLoad();
//		Date startDate = DateUtil.createFirstDayOfMonth(year, month);
//		Date endDate = DateUtil.getFirstDayOfNextMonth(year, month);
//		endDate = DateUtil.getNextDayOfDay(endDate, -1);
//		if (endDate.compareTo(new Date()) > 0) {
//			endDate = DateUtil.getNextDayOfToday();
//		}
//		if (globalWorkDays.isEmpty()) {
//			globalWorkDays = generateEmployeeWorkDays(startDate, endDate);
//			__logger.info(String.format("size = [%1$d]", globalWorkDays.size()));
//		}
//		for (BaseEmployee be : bes) {
//			generateEmployeeCheckList(be.getEmployeeId(), startDate, endDate);
//		}
//
//	}
//
//	public static String generateCheckDataFileName(int year, int month) throws Exception {
//		StringBuilder sb = new StringBuilder();
//		String rootPath = ThreadUtil.getRealPath();
//		sb.append(rootPath);
//		if (!rootPath.endsWith("/")) {
//			sb.append("/");
//		}
//		sb.append("checkdata");
//		File path = new File(sb.toString());
//		if (!path.exists()) {
//			path.mkdirs();
//		}
//		sb.append("/checkdata_");
//		sb.append(year);
//		sb.append("_");
//		sb.append(month);
//		sb.append(".mdb");
//		return sb.toString();
//	}
//
//	/**
//	 * 检索OA人员的每一天的正常上班点和下班点时间 如果人员一天涉及多个班次的，则根据当前是星期几，去检索上班的那个班次
//	 * 
//	 * @param oaUserId
//	 * @param checkDate
//	 * @return
//	 * @throws java.sql.SQLException
//	 */
//	public static Map getEmployeeNormalDate(int oaUserId, Date checkDate) throws SQLException {
//		Map<String, Date> dateMap = new HashMap<>();
//		Calendar calendar = Calendar.getInstance();
//		if (checkDate != null) {
//			calendar.setTime(checkDate);
//		}
//		// 获取当前计算天是星期几
//		int week = BaseHelpUtils.getIntValue(calendar.get(Calendar.DAY_OF_WEEK) - 1);
//		// 获取员工的所有班次数据
//		ConditionEmployeeWorkClassType condition = new ConditionEmployeeWorkClassType();
//		condition.setCheckdate(checkDate);
//		condition.setUserid(BaseHelpUtils.getString(oaUserId));
//		QueryEmployeeWorkClassType dao = new QueryEmployeeWorkClassType();
//		dao.setConnection("oahr");
//		BaseCollection<BaseEmployeeWorkClassType> result = dao.executeQuery(null, condition);
//		String onDateTime = "09:00";// 初始化上班时间点
//		String offDateTime = "18:00";// 初始化下班时间点
//		if (!BaseHelpUtils.isNullOrEmpty(result)) {
//			List<BaseEmployeeWorkClassType> resultBeans = result.getCollections();
//			for (BaseEmployeeWorkClassType bean : resultBeans) {
//				// 检索当前班次是否有效班次，即根据当前在当前班次上是否是上班，如果上班则表示是有效班次
//				boolean isNeed = checkIsNeedClassTypeItem(bean, week);
//				if (isNeed) {
//					onDateTime = BaseHelpUtils.getString(bean.getOntime());
//					offDateTime = BaseHelpUtils.getString(bean.getOfftime());
//				} else {
//					break;
//				}
//			}
//		}
//		Date normalCheckin = DateUtil.getDateOfSpecialHour(checkDate, getHourOrMinute(onDateTime, 1),
//				getHourOrMinute(onDateTime, 2));
//		Date normalCheckout = DateUtil.getDateOfSpecialHour(checkDate, getHourOrMinute(offDateTime, 1),
//				getHourOrMinute(offDateTime, 2));
//		dateMap.put("normalCheckin", normalCheckin);
//		dateMap.put("normalCheckout", normalCheckout);
//		return dateMap;
//	}
//
//	/**
//	 * 根据今天是星期几去检索当前班次是否有在上班，如果是上班，则返回true否则返回false
//	 * 
//	 * @param bean
//	 *            ：班次上班标示：1:上班;0:没上班
//	 * @param week
//	 * @return
//	 */
//	public static boolean checkIsNeedClassTypeItem(BaseEmployeeWorkClassType bean, int week) {
//		// 设置默认该班次在这一天是上班
//		boolean isNeed = true;
//		switch (week) {
//		case 1:// 星期一
//			if (BaseHelpUtils.getIntValue(bean.getMonday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		case 2:// 星期二
//			if (BaseHelpUtils.getIntValue(bean.getTuesday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		case 3:// 星期三
//			if (BaseHelpUtils.getIntValue(bean.getWednesday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		case 4:// 星期四
//			if (BaseHelpUtils.getIntValue(bean.getThursday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		case 5:// 星期五
//			if (BaseHelpUtils.getIntValue(bean.getFriday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		case 6:// 星期六
//			if (BaseHelpUtils.getIntValue(bean.getSaturday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		case 7:// 星期日
//			if (BaseHelpUtils.getIntValue(bean.getSunday()) == 0) {
//				isNeed = false;
//			}
//			break;
//		default:
//			isNeed = false;
//		}
//		return isNeed;
//	}
//
//	/**
//	 * 根据时间字符串获取小时数或者分钟数
//	 * 
//	 * @param dateTime
//	 * @param flag:1:小时数;2:分钟数
//	 * @return
//	 */
//	public static int getHourOrMinute(String dateTime, int flag) {
//		int result = 0;
//		if (!BaseHelpUtils.isNullOrEmpty(dateTime)) {
//			String[] dateTimeArr = dateTime.split(":");
//			if (!BaseHelpUtils.isNullOrEmpty(dateTimeArr) && dateTimeArr.length > 0) {
//				if (flag == 1) {
//					result = BaseHelpUtils.getIntValue(dateTimeArr[0]);
//				} else if (flag == 2) {
//					result = BaseHelpUtils.getIntValue(dateTimeArr[1]);
//				}
//			}
//		}
//		return result;
//	}
//
//	public static Map<String, List<BaseMemployeeworkor>> generateEmployeeWorkDays(Date startTime, Date endTime)
//			throws SQLException {
//		Map<String, List<BaseMemployeeworkor>> wds = new HashMap<>();
//		ConditionMemployeeworkor con = new ConditionMemployeeworkor();
//		con.setStartdate(startTime);
//		con.setEnddate(endTime);
//		QueryMemployeeworkor classTypeDao = new QueryMemployeeworkor();
//		classTypeDao.setConnection("oahr");
//		BaseCollection<BaseMemployeeworkor> classTypes = classTypeDao.executeQuery(null, con);
//		for (BaseMemployeeworkor m : classTypes.getCollections()) {
//			List<BaseMemployeeworkor> ewd = wds.get(m.getUserid());
//			if (ewd == null) {
//				ewd = new ArrayList<>();
//				wds.put(m.getUserid(), ewd);
//			}
//			ewd.add(m);
//		}
//		for (String s : wds.keySet()) {
//			List<BaseMemployeeworkor> ewd = wds.get(s);
//			if (ewd.size() > 1) {
//				Collections.sort(ewd, new EmployeeWorkDayCompare());
//				for (BaseMemployeeworkor bm : ewd) {
//					System.out.println(bm.toCSVString());
//				}
//				System.out.println("===============================================");
//			}
//
//		}
//		return wds;
//	}
//
//	public static Boolean isWorkDay(String oaid, Date td, Map<String, List<BaseMemployeeworkor>> employeeWorkDays) {
//		int dayOfWeek = DateUtil.getDayOfWeek(td);
//		int weekOfYear = DateUtil.getWeekOfYear(td);
//		boolean res;
//
//		List<BaseMemployeeworkor> ewd = employeeWorkDays.get(oaid);
//		if (ewd == null || ewd.isEmpty())
//			return null;
//
//		for (BaseMemployeeworkor m : ewd) {
//			if (td.compareTo(m.getOndate()) >= 0 && td.compareTo(m.getStopdate()) <= 0) {
//				switch (dayOfWeek) {
//				case 1:
//					if (m.getMonday() == 1)
//						return true;
//					break;
//				case 2:
//					if (m.getTuesday() == 1)
//						return true;
//					break;
//				case 3:
//					if (m.getWednesday() == 1)
//						return true;
//					break;
//				case 4:
//					if (m.getThursday() == 1)
//						return true;
//					break;
//				case 5:
//					if (m.getFriday() == 1)
//						return true;
//					break;
//				case 6:
//					if (m.getSaturday() == 1)
//						return true;
//					break;
//				case 7:
//					if (m.getSunday() == 1)
//						return true;
//					break;
//				}
//			}
//		}
//		return false;
//	}
//
//	public static void main(String[] args) {
//		try {
//			// String dateTime = "18:00";
//			// int result = getHourOrMinute(dateTime,2);
//			// System.out.println("resutl=="+result);
//			// Connection conn =
//			// ThreadConnection.getConnection().getConnection();
//			// Statement stmt = conn.createStatement();
//			// stmt.executeUpdate("delete from employee_checkinouts");
//			// stmt.executeUpdate("delete from employee_monthly_check");
//			// Date startDate = DateUtil.createFirstDayOfMonth(2016, 5);
//			// Date endDate = DateUtil.getFirstDayOfNextMonth(2016, 5);
//			// if (endDate.compareTo(new Date()) > 0) {
//			// endDate = DateUtil.getNextDayOfToday();
//			// }
//			// readFileAccess(null, startDate, endDate);
//			// readCheckData(2016, 5);
//			// processCheckData(2016, 5);
//			// readFileAccess(null, DateUtil.generateDate(2016, 5, 1),
//			// DateUtil.generateDate(2016, 6, 1));
//			// generateNormalCheckList(false, DateUtil.generateDate(2016, 4, 1),
//			// DateUtil.generateDate(2016, 5, 1));
//			// generateEmployeeCheckList(109, DateUtil.generateDate(2016, 4, 1),
//			// DateUtil.generateDate(2016, 5, 1));
//			// byte[] buff = SocketClient.callBinaryOperation("BW_getMDBFile",
//			// "", "");
//			// FileOutputStream fos = new
//			// FileOutputStream("/home/guanxgun/temp/test001.mdb");
//			// fos.write(buff);
//			// fos.close();
//
//			// con.setUsername("陈彩");
//			ReaderEmployeeCheckin.readCheckData(2017, 1);
//			ReaderEmployeeCheckin.processCheckData(2017, 1);
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

}
