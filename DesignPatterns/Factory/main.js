var Task = require("./task");
var taskRepo = require("./taskRepository");
var userRepo = require("./userRepository");


var task1 = new Task(taskRepo.get(1));
var task2 = new Task(taskRepo.get(2));

var user = userRepo.get(1);

task1.user = user;

console.log(task1);

task1.save();
