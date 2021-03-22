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

var UrgentTask = function (name, priority) {
    Task.call(this, name);
    this.priority = priority;
};
UrgentTask.prototype = Object.create(Task.prototype);

UrgentTask.prototype.notify = function() {
    console.log("notify impt ppl");
};

UrgentTask.prototype.save = function() {
    this.notify();
    console.log("do spl stuff before save");
    Task.prototype.save.call(this);
};

var ut = new UrgentTask("this is urgent", 1);

ut.complete();
ut.save();
console.log(ut);
