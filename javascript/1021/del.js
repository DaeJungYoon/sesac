const isWeekend = false;
const nowTime = 19;

// 주말 이거나 일과이후 => 휴식
// 주말의 일과 이후 -> 자기개발
// 일과시간 -> 일

// (!일과시간 === 일과이후)
// 주말    일과시간
// true    true        휴식
// true    false       자기개발
// false    true       일
// false    false      휴식

let isWorkingHour;

// 9 ~ 18시에는 workingHour = true
// 아닐때는 workingHour = false

if (9 <= nowTime && nowTime <= 18) {
  isWorkingHour = true;
} else {
  isWorkingHour = false;
}

// let isWorkingHour = (9 <= nowTime && nowTime <= 18) ? true : false
let toDo;
console.log(isWeekend, isWorkingHour);
if (isWeekend) {
  if (isWorkingHour) {
    toDo = '휴식';
  } else {
    toDo = '자기개발';
  }
} else {
  // 주말이 아닌 경우
  if (isWorkingHour) {
    toDo = '일';
  } else {
    toDo = '휴식';
  }
}

console.log(toDo);
