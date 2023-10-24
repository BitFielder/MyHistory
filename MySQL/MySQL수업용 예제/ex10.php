<html>
	<head><title>아이디, 패스워드</title>
	<meta charset = "utf-8"></head>
	<body>
		<?php
			$id = $_POST["id"];
			// id라는 이름의 텍스트박스 입력값을 변수 id에 저장
			$pw = $_POST["pw"];
			echo "아이디 : $id<br/>비밀번호 : $pw";
		?>
	</body>
	
</html>