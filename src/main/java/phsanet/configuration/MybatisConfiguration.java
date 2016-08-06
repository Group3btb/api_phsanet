package phsanet.configuration;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@MapperScan("phsanet.repositorys")
public class MybatisConfiguration {
	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		return sqlSessionFactoryBean;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	 @Bean
	 public Docket api() { 
	    return new Docket(DocumentationType.SWAGGER_2)  
	        .select()                                  
	        .apis(RequestHandlerSelectors.any())              
	        .paths(PathSelectors.any())                          
	        .build();                                           
	    }
	 
}
