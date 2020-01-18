package com.qzr.mybatis_ot.dao.adminUser;
import com.qzr.mybatis_ot.entity.adminUser.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface UserDao {

    public List<User> getAdminUserList();

    public User getAdminUserById(Long id);

    public int addAdminUser(User user);

    public int updateAdminUser(User user);

    public int deleteUserById(Long id);

    public List<User> selectPage();

    public void addAdminUserAll(List<User> list);

    public void addAdminUserAllSecond(User user);
}
