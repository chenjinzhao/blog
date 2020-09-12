package cn.chenjinzhao.blog.service;

import cn.chenjinzhao.blog.pojo.po.Category;
import cn.chenjinzhao.blog.pojo.po.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * CategoryService
 *
 * @author 陈今朝
 * @date 2020/9/9 16:45
 */
public interface CategoryService extends IService<Category> {
}
