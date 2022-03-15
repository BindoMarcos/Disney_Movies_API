INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');


INSERT IGNORE INTO users(id, email, password, username) VALUES (1, 'disneyjavaapi@gmail.com', '$2a$10$srm3CU4/WcgdkEPXtVUeIeRoaIkB03DJ8G9nCxC5wgWnW6CmzNnDq', 'DisneyAPI');
INSERT IGNORE INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT IGNORE INTO user_roles (user_id, role_id) VALUES (1, 2);


INSERT IGNORE INTO users(id, email, password, username) VALUES (2, 'fortestpurposes2002@gmail.com', '$2a$10$mAhNJrCtjQbOreBfboFx5u40m/X7dFCKiozfbwsWYOxbtnOEt/TIG', 'TestUser');
INSERT IGNORE INTO user_roles (user_id, role_id) VALUES (2, 1);

