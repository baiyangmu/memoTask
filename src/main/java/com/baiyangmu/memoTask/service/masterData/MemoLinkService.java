package com.baiyangmu.memotask.service.masterData;

import com.baiyangmu.memotask.entity.masterData.MemoLink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 备忘录关联表(MemoLink)表服务接口
 *
 * @author makejava
 * @since 2023-03-11 15:45:52
 */
public interface MemoLinkService {

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    MemoLink queryById(Integer linkId);

    /**
     * 分页查询
     *
     * @param memoLink 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MemoLink> queryByPage(MemoLink memoLink, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param memoLink 实例对象
     * @return 实例对象
     */
    MemoLink insert(MemoLink memoLink);

    /**
     * 修改数据
     *
     * @param memoLink 实例对象
     * @return 实例对象
     */
    MemoLink update(MemoLink memoLink);

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer linkId);

}
