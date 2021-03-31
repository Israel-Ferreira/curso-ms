INSERT INTO USER (name, email, password) VALUES ('admin', 'admin@admin.com', '$2y$12$kesSiZArqiJiIbt1uZC96u1.mgRqPZ83QbQ2m0/6uJN.fhp/9U0h2')

INSERT INTO USER (name, email, password) VALUES ('Israel', 'israelfsouza@hotmail.com', '$2y$12$NeFWWMdX2va3Ad7QVYyY4.ELl6ejsHxn5M18FnMCg90xmx2F4A5BG')

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR')
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN')


INSERT INTO user_roles (user_id, role_id) VALUES (1,1)
INSERT INTO user_roles (user_id, role_id) VALUES (1,2)
INSERT INTO user_roles (user_id, role_id) VALUES (2,1)