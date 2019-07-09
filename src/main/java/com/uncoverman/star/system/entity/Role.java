package com.uncoverman.star.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 角色表
* </p>
*
* @author nfl
* @since 2019-06-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 角色ID
    */
    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private Long roleId;

    /**
    * 角色名称
    */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
    * 角色描述
    */
    @TableField("REMARK")
    private String remark;

    /**
    * 创建时间
    */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
    * 修改时间
    */
    @TableField("MODIFY_TIME")
    private Date modifyTime;


}
