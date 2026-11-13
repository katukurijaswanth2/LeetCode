/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let original = init;   // store the initial value
    
    return {
        increment: function() {
           init= init+1;
            return init;
        },
        decrement: function() {
            init =init-1;
             return init;
        },
        reset: function() {
            init = original;  // reset to the original value
            return init;
        }
    };
};

let counter = createCounter(5);

console.log(counter.increment()); // 6
console.log(counter.reset());     // 5
console.log(counter.decrement()); // 4
