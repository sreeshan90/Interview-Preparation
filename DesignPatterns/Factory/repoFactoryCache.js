var repoFactoryCache = function() {
    this.getRepo = function (repoType) {
        if (repoType === 'task') {
            if (this.taskRepo) {
                console.log("retrieve from cache");
                return this.taskRepo;
            }
            var taskRepo = require("./taskRepository");
            return taskRepo;
        }

        if (repoType === 'user') {
            var taskRepo = require("./userRepository");
            return taskRepo;
        }
    }
};

module.exports = new repoFactoryCache();
