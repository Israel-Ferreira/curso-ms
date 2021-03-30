INSERT INTO USER (name, email, password) VALUES ('admin', 'admin@admin.com', 'admin123@admin')

INSERT INTO USER (name, email, password) VALUES ('Israel', 'israelfsouza@hotmail.com', 'teste123')

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR')
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN')


INSERT INTO user_roles (user_id, role_id) VALUES (1,1)
INSERT INTO user_roles (user_id, role_id) VALUES (1,2)
INSERT INTO user_roles (user_id, role_id) VALUES (2,1)