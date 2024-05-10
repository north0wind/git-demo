package com.huaibei.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiaolong
 * @date 2024/5/10
 */
@Configuration
@EnableTransactionManagement
public class JpaConfig {

    // @Bean
    // public DataSource dataSource(){
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //     dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    //     dataSource.setUrl("jdbc:mysql://localhost:3306/tetsR");
    //     dataSource.setUsername("root");
    //     dataSource.setPassword("password");
    //     return dataSource;
    // }
    //
    // @Bean
    // public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){
    //     LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    //     emf.setDataSource(dataSource);
    //     emf.setPackagesToScan("com.huaibei.entity");
    //     emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    //     return emf;
    // }
    //
    // @Bean
    // public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
    //     JpaTransactionManager transactionManager = new JpaTransactionManager();
    //     transactionManager.setEntityManagerFactory(entityManagerFactory);
    //     return transactionManager;
    //
    //
    // }
}
