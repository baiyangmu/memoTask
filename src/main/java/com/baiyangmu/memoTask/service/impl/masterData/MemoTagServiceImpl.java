package com.baiyangmu.memotask.service.impl.masterData;

import com.baiyangmu.memotask.entity.masterData.MemoTag;
import com.baiyangmu.memotask.dao.masterData.MemoTagDao;
import com.baiyangmu.memotask.service.masterData.MemoTagService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (MemoTag)表服务实现类
 *
 * @author makejava
 * @since 2023-03-11 15:46:09
 */
@Service("memoTagService")
public class MemoTagServiceImpl implements MemoTagService {
    @Resource
    private MemoTagDao memoTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    @Override
    public MemoTag queryById(Integer memoId) {
        return this.memoTagDao.queryById(memoId);
    }

    /**
     * 分页查询
     *
     * @param memoTag 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MemoTag> queryByPage(MemoTag memoTag, PageRequest pageRequest) {
        long total = this.memoTagDao.count(memoTag);
        return new PageImpl<>(this.memoTagDao.queryAllByLimit(memoTag, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param memoTag 实例对象
     * @return 实例对象
     */
    @Override
    public MemoTag insert(MemoTag memoTag) {
        this.memoTagDao.insert(memoTag);
        return memoTag;
    }

    /**
     * 修改数据
     *
     * @param memoTag 实例对象
     * @return 实例对象
     */
    @Override
    public MemoTag update(MemoTag memoTag) {
        this.memoTagDao.update(memoTag);
        return this.queryById(memoTag.getMemoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer memoId) {
        return this.memoTagDao.deleteById(memoId) > 0;
    }
}
