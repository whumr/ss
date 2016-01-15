package com.savior.service.account;

import com.savior.common.BaseService;
import com.savior.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Administrator on 2015/1/29.
 */
@Service("accountService")
public class AccountService extends BaseService {

    @PostConstruct
    protected void init() {
        namespace = "account.";
    }

    /**
     * 验证用户名重复
     * @param mobile
     * @return
     */
    public Account getAccountByMobile(String mobile) {
        List<Account> list = baseSqlSession.selectList(namespace + "getAccountByMobile", mobile);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 验证用户名密码
     * @param account
     * @return
     */
    public Account getAccountByMobilePassword(Account account) {
        List<Account> list = baseSqlSession.selectList(namespace + "getAccountByMobilePassword", account);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 更新用户基本资料
     * @param account
     */
    public void updateAccount(Account account) {
        baseSqlSession.update(namespace + "updateAccount", account);
    }

    /**
     * 更新登录信息
     * @param account
     */
    public void updateLoginInfo(Account account) {
        baseSqlSession.update(namespace + "loginAccount", account);
    }

    /**
     * 获取token
     * @param mobile
     * @return
     */
    public Account checkToken(String mobile) {
        List<Account> list = baseSqlSession.selectList(namespace + "checkToken", mobile);
        return list.isEmpty() ? null : list.get(0);
    }
}
