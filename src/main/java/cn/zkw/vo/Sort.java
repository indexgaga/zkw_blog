package cn.zkw.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Sort implements Serializable {
    private Integer sort_id;
    private String sort_name;
    private String sort_alias;
    private String sort_description;
    private String parent_sort_id;

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public String getSort_alias() {
        return sort_alias;
    }

    public void setSort_alias(String sort_alias) {
        this.sort_alias = sort_alias;
    }

    public String getSort_description() {
        return sort_description;
    }

    public void setSort_description(String sort_description) {
        this.sort_description = sort_description;
    }

    public String getParent_sort_id() {
        return parent_sort_id;
    }

    public void setParent_sort_id(String parent_sort_id) {
        this.parent_sort_id = parent_sort_id;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sort_id=" + sort_id +
                ", sort_name='" + sort_name + '\'' +
                ", sort_alias='" + sort_alias + '\'' +
                ", sort_description='" + sort_description + '\'' +
                ", parent_sort_id='" + parent_sort_id + '\'' +
                '}';
    }
}
