package com.baiyangmu.memotask.service.impl;

import com.baiyangmu.memotask.entity.Memo;
import com.baiyangmu.memotask.dao.MemoDao;
import com.baiyangmu.memotask.service.MemoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

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
