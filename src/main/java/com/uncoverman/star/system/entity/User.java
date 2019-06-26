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
* 用户表
* </p>
*
* @author nfl
* @since 2019-06-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // 用户状态：有效
    public static final String STATUS_VALID = "1";
    // 用户状态：锁定
    public static final String STATUS_LOCK = "0";
    // 默认头像
    public static final String DEFAULT_AVATAR = "default.jpg";
    // 默认密码
    public static final String DEFAULT_PASSWORD = "123456";
    // 性别男
    public static final String SEX_MALE = "0";
    // 性别女
    public static final String SEX_FEMALE = "1";
    // 性别保密
    public static final String SEX_UNKNOW = "2";
    // 黑色主题
    public static final String THEME_BLACK = "black";
    // 白色主题
    public static final String THEME_WHITE = "white";
    // TAB开启
    public static final String TAB_OPEN = "1";
    // TAB关闭
    public static final String TAB_CLOSE = "0";

    /**
    * 用户ID
    */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;

    /**
    * 用户名
    */
    @TableField("USERNAME")
    private String username;

    /**
    * 密码
    */
    @TableField("PASSWORD")
    private String password;

    /**
    * 公司
    */
    @TableField("COMPANY")
    private String company;

    /**
    * 部门ID
    */
    @TableField("DEPT_ID")
    private Long deptId;

    /**
    * 邮箱
    */
    @TableField("EMAIL")
    private String email;

    /**
    * 联系电话
    */
    @TableField("MOBILE")
    private String mobile;

    /**
    * 状态 0锁定 1有效
    */
    @TableField("STATUS")
    private String status;

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

    /**
    * 最近访问时间
    */
    @TableField("LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
    * 性别 0男 1女 2保密
    */
    @TableField("SSEX")
    private String ssex;

    /**
    * 是否开启tab，0关闭 1开启
    */
    @TableField("IS_TAB")
    private String isTab;

    /**
    * 主题
    */
    @TableField("THEME")
    private String theme;

    /**
    * 头像
    */
    @TableField("AVATAR")
    private String avatar;

    /**
    * 描述
    */
    @TableField("DESCRIPTION")
    private String description;


}
