var Task = require("./task");

var task1 = new Task("Create Demo constructor");
var task2 = new Task("Create Demo modules");
var task3 = new Task("Create Demo singletons");
var task4 = new Task("Create Demo prototypes");

task1.complete();
task2.save();
task3.save();
task4.save();
