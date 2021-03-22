var taskRepo = function () {

    var db = {};
    var get = function(id) { // mimics DB calls etc - an API
        console.log("Getting task "+ id);
        return {
            name: " Task "+ id +" from DB"
        }
    };
    var save =  function(task) {
        console.log("Saving task "+ task.name + " to the DB");
    };
    console.log("newing up my task repo");
    return {
        get: get,
        save: save
    }
};

module.exports = taskRepo();
