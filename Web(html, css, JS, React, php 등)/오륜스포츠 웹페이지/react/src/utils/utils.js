export function toDateObject(date_str) {
  var yyyyMMdd = String(date_str);
  var sYear = yyyyMMdd.substring(0, 4);
  var sMonth = yyyyMMdd.substring(4, 6);
  var sDate = yyyyMMdd.substring(6, 8);

  return new Date(Number(sYear), Number(sMonth) - 1, Number(sDate));
}

export function bizNumCheck(number) {
  let temp = number.replace(/-/gi, "");

  if (isNaN(temp)) {
    return false;
  } else {
    var numberMap = temp.split("").map(function (d) {
      return parseInt(d, 10);
    });

    if (numberMap.length == 10) {
      // 사업자번호 체크용 키 (고정값인듯)
      var keyArr = [1, 3, 7, 1, 3, 7, 1, 3, 5];
      var chk = 0;

      keyArr.forEach(function (d, i) {
        chk += d * numberMap[i];
      });

      chk += parseInt((keyArr[8] * numberMap[8]) / 10, 10);
      return Math.floor(numberMap[9]) === (10 - (chk % 10)) % 10;
    } else {
      return false;
    }
  }
}
