var repoFactory = function() {

    var repos = this;
    var repoList = [{
        name: "task", source: "./taskRepository"
    }, {
            name: "user", source: "./userRepository"
        }
    ]
    repoList.forEach((function(repo){
        repos[repo.name] = require(repo.source)
    }));
};

module.exports = new repoFactory;
