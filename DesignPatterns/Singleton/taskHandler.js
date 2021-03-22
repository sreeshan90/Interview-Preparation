// var repo = require("./repo");

// var myrepo = repo();
var myrepo = require("./repo");
var taskHandler = function () {
    return {
        save: function (param) {
            myrepo.save("From task handler "+ param);
        }
    }
}

module.exports = taskHandler();
