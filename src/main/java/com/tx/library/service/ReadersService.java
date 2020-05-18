package com.tx.library.service;

import com.tx.library.pojo.Readers;

import java.util.List;

public interface ReadersService {
    void addReader(Readers readers);
    void addAdmin(Readers readers);
    Readers login(String id, String pwd, Integer state);
    List<Readers> findReader();
    void deleteBook(String id);
}
