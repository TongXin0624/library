package com.tx.library.service.impl;


import com.tx.library.dao.ReadersDao;
import com.tx.library.pojo.Readers;
import com.tx.library.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadersServiceImpl implements ReadersService {

    @Autowired
    private ReadersDao readersDao;


    @Override
    @Transactional
    public void addReader(Readers readers) {
        this.readersDao.insertReaders(readers);
    }

    @Override
    public void addAdmin(Readers readers) {
        this.readersDao.insertAdmin(readers);
    }

    @Override
    public Readers login(String id, String pwd,Integer state) {
        return this.readersDao.login(id, pwd, state);
    }

    @Override
    public List<Readers> findReader() {
        return this.readersDao.findReader();
    }

    @Override
    public void deleteBook(String id) {
        this.readersDao.deleteReader(id);
    }



}
