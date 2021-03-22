var Task = require("./task");
var repoFactory = require("./repoFactory2");


var task1 = new Task(repoFactory.task.get(1));
var task2 = new Task(repoFactory.task.get(2));
console.log(task2);
var user = repoFactory.user.get(1);

task1.user = user;

console.log(task1);

task1.save();

