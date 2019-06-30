package cn.zkw.mapping;

import cn.zkw.vo.VisitorVolume;

import java.util.List;

public interface IVisitorVolumeDao {
    /**
     * 查询全部访问量
     * @return
     */
    List<VisitorVolume> findAllVisitorVolume();
}
