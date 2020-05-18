package com.tx.library.controller;


import com.tx.library.pojo.Readers;
import com.tx.library.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/reader")
public class ReadersController {
    @Autowired
    private ReadersService readersService;

    /**
     * 读者用户注册
     * @param readers
     * @return
     */
    @PostMapping("/addReader")
    public String addReader(Readers readers) {
        try {
            this.readersService.addReader(readers);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorAdd";
        }
        return "redirect:/loginIn";
    }

    /**
     * 添加子管理员
     * @param readers
     * @return
     */
    @PostMapping("/addAdmin")
    public String addAdmin(Readers readers) {
        try {
            this.readersService.addAdmin(readers);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorAdd";
        }
        return "admin2";
    }

    /**
     * 登录
     *
     * @param id
     * @param pwd
     * @param state
     * @param model
     * @param response
     * @return
     */
    @PostMapping("/login")
    public String login(String id, String pwd, Integer state, Model model, HttpServletResponse response) {
        try {
            Readers readers = this.readersService.login(id, pwd, state);
            Cookie c = new Cookie("readerid", readers.getId());
            c.setPath("/");
            response.addCookie(c);
            model.addAttribute("readers", readers);
            if (readers.getId() == null) {
                return "errorLogin";
            } else if (readers.getState() == 1) {
                return "admin";
            } else if (readers.getState() == 2) {
                return "admin2";
            } else {
                return "okLogin";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 管理员查询出所有用户信息
     * @param model
     * @return
     */
    @GetMapping("/findReader")
    public String findReader00(Model model) {
        List<Readers> list4 = null;
        try {
            list4 = this.readersService.findReader();
            model.addAttribute("list4", list4);
        } catch (Exception e) {
            e.printStackTrace();
            return "erroe";
        }
        return "deleteReader";
    }

    /**
     * 管理员删除用户
     * @param id
     * @return
     */
    @GetMapping("/deleteReader")
    public String deleteReader(String id) {
        try {
            this.readersService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "okDeleteReader";
    }

}
