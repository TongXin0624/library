package com.tx.library.controller;

import com.tx.library.pojo.Books;
import com.tx.library.pojo.PageBean;
import com.tx.library.service.BookService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 鼠阿鑫
 * @date 2020/5/16
 */


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    /**
     * 查询图书
     * @param model
     * @return
     */
    @RequestMapping("/findBook")
    public String findBook(Model model,HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "8";
        }

        Map<String,String[]> condition = request.getParameterMap();

        PageBean<Books> pb = this.bookService.findBookByPage(currentPage,rows,condition);
        model.addAttribute("pb", pb);
        model.addAttribute("condition",condition);


        try {
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "showbook";
    }


    /**
     * 获取cookie
     * @param name
     * @param request
     * @return
     */
    public String findCookie(String name, HttpServletRequest request) {
        Cookie allcookies[] = request.getCookies();
        for (int i = 0; i < allcookies.length; i++) {
            if (allcookies[i].getName().equals("readerid")) {
                name = allcookies[i].getValue();
            }
        }
        return name;
    }

    /**
     * 借阅图书
     *
     * @param bookid
     * @param request
     * @return
     */
    @GetMapping("/loginIn/updateBookState")
    public String updateBookState(String name, String bookid, HttpServletRequest request) {
        try {
            name = this.findCookie(name, request);
            this.bookService.modifyBookState(bookid, name);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/ok";
    }

    /**
     * 归还图书
     *
     * @param bookid
     * @return
     */
    @GetMapping("returnbook")
    public String returnBook(String bookid) {
        try {
            this.bookService.returnBook(bookid);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/okReturn";
    }

    /**
     * 管理员新增图书
     *
     * @param books
     * @return
     */
    @PostMapping("/addBook")
    public String addBook(Books books) {
        try {
            this.bookService.addBook(books);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "admin";
    }

    /**
     * 管理员查找图书列表
     *
     * @param model2
     * @return
     */
    @GetMapping("/findBook2")
    public String deleteBook(Model model2) {
        List<Books> list2 = null;
        try {
            list2 = this.bookService.findBook();
            model2.addAttribute("list2", list2);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "deleteBook";
    }

    /**
     * 读者查询已借阅图书
     *
     * @param model3
     * @param request
     * @return
     */
    @GetMapping("/findBookById00")
    public String findBookById(String name, Model model3, HttpServletRequest request) {
        List<Books> list3 = null;
        try {
            name = this.findCookie(name, request);
            list3 = this.bookService.findBookById(name);
            model3.addAttribute("list3", list3);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "findBookById";
    }

    /**
     * 查询借阅信息
     *
     * @param model3
     * @param request
     * @return
     */
    @GetMapping("/findBookById01")
    public String findBookById01(String name, Model model3, HttpServletRequest request) {
        List<Books> list3 = null;
        try {
            name = this.findCookie(name, request);
            list3 = this.bookService.findBookById(name);
            model3.addAttribute("list3", list3);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "findBookById01";
    }

    /**
     * 管理员删除图书
     *
     * @param bookid
     * @return
     */
    @GetMapping("/deleteBook00")
    public String deleteBook(String bookid) {
        try {
            this.bookService.deleteBook(bookid);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "okdelete";
    }



}
