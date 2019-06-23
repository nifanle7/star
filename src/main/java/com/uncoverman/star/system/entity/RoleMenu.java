package com.uncoverman.star.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 角色菜单关联表
* </p>
*
* @author nfl
* @since 2019-06-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 角色ID
    */
    @TableField("ROLE_ID")
    private Long roleId;

    /**
    * 菜单/按钮ID
    */
    @TableField("MENU_ID")
    private Long menuId;


}
