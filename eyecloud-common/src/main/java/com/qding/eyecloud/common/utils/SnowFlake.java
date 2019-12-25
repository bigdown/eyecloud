package com.qding.eyecloud.common.utils;

/**
 * twitter的snowflake算法 -- java实现
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年10月9日
 */
public class SnowFlake {

	public static long defaultDatacenterId = 200;
	public static long defaultMachineId = 100;

	private static SnowFlake snowFlake = new SnowFlake(defaultDatacenterId, defaultMachineId);
	/**
	 * 起始的时间戳
	 */
	private final static long START_STMP = 1574664230565L;

	/**
	 * 每一部分占用的位数
	 */
	private final static long SEQUENCE_BIT = 12;
	private final static long MACHINE_BIT = 10;
	private final static long DATACENTER_BIT = 10;

	/**
	 * 每一部分的最大值
	 */
	private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
	private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
	private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

	/**
	 * 每一部分向左的位移
	 */
	private final static long MACHINE_LEFT = SEQUENCE_BIT;
	private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
	private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

	private long datacenterId;
	private long machineId;
	private long sequence = 0L;
	private long lastStmp = -1L;

	public SnowFlake(long datacenterId, long machineId) {
		if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
			throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
		}
		if (machineId > MAX_MACHINE_NUM || machineId < 0) {
			throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
		}
		this.datacenterId = datacenterId;
		this.machineId = machineId;
	}

	/**
	 * 产生下一个ID
	 *
	 * @return
	 */
	public synchronized long nextId() {
		long currStmp = getNewstmp();
		if (currStmp < lastStmp) {
			throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
		}

		if (currStmp == lastStmp) {
			//相同毫秒内，序列号自增
			sequence = (sequence + 1) & MAX_SEQUENCE;
			//同一毫秒的序列数已经达到最大
			if (sequence == 0L) {
				currStmp = getNextMill();
			}
		} else {
			//不同毫秒内，序列号置为0
			sequence = 0L;
		}

		lastStmp = currStmp;

		return (currStmp - START_STMP) << TIMESTMP_LEFT | datacenterId << DATACENTER_LEFT | machineId << MACHINE_LEFT
				| sequence;
	}

	public String nextIdString() {
		return String.valueOf(this.nextId());
	}

	private long getNextMill() {
		long mill = getNewstmp();
		while (mill <= lastStmp) {
			mill = getNewstmp();
		}
		return mill;
	}

	private long getNewstmp() {
		return System.currentTimeMillis();
	}

	public static SnowFlake createSnowFlake() {
		//    	if(snowFlake==null) {
		//    		snowFlake = new SnowFlake(defaultDatacenterId, defaultMachineId);
		//    	}
		return snowFlake;
	}

	public static SnowFlake createSnowFlake(long datacenterId, long machineId) {
		if (snowFlake == null) {
			snowFlake = new SnowFlake(datacenterId, machineId);
		}
		return snowFlake;
	}

}