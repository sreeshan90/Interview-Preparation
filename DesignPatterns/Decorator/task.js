// Simple Decorator

var Task = function(data) {
    this.name = data;
    this.completed = false;
}

Task.prototype.complete = function() {
    console.log("Completing task "+ this.name);
    this.completed = true;
};

Task.prototype.save = function () {
    console.log("Saving task "+ this.name);
};

var myTask = new Task("Legacy Task");

myTask.complete();
myTask.save();

// Decorator - dont want to mess with whats working

var urgentTask = new Task("Urgent Task");

urgentTask.priority = 2;
urgentTask.notify = function() {
    console.log("Notifying task "+ this.name);
}

// urgentTask.notify();
urgentTask.complete();
urgentTask.save = function() {
    this.notify();
    Task.prototype.save.call(this); // call original save
};
urgentTask.save();
