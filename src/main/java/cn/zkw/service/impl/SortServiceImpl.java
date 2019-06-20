package cn.zkw.service.impl;

import cn.zkw.mapping.ISortDao;
import cn.zkw.service.SortService;
import cn.zkw.vo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SortServiceImpl implements SortService {
    @Autowired
    public ISortDao dao;

    //查询全部
    @Override
    public List<Sort> findAllSort() {
        return dao.findAllSort();
    }
}
