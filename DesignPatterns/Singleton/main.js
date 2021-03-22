var taskHandler = require("./taskHandler");
// var repo = require("./repo");
// var mainRepo = repo(); //repo you can use

var mainRepo = require("./repo");
mainRepo.save("fromMain");
mainRepo.save("fromMain");
mainRepo.save("fromMain");

taskHandler.save("A");
taskHandler.save("B");
taskHandler.save("C");
taskHandler.save("D");

