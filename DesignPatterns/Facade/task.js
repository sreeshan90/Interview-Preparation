// Simple Decorator

var Task = function(data) {
    this.name = data.name;
    this.priority = data.priority;
    this.project = data.project;
    this.user = data.user;
    this.completed = data.completed;
}

var TaskService = function() {

    return {
        complete: function (task) {
            task.completed = true;
            console.log("Completing task "+ task.name);
        },
        setCompleteDate: function (task) {
            task.completedDate = new Date();
            console.log(task.name + " completed on "+ task.completedDate);
        },
        notifyCompletion: function (task, user) {
            console.log("Notifying "+ user + " of completion of tasj - " + task.name);
        },
        save: function (task) {
            console.log("Saving task "+ task.name);
        }
    }
}();
var myTask = new Task({
    name: "MyTask",
    priority: 1,
    project: "MyProj",
    user: "Jon",
    completed: false
});
/*

TaskService.complete(myTask);

if (myTask.completed === true) {
    TaskService.setCompleteDate(myTask);
    TaskService.notifyCompletion(myTask, myTask.user);
    TaskService.save(myTask);
}

console.log(myTask);
*/


// ================ Facade ========================

var TaskServiceWrapper = function() {

    var completeAndNotify = function (task) {
        TaskService.complete(task);

        if (task.completed === true) {
            TaskService.setCompleteDate(task);
            TaskService.notifyCompletion(task, myTask.user);
            TaskService.save(task);
        }

    }

    return {
        completeAndNotify: completeAndNotify
    }
}();

TaskServiceWrapper.completeAndNotify(myTask);
console.log(myTask);
