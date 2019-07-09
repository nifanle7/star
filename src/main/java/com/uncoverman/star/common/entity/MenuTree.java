package com.uncoverman.star.common.entity;

import com.uncoverman.star.system.entity.Menu;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author nfl
 */
@Data
public class MenuTree<T> implements Serializable {

    private String id;
    private String icon;
    private String href;
    private String title;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<MenuTree<T>> childs = new ArrayList<>();
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private Menu data;

}