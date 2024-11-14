const compare = (a, b) => {
  if (a < b) {
    console.log(b);
  } else if (a > b) {
    console.log(a);
  } else {
    console.log(null);
  }
};

compare(1, 2);
compare(2, 2);
compare(3, 1);
