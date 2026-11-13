/**
 * @return {Function}
 */
function createHelloWorld(a,b) {
  return function() {
    return "Hello World";
  };
}

const f = createHelloWorld(10,20);
console.log(f()); 

