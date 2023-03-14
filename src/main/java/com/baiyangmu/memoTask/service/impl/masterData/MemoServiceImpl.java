package com.baiyangmu.memotask.service.impl.masterData;

import com.baiyangmu.memotask.dao.masterData.MemoDao;
import com.baiyangmu.memotask.entity.masterData.Memo;
import com.baiyangmu.memotask.entity.masterData.User;
import com.baiyangmu.memotask.service.masterData.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * (Memo)表服务实现类
 *
 * @author makejava
 * @since 2023-03-11 15:44:34
 */
@Service("memoService")
public class MemoServiceImpl implements MemoService {
    @Resource
    private MemoDao memoDao;
    @Autowired
    private HttpServletRequest request;

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    @Override
    public Memo queryById(Integer memoId) {
        return this.memoDao.queryById(memoId);
    }

    /**
     * 分页查询
     *
     * @param memo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Memo> queryByPage(Memo memo, PageRequest pageRequest) {
        long total = this.memoDao.count(memo);
        return new PageImpl<>(this.memoDao.queryAllByLimit(memo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    @Override
    public Memo insert(Memo memo) {

        User user = (User) request.getAttribute("user");

        memo.setCreatedBy(user.getUserId());
        memo.setLastUpdateBy(user.getUserId());
        memo.setCreationDate(new Date(System.currentTimeMillis()));
        memo.setLastUpdateDate(new Date(System.currentTimeMillis()));
        this.memoDao.insert(memo);
        return memo;
    }

    /**
     * 修改数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    @Override
    public Memo update(Memo memo) {

        User user = (User) request.getAttribute("user");

        memo.setLastUpdateBy(user.getUserId());
        memo.setLastUpdateDate(new Date(System.currentTimeMillis()));
        this.memoDao.update(memo);
        return this.queryById(memo.getMemoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer memoId) {
        return this.memoDao.deleteById(memoId) > 0;
    }
}
