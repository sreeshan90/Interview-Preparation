var userRepo = function () {

    var db = {};
    var get = function(id) { // mimics DB calls etc - an API
        console.log("Getting User "+ id);
        return {
            name: "User "+ id
        }
    };
    var save =  function(user) {
        console.log("Saving User "+ user.name + " to the DB");
    };

    return {
        get: get,
        save: save
    }
};

module.exports = userRepo();
