package com.baiyangmu.memotask.service;

import com.baiyangmu.memotask.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Memo)表服务接口
 *
 * @author makejava
 * @since 2023-03-11 15:44:33
 */
public interface MemoService {

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    Memo queryById(Integer memoId);

    /**
     * 分页查询
     *
     * @param memo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Memo> queryByPage(Memo memo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    Memo insert(Memo memo);

    /**
     * 修改数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    Memo update(Memo memo);

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer memoId);

}
