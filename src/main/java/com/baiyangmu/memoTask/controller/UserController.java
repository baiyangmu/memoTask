package com.baiyangmu.memotask.controller;

import com.baiyangmu.memotask.condition.UserQueryCondition;
import com.baiyangmu.memotask.entity.User;
import com.baiyangmu.memotask.service.UserService;
import com.baiyangmu.memotask.vo.Response;
import com.baiyangmu.memotask.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2023-03-11 15:46:52
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }


    /**
     * 注册用户
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/registeredUser")
    public ResponseEntity<Response<UserVo>> registeredUser(@RequestBody UserVo user) {
        return ResponseEntity.ok(this.userService.registeredUser(user));
    }


    /**
     * 登录
     */
    @PostMapping("login")
    public ResponseEntity<Response<String>> login(@RequestBody UserQueryCondition condition){

        return ResponseEntity.ok(this.userService.login(condition));
    }


    /**
     * 登出
     */
    @GetMapping("logout")
    public ResponseEntity<Response<String>> logout(){

        return ResponseEntity.ok(this.userService.logout());
    }



    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

