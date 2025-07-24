--���ŵ����¼��
Drop TABLE if exists plate_deploy_records;
CREATE TABLE plate_deploy_records
(
  plate_deploy_record_id serial primary key not null, -- ID
  plate_id integer, -- ҵ����
  advance_integral numeric(18,2) DEFAULT 0, --�������
  advance_date date, -- ��������
  operate_time timestamp ,--����ʱ��
  operate_employee_id int default 0, -- ������
  remark varchar(512)  -- ��ע
)
WITH (
  OIDS=FALSE
);
ALTER TABLE plate_deploy_records
  OWNER TO postgres;
COMMENT ON TABLE plate_deploy_records
  IS '���ŵ����¼��';
COMMENT ON COLUMN plate_deploy_records.plate_deploy_record_id IS '����ID';
COMMENT ON COLUMN plate_deploy_records.plate_id IS 'ҵ����';
COMMENT ON COLUMN plate_deploy_records.advance_integral IS '�������';
COMMENT ON COLUMN plate_deploy_records.advance_date IS '��������';
COMMENT ON COLUMN plate_deploy_records.operate_time IS '����ʱ��';
COMMENT ON COLUMN plate_deploy_records.operate_employee_id IS '������';
COMMENT ON COLUMN plate_deploy_records.remark IS '��ע';

--���ŵ����Ա��¼��
Drop TABLE if exists plate_deploy_details;
CREATE TABLE plate_deploy_details
(
  plate_deploy_detail_id serial primary key not null, -- ����ID
  plate_deploy_record_id int ,  --�ܱ�id
  employee_id int default 0, -- �����Ա
  advance_integral numeric(10,2) default 0,--�������
  advance_date date ,--��������
  operate_time timestamp ,--����ʱ��
  operate_employee_id int default 0, -- ������
  remark varchar(512)  -- ��ע
)
WITH (
  OIDS=FALSE
);
ALTER TABLE plate_deploy_details
  OWNER TO postgres;
COMMENT ON TABLE plate_deploy_details
  IS '���ŵ����Ա��¼��';
COMMENT ON COLUMN plate_deploy_details.plate_deploy_detail_id IS '����ID';
COMMENT ON COLUMN plate_deploy_details.plate_deploy_record_id IS '�ܱ�id';
COMMENT ON COLUMN plate_deploy_details.employee_id IS '�����Ա';
COMMENT ON COLUMN plate_deploy_details.advance_integral IS '�������';
COMMENT ON COLUMN plate_deploy_details.advance_date IS '��������';
COMMENT ON COLUMN plate_deploy_details.operate_time IS '����ʱ��';
COMMENT ON COLUMN plate_deploy_details.operate_employee_id IS '������';
COMMENT ON COLUMN plate_deploy_details.remark IS '��ע';


--��ֵ�����ܱ�
Drop TABLE if exists output_account_records;
CREATE TABLE output_account_records
(
  output_account_record_id serial primary key not null, -- ID
  plate_id integer, -- ҵ����
  dep_account_integral numeric(18,2) DEFAULT 0, --���Ž����ܻ���
  emp_account_integral numeric(18,2) DEFAULT 0, --��Ա�����ܻ���
  start_date date, -- ��ʼ����
  end_date date, -- ��������
  account_date date, -- ��������
  year int,--�������
  month int,--�����·�
  is_year_final_account boolean,--�Ƿ���������һ�ν���
  operate_time timestamp ,--����ʱ��
  operate_employee_id int default 0, -- ������
  remark varchar(512)  -- ��ע
)
WITH (
  OIDS=FALSE
);
ALTER TABLE output_account_records
  OWNER TO postgres;
COMMENT ON TABLE output_account_records
  IS '��ֵ�����ܱ�';
COMMENT ON COLUMN output_account_records.output_account_record_id IS '����ID';
COMMENT ON COLUMN output_account_records.plate_id IS 'ҵ����';
COMMENT ON COLUMN output_account_records.dep_account_integral IS '���Ž����ܻ���';
COMMENT ON COLUMN output_account_records.emp_account_integral IS '��Ա�����ܻ���';
COMMENT ON COLUMN output_account_records.start_date IS '��ʼ����';
COMMENT ON COLUMN output_account_records.end_date IS '��������';
COMMENT ON COLUMN output_account_records.account_date IS '��������';
COMMENT ON COLUMN output_account_records.year IS '�������';
COMMENT ON COLUMN output_account_records.month IS '�����·�';
COMMENT ON COLUMN output_account_records.is_year_final_account IS '�Ƿ���������һ�ν���';
COMMENT ON COLUMN output_account_records.operate_time IS '����ʱ��';
COMMENT ON COLUMN output_account_records.operate_employee_id IS '������';
COMMENT ON COLUMN output_account_records.remark IS '��ע';

--��ֵ�����Ա��ϸ��
Drop TABLE if exists output_account_details;
CREATE TABLE output_account_details
(
  output_account_detail_id serial primary key not null, -- ����ID
  output_account_record_id int ,  --�ܱ�id
  employee_id int default 0, -- �����Ա
  account_integral numeric(10,2) default 0,--�������
  start_date date, -- ��ʼ����
  end_date date, -- ��������
  account_date date, -- ��������
  year int,--�������
  month int,--�����·�
  is_year_final_account boolean--�Ƿ���������һ�ν���
)
WITH (
  OIDS=FALSE
);
ALTER TABLE output_account_details
  OWNER TO postgres;
COMMENT ON TABLE output_account_details
  IS '��ֵ�����Ա��ϸ��';
COMMENT ON COLUMN output_account_details.output_account_detail_id IS '����ID';
COMMENT ON COLUMN output_account_details.output_account_record_id IS '�ܱ�id';
COMMENT ON COLUMN output_account_details.employee_id IS '�����Ա';
COMMENT ON COLUMN output_account_details.account_integral IS '�������';
COMMENT ON COLUMN output_account_details.start_date IS '��ʼ����';
COMMENT ON COLUMN output_account_details.end_date IS '��������';
COMMENT ON COLUMN output_account_details.account_date IS '��������';
COMMENT ON COLUMN output_account_details.year IS '�������';
COMMENT ON COLUMN output_account_details.month IS '�����·�';
COMMENT ON COLUMN output_account_details.is_year_final_account IS '�Ƿ���������һ�ν���';

ALTER TABLE employee_month_checks ADD COLUMN overtime_pay_sub numeric(18,2);
ALTER TABLE employee_month_checks ALTER COLUMN overtime_pay_sub SET DEFAULT 0;
COMMENT ON COLUMN employee_month_checks.overtime_pay_sub IS '�Ӱಹ��(����)';

ALTER TABLE employee_month_checks ADD COLUMN overtime_pay_sub_before numeric(18,2);
ALTER TABLE employee_month_checks ALTER COLUMN overtime_pay_sub_before SET DEFAULT 0;
COMMENT ON COLUMN employee_month_checks.overtime_pay_sub_before IS '�Ӱಹ��';

ALTER TABLE employee_month_checks ADD COLUMN overtime_pay_before numeric(18,2);
ALTER TABLE employee_month_checks ALTER COLUMN overtime_pay_before SET DEFAULT 0;
COMMENT ON COLUMN employee_month_checks.overtime_pay_before IS '�Ӱ�Ͳ�';

ALTER TABLE employee_day_checks ADD COLUMN overtime_pay_sub numeric(18,2);
ALTER TABLE employee_day_checks ALTER COLUMN overtime_pay_sub SET DEFAULT 0;
COMMENT ON COLUMN employee_day_checks.overtime_pay_sub IS '�Ӱಹ��(����)';

ALTER TABLE employee_day_checks ADD COLUMN overtime_pay_sub_before numeric(18,2);
ALTER TABLE employee_day_checks ALTER COLUMN overtime_pay_sub_before SET DEFAULT 0;
COMMENT ON COLUMN employee_day_checks.overtime_pay_sub_before IS '�Ӱಹ��';

ALTER TABLE employee_day_checks ADD COLUMN overtime_pay_before numeric(18,2);
ALTER TABLE employee_day_checks ALTER COLUMN overtime_pay_before SET DEFAULT 0;
COMMENT ON COLUMN employee_day_checks.overtime_pay_before IS '�Ӱ�Ͳ�';