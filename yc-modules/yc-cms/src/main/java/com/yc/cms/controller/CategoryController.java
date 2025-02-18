package com.yc.cms.controller;

import com.yc.cms.service.CategoryService;
import com.yc.common.core.base.dto.cms.CategoryAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.cms.CategoryChangeStatusReqDTO;
import com.yc.common.core.base.dto.cms.CategoryPageReqDTO;
import com.yc.common.core.base.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:13
 */
@RestController
@Slf4j
@Api(tags = {"内容管理-分类管理"}, description = "内容管理-分类管理")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取分类列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/category/queryPageList")
    @ApiOperation("获取分类列表")
    public ResultBody queryPageList(@RequestBody CategoryPageReqDTO reqDTO) {
        log.info("/category/queryPageList:" + reqDTO);
        return ResultBody.success(categoryService.queryCategoryPageList(reqDTO));
    }


    /**
     * 新增或修改分类
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/category/saveOrUpdate")
    @ApiOperation("新增或修改分类")
    public ResultBody saveOrUpdate(@RequestBody CategoryAddOrUpdateReqDTO reqDTO) {
        log.info("/category/saveOrUpdate:" + reqDTO);
        return ResultBody.success(categoryService.saveOrUpdateCategory(reqDTO));
    }


    /**
     * 分类状态修改(禁用/删除)
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/category/changeCategoryStatus")
    @ApiOperation("分类状态修改(禁用/删除)")
    public ResultBody changeCategoryStatus(@RequestBody CategoryChangeStatusReqDTO reqDTO) {
        log.info("/category/changeCategoryStatus:" + reqDTO);
        return ResultBody.success(categoryService.changeCategoryStatus(reqDTO));
    }
}
