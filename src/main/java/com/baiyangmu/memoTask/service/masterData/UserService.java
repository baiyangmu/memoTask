package com.baiyangmu.memotask.service.masterData;

import com.baiyangmu.memotask.condition.UserQueryCondition;
import com.baiyangmu.memotask.entity.masterData.User;
import com.baiyangmu.memotask.vo.Response;
import com.baiyangmu.memotask.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-03-11 15:46:52
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    Response<UserVo> registeredUser(UserVo user);

    Response<String> login(UserQueryCondition condition);

    UserVo findByEmail(String email);

    Response<String> logout();
}
