
INSERT INTO message_source (locale, message_key,message_description,created_by) VALUES
('tr', 'person.firstname.notnull','Personel adı boş olamaz.','developer'),
('tr', 'person.firstname.size','Personel adı ve uzunluğu 2 ile 15 arasında olmalıdır. ','developer'),
('tr', 'AbstractAccessDecisionManager.accessDenied','Erişim reddedildi','developer'),
('tr', 'person.ipaddress','Ip adresiniz doğru değil','developer'),
('tr', 'person.tcno.valid','Tc kimlik numarasını doğru değil','developer'),
('tr', 'person.email.valid','Email adresi uygun formatta değil','developer'),
('tr', 'person.phone.valid','Telefon numarası uygun formatta değil','developer'),
('tr', 'AbstractUserDetailsAuthenticationProvider.badCredentials','Yanlış kimlik','developer'),

('en', 'AbstractUserDetailsAuthenticationProvider.badCredentials','Bad Credentials','developer'),
('en', 'person.phone.valid','Phone number is not valid','developer'),
('en', 'person.email.valid','Email address is not valid','developer'),
('en', 'person.firstname.notnull','Personel name is not empty.','developer'),
('en', 'person.tcno.valid','Tc number is not valid.','developer'),
('en', 'person.firstname.size','The personel name must be 2 beetwen 15 and.','developer'),
('en', 'person.ipaddress','Ip address is not valid.','developer'),
('en', 'AbstractAccessDecisionManager.accessDenied','Access is denied','developer')
;

INSERT INTO usr_user ( username, password,  first_name,  last_name,  enabled,  token_expired,created_by,version) VALUES
(40516901118,'$2a$10$mUf92VpprgXHg5Ddyi/EBu5ddC7iAh02w.K0brkIDhVRb05IjRTkq','Ramazan','Karagöz',true ,false,'admin',0 );
INSERT INTO role (role_name,created_by,version) VALUES ('ROLE_ADMIN','admin',0),('ROLE_USER','admin',0);
INSERT INTO privilege (privilege_name,created_by,version) VALUES ('READ_PRIVILEGE','admin',0),('WRITE_PRIVILEGE','admin',0);
INSERT INTO privileges_roles(role_id,privilege_id) VALUES (1,2),(2,1);
INSERT INTO users_roles(user_id,role_id) VALUES (1,1);