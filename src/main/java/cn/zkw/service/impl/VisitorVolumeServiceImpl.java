package cn.zkw.service.impl;

import cn.zkw.mapping.IVisitorVolumeDao;
import cn.zkw.service.VisitorVolumeService;
import cn.zkw.vo.VisitorVolume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisitorVolumeServiceImpl implements VisitorVolumeService {
    @Autowired
    IVisitorVolumeDao visitorVolumeDao;

    @Override
    public List<VisitorVolume> findAllVisitorVolume() {
        return visitorVolumeDao.findAllVisitorVolume();
    }
}
