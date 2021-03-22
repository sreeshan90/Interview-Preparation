var Task = require("./task");
var repoFactory = require("./repoFactory");


var task1 = new Task(repoFactory.getRepo("task").get(1));
var task2 = new Task(repoFactory.getRepo("task").get(2));
console.log(task2);
var user = repoFactory.getRepo("user").get(1);

task1.user = user;

console.log(task1);

task1.save();

