var factorial = function (n) {
  return n < 2 ? 1 : n * factorial(n - 1);
};

console.log(factorial(50));
