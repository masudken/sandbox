package jp.co.gfam.gits.integration.dao.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import jp.co.gfam.gits.common.criteria.UserCriteria;
import jp.co.gfam.gits.common.entity.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Kenichi Masuda
 *
 */
public class UserDaoImplTest {

    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    private UserDaoImpl target = new UserDaoImpl();

    @Before
    public void open() throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/gits", "gfam", "gfam");
        connectionHolder.set(connection);
    }

    @After
    public void close() {

    }

    /**
     * {@link jp.co.gfam.gits.integration.dao.impl.UserDaoImpl#search(jp.co.gfam.gits.common.criteria.UserCriteria)}
     * のためのテスト・メソッド。
     */
    @Test
    public void testSearch() throws Exception {
        UserCriteria criteria = new UserCriteria();
        criteria.setUserId(123);
        Connection con = connectionHolder.get();
        List<User> results = target.search(criteria);
    }

}
