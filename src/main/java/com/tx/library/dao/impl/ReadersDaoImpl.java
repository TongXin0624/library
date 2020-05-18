package com.tx.library.dao.impl;

import com.tx.library.dao.ReadersDao;
import com.tx.library.pojo.Readers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ReadersDaoImpl implements ReadersDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertReaders(Readers readers) {
        String sql = "insert into reader(id,name,pwd,sex,age,phone) values(?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql,readers.getId(),readers.getName(),readers.getPwd(),readers.getSex(),readers.getAge(),readers.getPhone());
    }

    @Override
    public void insertAdmin(Readers readers) {
        String sql = "insert into reader(id,name,pwd,sex,age,phone,state) values(?,?,?,?,?,?,'2')";
        this.jdbcTemplate.update(sql,readers.getId(),readers.getName(),readers.getPwd(),readers.getSex(),readers.getAge(),readers.getPhone());

    }

    @Override
    public Readers login(String id, String pwd, Integer state) {
        String sql = "select * from reader where id=? and pwd=?";
        Readers readers = new Readers();
        Object[] arr = new Object[]{id,pwd};
        this.jdbcTemplate.query(sql,arr, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                readers.setId(resultSet.getString("id"));
                readers.setName(resultSet.getString("name"));
                readers.setPwd(resultSet.getString("pwd"));
                readers.setState(resultSet.getInt("state"));
                System.out.println(readers);
            }
        });
        return readers;
    }

    @Override
    public List<Readers> findReader() {
        String sql = "select * from reader where state !=1 or state is null ";
        return this.jdbcTemplate.query(sql, new RowMapper<Readers>() {
            @Override
            public Readers mapRow(ResultSet resultSet, int i) throws SQLException {
                Readers readers = new Readers();
                readers.setId(resultSet.getString("id"));
                readers.setName(resultSet.getString("name"));
                readers.setPwd(resultSet.getString("pwd"));
                readers.setSex(resultSet.getString("sex"));
                readers.setAge(resultSet.getString("age"));
                readers.setPhone(resultSet.getString("phone"));
                readers.setState(resultSet.getInt("state"));
                return readers;
            }
        });

    }

    @Override
    public void deleteReader(String id) {
        String sql = "delete from reader where id = ?";
        this.jdbcTemplate.update(sql,id);
    }


}
