package com.qzr.mybatis_ot.service.adminUser;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qzr.mybatis_ot.common.page.PageRequest;
import com.qzr.mybatis_ot.dao.adminUser.UserDao;
import com.qzr.mybatis_ot.entity.adminUser.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    public List<User>getAdminUserList(){
        return userDao.getAdminUserList();
    }

    public User getAdminUserById(Long id) {
        return userDao.getAdminUserById(id);
    }

    public int addAdminUser(User user) {
        return userDao.addAdminUser(user);
    }

    public int updateAdminUser(User user) {
        return userDao.updateAdminUser(user);
    }

    public int deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    public PageInfo<User> getAdminUserInfo( PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<User> pageList = userDao.selectPage();
        return new PageInfo<User>(pageList);

    }

    public void addAdminUserAll(List<User> list) {
      userDao.addAdminUserAll(list);
    }
}
