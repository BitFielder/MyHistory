<html>
	<head><title>체크박스</title>
	<meta charset = "utf-8"></head>
	<body>
		<?php
			echo "취미 : ";
			$c = count($_POST["hob"]);
			for($i = 0; $i< $c;$i++){
				echo $_POST["hob"][$i];
				if($i!=$c-1)
					echo ", ";
			}
		?>
	</body>
	
</html>