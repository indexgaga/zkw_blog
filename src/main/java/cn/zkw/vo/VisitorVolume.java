package cn.zkw.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class VisitorVolume implements Serializable {
    private Date day;
    private Integer volume;

    @Override
    public String toString() {
        return "visitor_volume{" +
                "day=" + day +
                ", volume=" + volume +
                '}';
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
