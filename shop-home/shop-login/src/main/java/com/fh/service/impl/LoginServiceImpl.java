package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.bean.Login;
import com.fh.dao.LoginDao;
import com.fh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Login isRegister(String phone) {

        //判断手机号是否存在
        QueryWrapper<Login> queryWrapper = new QueryWrapper<Login>();
        queryWrapper.eq("phone", phone);
        Login login = loginDao.selectOne(queryWrapper);
        if (login == null) {
            login = new Login();
            login.setModifiedTime(new Date());
            login.setUserStatus(1);
            login.setPhone(phone);
            login.setCartId(UUID.randomUUID().toString().replace("-",""));
            loginDao.insert(login);
        } else {
            login.setModifiedTime(new Date());
            loginDao.updateById(login);

        }
        return login;
    }
}

