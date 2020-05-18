package com.tx.library.service.impl;

import com.tx.library.dao.BookDao;
import com.tx.library.pojo.Books;
import com.tx.library.pojo.PageBean;
import com.tx.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    /**
     * 查询出所有图书
     * @return
     */
    @Override
    public List<Books> findBook() {
        return this.bookDao.selectBook();
    }


    /**
     * 用户借阅图书
     * @param bookid
     * @param name
     */
    @Override
    @Transactional
    public void modifyBookState(String bookid, String name) {
        this.bookDao.updateBookState(bookid,name);
    }


    /**
     * 管理员新增图书
     * @param books
     */
    @Override
    @Transactional
    public void addBook(Books books) {
        this.bookDao.insertBooks(books);
    }


    /**
     * 用户查询已经借阅的图书
     * @param readerid
     * @return
     */
    @Override
    public List<Books> findBookById(String readerid) {
        return this.bookDao.findBookById(readerid);
    }


    /**
     * 用户归还图书
     * @param bookid
     */
    @Override
    public void returnBook(String bookid) {
        this.bookDao.returnBook(bookid);
    }


    /**
     * 管理员删除图书
     * @param bookid
     */
    @Override
    @Transactional
    public void deleteBook(String bookid) {
        this.bookDao.deleteBook(bookid);
    }


    @Override
    public PageBean<Books> findBookByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <=0){
            currentPage = 1;
        }



        PageBean<Books> pb = new PageBean<Books>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = this.bookDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<Books> list = this.bookDao.findByPage(start,rows,condition);
        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);



        return pb;
    }
}
