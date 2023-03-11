package com.baiyangmu.memotask.controller;

import com.baiyangmu.memotask.entity.MemoLink;
import com.baiyangmu.memotask.service.MemoLinkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 备忘录关联表(MemoLink)表控制层
 *
 * @author makejava
 * @since 2023-03-11 15:45:52
 */
@RestController
@RequestMapping("memoLink")
public class MemoLinkController {
    /**
     * 服务对象
     */
    @Resource
    private MemoLinkService memoLinkService;

    /**
     * 分页查询
     *
     * @param memoLink 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<MemoLink>> queryByPage(MemoLink memoLink, PageRequest pageRequest) {
        return ResponseEntity.ok(this.memoLinkService.queryByPage(memoLink, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MemoLink> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.memoLinkService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param memoLink 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<MemoLink> add(MemoLink memoLink) {
        return ResponseEntity.ok(this.memoLinkService.insert(memoLink));
    }

    /**
     * 编辑数据
     *
     * @param memoLink 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<MemoLink> edit(MemoLink memoLink) {
        return ResponseEntity.ok(this.memoLinkService.update(memoLink));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.memoLinkService.deleteById(id));
    }

}

