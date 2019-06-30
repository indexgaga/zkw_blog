package cn.zkw.service;

import cn.zkw.vo.User;
import cn.zkw.vo.VisitorVolume;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitorVolumeService {
    public List<VisitorVolume> findAllVisitorVolume();
}
