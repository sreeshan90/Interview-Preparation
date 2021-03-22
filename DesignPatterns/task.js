var task = Object.create(Object.prototype);
task.title = 'My task';
task.description = "My desc";

Object.defineProperty(task, 'toString', {
    value: function () {
        return this.title + " " + this.description;
    },
    writable: false,
    enumerable: false,
    configurable: false
});

console.log(task);
