/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* User */
INSERT INTO users (id_user, username, password) VALUES (default, 'Admin', '$2a$12$K..G3QkMFm8p8QZlJnP84.kwhRDGK/uMztc4cVjMG/yNkZL2lYaKO' );
/*password: passwordencriptada*/

/* roles_users */    /* ¿? */
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);

INSERT INTO family (id_family, family) VALUES (default, 'Felids');
INSERT INTO family (id_family, family) VALUES (default, 'Canids');
INSERT INTO family (id_family, family) VALUES (default, 'Reptiles');
INSERT INTO family (id_family, family) VALUES (default, 'Mustelids');
INSERT INTO family (id_family, family) VALUES (default, 'Leporidae');

INSERT INTO countries (id_country, country) VALUES (default, 'Spain');
INSERT INTO countries (id_country, country) VALUES (default, 'Australia');
INSERT INTO countries (id_country, country) VALUES (default, 'Africa');
INSERT INTO countries (id_country, country) VALUES (default, 'Mexico');
INSERT INTO countries (id_country, country) VALUES (default, 'Argentina');
INSERT INTO countries (id_country, country) VALUES (default, 'Brasil');
