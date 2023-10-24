<html>
	<head><title>체크박스</title>
	<meta charset = "utf-8"></head>
	<body>
		<?php
			$id = $_POST["id"];
			$pw = $_POST["pw"];
			$nick = $_POST["nick"];
			$a = $_POST["a"];
			$b = $_POST["b"];
			$readme = $_POST["readme"];
			$p = $_POST["p"];
			
			echo "아이디 : $id<br/>비밀번호 : $pw<br/>닉네임 : $nick</br>";
			
			echo "관심분야 : ";
			$c = count($_POST["q"]);
			for($i = 0; $i< $c;$i++){
				echo $_POST["q"][$i];
				if($i!=$c-1)echo ", ";}
				
			echo "<br/>";
			
			echo "가입경로 : $a";
			
			echo "<br/>";
			
			echo "통신사 : $p";
			
			echo "<br/>";
			
			echo "거주지역 : $b";
			
			echo "<br/>";
			
			echo "여행희망지역 : ";
			$c = count($_POST["w"]);
			for($i = 0; $i< $c;$i++){
				echo $_POST["w"][$i];
				if($i!=$c-1) echo ", ";}
				
			echo "<br/>";
			
			echo "하고싶은 말 : $readme";
			
		?>
	</body>
	
</html>