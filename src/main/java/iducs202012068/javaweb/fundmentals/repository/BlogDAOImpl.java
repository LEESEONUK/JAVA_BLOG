package iducs202012068.javaweb.fundmentals.repository;

import iducs202012068.javaweb.fundmentals.model.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOImpl extends OracleDAO implements BlogDAO{
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public int create(Blog b) {
        int ret = 0;
        String sql = "insert into blog values(seq_member.nextval,?,?,?,?)";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());
            pstmt.setString(3, b.getAuthor());
            pstmt.setString(4, b.getEmail());
            ret = pstmt.executeUpdate();
            if(ret <=0)
                throw new SQLException("등록 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }

    @Override
    public Blog read(Blog blog) {
        Blog ret = null;
        String sql = "select * from blog where id='" + blog.getId() +"'";
        try{
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }

    @Override
    public List<Blog> readList(){
        List<Blog> blogList = null;
        Blog ret = null;
        String sql = "select * from blog";
        try{
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            blogList = new ArrayList<Blog>();
            while(rs.next()){
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email"));
                blogList.add(ret);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return blogList;
        }
    }

    @Override
    public int update(Blog b){
        int ret = 0;
        String sql = "update blog set title=?, content=?, email=?, author=? where id=?"; // ?: placeholder
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());
            pstmt.setString(3, b.getEmail());
            pstmt.setString(4, b.getAuthor());
            pstmt.setLong(5, b.getId());
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환,
            if(ret <=0)
                throw new SQLException("수정 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }

    @Override
    public int delete(Blog b){

        int ret = 0;
        String sql = "delete from blog where id=?"; // ?: placeholder
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(b.getId()));
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환,
            if(ret <=0)
                throw new SQLException("삭제 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return ret;
        }
    }
}
