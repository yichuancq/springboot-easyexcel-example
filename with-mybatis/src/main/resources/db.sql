# # SELECT * FROM test_db.user_info a order by a.create_time desc;
#
# CREATE TABLE `sys_role` (
#   `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
#   `create_time` datetime NOT NULL,
#   `update_time` datetime NOT NULL,
#   `version` bigint(20) DEFAULT NULL,
#   `role_name` varchar(255) DEFAULT NULL,
#   `memo` varchar(255) DEFAULT NULL,
#   `role_status` varchar(255) NOT NULL,
#   PRIMARY KEY (`role_id`)
# ) ENGINE=MyISAM AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8
#
# CREATE TABLE `sys_user_role` (
#   `id` bigint(20) NOT NULL AUTO_INCREMENT,
#   `user_id` bigint NOT NULL,
#   `role_id` bigint NOT NULL,
#   `create_time` datetime NOT NULL,
#   `update_time` datetime NOT NULL,
#   `version` bigint(20) DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=MyISAM AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8
#
#
# CREATE TABLE `sys_role_permission` (
#   `id` bigint(20) NOT NULL AUTO_INCREMENT,
#   `role_id` bigint NOT NULL,
#   `permission_id` bigint NOT NULL,
#   `create_time` datetime NOT NULL,
#   `update_time` datetime NOT NULL,
#   `version` bigint(20) DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=MyISAM AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8
#
# select
# r.id ,
# r . role name roleName ,
# r . enabled ,
# r . create by createBy ,
# r . create time createTime
# from user_info u
# inner join sys_user_role  ur on u.id = ur.user id
# inner join sys_role_permission  rp on ur.role id = r.id
# where u.id = #{userid}
#
# select r.role_id, r.role_name ,r.create_time,r.update_time,r.memo,r.version,u.user_id
#   from user_info u
#  inner join sys_user_role ur on ur.user_id=u.user_id
#  inner join sys_role r on  r.role_id=ur.role_id
#   and u.user_id=1

