const people = {
  jun: {
    name: 'jun',
    age: 15,
    gender: 'M',
  },
  ken: {
    name: 'ken',
    age: 73,
    gender: 'w',
  },
  alex: {
    name: 'alex',
    age: 23,
    gender: '-',
  },
};
for (let person in people) {
  let human = people[person];
  // console.log(people[person]);
  // console.log(people[person].name);
  if (human.name === 'alex') {
    // console.log(human);
    console.log(human.age);
  }
}
console.log(people['ken']);
