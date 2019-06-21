package cn.zkw.service;

import cn.zkw.vo.Sort;
import cn.zkw.vo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SortService {
    public List<Sort> findAllSort();

    public Integer addSet_article_sort(Map<String,Integer> map);
}
