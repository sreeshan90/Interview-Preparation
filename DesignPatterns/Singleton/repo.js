var repo = function () {
    console.log("newing up task repo");
    var called = 0;
    var save = function (task) {
        called++;
        console.log("saving "+ task + " Called "
        + called + " times ")
    }

    return {
        save: save
    }
}

// module.exports =  repo;
// module.exports =  repo(); OR
module.exports =  new repo;
