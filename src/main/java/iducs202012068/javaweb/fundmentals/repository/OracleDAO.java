package iducs202012068.javaweb.fundmentals.repository;

import java.sql.*;

public class OracleDAO implements DAO {
    @Override
    public Connection getConnection() {
        Connection conn = null;
        String jdbcUrl ="jdbc:oracle:thin:@localhost:1521:XE";
        String dbUser = "sw202012068";
        String dbPass = "cometrue";
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {

    }
}
