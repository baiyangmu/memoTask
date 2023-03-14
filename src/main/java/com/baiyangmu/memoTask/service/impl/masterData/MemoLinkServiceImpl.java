package com.baiyangmu.memotask.service.impl.masterData;

import com.baiyangmu.memotask.entity.masterData.MemoLink;
import com.baiyangmu.memotask.dao.masterData.MemoLinkDao;
import com.baiyangmu.memotask.service.masterData.MemoLinkService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 备忘录关联表(MemoLink)表服务实现类
 *
 * @author makejava
 * @since 2023-03-11 15:45:52
 */
@Service("memoLinkService")
public class MemoLinkServiceImpl implements MemoLinkService {
    @Resource
    private MemoLinkDao memoLinkDao;

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    @Override
    public MemoLink queryById(Integer linkId) {
        return this.memoLinkDao.queryById(linkId);
    }

    /**
     * 分页查询
     *
     * @param memoLink 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MemoLink> queryByPage(MemoLink memoLink, PageRequest pageRequest) {
        long total = this.memoLinkDao.count(memoLink);
        return new PageImpl<>(this.memoLinkDao.queryAllByLimit(memoLink, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param memoLink 实例对象
     * @return 实例对象
     */
    @Override
    public MemoLink insert(MemoLink memoLink) {
        this.memoLinkDao.insert(memoLink);
        return memoLink;
    }

    /**
     * 修改数据
     *
     * @param memoLink 实例对象
     * @return 实例对象
     */
    @Override
    public MemoLink update(MemoLink memoLink) {
        this.memoLinkDao.update(memoLink);
        return this.queryById(memoLink.getLinkId());
    }

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer linkId) {
        return this.memoLinkDao.deleteById(linkId) > 0;
    }
}
