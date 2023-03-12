package com.baiyangmu.memotask.service.impl;

import com.baiyangmu.memotask.condition.UserQueryCondition;
import com.baiyangmu.memotask.entity.User;
import com.baiyangmu.memotask.dao.UserDao;
import com.baiyangmu.memotask.mapper.UserConvert;
import com.baiyangmu.memotask.service.UserService;
import com.baiyangmu.memotask.util.JwtTokenUtil;
import com.baiyangmu.memotask.util.RedisUtil;
import com.baiyangmu.memotask.util.passwordUtil;
import com.baiyangmu.memotask.vo.Response;
import com.baiyangmu.memotask.vo.UserVo;
import com.fasterxml.jackson.databind.util.BeanUtil;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-03-11 15:46:52
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisUtil redisUtil;

    // 从配置文件中获取过期时间
    @Value("${jwt.expiration}")
    private Long expirationTime;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userDao.deleteById(userId) > 0;
    }



    @Override
    public Response<UserVo> registeredUser(UserVo userVo) {

        User existUser = userDao.findByEmail(userVo.getEmail());

        if(existUser != null ){
           return Response.build(null, 400000 , "该用户已存在");
        }

        User user = UserConvert.USER_VO_INSTANCE.toUser(userVo);

        SecureRandom random = new SecureRandom();
        byte[] hexSalt = new byte[16];
        random.nextBytes(hexSalt);

        String salt = passwordUtil.bytesToHex(hexSalt);
        user.setSalt(salt);
        String mdPassword = passwordUtil.md5(user.getPassword() + salt);
        user.setPassword(mdPassword);

        int insert = userDao.insert(user);

        if(insert != 1){
            return Response.buildFailed(400000 , "注册用户失败");
        }

        return Response.build(userVo);
    }

    @Override
    public Response<String> login(UserQueryCondition condition) {

        String token = null;


        User existUser = userDao.findByEmail(condition.getEmail());

        if (existUser == null) {
            return Response.buildFailed(400000, "用户不存在");
        }
        String password = passwordUtil.md5(condition.getPassword() + existUser.getSalt());

        if (!password.equals(existUser.getPassword())) {
            return Response.buildFailed(400000, "密码不正确");
        }

        try{

            token = (String) redisUtil.get(condition.getEmail());
            if(token != null){
                return  Response.build(token);
            }

            token = jwtTokenUtil.generateToken(existUser.getEmail());
            redisUtil.set(existUser.getEmail(), token, expirationTime);
        }catch (Exception e){
            log.error("user set token error , user {}  token {}  ", existUser, token);
        }

        return Response.build(token);
    }

    @Override
    public UserVo findByEmail(String email) {
        User user = userDao.findByEmail(email);
        if(user != null){
            return UserConvert.USER_VO_INSTANCE.toUserDTO(user);
        }
        return null;
    }


}
