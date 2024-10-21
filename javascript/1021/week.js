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
