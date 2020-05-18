package com.tx.library.service;

import com.tx.library.pojo.Books;
import com.tx.library.pojo.PageBean;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Books> findBook();
    void modifyBookState(String bookid, String name);
    void addBook(Books books);
    List<Books> findBookById(String readerid);
    void returnBook(String bookid);
    void deleteBook(String bookid);


    PageBean<Books> findBookByPage(String currentPage, String rows, Map<String, String[]> condition);
}
