<?php 

//switch case문 사용
// 변수 t에 여름 저장
// t에 저장된 값이 봄인 경우 : 봄은 spring
// t에 저장된 값이 여름인 경우 : 여름은 summer
// t에 저장된 값이 가을인 경우 : 가을은 fall
// t에 저장된 값이 겨울인 경우 : 겨울은 winter
// 위의 조건에 해당되지 않는 경우 : 잘못 입력
	$t="여름";
	switch($t){
	case "봄": echo "{$t}은 spring"; break;
	case "여름": echo "{$t}은 summer"; break;
	case "가을": echo "{$t}은 fall"; break;
	case "겨울": echo "{$t}은 winter"; break;
	default: echo "다시 입력";	}
?>