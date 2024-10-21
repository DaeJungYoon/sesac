const isWeekend = true;
const nowTime = 4;

if (isWeekend === true) {
  console.log('휴식');
  if (nowTime > 18) {
    console.log('자기계발');
  }
} else if (nowTime > 9 && nowTime < 18) {
  console.log('일');
} else {
  console.log('휴식');
}

// 주말  일과시간
// true  true  -> 휴식
// true  false -> 자기계발
// false true  -> 일
// false false -> 휴식