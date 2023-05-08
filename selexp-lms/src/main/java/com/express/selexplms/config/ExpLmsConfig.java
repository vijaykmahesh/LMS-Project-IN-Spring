package com.express.selexplms.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class ExpLmsConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.express.selexplms.entity");
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;

	}

	private Properties getHibernateProperties() {

		Properties property = new Properties();
		property.put("hibernate.show_sql", "true");
		property.put("hibernate.format_sql", "true");
		property.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

		return property;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {

		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);

		return manager;
	}

	@Bean
	public DataSource getDataSource() throws PropertyVetoException {

		/* It doesn't uses connection pool concept */

//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/expressportal");
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("root");
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/expressportal");
		pooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");

		// pooledDataSource.setInitialPoolSize(30);
		pooledDataSource.setAcquireIncrement(10);

		return pooledDataSource;
	}

}
