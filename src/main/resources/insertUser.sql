INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_USER');

INSERT IGNORE INTO users(id, email, password, username) VALUES (1, 'bindomarcos13@gmail.com', '$2a$10$srm3CU4/WcgdkEPXtVUeIeRoaIkB03DJ8G9nCxC5wgWnW6CmzNnDq', 'marcos');

INSERT IGNORE INTO user_roles (user_id, role_id) VALUES (1, 1);
