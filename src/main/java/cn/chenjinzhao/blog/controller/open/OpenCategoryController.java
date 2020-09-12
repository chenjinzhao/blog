package cn.chenjinzhao.blog.controller.open;

import cn.chenjinzhao.blog.common.api.CommonResult;
import cn.chenjinzhao.blog.common.utils.CommonResultUtil;
import cn.chenjinzhao.blog.pojo.po.Category;
import cn.chenjinzhao.blog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author 陈今朝
 * @date 2020/9/9 16:27
 */
@RestController
@Slf4j
@Api(tags = "OpenCategoryController")
@RequestMapping("/category")
public class OpenCategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiOperation("获取所有分类")
    @GetMapping
    public CommonResult listCategory(){
        List<Category> list = categoryService.list();
        return CommonResultUtil.success(list);
    }

}
