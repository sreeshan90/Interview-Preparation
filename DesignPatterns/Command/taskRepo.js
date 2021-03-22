var repo = {
    tasks: {},
    commands: [],
    get: function(id) { // mimics DB calls etc - an API
        console.log("Getting task "+ id);
        return {
            name: "new task from DB"
        }
    },
    save: function(task) {
        repo.tasks[task.id] = task;
        console.log("Saving task "+ task.name + " to the DB");
    },
    replay: function () {
        for (var i = 0; i < repo.commands.length; i++) {
            var command = repo.commands[i];
            repo.executeNoLog(command.name, command.obj);
        }
    }
};

repo.execute = function(name) {

    var args = Array.prototype.slice.call(arguments, 1);

    repo.commands.push({
        name: name,
        obj: args[0] // first one
    });

    if (repo[name]) {
        return repo[name].apply(repo, args);
    }

    return false;
};

repo.executeNoLog = function (name) {
    var args = Array.prototype.slice.call(arguments, 1);
    if (repo[name]) {
        return repo[name].apply(repo, args);
    }
};

repo.execute("save", {
   id: 1,
   name: "task 1",
   completed: false
});

repo.execute("save", {
    id: 2,
    name: "task 2",
    completed: false
});

repo.execute("save", {
    id: 3,
    name: "task 3",
    completed: false
});

repo.execute("save", {
    id: 4,
    name: "task 4",
    completed: false
});

console.log(repo.tasks);
repo.tasks = {}; // deleted everyrhin
console.log(repo.tasks);


repo.replay()

console.log(repo.tasks);
