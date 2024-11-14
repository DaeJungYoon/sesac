const score =100;

if (score >= 90) {
  console.log('A');
  if (score === 100) {
    console.log('교수님의 총애');
  }
} else if (score >= 80) {
  console.log('B');
} else {
  console.log('C');
  if (score < 40) {
    console.log('학사경고');
  }
}
