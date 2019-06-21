package cn.zkw.mapping;

import cn.zkw.vo.Sort;
import org.omg.CORBA.INTERNAL;

import java.util.List;
import java.util.Map;

public interface ISortDao {
    //查询全部
    List<Sort> findAllSort();

    //添加文章与类型的关系
    Integer addSet_article_sort(Map<String,Integer> map);
}
