package com.example.springmybatisaccountmodule.user.infrastructure.configs;

import com.example.springmybatisaccountmodule.user.domain.repositories.UserRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisMapperConfiguration {
    @Bean
    public MapperFactoryBean<UserRepository> providerRepository(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<UserRepository> factoryBean = new MapperFactoryBean<>(UserRepository.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }
}
