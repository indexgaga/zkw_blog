package cn.zkw.service;

import cn.zkw.vo.Sort;
import cn.zkw.vo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortService {
    public List<Sort> findAllSort();
}
