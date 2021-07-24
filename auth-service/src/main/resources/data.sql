INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity,
                                  refresh_token_validity, resource_ids, authorized_grant_types, additional_information)
VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code',
        'READ,WRITE', '36000', '100000', 'microservice', 'authorization_code,password,refresh_token,implicit', '{}');

INSERT INTO permission (NAME)
VALUES ('create_profile'),
       ('read_profile'),
       ('update_profile'),
       ('delete_profile');

INSERT INTO role (NAME)
VALUES ('ROLE_admin'),
       ('ROLE_editor'),
       ('ROLE_operator');

INSERT INTO permission_role (PERMISSION_ID, ROLE_ID)
VALUES (1, 1), /*create-> admin */
       (2, 1), /* read admin */
       (3, 1), /* update admin */
       (4, 1), /* delete admin */
       (2, 2), /* read Editor */
       (3, 2), /* update Editor */
       (2, 3); /* read operator */

insert into user (id, username, password, email, enabled, account_non_expired, credentials_non_expired,
                  account_non_locked)
VALUES ('1', 'admin', '{bcrypt}$2a$12$xVEzhL3RTFP1WCYhS4cv5ecNZIf89EnOW4XQczWHNB/Zi4zQAnkuS',
        'habibsumoncse2@gmail.com', 1, 1, 1, 1);
insert into user (id, username, password, email, enabled, account_non_expired, credentials_non_expired,
                  account_non_locked)
VALUES ('2', 'ahasan', '{bcrypt}$2a$12$DGs/1IptlFg0szj.3PttmeC8swHZs/pZ6YEKng4Cl1l2woMtkNhvi',
        'habibsumoncse2@gmail.com', 1, 1, 1, 1);
insert into user (id, username, password, email, enabled, account_non_expired, credentials_non_expired,
                  account_non_locked)
VALUES ('3', 'user', '{bcrypt}$2a$12$udISUXbLy9ng5wuFsrCMPeQIYzaKtAEXNJqzeprSuaty86N4m6emW', 'habibsumoncse2@gmail.com',
        1, 1, 1, 1);
/*
passowrds:
admin - admin
ahasan - ahasan
user - user
*/

INSERT INTO role_user (ROLE_ID, USER_ID)
VALUES (1, 1), /* admin-admin */
       (2, 2), /* ahasan-editor */
       (3, 3); /* user-operatorr */ ;