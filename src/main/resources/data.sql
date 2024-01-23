INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* User */
INSERT INTO users (id_user, username, password) VALUES (default, 'Admin', '$2a$12$K..G3QkMFm8p8QZlJnP84.kwhRDGK/uMztc4cVjMG/yNkZL2lYaKO' );
/*password: passwordencriptada*/

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);