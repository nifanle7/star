package com.uncoverman.star.common.entity;

import com.uncoverman.star.system.entity.Dept;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nfl
 */
@Data
public class DeptTree<T> implements Serializable {

    private static final long serialVersionUID = 7681873362531265829L;

    private String id;
    //private String icon;
    //private String href;
    private String title;
    //private Map<String, Object> state;
    //private boolean checked = false;
    //private Map<String, Object> attributes;
    private List<DeptTree<T>> children;
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private Dept data;

    public void initChildren(){
        this.children = new ArrayList<>();
    }

}
