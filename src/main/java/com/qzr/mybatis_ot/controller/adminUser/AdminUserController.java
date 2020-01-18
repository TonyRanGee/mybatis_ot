package com.qzr.mybatis_ot.controller.adminUser;
import com.qzr.mybatis_ot.common.page.PageRequest;
import com.qzr.mybatis_ot.entity.adminUser.User;
import com.qzr.mybatis_ot.service.adminUser.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("user")
public class AdminUserController {
    @InitBinder("user")
    public void initBinder2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AdminUserController.class);

    @Resource
    UserService userService;

    @Resource
    MongoTemplate mongoTemplate;


    @RequestMapping("/get/user/list")
    public Map<String,Object> adminUserList(){
        Map map = new ConcurrentHashMap();
        try {
            List<User> list = userService.getAdminUserList();
            if(list.size()>0){
                map.put("list",list);
            }
        }catch (Exception e){
           log.error("AdminUserController.adminUserList",e);
        }
        return map;
    }

    @GetMapping("/get/user/by/id/{id}")
    public Map<String,Object> adminUserById(@PathVariable(value = "id") Long id){
        Map map = new ConcurrentHashMap();
        try {
            User user = userService.getAdminUserById(id);
            mongoTemplate.save(user,"user");
            if(user!=null){
                map.put("user",user);
            }
        }catch (Exception e){
            log.error("AdminUserController.adminUserList",e);
        }
        return map;
    }

    @RequestMapping("/add/user")
    public Map<String,Object> addAdminUser(@ModelAttribute("user") User user){
        Map map = new ConcurrentHashMap();

        try {
            boolean isSuccess = true;
            if(user.getId()==null){
                int i =userService.addAdminUser(user);
                if(i>0){
                    map.put("status",isSuccess);
                }else {
                    isSuccess=false;
                    map.put("status",isSuccess);
                }
            }else {
                int i =userService.updateAdminUser(user);
                if(i>0){
                    map.put("status",isSuccess);
                }else {
                    isSuccess=false;
                    map.put("status",isSuccess);
                }
            }

        }catch (Exception e){
            log.error("AdminUserController.addAdminUser",e);
        }
        return map;
    }

    @RequestMapping("/delete/user/by/id/{id}")
    public Map<String,Object> deleteUserById(@PathVariable("id")Long id){
        Map map = new ConcurrentHashMap();
        try {
            int i = userService.deleteUserById(id);
            mongoTemplate.remove(i);
            if(i>0){
                map.put("data",i);
            }
        }catch (Exception e){
            log.error("AdminUserController.deleteUserById",e);
        }
        return map;
    }

    /**
     * 分页
     * @param pageRequest
     * @return
     */
    @GetMapping("/findPage")
    public Object getAdminUserListPage(PageRequest pageRequest){
        return userService.getAdminUserInfo(pageRequest);
    }

    /**
     * 数据的批量更新
     */
    @RequestMapping("/add/userAll")
    public Map<String,Object> addAdminUserAll(@ModelAttribute("user") User user){
        Map map = new ConcurrentHashMap();
        List<User> list= new ArrayList<>();
        try {
            user.setName("徐庶");
            user.setAddress("蜀国");
            user.setAge(60);
            user.setContent("忠孝两全！！！");
            User user1 = new User();
            user1.setName("诸葛亮");
            user1.setAddress("蜀国");
            user1.setAge(64);
            user1.setContent("运筹帷幄");
            list.add(user);
            list.add(user1);
            userService.addAdminUserAll(list);
        }catch (Exception e){
            log.error("AdminUserController.addAdminUserAll",e);
        }
        return map;
    }
}
