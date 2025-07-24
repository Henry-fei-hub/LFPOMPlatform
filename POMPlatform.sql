--部门调配记录表
Drop TABLE if exists plate_deploy_records;
CREATE TABLE plate_deploy_records
(
  plate_deploy_record_id serial primary key not null, -- ID
  plate_id integer, -- 业务部门
  advance_integral numeric(18,2) DEFAULT 0, --调配积分
  advance_date date, -- 调配日期
  operate_time timestamp ,--操作时间
  operate_employee_id int default 0, -- 操作人
  remark varchar(512)  -- 备注
)
WITH (
  OIDS=FALSE
);
ALTER TABLE plate_deploy_records
  OWNER TO postgres;
COMMENT ON TABLE plate_deploy_records
  IS '部门调配记录表';
COMMENT ON COLUMN plate_deploy_records.plate_deploy_record_id IS '主键ID';
COMMENT ON COLUMN plate_deploy_records.plate_id IS '业务部门';
COMMENT ON COLUMN plate_deploy_records.advance_integral IS '调配积分';
COMMENT ON COLUMN plate_deploy_records.advance_date IS '调配日期';
COMMENT ON COLUMN plate_deploy_records.operate_time IS '操作时间';
COMMENT ON COLUMN plate_deploy_records.operate_employee_id IS '操作人';
COMMENT ON COLUMN plate_deploy_records.remark IS '备注';

--部门调配成员记录表
Drop TABLE if exists plate_deploy_details;
CREATE TABLE plate_deploy_details
(
  plate_deploy_detail_id serial primary key not null, -- 主键ID
  plate_deploy_record_id int ,  --总表id
  employee_id int default 0, -- 调配成员
  advance_integral numeric(10,2) default 0,--调配积分
  advance_date date ,--调配日期
  operate_time timestamp ,--操作时间
  operate_employee_id int default 0, -- 操作人
  remark varchar(512)  -- 备注
)
WITH (
  OIDS=FALSE
);
ALTER TABLE plate_deploy_details
  OWNER TO postgres;
COMMENT ON TABLE plate_deploy_details
  IS '部门调配成员记录表';
COMMENT ON COLUMN plate_deploy_details.plate_deploy_detail_id IS '主键ID';
COMMENT ON COLUMN plate_deploy_details.plate_deploy_record_id IS '总表id';
COMMENT ON COLUMN plate_deploy_details.employee_id IS '调配成员';
COMMENT ON COLUMN plate_deploy_details.advance_integral IS '调配积分';
COMMENT ON COLUMN plate_deploy_details.advance_date IS '调配日期';
COMMENT ON COLUMN plate_deploy_details.operate_time IS '操作时间';
COMMENT ON COLUMN plate_deploy_details.operate_employee_id IS '操作人';
COMMENT ON COLUMN plate_deploy_details.remark IS '备注';


--产值结算总表
Drop TABLE if exists output_account_records;
CREATE TABLE output_account_records
(
  output_account_record_id serial primary key not null, -- ID
  plate_id integer, -- 业务部门
  dep_account_integral numeric(18,2) DEFAULT 0, --部门结算总积分
  emp_account_integral numeric(18,2) DEFAULT 0, --成员结算总积分
  start_date date, -- 开始日期
  end_date date, -- 结束日期
  account_date date, -- 结算日期
  year int,--结算年份
  month int,--结算月份
  is_year_final_account boolean,--是否是年度最后一次结算
  operate_time timestamp ,--操作时间
  operate_employee_id int default 0, -- 操作人
  remark varchar(512)  -- 备注
)
WITH (
  OIDS=FALSE
);
ALTER TABLE output_account_records
  OWNER TO postgres;
COMMENT ON TABLE output_account_records
  IS '产值结算总表';
COMMENT ON COLUMN output_account_records.output_account_record_id IS '主键ID';
COMMENT ON COLUMN output_account_records.plate_id IS '业务部门';
COMMENT ON COLUMN output_account_records.dep_account_integral IS '部门结算总积分';
COMMENT ON COLUMN output_account_records.emp_account_integral IS '成员结算总积分';
COMMENT ON COLUMN output_account_records.start_date IS '开始日期';
COMMENT ON COLUMN output_account_records.end_date IS '结束日期';
COMMENT ON COLUMN output_account_records.account_date IS '结算日期';
COMMENT ON COLUMN output_account_records.year IS '结算年份';
COMMENT ON COLUMN output_account_records.month IS '结算月份';
COMMENT ON COLUMN output_account_records.is_year_final_account IS '是否是年度最后一次结算';
COMMENT ON COLUMN output_account_records.operate_time IS '操作时间';
COMMENT ON COLUMN output_account_records.operate_employee_id IS '操作人';
COMMENT ON COLUMN output_account_records.remark IS '备注';

--产值结算成员明细表
Drop TABLE if exists output_account_details;
CREATE TABLE output_account_details
(
  output_account_detail_id serial primary key not null, -- 主键ID
  output_account_record_id int ,  --总表id
  employee_id int default 0, -- 结算成员
  account_integral numeric(10,2) default 0,--结算积分
  start_date date, -- 开始日期
  end_date date, -- 结束日期
  account_date date, -- 结算日期
  year int,--结算年份
  month int,--结算月份
  is_year_final_account boolean--是否是年度最后一次结算
)
WITH (
  OIDS=FALSE
);
ALTER TABLE output_account_details
  OWNER TO postgres;
COMMENT ON TABLE output_account_details
  IS '产值结算成员明细表';
COMMENT ON COLUMN output_account_details.output_account_detail_id IS '主键ID';
COMMENT ON COLUMN output_account_details.output_account_record_id IS '总表id';
COMMENT ON COLUMN output_account_details.employee_id IS '结算成员';
COMMENT ON COLUMN output_account_details.account_integral IS '结算积分';
COMMENT ON COLUMN output_account_details.start_date IS '开始日期';
COMMENT ON COLUMN output_account_details.end_date IS '结束日期';
COMMENT ON COLUMN output_account_details.account_date IS '结算日期';
COMMENT ON COLUMN output_account_details.year IS '结算年份';
COMMENT ON COLUMN output_account_details.month IS '结算月份';
COMMENT ON COLUMN output_account_details.is_year_final_account IS '是否是年度最后一次结算';

ALTER TABLE employee_month_checks ADD COLUMN overtime_pay_sub numeric(18,2);
ALTER TABLE employee_month_checks ALTER COLUMN overtime_pay_sub SET DEFAULT 0;
COMMENT ON COLUMN employee_month_checks.overtime_pay_sub IS '加班补助(本月)';

ALTER TABLE employee_month_checks ADD COLUMN overtime_pay_sub_before numeric(18,2);
ALTER TABLE employee_month_checks ALTER COLUMN overtime_pay_sub_before SET DEFAULT 0;
COMMENT ON COLUMN employee_month_checks.overtime_pay_sub_before IS '加班补助';

ALTER TABLE employee_month_checks ADD COLUMN overtime_pay_before numeric(18,2);
ALTER TABLE employee_month_checks ALTER COLUMN overtime_pay_before SET DEFAULT 0;
COMMENT ON COLUMN employee_month_checks.overtime_pay_before IS '加班餐补';

ALTER TABLE employee_day_checks ADD COLUMN overtime_pay_sub numeric(18,2);
ALTER TABLE employee_day_checks ALTER COLUMN overtime_pay_sub SET DEFAULT 0;
COMMENT ON COLUMN employee_day_checks.overtime_pay_sub IS '加班补助(本月)';

ALTER TABLE employee_day_checks ADD COLUMN overtime_pay_sub_before numeric(18,2);
ALTER TABLE employee_day_checks ALTER COLUMN overtime_pay_sub_before SET DEFAULT 0;
COMMENT ON COLUMN employee_day_checks.overtime_pay_sub_before IS '加班补助';

ALTER TABLE employee_day_checks ADD COLUMN overtime_pay_before numeric(18,2);
ALTER TABLE employee_day_checks ALTER COLUMN overtime_pay_before SET DEFAULT 0;
COMMENT ON COLUMN employee_day_checks.overtime_pay_before IS '加班餐补';