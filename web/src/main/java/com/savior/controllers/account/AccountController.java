package com.savior.controllers.account;

import com.alibaba.fastjson.JSONObject;
import com.savior.common.BaseController;
import com.savior.common.Constants;
import com.savior.entity.Account;
import com.savior.service.account.AccountService;
import com.savior.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2015/1/29.
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController extends BaseController {


    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String error = null;
        if (chekValuesEmpty(new String[]{mobile, password}))
            error = Constants.ErrorMsg.Common.IllegalArgument;
        else {
            Account param = new com.savior.entity.Account();
            param.setMobile(mobile);
            param.setPassword(password);
            Account account = accountService.getAccountByMobilePassword(param);
            if (account == null)
                error = Constants.ErrorMsg.Account.LoginFail;
            else {
                JSONObject json = successJson();
                json.put("account", account);
                renderJson(response, json);
            }
        }
        if (error != null)
            fail(response, error);
    }

    @RequestMapping("/reg")
    public void reg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String error = null;
        if (chekValuesEmpty(new String[]{mobile, password}) || !Validator.isMobile(mobile) || !Validator.isPassword(password))
            error = Constants.ErrorMsg.Common.IllegalArgument;
        else {
            Account account = new Account();
            account.setMobile(mobile);
            Account check_member = accountService.getAccountByMobile(mobile);
            if (check_member != null)
                error = Constants.ErrorMsg.Account.AccountExists;
            else {
                account.setPassword(password);
                String nick_name = mobile.substring(0, 3) + "****" + mobile.substring(7);
                account.setNick_name(nick_name);
                Date now = new Date();
                account.setCreate_date(now);
                accountService.insert(account);
                account.setPassword(null);
                request.getSession().setAttribute(Constants.Keys.Session.KeyAccount, account);
                JSONObject json = successJson();
                json.put("account", account);
                renderJson(response, json);
            }
        }
        if (error != null)
            fail(response, error);
    }

    @RequestMapping("/checkMobile")
    public void checkMobile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String mobile = request.getParameter("mobile");
        if (chekValuesEmpty(new String[]{mobile}))
            fail(response, Constants.ErrorMsg.Common.IllegalArgument);
        else {
            JSONObject result = successJson();
            Account account = accountService.getAccountByMobile(mobile);
            result.put("exists", account == null ? 0 : 1);
            renderJson(response, result);
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(Constants.Keys.Session.KeyAccount, null);
        succeed(response);
    }

    @RequestMapping("/update")
    public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nick_name = request.getParameter("nick_name");
        if (chekValuesEmpty(new String[]{nick_name}))
            fail(response, Constants.ErrorMsg.Common.IllegalArgument);
        else {
            Account account = new Account();
            account.setId(getAccount(request).getId());
            account.setNick_name(nick_name);
            accountService.updateAccount(account);
            succeed(response);
        }
    }
}
