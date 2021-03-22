var repo = function () {

    var db = {};
    var get = function(id) { // mimics DB calls etc - an API
        console.log("Getting task "+ id);
        return {
            name: "new task from DB"
        }
    };
    var save =  function(task) {
        console.log("Saving task "+ task.name + " to the DB");
    };

    return {
        get: get,
        save: save
    }
};

module.exports = repo();
