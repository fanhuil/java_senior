package com.fanhuilin.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 * 遇到的对象：
 * 1、DriverManager：驱动管理对象
 *  功能：
 *      注册驱动
 *      获取数据库连接
 * 2、Connection：数据库连接对象
 * 3、Statement：执行sql的对象
 * 4、ResultSet: 结果集对象
 * 5、PreparedStatement:执行sql的对象
 *
 * @author fanhuilin
 * @date 2021-09-28 16:56
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // 1、导入驱动jar包（Add As Library）
        // 2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 3、获取数据库链接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/www_backstage_com", "www_backstage_com", "www_backstage_com");
        // 4、定义sql语句
        String sql = "update users set email='fanhuilin@163.com' where id = 1";
        // 5、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        // 6、执行sql
        int count = stmt.executeUpdate(sql);
        // 7、处理结果
        System.out.println(count);
        // 8、释放资源
        stmt.close();
        conn.close();
    }
}
