package com.baiyangmu.memotask.service;

import com.baiyangmu.memotask.entity.MemoTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (MemoTag)表服务接口
 *
 * @author makejava
 * @since 2023-03-11 15:46:09
 */
public interface MemoTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    MemoTag queryById(Integer memoId);

    /**
     * 分页查询
     *
     * @param memoTag 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MemoTag> queryByPage(MemoTag memoTag, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param memoTag 实例对象
     * @return 实例对象
     */
    MemoTag insert(MemoTag memoTag);

    /**
     * 修改数据
     *
     * @param memoTag 实例对象
     * @return 实例对象
     */
    MemoTag update(MemoTag memoTag);

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer memoId);

}
