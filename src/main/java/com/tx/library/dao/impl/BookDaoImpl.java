package com.tx.library.dao.impl;

import com.tx.library.dao.BookDao;
import com.tx.library.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Books> selectBook() {

        String sql = "select * from book";
        return this.jdbcTemplate.query(sql, new RowMapper<Books>() {
            @Override
            public Books mapRow(ResultSet resultSet, int i) throws SQLException {
                Books books = new Books();
                books.setBookid(resultSet.getString("bookid"));
                books.setBookname(resultSet.getString("bookname"));
                books.setPublisher(resultSet.getString("publisher"));
                books.setPrice(resultSet.getString("price"));
                books.setKind(resultSet.getString("kind"));
                books.setBookstate(resultSet.getInt("bookstate"));
                books.setReaderid(resultSet.getString("readerid"));
                books.setBorrowtime(resultSet.getString("borrowtime"));
                //System.out.println(books);
                return books;
            }
        });


    }

    @Override
    public void updateBookState(String bookid,String name) {
        String sql1 = "update book set bookstate = 0,readerid = ?,borrowtime = ? where bookid = ?";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= new Date();
        System.out.println(formatter.format(date));
        this.jdbcTemplate.update(sql1,name,formatter.format(date) ,bookid);
        //System.out.println(readers.getName());
        System.out.println(name);
        System.out.println(bookid);

    }

    @Override
    public void insertBooks(Books books) {
        String sql = "insert into book(bookid,bookname,publisher,price,kind,bookstate) values(?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql,books.getBookid(),books.getBookname(),books.getPublisher(),books.getPrice(),books.getKind(),books.getBookstate());
    }

    @Override
    public List<Books> findBookById(String readerid) {
        String sql = "select * from book where readerid = ?";
        Books books = new Books();
        Object[] arr = new Object[]{readerid};
        return this.jdbcTemplate.query(sql,arr, new RowMapper<Books>() {
            @Override
            public Books mapRow(ResultSet resultSet, int i) throws SQLException {
                Books books = new Books();
                books.setBookid(resultSet.getString("bookid"));
                books.setBookname(resultSet.getString("bookname"));
                books.setPublisher(resultSet.getString("publisher"));
                books.setBorrowtime(resultSet.getString("borrowtime"));
                books.setKind(resultSet.getString("kind"));
                books.setPrice(resultSet.getString("price"));

                //System.out.println(books);
                return books;
            }
        });
    }

    @Override
    public void returnBook(String bookid) {
        String sql = "update book set bookstate = 1,readerid = null,borrowtime = null ,returntime = ? where bookid = ?";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= new Date();
        this.jdbcTemplate.update(sql,formatter.format(date) ,bookid);

    }

    @Override
    public void deleteBook(String bookid) {
        String sql = "delete from book where bookid = ?";
        this.jdbcTemplate.update(sql,bookid);
    }



    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from book where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet){
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        return jdbcTemplate.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Books> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from book where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet){
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);

        return jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper<Books>(Books.class),params.toArray());
    }
}
