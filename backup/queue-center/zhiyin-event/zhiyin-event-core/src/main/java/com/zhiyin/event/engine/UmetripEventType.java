package com.zhiyin.event.engine;


public enum UmetripEventType {

	UNDEFINED("未定义事件","0000"),
	//0

	//10
	FLTIF("航班初始化", "1001"), OFF("起飞","1002"), ONN("到达","1003"),
	ETD_CHG("预计起飞时间变更","1004"),ETA_CHG("预计到达时间变更","1005"),
	GATE_INIT("登机口初始化","1006"), GATE_CHG("登机口变更","1007"),
	EQUIPNO_INIT("设备号初始化","1008"),EQUIPNO_CHG("设备号变更","1009"),
	PLANETYPE_INIT("飞机型号初始化","1010"),PLANETYPE_CHG("飞机型号变更","1011"),
	CKISTATUS_CHG("值机状态变更","1012"),
	PRE_FLIGHT_OFF("前序航班起飞","1013"),PRE_FLIGHT_ONN("前序航班到达","1014"),
	PREFLIGHT_CHG("前续航班变更","1015"),
	PTD_CHG("计划起飞时间变更","1016"),PTA_CHG("计划到达时间变更","1017"),

	CANCEL("航班取消","1018"),RETURN("返航","1019"),ALTERNATE("备降","1020"),CANANDRE("恢复","1021"),BACKUPOFF("备降返航后起飞","1022"),

	BACKUPSTATUS("备降取消后状态","1023"),BACKUPONN("到达备降返航地","1024"),BAGGAGE("行李转盘","1025"),CHECKIN("值机柜台","1026"),
	PARKING("停机位","1027"),DELAYREASON("延误原因","1028"),

	ATD("关舱","1029"), ATA("开舱","1030"),

	DEP_TEMP_CHG("出发机场温度变更"),DEP_TRAFFIC_CHG("出发机场流量变更"),DEP_WIND_CHG("出发机场风力变更"),DEP_VIS_CHG("出发机场能见度变更"),
	DEST_TEMP_CHG("到达机场温度变更"),DEST_TRAFFIC_CHG("到达机场流量变更"),DEST_WIND_CHG("到达机场风力变更"),DEST_VIS_CHG("到达机场能见度变更"),
	DEP_TERM_CHG("乘机楼变更"),DEST_TERM_CHG("接机楼变更"),
	SKIF("sk初始化"),

	//11
	PEAS_GIVEN_BY_INVITATION("邀请赠送", "1101"),
	//12
	PEAS_GIVEN_BY_SHARE("分享赠送", "1201"),

	// 20 行程事件

	ISSUE("出票", "2001"),REISSUE("OI换开", "2002"), PETNEW("纸票换开","2003"),
	VT("废票", "2004"), FIMEXCHANGE("值机后临时换开", "2005"), SUSPENDED("票挂起", "2006"),
	DESUSPEND("解挂", "2007"), NAMECHANGE("旅客姓名变更", "2008"), IDCHANGE("旅客证件信息变更", "2009"),

	TRFD("退票","2010"), ETRF("退票取消","2011"), REVALIDATION("改期","2012"),
	PA("离港系统PA操作","2013"), GOSHOW("值机时goshow变更","2014"), PW("离港系统PW操作","2015"), BOARDED("登机","2016"),
	USED("USED","2017"), FLOWN("FLOWN","2018"), REOPEN("REOPEN","2019"), CABINCHANGE("舱位变更","2020"),
	TKTSTATUS_CHG("客票状态变更", "2021"),

	SEAT_CHG("座位号变更","2022"),
	DEPTTIME_CHANGE("计划起飞时刻变更","2023"),

	//CKIIF("旅客离港系统初始化","2021"), CKISEAT("座位号变更","2022"), CKIACC("旅客值机ACC","2023"), CKIDEL("旅客值机删除DEL","2024"),

	AIRLINE_ISSUE("航空公司出票", "2041"),AIRLINE_TRFD("航空公司退票","2042"), AIRLINE_ETRF("航空公司退票取消","2043"),
	AIRLINE_REVALIDATION("航空公司改期","2044"),AIRLINE_PA("航空公司旅客值机ACC","2045"), AIRLINE_PW("航空公司旅客值机删除DEL","2046"),
	AIRLINE_SEAT_CHG("航空公司座位号变更","2047"),


	// 不区分具体类型的统一变更事件
	PSR_ALL("行程变更", "2099"),

	// 30
	TRIP_SUB("行程订阅", "3001"),
	// 31
	USER_AUTH_SUCC("用户认证成功", "3101"), USER_AUTH_FAIL("用户认证失败", "3102"), USER_AUTH_REPEAT("用户认证重复不通过", "3103"),
	// 32
	SUB_GATE_NOTIFY("订阅-登机口提醒","3201"), SUB_PREOFF_NOTIFY("订阅-起飞前的动态提醒","3202"),
	SUB_PLANE_AGE_TYPE_NOTIFY("订阅-机龄机型提醒","3203"),
	// 33
	TRIP_GATE_NOTIFY("行程-登机口提醒","3301"), TRIP_PREOFF_NOTIFY("行程-起飞前的动态提醒","3302"),
	TRIP_PLANE_AGE_TYPE_NOTIFY("行程-机龄机型提醒","3303"),
	TRIP_CHECKIN_NOTIFY("行程-值机提醒","3304"), TRIP_ISSUE_NOTIFY("行程-出票提醒","3305"),
	// 34
	USER_CERT_CHANGE("用户证件变更", "3401"),
	// 35
	FLIGHT_SUB_SUCC_NOTIFY("航班订阅成功提醒", "3501"),
	// 36
	CONTACT_UPLOAD("上传通讯录", "3601"),
	// 37
	USER_MOBILE_CHANGE("用户手机号变更", "3701"),
	USER_FEEDBACK("用户反馈", "3801"),
	USER_DATA_TRANS("导老表用户数据", "3901"),

	// 40
	TRIP_DETR_UPDATE("detr更新用户行程列表", "4001"),

	// 41
	FRIEND_INVITE("好友邀请", "4101"), FRIEND_ACCEPT("好友接受", "4102"), FRIEND_REJECT("好友拒绝", "4102"),

	// 42
	AGENTFLIGHT_SUB_SUCC_NOTIFY("一键订阅成功提醒","4201"),
	// 43
	HADOOP_SCHEDULE("HadoopSchedule", "4301"),
	// 44
	VERIFICATION_CODE_NOTIFY("验证码提醒", "4401"),

	// 45
	CONSOLE_MESSAGE_SEND("管理端单发消息", "4501"),
	// 46
	AGENT_PLANE_AGE_TYPE_NOTIFY("Agent机龄机型提醒","4601"),AGENT_CHECKIN_NOTIFY("Agent开放值机提醒","4602"),

	// 47
	USER_COMMON_MSG("用户通用消息","4701"),USER_ALILOGIN_MSG("支付宝用户登录","4702"),UME_LVDOU_SEND("旅豆赠送", "4703"),

	// 48
	INVITE_MSG("邀请好友","4801"),

	// 49
	REDIS_TRANS("redis数据主机间传导","4901"),
	// 50
	REQUEST_FFP_INFO("里程获取请求", "5001"),
	// 51
	RESPONSE_FFP_INFO("里程获取响应", "5101"),
	// 52
	ADD_FFP_INFO("ADD_FFP_INFO", "5201"),
	//53
	AUTO_PA_SUCCEED("自动值机成功", "5301"), AUTO_PA_FAIL("自动值机失败","5302"),

	//54
	SC_COMMON("余票宝通用消息","5401") ,
	//55
	SC_TICKET_LESS_BY_AREA("余票紧张消息-按航线", "5501"),
	SC_TICKET_LESS_BY_FLIGHTNO("余票紧张消息-按航班", "5502"),
	SC_TICKET_NONE_BY_PRICE_BY_AREA("机票售完消息-按航线", "5503"),
	SC_TICKET_NONE_BY_PRICE_BY_FLIGHTNO("机票售完事件-按航班", "5504"),
	SC_TICKET_APPEAR_BY_PRICE_BY_AREA("新增X折机票消息-按航线", "5505"),
	SC_TICKET_APPEAR_BY_PRICE_BY_FLIGHTNO("新增X折机票消息-按航班", "5506"),

	//61
	SUB_FLIGHT_STATUS("订阅","6101") ,

	//62
	CKI("值机","6201") ,

	//63
	USER_TRIP_OPEN_CKI("用户行程开放值机","6301"),

	//64
	SC_RULE("余票订阅", "6401"),

	//65
	ACTIVITY_FILL_DETR("detr补录", "6501"), ACTIVITY_FILL_WEB("web抓取补录", "6502"),
	ACTIVITY_FILL_SELF("登机凭证补录", "6503");

	//		FLIGHT_FOLLOW_NOTIFY("航班关注提醒", "3005");
	private String name;
	private String typeCode;//1100, 2100等

	private UmetripEventType(String name,String typeCode) {
		this.name = name;
		this.typeCode = typeCode;
	}

	private UmetripEventType(String name) {
		this.name = name;
	}

	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param typeCode
	 * @throws IllegalArgumentException if typeCode is not valid EventType code
	 */
	public static UmetripEventType fromTypeCode(String typeCode) {
		if (typeCode != null) {
			for (UmetripEventType b : UmetripEventType.values()) {
				if (typeCode.equalsIgnoreCase(b.typeCode)) {
					return b;
				}
			}
		}
		throw new IllegalArgumentException("No constant with typeCode " + typeCode + " found");
	}

	@Override
	public String toString() {
		return name;
	}
}
