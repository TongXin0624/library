package com.tx.library.dao;

import com.tx.library.pojo.Readers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReadersDao {
    void insertReaders(Readers readers);
    void insertAdmin(Readers readers);

    public Readers login(@Param("id") String id, @Param("pwd") String pwd, @Param("state") Integer state);
    List<Readers> findReader();
    void deleteReader(String id);
}
