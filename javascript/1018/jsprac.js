let se = 4000;

if (se > 10000) {
  console.log('피자');
} else {
  console.log('치킨');
}
console.log('--------0-------');

if (se > 10000) {
  console.log('피자');
}
if (5000 < se && se < 10000) {
  console.log('치킨');
} //2개의 비교연산사를 동시에 사용하지 못함 => 논리연산자를 사용해서 해야함
if (1000 < se < 5000) {
  console.log('라면');
}
console.log('--------1-------');

if (se > 10000) {
  console.log('피자');
} else {
  if (se > 5000) {
    console.log('치킨');
  } else {
    if (se > 1000) {
      console.log('라면');
    }
  }
}
console.log('--------2-------');

if (se > 10000) {
  console.log('피자');
} else if (se > 5000) {
  console.log('치킨');
} else if (se > 1000) {
  console.log('라면');
}
console.log('--------3-------');

if (true) {
  console.log('if(true)실행이 될까요? 됩니다!');
}
if (false) {
  console.log('if(false)실행이 될까요? 안 됩니다!');
}
if (null) {
  console.log(
    'if(null)실행이 될까요? null은 T or F 이전에 없는 값이라 안 됩니다!'
  );
}

if ('') {
  console.log('if("") 빈 문자열이 실행 될까요? 안 됩니다!');
}
if (' ') {
  console.log('if(" ") 공백이 실행 될까요? 됩니다!');
}
