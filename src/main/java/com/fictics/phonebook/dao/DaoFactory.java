package com.fictics.phonebook.dao;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public final class DaoFactory {

    private DaoFactory() {
    }

    private static SqlSession getSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory fs = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return fs.openSession(true);
    }

    public static UserDao getUserDao() throws IOException {
        return getSqlSession().getMapper(UserDao.class);
    }


    public static ContactDao getContactDao() throws IOException {
        return getSqlSession().getMapper(ContactDao.class);
    }

}
