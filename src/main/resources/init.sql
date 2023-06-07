-- 用户表
CREATE TABLE `t_user`
(
    `user_id`     int                                    NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `user_name`   varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
    `age`         int                                    NOT NULL               DEFAULT (0) COMMENT '年龄',
    `blog_url`    varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '博客地址',
    `blog_remark` varchar(50) COLLATE utf8mb4_general_ci                        DEFAULT NULL COMMENT '博客信息',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户信息表';

INSERT INTO `t_user` (`user_id`, `user_name`, `password`, `age`, `blog_url`, `blog_remark`)
VALUES (1, 'chenzy', 'dd853dffb1395a98e26d4e7062545ee4', 18, 'https://chenzy.com', '您好，欢迎访问 chenzy的博客');

-- 权限表
CREATE TABLE `t_permission`
(
    `id`   int                                                           NOT NULL AUTO_INCREMENT COMMENT '权限主键',
    `url`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路由地址',
    `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='权限表';

INSERT INTO `t_permission` (`id`, `url`, `name`)
VALUES (1, '/user', 'user:user');
INSERT INTO `t_permission` (`id`, `url`, `name`)
VALUES (2, '/user/insertUser', 'user:add');
INSERT INTO `t_permission` (`id`, `url`, `name`)
VALUES (3, '/user/deleteUser', 'user:delete');

-- 角色表
CREATE TABLE `t_role`
(
    `id`   int                                                           NOT NULL AUTO_INCREMENT COMMENT '权限主键',
    `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
    `desc` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色表';

INSERT INTO `t_role` (`id`, `name`, `desc`)
VALUES (1, 'admin', '超级管理员');
INSERT INTO `t_role` (`id`, `name`, `desc`)
VALUES (2, 'test', '测试账户');

-- 角色权限关联表
CREATE TABLE `t_role_permission`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
    `rid` int DEFAULT NULL COMMENT '角色id',
    `pid` int DEFAULT NULL COMMENT '权限id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色权限表';

INSERT INTO `t_role_permission` (`id`, `rid`, `pid`)
VALUES (1, 1, 2);
INSERT INTO `t_role_permission` (`id`, `rid`, `pid`)
VALUES (2, 1, 3);
INSERT INTO `t_role_permission` (`id`, `rid`, `pid`)
VALUES (3, 2, 1);
INSERT INTO `t_role_permission` (`id`, `rid`, `pid`)
VALUES (4, 1, 1);


-- 用户角色关联表
CREATE TABLE `t_user_role`
(
    `id`      int NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
    `user_id` int DEFAULT NULL COMMENT '用户id',
    `rid`     int DEFAULT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色权限表';

INSERT INTO `t_user_role` (`id`, `user_id`, `rid`)
VALUES (1, 1, 1);
INSERT INTO `t_user_role` (`id`, `user_id`, `rid`)
VALUES (2, 2, 2);
