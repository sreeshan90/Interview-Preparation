var repoFactory = function() {
    this.getRepo = function (repoType) {
        if (repoType === 'task') {
            var taskRepo = require("./taskRepository");
            return taskRepo;
        }

        if (repoType === 'user') {
            var userRepo = require("./userRepository");
            return userRepo;
        }
    }
};

module.exports = new repoFactory();
