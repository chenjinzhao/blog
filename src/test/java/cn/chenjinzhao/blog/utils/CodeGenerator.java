package cn.chenjinzhao.blog.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CodeGenerator {

    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("chenjinzhao");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setIdType(IdType.INPUT); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.chenjinzhao");
        pc.setModuleName("blog"); //模块名
        pc.setController("controller");
        pc.setEntity("pojo.po");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("article",
                "article_tag",
                "category",
                "comment",
                "permission",
                "role",
                "role_permission",
                "tag",
                "user",
                "user_role");
        sc.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        sc.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀

        sc.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        sc.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        sc.setRestControllerStyle(true); //restful api风格控制器
        sc.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        // sc.setLogicDeleteFieldName("is_deleted");//逻辑删除字段 , 没有可不写

        // 自动填充配置
        // TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        // TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        // sc.setTableFillList(Arrays.asList(gmtCreate, gmtModified));

        mpg.setStrategy(sc);


        // 6、执行
        mpg.execute();
    }
}