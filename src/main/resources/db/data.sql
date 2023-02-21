insert into user_tb(username, password, email, salt, created_at) 
values('ssar', 'b66bd95313a917c43a4a541dc19dc1e651e00db1f227633e79a68cebb010474e', 'ssar@nate.com', 'edb66c44cd70084f2f27c159244f475e2081a7a8',now());
insert into user_tb(username, password, email, salt, created_at) 
values('cos', 'b66bd95313a917c43a4a541dc19dc1e651e00db1f227633e79a68cebb010474e', 'cos@nate.com', 'edb66c44cd70084f2f27c159244f475e2081a7a8',now());

commit;

