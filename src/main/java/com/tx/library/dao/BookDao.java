package com.tx.library.dao;

import com.tx.library.pojo.Books;

import java.util.List;
import java.util.Map;

public interface BookDao {
    List<Books> selectBook();
    void updateBookState(String bookid, String name);
    void insertBooks(Books books);
    List<Books> findBookById(String readerid);
    void returnBook(String bookid);
    void deleteBook(String bookid);


    int findTotalCount(Map<String, String[]> condition);

    List<Books> findByPage(int start, int rows, Map<String, String[]> condition);
}
