mongoimport --db test --collection restaurants --drop --file primer-dataset.json

#1)Switch to db:
	use admin
#2)Create user:
	db.createUser({"user" : "administrator", "pwd": "0Jier93@", "roles" : [ "root" ] })
#3)Shut down server:
	db.shutdownServer()
#4)Start mongod process with auth:enabled
	sudo mongod  --config /etc/mongod.conf --auth
#5)Connect to mongo shel:
	mongo -u administrator -p 0Jier93@ --authenticationDatabase admin
#6)Switch to admin:
	use admin
#7)Grant roles for test db:
	db.grantRolesToUser("administrator", [{role:"readWrite", db:"test"}])
#8)Switch to test:
	use test
#9)Create user mongodb:
	db.createUser({"user" : "mongoDB", "pwd": "m0ng0D6", "roles" : [ "readWrite" ] })

#Source: https://docs.mongodb.com/manual/tutorial/manage-users-and-roles/
#https://docs.mongodb.com/manual/reference/built-in-roles/#read
#https://docs.mongodb.com/v3.0/reference/method/js-user-management/
