package com.baiyangmu.memotask.controller.masterData;

import com.baiyangmu.memotask.entity.masterData.Memo;
import com.baiyangmu.memotask.service.masterData.MemoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Memo)表控制层
 *
 * @author makejava
 * @since 2023-03-11 15:44:30
 */
@RestController
@RequestMapping("memo")
public class MemoController {
    /**
     * 服务对象
     */
    @Resource
    private MemoService memoService;

    /**
     * 分页查询
     *
     * @param memo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Memo>> queryByPage(Memo memo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.memoService.queryByPage(memo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Memo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.memoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param memo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Memo> add(@RequestBody Memo memo) {
        return ResponseEntity.ok(this.memoService.insert(memo));
    }

    /**
     * 编辑数据
     *
     * @param memo 实体
     * @return 编辑结果
     */
    @PutMapping()
    public ResponseEntity<Memo> edit(@RequestBody Memo memo) {
        return ResponseEntity.ok(this.memoService.update(memo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.memoService.deleteById(id));
    }

}

