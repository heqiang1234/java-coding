package com.mytest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

/**
 * @author HQ
 * @program: java-coding
 * @description: mybatis测
 * @date 2022-07-27 23:39:52
 */
public class MybatisUtil {

    private static SqlSessionFactory sessionFactory = null;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession(){
        return sessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
