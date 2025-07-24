-- Table: customers

-- DROP TABLE customers;

CREATE TABLE customers
(
  customer_id serial NOT NULL, -- 客户代码
  customer_name character varying(256), -- 客户名称
  email character varying(128), -- 注册邮箱
  passwd character varying(128), -- 密码
  organization character varying(128), -- 组织名称
  come_from integer, -- 客户来源
  send_me_news boolean, -- 愿意接收消息
  status integer, -- 状态，0-新注册，1-下载试用，2-已购买
  register_time timestamp without time zone, -- 注册日期
  download_time timestamp without time zone, -- 下载日期
  purchase_time timestamp without time zone, -- 购买日期
  CONSTRAINT customers_pkey PRIMARY KEY (customer_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE customers
  OWNER TO postgres;
COMMENT ON TABLE customers
  IS '客户表';
COMMENT ON COLUMN customers.customer_id IS '客户代码';
COMMENT ON COLUMN customers.customer_name IS '客户名称';
COMMENT ON COLUMN customers.email IS '注册邮箱';
COMMENT ON COLUMN customers.passwd IS '密码';
COMMENT ON COLUMN customers.organization IS '组织名称';
COMMENT ON COLUMN customers.come_from IS '客户来源';
COMMENT ON COLUMN customers.send_me_news IS '愿意接收消息';
COMMENT ON COLUMN customers.status IS '状态';
COMMENT ON COLUMN customers.register_time IS '注册日期';
COMMENT ON COLUMN customers.download_time IS '下载日期';
COMMENT ON COLUMN customers.purchase_time IS '购买日期';


-- Table: licences

-- DROP TABLE licences;

CREATE TABLE licences
(
  licence_id serial NOT NULL, -- 产品授权代码
  product_id integer, -- 产品代码，0-代码生成器，1-客户服务，2-定制开发
  product_name character varying(256), -- 产品名称
  licence_code character varying(64), -- 授权码
  licence_type integer, -- 授权类型，0-试用，1-个人授权，2-企业授权
  quantity integer default 1, -- 授权数量
  status integer, -- 状态，0-新生成，1-已发放，2-作废
  generate_time timestamp without time zone, -- 生成日期
  grant_time timestamp without time zone, -- 授权日期
  grant_start_time timestamp without time zone, -- 开始日期
  grant_end_time timestamp without time zone, -- 结束日期
  customer_id integer, -- 授权客户
  CONSTRAINT licences_pkey PRIMARY KEY (licence_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE licences
  OWNER TO postgres;
COMMENT ON TABLE licences
  IS '客户表';
COMMENT ON COLUMN licences.licence_id IS '产品授权代码';
COMMENT ON COLUMN licences.product_id IS '产品代码';
COMMENT ON COLUMN licences.product_name IS '产品名称';
COMMENT ON COLUMN licences.licence_code IS '授权码';
COMMENT ON COLUMN licences.licence_type IS '授权类型';
COMMENT ON COLUMN licences.quantity IS '授权数量';
COMMENT ON COLUMN licences.status IS '状态';
COMMENT ON COLUMN licences.generate_time IS '生成日期';
COMMENT ON COLUMN licences.grant_time IS '授权日期';
COMMENT ON COLUMN licences.grant_start_time IS '开始日期';
COMMENT ON COLUMN licences.grant_end_time IS '结束日期';
COMMENT ON COLUMN licences.customer_id IS '授权客户';

-- Table: licence_machines

-- DROP TABLE licence_machines;

CREATE TABLE licence_machines
(
  licence_machine_id serial NOT NULL, -- 授权使用机器代码
  licence_id integer, -- 授权代码
  machine_mac_address character varying(64), -- 机器MAC地址
  machine_ip_address character varying(64), -- 机器IP地址
  ip_area character varying(64), -- IP地址区域
  licence_type integer, -- 授权类型，0-试用，1-个人授权，2-企业授权
  quantity integer default 1, -- 授权数量
  status integer, -- 状态，0-新生成，1-已发放，2-作废
  generate_time timestamp without time zone, -- 生成日期
  grant_time timestamp without time zone, -- 授权日期
  grant_start_time timestamp without time zone, -- 开始日期
  grant_end_time timestamp without time zone, -- 结束日期
  customer_id integer, -- 授权客户
  CONSTRAINT licences_pkey PRIMARY KEY (licence_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE licences
  OWNER TO postgres;
COMMENT ON TABLE licences
  IS '客户表';
COMMENT ON COLUMN licences.licence_id IS '产品授权代码';
COMMENT ON COLUMN licences.product_id IS '产品代码';
COMMENT ON COLUMN licences.product_name IS '产品名称';
COMMENT ON COLUMN licences.licence_code IS '授权码';
COMMENT ON COLUMN licences.licence_type IS '授权类型';
COMMENT ON COLUMN licences.quantity IS '授权数量';
COMMENT ON COLUMN licences.status IS '状态';
COMMENT ON COLUMN licences.generate_time IS '生成日期';
COMMENT ON COLUMN licences.grant_time IS '授权日期';
COMMENT ON COLUMN licences.grant_start_time IS '开始日期';
COMMENT ON COLUMN licences.grant_end_time IS '结束日期';
COMMENT ON COLUMN licences.customer_id IS '授权客户';


