package org.dteja.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.dteja.models.Category;
import org.dteja.models.Product;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	@Bean
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/shopppingportal");
		dataSource.setUsername("manasi");
		dataSource.setPassword("manasi");
		return dataSource;
	}

	@Bean
	public SessionFactory getsessionfactory() {

		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");

		LocalSessionFactoryBuilder localSessionFactory = new LocalSessionFactoryBuilder(getH2DataSource());
		localSessionFactory.addProperties(hibernateProp);
		localSessionFactory.addAnnotatedClass(Category.class);
		localSessionFactory.addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = localSessionFactory.buildSessionFactory();
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionmanager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
