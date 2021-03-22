var Task = function(data) {
    this.name = data.name;
   /* this.priority = data.priority;
    this.project = data.project;
    this.user = data.user;
    this.completed = data.completed;*/
    this.flyweight = FlyweightFactory.get(data.project, data.priority, data.user, data.completed);

}

// exposed as getters and setters from the flyweight
Task.prototype.getPriority = function () {
    return this.flyweight.priority;
}

function Flyweight(project, priority, user, completed) {
    this.priority = priority;
    this.project = project;
    this.user = user;
    this.completed = completed;
}

var FlyweightFactory = function(){
    var flyweights = [];

    var get = function(project, priority, user, completed) { // task all things that are not unique
        if (!flyweights[project + priority + user + completed]) {
            flyweights[project + priority + user + completed] = new Flyweight(project, priority, user, completed);
        }
        return flyweights[project + priority + user + completed]
    };

    var getCount = function () {
        var count = 0;
        for (var f in flyweights) count++;
        return count;
    }

    return {
        get: get,
        getCount: getCount
    }
}();


function TaskCollection() {
    var tasks = {};
    var count = 0;
    var add = function (data) {
        tasks[data.name] = new Task(data);
        count++;
    }
    var get = function(name) {
        return tasks[name];
    }

    var getCount = function () {
        return count;
    }

    return {
        add: add,
        get: get,
        getCount: getCount
    };
}


var tasks = new TaskCollection();

var projects = ["none", "courses", "traiaing", "prokect"];
var priorities = [1, 2, 3, 4, 5];
var users = ["jon", "erica", "amanda", "nathan"];
var completed = [true, false];

var initMem = process.memoryUsage().heapUsed;

for (var i = 0; i< 1000000; i++) {
    tasks.add({
        name: "taks "+ i,
        priority: priorities[Math.floor((Math.random() * 5))],
        user: users[Math.floor((Math.random() * 4))],
        project: projects[Math.floor((Math.random() * 4))],
        completed: completed[Math.floor((Math.random() * 2))],
    })
}

var afterMem =  process.memoryUsage().heapUsed;

console.log("Used Mem " + (afterMem - initMem)/1000000);
console.log("tasks = "+ tasks.getCount());
console.log("flyweights = "+ FlyweightFactory.getCount());


