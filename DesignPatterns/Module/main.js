var Task = require("./task");
var Repo = require("./taskRepository");

var task1 = new Task(Repo.get(1));

var task2 = new Task({name:"Create Demo modules"});
var task3 = new Task({name: "Create Demo singletons"});
var task4 = new Task({name: "Create Demo prototypes"});

task1.complete();
task2.save();
task3.save();
task4.save();
