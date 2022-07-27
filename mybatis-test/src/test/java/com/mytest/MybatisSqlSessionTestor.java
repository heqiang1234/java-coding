package com.mytest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

/**
 * @author HQ
 * @program: java-coding
 * @description: sqlsession
 * @date 2022-07-27 23:21:36
 */
public class MybatisSqlSessionTestor {

    @Test
    public void testSqlSession() throws IOException {
        Reader asReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asReader);
        System.out.println("加载成功");
        SqlSession sqlSession = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }

    }

    @Test
    public void testSession(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        }catch (Exception e){
            throw e;
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }
}
