package cn.chenjinzhao.blog.service.impl;

import cn.chenjinzhao.blog.mapper.CategoryMapper;
import cn.chenjinzhao.blog.mapper.PermissionMapper;
import cn.chenjinzhao.blog.pojo.po.Category;
import cn.chenjinzhao.blog.pojo.po.Permission;
import cn.chenjinzhao.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * CategoryServiceImpl
 *
 * @author 陈今朝
 * @date 2020/9/9 16:45
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    @Cacheable(value="category",key="'categoryList'")
    public List<Category> list() {
        return super.list();
    }

    @Override
    @Cacheable(value="category",key="'categoryId:'+#id")
    public Category getById(Serializable id){
        return  super.getById(id);
    }
}
