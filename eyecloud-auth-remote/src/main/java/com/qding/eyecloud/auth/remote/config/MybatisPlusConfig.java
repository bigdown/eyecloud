package com.qding.eyecloud.auth.remote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

@Configuration
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 * 
	 * @return
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		
		// List<ISqlParser> sqlParserList = new ArrayList<>();
		// // 攻击 SQL 阻断解析器、加入解析链
		// sqlParserList.add(new BlockAttackSqlParser());
		// paginationInterceptor.setSqlParserList(sqlParserList);

		return paginationInterceptor;
	}
	
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
	    return new OptimisticLockerInterceptor();
	}

	/**
	 * SQL执行效率插件
	 */
//	@Bean
//	@Profile({ "dev", "test" }) // 设置 dev test 环境开启
//	public PerformanceInterceptor performanceInterceptor() {
//		return new PerformanceInterceptor();
//	}
}
