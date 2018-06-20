package com.thienhoang.ehrm.springconfig;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.thienhoang.ehrm")
@PropertySource(value = {"classpath:hibernate.properties"})
public class AppConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) throws IOException {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan(new String[] { "com.thienhoang.ehrm.model" });
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.afterPropertiesSet();
		return localSessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//		properties.put("current_session_context_class", environment.getProperty("current_session_context_class"));  -- bo dong nay vi chuyen quyen quan ly transaction cho spring
		properties.put("hibernate.search.autoregister_listeners", environment.getRequiredProperty("hibernate.search.autoregister_listeners"));
		properties.put("hibernate.validator.apply_to_ddl", environment.getRequiredProperty("hibernate.validator.apply_to_ddl"));
		properties.put("hibernate.bytecode.use_reflection_optimizer", environment.getRequiredProperty("hibernate.bytecode.use_reflection_optimizer"));
		properties.put("hibernate.enable_lazy_load_no_trans", environment.getProperty("hibernate.enable_lazy_load_no_trans"));
		return properties;        
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager(s);
		return txManager;
	}
}
